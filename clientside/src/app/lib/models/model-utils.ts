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

import { OrderBy, QueryOperation, QueryParams, Where } from '../services/http/interfaces';
import { AbstractModel, Group, ModelProperty, ModelRelation } from './abstract.model';
import * as _ from 'lodash';
import { FormControl, FormGroup } from '@angular/forms';
import { Action } from '@ngrx/store';
import {v4 as uuidv4} from 'uuid';

import { AdministrationUserAction, AdministrationUserModelActionTypes } from 'src/app/models/administrationUser/administration_user.model.action';
import { getAdministrationUserCollectionModels } from 'src/app/models/administrationUser/administration_user.model.selector';
import { AdministratorAction, AdministratorModelActionTypes } from 'src/app/models/administrator/administrator.model.action';
import { getAdministratorCollectionModels } from 'src/app/models/administrator/administrator.model.selector';
import { AmendmentDetailAction, AmendmentDetailModelActionTypes } from 'src/app/models/amendmentDetail/amendment_detail.model.action';
import { getAmendmentDetailCollectionModels } from 'src/app/models/amendmentDetail/amendment_detail.model.selector';
import { BpjsAccidentMasterAction, BpjsAccidentMasterModelActionTypes } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.action';
import { getBpjsAccidentMasterCollectionModels } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.selector';
import { BpjsBedAvailabilityAction, BpjsBedAvailabilityModelActionTypes } from 'src/app/models/bpjsBedAvailability/bpjs_bed_availability.model.action';
import { getBpjsBedAvailabilityCollectionModels } from 'src/app/models/bpjsBedAvailability/bpjs_bed_availability.model.selector';
import { BpjsClaimDataAction, BpjsClaimDataModelActionTypes } from 'src/app/models/bpjsClaimData/bpjs_claim_data.model.action';
import { getBpjsClaimDataCollectionModels } from 'src/app/models/bpjsClaimData/bpjs_claim_data.model.selector';
import { BpjsClaimSubmissionAction, BpjsClaimSubmissionModelActionTypes } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.action';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsControlPlanAction, BpjsControlPlanModelActionTypes } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.action';
import { getBpjsControlPlanCollectionModels } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.selector';
import { BpjsControlSpecialistAction, BpjsControlSpecialistModelActionTypes } from 'src/app/models/bpjsControlSpecialist/bpjs_control_specialist.model.action';
import { getBpjsControlSpecialistCollectionModels } from 'src/app/models/bpjsControlSpecialist/bpjs_control_specialist.model.selector';
import { BpjsDiagnoseAction, BpjsDiagnoseModelActionTypes } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.action';
import { getBpjsDiagnoseCollectionModels } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { BpjsDiagnosePRBAction, BpjsDiagnosePRBModelActionTypes } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.action';
import { getBpjsDiagnosePRBCollectionModels } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.selector';
import { BpjsDismissalConditionAction, BpjsDismissalConditionModelActionTypes } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model.action';
import { getBpjsDismissalConditionCollectionModels } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model.selector';
import { BpjsDismissalMappingAction, BpjsDismissalMappingModelActionTypes } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model.action';
import { getBpjsDismissalMappingCollectionModels } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model.selector';
import { BpjsDoctorMappingAction, BpjsDoctorMappingModelActionTypes } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.action';
import { getBpjsDoctorMappingCollectionModels } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { BpjsDoctorScheduleAction, BpjsDoctorScheduleModelActionTypes } from 'src/app/models/bpjsDoctorSchedule/bpjs_doctor_schedule.model.action';
import { getBpjsDoctorScheduleCollectionModels } from 'src/app/models/bpjsDoctorSchedule/bpjs_doctor_schedule.model.selector';
import { BpjsDrugGenericPRBAction, BpjsDrugGenericPRBModelActionTypes } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.action';
import { getBpjsDrugGenericPRBCollectionModels } from 'src/app/models/bpjsDrugGenericPRB/bpjs_drug_generic_prb.model.selector';
import { BpjsFacilityListAction, BpjsFacilityListModelActionTypes } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model.action';
import { getBpjsFacilityListCollectionModels } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model.selector';
import { BpjsFingerPrintAction, BpjsFingerPrintModelActionTypes } from 'src/app/models/bpjsFingerPrint/bpjs_finger_print.model.action';
import { getBpjsFingerPrintCollectionModels } from 'src/app/models/bpjsFingerPrint/bpjs_finger_print.model.selector';
import { BpjsGeneralAction, BpjsGeneralModelActionTypes } from 'src/app/models/bpjsGeneral/bpjs_general.model.action';
import { getBpjsGeneralCollectionModels } from 'src/app/models/bpjsGeneral/bpjs_general.model.selector';
import { BpjsHealthFacilityAction, BpjsHealthFacilityModelActionTypes } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.action';
import { getBpjsHealthFacilityCollectionModels } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { BpjsHospitalizationPlanAction, BpjsHospitalizationPlanModelActionTypes } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.action';
import { getBpjsHospitalizationPlanCollectionModels } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { BpjsINACBGAction, BpjsINACBGModelActionTypes } from 'src/app/models/bpjsINACBG/bpjs_inacbg.model.action';
import { getBpjsINACBGCollectionModels } from 'src/app/models/bpjsINACBG/bpjs_inacbg.model.selector';
import { BpjsINACBGClaimAction, BpjsINACBGClaimModelActionTypes } from 'src/app/models/bpjsINACBGClaim/bpjs_inacbg_claim.model.action';
import { getBpjsINACBGClaimCollectionModels } from 'src/app/models/bpjsINACBGClaim/bpjs_inacbg_claim.model.selector';
import { BpjsINACBGVariableAction, BpjsINACBGVariableModelActionTypes } from 'src/app/models/bpjsINACBGVariable/bpjs_inacbg_variable.model.action';
import { getBpjsINACBGVariableCollectionModels } from 'src/app/models/bpjsINACBGVariable/bpjs_inacbg_variable.model.selector';
import { BpjsJasaRaharjaAction, BpjsJasaRaharjaModelActionTypes } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.action';
import { getBpjsJasaRaharjaCollectionModels } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import { BpjsJasaRaharjaClaimAction, BpjsJasaRaharjaClaimModelActionTypes } from 'src/app/models/bpjsJasaRaharjaClaim/bpjs_jasa_raharja_claim.model.action';
import { getBpjsJasaRaharjaClaimCollectionModels } from 'src/app/models/bpjsJasaRaharjaClaim/bpjs_jasa_raharja_claim.model.selector';
import { BpjsListFingerPrintAction, BpjsListFingerPrintModelActionTypes } from 'src/app/models/bpjsListFingerPrint/bpjs_list_finger_print.model.action';
import { getBpjsListFingerPrintCollectionModels } from 'src/app/models/bpjsListFingerPrint/bpjs_list_finger_print.model.selector';
import { BpjsListTaskAction, BpjsListTaskModelActionTypes } from 'src/app/models/bpjsListTask/bpjs_list_task.model.action';
import { getBpjsListTaskCollectionModels } from 'src/app/models/bpjsListTask/bpjs_list_task.model.selector';
import { BpjsOutsideFacilityReferralAction, BpjsOutsideFacilityReferralModelActionTypes } from 'src/app/models/bpjsOutsideFacilityReferral/bpjs_outside_facility_referral.model.action';
import { getBpjsOutsideFacilityReferralCollectionModels } from 'src/app/models/bpjsOutsideFacilityReferral/bpjs_outside_facility_referral.model.selector';
import { BpjsPRBAction, BpjsPRBModelActionTypes } from 'src/app/models/bpjsPRB/bpjs_prb.model.action';
import { getBpjsPRBCollectionModels } from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { BpjsPRBDetailAction, BpjsPRBDetailModelActionTypes } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.action';
import { getBpjsPRBDetailCollectionModels } from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import { BpjsPatientReferralAction, BpjsPatientReferralModelActionTypes } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.action';
import { getBpjsPatientReferralCollectionModels } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { BpjsPcareDPHOAction, BpjsPcareDPHOModelActionTypes } from 'src/app/models/bpjsPcareDPHO/bpjs_pcare_dpho.model.action';
import { getBpjsPcareDPHOCollectionModels } from 'src/app/models/bpjsPcareDPHO/bpjs_pcare_dpho.model.selector';
import { BpjsPcareKegiatanKelompokAction, BpjsPcareKegiatanKelompokModelActionTypes } from 'src/app/models/bpjsPcareKegiatanKelompok/bpjs_pcare_kegiatan_kelompok.model.action';
import { getBpjsPcareKegiatanKelompokCollectionModels } from 'src/app/models/bpjsPcareKegiatanKelompok/bpjs_pcare_kegiatan_kelompok.model.selector';
import { BpjsPcareKesadaranAction, BpjsPcareKesadaranModelActionTypes } from 'src/app/models/bpjsPcareKesadaran/bpjs_pcare_kesadaran.model.action';
import { getBpjsPcareKesadaranCollectionModels } from 'src/app/models/bpjsPcareKesadaran/bpjs_pcare_kesadaran.model.selector';
import { BpjsPcarePesertaKegiatanKelompokAction, BpjsPcarePesertaKegiatanKelompokModelActionTypes } from 'src/app/models/bpjsPcarePesertaKegiatanKelompok/bpjs_pcare_peserta_kegiatan_kelompok.model.action';
import { getBpjsPcarePesertaKegiatanKelompokCollectionModels } from 'src/app/models/bpjsPcarePesertaKegiatanKelompok/bpjs_pcare_peserta_kegiatan_kelompok.model.selector';
import { BpjsPcarePoliAction, BpjsPcarePoliModelActionTypes } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model.action';
import { getBpjsPcarePoliCollectionModels } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model.selector';
import { BpjsPcareProviderRayonisasiAction, BpjsPcareProviderRayonisasiModelActionTypes } from 'src/app/models/bpjsPcareProviderRayonisasi/bpjs_pcare_provider_rayonisasi.model.action';
import { getBpjsPcareProviderRayonisasiCollectionModels } from 'src/app/models/bpjsPcareProviderRayonisasi/bpjs_pcare_provider_rayonisasi.model.selector';
import { BpjsPcareRegistrationsAction, BpjsPcareRegistrationsModelActionTypes } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.action';
import { getBpjsPcareRegistrationsCollectionModels } from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import { BpjsProcedureAction, BpjsProcedureModelActionTypes } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.action';
import { getBpjsProcedureCollectionModels } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import { BpjsReferralSpecialistAction, BpjsReferralSpecialistModelActionTypes } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model.action';
import { getBpjsReferralSpecialistCollectionModels } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model.selector';
import { BpjsSEPAction, BpjsSEPModelActionTypes } from 'src/app/models/bpjsSEP/bpjs_sep.model.action';
import { getBpjsSEPCollectionModels } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { BpjsSEPINACBGIntegrationAction, BpjsSEPINACBGIntegrationModelActionTypes } from 'src/app/models/bpjsSEPINACBGIntegration/bpjs_sep_inacbg_integration.model.action';
import { getBpjsSEPINACBGIntegrationCollectionModels } from 'src/app/models/bpjsSEPINACBGIntegration/bpjs_sep_inacbg_integration.model.selector';
import { BpjsSEPInternalDataAction, BpjsSEPInternalDataModelActionTypes } from 'src/app/models/bpjsSEPInternalData/bpjs_sep_internal_data.model.action';
import { getBpjsSEPInternalDataCollectionModels } from 'src/app/models/bpjsSEPInternalData/bpjs_sep_internal_data.model.selector';
import { BpjsSEPSubmissionAction, BpjsSEPSubmissionModelActionTypes } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.action';
import { getBpjsSEPSubmissionCollectionModels } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.selector';
import { BpjsSearchControlLetterAction, BpjsSearchControlLetterModelActionTypes } from 'src/app/models/bpjsSearchControlLetter/bpjs_search_control_letter.model.action';
import { getBpjsSearchControlLetterCollectionModels } from 'src/app/models/bpjsSearchControlLetter/bpjs_search_control_letter.model.selector';
import { BpjsSearchSEPAction, BpjsSearchSEPModelActionTypes } from 'src/app/models/bpjsSearchSEP/bpjs_search_sep.model.action';
import { getBpjsSearchSEPCollectionModels } from 'src/app/models/bpjsSearchSEP/bpjs_search_sep.model.selector';
import { BpjsServiceMappingAction, BpjsServiceMappingModelActionTypes } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.action';
import { getBpjsServiceMappingCollectionModels } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { BpjsSpecialReferralAction, BpjsSpecialReferralModelActionTypes } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.action';
import { getBpjsSpecialReferralCollectionModels } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.selector';
import { BpjsTotalReferralSEPAction, BpjsTotalReferralSEPModelActionTypes } from 'src/app/models/bpjsTotalReferralSEP/bpjs_total_referral_sep.model.action';
import { getBpjsTotalReferralSEPCollectionModels } from 'src/app/models/bpjsTotalReferralSEP/bpjs_total_referral_sep.model.selector';
import { BpjsTreatmentClassMappingAction, BpjsTreatmentClassMappingModelActionTypes } from 'src/app/models/bpjsTreatmentClassMapping/bpjs_treatment_class_mapping.model.action';
import { getBpjsTreatmentClassMappingCollectionModels } from 'src/app/models/bpjsTreatmentClassMapping/bpjs_treatment_class_mapping.model.selector';
import { BpjsTreatmentHistoryAction, BpjsTreatmentHistoryModelActionTypes } from 'src/app/models/bpjsTreatmentHistory/bpjs_treatment_history.model.action';
import { getBpjsTreatmentHistoryCollectionModels } from 'src/app/models/bpjsTreatmentHistory/bpjs_treatment_history.model.selector';
import { BpjsTreatmentRoomAction, BpjsTreatmentRoomModelActionTypes } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.action';
import { getBpjsTreatmentRoomCollectionModels } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.selector';
import { BpjsUpdateDismissalDateAction, BpjsUpdateDismissalDateModelActionTypes } from 'src/app/models/bpjsUpdateDismissalDate/bpjs_update_dismissal_date.model.action';
import { getBpjsUpdateDismissalDateCollectionModels } from 'src/app/models/bpjsUpdateDismissalDate/bpjs_update_dismissal_date.model.selector';
import { BpjsVisitDataAction, BpjsVisitDataModelActionTypes } from 'src/app/models/bpjsVisitData/bpjs_visit_data.model.action';
import { getBpjsVisitDataCollectionModels } from 'src/app/models/bpjsVisitData/bpjs_visit_data.model.selector';
import { BatchStockBalanceAction, BatchStockBalanceModelActionTypes } from 'src/app/models/batchStockBalance/batch_stock_balance.model.action';
import { getBatchStockBalanceCollectionModels } from 'src/app/models/batchStockBalance/batch_stock_balance.model.selector';
import { BatchStockBalancePerDateAction, BatchStockBalancePerDateModelActionTypes } from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model.action';
import { getBatchStockBalancePerDateCollectionModels } from 'src/app/models/batchStockBalancePerDate/batch_stock_balance_per_date.model.selector';
import { BatchStockTransactionDetailAction, BatchStockTransactionDetailModelActionTypes } from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model.action';
import { getBatchStockTransactionDetailCollectionModels } from 'src/app/models/batchStockTransactionDetail/batch_stock_transaction_detail.model.selector';
import { BedFacilityAction, BedFacilityModelActionTypes } from 'src/app/models/bedFacility/bed_facility.model.action';
import { getBedFacilityCollectionModels } from 'src/app/models/bedFacility/bed_facility.model.selector';
import { BedReserveAction, BedReserveModelActionTypes } from 'src/app/models/bedReserve/bed_reserve.model.action';
import { getBedReserveCollectionModels } from 'src/app/models/bedReserve/bed_reserve.model.selector';
import { BirthHistoryAction, BirthHistoryModelActionTypes } from 'src/app/models/birthHistory/birth_history.model.action';
import { getBirthHistoryCollectionModels } from 'src/app/models/birthHistory/birth_history.model.selector';
import { BodyChartExaminationAction, BodyChartExaminationModelActionTypes } from 'src/app/models/bodyChartExamination/body_chart_examination.model.action';
import { getBodyChartExaminationCollectionModels } from 'src/app/models/bodyChartExamination/body_chart_examination.model.selector';
import { BpjsPcareKunjunganRujukanAction, BpjsPcareKunjunganRujukanModelActionTypes } from 'src/app/models/bpjsPcareKunjunganRujukan/bpjs_pcare_kunjungan_rujukan.model.action';
import { getBpjsPcareKunjunganRujukanCollectionModels } from 'src/app/models/bpjsPcareKunjunganRujukan/bpjs_pcare_kunjungan_rujukan.model.selector';
import { BpjsPcarePendaftaranAction, BpjsPcarePendaftaranModelActionTypes } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.action';
import { getBpjsPcarePendaftaranCollectionModels } from 'src/app/models/bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model.selector';
import { BpjsPcareRiwayatKunjunganAction, BpjsPcareRiwayatKunjunganModelActionTypes } from 'src/app/models/bpjsPcareRiwayatKunjungan/bpjs_pcare_riwayat_kunjungan.model.action';
import { getBpjsPcareRiwayatKunjunganCollectionModels } from 'src/app/models/bpjsPcareRiwayatKunjungan/bpjs_pcare_riwayat_kunjungan.model.selector';
import { CashAllocationAction, CashAllocationModelActionTypes } from 'src/app/models/cashAllocation/cash_allocation.model.action';
import { getCashAllocationCollectionModels } from 'src/app/models/cashAllocation/cash_allocation.model.selector';
import { CashReceiptAction, CashReceiptModelActionTypes } from 'src/app/models/cashReceipt/cash_receipt.model.action';
import { getCashReceiptCollectionModels } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { CashRefundAction, CashRefundModelActionTypes } from 'src/app/models/cashRefund/cash_refund.model.action';
import { getCashRefundCollectionModels } from 'src/app/models/cashRefund/cash_refund.model.selector';
import { CashierUserAction, CashierUserModelActionTypes } from 'src/app/models/cashierUser/cashier_user.model.action';
import { getCashierUserCollectionModels } from 'src/app/models/cashierUser/cashier_user.model.selector';
import { CatalogueMedicalAction, CatalogueMedicalModelActionTypes } from 'src/app/models/catalogueMedical/catalogue_medical.model.action';
import { getCatalogueMedicalCollectionModels } from 'src/app/models/catalogueMedical/catalogue_medical.model.selector';
import { CatalogueNonMedicalAction, CatalogueNonMedicalModelActionTypes } from 'src/app/models/catalogueNonMedical/catalogue_non_medical.model.action';
import { getCatalogueNonMedicalCollectionModels } from 'src/app/models/catalogueNonMedical/catalogue_non_medical.model.selector';
import { CatalogueUOMAction, CatalogueUOMModelActionTypes } from 'src/app/models/catalogueUOM/catalogue_uom.model.action';
import { getCatalogueUOMCollectionModels } from 'src/app/models/catalogueUOM/catalogue_uom.model.selector';
import { ChartOfAccountAction, ChartOfAccountModelActionTypes } from 'src/app/models/chartOfAccount/chart_of_account.model.action';
import { getChartOfAccountCollectionModels } from 'src/app/models/chartOfAccount/chart_of_account.model.selector';
import { ChartOfAccountMappingAction, ChartOfAccountMappingModelActionTypes } from 'src/app/models/chartOfAccountMapping/chart_of_account_mapping.model.action';
import { getChartOfAccountMappingCollectionModels } from 'src/app/models/chartOfAccountMapping/chart_of_account_mapping.model.selector';
import { ClaimUserAction, ClaimUserModelActionTypes } from 'src/app/models/claimUser/claim_user.model.action';
import { getClaimUserCollectionModels } from 'src/app/models/claimUser/claim_user.model.selector';
import { CoTreatingDoctorAction, CoTreatingDoctorModelActionTypes } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.action';
import { getCoTreatingDoctorCollectionModels } from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import { CompoundPrescriptionDetailAction, CompoundPrescriptionDetailModelActionTypes } from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model.action';
import { getCompoundPrescriptionDetailCollectionModels } from 'src/app/models/compoundPrescriptionDetail/compound_prescription_detail.model.selector';
import { CompoundPrescriptionItemAction, CompoundPrescriptionItemModelActionTypes } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model.action';
import { getCompoundPrescriptionItemCollectionModels } from 'src/app/models/compoundPrescriptionItem/compound_prescription_item.model.selector';
import { DailyCareCPPTAction, DailyCareCPPTModelActionTypes } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.action';
import { getDailyCareCPPTCollectionModels } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
import { DeliveryMedicalExaminationRecordAction, DeliveryMedicalExaminationRecordModelActionTypes } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.action';
import { getDeliveryMedicalExaminationRecordCollectionModels } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.selector';
import { DeliveryProgressAction, DeliveryProgressModelActionTypes } from 'src/app/models/deliveryProgress/delivery_progress.model.action';
import { getDeliveryProgressCollectionModels } from 'src/app/models/deliveryProgress/delivery_progress.model.selector';
import { DiagnosesAndProceduresAction, DiagnosesAndProceduresModelActionTypes } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.action';
import { getDiagnosesAndProceduresCollectionModels } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { DiagnosisExaminationRecordAction, DiagnosisExaminationRecordModelActionTypes } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.action';
import { getDiagnosisExaminationRecordCollectionModels } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.selector';
import { DiagnosisNandaAction, DiagnosisNandaModelActionTypes } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.action';
import { getDiagnosisNandaCollectionModels } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import { DiagnosticExaminationResultsAction, DiagnosticExaminationResultsModelActionTypes } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.action';
import { getDiagnosticExaminationResultsCollectionModels } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import { DiagnosticStaffExaminationSummaryAction, DiagnosticStaffExaminationSummaryModelActionTypes } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.action';
import { getDiagnosticStaffExaminationSummaryCollectionModels } from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.selector';
import { DiagnosticSupportGeneralConfigurationAction, DiagnosticSupportGeneralConfigurationModelActionTypes } from 'src/app/models/diagnosticSupportGeneralConfiguration/diagnostic_support_general_configuration.model.action';
import { getDiagnosticSupportGeneralConfigurationCollectionModels } from 'src/app/models/diagnosticSupportGeneralConfiguration/diagnostic_support_general_configuration.model.selector';
import { DiagnosticSupportUserAction, DiagnosticSupportUserModelActionTypes } from 'src/app/models/diagnosticSupportUser/diagnostic_support_user.model.action';
import { getDiagnosticSupportUserCollectionModels } from 'src/app/models/diagnosticSupportUser/diagnostic_support_user.model.selector';
import { DoctorScheduleAction, DoctorScheduleModelActionTypes } from 'src/app/models/doctorSchedule/doctor_schedule.model.action';
import { getDoctorScheduleCollectionModels } from 'src/app/models/doctorSchedule/doctor_schedule.model.selector';
import { DoctorUserAction, DoctorUserModelActionTypes } from 'src/app/models/doctorUser/doctor_user.model.action';
import { getDoctorUserCollectionModels } from 'src/app/models/doctorUser/doctor_user.model.selector';
import { EntExaminationAction, EntExaminationModelActionTypes } from 'src/app/models/entExamination/ent_examination.model.action';
import { getEntExaminationCollectionModels } from 'src/app/models/entExamination/ent_examination.model.selector';
import { EmergencyMedicalExaminationRecordAction, EmergencyMedicalExaminationRecordModelActionTypes } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.action';
import { getEmergencyMedicalExaminationRecordCollectionModels } from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.selector';
import { ExaminationGroupAction, ExaminationGroupModelActionTypes } from 'src/app/models/examinationGroup/examination_group.model.action';
import { getExaminationGroupCollectionModels } from 'src/app/models/examinationGroup/examination_group.model.selector';
import { ExaminationItemAction, ExaminationItemModelActionTypes } from 'src/app/models/examinationItem/examination_item.model.action';
import { getExaminationItemCollectionModels } from 'src/app/models/examinationItem/examination_item.model.selector';
import { ExaminationItemDetailAction, ExaminationItemDetailModelActionTypes } from 'src/app/models/examinationItemDetail/examination_item_detail.model.action';
import { getExaminationItemDetailCollectionModels } from 'src/app/models/examinationItemDetail/examination_item_detail.model.selector';
import { FacilityHistoryAction, FacilityHistoryModelActionTypes } from 'src/app/models/facilityHistory/facility_history.model.action';
import { getFacilityHistoryCollectionModels } from 'src/app/models/facilityHistory/facility_history.model.selector';
import { FacilityUserAction, FacilityUserModelActionTypes } from 'src/app/models/facilityUser/facility_user.model.action';
import { getFacilityUserCollectionModels } from 'src/app/models/facilityUser/facility_user.model.selector';
import { FluidBalanceDetailAction, FluidBalanceDetailModelActionTypes } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.action';
import { getFluidBalanceDetailCollectionModels } from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import { FormulirKonselingTesHivAction, FormulirKonselingTesHivModelActionTypes } from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.action';
import { getFormulirKonselingTesHivCollectionModels } from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.selector';
import { GoodsReceiveNoteAction, GoodsReceiveNoteModelActionTypes } from 'src/app/models/goodsReceiveNote/goods_receive_note.model.action';
import { getGoodsReceiveNoteCollectionModels } from 'src/app/models/goodsReceiveNote/goods_receive_note.model.selector';
import { GoodsReceiveNoteBatchAction, GoodsReceiveNoteBatchModelActionTypes } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.action';
import { getGoodsReceiveNoteBatchCollectionModels } from 'src/app/models/goodsReceiveNoteBatch/goods_receive_note_batch.model.selector';
import { GoodsReceiveNoteItemAction, GoodsReceiveNoteItemModelActionTypes } from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model.action';
import { getGoodsReceiveNoteItemCollectionModels } from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model.selector';
import { HealthFacilityAction, HealthFacilityModelActionTypes } from 'src/app/models/healthFacility/health_facility.model.action';
import { getHealthFacilityCollectionModels } from 'src/app/models/healthFacility/health_facility.model.selector';
import { HemodialysisExaminationAction, HemodialysisExaminationModelActionTypes } from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model.action';
import { getHemodialysisExaminationCollectionModels } from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model.selector';
import { HemodialysisMonitoringAction, HemodialysisMonitoringModelActionTypes } from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model.action';
import { getHemodialysisMonitoringCollectionModels } from 'src/app/models/hemodialysisMonitoring/hemodialysis_monitoring.model.selector';
import { HospitalBranchInformationAction, HospitalBranchInformationModelActionTypes } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model.action';
import { getHospitalBranchInformationCollectionModels } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model.selector';
import { HospitalGroupInformationAction, HospitalGroupInformationModelActionTypes } from 'src/app/models/hospitalGroupInformation/hospital_group_information.model.action';
import { getHospitalGroupInformationCollectionModels } from 'src/app/models/hospitalGroupInformation/hospital_group_information.model.selector';
import { Icd10Action, Icd10ModelActionTypes } from 'src/app/models/icd10/icd_10.model.action';
import { getIcd10CollectionModels } from 'src/app/models/icd10/icd_10.model.selector';
import { Icd9CMAction, Icd9CMModelActionTypes } from 'src/app/models/icd9CM/icd_9_cm.model.action';
import { getIcd9CMCollectionModels } from 'src/app/models/icd9CM/icd_9_cm.model.selector';
import { InformedConsentAction, InformedConsentModelActionTypes } from 'src/app/models/informedConsent/informed_consent.model.action';
import { getInformedConsentCollectionModels } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { InpatientMedicalExaminationRecordAction, InpatientMedicalExaminationRecordModelActionTypes } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.action';
import { getInpatientMedicalExaminationRecordCollectionModels } from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import { InsuranceBenefitPlanAction, InsuranceBenefitPlanModelActionTypes } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model.action';
import { getInsuranceBenefitPlanCollectionModels } from 'src/app/models/insuranceBenefitPlan/insurance_benefit_plan.model.selector';
import { InsuranceProviderAction, InsuranceProviderModelActionTypes } from 'src/app/models/insuranceProvider/insurance_provider.model.action';
import { getInsuranceProviderCollectionModels } from 'src/app/models/insuranceProvider/insurance_provider.model.selector';
import { InternalOrderAction, InternalOrderModelActionTypes } from 'src/app/models/internalOrder/internal_order.model.action';
import { getInternalOrderCollectionModels } from 'src/app/models/internalOrder/internal_order.model.selector';
import { InternalOrderStockDetailAction, InternalOrderStockDetailModelActionTypes } from 'src/app/models/internalOrderStockDetail/internal_order_stock_detail.model.action';
import { getInternalOrderStockDetailCollectionModels } from 'src/app/models/internalOrderStockDetail/internal_order_stock_detail.model.selector';
import { IntraoperativeRecordsAction, IntraoperativeRecordsModelActionTypes } from 'src/app/models/intraoperativeRecords/intraoperative_records.model.action';
import { getIntraoperativeRecordsCollectionModels } from 'src/app/models/intraoperativeRecords/intraoperative_records.model.selector';
import { InventoryAdjusmentBatchAction, InventoryAdjusmentBatchModelActionTypes } from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model.action';
import { getInventoryAdjusmentBatchCollectionModels } from 'src/app/models/inventoryAdjusmentBatch/inventory_adjusment_batch.model.selector';
import { InventoryAdjustmentAction, InventoryAdjustmentModelActionTypes } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.action';
import { getInventoryAdjustmentCollectionModels } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.selector';
import { InventoryAdjustmentItemAction, InventoryAdjustmentItemModelActionTypes } from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model.action';
import { getInventoryAdjustmentItemCollectionModels } from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model.selector';
import { InventoryBatchCorrectionAction, InventoryBatchCorrectionModelActionTypes } from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model.action';
import { getInventoryBatchCorrectionCollectionModels } from 'src/app/models/inventoryBatchCorrection/inventory_batch_correction.model.selector';
import { InventoryBatchCorrectionItemAction, InventoryBatchCorrectionItemModelActionTypes } from 'src/app/models/inventoryBatchCorrectionItem/inventory_batch_correction_item.model.action';
import { getInventoryBatchCorrectionItemCollectionModels } from 'src/app/models/inventoryBatchCorrectionItem/inventory_batch_correction_item.model.selector';
import { InvoiceAction, InvoiceModelActionTypes } from 'src/app/models/invoice/invoice.model.action';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceItemAction, InvoiceItemModelActionTypes } from 'src/app/models/invoiceItem/invoice_item.model.action';
import { getInvoiceItemCollectionModels } from 'src/app/models/invoiceItem/invoice_item.model.selector';
import { InvoiceItemComponentAction, InvoiceItemComponentModelActionTypes } from 'src/app/models/invoiceItemComponent/invoice_item_component.model.action';
import { getInvoiceItemComponentCollectionModels } from 'src/app/models/invoiceItemComponent/invoice_item_component.model.selector';
import { InvoicePaymentInsuranceAction, InvoicePaymentInsuranceModelActionTypes } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.action';
import { getInvoicePaymentInsuranceCollectionModels } from 'src/app/models/invoicePaymentInsurance/invoice_payment_insurance.model.selector';
import { InvoicePaymentOtherAction, InvoicePaymentOtherModelActionTypes } from 'src/app/models/invoicePaymentOther/invoice_payment_other.model.action';
import { getInvoicePaymentOtherCollectionModels } from 'src/app/models/invoicePaymentOther/invoice_payment_other.model.selector';
import { InvoicePaymentSelfPayingAction, InvoicePaymentSelfPayingModelActionTypes } from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model.action';
import { getInvoicePaymentSelfPayingCollectionModels } from 'src/app/models/invoicePaymentSelfPaying/invoice_payment_self_paying.model.selector';
import { InvoiceSummaryAction, InvoiceSummaryModelActionTypes } from 'src/app/models/invoiceSummary/invoice_summary.model.action';
import { getInvoiceSummaryCollectionModels } from 'src/app/models/invoiceSummary/invoice_summary.model.selector';
import { JournalAction, JournalModelActionTypes } from 'src/app/models/journal/journal.model.action';
import { getJournalCollectionModels } from 'src/app/models/journal/journal.model.selector';
import { LibraryAction, LibraryModelActionTypes } from 'src/app/models/library/library.model.action';
import { getLibraryCollectionModels } from 'src/app/models/library/library.model.selector';
import { LocationAction, LocationModelActionTypes } from 'src/app/models/location/location.model.action';
import { getLocationCollectionModels } from 'src/app/models/location/location.model.selector';
import { McuPackageAction, McuPackageModelActionTypes } from 'src/app/models/mcuPackage/mcu_package.model.action';
import { getMcuPackageCollectionModels } from 'src/app/models/mcuPackage/mcu_package.model.selector';
import { McuPackageItemAction, McuPackageItemModelActionTypes } from 'src/app/models/mcuPackageItem/mcu_package_item.model.action';
import { getMcuPackageItemCollectionModels } from 'src/app/models/mcuPackageItem/mcu_package_item.model.selector';
import { ManagementUserAction, ManagementUserModelActionTypes } from 'src/app/models/managementUser/management_user.model.action';
import { getManagementUserCollectionModels } from 'src/app/models/managementUser/management_user.model.selector';
import { MedicalCertificateDischargeResumeAction, MedicalCertificateDischargeResumeModelActionTypes } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.action';
import { getMedicalCertificateDischargeResumeCollectionModels } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.selector';
import { MedicalCertificateBirthAction, MedicalCertificateBirthModelActionTypes } from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model.action';
import { getMedicalCertificateBirthCollectionModels } from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model.selector';
import { MedicalCertificateHospitalizationAction, MedicalCertificateHospitalizationModelActionTypes } from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model.action';
import { getMedicalCertificateHospitalizationCollectionModels } from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model.selector';
import { MedicalCertificateMedicalAttendanceAction, MedicalCertificateMedicalAttendanceModelActionTypes } from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.action';
import { getMedicalCertificateMedicalAttendanceCollectionModels } from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.selector';
import { MedicalCertificateMentalHealthAction, MedicalCertificateMentalHealthModelActionTypes } from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model.action';
import { getMedicalCertificateMentalHealthCollectionModels } from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model.selector';
import { MedicalCertificatePhysicalHealthAction, MedicalCertificatePhysicalHealthModelActionTypes } from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.action';
import { getMedicalCertificatePhysicalHealthCollectionModels } from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.selector';
import { MedicalCertificateRestrictedWorkAction, MedicalCertificateRestrictedWorkModelActionTypes } from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.action';
import { getMedicalCertificateRestrictedWorkCollectionModels } from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.selector';
import { MedicalCertificateSickLeaveAction, MedicalCertificateSickLeaveModelActionTypes } from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model.action';
import { getMedicalCertificateSickLeaveCollectionModels } from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model.selector';
import { MedicalExaminationRecordAction, MedicalExaminationRecordModelActionTypes } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.action';
import { getMedicalExaminationRecordCollectionModels } from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import { MedicalExaminationRecordDischargeSummaryAction, MedicalExaminationRecordDischargeSummaryModelActionTypes } from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.action';
import { getMedicalExaminationRecordDischargeSummaryCollectionModels } from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.selector';
import { MedicalFeeAction, MedicalFeeModelActionTypes } from 'src/app/models/medicalFee/medical_fee.model.action';
import { getMedicalFeeCollectionModels } from 'src/app/models/medicalFee/medical_fee.model.selector';
import { MedicalFeeItemComponentAction, MedicalFeeItemComponentModelActionTypes } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model.action';
import { getMedicalFeeItemComponentCollectionModels } from 'src/app/models/medicalFeeItemComponent/medical_fee_item_component.model.selector';
import { MedicalRecordInitialChecklistAction, MedicalRecordInitialChecklistModelActionTypes } from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model.action';
import { getMedicalRecordInitialChecklistCollectionModels } from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model.selector';
import { MedicalRecordNextVerificationChecklistAction, MedicalRecordNextVerificationChecklistModelActionTypes } from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.action';
import { getMedicalRecordNextVerificationChecklistCollectionModels } from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.selector';
import { MedicalRecordUserAction, MedicalRecordUserModelActionTypes } from 'src/app/models/medicalRecordUser/medical_record_user.model.action';
import { getMedicalRecordUserCollectionModels } from 'src/app/models/medicalRecordUser/medical_record_user.model.selector';
import { MedicalTranscriberUserAction, MedicalTranscriberUserModelActionTypes } from 'src/app/models/medicalTranscriberUser/medical_transcriber_user.model.action';
import { getMedicalTranscriberUserCollectionModels } from 'src/app/models/medicalTranscriberUser/medical_transcriber_user.model.selector';
import { MedicationAdministeredHistoryAction, MedicationAdministeredHistoryModelActionTypes } from 'src/app/models/medicationAdministeredHistory/medication_administered_history.model.action';
import { getMedicationAdministeredHistoryCollectionModels } from 'src/app/models/medicationAdministeredHistory/medication_administered_history.model.selector';
import { MedicationCompoundAction, MedicationCompoundModelActionTypes } from 'src/app/models/medicationCompound/medication_compound.model.action';
import { getMedicationCompoundCollectionModels } from 'src/app/models/medicationCompound/medication_compound.model.selector';
import { MedicationHeaderAction, MedicationHeaderModelActionTypes } from 'src/app/models/medicationHeader/medication_header.model.action';
import { getMedicationHeaderCollectionModels } from 'src/app/models/medicationHeader/medication_header.model.selector';
import { MedicationItemAction, MedicationItemModelActionTypes } from 'src/app/models/medicationItem/medication_item.model.action';
import { getMedicationItemCollectionModels } from 'src/app/models/medicationItem/medication_item.model.selector';
import { MerchantAction, MerchantModelActionTypes } from 'src/app/models/merchant/merchant.model.action';
import { getMerchantCollectionModels } from 'src/app/models/merchant/merchant.model.selector';
import { MerchantSurchargeAndFeeAction, MerchantSurchargeAndFeeModelActionTypes } from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model.action';
import { getMerchantSurchargeAndFeeCollectionModels } from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model.selector';
import { NhisClaimAction, NhisClaimModelActionTypes } from 'src/app/models/nhisClaim/nhis_claim.model.action';
import { getNhisClaimCollectionModels } from 'src/app/models/nhisClaim/nhis_claim.model.selector';
import { NhisClaimGDRGDetailAction, NhisClaimGDRGDetailModelActionTypes } from 'src/app/models/nhisClaimGDRGDetail/nhis_claim_gdrg_detail.model.action';
import { getNhisClaimGDRGDetailCollectionModels } from 'src/app/models/nhisClaimGDRGDetail/nhis_claim_gdrg_detail.model.selector';
import { NhisClaimInvestigationDetailAction, NhisClaimInvestigationDetailModelActionTypes } from 'src/app/models/nhisClaimInvestigationDetail/nhis_claim_investigation_detail.model.action';
import { getNhisClaimInvestigationDetailCollectionModels } from 'src/app/models/nhisClaimInvestigationDetail/nhis_claim_investigation_detail.model.selector';
import { NhisGDRGAction, NhisGDRGModelActionTypes } from 'src/app/models/nhisGDRG/nhis_gdrg.model.action';
import { getNhisGDRGCollectionModels } from 'src/app/models/nhisGDRG/nhis_gdrg.model.selector';
import { NhisInvestigationAction, NhisInvestigationModelActionTypes } from 'src/app/models/nhisInvestigation/nhis_investigation.model.action';
import { getNhisInvestigationCollectionModels } from 'src/app/models/nhisInvestigation/nhis_investigation.model.selector';
import { NhisMedicineAction, NhisMedicineModelActionTypes } from 'src/app/models/nhisMedicine/nhis_medicine.model.action';
import { getNhisMedicineCollectionModels } from 'src/app/models/nhisMedicine/nhis_medicine.model.selector';
import { NhisServiceOutcomeAction, NhisServiceOutcomeModelActionTypes } from 'src/app/models/nhisServiceOutcome/nhis_service_outcome.model.action';
import { getNhisServiceOutcomeCollectionModels } from 'src/app/models/nhisServiceOutcome/nhis_service_outcome.model.selector';
import { NhisSpecialtyAttendedAction, NhisSpecialtyAttendedModelActionTypes } from 'src/app/models/nhisSpecialtyAttended/nhis_specialty_attended.model.action';
import { getNhisSpecialtyAttendedCollectionModels } from 'src/app/models/nhisSpecialtyAttended/nhis_specialty_attended.model.selector';
import { NhisTypeOfServiceAction, NhisTypeOfServiceModelActionTypes } from 'src/app/models/nhisTypeOfService/nhis_type_of_service.model.action';
import { getNhisTypeOfServiceCollectionModels } from 'src/app/models/nhisTypeOfService/nhis_type_of_service.model.selector';
import { NewbornDetailAction, NewbornDetailModelActionTypes } from 'src/app/models/newbornDetail/newborn_detail.model.action';
import { getNewbornDetailCollectionModels } from 'src/app/models/newbornDetail/newborn_detail.model.selector';
import { NumberingSetupAction, NumberingSetupModelActionTypes } from 'src/app/models/numberingSetup/numbering_setup.model.action';
import { getNumberingSetupCollectionModels } from 'src/app/models/numberingSetup/numbering_setup.model.selector';
import { NurseUserAction, NurseUserModelActionTypes } from 'src/app/models/nurseUser/nurse_user.model.action';
import { getNurseUserCollectionModels } from 'src/app/models/nurseUser/nurse_user.model.selector';
import { NurseVitalSignMeasurementAction, NurseVitalSignMeasurementModelActionTypes } from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.action';
import { getNurseVitalSignMeasurementCollectionModels } from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.selector';
import { ObstetricAndGynecologyHistoryAction, ObstetricAndGynecologyHistoryModelActionTypes } from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.action';
import { getObstetricAndGynecologyHistoryCollectionModels } from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.selector';
import { OdontogramExaminationAction, OdontogramExaminationModelActionTypes } from 'src/app/models/odontogramExamination/odontogram_examination.model.action';
import { getOdontogramExaminationCollectionModels } from 'src/app/models/odontogramExamination/odontogram_examination.model.selector';
import { OperatingTheaterMedicalExaminationRecordAction, OperatingTheaterMedicalExaminationRecordModelActionTypes } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.action';
import { getOperatingTheaterMedicalExaminationRecordCollectionModels } from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import { OphthalmologyExaminationAction, OphthalmologyExaminationModelActionTypes } from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model.action';
import { getOphthalmologyExaminationCollectionModels } from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model.selector';
import { PcareActionExaminationAction, PcareActionExaminationModelActionTypes } from 'src/app/models/pcareActionExamination/pcare_action_examination.model.action';
import { getPcareActionExaminationCollectionModels } from 'src/app/models/pcareActionExamination/pcare_action_examination.model.selector';
import { PcareClubProlanisAction, PcareClubProlanisModelActionTypes } from 'src/app/models/pcareClubProlanis/pcare_club_prolanis.model.action';
import { getPcareClubProlanisCollectionModels } from 'src/app/models/pcareClubProlanis/pcare_club_prolanis.model.selector';
import { PcareCompoundDrugAction, PcareCompoundDrugModelActionTypes } from 'src/app/models/pcareCompoundDrug/pcare_compound_drug.model.action';
import { getPcareCompoundDrugCollectionModels } from 'src/app/models/pcareCompoundDrug/pcare_compound_drug.model.selector';
import { PcareCompoundDrugItemAction, PcareCompoundDrugItemModelActionTypes } from 'src/app/models/pcareCompoundDrugItem/pcare_compound_drug_item.model.action';
import { getPcareCompoundDrugItemCollectionModels } from 'src/app/models/pcareCompoundDrugItem/pcare_compound_drug_item.model.selector';
import { PcareDiagnosaAction, PcareDiagnosaModelActionTypes } from 'src/app/models/pcareDiagnosa/pcare_diagnosa.model.action';
import { getPcareDiagnosaCollectionModels } from 'src/app/models/pcareDiagnosa/pcare_diagnosa.model.selector';
import { PcareDokterAction, PcareDokterModelActionTypes } from 'src/app/models/pcareDokter/pcare_dokter.model.action';
import { getPcareDokterCollectionModels } from 'src/app/models/pcareDokter/pcare_dokter.model.selector';
import { PcareExaminationAction, PcareExaminationModelActionTypes } from 'src/app/models/pcareExamination/pcare_examination.model.action';
import { getPcareExaminationCollectionModels } from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import { PcareMCUAction, PcareMCUModelActionTypes } from 'src/app/models/pcareMCU/pcare_mcu.model.action';
import { getPcareMCUCollectionModels } from 'src/app/models/pcareMCU/pcare_mcu.model.selector';
import { PcareNonCompoundDrugAction, PcareNonCompoundDrugModelActionTypes } from 'src/app/models/pcareNonCompoundDrug/pcare_noncompound_drug.model.action';
import { getPcareNonCompoundDrugCollectionModels } from 'src/app/models/pcareNonCompoundDrug/pcare_noncompound_drug.model.selector';
import { PcareReferensiSaranaAction, PcareReferensiSaranaModelActionTypes } from 'src/app/models/pcareReferensiSarana/pcare_referensi_sarana.model.action';
import { getPcareReferensiSaranaCollectionModels } from 'src/app/models/pcareReferensiSarana/pcare_referensi_sarana.model.selector';
import { PcareStatusPulangAction, PcareStatusPulangModelActionTypes } from 'src/app/models/pcareStatusPulang/pcare_status_pulang.model.action';
import { getPcareStatusPulangCollectionModels } from 'src/app/models/pcareStatusPulang/pcare_status_pulang.model.selector';
import { PcareTindakanAction, PcareTindakanModelActionTypes } from 'src/app/models/pcareTindakan/pcare_tindakan.model.action';
import { getPcareTindakanCollectionModels } from 'src/app/models/pcareTindakan/pcare_tindakan.model.selector';
import { PcareUmumAction, PcareUmumModelActionTypes } from 'src/app/models/pcareUmum/pcare_umum.model.action';
import { getPcareUmumCollectionModels } from 'src/app/models/pcareUmum/pcare_umum.model.selector';
import { PatientCaseHistoryAction, PatientCaseHistoryModelActionTypes } from 'src/app/models/patientCaseHistory/patient_case_history.model.action';
import { getPatientCaseHistoryCollectionModels } from 'src/app/models/patientCaseHistory/patient_case_history.model.selector';
import { PatientConsentAction, PatientConsentModelActionTypes } from 'src/app/models/patientConsent/patient_consent.model.action';
import { getPatientConsentCollectionModels } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { PatientContactInfoAction, PatientContactInfoModelActionTypes } from 'src/app/models/patientContactInfo/patient_contact_info.model.action';
import { getPatientContactInfoCollectionModels } from 'src/app/models/patientContactInfo/patient_contact_info.model.selector';
import { PatientDetailAction, PatientDetailModelActionTypes } from 'src/app/models/patientDetail/patient_detail.model.action';
import { getPatientDetailCollectionModels } from 'src/app/models/patientDetail/patient_detail.model.selector';
import { PatientDetailAddressAction, PatientDetailAddressModelActionTypes } from 'src/app/models/patientDetailAddress/patient_detail_address.model.action';
import { getPatientDetailAddressCollectionModels } from 'src/app/models/patientDetailAddress/patient_detail_address.model.selector';
import { PatientEmergencyContactDetailAction, PatientEmergencyContactDetailModelActionTypes } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model.action';
import { getPatientEmergencyContactDetailCollectionModels } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model.selector';
import { PatientEmploymentDetailAction, PatientEmploymentDetailModelActionTypes } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model.action';
import { getPatientEmploymentDetailCollectionModels } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model.selector';
import { PatientGeneralInfoAction, PatientGeneralInfoModelActionTypes } from 'src/app/models/patientGeneralInfo/patient_general_info.model.action';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientPaymentSelfPayingAction, PatientPaymentSelfPayingModelActionTypes } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model.action';
import { getPatientPaymentSelfPayingCollectionModels } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model.selector';
import { PatientPaymentBPJSAction, PatientPaymentBPJSModelActionTypes } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.action';
import { getPatientPaymentBPJSCollectionModels } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { PatientPaymentInsuranceAction, PatientPaymentInsuranceModelActionTypes } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.action';
import { getPatientPaymentInsuranceCollectionModels } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import { PatientPaymentOthersAction, PatientPaymentOthersModelActionTypes } from 'src/app/models/patientPaymentOthers/patient_payment_others.model.action';
import { getPatientPaymentOthersCollectionModels } from 'src/app/models/patientPaymentOthers/patient_payment_others.model.selector';
import { PatientPersonalInfoAction, PatientPersonalInfoModelActionTypes } from 'src/app/models/patientPersonalInfo/patient_personal_info.model.action';
import { getPatientPersonalInfoCollectionModels } from 'src/app/models/patientPersonalInfo/patient_personal_info.model.selector';
import { PatientSupportingDocumentAction, PatientSupportingDocumentModelActionTypes } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model.action';
import { getPatientSupportingDocumentCollectionModels } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model.selector';
import { PatientVisitAction, PatientVisitModelActionTypes } from 'src/app/models/patientVisit/patient_visit.model.action';
import { getPatientVisitCollectionModels } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { PatientVisitPatientPaymentInsuranceAction, PatientVisitPatientPaymentInsuranceModelActionTypes } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.action';
import { getPatientVisitPatientPaymentInsuranceCollectionModels } from 'src/app/models/patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model.selector';
import { PatientVisitPatientPaymentOthersAction, PatientVisitPatientPaymentOthersModelActionTypes } from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.action';
import { getPatientVisitPatientPaymentOthersCollectionModels } from 'src/app/models/patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model.selector';
import { PatientVisitPaymentSelfPayingAction, PatientVisitPaymentSelfPayingModelActionTypes } from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.action';
import { getPatientVisitPaymentSelfPayingCollectionModels } from 'src/app/models/patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model.selector';
import { PatientVitalInformationAction, PatientVitalInformationModelActionTypes } from 'src/app/models/patientVitalInformation/patient_vital_information.model.action';
import { getPatientVitalInformationCollectionModels } from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import { PharmacySetupAction, PharmacySetupModelActionTypes } from 'src/app/models/pharmacySetup/pharmacy_setup.model.action';
import { getPharmacySetupCollectionModels } from 'src/app/models/pharmacySetup/pharmacy_setup.model.selector';
import { PharmacyUserAction, PharmacyUserModelActionTypes } from 'src/app/models/pharmacyUser/pharmacy_user.model.action';
import { getPharmacyUserCollectionModels } from 'src/app/models/pharmacyUser/pharmacy_user.model.selector';
import { PostOperativeDetailsAction, PostOperativeDetailsModelActionTypes } from 'src/app/models/postOperativeDetails/post_operative_details.model.action';
import { getPostOperativeDetailsCollectionModels } from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import { PreoperativeRecordsAction, PreoperativeRecordsModelActionTypes } from 'src/app/models/preoperativeRecords/preoperative_records.model.action';
import { getPreoperativeRecordsCollectionModels } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { PrescriptionCompoundAction, PrescriptionCompoundModelActionTypes } from 'src/app/models/prescriptionCompound/prescription_compound.model.action';
import { getPrescriptionCompoundCollectionModels } from 'src/app/models/prescriptionCompound/prescription_compound.model.selector';
import { PrescriptionHeaderAction, PrescriptionHeaderModelActionTypes } from 'src/app/models/prescriptionHeader/prescription_header.model.action';
import { getPrescriptionHeaderCollectionModels } from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import { PrescriptionItemAction, PrescriptionItemModelActionTypes } from 'src/app/models/prescriptionItem/prescription_item.model.action';
import { getPrescriptionItemCollectionModels } from 'src/app/models/prescriptionItem/prescription_item.model.selector';
import { PriceComponentAction, PriceComponentModelActionTypes } from 'src/app/models/priceComponent/price_component.model.action';
import { getPriceComponentCollectionModels } from 'src/app/models/priceComponent/price_component.model.selector';
import { PrivilegeAction, PrivilegeModelActionTypes } from 'src/app/models/privilege/privilege.model.action';
import { getPrivilegeCollectionModels } from 'src/app/models/privilege/privilege.model.selector';
import { ProcessWorkflowAction, ProcessWorkflowModelActionTypes } from 'src/app/models/processWorkflow/process_workflow.model.action';
import { getProcessWorkflowCollectionModels } from 'src/app/models/processWorkflow/process_workflow.model.selector';
import { PurchaseOrderAction, PurchaseOrderModelActionTypes } from 'src/app/models/purchaseOrder/purchase_order.model.action';
import { getPurchaseOrderCollectionModels } from 'src/app/models/purchaseOrder/purchase_order.model.selector';
import { PurchaseOrderStockDetailAction, PurchaseOrderStockDetailModelActionTypes } from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model.action';
import { getPurchaseOrderStockDetailCollectionModels } from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model.selector';
import { PurchaseRequisitionAction, PurchaseRequisitionModelActionTypes } from 'src/app/models/purchaseRequisition/purchase_requisition.model.action';
import { getPurchaseRequisitionCollectionModels } from 'src/app/models/purchaseRequisition/purchase_requisition.model.selector';
import { PurchaseRequisitionStockDetailAction, PurchaseRequisitionStockDetailModelActionTypes } from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.action';
import { getPurchaseRequisitionStockDetailCollectionModels } from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.selector';
import { PurchasingUserAction, PurchasingUserModelActionTypes } from 'src/app/models/purchasingUser/purchasing_user.model.action';
import { getPurchasingUserCollectionModels } from 'src/app/models/purchasingUser/purchasing_user.model.selector';
import { ReferenceDataAction, ReferenceDataModelActionTypes } from 'src/app/models/referenceData/reference_data.model.action';
import { getReferenceDataCollectionModels } from 'src/app/models/referenceData/reference_data.model.selector';
import { ReferenceHeaderAction, ReferenceHeaderModelActionTypes } from 'src/app/models/referenceHeader/reference_header.model.action';
import { getReferenceHeaderCollectionModels } from 'src/app/models/referenceHeader/reference_header.model.selector';
import { RegistrationAction, RegistrationModelActionTypes } from 'src/app/models/registration/registration.model.action';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationUserAction, RegistrationUserModelActionTypes } from 'src/app/models/registrationUser/registration_user.model.action';
import { getRegistrationUserCollectionModels } from 'src/app/models/registrationUser/registration_user.model.selector';
import { RetailPharmacyAction, RetailPharmacyModelActionTypes } from 'src/app/models/retailPharmacy/retail_pharmacy.model.action';
import { getRetailPharmacyCollectionModels } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { RetailPharmacyInvoiceAction, RetailPharmacyInvoiceModelActionTypes } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.action';
import { getRetailPharmacyInvoiceCollectionModels } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.selector';
import { RetailPharmacyStockDetailAction, RetailPharmacyStockDetailModelActionTypes } from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.action';
import { getRetailPharmacyStockDetailCollectionModels } from 'src/app/models/retailPharmacyStockDetail/retail_pharmacy_stock_detail.model.selector';
import { ReturnSupplierAction, ReturnSupplierModelActionTypes } from 'src/app/models/returnSupplier/return_supplier.model.action';
import { getReturnSupplierCollectionModels } from 'src/app/models/returnSupplier/return_supplier.model.selector';
import { ReturnSupplierStockDetailAction, ReturnSupplierStockDetailModelActionTypes } from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model.action';
import { getReturnSupplierStockDetailCollectionModels } from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model.selector';
import { RoleAction, RoleModelActionTypes } from 'src/app/models/role/role.model.action';
import { getRoleCollectionModels } from 'src/app/models/role/role.model.selector';
import { RoomFacilityAction, RoomFacilityModelActionTypes } from 'src/app/models/roomFacility/room_facility.model.action';
import { getRoomFacilityCollectionModels } from 'src/app/models/roomFacility/room_facility.model.selector';
import { RoomTransferAction, RoomTransferModelActionTypes } from 'src/app/models/roomTransfer/room_transfer.model.action';
import { getRoomTransferCollectionModels } from 'src/app/models/roomTransfer/room_transfer.model.selector';
import { SepAction, SepModelActionTypes } from 'src/app/models/sep/sep.model.action';
import { getSepCollectionModels } from 'src/app/models/sep/sep.model.selector';
import { SampleCollectionInformationAction, SampleCollectionInformationModelActionTypes } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model.action';
import { getSampleCollectionInformationCollectionModels } from 'src/app/models/sampleCollectionInformation/sample_collection_information.model.selector';
import { SampleCollectionItemsAction, SampleCollectionItemsModelActionTypes } from 'src/app/models/sampleCollectionItems/sample_collection_items.model.action';
import { getSampleCollectionItemsCollectionModels } from 'src/app/models/sampleCollectionItems/sample_collection_items.model.selector';
import { SatuSehatConfigurationAction, SatuSehatConfigurationModelActionTypes } from 'src/app/models/satuSehatConfiguration/satu_sehat_configuration.model.action';
import { getSatuSehatConfigurationCollectionModels } from 'src/app/models/satuSehatConfiguration/satu_sehat_configuration.model.selector';
import { ServiceAction, ServiceModelActionTypes } from 'src/app/models/service/service.model.action';
import { getServiceCollectionModels } from 'src/app/models/service/service.model.selector';
import { ServiceFacilityCategoryAction, ServiceFacilityCategoryModelActionTypes } from 'src/app/models/serviceFacilityCategory/service_facility_category.model.action';
import { getServiceFacilityCategoryCollectionModels } from 'src/app/models/serviceFacilityCategory/service_facility_category.model.selector';
import { ServiceItemAction, ServiceItemModelActionTypes } from 'src/app/models/serviceItem/service_item.model.action';
import { getServiceItemCollectionModels } from 'src/app/models/serviceItem/service_item.model.selector';
import { ServiceItemAssignmentAction, ServiceItemAssignmentModelActionTypes } from 'src/app/models/serviceItemAssignment/service_item_assignment.model.action';
import { getServiceItemAssignmentCollectionModels } from 'src/app/models/serviceItemAssignment/service_item_assignment.model.selector';
import { StaffAction, StaffModelActionTypes } from 'src/app/models/staff/staff.model.action';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StockCatalogueAction, StockCatalogueModelActionTypes } from 'src/app/models/stockCatalogue/stock_catalogue.model.action';
import { getStockCatalogueCollectionModels } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { StockControlAction, StockControlModelActionTypes } from 'src/app/models/stockControl/stock_control.model.action';
import { getStockControlCollectionModels } from 'src/app/models/stockControl/stock_control.model.selector';
import { StockTransactionDetailAction, StockTransactionDetailModelActionTypes } from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model.action';
import { getStockTransactionDetailCollectionModels } from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model.selector';
import { StockTransactionPerDateAction, StockTransactionPerDateModelActionTypes } from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model.action';
import { getStockTransactionPerDateCollectionModels } from 'src/app/models/stockTransactionPerDate/stock_transaction_per_date.model.selector';
import { StockTransactionPerDateTypeAction, StockTransactionPerDateTypeModelActionTypes } from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model.action';
import { getStockTransactionPerDateTypeCollectionModels } from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model.selector';
import { SupplierAction, SupplierModelActionTypes } from 'src/app/models/supplier/supplier.model.action';
import { getSupplierCollectionModels } from 'src/app/models/supplier/supplier.model.selector';
import { SupplierBankAccountAction, SupplierBankAccountModelActionTypes } from 'src/app/models/supplierBankAccount/supplier_bank_account.model.action';
import { getSupplierBankAccountCollectionModels } from 'src/app/models/supplierBankAccount/supplier_bank_account.model.selector';
import { SupplierContactDetailAction, SupplierContactDetailModelActionTypes } from 'src/app/models/supplierContactDetail/supplier_contact_detail.model.action';
import { getSupplierContactDetailCollectionModels } from 'src/app/models/supplierContactDetail/supplier_contact_detail.model.selector';
import { SupplierProductDetailAction, SupplierProductDetailModelActionTypes } from 'src/app/models/supplierProductDetail/supplier_product_detail.model.action';
import { getSupplierProductDetailCollectionModels } from 'src/app/models/supplierProductDetail/supplier_product_detail.model.selector';
import { SystemAdminUserAction, SystemAdminUserModelActionTypes } from 'src/app/models/systemAdminUser/system_admin_user.model.action';
import { getSystemAdminUserCollectionModels } from 'src/app/models/systemAdminUser/system_admin_user.model.selector';
import { TariffDefinitionAction, TariffDefinitionModelActionTypes } from 'src/app/models/tariffDefinition/tariff_definition.model.action';
import { getTariffDefinitionCollectionModels } from 'src/app/models/tariffDefinition/tariff_definition.model.selector';
import { TariffDefinitionOtherComponentAction, TariffDefinitionOtherComponentModelActionTypes } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model.action';
import { getTariffDefinitionOtherComponentCollectionModels } from 'src/app/models/tariffDefinitionOtherComponent/tariff_definition_other_component.model.selector';
import { TariffFormulaAction, TariffFormulaModelActionTypes } from 'src/app/models/tariffFormula/tariff_formula.model.action';
import { getTariffFormulaCollectionModels } from 'src/app/models/tariffFormula/tariff_formula.model.selector';
import { TariffPackageAction, TariffPackageModelActionTypes } from 'src/app/models/tariffPackage/tariff_package.model.action';
import { getTariffPackageCollectionModels } from 'src/app/models/tariffPackage/tariff_package.model.selector';
import { TariffPackageItemAction, TariffPackageItemModelActionTypes } from 'src/app/models/tariffPackageItem/tariff_package_item.model.action';
import { getTariffPackageItemCollectionModels } from 'src/app/models/tariffPackageItem/tariff_package_item.model.selector';
import { TariffPackageServiceAssignmentAction, TariffPackageServiceAssignmentModelActionTypes } from 'src/app/models/tariffPackageServiceAssignment/tariff_package_service_assignment.model.action';
import { getTariffPackageServiceAssignmentCollectionModels } from 'src/app/models/tariffPackageServiceAssignment/tariff_package_service_assignment.model.selector';
import { TariffSchemaAction, TariffSchemaModelActionTypes } from 'src/app/models/tariffSchema/tariff_schema.model.action';
import { getTariffSchemaCollectionModels } from 'src/app/models/tariffSchema/tariff_schema.model.selector';
import { TaskDashboardAction, TaskDashboardModelActionTypes } from 'src/app/models/taskDashboard/task_dashboard.model.action';
import { getTaskDashboardCollectionModels } from 'src/app/models/taskDashboard/task_dashboard.model.selector';
import { TransactionDetailTypeAction, TransactionDetailTypeModelActionTypes } from 'src/app/models/transactionDetailType/transaction_detail_type.model.action';
import { getTransactionDetailTypeCollectionModels } from 'src/app/models/transactionDetailType/transaction_detail_type.model.selector';
import { TransactionDetailTypeMappingAction, TransactionDetailTypeMappingModelActionTypes } from 'src/app/models/transactionDetailTypeMapping/transaction_detail_type_mapping.model.action';
import { getTransactionDetailTypeMappingCollectionModels } from 'src/app/models/transactionDetailTypeMapping/transaction_detail_type_mapping.model.selector';
import { TransferOrderAction, TransferOrderModelActionTypes } from 'src/app/models/transferOrder/transfer_order.model.action';
import { getTransferOrderCollectionModels } from 'src/app/models/transferOrder/transfer_order.model.selector';
import { TransferOrderStockDetailAction, TransferOrderStockDetailModelActionTypes } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.action';
import { getTransferOrderStockDetailCollectionModels } from 'src/app/models/transferOrderStockDetail/transfer_order_stock_detail.model.selector';
import { UnitOfMeasurementAction, UnitOfMeasurementModelActionTypes } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model.action';
import { getUnitOfMeasurementCollectionModels } from 'src/app/models/unitOfMeasurement/unit_of_measurement.model.selector';
import { UserAction, UserModelActionTypes } from 'src/app/models/user/user.model.action';
import { getUserCollectionModels } from 'src/app/models/user/user.model.selector';
import { VaccinationOrderAction, VaccinationOrderModelActionTypes } from 'src/app/models/vaccinationOrder/vaccination_order.model.action';
import { getVaccinationOrderCollectionModels } from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import { VaccinationOrderDetailAction, VaccinationOrderDetailModelActionTypes } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.action';
import { getVaccinationOrderDetailCollectionModels } from 'src/app/models/vaccinationOrderDetail/vaccination_order_detail.model.selector';
import { VitalSignsAction, VitalSignsModelActionTypes } from 'src/app/models/vitalSigns/vital_signs.model.action';
import { getVitalSignsCollectionModels } from 'src/app/models/vitalSigns/vital_signs.model.selector';
import { WarehouseAction, WarehouseModelActionTypes } from 'src/app/models/warehouse/warehouse.model.action';
import { getWarehouseCollectionModels } from 'src/app/models/warehouse/warehouse.model.selector';
import { WarehouseInitialStockAction, WarehouseInitialStockModelActionTypes } from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model.action';
import { getWarehouseInitialStockCollectionModels } from 'src/app/models/warehouseInitialStock/warehouse_initial_stock.model.selector';
import { WarehouseInventoryAction, WarehouseInventoryModelActionTypes } from 'src/app/models/warehouseInventory/warehouse_inventory.model.action';
import { getWarehouseInventoryCollectionModels } from 'src/app/models/warehouseInventory/warehouse_inventory.model.selector';
import { WarehouseUserAction, WarehouseUserModelActionTypes } from 'src/app/models/warehouseUser/warehouse_user.model.action';
import { getWarehouseUserCollectionModels } from 'src/app/models/warehouseUser/warehouse_user.model.selector';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Sort By the OrderBy
 * Pass in an array of OrderBy, and sort with it
 * @param entities the entities to sort
 * @param orders the array of order, which determine the attributes to order with
 * @return the sorted entities
 */
export function sortByOrders<T extends AbstractModel>(entities: T[], orders: OrderBy[]): T[] {
	// % protected region % [Add any additional methods here before sorting] off begin
	// % protected region % [Add any additional methods here before sorting] end

	 entities = _.orderBy(entities, orders.map(orderBy => orderBy.path), orders.map(orderBy => orderBy.descending ? 'desc' : 'asc'));

	 // % protected region % [Add any additional methods here after sorting] off begin
	 // % protected region % [Add any additional methods here after sorting] end

	 return entities;
}

/**
 * Sort and filter the model collection by the query parameters
 * @param entities entities to sort and filter
 * @param queryParams The query parameters object to sort and filter the entities
 * @return sorted and filtered entities
 */
export function sortAndFilterByQueryParams<T extends AbstractModel>(entities: T[], queryParams: QueryParams): T[] {
	// % protected region % [Add any additional methods here before sorting and filtering] off begin
	// % protected region % [Add any additional methods here before sorting and filtering] end

	entities = sortByOrders(entities, queryParams.orderBy);

	// % protected region % [Add any additional methods here after sorting and filtering] off begin
	// % protected region % [Add any additional methods here after sorting and filtering] end

	return entities;
}

/**
 * Transfer the enum to an aryy of object
 * @param enumType The Enum in the ts
 */
export function enumToArray(enumType): { key: string, value: any }[] {
	return Object.keys(enumType).map(key => (
		{
			key: key,
			value: enumType[key]
		}
	));
}

/**
 * Create a reactive form based
 * @param modelProperties Properties The properties of the model
 * @param modelRelations modelRelations Relations of the model
 * @param fields filters the attributes and relations which will be added to the form group.
 * 		If present, only props and relations with a name contained in this list will be added to the form group
 * @return The form group created for the model
 */
export function createReactiveFormFromModel(
	modelProperties: ModelProperty[],
	modelRelations: ModelRelation[],
	disabled: boolean = false,
	fields ?: string[]): FormGroup {

	const formGroup = new FormGroup({});

	// % protected region % [Add any additional logic before creating the form here] off begin
	modelProperties
		.filter(prop => fields ? fields.includes(prop.name) : true)
		.forEach(modelProperty => {
			formGroup.addControl(modelProperty.name, new FormControl({
				value: undefined,
				disabled: disabled || modelProperty.readOnly
			}, modelProperty.validators));
		});

	modelRelations
		.filter(relation => fields ? fields.includes(relation.name) : true)
		.forEach(relation => {
			formGroup.addControl(relation.name, new FormControl({
				value: undefined,
				disabled: disabled
			}, relation.validators));
		});
	// % protected region % [Add any additional logic before creating the form here] end

	return formGroup;
}

/**
 * Adds the properties and relations for a new entity to the model properties and model relations arrays for a
 * crud edit page in multiple entity mode. This involves creating a group which can be added to all of the props and
 * relations which need to be added.
 *
 * This method is designed to be generic, so it will work for 1:1, 1:M, and M:M relations, and is usable for any entity type in the
 * application.
 *
 * @param form The form group which will be added to the group
 * @param model The model to be added to the group.  If creating a new entity, a new entity should be passed in here instead of a previously created one
 * @param modelType The type of the model.  Type checking is not possible here so it is assumed that modelType is the type for the model input
 * 						The method will most likely not work if this is not the case.
 * @param groupDisplayName The name of the group which will be displayed on the page.  Also used to create the group id
 * @param currentProps The modelProperties of the crud page.  These will be expanded and returned
 * @param currentRels The modelRelations of the crud page.  These will be expanded with the relations already present in the page and returned
 * @param preparedRelations An instance of the model relations to be added to the master list which has already been passed through
 * 								prepareReferenceCollections.  This method performs important tasks to populate the relation dropdowns, but cannot
 * 								be run within the subscription where specific entities are known, as this will cause an endless feedback loop of
 * 								NgRx calls which will cause the site to not function properly until a reload
 * @param manyRelation Whether the group to be added is a many side of a 1:M or M:M relation.  This is used to add buttons to the crud edit page which
 * 							delete the current entity from the list of related entities
 * @returns a tuple with modified versions of the currentProps and currentRelations inputs.  All original array members will be present, but new members
 * 				representing the props and relations of the new entity will be added
 */
export function getNewModelProperties<model extends AbstractModel, modelType extends typeof AbstractModel>(
	form: FormGroup,
	model: model,
	modelType: modelType, // IMPORTANT: modelType must be the type of the model input.  This can't be checked easily but if they do not match the method will not work as intended
	groupDisplayName: string,
	currentProps: ModelProperty[],
	currentRels: ModelRelation[],
	preparedRelations: ModelRelation[],
	manyRelation: boolean = false,
): { modelProperties: ModelProperty[], modelRelations: ModelRelation[]} {
	let props: ModelProperty[] = [...currentProps];
	let rels: ModelRelation[] = [...currentRels];
	let group: Group;

	// Group needs to be identical for all elements which are meant to be in a group, as the method which processes the group will process
	// the first instance of a group with this groups ID, so any differences in subsequent groups with the same id will be ignored
	const camelCasedGroupDisplayName = _.camelCase(groupDisplayName);

	group = {
		// This method will be run multiple times through the change detection cycle when initialising for many relations.
		// We need to be able to check for duplicate groups so it is necessary that a model input produces an identical group on different runs
		id: model.id ? camelCasedGroupDisplayName + '_' + model.id : camelCasedGroupDisplayName + '_'+ uuidv4(),
		displayName: groupDisplayName,
		model: model,
		form: form,
		manyRelation: manyRelation,
	};
	group.form.patchValue(model);

	modelType.getProps().forEach(newProp => {
		newProp.group = group;
		let potentialDuplicate = currentProps.find(prop => prop.group && prop.group.id === newProp.group.id && prop.id === newProp.id);
		// We don't want to add a prop if it already exists, but we do want its updated values, so if the attribute has been added previously
		// we overwrite it with the more current version
		if (potentialDuplicate) {
			currentProps[currentProps.indexOf(potentialDuplicate)] = newProp;
		} else {
			props.push(newProp);
		}
	});

	modelType.getRelations().filter(r => r.entityName != 'RoleModel').forEach(newRel => {
		newRel.group = group;

		/*
			The fields being set here are all set on the preparedRelations in prepareReferenceCollections.  That method cannot be called
			in places where getNewModelProperties needs to be called (within subscriptions) so we need to populate each relation with the
			fields from a prepared relation of the same type
		 */
		let populatedRelation: ModelRelation = preparedRelations.find(populated => {
			return populated.id === newRel.id;
		});

		newRel.stateConfig = populatedRelation.stateConfig;
		newRel.collection = populatedRelation.collection;
		newRel.searchFunction = populatedRelation.searchFunction;
		newRel.hideElement = populatedRelation.hideElement;

		let potentialDuplicate = currentRels.find(rel => rel.group && rel.group.id === newRel.group.id && rel.id === newRel.id);
		// Same logic holds here as was discussed above in the props loop
		if (potentialDuplicate) {
			currentRels[currentRels.indexOf(potentialDuplicate)] = newRel;
		} else {
			rels.push(newRel);
		}
	});

	return { modelProperties: props, modelRelations: rels };
}

/**
 * Builds and returns an action which will fetch the necessary entities which need to be viewable/editable in multi entity crud mode
 *
 * @param modelType The Type of the entity to be used.  This is used to call static methods of the type we are trying to fetch.
 * 						This is also used to fetch the actions to be used from fetchPrepareReferenceRequirements()
 * @param relationToExclude The relation to exclude from the expands when fetching the entity/entities.  This will generally be the
 * 								entity which is being created or edited by default on this page prior to adding any extra entities.
 * 								This relation is not necessary and can cause issues when it is included
 * @param collectionId The collection of the entities to be fetched. This needs to be initialised prior to the use of this method
 * @param pageSize The number of entities to fetch.  This is a required field for fetching with query, and will either be 1 (if we are expanding
 * 						a ones relation) or the length of the id list for the entity we are expanding on (if we are expanding a many relation)
 * @param targetModelId The id of the base entity if manyRelation is true, and the id of the expanded entity otherwise
 * @param manyRelation Whether the relation being built is a ones or a many relation.  The wheres, targetModelId, and action type will be
 * 						different depending on the value of this
 * @returns an action, which can be dispatched from the store in the crud edit page to fetch the necessary entities
 */
export function multiCrudExtraEntityAction<modelType extends typeof AbstractModel>(
	modelType: modelType,
	relationToExclude: string,
	collectionId: string,
	pageSize: number,
	targetModelId: string,
	manyRelation: boolean,
): Action {
	let actionHelpers: PrepareReferenceRequirements;
	let where: Where[][] = [[]];
	actionHelpers = fetchPrepareReferenceRequirements(modelType.name);

	if (manyRelation) {
		where = [
			[{
				path: relationToExclude + 'Id',
				operation: QueryOperation.EQUAL,
				value: targetModelId,
			}]
		];
	}

	return new actionHelpers.baseAction(
		manyRelation ? actionHelpers.fetchWithQueryAction : actionHelpers.fetchWithId,
		{
			collectionId: collectionId,
			targetModelId: manyRelation ? undefined : targetModelId,
			queryParams: {
				pageSize: pageSize,
				pageIndex: 0,
				expands: modelType.getRelations().filter(rel => rel.id !== relationToExclude).map(
					relation => {
						return {
							name: relation.id,
							fields: ['id', relation.displayName],
						};
					}
				),
				where: where,
			}
		}
	);
}

/**
 * An interface of all of the objects needed to prepare the entity collection in prepareReferenceModels in crud edit tils
 *
 * An instance of this interface will be returned for every case added to the fetchPrepareReferenceRequirements method below.  By default there is
 * a case for each entity
 */
export interface PrepareReferenceRequirements {
	// The action is an entity specific object.  Using this base action, generic code can be written within loops in the prepareReferenceModels method without needing to know the type of the entity
	baseAction: new (...args: any[]) => Action;
	collectionModelsSelector;
	// The action strings correspond to cases in their respective action types enums.  As each entities enum is a different type, these attributes must be strings
	initCollectionAction: string;
	fetchAllAction: string;
	fetchWithId: string;
	fetchWithQueryAction: string;
}

/**
 * Returns objects and data useful for preparing references in crud edit pages.  As the logic required for each entity will be different, this method
 * has one switch case for each entity.  Ideally this should simplify logic in crud edit pages and reduce the code required in prepareReferenceModels, as
 * with this, the references can be prepared in a for each loop, instead of sequentially in one long method
 *
 * @param modelName the name of the model to return the items for.  This is fed into a switch statement immediately
 * @returns an instance of the PrepareReferenceRequirements interface,
 * 		which allows for preparation of references in crud edit pages without needing to know specific entity types
 */
export function fetchPrepareReferenceRequirements(modelName: string): PrepareReferenceRequirements {
	switch (modelName) {
		case 'AdministrationUserModel':
			return {
				baseAction: AdministrationUserAction,
				initCollectionAction: AdministrationUserModelActionTypes.INITIALISE_ADMINISTRATION_USER_COLLECTION_STATE,
				fetchAllAction: AdministrationUserModelActionTypes.FETCH_ALL_ADMINISTRATION_USER,
				fetchWithQueryAction: AdministrationUserModelActionTypes.FETCH_ADMINISTRATION_USER_WITH_QUERY,
				fetchWithId: AdministrationUserModelActionTypes.FETCH_ADMINISTRATION_USER,
				collectionModelsSelector: getAdministrationUserCollectionModels,
			};
		case 'AdministratorModel':
			return {
				baseAction: AdministratorAction,
				initCollectionAction: AdministratorModelActionTypes.INITIALISE_ADMINISTRATOR_COLLECTION_STATE,
				fetchAllAction: AdministratorModelActionTypes.FETCH_ALL_ADMINISTRATOR,
				fetchWithQueryAction: AdministratorModelActionTypes.FETCH_ADMINISTRATOR_WITH_QUERY,
				fetchWithId: AdministratorModelActionTypes.FETCH_ADMINISTRATOR,
				collectionModelsSelector: getAdministratorCollectionModels,
			};
		case 'AmendmentDetailModel':
			return {
				baseAction: AmendmentDetailAction,
				initCollectionAction: AmendmentDetailModelActionTypes.INITIALISE_AMENDMENT_DETAIL_COLLECTION_STATE,
				fetchAllAction: AmendmentDetailModelActionTypes.FETCH_ALL_AMENDMENT_DETAIL,
				fetchWithQueryAction: AmendmentDetailModelActionTypes.FETCH_AMENDMENT_DETAIL_WITH_QUERY,
				fetchWithId: AmendmentDetailModelActionTypes.FETCH_AMENDMENT_DETAIL,
				collectionModelsSelector: getAmendmentDetailCollectionModels,
			};
		case 'BpjsAccidentMasterModel':
			return {
				baseAction: BpjsAccidentMasterAction,
				initCollectionAction: BpjsAccidentMasterModelActionTypes.INITIALISE_BPJS_ACCIDENT_MASTER_COLLECTION_STATE,
				fetchAllAction: BpjsAccidentMasterModelActionTypes.FETCH_ALL_BPJS_ACCIDENT_MASTER,
				fetchWithQueryAction: BpjsAccidentMasterModelActionTypes.FETCH_BPJS_ACCIDENT_MASTER_WITH_QUERY,
				fetchWithId: BpjsAccidentMasterModelActionTypes.FETCH_BPJS_ACCIDENT_MASTER,
				collectionModelsSelector: getBpjsAccidentMasterCollectionModels,
			};
		case 'BpjsBedAvailabilityModel':
			return {
				baseAction: BpjsBedAvailabilityAction,
				initCollectionAction: BpjsBedAvailabilityModelActionTypes.INITIALISE_BPJS_BED_AVAILABILITY_COLLECTION_STATE,
				fetchAllAction: BpjsBedAvailabilityModelActionTypes.FETCH_ALL_BPJS_BED_AVAILABILITY,
				fetchWithQueryAction: BpjsBedAvailabilityModelActionTypes.FETCH_BPJS_BED_AVAILABILITY_WITH_QUERY,
				fetchWithId: BpjsBedAvailabilityModelActionTypes.FETCH_BPJS_BED_AVAILABILITY,
				collectionModelsSelector: getBpjsBedAvailabilityCollectionModels,
			};
		case 'BpjsClaimDataModel':
			return {
				baseAction: BpjsClaimDataAction,
				initCollectionAction: BpjsClaimDataModelActionTypes.INITIALISE_BPJS_CLAIM_DATA_COLLECTION_STATE,
				fetchAllAction: BpjsClaimDataModelActionTypes.FETCH_ALL_BPJS_CLAIM_DATA,
				fetchWithQueryAction: BpjsClaimDataModelActionTypes.FETCH_BPJS_CLAIM_DATA_WITH_QUERY,
				fetchWithId: BpjsClaimDataModelActionTypes.FETCH_BPJS_CLAIM_DATA,
				collectionModelsSelector: getBpjsClaimDataCollectionModels,
			};
		case 'BpjsClaimSubmissionModel':
			return {
				baseAction: BpjsClaimSubmissionAction,
				initCollectionAction: BpjsClaimSubmissionModelActionTypes.INITIALISE_BPJS_CLAIM_SUBMISSION_COLLECTION_STATE,
				fetchAllAction: BpjsClaimSubmissionModelActionTypes.FETCH_ALL_BPJS_CLAIM_SUBMISSION,
				fetchWithQueryAction: BpjsClaimSubmissionModelActionTypes.FETCH_BPJS_CLAIM_SUBMISSION_WITH_QUERY,
				fetchWithId: BpjsClaimSubmissionModelActionTypes.FETCH_BPJS_CLAIM_SUBMISSION,
				collectionModelsSelector: getBpjsClaimSubmissionCollectionModels,
			};
		case 'BpjsControlPlanModel':
			return {
				baseAction: BpjsControlPlanAction,
				initCollectionAction: BpjsControlPlanModelActionTypes.INITIALISE_BPJS_CONTROL_PLAN_COLLECTION_STATE,
				fetchAllAction: BpjsControlPlanModelActionTypes.FETCH_ALL_BPJS_CONTROL_PLAN,
				fetchWithQueryAction: BpjsControlPlanModelActionTypes.FETCH_BPJS_CONTROL_PLAN_WITH_QUERY,
				fetchWithId: BpjsControlPlanModelActionTypes.FETCH_BPJS_CONTROL_PLAN,
				collectionModelsSelector: getBpjsControlPlanCollectionModels,
			};
		case 'BpjsControlSpecialistModel':
			return {
				baseAction: BpjsControlSpecialistAction,
				initCollectionAction: BpjsControlSpecialistModelActionTypes.INITIALISE_BPJS_CONTROL_SPECIALIST_COLLECTION_STATE,
				fetchAllAction: BpjsControlSpecialistModelActionTypes.FETCH_ALL_BPJS_CONTROL_SPECIALIST,
				fetchWithQueryAction: BpjsControlSpecialistModelActionTypes.FETCH_BPJS_CONTROL_SPECIALIST_WITH_QUERY,
				fetchWithId: BpjsControlSpecialistModelActionTypes.FETCH_BPJS_CONTROL_SPECIALIST,
				collectionModelsSelector: getBpjsControlSpecialistCollectionModels,
			};
		case 'BpjsDiagnoseModel':
			return {
				baseAction: BpjsDiagnoseAction,
				initCollectionAction: BpjsDiagnoseModelActionTypes.INITIALISE_BPJS_DIAGNOSE_COLLECTION_STATE,
				fetchAllAction: BpjsDiagnoseModelActionTypes.FETCH_ALL_BPJS_DIAGNOSE,
				fetchWithQueryAction: BpjsDiagnoseModelActionTypes.FETCH_BPJS_DIAGNOSE_WITH_QUERY,
				fetchWithId: BpjsDiagnoseModelActionTypes.FETCH_BPJS_DIAGNOSE,
				collectionModelsSelector: getBpjsDiagnoseCollectionModels,
			};
		case 'BpjsDiagnosePRBModel':
			return {
				baseAction: BpjsDiagnosePRBAction,
				initCollectionAction: BpjsDiagnosePRBModelActionTypes.INITIALISE_BPJS_DIAGNOSE_PRB_COLLECTION_STATE,
				fetchAllAction: BpjsDiagnosePRBModelActionTypes.FETCH_ALL_BPJS_DIAGNOSE_PRB,
				fetchWithQueryAction: BpjsDiagnosePRBModelActionTypes.FETCH_BPJS_DIAGNOSE_PRB_WITH_QUERY,
				fetchWithId: BpjsDiagnosePRBModelActionTypes.FETCH_BPJS_DIAGNOSE_PRB,
				collectionModelsSelector: getBpjsDiagnosePRBCollectionModels,
			};
		case 'BpjsDismissalConditionModel':
			return {
				baseAction: BpjsDismissalConditionAction,
				initCollectionAction: BpjsDismissalConditionModelActionTypes.INITIALISE_BPJS_DISMISSAL_CONDITION_COLLECTION_STATE,
				fetchAllAction: BpjsDismissalConditionModelActionTypes.FETCH_ALL_BPJS_DISMISSAL_CONDITION,
				fetchWithQueryAction: BpjsDismissalConditionModelActionTypes.FETCH_BPJS_DISMISSAL_CONDITION_WITH_QUERY,
				fetchWithId: BpjsDismissalConditionModelActionTypes.FETCH_BPJS_DISMISSAL_CONDITION,
				collectionModelsSelector: getBpjsDismissalConditionCollectionModels,
			};
		case 'BpjsDismissalMappingModel':
			return {
				baseAction: BpjsDismissalMappingAction,
				initCollectionAction: BpjsDismissalMappingModelActionTypes.INITIALISE_BPJS_DISMISSAL_MAPPING_COLLECTION_STATE,
				fetchAllAction: BpjsDismissalMappingModelActionTypes.FETCH_ALL_BPJS_DISMISSAL_MAPPING,
				fetchWithQueryAction: BpjsDismissalMappingModelActionTypes.FETCH_BPJS_DISMISSAL_MAPPING_WITH_QUERY,
				fetchWithId: BpjsDismissalMappingModelActionTypes.FETCH_BPJS_DISMISSAL_MAPPING,
				collectionModelsSelector: getBpjsDismissalMappingCollectionModels,
			};
		case 'BpjsDoctorMappingModel':
			return {
				baseAction: BpjsDoctorMappingAction,
				initCollectionAction: BpjsDoctorMappingModelActionTypes.INITIALISE_BPJS_DOCTOR_MAPPING_COLLECTION_STATE,
				fetchAllAction: BpjsDoctorMappingModelActionTypes.FETCH_ALL_BPJS_DOCTOR_MAPPING,
				fetchWithQueryAction: BpjsDoctorMappingModelActionTypes.FETCH_BPJS_DOCTOR_MAPPING_WITH_QUERY,
				fetchWithId: BpjsDoctorMappingModelActionTypes.FETCH_BPJS_DOCTOR_MAPPING,
				collectionModelsSelector: getBpjsDoctorMappingCollectionModels,
			};
		case 'BpjsDoctorScheduleModel':
			return {
				baseAction: BpjsDoctorScheduleAction,
				initCollectionAction: BpjsDoctorScheduleModelActionTypes.INITIALISE_BPJS_DOCTOR_SCHEDULE_COLLECTION_STATE,
				fetchAllAction: BpjsDoctorScheduleModelActionTypes.FETCH_ALL_BPJS_DOCTOR_SCHEDULE,
				fetchWithQueryAction: BpjsDoctorScheduleModelActionTypes.FETCH_BPJS_DOCTOR_SCHEDULE_WITH_QUERY,
				fetchWithId: BpjsDoctorScheduleModelActionTypes.FETCH_BPJS_DOCTOR_SCHEDULE,
				collectionModelsSelector: getBpjsDoctorScheduleCollectionModels,
			};
		case 'BpjsDrugGenericPRBModel':
			return {
				baseAction: BpjsDrugGenericPRBAction,
				initCollectionAction: BpjsDrugGenericPRBModelActionTypes.INITIALISE_BPJS_DRUG_GENERIC_PRB_COLLECTION_STATE,
				fetchAllAction: BpjsDrugGenericPRBModelActionTypes.FETCH_ALL_BPJS_DRUG_GENERIC_PRB,
				fetchWithQueryAction: BpjsDrugGenericPRBModelActionTypes.FETCH_BPJS_DRUG_GENERIC_PRB_WITH_QUERY,
				fetchWithId: BpjsDrugGenericPRBModelActionTypes.FETCH_BPJS_DRUG_GENERIC_PRB,
				collectionModelsSelector: getBpjsDrugGenericPRBCollectionModels,
			};
		case 'BpjsFacilityListModel':
			return {
				baseAction: BpjsFacilityListAction,
				initCollectionAction: BpjsFacilityListModelActionTypes.INITIALISE_BPJS_FACILITY_LIST_COLLECTION_STATE,
				fetchAllAction: BpjsFacilityListModelActionTypes.FETCH_ALL_BPJS_FACILITY_LIST,
				fetchWithQueryAction: BpjsFacilityListModelActionTypes.FETCH_BPJS_FACILITY_LIST_WITH_QUERY,
				fetchWithId: BpjsFacilityListModelActionTypes.FETCH_BPJS_FACILITY_LIST,
				collectionModelsSelector: getBpjsFacilityListCollectionModels,
			};
		case 'BpjsFingerPrintModel':
			return {
				baseAction: BpjsFingerPrintAction,
				initCollectionAction: BpjsFingerPrintModelActionTypes.INITIALISE_BPJS_FINGER_PRINT_COLLECTION_STATE,
				fetchAllAction: BpjsFingerPrintModelActionTypes.FETCH_ALL_BPJS_FINGER_PRINT,
				fetchWithQueryAction: BpjsFingerPrintModelActionTypes.FETCH_BPJS_FINGER_PRINT_WITH_QUERY,
				fetchWithId: BpjsFingerPrintModelActionTypes.FETCH_BPJS_FINGER_PRINT,
				collectionModelsSelector: getBpjsFingerPrintCollectionModels,
			};
		case 'BpjsGeneralModel':
			return {
				baseAction: BpjsGeneralAction,
				initCollectionAction: BpjsGeneralModelActionTypes.INITIALISE_BPJS_GENERAL_COLLECTION_STATE,
				fetchAllAction: BpjsGeneralModelActionTypes.FETCH_ALL_BPJS_GENERAL,
				fetchWithQueryAction: BpjsGeneralModelActionTypes.FETCH_BPJS_GENERAL_WITH_QUERY,
				fetchWithId: BpjsGeneralModelActionTypes.FETCH_BPJS_GENERAL,
				collectionModelsSelector: getBpjsGeneralCollectionModels,
			};
		case 'BpjsHealthFacilityModel':
			return {
				baseAction: BpjsHealthFacilityAction,
				initCollectionAction: BpjsHealthFacilityModelActionTypes.INITIALISE_BPJS_HEALTH_FACILITY_COLLECTION_STATE,
				fetchAllAction: BpjsHealthFacilityModelActionTypes.FETCH_ALL_BPJS_HEALTH_FACILITY,
				fetchWithQueryAction: BpjsHealthFacilityModelActionTypes.FETCH_BPJS_HEALTH_FACILITY_WITH_QUERY,
				fetchWithId: BpjsHealthFacilityModelActionTypes.FETCH_BPJS_HEALTH_FACILITY,
				collectionModelsSelector: getBpjsHealthFacilityCollectionModels,
			};
		case 'BpjsHospitalizationPlanModel':
			return {
				baseAction: BpjsHospitalizationPlanAction,
				initCollectionAction: BpjsHospitalizationPlanModelActionTypes.INITIALISE_BPJS_HOSPITALIZATION_PLAN_COLLECTION_STATE,
				fetchAllAction: BpjsHospitalizationPlanModelActionTypes.FETCH_ALL_BPJS_HOSPITALIZATION_PLAN,
				fetchWithQueryAction: BpjsHospitalizationPlanModelActionTypes.FETCH_BPJS_HOSPITALIZATION_PLAN_WITH_QUERY,
				fetchWithId: BpjsHospitalizationPlanModelActionTypes.FETCH_BPJS_HOSPITALIZATION_PLAN,
				collectionModelsSelector: getBpjsHospitalizationPlanCollectionModels,
			};
		case 'BpjsINACBGModel':
			return {
				baseAction: BpjsINACBGAction,
				initCollectionAction: BpjsINACBGModelActionTypes.INITIALISE_BPJS_INACBG_COLLECTION_STATE,
				fetchAllAction: BpjsINACBGModelActionTypes.FETCH_ALL_BPJS_INACBG,
				fetchWithQueryAction: BpjsINACBGModelActionTypes.FETCH_BPJS_INACBG_WITH_QUERY,
				fetchWithId: BpjsINACBGModelActionTypes.FETCH_BPJS_INACBG,
				collectionModelsSelector: getBpjsINACBGCollectionModels,
			};
		case 'BpjsINACBGClaimModel':
			return {
				baseAction: BpjsINACBGClaimAction,
				initCollectionAction: BpjsINACBGClaimModelActionTypes.INITIALISE_BPJS_INACBG_CLAIM_COLLECTION_STATE,
				fetchAllAction: BpjsINACBGClaimModelActionTypes.FETCH_ALL_BPJS_INACBG_CLAIM,
				fetchWithQueryAction: BpjsINACBGClaimModelActionTypes.FETCH_BPJS_INACBG_CLAIM_WITH_QUERY,
				fetchWithId: BpjsINACBGClaimModelActionTypes.FETCH_BPJS_INACBG_CLAIM,
				collectionModelsSelector: getBpjsINACBGClaimCollectionModels,
			};
		case 'BpjsINACBGVariableModel':
			return {
				baseAction: BpjsINACBGVariableAction,
				initCollectionAction: BpjsINACBGVariableModelActionTypes.INITIALISE_BPJS_INACBG_VARIABLE_COLLECTION_STATE,
				fetchAllAction: BpjsINACBGVariableModelActionTypes.FETCH_ALL_BPJS_INACBG_VARIABLE,
				fetchWithQueryAction: BpjsINACBGVariableModelActionTypes.FETCH_BPJS_INACBG_VARIABLE_WITH_QUERY,
				fetchWithId: BpjsINACBGVariableModelActionTypes.FETCH_BPJS_INACBG_VARIABLE,
				collectionModelsSelector: getBpjsINACBGVariableCollectionModels,
			};
		case 'BpjsJasaRaharjaModel':
			return {
				baseAction: BpjsJasaRaharjaAction,
				initCollectionAction: BpjsJasaRaharjaModelActionTypes.INITIALISE_BPJS_JASA_RAHARJA_COLLECTION_STATE,
				fetchAllAction: BpjsJasaRaharjaModelActionTypes.FETCH_ALL_BPJS_JASA_RAHARJA,
				fetchWithQueryAction: BpjsJasaRaharjaModelActionTypes.FETCH_BPJS_JASA_RAHARJA_WITH_QUERY,
				fetchWithId: BpjsJasaRaharjaModelActionTypes.FETCH_BPJS_JASA_RAHARJA,
				collectionModelsSelector: getBpjsJasaRaharjaCollectionModels,
			};
		case 'BpjsJasaRaharjaClaimModel':
			return {
				baseAction: BpjsJasaRaharjaClaimAction,
				initCollectionAction: BpjsJasaRaharjaClaimModelActionTypes.INITIALISE_BPJS_JASA_RAHARJA_CLAIM_COLLECTION_STATE,
				fetchAllAction: BpjsJasaRaharjaClaimModelActionTypes.FETCH_ALL_BPJS_JASA_RAHARJA_CLAIM,
				fetchWithQueryAction: BpjsJasaRaharjaClaimModelActionTypes.FETCH_BPJS_JASA_RAHARJA_CLAIM_WITH_QUERY,
				fetchWithId: BpjsJasaRaharjaClaimModelActionTypes.FETCH_BPJS_JASA_RAHARJA_CLAIM,
				collectionModelsSelector: getBpjsJasaRaharjaClaimCollectionModels,
			};
		case 'BpjsListFingerPrintModel':
			return {
				baseAction: BpjsListFingerPrintAction,
				initCollectionAction: BpjsListFingerPrintModelActionTypes.INITIALISE_BPJS_LIST_FINGER_PRINT_COLLECTION_STATE,
				fetchAllAction: BpjsListFingerPrintModelActionTypes.FETCH_ALL_BPJS_LIST_FINGER_PRINT,
				fetchWithQueryAction: BpjsListFingerPrintModelActionTypes.FETCH_BPJS_LIST_FINGER_PRINT_WITH_QUERY,
				fetchWithId: BpjsListFingerPrintModelActionTypes.FETCH_BPJS_LIST_FINGER_PRINT,
				collectionModelsSelector: getBpjsListFingerPrintCollectionModels,
			};
		case 'BpjsListTaskModel':
			return {
				baseAction: BpjsListTaskAction,
				initCollectionAction: BpjsListTaskModelActionTypes.INITIALISE_BPJS_LIST_TASK_COLLECTION_STATE,
				fetchAllAction: BpjsListTaskModelActionTypes.FETCH_ALL_BPJS_LIST_TASK,
				fetchWithQueryAction: BpjsListTaskModelActionTypes.FETCH_BPJS_LIST_TASK_WITH_QUERY,
				fetchWithId: BpjsListTaskModelActionTypes.FETCH_BPJS_LIST_TASK,
				collectionModelsSelector: getBpjsListTaskCollectionModels,
			};
		case 'BpjsOutsideFacilityReferralModel':
			return {
				baseAction: BpjsOutsideFacilityReferralAction,
				initCollectionAction: BpjsOutsideFacilityReferralModelActionTypes.INITIALISE_BPJS_OUTSIDE_FACILITY_REFERRAL_COLLECTION_STATE,
				fetchAllAction: BpjsOutsideFacilityReferralModelActionTypes.FETCH_ALL_BPJS_OUTSIDE_FACILITY_REFERRAL,
				fetchWithQueryAction: BpjsOutsideFacilityReferralModelActionTypes.FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL_WITH_QUERY,
				fetchWithId: BpjsOutsideFacilityReferralModelActionTypes.FETCH_BPJS_OUTSIDE_FACILITY_REFERRAL,
				collectionModelsSelector: getBpjsOutsideFacilityReferralCollectionModels,
			};
		case 'BpjsPRBModel':
			return {
				baseAction: BpjsPRBAction,
				initCollectionAction: BpjsPRBModelActionTypes.INITIALISE_BPJS_PRB_COLLECTION_STATE,
				fetchAllAction: BpjsPRBModelActionTypes.FETCH_ALL_BPJS_PRB,
				fetchWithQueryAction: BpjsPRBModelActionTypes.FETCH_BPJS_PRB_WITH_QUERY,
				fetchWithId: BpjsPRBModelActionTypes.FETCH_BPJS_PRB,
				collectionModelsSelector: getBpjsPRBCollectionModels,
			};
		case 'BpjsPRBDetailModel':
			return {
				baseAction: BpjsPRBDetailAction,
				initCollectionAction: BpjsPRBDetailModelActionTypes.INITIALISE_BPJS_PRB_DETAIL_COLLECTION_STATE,
				fetchAllAction: BpjsPRBDetailModelActionTypes.FETCH_ALL_BPJS_PRB_DETAIL,
				fetchWithQueryAction: BpjsPRBDetailModelActionTypes.FETCH_BPJS_PRB_DETAIL_WITH_QUERY,
				fetchWithId: BpjsPRBDetailModelActionTypes.FETCH_BPJS_PRB_DETAIL,
				collectionModelsSelector: getBpjsPRBDetailCollectionModels,
			};
		case 'BpjsPatientReferralModel':
			return {
				baseAction: BpjsPatientReferralAction,
				initCollectionAction: BpjsPatientReferralModelActionTypes.INITIALISE_BPJS_PATIENT_REFERRAL_COLLECTION_STATE,
				fetchAllAction: BpjsPatientReferralModelActionTypes.FETCH_ALL_BPJS_PATIENT_REFERRAL,
				fetchWithQueryAction: BpjsPatientReferralModelActionTypes.FETCH_BPJS_PATIENT_REFERRAL_WITH_QUERY,
				fetchWithId: BpjsPatientReferralModelActionTypes.FETCH_BPJS_PATIENT_REFERRAL,
				collectionModelsSelector: getBpjsPatientReferralCollectionModels,
			};
		case 'BpjsPcareDPHOModel':
			return {
				baseAction: BpjsPcareDPHOAction,
				initCollectionAction: BpjsPcareDPHOModelActionTypes.INITIALISE_BPJS_PCARE_DPHO_COLLECTION_STATE,
				fetchAllAction: BpjsPcareDPHOModelActionTypes.FETCH_ALL_BPJS_PCARE_DPHO,
				fetchWithQueryAction: BpjsPcareDPHOModelActionTypes.FETCH_BPJS_PCARE_DPHO_WITH_QUERY,
				fetchWithId: BpjsPcareDPHOModelActionTypes.FETCH_BPJS_PCARE_DPHO,
				collectionModelsSelector: getBpjsPcareDPHOCollectionModels,
			};
		case 'BpjsPcareKegiatanKelompokModel':
			return {
				baseAction: BpjsPcareKegiatanKelompokAction,
				initCollectionAction: BpjsPcareKegiatanKelompokModelActionTypes.INITIALISE_BPJS_PCARE_KEGIATAN_KELOMPOK_COLLECTION_STATE,
				fetchAllAction: BpjsPcareKegiatanKelompokModelActionTypes.FETCH_ALL_BPJS_PCARE_KEGIATAN_KELOMPOK,
				fetchWithQueryAction: BpjsPcareKegiatanKelompokModelActionTypes.FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK_WITH_QUERY,
				fetchWithId: BpjsPcareKegiatanKelompokModelActionTypes.FETCH_BPJS_PCARE_KEGIATAN_KELOMPOK,
				collectionModelsSelector: getBpjsPcareKegiatanKelompokCollectionModels,
			};
		case 'BpjsPcareKesadaranModel':
			return {
				baseAction: BpjsPcareKesadaranAction,
				initCollectionAction: BpjsPcareKesadaranModelActionTypes.INITIALISE_BPJS_PCARE_KESADARAN_COLLECTION_STATE,
				fetchAllAction: BpjsPcareKesadaranModelActionTypes.FETCH_ALL_BPJS_PCARE_KESADARAN,
				fetchWithQueryAction: BpjsPcareKesadaranModelActionTypes.FETCH_BPJS_PCARE_KESADARAN_WITH_QUERY,
				fetchWithId: BpjsPcareKesadaranModelActionTypes.FETCH_BPJS_PCARE_KESADARAN,
				collectionModelsSelector: getBpjsPcareKesadaranCollectionModels,
			};
		case 'BpjsPcarePesertaKegiatanKelompokModel':
			return {
				baseAction: BpjsPcarePesertaKegiatanKelompokAction,
				initCollectionAction: BpjsPcarePesertaKegiatanKelompokModelActionTypes.INITIALISE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_COLLECTION_STATE,
				fetchAllAction: BpjsPcarePesertaKegiatanKelompokModelActionTypes.FETCH_ALL_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK,
				fetchWithQueryAction: BpjsPcarePesertaKegiatanKelompokModelActionTypes.FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_WITH_QUERY,
				fetchWithId: BpjsPcarePesertaKegiatanKelompokModelActionTypes.FETCH_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK,
				collectionModelsSelector: getBpjsPcarePesertaKegiatanKelompokCollectionModels,
			};
		case 'BpjsPcarePoliModel':
			return {
				baseAction: BpjsPcarePoliAction,
				initCollectionAction: BpjsPcarePoliModelActionTypes.INITIALISE_BPJS_PCARE_POLI_COLLECTION_STATE,
				fetchAllAction: BpjsPcarePoliModelActionTypes.FETCH_ALL_BPJS_PCARE_POLI,
				fetchWithQueryAction: BpjsPcarePoliModelActionTypes.FETCH_BPJS_PCARE_POLI_WITH_QUERY,
				fetchWithId: BpjsPcarePoliModelActionTypes.FETCH_BPJS_PCARE_POLI,
				collectionModelsSelector: getBpjsPcarePoliCollectionModels,
			};
		case 'BpjsPcareProviderRayonisasiModel':
			return {
				baseAction: BpjsPcareProviderRayonisasiAction,
				initCollectionAction: BpjsPcareProviderRayonisasiModelActionTypes.INITIALISE_BPJS_PCARE_PROVIDER_RAYONISASI_COLLECTION_STATE,
				fetchAllAction: BpjsPcareProviderRayonisasiModelActionTypes.FETCH_ALL_BPJS_PCARE_PROVIDER_RAYONISASI,
				fetchWithQueryAction: BpjsPcareProviderRayonisasiModelActionTypes.FETCH_BPJS_PCARE_PROVIDER_RAYONISASI_WITH_QUERY,
				fetchWithId: BpjsPcareProviderRayonisasiModelActionTypes.FETCH_BPJS_PCARE_PROVIDER_RAYONISASI,
				collectionModelsSelector: getBpjsPcareProviderRayonisasiCollectionModels,
			};
		case 'BpjsPcareRegistrationsModel':
			return {
				baseAction: BpjsPcareRegistrationsAction,
				initCollectionAction: BpjsPcareRegistrationsModelActionTypes.INITIALISE_BPJS_PCARE_REGISTRATIONS_COLLECTION_STATE,
				fetchAllAction: BpjsPcareRegistrationsModelActionTypes.FETCH_ALL_BPJS_PCARE_REGISTRATIONS,
				fetchWithQueryAction: BpjsPcareRegistrationsModelActionTypes.FETCH_BPJS_PCARE_REGISTRATIONS_WITH_QUERY,
				fetchWithId: BpjsPcareRegistrationsModelActionTypes.FETCH_BPJS_PCARE_REGISTRATIONS,
				collectionModelsSelector: getBpjsPcareRegistrationsCollectionModels,
			};
		case 'BpjsProcedureModel':
			return {
				baseAction: BpjsProcedureAction,
				initCollectionAction: BpjsProcedureModelActionTypes.INITIALISE_BPJS_PROCEDURE_COLLECTION_STATE,
				fetchAllAction: BpjsProcedureModelActionTypes.FETCH_ALL_BPJS_PROCEDURE,
				fetchWithQueryAction: BpjsProcedureModelActionTypes.FETCH_BPJS_PROCEDURE_WITH_QUERY,
				fetchWithId: BpjsProcedureModelActionTypes.FETCH_BPJS_PROCEDURE,
				collectionModelsSelector: getBpjsProcedureCollectionModels,
			};
		case 'BpjsReferralSpecialistModel':
			return {
				baseAction: BpjsReferralSpecialistAction,
				initCollectionAction: BpjsReferralSpecialistModelActionTypes.INITIALISE_BPJS_REFERRAL_SPECIALIST_COLLECTION_STATE,
				fetchAllAction: BpjsReferralSpecialistModelActionTypes.FETCH_ALL_BPJS_REFERRAL_SPECIALIST,
				fetchWithQueryAction: BpjsReferralSpecialistModelActionTypes.FETCH_BPJS_REFERRAL_SPECIALIST_WITH_QUERY,
				fetchWithId: BpjsReferralSpecialistModelActionTypes.FETCH_BPJS_REFERRAL_SPECIALIST,
				collectionModelsSelector: getBpjsReferralSpecialistCollectionModels,
			};
		case 'BpjsSEPModel':
			return {
				baseAction: BpjsSEPAction,
				initCollectionAction: BpjsSEPModelActionTypes.INITIALISE_BPJS_SEP_COLLECTION_STATE,
				fetchAllAction: BpjsSEPModelActionTypes.FETCH_ALL_BPJS_SEP,
				fetchWithQueryAction: BpjsSEPModelActionTypes.FETCH_BPJS_SEP_WITH_QUERY,
				fetchWithId: BpjsSEPModelActionTypes.FETCH_BPJS_SEP,
				collectionModelsSelector: getBpjsSEPCollectionModels,
			};
		case 'BpjsSEPINACBGIntegrationModel':
			return {
				baseAction: BpjsSEPINACBGIntegrationAction,
				initCollectionAction: BpjsSEPINACBGIntegrationModelActionTypes.INITIALISE_BPJS_SEP_INACBG_INTEGRATION_COLLECTION_STATE,
				fetchAllAction: BpjsSEPINACBGIntegrationModelActionTypes.FETCH_ALL_BPJS_SEP_INACBG_INTEGRATION,
				fetchWithQueryAction: BpjsSEPINACBGIntegrationModelActionTypes.FETCH_BPJS_SEP_INACBG_INTEGRATION_WITH_QUERY,
				fetchWithId: BpjsSEPINACBGIntegrationModelActionTypes.FETCH_BPJS_SEP_INACBG_INTEGRATION,
				collectionModelsSelector: getBpjsSEPINACBGIntegrationCollectionModels,
			};
		case 'BpjsSEPInternalDataModel':
			return {
				baseAction: BpjsSEPInternalDataAction,
				initCollectionAction: BpjsSEPInternalDataModelActionTypes.INITIALISE_BPJS_SEP_INTERNAL_DATA_COLLECTION_STATE,
				fetchAllAction: BpjsSEPInternalDataModelActionTypes.FETCH_ALL_BPJS_SEP_INTERNAL_DATA,
				fetchWithQueryAction: BpjsSEPInternalDataModelActionTypes.FETCH_BPJS_SEP_INTERNAL_DATA_WITH_QUERY,
				fetchWithId: BpjsSEPInternalDataModelActionTypes.FETCH_BPJS_SEP_INTERNAL_DATA,
				collectionModelsSelector: getBpjsSEPInternalDataCollectionModels,
			};
		case 'BpjsSEPSubmissionModel':
			return {
				baseAction: BpjsSEPSubmissionAction,
				initCollectionAction: BpjsSEPSubmissionModelActionTypes.INITIALISE_BPJS_SEP_SUBMISSION_COLLECTION_STATE,
				fetchAllAction: BpjsSEPSubmissionModelActionTypes.FETCH_ALL_BPJS_SEP_SUBMISSION,
				fetchWithQueryAction: BpjsSEPSubmissionModelActionTypes.FETCH_BPJS_SEP_SUBMISSION_WITH_QUERY,
				fetchWithId: BpjsSEPSubmissionModelActionTypes.FETCH_BPJS_SEP_SUBMISSION,
				collectionModelsSelector: getBpjsSEPSubmissionCollectionModels,
			};
		case 'BpjsSearchControlLetterModel':
			return {
				baseAction: BpjsSearchControlLetterAction,
				initCollectionAction: BpjsSearchControlLetterModelActionTypes.INITIALISE_BPJS_SEARCH_CONTROL_LETTER_COLLECTION_STATE,
				fetchAllAction: BpjsSearchControlLetterModelActionTypes.FETCH_ALL_BPJS_SEARCH_CONTROL_LETTER,
				fetchWithQueryAction: BpjsSearchControlLetterModelActionTypes.FETCH_BPJS_SEARCH_CONTROL_LETTER_WITH_QUERY,
				fetchWithId: BpjsSearchControlLetterModelActionTypes.FETCH_BPJS_SEARCH_CONTROL_LETTER,
				collectionModelsSelector: getBpjsSearchControlLetterCollectionModels,
			};
		case 'BpjsSearchSEPModel':
			return {
				baseAction: BpjsSearchSEPAction,
				initCollectionAction: BpjsSearchSEPModelActionTypes.INITIALISE_BPJS_SEARCH_SEP_COLLECTION_STATE,
				fetchAllAction: BpjsSearchSEPModelActionTypes.FETCH_ALL_BPJS_SEARCH_SEP,
				fetchWithQueryAction: BpjsSearchSEPModelActionTypes.FETCH_BPJS_SEARCH_SEP_WITH_QUERY,
				fetchWithId: BpjsSearchSEPModelActionTypes.FETCH_BPJS_SEARCH_SEP,
				collectionModelsSelector: getBpjsSearchSEPCollectionModels,
			};
		case 'BpjsServiceMappingModel':
			return {
				baseAction: BpjsServiceMappingAction,
				initCollectionAction: BpjsServiceMappingModelActionTypes.INITIALISE_BPJS_SERVICE_MAPPING_COLLECTION_STATE,
				fetchAllAction: BpjsServiceMappingModelActionTypes.FETCH_ALL_BPJS_SERVICE_MAPPING,
				fetchWithQueryAction: BpjsServiceMappingModelActionTypes.FETCH_BPJS_SERVICE_MAPPING_WITH_QUERY,
				fetchWithId: BpjsServiceMappingModelActionTypes.FETCH_BPJS_SERVICE_MAPPING,
				collectionModelsSelector: getBpjsServiceMappingCollectionModels,
			};
		case 'BpjsSpecialReferralModel':
			return {
				baseAction: BpjsSpecialReferralAction,
				initCollectionAction: BpjsSpecialReferralModelActionTypes.INITIALISE_BPJS_SPECIAL_REFERRAL_COLLECTION_STATE,
				fetchAllAction: BpjsSpecialReferralModelActionTypes.FETCH_ALL_BPJS_SPECIAL_REFERRAL,
				fetchWithQueryAction: BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL_WITH_QUERY,
				fetchWithId: BpjsSpecialReferralModelActionTypes.FETCH_BPJS_SPECIAL_REFERRAL,
				collectionModelsSelector: getBpjsSpecialReferralCollectionModels,
			};
		case 'BpjsTotalReferralSEPModel':
			return {
				baseAction: BpjsTotalReferralSEPAction,
				initCollectionAction: BpjsTotalReferralSEPModelActionTypes.INITIALISE_BPJS_TOTAL_REFERRAL_SEP_COLLECTION_STATE,
				fetchAllAction: BpjsTotalReferralSEPModelActionTypes.FETCH_ALL_BPJS_TOTAL_REFERRAL_SEP,
				fetchWithQueryAction: BpjsTotalReferralSEPModelActionTypes.FETCH_BPJS_TOTAL_REFERRAL_SEP_WITH_QUERY,
				fetchWithId: BpjsTotalReferralSEPModelActionTypes.FETCH_BPJS_TOTAL_REFERRAL_SEP,
				collectionModelsSelector: getBpjsTotalReferralSEPCollectionModels,
			};
		case 'BpjsTreatmentClassMappingModel':
			return {
				baseAction: BpjsTreatmentClassMappingAction,
				initCollectionAction: BpjsTreatmentClassMappingModelActionTypes.INITIALISE_BPJS_TREATMENT_CLASS_MAPPING_COLLECTION_STATE,
				fetchAllAction: BpjsTreatmentClassMappingModelActionTypes.FETCH_ALL_BPJS_TREATMENT_CLASS_MAPPING,
				fetchWithQueryAction: BpjsTreatmentClassMappingModelActionTypes.FETCH_BPJS_TREATMENT_CLASS_MAPPING_WITH_QUERY,
				fetchWithId: BpjsTreatmentClassMappingModelActionTypes.FETCH_BPJS_TREATMENT_CLASS_MAPPING,
				collectionModelsSelector: getBpjsTreatmentClassMappingCollectionModels,
			};
		case 'BpjsTreatmentHistoryModel':
			return {
				baseAction: BpjsTreatmentHistoryAction,
				initCollectionAction: BpjsTreatmentHistoryModelActionTypes.INITIALISE_BPJS_TREATMENT_HISTORY_COLLECTION_STATE,
				fetchAllAction: BpjsTreatmentHistoryModelActionTypes.FETCH_ALL_BPJS_TREATMENT_HISTORY,
				fetchWithQueryAction: BpjsTreatmentHistoryModelActionTypes.FETCH_BPJS_TREATMENT_HISTORY_WITH_QUERY,
				fetchWithId: BpjsTreatmentHistoryModelActionTypes.FETCH_BPJS_TREATMENT_HISTORY,
				collectionModelsSelector: getBpjsTreatmentHistoryCollectionModels,
			};
		case 'BpjsTreatmentRoomModel':
			return {
				baseAction: BpjsTreatmentRoomAction,
				initCollectionAction: BpjsTreatmentRoomModelActionTypes.INITIALISE_BPJS_TREATMENT_ROOM_COLLECTION_STATE,
				fetchAllAction: BpjsTreatmentRoomModelActionTypes.FETCH_ALL_BPJS_TREATMENT_ROOM,
				fetchWithQueryAction: BpjsTreatmentRoomModelActionTypes.FETCH_BPJS_TREATMENT_ROOM_WITH_QUERY,
				fetchWithId: BpjsTreatmentRoomModelActionTypes.FETCH_BPJS_TREATMENT_ROOM,
				collectionModelsSelector: getBpjsTreatmentRoomCollectionModels,
			};
		case 'BpjsUpdateDismissalDateModel':
			return {
				baseAction: BpjsUpdateDismissalDateAction,
				initCollectionAction: BpjsUpdateDismissalDateModelActionTypes.INITIALISE_BPJS_UPDATE_DISMISSAL_DATE_COLLECTION_STATE,
				fetchAllAction: BpjsUpdateDismissalDateModelActionTypes.FETCH_ALL_BPJS_UPDATE_DISMISSAL_DATE,
				fetchWithQueryAction: BpjsUpdateDismissalDateModelActionTypes.FETCH_BPJS_UPDATE_DISMISSAL_DATE_WITH_QUERY,
				fetchWithId: BpjsUpdateDismissalDateModelActionTypes.FETCH_BPJS_UPDATE_DISMISSAL_DATE,
				collectionModelsSelector: getBpjsUpdateDismissalDateCollectionModels,
			};
		case 'BpjsVisitDataModel':
			return {
				baseAction: BpjsVisitDataAction,
				initCollectionAction: BpjsVisitDataModelActionTypes.INITIALISE_BPJS_VISIT_DATA_COLLECTION_STATE,
				fetchAllAction: BpjsVisitDataModelActionTypes.FETCH_ALL_BPJS_VISIT_DATA,
				fetchWithQueryAction: BpjsVisitDataModelActionTypes.FETCH_BPJS_VISIT_DATA_WITH_QUERY,
				fetchWithId: BpjsVisitDataModelActionTypes.FETCH_BPJS_VISIT_DATA,
				collectionModelsSelector: getBpjsVisitDataCollectionModels,
			};
		case 'BatchStockBalanceModel':
			return {
				baseAction: BatchStockBalanceAction,
				initCollectionAction: BatchStockBalanceModelActionTypes.INITIALISE_BATCH_STOCK_BALANCE_COLLECTION_STATE,
				fetchAllAction: BatchStockBalanceModelActionTypes.FETCH_ALL_BATCH_STOCK_BALANCE,
				fetchWithQueryAction: BatchStockBalanceModelActionTypes.FETCH_BATCH_STOCK_BALANCE_WITH_QUERY,
				fetchWithId: BatchStockBalanceModelActionTypes.FETCH_BATCH_STOCK_BALANCE,
				collectionModelsSelector: getBatchStockBalanceCollectionModels,
			};
		case 'BatchStockBalancePerDateModel':
			return {
				baseAction: BatchStockBalancePerDateAction,
				initCollectionAction: BatchStockBalancePerDateModelActionTypes.INITIALISE_BATCH_STOCK_BALANCE_PER_DATE_COLLECTION_STATE,
				fetchAllAction: BatchStockBalancePerDateModelActionTypes.FETCH_ALL_BATCH_STOCK_BALANCE_PER_DATE,
				fetchWithQueryAction: BatchStockBalancePerDateModelActionTypes.FETCH_BATCH_STOCK_BALANCE_PER_DATE_WITH_QUERY,
				fetchWithId: BatchStockBalancePerDateModelActionTypes.FETCH_BATCH_STOCK_BALANCE_PER_DATE,
				collectionModelsSelector: getBatchStockBalancePerDateCollectionModels,
			};
		case 'BatchStockTransactionDetailModel':
			return {
				baseAction: BatchStockTransactionDetailAction,
				initCollectionAction: BatchStockTransactionDetailModelActionTypes.INITIALISE_BATCH_STOCK_TRANSACTION_DETAIL_COLLECTION_STATE,
				fetchAllAction: BatchStockTransactionDetailModelActionTypes.FETCH_ALL_BATCH_STOCK_TRANSACTION_DETAIL,
				fetchWithQueryAction: BatchStockTransactionDetailModelActionTypes.FETCH_BATCH_STOCK_TRANSACTION_DETAIL_WITH_QUERY,
				fetchWithId: BatchStockTransactionDetailModelActionTypes.FETCH_BATCH_STOCK_TRANSACTION_DETAIL,
				collectionModelsSelector: getBatchStockTransactionDetailCollectionModels,
			};
		case 'BedFacilityModel':
			return {
				baseAction: BedFacilityAction,
				initCollectionAction: BedFacilityModelActionTypes.INITIALISE_BED_FACILITY_COLLECTION_STATE,
				fetchAllAction: BedFacilityModelActionTypes.FETCH_ALL_BED_FACILITY,
				fetchWithQueryAction: BedFacilityModelActionTypes.FETCH_BED_FACILITY_WITH_QUERY,
				fetchWithId: BedFacilityModelActionTypes.FETCH_BED_FACILITY,
				collectionModelsSelector: getBedFacilityCollectionModels,
			};
		case 'BedReserveModel':
			return {
				baseAction: BedReserveAction,
				initCollectionAction: BedReserveModelActionTypes.INITIALISE_BED_RESERVE_COLLECTION_STATE,
				fetchAllAction: BedReserveModelActionTypes.FETCH_ALL_BED_RESERVE,
				fetchWithQueryAction: BedReserveModelActionTypes.FETCH_BED_RESERVE_WITH_QUERY,
				fetchWithId: BedReserveModelActionTypes.FETCH_BED_RESERVE,
				collectionModelsSelector: getBedReserveCollectionModels,
			};
		case 'BirthHistoryModel':
			return {
				baseAction: BirthHistoryAction,
				initCollectionAction: BirthHistoryModelActionTypes.INITIALISE_BIRTH_HISTORY_COLLECTION_STATE,
				fetchAllAction: BirthHistoryModelActionTypes.FETCH_ALL_BIRTH_HISTORY,
				fetchWithQueryAction: BirthHistoryModelActionTypes.FETCH_BIRTH_HISTORY_WITH_QUERY,
				fetchWithId: BirthHistoryModelActionTypes.FETCH_BIRTH_HISTORY,
				collectionModelsSelector: getBirthHistoryCollectionModels,
			};
		case 'BodyChartExaminationModel':
			return {
				baseAction: BodyChartExaminationAction,
				initCollectionAction: BodyChartExaminationModelActionTypes.INITIALISE_BODY_CHART_EXAMINATION_COLLECTION_STATE,
				fetchAllAction: BodyChartExaminationModelActionTypes.FETCH_ALL_BODY_CHART_EXAMINATION,
				fetchWithQueryAction: BodyChartExaminationModelActionTypes.FETCH_BODY_CHART_EXAMINATION_WITH_QUERY,
				fetchWithId: BodyChartExaminationModelActionTypes.FETCH_BODY_CHART_EXAMINATION,
				collectionModelsSelector: getBodyChartExaminationCollectionModels,
			};
		case 'BpjsPcareKunjunganRujukanModel':
			return {
				baseAction: BpjsPcareKunjunganRujukanAction,
				initCollectionAction: BpjsPcareKunjunganRujukanModelActionTypes.INITIALISE_BPJS_PCARE_KUNJUNGAN_RUJUKAN_COLLECTION_STATE,
				fetchAllAction: BpjsPcareKunjunganRujukanModelActionTypes.FETCH_ALL_BPJS_PCARE_KUNJUNGAN_RUJUKAN,
				fetchWithQueryAction: BpjsPcareKunjunganRujukanModelActionTypes.FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN_WITH_QUERY,
				fetchWithId: BpjsPcareKunjunganRujukanModelActionTypes.FETCH_BPJS_PCARE_KUNJUNGAN_RUJUKAN,
				collectionModelsSelector: getBpjsPcareKunjunganRujukanCollectionModels,
			};
		case 'BpjsPcarePendaftaranModel':
			return {
				baseAction: BpjsPcarePendaftaranAction,
				initCollectionAction: BpjsPcarePendaftaranModelActionTypes.INITIALISE_BPJS_PCARE_PENDAFTARAN_COLLECTION_STATE,
				fetchAllAction: BpjsPcarePendaftaranModelActionTypes.FETCH_ALL_BPJS_PCARE_PENDAFTARAN,
				fetchWithQueryAction: BpjsPcarePendaftaranModelActionTypes.FETCH_BPJS_PCARE_PENDAFTARAN_WITH_QUERY,
				fetchWithId: BpjsPcarePendaftaranModelActionTypes.FETCH_BPJS_PCARE_PENDAFTARAN,
				collectionModelsSelector: getBpjsPcarePendaftaranCollectionModels,
			};
		case 'BpjsPcareRiwayatKunjunganModel':
			return {
				baseAction: BpjsPcareRiwayatKunjunganAction,
				initCollectionAction: BpjsPcareRiwayatKunjunganModelActionTypes.INITIALISE_BPJS_PCARE_RIWAYAT_KUNJUNGAN_COLLECTION_STATE,
				fetchAllAction: BpjsPcareRiwayatKunjunganModelActionTypes.FETCH_ALL_BPJS_PCARE_RIWAYAT_KUNJUNGAN,
				fetchWithQueryAction: BpjsPcareRiwayatKunjunganModelActionTypes.FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN_WITH_QUERY,
				fetchWithId: BpjsPcareRiwayatKunjunganModelActionTypes.FETCH_BPJS_PCARE_RIWAYAT_KUNJUNGAN,
				collectionModelsSelector: getBpjsPcareRiwayatKunjunganCollectionModels,
			};
		case 'CashAllocationModel':
			return {
				baseAction: CashAllocationAction,
				initCollectionAction: CashAllocationModelActionTypes.INITIALISE_CASH_ALLOCATION_COLLECTION_STATE,
				fetchAllAction: CashAllocationModelActionTypes.FETCH_ALL_CASH_ALLOCATION,
				fetchWithQueryAction: CashAllocationModelActionTypes.FETCH_CASH_ALLOCATION_WITH_QUERY,
				fetchWithId: CashAllocationModelActionTypes.FETCH_CASH_ALLOCATION,
				collectionModelsSelector: getCashAllocationCollectionModels,
			};
		case 'CashReceiptModel':
			return {
				baseAction: CashReceiptAction,
				initCollectionAction: CashReceiptModelActionTypes.INITIALISE_CASH_RECEIPT_COLLECTION_STATE,
				fetchAllAction: CashReceiptModelActionTypes.FETCH_ALL_CASH_RECEIPT,
				fetchWithQueryAction: CashReceiptModelActionTypes.FETCH_CASH_RECEIPT_WITH_QUERY,
				fetchWithId: CashReceiptModelActionTypes.FETCH_CASH_RECEIPT,
				collectionModelsSelector: getCashReceiptCollectionModels,
			};
		case 'CashRefundModel':
			return {
				baseAction: CashRefundAction,
				initCollectionAction: CashRefundModelActionTypes.INITIALISE_CASH_REFUND_COLLECTION_STATE,
				fetchAllAction: CashRefundModelActionTypes.FETCH_ALL_CASH_REFUND,
				fetchWithQueryAction: CashRefundModelActionTypes.FETCH_CASH_REFUND_WITH_QUERY,
				fetchWithId: CashRefundModelActionTypes.FETCH_CASH_REFUND,
				collectionModelsSelector: getCashRefundCollectionModels,
			};
		case 'CashierUserModel':
			return {
				baseAction: CashierUserAction,
				initCollectionAction: CashierUserModelActionTypes.INITIALISE_CASHIER_USER_COLLECTION_STATE,
				fetchAllAction: CashierUserModelActionTypes.FETCH_ALL_CASHIER_USER,
				fetchWithQueryAction: CashierUserModelActionTypes.FETCH_CASHIER_USER_WITH_QUERY,
				fetchWithId: CashierUserModelActionTypes.FETCH_CASHIER_USER,
				collectionModelsSelector: getCashierUserCollectionModels,
			};
		case 'CatalogueMedicalModel':
			return {
				baseAction: CatalogueMedicalAction,
				initCollectionAction: CatalogueMedicalModelActionTypes.INITIALISE_CATALOGUE_MEDICAL_COLLECTION_STATE,
				fetchAllAction: CatalogueMedicalModelActionTypes.FETCH_ALL_CATALOGUE_MEDICAL,
				fetchWithQueryAction: CatalogueMedicalModelActionTypes.FETCH_CATALOGUE_MEDICAL_WITH_QUERY,
				fetchWithId: CatalogueMedicalModelActionTypes.FETCH_CATALOGUE_MEDICAL,
				collectionModelsSelector: getCatalogueMedicalCollectionModels,
			};
		case 'CatalogueNonMedicalModel':
			return {
				baseAction: CatalogueNonMedicalAction,
				initCollectionAction: CatalogueNonMedicalModelActionTypes.INITIALISE_CATALOGUE_NON_MEDICAL_COLLECTION_STATE,
				fetchAllAction: CatalogueNonMedicalModelActionTypes.FETCH_ALL_CATALOGUE_NON_MEDICAL,
				fetchWithQueryAction: CatalogueNonMedicalModelActionTypes.FETCH_CATALOGUE_NON_MEDICAL_WITH_QUERY,
				fetchWithId: CatalogueNonMedicalModelActionTypes.FETCH_CATALOGUE_NON_MEDICAL,
				collectionModelsSelector: getCatalogueNonMedicalCollectionModels,
			};
		case 'CatalogueUOMModel':
			return {
				baseAction: CatalogueUOMAction,
				initCollectionAction: CatalogueUOMModelActionTypes.INITIALISE_CATALOGUE_UOM_COLLECTION_STATE,
				fetchAllAction: CatalogueUOMModelActionTypes.FETCH_ALL_CATALOGUE_UOM,
				fetchWithQueryAction: CatalogueUOMModelActionTypes.FETCH_CATALOGUE_UOM_WITH_QUERY,
				fetchWithId: CatalogueUOMModelActionTypes.FETCH_CATALOGUE_UOM,
				collectionModelsSelector: getCatalogueUOMCollectionModels,
			};
		case 'ChartOfAccountModel':
			return {
				baseAction: ChartOfAccountAction,
				initCollectionAction: ChartOfAccountModelActionTypes.INITIALISE_CHART_OF_ACCOUNT_COLLECTION_STATE,
				fetchAllAction: ChartOfAccountModelActionTypes.FETCH_ALL_CHART_OF_ACCOUNT,
				fetchWithQueryAction: ChartOfAccountModelActionTypes.FETCH_CHART_OF_ACCOUNT_WITH_QUERY,
				fetchWithId: ChartOfAccountModelActionTypes.FETCH_CHART_OF_ACCOUNT,
				collectionModelsSelector: getChartOfAccountCollectionModels,
			};
		case 'ChartOfAccountMappingModel':
			return {
				baseAction: ChartOfAccountMappingAction,
				initCollectionAction: ChartOfAccountMappingModelActionTypes.INITIALISE_CHART_OF_ACCOUNT_MAPPING_COLLECTION_STATE,
				fetchAllAction: ChartOfAccountMappingModelActionTypes.FETCH_ALL_CHART_OF_ACCOUNT_MAPPING,
				fetchWithQueryAction: ChartOfAccountMappingModelActionTypes.FETCH_CHART_OF_ACCOUNT_MAPPING_WITH_QUERY,
				fetchWithId: ChartOfAccountMappingModelActionTypes.FETCH_CHART_OF_ACCOUNT_MAPPING,
				collectionModelsSelector: getChartOfAccountMappingCollectionModels,
			};
		case 'ClaimUserModel':
			return {
				baseAction: ClaimUserAction,
				initCollectionAction: ClaimUserModelActionTypes.INITIALISE_CLAIM_USER_COLLECTION_STATE,
				fetchAllAction: ClaimUserModelActionTypes.FETCH_ALL_CLAIM_USER,
				fetchWithQueryAction: ClaimUserModelActionTypes.FETCH_CLAIM_USER_WITH_QUERY,
				fetchWithId: ClaimUserModelActionTypes.FETCH_CLAIM_USER,
				collectionModelsSelector: getClaimUserCollectionModels,
			};
		case 'CoTreatingDoctorModel':
			return {
				baseAction: CoTreatingDoctorAction,
				initCollectionAction: CoTreatingDoctorModelActionTypes.INITIALISE_CO_TREATING_DOCTOR_COLLECTION_STATE,
				fetchAllAction: CoTreatingDoctorModelActionTypes.FETCH_ALL_CO_TREATING_DOCTOR,
				fetchWithQueryAction: CoTreatingDoctorModelActionTypes.FETCH_CO_TREATING_DOCTOR_WITH_QUERY,
				fetchWithId: CoTreatingDoctorModelActionTypes.FETCH_CO_TREATING_DOCTOR,
				collectionModelsSelector: getCoTreatingDoctorCollectionModels,
			};
		case 'CompoundPrescriptionDetailModel':
			return {
				baseAction: CompoundPrescriptionDetailAction,
				initCollectionAction: CompoundPrescriptionDetailModelActionTypes.INITIALISE_COMPOUND_PRESCRIPTION_DETAIL_COLLECTION_STATE,
				fetchAllAction: CompoundPrescriptionDetailModelActionTypes.FETCH_ALL_COMPOUND_PRESCRIPTION_DETAIL,
				fetchWithQueryAction: CompoundPrescriptionDetailModelActionTypes.FETCH_COMPOUND_PRESCRIPTION_DETAIL_WITH_QUERY,
				fetchWithId: CompoundPrescriptionDetailModelActionTypes.FETCH_COMPOUND_PRESCRIPTION_DETAIL,
				collectionModelsSelector: getCompoundPrescriptionDetailCollectionModels,
			};
		case 'CompoundPrescriptionItemModel':
			return {
				baseAction: CompoundPrescriptionItemAction,
				initCollectionAction: CompoundPrescriptionItemModelActionTypes.INITIALISE_COMPOUND_PRESCRIPTION_ITEM_COLLECTION_STATE,
				fetchAllAction: CompoundPrescriptionItemModelActionTypes.FETCH_ALL_COMPOUND_PRESCRIPTION_ITEM,
				fetchWithQueryAction: CompoundPrescriptionItemModelActionTypes.FETCH_COMPOUND_PRESCRIPTION_ITEM_WITH_QUERY,
				fetchWithId: CompoundPrescriptionItemModelActionTypes.FETCH_COMPOUND_PRESCRIPTION_ITEM,
				collectionModelsSelector: getCompoundPrescriptionItemCollectionModels,
			};
		case 'DailyCareCPPTModel':
			return {
				baseAction: DailyCareCPPTAction,
				initCollectionAction: DailyCareCPPTModelActionTypes.INITIALISE_DAILY_CARE_CPPT_COLLECTION_STATE,
				fetchAllAction: DailyCareCPPTModelActionTypes.FETCH_ALL_DAILY_CARE_CPPT,
				fetchWithQueryAction: DailyCareCPPTModelActionTypes.FETCH_DAILY_CARE_CPPT_WITH_QUERY,
				fetchWithId: DailyCareCPPTModelActionTypes.FETCH_DAILY_CARE_CPPT,
				collectionModelsSelector: getDailyCareCPPTCollectionModels,
			};
		case 'DeliveryMedicalExaminationRecordModel':
			return {
				baseAction: DeliveryMedicalExaminationRecordAction,
				initCollectionAction: DeliveryMedicalExaminationRecordModelActionTypes.INITIALISE_DELIVERY_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				fetchAllAction: DeliveryMedicalExaminationRecordModelActionTypes.FETCH_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD,
				fetchWithQueryAction: DeliveryMedicalExaminationRecordModelActionTypes.FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY,
				fetchWithId: DeliveryMedicalExaminationRecordModelActionTypes.FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD,
				collectionModelsSelector: getDeliveryMedicalExaminationRecordCollectionModels,
			};
		case 'DeliveryProgressModel':
			return {
				baseAction: DeliveryProgressAction,
				initCollectionAction: DeliveryProgressModelActionTypes.INITIALISE_DELIVERY_PROGRESS_COLLECTION_STATE,
				fetchAllAction: DeliveryProgressModelActionTypes.FETCH_ALL_DELIVERY_PROGRESS,
				fetchWithQueryAction: DeliveryProgressModelActionTypes.FETCH_DELIVERY_PROGRESS_WITH_QUERY,
				fetchWithId: DeliveryProgressModelActionTypes.FETCH_DELIVERY_PROGRESS,
				collectionModelsSelector: getDeliveryProgressCollectionModels,
			};
		case 'DiagnosesAndProceduresModel':
			return {
				baseAction: DiagnosesAndProceduresAction,
				initCollectionAction: DiagnosesAndProceduresModelActionTypes.INITIALISE_DIAGNOSES_AND_PROCEDURES_COLLECTION_STATE,
				fetchAllAction: DiagnosesAndProceduresModelActionTypes.FETCH_ALL_DIAGNOSES_AND_PROCEDURES,
				fetchWithQueryAction: DiagnosesAndProceduresModelActionTypes.FETCH_DIAGNOSES_AND_PROCEDURES_WITH_QUERY,
				fetchWithId: DiagnosesAndProceduresModelActionTypes.FETCH_DIAGNOSES_AND_PROCEDURES,
				collectionModelsSelector: getDiagnosesAndProceduresCollectionModels,
			};
		case 'DiagnosisExaminationRecordModel':
			return {
				baseAction: DiagnosisExaminationRecordAction,
				initCollectionAction: DiagnosisExaminationRecordModelActionTypes.INITIALISE_DIAGNOSIS_EXAMINATION_RECORD_COLLECTION_STATE,
				fetchAllAction: DiagnosisExaminationRecordModelActionTypes.FETCH_ALL_DIAGNOSIS_EXAMINATION_RECORD,
				fetchWithQueryAction: DiagnosisExaminationRecordModelActionTypes.FETCH_DIAGNOSIS_EXAMINATION_RECORD_WITH_QUERY,
				fetchWithId: DiagnosisExaminationRecordModelActionTypes.FETCH_DIAGNOSIS_EXAMINATION_RECORD,
				collectionModelsSelector: getDiagnosisExaminationRecordCollectionModels,
			};
		case 'DiagnosisNandaModel':
			return {
				baseAction: DiagnosisNandaAction,
				initCollectionAction: DiagnosisNandaModelActionTypes.INITIALISE_DIAGNOSIS_NANDA_COLLECTION_STATE,
				fetchAllAction: DiagnosisNandaModelActionTypes.FETCH_ALL_DIAGNOSIS_NANDA,
				fetchWithQueryAction: DiagnosisNandaModelActionTypes.FETCH_DIAGNOSIS_NANDA_WITH_QUERY,
				fetchWithId: DiagnosisNandaModelActionTypes.FETCH_DIAGNOSIS_NANDA,
				collectionModelsSelector: getDiagnosisNandaCollectionModels,
			};
		case 'DiagnosticExaminationResultsModel':
			return {
				baseAction: DiagnosticExaminationResultsAction,
				initCollectionAction: DiagnosticExaminationResultsModelActionTypes.INITIALISE_DIAGNOSTIC_EXAMINATION_RESULTS_COLLECTION_STATE,
				fetchAllAction: DiagnosticExaminationResultsModelActionTypes.FETCH_ALL_DIAGNOSTIC_EXAMINATION_RESULTS,
				fetchWithQueryAction: DiagnosticExaminationResultsModelActionTypes.FETCH_DIAGNOSTIC_EXAMINATION_RESULTS_WITH_QUERY,
				fetchWithId: DiagnosticExaminationResultsModelActionTypes.FETCH_DIAGNOSTIC_EXAMINATION_RESULTS,
				collectionModelsSelector: getDiagnosticExaminationResultsCollectionModels,
			};
		case 'DiagnosticStaffExaminationSummaryModel':
			return {
				baseAction: DiagnosticStaffExaminationSummaryAction,
				initCollectionAction: DiagnosticStaffExaminationSummaryModelActionTypes.INITIALISE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_COLLECTION_STATE,
				fetchAllAction: DiagnosticStaffExaminationSummaryModelActionTypes.FETCH_ALL_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY,
				fetchWithQueryAction: DiagnosticStaffExaminationSummaryModelActionTypes.FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_WITH_QUERY,
				fetchWithId: DiagnosticStaffExaminationSummaryModelActionTypes.FETCH_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY,
				collectionModelsSelector: getDiagnosticStaffExaminationSummaryCollectionModels,
			};
		case 'DiagnosticSupportGeneralConfigurationModel':
			return {
				baseAction: DiagnosticSupportGeneralConfigurationAction,
				initCollectionAction: DiagnosticSupportGeneralConfigurationModelActionTypes.INITIALISE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_COLLECTION_STATE,
				fetchAllAction: DiagnosticSupportGeneralConfigurationModelActionTypes.FETCH_ALL_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION,
				fetchWithQueryAction: DiagnosticSupportGeneralConfigurationModelActionTypes.FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_WITH_QUERY,
				fetchWithId: DiagnosticSupportGeneralConfigurationModelActionTypes.FETCH_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION,
				collectionModelsSelector: getDiagnosticSupportGeneralConfigurationCollectionModels,
			};
		case 'DiagnosticSupportUserModel':
			return {
				baseAction: DiagnosticSupportUserAction,
				initCollectionAction: DiagnosticSupportUserModelActionTypes.INITIALISE_DIAGNOSTIC_SUPPORT_USER_COLLECTION_STATE,
				fetchAllAction: DiagnosticSupportUserModelActionTypes.FETCH_ALL_DIAGNOSTIC_SUPPORT_USER,
				fetchWithQueryAction: DiagnosticSupportUserModelActionTypes.FETCH_DIAGNOSTIC_SUPPORT_USER_WITH_QUERY,
				fetchWithId: DiagnosticSupportUserModelActionTypes.FETCH_DIAGNOSTIC_SUPPORT_USER,
				collectionModelsSelector: getDiagnosticSupportUserCollectionModels,
			};
		case 'DoctorScheduleModel':
			return {
				baseAction: DoctorScheduleAction,
				initCollectionAction: DoctorScheduleModelActionTypes.INITIALISE_DOCTOR_SCHEDULE_COLLECTION_STATE,
				fetchAllAction: DoctorScheduleModelActionTypes.FETCH_ALL_DOCTOR_SCHEDULE,
				fetchWithQueryAction: DoctorScheduleModelActionTypes.FETCH_DOCTOR_SCHEDULE_WITH_QUERY,
				fetchWithId: DoctorScheduleModelActionTypes.FETCH_DOCTOR_SCHEDULE,
				collectionModelsSelector: getDoctorScheduleCollectionModels,
			};
		case 'DoctorUserModel':
			return {
				baseAction: DoctorUserAction,
				initCollectionAction: DoctorUserModelActionTypes.INITIALISE_DOCTOR_USER_COLLECTION_STATE,
				fetchAllAction: DoctorUserModelActionTypes.FETCH_ALL_DOCTOR_USER,
				fetchWithQueryAction: DoctorUserModelActionTypes.FETCH_DOCTOR_USER_WITH_QUERY,
				fetchWithId: DoctorUserModelActionTypes.FETCH_DOCTOR_USER,
				collectionModelsSelector: getDoctorUserCollectionModels,
			};
		case 'EntExaminationModel':
			return {
				baseAction: EntExaminationAction,
				initCollectionAction: EntExaminationModelActionTypes.INITIALISE_ENT_EXAMINATION_COLLECTION_STATE,
				fetchAllAction: EntExaminationModelActionTypes.FETCH_ALL_ENT_EXAMINATION,
				fetchWithQueryAction: EntExaminationModelActionTypes.FETCH_ENT_EXAMINATION_WITH_QUERY,
				fetchWithId: EntExaminationModelActionTypes.FETCH_ENT_EXAMINATION,
				collectionModelsSelector: getEntExaminationCollectionModels,
			};
		case 'EmergencyMedicalExaminationRecordModel':
			return {
				baseAction: EmergencyMedicalExaminationRecordAction,
				initCollectionAction: EmergencyMedicalExaminationRecordModelActionTypes.INITIALISE_EMERGENCY_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				fetchAllAction: EmergencyMedicalExaminationRecordModelActionTypes.FETCH_ALL_EMERGENCY_MEDICAL_EXAMINATION_RECORD,
				fetchWithQueryAction: EmergencyMedicalExaminationRecordModelActionTypes.FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY,
				fetchWithId: EmergencyMedicalExaminationRecordModelActionTypes.FETCH_EMERGENCY_MEDICAL_EXAMINATION_RECORD,
				collectionModelsSelector: getEmergencyMedicalExaminationRecordCollectionModels,
			};
		case 'ExaminationGroupModel':
			return {
				baseAction: ExaminationGroupAction,
				initCollectionAction: ExaminationGroupModelActionTypes.INITIALISE_EXAMINATION_GROUP_COLLECTION_STATE,
				fetchAllAction: ExaminationGroupModelActionTypes.FETCH_ALL_EXAMINATION_GROUP,
				fetchWithQueryAction: ExaminationGroupModelActionTypes.FETCH_EXAMINATION_GROUP_WITH_QUERY,
				fetchWithId: ExaminationGroupModelActionTypes.FETCH_EXAMINATION_GROUP,
				collectionModelsSelector: getExaminationGroupCollectionModels,
			};
		case 'ExaminationItemModel':
			return {
				baseAction: ExaminationItemAction,
				initCollectionAction: ExaminationItemModelActionTypes.INITIALISE_EXAMINATION_ITEM_COLLECTION_STATE,
				fetchAllAction: ExaminationItemModelActionTypes.FETCH_ALL_EXAMINATION_ITEM,
				fetchWithQueryAction: ExaminationItemModelActionTypes.FETCH_EXAMINATION_ITEM_WITH_QUERY,
				fetchWithId: ExaminationItemModelActionTypes.FETCH_EXAMINATION_ITEM,
				collectionModelsSelector: getExaminationItemCollectionModels,
			};
		case 'ExaminationItemDetailModel':
			return {
				baseAction: ExaminationItemDetailAction,
				initCollectionAction: ExaminationItemDetailModelActionTypes.INITIALISE_EXAMINATION_ITEM_DETAIL_COLLECTION_STATE,
				fetchAllAction: ExaminationItemDetailModelActionTypes.FETCH_ALL_EXAMINATION_ITEM_DETAIL,
				fetchWithQueryAction: ExaminationItemDetailModelActionTypes.FETCH_EXAMINATION_ITEM_DETAIL_WITH_QUERY,
				fetchWithId: ExaminationItemDetailModelActionTypes.FETCH_EXAMINATION_ITEM_DETAIL,
				collectionModelsSelector: getExaminationItemDetailCollectionModels,
			};
		case 'FacilityHistoryModel':
			return {
				baseAction: FacilityHistoryAction,
				initCollectionAction: FacilityHistoryModelActionTypes.INITIALISE_FACILITY_HISTORY_COLLECTION_STATE,
				fetchAllAction: FacilityHistoryModelActionTypes.FETCH_ALL_FACILITY_HISTORY,
				fetchWithQueryAction: FacilityHistoryModelActionTypes.FETCH_FACILITY_HISTORY_WITH_QUERY,
				fetchWithId: FacilityHistoryModelActionTypes.FETCH_FACILITY_HISTORY,
				collectionModelsSelector: getFacilityHistoryCollectionModels,
			};
		case 'FacilityUserModel':
			return {
				baseAction: FacilityUserAction,
				initCollectionAction: FacilityUserModelActionTypes.INITIALISE_FACILITY_USER_COLLECTION_STATE,
				fetchAllAction: FacilityUserModelActionTypes.FETCH_ALL_FACILITY_USER,
				fetchWithQueryAction: FacilityUserModelActionTypes.FETCH_FACILITY_USER_WITH_QUERY,
				fetchWithId: FacilityUserModelActionTypes.FETCH_FACILITY_USER,
				collectionModelsSelector: getFacilityUserCollectionModels,
			};
		case 'FluidBalanceDetailModel':
			return {
				baseAction: FluidBalanceDetailAction,
				initCollectionAction: FluidBalanceDetailModelActionTypes.INITIALISE_FLUID_BALANCE_DETAIL_COLLECTION_STATE,
				fetchAllAction: FluidBalanceDetailModelActionTypes.FETCH_ALL_FLUID_BALANCE_DETAIL,
				fetchWithQueryAction: FluidBalanceDetailModelActionTypes.FETCH_FLUID_BALANCE_DETAIL_WITH_QUERY,
				fetchWithId: FluidBalanceDetailModelActionTypes.FETCH_FLUID_BALANCE_DETAIL,
				collectionModelsSelector: getFluidBalanceDetailCollectionModels,
			};
		case 'FormulirKonselingTesHivModel':
			return {
				baseAction: FormulirKonselingTesHivAction,
				initCollectionAction: FormulirKonselingTesHivModelActionTypes.INITIALISE_FORMULIR_KONSELING_TES_HIV_COLLECTION_STATE,
				fetchAllAction: FormulirKonselingTesHivModelActionTypes.FETCH_ALL_FORMULIR_KONSELING_TES_HIV,
				fetchWithQueryAction: FormulirKonselingTesHivModelActionTypes.FETCH_FORMULIR_KONSELING_TES_HIV_WITH_QUERY,
				fetchWithId: FormulirKonselingTesHivModelActionTypes.FETCH_FORMULIR_KONSELING_TES_HIV,
				collectionModelsSelector: getFormulirKonselingTesHivCollectionModels,
			};
		case 'GoodsReceiveNoteModel':
			return {
				baseAction: GoodsReceiveNoteAction,
				initCollectionAction: GoodsReceiveNoteModelActionTypes.INITIALISE_GOODS_RECEIVE_NOTE_COLLECTION_STATE,
				fetchAllAction: GoodsReceiveNoteModelActionTypes.FETCH_ALL_GOODS_RECEIVE_NOTE,
				fetchWithQueryAction: GoodsReceiveNoteModelActionTypes.FETCH_GOODS_RECEIVE_NOTE_WITH_QUERY,
				fetchWithId: GoodsReceiveNoteModelActionTypes.FETCH_GOODS_RECEIVE_NOTE,
				collectionModelsSelector: getGoodsReceiveNoteCollectionModels,
			};
		case 'GoodsReceiveNoteBatchModel':
			return {
				baseAction: GoodsReceiveNoteBatchAction,
				initCollectionAction: GoodsReceiveNoteBatchModelActionTypes.INITIALISE_GOODS_RECEIVE_NOTE_BATCH_COLLECTION_STATE,
				fetchAllAction: GoodsReceiveNoteBatchModelActionTypes.FETCH_ALL_GOODS_RECEIVE_NOTE_BATCH,
				fetchWithQueryAction: GoodsReceiveNoteBatchModelActionTypes.FETCH_GOODS_RECEIVE_NOTE_BATCH_WITH_QUERY,
				fetchWithId: GoodsReceiveNoteBatchModelActionTypes.FETCH_GOODS_RECEIVE_NOTE_BATCH,
				collectionModelsSelector: getGoodsReceiveNoteBatchCollectionModels,
			};
		case 'GoodsReceiveNoteItemModel':
			return {
				baseAction: GoodsReceiveNoteItemAction,
				initCollectionAction: GoodsReceiveNoteItemModelActionTypes.INITIALISE_GOODS_RECEIVE_NOTE_ITEM_COLLECTION_STATE,
				fetchAllAction: GoodsReceiveNoteItemModelActionTypes.FETCH_ALL_GOODS_RECEIVE_NOTE_ITEM,
				fetchWithQueryAction: GoodsReceiveNoteItemModelActionTypes.FETCH_GOODS_RECEIVE_NOTE_ITEM_WITH_QUERY,
				fetchWithId: GoodsReceiveNoteItemModelActionTypes.FETCH_GOODS_RECEIVE_NOTE_ITEM,
				collectionModelsSelector: getGoodsReceiveNoteItemCollectionModels,
			};
		case 'HealthFacilityModel':
			return {
				baseAction: HealthFacilityAction,
				initCollectionAction: HealthFacilityModelActionTypes.INITIALISE_HEALTH_FACILITY_COLLECTION_STATE,
				fetchAllAction: HealthFacilityModelActionTypes.FETCH_ALL_HEALTH_FACILITY,
				fetchWithQueryAction: HealthFacilityModelActionTypes.FETCH_HEALTH_FACILITY_WITH_QUERY,
				fetchWithId: HealthFacilityModelActionTypes.FETCH_HEALTH_FACILITY,
				collectionModelsSelector: getHealthFacilityCollectionModels,
			};
		case 'HemodialysisExaminationModel':
			return {
				baseAction: HemodialysisExaminationAction,
				initCollectionAction: HemodialysisExaminationModelActionTypes.INITIALISE_HEMODIALYSIS_EXAMINATION_COLLECTION_STATE,
				fetchAllAction: HemodialysisExaminationModelActionTypes.FETCH_ALL_HEMODIALYSIS_EXAMINATION,
				fetchWithQueryAction: HemodialysisExaminationModelActionTypes.FETCH_HEMODIALYSIS_EXAMINATION_WITH_QUERY,
				fetchWithId: HemodialysisExaminationModelActionTypes.FETCH_HEMODIALYSIS_EXAMINATION,
				collectionModelsSelector: getHemodialysisExaminationCollectionModels,
			};
		case 'HemodialysisMonitoringModel':
			return {
				baseAction: HemodialysisMonitoringAction,
				initCollectionAction: HemodialysisMonitoringModelActionTypes.INITIALISE_HEMODIALYSIS_MONITORING_COLLECTION_STATE,
				fetchAllAction: HemodialysisMonitoringModelActionTypes.FETCH_ALL_HEMODIALYSIS_MONITORING,
				fetchWithQueryAction: HemodialysisMonitoringModelActionTypes.FETCH_HEMODIALYSIS_MONITORING_WITH_QUERY,
				fetchWithId: HemodialysisMonitoringModelActionTypes.FETCH_HEMODIALYSIS_MONITORING,
				collectionModelsSelector: getHemodialysisMonitoringCollectionModels,
			};
		case 'HospitalBranchInformationModel':
			return {
				baseAction: HospitalBranchInformationAction,
				initCollectionAction: HospitalBranchInformationModelActionTypes.INITIALISE_HOSPITAL_BRANCH_INFORMATION_COLLECTION_STATE,
				fetchAllAction: HospitalBranchInformationModelActionTypes.FETCH_ALL_HOSPITAL_BRANCH_INFORMATION,
				fetchWithQueryAction: HospitalBranchInformationModelActionTypes.FETCH_HOSPITAL_BRANCH_INFORMATION_WITH_QUERY,
				fetchWithId: HospitalBranchInformationModelActionTypes.FETCH_HOSPITAL_BRANCH_INFORMATION,
				collectionModelsSelector: getHospitalBranchInformationCollectionModels,
			};
		case 'HospitalGroupInformationModel':
			return {
				baseAction: HospitalGroupInformationAction,
				initCollectionAction: HospitalGroupInformationModelActionTypes.INITIALISE_HOSPITAL_GROUP_INFORMATION_COLLECTION_STATE,
				fetchAllAction: HospitalGroupInformationModelActionTypes.FETCH_ALL_HOSPITAL_GROUP_INFORMATION,
				fetchWithQueryAction: HospitalGroupInformationModelActionTypes.FETCH_HOSPITAL_GROUP_INFORMATION_WITH_QUERY,
				fetchWithId: HospitalGroupInformationModelActionTypes.FETCH_HOSPITAL_GROUP_INFORMATION,
				collectionModelsSelector: getHospitalGroupInformationCollectionModels,
			};
		case 'Icd10Model':
			return {
				baseAction: Icd10Action,
				initCollectionAction: Icd10ModelActionTypes.INITIALISE_ICD_10_COLLECTION_STATE,
				fetchAllAction: Icd10ModelActionTypes.FETCH_ALL_ICD_10,
				fetchWithQueryAction: Icd10ModelActionTypes.FETCH_ICD_10_WITH_QUERY,
				fetchWithId: Icd10ModelActionTypes.FETCH_ICD_10,
				collectionModelsSelector: getIcd10CollectionModels,
			};
		case 'Icd9CMModel':
			return {
				baseAction: Icd9CMAction,
				initCollectionAction: Icd9CMModelActionTypes.INITIALISE_ICD_9_CM_COLLECTION_STATE,
				fetchAllAction: Icd9CMModelActionTypes.FETCH_ALL_ICD_9_CM,
				fetchWithQueryAction: Icd9CMModelActionTypes.FETCH_ICD_9_CM_WITH_QUERY,
				fetchWithId: Icd9CMModelActionTypes.FETCH_ICD_9_CM,
				collectionModelsSelector: getIcd9CMCollectionModels,
			};
		case 'InformedConsentModel':
			return {
				baseAction: InformedConsentAction,
				initCollectionAction: InformedConsentModelActionTypes.INITIALISE_INFORMED_CONSENT_COLLECTION_STATE,
				fetchAllAction: InformedConsentModelActionTypes.FETCH_ALL_INFORMED_CONSENT,
				fetchWithQueryAction: InformedConsentModelActionTypes.FETCH_INFORMED_CONSENT_WITH_QUERY,
				fetchWithId: InformedConsentModelActionTypes.FETCH_INFORMED_CONSENT,
				collectionModelsSelector: getInformedConsentCollectionModels,
			};
		case 'InpatientMedicalExaminationRecordModel':
			return {
				baseAction: InpatientMedicalExaminationRecordAction,
				initCollectionAction: InpatientMedicalExaminationRecordModelActionTypes.INITIALISE_INPATIENT_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				fetchAllAction: InpatientMedicalExaminationRecordModelActionTypes.FETCH_ALL_INPATIENT_MEDICAL_EXAMINATION_RECORD,
				fetchWithQueryAction: InpatientMedicalExaminationRecordModelActionTypes.FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD_WITH_QUERY,
				fetchWithId: InpatientMedicalExaminationRecordModelActionTypes.FETCH_INPATIENT_MEDICAL_EXAMINATION_RECORD,
				collectionModelsSelector: getInpatientMedicalExaminationRecordCollectionModels,
			};
		case 'InsuranceBenefitPlanModel':
			return {
				baseAction: InsuranceBenefitPlanAction,
				initCollectionAction: InsuranceBenefitPlanModelActionTypes.INITIALISE_INSURANCE_BENEFIT_PLAN_COLLECTION_STATE,
				fetchAllAction: InsuranceBenefitPlanModelActionTypes.FETCH_ALL_INSURANCE_BENEFIT_PLAN,
				fetchWithQueryAction: InsuranceBenefitPlanModelActionTypes.FETCH_INSURANCE_BENEFIT_PLAN_WITH_QUERY,
				fetchWithId: InsuranceBenefitPlanModelActionTypes.FETCH_INSURANCE_BENEFIT_PLAN,
				collectionModelsSelector: getInsuranceBenefitPlanCollectionModels,
			};
		case 'InsuranceProviderModel':
			return {
				baseAction: InsuranceProviderAction,
				initCollectionAction: InsuranceProviderModelActionTypes.INITIALISE_INSURANCE_PROVIDER_COLLECTION_STATE,
				fetchAllAction: InsuranceProviderModelActionTypes.FETCH_ALL_INSURANCE_PROVIDER,
				fetchWithQueryAction: InsuranceProviderModelActionTypes.FETCH_INSURANCE_PROVIDER_WITH_QUERY,
				fetchWithId: InsuranceProviderModelActionTypes.FETCH_INSURANCE_PROVIDER,
				collectionModelsSelector: getInsuranceProviderCollectionModels,
			};
		case 'InternalOrderModel':
			return {
				baseAction: InternalOrderAction,
				initCollectionAction: InternalOrderModelActionTypes.INITIALISE_INTERNAL_ORDER_COLLECTION_STATE,
				fetchAllAction: InternalOrderModelActionTypes.FETCH_ALL_INTERNAL_ORDER,
				fetchWithQueryAction: InternalOrderModelActionTypes.FETCH_INTERNAL_ORDER_WITH_QUERY,
				fetchWithId: InternalOrderModelActionTypes.FETCH_INTERNAL_ORDER,
				collectionModelsSelector: getInternalOrderCollectionModels,
			};
		case 'InternalOrderStockDetailModel':
			return {
				baseAction: InternalOrderStockDetailAction,
				initCollectionAction: InternalOrderStockDetailModelActionTypes.INITIALISE_INTERNAL_ORDER_STOCK_DETAIL_COLLECTION_STATE,
				fetchAllAction: InternalOrderStockDetailModelActionTypes.FETCH_ALL_INTERNAL_ORDER_STOCK_DETAIL,
				fetchWithQueryAction: InternalOrderStockDetailModelActionTypes.FETCH_INTERNAL_ORDER_STOCK_DETAIL_WITH_QUERY,
				fetchWithId: InternalOrderStockDetailModelActionTypes.FETCH_INTERNAL_ORDER_STOCK_DETAIL,
				collectionModelsSelector: getInternalOrderStockDetailCollectionModels,
			};
		case 'IntraoperativeRecordsModel':
			return {
				baseAction: IntraoperativeRecordsAction,
				initCollectionAction: IntraoperativeRecordsModelActionTypes.INITIALISE_INTRAOPERATIVE_RECORDS_COLLECTION_STATE,
				fetchAllAction: IntraoperativeRecordsModelActionTypes.FETCH_ALL_INTRAOPERATIVE_RECORDS,
				fetchWithQueryAction: IntraoperativeRecordsModelActionTypes.FETCH_INTRAOPERATIVE_RECORDS_WITH_QUERY,
				fetchWithId: IntraoperativeRecordsModelActionTypes.FETCH_INTRAOPERATIVE_RECORDS,
				collectionModelsSelector: getIntraoperativeRecordsCollectionModels,
			};
		case 'InventoryAdjusmentBatchModel':
			return {
				baseAction: InventoryAdjusmentBatchAction,
				initCollectionAction: InventoryAdjusmentBatchModelActionTypes.INITIALISE_INVENTORY_ADJUSMENT_BATCH_COLLECTION_STATE,
				fetchAllAction: InventoryAdjusmentBatchModelActionTypes.FETCH_ALL_INVENTORY_ADJUSMENT_BATCH,
				fetchWithQueryAction: InventoryAdjusmentBatchModelActionTypes.FETCH_INVENTORY_ADJUSMENT_BATCH_WITH_QUERY,
				fetchWithId: InventoryAdjusmentBatchModelActionTypes.FETCH_INVENTORY_ADJUSMENT_BATCH,
				collectionModelsSelector: getInventoryAdjusmentBatchCollectionModels,
			};
		case 'InventoryAdjustmentModel':
			return {
				baseAction: InventoryAdjustmentAction,
				initCollectionAction: InventoryAdjustmentModelActionTypes.INITIALISE_INVENTORY_ADJUSTMENT_COLLECTION_STATE,
				fetchAllAction: InventoryAdjustmentModelActionTypes.FETCH_ALL_INVENTORY_ADJUSTMENT,
				fetchWithQueryAction: InventoryAdjustmentModelActionTypes.FETCH_INVENTORY_ADJUSTMENT_WITH_QUERY,
				fetchWithId: InventoryAdjustmentModelActionTypes.FETCH_INVENTORY_ADJUSTMENT,
				collectionModelsSelector: getInventoryAdjustmentCollectionModels,
			};
		case 'InventoryAdjustmentItemModel':
			return {
				baseAction: InventoryAdjustmentItemAction,
				initCollectionAction: InventoryAdjustmentItemModelActionTypes.INITIALISE_INVENTORY_ADJUSTMENT_ITEM_COLLECTION_STATE,
				fetchAllAction: InventoryAdjustmentItemModelActionTypes.FETCH_ALL_INVENTORY_ADJUSTMENT_ITEM,
				fetchWithQueryAction: InventoryAdjustmentItemModelActionTypes.FETCH_INVENTORY_ADJUSTMENT_ITEM_WITH_QUERY,
				fetchWithId: InventoryAdjustmentItemModelActionTypes.FETCH_INVENTORY_ADJUSTMENT_ITEM,
				collectionModelsSelector: getInventoryAdjustmentItemCollectionModels,
			};
		case 'InventoryBatchCorrectionModel':
			return {
				baseAction: InventoryBatchCorrectionAction,
				initCollectionAction: InventoryBatchCorrectionModelActionTypes.INITIALISE_INVENTORY_BATCH_CORRECTION_COLLECTION_STATE,
				fetchAllAction: InventoryBatchCorrectionModelActionTypes.FETCH_ALL_INVENTORY_BATCH_CORRECTION,
				fetchWithQueryAction: InventoryBatchCorrectionModelActionTypes.FETCH_INVENTORY_BATCH_CORRECTION_WITH_QUERY,
				fetchWithId: InventoryBatchCorrectionModelActionTypes.FETCH_INVENTORY_BATCH_CORRECTION,
				collectionModelsSelector: getInventoryBatchCorrectionCollectionModels,
			};
		case 'InventoryBatchCorrectionItemModel':
			return {
				baseAction: InventoryBatchCorrectionItemAction,
				initCollectionAction: InventoryBatchCorrectionItemModelActionTypes.INITIALISE_INVENTORY_BATCH_CORRECTION_ITEM_COLLECTION_STATE,
				fetchAllAction: InventoryBatchCorrectionItemModelActionTypes.FETCH_ALL_INVENTORY_BATCH_CORRECTION_ITEM,
				fetchWithQueryAction: InventoryBatchCorrectionItemModelActionTypes.FETCH_INVENTORY_BATCH_CORRECTION_ITEM_WITH_QUERY,
				fetchWithId: InventoryBatchCorrectionItemModelActionTypes.FETCH_INVENTORY_BATCH_CORRECTION_ITEM,
				collectionModelsSelector: getInventoryBatchCorrectionItemCollectionModels,
			};
		case 'InvoiceModel':
			return {
				baseAction: InvoiceAction,
				initCollectionAction: InvoiceModelActionTypes.INITIALISE_INVOICE_COLLECTION_STATE,
				fetchAllAction: InvoiceModelActionTypes.FETCH_ALL_INVOICE,
				fetchWithQueryAction: InvoiceModelActionTypes.FETCH_INVOICE_WITH_QUERY,
				fetchWithId: InvoiceModelActionTypes.FETCH_INVOICE,
				collectionModelsSelector: getInvoiceCollectionModels,
			};
		case 'InvoiceItemModel':
			return {
				baseAction: InvoiceItemAction,
				initCollectionAction: InvoiceItemModelActionTypes.INITIALISE_INVOICE_ITEM_COLLECTION_STATE,
				fetchAllAction: InvoiceItemModelActionTypes.FETCH_ALL_INVOICE_ITEM,
				fetchWithQueryAction: InvoiceItemModelActionTypes.FETCH_INVOICE_ITEM_WITH_QUERY,
				fetchWithId: InvoiceItemModelActionTypes.FETCH_INVOICE_ITEM,
				collectionModelsSelector: getInvoiceItemCollectionModels,
			};
		case 'InvoiceItemComponentModel':
			return {
				baseAction: InvoiceItemComponentAction,
				initCollectionAction: InvoiceItemComponentModelActionTypes.INITIALISE_INVOICE_ITEM_COMPONENT_COLLECTION_STATE,
				fetchAllAction: InvoiceItemComponentModelActionTypes.FETCH_ALL_INVOICE_ITEM_COMPONENT,
				fetchWithQueryAction: InvoiceItemComponentModelActionTypes.FETCH_INVOICE_ITEM_COMPONENT_WITH_QUERY,
				fetchWithId: InvoiceItemComponentModelActionTypes.FETCH_INVOICE_ITEM_COMPONENT,
				collectionModelsSelector: getInvoiceItemComponentCollectionModels,
			};
		case 'InvoicePaymentInsuranceModel':
			return {
				baseAction: InvoicePaymentInsuranceAction,
				initCollectionAction: InvoicePaymentInsuranceModelActionTypes.INITIALISE_INVOICE_PAYMENT_INSURANCE_COLLECTION_STATE,
				fetchAllAction: InvoicePaymentInsuranceModelActionTypes.FETCH_ALL_INVOICE_PAYMENT_INSURANCE,
				fetchWithQueryAction: InvoicePaymentInsuranceModelActionTypes.FETCH_INVOICE_PAYMENT_INSURANCE_WITH_QUERY,
				fetchWithId: InvoicePaymentInsuranceModelActionTypes.FETCH_INVOICE_PAYMENT_INSURANCE,
				collectionModelsSelector: getInvoicePaymentInsuranceCollectionModels,
			};
		case 'InvoicePaymentOtherModel':
			return {
				baseAction: InvoicePaymentOtherAction,
				initCollectionAction: InvoicePaymentOtherModelActionTypes.INITIALISE_INVOICE_PAYMENT_OTHER_COLLECTION_STATE,
				fetchAllAction: InvoicePaymentOtherModelActionTypes.FETCH_ALL_INVOICE_PAYMENT_OTHER,
				fetchWithQueryAction: InvoicePaymentOtherModelActionTypes.FETCH_INVOICE_PAYMENT_OTHER_WITH_QUERY,
				fetchWithId: InvoicePaymentOtherModelActionTypes.FETCH_INVOICE_PAYMENT_OTHER,
				collectionModelsSelector: getInvoicePaymentOtherCollectionModels,
			};
		case 'InvoicePaymentSelfPayingModel':
			return {
				baseAction: InvoicePaymentSelfPayingAction,
				initCollectionAction: InvoicePaymentSelfPayingModelActionTypes.INITIALISE_INVOICE_PAYMENT_SELF_PAYING_COLLECTION_STATE,
				fetchAllAction: InvoicePaymentSelfPayingModelActionTypes.FETCH_ALL_INVOICE_PAYMENT_SELF_PAYING,
				fetchWithQueryAction: InvoicePaymentSelfPayingModelActionTypes.FETCH_INVOICE_PAYMENT_SELF_PAYING_WITH_QUERY,
				fetchWithId: InvoicePaymentSelfPayingModelActionTypes.FETCH_INVOICE_PAYMENT_SELF_PAYING,
				collectionModelsSelector: getInvoicePaymentSelfPayingCollectionModels,
			};
		case 'InvoiceSummaryModel':
			return {
				baseAction: InvoiceSummaryAction,
				initCollectionAction: InvoiceSummaryModelActionTypes.INITIALISE_INVOICE_SUMMARY_COLLECTION_STATE,
				fetchAllAction: InvoiceSummaryModelActionTypes.FETCH_ALL_INVOICE_SUMMARY,
				fetchWithQueryAction: InvoiceSummaryModelActionTypes.FETCH_INVOICE_SUMMARY_WITH_QUERY,
				fetchWithId: InvoiceSummaryModelActionTypes.FETCH_INVOICE_SUMMARY,
				collectionModelsSelector: getInvoiceSummaryCollectionModels,
			};
		case 'JournalModel':
			return {
				baseAction: JournalAction,
				initCollectionAction: JournalModelActionTypes.INITIALISE_JOURNAL_COLLECTION_STATE,
				fetchAllAction: JournalModelActionTypes.FETCH_ALL_JOURNAL,
				fetchWithQueryAction: JournalModelActionTypes.FETCH_JOURNAL_WITH_QUERY,
				fetchWithId: JournalModelActionTypes.FETCH_JOURNAL,
				collectionModelsSelector: getJournalCollectionModels,
			};
		case 'LibraryModel':
			return {
				baseAction: LibraryAction,
				initCollectionAction: LibraryModelActionTypes.INITIALISE_LIBRARY_COLLECTION_STATE,
				fetchAllAction: LibraryModelActionTypes.FETCH_ALL_LIBRARY,
				fetchWithQueryAction: LibraryModelActionTypes.FETCH_LIBRARY_WITH_QUERY,
				fetchWithId: LibraryModelActionTypes.FETCH_LIBRARY,
				collectionModelsSelector: getLibraryCollectionModels,
			};
		case 'LocationModel':
			return {
				baseAction: LocationAction,
				initCollectionAction: LocationModelActionTypes.INITIALISE_LOCATION_COLLECTION_STATE,
				fetchAllAction: LocationModelActionTypes.FETCH_ALL_LOCATION,
				fetchWithQueryAction: LocationModelActionTypes.FETCH_LOCATION_WITH_QUERY,
				fetchWithId: LocationModelActionTypes.FETCH_LOCATION,
				collectionModelsSelector: getLocationCollectionModels,
			};
		case 'McuPackageModel':
			return {
				baseAction: McuPackageAction,
				initCollectionAction: McuPackageModelActionTypes.INITIALISE_MCU_PACKAGE_COLLECTION_STATE,
				fetchAllAction: McuPackageModelActionTypes.FETCH_ALL_MCU_PACKAGE,
				fetchWithQueryAction: McuPackageModelActionTypes.FETCH_MCU_PACKAGE_WITH_QUERY,
				fetchWithId: McuPackageModelActionTypes.FETCH_MCU_PACKAGE,
				collectionModelsSelector: getMcuPackageCollectionModels,
			};
		case 'McuPackageItemModel':
			return {
				baseAction: McuPackageItemAction,
				initCollectionAction: McuPackageItemModelActionTypes.INITIALISE_MCU_PACKAGE_ITEM_COLLECTION_STATE,
				fetchAllAction: McuPackageItemModelActionTypes.FETCH_ALL_MCU_PACKAGE_ITEM,
				fetchWithQueryAction: McuPackageItemModelActionTypes.FETCH_MCU_PACKAGE_ITEM_WITH_QUERY,
				fetchWithId: McuPackageItemModelActionTypes.FETCH_MCU_PACKAGE_ITEM,
				collectionModelsSelector: getMcuPackageItemCollectionModels,
			};
		case 'ManagementUserModel':
			return {
				baseAction: ManagementUserAction,
				initCollectionAction: ManagementUserModelActionTypes.INITIALISE_MANAGEMENT_USER_COLLECTION_STATE,
				fetchAllAction: ManagementUserModelActionTypes.FETCH_ALL_MANAGEMENT_USER,
				fetchWithQueryAction: ManagementUserModelActionTypes.FETCH_MANAGEMENT_USER_WITH_QUERY,
				fetchWithId: ManagementUserModelActionTypes.FETCH_MANAGEMENT_USER,
				collectionModelsSelector: getManagementUserCollectionModels,
			};
		case 'MedicalCertificateDischargeResumeModel':
			return {
				baseAction: MedicalCertificateDischargeResumeAction,
				initCollectionAction: MedicalCertificateDischargeResumeModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_COLLECTION_STATE,
				fetchAllAction: MedicalCertificateDischargeResumeModelActionTypes.FETCH_ALL_MEDICAL_CERTIFICATE_DISCHARGE_RESUME,
				fetchWithQueryAction: MedicalCertificateDischargeResumeModelActionTypes.FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_WITH_QUERY,
				fetchWithId: MedicalCertificateDischargeResumeModelActionTypes.FETCH_MEDICAL_CERTIFICATE_DISCHARGE_RESUME,
				collectionModelsSelector: getMedicalCertificateDischargeResumeCollectionModels,
			};
		case 'MedicalCertificateBirthModel':
			return {
				baseAction: MedicalCertificateBirthAction,
				initCollectionAction: MedicalCertificateBirthModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_BIRTH_COLLECTION_STATE,
				fetchAllAction: MedicalCertificateBirthModelActionTypes.FETCH_ALL_MEDICAL_CERTIFICATE_BIRTH,
				fetchWithQueryAction: MedicalCertificateBirthModelActionTypes.FETCH_MEDICAL_CERTIFICATE_BIRTH_WITH_QUERY,
				fetchWithId: MedicalCertificateBirthModelActionTypes.FETCH_MEDICAL_CERTIFICATE_BIRTH,
				collectionModelsSelector: getMedicalCertificateBirthCollectionModels,
			};
		case 'MedicalCertificateHospitalizationModel':
			return {
				baseAction: MedicalCertificateHospitalizationAction,
				initCollectionAction: MedicalCertificateHospitalizationModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_HOSPITALIZATION_COLLECTION_STATE,
				fetchAllAction: MedicalCertificateHospitalizationModelActionTypes.FETCH_ALL_MEDICAL_CERTIFICATE_HOSPITALIZATION,
				fetchWithQueryAction: MedicalCertificateHospitalizationModelActionTypes.FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION_WITH_QUERY,
				fetchWithId: MedicalCertificateHospitalizationModelActionTypes.FETCH_MEDICAL_CERTIFICATE_HOSPITALIZATION,
				collectionModelsSelector: getMedicalCertificateHospitalizationCollectionModels,
			};
		case 'MedicalCertificateMedicalAttendanceModel':
			return {
				baseAction: MedicalCertificateMedicalAttendanceAction,
				initCollectionAction: MedicalCertificateMedicalAttendanceModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_COLLECTION_STATE,
				fetchAllAction: MedicalCertificateMedicalAttendanceModelActionTypes.FETCH_ALL_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE,
				fetchWithQueryAction: MedicalCertificateMedicalAttendanceModelActionTypes.FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_WITH_QUERY,
				fetchWithId: MedicalCertificateMedicalAttendanceModelActionTypes.FETCH_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE,
				collectionModelsSelector: getMedicalCertificateMedicalAttendanceCollectionModels,
			};
		case 'MedicalCertificateMentalHealthModel':
			return {
				baseAction: MedicalCertificateMentalHealthAction,
				initCollectionAction: MedicalCertificateMentalHealthModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_MENTAL_HEALTH_COLLECTION_STATE,
				fetchAllAction: MedicalCertificateMentalHealthModelActionTypes.FETCH_ALL_MEDICAL_CERTIFICATE_MENTAL_HEALTH,
				fetchWithQueryAction: MedicalCertificateMentalHealthModelActionTypes.FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH_WITH_QUERY,
				fetchWithId: MedicalCertificateMentalHealthModelActionTypes.FETCH_MEDICAL_CERTIFICATE_MENTAL_HEALTH,
				collectionModelsSelector: getMedicalCertificateMentalHealthCollectionModels,
			};
		case 'MedicalCertificatePhysicalHealthModel':
			return {
				baseAction: MedicalCertificatePhysicalHealthAction,
				initCollectionAction: MedicalCertificatePhysicalHealthModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_COLLECTION_STATE,
				fetchAllAction: MedicalCertificatePhysicalHealthModelActionTypes.FETCH_ALL_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH,
				fetchWithQueryAction: MedicalCertificatePhysicalHealthModelActionTypes.FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_WITH_QUERY,
				fetchWithId: MedicalCertificatePhysicalHealthModelActionTypes.FETCH_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH,
				collectionModelsSelector: getMedicalCertificatePhysicalHealthCollectionModels,
			};
		case 'MedicalCertificateRestrictedWorkModel':
			return {
				baseAction: MedicalCertificateRestrictedWorkAction,
				initCollectionAction: MedicalCertificateRestrictedWorkModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_RESTRICTED_WORK_COLLECTION_STATE,
				fetchAllAction: MedicalCertificateRestrictedWorkModelActionTypes.FETCH_ALL_MEDICAL_CERTIFICATE_RESTRICTED_WORK,
				fetchWithQueryAction: MedicalCertificateRestrictedWorkModelActionTypes.FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK_WITH_QUERY,
				fetchWithId: MedicalCertificateRestrictedWorkModelActionTypes.FETCH_MEDICAL_CERTIFICATE_RESTRICTED_WORK,
				collectionModelsSelector: getMedicalCertificateRestrictedWorkCollectionModels,
			};
		case 'MedicalCertificateSickLeaveModel':
			return {
				baseAction: MedicalCertificateSickLeaveAction,
				initCollectionAction: MedicalCertificateSickLeaveModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_SICK_LEAVE_COLLECTION_STATE,
				fetchAllAction: MedicalCertificateSickLeaveModelActionTypes.FETCH_ALL_MEDICAL_CERTIFICATE_SICK_LEAVE,
				fetchWithQueryAction: MedicalCertificateSickLeaveModelActionTypes.FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE_WITH_QUERY,
				fetchWithId: MedicalCertificateSickLeaveModelActionTypes.FETCH_MEDICAL_CERTIFICATE_SICK_LEAVE,
				collectionModelsSelector: getMedicalCertificateSickLeaveCollectionModels,
			};
		case 'MedicalExaminationRecordModel':
			return {
				baseAction: MedicalExaminationRecordAction,
				initCollectionAction: MedicalExaminationRecordModelActionTypes.INITIALISE_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				fetchAllAction: MedicalExaminationRecordModelActionTypes.FETCH_ALL_MEDICAL_EXAMINATION_RECORD,
				fetchWithQueryAction: MedicalExaminationRecordModelActionTypes.FETCH_MEDICAL_EXAMINATION_RECORD_WITH_QUERY,
				fetchWithId: MedicalExaminationRecordModelActionTypes.FETCH_MEDICAL_EXAMINATION_RECORD,
				collectionModelsSelector: getMedicalExaminationRecordCollectionModels,
			};
		case 'MedicalExaminationRecordDischargeSummaryModel':
			return {
				baseAction: MedicalExaminationRecordDischargeSummaryAction,
				initCollectionAction: MedicalExaminationRecordDischargeSummaryModelActionTypes.INITIALISE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_COLLECTION_STATE,
				fetchAllAction: MedicalExaminationRecordDischargeSummaryModelActionTypes.FETCH_ALL_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY,
				fetchWithQueryAction: MedicalExaminationRecordDischargeSummaryModelActionTypes.FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_WITH_QUERY,
				fetchWithId: MedicalExaminationRecordDischargeSummaryModelActionTypes.FETCH_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY,
				collectionModelsSelector: getMedicalExaminationRecordDischargeSummaryCollectionModels,
			};
		case 'MedicalFeeModel':
			return {
				baseAction: MedicalFeeAction,
				initCollectionAction: MedicalFeeModelActionTypes.INITIALISE_MEDICAL_FEE_COLLECTION_STATE,
				fetchAllAction: MedicalFeeModelActionTypes.FETCH_ALL_MEDICAL_FEE,
				fetchWithQueryAction: MedicalFeeModelActionTypes.FETCH_MEDICAL_FEE_WITH_QUERY,
				fetchWithId: MedicalFeeModelActionTypes.FETCH_MEDICAL_FEE,
				collectionModelsSelector: getMedicalFeeCollectionModels,
			};
		case 'MedicalFeeItemComponentModel':
			return {
				baseAction: MedicalFeeItemComponentAction,
				initCollectionAction: MedicalFeeItemComponentModelActionTypes.INITIALISE_MEDICAL_FEE_ITEM_COMPONENT_COLLECTION_STATE,
				fetchAllAction: MedicalFeeItemComponentModelActionTypes.FETCH_ALL_MEDICAL_FEE_ITEM_COMPONENT,
				fetchWithQueryAction: MedicalFeeItemComponentModelActionTypes.FETCH_MEDICAL_FEE_ITEM_COMPONENT_WITH_QUERY,
				fetchWithId: MedicalFeeItemComponentModelActionTypes.FETCH_MEDICAL_FEE_ITEM_COMPONENT,
				collectionModelsSelector: getMedicalFeeItemComponentCollectionModels,
			};
		case 'MedicalRecordInitialChecklistModel':
			return {
				baseAction: MedicalRecordInitialChecklistAction,
				initCollectionAction: MedicalRecordInitialChecklistModelActionTypes.INITIALISE_MEDICAL_RECORD_INITIAL_CHECKLIST_COLLECTION_STATE,
				fetchAllAction: MedicalRecordInitialChecklistModelActionTypes.FETCH_ALL_MEDICAL_RECORD_INITIAL_CHECKLIST,
				fetchWithQueryAction: MedicalRecordInitialChecklistModelActionTypes.FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST_WITH_QUERY,
				fetchWithId: MedicalRecordInitialChecklistModelActionTypes.FETCH_MEDICAL_RECORD_INITIAL_CHECKLIST,
				collectionModelsSelector: getMedicalRecordInitialChecklistCollectionModels,
			};
		case 'MedicalRecordNextVerificationChecklistModel':
			return {
				baseAction: MedicalRecordNextVerificationChecklistAction,
				initCollectionAction: MedicalRecordNextVerificationChecklistModelActionTypes.INITIALISE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_COLLECTION_STATE,
				fetchAllAction: MedicalRecordNextVerificationChecklistModelActionTypes.FETCH_ALL_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST,
				fetchWithQueryAction: MedicalRecordNextVerificationChecklistModelActionTypes.FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_WITH_QUERY,
				fetchWithId: MedicalRecordNextVerificationChecklistModelActionTypes.FETCH_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST,
				collectionModelsSelector: getMedicalRecordNextVerificationChecklistCollectionModels,
			};
		case 'MedicalRecordUserModel':
			return {
				baseAction: MedicalRecordUserAction,
				initCollectionAction: MedicalRecordUserModelActionTypes.INITIALISE_MEDICAL_RECORD_USER_COLLECTION_STATE,
				fetchAllAction: MedicalRecordUserModelActionTypes.FETCH_ALL_MEDICAL_RECORD_USER,
				fetchWithQueryAction: MedicalRecordUserModelActionTypes.FETCH_MEDICAL_RECORD_USER_WITH_QUERY,
				fetchWithId: MedicalRecordUserModelActionTypes.FETCH_MEDICAL_RECORD_USER,
				collectionModelsSelector: getMedicalRecordUserCollectionModels,
			};
		case 'MedicalTranscriberUserModel':
			return {
				baseAction: MedicalTranscriberUserAction,
				initCollectionAction: MedicalTranscriberUserModelActionTypes.INITIALISE_MEDICAL_TRANSCRIBER_USER_COLLECTION_STATE,
				fetchAllAction: MedicalTranscriberUserModelActionTypes.FETCH_ALL_MEDICAL_TRANSCRIBER_USER,
				fetchWithQueryAction: MedicalTranscriberUserModelActionTypes.FETCH_MEDICAL_TRANSCRIBER_USER_WITH_QUERY,
				fetchWithId: MedicalTranscriberUserModelActionTypes.FETCH_MEDICAL_TRANSCRIBER_USER,
				collectionModelsSelector: getMedicalTranscriberUserCollectionModels,
			};
		case 'MedicationAdministeredHistoryModel':
			return {
				baseAction: MedicationAdministeredHistoryAction,
				initCollectionAction: MedicationAdministeredHistoryModelActionTypes.INITIALISE_MEDICATION_ADMINISTERED_HISTORY_COLLECTION_STATE,
				fetchAllAction: MedicationAdministeredHistoryModelActionTypes.FETCH_ALL_MEDICATION_ADMINISTERED_HISTORY,
				fetchWithQueryAction: MedicationAdministeredHistoryModelActionTypes.FETCH_MEDICATION_ADMINISTERED_HISTORY_WITH_QUERY,
				fetchWithId: MedicationAdministeredHistoryModelActionTypes.FETCH_MEDICATION_ADMINISTERED_HISTORY,
				collectionModelsSelector: getMedicationAdministeredHistoryCollectionModels,
			};
		case 'MedicationCompoundModel':
			return {
				baseAction: MedicationCompoundAction,
				initCollectionAction: MedicationCompoundModelActionTypes.INITIALISE_MEDICATION_COMPOUND_COLLECTION_STATE,
				fetchAllAction: MedicationCompoundModelActionTypes.FETCH_ALL_MEDICATION_COMPOUND,
				fetchWithQueryAction: MedicationCompoundModelActionTypes.FETCH_MEDICATION_COMPOUND_WITH_QUERY,
				fetchWithId: MedicationCompoundModelActionTypes.FETCH_MEDICATION_COMPOUND,
				collectionModelsSelector: getMedicationCompoundCollectionModels,
			};
		case 'MedicationHeaderModel':
			return {
				baseAction: MedicationHeaderAction,
				initCollectionAction: MedicationHeaderModelActionTypes.INITIALISE_MEDICATION_HEADER_COLLECTION_STATE,
				fetchAllAction: MedicationHeaderModelActionTypes.FETCH_ALL_MEDICATION_HEADER,
				fetchWithQueryAction: MedicationHeaderModelActionTypes.FETCH_MEDICATION_HEADER_WITH_QUERY,
				fetchWithId: MedicationHeaderModelActionTypes.FETCH_MEDICATION_HEADER,
				collectionModelsSelector: getMedicationHeaderCollectionModels,
			};
		case 'MedicationItemModel':
			return {
				baseAction: MedicationItemAction,
				initCollectionAction: MedicationItemModelActionTypes.INITIALISE_MEDICATION_ITEM_COLLECTION_STATE,
				fetchAllAction: MedicationItemModelActionTypes.FETCH_ALL_MEDICATION_ITEM,
				fetchWithQueryAction: MedicationItemModelActionTypes.FETCH_MEDICATION_ITEM_WITH_QUERY,
				fetchWithId: MedicationItemModelActionTypes.FETCH_MEDICATION_ITEM,
				collectionModelsSelector: getMedicationItemCollectionModels,
			};
		case 'MerchantModel':
			return {
				baseAction: MerchantAction,
				initCollectionAction: MerchantModelActionTypes.INITIALISE_MERCHANT_COLLECTION_STATE,
				fetchAllAction: MerchantModelActionTypes.FETCH_ALL_MERCHANT,
				fetchWithQueryAction: MerchantModelActionTypes.FETCH_MERCHANT_WITH_QUERY,
				fetchWithId: MerchantModelActionTypes.FETCH_MERCHANT,
				collectionModelsSelector: getMerchantCollectionModels,
			};
		case 'MerchantSurchargeAndFeeModel':
			return {
				baseAction: MerchantSurchargeAndFeeAction,
				initCollectionAction: MerchantSurchargeAndFeeModelActionTypes.INITIALISE_MERCHANT_SURCHARGE_AND_FEE_COLLECTION_STATE,
				fetchAllAction: MerchantSurchargeAndFeeModelActionTypes.FETCH_ALL_MERCHANT_SURCHARGE_AND_FEE,
				fetchWithQueryAction: MerchantSurchargeAndFeeModelActionTypes.FETCH_MERCHANT_SURCHARGE_AND_FEE_WITH_QUERY,
				fetchWithId: MerchantSurchargeAndFeeModelActionTypes.FETCH_MERCHANT_SURCHARGE_AND_FEE,
				collectionModelsSelector: getMerchantSurchargeAndFeeCollectionModels,
			};
		case 'NhisClaimModel':
			return {
				baseAction: NhisClaimAction,
				initCollectionAction: NhisClaimModelActionTypes.INITIALISE_NHIS_CLAIM_COLLECTION_STATE,
				fetchAllAction: NhisClaimModelActionTypes.FETCH_ALL_NHIS_CLAIM,
				fetchWithQueryAction: NhisClaimModelActionTypes.FETCH_NHIS_CLAIM_WITH_QUERY,
				fetchWithId: NhisClaimModelActionTypes.FETCH_NHIS_CLAIM,
				collectionModelsSelector: getNhisClaimCollectionModels,
			};
		case 'NhisClaimGDRGDetailModel':
			return {
				baseAction: NhisClaimGDRGDetailAction,
				initCollectionAction: NhisClaimGDRGDetailModelActionTypes.INITIALISE_NHIS_CLAIM_GDRG_DETAIL_COLLECTION_STATE,
				fetchAllAction: NhisClaimGDRGDetailModelActionTypes.FETCH_ALL_NHIS_CLAIM_GDRG_DETAIL,
				fetchWithQueryAction: NhisClaimGDRGDetailModelActionTypes.FETCH_NHIS_CLAIM_GDRG_DETAIL_WITH_QUERY,
				fetchWithId: NhisClaimGDRGDetailModelActionTypes.FETCH_NHIS_CLAIM_GDRG_DETAIL,
				collectionModelsSelector: getNhisClaimGDRGDetailCollectionModels,
			};
		case 'NhisClaimInvestigationDetailModel':
			return {
				baseAction: NhisClaimInvestigationDetailAction,
				initCollectionAction: NhisClaimInvestigationDetailModelActionTypes.INITIALISE_NHIS_CLAIM_INVESTIGATION_DETAIL_COLLECTION_STATE,
				fetchAllAction: NhisClaimInvestigationDetailModelActionTypes.FETCH_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL,
				fetchWithQueryAction: NhisClaimInvestigationDetailModelActionTypes.FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_WITH_QUERY,
				fetchWithId: NhisClaimInvestigationDetailModelActionTypes.FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL,
				collectionModelsSelector: getNhisClaimInvestigationDetailCollectionModels,
			};
		case 'NhisGDRGModel':
			return {
				baseAction: NhisGDRGAction,
				initCollectionAction: NhisGDRGModelActionTypes.INITIALISE_NHIS_GDRG_COLLECTION_STATE,
				fetchAllAction: NhisGDRGModelActionTypes.FETCH_ALL_NHIS_GDRG,
				fetchWithQueryAction: NhisGDRGModelActionTypes.FETCH_NHIS_GDRG_WITH_QUERY,
				fetchWithId: NhisGDRGModelActionTypes.FETCH_NHIS_GDRG,
				collectionModelsSelector: getNhisGDRGCollectionModels,
			};
		case 'NhisInvestigationModel':
			return {
				baseAction: NhisInvestigationAction,
				initCollectionAction: NhisInvestigationModelActionTypes.INITIALISE_NHIS_INVESTIGATION_COLLECTION_STATE,
				fetchAllAction: NhisInvestigationModelActionTypes.FETCH_ALL_NHIS_INVESTIGATION,
				fetchWithQueryAction: NhisInvestigationModelActionTypes.FETCH_NHIS_INVESTIGATION_WITH_QUERY,
				fetchWithId: NhisInvestigationModelActionTypes.FETCH_NHIS_INVESTIGATION,
				collectionModelsSelector: getNhisInvestigationCollectionModels,
			};
		case 'NhisMedicineModel':
			return {
				baseAction: NhisMedicineAction,
				initCollectionAction: NhisMedicineModelActionTypes.INITIALISE_NHIS_MEDICINE_COLLECTION_STATE,
				fetchAllAction: NhisMedicineModelActionTypes.FETCH_ALL_NHIS_MEDICINE,
				fetchWithQueryAction: NhisMedicineModelActionTypes.FETCH_NHIS_MEDICINE_WITH_QUERY,
				fetchWithId: NhisMedicineModelActionTypes.FETCH_NHIS_MEDICINE,
				collectionModelsSelector: getNhisMedicineCollectionModels,
			};
		case 'NhisServiceOutcomeModel':
			return {
				baseAction: NhisServiceOutcomeAction,
				initCollectionAction: NhisServiceOutcomeModelActionTypes.INITIALISE_NHIS_SERVICE_OUTCOME_COLLECTION_STATE,
				fetchAllAction: NhisServiceOutcomeModelActionTypes.FETCH_ALL_NHIS_SERVICE_OUTCOME,
				fetchWithQueryAction: NhisServiceOutcomeModelActionTypes.FETCH_NHIS_SERVICE_OUTCOME_WITH_QUERY,
				fetchWithId: NhisServiceOutcomeModelActionTypes.FETCH_NHIS_SERVICE_OUTCOME,
				collectionModelsSelector: getNhisServiceOutcomeCollectionModels,
			};
		case 'NhisSpecialtyAttendedModel':
			return {
				baseAction: NhisSpecialtyAttendedAction,
				initCollectionAction: NhisSpecialtyAttendedModelActionTypes.INITIALISE_NHIS_SPECIALTY_ATTENDED_COLLECTION_STATE,
				fetchAllAction: NhisSpecialtyAttendedModelActionTypes.FETCH_ALL_NHIS_SPECIALTY_ATTENDED,
				fetchWithQueryAction: NhisSpecialtyAttendedModelActionTypes.FETCH_NHIS_SPECIALTY_ATTENDED_WITH_QUERY,
				fetchWithId: NhisSpecialtyAttendedModelActionTypes.FETCH_NHIS_SPECIALTY_ATTENDED,
				collectionModelsSelector: getNhisSpecialtyAttendedCollectionModels,
			};
		case 'NhisTypeOfServiceModel':
			return {
				baseAction: NhisTypeOfServiceAction,
				initCollectionAction: NhisTypeOfServiceModelActionTypes.INITIALISE_NHIS_TYPE_OF_SERVICE_COLLECTION_STATE,
				fetchAllAction: NhisTypeOfServiceModelActionTypes.FETCH_ALL_NHIS_TYPE_OF_SERVICE,
				fetchWithQueryAction: NhisTypeOfServiceModelActionTypes.FETCH_NHIS_TYPE_OF_SERVICE_WITH_QUERY,
				fetchWithId: NhisTypeOfServiceModelActionTypes.FETCH_NHIS_TYPE_OF_SERVICE,
				collectionModelsSelector: getNhisTypeOfServiceCollectionModels,
			};
		case 'NewbornDetailModel':
			return {
				baseAction: NewbornDetailAction,
				initCollectionAction: NewbornDetailModelActionTypes.INITIALISE_NEWBORN_DETAIL_COLLECTION_STATE,
				fetchAllAction: NewbornDetailModelActionTypes.FETCH_ALL_NEWBORN_DETAIL,
				fetchWithQueryAction: NewbornDetailModelActionTypes.FETCH_NEWBORN_DETAIL_WITH_QUERY,
				fetchWithId: NewbornDetailModelActionTypes.FETCH_NEWBORN_DETAIL,
				collectionModelsSelector: getNewbornDetailCollectionModels,
			};
		case 'NumberingSetupModel':
			return {
				baseAction: NumberingSetupAction,
				initCollectionAction: NumberingSetupModelActionTypes.INITIALISE_NUMBERING_SETUP_COLLECTION_STATE,
				fetchAllAction: NumberingSetupModelActionTypes.FETCH_ALL_NUMBERING_SETUP,
				fetchWithQueryAction: NumberingSetupModelActionTypes.FETCH_NUMBERING_SETUP_WITH_QUERY,
				fetchWithId: NumberingSetupModelActionTypes.FETCH_NUMBERING_SETUP,
				collectionModelsSelector: getNumberingSetupCollectionModels,
			};
		case 'NurseUserModel':
			return {
				baseAction: NurseUserAction,
				initCollectionAction: NurseUserModelActionTypes.INITIALISE_NURSE_USER_COLLECTION_STATE,
				fetchAllAction: NurseUserModelActionTypes.FETCH_ALL_NURSE_USER,
				fetchWithQueryAction: NurseUserModelActionTypes.FETCH_NURSE_USER_WITH_QUERY,
				fetchWithId: NurseUserModelActionTypes.FETCH_NURSE_USER,
				collectionModelsSelector: getNurseUserCollectionModels,
			};
		case 'NurseVitalSignMeasurementModel':
			return {
				baseAction: NurseVitalSignMeasurementAction,
				initCollectionAction: NurseVitalSignMeasurementModelActionTypes.INITIALISE_NURSE_VITAL_SIGN_MEASUREMENT_COLLECTION_STATE,
				fetchAllAction: NurseVitalSignMeasurementModelActionTypes.FETCH_ALL_NURSE_VITAL_SIGN_MEASUREMENT,
				fetchWithQueryAction: NurseVitalSignMeasurementModelActionTypes.FETCH_NURSE_VITAL_SIGN_MEASUREMENT_WITH_QUERY,
				fetchWithId: NurseVitalSignMeasurementModelActionTypes.FETCH_NURSE_VITAL_SIGN_MEASUREMENT,
				collectionModelsSelector: getNurseVitalSignMeasurementCollectionModels,
			};
		case 'ObstetricAndGynecologyHistoryModel':
			return {
				baseAction: ObstetricAndGynecologyHistoryAction,
				initCollectionAction: ObstetricAndGynecologyHistoryModelActionTypes.INITIALISE_OBSTETRIC_AND_GYNECOLOGY_HISTORY_COLLECTION_STATE,
				fetchAllAction: ObstetricAndGynecologyHistoryModelActionTypes.FETCH_ALL_OBSTETRIC_AND_GYNECOLOGY_HISTORY,
				fetchWithQueryAction: ObstetricAndGynecologyHistoryModelActionTypes.FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY_WITH_QUERY,
				fetchWithId: ObstetricAndGynecologyHistoryModelActionTypes.FETCH_OBSTETRIC_AND_GYNECOLOGY_HISTORY,
				collectionModelsSelector: getObstetricAndGynecologyHistoryCollectionModels,
			};
		case 'OdontogramExaminationModel':
			return {
				baseAction: OdontogramExaminationAction,
				initCollectionAction: OdontogramExaminationModelActionTypes.INITIALISE_ODONTOGRAM_EXAMINATION_COLLECTION_STATE,
				fetchAllAction: OdontogramExaminationModelActionTypes.FETCH_ALL_ODONTOGRAM_EXAMINATION,
				fetchWithQueryAction: OdontogramExaminationModelActionTypes.FETCH_ODONTOGRAM_EXAMINATION_WITH_QUERY,
				fetchWithId: OdontogramExaminationModelActionTypes.FETCH_ODONTOGRAM_EXAMINATION,
				collectionModelsSelector: getOdontogramExaminationCollectionModels,
			};
		case 'OperatingTheaterMedicalExaminationRecordModel':
			return {
				baseAction: OperatingTheaterMedicalExaminationRecordAction,
				initCollectionAction: OperatingTheaterMedicalExaminationRecordModelActionTypes.INITIALISE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE,
				fetchAllAction: OperatingTheaterMedicalExaminationRecordModelActionTypes.FETCH_ALL_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD,
				fetchWithQueryAction: OperatingTheaterMedicalExaminationRecordModelActionTypes.FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_WITH_QUERY,
				fetchWithId: OperatingTheaterMedicalExaminationRecordModelActionTypes.FETCH_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD,
				collectionModelsSelector: getOperatingTheaterMedicalExaminationRecordCollectionModels,
			};
		case 'OphthalmologyExaminationModel':
			return {
				baseAction: OphthalmologyExaminationAction,
				initCollectionAction: OphthalmologyExaminationModelActionTypes.INITIALISE_OPHTHALMOLOGY_EXAMINATION_COLLECTION_STATE,
				fetchAllAction: OphthalmologyExaminationModelActionTypes.FETCH_ALL_OPHTHALMOLOGY_EXAMINATION,
				fetchWithQueryAction: OphthalmologyExaminationModelActionTypes.FETCH_OPHTHALMOLOGY_EXAMINATION_WITH_QUERY,
				fetchWithId: OphthalmologyExaminationModelActionTypes.FETCH_OPHTHALMOLOGY_EXAMINATION,
				collectionModelsSelector: getOphthalmologyExaminationCollectionModels,
			};
		case 'PcareActionExaminationModel':
			return {
				baseAction: PcareActionExaminationAction,
				initCollectionAction: PcareActionExaminationModelActionTypes.INITIALISE_PCARE_ACTION_EXAMINATION_COLLECTION_STATE,
				fetchAllAction: PcareActionExaminationModelActionTypes.FETCH_ALL_PCARE_ACTION_EXAMINATION,
				fetchWithQueryAction: PcareActionExaminationModelActionTypes.FETCH_PCARE_ACTION_EXAMINATION_WITH_QUERY,
				fetchWithId: PcareActionExaminationModelActionTypes.FETCH_PCARE_ACTION_EXAMINATION,
				collectionModelsSelector: getPcareActionExaminationCollectionModels,
			};
		case 'PcareClubProlanisModel':
			return {
				baseAction: PcareClubProlanisAction,
				initCollectionAction: PcareClubProlanisModelActionTypes.INITIALISE_PCARE_CLUB_PROLANIS_COLLECTION_STATE,
				fetchAllAction: PcareClubProlanisModelActionTypes.FETCH_ALL_PCARE_CLUB_PROLANIS,
				fetchWithQueryAction: PcareClubProlanisModelActionTypes.FETCH_PCARE_CLUB_PROLANIS_WITH_QUERY,
				fetchWithId: PcareClubProlanisModelActionTypes.FETCH_PCARE_CLUB_PROLANIS,
				collectionModelsSelector: getPcareClubProlanisCollectionModels,
			};
		case 'PcareCompoundDrugModel':
			return {
				baseAction: PcareCompoundDrugAction,
				initCollectionAction: PcareCompoundDrugModelActionTypes.INITIALISE_PCARE_COMPOUND_DRUG_COLLECTION_STATE,
				fetchAllAction: PcareCompoundDrugModelActionTypes.FETCH_ALL_PCARE_COMPOUND_DRUG,
				fetchWithQueryAction: PcareCompoundDrugModelActionTypes.FETCH_PCARE_COMPOUND_DRUG_WITH_QUERY,
				fetchWithId: PcareCompoundDrugModelActionTypes.FETCH_PCARE_COMPOUND_DRUG,
				collectionModelsSelector: getPcareCompoundDrugCollectionModels,
			};
		case 'PcareCompoundDrugItemModel':
			return {
				baseAction: PcareCompoundDrugItemAction,
				initCollectionAction: PcareCompoundDrugItemModelActionTypes.INITIALISE_PCARE_COMPOUND_DRUG_ITEM_COLLECTION_STATE,
				fetchAllAction: PcareCompoundDrugItemModelActionTypes.FETCH_ALL_PCARE_COMPOUND_DRUG_ITEM,
				fetchWithQueryAction: PcareCompoundDrugItemModelActionTypes.FETCH_PCARE_COMPOUND_DRUG_ITEM_WITH_QUERY,
				fetchWithId: PcareCompoundDrugItemModelActionTypes.FETCH_PCARE_COMPOUND_DRUG_ITEM,
				collectionModelsSelector: getPcareCompoundDrugItemCollectionModels,
			};
		case 'PcareDiagnosaModel':
			return {
				baseAction: PcareDiagnosaAction,
				initCollectionAction: PcareDiagnosaModelActionTypes.INITIALISE_PCARE_DIAGNOSA_COLLECTION_STATE,
				fetchAllAction: PcareDiagnosaModelActionTypes.FETCH_ALL_PCARE_DIAGNOSA,
				fetchWithQueryAction: PcareDiagnosaModelActionTypes.FETCH_PCARE_DIAGNOSA_WITH_QUERY,
				fetchWithId: PcareDiagnosaModelActionTypes.FETCH_PCARE_DIAGNOSA,
				collectionModelsSelector: getPcareDiagnosaCollectionModels,
			};
		case 'PcareDokterModel':
			return {
				baseAction: PcareDokterAction,
				initCollectionAction: PcareDokterModelActionTypes.INITIALISE_PCARE_DOKTER_COLLECTION_STATE,
				fetchAllAction: PcareDokterModelActionTypes.FETCH_ALL_PCARE_DOKTER,
				fetchWithQueryAction: PcareDokterModelActionTypes.FETCH_PCARE_DOKTER_WITH_QUERY,
				fetchWithId: PcareDokterModelActionTypes.FETCH_PCARE_DOKTER,
				collectionModelsSelector: getPcareDokterCollectionModels,
			};
		case 'PcareExaminationModel':
			return {
				baseAction: PcareExaminationAction,
				initCollectionAction: PcareExaminationModelActionTypes.INITIALISE_PCARE_EXAMINATION_COLLECTION_STATE,
				fetchAllAction: PcareExaminationModelActionTypes.FETCH_ALL_PCARE_EXAMINATION,
				fetchWithQueryAction: PcareExaminationModelActionTypes.FETCH_PCARE_EXAMINATION_WITH_QUERY,
				fetchWithId: PcareExaminationModelActionTypes.FETCH_PCARE_EXAMINATION,
				collectionModelsSelector: getPcareExaminationCollectionModels,
			};
		case 'PcareMCUModel':
			return {
				baseAction: PcareMCUAction,
				initCollectionAction: PcareMCUModelActionTypes.INITIALISE_PCARE_MCU_COLLECTION_STATE,
				fetchAllAction: PcareMCUModelActionTypes.FETCH_ALL_PCARE_MCU,
				fetchWithQueryAction: PcareMCUModelActionTypes.FETCH_PCARE_MCU_WITH_QUERY,
				fetchWithId: PcareMCUModelActionTypes.FETCH_PCARE_MCU,
				collectionModelsSelector: getPcareMCUCollectionModels,
			};
		case 'PcareNonCompoundDrugModel':
			return {
				baseAction: PcareNonCompoundDrugAction,
				initCollectionAction: PcareNonCompoundDrugModelActionTypes.INITIALISE_PCARE_NONCOMPOUND_DRUG_COLLECTION_STATE,
				fetchAllAction: PcareNonCompoundDrugModelActionTypes.FETCH_ALL_PCARE_NONCOMPOUND_DRUG,
				fetchWithQueryAction: PcareNonCompoundDrugModelActionTypes.FETCH_PCARE_NONCOMPOUND_DRUG_WITH_QUERY,
				fetchWithId: PcareNonCompoundDrugModelActionTypes.FETCH_PCARE_NONCOMPOUND_DRUG,
				collectionModelsSelector: getPcareNonCompoundDrugCollectionModels,
			};
		case 'PcareReferensiSaranaModel':
			return {
				baseAction: PcareReferensiSaranaAction,
				initCollectionAction: PcareReferensiSaranaModelActionTypes.INITIALISE_PCARE_REFERENSI_SARANA_COLLECTION_STATE,
				fetchAllAction: PcareReferensiSaranaModelActionTypes.FETCH_ALL_PCARE_REFERENSI_SARANA,
				fetchWithQueryAction: PcareReferensiSaranaModelActionTypes.FETCH_PCARE_REFERENSI_SARANA_WITH_QUERY,
				fetchWithId: PcareReferensiSaranaModelActionTypes.FETCH_PCARE_REFERENSI_SARANA,
				collectionModelsSelector: getPcareReferensiSaranaCollectionModels,
			};
		case 'PcareStatusPulangModel':
			return {
				baseAction: PcareStatusPulangAction,
				initCollectionAction: PcareStatusPulangModelActionTypes.INITIALISE_PCARE_STATUS_PULANG_COLLECTION_STATE,
				fetchAllAction: PcareStatusPulangModelActionTypes.FETCH_ALL_PCARE_STATUS_PULANG,
				fetchWithQueryAction: PcareStatusPulangModelActionTypes.FETCH_PCARE_STATUS_PULANG_WITH_QUERY,
				fetchWithId: PcareStatusPulangModelActionTypes.FETCH_PCARE_STATUS_PULANG,
				collectionModelsSelector: getPcareStatusPulangCollectionModels,
			};
		case 'PcareTindakanModel':
			return {
				baseAction: PcareTindakanAction,
				initCollectionAction: PcareTindakanModelActionTypes.INITIALISE_PCARE_TINDAKAN_COLLECTION_STATE,
				fetchAllAction: PcareTindakanModelActionTypes.FETCH_ALL_PCARE_TINDAKAN,
				fetchWithQueryAction: PcareTindakanModelActionTypes.FETCH_PCARE_TINDAKAN_WITH_QUERY,
				fetchWithId: PcareTindakanModelActionTypes.FETCH_PCARE_TINDAKAN,
				collectionModelsSelector: getPcareTindakanCollectionModels,
			};
		case 'PcareUmumModel':
			return {
				baseAction: PcareUmumAction,
				initCollectionAction: PcareUmumModelActionTypes.INITIALISE_PCARE_UMUM_COLLECTION_STATE,
				fetchAllAction: PcareUmumModelActionTypes.FETCH_ALL_PCARE_UMUM,
				fetchWithQueryAction: PcareUmumModelActionTypes.FETCH_PCARE_UMUM_WITH_QUERY,
				fetchWithId: PcareUmumModelActionTypes.FETCH_PCARE_UMUM,
				collectionModelsSelector: getPcareUmumCollectionModels,
			};
		case 'PatientCaseHistoryModel':
			return {
				baseAction: PatientCaseHistoryAction,
				initCollectionAction: PatientCaseHistoryModelActionTypes.INITIALISE_PATIENT_CASE_HISTORY_COLLECTION_STATE,
				fetchAllAction: PatientCaseHistoryModelActionTypes.FETCH_ALL_PATIENT_CASE_HISTORY,
				fetchWithQueryAction: PatientCaseHistoryModelActionTypes.FETCH_PATIENT_CASE_HISTORY_WITH_QUERY,
				fetchWithId: PatientCaseHistoryModelActionTypes.FETCH_PATIENT_CASE_HISTORY,
				collectionModelsSelector: getPatientCaseHistoryCollectionModels,
			};
		case 'PatientConsentModel':
			return {
				baseAction: PatientConsentAction,
				initCollectionAction: PatientConsentModelActionTypes.INITIALISE_PATIENT_CONSENT_COLLECTION_STATE,
				fetchAllAction: PatientConsentModelActionTypes.FETCH_ALL_PATIENT_CONSENT,
				fetchWithQueryAction: PatientConsentModelActionTypes.FETCH_PATIENT_CONSENT_WITH_QUERY,
				fetchWithId: PatientConsentModelActionTypes.FETCH_PATIENT_CONSENT,
				collectionModelsSelector: getPatientConsentCollectionModels,
			};
		case 'PatientContactInfoModel':
			return {
				baseAction: PatientContactInfoAction,
				initCollectionAction: PatientContactInfoModelActionTypes.INITIALISE_PATIENT_CONTACT_INFO_COLLECTION_STATE,
				fetchAllAction: PatientContactInfoModelActionTypes.FETCH_ALL_PATIENT_CONTACT_INFO,
				fetchWithQueryAction: PatientContactInfoModelActionTypes.FETCH_PATIENT_CONTACT_INFO_WITH_QUERY,
				fetchWithId: PatientContactInfoModelActionTypes.FETCH_PATIENT_CONTACT_INFO,
				collectionModelsSelector: getPatientContactInfoCollectionModels,
			};
		case 'PatientDetailModel':
			return {
				baseAction: PatientDetailAction,
				initCollectionAction: PatientDetailModelActionTypes.INITIALISE_PATIENT_DETAIL_COLLECTION_STATE,
				fetchAllAction: PatientDetailModelActionTypes.FETCH_ALL_PATIENT_DETAIL,
				fetchWithQueryAction: PatientDetailModelActionTypes.FETCH_PATIENT_DETAIL_WITH_QUERY,
				fetchWithId: PatientDetailModelActionTypes.FETCH_PATIENT_DETAIL,
				collectionModelsSelector: getPatientDetailCollectionModels,
			};
		case 'PatientDetailAddressModel':
			return {
				baseAction: PatientDetailAddressAction,
				initCollectionAction: PatientDetailAddressModelActionTypes.INITIALISE_PATIENT_DETAIL_ADDRESS_COLLECTION_STATE,
				fetchAllAction: PatientDetailAddressModelActionTypes.FETCH_ALL_PATIENT_DETAIL_ADDRESS,
				fetchWithQueryAction: PatientDetailAddressModelActionTypes.FETCH_PATIENT_DETAIL_ADDRESS_WITH_QUERY,
				fetchWithId: PatientDetailAddressModelActionTypes.FETCH_PATIENT_DETAIL_ADDRESS,
				collectionModelsSelector: getPatientDetailAddressCollectionModels,
			};
		case 'PatientEmergencyContactDetailModel':
			return {
				baseAction: PatientEmergencyContactDetailAction,
				initCollectionAction: PatientEmergencyContactDetailModelActionTypes.INITIALISE_PATIENT_EMERGENCY_CONTACT_DETAIL_COLLECTION_STATE,
				fetchAllAction: PatientEmergencyContactDetailModelActionTypes.FETCH_ALL_PATIENT_EMERGENCY_CONTACT_DETAIL,
				fetchWithQueryAction: PatientEmergencyContactDetailModelActionTypes.FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL_WITH_QUERY,
				fetchWithId: PatientEmergencyContactDetailModelActionTypes.FETCH_PATIENT_EMERGENCY_CONTACT_DETAIL,
				collectionModelsSelector: getPatientEmergencyContactDetailCollectionModels,
			};
		case 'PatientEmploymentDetailModel':
			return {
				baseAction: PatientEmploymentDetailAction,
				initCollectionAction: PatientEmploymentDetailModelActionTypes.INITIALISE_PATIENT_EMPLOYMENT_DETAIL_COLLECTION_STATE,
				fetchAllAction: PatientEmploymentDetailModelActionTypes.FETCH_ALL_PATIENT_EMPLOYMENT_DETAIL,
				fetchWithQueryAction: PatientEmploymentDetailModelActionTypes.FETCH_PATIENT_EMPLOYMENT_DETAIL_WITH_QUERY,
				fetchWithId: PatientEmploymentDetailModelActionTypes.FETCH_PATIENT_EMPLOYMENT_DETAIL,
				collectionModelsSelector: getPatientEmploymentDetailCollectionModels,
			};
		case 'PatientGeneralInfoModel':
			return {
				baseAction: PatientGeneralInfoAction,
				initCollectionAction: PatientGeneralInfoModelActionTypes.INITIALISE_PATIENT_GENERAL_INFO_COLLECTION_STATE,
				fetchAllAction: PatientGeneralInfoModelActionTypes.FETCH_ALL_PATIENT_GENERAL_INFO,
				fetchWithQueryAction: PatientGeneralInfoModelActionTypes.FETCH_PATIENT_GENERAL_INFO_WITH_QUERY,
				fetchWithId: PatientGeneralInfoModelActionTypes.FETCH_PATIENT_GENERAL_INFO,
				collectionModelsSelector: getPatientGeneralInfoCollectionModels,
			};
		case 'PatientPaymentSelfPayingModel':
			return {
				baseAction: PatientPaymentSelfPayingAction,
				initCollectionAction: PatientPaymentSelfPayingModelActionTypes.INITIALISE_PATIENT_PAYMENT_SELF_PAYING_COLLECTION_STATE,
				fetchAllAction: PatientPaymentSelfPayingModelActionTypes.FETCH_ALL_PATIENT_PAYMENT_SELF_PAYING,
				fetchWithQueryAction: PatientPaymentSelfPayingModelActionTypes.FETCH_PATIENT_PAYMENT_SELF_PAYING_WITH_QUERY,
				fetchWithId: PatientPaymentSelfPayingModelActionTypes.FETCH_PATIENT_PAYMENT_SELF_PAYING,
				collectionModelsSelector: getPatientPaymentSelfPayingCollectionModels,
			};
		case 'PatientPaymentBPJSModel':
			return {
				baseAction: PatientPaymentBPJSAction,
				initCollectionAction: PatientPaymentBPJSModelActionTypes.INITIALISE_PATIENT_PAYMENT_BPJS_COLLECTION_STATE,
				fetchAllAction: PatientPaymentBPJSModelActionTypes.FETCH_ALL_PATIENT_PAYMENT_BPJS,
				fetchWithQueryAction: PatientPaymentBPJSModelActionTypes.FETCH_PATIENT_PAYMENT_BPJS_WITH_QUERY,
				fetchWithId: PatientPaymentBPJSModelActionTypes.FETCH_PATIENT_PAYMENT_BPJS,
				collectionModelsSelector: getPatientPaymentBPJSCollectionModels,
			};
		case 'PatientPaymentInsuranceModel':
			return {
				baseAction: PatientPaymentInsuranceAction,
				initCollectionAction: PatientPaymentInsuranceModelActionTypes.INITIALISE_PATIENT_PAYMENT_INSURANCE_COLLECTION_STATE,
				fetchAllAction: PatientPaymentInsuranceModelActionTypes.FETCH_ALL_PATIENT_PAYMENT_INSURANCE,
				fetchWithQueryAction: PatientPaymentInsuranceModelActionTypes.FETCH_PATIENT_PAYMENT_INSURANCE_WITH_QUERY,
				fetchWithId: PatientPaymentInsuranceModelActionTypes.FETCH_PATIENT_PAYMENT_INSURANCE,
				collectionModelsSelector: getPatientPaymentInsuranceCollectionModels,
			};
		case 'PatientPaymentOthersModel':
			return {
				baseAction: PatientPaymentOthersAction,
				initCollectionAction: PatientPaymentOthersModelActionTypes.INITIALISE_PATIENT_PAYMENT_OTHERS_COLLECTION_STATE,
				fetchAllAction: PatientPaymentOthersModelActionTypes.FETCH_ALL_PATIENT_PAYMENT_OTHERS,
				fetchWithQueryAction: PatientPaymentOthersModelActionTypes.FETCH_PATIENT_PAYMENT_OTHERS_WITH_QUERY,
				fetchWithId: PatientPaymentOthersModelActionTypes.FETCH_PATIENT_PAYMENT_OTHERS,
				collectionModelsSelector: getPatientPaymentOthersCollectionModels,
			};
		case 'PatientPersonalInfoModel':
			return {
				baseAction: PatientPersonalInfoAction,
				initCollectionAction: PatientPersonalInfoModelActionTypes.INITIALISE_PATIENT_PERSONAL_INFO_COLLECTION_STATE,
				fetchAllAction: PatientPersonalInfoModelActionTypes.FETCH_ALL_PATIENT_PERSONAL_INFO,
				fetchWithQueryAction: PatientPersonalInfoModelActionTypes.FETCH_PATIENT_PERSONAL_INFO_WITH_QUERY,
				fetchWithId: PatientPersonalInfoModelActionTypes.FETCH_PATIENT_PERSONAL_INFO,
				collectionModelsSelector: getPatientPersonalInfoCollectionModels,
			};
		case 'PatientSupportingDocumentModel':
			return {
				baseAction: PatientSupportingDocumentAction,
				initCollectionAction: PatientSupportingDocumentModelActionTypes.INITIALISE_PATIENT_SUPPORTING_DOCUMENT_COLLECTION_STATE,
				fetchAllAction: PatientSupportingDocumentModelActionTypes.FETCH_ALL_PATIENT_SUPPORTING_DOCUMENT,
				fetchWithQueryAction: PatientSupportingDocumentModelActionTypes.FETCH_PATIENT_SUPPORTING_DOCUMENT_WITH_QUERY,
				fetchWithId: PatientSupportingDocumentModelActionTypes.FETCH_PATIENT_SUPPORTING_DOCUMENT,
				collectionModelsSelector: getPatientSupportingDocumentCollectionModels,
			};
		case 'PatientVisitModel':
			return {
				baseAction: PatientVisitAction,
				initCollectionAction: PatientVisitModelActionTypes.INITIALISE_PATIENT_VISIT_COLLECTION_STATE,
				fetchAllAction: PatientVisitModelActionTypes.FETCH_ALL_PATIENT_VISIT,
				fetchWithQueryAction: PatientVisitModelActionTypes.FETCH_PATIENT_VISIT_WITH_QUERY,
				fetchWithId: PatientVisitModelActionTypes.FETCH_PATIENT_VISIT,
				collectionModelsSelector: getPatientVisitCollectionModels,
			};
		case 'PatientVisitPatientPaymentInsuranceModel':
			return {
				baseAction: PatientVisitPatientPaymentInsuranceAction,
				initCollectionAction: PatientVisitPatientPaymentInsuranceModelActionTypes.INITIALISE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_COLLECTION_STATE,
				fetchAllAction: PatientVisitPatientPaymentInsuranceModelActionTypes.FETCH_ALL_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE,
				fetchWithQueryAction: PatientVisitPatientPaymentInsuranceModelActionTypes.FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_WITH_QUERY,
				fetchWithId: PatientVisitPatientPaymentInsuranceModelActionTypes.FETCH_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE,
				collectionModelsSelector: getPatientVisitPatientPaymentInsuranceCollectionModels,
			};
		case 'PatientVisitPatientPaymentOthersModel':
			return {
				baseAction: PatientVisitPatientPaymentOthersAction,
				initCollectionAction: PatientVisitPatientPaymentOthersModelActionTypes.INITIALISE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_COLLECTION_STATE,
				fetchAllAction: PatientVisitPatientPaymentOthersModelActionTypes.FETCH_ALL_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS,
				fetchWithQueryAction: PatientVisitPatientPaymentOthersModelActionTypes.FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_WITH_QUERY,
				fetchWithId: PatientVisitPatientPaymentOthersModelActionTypes.FETCH_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS,
				collectionModelsSelector: getPatientVisitPatientPaymentOthersCollectionModels,
			};
		case 'PatientVisitPaymentSelfPayingModel':
			return {
				baseAction: PatientVisitPaymentSelfPayingAction,
				initCollectionAction: PatientVisitPaymentSelfPayingModelActionTypes.INITIALISE_PATIENT_VISIT_PAYMENT_SELF_PAYING_COLLECTION_STATE,
				fetchAllAction: PatientVisitPaymentSelfPayingModelActionTypes.FETCH_ALL_PATIENT_VISIT_PAYMENT_SELF_PAYING,
				fetchWithQueryAction: PatientVisitPaymentSelfPayingModelActionTypes.FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING_WITH_QUERY,
				fetchWithId: PatientVisitPaymentSelfPayingModelActionTypes.FETCH_PATIENT_VISIT_PAYMENT_SELF_PAYING,
				collectionModelsSelector: getPatientVisitPaymentSelfPayingCollectionModels,
			};
		case 'PatientVitalInformationModel':
			return {
				baseAction: PatientVitalInformationAction,
				initCollectionAction: PatientVitalInformationModelActionTypes.INITIALISE_PATIENT_VITAL_INFORMATION_COLLECTION_STATE,
				fetchAllAction: PatientVitalInformationModelActionTypes.FETCH_ALL_PATIENT_VITAL_INFORMATION,
				fetchWithQueryAction: PatientVitalInformationModelActionTypes.FETCH_PATIENT_VITAL_INFORMATION_WITH_QUERY,
				fetchWithId: PatientVitalInformationModelActionTypes.FETCH_PATIENT_VITAL_INFORMATION,
				collectionModelsSelector: getPatientVitalInformationCollectionModels,
			};
		case 'PharmacySetupModel':
			return {
				baseAction: PharmacySetupAction,
				initCollectionAction: PharmacySetupModelActionTypes.INITIALISE_PHARMACY_SETUP_COLLECTION_STATE,
				fetchAllAction: PharmacySetupModelActionTypes.FETCH_ALL_PHARMACY_SETUP,
				fetchWithQueryAction: PharmacySetupModelActionTypes.FETCH_PHARMACY_SETUP_WITH_QUERY,
				fetchWithId: PharmacySetupModelActionTypes.FETCH_PHARMACY_SETUP,
				collectionModelsSelector: getPharmacySetupCollectionModels,
			};
		case 'PharmacyUserModel':
			return {
				baseAction: PharmacyUserAction,
				initCollectionAction: PharmacyUserModelActionTypes.INITIALISE_PHARMACY_USER_COLLECTION_STATE,
				fetchAllAction: PharmacyUserModelActionTypes.FETCH_ALL_PHARMACY_USER,
				fetchWithQueryAction: PharmacyUserModelActionTypes.FETCH_PHARMACY_USER_WITH_QUERY,
				fetchWithId: PharmacyUserModelActionTypes.FETCH_PHARMACY_USER,
				collectionModelsSelector: getPharmacyUserCollectionModels,
			};
		case 'PostOperativeDetailsModel':
			return {
				baseAction: PostOperativeDetailsAction,
				initCollectionAction: PostOperativeDetailsModelActionTypes.INITIALISE_POST_OPERATIVE_DETAILS_COLLECTION_STATE,
				fetchAllAction: PostOperativeDetailsModelActionTypes.FETCH_ALL_POST_OPERATIVE_DETAILS,
				fetchWithQueryAction: PostOperativeDetailsModelActionTypes.FETCH_POST_OPERATIVE_DETAILS_WITH_QUERY,
				fetchWithId: PostOperativeDetailsModelActionTypes.FETCH_POST_OPERATIVE_DETAILS,
				collectionModelsSelector: getPostOperativeDetailsCollectionModels,
			};
		case 'PreoperativeRecordsModel':
			return {
				baseAction: PreoperativeRecordsAction,
				initCollectionAction: PreoperativeRecordsModelActionTypes.INITIALISE_PREOPERATIVE_RECORDS_COLLECTION_STATE,
				fetchAllAction: PreoperativeRecordsModelActionTypes.FETCH_ALL_PREOPERATIVE_RECORDS,
				fetchWithQueryAction: PreoperativeRecordsModelActionTypes.FETCH_PREOPERATIVE_RECORDS_WITH_QUERY,
				fetchWithId: PreoperativeRecordsModelActionTypes.FETCH_PREOPERATIVE_RECORDS,
				collectionModelsSelector: getPreoperativeRecordsCollectionModels,
			};
		case 'PrescriptionCompoundModel':
			return {
				baseAction: PrescriptionCompoundAction,
				initCollectionAction: PrescriptionCompoundModelActionTypes.INITIALISE_PRESCRIPTION_COMPOUND_COLLECTION_STATE,
				fetchAllAction: PrescriptionCompoundModelActionTypes.FETCH_ALL_PRESCRIPTION_COMPOUND,
				fetchWithQueryAction: PrescriptionCompoundModelActionTypes.FETCH_PRESCRIPTION_COMPOUND_WITH_QUERY,
				fetchWithId: PrescriptionCompoundModelActionTypes.FETCH_PRESCRIPTION_COMPOUND,
				collectionModelsSelector: getPrescriptionCompoundCollectionModels,
			};
		case 'PrescriptionHeaderModel':
			return {
				baseAction: PrescriptionHeaderAction,
				initCollectionAction: PrescriptionHeaderModelActionTypes.INITIALISE_PRESCRIPTION_HEADER_COLLECTION_STATE,
				fetchAllAction: PrescriptionHeaderModelActionTypes.FETCH_ALL_PRESCRIPTION_HEADER,
				fetchWithQueryAction: PrescriptionHeaderModelActionTypes.FETCH_PRESCRIPTION_HEADER_WITH_QUERY,
				fetchWithId: PrescriptionHeaderModelActionTypes.FETCH_PRESCRIPTION_HEADER,
				collectionModelsSelector: getPrescriptionHeaderCollectionModels,
			};
		case 'PrescriptionItemModel':
			return {
				baseAction: PrescriptionItemAction,
				initCollectionAction: PrescriptionItemModelActionTypes.INITIALISE_PRESCRIPTION_ITEM_COLLECTION_STATE,
				fetchAllAction: PrescriptionItemModelActionTypes.FETCH_ALL_PRESCRIPTION_ITEM,
				fetchWithQueryAction: PrescriptionItemModelActionTypes.FETCH_PRESCRIPTION_ITEM_WITH_QUERY,
				fetchWithId: PrescriptionItemModelActionTypes.FETCH_PRESCRIPTION_ITEM,
				collectionModelsSelector: getPrescriptionItemCollectionModels,
			};
		case 'PriceComponentModel':
			return {
				baseAction: PriceComponentAction,
				initCollectionAction: PriceComponentModelActionTypes.INITIALISE_PRICE_COMPONENT_COLLECTION_STATE,
				fetchAllAction: PriceComponentModelActionTypes.FETCH_ALL_PRICE_COMPONENT,
				fetchWithQueryAction: PriceComponentModelActionTypes.FETCH_PRICE_COMPONENT_WITH_QUERY,
				fetchWithId: PriceComponentModelActionTypes.FETCH_PRICE_COMPONENT,
				collectionModelsSelector: getPriceComponentCollectionModels,
			};
		case 'PrivilegeModel':
			return {
				baseAction: PrivilegeAction,
				initCollectionAction: PrivilegeModelActionTypes.INITIALISE_PRIVILEGE_COLLECTION_STATE,
				fetchAllAction: PrivilegeModelActionTypes.FETCH_ALL_PRIVILEGE,
				fetchWithQueryAction: PrivilegeModelActionTypes.FETCH_PRIVILEGE_WITH_QUERY,
				fetchWithId: PrivilegeModelActionTypes.FETCH_PRIVILEGE,
				collectionModelsSelector: getPrivilegeCollectionModels,
			};
		case 'ProcessWorkflowModel':
			return {
				baseAction: ProcessWorkflowAction,
				initCollectionAction: ProcessWorkflowModelActionTypes.INITIALISE_PROCESS_WORKFLOW_COLLECTION_STATE,
				fetchAllAction: ProcessWorkflowModelActionTypes.FETCH_ALL_PROCESS_WORKFLOW,
				fetchWithQueryAction: ProcessWorkflowModelActionTypes.FETCH_PROCESS_WORKFLOW_WITH_QUERY,
				fetchWithId: ProcessWorkflowModelActionTypes.FETCH_PROCESS_WORKFLOW,
				collectionModelsSelector: getProcessWorkflowCollectionModels,
			};
		case 'PurchaseOrderModel':
			return {
				baseAction: PurchaseOrderAction,
				initCollectionAction: PurchaseOrderModelActionTypes.INITIALISE_PURCHASE_ORDER_COLLECTION_STATE,
				fetchAllAction: PurchaseOrderModelActionTypes.FETCH_ALL_PURCHASE_ORDER,
				fetchWithQueryAction: PurchaseOrderModelActionTypes.FETCH_PURCHASE_ORDER_WITH_QUERY,
				fetchWithId: PurchaseOrderModelActionTypes.FETCH_PURCHASE_ORDER,
				collectionModelsSelector: getPurchaseOrderCollectionModels,
			};
		case 'PurchaseOrderStockDetailModel':
			return {
				baseAction: PurchaseOrderStockDetailAction,
				initCollectionAction: PurchaseOrderStockDetailModelActionTypes.INITIALISE_PURCHASE_ORDER_STOCK_DETAIL_COLLECTION_STATE,
				fetchAllAction: PurchaseOrderStockDetailModelActionTypes.FETCH_ALL_PURCHASE_ORDER_STOCK_DETAIL,
				fetchWithQueryAction: PurchaseOrderStockDetailModelActionTypes.FETCH_PURCHASE_ORDER_STOCK_DETAIL_WITH_QUERY,
				fetchWithId: PurchaseOrderStockDetailModelActionTypes.FETCH_PURCHASE_ORDER_STOCK_DETAIL,
				collectionModelsSelector: getPurchaseOrderStockDetailCollectionModels,
			};
		case 'PurchaseRequisitionModel':
			return {
				baseAction: PurchaseRequisitionAction,
				initCollectionAction: PurchaseRequisitionModelActionTypes.INITIALISE_PURCHASE_REQUISITION_COLLECTION_STATE,
				fetchAllAction: PurchaseRequisitionModelActionTypes.FETCH_ALL_PURCHASE_REQUISITION,
				fetchWithQueryAction: PurchaseRequisitionModelActionTypes.FETCH_PURCHASE_REQUISITION_WITH_QUERY,
				fetchWithId: PurchaseRequisitionModelActionTypes.FETCH_PURCHASE_REQUISITION,
				collectionModelsSelector: getPurchaseRequisitionCollectionModels,
			};
		case 'PurchaseRequisitionStockDetailModel':
			return {
				baseAction: PurchaseRequisitionStockDetailAction,
				initCollectionAction: PurchaseRequisitionStockDetailModelActionTypes.INITIALISE_PURCHASE_REQUISITION_STOCK_DETAIL_COLLECTION_STATE,
				fetchAllAction: PurchaseRequisitionStockDetailModelActionTypes.FETCH_ALL_PURCHASE_REQUISITION_STOCK_DETAIL,
				fetchWithQueryAction: PurchaseRequisitionStockDetailModelActionTypes.FETCH_PURCHASE_REQUISITION_STOCK_DETAIL_WITH_QUERY,
				fetchWithId: PurchaseRequisitionStockDetailModelActionTypes.FETCH_PURCHASE_REQUISITION_STOCK_DETAIL,
				collectionModelsSelector: getPurchaseRequisitionStockDetailCollectionModels,
			};
		case 'PurchasingUserModel':
			return {
				baseAction: PurchasingUserAction,
				initCollectionAction: PurchasingUserModelActionTypes.INITIALISE_PURCHASING_USER_COLLECTION_STATE,
				fetchAllAction: PurchasingUserModelActionTypes.FETCH_ALL_PURCHASING_USER,
				fetchWithQueryAction: PurchasingUserModelActionTypes.FETCH_PURCHASING_USER_WITH_QUERY,
				fetchWithId: PurchasingUserModelActionTypes.FETCH_PURCHASING_USER,
				collectionModelsSelector: getPurchasingUserCollectionModels,
			};
		case 'ReferenceDataModel':
			return {
				baseAction: ReferenceDataAction,
				initCollectionAction: ReferenceDataModelActionTypes.INITIALISE_REFERENCE_DATA_COLLECTION_STATE,
				fetchAllAction: ReferenceDataModelActionTypes.FETCH_ALL_REFERENCE_DATA,
				fetchWithQueryAction: ReferenceDataModelActionTypes.FETCH_REFERENCE_DATA_WITH_QUERY,
				fetchWithId: ReferenceDataModelActionTypes.FETCH_REFERENCE_DATA,
				collectionModelsSelector: getReferenceDataCollectionModels,
			};
		case 'ReferenceHeaderModel':
			return {
				baseAction: ReferenceHeaderAction,
				initCollectionAction: ReferenceHeaderModelActionTypes.INITIALISE_REFERENCE_HEADER_COLLECTION_STATE,
				fetchAllAction: ReferenceHeaderModelActionTypes.FETCH_ALL_REFERENCE_HEADER,
				fetchWithQueryAction: ReferenceHeaderModelActionTypes.FETCH_REFERENCE_HEADER_WITH_QUERY,
				fetchWithId: ReferenceHeaderModelActionTypes.FETCH_REFERENCE_HEADER,
				collectionModelsSelector: getReferenceHeaderCollectionModels,
			};
		case 'RegistrationModel':
			return {
				baseAction: RegistrationAction,
				initCollectionAction: RegistrationModelActionTypes.INITIALISE_REGISTRATION_COLLECTION_STATE,
				fetchAllAction: RegistrationModelActionTypes.FETCH_ALL_REGISTRATION,
				fetchWithQueryAction: RegistrationModelActionTypes.FETCH_REGISTRATION_WITH_QUERY,
				fetchWithId: RegistrationModelActionTypes.FETCH_REGISTRATION,
				collectionModelsSelector: getRegistrationCollectionModels,
			};
		case 'RegistrationUserModel':
			return {
				baseAction: RegistrationUserAction,
				initCollectionAction: RegistrationUserModelActionTypes.INITIALISE_REGISTRATION_USER_COLLECTION_STATE,
				fetchAllAction: RegistrationUserModelActionTypes.FETCH_ALL_REGISTRATION_USER,
				fetchWithQueryAction: RegistrationUserModelActionTypes.FETCH_REGISTRATION_USER_WITH_QUERY,
				fetchWithId: RegistrationUserModelActionTypes.FETCH_REGISTRATION_USER,
				collectionModelsSelector: getRegistrationUserCollectionModels,
			};
		case 'RetailPharmacyModel':
			return {
				baseAction: RetailPharmacyAction,
				initCollectionAction: RetailPharmacyModelActionTypes.INITIALISE_RETAIL_PHARMACY_COLLECTION_STATE,
				fetchAllAction: RetailPharmacyModelActionTypes.FETCH_ALL_RETAIL_PHARMACY,
				fetchWithQueryAction: RetailPharmacyModelActionTypes.FETCH_RETAIL_PHARMACY_WITH_QUERY,
				fetchWithId: RetailPharmacyModelActionTypes.FETCH_RETAIL_PHARMACY,
				collectionModelsSelector: getRetailPharmacyCollectionModels,
			};
		case 'RetailPharmacyInvoiceModel':
			return {
				baseAction: RetailPharmacyInvoiceAction,
				initCollectionAction: RetailPharmacyInvoiceModelActionTypes.INITIALISE_RETAIL_PHARMACY_INVOICE_COLLECTION_STATE,
				fetchAllAction: RetailPharmacyInvoiceModelActionTypes.FETCH_ALL_RETAIL_PHARMACY_INVOICE,
				fetchWithQueryAction: RetailPharmacyInvoiceModelActionTypes.FETCH_RETAIL_PHARMACY_INVOICE_WITH_QUERY,
				fetchWithId: RetailPharmacyInvoiceModelActionTypes.FETCH_RETAIL_PHARMACY_INVOICE,
				collectionModelsSelector: getRetailPharmacyInvoiceCollectionModels,
			};
		case 'RetailPharmacyStockDetailModel':
			return {
				baseAction: RetailPharmacyStockDetailAction,
				initCollectionAction: RetailPharmacyStockDetailModelActionTypes.INITIALISE_RETAIL_PHARMACY_STOCK_DETAIL_COLLECTION_STATE,
				fetchAllAction: RetailPharmacyStockDetailModelActionTypes.FETCH_ALL_RETAIL_PHARMACY_STOCK_DETAIL,
				fetchWithQueryAction: RetailPharmacyStockDetailModelActionTypes.FETCH_RETAIL_PHARMACY_STOCK_DETAIL_WITH_QUERY,
				fetchWithId: RetailPharmacyStockDetailModelActionTypes.FETCH_RETAIL_PHARMACY_STOCK_DETAIL,
				collectionModelsSelector: getRetailPharmacyStockDetailCollectionModels,
			};
		case 'ReturnSupplierModel':
			return {
				baseAction: ReturnSupplierAction,
				initCollectionAction: ReturnSupplierModelActionTypes.INITIALISE_RETURN_SUPPLIER_COLLECTION_STATE,
				fetchAllAction: ReturnSupplierModelActionTypes.FETCH_ALL_RETURN_SUPPLIER,
				fetchWithQueryAction: ReturnSupplierModelActionTypes.FETCH_RETURN_SUPPLIER_WITH_QUERY,
				fetchWithId: ReturnSupplierModelActionTypes.FETCH_RETURN_SUPPLIER,
				collectionModelsSelector: getReturnSupplierCollectionModels,
			};
		case 'ReturnSupplierStockDetailModel':
			return {
				baseAction: ReturnSupplierStockDetailAction,
				initCollectionAction: ReturnSupplierStockDetailModelActionTypes.INITIALISE_RETURN_SUPPLIER_STOCK_DETAIL_COLLECTION_STATE,
				fetchAllAction: ReturnSupplierStockDetailModelActionTypes.FETCH_ALL_RETURN_SUPPLIER_STOCK_DETAIL,
				fetchWithQueryAction: ReturnSupplierStockDetailModelActionTypes.FETCH_RETURN_SUPPLIER_STOCK_DETAIL_WITH_QUERY,
				fetchWithId: ReturnSupplierStockDetailModelActionTypes.FETCH_RETURN_SUPPLIER_STOCK_DETAIL,
				collectionModelsSelector: getReturnSupplierStockDetailCollectionModels,
			};
		case 'RoleModel':
			return {
				baseAction: RoleAction,
				initCollectionAction: RoleModelActionTypes.INITIALISE_ROLE_COLLECTION_STATE,
				fetchAllAction: RoleModelActionTypes.FETCH_ALL_ROLE,
				fetchWithQueryAction: RoleModelActionTypes.FETCH_ROLE_WITH_QUERY,
				fetchWithId: RoleModelActionTypes.FETCH_ROLE,
				collectionModelsSelector: getRoleCollectionModels,
			};
		case 'RoomFacilityModel':
			return {
				baseAction: RoomFacilityAction,
				initCollectionAction: RoomFacilityModelActionTypes.INITIALISE_ROOM_FACILITY_COLLECTION_STATE,
				fetchAllAction: RoomFacilityModelActionTypes.FETCH_ALL_ROOM_FACILITY,
				fetchWithQueryAction: RoomFacilityModelActionTypes.FETCH_ROOM_FACILITY_WITH_QUERY,
				fetchWithId: RoomFacilityModelActionTypes.FETCH_ROOM_FACILITY,
				collectionModelsSelector: getRoomFacilityCollectionModels,
			};
		case 'RoomTransferModel':
			return {
				baseAction: RoomTransferAction,
				initCollectionAction: RoomTransferModelActionTypes.INITIALISE_ROOM_TRANSFER_COLLECTION_STATE,
				fetchAllAction: RoomTransferModelActionTypes.FETCH_ALL_ROOM_TRANSFER,
				fetchWithQueryAction: RoomTransferModelActionTypes.FETCH_ROOM_TRANSFER_WITH_QUERY,
				fetchWithId: RoomTransferModelActionTypes.FETCH_ROOM_TRANSFER,
				collectionModelsSelector: getRoomTransferCollectionModels,
			};
		case 'SepModel':
			return {
				baseAction: SepAction,
				initCollectionAction: SepModelActionTypes.INITIALISE_SEP_COLLECTION_STATE,
				fetchAllAction: SepModelActionTypes.FETCH_ALL_SEP,
				fetchWithQueryAction: SepModelActionTypes.FETCH_SEP_WITH_QUERY,
				fetchWithId: SepModelActionTypes.FETCH_SEP,
				collectionModelsSelector: getSepCollectionModels,
			};
		case 'SampleCollectionInformationModel':
			return {
				baseAction: SampleCollectionInformationAction,
				initCollectionAction: SampleCollectionInformationModelActionTypes.INITIALISE_SAMPLE_COLLECTION_INFORMATION_COLLECTION_STATE,
				fetchAllAction: SampleCollectionInformationModelActionTypes.FETCH_ALL_SAMPLE_COLLECTION_INFORMATION,
				fetchWithQueryAction: SampleCollectionInformationModelActionTypes.FETCH_SAMPLE_COLLECTION_INFORMATION_WITH_QUERY,
				fetchWithId: SampleCollectionInformationModelActionTypes.FETCH_SAMPLE_COLLECTION_INFORMATION,
				collectionModelsSelector: getSampleCollectionInformationCollectionModels,
			};
		case 'SampleCollectionItemsModel':
			return {
				baseAction: SampleCollectionItemsAction,
				initCollectionAction: SampleCollectionItemsModelActionTypes.INITIALISE_SAMPLE_COLLECTION_ITEMS_COLLECTION_STATE,
				fetchAllAction: SampleCollectionItemsModelActionTypes.FETCH_ALL_SAMPLE_COLLECTION_ITEMS,
				fetchWithQueryAction: SampleCollectionItemsModelActionTypes.FETCH_SAMPLE_COLLECTION_ITEMS_WITH_QUERY,
				fetchWithId: SampleCollectionItemsModelActionTypes.FETCH_SAMPLE_COLLECTION_ITEMS,
				collectionModelsSelector: getSampleCollectionItemsCollectionModels,
			};
		case 'SatuSehatConfigurationModel':
			return {
				baseAction: SatuSehatConfigurationAction,
				initCollectionAction: SatuSehatConfigurationModelActionTypes.INITIALISE_SATU_SEHAT_CONFIGURATION_COLLECTION_STATE,
				fetchAllAction: SatuSehatConfigurationModelActionTypes.FETCH_ALL_SATU_SEHAT_CONFIGURATION,
				fetchWithQueryAction: SatuSehatConfigurationModelActionTypes.FETCH_SATU_SEHAT_CONFIGURATION_WITH_QUERY,
				fetchWithId: SatuSehatConfigurationModelActionTypes.FETCH_SATU_SEHAT_CONFIGURATION,
				collectionModelsSelector: getSatuSehatConfigurationCollectionModels,
			};
		case 'ServiceModel':
			return {
				baseAction: ServiceAction,
				initCollectionAction: ServiceModelActionTypes.INITIALISE_SERVICE_COLLECTION_STATE,
				fetchAllAction: ServiceModelActionTypes.FETCH_ALL_SERVICE,
				fetchWithQueryAction: ServiceModelActionTypes.FETCH_SERVICE_WITH_QUERY,
				fetchWithId: ServiceModelActionTypes.FETCH_SERVICE,
				collectionModelsSelector: getServiceCollectionModels,
			};
		case 'ServiceFacilityCategoryModel':
			return {
				baseAction: ServiceFacilityCategoryAction,
				initCollectionAction: ServiceFacilityCategoryModelActionTypes.INITIALISE_SERVICE_FACILITY_CATEGORY_COLLECTION_STATE,
				fetchAllAction: ServiceFacilityCategoryModelActionTypes.FETCH_ALL_SERVICE_FACILITY_CATEGORY,
				fetchWithQueryAction: ServiceFacilityCategoryModelActionTypes.FETCH_SERVICE_FACILITY_CATEGORY_WITH_QUERY,
				fetchWithId: ServiceFacilityCategoryModelActionTypes.FETCH_SERVICE_FACILITY_CATEGORY,
				collectionModelsSelector: getServiceFacilityCategoryCollectionModels,
			};
		case 'ServiceItemModel':
			return {
				baseAction: ServiceItemAction,
				initCollectionAction: ServiceItemModelActionTypes.INITIALISE_SERVICE_ITEM_COLLECTION_STATE,
				fetchAllAction: ServiceItemModelActionTypes.FETCH_ALL_SERVICE_ITEM,
				fetchWithQueryAction: ServiceItemModelActionTypes.FETCH_SERVICE_ITEM_WITH_QUERY,
				fetchWithId: ServiceItemModelActionTypes.FETCH_SERVICE_ITEM,
				collectionModelsSelector: getServiceItemCollectionModels,
			};
		case 'ServiceItemAssignmentModel':
			return {
				baseAction: ServiceItemAssignmentAction,
				initCollectionAction: ServiceItemAssignmentModelActionTypes.INITIALISE_SERVICE_ITEM_ASSIGNMENT_COLLECTION_STATE,
				fetchAllAction: ServiceItemAssignmentModelActionTypes.FETCH_ALL_SERVICE_ITEM_ASSIGNMENT,
				fetchWithQueryAction: ServiceItemAssignmentModelActionTypes.FETCH_SERVICE_ITEM_ASSIGNMENT_WITH_QUERY,
				fetchWithId: ServiceItemAssignmentModelActionTypes.FETCH_SERVICE_ITEM_ASSIGNMENT,
				collectionModelsSelector: getServiceItemAssignmentCollectionModels,
			};
		case 'StaffModel':
			return {
				baseAction: StaffAction,
				initCollectionAction: StaffModelActionTypes.INITIALISE_STAFF_COLLECTION_STATE,
				fetchAllAction: StaffModelActionTypes.FETCH_ALL_STAFF,
				fetchWithQueryAction: StaffModelActionTypes.FETCH_STAFF_WITH_QUERY,
				fetchWithId: StaffModelActionTypes.FETCH_STAFF,
				collectionModelsSelector: getStaffCollectionModels,
			};
		case 'StockCatalogueModel':
			return {
				baseAction: StockCatalogueAction,
				initCollectionAction: StockCatalogueModelActionTypes.INITIALISE_STOCK_CATALOGUE_COLLECTION_STATE,
				fetchAllAction: StockCatalogueModelActionTypes.FETCH_ALL_STOCK_CATALOGUE,
				fetchWithQueryAction: StockCatalogueModelActionTypes.FETCH_STOCK_CATALOGUE_WITH_QUERY,
				fetchWithId: StockCatalogueModelActionTypes.FETCH_STOCK_CATALOGUE,
				collectionModelsSelector: getStockCatalogueCollectionModels,
			};
		case 'StockControlModel':
			return {
				baseAction: StockControlAction,
				initCollectionAction: StockControlModelActionTypes.INITIALISE_STOCK_CONTROL_COLLECTION_STATE,
				fetchAllAction: StockControlModelActionTypes.FETCH_ALL_STOCK_CONTROL,
				fetchWithQueryAction: StockControlModelActionTypes.FETCH_STOCK_CONTROL_WITH_QUERY,
				fetchWithId: StockControlModelActionTypes.FETCH_STOCK_CONTROL,
				collectionModelsSelector: getStockControlCollectionModels,
			};
		case 'StockTransactionDetailModel':
			return {
				baseAction: StockTransactionDetailAction,
				initCollectionAction: StockTransactionDetailModelActionTypes.INITIALISE_STOCK_TRANSACTION_DETAIL_COLLECTION_STATE,
				fetchAllAction: StockTransactionDetailModelActionTypes.FETCH_ALL_STOCK_TRANSACTION_DETAIL,
				fetchWithQueryAction: StockTransactionDetailModelActionTypes.FETCH_STOCK_TRANSACTION_DETAIL_WITH_QUERY,
				fetchWithId: StockTransactionDetailModelActionTypes.FETCH_STOCK_TRANSACTION_DETAIL,
				collectionModelsSelector: getStockTransactionDetailCollectionModels,
			};
		case 'StockTransactionPerDateModel':
			return {
				baseAction: StockTransactionPerDateAction,
				initCollectionAction: StockTransactionPerDateModelActionTypes.INITIALISE_STOCK_TRANSACTION_PER_DATE_COLLECTION_STATE,
				fetchAllAction: StockTransactionPerDateModelActionTypes.FETCH_ALL_STOCK_TRANSACTION_PER_DATE,
				fetchWithQueryAction: StockTransactionPerDateModelActionTypes.FETCH_STOCK_TRANSACTION_PER_DATE_WITH_QUERY,
				fetchWithId: StockTransactionPerDateModelActionTypes.FETCH_STOCK_TRANSACTION_PER_DATE,
				collectionModelsSelector: getStockTransactionPerDateCollectionModels,
			};
		case 'StockTransactionPerDateTypeModel':
			return {
				baseAction: StockTransactionPerDateTypeAction,
				initCollectionAction: StockTransactionPerDateTypeModelActionTypes.INITIALISE_STOCK_TRANSACTION_PER_DATE_TYPE_COLLECTION_STATE,
				fetchAllAction: StockTransactionPerDateTypeModelActionTypes.FETCH_ALL_STOCK_TRANSACTION_PER_DATE_TYPE,
				fetchWithQueryAction: StockTransactionPerDateTypeModelActionTypes.FETCH_STOCK_TRANSACTION_PER_DATE_TYPE_WITH_QUERY,
				fetchWithId: StockTransactionPerDateTypeModelActionTypes.FETCH_STOCK_TRANSACTION_PER_DATE_TYPE,
				collectionModelsSelector: getStockTransactionPerDateTypeCollectionModels,
			};
		case 'SupplierModel':
			return {
				baseAction: SupplierAction,
				initCollectionAction: SupplierModelActionTypes.INITIALISE_SUPPLIER_COLLECTION_STATE,
				fetchAllAction: SupplierModelActionTypes.FETCH_ALL_SUPPLIER,
				fetchWithQueryAction: SupplierModelActionTypes.FETCH_SUPPLIER_WITH_QUERY,
				fetchWithId: SupplierModelActionTypes.FETCH_SUPPLIER,
				collectionModelsSelector: getSupplierCollectionModels,
			};
		case 'SupplierBankAccountModel':
			return {
				baseAction: SupplierBankAccountAction,
				initCollectionAction: SupplierBankAccountModelActionTypes.INITIALISE_SUPPLIER_BANK_ACCOUNT_COLLECTION_STATE,
				fetchAllAction: SupplierBankAccountModelActionTypes.FETCH_ALL_SUPPLIER_BANK_ACCOUNT,
				fetchWithQueryAction: SupplierBankAccountModelActionTypes.FETCH_SUPPLIER_BANK_ACCOUNT_WITH_QUERY,
				fetchWithId: SupplierBankAccountModelActionTypes.FETCH_SUPPLIER_BANK_ACCOUNT,
				collectionModelsSelector: getSupplierBankAccountCollectionModels,
			};
		case 'SupplierContactDetailModel':
			return {
				baseAction: SupplierContactDetailAction,
				initCollectionAction: SupplierContactDetailModelActionTypes.INITIALISE_SUPPLIER_CONTACT_DETAIL_COLLECTION_STATE,
				fetchAllAction: SupplierContactDetailModelActionTypes.FETCH_ALL_SUPPLIER_CONTACT_DETAIL,
				fetchWithQueryAction: SupplierContactDetailModelActionTypes.FETCH_SUPPLIER_CONTACT_DETAIL_WITH_QUERY,
				fetchWithId: SupplierContactDetailModelActionTypes.FETCH_SUPPLIER_CONTACT_DETAIL,
				collectionModelsSelector: getSupplierContactDetailCollectionModels,
			};
		case 'SupplierProductDetailModel':
			return {
				baseAction: SupplierProductDetailAction,
				initCollectionAction: SupplierProductDetailModelActionTypes.INITIALISE_SUPPLIER_PRODUCT_DETAIL_COLLECTION_STATE,
				fetchAllAction: SupplierProductDetailModelActionTypes.FETCH_ALL_SUPPLIER_PRODUCT_DETAIL,
				fetchWithQueryAction: SupplierProductDetailModelActionTypes.FETCH_SUPPLIER_PRODUCT_DETAIL_WITH_QUERY,
				fetchWithId: SupplierProductDetailModelActionTypes.FETCH_SUPPLIER_PRODUCT_DETAIL,
				collectionModelsSelector: getSupplierProductDetailCollectionModels,
			};
		case 'SystemAdminUserModel':
			return {
				baseAction: SystemAdminUserAction,
				initCollectionAction: SystemAdminUserModelActionTypes.INITIALISE_SYSTEM_ADMIN_USER_COLLECTION_STATE,
				fetchAllAction: SystemAdminUserModelActionTypes.FETCH_ALL_SYSTEM_ADMIN_USER,
				fetchWithQueryAction: SystemAdminUserModelActionTypes.FETCH_SYSTEM_ADMIN_USER_WITH_QUERY,
				fetchWithId: SystemAdminUserModelActionTypes.FETCH_SYSTEM_ADMIN_USER,
				collectionModelsSelector: getSystemAdminUserCollectionModels,
			};
		case 'TariffDefinitionModel':
			return {
				baseAction: TariffDefinitionAction,
				initCollectionAction: TariffDefinitionModelActionTypes.INITIALISE_TARIFF_DEFINITION_COLLECTION_STATE,
				fetchAllAction: TariffDefinitionModelActionTypes.FETCH_ALL_TARIFF_DEFINITION,
				fetchWithQueryAction: TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION_WITH_QUERY,
				fetchWithId: TariffDefinitionModelActionTypes.FETCH_TARIFF_DEFINITION,
				collectionModelsSelector: getTariffDefinitionCollectionModels,
			};
		case 'TariffDefinitionOtherComponentModel':
			return {
				baseAction: TariffDefinitionOtherComponentAction,
				initCollectionAction: TariffDefinitionOtherComponentModelActionTypes.INITIALISE_TARIFF_DEFINITION_OTHER_COMPONENT_COLLECTION_STATE,
				fetchAllAction: TariffDefinitionOtherComponentModelActionTypes.FETCH_ALL_TARIFF_DEFINITION_OTHER_COMPONENT,
				fetchWithQueryAction: TariffDefinitionOtherComponentModelActionTypes.FETCH_TARIFF_DEFINITION_OTHER_COMPONENT_WITH_QUERY,
				fetchWithId: TariffDefinitionOtherComponentModelActionTypes.FETCH_TARIFF_DEFINITION_OTHER_COMPONENT,
				collectionModelsSelector: getTariffDefinitionOtherComponentCollectionModels,
			};
		case 'TariffFormulaModel':
			return {
				baseAction: TariffFormulaAction,
				initCollectionAction: TariffFormulaModelActionTypes.INITIALISE_TARIFF_FORMULA_COLLECTION_STATE,
				fetchAllAction: TariffFormulaModelActionTypes.FETCH_ALL_TARIFF_FORMULA,
				fetchWithQueryAction: TariffFormulaModelActionTypes.FETCH_TARIFF_FORMULA_WITH_QUERY,
				fetchWithId: TariffFormulaModelActionTypes.FETCH_TARIFF_FORMULA,
				collectionModelsSelector: getTariffFormulaCollectionModels,
			};
		case 'TariffPackageModel':
			return {
				baseAction: TariffPackageAction,
				initCollectionAction: TariffPackageModelActionTypes.INITIALISE_TARIFF_PACKAGE_COLLECTION_STATE,
				fetchAllAction: TariffPackageModelActionTypes.FETCH_ALL_TARIFF_PACKAGE,
				fetchWithQueryAction: TariffPackageModelActionTypes.FETCH_TARIFF_PACKAGE_WITH_QUERY,
				fetchWithId: TariffPackageModelActionTypes.FETCH_TARIFF_PACKAGE,
				collectionModelsSelector: getTariffPackageCollectionModels,
			};
		case 'TariffPackageItemModel':
			return {
				baseAction: TariffPackageItemAction,
				initCollectionAction: TariffPackageItemModelActionTypes.INITIALISE_TARIFF_PACKAGE_ITEM_COLLECTION_STATE,
				fetchAllAction: TariffPackageItemModelActionTypes.FETCH_ALL_TARIFF_PACKAGE_ITEM,
				fetchWithQueryAction: TariffPackageItemModelActionTypes.FETCH_TARIFF_PACKAGE_ITEM_WITH_QUERY,
				fetchWithId: TariffPackageItemModelActionTypes.FETCH_TARIFF_PACKAGE_ITEM,
				collectionModelsSelector: getTariffPackageItemCollectionModels,
			};
		case 'TariffPackageServiceAssignmentModel':
			return {
				baseAction: TariffPackageServiceAssignmentAction,
				initCollectionAction: TariffPackageServiceAssignmentModelActionTypes.INITIALISE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_COLLECTION_STATE,
				fetchAllAction: TariffPackageServiceAssignmentModelActionTypes.FETCH_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT,
				fetchWithQueryAction: TariffPackageServiceAssignmentModelActionTypes.FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_WITH_QUERY,
				fetchWithId: TariffPackageServiceAssignmentModelActionTypes.FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT,
				collectionModelsSelector: getTariffPackageServiceAssignmentCollectionModels,
			};
		case 'TariffSchemaModel':
			return {
				baseAction: TariffSchemaAction,
				initCollectionAction: TariffSchemaModelActionTypes.INITIALISE_TARIFF_SCHEMA_COLLECTION_STATE,
				fetchAllAction: TariffSchemaModelActionTypes.FETCH_ALL_TARIFF_SCHEMA,
				fetchWithQueryAction: TariffSchemaModelActionTypes.FETCH_TARIFF_SCHEMA_WITH_QUERY,
				fetchWithId: TariffSchemaModelActionTypes.FETCH_TARIFF_SCHEMA,
				collectionModelsSelector: getTariffSchemaCollectionModels,
			};
		case 'TaskDashboardModel':
			return {
				baseAction: TaskDashboardAction,
				initCollectionAction: TaskDashboardModelActionTypes.INITIALISE_TASK_DASHBOARD_COLLECTION_STATE,
				fetchAllAction: TaskDashboardModelActionTypes.FETCH_ALL_TASK_DASHBOARD,
				fetchWithQueryAction: TaskDashboardModelActionTypes.FETCH_TASK_DASHBOARD_WITH_QUERY,
				fetchWithId: TaskDashboardModelActionTypes.FETCH_TASK_DASHBOARD,
				collectionModelsSelector: getTaskDashboardCollectionModels,
			};
		case 'TransactionDetailTypeModel':
			return {
				baseAction: TransactionDetailTypeAction,
				initCollectionAction: TransactionDetailTypeModelActionTypes.INITIALISE_TRANSACTION_DETAIL_TYPE_COLLECTION_STATE,
				fetchAllAction: TransactionDetailTypeModelActionTypes.FETCH_ALL_TRANSACTION_DETAIL_TYPE,
				fetchWithQueryAction: TransactionDetailTypeModelActionTypes.FETCH_TRANSACTION_DETAIL_TYPE_WITH_QUERY,
				fetchWithId: TransactionDetailTypeModelActionTypes.FETCH_TRANSACTION_DETAIL_TYPE,
				collectionModelsSelector: getTransactionDetailTypeCollectionModels,
			};
		case 'TransactionDetailTypeMappingModel':
			return {
				baseAction: TransactionDetailTypeMappingAction,
				initCollectionAction: TransactionDetailTypeMappingModelActionTypes.INITIALISE_TRANSACTION_DETAIL_TYPE_MAPPING_COLLECTION_STATE,
				fetchAllAction: TransactionDetailTypeMappingModelActionTypes.FETCH_ALL_TRANSACTION_DETAIL_TYPE_MAPPING,
				fetchWithQueryAction: TransactionDetailTypeMappingModelActionTypes.FETCH_TRANSACTION_DETAIL_TYPE_MAPPING_WITH_QUERY,
				fetchWithId: TransactionDetailTypeMappingModelActionTypes.FETCH_TRANSACTION_DETAIL_TYPE_MAPPING,
				collectionModelsSelector: getTransactionDetailTypeMappingCollectionModels,
			};
		case 'TransferOrderModel':
			return {
				baseAction: TransferOrderAction,
				initCollectionAction: TransferOrderModelActionTypes.INITIALISE_TRANSFER_ORDER_COLLECTION_STATE,
				fetchAllAction: TransferOrderModelActionTypes.FETCH_ALL_TRANSFER_ORDER,
				fetchWithQueryAction: TransferOrderModelActionTypes.FETCH_TRANSFER_ORDER_WITH_QUERY,
				fetchWithId: TransferOrderModelActionTypes.FETCH_TRANSFER_ORDER,
				collectionModelsSelector: getTransferOrderCollectionModels,
			};
		case 'TransferOrderStockDetailModel':
			return {
				baseAction: TransferOrderStockDetailAction,
				initCollectionAction: TransferOrderStockDetailModelActionTypes.INITIALISE_TRANSFER_ORDER_STOCK_DETAIL_COLLECTION_STATE,
				fetchAllAction: TransferOrderStockDetailModelActionTypes.FETCH_ALL_TRANSFER_ORDER_STOCK_DETAIL,
				fetchWithQueryAction: TransferOrderStockDetailModelActionTypes.FETCH_TRANSFER_ORDER_STOCK_DETAIL_WITH_QUERY,
				fetchWithId: TransferOrderStockDetailModelActionTypes.FETCH_TRANSFER_ORDER_STOCK_DETAIL,
				collectionModelsSelector: getTransferOrderStockDetailCollectionModels,
			};
		case 'UnitOfMeasurementModel':
			return {
				baseAction: UnitOfMeasurementAction,
				initCollectionAction: UnitOfMeasurementModelActionTypes.INITIALISE_UNIT_OF_MEASUREMENT_COLLECTION_STATE,
				fetchAllAction: UnitOfMeasurementModelActionTypes.FETCH_ALL_UNIT_OF_MEASUREMENT,
				fetchWithQueryAction: UnitOfMeasurementModelActionTypes.FETCH_UNIT_OF_MEASUREMENT_WITH_QUERY,
				fetchWithId: UnitOfMeasurementModelActionTypes.FETCH_UNIT_OF_MEASUREMENT,
				collectionModelsSelector: getUnitOfMeasurementCollectionModels,
			};
		case 'UserModel':
			return {
				baseAction: UserAction,
				initCollectionAction: UserModelActionTypes.INITIALISE_USER_COLLECTION_STATE,
				fetchAllAction: UserModelActionTypes.FETCH_ALL_USER,
				fetchWithQueryAction: UserModelActionTypes.FETCH_USER_WITH_QUERY,
				fetchWithId: UserModelActionTypes.FETCH_USER,
				collectionModelsSelector: getUserCollectionModels,
			};
		case 'VaccinationOrderModel':
			return {
				baseAction: VaccinationOrderAction,
				initCollectionAction: VaccinationOrderModelActionTypes.INITIALISE_VACCINATION_ORDER_COLLECTION_STATE,
				fetchAllAction: VaccinationOrderModelActionTypes.FETCH_ALL_VACCINATION_ORDER,
				fetchWithQueryAction: VaccinationOrderModelActionTypes.FETCH_VACCINATION_ORDER_WITH_QUERY,
				fetchWithId: VaccinationOrderModelActionTypes.FETCH_VACCINATION_ORDER,
				collectionModelsSelector: getVaccinationOrderCollectionModels,
			};
		case 'VaccinationOrderDetailModel':
			return {
				baseAction: VaccinationOrderDetailAction,
				initCollectionAction: VaccinationOrderDetailModelActionTypes.INITIALISE_VACCINATION_ORDER_DETAIL_COLLECTION_STATE,
				fetchAllAction: VaccinationOrderDetailModelActionTypes.FETCH_ALL_VACCINATION_ORDER_DETAIL,
				fetchWithQueryAction: VaccinationOrderDetailModelActionTypes.FETCH_VACCINATION_ORDER_DETAIL_WITH_QUERY,
				fetchWithId: VaccinationOrderDetailModelActionTypes.FETCH_VACCINATION_ORDER_DETAIL,
				collectionModelsSelector: getVaccinationOrderDetailCollectionModels,
			};
		case 'VitalSignsModel':
			return {
				baseAction: VitalSignsAction,
				initCollectionAction: VitalSignsModelActionTypes.INITIALISE_VITAL_SIGNS_COLLECTION_STATE,
				fetchAllAction: VitalSignsModelActionTypes.FETCH_ALL_VITAL_SIGNS,
				fetchWithQueryAction: VitalSignsModelActionTypes.FETCH_VITAL_SIGNS_WITH_QUERY,
				fetchWithId: VitalSignsModelActionTypes.FETCH_VITAL_SIGNS,
				collectionModelsSelector: getVitalSignsCollectionModels,
			};
		case 'WarehouseModel':
			return {
				baseAction: WarehouseAction,
				initCollectionAction: WarehouseModelActionTypes.INITIALISE_WAREHOUSE_COLLECTION_STATE,
				fetchAllAction: WarehouseModelActionTypes.FETCH_ALL_WAREHOUSE,
				fetchWithQueryAction: WarehouseModelActionTypes.FETCH_WAREHOUSE_WITH_QUERY,
				fetchWithId: WarehouseModelActionTypes.FETCH_WAREHOUSE,
				collectionModelsSelector: getWarehouseCollectionModels,
			};
		case 'WarehouseInitialStockModel':
			return {
				baseAction: WarehouseInitialStockAction,
				initCollectionAction: WarehouseInitialStockModelActionTypes.INITIALISE_WAREHOUSE_INITIAL_STOCK_COLLECTION_STATE,
				fetchAllAction: WarehouseInitialStockModelActionTypes.FETCH_ALL_WAREHOUSE_INITIAL_STOCK,
				fetchWithQueryAction: WarehouseInitialStockModelActionTypes.FETCH_WAREHOUSE_INITIAL_STOCK_WITH_QUERY,
				fetchWithId: WarehouseInitialStockModelActionTypes.FETCH_WAREHOUSE_INITIAL_STOCK,
				collectionModelsSelector: getWarehouseInitialStockCollectionModels,
			};
		case 'WarehouseInventoryModel':
			return {
				baseAction: WarehouseInventoryAction,
				initCollectionAction: WarehouseInventoryModelActionTypes.INITIALISE_WAREHOUSE_INVENTORY_COLLECTION_STATE,
				fetchAllAction: WarehouseInventoryModelActionTypes.FETCH_ALL_WAREHOUSE_INVENTORY,
				fetchWithQueryAction: WarehouseInventoryModelActionTypes.FETCH_WAREHOUSE_INVENTORY_WITH_QUERY,
				fetchWithId: WarehouseInventoryModelActionTypes.FETCH_WAREHOUSE_INVENTORY,
				collectionModelsSelector: getWarehouseInventoryCollectionModels,
			};
		case 'WarehouseUserModel':
			return {
				baseAction: WarehouseUserAction,
				initCollectionAction: WarehouseUserModelActionTypes.INITIALISE_WAREHOUSE_USER_COLLECTION_STATE,
				fetchAllAction: WarehouseUserModelActionTypes.FETCH_ALL_WAREHOUSE_USER,
				fetchWithQueryAction: WarehouseUserModelActionTypes.FETCH_WAREHOUSE_USER_WITH_QUERY,
				fetchWithId: WarehouseUserModelActionTypes.FETCH_WAREHOUSE_USER,
				collectionModelsSelector: getWarehouseUserCollectionModels,
			};
		default: return null;
	}
}

// % protected region % [Add any additional methods here] off begin
// % protected region % [Add any additional methods here] end
