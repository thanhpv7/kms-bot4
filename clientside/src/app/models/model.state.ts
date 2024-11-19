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

import {Params, RouterStateSnapshot} from '@angular/router';
import {RouterReducerState, RouterStateSerializer} from '@ngrx/router-store';
import {RoutingEffect} from '../lib/routing/routing.effect';
import {QueryParams} from '../lib/services/http/interfaces';
import {AdministrationUserEffect} from './administrationUser/administration_user.model.effect';
import {
	AdministrationUserModelState,
	initialState as AdministrationUserModelInitialState
} from './administrationUser/administration_user.model.state';
import {AdministratorEffect} from './administrator/administrator.model.effect';
import {
	AdministratorModelState,
	initialState as AdministratorModelInitialState
} from './administrator/administrator.model.state';
import {AmendmentDetailEffect} from './amendmentDetail/amendment_detail.model.effect';
import {
	AmendmentDetailModelState,
	initialState as AmendmentDetailModelInitialState
} from './amendmentDetail/amendment_detail.model.state';
import {BpjsAccidentMasterEffect} from './bpjsAccidentMaster/bpjs_accident_master.model.effect';
import {
	BpjsAccidentMasterModelState,
	initialState as BpjsAccidentMasterModelInitialState
} from './bpjsAccidentMaster/bpjs_accident_master.model.state';
import {BpjsBedAvailabilityEffect} from './bpjsBedAvailability/bpjs_bed_availability.model.effect';
import {
	BpjsBedAvailabilityModelState,
	initialState as BpjsBedAvailabilityModelInitialState
} from './bpjsBedAvailability/bpjs_bed_availability.model.state';
import {BpjsClaimDataEffect} from './bpjsClaimData/bpjs_claim_data.model.effect';
import {
	BpjsClaimDataModelState,
	initialState as BpjsClaimDataModelInitialState
} from './bpjsClaimData/bpjs_claim_data.model.state';
import {BpjsClaimSubmissionEffect} from './bpjsClaimSubmission/bpjs_claim_submission.model.effect';
import {
	BpjsClaimSubmissionModelState,
	initialState as BpjsClaimSubmissionModelInitialState
} from './bpjsClaimSubmission/bpjs_claim_submission.model.state';
import {BpjsControlPlanEffect} from './bpjsControlPlan/bpjs_control_plan.model.effect';
import {
	BpjsControlPlanModelState,
	initialState as BpjsControlPlanModelInitialState
} from './bpjsControlPlan/bpjs_control_plan.model.state';
import {BpjsControlSpecialistEffect} from './bpjsControlSpecialist/bpjs_control_specialist.model.effect';
import {
	BpjsControlSpecialistModelState,
	initialState as BpjsControlSpecialistModelInitialState
} from './bpjsControlSpecialist/bpjs_control_specialist.model.state';
import {BpjsDiagnoseEffect} from './bpjsDiagnose/bpjs_diagnose.model.effect';
import {
	BpjsDiagnoseModelState,
	initialState as BpjsDiagnoseModelInitialState
} from './bpjsDiagnose/bpjs_diagnose.model.state';
import {BpjsDiagnosePRBEffect} from './bpjsDiagnosePRB/bpjs_diagnose_prb.model.effect';
import {
	BpjsDiagnosePRBModelState,
	initialState as BpjsDiagnosePRBModelInitialState
} from './bpjsDiagnosePRB/bpjs_diagnose_prb.model.state';
import {BpjsDismissalConditionEffect} from './bpjsDismissalCondition/bpjs_dismissal_condition.model.effect';
import {
	BpjsDismissalConditionModelState,
	initialState as BpjsDismissalConditionModelInitialState
} from './bpjsDismissalCondition/bpjs_dismissal_condition.model.state';
import {BpjsDismissalMappingEffect} from './bpjsDismissalMapping/bpjs_dismissal_mapping.model.effect';
import {
	BpjsDismissalMappingModelState,
	initialState as BpjsDismissalMappingModelInitialState
} from './bpjsDismissalMapping/bpjs_dismissal_mapping.model.state';
import {BpjsDoctorMappingEffect} from './bpjsDoctorMapping/bpjs_doctor_mapping.model.effect';
import {
	BpjsDoctorMappingModelState,
	initialState as BpjsDoctorMappingModelInitialState
} from './bpjsDoctorMapping/bpjs_doctor_mapping.model.state';
import {BpjsDoctorScheduleEffect} from './bpjsDoctorSchedule/bpjs_doctor_schedule.model.effect';
import {
	BpjsDoctorScheduleModelState,
	initialState as BpjsDoctorScheduleModelInitialState
} from './bpjsDoctorSchedule/bpjs_doctor_schedule.model.state';
import {BpjsDrugGenericPRBEffect} from './bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.effect';
import {
	BpjsDrugGenericPRBModelState,
	initialState as BpjsDrugGenericPRBModelInitialState
} from './bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.state';
import {BpjsFacilityListEffect} from './bpjsFacilityList/bpjs_facility_list.model.effect';
import {
	BpjsFacilityListModelState,
	initialState as BpjsFacilityListModelInitialState
} from './bpjsFacilityList/bpjs_facility_list.model.state';
import {BpjsFingerPrintEffect} from './bpjsFingerPrint/bpjs_finger_print.model.effect';
import {
	BpjsFingerPrintModelState,
	initialState as BpjsFingerPrintModelInitialState
} from './bpjsFingerPrint/bpjs_finger_print.model.state';
import {BpjsGeneralEffect} from './bpjsGeneral/bpjs_general.model.effect';
import {
	BpjsGeneralModelState,
	initialState as BpjsGeneralModelInitialState
} from './bpjsGeneral/bpjs_general.model.state';
import {BpjsHealthFacilityEffect} from './bpjsHealthFacility/bpjs_health_facility.model.effect';
import {
	BpjsHealthFacilityModelState,
	initialState as BpjsHealthFacilityModelInitialState
} from './bpjsHealthFacility/bpjs_health_facility.model.state';
import {BpjsHospitalizationPlanEffect} from './bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.effect';
import {
	BpjsHospitalizationPlanModelState,
	initialState as BpjsHospitalizationPlanModelInitialState
} from './bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.state';
import {BpjsINACBGEffect} from './bpjsINACBG/bpjs_inacbg.model.effect';
import {
	BpjsINACBGModelState,
	initialState as BpjsINACBGModelInitialState
} from './bpjsINACBG/bpjs_inacbg.model.state';
import {BpjsINACBGClaimEffect} from './bpjsINACBGClaim/bpjs_inacbg_claim.model.effect';
import {
	BpjsINACBGClaimModelState,
	initialState as BpjsINACBGClaimModelInitialState
} from './bpjsINACBGClaim/bpjs_inacbg_claim.model.state';
import {BpjsINACBGVariableEffect} from './bpjsINACBGVariable/bpjs_inacbg_variable.model.effect';
import {
	BpjsINACBGVariableModelState,
	initialState as BpjsINACBGVariableModelInitialState
} from './bpjsINACBGVariable/bpjs_inacbg_variable.model.state';
import {BpjsJasaRaharjaEffect} from './bpjsJasaRaharja/bpjs_jasa_raharja.model.effect';
import {
	BpjsJasaRaharjaModelState,
	initialState as BpjsJasaRaharjaModelInitialState
} from './bpjsJasaRaharja/bpjs_jasa_raharja.model.state';
import {BpjsJasaRaharjaClaimEffect} from './bpjsJasaRaharjaClaim/bpjs_jasa_raharja_claim.model.effect';
import {
	BpjsJasaRaharjaClaimModelState,
	initialState as BpjsJasaRaharjaClaimModelInitialState
} from './bpjsJasaRaharjaClaim/bpjs_jasa_raharja_claim.model.state';
import {BpjsListFingerPrintEffect} from './bpjsListFingerPrint/bpjs_list_finger_print.model.effect';
import {
	BpjsListFingerPrintModelState,
	initialState as BpjsListFingerPrintModelInitialState
} from './bpjsListFingerPrint/bpjs_list_finger_print.model.state';
import {BpjsListTaskEffect} from './bpjsListTask/bpjs_list_task.model.effect';
import {
	BpjsListTaskModelState,
	initialState as BpjsListTaskModelInitialState
} from './bpjsListTask/bpjs_list_task.model.state';
import {BpjsOutsideFacilityReferralEffect} from './bpjsOutsideFacilityReferral/bpjs_outside_facility_referral.model.effect';
import {
	BpjsOutsideFacilityReferralModelState,
	initialState as BpjsOutsideFacilityReferralModelInitialState
} from './bpjsOutsideFacilityReferral/bpjs_outside_facility_referral.model.state';
import {BpjsPRBEffect} from './bpjsPRB/bpjs_prb.model.effect';
import {
	BpjsPRBModelState,
	initialState as BpjsPRBModelInitialState
} from './bpjsPRB/bpjs_prb.model.state';
import {BpjsPRBDetailEffect} from './bpjsPRBDetail/bpjs_prb_detail.model.effect';
import {
	BpjsPRBDetailModelState,
	initialState as BpjsPRBDetailModelInitialState
} from './bpjsPRBDetail/bpjs_prb_detail.model.state';
import {BpjsPatientReferralEffect} from './bpjsPatientReferral/bpjs_patient_referral.model.effect';
import {
	BpjsPatientReferralModelState,
	initialState as BpjsPatientReferralModelInitialState
} from './bpjsPatientReferral/bpjs_patient_referral.model.state';
import {BpjsPcareDPHOEffect} from './bpjsPcareDPHO/bpjs_pcare_dpho.model.effect';
import {
	BpjsPcareDPHOModelState,
	initialState as BpjsPcareDPHOModelInitialState
} from './bpjsPcareDPHO/bpjs_pcare_dpho.model.state';
import {BpjsPcareKegiatanKelompokEffect} from './bpjsPcareKegiatanKelompok/bpjs_pcare_kegiatan_kelompok.model.effect';
import {
	BpjsPcareKegiatanKelompokModelState,
	initialState as BpjsPcareKegiatanKelompokModelInitialState
} from './bpjsPcareKegiatanKelompok/bpjs_pcare_kegiatan_kelompok.model.state';
import {BpjsPcareKesadaranEffect} from './bpjsPcareKesadaran/bpjs_pcare_kesadaran.model.effect';
import {
	BpjsPcareKesadaranModelState,
	initialState as BpjsPcareKesadaranModelInitialState
} from './bpjsPcareKesadaran/bpjs_pcare_kesadaran.model.state';
import {BpjsPcarePesertaKegiatanKelompokEffect} from './bpjsPcarePesertaKegiatanKelompok/bpjs_pcare_peserta_kegiatan_kelompok.model.effect';
import {
	BpjsPcarePesertaKegiatanKelompokModelState,
	initialState as BpjsPcarePesertaKegiatanKelompokModelInitialState
} from './bpjsPcarePesertaKegiatanKelompok/bpjs_pcare_peserta_kegiatan_kelompok.model.state';
import {BpjsPcarePoliEffect} from './bpjsPcarePoli/bpjs_pcare_poli.model.effect';
import {
	BpjsPcarePoliModelState,
	initialState as BpjsPcarePoliModelInitialState
} from './bpjsPcarePoli/bpjs_pcare_poli.model.state';
import {BpjsPcareProviderRayonisasiEffect} from './bpjsPcareProviderRayonisasi/bpjs_pcare_provider_rayonisasi.model.effect';
import {
	BpjsPcareProviderRayonisasiModelState,
	initialState as BpjsPcareProviderRayonisasiModelInitialState
} from './bpjsPcareProviderRayonisasi/bpjs_pcare_provider_rayonisasi.model.state';
import {BpjsPcareRegistrationsEffect} from './bpjsPcareRegistrations/bpjs_pcare_registrations.model.effect';
import {
	BpjsPcareRegistrationsModelState,
	initialState as BpjsPcareRegistrationsModelInitialState
} from './bpjsPcareRegistrations/bpjs_pcare_registrations.model.state';
import {BpjsProcedureEffect} from './bpjsProcedure/bpjs_procedure.model.effect';
import {
	BpjsProcedureModelState,
	initialState as BpjsProcedureModelInitialState
} from './bpjsProcedure/bpjs_procedure.model.state';
import {BpjsReferralSpecialistEffect} from './bpjsReferralSpecialist/bpjs_referral_specialist.model.effect';
import {
	BpjsReferralSpecialistModelState,
	initialState as BpjsReferralSpecialistModelInitialState
} from './bpjsReferralSpecialist/bpjs_referral_specialist.model.state';
import {BpjsSEPEffect} from './bpjsSEP/bpjs_sep.model.effect';
import {
	BpjsSEPModelState,
	initialState as BpjsSEPModelInitialState
} from './bpjsSEP/bpjs_sep.model.state';
import {BpjsSEPINACBGIntegrationEffect} from './bpjsSEPINACBGIntegration/bpjs_sep_inacbg_integration.model.effect';
import {
	BpjsSEPINACBGIntegrationModelState,
	initialState as BpjsSEPINACBGIntegrationModelInitialState
} from './bpjsSEPINACBGIntegration/bpjs_sep_inacbg_integration.model.state';
import {BpjsSEPInternalDataEffect} from './bpjsSEPInternalData/bpjs_sep_internal_data.model.effect';
import {
	BpjsSEPInternalDataModelState,
	initialState as BpjsSEPInternalDataModelInitialState
} from './bpjsSEPInternalData/bpjs_sep_internal_data.model.state';
import {BpjsSEPSubmissionEffect} from './bpjsSEPSubmission/bpjs_sep_submission.model.effect';
import {
	BpjsSEPSubmissionModelState,
	initialState as BpjsSEPSubmissionModelInitialState
} from './bpjsSEPSubmission/bpjs_sep_submission.model.state';
import {BpjsSearchControlLetterEffect} from './bpjsSearchControlLetter/bpjs_search_control_letter.model.effect';
import {
	BpjsSearchControlLetterModelState,
	initialState as BpjsSearchControlLetterModelInitialState
} from './bpjsSearchControlLetter/bpjs_search_control_letter.model.state';
import {BpjsSearchSEPEffect} from './bpjsSearchSEP/bpjs_search_sep.model.effect';
import {
	BpjsSearchSEPModelState,
	initialState as BpjsSearchSEPModelInitialState
} from './bpjsSearchSEP/bpjs_search_sep.model.state';
import {BpjsServiceMappingEffect} from './bpjsServiceMapping/bpjs_service_mapping.model.effect';
import {
	BpjsServiceMappingModelState,
	initialState as BpjsServiceMappingModelInitialState
} from './bpjsServiceMapping/bpjs_service_mapping.model.state';
import {BpjsSpecialReferralEffect} from './bpjsSpecialReferral/bpjs_special_referral.model.effect';
import {
	BpjsSpecialReferralModelState,
	initialState as BpjsSpecialReferralModelInitialState
} from './bpjsSpecialReferral/bpjs_special_referral.model.state';
import {BpjsTotalReferralSEPEffect} from './bpjsTotalReferralSEP/bpjs_total_referral_sep.model.effect';
import {
	BpjsTotalReferralSEPModelState,
	initialState as BpjsTotalReferralSEPModelInitialState
} from './bpjsTotalReferralSEP/bpjs_total_referral_sep.model.state';
import {BpjsTreatmentClassMappingEffect} from './bpjsTreatmentClassMapping/bpjs_treatment_class_mapping.model.effect';
import {
	BpjsTreatmentClassMappingModelState,
	initialState as BpjsTreatmentClassMappingModelInitialState
} from './bpjsTreatmentClassMapping/bpjs_treatment_class_mapping.model.state';
import {BpjsTreatmentHistoryEffect} from './bpjsTreatmentHistory/bpjs_treatment_history.model.effect';
import {
	BpjsTreatmentHistoryModelState,
	initialState as BpjsTreatmentHistoryModelInitialState
} from './bpjsTreatmentHistory/bpjs_treatment_history.model.state';
import {BpjsTreatmentRoomEffect} from './bpjsTreatmentRoom/bpjs_treatment_room.model.effect';
import {
	BpjsTreatmentRoomModelState,
	initialState as BpjsTreatmentRoomModelInitialState
} from './bpjsTreatmentRoom/bpjs_treatment_room.model.state';
import {BpjsUpdateDismissalDateEffect} from './bpjsUpdateDismissalDate/bpjs_update_dismissal_date.model.effect';
import {
	BpjsUpdateDismissalDateModelState,
	initialState as BpjsUpdateDismissalDateModelInitialState
} from './bpjsUpdateDismissalDate/bpjs_update_dismissal_date.model.state';
import {BpjsVisitDataEffect} from './bpjsVisitData/bpjs_visit_data.model.effect';
import {
	BpjsVisitDataModelState,
	initialState as BpjsVisitDataModelInitialState
} from './bpjsVisitData/bpjs_visit_data.model.state';
import {BatchStockBalanceEffect} from './batchStockBalance/batch_stock_balance.model.effect';
import {
	BatchStockBalanceModelState,
	initialState as BatchStockBalanceModelInitialState
} from './batchStockBalance/batch_stock_balance.model.state';
import {BatchStockBalancePerDateEffect} from './batchStockBalancePerDate/batch_stock_balance_per_date.model.effect';
import {
	BatchStockBalancePerDateModelState,
	initialState as BatchStockBalancePerDateModelInitialState
} from './batchStockBalancePerDate/batch_stock_balance_per_date.model.state';
import {BatchStockTransactionDetailEffect} from './batchStockTransactionDetail/batch_stock_transaction_detail.model.effect';
import {
	BatchStockTransactionDetailModelState,
	initialState as BatchStockTransactionDetailModelInitialState
} from './batchStockTransactionDetail/batch_stock_transaction_detail.model.state';
import {BedFacilityEffect} from './bedFacility/bed_facility.model.effect';
import {
	BedFacilityModelState,
	initialState as BedFacilityModelInitialState
} from './bedFacility/bed_facility.model.state';
import {BedReserveEffect} from './bedReserve/bed_reserve.model.effect';
import {
	BedReserveModelState,
	initialState as BedReserveModelInitialState
} from './bedReserve/bed_reserve.model.state';
import {BirthHistoryEffect} from './birthHistory/birth_history.model.effect';
import {
	BirthHistoryModelState,
	initialState as BirthHistoryModelInitialState
} from './birthHistory/birth_history.model.state';
import {BodyChartExaminationEffect} from './bodyChartExamination/body_chart_examination.model.effect';
import {
	BodyChartExaminationModelState,
	initialState as BodyChartExaminationModelInitialState
} from './bodyChartExamination/body_chart_examination.model.state';
import {BpjsPcareKunjunganRujukanEffect} from './bpjsPcareKunjunganRujukan/bpjs_pcare_kunjungan_rujukan.model.effect';
import {
	BpjsPcareKunjunganRujukanModelState,
	initialState as BpjsPcareKunjunganRujukanModelInitialState
} from './bpjsPcareKunjunganRujukan/bpjs_pcare_kunjungan_rujukan.model.state';
import {BpjsPcarePendaftaranEffect} from './bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.effect';
import {
	BpjsPcarePendaftaranModelState,
	initialState as BpjsPcarePendaftaranModelInitialState
} from './bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.state';
import {BpjsPcareRiwayatKunjunganEffect} from './bpjsPcareRiwayatKunjungan/bpjs_pcare_riwayat_kunjungan.model.effect';
import {
	BpjsPcareRiwayatKunjunganModelState,
	initialState as BpjsPcareRiwayatKunjunganModelInitialState
} from './bpjsPcareRiwayatKunjungan/bpjs_pcare_riwayat_kunjungan.model.state';
import {CashAllocationEffect} from './cashAllocation/cash_allocation.model.effect';
import {
	CashAllocationModelState,
	initialState as CashAllocationModelInitialState
} from './cashAllocation/cash_allocation.model.state';
import {CashReceiptEffect} from './cashReceipt/cash_receipt.model.effect';
import {
	CashReceiptModelState,
	initialState as CashReceiptModelInitialState
} from './cashReceipt/cash_receipt.model.state';
import {CashRefundEffect} from './cashRefund/cash_refund.model.effect';
import {
	CashRefundModelState,
	initialState as CashRefundModelInitialState
} from './cashRefund/cash_refund.model.state';
import {CashierUserEffect} from './cashierUser/cashier_user.model.effect';
import {
	CashierUserModelState,
	initialState as CashierUserModelInitialState
} from './cashierUser/cashier_user.model.state';
import {CatalogueMedicalEffect} from './catalogueMedical/catalogue_medical.model.effect';
import {
	CatalogueMedicalModelState,
	initialState as CatalogueMedicalModelInitialState
} from './catalogueMedical/catalogue_medical.model.state';
import {CatalogueNonMedicalEffect} from './catalogueNonMedical/catalogue_non_medical.model.effect';
import {
	CatalogueNonMedicalModelState,
	initialState as CatalogueNonMedicalModelInitialState
} from './catalogueNonMedical/catalogue_non_medical.model.state';
import {CatalogueUOMEffect} from './catalogueUOM/catalogue_uom.model.effect';
import {
	CatalogueUOMModelState,
	initialState as CatalogueUOMModelInitialState
} from './catalogueUOM/catalogue_uom.model.state';
import {ChartOfAccountEffect} from './chartOfAccount/chart_of_account.model.effect';
import {
	ChartOfAccountModelState,
	initialState as ChartOfAccountModelInitialState
} from './chartOfAccount/chart_of_account.model.state';
import {ChartOfAccountMappingEffect} from './chartOfAccountMapping/chart_of_account_mapping.model.effect';
import {
	ChartOfAccountMappingModelState,
	initialState as ChartOfAccountMappingModelInitialState
} from './chartOfAccountMapping/chart_of_account_mapping.model.state';
import {ClaimUserEffect} from './claimUser/claim_user.model.effect';
import {
	ClaimUserModelState,
	initialState as ClaimUserModelInitialState
} from './claimUser/claim_user.model.state';
import {CoTreatingDoctorEffect} from './coTreatingDoctor/co_treating_doctor.model.effect';
import {
	CoTreatingDoctorModelState,
	initialState as CoTreatingDoctorModelInitialState
} from './coTreatingDoctor/co_treating_doctor.model.state';
import {CompoundPrescriptionDetailEffect} from './compoundPrescriptionDetail/compound_prescription_detail.model.effect';
import {
	CompoundPrescriptionDetailModelState,
	initialState as CompoundPrescriptionDetailModelInitialState
} from './compoundPrescriptionDetail/compound_prescription_detail.model.state';
import {CompoundPrescriptionItemEffect} from './compoundPrescriptionItem/compound_prescription_item.model.effect';
import {
	CompoundPrescriptionItemModelState,
	initialState as CompoundPrescriptionItemModelInitialState
} from './compoundPrescriptionItem/compound_prescription_item.model.state';
import {DailyCareCPPTEffect} from './dailyCareCPPT/daily_care_cppt.model.effect';
import {
	DailyCareCPPTModelState,
	initialState as DailyCareCPPTModelInitialState
} from './dailyCareCPPT/daily_care_cppt.model.state';
import {DeliveryMedicalExaminationRecordEffect} from './deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.effect';
import {
	DeliveryMedicalExaminationRecordModelState,
	initialState as DeliveryMedicalExaminationRecordModelInitialState
} from './deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.state';
import {DeliveryProgressEffect} from './deliveryProgress/delivery_progress.model.effect';
import {
	DeliveryProgressModelState,
	initialState as DeliveryProgressModelInitialState
} from './deliveryProgress/delivery_progress.model.state';
import {DiagnosesAndProceduresEffect} from './diagnosesAndProcedures/diagnoses_and_procedures.model.effect';
import {
	DiagnosesAndProceduresModelState,
	initialState as DiagnosesAndProceduresModelInitialState
} from './diagnosesAndProcedures/diagnoses_and_procedures.model.state';
import {DiagnosisExaminationRecordEffect} from './diagnosisExaminationRecord/diagnosis_examination_record.model.effect';
import {
	DiagnosisExaminationRecordModelState,
	initialState as DiagnosisExaminationRecordModelInitialState
} from './diagnosisExaminationRecord/diagnosis_examination_record.model.state';
import {DiagnosisNandaEffect} from './diagnosisNanda/diagnosis_nanda.model.effect';
import {
	DiagnosisNandaModelState,
	initialState as DiagnosisNandaModelInitialState
} from './diagnosisNanda/diagnosis_nanda.model.state';
import {DiagnosticExaminationResultsEffect} from './diagnosticExaminationResults/diagnostic_examination_results.model.effect';
import {
	DiagnosticExaminationResultsModelState,
	initialState as DiagnosticExaminationResultsModelInitialState
} from './diagnosticExaminationResults/diagnostic_examination_results.model.state';
import {DiagnosticStaffExaminationSummaryEffect} from './diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.effect';
import {
	DiagnosticStaffExaminationSummaryModelState,
	initialState as DiagnosticStaffExaminationSummaryModelInitialState
} from './diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.state';
import {DiagnosticSupportGeneralConfigurationEffect} from './diagnosticSupportGeneralConfiguration/diagnostic_support_general_configuration.model.effect';
import {
	DiagnosticSupportGeneralConfigurationModelState,
	initialState as DiagnosticSupportGeneralConfigurationModelInitialState
} from './diagnosticSupportGeneralConfiguration/diagnostic_support_general_configuration.model.state';
import {DiagnosticSupportUserEffect} from './diagnosticSupportUser/diagnostic_support_user.model.effect';
import {
	DiagnosticSupportUserModelState,
	initialState as DiagnosticSupportUserModelInitialState
} from './diagnosticSupportUser/diagnostic_support_user.model.state';
import {DoctorScheduleEffect} from './doctorSchedule/doctor_schedule.model.effect';
import {
	DoctorScheduleModelState,
	initialState as DoctorScheduleModelInitialState
} from './doctorSchedule/doctor_schedule.model.state';
import {DoctorUserEffect} from './doctorUser/doctor_user.model.effect';
import {
	DoctorUserModelState,
	initialState as DoctorUserModelInitialState
} from './doctorUser/doctor_user.model.state';
import {EntExaminationEffect} from './entExamination/ent_examination.model.effect';
import {
	EntExaminationModelState,
	initialState as EntExaminationModelInitialState
} from './entExamination/ent_examination.model.state';
import {EmergencyMedicalExaminationRecordEffect} from './emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.effect';
import {
	EmergencyMedicalExaminationRecordModelState,
	initialState as EmergencyMedicalExaminationRecordModelInitialState
} from './emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.state';
import {ExaminationGroupEffect} from './examinationGroup/examination_group.model.effect';
import {
	ExaminationGroupModelState,
	initialState as ExaminationGroupModelInitialState
} from './examinationGroup/examination_group.model.state';
import {ExaminationItemEffect} from './examinationItem/examination_item.model.effect';
import {
	ExaminationItemModelState,
	initialState as ExaminationItemModelInitialState
} from './examinationItem/examination_item.model.state';
import {ExaminationItemDetailEffect} from './examinationItemDetail/examination_item_detail.model.effect';
import {
	ExaminationItemDetailModelState,
	initialState as ExaminationItemDetailModelInitialState
} from './examinationItemDetail/examination_item_detail.model.state';
import {FacilityHistoryEffect} from './facilityHistory/facility_history.model.effect';
import {
	FacilityHistoryModelState,
	initialState as FacilityHistoryModelInitialState
} from './facilityHistory/facility_history.model.state';
import {FacilityUserEffect} from './facilityUser/facility_user.model.effect';
import {
	FacilityUserModelState,
	initialState as FacilityUserModelInitialState
} from './facilityUser/facility_user.model.state';
import {FluidBalanceDetailEffect} from './fluidBalanceDetail/fluid_balance_detail.model.effect';
import {
	FluidBalanceDetailModelState,
	initialState as FluidBalanceDetailModelInitialState
} from './fluidBalanceDetail/fluid_balance_detail.model.state';
import {FormulirKonselingTesHivEffect} from './formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.effect';
import {
	FormulirKonselingTesHivModelState,
	initialState as FormulirKonselingTesHivModelInitialState
} from './formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.state';
import {GoodsReceiveNoteEffect} from './goodsReceiveNote/goods_receive_note.model.effect';
import {
	GoodsReceiveNoteModelState,
	initialState as GoodsReceiveNoteModelInitialState
} from './goodsReceiveNote/goods_receive_note.model.state';
import {GoodsReceiveNoteBatchEffect} from './goodsReceiveNoteBatch/goods_receive_note_batch.model.effect';
import {
	GoodsReceiveNoteBatchModelState,
	initialState as GoodsReceiveNoteBatchModelInitialState
} from './goodsReceiveNoteBatch/goods_receive_note_batch.model.state';
import {GoodsReceiveNoteItemEffect} from './goodsReceiveNoteItem/goods_receive_note_item.model.effect';
import {
	GoodsReceiveNoteItemModelState,
	initialState as GoodsReceiveNoteItemModelInitialState
} from './goodsReceiveNoteItem/goods_receive_note_item.model.state';
import {HealthFacilityEffect} from './healthFacility/health_facility.model.effect';
import {
	HealthFacilityModelState,
	initialState as HealthFacilityModelInitialState
} from './healthFacility/health_facility.model.state';
import {HemodialysisExaminationEffect} from './hemodialysisExamination/hemodialysis_examination.model.effect';
import {
	HemodialysisExaminationModelState,
	initialState as HemodialysisExaminationModelInitialState
} from './hemodialysisExamination/hemodialysis_examination.model.state';
import {HemodialysisMonitoringEffect} from './hemodialysisMonitoring/hemodialysis_monitoring.model.effect';
import {
	HemodialysisMonitoringModelState,
	initialState as HemodialysisMonitoringModelInitialState
} from './hemodialysisMonitoring/hemodialysis_monitoring.model.state';
import {HospitalBranchInformationEffect} from './hospitalBranchInformation/hospital_branch_information.model.effect';
import {
	HospitalBranchInformationModelState,
	initialState as HospitalBranchInformationModelInitialState
} from './hospitalBranchInformation/hospital_branch_information.model.state';
import {HospitalGroupInformationEffect} from './hospitalGroupInformation/hospital_group_information.model.effect';
import {
	HospitalGroupInformationModelState,
	initialState as HospitalGroupInformationModelInitialState
} from './hospitalGroupInformation/hospital_group_information.model.state';
import {Icd10Effect} from './icd10/icd_10.model.effect';
import {
	Icd10ModelState,
	initialState as Icd10ModelInitialState
} from './icd10/icd_10.model.state';
import {Icd9CMEffect} from './icd9CM/icd_9_cm.model.effect';
import {
	Icd9CMModelState,
	initialState as Icd9CMModelInitialState
} from './icd9CM/icd_9_cm.model.state';
import {InformedConsentEffect} from './informedConsent/informed_consent.model.effect';
import {
	InformedConsentModelState,
	initialState as InformedConsentModelInitialState
} from './informedConsent/informed_consent.model.state';
import {InpatientMedicalExaminationRecordEffect} from './inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.effect';
import {
	InpatientMedicalExaminationRecordModelState,
	initialState as InpatientMedicalExaminationRecordModelInitialState
} from './inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.state';
import {InsuranceBenefitPlanEffect} from './insuranceBenefitPlan/insurance_benefit_plan.model.effect';
import {
	InsuranceBenefitPlanModelState,
	initialState as InsuranceBenefitPlanModelInitialState
} from './insuranceBenefitPlan/insurance_benefit_plan.model.state';
import {InsuranceProviderEffect} from './insuranceProvider/insurance_provider.model.effect';
import {
	InsuranceProviderModelState,
	initialState as InsuranceProviderModelInitialState
} from './insuranceProvider/insurance_provider.model.state';
import {InternalOrderEffect} from './internalOrder/internal_order.model.effect';
import {
	InternalOrderModelState,
	initialState as InternalOrderModelInitialState
} from './internalOrder/internal_order.model.state';
import {InternalOrderStockDetailEffect} from './internalOrderStockDetail/internal_order_stock_detail.model.effect';
import {
	InternalOrderStockDetailModelState,
	initialState as InternalOrderStockDetailModelInitialState
} from './internalOrderStockDetail/internal_order_stock_detail.model.state';
import {IntraoperativeRecordsEffect} from './intraoperativeRecords/intraoperative_records.model.effect';
import {
	IntraoperativeRecordsModelState,
	initialState as IntraoperativeRecordsModelInitialState
} from './intraoperativeRecords/intraoperative_records.model.state';
import {InventoryAdjusmentBatchEffect} from './inventoryAdjusmentBatch/inventory_adjusment_batch.model.effect';
import {
	InventoryAdjusmentBatchModelState,
	initialState as InventoryAdjusmentBatchModelInitialState
} from './inventoryAdjusmentBatch/inventory_adjusment_batch.model.state';
import {InventoryAdjustmentEffect} from './inventoryAdjustment/inventory_adjustment.model.effect';
import {
	InventoryAdjustmentModelState,
	initialState as InventoryAdjustmentModelInitialState
} from './inventoryAdjustment/inventory_adjustment.model.state';
import {InventoryAdjustmentItemEffect} from './inventoryAdjustmentItem/inventory_adjustment_item.model.effect';
import {
	InventoryAdjustmentItemModelState,
	initialState as InventoryAdjustmentItemModelInitialState
} from './inventoryAdjustmentItem/inventory_adjustment_item.model.state';
import {InventoryBatchCorrectionEffect} from './inventoryBatchCorrection/inventory_batch_correction.model.effect';
import {
	InventoryBatchCorrectionModelState,
	initialState as InventoryBatchCorrectionModelInitialState
} from './inventoryBatchCorrection/inventory_batch_correction.model.state';
import {InventoryBatchCorrectionItemEffect} from './inventoryBatchCorrectionItem/inventory_batch_correction_item.model.effect';
import {
	InventoryBatchCorrectionItemModelState,
	initialState as InventoryBatchCorrectionItemModelInitialState
} from './inventoryBatchCorrectionItem/inventory_batch_correction_item.model.state';
import {InvoiceEffect} from './invoice/invoice.model.effect';
import {
	InvoiceModelState,
	initialState as InvoiceModelInitialState
} from './invoice/invoice.model.state';
import {InvoiceItemEffect} from './invoiceItem/invoice_item.model.effect';
import {
	InvoiceItemModelState,
	initialState as InvoiceItemModelInitialState
} from './invoiceItem/invoice_item.model.state';
import {InvoiceItemComponentEffect} from './invoiceItemComponent/invoice_item_component.model.effect';
import {
	InvoiceItemComponentModelState,
	initialState as InvoiceItemComponentModelInitialState
} from './invoiceItemComponent/invoice_item_component.model.state';
import {InvoicePaymentInsuranceEffect} from './invoicePaymentInsurance/invoice_payment_insurance.model.effect';
import {
	InvoicePaymentInsuranceModelState,
	initialState as InvoicePaymentInsuranceModelInitialState
} from './invoicePaymentInsurance/invoice_payment_insurance.model.state';
import {InvoicePaymentOtherEffect} from './invoicePaymentOther/invoice_payment_other.model.effect';
import {
	InvoicePaymentOtherModelState,
	initialState as InvoicePaymentOtherModelInitialState
} from './invoicePaymentOther/invoice_payment_other.model.state';
import {InvoicePaymentSelfPayingEffect} from './invoicePaymentSelfPaying/invoice_payment_self_paying.model.effect';
import {
	InvoicePaymentSelfPayingModelState,
	initialState as InvoicePaymentSelfPayingModelInitialState
} from './invoicePaymentSelfPaying/invoice_payment_self_paying.model.state';
import {InvoiceSummaryEffect} from './invoiceSummary/invoice_summary.model.effect';
import {
	InvoiceSummaryModelState,
	initialState as InvoiceSummaryModelInitialState
} from './invoiceSummary/invoice_summary.model.state';
import {JournalEffect} from './journal/journal.model.effect';
import {
	JournalModelState,
	initialState as JournalModelInitialState
} from './journal/journal.model.state';
import {LibraryEffect} from './library/library.model.effect';
import {
	LibraryModelState,
	initialState as LibraryModelInitialState
} from './library/library.model.state';
import {LocationEffect} from './location/location.model.effect';
import {
	LocationModelState,
	initialState as LocationModelInitialState
} from './location/location.model.state';
import {McuPackageEffect} from './mcuPackage/mcu_package.model.effect';
import {
	McuPackageModelState,
	initialState as McuPackageModelInitialState
} from './mcuPackage/mcu_package.model.state';
import {McuPackageItemEffect} from './mcuPackageItem/mcu_package_item.model.effect';
import {
	McuPackageItemModelState,
	initialState as McuPackageItemModelInitialState
} from './mcuPackageItem/mcu_package_item.model.state';
import {ManagementUserEffect} from './managementUser/management_user.model.effect';
import {
	ManagementUserModelState,
	initialState as ManagementUserModelInitialState
} from './managementUser/management_user.model.state';
import {MedicalCertificateDischargeResumeEffect} from './medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.effect';
import {
	MedicalCertificateDischargeResumeModelState,
	initialState as MedicalCertificateDischargeResumeModelInitialState
} from './medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.state';
import {MedicalCertificateBirthEffect} from './medicalCertificateBirth/medical_certificate_birth.model.effect';
import {
	MedicalCertificateBirthModelState,
	initialState as MedicalCertificateBirthModelInitialState
} from './medicalCertificateBirth/medical_certificate_birth.model.state';
import {MedicalCertificateHospitalizationEffect} from './medicalCertificateHospitalization/medical_certificate_hospitalization.model.effect';
import {
	MedicalCertificateHospitalizationModelState,
	initialState as MedicalCertificateHospitalizationModelInitialState
} from './medicalCertificateHospitalization/medical_certificate_hospitalization.model.state';
import {MedicalCertificateMedicalAttendanceEffect} from './medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.effect';
import {
	MedicalCertificateMedicalAttendanceModelState,
	initialState as MedicalCertificateMedicalAttendanceModelInitialState
} from './medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.state';
import {MedicalCertificateMentalHealthEffect} from './medicalCertificateMentalHealth/medical_certificate_mental_health.model.effect';
import {
	MedicalCertificateMentalHealthModelState,
	initialState as MedicalCertificateMentalHealthModelInitialState
} from './medicalCertificateMentalHealth/medical_certificate_mental_health.model.state';
import {MedicalCertificatePhysicalHealthEffect} from './medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.effect';
import {
	MedicalCertificatePhysicalHealthModelState,
	initialState as MedicalCertificatePhysicalHealthModelInitialState
} from './medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.state';
import {MedicalCertificateRestrictedWorkEffect} from './medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.effect';
import {
	MedicalCertificateRestrictedWorkModelState,
	initialState as MedicalCertificateRestrictedWorkModelInitialState
} from './medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.state';
import {MedicalCertificateSickLeaveEffect} from './medicalCertificateSickLeave/medical_certificate_sick_leave.model.effect';
import {
	MedicalCertificateSickLeaveModelState,
	initialState as MedicalCertificateSickLeaveModelInitialState
} from './medicalCertificateSickLeave/medical_certificate_sick_leave.model.state';
import {MedicalExaminationRecordEffect} from './medicalExaminationRecord/medical_examination_record.model.effect';
import {
	MedicalExaminationRecordModelState,
	initialState as MedicalExaminationRecordModelInitialState
} from './medicalExaminationRecord/medical_examination_record.model.state';
import {MedicalExaminationRecordDischargeSummaryEffect} from './medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.effect';
import {
	MedicalExaminationRecordDischargeSummaryModelState,
	initialState as MedicalExaminationRecordDischargeSummaryModelInitialState
} from './medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.state';
import {MedicalFeeEffect} from './medicalFee/medical_fee.model.effect';
import {
	MedicalFeeModelState,
	initialState as MedicalFeeModelInitialState
} from './medicalFee/medical_fee.model.state';
import {MedicalFeeItemComponentEffect} from './medicalFeeItemComponent/medical_fee_item_component.model.effect';
import {
	MedicalFeeItemComponentModelState,
	initialState as MedicalFeeItemComponentModelInitialState
} from './medicalFeeItemComponent/medical_fee_item_component.model.state';
import {MedicalRecordInitialChecklistEffect} from './medicalRecordInitialChecklist/medical_record_initial_checklist.model.effect';
import {
	MedicalRecordInitialChecklistModelState,
	initialState as MedicalRecordInitialChecklistModelInitialState
} from './medicalRecordInitialChecklist/medical_record_initial_checklist.model.state';
import {MedicalRecordNextVerificationChecklistEffect} from './medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.effect';
import {
	MedicalRecordNextVerificationChecklistModelState,
	initialState as MedicalRecordNextVerificationChecklistModelInitialState
} from './medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.state';
import {MedicalRecordUserEffect} from './medicalRecordUser/medical_record_user.model.effect';
import {
	MedicalRecordUserModelState,
	initialState as MedicalRecordUserModelInitialState
} from './medicalRecordUser/medical_record_user.model.state';
import {MedicalTranscriberUserEffect} from './medicalTranscriberUser/medical_transcriber_user.model.effect';
import {
	MedicalTranscriberUserModelState,
	initialState as MedicalTranscriberUserModelInitialState
} from './medicalTranscriberUser/medical_transcriber_user.model.state';
import {MedicationAdministeredHistoryEffect} from './medicationAdministeredHistory/medication_administered_history.model.effect';
import {
	MedicationAdministeredHistoryModelState,
	initialState as MedicationAdministeredHistoryModelInitialState
} from './medicationAdministeredHistory/medication_administered_history.model.state';
import {MedicationCompoundEffect} from './medicationCompound/medication_compound.model.effect';
import {
	MedicationCompoundModelState,
	initialState as MedicationCompoundModelInitialState
} from './medicationCompound/medication_compound.model.state';
import {MedicationHeaderEffect} from './medicationHeader/medication_header.model.effect';
import {
	MedicationHeaderModelState,
	initialState as MedicationHeaderModelInitialState
} from './medicationHeader/medication_header.model.state';
import {MedicationItemEffect} from './medicationItem/medication_item.model.effect';
import {
	MedicationItemModelState,
	initialState as MedicationItemModelInitialState
} from './medicationItem/medication_item.model.state';
import {MerchantEffect} from './merchant/merchant.model.effect';
import {
	MerchantModelState,
	initialState as MerchantModelInitialState
} from './merchant/merchant.model.state';
import {MerchantSurchargeAndFeeEffect} from './merchantSurchargeAndFee/merchant_surcharge_and_fee.model.effect';
import {
	MerchantSurchargeAndFeeModelState,
	initialState as MerchantSurchargeAndFeeModelInitialState
} from './merchantSurchargeAndFee/merchant_surcharge_and_fee.model.state';
import {NhisClaimEffect} from './nhisClaim/nhis_claim.model.effect';
import {
	NhisClaimModelState,
	initialState as NhisClaimModelInitialState
} from './nhisClaim/nhis_claim.model.state';
import {NhisClaimGDRGDetailEffect} from './nhisClaimGDRGDetail/nhis_claim_gdrg_detail.model.effect';
import {
	NhisClaimGDRGDetailModelState,
	initialState as NhisClaimGDRGDetailModelInitialState
} from './nhisClaimGDRGDetail/nhis_claim_gdrg_detail.model.state';
import {NhisClaimInvestigationDetailEffect} from './nhisClaimInvestigationDetail/nhis_claim_investigation_detail.model.effect';
import {
	NhisClaimInvestigationDetailModelState,
	initialState as NhisClaimInvestigationDetailModelInitialState
} from './nhisClaimInvestigationDetail/nhis_claim_investigation_detail.model.state';
import {NhisGDRGEffect} from './nhisGDRG/nhis_gdrg.model.effect';
import {
	NhisGDRGModelState,
	initialState as NhisGDRGModelInitialState
} from './nhisGDRG/nhis_gdrg.model.state';
import {NhisInvestigationEffect} from './nhisInvestigation/nhis_investigation.model.effect';
import {
	NhisInvestigationModelState,
	initialState as NhisInvestigationModelInitialState
} from './nhisInvestigation/nhis_investigation.model.state';
import {NhisMedicineEffect} from './nhisMedicine/nhis_medicine.model.effect';
import {
	NhisMedicineModelState,
	initialState as NhisMedicineModelInitialState
} from './nhisMedicine/nhis_medicine.model.state';
import {NhisServiceOutcomeEffect} from './nhisServiceOutcome/nhis_service_outcome.model.effect';
import {
	NhisServiceOutcomeModelState,
	initialState as NhisServiceOutcomeModelInitialState
} from './nhisServiceOutcome/nhis_service_outcome.model.state';
import {NhisSpecialtyAttendedEffect} from './nhisSpecialtyAttended/nhis_specialty_attended.model.effect';
import {
	NhisSpecialtyAttendedModelState,
	initialState as NhisSpecialtyAttendedModelInitialState
} from './nhisSpecialtyAttended/nhis_specialty_attended.model.state';
import {NhisTypeOfServiceEffect} from './nhisTypeOfService/nhis_type_of_service.model.effect';
import {
	NhisTypeOfServiceModelState,
	initialState as NhisTypeOfServiceModelInitialState
} from './nhisTypeOfService/nhis_type_of_service.model.state';
import {NewbornDetailEffect} from './newbornDetail/newborn_detail.model.effect';
import {
	NewbornDetailModelState,
	initialState as NewbornDetailModelInitialState
} from './newbornDetail/newborn_detail.model.state';
import {NumberingSetupEffect} from './numberingSetup/numbering_setup.model.effect';
import {
	NumberingSetupModelState,
	initialState as NumberingSetupModelInitialState
} from './numberingSetup/numbering_setup.model.state';
import {NurseUserEffect} from './nurseUser/nurse_user.model.effect';
import {
	NurseUserModelState,
	initialState as NurseUserModelInitialState
} from './nurseUser/nurse_user.model.state';
import {NurseVitalSignMeasurementEffect} from './nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.effect';
import {
	NurseVitalSignMeasurementModelState,
	initialState as NurseVitalSignMeasurementModelInitialState
} from './nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.state';
import {ObstetricAndGynecologyHistoryEffect} from './obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.effect';
import {
	ObstetricAndGynecologyHistoryModelState,
	initialState as ObstetricAndGynecologyHistoryModelInitialState
} from './obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.state';
import {OdontogramExaminationEffect} from './odontogramExamination/odontogram_examination.model.effect';
import {
	OdontogramExaminationModelState,
	initialState as OdontogramExaminationModelInitialState
} from './odontogramExamination/odontogram_examination.model.state';
import {OperatingTheaterMedicalExaminationRecordEffect} from './operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.effect';
import {
	OperatingTheaterMedicalExaminationRecordModelState,
	initialState as OperatingTheaterMedicalExaminationRecordModelInitialState
} from './operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.state';
import {OphthalmologyExaminationEffect} from './ophthalmologyExamination/ophthalmology_examination.model.effect';
import {
	OphthalmologyExaminationModelState,
	initialState as OphthalmologyExaminationModelInitialState
} from './ophthalmologyExamination/ophthalmology_examination.model.state';
import {PcareActionExaminationEffect} from './pcareActionExamination/pcare_action_examination.model.effect';
import {
	PcareActionExaminationModelState,
	initialState as PcareActionExaminationModelInitialState
} from './pcareActionExamination/pcare_action_examination.model.state';
import {PcareClubProlanisEffect} from './pcareClubProlanis/pcare_club_prolanis.model.effect';
import {
	PcareClubProlanisModelState,
	initialState as PcareClubProlanisModelInitialState
} from './pcareClubProlanis/pcare_club_prolanis.model.state';
import {PcareCompoundDrugEffect} from './pcareCompoundDrug/pcare_compound_drug.model.effect';
import {
	PcareCompoundDrugModelState,
	initialState as PcareCompoundDrugModelInitialState
} from './pcareCompoundDrug/pcare_compound_drug.model.state';
import {PcareCompoundDrugItemEffect} from './pcareCompoundDrugItem/pcare_compound_drug_item.model.effect';
import {
	PcareCompoundDrugItemModelState,
	initialState as PcareCompoundDrugItemModelInitialState
} from './pcareCompoundDrugItem/pcare_compound_drug_item.model.state';
import {PcareDiagnosaEffect} from './pcareDiagnosa/pcare_diagnosa.model.effect';
import {
	PcareDiagnosaModelState,
	initialState as PcareDiagnosaModelInitialState
} from './pcareDiagnosa/pcare_diagnosa.model.state';
import {PcareDokterEffect} from './pcareDokter/pcare_dokter.model.effect';
import {
	PcareDokterModelState,
	initialState as PcareDokterModelInitialState
} from './pcareDokter/pcare_dokter.model.state';
import {PcareExaminationEffect} from './pcareExamination/pcare_examination.model.effect';
import {
	PcareExaminationModelState,
	initialState as PcareExaminationModelInitialState
} from './pcareExamination/pcare_examination.model.state';
import {PcareMCUEffect} from './pcareMCU/pcare_mcu.model.effect';
import {
	PcareMCUModelState,
	initialState as PcareMCUModelInitialState
} from './pcareMCU/pcare_mcu.model.state';
import {PcareNonCompoundDrugEffect} from './pcareNonCompoundDrug/pcare_noncompound_drug.model.effect';
import {
	PcareNonCompoundDrugModelState,
	initialState as PcareNonCompoundDrugModelInitialState
} from './pcareNonCompoundDrug/pcare_noncompound_drug.model.state';
import {PcareReferensiSaranaEffect} from './pcareReferensiSarana/pcare_referensi_sarana.model.effect';
import {
	PcareReferensiSaranaModelState,
	initialState as PcareReferensiSaranaModelInitialState
} from './pcareReferensiSarana/pcare_referensi_sarana.model.state';
import {PcareStatusPulangEffect} from './pcareStatusPulang/pcare_status_pulang.model.effect';
import {
	PcareStatusPulangModelState,
	initialState as PcareStatusPulangModelInitialState
} from './pcareStatusPulang/pcare_status_pulang.model.state';
import {PcareTindakanEffect} from './pcareTindakan/pcare_tindakan.model.effect';
import {
	PcareTindakanModelState,
	initialState as PcareTindakanModelInitialState
} from './pcareTindakan/pcare_tindakan.model.state';
import {PcareUmumEffect} from './pcareUmum/pcare_umum.model.effect';
import {
	PcareUmumModelState,
	initialState as PcareUmumModelInitialState
} from './pcareUmum/pcare_umum.model.state';
import {PatientCaseHistoryEffect} from './patientCaseHistory/patient_case_history.model.effect';
import {
	PatientCaseHistoryModelState,
	initialState as PatientCaseHistoryModelInitialState
} from './patientCaseHistory/patient_case_history.model.state';
import {PatientConsentEffect} from './patientConsent/patient_consent.model.effect';
import {
	PatientConsentModelState,
	initialState as PatientConsentModelInitialState
} from './patientConsent/patient_consent.model.state';
import {PatientContactInfoEffect} from './patientContactInfo/patient_contact_info.model.effect';
import {
	PatientContactInfoModelState,
	initialState as PatientContactInfoModelInitialState
} from './patientContactInfo/patient_contact_info.model.state';
import {PatientDetailEffect} from './patientDetail/patient_detail.model.effect';
import {
	PatientDetailModelState,
	initialState as PatientDetailModelInitialState
} from './patientDetail/patient_detail.model.state';
import {PatientDetailAddressEffect} from './patientDetailAddress/patient_detail_address.model.effect';
import {
	PatientDetailAddressModelState,
	initialState as PatientDetailAddressModelInitialState
} from './patientDetailAddress/patient_detail_address.model.state';
import {PatientEmergencyContactDetailEffect} from './patientEmergencyContactDetail/patient_emergency_contact_detail.model.effect';
import {
	PatientEmergencyContactDetailModelState,
	initialState as PatientEmergencyContactDetailModelInitialState
} from './patientEmergencyContactDetail/patient_emergency_contact_detail.model.state';
import {PatientEmploymentDetailEffect} from './patientEmploymentDetail/patient_employment_detail.model.effect';
import {
	PatientEmploymentDetailModelState,
	initialState as PatientEmploymentDetailModelInitialState
} from './patientEmploymentDetail/patient_employment_detail.model.state';
import {PatientGeneralInfoEffect} from './patientGeneralInfo/patient_general_info.model.effect';
import {
	PatientGeneralInfoModelState,
	initialState as PatientGeneralInfoModelInitialState
} from './patientGeneralInfo/patient_general_info.model.state';
import {PatientPaymentSelfPayingEffect} from './patientPaymentSelfPaying/patient_payment_self_paying.model.effect';
import {
	PatientPaymentSelfPayingModelState,
	initialState as PatientPaymentSelfPayingModelInitialState
} from './patientPaymentSelfPaying/patient_payment_self_paying.model.state';
import {PatientPaymentBPJSEffect} from './patientPaymentBPJS/patient_payment_bpjs.model.effect';
import {
	PatientPaymentBPJSModelState,
	initialState as PatientPaymentBPJSModelInitialState
} from './patientPaymentBPJS/patient_payment_bpjs.model.state';
import {PatientPaymentInsuranceEffect} from './patientPaymentInsurance/patient_payment_insurance.model.effect';
import {
	PatientPaymentInsuranceModelState,
	initialState as PatientPaymentInsuranceModelInitialState
} from './patientPaymentInsurance/patient_payment_insurance.model.state';
import {PatientPaymentOthersEffect} from './patientPaymentOthers/patient_payment_others.model.effect';
import {
	PatientPaymentOthersModelState,
	initialState as PatientPaymentOthersModelInitialState
} from './patientPaymentOthers/patient_payment_others.model.state';
import {PatientPersonalInfoEffect} from './patientPersonalInfo/patient_personal_info.model.effect';
import {
	PatientPersonalInfoModelState,
	initialState as PatientPersonalInfoModelInitialState
} from './patientPersonalInfo/patient_personal_info.model.state';
import {PatientSupportingDocumentEffect} from './patientSupportingDocument/patient_supporting_document.model.effect';
import {
	PatientSupportingDocumentModelState,
	initialState as PatientSupportingDocumentModelInitialState
} from './patientSupportingDocument/patient_supporting_document.model.state';
import {PatientVisitEffect} from './patientVisit/patient_visit.model.effect';
import {
	PatientVisitModelState,
	initialState as PatientVisitModelInitialState
} from './patientVisit/patient_visit.model.state';
import {PatientVisitPatientPaymentInsuranceEffect} from './patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.effect';
import {
	PatientVisitPatientPaymentInsuranceModelState,
	initialState as PatientVisitPatientPaymentInsuranceModelInitialState
} from './patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.state';
import {PatientVisitPatientPaymentOthersEffect} from './patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.effect';
import {
	PatientVisitPatientPaymentOthersModelState,
	initialState as PatientVisitPatientPaymentOthersModelInitialState
} from './patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.state';
import {PatientVisitPaymentSelfPayingEffect} from './patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.effect';
import {
	PatientVisitPaymentSelfPayingModelState,
	initialState as PatientVisitPaymentSelfPayingModelInitialState
} from './patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.state';
import {PatientVitalInformationEffect} from './patientVitalInformation/patient_vital_information.model.effect';
import {
	PatientVitalInformationModelState,
	initialState as PatientVitalInformationModelInitialState
} from './patientVitalInformation/patient_vital_information.model.state';
import {PharmacySetupEffect} from './pharmacySetup/pharmacy_setup.model.effect';
import {
	PharmacySetupModelState,
	initialState as PharmacySetupModelInitialState
} from './pharmacySetup/pharmacy_setup.model.state';
import {PharmacyUserEffect} from './pharmacyUser/pharmacy_user.model.effect';
import {
	PharmacyUserModelState,
	initialState as PharmacyUserModelInitialState
} from './pharmacyUser/pharmacy_user.model.state';
import {PostOperativeDetailsEffect} from './postOperativeDetails/post_operative_details.model.effect';
import {
	PostOperativeDetailsModelState,
	initialState as PostOperativeDetailsModelInitialState
} from './postOperativeDetails/post_operative_details.model.state';
import {PreoperativeRecordsEffect} from './preoperativeRecords/preoperative_records.model.effect';
import {
	PreoperativeRecordsModelState,
	initialState as PreoperativeRecordsModelInitialState
} from './preoperativeRecords/preoperative_records.model.state';
import {PrescriptionCompoundEffect} from './prescriptionCompound/prescription_compound.model.effect';
import {
	PrescriptionCompoundModelState,
	initialState as PrescriptionCompoundModelInitialState
} from './prescriptionCompound/prescription_compound.model.state';
import {PrescriptionHeaderEffect} from './prescriptionHeader/prescription_header.model.effect';
import {
	PrescriptionHeaderModelState,
	initialState as PrescriptionHeaderModelInitialState
} from './prescriptionHeader/prescription_header.model.state';
import {PrescriptionItemEffect} from './prescriptionItem/prescription_item.model.effect';
import {
	PrescriptionItemModelState,
	initialState as PrescriptionItemModelInitialState
} from './prescriptionItem/prescription_item.model.state';
import {PriceComponentEffect} from './priceComponent/price_component.model.effect';
import {
	PriceComponentModelState,
	initialState as PriceComponentModelInitialState
} from './priceComponent/price_component.model.state';
import {PrivilegeEffect} from './privilege/privilege.model.effect';
import {
	PrivilegeModelState,
	initialState as PrivilegeModelInitialState
} from './privilege/privilege.model.state';
import {ProcessWorkflowEffect} from './processWorkflow/process_workflow.model.effect';
import {
	ProcessWorkflowModelState,
	initialState as ProcessWorkflowModelInitialState
} from './processWorkflow/process_workflow.model.state';
import {PurchaseOrderEffect} from './purchaseOrder/purchase_order.model.effect';
import {
	PurchaseOrderModelState,
	initialState as PurchaseOrderModelInitialState
} from './purchaseOrder/purchase_order.model.state';
import {PurchaseOrderStockDetailEffect} from './purchaseOrderStockDetail/purchase_order_stock_detail.model.effect';
import {
	PurchaseOrderStockDetailModelState,
	initialState as PurchaseOrderStockDetailModelInitialState
} from './purchaseOrderStockDetail/purchase_order_stock_detail.model.state';
import {PurchaseRequisitionEffect} from './purchaseRequisition/purchase_requisition.model.effect';
import {
	PurchaseRequisitionModelState,
	initialState as PurchaseRequisitionModelInitialState
} from './purchaseRequisition/purchase_requisition.model.state';
import {PurchaseRequisitionStockDetailEffect} from './purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.effect';
import {
	PurchaseRequisitionStockDetailModelState,
	initialState as PurchaseRequisitionStockDetailModelInitialState
} from './purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.state';
import {PurchasingUserEffect} from './purchasingUser/purchasing_user.model.effect';
import {
	PurchasingUserModelState,
	initialState as PurchasingUserModelInitialState
} from './purchasingUser/purchasing_user.model.state';
import {ReferenceDataEffect} from './referenceData/reference_data.model.effect';
import {
	ReferenceDataModelState,
	initialState as ReferenceDataModelInitialState
} from './referenceData/reference_data.model.state';
import {ReferenceHeaderEffect} from './referenceHeader/reference_header.model.effect';
import {
	ReferenceHeaderModelState,
	initialState as ReferenceHeaderModelInitialState
} from './referenceHeader/reference_header.model.state';
import {RegistrationEffect} from './registration/registration.model.effect';
import {
	RegistrationModelState,
	initialState as RegistrationModelInitialState
} from './registration/registration.model.state';
import {RegistrationUserEffect} from './registrationUser/registration_user.model.effect';
import {
	RegistrationUserModelState,
	initialState as RegistrationUserModelInitialState
} from './registrationUser/registration_user.model.state';
import {RetailPharmacyEffect} from './retailPharmacy/retail_pharmacy.model.effect';
import {
	RetailPharmacyModelState,
	initialState as RetailPharmacyModelInitialState
} from './retailPharmacy/retail_pharmacy.model.state';
import {RetailPharmacyInvoiceEffect} from './retailPharmacyInvoice/retail_pharmacy_invoice.model.effect';
import {
	RetailPharmacyInvoiceModelState,
	initialState as RetailPharmacyInvoiceModelInitialState
} from './retailPharmacyInvoice/retail_pharmacy_invoice.model.state';
import {RetailPharmacyStockDetailEffect} from './retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.effect';
import {
	RetailPharmacyStockDetailModelState,
	initialState as RetailPharmacyStockDetailModelInitialState
} from './retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.state';
import {ReturnSupplierEffect} from './returnSupplier/return_supplier.model.effect';
import {
	ReturnSupplierModelState,
	initialState as ReturnSupplierModelInitialState
} from './returnSupplier/return_supplier.model.state';
import {ReturnSupplierStockDetailEffect} from './returnSupplierStockDetail/return_supplier_stock_detail.model.effect';
import {
	ReturnSupplierStockDetailModelState,
	initialState as ReturnSupplierStockDetailModelInitialState
} from './returnSupplierStockDetail/return_supplier_stock_detail.model.state';
import {RoleEffect} from './role/role.model.effect';
import {
	RoleModelState,
	initialState as RoleModelInitialState
} from './role/role.model.state';
import {RoomFacilityEffect} from './roomFacility/room_facility.model.effect';
import {
	RoomFacilityModelState,
	initialState as RoomFacilityModelInitialState
} from './roomFacility/room_facility.model.state';
import {RoomTransferEffect} from './roomTransfer/room_transfer.model.effect';
import {
	RoomTransferModelState,
	initialState as RoomTransferModelInitialState
} from './roomTransfer/room_transfer.model.state';
import {SepEffect} from './sep/sep.model.effect';
import {
	SepModelState,
	initialState as SepModelInitialState
} from './sep/sep.model.state';
import {SampleCollectionInformationEffect} from './sampleCollectionInformation/sample_collection_information.model.effect';
import {
	SampleCollectionInformationModelState,
	initialState as SampleCollectionInformationModelInitialState
} from './sampleCollectionInformation/sample_collection_information.model.state';
import {SampleCollectionItemsEffect} from './sampleCollectionItems/sample_collection_items.model.effect';
import {
	SampleCollectionItemsModelState,
	initialState as SampleCollectionItemsModelInitialState
} from './sampleCollectionItems/sample_collection_items.model.state';
import {SatuSehatConfigurationEffect} from './satuSehatConfiguration/satu_sehat_configuration.model.effect';
import {
	SatuSehatConfigurationModelState,
	initialState as SatuSehatConfigurationModelInitialState
} from './satuSehatConfiguration/satu_sehat_configuration.model.state';
import {ServiceEffect} from './service/service.model.effect';
import {
	ServiceModelState,
	initialState as ServiceModelInitialState
} from './service/service.model.state';
import {ServiceFacilityCategoryEffect} from './serviceFacilityCategory/service_facility_category.model.effect';
import {
	ServiceFacilityCategoryModelState,
	initialState as ServiceFacilityCategoryModelInitialState
} from './serviceFacilityCategory/service_facility_category.model.state';
import {ServiceItemEffect} from './serviceItem/service_item.model.effect';
import {
	ServiceItemModelState,
	initialState as ServiceItemModelInitialState
} from './serviceItem/service_item.model.state';
import {ServiceItemAssignmentEffect} from './serviceItemAssignment/service_item_assignment.model.effect';
import {
	ServiceItemAssignmentModelState,
	initialState as ServiceItemAssignmentModelInitialState
} from './serviceItemAssignment/service_item_assignment.model.state';
import {StaffEffect} from './staff/staff.model.effect';
import {
	StaffModelState,
	initialState as StaffModelInitialState
} from './staff/staff.model.state';
import {StockCatalogueEffect} from './stockCatalogue/stock_catalogue.model.effect';
import {
	StockCatalogueModelState,
	initialState as StockCatalogueModelInitialState
} from './stockCatalogue/stock_catalogue.model.state';
import {StockControlEffect} from './stockControl/stock_control.model.effect';
import {
	StockControlModelState,
	initialState as StockControlModelInitialState
} from './stockControl/stock_control.model.state';
import {StockTransactionDetailEffect} from './stockTransactionDetail/stock_transaction_detail.model.effect';
import {
	StockTransactionDetailModelState,
	initialState as StockTransactionDetailModelInitialState
} from './stockTransactionDetail/stock_transaction_detail.model.state';
import {StockTransactionPerDateEffect} from './stockTransactionPerDate/stock_transaction_per_date.model.effect';
import {
	StockTransactionPerDateModelState,
	initialState as StockTransactionPerDateModelInitialState
} from './stockTransactionPerDate/stock_transaction_per_date.model.state';
import {StockTransactionPerDateTypeEffect} from './stockTransactionPerDateType/stock_transaction_per_date_type.model.effect';
import {
	StockTransactionPerDateTypeModelState,
	initialState as StockTransactionPerDateTypeModelInitialState
} from './stockTransactionPerDateType/stock_transaction_per_date_type.model.state';
import {SupplierEffect} from './supplier/supplier.model.effect';
import {
	SupplierModelState,
	initialState as SupplierModelInitialState
} from './supplier/supplier.model.state';
import {SupplierBankAccountEffect} from './supplierBankAccount/supplier_bank_account.model.effect';
import {
	SupplierBankAccountModelState,
	initialState as SupplierBankAccountModelInitialState
} from './supplierBankAccount/supplier_bank_account.model.state';
import {SupplierContactDetailEffect} from './supplierContactDetail/supplier_contact_detail.model.effect';
import {
	SupplierContactDetailModelState,
	initialState as SupplierContactDetailModelInitialState
} from './supplierContactDetail/supplier_contact_detail.model.state';
import {SupplierProductDetailEffect} from './supplierProductDetail/supplier_product_detail.model.effect';
import {
	SupplierProductDetailModelState,
	initialState as SupplierProductDetailModelInitialState
} from './supplierProductDetail/supplier_product_detail.model.state';
import {SystemAdminUserEffect} from './systemAdminUser/system_admin_user.model.effect';
import {
	SystemAdminUserModelState,
	initialState as SystemAdminUserModelInitialState
} from './systemAdminUser/system_admin_user.model.state';
import {TariffDefinitionEffect} from './tariffDefinition/tariff_definition.model.effect';
import {
	TariffDefinitionModelState,
	initialState as TariffDefinitionModelInitialState
} from './tariffDefinition/tariff_definition.model.state';
import {TariffDefinitionOtherComponentEffect} from './tariffDefinitionOtherComponent/tariff_definition_other_component.model.effect';
import {
	TariffDefinitionOtherComponentModelState,
	initialState as TariffDefinitionOtherComponentModelInitialState
} from './tariffDefinitionOtherComponent/tariff_definition_other_component.model.state';
import {TariffFormulaEffect} from './tariffFormula/tariff_formula.model.effect';
import {
	TariffFormulaModelState,
	initialState as TariffFormulaModelInitialState
} from './tariffFormula/tariff_formula.model.state';
import {TariffPackageEffect} from './tariffPackage/tariff_package.model.effect';
import {
	TariffPackageModelState,
	initialState as TariffPackageModelInitialState
} from './tariffPackage/tariff_package.model.state';
import {TariffPackageItemEffect} from './tariffPackageItem/tariff_package_item.model.effect';
import {
	TariffPackageItemModelState,
	initialState as TariffPackageItemModelInitialState
} from './tariffPackageItem/tariff_package_item.model.state';
import {TariffPackageServiceAssignmentEffect} from './tariffPackageServiceAssignment/tariff_package_service_assignment.model.effect';
import {
	TariffPackageServiceAssignmentModelState,
	initialState as TariffPackageServiceAssignmentModelInitialState
} from './tariffPackageServiceAssignment/tariff_package_service_assignment.model.state';
import {TariffSchemaEffect} from './tariffSchema/tariff_schema.model.effect';
import {
	TariffSchemaModelState,
	initialState as TariffSchemaModelInitialState
} from './tariffSchema/tariff_schema.model.state';
import {TaskDashboardEffect} from './taskDashboard/task_dashboard.model.effect';
import {
	TaskDashboardModelState,
	initialState as TaskDashboardModelInitialState
} from './taskDashboard/task_dashboard.model.state';
import {TransactionDetailTypeEffect} from './transactionDetailType/transaction_detail_type.model.effect';
import {
	TransactionDetailTypeModelState,
	initialState as TransactionDetailTypeModelInitialState
} from './transactionDetailType/transaction_detail_type.model.state';
import {TransactionDetailTypeMappingEffect} from './transactionDetailTypeMapping/transaction_detail_type_mapping.model.effect';
import {
	TransactionDetailTypeMappingModelState,
	initialState as TransactionDetailTypeMappingModelInitialState
} from './transactionDetailTypeMapping/transaction_detail_type_mapping.model.state';
import {TransferOrderEffect} from './transferOrder/transfer_order.model.effect';
import {
	TransferOrderModelState,
	initialState as TransferOrderModelInitialState
} from './transferOrder/transfer_order.model.state';
import {TransferOrderStockDetailEffect} from './transferOrderStockDetail/transfer_order_stock_detail.model.effect';
import {
	TransferOrderStockDetailModelState,
	initialState as TransferOrderStockDetailModelInitialState
} from './transferOrderStockDetail/transfer_order_stock_detail.model.state';
import {UnitOfMeasurementEffect} from './unitOfMeasurement/unit_of_measurement.model.effect';
import {
	UnitOfMeasurementModelState,
	initialState as UnitOfMeasurementModelInitialState
} from './unitOfMeasurement/unit_of_measurement.model.state';
import {UserEffect} from './user/user.model.effect';
import {
	UserModelState,
	initialState as UserModelInitialState
} from './user/user.model.state';
import {VaccinationOrderEffect} from './vaccinationOrder/vaccination_order.model.effect';
import {
	VaccinationOrderModelState,
	initialState as VaccinationOrderModelInitialState
} from './vaccinationOrder/vaccination_order.model.state';
import {VaccinationOrderDetailEffect} from './vaccinationOrderDetail/vaccination_order_detail.model.effect';
import {
	VaccinationOrderDetailModelState,
	initialState as VaccinationOrderDetailModelInitialState
} from './vaccinationOrderDetail/vaccination_order_detail.model.state';
import {VitalSignsEffect} from './vitalSigns/vital_signs.model.effect';
import {
	VitalSignsModelState,
	initialState as VitalSignsModelInitialState
} from './vitalSigns/vital_signs.model.state';
import {WarehouseEffect} from './warehouse/warehouse.model.effect';
import {
	WarehouseModelState,
	initialState as WarehouseModelInitialState
} from './warehouse/warehouse.model.state';
import {WarehouseInitialStockEffect} from './warehouseInitialStock/warehouse_initial_stock.model.effect';
import {
	WarehouseInitialStockModelState,
	initialState as WarehouseInitialStockModelInitialState
} from './warehouseInitialStock/warehouse_initial_stock.model.state';
import {WarehouseInventoryEffect} from './warehouseInventory/warehouse_inventory.model.effect';
import {
	WarehouseInventoryModelState,
	initialState as WarehouseInventoryModelInitialState
} from './warehouseInventory/warehouse_inventory.model.state';
import {WarehouseUserEffect} from './warehouseUser/warehouse_user.model.effect';
import {
	WarehouseUserModelState,
	initialState as WarehouseUserModelInitialState
} from './warehouseUser/warehouse_user.model.state';
import {AbstractModel} from '../lib/models/abstract.model';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * The State of a collection of the model
 * This would store the queryParams of specific collection, which could be shared through the store
 */
export interface CollectionState {
	/**
	 * The query parameters to be used for querying of this collection
	 */
	queryParams: QueryParams;

	/**
	 * The total number of results on the server that match the queryParams
	 */
	collectionCount: number;

	/**
	 * The ids of the data in this collection
	 */
	ids?: string[];
}

/**
 * Types of audit query.
 */
export enum AuditQueryType {
	CREATE = 'CREATE',
	UPDATE = 'UPDATE',
	DELETE = 'DELETE'
}

/**
 * State containing audits against a specific entity.
 */
export interface AbstractModelAudit<E extends AbstractModel> {
	entity: E;
	timestamp: string;
	type: AuditQueryType;
	authorId: string;
	authorFirstName: string;
	authorLastName: string;
	// % protected region % [Add any model audit properties here] off begin
	// % protected region % [Add any model audit properties here] end
}

/**
 * State containing all models in the current application. This acts essentially as the central store of models for the
 * application.
 */
export interface ModelState {
	AdministrationUserModel: AdministrationUserModelState;
	AdministratorModel: AdministratorModelState;
	AmendmentDetailModel: AmendmentDetailModelState;
	BpjsAccidentMasterModel: BpjsAccidentMasterModelState;
	BpjsBedAvailabilityModel: BpjsBedAvailabilityModelState;
	BpjsClaimDataModel: BpjsClaimDataModelState;
	BpjsClaimSubmissionModel: BpjsClaimSubmissionModelState;
	BpjsControlPlanModel: BpjsControlPlanModelState;
	BpjsControlSpecialistModel: BpjsControlSpecialistModelState;
	BpjsDiagnoseModel: BpjsDiagnoseModelState;
	BpjsDiagnosePRBModel: BpjsDiagnosePRBModelState;
	BpjsDismissalConditionModel: BpjsDismissalConditionModelState;
	BpjsDismissalMappingModel: BpjsDismissalMappingModelState;
	BpjsDoctorMappingModel: BpjsDoctorMappingModelState;
	BpjsDoctorScheduleModel: BpjsDoctorScheduleModelState;
	BpjsDrugGenericPRBModel: BpjsDrugGenericPRBModelState;
	BpjsFacilityListModel: BpjsFacilityListModelState;
	BpjsFingerPrintModel: BpjsFingerPrintModelState;
	BpjsGeneralModel: BpjsGeneralModelState;
	BpjsHealthFacilityModel: BpjsHealthFacilityModelState;
	BpjsHospitalizationPlanModel: BpjsHospitalizationPlanModelState;
	BpjsINACBGModel: BpjsINACBGModelState;
	BpjsINACBGClaimModel: BpjsINACBGClaimModelState;
	BpjsINACBGVariableModel: BpjsINACBGVariableModelState;
	BpjsJasaRaharjaModel: BpjsJasaRaharjaModelState;
	BpjsJasaRaharjaClaimModel: BpjsJasaRaharjaClaimModelState;
	BpjsListFingerPrintModel: BpjsListFingerPrintModelState;
	BpjsListTaskModel: BpjsListTaskModelState;
	BpjsOutsideFacilityReferralModel: BpjsOutsideFacilityReferralModelState;
	BpjsPRBModel: BpjsPRBModelState;
	BpjsPRBDetailModel: BpjsPRBDetailModelState;
	BpjsPatientReferralModel: BpjsPatientReferralModelState;
	BpjsPcareDPHOModel: BpjsPcareDPHOModelState;
	BpjsPcareKegiatanKelompokModel: BpjsPcareKegiatanKelompokModelState;
	BpjsPcareKesadaranModel: BpjsPcareKesadaranModelState;
	BpjsPcarePesertaKegiatanKelompokModel: BpjsPcarePesertaKegiatanKelompokModelState;
	BpjsPcarePoliModel: BpjsPcarePoliModelState;
	BpjsPcareProviderRayonisasiModel: BpjsPcareProviderRayonisasiModelState;
	BpjsPcareRegistrationsModel: BpjsPcareRegistrationsModelState;
	BpjsProcedureModel: BpjsProcedureModelState;
	BpjsReferralSpecialistModel: BpjsReferralSpecialistModelState;
	BpjsSEPModel: BpjsSEPModelState;
	BpjsSEPINACBGIntegrationModel: BpjsSEPINACBGIntegrationModelState;
	BpjsSEPInternalDataModel: BpjsSEPInternalDataModelState;
	BpjsSEPSubmissionModel: BpjsSEPSubmissionModelState;
	BpjsSearchControlLetterModel: BpjsSearchControlLetterModelState;
	BpjsSearchSEPModel: BpjsSearchSEPModelState;
	BpjsServiceMappingModel: BpjsServiceMappingModelState;
	BpjsSpecialReferralModel: BpjsSpecialReferralModelState;
	BpjsTotalReferralSEPModel: BpjsTotalReferralSEPModelState;
	BpjsTreatmentClassMappingModel: BpjsTreatmentClassMappingModelState;
	BpjsTreatmentHistoryModel: BpjsTreatmentHistoryModelState;
	BpjsTreatmentRoomModel: BpjsTreatmentRoomModelState;
	BpjsUpdateDismissalDateModel: BpjsUpdateDismissalDateModelState;
	BpjsVisitDataModel: BpjsVisitDataModelState;
	BatchStockBalanceModel: BatchStockBalanceModelState;
	BatchStockBalancePerDateModel: BatchStockBalancePerDateModelState;
	BatchStockTransactionDetailModel: BatchStockTransactionDetailModelState;
	BedFacilityModel: BedFacilityModelState;
	BedReserveModel: BedReserveModelState;
	BirthHistoryModel: BirthHistoryModelState;
	BodyChartExaminationModel: BodyChartExaminationModelState;
	BpjsPcareKunjunganRujukanModel: BpjsPcareKunjunganRujukanModelState;
	BpjsPcarePendaftaranModel: BpjsPcarePendaftaranModelState;
	BpjsPcareRiwayatKunjunganModel: BpjsPcareRiwayatKunjunganModelState;
	CashAllocationModel: CashAllocationModelState;
	CashReceiptModel: CashReceiptModelState;
	CashRefundModel: CashRefundModelState;
	CashierUserModel: CashierUserModelState;
	CatalogueMedicalModel: CatalogueMedicalModelState;
	CatalogueNonMedicalModel: CatalogueNonMedicalModelState;
	CatalogueUOMModel: CatalogueUOMModelState;
	ChartOfAccountModel: ChartOfAccountModelState;
	ChartOfAccountMappingModel: ChartOfAccountMappingModelState;
	ClaimUserModel: ClaimUserModelState;
	CoTreatingDoctorModel: CoTreatingDoctorModelState;
	CompoundPrescriptionDetailModel: CompoundPrescriptionDetailModelState;
	CompoundPrescriptionItemModel: CompoundPrescriptionItemModelState;
	DailyCareCPPTModel: DailyCareCPPTModelState;
	DeliveryMedicalExaminationRecordModel: DeliveryMedicalExaminationRecordModelState;
	DeliveryProgressModel: DeliveryProgressModelState;
	DiagnosesAndProceduresModel: DiagnosesAndProceduresModelState;
	DiagnosisExaminationRecordModel: DiagnosisExaminationRecordModelState;
	DiagnosisNandaModel: DiagnosisNandaModelState;
	DiagnosticExaminationResultsModel: DiagnosticExaminationResultsModelState;
	DiagnosticStaffExaminationSummaryModel: DiagnosticStaffExaminationSummaryModelState;
	DiagnosticSupportGeneralConfigurationModel: DiagnosticSupportGeneralConfigurationModelState;
	DiagnosticSupportUserModel: DiagnosticSupportUserModelState;
	DoctorScheduleModel: DoctorScheduleModelState;
	DoctorUserModel: DoctorUserModelState;
	EntExaminationModel: EntExaminationModelState;
	EmergencyMedicalExaminationRecordModel: EmergencyMedicalExaminationRecordModelState;
	ExaminationGroupModel: ExaminationGroupModelState;
	ExaminationItemModel: ExaminationItemModelState;
	ExaminationItemDetailModel: ExaminationItemDetailModelState;
	FacilityHistoryModel: FacilityHistoryModelState;
	FacilityUserModel: FacilityUserModelState;
	FluidBalanceDetailModel: FluidBalanceDetailModelState;
	FormulirKonselingTesHivModel: FormulirKonselingTesHivModelState;
	GoodsReceiveNoteModel: GoodsReceiveNoteModelState;
	GoodsReceiveNoteBatchModel: GoodsReceiveNoteBatchModelState;
	GoodsReceiveNoteItemModel: GoodsReceiveNoteItemModelState;
	HealthFacilityModel: HealthFacilityModelState;
	HemodialysisExaminationModel: HemodialysisExaminationModelState;
	HemodialysisMonitoringModel: HemodialysisMonitoringModelState;
	HospitalBranchInformationModel: HospitalBranchInformationModelState;
	HospitalGroupInformationModel: HospitalGroupInformationModelState;
	Icd10Model: Icd10ModelState;
	Icd9CMModel: Icd9CMModelState;
	InformedConsentModel: InformedConsentModelState;
	InpatientMedicalExaminationRecordModel: InpatientMedicalExaminationRecordModelState;
	InsuranceBenefitPlanModel: InsuranceBenefitPlanModelState;
	InsuranceProviderModel: InsuranceProviderModelState;
	InternalOrderModel: InternalOrderModelState;
	InternalOrderStockDetailModel: InternalOrderStockDetailModelState;
	IntraoperativeRecordsModel: IntraoperativeRecordsModelState;
	InventoryAdjusmentBatchModel: InventoryAdjusmentBatchModelState;
	InventoryAdjustmentModel: InventoryAdjustmentModelState;
	InventoryAdjustmentItemModel: InventoryAdjustmentItemModelState;
	InventoryBatchCorrectionModel: InventoryBatchCorrectionModelState;
	InventoryBatchCorrectionItemModel: InventoryBatchCorrectionItemModelState;
	InvoiceModel: InvoiceModelState;
	InvoiceItemModel: InvoiceItemModelState;
	InvoiceItemComponentModel: InvoiceItemComponentModelState;
	InvoicePaymentInsuranceModel: InvoicePaymentInsuranceModelState;
	InvoicePaymentOtherModel: InvoicePaymentOtherModelState;
	InvoicePaymentSelfPayingModel: InvoicePaymentSelfPayingModelState;
	InvoiceSummaryModel: InvoiceSummaryModelState;
	JournalModel: JournalModelState;
	LibraryModel: LibraryModelState;
	LocationModel: LocationModelState;
	McuPackageModel: McuPackageModelState;
	McuPackageItemModel: McuPackageItemModelState;
	ManagementUserModel: ManagementUserModelState;
	MedicalCertificateDischargeResumeModel: MedicalCertificateDischargeResumeModelState;
	MedicalCertificateBirthModel: MedicalCertificateBirthModelState;
	MedicalCertificateHospitalizationModel: MedicalCertificateHospitalizationModelState;
	MedicalCertificateMedicalAttendanceModel: MedicalCertificateMedicalAttendanceModelState;
	MedicalCertificateMentalHealthModel: MedicalCertificateMentalHealthModelState;
	MedicalCertificatePhysicalHealthModel: MedicalCertificatePhysicalHealthModelState;
	MedicalCertificateRestrictedWorkModel: MedicalCertificateRestrictedWorkModelState;
	MedicalCertificateSickLeaveModel: MedicalCertificateSickLeaveModelState;
	MedicalExaminationRecordModel: MedicalExaminationRecordModelState;
	MedicalExaminationRecordDischargeSummaryModel: MedicalExaminationRecordDischargeSummaryModelState;
	MedicalFeeModel: MedicalFeeModelState;
	MedicalFeeItemComponentModel: MedicalFeeItemComponentModelState;
	MedicalRecordInitialChecklistModel: MedicalRecordInitialChecklistModelState;
	MedicalRecordNextVerificationChecklistModel: MedicalRecordNextVerificationChecklistModelState;
	MedicalRecordUserModel: MedicalRecordUserModelState;
	MedicalTranscriberUserModel: MedicalTranscriberUserModelState;
	MedicationAdministeredHistoryModel: MedicationAdministeredHistoryModelState;
	MedicationCompoundModel: MedicationCompoundModelState;
	MedicationHeaderModel: MedicationHeaderModelState;
	MedicationItemModel: MedicationItemModelState;
	MerchantModel: MerchantModelState;
	MerchantSurchargeAndFeeModel: MerchantSurchargeAndFeeModelState;
	NhisClaimModel: NhisClaimModelState;
	NhisClaimGDRGDetailModel: NhisClaimGDRGDetailModelState;
	NhisClaimInvestigationDetailModel: NhisClaimInvestigationDetailModelState;
	NhisGDRGModel: NhisGDRGModelState;
	NhisInvestigationModel: NhisInvestigationModelState;
	NhisMedicineModel: NhisMedicineModelState;
	NhisServiceOutcomeModel: NhisServiceOutcomeModelState;
	NhisSpecialtyAttendedModel: NhisSpecialtyAttendedModelState;
	NhisTypeOfServiceModel: NhisTypeOfServiceModelState;
	NewbornDetailModel: NewbornDetailModelState;
	NumberingSetupModel: NumberingSetupModelState;
	NurseUserModel: NurseUserModelState;
	NurseVitalSignMeasurementModel: NurseVitalSignMeasurementModelState;
	ObstetricAndGynecologyHistoryModel: ObstetricAndGynecologyHistoryModelState;
	OdontogramExaminationModel: OdontogramExaminationModelState;
	OperatingTheaterMedicalExaminationRecordModel: OperatingTheaterMedicalExaminationRecordModelState;
	OphthalmologyExaminationModel: OphthalmologyExaminationModelState;
	PcareActionExaminationModel: PcareActionExaminationModelState;
	PcareClubProlanisModel: PcareClubProlanisModelState;
	PcareCompoundDrugModel: PcareCompoundDrugModelState;
	PcareCompoundDrugItemModel: PcareCompoundDrugItemModelState;
	PcareDiagnosaModel: PcareDiagnosaModelState;
	PcareDokterModel: PcareDokterModelState;
	PcareExaminationModel: PcareExaminationModelState;
	PcareMCUModel: PcareMCUModelState;
	PcareNonCompoundDrugModel: PcareNonCompoundDrugModelState;
	PcareReferensiSaranaModel: PcareReferensiSaranaModelState;
	PcareStatusPulangModel: PcareStatusPulangModelState;
	PcareTindakanModel: PcareTindakanModelState;
	PcareUmumModel: PcareUmumModelState;
	PatientCaseHistoryModel: PatientCaseHistoryModelState;
	PatientConsentModel: PatientConsentModelState;
	PatientContactInfoModel: PatientContactInfoModelState;
	PatientDetailModel: PatientDetailModelState;
	PatientDetailAddressModel: PatientDetailAddressModelState;
	PatientEmergencyContactDetailModel: PatientEmergencyContactDetailModelState;
	PatientEmploymentDetailModel: PatientEmploymentDetailModelState;
	PatientGeneralInfoModel: PatientGeneralInfoModelState;
	PatientPaymentSelfPayingModel: PatientPaymentSelfPayingModelState;
	PatientPaymentBPJSModel: PatientPaymentBPJSModelState;
	PatientPaymentInsuranceModel: PatientPaymentInsuranceModelState;
	PatientPaymentOthersModel: PatientPaymentOthersModelState;
	PatientPersonalInfoModel: PatientPersonalInfoModelState;
	PatientSupportingDocumentModel: PatientSupportingDocumentModelState;
	PatientVisitModel: PatientVisitModelState;
	PatientVisitPatientPaymentInsuranceModel: PatientVisitPatientPaymentInsuranceModelState;
	PatientVisitPatientPaymentOthersModel: PatientVisitPatientPaymentOthersModelState;
	PatientVisitPaymentSelfPayingModel: PatientVisitPaymentSelfPayingModelState;
	PatientVitalInformationModel: PatientVitalInformationModelState;
	PharmacySetupModel: PharmacySetupModelState;
	PharmacyUserModel: PharmacyUserModelState;
	PostOperativeDetailsModel: PostOperativeDetailsModelState;
	PreoperativeRecordsModel: PreoperativeRecordsModelState;
	PrescriptionCompoundModel: PrescriptionCompoundModelState;
	PrescriptionHeaderModel: PrescriptionHeaderModelState;
	PrescriptionItemModel: PrescriptionItemModelState;
	PriceComponentModel: PriceComponentModelState;
	PrivilegeModel: PrivilegeModelState;
	ProcessWorkflowModel: ProcessWorkflowModelState;
	PurchaseOrderModel: PurchaseOrderModelState;
	PurchaseOrderStockDetailModel: PurchaseOrderStockDetailModelState;
	PurchaseRequisitionModel: PurchaseRequisitionModelState;
	PurchaseRequisitionStockDetailModel: PurchaseRequisitionStockDetailModelState;
	PurchasingUserModel: PurchasingUserModelState;
	ReferenceDataModel: ReferenceDataModelState;
	ReferenceHeaderModel: ReferenceHeaderModelState;
	RegistrationModel: RegistrationModelState;
	RegistrationUserModel: RegistrationUserModelState;
	RetailPharmacyModel: RetailPharmacyModelState;
	RetailPharmacyInvoiceModel: RetailPharmacyInvoiceModelState;
	RetailPharmacyStockDetailModel: RetailPharmacyStockDetailModelState;
	ReturnSupplierModel: ReturnSupplierModelState;
	ReturnSupplierStockDetailModel: ReturnSupplierStockDetailModelState;
	RoleModel: RoleModelState;
	RoomFacilityModel: RoomFacilityModelState;
	RoomTransferModel: RoomTransferModelState;
	SepModel: SepModelState;
	SampleCollectionInformationModel: SampleCollectionInformationModelState;
	SampleCollectionItemsModel: SampleCollectionItemsModelState;
	SatuSehatConfigurationModel: SatuSehatConfigurationModelState;
	ServiceModel: ServiceModelState;
	ServiceFacilityCategoryModel: ServiceFacilityCategoryModelState;
	ServiceItemModel: ServiceItemModelState;
	ServiceItemAssignmentModel: ServiceItemAssignmentModelState;
	StaffModel: StaffModelState;
	StockCatalogueModel: StockCatalogueModelState;
	StockControlModel: StockControlModelState;
	StockTransactionDetailModel: StockTransactionDetailModelState;
	StockTransactionPerDateModel: StockTransactionPerDateModelState;
	StockTransactionPerDateTypeModel: StockTransactionPerDateTypeModelState;
	SupplierModel: SupplierModelState;
	SupplierBankAccountModel: SupplierBankAccountModelState;
	SupplierContactDetailModel: SupplierContactDetailModelState;
	SupplierProductDetailModel: SupplierProductDetailModelState;
	SystemAdminUserModel: SystemAdminUserModelState;
	TariffDefinitionModel: TariffDefinitionModelState;
	TariffDefinitionOtherComponentModel: TariffDefinitionOtherComponentModelState;
	TariffFormulaModel: TariffFormulaModelState;
	TariffPackageModel: TariffPackageModelState;
	TariffPackageItemModel: TariffPackageItemModelState;
	TariffPackageServiceAssignmentModel: TariffPackageServiceAssignmentModelState;
	TariffSchemaModel: TariffSchemaModelState;
	TaskDashboardModel: TaskDashboardModelState;
	TransactionDetailTypeModel: TransactionDetailTypeModelState;
	TransactionDetailTypeMappingModel: TransactionDetailTypeMappingModelState;
	TransferOrderModel: TransferOrderModelState;
	TransferOrderStockDetailModel: TransferOrderStockDetailModelState;
	UnitOfMeasurementModel: UnitOfMeasurementModelState;
	UserModel: UserModelState;
	VaccinationOrderModel: VaccinationOrderModelState;
	VaccinationOrderDetailModel: VaccinationOrderDetailModelState;
	VitalSignsModel: VitalSignsModelState;
	WarehouseModel: WarehouseModelState;
	WarehouseInitialStockModel: WarehouseInitialStockModelState;
	WarehouseInventoryModel: WarehouseInventoryModelState;
	WarehouseUserModel: WarehouseUserModelState;
	// % protected region % [Add any additional ModelState attributes here] off begin
	// % protected region % [Add any additional ModelState attributes here] end
}

/**
 * Initial model state of the application.
 */
export const initialModelState: ModelState = {
	AdministrationUserModel: {
		...AdministrationUserModelInitialState,
		// % protected region % [Add any additional state for model Administration User here] off begin
		// % protected region % [Add any additional state for model Administration User here] end
	},
	AdministratorModel: {
		...AdministratorModelInitialState,
		// % protected region % [Add any additional state for model Administrator here] off begin
		// % protected region % [Add any additional state for model Administrator here] end
	},
	AmendmentDetailModel: {
		...AmendmentDetailModelInitialState,
		// % protected region % [Add any additional state for model Amendment Detail here] off begin
		// % protected region % [Add any additional state for model Amendment Detail here] end
	},
	BpjsAccidentMasterModel: {
		...BpjsAccidentMasterModelInitialState,
		// % protected region % [Add any additional state for model BPJS Accident Master here] off begin
		// % protected region % [Add any additional state for model BPJS Accident Master here] end
	},
	BpjsBedAvailabilityModel: {
		...BpjsBedAvailabilityModelInitialState,
		// % protected region % [Add any additional state for model BPJS Bed Availability here] off begin
		// % protected region % [Add any additional state for model BPJS Bed Availability here] end
	},
	BpjsClaimDataModel: {
		...BpjsClaimDataModelInitialState,
		// % protected region % [Add any additional state for model BPJS Claim Data here] off begin
		// % protected region % [Add any additional state for model BPJS Claim Data here] end
	},
	BpjsClaimSubmissionModel: {
		...BpjsClaimSubmissionModelInitialState,
		// % protected region % [Add any additional state for model BPJS Claim Submission here] off begin
		// % protected region % [Add any additional state for model BPJS Claim Submission here] end
	},
	BpjsControlPlanModel: {
		...BpjsControlPlanModelInitialState,
		// % protected region % [Add any additional state for model BPJS Control Plan here] off begin
		// % protected region % [Add any additional state for model BPJS Control Plan here] end
	},
	BpjsControlSpecialistModel: {
		...BpjsControlSpecialistModelInitialState,
		// % protected region % [Add any additional state for model BPJS Control Specialist here] off begin
		// % protected region % [Add any additional state for model BPJS Control Specialist here] end
	},
	BpjsDiagnoseModel: {
		...BpjsDiagnoseModelInitialState,
		// % protected region % [Add any additional state for model BPJS Diagnose here] off begin
		// % protected region % [Add any additional state for model BPJS Diagnose here] end
	},
	BpjsDiagnosePRBModel: {
		...BpjsDiagnosePRBModelInitialState,
		// % protected region % [Add any additional state for model BPJS Diagnose PRB here] off begin
		// % protected region % [Add any additional state for model BPJS Diagnose PRB here] end
	},
	BpjsDismissalConditionModel: {
		...BpjsDismissalConditionModelInitialState,
		// % protected region % [Add any additional state for model BPJS Dismissal Condition here] off begin
		// % protected region % [Add any additional state for model BPJS Dismissal Condition here] end
	},
	BpjsDismissalMappingModel: {
		...BpjsDismissalMappingModelInitialState,
		// % protected region % [Add any additional state for model BPJS Dismissal Mapping here] off begin
		// % protected region % [Add any additional state for model BPJS Dismissal Mapping here] end
	},
	BpjsDoctorMappingModel: {
		...BpjsDoctorMappingModelInitialState,
		// % protected region % [Add any additional state for model BPJS Doctor Mapping here] off begin
		// % protected region % [Add any additional state for model BPJS Doctor Mapping here] end
	},
	BpjsDoctorScheduleModel: {
		...BpjsDoctorScheduleModelInitialState,
		// % protected region % [Add any additional state for model BPJS Doctor Schedule here] off begin
		// % protected region % [Add any additional state for model BPJS Doctor Schedule here] end
	},
	BpjsDrugGenericPRBModel: {
		...BpjsDrugGenericPRBModelInitialState,
		// % protected region % [Add any additional state for model BPJS Drug Generic PRB here] off begin
		// % protected region % [Add any additional state for model BPJS Drug Generic PRB here] end
	},
	BpjsFacilityListModel: {
		...BpjsFacilityListModelInitialState,
		// % protected region % [Add any additional state for model BPJS Facility List here] off begin
		// % protected region % [Add any additional state for model BPJS Facility List here] end
	},
	BpjsFingerPrintModel: {
		...BpjsFingerPrintModelInitialState,
		// % protected region % [Add any additional state for model BPJS Finger Print here] off begin
		// % protected region % [Add any additional state for model BPJS Finger Print here] end
	},
	BpjsGeneralModel: {
		...BpjsGeneralModelInitialState,
		// % protected region % [Add any additional state for model BPJS General here] off begin
		// % protected region % [Add any additional state for model BPJS General here] end
	},
	BpjsHealthFacilityModel: {
		...BpjsHealthFacilityModelInitialState,
		// % protected region % [Add any additional state for model BPJS Health Facility here] off begin
		// % protected region % [Add any additional state for model BPJS Health Facility here] end
	},
	BpjsHospitalizationPlanModel: {
		...BpjsHospitalizationPlanModelInitialState,
		// % protected region % [Add any additional state for model BPJS Hospitalization Plan here] off begin
		// % protected region % [Add any additional state for model BPJS Hospitalization Plan here] end
	},
	BpjsINACBGModel: {
		...BpjsINACBGModelInitialState,
		// % protected region % [Add any additional state for model BPJS INACBG here] off begin
		// % protected region % [Add any additional state for model BPJS INACBG here] end
	},
	BpjsINACBGClaimModel: {
		...BpjsINACBGClaimModelInitialState,
		// % protected region % [Add any additional state for model BPJS INACBG Claim here] off begin
		// % protected region % [Add any additional state for model BPJS INACBG Claim here] end
	},
	BpjsINACBGVariableModel: {
		...BpjsINACBGVariableModelInitialState,
		// % protected region % [Add any additional state for model BPJS INACBG Variable here] off begin
		// % protected region % [Add any additional state for model BPJS INACBG Variable here] end
	},
	BpjsJasaRaharjaModel: {
		...BpjsJasaRaharjaModelInitialState,
		// % protected region % [Add any additional state for model BPJS Jasa Raharja here] off begin
		// % protected region % [Add any additional state for model BPJS Jasa Raharja here] end
	},
	BpjsJasaRaharjaClaimModel: {
		...BpjsJasaRaharjaClaimModelInitialState,
		// % protected region % [Add any additional state for model BPJS Jasa Raharja Claim here] off begin
		// % protected region % [Add any additional state for model BPJS Jasa Raharja Claim here] end
	},
	BpjsListFingerPrintModel: {
		...BpjsListFingerPrintModelInitialState,
		// % protected region % [Add any additional state for model BPJS List Finger Print here] off begin
		// % protected region % [Add any additional state for model BPJS List Finger Print here] end
	},
	BpjsListTaskModel: {
		...BpjsListTaskModelInitialState,
		// % protected region % [Add any additional state for model BPJS List Task here] off begin
		// % protected region % [Add any additional state for model BPJS List Task here] end
	},
	BpjsOutsideFacilityReferralModel: {
		...BpjsOutsideFacilityReferralModelInitialState,
		// % protected region % [Add any additional state for model BPJS Outside Facility Referral here] off begin
		// % protected region % [Add any additional state for model BPJS Outside Facility Referral here] end
	},
	BpjsPRBModel: {
		...BpjsPRBModelInitialState,
		// % protected region % [Add any additional state for model BPJS PRB here] off begin
		// % protected region % [Add any additional state for model BPJS PRB here] end
	},
	BpjsPRBDetailModel: {
		...BpjsPRBDetailModelInitialState,
		// % protected region % [Add any additional state for model BPJS PRB Detail here] off begin
		// % protected region % [Add any additional state for model BPJS PRB Detail here] end
	},
	BpjsPatientReferralModel: {
		...BpjsPatientReferralModelInitialState,
		// % protected region % [Add any additional state for model BPJS Patient Referral here] off begin
		// % protected region % [Add any additional state for model BPJS Patient Referral here] end
	},
	BpjsPcareDPHOModel: {
		...BpjsPcareDPHOModelInitialState,
		// % protected region % [Add any additional state for model BPJS Pcare DPHO here] off begin
		// % protected region % [Add any additional state for model BPJS Pcare DPHO here] end
	},
	BpjsPcareKegiatanKelompokModel: {
		...BpjsPcareKegiatanKelompokModelInitialState,
		// % protected region % [Add any additional state for model BPJS Pcare Kegiatan Kelompok here] off begin
		// % protected region % [Add any additional state for model BPJS Pcare Kegiatan Kelompok here] end
	},
	BpjsPcareKesadaranModel: {
		...BpjsPcareKesadaranModelInitialState,
		// % protected region % [Add any additional state for model BPJS Pcare Kesadaran here] off begin
		// % protected region % [Add any additional state for model BPJS Pcare Kesadaran here] end
	},
	BpjsPcarePesertaKegiatanKelompokModel: {
		...BpjsPcarePesertaKegiatanKelompokModelInitialState,
		// % protected region % [Add any additional state for model BPJS Pcare Peserta Kegiatan Kelompok here] off begin
		// % protected region % [Add any additional state for model BPJS Pcare Peserta Kegiatan Kelompok here] end
	},
	BpjsPcarePoliModel: {
		...BpjsPcarePoliModelInitialState,
		// % protected region % [Add any additional state for model BPJS Pcare Poli here] off begin
		// % protected region % [Add any additional state for model BPJS Pcare Poli here] end
	},
	BpjsPcareProviderRayonisasiModel: {
		...BpjsPcareProviderRayonisasiModelInitialState,
		// % protected region % [Add any additional state for model BPJS Pcare Provider Rayonisasi here] off begin
		// % protected region % [Add any additional state for model BPJS Pcare Provider Rayonisasi here] end
	},
	BpjsPcareRegistrationsModel: {
		...BpjsPcareRegistrationsModelInitialState,
		// % protected region % [Add any additional state for model BPJS Pcare Registrations here] off begin
		// % protected region % [Add any additional state for model BPJS Pcare Registrations here] end
	},
	BpjsProcedureModel: {
		...BpjsProcedureModelInitialState,
		// % protected region % [Add any additional state for model BPJS Procedure here] off begin
		// % protected region % [Add any additional state for model BPJS Procedure here] end
	},
	BpjsReferralSpecialistModel: {
		...BpjsReferralSpecialistModelInitialState,
		// % protected region % [Add any additional state for model BPJS Referral Specialist here] off begin
		// % protected region % [Add any additional state for model BPJS Referral Specialist here] end
	},
	BpjsSEPModel: {
		...BpjsSEPModelInitialState,
		// % protected region % [Add any additional state for model BPJS SEP here] off begin
		// % protected region % [Add any additional state for model BPJS SEP here] end
	},
	BpjsSEPINACBGIntegrationModel: {
		...BpjsSEPINACBGIntegrationModelInitialState,
		// % protected region % [Add any additional state for model BPJS SEP INACBG Integration here] off begin
		// % protected region % [Add any additional state for model BPJS SEP INACBG Integration here] end
	},
	BpjsSEPInternalDataModel: {
		...BpjsSEPInternalDataModelInitialState,
		// % protected region % [Add any additional state for model BPJS SEP Internal Data here] off begin
		// % protected region % [Add any additional state for model BPJS SEP Internal Data here] end
	},
	BpjsSEPSubmissionModel: {
		...BpjsSEPSubmissionModelInitialState,
		// % protected region % [Add any additional state for model BPJS SEP Submission here] off begin
		// % protected region % [Add any additional state for model BPJS SEP Submission here] end
	},
	BpjsSearchControlLetterModel: {
		...BpjsSearchControlLetterModelInitialState,
		// % protected region % [Add any additional state for model BPJS Search Control Letter here] off begin
		// % protected region % [Add any additional state for model BPJS Search Control Letter here] end
	},
	BpjsSearchSEPModel: {
		...BpjsSearchSEPModelInitialState,
		// % protected region % [Add any additional state for model BPJS Search SEP here] off begin
		// % protected region % [Add any additional state for model BPJS Search SEP here] end
	},
	BpjsServiceMappingModel: {
		...BpjsServiceMappingModelInitialState,
		// % protected region % [Add any additional state for model BPJS Service Mapping here] off begin
		// % protected region % [Add any additional state for model BPJS Service Mapping here] end
	},
	BpjsSpecialReferralModel: {
		...BpjsSpecialReferralModelInitialState,
		// % protected region % [Add any additional state for model BPJS Special Referral here] off begin
		// % protected region % [Add any additional state for model BPJS Special Referral here] end
	},
	BpjsTotalReferralSEPModel: {
		...BpjsTotalReferralSEPModelInitialState,
		// % protected region % [Add any additional state for model BPJS Total Referral SEP here] off begin
		// % protected region % [Add any additional state for model BPJS Total Referral SEP here] end
	},
	BpjsTreatmentClassMappingModel: {
		...BpjsTreatmentClassMappingModelInitialState,
		// % protected region % [Add any additional state for model BPJS Treatment Class Mapping here] off begin
		// % protected region % [Add any additional state for model BPJS Treatment Class Mapping here] end
	},
	BpjsTreatmentHistoryModel: {
		...BpjsTreatmentHistoryModelInitialState,
		// % protected region % [Add any additional state for model BPJS Treatment History here] off begin
		// % protected region % [Add any additional state for model BPJS Treatment History here] end
	},
	BpjsTreatmentRoomModel: {
		...BpjsTreatmentRoomModelInitialState,
		// % protected region % [Add any additional state for model BPJS Treatment Room here] off begin
		// % protected region % [Add any additional state for model BPJS Treatment Room here] end
	},
	BpjsUpdateDismissalDateModel: {
		...BpjsUpdateDismissalDateModelInitialState,
		// % protected region % [Add any additional state for model BPJS Update Dismissal Date here] off begin
		// % protected region % [Add any additional state for model BPJS Update Dismissal Date here] end
	},
	BpjsVisitDataModel: {
		...BpjsVisitDataModelInitialState,
		// % protected region % [Add any additional state for model BPJS Visit Data here] off begin
		// % protected region % [Add any additional state for model BPJS Visit Data here] end
	},
	BatchStockBalanceModel: {
		...BatchStockBalanceModelInitialState,
		// % protected region % [Add any additional state for model Batch Stock Balance here] off begin
		// % protected region % [Add any additional state for model Batch Stock Balance here] end
	},
	BatchStockBalancePerDateModel: {
		...BatchStockBalancePerDateModelInitialState,
		// % protected region % [Add any additional state for model Batch Stock Balance Per Date here] off begin
		// % protected region % [Add any additional state for model Batch Stock Balance Per Date here] end
	},
	BatchStockTransactionDetailModel: {
		...BatchStockTransactionDetailModelInitialState,
		// % protected region % [Add any additional state for model Batch Stock Transaction Detail here] off begin
		// % protected region % [Add any additional state for model Batch Stock Transaction Detail here] end
	},
	BedFacilityModel: {
		...BedFacilityModelInitialState,
		// % protected region % [Add any additional state for model Bed Facility here] off begin
		// % protected region % [Add any additional state for model Bed Facility here] end
	},
	BedReserveModel: {
		...BedReserveModelInitialState,
		// % protected region % [Add any additional state for model Bed Reserve here] off begin
		// % protected region % [Add any additional state for model Bed Reserve here] end
	},
	BirthHistoryModel: {
		...BirthHistoryModelInitialState,
		// % protected region % [Add any additional state for model Birth History here] off begin
		// % protected region % [Add any additional state for model Birth History here] end
	},
	BodyChartExaminationModel: {
		...BodyChartExaminationModelInitialState,
		// % protected region % [Add any additional state for model Body Chart Examination here] off begin
		// % protected region % [Add any additional state for model Body Chart Examination here] end
	},
	BpjsPcareKunjunganRujukanModel: {
		...BpjsPcareKunjunganRujukanModelInitialState,
		// % protected region % [Add any additional state for model Bpjs Pcare Kunjungan Rujukan here] off begin
		// % protected region % [Add any additional state for model Bpjs Pcare Kunjungan Rujukan here] end
	},
	BpjsPcarePendaftaranModel: {
		...BpjsPcarePendaftaranModelInitialState,
		// % protected region % [Add any additional state for model Bpjs Pcare Pendaftaran here] off begin
		// % protected region % [Add any additional state for model Bpjs Pcare Pendaftaran here] end
	},
	BpjsPcareRiwayatKunjunganModel: {
		...BpjsPcareRiwayatKunjunganModelInitialState,
		// % protected region % [Add any additional state for model Bpjs Pcare Riwayat Kunjungan here] off begin
		// % protected region % [Add any additional state for model Bpjs Pcare Riwayat Kunjungan here] end
	},
	CashAllocationModel: {
		...CashAllocationModelInitialState,
		// % protected region % [Add any additional state for model Cash Allocation here] off begin
		// % protected region % [Add any additional state for model Cash Allocation here] end
	},
	CashReceiptModel: {
		...CashReceiptModelInitialState,
		// % protected region % [Add any additional state for model Cash Receipt here] off begin
		// % protected region % [Add any additional state for model Cash Receipt here] end
	},
	CashRefundModel: {
		...CashRefundModelInitialState,
		// % protected region % [Add any additional state for model Cash Refund here] off begin
		// % protected region % [Add any additional state for model Cash Refund here] end
	},
	CashierUserModel: {
		...CashierUserModelInitialState,
		// % protected region % [Add any additional state for model Cashier User here] off begin
		// % protected region % [Add any additional state for model Cashier User here] end
	},
	CatalogueMedicalModel: {
		...CatalogueMedicalModelInitialState,
		// % protected region % [Add any additional state for model Catalogue Medical  here] off begin
		// % protected region % [Add any additional state for model Catalogue Medical  here] end
	},
	CatalogueNonMedicalModel: {
		...CatalogueNonMedicalModelInitialState,
		// % protected region % [Add any additional state for model Catalogue Non Medical here] off begin
		// % protected region % [Add any additional state for model Catalogue Non Medical here] end
	},
	CatalogueUOMModel: {
		...CatalogueUOMModelInitialState,
		// % protected region % [Add any additional state for model Catalogue UOM here] off begin
		// % protected region % [Add any additional state for model Catalogue UOM here] end
	},
	ChartOfAccountModel: {
		...ChartOfAccountModelInitialState,
		// % protected region % [Add any additional state for model Chart of Account here] off begin
		// % protected region % [Add any additional state for model Chart of Account here] end
	},
	ChartOfAccountMappingModel: {
		...ChartOfAccountMappingModelInitialState,
		// % protected region % [Add any additional state for model Chart of Account Mapping here] off begin
		// % protected region % [Add any additional state for model Chart of Account Mapping here] end
	},
	ClaimUserModel: {
		...ClaimUserModelInitialState,
		// % protected region % [Add any additional state for model Claim User here] off begin
		// % protected region % [Add any additional state for model Claim User here] end
	},
	CoTreatingDoctorModel: {
		...CoTreatingDoctorModelInitialState,
		// % protected region % [Add any additional state for model Co Treating Doctor here] off begin
		// % protected region % [Add any additional state for model Co Treating Doctor here] end
	},
	CompoundPrescriptionDetailModel: {
		...CompoundPrescriptionDetailModelInitialState,
		// % protected region % [Add any additional state for model Compound Prescription Detail here] off begin
		// % protected region % [Add any additional state for model Compound Prescription Detail here] end
	},
	CompoundPrescriptionItemModel: {
		...CompoundPrescriptionItemModelInitialState,
		// % protected region % [Add any additional state for model Compound Prescription Item here] off begin
		// % protected region % [Add any additional state for model Compound Prescription Item here] end
	},
	DailyCareCPPTModel: {
		...DailyCareCPPTModelInitialState,
		// % protected region % [Add any additional state for model Daily Care CPPT here] off begin
		// % protected region % [Add any additional state for model Daily Care CPPT here] end
	},
	DeliveryMedicalExaminationRecordModel: {
		...DeliveryMedicalExaminationRecordModelInitialState,
		// % protected region % [Add any additional state for model Delivery Medical Examination Record here] off begin
		// % protected region % [Add any additional state for model Delivery Medical Examination Record here] end
	},
	DeliveryProgressModel: {
		...DeliveryProgressModelInitialState,
		// % protected region % [Add any additional state for model Delivery Progress here] off begin
		// % protected region % [Add any additional state for model Delivery Progress here] end
	},
	DiagnosesAndProceduresModel: {
		...DiagnosesAndProceduresModelInitialState,
		// % protected region % [Add any additional state for model Diagnoses and Procedures here] off begin
		// % protected region % [Add any additional state for model Diagnoses and Procedures here] end
	},
	DiagnosisExaminationRecordModel: {
		...DiagnosisExaminationRecordModelInitialState,
		// % protected region % [Add any additional state for model Diagnosis Examination Record here] off begin
		// % protected region % [Add any additional state for model Diagnosis Examination Record here] end
	},
	DiagnosisNandaModel: {
		...DiagnosisNandaModelInitialState,
		// % protected region % [Add any additional state for model Diagnosis Nanda here] off begin
		// % protected region % [Add any additional state for model Diagnosis Nanda here] end
	},
	DiagnosticExaminationResultsModel: {
		...DiagnosticExaminationResultsModelInitialState,
		// % protected region % [Add any additional state for model Diagnostic Examination Results here] off begin
		// % protected region % [Add any additional state for model Diagnostic Examination Results here] end
	},
	DiagnosticStaffExaminationSummaryModel: {
		...DiagnosticStaffExaminationSummaryModelInitialState,
		// % protected region % [Add any additional state for model Diagnostic Staff Examination Summary here] off begin
		// % protected region % [Add any additional state for model Diagnostic Staff Examination Summary here] end
	},
	DiagnosticSupportGeneralConfigurationModel: {
		...DiagnosticSupportGeneralConfigurationModelInitialState,
		// % protected region % [Add any additional state for model Diagnostic Support General Configuration here] off begin
		// % protected region % [Add any additional state for model Diagnostic Support General Configuration here] end
	},
	DiagnosticSupportUserModel: {
		...DiagnosticSupportUserModelInitialState,
		// % protected region % [Add any additional state for model Diagnostic Support User here] off begin
		// % protected region % [Add any additional state for model Diagnostic Support User here] end
	},
	DoctorScheduleModel: {
		...DoctorScheduleModelInitialState,
		// % protected region % [Add any additional state for model Doctor Schedule here] off begin
		// % protected region % [Add any additional state for model Doctor Schedule here] end
	},
	DoctorUserModel: {
		...DoctorUserModelInitialState,
		// % protected region % [Add any additional state for model Doctor User here] off begin
		// % protected region % [Add any additional state for model Doctor User here] end
	},
	EntExaminationModel: {
		...EntExaminationModelInitialState,
		// % protected region % [Add any additional state for model ENT Examination here] off begin
		// % protected region % [Add any additional state for model ENT Examination here] end
	},
	EmergencyMedicalExaminationRecordModel: {
		...EmergencyMedicalExaminationRecordModelInitialState,
		// % protected region % [Add any additional state for model Emergency Medical Examination Record here] off begin
		// % protected region % [Add any additional state for model Emergency Medical Examination Record here] end
	},
	ExaminationGroupModel: {
		...ExaminationGroupModelInitialState,
		// % protected region % [Add any additional state for model Examination Group here] off begin
		// % protected region % [Add any additional state for model Examination Group here] end
	},
	ExaminationItemModel: {
		...ExaminationItemModelInitialState,
		// % protected region % [Add any additional state for model Examination Item here] off begin
		// % protected region % [Add any additional state for model Examination Item here] end
	},
	ExaminationItemDetailModel: {
		...ExaminationItemDetailModelInitialState,
		// % protected region % [Add any additional state for model Examination Item Detail here] off begin
		// % protected region % [Add any additional state for model Examination Item Detail here] end
	},
	FacilityHistoryModel: {
		...FacilityHistoryModelInitialState,
		// % protected region % [Add any additional state for model Facility History here] off begin
		// % protected region % [Add any additional state for model Facility History here] end
	},
	FacilityUserModel: {
		...FacilityUserModelInitialState,
		// % protected region % [Add any additional state for model Facility User here] off begin
		// % protected region % [Add any additional state for model Facility User here] end
	},
	FluidBalanceDetailModel: {
		...FluidBalanceDetailModelInitialState,
		// % protected region % [Add any additional state for model Fluid Balance Detail here] off begin
		// % protected region % [Add any additional state for model Fluid Balance Detail here] end
	},
	FormulirKonselingTesHivModel: {
		...FormulirKonselingTesHivModelInitialState,
		// % protected region % [Add any additional state for model Formulir Konseling Tes Hiv here] off begin
		// % protected region % [Add any additional state for model Formulir Konseling Tes Hiv here] end
	},
	GoodsReceiveNoteModel: {
		...GoodsReceiveNoteModelInitialState,
		// % protected region % [Add any additional state for model Goods Receive Note here] off begin
		// % protected region % [Add any additional state for model Goods Receive Note here] end
	},
	GoodsReceiveNoteBatchModel: {
		...GoodsReceiveNoteBatchModelInitialState,
		// % protected region % [Add any additional state for model Goods Receive Note Batch here] off begin
		// % protected region % [Add any additional state for model Goods Receive Note Batch here] end
	},
	GoodsReceiveNoteItemModel: {
		...GoodsReceiveNoteItemModelInitialState,
		// % protected region % [Add any additional state for model Goods Receive Note Item here] off begin
		// % protected region % [Add any additional state for model Goods Receive Note Item here] end
	},
	HealthFacilityModel: {
		...HealthFacilityModelInitialState,
		// % protected region % [Add any additional state for model Health Facility here] off begin
		// % protected region % [Add any additional state for model Health Facility here] end
	},
	HemodialysisExaminationModel: {
		...HemodialysisExaminationModelInitialState,
		// % protected region % [Add any additional state for model Hemodialysis Examination here] off begin
		// % protected region % [Add any additional state for model Hemodialysis Examination here] end
	},
	HemodialysisMonitoringModel: {
		...HemodialysisMonitoringModelInitialState,
		// % protected region % [Add any additional state for model Hemodialysis Monitoring here] off begin
		// % protected region % [Add any additional state for model Hemodialysis Monitoring here] end
	},
	HospitalBranchInformationModel: {
		...HospitalBranchInformationModelInitialState,
		// % protected region % [Add any additional state for model Hospital Branch Information here] off begin
		// % protected region % [Add any additional state for model Hospital Branch Information here] end
	},
	HospitalGroupInformationModel: {
		...HospitalGroupInformationModelInitialState,
		// % protected region % [Add any additional state for model Hospital Group Information here] off begin
		// % protected region % [Add any additional state for model Hospital Group Information here] end
	},
	Icd10Model: {
		...Icd10ModelInitialState,
		// % protected region % [Add any additional state for model ICD 10 here] off begin
		// % protected region % [Add any additional state for model ICD 10 here] end
	},
	Icd9CMModel: {
		...Icd9CMModelInitialState,
		// % protected region % [Add any additional state for model ICD 9 CM here] off begin
		// % protected region % [Add any additional state for model ICD 9 CM here] end
	},
	InformedConsentModel: {
		...InformedConsentModelInitialState,
		// % protected region % [Add any additional state for model Informed Consent here] off begin
		// % protected region % [Add any additional state for model Informed Consent here] end
	},
	InpatientMedicalExaminationRecordModel: {
		...InpatientMedicalExaminationRecordModelInitialState,
		// % protected region % [Add any additional state for model Inpatient Medical Examination Record here] off begin
		// % protected region % [Add any additional state for model Inpatient Medical Examination Record here] end
	},
	InsuranceBenefitPlanModel: {
		...InsuranceBenefitPlanModelInitialState,
		// % protected region % [Add any additional state for model Insurance Benefit Plan here] off begin
		// % protected region % [Add any additional state for model Insurance Benefit Plan here] end
	},
	InsuranceProviderModel: {
		...InsuranceProviderModelInitialState,
		// % protected region % [Add any additional state for model Insurance Provider here] off begin
		// % protected region % [Add any additional state for model Insurance Provider here] end
	},
	InternalOrderModel: {
		...InternalOrderModelInitialState,
		// % protected region % [Add any additional state for model Internal Order here] off begin
		// % protected region % [Add any additional state for model Internal Order here] end
	},
	InternalOrderStockDetailModel: {
		...InternalOrderStockDetailModelInitialState,
		// % protected region % [Add any additional state for model Internal Order Stock Detail here] off begin
		// % protected region % [Add any additional state for model Internal Order Stock Detail here] end
	},
	IntraoperativeRecordsModel: {
		...IntraoperativeRecordsModelInitialState,
		// % protected region % [Add any additional state for model Intraoperative Records here] off begin
		// % protected region % [Add any additional state for model Intraoperative Records here] end
	},
	InventoryAdjusmentBatchModel: {
		...InventoryAdjusmentBatchModelInitialState,
		// % protected region % [Add any additional state for model Inventory Adjusment Batch here] off begin
		// % protected region % [Add any additional state for model Inventory Adjusment Batch here] end
	},
	InventoryAdjustmentModel: {
		...InventoryAdjustmentModelInitialState,
		// % protected region % [Add any additional state for model Inventory Adjustment here] off begin
		// % protected region % [Add any additional state for model Inventory Adjustment here] end
	},
	InventoryAdjustmentItemModel: {
		...InventoryAdjustmentItemModelInitialState,
		// % protected region % [Add any additional state for model Inventory Adjustment Item here] off begin
		// % protected region % [Add any additional state for model Inventory Adjustment Item here] end
	},
	InventoryBatchCorrectionModel: {
		...InventoryBatchCorrectionModelInitialState,
		// % protected region % [Add any additional state for model Inventory Batch Correction here] off begin
		// % protected region % [Add any additional state for model Inventory Batch Correction here] end
	},
	InventoryBatchCorrectionItemModel: {
		...InventoryBatchCorrectionItemModelInitialState,
		// % protected region % [Add any additional state for model Inventory Batch Correction Item here] off begin
		// % protected region % [Add any additional state for model Inventory Batch Correction Item here] end
	},
	InvoiceModel: {
		...InvoiceModelInitialState,
		// % protected region % [Add any additional state for model Invoice here] off begin
		// % protected region % [Add any additional state for model Invoice here] end
	},
	InvoiceItemModel: {
		...InvoiceItemModelInitialState,
		// % protected region % [Add any additional state for model Invoice Item here] off begin
		// % protected region % [Add any additional state for model Invoice Item here] end
	},
	InvoiceItemComponentModel: {
		...InvoiceItemComponentModelInitialState,
		// % protected region % [Add any additional state for model Invoice Item Component here] off begin
		// % protected region % [Add any additional state for model Invoice Item Component here] end
	},
	InvoicePaymentInsuranceModel: {
		...InvoicePaymentInsuranceModelInitialState,
		// % protected region % [Add any additional state for model Invoice Payment Insurance here] off begin
		// % protected region % [Add any additional state for model Invoice Payment Insurance here] end
	},
	InvoicePaymentOtherModel: {
		...InvoicePaymentOtherModelInitialState,
		// % protected region % [Add any additional state for model Invoice Payment Other here] off begin
		// % protected region % [Add any additional state for model Invoice Payment Other here] end
	},
	InvoicePaymentSelfPayingModel: {
		...InvoicePaymentSelfPayingModelInitialState,
		// % protected region % [Add any additional state for model Invoice Payment Self Paying here] off begin
		// % protected region % [Add any additional state for model Invoice Payment Self Paying here] end
	},
	InvoiceSummaryModel: {
		...InvoiceSummaryModelInitialState,
		// % protected region % [Add any additional state for model Invoice Summary here] off begin
		// % protected region % [Add any additional state for model Invoice Summary here] end
	},
	JournalModel: {
		...JournalModelInitialState,
		// % protected region % [Add any additional state for model Journal here] off begin
		// % protected region % [Add any additional state for model Journal here] end
	},
	LibraryModel: {
		...LibraryModelInitialState,
		// % protected region % [Add any additional state for model Library here] off begin
		// % protected region % [Add any additional state for model Library here] end
	},
	LocationModel: {
		...LocationModelInitialState,
		// % protected region % [Add any additional state for model Location here] off begin
		// % protected region % [Add any additional state for model Location here] end
	},
	McuPackageModel: {
		...McuPackageModelInitialState,
		// % protected region % [Add any additional state for model MCU Package here] off begin
		// % protected region % [Add any additional state for model MCU Package here] end
	},
	McuPackageItemModel: {
		...McuPackageItemModelInitialState,
		// % protected region % [Add any additional state for model MCU Package Item here] off begin
		// % protected region % [Add any additional state for model MCU Package Item here] end
	},
	ManagementUserModel: {
		...ManagementUserModelInitialState,
		// % protected region % [Add any additional state for model Management User here] off begin
		// % protected region % [Add any additional state for model Management User here] end
	},
	MedicalCertificateDischargeResumeModel: {
		...MedicalCertificateDischargeResumeModelInitialState,
		// % protected region % [Add any additional state for model Medical Certificate  Discharge Resume here] off begin
		// % protected region % [Add any additional state for model Medical Certificate  Discharge Resume here] end
	},
	MedicalCertificateBirthModel: {
		...MedicalCertificateBirthModelInitialState,
		// % protected region % [Add any additional state for model Medical Certificate Birth here] off begin
		// % protected region % [Add any additional state for model Medical Certificate Birth here] end
	},
	MedicalCertificateHospitalizationModel: {
		...MedicalCertificateHospitalizationModelInitialState,
		// % protected region % [Add any additional state for model Medical Certificate Hospitalization here] off begin
		// % protected region % [Add any additional state for model Medical Certificate Hospitalization here] end
	},
	MedicalCertificateMedicalAttendanceModel: {
		...MedicalCertificateMedicalAttendanceModelInitialState,
		// % protected region % [Add any additional state for model Medical Certificate Medical Attendance here] off begin
		// % protected region % [Add any additional state for model Medical Certificate Medical Attendance here] end
	},
	MedicalCertificateMentalHealthModel: {
		...MedicalCertificateMentalHealthModelInitialState,
		// % protected region % [Add any additional state for model Medical Certificate Mental Health here] off begin
		// % protected region % [Add any additional state for model Medical Certificate Mental Health here] end
	},
	MedicalCertificatePhysicalHealthModel: {
		...MedicalCertificatePhysicalHealthModelInitialState,
		// % protected region % [Add any additional state for model Medical Certificate Physical Health here] off begin
		// % protected region % [Add any additional state for model Medical Certificate Physical Health here] end
	},
	MedicalCertificateRestrictedWorkModel: {
		...MedicalCertificateRestrictedWorkModelInitialState,
		// % protected region % [Add any additional state for model Medical Certificate Restricted Work here] off begin
		// % protected region % [Add any additional state for model Medical Certificate Restricted Work here] end
	},
	MedicalCertificateSickLeaveModel: {
		...MedicalCertificateSickLeaveModelInitialState,
		// % protected region % [Add any additional state for model Medical Certificate Sick Leave here] off begin
		// % protected region % [Add any additional state for model Medical Certificate Sick Leave here] end
	},
	MedicalExaminationRecordModel: {
		...MedicalExaminationRecordModelInitialState,
		// % protected region % [Add any additional state for model Medical Examination Record here] off begin
		// % protected region % [Add any additional state for model Medical Examination Record here] end
	},
	MedicalExaminationRecordDischargeSummaryModel: {
		...MedicalExaminationRecordDischargeSummaryModelInitialState,
		// % protected region % [Add any additional state for model Medical Examination Record Discharge Summary here] off begin
		// % protected region % [Add any additional state for model Medical Examination Record Discharge Summary here] end
	},
	MedicalFeeModel: {
		...MedicalFeeModelInitialState,
		// % protected region % [Add any additional state for model Medical Fee here] off begin
		// % protected region % [Add any additional state for model Medical Fee here] end
	},
	MedicalFeeItemComponentModel: {
		...MedicalFeeItemComponentModelInitialState,
		// % protected region % [Add any additional state for model Medical Fee Item Component here] off begin
		// % protected region % [Add any additional state for model Medical Fee Item Component here] end
	},
	MedicalRecordInitialChecklistModel: {
		...MedicalRecordInitialChecklistModelInitialState,
		// % protected region % [Add any additional state for model Medical Record Initial Checklist here] off begin
		// % protected region % [Add any additional state for model Medical Record Initial Checklist here] end
	},
	MedicalRecordNextVerificationChecklistModel: {
		...MedicalRecordNextVerificationChecklistModelInitialState,
		// % protected region % [Add any additional state for model Medical Record Next Verification Checklist here] off begin
		// % protected region % [Add any additional state for model Medical Record Next Verification Checklist here] end
	},
	MedicalRecordUserModel: {
		...MedicalRecordUserModelInitialState,
		// % protected region % [Add any additional state for model Medical Record user here] off begin
		// % protected region % [Add any additional state for model Medical Record user here] end
	},
	MedicalTranscriberUserModel: {
		...MedicalTranscriberUserModelInitialState,
		// % protected region % [Add any additional state for model Medical Transcriber User here] off begin
		// % protected region % [Add any additional state for model Medical Transcriber User here] end
	},
	MedicationAdministeredHistoryModel: {
		...MedicationAdministeredHistoryModelInitialState,
		// % protected region % [Add any additional state for model Medication Administered History here] off begin
		// % protected region % [Add any additional state for model Medication Administered History here] end
	},
	MedicationCompoundModel: {
		...MedicationCompoundModelInitialState,
		// % protected region % [Add any additional state for model Medication Compound here] off begin
		// % protected region % [Add any additional state for model Medication Compound here] end
	},
	MedicationHeaderModel: {
		...MedicationHeaderModelInitialState,
		// % protected region % [Add any additional state for model Medication Header here] off begin
		// % protected region % [Add any additional state for model Medication Header here] end
	},
	MedicationItemModel: {
		...MedicationItemModelInitialState,
		// % protected region % [Add any additional state for model Medication Item here] off begin
		// % protected region % [Add any additional state for model Medication Item here] end
	},
	MerchantModel: {
		...MerchantModelInitialState,
		// % protected region % [Add any additional state for model Merchant here] off begin
		// % protected region % [Add any additional state for model Merchant here] end
	},
	MerchantSurchargeAndFeeModel: {
		...MerchantSurchargeAndFeeModelInitialState,
		// % protected region % [Add any additional state for model Merchant Surcharge and Fee here] off begin
		// % protected region % [Add any additional state for model Merchant Surcharge and Fee here] end
	},
	NhisClaimModel: {
		...NhisClaimModelInitialState,
		// % protected region % [Add any additional state for model NHIS Claim here] off begin
		// % protected region % [Add any additional state for model NHIS Claim here] end
	},
	NhisClaimGDRGDetailModel: {
		...NhisClaimGDRGDetailModelInitialState,
		// % protected region % [Add any additional state for model NHIS Claim GDRG Detail here] off begin
		// % protected region % [Add any additional state for model NHIS Claim GDRG Detail here] end
	},
	NhisClaimInvestigationDetailModel: {
		...NhisClaimInvestigationDetailModelInitialState,
		// % protected region % [Add any additional state for model NHIS Claim Investigation Detail here] off begin
		// % protected region % [Add any additional state for model NHIS Claim Investigation Detail here] end
	},
	NhisGDRGModel: {
		...NhisGDRGModelInitialState,
		// % protected region % [Add any additional state for model NHIS GDRG here] off begin
		// % protected region % [Add any additional state for model NHIS GDRG here] end
	},
	NhisInvestigationModel: {
		...NhisInvestigationModelInitialState,
		// % protected region % [Add any additional state for model NHIS Investigation here] off begin
		// % protected region % [Add any additional state for model NHIS Investigation here] end
	},
	NhisMedicineModel: {
		...NhisMedicineModelInitialState,
		// % protected region % [Add any additional state for model NHIS Medicine here] off begin
		// % protected region % [Add any additional state for model NHIS Medicine here] end
	},
	NhisServiceOutcomeModel: {
		...NhisServiceOutcomeModelInitialState,
		// % protected region % [Add any additional state for model NHIS Service Outcome here] off begin
		// % protected region % [Add any additional state for model NHIS Service Outcome here] end
	},
	NhisSpecialtyAttendedModel: {
		...NhisSpecialtyAttendedModelInitialState,
		// % protected region % [Add any additional state for model NHIS Specialty Attended here] off begin
		// % protected region % [Add any additional state for model NHIS Specialty Attended here] end
	},
	NhisTypeOfServiceModel: {
		...NhisTypeOfServiceModelInitialState,
		// % protected region % [Add any additional state for model NHIS Type Of Service here] off begin
		// % protected region % [Add any additional state for model NHIS Type Of Service here] end
	},
	NewbornDetailModel: {
		...NewbornDetailModelInitialState,
		// % protected region % [Add any additional state for model Newborn Detail here] off begin
		// % protected region % [Add any additional state for model Newborn Detail here] end
	},
	NumberingSetupModel: {
		...NumberingSetupModelInitialState,
		// % protected region % [Add any additional state for model Numbering Setup here] off begin
		// % protected region % [Add any additional state for model Numbering Setup here] end
	},
	NurseUserModel: {
		...NurseUserModelInitialState,
		// % protected region % [Add any additional state for model Nurse User here] off begin
		// % protected region % [Add any additional state for model Nurse User here] end
	},
	NurseVitalSignMeasurementModel: {
		...NurseVitalSignMeasurementModelInitialState,
		// % protected region % [Add any additional state for model Nurse Vital Sign Measurement here] off begin
		// % protected region % [Add any additional state for model Nurse Vital Sign Measurement here] end
	},
	ObstetricAndGynecologyHistoryModel: {
		...ObstetricAndGynecologyHistoryModelInitialState,
		// % protected region % [Add any additional state for model Obstetric And Gynecology History here] off begin
		// % protected region % [Add any additional state for model Obstetric And Gynecology History here] end
	},
	OdontogramExaminationModel: {
		...OdontogramExaminationModelInitialState,
		// % protected region % [Add any additional state for model Odontogram Examination here] off begin
		// % protected region % [Add any additional state for model Odontogram Examination here] end
	},
	OperatingTheaterMedicalExaminationRecordModel: {
		...OperatingTheaterMedicalExaminationRecordModelInitialState,
		// % protected region % [Add any additional state for model Operating Theater Medical Examination Record here] off begin
		// % protected region % [Add any additional state for model Operating Theater Medical Examination Record here] end
	},
	OphthalmologyExaminationModel: {
		...OphthalmologyExaminationModelInitialState,
		// % protected region % [Add any additional state for model Ophthalmology Examination here] off begin
		// % protected region % [Add any additional state for model Ophthalmology Examination here] end
	},
	PcareActionExaminationModel: {
		...PcareActionExaminationModelInitialState,
		// % protected region % [Add any additional state for model PCare Action Examination here] off begin
		// % protected region % [Add any additional state for model PCare Action Examination here] end
	},
	PcareClubProlanisModel: {
		...PcareClubProlanisModelInitialState,
		// % protected region % [Add any additional state for model PCare Club Prolanis here] off begin
		// % protected region % [Add any additional state for model PCare Club Prolanis here] end
	},
	PcareCompoundDrugModel: {
		...PcareCompoundDrugModelInitialState,
		// % protected region % [Add any additional state for model PCare Compound Drug here] off begin
		// % protected region % [Add any additional state for model PCare Compound Drug here] end
	},
	PcareCompoundDrugItemModel: {
		...PcareCompoundDrugItemModelInitialState,
		// % protected region % [Add any additional state for model PCare Compound Drug Item here] off begin
		// % protected region % [Add any additional state for model PCare Compound Drug Item here] end
	},
	PcareDiagnosaModel: {
		...PcareDiagnosaModelInitialState,
		// % protected region % [Add any additional state for model PCare Diagnosa here] off begin
		// % protected region % [Add any additional state for model PCare Diagnosa here] end
	},
	PcareDokterModel: {
		...PcareDokterModelInitialState,
		// % protected region % [Add any additional state for model PCare Dokter here] off begin
		// % protected region % [Add any additional state for model PCare Dokter here] end
	},
	PcareExaminationModel: {
		...PcareExaminationModelInitialState,
		// % protected region % [Add any additional state for model PCare Examination here] off begin
		// % protected region % [Add any additional state for model PCare Examination here] end
	},
	PcareMCUModel: {
		...PcareMCUModelInitialState,
		// % protected region % [Add any additional state for model PCare MCU here] off begin
		// % protected region % [Add any additional state for model PCare MCU here] end
	},
	PcareNonCompoundDrugModel: {
		...PcareNonCompoundDrugModelInitialState,
		// % protected region % [Add any additional state for model PCare NonCompound Drug here] off begin
		// % protected region % [Add any additional state for model PCare NonCompound Drug here] end
	},
	PcareReferensiSaranaModel: {
		...PcareReferensiSaranaModelInitialState,
		// % protected region % [Add any additional state for model PCare Referensi Sarana here] off begin
		// % protected region % [Add any additional state for model PCare Referensi Sarana here] end
	},
	PcareStatusPulangModel: {
		...PcareStatusPulangModelInitialState,
		// % protected region % [Add any additional state for model PCare Status Pulang here] off begin
		// % protected region % [Add any additional state for model PCare Status Pulang here] end
	},
	PcareTindakanModel: {
		...PcareTindakanModelInitialState,
		// % protected region % [Add any additional state for model PCare Tindakan here] off begin
		// % protected region % [Add any additional state for model PCare Tindakan here] end
	},
	PcareUmumModel: {
		...PcareUmumModelInitialState,
		// % protected region % [Add any additional state for model PCare Umum here] off begin
		// % protected region % [Add any additional state for model PCare Umum here] end
	},
	PatientCaseHistoryModel: {
		...PatientCaseHistoryModelInitialState,
		// % protected region % [Add any additional state for model Patient Case History here] off begin
		// % protected region % [Add any additional state for model Patient Case History here] end
	},
	PatientConsentModel: {
		...PatientConsentModelInitialState,
		// % protected region % [Add any additional state for model Patient Consent here] off begin
		// % protected region % [Add any additional state for model Patient Consent here] end
	},
	PatientContactInfoModel: {
		...PatientContactInfoModelInitialState,
		// % protected region % [Add any additional state for model Patient Contact Info here] off begin
		// % protected region % [Add any additional state for model Patient Contact Info here] end
	},
	PatientDetailModel: {
		...PatientDetailModelInitialState,
		// % protected region % [Add any additional state for model Patient Detail here] off begin
		// % protected region % [Add any additional state for model Patient Detail here] end
	},
	PatientDetailAddressModel: {
		...PatientDetailAddressModelInitialState,
		// % protected region % [Add any additional state for model Patient Detail Address here] off begin
		// % protected region % [Add any additional state for model Patient Detail Address here] end
	},
	PatientEmergencyContactDetailModel: {
		...PatientEmergencyContactDetailModelInitialState,
		// % protected region % [Add any additional state for model Patient Emergency Contact Detail here] off begin
		// % protected region % [Add any additional state for model Patient Emergency Contact Detail here] end
	},
	PatientEmploymentDetailModel: {
		...PatientEmploymentDetailModelInitialState,
		// % protected region % [Add any additional state for model Patient Employment Detail  here] off begin
		// % protected region % [Add any additional state for model Patient Employment Detail  here] end
	},
	PatientGeneralInfoModel: {
		...PatientGeneralInfoModelInitialState,
		// % protected region % [Add any additional state for model Patient General Info here] off begin
		// % protected region % [Add any additional state for model Patient General Info here] end
	},
	PatientPaymentSelfPayingModel: {
		...PatientPaymentSelfPayingModelInitialState,
		// % protected region % [Add any additional state for model Patient Payment  Self Paying here] off begin
		// % protected region % [Add any additional state for model Patient Payment  Self Paying here] end
	},
	PatientPaymentBPJSModel: {
		...PatientPaymentBPJSModelInitialState,
		// % protected region % [Add any additional state for model Patient Payment BPJS here] off begin
		// % protected region % [Add any additional state for model Patient Payment BPJS here] end
	},
	PatientPaymentInsuranceModel: {
		...PatientPaymentInsuranceModelInitialState,
		// % protected region % [Add any additional state for model Patient Payment Insurance here] off begin
		// % protected region % [Add any additional state for model Patient Payment Insurance here] end
	},
	PatientPaymentOthersModel: {
		...PatientPaymentOthersModelInitialState,
		// % protected region % [Add any additional state for model Patient Payment Others here] off begin
		// % protected region % [Add any additional state for model Patient Payment Others here] end
	},
	PatientPersonalInfoModel: {
		...PatientPersonalInfoModelInitialState,
		// % protected region % [Add any additional state for model Patient Personal Info here] off begin
		// % protected region % [Add any additional state for model Patient Personal Info here] end
	},
	PatientSupportingDocumentModel: {
		...PatientSupportingDocumentModelInitialState,
		// % protected region % [Add any additional state for model Patient Supporting Document here] off begin
		// % protected region % [Add any additional state for model Patient Supporting Document here] end
	},
	PatientVisitModel: {
		...PatientVisitModelInitialState,
		// % protected region % [Add any additional state for model Patient Visit here] off begin
		// % protected region % [Add any additional state for model Patient Visit here] end
	},
	PatientVisitPatientPaymentInsuranceModel: {
		...PatientVisitPatientPaymentInsuranceModelInitialState,
		// % protected region % [Add any additional state for model Patient Visit Patient Payment Insurance here] off begin
		// % protected region % [Add any additional state for model Patient Visit Patient Payment Insurance here] end
	},
	PatientVisitPatientPaymentOthersModel: {
		...PatientVisitPatientPaymentOthersModelInitialState,
		// % protected region % [Add any additional state for model Patient Visit Patient Payment Others here] off begin
		// % protected region % [Add any additional state for model Patient Visit Patient Payment Others here] end
	},
	PatientVisitPaymentSelfPayingModel: {
		...PatientVisitPaymentSelfPayingModelInitialState,
		// % protected region % [Add any additional state for model Patient Visit Payment Self Paying here] off begin
		// % protected region % [Add any additional state for model Patient Visit Payment Self Paying here] end
	},
	PatientVitalInformationModel: {
		...PatientVitalInformationModelInitialState,
		// % protected region % [Add any additional state for model Patient Vital Information here] off begin
		// % protected region % [Add any additional state for model Patient Vital Information here] end
	},
	PharmacySetupModel: {
		...PharmacySetupModelInitialState,
		// % protected region % [Add any additional state for model Pharmacy Setup here] off begin
		// % protected region % [Add any additional state for model Pharmacy Setup here] end
	},
	PharmacyUserModel: {
		...PharmacyUserModelInitialState,
		// % protected region % [Add any additional state for model Pharmacy User here] off begin
		// % protected region % [Add any additional state for model Pharmacy User here] end
	},
	PostOperativeDetailsModel: {
		...PostOperativeDetailsModelInitialState,
		// % protected region % [Add any additional state for model Post Operative Details here] off begin
		// % protected region % [Add any additional state for model Post Operative Details here] end
	},
	PreoperativeRecordsModel: {
		...PreoperativeRecordsModelInitialState,
		// % protected region % [Add any additional state for model Preoperative Records here] off begin
		// % protected region % [Add any additional state for model Preoperative Records here] end
	},
	PrescriptionCompoundModel: {
		...PrescriptionCompoundModelInitialState,
		// % protected region % [Add any additional state for model Prescription Compound here] off begin
		// % protected region % [Add any additional state for model Prescription Compound here] end
	},
	PrescriptionHeaderModel: {
		...PrescriptionHeaderModelInitialState,
		// % protected region % [Add any additional state for model Prescription Header here] off begin
		// % protected region % [Add any additional state for model Prescription Header here] end
	},
	PrescriptionItemModel: {
		...PrescriptionItemModelInitialState,
		// % protected region % [Add any additional state for model Prescription Item here] off begin
		// % protected region % [Add any additional state for model Prescription Item here] end
	},
	PriceComponentModel: {
		...PriceComponentModelInitialState,
		// % protected region % [Add any additional state for model Price Component here] off begin
		// % protected region % [Add any additional state for model Price Component here] end
	},
	PrivilegeModel: {
		...PrivilegeModelInitialState,
		// % protected region % [Add any additional state for model Privilege here] off begin
		// % protected region % [Add any additional state for model Privilege here] end
	},
	ProcessWorkflowModel: {
		...ProcessWorkflowModelInitialState,
		// % protected region % [Add any additional state for model Process Workflow here] off begin
		// % protected region % [Add any additional state for model Process Workflow here] end
	},
	PurchaseOrderModel: {
		...PurchaseOrderModelInitialState,
		// % protected region % [Add any additional state for model Purchase Order here] off begin
		// % protected region % [Add any additional state for model Purchase Order here] end
	},
	PurchaseOrderStockDetailModel: {
		...PurchaseOrderStockDetailModelInitialState,
		// % protected region % [Add any additional state for model Purchase Order Stock Detail here] off begin
		// % protected region % [Add any additional state for model Purchase Order Stock Detail here] end
	},
	PurchaseRequisitionModel: {
		...PurchaseRequisitionModelInitialState,
		// % protected region % [Add any additional state for model Purchase Requisition here] off begin
		// % protected region % [Add any additional state for model Purchase Requisition here] end
	},
	PurchaseRequisitionStockDetailModel: {
		...PurchaseRequisitionStockDetailModelInitialState,
		// % protected region % [Add any additional state for model Purchase Requisition Stock Detail here] off begin
		// % protected region % [Add any additional state for model Purchase Requisition Stock Detail here] end
	},
	PurchasingUserModel: {
		...PurchasingUserModelInitialState,
		// % protected region % [Add any additional state for model Purchasing User here] off begin
		// % protected region % [Add any additional state for model Purchasing User here] end
	},
	ReferenceDataModel: {
		...ReferenceDataModelInitialState,
		// % protected region % [Add any additional state for model Reference Data here] off begin
		// % protected region % [Add any additional state for model Reference Data here] end
	},
	ReferenceHeaderModel: {
		...ReferenceHeaderModelInitialState,
		// % protected region % [Add any additional state for model Reference Header here] off begin
		// % protected region % [Add any additional state for model Reference Header here] end
	},
	RegistrationModel: {
		...RegistrationModelInitialState,
		// % protected region % [Add any additional state for model Registration here] off begin
		// % protected region % [Add any additional state for model Registration here] end
	},
	RegistrationUserModel: {
		...RegistrationUserModelInitialState,
		// % protected region % [Add any additional state for model Registration User here] off begin
		// % protected region % [Add any additional state for model Registration User here] end
	},
	RetailPharmacyModel: {
		...RetailPharmacyModelInitialState,
		// % protected region % [Add any additional state for model Retail Pharmacy here] off begin
		// % protected region % [Add any additional state for model Retail Pharmacy here] end
	},
	RetailPharmacyInvoiceModel: {
		...RetailPharmacyInvoiceModelInitialState,
		// % protected region % [Add any additional state for model Retail Pharmacy Invoice here] off begin
		// % protected region % [Add any additional state for model Retail Pharmacy Invoice here] end
	},
	RetailPharmacyStockDetailModel: {
		...RetailPharmacyStockDetailModelInitialState,
		// % protected region % [Add any additional state for model Retail Pharmacy Stock Detail here] off begin
		// % protected region % [Add any additional state for model Retail Pharmacy Stock Detail here] end
	},
	ReturnSupplierModel: {
		...ReturnSupplierModelInitialState,
		// % protected region % [Add any additional state for model Return Supplier here] off begin
		// % protected region % [Add any additional state for model Return Supplier here] end
	},
	ReturnSupplierStockDetailModel: {
		...ReturnSupplierStockDetailModelInitialState,
		// % protected region % [Add any additional state for model Return Supplier Stock Detail here] off begin
		// % protected region % [Add any additional state for model Return Supplier Stock Detail here] end
	},
	RoleModel: {
		...RoleModelInitialState,
		// % protected region % [Add any additional state for model Role here] off begin
		// % protected region % [Add any additional state for model Role here] end
	},
	RoomFacilityModel: {
		...RoomFacilityModelInitialState,
		// % protected region % [Add any additional state for model Room Facility here] off begin
		// % protected region % [Add any additional state for model Room Facility here] end
	},
	RoomTransferModel: {
		...RoomTransferModelInitialState,
		// % protected region % [Add any additional state for model Room Transfer here] off begin
		// % protected region % [Add any additional state for model Room Transfer here] end
	},
	SepModel: {
		...SepModelInitialState,
		// % protected region % [Add any additional state for model SEP here] off begin
		// % protected region % [Add any additional state for model SEP here] end
	},
	SampleCollectionInformationModel: {
		...SampleCollectionInformationModelInitialState,
		// % protected region % [Add any additional state for model Sample Collection Information here] off begin
		// % protected region % [Add any additional state for model Sample Collection Information here] end
	},
	SampleCollectionItemsModel: {
		...SampleCollectionItemsModelInitialState,
		// % protected region % [Add any additional state for model Sample Collection Items here] off begin
		// % protected region % [Add any additional state for model Sample Collection Items here] end
	},
	SatuSehatConfigurationModel: {
		...SatuSehatConfigurationModelInitialState,
		// % protected region % [Add any additional state for model Satu Sehat Configuration here] off begin
		// % protected region % [Add any additional state for model Satu Sehat Configuration here] end
	},
	ServiceModel: {
		...ServiceModelInitialState,
		// % protected region % [Add any additional state for model Service here] off begin
		// % protected region % [Add any additional state for model Service here] end
	},
	ServiceFacilityCategoryModel: {
		...ServiceFacilityCategoryModelInitialState,
		// % protected region % [Add any additional state for model Service Facility Category here] off begin
		// % protected region % [Add any additional state for model Service Facility Category here] end
	},
	ServiceItemModel: {
		...ServiceItemModelInitialState,
		// % protected region % [Add any additional state for model Service Item here] off begin
		// % protected region % [Add any additional state for model Service Item here] end
	},
	ServiceItemAssignmentModel: {
		...ServiceItemAssignmentModelInitialState,
		// % protected region % [Add any additional state for model Service Item Assignment here] off begin
		// % protected region % [Add any additional state for model Service Item Assignment here] end
	},
	StaffModel: {
		...StaffModelInitialState,
		// % protected region % [Add any additional state for model Staff here] off begin
		// % protected region % [Add any additional state for model Staff here] end
	},
	StockCatalogueModel: {
		...StockCatalogueModelInitialState,
		// % protected region % [Add any additional state for model Stock Catalogue here] off begin
		// % protected region % [Add any additional state for model Stock Catalogue here] end
	},
	StockControlModel: {
		...StockControlModelInitialState,
		// % protected region % [Add any additional state for model Stock Control here] off begin
		// % protected region % [Add any additional state for model Stock Control here] end
	},
	StockTransactionDetailModel: {
		...StockTransactionDetailModelInitialState,
		// % protected region % [Add any additional state for model Stock Transaction Detail here] off begin
		// % protected region % [Add any additional state for model Stock Transaction Detail here] end
	},
	StockTransactionPerDateModel: {
		...StockTransactionPerDateModelInitialState,
		// % protected region % [Add any additional state for model Stock Transaction Per Date here] off begin
		// % protected region % [Add any additional state for model Stock Transaction Per Date here] end
	},
	StockTransactionPerDateTypeModel: {
		...StockTransactionPerDateTypeModelInitialState,
		// % protected region % [Add any additional state for model Stock Transaction Per Date Type here] off begin
		// % protected region % [Add any additional state for model Stock Transaction Per Date Type here] end
	},
	SupplierModel: {
		...SupplierModelInitialState,
		// % protected region % [Add any additional state for model Supplier here] off begin
		// % protected region % [Add any additional state for model Supplier here] end
	},
	SupplierBankAccountModel: {
		...SupplierBankAccountModelInitialState,
		// % protected region % [Add any additional state for model Supplier Bank Account here] off begin
		// % protected region % [Add any additional state for model Supplier Bank Account here] end
	},
	SupplierContactDetailModel: {
		...SupplierContactDetailModelInitialState,
		// % protected region % [Add any additional state for model Supplier Contact Detail here] off begin
		// % protected region % [Add any additional state for model Supplier Contact Detail here] end
	},
	SupplierProductDetailModel: {
		...SupplierProductDetailModelInitialState,
		// % protected region % [Add any additional state for model Supplier Product Detail here] off begin
		// % protected region % [Add any additional state for model Supplier Product Detail here] end
	},
	SystemAdminUserModel: {
		...SystemAdminUserModelInitialState,
		// % protected region % [Add any additional state for model System Admin User here] off begin
		// % protected region % [Add any additional state for model System Admin User here] end
	},
	TariffDefinitionModel: {
		...TariffDefinitionModelInitialState,
		// % protected region % [Add any additional state for model Tariff Definition here] off begin
		// % protected region % [Add any additional state for model Tariff Definition here] end
	},
	TariffDefinitionOtherComponentModel: {
		...TariffDefinitionOtherComponentModelInitialState,
		// % protected region % [Add any additional state for model Tariff Definition Other Component here] off begin
		// % protected region % [Add any additional state for model Tariff Definition Other Component here] end
	},
	TariffFormulaModel: {
		...TariffFormulaModelInitialState,
		// % protected region % [Add any additional state for model Tariff Formula here] off begin
		// % protected region % [Add any additional state for model Tariff Formula here] end
	},
	TariffPackageModel: {
		...TariffPackageModelInitialState,
		// % protected region % [Add any additional state for model Tariff Package here] off begin
		// % protected region % [Add any additional state for model Tariff Package here] end
	},
	TariffPackageItemModel: {
		...TariffPackageItemModelInitialState,
		// % protected region % [Add any additional state for model Tariff Package Item here] off begin
		// % protected region % [Add any additional state for model Tariff Package Item here] end
	},
	TariffPackageServiceAssignmentModel: {
		...TariffPackageServiceAssignmentModelInitialState,
		// % protected region % [Add any additional state for model Tariff Package Service Assignment here] off begin
		// % protected region % [Add any additional state for model Tariff Package Service Assignment here] end
	},
	TariffSchemaModel: {
		...TariffSchemaModelInitialState,
		// % protected region % [Add any additional state for model Tariff Schema here] off begin
		// % protected region % [Add any additional state for model Tariff Schema here] end
	},
	TaskDashboardModel: {
		...TaskDashboardModelInitialState,
		// % protected region % [Add any additional state for model Task Dashboard here] off begin
		// % protected region % [Add any additional state for model Task Dashboard here] end
	},
	TransactionDetailTypeModel: {
		...TransactionDetailTypeModelInitialState,
		// % protected region % [Add any additional state for model Transaction Detail Type here] off begin
		// % protected region % [Add any additional state for model Transaction Detail Type here] end
	},
	TransactionDetailTypeMappingModel: {
		...TransactionDetailTypeMappingModelInitialState,
		// % protected region % [Add any additional state for model Transaction Detail Type Mapping here] off begin
		// % protected region % [Add any additional state for model Transaction Detail Type Mapping here] end
	},
	TransferOrderModel: {
		...TransferOrderModelInitialState,
		// % protected region % [Add any additional state for model Transfer Order here] off begin
		// % protected region % [Add any additional state for model Transfer Order here] end
	},
	TransferOrderStockDetailModel: {
		...TransferOrderStockDetailModelInitialState,
		// % protected region % [Add any additional state for model Transfer Order Stock Detail here] off begin
		// % protected region % [Add any additional state for model Transfer Order Stock Detail here] end
	},
	UnitOfMeasurementModel: {
		...UnitOfMeasurementModelInitialState,
		// % protected region % [Add any additional state for model Unit Of Measurement here] off begin
		// % protected region % [Add any additional state for model Unit Of Measurement here] end
	},
	UserModel: {
		...UserModelInitialState,
		// % protected region % [Add any additional state for model User here] off begin
		// % protected region % [Add any additional state for model User here] end
	},
	VaccinationOrderModel: {
		...VaccinationOrderModelInitialState,
		// % protected region % [Add any additional state for model Vaccination Order here] off begin
		// % protected region % [Add any additional state for model Vaccination Order here] end
	},
	VaccinationOrderDetailModel: {
		...VaccinationOrderDetailModelInitialState,
		// % protected region % [Add any additional state for model Vaccination Order Detail here] off begin
		// % protected region % [Add any additional state for model Vaccination Order Detail here] end
	},
	VitalSignsModel: {
		...VitalSignsModelInitialState,
		// % protected region % [Add any additional state for model Vital Signs here] off begin
		// % protected region % [Add any additional state for model Vital Signs here] end
	},
	WarehouseModel: {
		...WarehouseModelInitialState,
		// % protected region % [Add any additional state for model Warehouse here] off begin
		// % protected region % [Add any additional state for model Warehouse here] end
	},
	WarehouseInitialStockModel: {
		...WarehouseInitialStockModelInitialState,
		// % protected region % [Add any additional state for model Warehouse Initial Stock  here] off begin
		// % protected region % [Add any additional state for model Warehouse Initial Stock  here] end
	},
	WarehouseInventoryModel: {
		...WarehouseInventoryModelInitialState,
		// % protected region % [Add any additional state for model Warehouse Inventory here] off begin
		// % protected region % [Add any additional state for model Warehouse Inventory here] end
	},
	WarehouseUserModel: {
		...WarehouseUserModelInitialState,
		// % protected region % [Add any additional state for model Warehouse User here] off begin
		// % protected region % [Add any additional state for model Warehouse User here] end
	},
	// % protected region % [Add any additional intitialModelState attributes here] off begin
	// % protected region % [Add any additional intitialModelState attributes here] end
};

/**
 * State containing all everything in the current application. This acts essentially as the central store of the
 * application, including the router and the model state.
 */
export interface AppState {
	router: RouterReducerState<RouterState>;
	models: ModelState;
	// % protected region % [Add any additional app state definition here] off begin
	// % protected region % [Add any additional app state definition here] end
}

/**
 * List of all effects for each model in the application.
 */
export const effects = [
	RoutingEffect,
	AdministrationUserEffect,
	AdministratorEffect,
	AmendmentDetailEffect,
	BpjsAccidentMasterEffect,
	BpjsBedAvailabilityEffect,
	BpjsClaimDataEffect,
	BpjsClaimSubmissionEffect,
	BpjsControlPlanEffect,
	BpjsControlSpecialistEffect,
	BpjsDiagnoseEffect,
	BpjsDiagnosePRBEffect,
	BpjsDismissalConditionEffect,
	BpjsDismissalMappingEffect,
	BpjsDoctorMappingEffect,
	BpjsDoctorScheduleEffect,
	BpjsDrugGenericPRBEffect,
	BpjsFacilityListEffect,
	BpjsFingerPrintEffect,
	BpjsGeneralEffect,
	BpjsHealthFacilityEffect,
	BpjsHospitalizationPlanEffect,
	BpjsINACBGEffect,
	BpjsINACBGClaimEffect,
	BpjsINACBGVariableEffect,
	BpjsJasaRaharjaEffect,
	BpjsJasaRaharjaClaimEffect,
	BpjsListFingerPrintEffect,
	BpjsListTaskEffect,
	BpjsOutsideFacilityReferralEffect,
	BpjsPRBEffect,
	BpjsPRBDetailEffect,
	BpjsPatientReferralEffect,
	BpjsPcareDPHOEffect,
	BpjsPcareKegiatanKelompokEffect,
	BpjsPcareKesadaranEffect,
	BpjsPcarePesertaKegiatanKelompokEffect,
	BpjsPcarePoliEffect,
	BpjsPcareProviderRayonisasiEffect,
	BpjsPcareRegistrationsEffect,
	BpjsProcedureEffect,
	BpjsReferralSpecialistEffect,
	BpjsSEPEffect,
	BpjsSEPINACBGIntegrationEffect,
	BpjsSEPInternalDataEffect,
	BpjsSEPSubmissionEffect,
	BpjsSearchControlLetterEffect,
	BpjsSearchSEPEffect,
	BpjsServiceMappingEffect,
	BpjsSpecialReferralEffect,
	BpjsTotalReferralSEPEffect,
	BpjsTreatmentClassMappingEffect,
	BpjsTreatmentHistoryEffect,
	BpjsTreatmentRoomEffect,
	BpjsUpdateDismissalDateEffect,
	BpjsVisitDataEffect,
	BatchStockBalanceEffect,
	BatchStockBalancePerDateEffect,
	BatchStockTransactionDetailEffect,
	BedFacilityEffect,
	BedReserveEffect,
	BirthHistoryEffect,
	BodyChartExaminationEffect,
	BpjsPcareKunjunganRujukanEffect,
	BpjsPcarePendaftaranEffect,
	BpjsPcareRiwayatKunjunganEffect,
	CashAllocationEffect,
	CashReceiptEffect,
	CashRefundEffect,
	CashierUserEffect,
	CatalogueMedicalEffect,
	CatalogueNonMedicalEffect,
	CatalogueUOMEffect,
	ChartOfAccountEffect,
	ChartOfAccountMappingEffect,
	ClaimUserEffect,
	CoTreatingDoctorEffect,
	CompoundPrescriptionDetailEffect,
	CompoundPrescriptionItemEffect,
	DailyCareCPPTEffect,
	DeliveryMedicalExaminationRecordEffect,
	DeliveryProgressEffect,
	DiagnosesAndProceduresEffect,
	DiagnosisExaminationRecordEffect,
	DiagnosisNandaEffect,
	DiagnosticExaminationResultsEffect,
	DiagnosticStaffExaminationSummaryEffect,
	DiagnosticSupportGeneralConfigurationEffect,
	DiagnosticSupportUserEffect,
	DoctorScheduleEffect,
	DoctorUserEffect,
	EntExaminationEffect,
	EmergencyMedicalExaminationRecordEffect,
	ExaminationGroupEffect,
	ExaminationItemEffect,
	ExaminationItemDetailEffect,
	FacilityHistoryEffect,
	FacilityUserEffect,
	FluidBalanceDetailEffect,
	FormulirKonselingTesHivEffect,
	GoodsReceiveNoteEffect,
	GoodsReceiveNoteBatchEffect,
	GoodsReceiveNoteItemEffect,
	HealthFacilityEffect,
	HemodialysisExaminationEffect,
	HemodialysisMonitoringEffect,
	HospitalBranchInformationEffect,
	HospitalGroupInformationEffect,
	Icd10Effect,
	Icd9CMEffect,
	InformedConsentEffect,
	InpatientMedicalExaminationRecordEffect,
	InsuranceBenefitPlanEffect,
	InsuranceProviderEffect,
	InternalOrderEffect,
	InternalOrderStockDetailEffect,
	IntraoperativeRecordsEffect,
	InventoryAdjusmentBatchEffect,
	InventoryAdjustmentEffect,
	InventoryAdjustmentItemEffect,
	InventoryBatchCorrectionEffect,
	InventoryBatchCorrectionItemEffect,
	InvoiceEffect,
	InvoiceItemEffect,
	InvoiceItemComponentEffect,
	InvoicePaymentInsuranceEffect,
	InvoicePaymentOtherEffect,
	InvoicePaymentSelfPayingEffect,
	InvoiceSummaryEffect,
	JournalEffect,
	LibraryEffect,
	LocationEffect,
	McuPackageEffect,
	McuPackageItemEffect,
	ManagementUserEffect,
	MedicalCertificateDischargeResumeEffect,
	MedicalCertificateBirthEffect,
	MedicalCertificateHospitalizationEffect,
	MedicalCertificateMedicalAttendanceEffect,
	MedicalCertificateMentalHealthEffect,
	MedicalCertificatePhysicalHealthEffect,
	MedicalCertificateRestrictedWorkEffect,
	MedicalCertificateSickLeaveEffect,
	MedicalExaminationRecordEffect,
	MedicalExaminationRecordDischargeSummaryEffect,
	MedicalFeeEffect,
	MedicalFeeItemComponentEffect,
	MedicalRecordInitialChecklistEffect,
	MedicalRecordNextVerificationChecklistEffect,
	MedicalRecordUserEffect,
	MedicalTranscriberUserEffect,
	MedicationAdministeredHistoryEffect,
	MedicationCompoundEffect,
	MedicationHeaderEffect,
	MedicationItemEffect,
	MerchantEffect,
	MerchantSurchargeAndFeeEffect,
	NhisClaimEffect,
	NhisClaimGDRGDetailEffect,
	NhisClaimInvestigationDetailEffect,
	NhisGDRGEffect,
	NhisInvestigationEffect,
	NhisMedicineEffect,
	NhisServiceOutcomeEffect,
	NhisSpecialtyAttendedEffect,
	NhisTypeOfServiceEffect,
	NewbornDetailEffect,
	NumberingSetupEffect,
	NurseUserEffect,
	NurseVitalSignMeasurementEffect,
	ObstetricAndGynecologyHistoryEffect,
	OdontogramExaminationEffect,
	OperatingTheaterMedicalExaminationRecordEffect,
	OphthalmologyExaminationEffect,
	PcareActionExaminationEffect,
	PcareClubProlanisEffect,
	PcareCompoundDrugEffect,
	PcareCompoundDrugItemEffect,
	PcareDiagnosaEffect,
	PcareDokterEffect,
	PcareExaminationEffect,
	PcareMCUEffect,
	PcareNonCompoundDrugEffect,
	PcareReferensiSaranaEffect,
	PcareStatusPulangEffect,
	PcareTindakanEffect,
	PcareUmumEffect,
	PatientCaseHistoryEffect,
	PatientConsentEffect,
	PatientContactInfoEffect,
	PatientDetailEffect,
	PatientDetailAddressEffect,
	PatientEmergencyContactDetailEffect,
	PatientEmploymentDetailEffect,
	PatientGeneralInfoEffect,
	PatientPaymentSelfPayingEffect,
	PatientPaymentBPJSEffect,
	PatientPaymentInsuranceEffect,
	PatientPaymentOthersEffect,
	PatientPersonalInfoEffect,
	PatientSupportingDocumentEffect,
	PatientVisitEffect,
	PatientVisitPatientPaymentInsuranceEffect,
	PatientVisitPatientPaymentOthersEffect,
	PatientVisitPaymentSelfPayingEffect,
	PatientVitalInformationEffect,
	PharmacySetupEffect,
	PharmacyUserEffect,
	PostOperativeDetailsEffect,
	PreoperativeRecordsEffect,
	PrescriptionCompoundEffect,
	PrescriptionHeaderEffect,
	PrescriptionItemEffect,
	PriceComponentEffect,
	PrivilegeEffect,
	ProcessWorkflowEffect,
	PurchaseOrderEffect,
	PurchaseOrderStockDetailEffect,
	PurchaseRequisitionEffect,
	PurchaseRequisitionStockDetailEffect,
	PurchasingUserEffect,
	ReferenceDataEffect,
	ReferenceHeaderEffect,
	RegistrationEffect,
	RegistrationUserEffect,
	RetailPharmacyEffect,
	RetailPharmacyInvoiceEffect,
	RetailPharmacyStockDetailEffect,
	ReturnSupplierEffect,
	ReturnSupplierStockDetailEffect,
	RoleEffect,
	RoomFacilityEffect,
	RoomTransferEffect,
	SepEffect,
	SampleCollectionInformationEffect,
	SampleCollectionItemsEffect,
	SatuSehatConfigurationEffect,
	ServiceEffect,
	ServiceFacilityCategoryEffect,
	ServiceItemEffect,
	ServiceItemAssignmentEffect,
	StaffEffect,
	StockCatalogueEffect,
	StockControlEffect,
	StockTransactionDetailEffect,
	StockTransactionPerDateEffect,
	StockTransactionPerDateTypeEffect,
	SupplierEffect,
	SupplierBankAccountEffect,
	SupplierContactDetailEffect,
	SupplierProductDetailEffect,
	SystemAdminUserEffect,
	TariffDefinitionEffect,
	TariffDefinitionOtherComponentEffect,
	TariffFormulaEffect,
	TariffPackageEffect,
	TariffPackageItemEffect,
	TariffPackageServiceAssignmentEffect,
	TariffSchemaEffect,
	TaskDashboardEffect,
	TransactionDetailTypeEffect,
	TransactionDetailTypeMappingEffect,
	TransferOrderEffect,
	TransferOrderStockDetailEffect,
	UnitOfMeasurementEffect,
	UserEffect,
	VaccinationOrderEffect,
	VaccinationOrderDetailEffect,
	VitalSignsEffect,
	WarehouseEffect,
	WarehouseInitialStockEffect,
	WarehouseInventoryEffect,
	WarehouseUserEffect,
	// % protected region % [Add any additional effects here] off begin
	// % protected region % [Add any additional effects here] end
];

/**
 * Define the state for the Angular router. Since the original one contains many unused data which can be removed
 * otherwise, this interface is used with the custom serialiser below to provide a simpler router state.
 */
export interface RouterState {
	url: string;
	urls: string[];
	params: Params;
	queryParams: Params;
	data: any;
	// % protected region % [Add any additional properties for RouterState here] off begin
	// % protected region % [Add any additional properties for RouterState here] end
}

/**
 * Define the initial state for router when first bootstrapped.
 */
export const initialRouterState: RouterReducerState<RouterState> = {
	state: {
		url: '/',
		urls: [],
		params: [],
		queryParams: [],
		data: {},
		// % protected region % [Add any additional initial state for RouterState here] off begin
		// % protected region % [Add any additional initial state for RouterState here] end
	},
	navigationId: -1
};

/**
 * Custom serializer used for parsing the original router state provided by Angular.
 */
export class CustomSerializer implements RouterStateSerializer<RouterState> {
	serialize(routerState: RouterStateSnapshot): RouterState {
		let route = routerState.root;
		const urls: string[] = [];

		while (route.firstChild) {
			route.firstChild.url.forEach(u => urls.push(u.path));
			route = route.firstChild;
		}

		const {
			url,
			root: {
				queryParams,
				data,
				// % protected region % [Add any additional extraction of routerState properties here] off begin
				// % protected region % [Add any additional extraction of routerState properties here] end
			}
		} = routerState;
		const {params} = route;

		// Only return an object including the URL, params and query params
		// instead of the entire snapshot
		return {
			url,
			urls,
			params,
			queryParams,
			data,
			// % protected region % [Add any additional properties to be returned here] off begin
			// % protected region % [Add any additional properties to be returned here] end
		};
	}
}

// % protected region % [Add any additional stuffs here] off begin
// % protected region % [Add any additional stuffs here] end
