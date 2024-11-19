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

import { DebugElement } from '@angular/core';
import { CommonModule } from '@angular/common';
import { waitForAsync, ComponentFixture, fakeAsync, flush, TestBed, tick } from '@angular/core/testing';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';

import { AdministrationUserModel } from 'src/app/models/administrationUser/administration_user.model';
import { AdministrationUserModelAudit } from 'src/app/models/administrationUser/administration_user.model.state';
import { AdministratorModel } from 'src/app/models/administrator/administrator.model';
import { AdministratorModelAudit } from 'src/app/models/administrator/administrator.model.state';
import { AmendmentDetailModel } from 'src/app/models/amendmentDetail/amendment_detail.model';
import { AmendmentDetailModelAudit } from 'src/app/models/amendmentDetail/amendment_detail.model.state';
import { BpjsAccidentMasterModel } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model';
import { BpjsAccidentMasterModelAudit } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.state';
import { BpjsBedAvailabilityModel } from 'src/app/models/bpjsBedAvailability/bpjs_bed_availability.model';
import { BpjsBedAvailabilityModelAudit } from 'src/app/models/bpjsBedAvailability/bpjs_bed_availability.model.state';
import { BpjsClaimDataModel } from 'src/app/models/bpjsClaimData/bpjs_claim_data.model';
import { BpjsClaimDataModelAudit } from 'src/app/models/bpjsClaimData/bpjs_claim_data.model.state';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionModelAudit } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.state';
import { BpjsControlPlanModel } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model';
import { BpjsControlPlanModelAudit } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.state';
import { BpjsControlSpecialistModel } from 'src/app/models/bpjsControlSpecialist/bpjs_control_specialist.model';
import { BpjsControlSpecialistModelAudit } from 'src/app/models/bpjsControlSpecialist/bpjs_control_specialist.model.state';
import { BpjsDiagnoseModel } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import { BpjsDiagnoseModelAudit } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.state';
import { BpjsDiagnosePRBModel } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model';
import { BpjsDiagnosePRBModelAudit } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.state';
import { BpjsDismissalConditionModel } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model';
import { BpjsDismissalConditionModelAudit } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model.state';
import { BpjsDismissalMappingModel } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model';
import { BpjsDismissalMappingModelAudit } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model.state';
import { BpjsDoctorMappingModel } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import { BpjsDoctorMappingModelAudit } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.state';
import { BpjsDoctorScheduleModel } from 'src/app/models/bpjsDoctorSchedule/bpjs_doctor_schedule.model';
import { BpjsDoctorScheduleModelAudit } from 'src/app/models/bpjsDoctorSchedule/bpjs_doctor_schedule.model.state';
import { BpjsDrugGenericPRBModel } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model';
import { BpjsDrugGenericPRBModelAudit } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.state';
import { BpjsFacilityListModel } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model';
import { BpjsFacilityListModelAudit } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model.state';
import { BpjsFingerPrintModel } from 'src/app/models/bpjsFingerPrint/bpjs_finger_print.model';
import { BpjsFingerPrintModelAudit } from 'src/app/models/bpjsFingerPrint/bpjs_finger_print.model.state';
import { BpjsGeneralModel } from 'src/app/models/bpjsGeneral/bpjs_general.model';
import { BpjsGeneralModelAudit } from 'src/app/models/bpjsGeneral/bpjs_general.model.state';
import { BpjsHealthFacilityModel } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model';
import { BpjsHealthFacilityModelAudit } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.state';
import { BpjsHospitalizationPlanModel } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import { BpjsHospitalizationPlanModelAudit } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.state';
import { BpjsINACBGModel } from 'src/app/models/bpjsINACBG/bpjs_inacbg.model';
import { BpjsINACBGModelAudit } from 'src/app/models/bpjsINACBG/bpjs_inacbg.model.state';
import { BpjsINACBGClaimModel } from 'src/app/models/bpjsINACBGClaim/bpjs_inacbg_claim.model';
import { BpjsINACBGClaimModelAudit } from 'src/app/models/bpjsINACBGClaim/bpjs_inacbg_claim.model.state';
import { BpjsINACBGVariableModel } from 'src/app/models/bpjsINACBGVariable/bpjs_inacbg_variable.model';
import { BpjsINACBGVariableModelAudit } from 'src/app/models/bpjsINACBGVariable/bpjs_inacbg_variable.model.state';
import { BpjsJasaRaharjaModel } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model';
import { BpjsJasaRaharjaModelAudit } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.state';
import { BpjsJasaRaharjaClaimModel } from 'src/app/models/bpjsJasaRaharjaClaim/bpjs_jasa_raharja_claim.model';
import { BpjsJasaRaharjaClaimModelAudit } from 'src/app/models/bpjsJasaRaharjaClaim/bpjs_jasa_raharja_claim.model.state';
import { BpjsListFingerPrintModel } from 'src/app/models/bpjsListFingerPrint/bpjs_list_finger_print.model';
import { BpjsListFingerPrintModelAudit } from 'src/app/models/bpjsListFingerPrint/bpjs_list_finger_print.model.state';
import { BpjsListTaskModel } from 'src/app/models/bpjsListTask/bpjs_list_task.model';
import { BpjsListTaskModelAudit } from 'src/app/models/bpjsListTask/bpjs_list_task.model.state';
import { BpjsOutsideFacilityReferralModel } from 'src/app/models/bpjsOutsideFacilityReferral/bpjs_outside_facility_referral.model';
import { BpjsOutsideFacilityReferralModelAudit } from 'src/app/models/bpjsOutsideFacilityReferral/bpjs_outside_facility_referral.model.state';
import { BpjsPRBModel } from 'src/app/models/bpjsPRB/bpjs_prb.model';
import { BpjsPRBModelAudit } from 'src/app/models/bpjsPRB/bpjs_prb.model.state';
import { BpjsPRBDetailModel } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model';
import { BpjsPRBDetailModelAudit } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.state';
import { BpjsPatientReferralModel } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import { BpjsPatientReferralModelAudit } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.state';
import { BpjsPcareDPHOModel } from 'src/app/models/bpjsPcareDPHO/bpjs_pcare_dpho.model';
import { BpjsPcareDPHOModelAudit } from 'src/app/models/bpjsPcareDPHO/bpjs_pcare_dpho.model.state';
import { BpjsPcareKegiatanKelompokModel } from 'src/app/models/bpjsPcareKegiatanKelompok/bpjs_pcare_kegiatan_kelompok.model';
import { BpjsPcareKegiatanKelompokModelAudit } from 'src/app/models/bpjsPcareKegiatanKelompok/bpjs_pcare_kegiatan_kelompok.model.state';
import { BpjsPcareKesadaranModel } from 'src/app/models/bpjsPcareKesadaran/bpjs_pcare_kesadaran.model';
import { BpjsPcareKesadaranModelAudit } from 'src/app/models/bpjsPcareKesadaran/bpjs_pcare_kesadaran.model.state';
import { BpjsPcarePesertaKegiatanKelompokModel } from 'src/app/models/bpjsPcarePesertaKegiatanKelompok/bpjs_pcare_peserta_kegiatan_kelompok.model';
import { BpjsPcarePesertaKegiatanKelompokModelAudit } from 'src/app/models/bpjsPcarePesertaKegiatanKelompok/bpjs_pcare_peserta_kegiatan_kelompok.model.state';
import { BpjsPcarePoliModel } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model';
import { BpjsPcarePoliModelAudit } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model.state';
import { BpjsPcareProviderRayonisasiModel } from 'src/app/models/bpjsPcareProviderRayonisasi/bpjs_pcare_provider_rayonisasi.model';
import { BpjsPcareProviderRayonisasiModelAudit } from 'src/app/models/bpjsPcareProviderRayonisasi/bpjs_pcare_provider_rayonisasi.model.state';
import { BpjsPcareRegistrationsModel } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import { BpjsPcareRegistrationsModelAudit } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.state';
import { BpjsProcedureModel } from 'src/app/models/bpjsProcedure/bpjs_procedure.model';
import { BpjsProcedureModelAudit } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.state';
import { BpjsReferralSpecialistModel } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model';
import { BpjsReferralSpecialistModelAudit } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model.state';
import { BpjsSEPModel } from 'src/app/models/bpjsSEP/bpjs_sep.model';
import { BpjsSEPModelAudit } from 'src/app/models/bpjsSEP/bpjs_sep.model.state';
import { BpjsSEPINACBGIntegrationModel } from 'src/app/models/bpjsSEPINACBGIntegration/bpjs_sep_inacbg_integration.model';
import { BpjsSEPINACBGIntegrationModelAudit } from 'src/app/models/bpjsSEPINACBGIntegration/bpjs_sep_inacbg_integration.model.state';
import { BpjsSEPInternalDataModel } from 'src/app/models/bpjsSEPInternalData/bpjs_sep_internal_data.model';
import { BpjsSEPInternalDataModelAudit } from 'src/app/models/bpjsSEPInternalData/bpjs_sep_internal_data.model.state';
import { BpjsSEPSubmissionModel } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model';
import { BpjsSEPSubmissionModelAudit } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.state';
import { BpjsSearchControlLetterModel } from 'src/app/models/bpjsSearchControlLetter/bpjs_search_control_letter.model';
import { BpjsSearchControlLetterModelAudit } from 'src/app/models/bpjsSearchControlLetter/bpjs_search_control_letter.model.state';
import { BpjsSearchSEPModel } from 'src/app/models/bpjsSearchSEP/bpjs_search_sep.model';
import { BpjsSearchSEPModelAudit } from 'src/app/models/bpjsSearchSEP/bpjs_search_sep.model.state';
import { BpjsServiceMappingModel } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model';
import { BpjsServiceMappingModelAudit } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.state';
import { BpjsSpecialReferralModel } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model';
import { BpjsSpecialReferralModelAudit } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.state';
import { BpjsTotalReferralSEPModel } from 'src/app/models/bpjsTotalReferralSEP/bpjs_total_referral_sep.model';
import { BpjsTotalReferralSEPModelAudit } from 'src/app/models/bpjsTotalReferralSEP/bpjs_total_referral_sep.model.state';
import { BpjsTreatmentClassMappingModel } from 'src/app/models/bpjsTreatmentClassMapping/bpjs_treatment_class_mapping.model';
import { BpjsTreatmentClassMappingModelAudit } from 'src/app/models/bpjsTreatmentClassMapping/bpjs_treatment_class_mapping.model.state';
import { BpjsTreatmentHistoryModel } from 'src/app/models/bpjsTreatmentHistory/bpjs_treatment_history.model';
import { BpjsTreatmentHistoryModelAudit } from 'src/app/models/bpjsTreatmentHistory/bpjs_treatment_history.model.state';
import { BpjsTreatmentRoomModel } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model';
import { BpjsTreatmentRoomModelAudit } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.state';
import { BpjsUpdateDismissalDateModel } from 'src/app/models/bpjsUpdateDismissalDate/bpjs_update_dismissal_date.model';
import { BpjsUpdateDismissalDateModelAudit } from 'src/app/models/bpjsUpdateDismissalDate/bpjs_update_dismissal_date.model.state';
import { BpjsVisitDataModel } from 'src/app/models/bpjsVisitData/bpjs_visit_data.model';
import { BpjsVisitDataModelAudit } from 'src/app/models/bpjsVisitData/bpjs_visit_data.model.state';
import { BatchStockBalanceModel } from 'src/app/models/batchStockBalance/batch_stock_balance.model';
import { BatchStockBalanceModelAudit } from 'src/app/models/batchStockBalance/batch_stock_balance.model.state';
import { BatchStockBalancePerDateModel } from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model';
import { BatchStockBalancePerDateModelAudit } from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model.state';
import { BatchStockTransactionDetailModel } from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model';
import { BatchStockTransactionDetailModelAudit } from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model.state';
import { BedFacilityModel } from 'src/app/models/bedFacility/bed_facility.model';
import { BedFacilityModelAudit } from 'src/app/models/bedFacility/bed_facility.model.state';
import { BedReserveModel } from 'src/app/models/bedReserve/bed_reserve.model';
import { BedReserveModelAudit } from 'src/app/models/bedReserve/bed_reserve.model.state';
import { BirthHistoryModel } from 'src/app/models/birthHistory/birth_history.model';
import { BirthHistoryModelAudit } from 'src/app/models/birthHistory/birth_history.model.state';
import { BodyChartExaminationModel } from 'src/app/models/bodyChartExamination/body_chart_examination.model';
import { BodyChartExaminationModelAudit } from 'src/app/models/bodyChartExamination/body_chart_examination.model.state';
import { BpjsPcareKunjunganRujukanModel } from 'src/app/models/bpjsPcareKunjunganRujukan/bpjs_pcare_kunjungan_rujukan.model';
import { BpjsPcareKunjunganRujukanModelAudit } from 'src/app/models/bpjsPcareKunjunganRujukan/bpjs_pcare_kunjungan_rujukan.model.state';
import { BpjsPcarePendaftaranModel } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model';
import { BpjsPcarePendaftaranModelAudit } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.state';
import { BpjsPcareRiwayatKunjunganModel } from 'src/app/models/bpjsPcareRiwayatKunjungan/bpjs_pcare_riwayat_kunjungan.model';
import { BpjsPcareRiwayatKunjunganModelAudit } from 'src/app/models/bpjsPcareRiwayatKunjungan/bpjs_pcare_riwayat_kunjungan.model.state';
import { CashAllocationModel } from 'src/app/models/cashAllocation/cash_allocation.model';
import { CashAllocationModelAudit } from 'src/app/models/cashAllocation/cash_allocation.model.state';
import { CashReceiptModel } from 'src/app/models/cashReceipt/cash_receipt.model';
import { CashReceiptModelAudit } from 'src/app/models/cashReceipt/cash_receipt.model.state';
import { CashRefundModel } from 'src/app/models/cashRefund/cash_refund.model';
import { CashRefundModelAudit } from 'src/app/models/cashRefund/cash_refund.model.state';
import { CashierUserModel } from 'src/app/models/cashierUser/cashier_user.model';
import { CashierUserModelAudit } from 'src/app/models/cashierUser/cashier_user.model.state';
import { CatalogueMedicalModel } from 'src/app/models/catalogueMedical/catalogue_medical.model';
import { CatalogueMedicalModelAudit } from 'src/app/models/catalogueMedical/catalogue_medical.model.state';
import { CatalogueNonMedicalModel } from 'src/app/models/catalogueNonMedical/catalogue_non_medical.model';
import { CatalogueNonMedicalModelAudit } from 'src/app/models/catalogueNonMedical/catalogue_non_medical.model.state';
import { CatalogueUOMModel } from 'src/app/models/catalogueUOM/catalogue_uom.model';
import { CatalogueUOMModelAudit } from 'src/app/models/catalogueUOM/catalogue_uom.model.state';
import { ChartOfAccountModel } from 'src/app/models/chartOfAccount/chart_of_account.model';
import { ChartOfAccountModelAudit } from 'src/app/models/chartOfAccount/chart_of_account.model.state';
import { ChartOfAccountMappingModel } from 'src/app/models/chartOfAccountMapping/chart_of_account_mapping.model';
import { ChartOfAccountMappingModelAudit } from 'src/app/models/chartOfAccountMapping/chart_of_account_mapping.model.state';
import { ClaimUserModel } from 'src/app/models/claimUser/claim_user.model';
import { ClaimUserModelAudit } from 'src/app/models/claimUser/claim_user.model.state';
import { CoTreatingDoctorModel } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model';
import { CoTreatingDoctorModelAudit } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.state';
import { CompoundPrescriptionDetailModel } from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model';
import { CompoundPrescriptionDetailModelAudit } from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model.state';
import { CompoundPrescriptionItemModel } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model';
import { CompoundPrescriptionItemModelAudit } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model.state';
import { DailyCareCPPTModel } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model';
import { DailyCareCPPTModelAudit } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.state';
import { DeliveryMedicalExaminationRecordModel } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import { DeliveryMedicalExaminationRecordModelAudit } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.state';
import { DeliveryProgressModel } from 'src/app/models/deliveryProgress/delivery_progress.model';
import { DeliveryProgressModelAudit } from 'src/app/models/deliveryProgress/delivery_progress.model.state';
import { DiagnosesAndProceduresModel } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import { DiagnosesAndProceduresModelAudit } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.state';
import { DiagnosisExaminationRecordModel } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model';
import { DiagnosisExaminationRecordModelAudit } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.state';
import { DiagnosisNandaModel } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model';
import { DiagnosisNandaModelAudit } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.state';
import { DiagnosticExaminationResultsModel } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model';
import { DiagnosticExaminationResultsModelAudit } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.state';
import { DiagnosticStaffExaminationSummaryModel } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model';
import { DiagnosticStaffExaminationSummaryModelAudit } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.state';
import { DiagnosticSupportGeneralConfigurationModel } from 'src/app/models/diagnosticSupportGeneralConfiguration/diagnostic_support_general_configuration.model';
import { DiagnosticSupportGeneralConfigurationModelAudit } from 'src/app/models/diagnosticSupportGeneralConfiguration/diagnostic_support_general_configuration.model.state';
import { DiagnosticSupportUserModel } from 'src/app/models/diagnosticSupportUser/diagnostic_support_user.model';
import { DiagnosticSupportUserModelAudit } from 'src/app/models/diagnosticSupportUser/diagnostic_support_user.model.state';
import { DoctorScheduleModel } from 'src/app/models/doctorSchedule/doctor_schedule.model';
import { DoctorScheduleModelAudit } from 'src/app/models/doctorSchedule/doctor_schedule.model.state';
import { DoctorUserModel } from 'src/app/models/doctorUser/doctor_user.model';
import { DoctorUserModelAudit } from 'src/app/models/doctorUser/doctor_user.model.state';
import { EntExaminationModel } from 'src/app/models/entExamination/ent_examination.model';
import { EntExaminationModelAudit } from 'src/app/models/entExamination/ent_examination.model.state';
import { EmergencyMedicalExaminationRecordModel } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model';
import { EmergencyMedicalExaminationRecordModelAudit } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.state';
import { ExaminationGroupModel } from 'src/app/models/examinationGroup/examination_group.model';
import { ExaminationGroupModelAudit } from 'src/app/models/examinationGroup/examination_group.model.state';
import { ExaminationItemModel } from 'src/app/models/examinationItem/examination_item.model';
import { ExaminationItemModelAudit } from 'src/app/models/examinationItem/examination_item.model.state';
import { ExaminationItemDetailModel } from 'src/app/models/examinationItemDetail/examination_item_detail.model';
import { ExaminationItemDetailModelAudit } from 'src/app/models/examinationItemDetail/examination_item_detail.model.state';
import { FacilityHistoryModel } from 'src/app/models/facilityHistory/facility_history.model';
import { FacilityHistoryModelAudit } from 'src/app/models/facilityHistory/facility_history.model.state';
import { FacilityUserModel } from 'src/app/models/facilityUser/facility_user.model';
import { FacilityUserModelAudit } from 'src/app/models/facilityUser/facility_user.model.state';
import { FluidBalanceDetailModel } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model';
import { FluidBalanceDetailModelAudit } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.state';
import { FormulirKonselingTesHivModel } from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model';
import { FormulirKonselingTesHivModelAudit } from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.state';
import { GoodsReceiveNoteModel } from 'src/app/models/goodsReceiveNote/goods_receive_note.model';
import { GoodsReceiveNoteModelAudit } from 'src/app/models/goodsReceiveNote/goods_receive_note.model.state';
import { GoodsReceiveNoteBatchModel } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model';
import { GoodsReceiveNoteBatchModelAudit } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.state';
import { GoodsReceiveNoteItemModel } from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model';
import { GoodsReceiveNoteItemModelAudit } from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model.state';
import { HealthFacilityModel } from 'src/app/models/healthFacility/health_facility.model';
import { HealthFacilityModelAudit } from 'src/app/models/healthFacility/health_facility.model.state';
import { HemodialysisExaminationModel } from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model';
import { HemodialysisExaminationModelAudit } from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model.state';
import { HemodialysisMonitoringModel } from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model';
import { HemodialysisMonitoringModelAudit } from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model.state';
import { HospitalBranchInformationModel } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model';
import { HospitalBranchInformationModelAudit } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model.state';
import { HospitalGroupInformationModel } from 'src/app/models/hospitalGroupInformation/hospital_group_information.model';
import { HospitalGroupInformationModelAudit } from 'src/app/models/hospitalGroupInformation/hospital_group_information.model.state';
import { Icd10Model } from 'src/app/models/icd10/icd_10.model';
import { Icd10ModelAudit } from 'src/app/models/icd10/icd_10.model.state';
import { Icd9CMModel } from 'src/app/models/icd9CM/icd_9_cm.model';
import { Icd9CMModelAudit } from 'src/app/models/icd9CM/icd_9_cm.model.state';
import { InformedConsentModel } from 'src/app/models/informedConsent/informed_consent.model';
import { InformedConsentModelAudit } from 'src/app/models/informedConsent/informed_consent.model.state';
import { InpatientMedicalExaminationRecordModel } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import { InpatientMedicalExaminationRecordModelAudit } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.state';
import { InsuranceBenefitPlanModel } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model';
import { InsuranceBenefitPlanModelAudit } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model.state';
import { InsuranceProviderModel } from 'src/app/models/insuranceProvider/insurance_provider.model';
import { InsuranceProviderModelAudit } from 'src/app/models/insuranceProvider/insurance_provider.model.state';
import { InternalOrderModel } from 'src/app/models/internalOrder/internal_order.model';
import { InternalOrderModelAudit } from 'src/app/models/internalOrder/internal_order.model.state';
import { InternalOrderStockDetailModel } from 'src/app/models/internalOrderStockDetail/internal_order_stock_detail.model';
import { InternalOrderStockDetailModelAudit } from 'src/app/models/internalOrderStockDetail/internal_order_stock_detail.model.state';
import { IntraoperativeRecordsModel } from 'src/app/models/intraoperativeRecords/intraoperative_records.model';
import { IntraoperativeRecordsModelAudit } from 'src/app/models/intraoperativeRecords/intraoperative_records.model.state';
import { InventoryAdjusmentBatchModel } from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model';
import { InventoryAdjusmentBatchModelAudit } from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model.state';
import { InventoryAdjustmentModel } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model';
import { InventoryAdjustmentModelAudit } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.state';
import { InventoryAdjustmentItemModel } from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model';
import { InventoryAdjustmentItemModelAudit } from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model.state';
import { InventoryBatchCorrectionModel } from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model';
import { InventoryBatchCorrectionModelAudit } from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model.state';
import { InventoryBatchCorrectionItemModel } from 'src/app/models/inventoryBatchCorrectionItem/inventory_batch_correction_item.model';
import { InventoryBatchCorrectionItemModelAudit } from 'src/app/models/inventoryBatchCorrectionItem/inventory_batch_correction_item.model.state';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceModelAudit } from 'src/app/models/invoice/invoice.model.state';
import { InvoiceItemModel } from 'src/app/models/invoiceItem/invoice_item.model';
import { InvoiceItemModelAudit } from 'src/app/models/invoiceItem/invoice_item.model.state';
import { InvoiceItemComponentModel } from 'src/app/models/invoiceItemComponent/invoice_item_component.model';
import { InvoiceItemComponentModelAudit } from 'src/app/models/invoiceItemComponent/invoice_item_component.model.state';
import { InvoicePaymentInsuranceModel } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model';
import { InvoicePaymentInsuranceModelAudit } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.state';
import { InvoicePaymentOtherModel } from 'src/app/models/invoicePaymentOther/invoice_payment_other.model';
import { InvoicePaymentOtherModelAudit } from 'src/app/models/invoicePaymentOther/invoice_payment_other.model.state';
import { InvoicePaymentSelfPayingModel } from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model';
import { InvoicePaymentSelfPayingModelAudit } from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model.state';
import { InvoiceSummaryModel } from 'src/app/models/invoiceSummary/invoice_summary.model';
import { InvoiceSummaryModelAudit } from 'src/app/models/invoiceSummary/invoice_summary.model.state';
import { JournalModel } from 'src/app/models/journal/journal.model';
import { JournalModelAudit } from 'src/app/models/journal/journal.model.state';
import { LibraryModel } from 'src/app/models/library/library.model';
import { LibraryModelAudit } from 'src/app/models/library/library.model.state';
import { LocationModel } from 'src/app/models/location/location.model';
import { LocationModelAudit } from 'src/app/models/location/location.model.state';
import { McuPackageModel } from 'src/app/models/mcuPackage/mcu_package.model';
import { McuPackageModelAudit } from 'src/app/models/mcuPackage/mcu_package.model.state';
import { McuPackageItemModel } from 'src/app/models/mcuPackageItem/mcu_package_item.model';
import { McuPackageItemModelAudit } from 'src/app/models/mcuPackageItem/mcu_package_item.model.state';
import { ManagementUserModel } from 'src/app/models/managementUser/management_user.model';
import { ManagementUserModelAudit } from 'src/app/models/managementUser/management_user.model.state';
import { MedicalCertificateDischargeResumeModel } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import { MedicalCertificateDischargeResumeModelAudit } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.state';
import { MedicalCertificateBirthModel } from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model';
import { MedicalCertificateBirthModelAudit } from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model.state';
import { MedicalCertificateHospitalizationModel } from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model';
import { MedicalCertificateHospitalizationModelAudit } from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model.state';
import { MedicalCertificateMedicalAttendanceModel } from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model';
import { MedicalCertificateMedicalAttendanceModelAudit } from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.state';
import { MedicalCertificateMentalHealthModel } from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model';
import { MedicalCertificateMentalHealthModelAudit } from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model.state';
import { MedicalCertificatePhysicalHealthModel } from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model';
import { MedicalCertificatePhysicalHealthModelAudit } from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.state';
import { MedicalCertificateRestrictedWorkModel } from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model';
import { MedicalCertificateRestrictedWorkModelAudit } from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.state';
import { MedicalCertificateSickLeaveModel } from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model';
import { MedicalCertificateSickLeaveModelAudit } from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model.state';
import { MedicalExaminationRecordModel } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model';
import { MedicalExaminationRecordModelAudit } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.state';
import { MedicalExaminationRecordDischargeSummaryModel } from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model';
import { MedicalExaminationRecordDischargeSummaryModelAudit } from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.state';
import { MedicalFeeModel } from 'src/app/models/medicalFee/medical_fee.model';
import { MedicalFeeModelAudit } from 'src/app/models/medicalFee/medical_fee.model.state';
import { MedicalFeeItemComponentModel } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model';
import { MedicalFeeItemComponentModelAudit } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model.state';
import { MedicalRecordInitialChecklistModel } from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model';
import { MedicalRecordInitialChecklistModelAudit } from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model.state';
import { MedicalRecordNextVerificationChecklistModel } from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model';
import { MedicalRecordNextVerificationChecklistModelAudit } from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.state';
import { MedicalRecordUserModel } from 'src/app/models/medicalRecordUser/medical_record_user.model';
import { MedicalRecordUserModelAudit } from 'src/app/models/medicalRecordUser/medical_record_user.model.state';
import { MedicalTranscriberUserModel } from 'src/app/models/medicalTranscriberUser/medical_transcriber_user.model';
import { MedicalTranscriberUserModelAudit } from 'src/app/models/medicalTranscriberUser/medical_transcriber_user.model.state';
import { MedicationAdministeredHistoryModel } from 'src/app/models/medicationAdministeredHistory/medication_administered_history.model';
import { MedicationAdministeredHistoryModelAudit } from 'src/app/models/medicationAdministeredHistory/medication_administered_history.model.state';
import { MedicationCompoundModel } from 'src/app/models/medicationCompound/medication_compound.model';
import { MedicationCompoundModelAudit } from 'src/app/models/medicationCompound/medication_compound.model.state';
import { MedicationHeaderModel } from 'src/app/models/medicationHeader/medication_header.model';
import { MedicationHeaderModelAudit } from 'src/app/models/medicationHeader/medication_header.model.state';
import { MedicationItemModel } from 'src/app/models/medicationItem/medication_item.model';
import { MedicationItemModelAudit } from 'src/app/models/medicationItem/medication_item.model.state';
import { MerchantModel } from 'src/app/models/merchant/merchant.model';
import { MerchantModelAudit } from 'src/app/models/merchant/merchant.model.state';
import { MerchantSurchargeAndFeeModel } from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model';
import { MerchantSurchargeAndFeeModelAudit } from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model.state';
import { NhisClaimModel } from 'src/app/models/nhisClaim/nhis_claim.model';
import { NhisClaimModelAudit } from 'src/app/models/nhisClaim/nhis_claim.model.state';
import { NhisClaimGDRGDetailModel } from 'src/app/models/nhisClaimGDRGDetail/nhis_claim_gdrg_detail.model';
import { NhisClaimGDRGDetailModelAudit } from 'src/app/models/nhisClaimGDRGDetail/nhis_claim_gdrg_detail.model.state';
import { NhisClaimInvestigationDetailModel } from 'src/app/models/nhisClaimInvestigationDetail/nhis_claim_investigation_detail.model';
import { NhisClaimInvestigationDetailModelAudit } from 'src/app/models/nhisClaimInvestigationDetail/nhis_claim_investigation_detail.model.state';
import { NhisGDRGModel } from 'src/app/models/nhisGDRG/nhis_gdrg.model';
import { NhisGDRGModelAudit } from 'src/app/models/nhisGDRG/nhis_gdrg.model.state';
import { NhisInvestigationModel } from 'src/app/models/nhisInvestigation/nhis_investigation.model';
import { NhisInvestigationModelAudit } from 'src/app/models/nhisInvestigation/nhis_investigation.model.state';
import { NhisMedicineModel } from 'src/app/models/nhisMedicine/nhis_medicine.model';
import { NhisMedicineModelAudit } from 'src/app/models/nhisMedicine/nhis_medicine.model.state';
import { NhisServiceOutcomeModel } from 'src/app/models/nhisServiceOutcome/nhis_service_outcome.model';
import { NhisServiceOutcomeModelAudit } from 'src/app/models/nhisServiceOutcome/nhis_service_outcome.model.state';
import { NhisSpecialtyAttendedModel } from 'src/app/models/nhisSpecialtyAttended/nhis_specialty_attended.model';
import { NhisSpecialtyAttendedModelAudit } from 'src/app/models/nhisSpecialtyAttended/nhis_specialty_attended.model.state';
import { NhisTypeOfServiceModel } from 'src/app/models/nhisTypeOfService/nhis_type_of_service.model';
import { NhisTypeOfServiceModelAudit } from 'src/app/models/nhisTypeOfService/nhis_type_of_service.model.state';
import { NewbornDetailModel } from 'src/app/models/newbornDetail/newborn_detail.model';
import { NewbornDetailModelAudit } from 'src/app/models/newbornDetail/newborn_detail.model.state';
import { NumberingSetupModel } from 'src/app/models/numberingSetup/numbering_setup.model';
import { NumberingSetupModelAudit } from 'src/app/models/numberingSetup/numbering_setup.model.state';
import { NurseUserModel } from 'src/app/models/nurseUser/nurse_user.model';
import { NurseUserModelAudit } from 'src/app/models/nurseUser/nurse_user.model.state';
import { NurseVitalSignMeasurementModel } from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model';
import { NurseVitalSignMeasurementModelAudit } from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.state';
import { ObstetricAndGynecologyHistoryModel } from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model';
import { ObstetricAndGynecologyHistoryModelAudit } from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.state';
import { OdontogramExaminationModel } from 'src/app/models/odontogramExamination/odontogram_examination.model';
import { OdontogramExaminationModelAudit } from 'src/app/models/odontogramExamination/odontogram_examination.model.state';
import { OperatingTheaterMedicalExaminationRecordModel } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import { OperatingTheaterMedicalExaminationRecordModelAudit } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.state';
import { OphthalmologyExaminationModel } from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model';
import { OphthalmologyExaminationModelAudit } from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model.state';
import { PcareActionExaminationModel } from 'src/app/models/pcareActionExamination/pcare_action_examination.model';
import { PcareActionExaminationModelAudit } from 'src/app/models/pcareActionExamination/pcare_action_examination.model.state';
import { PcareClubProlanisModel } from 'src/app/models/pcareClubProlanis/pcare_club_prolanis.model';
import { PcareClubProlanisModelAudit } from 'src/app/models/pcareClubProlanis/pcare_club_prolanis.model.state';
import { PcareCompoundDrugModel } from 'src/app/models/pcareCompoundDrug/pcare_compound_drug.model';
import { PcareCompoundDrugModelAudit } from 'src/app/models/pcareCompoundDrug/pcare_compound_drug.model.state';
import { PcareCompoundDrugItemModel } from 'src/app/models/pcareCompoundDrugItem/pcare_compound_drug_item.model';
import { PcareCompoundDrugItemModelAudit } from 'src/app/models/pcareCompoundDrugItem/pcare_compound_drug_item.model.state';
import { PcareDiagnosaModel } from 'src/app/models/pcareDiagnosa/pcare_diagnosa.model';
import { PcareDiagnosaModelAudit } from 'src/app/models/pcareDiagnosa/pcare_diagnosa.model.state';
import { PcareDokterModel } from 'src/app/models/pcareDokter/pcare_dokter.model';
import { PcareDokterModelAudit } from 'src/app/models/pcareDokter/pcare_dokter.model.state';
import { PcareExaminationModel } from 'src/app/models/pcareExamination/pcare_examination.model';
import { PcareExaminationModelAudit } from 'src/app/models/pcareExamination/pcare_examination.model.state';
import { PcareMCUModel } from 'src/app/models/pcareMCU/pcare_mcu.model';
import { PcareMCUModelAudit } from 'src/app/models/pcareMCU/pcare_mcu.model.state';
import { PcareNonCompoundDrugModel } from 'src/app/models/pcareNonCompoundDrug/pcare_noncompound_drug.model';
import { PcareNonCompoundDrugModelAudit } from 'src/app/models/pcareNonCompoundDrug/pcare_noncompound_drug.model.state';
import { PcareReferensiSaranaModel } from 'src/app/models/pcareReferensiSarana/pcare_referensi_sarana.model';
import { PcareReferensiSaranaModelAudit } from 'src/app/models/pcareReferensiSarana/pcare_referensi_sarana.model.state';
import { PcareStatusPulangModel } from 'src/app/models/pcareStatusPulang/pcare_status_pulang.model';
import { PcareStatusPulangModelAudit } from 'src/app/models/pcareStatusPulang/pcare_status_pulang.model.state';
import { PcareTindakanModel } from 'src/app/models/pcareTindakan/pcare_tindakan.model';
import { PcareTindakanModelAudit } from 'src/app/models/pcareTindakan/pcare_tindakan.model.state';
import { PcareUmumModel } from 'src/app/models/pcareUmum/pcare_umum.model';
import { PcareUmumModelAudit } from 'src/app/models/pcareUmum/pcare_umum.model.state';
import { PatientCaseHistoryModel } from 'src/app/models/patientCaseHistory/patient_case_history.model';
import { PatientCaseHistoryModelAudit } from 'src/app/models/patientCaseHistory/patient_case_history.model.state';
import { PatientConsentModel } from 'src/app/models/patientConsent/patient_consent.model';
import { PatientConsentModelAudit } from 'src/app/models/patientConsent/patient_consent.model.state';
import { PatientContactInfoModel } from 'src/app/models/patientContactInfo/patient_contact_info.model';
import { PatientContactInfoModelAudit } from 'src/app/models/patientContactInfo/patient_contact_info.model.state';
import { PatientDetailModel } from 'src/app/models/patientDetail/patient_detail.model';
import { PatientDetailModelAudit } from 'src/app/models/patientDetail/patient_detail.model.state';
import { PatientDetailAddressModel } from 'src/app/models/patientDetailAddress/patient_detail_address.model';
import { PatientDetailAddressModelAudit } from 'src/app/models/patientDetailAddress/patient_detail_address.model.state';
import { PatientEmergencyContactDetailModel } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model';
import { PatientEmergencyContactDetailModelAudit } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model.state';
import { PatientEmploymentDetailModel } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model';
import { PatientEmploymentDetailModelAudit } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model.state';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoModelAudit } from 'src/app/models/patientGeneralInfo/patient_general_info.model.state';
import { PatientPaymentSelfPayingModel } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model';
import { PatientPaymentSelfPayingModelAudit } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model.state';
import { PatientPaymentBPJSModel } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import { PatientPaymentBPJSModelAudit } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.state';
import { PatientPaymentInsuranceModel } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model';
import { PatientPaymentInsuranceModelAudit } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.state';
import { PatientPaymentOthersModel } from 'src/app/models/patientPaymentOthers/patient_payment_others.model';
import { PatientPaymentOthersModelAudit } from 'src/app/models/patientPaymentOthers/patient_payment_others.model.state';
import { PatientPersonalInfoModel } from 'src/app/models/patientPersonalInfo/patient_personal_info.model';
import { PatientPersonalInfoModelAudit } from 'src/app/models/patientPersonalInfo/patient_personal_info.model.state';
import { PatientSupportingDocumentModel } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model';
import { PatientSupportingDocumentModelAudit } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model.state';
import { PatientVisitModel } from 'src/app/models/patientVisit/patient_visit.model';
import { PatientVisitModelAudit } from 'src/app/models/patientVisit/patient_visit.model.state';
import { PatientVisitPatientPaymentInsuranceModel } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model';
import { PatientVisitPatientPaymentInsuranceModelAudit } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.state';
import { PatientVisitPatientPaymentOthersModel } from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model';
import { PatientVisitPatientPaymentOthersModelAudit } from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.state';
import { PatientVisitPaymentSelfPayingModel } from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model';
import { PatientVisitPaymentSelfPayingModelAudit } from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.state';
import { PatientVitalInformationModel } from 'src/app/models/patientVitalInformation/patient_vital_information.model';
import { PatientVitalInformationModelAudit } from 'src/app/models/patientVitalInformation/patient_vital_information.model.state';
import { PharmacySetupModel } from 'src/app/models/pharmacySetup/pharmacy_setup.model';
import { PharmacySetupModelAudit } from 'src/app/models/pharmacySetup/pharmacy_setup.model.state';
import { PharmacyUserModel } from 'src/app/models/pharmacyUser/pharmacy_user.model';
import { PharmacyUserModelAudit } from 'src/app/models/pharmacyUser/pharmacy_user.model.state';
import { PostOperativeDetailsModel } from 'src/app/models/postOperativeDetails/post_operative_details.model';
import { PostOperativeDetailsModelAudit } from 'src/app/models/postOperativeDetails/post_operative_details.model.state';
import { PreoperativeRecordsModel } from 'src/app/models/preoperativeRecords/preoperative_records.model';
import { PreoperativeRecordsModelAudit } from 'src/app/models/preoperativeRecords/preoperative_records.model.state';
import { PrescriptionCompoundModel } from 'src/app/models/prescriptionCompound/prescription_compound.model';
import { PrescriptionCompoundModelAudit } from 'src/app/models/prescriptionCompound/prescription_compound.model.state';
import { PrescriptionHeaderModel } from 'src/app/models/prescriptionHeader/prescription_header.model';
import { PrescriptionHeaderModelAudit } from 'src/app/models/prescriptionHeader/prescription_header.model.state';
import { PrescriptionItemModel } from 'src/app/models/prescriptionItem/prescription_item.model';
import { PrescriptionItemModelAudit } from 'src/app/models/prescriptionItem/prescription_item.model.state';
import { PriceComponentModel } from 'src/app/models/priceComponent/price_component.model';
import { PriceComponentModelAudit } from 'src/app/models/priceComponent/price_component.model.state';
import { PrivilegeModel } from 'src/app/models/privilege/privilege.model';
import { PrivilegeModelAudit } from 'src/app/models/privilege/privilege.model.state';
import { ProcessWorkflowModel } from 'src/app/models/processWorkflow/process_workflow.model';
import { ProcessWorkflowModelAudit } from 'src/app/models/processWorkflow/process_workflow.model.state';
import { PurchaseOrderModel } from 'src/app/models/purchaseOrder/purchase_order.model';
import { PurchaseOrderModelAudit } from 'src/app/models/purchaseOrder/purchase_order.model.state';
import { PurchaseOrderStockDetailModel } from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model';
import { PurchaseOrderStockDetailModelAudit } from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model.state';
import { PurchaseRequisitionModel } from 'src/app/models/purchaseRequisition/purchase_requisition.model';
import { PurchaseRequisitionModelAudit } from 'src/app/models/purchaseRequisition/purchase_requisition.model.state';
import { PurchaseRequisitionStockDetailModel } from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model';
import { PurchaseRequisitionStockDetailModelAudit } from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.state';
import { PurchasingUserModel } from 'src/app/models/purchasingUser/purchasing_user.model';
import { PurchasingUserModelAudit } from 'src/app/models/purchasingUser/purchasing_user.model.state';
import { ReferenceDataModel } from 'src/app/models/referenceData/reference_data.model';
import { ReferenceDataModelAudit } from 'src/app/models/referenceData/reference_data.model.state';
import { ReferenceHeaderModel } from 'src/app/models/referenceHeader/reference_header.model';
import { ReferenceHeaderModelAudit } from 'src/app/models/referenceHeader/reference_header.model.state';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationModelAudit } from 'src/app/models/registration/registration.model.state';
import { RegistrationUserModel } from 'src/app/models/registrationUser/registration_user.model';
import { RegistrationUserModelAudit } from 'src/app/models/registrationUser/registration_user.model.state';
import { RetailPharmacyModel } from 'src/app/models/retailPharmacy/retail_pharmacy.model';
import { RetailPharmacyModelAudit } from 'src/app/models/retailPharmacy/retail_pharmacy.model.state';
import { RetailPharmacyInvoiceModel } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model';
import { RetailPharmacyInvoiceModelAudit } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.state';
import { RetailPharmacyStockDetailModel } from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model';
import { RetailPharmacyStockDetailModelAudit } from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.state';
import { ReturnSupplierModel } from 'src/app/models/returnSupplier/return_supplier.model';
import { ReturnSupplierModelAudit } from 'src/app/models/returnSupplier/return_supplier.model.state';
import { ReturnSupplierStockDetailModel } from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model';
import { ReturnSupplierStockDetailModelAudit } from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model.state';
import { RoleModel } from 'src/app/models/role/role.model';
import { RoleModelAudit } from 'src/app/models/role/role.model.state';
import { RoomFacilityModel } from 'src/app/models/roomFacility/room_facility.model';
import { RoomFacilityModelAudit } from 'src/app/models/roomFacility/room_facility.model.state';
import { RoomTransferModel } from 'src/app/models/roomTransfer/room_transfer.model';
import { RoomTransferModelAudit } from 'src/app/models/roomTransfer/room_transfer.model.state';
import { SepModel } from 'src/app/models/sep/sep.model';
import { SepModelAudit } from 'src/app/models/sep/sep.model.state';
import { SampleCollectionInformationModel } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model';
import { SampleCollectionInformationModelAudit } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model.state';
import { SampleCollectionItemsModel } from 'src/app/models/sampleCollectionItems/sample_collection_items.model';
import { SampleCollectionItemsModelAudit } from 'src/app/models/sampleCollectionItems/sample_collection_items.model.state';
import { SatuSehatConfigurationModel } from 'src/app/models/satuSehatConfiguration/satu_sehat_configuration.model';
import { SatuSehatConfigurationModelAudit } from 'src/app/models/satuSehatConfiguration/satu_sehat_configuration.model.state';
import { ServiceModel } from 'src/app/models/service/service.model';
import { ServiceModelAudit } from 'src/app/models/service/service.model.state';
import { ServiceFacilityCategoryModel } from 'src/app/models/serviceFacilityCategory/service_facility_category.model';
import { ServiceFacilityCategoryModelAudit } from 'src/app/models/serviceFacilityCategory/service_facility_category.model.state';
import { ServiceItemModel } from 'src/app/models/serviceItem/service_item.model';
import { ServiceItemModelAudit } from 'src/app/models/serviceItem/service_item.model.state';
import { ServiceItemAssignmentModel } from 'src/app/models/serviceItemAssignment/service_item_assignment.model';
import { ServiceItemAssignmentModelAudit } from 'src/app/models/serviceItemAssignment/service_item_assignment.model.state';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffModelAudit } from 'src/app/models/staff/staff.model.state';
import { StockCatalogueModel } from 'src/app/models/stockCatalogue/stock_catalogue.model';
import { StockCatalogueModelAudit } from 'src/app/models/stockCatalogue/stock_catalogue.model.state';
import { StockControlModel } from 'src/app/models/stockControl/stock_control.model';
import { StockControlModelAudit } from 'src/app/models/stockControl/stock_control.model.state';
import { StockTransactionDetailModel } from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model';
import { StockTransactionDetailModelAudit } from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model.state';
import { StockTransactionPerDateModel } from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model';
import { StockTransactionPerDateModelAudit } from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model.state';
import { StockTransactionPerDateTypeModel } from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model';
import { StockTransactionPerDateTypeModelAudit } from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model.state';
import { SupplierModel } from 'src/app/models/supplier/supplier.model';
import { SupplierModelAudit } from 'src/app/models/supplier/supplier.model.state';
import { SupplierBankAccountModel } from 'src/app/models/supplierBankAccount/supplier_bank_account.model';
import { SupplierBankAccountModelAudit } from 'src/app/models/supplierBankAccount/supplier_bank_account.model.state';
import { SupplierContactDetailModel } from 'src/app/models/supplierContactDetail/supplier_contact_detail.model';
import { SupplierContactDetailModelAudit } from 'src/app/models/supplierContactDetail/supplier_contact_detail.model.state';
import { SupplierProductDetailModel } from 'src/app/models/supplierProductDetail/supplier_product_detail.model';
import { SupplierProductDetailModelAudit } from 'src/app/models/supplierProductDetail/supplier_product_detail.model.state';
import { SystemAdminUserModel } from 'src/app/models/systemAdminUser/system_admin_user.model';
import { SystemAdminUserModelAudit } from 'src/app/models/systemAdminUser/system_admin_user.model.state';
import { TariffDefinitionModel } from 'src/app/models/tariffDefinition/tariff_definition.model';
import { TariffDefinitionModelAudit } from 'src/app/models/tariffDefinition/tariff_definition.model.state';
import { TariffDefinitionOtherComponentModel } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model';
import { TariffDefinitionOtherComponentModelAudit } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model.state';
import { TariffFormulaModel } from 'src/app/models/tariffFormula/tariff_formula.model';
import { TariffFormulaModelAudit } from 'src/app/models/tariffFormula/tariff_formula.model.state';
import { TariffPackageModel } from 'src/app/models/tariffPackage/tariff_package.model';
import { TariffPackageModelAudit } from 'src/app/models/tariffPackage/tariff_package.model.state';
import { TariffPackageItemModel } from 'src/app/models/tariffPackageItem/tariff_package_item.model';
import { TariffPackageItemModelAudit } from 'src/app/models/tariffPackageItem/tariff_package_item.model.state';
import { TariffPackageServiceAssignmentModel } from 'src/app/models/tariffPackageServiceAssignment/tariff_package_service_assignment.model';
import { TariffPackageServiceAssignmentModelAudit } from 'src/app/models/tariffPackageServiceAssignment/tariff_package_service_assignment.model.state';
import { TariffSchemaModel } from 'src/app/models/tariffSchema/tariff_schema.model';
import { TariffSchemaModelAudit } from 'src/app/models/tariffSchema/tariff_schema.model.state';
import { TaskDashboardModel } from 'src/app/models/taskDashboard/task_dashboard.model';
import { TaskDashboardModelAudit } from 'src/app/models/taskDashboard/task_dashboard.model.state';
import { TransactionDetailTypeModel } from 'src/app/models/transactionDetailType/transaction_detail_type.model';
import { TransactionDetailTypeModelAudit } from 'src/app/models/transactionDetailType/transaction_detail_type.model.state';
import { TransactionDetailTypeMappingModel } from 'src/app/models/transactionDetailTypeMapping/transaction_detail_type_mapping.model';
import { TransactionDetailTypeMappingModelAudit } from 'src/app/models/transactionDetailTypeMapping/transaction_detail_type_mapping.model.state';
import { TransferOrderModel } from 'src/app/models/transferOrder/transfer_order.model';
import { TransferOrderModelAudit } from 'src/app/models/transferOrder/transfer_order.model.state';
import { TransferOrderStockDetailModel } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model';
import { TransferOrderStockDetailModelAudit } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.state';
import { UnitOfMeasurementModel } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model';
import { UnitOfMeasurementModelAudit } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model.state';
import { UserModel } from 'src/app/models/user/user.model';
import { UserModelAudit } from 'src/app/models/user/user.model.state';
import { VaccinationOrderModel } from 'src/app/models/vaccinationOrder/vaccination_order.model';
import { VaccinationOrderModelAudit } from 'src/app/models/vaccinationOrder/vaccination_order.model.state';
import { VaccinationOrderDetailModel } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model';
import { VaccinationOrderDetailModelAudit } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.state';
import { VitalSignsModel } from 'src/app/models/vitalSigns/vital_signs.model';
import { VitalSignsModelAudit } from 'src/app/models/vitalSigns/vital_signs.model.state';
import { WarehouseModel } from 'src/app/models/warehouse/warehouse.model';
import { WarehouseModelAudit } from 'src/app/models/warehouse/warehouse.model.state';
import { WarehouseInitialStockModel } from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model';
import { WarehouseInitialStockModelAudit } from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model.state';
import { WarehouseInventoryModel } from 'src/app/models/warehouseInventory/warehouse_inventory.model';
import { WarehouseInventoryModelAudit } from 'src/app/models/warehouseInventory/warehouse_inventory.model.state';
import { WarehouseUserModel } from 'src/app/models/warehouseUser/warehouse_user.model';
import { WarehouseUserModelAudit } from 'src/app/models/warehouseUser/warehouse_user.model.state';

import { ModelProperty, ModelRelation } from 'src/app/lib/models/abstract.model';
import { CommonComponentModule } from 'src/app/lib/components/common.component.module';
import { CrudCreateEditComponent } from './crud.create.edit.component';
import { StoreModule } from '@ngrx/store';
import { reducers, clearState } from 'src/app/models/model.reducer';
import { initialRouterState, initialModelState } from 'src/app/models/model.state';
import { createReactiveFormFromModel } from 'src/app/lib/models/model-utils';
import { ValidatorInputUtils } from 'src/testing/helpers/validator-input-utils';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

const requiredValidators = [
	{entityName: 'amendmentDetail', attributeName: 'reason'},
	{entityName: 'bpjsDismissalMapping', attributeName: 'refCode'},
	{entityName: 'bpjsDismissalMapping', attributeName: 'refName'},
	{entityName: 'bpjsDismissalMapping', attributeName: 'internalDismissal'},
	{entityName: 'bpjsDoctorMapping', attributeName: 'refCode'},
	{entityName: 'bpjsDoctorMapping', attributeName: 'bpjsMedicalStaff'},
	{entityName: 'bpjsGeneral', attributeName: 'consID'},
	{entityName: 'bpjsGeneral', attributeName: 'secretKey'},
	{entityName: 'bpjsGeneral', attributeName: 'bpjsWebServiceURL'},
	{entityName: 'bpjsGeneral', attributeName: 'aplicareWebServiceURL'},
	{entityName: 'bpjsGeneral', attributeName: 'healthFacilityCode'},
	{entityName: 'bpjsGeneral', attributeName: 'healthFacilityName'},
	{entityName: 'bpjsINACBG', attributeName: 'healthFacilityCode'},
	{entityName: 'bpjsINACBG', attributeName: 'healthFacilityName'},
	{entityName: 'bpjsINACBG', attributeName: 'address'},
	{entityName: 'bpjsINACBG', attributeName: 'stateProvince'},
	{entityName: 'bpjsINACBG', attributeName: 'cityRegency'},
	{entityName: 'bpjsINACBG', attributeName: 'regional'},
	{entityName: 'bpjsINACBG', attributeName: 'hospitalClass'},
	{entityName: 'bpjsINACBG', attributeName: 'inacbgTariff1'},
	{entityName: 'bpjsINACBG', attributeName: 'inacbgTariff2'},
	{entityName: 'bpjsINACBG', attributeName: 'additionalUpgradeVIP'},
	{entityName: 'bpjsINACBG', attributeName: 'payplanID'},
	{entityName: 'bpjsINACBG', attributeName: 'paymentPlanCode'},
	{entityName: 'bpjsINACBG', attributeName: 'tariffCode'},
	{entityName: 'bpjsINACBG', attributeName: 'url'},
	{entityName: 'bpjsINACBG', attributeName: 'username'},
	{entityName: 'bpjsINACBG', attributeName: 'password'},
	{entityName: 'bpjsINACBG', attributeName: 'secretKey'},
	{entityName: 'bpjsINACBG', attributeName: 'coderID'},
	{entityName: 'bpjsINACBGVariable', attributeName: 'variableCode'},
	{entityName: 'bpjsINACBGVariable', attributeName: 'english'},
	{entityName: 'bpjsINACBGVariable', attributeName: 'indonesian'},
	{entityName: 'bpjsINACBGVariable', attributeName: 'notes'},
	{entityName: 'bpjsTreatmentClassMapping', attributeName: 'refCode'},
	{entityName: 'bpjsTreatmentClassMapping', attributeName: 'refName'},
	{entityName: 'bpjsTreatmentClassMapping', attributeName: 'internalTreatmentClass'},
	{entityName: 'bedFacility', attributeName: 'bedNumber'},
	{entityName: 'bedFacility', attributeName: 'bedName'},
	{entityName: 'bedFacility', attributeName: 'treatmentClass'},
	{entityName: 'bedFacility', attributeName: 'availability'},
	{entityName: 'cashReceipt', attributeName: 'receiptType'},
	{entityName: 'cashReceipt', attributeName: 'paymentDate'},
	{entityName: 'cashReceipt', attributeName: 'cashierLocation'},
	{entityName: 'cashRefund', attributeName: 'refundDate'},
	{entityName: 'cashRefund', attributeName: 'cashierLocation'},
	{entityName: 'dailyCareCPPT', attributeName: 'subjective'},
	{entityName: 'dailyCareCPPT', attributeName: 'objective'},
	{entityName: 'dailyCareCPPT', attributeName: 'diagnose'},
	{entityName: 'dailyCareCPPT', attributeName: 'plan'},
	{entityName: 'dailyCareCPPT', attributeName: 'instruction'},
	{entityName: 'diagnosesAndProcedures', attributeName: 'itemType'},
	{entityName: 'diagnosesAndProcedures', attributeName: 'itemCode'},
	{entityName: 'diagnosesAndProcedures', attributeName: 'description'},
	{entityName: 'doctorSchedule', attributeName: 'startDateTime'},
	{entityName: 'doctorSchedule', attributeName: 'endDateTime'},
	{entityName: 'doctorSchedule', attributeName: 'schedulerType'},
	{entityName: 'examinationGroup', attributeName: 'diagnosticGroupCode'},
	{entityName: 'examinationGroup', attributeName: 'description'},
	{entityName: 'examinationItem', attributeName: 'itemCode'},
	{entityName: 'examinationItem', attributeName: 'description'},
	{entityName: 'examinationItemDetail', attributeName: 'ageMinimum'},
	{entityName: 'examinationItemDetail', attributeName: 'ageMaximum'},
	{entityName: 'examinationItemDetail', attributeName: 'gender'},
	{entityName: 'examinationItemDetail', attributeName: 'normalRangeLow'},
	{entityName: 'examinationItemDetail', attributeName: 'normalRangeHigh'},
	{entityName: 'examinationItemDetail', attributeName: 'unit'},
	{entityName: 'healthFacility', attributeName: 'healthFacilityID'},
	{entityName: 'healthFacility', attributeName: 'healthFacilityName'},
	{entityName: 'healthFacility', attributeName: 'address'},
	{entityName: 'hospitalBranchInformation', attributeName: 'hospitalCode'},
	{entityName: 'hospitalBranchInformation', attributeName: 'hospitalName'},
	{entityName: 'hospitalBranchInformation', attributeName: 'hospitalType'},
	{entityName: 'hospitalBranchInformation', attributeName: 'hospitalClass'},
	{entityName: 'hospitalBranchInformation', attributeName: 'hospitalDirectorName'},
	{entityName: 'hospitalBranchInformation', attributeName: 'address'},
	{entityName: 'hospitalBranchInformation', attributeName: 'city'},
	{entityName: 'hospitalGroupInformation', attributeName: 'hospitalGroupCode'},
	{entityName: 'hospitalGroupInformation', attributeName: 'hospitalGroupName'},
	{entityName: 'hospitalGroupInformation', attributeName: 'hospitalGroupCorporationName'},
	{entityName: 'hospitalGroupInformation', attributeName: 'hospitalGroupDirector'},
	{entityName: 'hospitalGroupInformation', attributeName: 'address'},
	{entityName: 'insuranceBenefitPlan', attributeName: 'benefitPlanNo'},
	{entityName: 'insuranceProvider', attributeName: 'providerCode'},
	{entityName: 'insuranceProvider', attributeName: 'providerName'},
	{entityName: 'insuranceProvider', attributeName: 'providerType'},
	{entityName: 'insuranceProvider', attributeName: 'benefitProvider'},
	{entityName: 'insuranceProvider', attributeName: 'firstName'},
	{entityName: 'insuranceProvider', attributeName: 'lastName'},
	{entityName: 'inventoryBatchCorrection', attributeName: 'transactionDate'},
	{entityName: 'inventoryBatchCorrection', attributeName: 'transactionType'},
	{entityName: 'invoice', attributeName: 'invoiceType'},
	{entityName: 'invoice', attributeName: 'invoiceDate'},
	{entityName: 'invoice', attributeName: 'billingLocation'},
	{entityName: 'invoice', attributeName: 'patientPaymentType'},
	{entityName: 'location', attributeName: 'locationName'},
	{entityName: 'mcuPackage', attributeName: 'mcuPackageCode'},
	{entityName: 'mcuPackage', attributeName: 'description'},
	{entityName: 'mcuPackage', attributeName: 'packageType'},
	{entityName: 'mcuPackageItem', attributeName: 'itemCode'},
	{entityName: 'medicationHeader', attributeName: 'medicationNumber'},
	{entityName: 'medicationHeader', attributeName: 'dispensingType'},
	{entityName: 'merchant', attributeName: 'merchantName'},
	{entityName: 'merchant', attributeName: 'merchantNumber'},
	{entityName: 'merchant', attributeName: 'bankAccount'},
	{entityName: 'merchantSurchargeAndFee', attributeName: 'bankName'},
	{entityName: 'merchantSurchargeAndFee', attributeName: 'cardType'},
	{entityName: 'merchantSurchargeAndFee', attributeName: 'surcharge'},
	{entityName: 'merchantSurchargeAndFee', attributeName: 'fee'},
	{entityName: 'pcareUmum', attributeName: 'consID'},
	{entityName: 'pcareUmum', attributeName: 'secretKey'},
	{entityName: 'pcareUmum', attributeName: 'webServiceURL'},
	{entityName: 'pcareUmum', attributeName: 'authUsername'},
	{entityName: 'pcareUmum', attributeName: 'authPassword'},
	{entityName: 'pcareUmum', attributeName: 'kodeAplikasi'},
	{entityName: 'patientDetail', attributeName: 'activePatientID'},
	{entityName: 'patientGeneralInfo', attributeName: 'patientID'},
	{entityName: 'patientGeneralInfo', attributeName: 'givenName'},
	{entityName: 'patientGeneralInfo', attributeName: 'lastName'},
	{entityName: 'patientGeneralInfo', attributeName: 'placeOfBirth'},
	{entityName: 'patientGeneralInfo', attributeName: 'dateOfBirth'},
	{entityName: 'patientGeneralInfo', attributeName: 'address'},
	{entityName: 'patientVisit', attributeName: 'visitNumber'},
	{entityName: 'patientVisit', attributeName: 'visitDate'},
	{entityName: 'patientVisit', attributeName: 'registrationLocation'},
	{entityName: 'prescriptionHeader', attributeName: 'prescriptionNumber'},
	{entityName: 'prescriptionHeader', attributeName: 'prescriptionType'},
	{entityName: 'priceComponent', attributeName: 'componentCode'},
	{entityName: 'priceComponent', attributeName: 'componentName'},
	{entityName: 'referenceData', attributeName: 'referenceType'},
	{entityName: 'referenceData', attributeName: 'code'},
	{entityName: 'referenceData', attributeName: 'description'},
	{entityName: 'referenceData', attributeName: 'sequence'},
	{entityName: 'referenceHeader', attributeName: 'referenceType'},
	{entityName: 'referenceHeader', attributeName: 'description'},
	{entityName: 'registration', attributeName: 'registrationNumber'},
	{entityName: 'registration', attributeName: 'scheduledDate'},
	{entityName: 'roomFacility', attributeName: 'roomNumber'},
	{entityName: 'roomFacility', attributeName: 'roomName'},
	{entityName: 'roomFacility', attributeName: 'department'},
	{entityName: 'roomFacility', attributeName: 'genderAllocation'},
	{entityName: 'roomFacility', attributeName: 'location'},
	{entityName: 'roomFacility', attributeName: 'treatmentClass'},
	{entityName: 'service', attributeName: 'serviceName'},
	{entityName: 'serviceItem', attributeName: 'serviceItemCode'},
	{entityName: 'serviceItem', attributeName: 'serviceItemName'},
	{entityName: 'serviceItem', attributeName: 'classification'},
	{entityName: 'staff', attributeName: 'firstName'},
	{entityName: 'staff', attributeName: 'lastName'},
	{entityName: 'supplier', attributeName: 'supplierNumber'},
	{entityName: 'supplier', attributeName: 'supplierName'},
	{entityName: 'supplier', attributeName: 'supplyStockGroup'},
	{entityName: 'supplier', attributeName: 'adress'},
	{entityName: 'supplier', attributeName: 'phoneNumber'},
	{entityName: 'supplierBankAccount', attributeName: 'bankName'},
	{entityName: 'supplierBankAccount', attributeName: 'accountName'},
	{entityName: 'supplierBankAccount', attributeName: 'accountNumber'},
	{entityName: 'tariffSchema', attributeName: 'schemaCode'},
	{entityName: 'tariffSchema', attributeName: 'schemeName'},
	{entityName: 'tariffSchema', attributeName: 'startDate'},
	{entityName: 'transactionDetailType', attributeName: 'transactionDetail'},
	{entityName: 'unitOfMeasurement', attributeName: 'unitName'},
	{entityName: 'user', attributeName: 'isArchived'},
	{entityName: 'vaccinationOrderDetail', attributeName: 'vaccinationDate'},
	{entityName: 'vaccinationOrderDetail', attributeName: 'vaccinationType'},
	{entityName: 'vaccinationOrderDetail', attributeName: 'vaccinationDetail'},
	{entityName: 'vaccinationOrderDetail', attributeName: 'quantity'},
	{entityName: 'warehouse', attributeName: 'warehouseNumber'},
	{entityName: 'warehouse', attributeName: 'warehouseName'},
	{entityName: 'warehouse', attributeName: 'description'},
	{entityName: 'warehouse', attributeName: 'address'},
	{entityName: 'warehouse', attributeName: 'contactPerson'},
	{entityName: 'warehouse', attributeName: 'phoneNumber'},
];

const rangeValidators = [
];

// Excludes length validators on attributes which also have other validators applied
const lengthValidators = [
	{entityName: 'bpjsDismissalMapping', attributeName: 'refCode', min: null, max: 25},
	{entityName: 'bpjsDismissalMapping', attributeName: 'refName', min: null, max: 50},
	{entityName: 'bpjsDoctorMapping', attributeName: 'refCode', min: null, max: 25},
	{entityName: 'bpjsDoctorMapping', attributeName: 'notes', min: null, max: 1000},
	{entityName: 'bpjsGeneral', attributeName: 'consID', min: 4, max: 15},
	{entityName: 'bpjsGeneral', attributeName: 'secretKey', min: null, max: 25},
	{entityName: 'bpjsGeneral', attributeName: 'healthFacilityCode', min: null, max: 25},
	{entityName: 'bpjsGeneral', attributeName: 'healthFacilityName', min: null, max: 100},
	{entityName: 'bpjsINACBG', attributeName: 'healthFacilityCode', min: null, max: 25},
	{entityName: 'bpjsINACBG', attributeName: 'healthFacilityName', min: null, max: 100},
	{entityName: 'bpjsINACBG', attributeName: 'stateProvince', min: null, max: 50},
	{entityName: 'bpjsINACBG', attributeName: 'cityRegency', min: null, max: 50},
	{entityName: 'bpjsINACBG', attributeName: 'regional', min: null, max: 50},
	{entityName: 'bpjsINACBG', attributeName: 'hospitalClass', min: null, max: 25},
	{entityName: 'bpjsINACBG', attributeName: 'inacbgTariff1', min: null, max: 100},
	{entityName: 'bpjsINACBG', attributeName: 'inacbgTariff2', min: null, max: 100},
	{entityName: 'bpjsINACBG', attributeName: 'additionalUpgradeVIP', min: null, max: 100},
	{entityName: 'bpjsINACBG', attributeName: 'payplanID', min: null, max: 100},
	{entityName: 'bpjsINACBG', attributeName: 'paymentPlanCode', min: null, max: 100},
	{entityName: 'bpjsINACBG', attributeName: 'tariffCode', min: null, max: 50},
	{entityName: 'bpjsINACBG', attributeName: 'username', min: null, max: 100},
	{entityName: 'bpjsINACBG', attributeName: 'password', min: null, max: 100},
	{entityName: 'bpjsINACBG', attributeName: 'secretKey', min: null, max: 225},
	{entityName: 'bpjsINACBG', attributeName: 'coderID', min: null, max: 100},
	{entityName: 'bpjsServiceMapping', attributeName: 'refCode', min: null, max: 25},
	{entityName: 'bpjsServiceMapping', attributeName: 'refService', min: null, max: 200},
	{entityName: 'bpjsTreatmentClassMapping', attributeName: 'refCode', min: null, max: 25},
	{entityName: 'bpjsTreatmentClassMapping', attributeName: 'refName', min: null, max: 50},
	{entityName: 'bpjsVisitData', attributeName: 'jsonInsert', min: null, max: 5000},
	{entityName: 'bpjsVisitData', attributeName: 'jsonUpdate', min: null, max: 5000},
	{entityName: 'cashReceipt', attributeName: 'description', min: null, max: 5000},
	{entityName: 'cashRefund', attributeName: 'description', min: null, max: 5000},
	{entityName: 'dailyCareCPPT', attributeName: 'subjective', min: null, max: 5000},
	{entityName: 'dailyCareCPPT', attributeName: 'objective', min: null, max: 5000},
	{entityName: 'dailyCareCPPT', attributeName: 'diagnose', min: null, max: 5000},
	{entityName: 'dailyCareCPPT', attributeName: 'plan', min: null, max: 5000},
	{entityName: 'dailyCareCPPT', attributeName: 'instruction', min: null, max: 5000},
	{entityName: 'diagnosisExaminationRecord', attributeName: 'diagnosisNotes', min: null, max: 5000},
	{entityName: 'diagnosisExaminationRecord', attributeName: 'actionNotes', min: null, max: 5000},
	{entityName: 'diagnosticExaminationResults', attributeName: 'result', min: null, max: 1000},
	{entityName: 'hemodialysisExamination', attributeName: 'postHemodialysisEvaluation', min: null, max: 500},
	{entityName: 'invoice', attributeName: 'billingLocation', min: null, max: 20},
	{entityName: 'invoice', attributeName: 'notes', min: null, max: 500},
	{entityName: 'invoiceItem', attributeName: 'notes', min: null, max: 500},
	{entityName: 'medicalExaminationRecord', attributeName: 'objective', min: null, max: 5000},
	{entityName: 'medicalExaminationRecord', attributeName: 'subjective', min: null, max: 5000},
	{entityName: 'medicalExaminationRecord', attributeName: 'plan', min: null, max: 5000},
	{entityName: 'medicalExaminationRecord', attributeName: 'purpose', min: null, max: 5000},
	{entityName: 'medicalExaminationRecord', attributeName: 'additionalNotes', min: null, max: 5000},
	{entityName: 'medicalExaminationRecordDischargeSummary', attributeName: 'objective', min: null, max: 5000},
	{entityName: 'medicalExaminationRecordDischargeSummary', attributeName: 'subjective', min: null, max: 5000},
	{entityName: 'medicalExaminationRecordDischargeSummary', attributeName: 'plan', min: null, max: 5000},
	{entityName: 'medicalExaminationRecordDischargeSummary', attributeName: 'purpose', min: null, max: 5000},
	{entityName: 'medicalExaminationRecordDischargeSummary', attributeName: 'additionalNotes', min: null, max: 5000},
	{entityName: 'pcareExamination', attributeName: 'catatan', min: null, max: 1000},
	{entityName: 'pcareExamination', attributeName: 'jsoninsert', min: null, max: 5000},
	{entityName: 'pcareExamination', attributeName: 'jsonupdate', min: null, max: 5000},
	{entityName: 'pcareUmum', attributeName: 'consID', min: 4, max: 15},
	{entityName: 'pcareUmum', attributeName: 'secretKey', min: null, max: 25},
	{entityName: 'satuSehatConfiguration', attributeName: 'clientID', min: null, max: 1000},
	{entityName: 'satuSehatConfiguration', attributeName: 'secretKey', min: null, max: 1000},
	{entityName: 'satuSehatConfiguration', attributeName: 'tokenRequest', min: null, max: 1000},
	{entityName: 'user', attributeName: 'password', min: 10, max: 255},
	{entityName: 'warehouse', attributeName: 'description', min: null, max: 2000},
];

const numericValidators = [
	{entityName: 'catalogueUOM', attributeName: 'conversion', min: null, max: null},
	{entityName: 'supplier', attributeName: 'phoneNumber', min: null, max: null},
	{entityName: 'supplier', attributeName: 'otherPhoneNumber', min: null, max: null},
	{entityName: 'supplier', attributeName: 'fax', min: null, max: null},
	{entityName: 'supplierBankAccount', attributeName: 'accountNumber', min: null, max: null},
	{entityName: 'supplierContactDetail', attributeName: 'phoneNumber', min: null, max: null},
	{entityName: 'supplierContactDetail', attributeName: 'mobilePhoneNumber', min: null, max: null},
	{entityName: 'supplierContactDetail', attributeName: 'ext', min: null, max: null},
	{entityName: 'warehouse', attributeName: 'phoneNumber', min: null, max: null},
	{entityName: 'warehouse', attributeName: 'mobilePhoneNumber', min: null, max: null},
];

const alphanumericValidators = [
];

const urlValidators = [
	{entityName: 'diagnosticSupportGeneralConfiguration', attributeName: 'lisWebServiceURL'},
];

const emailValidators = [
	{entityName: 'supplier', attributeName: 'email'},
	{entityName: 'supplierContactDetail', attributeName: 'email'},
	{entityName: 'user', attributeName: 'username'},
	{entityName: 'warehouse', attributeName: 'email'},
];

const uuidValidators = [
];

// % protected region % [Add any additional constants here] off begin
// % protected region % [Add any additional constants here] end

describe('Crud Create Edit Tests', () => {
	let modelForm: FormGroup;
	let modelProperties: ModelProperty[];
	let modelRelations: ModelRelation[];

	let fixture: ComponentFixture<CrudCreateEditComponent<any, any>>;
	let crudElement: CrudCreateEditComponent<any, any>;
	let formGroup: DebugElement;

	// % protected region % [Add any additional test class methods here] off begin
	// % protected region % [Add any additional test class methods here] end

	function createTestingComponent(entityName: string) {
		let model;
		switch (entityName) {
			case 'administrationUser':
				model = new AdministrationUserModel();
				modelProperties = AdministrationUserModel.getProps();
				modelRelations = AdministrationUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<AdministrationUserModel,
				AdministrationUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'administrator':
				model = new AdministratorModel();
				modelProperties = AdministratorModel.getProps();
				modelRelations = AdministratorModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<AdministratorModel,
				AdministratorModelAudit>>(CrudCreateEditComponent);
				break;

			case 'amendmentDetail':
				model = new AmendmentDetailModel();
				modelProperties = AmendmentDetailModel.getProps();
				modelRelations = AmendmentDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<AmendmentDetailModel,
				AmendmentDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsAccidentMaster':
				model = new BpjsAccidentMasterModel();
				modelProperties = BpjsAccidentMasterModel.getProps();
				modelRelations = BpjsAccidentMasterModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsAccidentMasterModel,
				BpjsAccidentMasterModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsBedAvailability':
				model = new BpjsBedAvailabilityModel();
				modelProperties = BpjsBedAvailabilityModel.getProps();
				modelRelations = BpjsBedAvailabilityModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsBedAvailabilityModel,
				BpjsBedAvailabilityModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsClaimData':
				model = new BpjsClaimDataModel();
				modelProperties = BpjsClaimDataModel.getProps();
				modelRelations = BpjsClaimDataModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsClaimDataModel,
				BpjsClaimDataModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsClaimSubmission':
				model = new BpjsClaimSubmissionModel();
				modelProperties = BpjsClaimSubmissionModel.getProps();
				modelRelations = BpjsClaimSubmissionModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsClaimSubmissionModel,
				BpjsClaimSubmissionModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsControlPlan':
				model = new BpjsControlPlanModel();
				modelProperties = BpjsControlPlanModel.getProps();
				modelRelations = BpjsControlPlanModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsControlPlanModel,
				BpjsControlPlanModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsControlSpecialist':
				model = new BpjsControlSpecialistModel();
				modelProperties = BpjsControlSpecialistModel.getProps();
				modelRelations = BpjsControlSpecialistModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsControlSpecialistModel,
				BpjsControlSpecialistModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsDiagnose':
				model = new BpjsDiagnoseModel();
				modelProperties = BpjsDiagnoseModel.getProps();
				modelRelations = BpjsDiagnoseModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsDiagnoseModel,
				BpjsDiagnoseModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsDiagnosePRB':
				model = new BpjsDiagnosePRBModel();
				modelProperties = BpjsDiagnosePRBModel.getProps();
				modelRelations = BpjsDiagnosePRBModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsDiagnosePRBModel,
				BpjsDiagnosePRBModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsDismissalCondition':
				model = new BpjsDismissalConditionModel();
				modelProperties = BpjsDismissalConditionModel.getProps();
				modelRelations = BpjsDismissalConditionModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsDismissalConditionModel,
				BpjsDismissalConditionModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsDismissalMapping':
				model = new BpjsDismissalMappingModel();
				modelProperties = BpjsDismissalMappingModel.getProps();
				modelRelations = BpjsDismissalMappingModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsDismissalMappingModel,
				BpjsDismissalMappingModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsDoctorMapping':
				model = new BpjsDoctorMappingModel();
				modelProperties = BpjsDoctorMappingModel.getProps();
				modelRelations = BpjsDoctorMappingModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsDoctorMappingModel,
				BpjsDoctorMappingModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsDoctorSchedule':
				model = new BpjsDoctorScheduleModel();
				modelProperties = BpjsDoctorScheduleModel.getProps();
				modelRelations = BpjsDoctorScheduleModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsDoctorScheduleModel,
				BpjsDoctorScheduleModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsDrugGenericPRB':
				model = new BpjsDrugGenericPRBModel();
				modelProperties = BpjsDrugGenericPRBModel.getProps();
				modelRelations = BpjsDrugGenericPRBModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsDrugGenericPRBModel,
				BpjsDrugGenericPRBModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsFacilityList':
				model = new BpjsFacilityListModel();
				modelProperties = BpjsFacilityListModel.getProps();
				modelRelations = BpjsFacilityListModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsFacilityListModel,
				BpjsFacilityListModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsFingerPrint':
				model = new BpjsFingerPrintModel();
				modelProperties = BpjsFingerPrintModel.getProps();
				modelRelations = BpjsFingerPrintModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsFingerPrintModel,
				BpjsFingerPrintModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsGeneral':
				model = new BpjsGeneralModel();
				modelProperties = BpjsGeneralModel.getProps();
				modelRelations = BpjsGeneralModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsGeneralModel,
				BpjsGeneralModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsHealthFacility':
				model = new BpjsHealthFacilityModel();
				modelProperties = BpjsHealthFacilityModel.getProps();
				modelRelations = BpjsHealthFacilityModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsHealthFacilityModel,
				BpjsHealthFacilityModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsHospitalizationPlan':
				model = new BpjsHospitalizationPlanModel();
				modelProperties = BpjsHospitalizationPlanModel.getProps();
				modelRelations = BpjsHospitalizationPlanModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsHospitalizationPlanModel,
				BpjsHospitalizationPlanModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsINACBG':
				model = new BpjsINACBGModel();
				modelProperties = BpjsINACBGModel.getProps();
				modelRelations = BpjsINACBGModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsINACBGModel,
				BpjsINACBGModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsINACBGClaim':
				model = new BpjsINACBGClaimModel();
				modelProperties = BpjsINACBGClaimModel.getProps();
				modelRelations = BpjsINACBGClaimModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsINACBGClaimModel,
				BpjsINACBGClaimModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsINACBGVariable':
				model = new BpjsINACBGVariableModel();
				modelProperties = BpjsINACBGVariableModel.getProps();
				modelRelations = BpjsINACBGVariableModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsINACBGVariableModel,
				BpjsINACBGVariableModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsJasaRaharja':
				model = new BpjsJasaRaharjaModel();
				modelProperties = BpjsJasaRaharjaModel.getProps();
				modelRelations = BpjsJasaRaharjaModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsJasaRaharjaModel,
				BpjsJasaRaharjaModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsJasaRaharjaClaim':
				model = new BpjsJasaRaharjaClaimModel();
				modelProperties = BpjsJasaRaharjaClaimModel.getProps();
				modelRelations = BpjsJasaRaharjaClaimModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsJasaRaharjaClaimModel,
				BpjsJasaRaharjaClaimModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsListFingerPrint':
				model = new BpjsListFingerPrintModel();
				modelProperties = BpjsListFingerPrintModel.getProps();
				modelRelations = BpjsListFingerPrintModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsListFingerPrintModel,
				BpjsListFingerPrintModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsListTask':
				model = new BpjsListTaskModel();
				modelProperties = BpjsListTaskModel.getProps();
				modelRelations = BpjsListTaskModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsListTaskModel,
				BpjsListTaskModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsOutsideFacilityReferral':
				model = new BpjsOutsideFacilityReferralModel();
				modelProperties = BpjsOutsideFacilityReferralModel.getProps();
				modelRelations = BpjsOutsideFacilityReferralModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsOutsideFacilityReferralModel,
				BpjsOutsideFacilityReferralModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPRB':
				model = new BpjsPRBModel();
				modelProperties = BpjsPRBModel.getProps();
				modelRelations = BpjsPRBModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPRBModel,
				BpjsPRBModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPRBDetail':
				model = new BpjsPRBDetailModel();
				modelProperties = BpjsPRBDetailModel.getProps();
				modelRelations = BpjsPRBDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPRBDetailModel,
				BpjsPRBDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPatientReferral':
				model = new BpjsPatientReferralModel();
				modelProperties = BpjsPatientReferralModel.getProps();
				modelRelations = BpjsPatientReferralModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPatientReferralModel,
				BpjsPatientReferralModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPcareDPHO':
				model = new BpjsPcareDPHOModel();
				modelProperties = BpjsPcareDPHOModel.getProps();
				modelRelations = BpjsPcareDPHOModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPcareDPHOModel,
				BpjsPcareDPHOModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPcareKegiatanKelompok':
				model = new BpjsPcareKegiatanKelompokModel();
				modelProperties = BpjsPcareKegiatanKelompokModel.getProps();
				modelRelations = BpjsPcareKegiatanKelompokModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPcareKegiatanKelompokModel,
				BpjsPcareKegiatanKelompokModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPcareKesadaran':
				model = new BpjsPcareKesadaranModel();
				modelProperties = BpjsPcareKesadaranModel.getProps();
				modelRelations = BpjsPcareKesadaranModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPcareKesadaranModel,
				BpjsPcareKesadaranModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPcarePesertaKegiatanKelompok':
				model = new BpjsPcarePesertaKegiatanKelompokModel();
				modelProperties = BpjsPcarePesertaKegiatanKelompokModel.getProps();
				modelRelations = BpjsPcarePesertaKegiatanKelompokModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPcarePesertaKegiatanKelompokModel,
				BpjsPcarePesertaKegiatanKelompokModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPcarePoli':
				model = new BpjsPcarePoliModel();
				modelProperties = BpjsPcarePoliModel.getProps();
				modelRelations = BpjsPcarePoliModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPcarePoliModel,
				BpjsPcarePoliModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPcareProviderRayonisasi':
				model = new BpjsPcareProviderRayonisasiModel();
				modelProperties = BpjsPcareProviderRayonisasiModel.getProps();
				modelRelations = BpjsPcareProviderRayonisasiModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPcareProviderRayonisasiModel,
				BpjsPcareProviderRayonisasiModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPcareRegistrations':
				model = new BpjsPcareRegistrationsModel();
				modelProperties = BpjsPcareRegistrationsModel.getProps();
				modelRelations = BpjsPcareRegistrationsModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPcareRegistrationsModel,
				BpjsPcareRegistrationsModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsProcedure':
				model = new BpjsProcedureModel();
				modelProperties = BpjsProcedureModel.getProps();
				modelRelations = BpjsProcedureModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsProcedureModel,
				BpjsProcedureModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsReferralSpecialist':
				model = new BpjsReferralSpecialistModel();
				modelProperties = BpjsReferralSpecialistModel.getProps();
				modelRelations = BpjsReferralSpecialistModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsReferralSpecialistModel,
				BpjsReferralSpecialistModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsSEP':
				model = new BpjsSEPModel();
				modelProperties = BpjsSEPModel.getProps();
				modelRelations = BpjsSEPModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsSEPModel,
				BpjsSEPModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsSEPINACBGIntegration':
				model = new BpjsSEPINACBGIntegrationModel();
				modelProperties = BpjsSEPINACBGIntegrationModel.getProps();
				modelRelations = BpjsSEPINACBGIntegrationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsSEPINACBGIntegrationModel,
				BpjsSEPINACBGIntegrationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsSEPInternalData':
				model = new BpjsSEPInternalDataModel();
				modelProperties = BpjsSEPInternalDataModel.getProps();
				modelRelations = BpjsSEPInternalDataModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsSEPInternalDataModel,
				BpjsSEPInternalDataModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsSEPSubmission':
				model = new BpjsSEPSubmissionModel();
				modelProperties = BpjsSEPSubmissionModel.getProps();
				modelRelations = BpjsSEPSubmissionModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsSEPSubmissionModel,
				BpjsSEPSubmissionModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsSearchControlLetter':
				model = new BpjsSearchControlLetterModel();
				modelProperties = BpjsSearchControlLetterModel.getProps();
				modelRelations = BpjsSearchControlLetterModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsSearchControlLetterModel,
				BpjsSearchControlLetterModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsSearchSEP':
				model = new BpjsSearchSEPModel();
				modelProperties = BpjsSearchSEPModel.getProps();
				modelRelations = BpjsSearchSEPModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsSearchSEPModel,
				BpjsSearchSEPModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsServiceMapping':
				model = new BpjsServiceMappingModel();
				modelProperties = BpjsServiceMappingModel.getProps();
				modelRelations = BpjsServiceMappingModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsServiceMappingModel,
				BpjsServiceMappingModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsSpecialReferral':
				model = new BpjsSpecialReferralModel();
				modelProperties = BpjsSpecialReferralModel.getProps();
				modelRelations = BpjsSpecialReferralModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsSpecialReferralModel,
				BpjsSpecialReferralModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsTotalReferralSEP':
				model = new BpjsTotalReferralSEPModel();
				modelProperties = BpjsTotalReferralSEPModel.getProps();
				modelRelations = BpjsTotalReferralSEPModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsTotalReferralSEPModel,
				BpjsTotalReferralSEPModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsTreatmentClassMapping':
				model = new BpjsTreatmentClassMappingModel();
				modelProperties = BpjsTreatmentClassMappingModel.getProps();
				modelRelations = BpjsTreatmentClassMappingModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsTreatmentClassMappingModel,
				BpjsTreatmentClassMappingModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsTreatmentHistory':
				model = new BpjsTreatmentHistoryModel();
				modelProperties = BpjsTreatmentHistoryModel.getProps();
				modelRelations = BpjsTreatmentHistoryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsTreatmentHistoryModel,
				BpjsTreatmentHistoryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsTreatmentRoom':
				model = new BpjsTreatmentRoomModel();
				modelProperties = BpjsTreatmentRoomModel.getProps();
				modelRelations = BpjsTreatmentRoomModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsTreatmentRoomModel,
				BpjsTreatmentRoomModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsUpdateDismissalDate':
				model = new BpjsUpdateDismissalDateModel();
				modelProperties = BpjsUpdateDismissalDateModel.getProps();
				modelRelations = BpjsUpdateDismissalDateModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsUpdateDismissalDateModel,
				BpjsUpdateDismissalDateModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsVisitData':
				model = new BpjsVisitDataModel();
				modelProperties = BpjsVisitDataModel.getProps();
				modelRelations = BpjsVisitDataModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsVisitDataModel,
				BpjsVisitDataModelAudit>>(CrudCreateEditComponent);
				break;

			case 'batchStockBalance':
				model = new BatchStockBalanceModel();
				modelProperties = BatchStockBalanceModel.getProps();
				modelRelations = BatchStockBalanceModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BatchStockBalanceModel,
				BatchStockBalanceModelAudit>>(CrudCreateEditComponent);
				break;

			case 'batchStockBalancePerDate':
				model = new BatchStockBalancePerDateModel();
				modelProperties = BatchStockBalancePerDateModel.getProps();
				modelRelations = BatchStockBalancePerDateModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BatchStockBalancePerDateModel,
				BatchStockBalancePerDateModelAudit>>(CrudCreateEditComponent);
				break;

			case 'batchStockTransactionDetail':
				model = new BatchStockTransactionDetailModel();
				modelProperties = BatchStockTransactionDetailModel.getProps();
				modelRelations = BatchStockTransactionDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BatchStockTransactionDetailModel,
				BatchStockTransactionDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bedFacility':
				model = new BedFacilityModel();
				modelProperties = BedFacilityModel.getProps();
				modelRelations = BedFacilityModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BedFacilityModel,
				BedFacilityModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bedReserve':
				model = new BedReserveModel();
				modelProperties = BedReserveModel.getProps();
				modelRelations = BedReserveModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BedReserveModel,
				BedReserveModelAudit>>(CrudCreateEditComponent);
				break;

			case 'birthHistory':
				model = new BirthHistoryModel();
				modelProperties = BirthHistoryModel.getProps();
				modelRelations = BirthHistoryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BirthHistoryModel,
				BirthHistoryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bodyChartExamination':
				model = new BodyChartExaminationModel();
				modelProperties = BodyChartExaminationModel.getProps();
				modelRelations = BodyChartExaminationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BodyChartExaminationModel,
				BodyChartExaminationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPcareKunjunganRujukan':
				model = new BpjsPcareKunjunganRujukanModel();
				modelProperties = BpjsPcareKunjunganRujukanModel.getProps();
				modelRelations = BpjsPcareKunjunganRujukanModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPcareKunjunganRujukanModel,
				BpjsPcareKunjunganRujukanModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPcarePendaftaran':
				model = new BpjsPcarePendaftaranModel();
				modelProperties = BpjsPcarePendaftaranModel.getProps();
				modelRelations = BpjsPcarePendaftaranModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPcarePendaftaranModel,
				BpjsPcarePendaftaranModelAudit>>(CrudCreateEditComponent);
				break;

			case 'bpjsPcareRiwayatKunjungan':
				model = new BpjsPcareRiwayatKunjunganModel();
				modelProperties = BpjsPcareRiwayatKunjunganModel.getProps();
				modelRelations = BpjsPcareRiwayatKunjunganModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<BpjsPcareRiwayatKunjunganModel,
				BpjsPcareRiwayatKunjunganModelAudit>>(CrudCreateEditComponent);
				break;

			case 'cashAllocation':
				model = new CashAllocationModel();
				modelProperties = CashAllocationModel.getProps();
				modelRelations = CashAllocationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<CashAllocationModel,
				CashAllocationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'cashReceipt':
				model = new CashReceiptModel();
				modelProperties = CashReceiptModel.getProps();
				modelRelations = CashReceiptModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<CashReceiptModel,
				CashReceiptModelAudit>>(CrudCreateEditComponent);
				break;

			case 'cashRefund':
				model = new CashRefundModel();
				modelProperties = CashRefundModel.getProps();
				modelRelations = CashRefundModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<CashRefundModel,
				CashRefundModelAudit>>(CrudCreateEditComponent);
				break;

			case 'cashierUser':
				model = new CashierUserModel();
				modelProperties = CashierUserModel.getProps();
				modelRelations = CashierUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<CashierUserModel,
				CashierUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'catalogueMedical':
				model = new CatalogueMedicalModel();
				modelProperties = CatalogueMedicalModel.getProps();
				modelRelations = CatalogueMedicalModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<CatalogueMedicalModel,
				CatalogueMedicalModelAudit>>(CrudCreateEditComponent);
				break;

			case 'catalogueNonMedical':
				model = new CatalogueNonMedicalModel();
				modelProperties = CatalogueNonMedicalModel.getProps();
				modelRelations = CatalogueNonMedicalModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<CatalogueNonMedicalModel,
				CatalogueNonMedicalModelAudit>>(CrudCreateEditComponent);
				break;

			case 'catalogueUOM':
				model = new CatalogueUOMModel();
				modelProperties = CatalogueUOMModel.getProps();
				modelRelations = CatalogueUOMModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<CatalogueUOMModel,
				CatalogueUOMModelAudit>>(CrudCreateEditComponent);
				break;

			case 'chartOfAccount':
				model = new ChartOfAccountModel();
				modelProperties = ChartOfAccountModel.getProps();
				modelRelations = ChartOfAccountModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ChartOfAccountModel,
				ChartOfAccountModelAudit>>(CrudCreateEditComponent);
				break;

			case 'chartOfAccountMapping':
				model = new ChartOfAccountMappingModel();
				modelProperties = ChartOfAccountMappingModel.getProps();
				modelRelations = ChartOfAccountMappingModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ChartOfAccountMappingModel,
				ChartOfAccountMappingModelAudit>>(CrudCreateEditComponent);
				break;

			case 'claimUser':
				model = new ClaimUserModel();
				modelProperties = ClaimUserModel.getProps();
				modelRelations = ClaimUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ClaimUserModel,
				ClaimUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'coTreatingDoctor':
				model = new CoTreatingDoctorModel();
				modelProperties = CoTreatingDoctorModel.getProps();
				modelRelations = CoTreatingDoctorModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<CoTreatingDoctorModel,
				CoTreatingDoctorModelAudit>>(CrudCreateEditComponent);
				break;

			case 'compoundPrescriptionDetail':
				model = new CompoundPrescriptionDetailModel();
				modelProperties = CompoundPrescriptionDetailModel.getProps();
				modelRelations = CompoundPrescriptionDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<CompoundPrescriptionDetailModel,
				CompoundPrescriptionDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'compoundPrescriptionItem':
				model = new CompoundPrescriptionItemModel();
				modelProperties = CompoundPrescriptionItemModel.getProps();
				modelRelations = CompoundPrescriptionItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<CompoundPrescriptionItemModel,
				CompoundPrescriptionItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'dailyCareCPPT':
				model = new DailyCareCPPTModel();
				modelProperties = DailyCareCPPTModel.getProps();
				modelRelations = DailyCareCPPTModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DailyCareCPPTModel,
				DailyCareCPPTModelAudit>>(CrudCreateEditComponent);
				break;

			case 'deliveryMedicalExaminationRecord':
				model = new DeliveryMedicalExaminationRecordModel();
				modelProperties = DeliveryMedicalExaminationRecordModel.getProps();
				modelRelations = DeliveryMedicalExaminationRecordModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DeliveryMedicalExaminationRecordModel,
				DeliveryMedicalExaminationRecordModelAudit>>(CrudCreateEditComponent);
				break;

			case 'deliveryProgress':
				model = new DeliveryProgressModel();
				modelProperties = DeliveryProgressModel.getProps();
				modelRelations = DeliveryProgressModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DeliveryProgressModel,
				DeliveryProgressModelAudit>>(CrudCreateEditComponent);
				break;

			case 'diagnosesAndProcedures':
				model = new DiagnosesAndProceduresModel();
				modelProperties = DiagnosesAndProceduresModel.getProps();
				modelRelations = DiagnosesAndProceduresModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DiagnosesAndProceduresModel,
				DiagnosesAndProceduresModelAudit>>(CrudCreateEditComponent);
				break;

			case 'diagnosisExaminationRecord':
				model = new DiagnosisExaminationRecordModel();
				modelProperties = DiagnosisExaminationRecordModel.getProps();
				modelRelations = DiagnosisExaminationRecordModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DiagnosisExaminationRecordModel,
				DiagnosisExaminationRecordModelAudit>>(CrudCreateEditComponent);
				break;

			case 'diagnosisNanda':
				model = new DiagnosisNandaModel();
				modelProperties = DiagnosisNandaModel.getProps();
				modelRelations = DiagnosisNandaModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DiagnosisNandaModel,
				DiagnosisNandaModelAudit>>(CrudCreateEditComponent);
				break;

			case 'diagnosticExaminationResults':
				model = new DiagnosticExaminationResultsModel();
				modelProperties = DiagnosticExaminationResultsModel.getProps();
				modelRelations = DiagnosticExaminationResultsModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DiagnosticExaminationResultsModel,
				DiagnosticExaminationResultsModelAudit>>(CrudCreateEditComponent);
				break;

			case 'diagnosticStaffExaminationSummary':
				model = new DiagnosticStaffExaminationSummaryModel();
				modelProperties = DiagnosticStaffExaminationSummaryModel.getProps();
				modelRelations = DiagnosticStaffExaminationSummaryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DiagnosticStaffExaminationSummaryModel,
				DiagnosticStaffExaminationSummaryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'diagnosticSupportGeneralConfiguration':
				model = new DiagnosticSupportGeneralConfigurationModel();
				modelProperties = DiagnosticSupportGeneralConfigurationModel.getProps();
				modelRelations = DiagnosticSupportGeneralConfigurationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DiagnosticSupportGeneralConfigurationModel,
				DiagnosticSupportGeneralConfigurationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'diagnosticSupportUser':
				model = new DiagnosticSupportUserModel();
				modelProperties = DiagnosticSupportUserModel.getProps();
				modelRelations = DiagnosticSupportUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DiagnosticSupportUserModel,
				DiagnosticSupportUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'doctorSchedule':
				model = new DoctorScheduleModel();
				modelProperties = DoctorScheduleModel.getProps();
				modelRelations = DoctorScheduleModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DoctorScheduleModel,
				DoctorScheduleModelAudit>>(CrudCreateEditComponent);
				break;

			case 'doctorUser':
				model = new DoctorUserModel();
				modelProperties = DoctorUserModel.getProps();
				modelRelations = DoctorUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<DoctorUserModel,
				DoctorUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'entExamination':
				model = new EntExaminationModel();
				modelProperties = EntExaminationModel.getProps();
				modelRelations = EntExaminationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<EntExaminationModel,
				EntExaminationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'emergencyMedicalExaminationRecord':
				model = new EmergencyMedicalExaminationRecordModel();
				modelProperties = EmergencyMedicalExaminationRecordModel.getProps();
				modelRelations = EmergencyMedicalExaminationRecordModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<EmergencyMedicalExaminationRecordModel,
				EmergencyMedicalExaminationRecordModelAudit>>(CrudCreateEditComponent);
				break;

			case 'examinationGroup':
				model = new ExaminationGroupModel();
				modelProperties = ExaminationGroupModel.getProps();
				modelRelations = ExaminationGroupModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ExaminationGroupModel,
				ExaminationGroupModelAudit>>(CrudCreateEditComponent);
				break;

			case 'examinationItem':
				model = new ExaminationItemModel();
				modelProperties = ExaminationItemModel.getProps();
				modelRelations = ExaminationItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ExaminationItemModel,
				ExaminationItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'examinationItemDetail':
				model = new ExaminationItemDetailModel();
				modelProperties = ExaminationItemDetailModel.getProps();
				modelRelations = ExaminationItemDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ExaminationItemDetailModel,
				ExaminationItemDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'facilityHistory':
				model = new FacilityHistoryModel();
				modelProperties = FacilityHistoryModel.getProps();
				modelRelations = FacilityHistoryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<FacilityHistoryModel,
				FacilityHistoryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'facilityUser':
				model = new FacilityUserModel();
				modelProperties = FacilityUserModel.getProps();
				modelRelations = FacilityUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<FacilityUserModel,
				FacilityUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'fluidBalanceDetail':
				model = new FluidBalanceDetailModel();
				modelProperties = FluidBalanceDetailModel.getProps();
				modelRelations = FluidBalanceDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<FluidBalanceDetailModel,
				FluidBalanceDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'formulirKonselingTesHiv':
				model = new FormulirKonselingTesHivModel();
				modelProperties = FormulirKonselingTesHivModel.getProps();
				modelRelations = FormulirKonselingTesHivModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<FormulirKonselingTesHivModel,
				FormulirKonselingTesHivModelAudit>>(CrudCreateEditComponent);
				break;

			case 'goodsReceiveNote':
				model = new GoodsReceiveNoteModel();
				modelProperties = GoodsReceiveNoteModel.getProps();
				modelRelations = GoodsReceiveNoteModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<GoodsReceiveNoteModel,
				GoodsReceiveNoteModelAudit>>(CrudCreateEditComponent);
				break;

			case 'goodsReceiveNoteBatch':
				model = new GoodsReceiveNoteBatchModel();
				modelProperties = GoodsReceiveNoteBatchModel.getProps();
				modelRelations = GoodsReceiveNoteBatchModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<GoodsReceiveNoteBatchModel,
				GoodsReceiveNoteBatchModelAudit>>(CrudCreateEditComponent);
				break;

			case 'goodsReceiveNoteItem':
				model = new GoodsReceiveNoteItemModel();
				modelProperties = GoodsReceiveNoteItemModel.getProps();
				modelRelations = GoodsReceiveNoteItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<GoodsReceiveNoteItemModel,
				GoodsReceiveNoteItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'healthFacility':
				model = new HealthFacilityModel();
				modelProperties = HealthFacilityModel.getProps();
				modelRelations = HealthFacilityModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<HealthFacilityModel,
				HealthFacilityModelAudit>>(CrudCreateEditComponent);
				break;

			case 'hemodialysisExamination':
				model = new HemodialysisExaminationModel();
				modelProperties = HemodialysisExaminationModel.getProps();
				modelRelations = HemodialysisExaminationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<HemodialysisExaminationModel,
				HemodialysisExaminationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'hemodialysisMonitoring':
				model = new HemodialysisMonitoringModel();
				modelProperties = HemodialysisMonitoringModel.getProps();
				modelRelations = HemodialysisMonitoringModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<HemodialysisMonitoringModel,
				HemodialysisMonitoringModelAudit>>(CrudCreateEditComponent);
				break;

			case 'hospitalBranchInformation':
				model = new HospitalBranchInformationModel();
				modelProperties = HospitalBranchInformationModel.getProps();
				modelRelations = HospitalBranchInformationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<HospitalBranchInformationModel,
				HospitalBranchInformationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'hospitalGroupInformation':
				model = new HospitalGroupInformationModel();
				modelProperties = HospitalGroupInformationModel.getProps();
				modelRelations = HospitalGroupInformationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<HospitalGroupInformationModel,
				HospitalGroupInformationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'icd10':
				model = new Icd10Model();
				modelProperties = Icd10Model.getProps();
				modelRelations = Icd10Model.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<Icd10Model,
				Icd10ModelAudit>>(CrudCreateEditComponent);
				break;

			case 'icd9CM':
				model = new Icd9CMModel();
				modelProperties = Icd9CMModel.getProps();
				modelRelations = Icd9CMModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<Icd9CMModel,
				Icd9CMModelAudit>>(CrudCreateEditComponent);
				break;

			case 'informedConsent':
				model = new InformedConsentModel();
				modelProperties = InformedConsentModel.getProps();
				modelRelations = InformedConsentModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InformedConsentModel,
				InformedConsentModelAudit>>(CrudCreateEditComponent);
				break;

			case 'inpatientMedicalExaminationRecord':
				model = new InpatientMedicalExaminationRecordModel();
				modelProperties = InpatientMedicalExaminationRecordModel.getProps();
				modelRelations = InpatientMedicalExaminationRecordModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InpatientMedicalExaminationRecordModel,
				InpatientMedicalExaminationRecordModelAudit>>(CrudCreateEditComponent);
				break;

			case 'insuranceBenefitPlan':
				model = new InsuranceBenefitPlanModel();
				modelProperties = InsuranceBenefitPlanModel.getProps();
				modelRelations = InsuranceBenefitPlanModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InsuranceBenefitPlanModel,
				InsuranceBenefitPlanModelAudit>>(CrudCreateEditComponent);
				break;

			case 'insuranceProvider':
				model = new InsuranceProviderModel();
				modelProperties = InsuranceProviderModel.getProps();
				modelRelations = InsuranceProviderModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InsuranceProviderModel,
				InsuranceProviderModelAudit>>(CrudCreateEditComponent);
				break;

			case 'internalOrder':
				model = new InternalOrderModel();
				modelProperties = InternalOrderModel.getProps();
				modelRelations = InternalOrderModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InternalOrderModel,
				InternalOrderModelAudit>>(CrudCreateEditComponent);
				break;

			case 'internalOrderStockDetail':
				model = new InternalOrderStockDetailModel();
				modelProperties = InternalOrderStockDetailModel.getProps();
				modelRelations = InternalOrderStockDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InternalOrderStockDetailModel,
				InternalOrderStockDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'intraoperativeRecords':
				model = new IntraoperativeRecordsModel();
				modelProperties = IntraoperativeRecordsModel.getProps();
				modelRelations = IntraoperativeRecordsModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<IntraoperativeRecordsModel,
				IntraoperativeRecordsModelAudit>>(CrudCreateEditComponent);
				break;

			case 'inventoryAdjusmentBatch':
				model = new InventoryAdjusmentBatchModel();
				modelProperties = InventoryAdjusmentBatchModel.getProps();
				modelRelations = InventoryAdjusmentBatchModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InventoryAdjusmentBatchModel,
				InventoryAdjusmentBatchModelAudit>>(CrudCreateEditComponent);
				break;

			case 'inventoryAdjustment':
				model = new InventoryAdjustmentModel();
				modelProperties = InventoryAdjustmentModel.getProps();
				modelRelations = InventoryAdjustmentModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InventoryAdjustmentModel,
				InventoryAdjustmentModelAudit>>(CrudCreateEditComponent);
				break;

			case 'inventoryAdjustmentItem':
				model = new InventoryAdjustmentItemModel();
				modelProperties = InventoryAdjustmentItemModel.getProps();
				modelRelations = InventoryAdjustmentItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InventoryAdjustmentItemModel,
				InventoryAdjustmentItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'inventoryBatchCorrection':
				model = new InventoryBatchCorrectionModel();
				modelProperties = InventoryBatchCorrectionModel.getProps();
				modelRelations = InventoryBatchCorrectionModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InventoryBatchCorrectionModel,
				InventoryBatchCorrectionModelAudit>>(CrudCreateEditComponent);
				break;

			case 'inventoryBatchCorrectionItem':
				model = new InventoryBatchCorrectionItemModel();
				modelProperties = InventoryBatchCorrectionItemModel.getProps();
				modelRelations = InventoryBatchCorrectionItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InventoryBatchCorrectionItemModel,
				InventoryBatchCorrectionItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'invoice':
				model = new InvoiceModel();
				modelProperties = InvoiceModel.getProps();
				modelRelations = InvoiceModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InvoiceModel,
				InvoiceModelAudit>>(CrudCreateEditComponent);
				break;

			case 'invoiceItem':
				model = new InvoiceItemModel();
				modelProperties = InvoiceItemModel.getProps();
				modelRelations = InvoiceItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InvoiceItemModel,
				InvoiceItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'invoiceItemComponent':
				model = new InvoiceItemComponentModel();
				modelProperties = InvoiceItemComponentModel.getProps();
				modelRelations = InvoiceItemComponentModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InvoiceItemComponentModel,
				InvoiceItemComponentModelAudit>>(CrudCreateEditComponent);
				break;

			case 'invoicePaymentInsurance':
				model = new InvoicePaymentInsuranceModel();
				modelProperties = InvoicePaymentInsuranceModel.getProps();
				modelRelations = InvoicePaymentInsuranceModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InvoicePaymentInsuranceModel,
				InvoicePaymentInsuranceModelAudit>>(CrudCreateEditComponent);
				break;

			case 'invoicePaymentOther':
				model = new InvoicePaymentOtherModel();
				modelProperties = InvoicePaymentOtherModel.getProps();
				modelRelations = InvoicePaymentOtherModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InvoicePaymentOtherModel,
				InvoicePaymentOtherModelAudit>>(CrudCreateEditComponent);
				break;

			case 'invoicePaymentSelfPaying':
				model = new InvoicePaymentSelfPayingModel();
				modelProperties = InvoicePaymentSelfPayingModel.getProps();
				modelRelations = InvoicePaymentSelfPayingModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InvoicePaymentSelfPayingModel,
				InvoicePaymentSelfPayingModelAudit>>(CrudCreateEditComponent);
				break;

			case 'invoiceSummary':
				model = new InvoiceSummaryModel();
				modelProperties = InvoiceSummaryModel.getProps();
				modelRelations = InvoiceSummaryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<InvoiceSummaryModel,
				InvoiceSummaryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'journal':
				model = new JournalModel();
				modelProperties = JournalModel.getProps();
				modelRelations = JournalModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<JournalModel,
				JournalModelAudit>>(CrudCreateEditComponent);
				break;

			case 'library':
				model = new LibraryModel();
				modelProperties = LibraryModel.getProps();
				modelRelations = LibraryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<LibraryModel,
				LibraryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'location':
				model = new LocationModel();
				modelProperties = LocationModel.getProps();
				modelRelations = LocationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<LocationModel,
				LocationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'mcuPackage':
				model = new McuPackageModel();
				modelProperties = McuPackageModel.getProps();
				modelRelations = McuPackageModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<McuPackageModel,
				McuPackageModelAudit>>(CrudCreateEditComponent);
				break;

			case 'mcuPackageItem':
				model = new McuPackageItemModel();
				modelProperties = McuPackageItemModel.getProps();
				modelRelations = McuPackageItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<McuPackageItemModel,
				McuPackageItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'managementUser':
				model = new ManagementUserModel();
				modelProperties = ManagementUserModel.getProps();
				modelRelations = ManagementUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ManagementUserModel,
				ManagementUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalCertificateDischargeResume':
				model = new MedicalCertificateDischargeResumeModel();
				modelProperties = MedicalCertificateDischargeResumeModel.getProps();
				modelRelations = MedicalCertificateDischargeResumeModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalCertificateDischargeResumeModel,
				MedicalCertificateDischargeResumeModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalCertificateBirth':
				model = new MedicalCertificateBirthModel();
				modelProperties = MedicalCertificateBirthModel.getProps();
				modelRelations = MedicalCertificateBirthModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalCertificateBirthModel,
				MedicalCertificateBirthModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalCertificateHospitalization':
				model = new MedicalCertificateHospitalizationModel();
				modelProperties = MedicalCertificateHospitalizationModel.getProps();
				modelRelations = MedicalCertificateHospitalizationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalCertificateHospitalizationModel,
				MedicalCertificateHospitalizationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalCertificateMedicalAttendance':
				model = new MedicalCertificateMedicalAttendanceModel();
				modelProperties = MedicalCertificateMedicalAttendanceModel.getProps();
				modelRelations = MedicalCertificateMedicalAttendanceModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalCertificateMedicalAttendanceModel,
				MedicalCertificateMedicalAttendanceModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalCertificateMentalHealth':
				model = new MedicalCertificateMentalHealthModel();
				modelProperties = MedicalCertificateMentalHealthModel.getProps();
				modelRelations = MedicalCertificateMentalHealthModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalCertificateMentalHealthModel,
				MedicalCertificateMentalHealthModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalCertificatePhysicalHealth':
				model = new MedicalCertificatePhysicalHealthModel();
				modelProperties = MedicalCertificatePhysicalHealthModel.getProps();
				modelRelations = MedicalCertificatePhysicalHealthModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalCertificatePhysicalHealthModel,
				MedicalCertificatePhysicalHealthModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalCertificateRestrictedWork':
				model = new MedicalCertificateRestrictedWorkModel();
				modelProperties = MedicalCertificateRestrictedWorkModel.getProps();
				modelRelations = MedicalCertificateRestrictedWorkModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalCertificateRestrictedWorkModel,
				MedicalCertificateRestrictedWorkModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalCertificateSickLeave':
				model = new MedicalCertificateSickLeaveModel();
				modelProperties = MedicalCertificateSickLeaveModel.getProps();
				modelRelations = MedicalCertificateSickLeaveModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalCertificateSickLeaveModel,
				MedicalCertificateSickLeaveModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalExaminationRecord':
				model = new MedicalExaminationRecordModel();
				modelProperties = MedicalExaminationRecordModel.getProps();
				modelRelations = MedicalExaminationRecordModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalExaminationRecordModel,
				MedicalExaminationRecordModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalExaminationRecordDischargeSummary':
				model = new MedicalExaminationRecordDischargeSummaryModel();
				modelProperties = MedicalExaminationRecordDischargeSummaryModel.getProps();
				modelRelations = MedicalExaminationRecordDischargeSummaryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalExaminationRecordDischargeSummaryModel,
				MedicalExaminationRecordDischargeSummaryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalFee':
				model = new MedicalFeeModel();
				modelProperties = MedicalFeeModel.getProps();
				modelRelations = MedicalFeeModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalFeeModel,
				MedicalFeeModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalFeeItemComponent':
				model = new MedicalFeeItemComponentModel();
				modelProperties = MedicalFeeItemComponentModel.getProps();
				modelRelations = MedicalFeeItemComponentModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalFeeItemComponentModel,
				MedicalFeeItemComponentModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalRecordInitialChecklist':
				model = new MedicalRecordInitialChecklistModel();
				modelProperties = MedicalRecordInitialChecklistModel.getProps();
				modelRelations = MedicalRecordInitialChecklistModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalRecordInitialChecklistModel,
				MedicalRecordInitialChecklistModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalRecordNextVerificationChecklist':
				model = new MedicalRecordNextVerificationChecklistModel();
				modelProperties = MedicalRecordNextVerificationChecklistModel.getProps();
				modelRelations = MedicalRecordNextVerificationChecklistModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalRecordNextVerificationChecklistModel,
				MedicalRecordNextVerificationChecklistModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalRecordUser':
				model = new MedicalRecordUserModel();
				modelProperties = MedicalRecordUserModel.getProps();
				modelRelations = MedicalRecordUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalRecordUserModel,
				MedicalRecordUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicalTranscriberUser':
				model = new MedicalTranscriberUserModel();
				modelProperties = MedicalTranscriberUserModel.getProps();
				modelRelations = MedicalTranscriberUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicalTranscriberUserModel,
				MedicalTranscriberUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicationAdministeredHistory':
				model = new MedicationAdministeredHistoryModel();
				modelProperties = MedicationAdministeredHistoryModel.getProps();
				modelRelations = MedicationAdministeredHistoryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicationAdministeredHistoryModel,
				MedicationAdministeredHistoryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicationCompound':
				model = new MedicationCompoundModel();
				modelProperties = MedicationCompoundModel.getProps();
				modelRelations = MedicationCompoundModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicationCompoundModel,
				MedicationCompoundModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicationHeader':
				model = new MedicationHeaderModel();
				modelProperties = MedicationHeaderModel.getProps();
				modelRelations = MedicationHeaderModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicationHeaderModel,
				MedicationHeaderModelAudit>>(CrudCreateEditComponent);
				break;

			case 'medicationItem':
				model = new MedicationItemModel();
				modelProperties = MedicationItemModel.getProps();
				modelRelations = MedicationItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MedicationItemModel,
				MedicationItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'merchant':
				model = new MerchantModel();
				modelProperties = MerchantModel.getProps();
				modelRelations = MerchantModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MerchantModel,
				MerchantModelAudit>>(CrudCreateEditComponent);
				break;

			case 'merchantSurchargeAndFee':
				model = new MerchantSurchargeAndFeeModel();
				modelProperties = MerchantSurchargeAndFeeModel.getProps();
				modelRelations = MerchantSurchargeAndFeeModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<MerchantSurchargeAndFeeModel,
				MerchantSurchargeAndFeeModelAudit>>(CrudCreateEditComponent);
				break;

			case 'nhisClaim':
				model = new NhisClaimModel();
				modelProperties = NhisClaimModel.getProps();
				modelRelations = NhisClaimModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NhisClaimModel,
				NhisClaimModelAudit>>(CrudCreateEditComponent);
				break;

			case 'nhisClaimGDRGDetail':
				model = new NhisClaimGDRGDetailModel();
				modelProperties = NhisClaimGDRGDetailModel.getProps();
				modelRelations = NhisClaimGDRGDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NhisClaimGDRGDetailModel,
				NhisClaimGDRGDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'nhisClaimInvestigationDetail':
				model = new NhisClaimInvestigationDetailModel();
				modelProperties = NhisClaimInvestigationDetailModel.getProps();
				modelRelations = NhisClaimInvestigationDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NhisClaimInvestigationDetailModel,
				NhisClaimInvestigationDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'nhisGDRG':
				model = new NhisGDRGModel();
				modelProperties = NhisGDRGModel.getProps();
				modelRelations = NhisGDRGModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NhisGDRGModel,
				NhisGDRGModelAudit>>(CrudCreateEditComponent);
				break;

			case 'nhisInvestigation':
				model = new NhisInvestigationModel();
				modelProperties = NhisInvestigationModel.getProps();
				modelRelations = NhisInvestigationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NhisInvestigationModel,
				NhisInvestigationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'nhisMedicine':
				model = new NhisMedicineModel();
				modelProperties = NhisMedicineModel.getProps();
				modelRelations = NhisMedicineModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NhisMedicineModel,
				NhisMedicineModelAudit>>(CrudCreateEditComponent);
				break;

			case 'nhisServiceOutcome':
				model = new NhisServiceOutcomeModel();
				modelProperties = NhisServiceOutcomeModel.getProps();
				modelRelations = NhisServiceOutcomeModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NhisServiceOutcomeModel,
				NhisServiceOutcomeModelAudit>>(CrudCreateEditComponent);
				break;

			case 'nhisSpecialtyAttended':
				model = new NhisSpecialtyAttendedModel();
				modelProperties = NhisSpecialtyAttendedModel.getProps();
				modelRelations = NhisSpecialtyAttendedModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NhisSpecialtyAttendedModel,
				NhisSpecialtyAttendedModelAudit>>(CrudCreateEditComponent);
				break;

			case 'nhisTypeOfService':
				model = new NhisTypeOfServiceModel();
				modelProperties = NhisTypeOfServiceModel.getProps();
				modelRelations = NhisTypeOfServiceModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NhisTypeOfServiceModel,
				NhisTypeOfServiceModelAudit>>(CrudCreateEditComponent);
				break;

			case 'newbornDetail':
				model = new NewbornDetailModel();
				modelProperties = NewbornDetailModel.getProps();
				modelRelations = NewbornDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NewbornDetailModel,
				NewbornDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'numberingSetup':
				model = new NumberingSetupModel();
				modelProperties = NumberingSetupModel.getProps();
				modelRelations = NumberingSetupModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NumberingSetupModel,
				NumberingSetupModelAudit>>(CrudCreateEditComponent);
				break;

			case 'nurseUser':
				model = new NurseUserModel();
				modelProperties = NurseUserModel.getProps();
				modelRelations = NurseUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NurseUserModel,
				NurseUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'nurseVitalSignMeasurement':
				model = new NurseVitalSignMeasurementModel();
				modelProperties = NurseVitalSignMeasurementModel.getProps();
				modelRelations = NurseVitalSignMeasurementModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<NurseVitalSignMeasurementModel,
				NurseVitalSignMeasurementModelAudit>>(CrudCreateEditComponent);
				break;

			case 'obstetricAndGynecologyHistory':
				model = new ObstetricAndGynecologyHistoryModel();
				modelProperties = ObstetricAndGynecologyHistoryModel.getProps();
				modelRelations = ObstetricAndGynecologyHistoryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ObstetricAndGynecologyHistoryModel,
				ObstetricAndGynecologyHistoryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'odontogramExamination':
				model = new OdontogramExaminationModel();
				modelProperties = OdontogramExaminationModel.getProps();
				modelRelations = OdontogramExaminationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<OdontogramExaminationModel,
				OdontogramExaminationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'operatingTheaterMedicalExaminationRecord':
				model = new OperatingTheaterMedicalExaminationRecordModel();
				modelProperties = OperatingTheaterMedicalExaminationRecordModel.getProps();
				modelRelations = OperatingTheaterMedicalExaminationRecordModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<OperatingTheaterMedicalExaminationRecordModel,
				OperatingTheaterMedicalExaminationRecordModelAudit>>(CrudCreateEditComponent);
				break;

			case 'ophthalmologyExamination':
				model = new OphthalmologyExaminationModel();
				modelProperties = OphthalmologyExaminationModel.getProps();
				modelRelations = OphthalmologyExaminationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<OphthalmologyExaminationModel,
				OphthalmologyExaminationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareActionExamination':
				model = new PcareActionExaminationModel();
				modelProperties = PcareActionExaminationModel.getProps();
				modelRelations = PcareActionExaminationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareActionExaminationModel,
				PcareActionExaminationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareClubProlanis':
				model = new PcareClubProlanisModel();
				modelProperties = PcareClubProlanisModel.getProps();
				modelRelations = PcareClubProlanisModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareClubProlanisModel,
				PcareClubProlanisModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareCompoundDrug':
				model = new PcareCompoundDrugModel();
				modelProperties = PcareCompoundDrugModel.getProps();
				modelRelations = PcareCompoundDrugModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareCompoundDrugModel,
				PcareCompoundDrugModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareCompoundDrugItem':
				model = new PcareCompoundDrugItemModel();
				modelProperties = PcareCompoundDrugItemModel.getProps();
				modelRelations = PcareCompoundDrugItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareCompoundDrugItemModel,
				PcareCompoundDrugItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareDiagnosa':
				model = new PcareDiagnosaModel();
				modelProperties = PcareDiagnosaModel.getProps();
				modelRelations = PcareDiagnosaModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareDiagnosaModel,
				PcareDiagnosaModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareDokter':
				model = new PcareDokterModel();
				modelProperties = PcareDokterModel.getProps();
				modelRelations = PcareDokterModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareDokterModel,
				PcareDokterModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareExamination':
				model = new PcareExaminationModel();
				modelProperties = PcareExaminationModel.getProps();
				modelRelations = PcareExaminationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareExaminationModel,
				PcareExaminationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareMCU':
				model = new PcareMCUModel();
				modelProperties = PcareMCUModel.getProps();
				modelRelations = PcareMCUModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareMCUModel,
				PcareMCUModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareNonCompoundDrug':
				model = new PcareNonCompoundDrugModel();
				modelProperties = PcareNonCompoundDrugModel.getProps();
				modelRelations = PcareNonCompoundDrugModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareNonCompoundDrugModel,
				PcareNonCompoundDrugModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareReferensiSarana':
				model = new PcareReferensiSaranaModel();
				modelProperties = PcareReferensiSaranaModel.getProps();
				modelRelations = PcareReferensiSaranaModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareReferensiSaranaModel,
				PcareReferensiSaranaModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareStatusPulang':
				model = new PcareStatusPulangModel();
				modelProperties = PcareStatusPulangModel.getProps();
				modelRelations = PcareStatusPulangModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareStatusPulangModel,
				PcareStatusPulangModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareTindakan':
				model = new PcareTindakanModel();
				modelProperties = PcareTindakanModel.getProps();
				modelRelations = PcareTindakanModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareTindakanModel,
				PcareTindakanModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pcareUmum':
				model = new PcareUmumModel();
				modelProperties = PcareUmumModel.getProps();
				modelRelations = PcareUmumModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PcareUmumModel,
				PcareUmumModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientCaseHistory':
				model = new PatientCaseHistoryModel();
				modelProperties = PatientCaseHistoryModel.getProps();
				modelRelations = PatientCaseHistoryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientCaseHistoryModel,
				PatientCaseHistoryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientConsent':
				model = new PatientConsentModel();
				modelProperties = PatientConsentModel.getProps();
				modelRelations = PatientConsentModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientConsentModel,
				PatientConsentModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientContactInfo':
				model = new PatientContactInfoModel();
				modelProperties = PatientContactInfoModel.getProps();
				modelRelations = PatientContactInfoModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientContactInfoModel,
				PatientContactInfoModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientDetail':
				model = new PatientDetailModel();
				modelProperties = PatientDetailModel.getProps();
				modelRelations = PatientDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientDetailModel,
				PatientDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientDetailAddress':
				model = new PatientDetailAddressModel();
				modelProperties = PatientDetailAddressModel.getProps();
				modelRelations = PatientDetailAddressModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientDetailAddressModel,
				PatientDetailAddressModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientEmergencyContactDetail':
				model = new PatientEmergencyContactDetailModel();
				modelProperties = PatientEmergencyContactDetailModel.getProps();
				modelRelations = PatientEmergencyContactDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientEmergencyContactDetailModel,
				PatientEmergencyContactDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientEmploymentDetail':
				model = new PatientEmploymentDetailModel();
				modelProperties = PatientEmploymentDetailModel.getProps();
				modelRelations = PatientEmploymentDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientEmploymentDetailModel,
				PatientEmploymentDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientGeneralInfo':
				model = new PatientGeneralInfoModel();
				modelProperties = PatientGeneralInfoModel.getProps();
				modelRelations = PatientGeneralInfoModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientGeneralInfoModel,
				PatientGeneralInfoModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientPaymentSelfPaying':
				model = new PatientPaymentSelfPayingModel();
				modelProperties = PatientPaymentSelfPayingModel.getProps();
				modelRelations = PatientPaymentSelfPayingModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientPaymentSelfPayingModel,
				PatientPaymentSelfPayingModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientPaymentBPJS':
				model = new PatientPaymentBPJSModel();
				modelProperties = PatientPaymentBPJSModel.getProps();
				modelRelations = PatientPaymentBPJSModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientPaymentBPJSModel,
				PatientPaymentBPJSModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientPaymentInsurance':
				model = new PatientPaymentInsuranceModel();
				modelProperties = PatientPaymentInsuranceModel.getProps();
				modelRelations = PatientPaymentInsuranceModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientPaymentInsuranceModel,
				PatientPaymentInsuranceModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientPaymentOthers':
				model = new PatientPaymentOthersModel();
				modelProperties = PatientPaymentOthersModel.getProps();
				modelRelations = PatientPaymentOthersModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientPaymentOthersModel,
				PatientPaymentOthersModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientPersonalInfo':
				model = new PatientPersonalInfoModel();
				modelProperties = PatientPersonalInfoModel.getProps();
				modelRelations = PatientPersonalInfoModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientPersonalInfoModel,
				PatientPersonalInfoModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientSupportingDocument':
				model = new PatientSupportingDocumentModel();
				modelProperties = PatientSupportingDocumentModel.getProps();
				modelRelations = PatientSupportingDocumentModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientSupportingDocumentModel,
				PatientSupportingDocumentModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientVisit':
				model = new PatientVisitModel();
				modelProperties = PatientVisitModel.getProps();
				modelRelations = PatientVisitModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientVisitModel,
				PatientVisitModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientVisitPatientPaymentInsurance':
				model = new PatientVisitPatientPaymentInsuranceModel();
				modelProperties = PatientVisitPatientPaymentInsuranceModel.getProps();
				modelRelations = PatientVisitPatientPaymentInsuranceModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientVisitPatientPaymentInsuranceModel,
				PatientVisitPatientPaymentInsuranceModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientVisitPatientPaymentOthers':
				model = new PatientVisitPatientPaymentOthersModel();
				modelProperties = PatientVisitPatientPaymentOthersModel.getProps();
				modelRelations = PatientVisitPatientPaymentOthersModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientVisitPatientPaymentOthersModel,
				PatientVisitPatientPaymentOthersModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientVisitPaymentSelfPaying':
				model = new PatientVisitPaymentSelfPayingModel();
				modelProperties = PatientVisitPaymentSelfPayingModel.getProps();
				modelRelations = PatientVisitPaymentSelfPayingModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientVisitPaymentSelfPayingModel,
				PatientVisitPaymentSelfPayingModelAudit>>(CrudCreateEditComponent);
				break;

			case 'patientVitalInformation':
				model = new PatientVitalInformationModel();
				modelProperties = PatientVitalInformationModel.getProps();
				modelRelations = PatientVitalInformationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PatientVitalInformationModel,
				PatientVitalInformationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pharmacySetup':
				model = new PharmacySetupModel();
				modelProperties = PharmacySetupModel.getProps();
				modelRelations = PharmacySetupModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PharmacySetupModel,
				PharmacySetupModelAudit>>(CrudCreateEditComponent);
				break;

			case 'pharmacyUser':
				model = new PharmacyUserModel();
				modelProperties = PharmacyUserModel.getProps();
				modelRelations = PharmacyUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PharmacyUserModel,
				PharmacyUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'postOperativeDetails':
				model = new PostOperativeDetailsModel();
				modelProperties = PostOperativeDetailsModel.getProps();
				modelRelations = PostOperativeDetailsModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PostOperativeDetailsModel,
				PostOperativeDetailsModelAudit>>(CrudCreateEditComponent);
				break;

			case 'preoperativeRecords':
				model = new PreoperativeRecordsModel();
				modelProperties = PreoperativeRecordsModel.getProps();
				modelRelations = PreoperativeRecordsModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PreoperativeRecordsModel,
				PreoperativeRecordsModelAudit>>(CrudCreateEditComponent);
				break;

			case 'prescriptionCompound':
				model = new PrescriptionCompoundModel();
				modelProperties = PrescriptionCompoundModel.getProps();
				modelRelations = PrescriptionCompoundModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PrescriptionCompoundModel,
				PrescriptionCompoundModelAudit>>(CrudCreateEditComponent);
				break;

			case 'prescriptionHeader':
				model = new PrescriptionHeaderModel();
				modelProperties = PrescriptionHeaderModel.getProps();
				modelRelations = PrescriptionHeaderModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PrescriptionHeaderModel,
				PrescriptionHeaderModelAudit>>(CrudCreateEditComponent);
				break;

			case 'prescriptionItem':
				model = new PrescriptionItemModel();
				modelProperties = PrescriptionItemModel.getProps();
				modelRelations = PrescriptionItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PrescriptionItemModel,
				PrescriptionItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'priceComponent':
				model = new PriceComponentModel();
				modelProperties = PriceComponentModel.getProps();
				modelRelations = PriceComponentModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PriceComponentModel,
				PriceComponentModelAudit>>(CrudCreateEditComponent);
				break;

			case 'privilege':
				model = new PrivilegeModel();
				modelProperties = PrivilegeModel.getProps();
				modelRelations = PrivilegeModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PrivilegeModel,
				PrivilegeModelAudit>>(CrudCreateEditComponent);
				break;

			case 'processWorkflow':
				model = new ProcessWorkflowModel();
				modelProperties = ProcessWorkflowModel.getProps();
				modelRelations = ProcessWorkflowModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ProcessWorkflowModel,
				ProcessWorkflowModelAudit>>(CrudCreateEditComponent);
				break;

			case 'purchaseOrder':
				model = new PurchaseOrderModel();
				modelProperties = PurchaseOrderModel.getProps();
				modelRelations = PurchaseOrderModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PurchaseOrderModel,
				PurchaseOrderModelAudit>>(CrudCreateEditComponent);
				break;

			case 'purchaseOrderStockDetail':
				model = new PurchaseOrderStockDetailModel();
				modelProperties = PurchaseOrderStockDetailModel.getProps();
				modelRelations = PurchaseOrderStockDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PurchaseOrderStockDetailModel,
				PurchaseOrderStockDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'purchaseRequisition':
				model = new PurchaseRequisitionModel();
				modelProperties = PurchaseRequisitionModel.getProps();
				modelRelations = PurchaseRequisitionModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PurchaseRequisitionModel,
				PurchaseRequisitionModelAudit>>(CrudCreateEditComponent);
				break;

			case 'purchaseRequisitionStockDetail':
				model = new PurchaseRequisitionStockDetailModel();
				modelProperties = PurchaseRequisitionStockDetailModel.getProps();
				modelRelations = PurchaseRequisitionStockDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PurchaseRequisitionStockDetailModel,
				PurchaseRequisitionStockDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'purchasingUser':
				model = new PurchasingUserModel();
				modelProperties = PurchasingUserModel.getProps();
				modelRelations = PurchasingUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<PurchasingUserModel,
				PurchasingUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'referenceData':
				model = new ReferenceDataModel();
				modelProperties = ReferenceDataModel.getProps();
				modelRelations = ReferenceDataModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ReferenceDataModel,
				ReferenceDataModelAudit>>(CrudCreateEditComponent);
				break;

			case 'referenceHeader':
				model = new ReferenceHeaderModel();
				modelProperties = ReferenceHeaderModel.getProps();
				modelRelations = ReferenceHeaderModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ReferenceHeaderModel,
				ReferenceHeaderModelAudit>>(CrudCreateEditComponent);
				break;

			case 'registration':
				model = new RegistrationModel();
				modelProperties = RegistrationModel.getProps();
				modelRelations = RegistrationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<RegistrationModel,
				RegistrationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'registrationUser':
				model = new RegistrationUserModel();
				modelProperties = RegistrationUserModel.getProps();
				modelRelations = RegistrationUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<RegistrationUserModel,
				RegistrationUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'retailPharmacy':
				model = new RetailPharmacyModel();
				modelProperties = RetailPharmacyModel.getProps();
				modelRelations = RetailPharmacyModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<RetailPharmacyModel,
				RetailPharmacyModelAudit>>(CrudCreateEditComponent);
				break;

			case 'retailPharmacyInvoice':
				model = new RetailPharmacyInvoiceModel();
				modelProperties = RetailPharmacyInvoiceModel.getProps();
				modelRelations = RetailPharmacyInvoiceModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<RetailPharmacyInvoiceModel,
				RetailPharmacyInvoiceModelAudit>>(CrudCreateEditComponent);
				break;

			case 'retailPharmacyStockDetail':
				model = new RetailPharmacyStockDetailModel();
				modelProperties = RetailPharmacyStockDetailModel.getProps();
				modelRelations = RetailPharmacyStockDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<RetailPharmacyStockDetailModel,
				RetailPharmacyStockDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'returnSupplier':
				model = new ReturnSupplierModel();
				modelProperties = ReturnSupplierModel.getProps();
				modelRelations = ReturnSupplierModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ReturnSupplierModel,
				ReturnSupplierModelAudit>>(CrudCreateEditComponent);
				break;

			case 'returnSupplierStockDetail':
				model = new ReturnSupplierStockDetailModel();
				modelProperties = ReturnSupplierStockDetailModel.getProps();
				modelRelations = ReturnSupplierStockDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ReturnSupplierStockDetailModel,
				ReturnSupplierStockDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'role':
				model = new RoleModel();
				modelProperties = RoleModel.getProps();
				modelRelations = RoleModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<RoleModel,
				RoleModelAudit>>(CrudCreateEditComponent);
				break;

			case 'roomFacility':
				model = new RoomFacilityModel();
				modelProperties = RoomFacilityModel.getProps();
				modelRelations = RoomFacilityModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<RoomFacilityModel,
				RoomFacilityModelAudit>>(CrudCreateEditComponent);
				break;

			case 'roomTransfer':
				model = new RoomTransferModel();
				modelProperties = RoomTransferModel.getProps();
				modelRelations = RoomTransferModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<RoomTransferModel,
				RoomTransferModelAudit>>(CrudCreateEditComponent);
				break;

			case 'sep':
				model = new SepModel();
				modelProperties = SepModel.getProps();
				modelRelations = SepModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<SepModel,
				SepModelAudit>>(CrudCreateEditComponent);
				break;

			case 'sampleCollectionInformation':
				model = new SampleCollectionInformationModel();
				modelProperties = SampleCollectionInformationModel.getProps();
				modelRelations = SampleCollectionInformationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<SampleCollectionInformationModel,
				SampleCollectionInformationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'sampleCollectionItems':
				model = new SampleCollectionItemsModel();
				modelProperties = SampleCollectionItemsModel.getProps();
				modelRelations = SampleCollectionItemsModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<SampleCollectionItemsModel,
				SampleCollectionItemsModelAudit>>(CrudCreateEditComponent);
				break;

			case 'satuSehatConfiguration':
				model = new SatuSehatConfigurationModel();
				modelProperties = SatuSehatConfigurationModel.getProps();
				modelRelations = SatuSehatConfigurationModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<SatuSehatConfigurationModel,
				SatuSehatConfigurationModelAudit>>(CrudCreateEditComponent);
				break;

			case 'service':
				model = new ServiceModel();
				modelProperties = ServiceModel.getProps();
				modelRelations = ServiceModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ServiceModel,
				ServiceModelAudit>>(CrudCreateEditComponent);
				break;

			case 'serviceFacilityCategory':
				model = new ServiceFacilityCategoryModel();
				modelProperties = ServiceFacilityCategoryModel.getProps();
				modelRelations = ServiceFacilityCategoryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ServiceFacilityCategoryModel,
				ServiceFacilityCategoryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'serviceItem':
				model = new ServiceItemModel();
				modelProperties = ServiceItemModel.getProps();
				modelRelations = ServiceItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ServiceItemModel,
				ServiceItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'serviceItemAssignment':
				model = new ServiceItemAssignmentModel();
				modelProperties = ServiceItemAssignmentModel.getProps();
				modelRelations = ServiceItemAssignmentModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<ServiceItemAssignmentModel,
				ServiceItemAssignmentModelAudit>>(CrudCreateEditComponent);
				break;

			case 'staff':
				model = new StaffModel();
				modelProperties = StaffModel.getProps();
				modelRelations = StaffModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<StaffModel,
				StaffModelAudit>>(CrudCreateEditComponent);
				break;

			case 'stockCatalogue':
				model = new StockCatalogueModel();
				modelProperties = StockCatalogueModel.getProps();
				modelRelations = StockCatalogueModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<StockCatalogueModel,
				StockCatalogueModelAudit>>(CrudCreateEditComponent);
				break;

			case 'stockControl':
				model = new StockControlModel();
				modelProperties = StockControlModel.getProps();
				modelRelations = StockControlModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<StockControlModel,
				StockControlModelAudit>>(CrudCreateEditComponent);
				break;

			case 'stockTransactionDetail':
				model = new StockTransactionDetailModel();
				modelProperties = StockTransactionDetailModel.getProps();
				modelRelations = StockTransactionDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<StockTransactionDetailModel,
				StockTransactionDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'stockTransactionPerDate':
				model = new StockTransactionPerDateModel();
				modelProperties = StockTransactionPerDateModel.getProps();
				modelRelations = StockTransactionPerDateModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<StockTransactionPerDateModel,
				StockTransactionPerDateModelAudit>>(CrudCreateEditComponent);
				break;

			case 'stockTransactionPerDateType':
				model = new StockTransactionPerDateTypeModel();
				modelProperties = StockTransactionPerDateTypeModel.getProps();
				modelRelations = StockTransactionPerDateTypeModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<StockTransactionPerDateTypeModel,
				StockTransactionPerDateTypeModelAudit>>(CrudCreateEditComponent);
				break;

			case 'supplier':
				model = new SupplierModel();
				modelProperties = SupplierModel.getProps();
				modelRelations = SupplierModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<SupplierModel,
				SupplierModelAudit>>(CrudCreateEditComponent);
				break;

			case 'supplierBankAccount':
				model = new SupplierBankAccountModel();
				modelProperties = SupplierBankAccountModel.getProps();
				modelRelations = SupplierBankAccountModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<SupplierBankAccountModel,
				SupplierBankAccountModelAudit>>(CrudCreateEditComponent);
				break;

			case 'supplierContactDetail':
				model = new SupplierContactDetailModel();
				modelProperties = SupplierContactDetailModel.getProps();
				modelRelations = SupplierContactDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<SupplierContactDetailModel,
				SupplierContactDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'supplierProductDetail':
				model = new SupplierProductDetailModel();
				modelProperties = SupplierProductDetailModel.getProps();
				modelRelations = SupplierProductDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<SupplierProductDetailModel,
				SupplierProductDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'systemAdminUser':
				model = new SystemAdminUserModel();
				modelProperties = SystemAdminUserModel.getProps();
				modelRelations = SystemAdminUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<SystemAdminUserModel,
				SystemAdminUserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'tariffDefinition':
				model = new TariffDefinitionModel();
				modelProperties = TariffDefinitionModel.getProps();
				modelRelations = TariffDefinitionModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TariffDefinitionModel,
				TariffDefinitionModelAudit>>(CrudCreateEditComponent);
				break;

			case 'tariffDefinitionOtherComponent':
				model = new TariffDefinitionOtherComponentModel();
				modelProperties = TariffDefinitionOtherComponentModel.getProps();
				modelRelations = TariffDefinitionOtherComponentModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TariffDefinitionOtherComponentModel,
				TariffDefinitionOtherComponentModelAudit>>(CrudCreateEditComponent);
				break;

			case 'tariffFormula':
				model = new TariffFormulaModel();
				modelProperties = TariffFormulaModel.getProps();
				modelRelations = TariffFormulaModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TariffFormulaModel,
				TariffFormulaModelAudit>>(CrudCreateEditComponent);
				break;

			case 'tariffPackage':
				model = new TariffPackageModel();
				modelProperties = TariffPackageModel.getProps();
				modelRelations = TariffPackageModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TariffPackageModel,
				TariffPackageModelAudit>>(CrudCreateEditComponent);
				break;

			case 'tariffPackageItem':
				model = new TariffPackageItemModel();
				modelProperties = TariffPackageItemModel.getProps();
				modelRelations = TariffPackageItemModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TariffPackageItemModel,
				TariffPackageItemModelAudit>>(CrudCreateEditComponent);
				break;

			case 'tariffPackageServiceAssignment':
				model = new TariffPackageServiceAssignmentModel();
				modelProperties = TariffPackageServiceAssignmentModel.getProps();
				modelRelations = TariffPackageServiceAssignmentModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TariffPackageServiceAssignmentModel,
				TariffPackageServiceAssignmentModelAudit>>(CrudCreateEditComponent);
				break;

			case 'tariffSchema':
				model = new TariffSchemaModel();
				modelProperties = TariffSchemaModel.getProps();
				modelRelations = TariffSchemaModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TariffSchemaModel,
				TariffSchemaModelAudit>>(CrudCreateEditComponent);
				break;

			case 'taskDashboard':
				model = new TaskDashboardModel();
				modelProperties = TaskDashboardModel.getProps();
				modelRelations = TaskDashboardModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TaskDashboardModel,
				TaskDashboardModelAudit>>(CrudCreateEditComponent);
				break;

			case 'transactionDetailType':
				model = new TransactionDetailTypeModel();
				modelProperties = TransactionDetailTypeModel.getProps();
				modelRelations = TransactionDetailTypeModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TransactionDetailTypeModel,
				TransactionDetailTypeModelAudit>>(CrudCreateEditComponent);
				break;

			case 'transactionDetailTypeMapping':
				model = new TransactionDetailTypeMappingModel();
				modelProperties = TransactionDetailTypeMappingModel.getProps();
				modelRelations = TransactionDetailTypeMappingModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TransactionDetailTypeMappingModel,
				TransactionDetailTypeMappingModelAudit>>(CrudCreateEditComponent);
				break;

			case 'transferOrder':
				model = new TransferOrderModel();
				modelProperties = TransferOrderModel.getProps();
				modelRelations = TransferOrderModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TransferOrderModel,
				TransferOrderModelAudit>>(CrudCreateEditComponent);
				break;

			case 'transferOrderStockDetail':
				model = new TransferOrderStockDetailModel();
				modelProperties = TransferOrderStockDetailModel.getProps();
				modelRelations = TransferOrderStockDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<TransferOrderStockDetailModel,
				TransferOrderStockDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'unitOfMeasurement':
				model = new UnitOfMeasurementModel();
				modelProperties = UnitOfMeasurementModel.getProps();
				modelRelations = UnitOfMeasurementModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<UnitOfMeasurementModel,
				UnitOfMeasurementModelAudit>>(CrudCreateEditComponent);
				break;

			case 'user':
				model = new UserModel();
				modelProperties = UserModel.getProps();
				modelRelations = UserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<UserModel,
				UserModelAudit>>(CrudCreateEditComponent);
				break;

			case 'vaccinationOrder':
				model = new VaccinationOrderModel();
				modelProperties = VaccinationOrderModel.getProps();
				modelRelations = VaccinationOrderModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<VaccinationOrderModel,
				VaccinationOrderModelAudit>>(CrudCreateEditComponent);
				break;

			case 'vaccinationOrderDetail':
				model = new VaccinationOrderDetailModel();
				modelProperties = VaccinationOrderDetailModel.getProps();
				modelRelations = VaccinationOrderDetailModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<VaccinationOrderDetailModel,
				VaccinationOrderDetailModelAudit>>(CrudCreateEditComponent);
				break;

			case 'vitalSigns':
				model = new VitalSignsModel();
				modelProperties = VitalSignsModel.getProps();
				modelRelations = VitalSignsModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<VitalSignsModel,
				VitalSignsModelAudit>>(CrudCreateEditComponent);
				break;

			case 'warehouse':
				model = new WarehouseModel();
				modelProperties = WarehouseModel.getProps();
				modelRelations = WarehouseModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<WarehouseModel,
				WarehouseModelAudit>>(CrudCreateEditComponent);
				break;

			case 'warehouseInitialStock':
				model = new WarehouseInitialStockModel();
				modelProperties = WarehouseInitialStockModel.getProps();
				modelRelations = WarehouseInitialStockModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<WarehouseInitialStockModel,
				WarehouseInitialStockModelAudit>>(CrudCreateEditComponent);
				break;

			case 'warehouseInventory':
				model = new WarehouseInventoryModel();
				modelProperties = WarehouseInventoryModel.getProps();
				modelRelations = WarehouseInventoryModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<WarehouseInventoryModel,
				WarehouseInventoryModelAudit>>(CrudCreateEditComponent);
				break;

			case 'warehouseUser':
				model = new WarehouseUserModel();
				modelProperties = WarehouseUserModel.getProps();
				modelRelations = WarehouseUserModel.getRelations();
				modelForm = createReactiveFormFromModel(modelProperties, modelRelations, false);

				fixture = TestBed.createComponent<CrudCreateEditComponent<WarehouseUserModel,
				WarehouseUserModelAudit>>(CrudCreateEditComponent);
				break;

		}

		crudElement = fixture.debugElement.componentInstance;
		crudElement.model = model;
		crudElement.modelProperties = modelProperties;
		crudElement.modelRelations = modelRelations;
		crudElement.modelFormGroup = modelForm;
		crudElement.isDisabled = false;
		fixture.detectChanges();

		formGroup = fixture
			.debugElement
			.query(By.css('.crud__form-container'));

		// % protected region % [Add any additional logic when creating the testing component here] off begin
		// % protected region % [Add any additional logic when creating the testing component here] end
	}

	beforeEach(waitForAsync (() => {
		TestBed.configureTestingModule({
			imports: [
				CommonModule,
				FormsModule,
				ReactiveFormsModule,
				CommonComponentModule,
				StoreModule.forRoot(reducers, {
					initialState: {
						router: initialRouterState,
						models: initialModelState,
					},
					metaReducers: [
						clearState,
					],
				}),
				// % protected region % [Add additional TestBed imports here] off begin
				// % protected region % [Add additional TestBed imports here] end
			],
			declarations: [
				CrudCreateEditComponent
			]
			// % protected region % [Add any additional fields to configureTestingModule here] off begin
			// % protected region % [Add any additional fields to configureTestingModule here] end
		}).compileComponents();
	}));

	afterEach(() => {
		(fixture.nativeElement as HTMLElement).remove();

		// % protected region % [Add additional logic to the afterEach method here] off begin
		// % protected region % [Add additional logic to the afterEach method here] end
	});

	requiredValidators.forEach(validator => {
		it('should be invalid when violating ' + validator.entityName + ' required validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			// Set value to empty so that we can check the required validator is violated
			crudElement.modelFormGroup.get(validator.attributeName).setValue('');
			fixture.detectChanges();
			expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
		});

		// Required validator can be applied in addition to any other validator.
		// As a result we don't check that the form control is valid after setting a value, as a value may not
		// fulfil the other validators present
	});

	rangeValidators.forEach(validator => {
		it('should be invalid when violating ' + validator.entityName + ' range validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			crudElement.modelFormGroup.get(validator.attributeName).setValue(validator.lower - 1);
			fixture.detectChanges();
			expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();

			crudElement.modelFormGroup.get(validator.attributeName).setValue(validator.upper + 1);
			fixture.detectChanges();
			expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
		});

		it('should have valid form group when not volating ' + validator.entityName + ' range validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			crudElement.modelFormGroup.get(validator.attributeName).setValue(validator.lower);
			fixture.detectChanges();
			expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();

			crudElement.modelFormGroup.get(validator.attributeName).setValue(validator.upper);
			fixture.detectChanges();
			expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
		});
	});

	lengthValidators.forEach(validator => {
		it('should be invalid when violating ' + validator.entityName + ' length validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			// Check that string shorter than minimum length violates the validator
			if (validator.min) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.lengthString(validator.min - 1));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
			}

			// Check that string longer than maximum length violated the validator
			if (validator.max) {
				crudElement.modelFormGroup.get('name').setValue(ValidatorInputUtils.lengthString(validator.max + 1));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
			}
		});

		it('should have valid form group when not volating ' + validator.entityName + ' length validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			// Check that string of minimum length does not violate the validator
			if (validator.min) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.lengthString(validator.min));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
			}

			// Check that string of maximum length does not violate the validator
			if (validator.max) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.lengthString(validator.max));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
			}
		});
	});

	numericValidators.forEach(validator => {
		it('should be invalid when violating ' + validator.entityName + ' numeric validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			if (validator.min) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.numeric(true, validator.min - 1));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();

				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.numeric(false, validator.min));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
			}

			if (validator.max) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.numeric(true, validator.max + 1));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();

				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.numeric(false, validator.max));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
			}

			if (!validator.min && !validator.max) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.numeric(false, 6));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
			}
		});

		it('should have valid form group when not volating '
		 		+ validator.entityName + ' numeric validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			if (validator.min) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.numeric(true, validator.min));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
			}

			if (validator.max) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.numeric(true, validator.max));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
			}

			if (!validator.min && !validator.max) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.numeric(true, 6));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
			}
		});
	});

	alphanumericValidators.forEach(validator => {
		it('should be invalid when violating ' + validator.entityName + ' alphanumeric validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			if (validator.min) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.alphanumeric(true, validator.min - 1));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();

				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.alphanumeric(false, validator.min));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
			}

			if (validator.max) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.alphanumeric(true, validator.max + 1));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();

				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.alphanumeric(false, validator.max));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
			}

			if (!validator.min && !validator.max) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.alphanumeric(false, 6));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
			}
		});

		it('should have valid form group when not volating '
		 		+ validator.entityName + ' alphanumeric validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			if (validator.min) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.alphanumeric(true, validator.min));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
			}

			if (validator.max) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.alphanumeric(true, validator.max));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
			}

			if (!validator.min && !validator.max) {
				crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.alphanumeric(true, 6));
				fixture.detectChanges();
				expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
			}
		});
	});

	urlValidators.forEach(validator => {
		it('should be invalid when violating ' + validator.entityName + ' url validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.url(false));
			fixture.detectChanges();
			expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
		});

		it('should have valid form group when not volating ' + validator.entityName + ' url validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.url(true));
			fixture.detectChanges();
			expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
		});
	});

	emailValidators.forEach(validator => {
		it('should be invalid when violating ' + validator.entityName + ' email validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.email(false));
			fixture.detectChanges();
			expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
		});

		it('should have valid form group when not volating ' + validator.entityName + ' email validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.email(true));
			fixture.detectChanges();
			expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
		});
	});

	uuidValidators.forEach(validator => {
		it('should be invalid when violating ' + validator.entityName + ' uuid validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.uuid(false));
			fixture.detectChanges();
			expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeFalsy();
		});

		it('should have valid form group when not volating ' + validator.entityName + ' uuid validator on ' + validator.attributeName, () => {
			createTestingComponent(validator.entityName);

			crudElement.modelFormGroup.get(validator.attributeName).setValue(ValidatorInputUtils.uuid(true));
			fixture.detectChanges();
			expect(crudElement.modelFormGroup.get(validator.attributeName).valid).toBeTruthy();
		});
	});

	// % protected region % [Add any additional test cases here] off begin
	// % protected region % [Add any additional test cases here] end
});
