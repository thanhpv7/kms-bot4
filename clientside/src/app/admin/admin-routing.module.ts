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
import {AdminComponent} from './admin.component';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

const appRoutes: Routes = [
	{
		path: '',
		component: AdminComponent,
		children: [
			{
				path: '',
				pathMatch: 'full',
				loadChildren: () => import('./pages/adminHome/home.admin.page.module').then(m => m.AdminHomePageModule),
			},
			// Admin Crud tile for user and entities
			{
				path: 'users/administration-user',
				loadChildren: () => import('./tiles/crud/administrationUser/administration-user-admin-crud.module').then(m => m.AdminAdministrationUserCrudModule),
			},
			{
				path: 'users/administrator',
				loadChildren: () => import('./tiles/crud/administrator/administrator-admin-crud.module').then(m => m.AdminAdministratorCrudModule),
			},
			{
				path: 'entities/amendment-detail',
				loadChildren: () => import('./tiles/crud/amendmentDetail/amendment-detail-admin-crud.module').then(m => m.AdminAmendmentDetailCrudModule),
			},
			{
				path: 'entities/bpjs-accident-master',
				loadChildren: () => import('./tiles/crud/bpjsAccidentMaster/bpjs-accident-master-admin-crud.module').then(m => m.AdminBpjsAccidentMasterCrudModule),
			},
			{
				path: 'entities/bpjs-bed-availability',
				loadChildren: () => import('./tiles/crud/bpjsBedAvailability/bpjs-bed-availability-admin-crud.module').then(m => m.AdminBpjsBedAvailabilityCrudModule),
			},
			{
				path: 'entities/bpjs-claim-data',
				loadChildren: () => import('./tiles/crud/bpjsClaimData/bpjs-claim-data-admin-crud.module').then(m => m.AdminBpjsClaimDataCrudModule),
			},
			{
				path: 'entities/bpjs-claim-submission',
				loadChildren: () => import('./tiles/crud/bpjsClaimSubmission/bpjs-claim-submission-admin-crud.module').then(m => m.AdminBpjsClaimSubmissionCrudModule),
			},
			{
				path: 'entities/bpjs-control-plan',
				loadChildren: () => import('./tiles/crud/bpjsControlPlan/bpjs-control-plan-admin-crud.module').then(m => m.AdminBpjsControlPlanCrudModule),
			},
			{
				path: 'entities/bpjs-control-specialist',
				loadChildren: () => import('./tiles/crud/bpjsControlSpecialist/bpjs-control-specialist-admin-crud.module').then(m => m.AdminBpjsControlSpecialistCrudModule),
			},
			{
				path: 'entities/bpjs-diagnose',
				loadChildren: () => import('./tiles/crud/bpjsDiagnose/bpjs-diagnose-admin-crud.module').then(m => m.AdminBpjsDiagnoseCrudModule),
			},
			{
				path: 'entities/bpjs-diagnose-prb',
				loadChildren: () => import('./tiles/crud/bpjsDiagnosePRB/bpjs-diagnose-prb-admin-crud.module').then(m => m.AdminBpjsDiagnosePRBCrudModule),
			},
			{
				path: 'entities/bpjs-dismissal-condition',
				loadChildren: () => import('./tiles/crud/bpjsDismissalCondition/bpjs-dismissal-condition-admin-crud.module').then(m => m.AdminBpjsDismissalConditionCrudModule),
			},
			{
				path: 'entities/bpjs-dismissal-mapping',
				loadChildren: () => import('./tiles/crud/bpjsDismissalMapping/bpjs-dismissal-mapping-admin-crud.module').then(m => m.AdminBpjsDismissalMappingCrudModule),
			},
			{
				path: 'entities/bpjs-doctor-mapping',
				loadChildren: () => import('./tiles/crud/bpjsDoctorMapping/bpjs-doctor-mapping-admin-crud.module').then(m => m.AdminBpjsDoctorMappingCrudModule),
			},
			{
				path: 'entities/bpjs-doctor-schedule',
				loadChildren: () => import('./tiles/crud/bpjsDoctorSchedule/bpjs-doctor-schedule-admin-crud.module').then(m => m.AdminBpjsDoctorScheduleCrudModule),
			},
			{
				path: 'entities/bpjs-drug-generic-prb',
				loadChildren: () => import('./tiles/crud/bpjsDrugGenericPRB/bpjs-drug-generic-prb-admin-crud.module').then(m => m.AdminBpjsDrugGenericPRBCrudModule),
			},
			{
				path: 'entities/bpjs-facility-list',
				loadChildren: () => import('./tiles/crud/bpjsFacilityList/bpjs-facility-list-admin-crud.module').then(m => m.AdminBpjsFacilityListCrudModule),
			},
			{
				path: 'entities/bpjs-finger-print',
				loadChildren: () => import('./tiles/crud/bpjsFingerPrint/bpjs-finger-print-admin-crud.module').then(m => m.AdminBpjsFingerPrintCrudModule),
			},
			{
				path: 'entities/bpjs-general',
				loadChildren: () => import('./tiles/crud/bpjsGeneral/bpjs-general-admin-crud.module').then(m => m.AdminBpjsGeneralCrudModule),
			},
			{
				path: 'entities/bpjs-health-facility',
				loadChildren: () => import('./tiles/crud/bpjsHealthFacility/bpjs-health-facility-admin-crud.module').then(m => m.AdminBpjsHealthFacilityCrudModule),
			},
			{
				path: 'entities/bpjs-hospitalization-plan',
				loadChildren: () => import('./tiles/crud/bpjsHospitalizationPlan/bpjs-hospitalization-plan-admin-crud.module').then(m => m.AdminBpjsHospitalizationPlanCrudModule),
			},
			{
				path: 'entities/bpjs-inacbg',
				loadChildren: () => import('./tiles/crud/bpjsINACBG/bpjs-inacbg-admin-crud.module').then(m => m.AdminBpjsINACBGCrudModule),
			},
			{
				path: 'entities/bpjs-inacbg-claim',
				loadChildren: () => import('./tiles/crud/bpjsINACBGClaim/bpjs-inacbg-claim-admin-crud.module').then(m => m.AdminBpjsINACBGClaimCrudModule),
			},
			{
				path: 'entities/bpjs-inacbg-variable',
				loadChildren: () => import('./tiles/crud/bpjsINACBGVariable/bpjs-inacbg-variable-admin-crud.module').then(m => m.AdminBpjsINACBGVariableCrudModule),
			},
			{
				path: 'entities/bpjs-jasa-raharja',
				loadChildren: () => import('./tiles/crud/bpjsJasaRaharja/bpjs-jasa-raharja-admin-crud.module').then(m => m.AdminBpjsJasaRaharjaCrudModule),
			},
			{
				path: 'entities/bpjs-jasa-raharja-claim',
				loadChildren: () => import('./tiles/crud/bpjsJasaRaharjaClaim/bpjs-jasa-raharja-claim-admin-crud.module').then(m => m.AdminBpjsJasaRaharjaClaimCrudModule),
			},
			{
				path: 'entities/bpjs-list-finger-print',
				loadChildren: () => import('./tiles/crud/bpjsListFingerPrint/bpjs-list-finger-print-admin-crud.module').then(m => m.AdminBpjsListFingerPrintCrudModule),
			},
			{
				path: 'entities/bpjs-list-task',
				loadChildren: () => import('./tiles/crud/bpjsListTask/bpjs-list-task-admin-crud.module').then(m => m.AdminBpjsListTaskCrudModule),
			},
			{
				path: 'entities/bpjs-outside-facility-referral',
				loadChildren: () => import('./tiles/crud/bpjsOutsideFacilityReferral/bpjs-outside-facility-referral-admin-crud.module').then(m => m.AdminBpjsOutsideFacilityReferralCrudModule),
			},
			{
				path: 'entities/bpjs-prb',
				loadChildren: () => import('./tiles/crud/bpjsPRB/bpjs-prb-admin-crud.module').then(m => m.AdminBpjsPRBCrudModule),
			},
			{
				path: 'entities/bpjs-prb-detail',
				loadChildren: () => import('./tiles/crud/bpjsPRBDetail/bpjs-prb-detail-admin-crud.module').then(m => m.AdminBpjsPRBDetailCrudModule),
			},
			{
				path: 'entities/bpjs-patient-referral',
				loadChildren: () => import('./tiles/crud/bpjsPatientReferral/bpjs-patient-referral-admin-crud.module').then(m => m.AdminBpjsPatientReferralCrudModule),
			},
			{
				path: 'entities/bpjs-pcare-dpho',
				loadChildren: () => import('./tiles/crud/bpjsPcareDPHO/bpjs-pcare-dpho-admin-crud.module').then(m => m.AdminBpjsPcareDPHOCrudModule),
			},
			{
				path: 'entities/bpjs-pcare-kegiatan-kelompok',
				loadChildren: () => import('./tiles/crud/bpjsPcareKegiatanKelompok/bpjs-pcare-kegiatan-kelompok-admin-crud.module').then(m => m.AdminBpjsPcareKegiatanKelompokCrudModule),
			},
			{
				path: 'entities/bpjs-pcare-kesadaran',
				loadChildren: () => import('./tiles/crud/bpjsPcareKesadaran/bpjs-pcare-kesadaran-admin-crud.module').then(m => m.AdminBpjsPcareKesadaranCrudModule),
			},
			{
				path: 'entities/bpjs-pcare-peserta-kegiatan-kelompok',
				loadChildren: () => import('./tiles/crud/bpjsPcarePesertaKegiatanKelompok/bpjs-pcare-peserta-kegiatan-kelompok-admin-crud.module').then(m => m.AdminBpjsPcarePesertaKegiatanKelompokCrudModule),
			},
			{
				path: 'entities/bpjs-pcare-poli',
				loadChildren: () => import('./tiles/crud/bpjsPcarePoli/bpjs-pcare-poli-admin-crud.module').then(m => m.AdminBpjsPcarePoliCrudModule),
			},
			{
				path: 'entities/bpjs-pcare-provider-rayonisasi',
				loadChildren: () => import('./tiles/crud/bpjsPcareProviderRayonisasi/bpjs-pcare-provider-rayonisasi-admin-crud.module').then(m => m.AdminBpjsPcareProviderRayonisasiCrudModule),
			},
			{
				path: 'entities/bpjs-pcare-registrations',
				loadChildren: () => import('./tiles/crud/bpjsPcareRegistrations/bpjs-pcare-registrations-admin-crud.module').then(m => m.AdminBpjsPcareRegistrationsCrudModule),
			},
			{
				path: 'entities/bpjs-procedure',
				loadChildren: () => import('./tiles/crud/bpjsProcedure/bpjs-procedure-admin-crud.module').then(m => m.AdminBpjsProcedureCrudModule),
			},
			{
				path: 'entities/bpjs-referral-specialist',
				loadChildren: () => import('./tiles/crud/bpjsReferralSpecialist/bpjs-referral-specialist-admin-crud.module').then(m => m.AdminBpjsReferralSpecialistCrudModule),
			},
			{
				path: 'entities/bpjs-sep',
				loadChildren: () => import('./tiles/crud/bpjsSEP/bpjs-sep-admin-crud.module').then(m => m.AdminBpjsSEPCrudModule),
			},
			{
				path: 'entities/bpjs-sep-inacbg-integration',
				loadChildren: () => import('./tiles/crud/bpjsSEPINACBGIntegration/bpjs-sep-inacbg-integration-admin-crud.module').then(m => m.AdminBpjsSEPINACBGIntegrationCrudModule),
			},
			{
				path: 'entities/bpjs-sep-internal-data',
				loadChildren: () => import('./tiles/crud/bpjsSEPInternalData/bpjs-sep-internal-data-admin-crud.module').then(m => m.AdminBpjsSEPInternalDataCrudModule),
			},
			{
				path: 'entities/bpjs-sep-submission',
				loadChildren: () => import('./tiles/crud/bpjsSEPSubmission/bpjs-sep-submission-admin-crud.module').then(m => m.AdminBpjsSEPSubmissionCrudModule),
			},
			{
				path: 'entities/bpjs-search-control-letter',
				loadChildren: () => import('./tiles/crud/bpjsSearchControlLetter/bpjs-search-control-letter-admin-crud.module').then(m => m.AdminBpjsSearchControlLetterCrudModule),
			},
			{
				path: 'entities/bpjs-search-sep',
				loadChildren: () => import('./tiles/crud/bpjsSearchSEP/bpjs-search-sep-admin-crud.module').then(m => m.AdminBpjsSearchSEPCrudModule),
			},
			{
				path: 'entities/bpjs-service-mapping',
				loadChildren: () => import('./tiles/crud/bpjsServiceMapping/bpjs-service-mapping-admin-crud.module').then(m => m.AdminBpjsServiceMappingCrudModule),
			},
			{
				path: 'entities/bpjs-special-referral',
				loadChildren: () => import('./tiles/crud/bpjsSpecialReferral/bpjs-special-referral-admin-crud.module').then(m => m.AdminBpjsSpecialReferralCrudModule),
			},
			{
				path: 'entities/bpjs-total-referral-sep',
				loadChildren: () => import('./tiles/crud/bpjsTotalReferralSEP/bpjs-total-referral-sep-admin-crud.module').then(m => m.AdminBpjsTotalReferralSEPCrudModule),
			},
			{
				path: 'entities/bpjs-treatment-class-mapping',
				loadChildren: () => import('./tiles/crud/bpjsTreatmentClassMapping/bpjs-treatment-class-mapping-admin-crud.module').then(m => m.AdminBpjsTreatmentClassMappingCrudModule),
			},
			{
				path: 'entities/bpjs-treatment-history',
				loadChildren: () => import('./tiles/crud/bpjsTreatmentHistory/bpjs-treatment-history-admin-crud.module').then(m => m.AdminBpjsTreatmentHistoryCrudModule),
			},
			{
				path: 'entities/bpjs-treatment-room',
				loadChildren: () => import('./tiles/crud/bpjsTreatmentRoom/bpjs-treatment-room-admin-crud.module').then(m => m.AdminBpjsTreatmentRoomCrudModule),
			},
			{
				path: 'entities/bpjs-update-dismissal-date',
				loadChildren: () => import('./tiles/crud/bpjsUpdateDismissalDate/bpjs-update-dismissal-date-admin-crud.module').then(m => m.AdminBpjsUpdateDismissalDateCrudModule),
			},
			{
				path: 'entities/bpjs-visit-data',
				loadChildren: () => import('./tiles/crud/bpjsVisitData/bpjs-visit-data-admin-crud.module').then(m => m.AdminBpjsVisitDataCrudModule),
			},
			{
				path: 'entities/batch-stock-balance',
				loadChildren: () => import('./tiles/crud/batchStockBalance/batch-stock-balance-admin-crud.module').then(m => m.AdminBatchStockBalanceCrudModule),
			},
			{
				path: 'entities/batch-stock-balance-per-date',
				loadChildren: () => import('./tiles/crud/batchStockBalancePerDate/batch-stock-balance-per-date-admin-crud.module').then(m => m.AdminBatchStockBalancePerDateCrudModule),
			},
			{
				path: 'entities/batch-stock-transaction-detail',
				loadChildren: () => import('./tiles/crud/batchStockTransactionDetail/batch-stock-transaction-detail-admin-crud.module').then(m => m.AdminBatchStockTransactionDetailCrudModule),
			},
			{
				path: 'entities/bed-facility',
				loadChildren: () => import('./tiles/crud/bedFacility/bed-facility-admin-crud.module').then(m => m.AdminBedFacilityCrudModule),
			},
			{
				path: 'entities/bed-reserve',
				loadChildren: () => import('./tiles/crud/bedReserve/bed-reserve-admin-crud.module').then(m => m.AdminBedReserveCrudModule),
			},
			{
				path: 'entities/birth-history',
				loadChildren: () => import('./tiles/crud/birthHistory/birth-history-admin-crud.module').then(m => m.AdminBirthHistoryCrudModule),
			},
			{
				path: 'entities/body-chart-examination',
				loadChildren: () => import('./tiles/crud/bodyChartExamination/body-chart-examination-admin-crud.module').then(m => m.AdminBodyChartExaminationCrudModule),
			},
			{
				path: 'entities/bpjs-pcare-kunjungan-rujukan',
				loadChildren: () => import('./tiles/crud/bpjsPcareKunjunganRujukan/bpjs-pcare-kunjungan-rujukan-admin-crud.module').then(m => m.AdminBpjsPcareKunjunganRujukanCrudModule),
			},
			{
				path: 'entities/bpjs-pcare-pendaftaran',
				loadChildren: () => import('./tiles/crud/bpjsPcarePendaftaran/bpjs-pcare-pendaftaran-admin-crud.module').then(m => m.AdminBpjsPcarePendaftaranCrudModule),
			},
			{
				path: 'entities/bpjs-pcare-riwayat-kunjungan',
				loadChildren: () => import('./tiles/crud/bpjsPcareRiwayatKunjungan/bpjs-pcare-riwayat-kunjungan-admin-crud.module').then(m => m.AdminBpjsPcareRiwayatKunjunganCrudModule),
			},
			{
				path: 'entities/cash-allocation',
				loadChildren: () => import('./tiles/crud/cashAllocation/cash-allocation-admin-crud.module').then(m => m.AdminCashAllocationCrudModule),
			},
			{
				path: 'entities/cash-receipt',
				loadChildren: () => import('./tiles/crud/cashReceipt/cash-receipt-admin-crud.module').then(m => m.AdminCashReceiptCrudModule),
			},
			{
				path: 'entities/cash-refund',
				loadChildren: () => import('./tiles/crud/cashRefund/cash-refund-admin-crud.module').then(m => m.AdminCashRefundCrudModule),
			},
			{
				path: 'users/cashier-user',
				loadChildren: () => import('./tiles/crud/cashierUser/cashier-user-admin-crud.module').then(m => m.AdminCashierUserCrudModule),
			},
			{
				path: 'entities/catalogue-medical',
				loadChildren: () => import('./tiles/crud/catalogueMedical/catalogue-medical-admin-crud.module').then(m => m.AdminCatalogueMedicalCrudModule),
			},
			{
				path: 'entities/catalogue-non-medical',
				loadChildren: () => import('./tiles/crud/catalogueNonMedical/catalogue-non-medical-admin-crud.module').then(m => m.AdminCatalogueNonMedicalCrudModule),
			},
			{
				path: 'entities/catalogue-uom',
				loadChildren: () => import('./tiles/crud/catalogueUOM/catalogue-uom-admin-crud.module').then(m => m.AdminCatalogueUOMCrudModule),
			},
			{
				path: 'entities/chart-of-account',
				loadChildren: () => import('./tiles/crud/chartOfAccount/chart-of-account-admin-crud.module').then(m => m.AdminChartOfAccountCrudModule),
			},
			{
				path: 'entities/chart-of-account-mapping',
				loadChildren: () => import('./tiles/crud/chartOfAccountMapping/chart-of-account-mapping-admin-crud.module').then(m => m.AdminChartOfAccountMappingCrudModule),
			},
			{
				path: 'users/claim-user',
				loadChildren: () => import('./tiles/crud/claimUser/claim-user-admin-crud.module').then(m => m.AdminClaimUserCrudModule),
			},
			{
				path: 'entities/co-treating-doctor',
				loadChildren: () => import('./tiles/crud/coTreatingDoctor/co-treating-doctor-admin-crud.module').then(m => m.AdminCoTreatingDoctorCrudModule),
			},
			{
				path: 'entities/compound-prescription-detail',
				loadChildren: () => import('./tiles/crud/compoundPrescriptionDetail/compound-prescription-detail-admin-crud.module').then(m => m.AdminCompoundPrescriptionDetailCrudModule),
			},
			{
				path: 'entities/compound-prescription-item',
				loadChildren: () => import('./tiles/crud/compoundPrescriptionItem/compound-prescription-item-admin-crud.module').then(m => m.AdminCompoundPrescriptionItemCrudModule),
			},
			{
				path: 'entities/daily-care-cppt',
				loadChildren: () => import('./tiles/crud/dailyCareCPPT/daily-care-cppt-admin-crud.module').then(m => m.AdminDailyCareCPPTCrudModule),
			},
			{
				path: 'entities/delivery-medical-examination-record',
				loadChildren: () => import('./tiles/crud/deliveryMedicalExaminationRecord/delivery-medical-examination-record-admin-crud.module').then(m => m.AdminDeliveryMedicalExaminationRecordCrudModule),
			},
			{
				path: 'entities/delivery-progress',
				loadChildren: () => import('./tiles/crud/deliveryProgress/delivery-progress-admin-crud.module').then(m => m.AdminDeliveryProgressCrudModule),
			},
			{
				path: 'entities/diagnoses-and-procedures',
				loadChildren: () => import('./tiles/crud/diagnosesAndProcedures/diagnoses-and-procedures-admin-crud.module').then(m => m.AdminDiagnosesAndProceduresCrudModule),
			},
			{
				path: 'entities/diagnosis-examination-record',
				loadChildren: () => import('./tiles/crud/diagnosisExaminationRecord/diagnosis-examination-record-admin-crud.module').then(m => m.AdminDiagnosisExaminationRecordCrudModule),
			},
			{
				path: 'entities/diagnosis-nanda',
				loadChildren: () => import('./tiles/crud/diagnosisNanda/diagnosis-nanda-admin-crud.module').then(m => m.AdminDiagnosisNandaCrudModule),
			},
			{
				path: 'entities/diagnostic-examination-results',
				loadChildren: () => import('./tiles/crud/diagnosticExaminationResults/diagnostic-examination-results-admin-crud.module').then(m => m.AdminDiagnosticExaminationResultsCrudModule),
			},
			{
				path: 'entities/diagnostic-staff-examination-summary',
				loadChildren: () => import('./tiles/crud/diagnosticStaffExaminationSummary/diagnostic-staff-examination-summary-admin-crud.module').then(m => m.AdminDiagnosticStaffExaminationSummaryCrudModule),
			},
			{
				path: 'entities/diagnostic-support-general-configuration',
				loadChildren: () => import('./tiles/crud/diagnosticSupportGeneralConfiguration/diagnostic-support-general-configuration-admin-crud.module').then(m => m.AdminDiagnosticSupportGeneralConfigurationCrudModule),
			},
			{
				path: 'users/diagnostic-support-user',
				loadChildren: () => import('./tiles/crud/diagnosticSupportUser/diagnostic-support-user-admin-crud.module').then(m => m.AdminDiagnosticSupportUserCrudModule),
			},
			{
				path: 'entities/doctor-schedule',
				loadChildren: () => import('./tiles/crud/doctorSchedule/doctor-schedule-admin-crud.module').then(m => m.AdminDoctorScheduleCrudModule),
			},
			{
				path: 'users/doctor-user',
				loadChildren: () => import('./tiles/crud/doctorUser/doctor-user-admin-crud.module').then(m => m.AdminDoctorUserCrudModule),
			},
			{
				path: 'entities/ent-examination',
				loadChildren: () => import('./tiles/crud/entExamination/ent-examination-admin-crud.module').then(m => m.AdminEntExaminationCrudModule),
			},
			{
				path: 'entities/emergency-medical-examination-record',
				loadChildren: () => import('./tiles/crud/emergencyMedicalExaminationRecord/emergency-medical-examination-record-admin-crud.module').then(m => m.AdminEmergencyMedicalExaminationRecordCrudModule),
			},
			{
				path: 'entities/examination-group',
				loadChildren: () => import('./tiles/crud/examinationGroup/examination-group-admin-crud.module').then(m => m.AdminExaminationGroupCrudModule),
			},
			{
				path: 'entities/examination-item',
				loadChildren: () => import('./tiles/crud/examinationItem/examination-item-admin-crud.module').then(m => m.AdminExaminationItemCrudModule),
			},
			{
				path: 'entities/examination-item-detail',
				loadChildren: () => import('./tiles/crud/examinationItemDetail/examination-item-detail-admin-crud.module').then(m => m.AdminExaminationItemDetailCrudModule),
			},
			{
				path: 'entities/facility-history',
				loadChildren: () => import('./tiles/crud/facilityHistory/facility-history-admin-crud.module').then(m => m.AdminFacilityHistoryCrudModule),
			},
			{
				path: 'users/facility-user',
				loadChildren: () => import('./tiles/crud/facilityUser/facility-user-admin-crud.module').then(m => m.AdminFacilityUserCrudModule),
			},
			{
				path: 'entities/fluid-balance-detail',
				loadChildren: () => import('./tiles/crud/fluidBalanceDetail/fluid-balance-detail-admin-crud.module').then(m => m.AdminFluidBalanceDetailCrudModule),
			},
			{
				path: 'entities/formulir-konseling-tes-hiv',
				loadChildren: () => import('./tiles/crud/formulirKonselingTesHiv/formulir-konseling-tes-hiv-admin-crud.module').then(m => m.AdminFormulirKonselingTesHivCrudModule),
			},
			{
				path: 'entities/goods-receive-note',
				loadChildren: () => import('./tiles/crud/goodsReceiveNote/goods-receive-note-admin-crud.module').then(m => m.AdminGoodsReceiveNoteCrudModule),
			},
			{
				path: 'entities/goods-receive-note-batch',
				loadChildren: () => import('./tiles/crud/goodsReceiveNoteBatch/goods-receive-note-batch-admin-crud.module').then(m => m.AdminGoodsReceiveNoteBatchCrudModule),
			},
			{
				path: 'entities/goods-receive-note-item',
				loadChildren: () => import('./tiles/crud/goodsReceiveNoteItem/goods-receive-note-item-admin-crud.module').then(m => m.AdminGoodsReceiveNoteItemCrudModule),
			},
			{
				path: 'entities/health-facility',
				loadChildren: () => import('./tiles/crud/healthFacility/health-facility-admin-crud.module').then(m => m.AdminHealthFacilityCrudModule),
			},
			{
				path: 'entities/hemodialysis-examination',
				loadChildren: () => import('./tiles/crud/hemodialysisExamination/hemodialysis-examination-admin-crud.module').then(m => m.AdminHemodialysisExaminationCrudModule),
			},
			{
				path: 'entities/hemodialysis-monitoring',
				loadChildren: () => import('./tiles/crud/hemodialysisMonitoring/hemodialysis-monitoring-admin-crud.module').then(m => m.AdminHemodialysisMonitoringCrudModule),
			},
			{
				path: 'entities/hospital-branch-information',
				loadChildren: () => import('./tiles/crud/hospitalBranchInformation/hospital-branch-information-admin-crud.module').then(m => m.AdminHospitalBranchInformationCrudModule),
			},
			{
				path: 'entities/hospital-group-information',
				loadChildren: () => import('./tiles/crud/hospitalGroupInformation/hospital-group-information-admin-crud.module').then(m => m.AdminHospitalGroupInformationCrudModule),
			},
			{
				path: 'entities/icd-10',
				loadChildren: () => import('./tiles/crud/icd10/icd-10-admin-crud.module').then(m => m.AdminIcd10CrudModule),
			},
			{
				path: 'entities/icd-9-cm',
				loadChildren: () => import('./tiles/crud/icd9CM/icd-9-cm-admin-crud.module').then(m => m.AdminIcd9CMCrudModule),
			},
			{
				path: 'entities/informed-consent',
				loadChildren: () => import('./tiles/crud/informedConsent/informed-consent-admin-crud.module').then(m => m.AdminInformedConsentCrudModule),
			},
			{
				path: 'entities/inpatient-medical-examination-record',
				loadChildren: () => import('./tiles/crud/inpatientMedicalExaminationRecord/inpatient-medical-examination-record-admin-crud.module').then(m => m.AdminInpatientMedicalExaminationRecordCrudModule),
			},
			{
				path: 'entities/insurance-benefit-plan',
				loadChildren: () => import('./tiles/crud/insuranceBenefitPlan/insurance-benefit-plan-admin-crud.module').then(m => m.AdminInsuranceBenefitPlanCrudModule),
			},
			{
				path: 'entities/insurance-provider',
				loadChildren: () => import('./tiles/crud/insuranceProvider/insurance-provider-admin-crud.module').then(m => m.AdminInsuranceProviderCrudModule),
			},
			{
				path: 'entities/internal-order',
				loadChildren: () => import('./tiles/crud/internalOrder/internal-order-admin-crud.module').then(m => m.AdminInternalOrderCrudModule),
			},
			{
				path: 'entities/internal-order-stock-detail',
				loadChildren: () => import('./tiles/crud/internalOrderStockDetail/internal-order-stock-detail-admin-crud.module').then(m => m.AdminInternalOrderStockDetailCrudModule),
			},
			{
				path: 'entities/intraoperative-records',
				loadChildren: () => import('./tiles/crud/intraoperativeRecords/intraoperative-records-admin-crud.module').then(m => m.AdminIntraoperativeRecordsCrudModule),
			},
			{
				path: 'entities/inventory-adjusment-batch',
				loadChildren: () => import('./tiles/crud/inventoryAdjusmentBatch/inventory-adjusment-batch-admin-crud.module').then(m => m.AdminInventoryAdjusmentBatchCrudModule),
			},
			{
				path: 'entities/inventory-adjustment',
				loadChildren: () => import('./tiles/crud/inventoryAdjustment/inventory-adjustment-admin-crud.module').then(m => m.AdminInventoryAdjustmentCrudModule),
			},
			{
				path: 'entities/inventory-adjustment-item',
				loadChildren: () => import('./tiles/crud/inventoryAdjustmentItem/inventory-adjustment-item-admin-crud.module').then(m => m.AdminInventoryAdjustmentItemCrudModule),
			},
			{
				path: 'entities/inventory-batch-correction',
				loadChildren: () => import('./tiles/crud/inventoryBatchCorrection/inventory-batch-correction-admin-crud.module').then(m => m.AdminInventoryBatchCorrectionCrudModule),
			},
			{
				path: 'entities/inventory-batch-correction-item',
				loadChildren: () => import('./tiles/crud/inventoryBatchCorrectionItem/inventory-batch-correction-item-admin-crud.module').then(m => m.AdminInventoryBatchCorrectionItemCrudModule),
			},
			{
				path: 'entities/invoice',
				loadChildren: () => import('./tiles/crud/invoice/invoice-admin-crud.module').then(m => m.AdminInvoiceCrudModule),
			},
			{
				path: 'entities/invoice-item',
				loadChildren: () => import('./tiles/crud/invoiceItem/invoice-item-admin-crud.module').then(m => m.AdminInvoiceItemCrudModule),
			},
			{
				path: 'entities/invoice-item-component',
				loadChildren: () => import('./tiles/crud/invoiceItemComponent/invoice-item-component-admin-crud.module').then(m => m.AdminInvoiceItemComponentCrudModule),
			},
			{
				path: 'entities/invoice-payment-insurance',
				loadChildren: () => import('./tiles/crud/invoicePaymentInsurance/invoice-payment-insurance-admin-crud.module').then(m => m.AdminInvoicePaymentInsuranceCrudModule),
			},
			{
				path: 'entities/invoice-payment-other',
				loadChildren: () => import('./tiles/crud/invoicePaymentOther/invoice-payment-other-admin-crud.module').then(m => m.AdminInvoicePaymentOtherCrudModule),
			},
			{
				path: 'entities/invoice-payment-self-paying',
				loadChildren: () => import('./tiles/crud/invoicePaymentSelfPaying/invoice-payment-self-paying-admin-crud.module').then(m => m.AdminInvoicePaymentSelfPayingCrudModule),
			},
			{
				path: 'entities/invoice-summary',
				loadChildren: () => import('./tiles/crud/invoiceSummary/invoice-summary-admin-crud.module').then(m => m.AdminInvoiceSummaryCrudModule),
			},
			{
				path: 'entities/journal',
				loadChildren: () => import('./tiles/crud/journal/journal-admin-crud.module').then(m => m.AdminJournalCrudModule),
			},
			{
				path: 'entities/library',
				loadChildren: () => import('./tiles/crud/library/library-admin-crud.module').then(m => m.AdminLibraryCrudModule),
			},
			{
				path: 'entities/location',
				loadChildren: () => import('./tiles/crud/location/location-admin-crud.module').then(m => m.AdminLocationCrudModule),
			},
			{
				path: 'entities/mcu-package',
				loadChildren: () => import('./tiles/crud/mcuPackage/mcu-package-admin-crud.module').then(m => m.AdminMcuPackageCrudModule),
			},
			{
				path: 'entities/mcu-package-item',
				loadChildren: () => import('./tiles/crud/mcuPackageItem/mcu-package-item-admin-crud.module').then(m => m.AdminMcuPackageItemCrudModule),
			},
			{
				path: 'users/management-user',
				loadChildren: () => import('./tiles/crud/managementUser/management-user-admin-crud.module').then(m => m.AdminManagementUserCrudModule),
			},
			{
				path: 'entities/medical-certificate-discharge-resume',
				loadChildren: () => import('./tiles/crud/medicalCertificateDischargeResume/medical-certificate-discharge-resume-admin-crud.module').then(m => m.AdminMedicalCertificateDischargeResumeCrudModule),
			},
			{
				path: 'entities/medical-certificate-birth',
				loadChildren: () => import('./tiles/crud/medicalCertificateBirth/medical-certificate-birth-admin-crud.module').then(m => m.AdminMedicalCertificateBirthCrudModule),
			},
			{
				path: 'entities/medical-certificate-hospitalization',
				loadChildren: () => import('./tiles/crud/medicalCertificateHospitalization/medical-certificate-hospitalization-admin-crud.module').then(m => m.AdminMedicalCertificateHospitalizationCrudModule),
			},
			{
				path: 'entities/medical-certificate-medical-attendance',
				loadChildren: () => import('./tiles/crud/medicalCertificateMedicalAttendance/medical-certificate-medical-attendance-admin-crud.module').then(m => m.AdminMedicalCertificateMedicalAttendanceCrudModule),
			},
			{
				path: 'entities/medical-certificate-mental-health',
				loadChildren: () => import('./tiles/crud/medicalCertificateMentalHealth/medical-certificate-mental-health-admin-crud.module').then(m => m.AdminMedicalCertificateMentalHealthCrudModule),
			},
			{
				path: 'entities/medical-certificate-physical-health',
				loadChildren: () => import('./tiles/crud/medicalCertificatePhysicalHealth/medical-certificate-physical-health-admin-crud.module').then(m => m.AdminMedicalCertificatePhysicalHealthCrudModule),
			},
			{
				path: 'entities/medical-certificate-restricted-work',
				loadChildren: () => import('./tiles/crud/medicalCertificateRestrictedWork/medical-certificate-restricted-work-admin-crud.module').then(m => m.AdminMedicalCertificateRestrictedWorkCrudModule),
			},
			{
				path: 'entities/medical-certificate-sick-leave',
				loadChildren: () => import('./tiles/crud/medicalCertificateSickLeave/medical-certificate-sick-leave-admin-crud.module').then(m => m.AdminMedicalCertificateSickLeaveCrudModule),
			},
			{
				path: 'entities/medical-examination-record',
				loadChildren: () => import('./tiles/crud/medicalExaminationRecord/medical-examination-record-admin-crud.module').then(m => m.AdminMedicalExaminationRecordCrudModule),
			},
			{
				path: 'entities/medical-examination-record-discharge-summary',
				loadChildren: () => import('./tiles/crud/medicalExaminationRecordDischargeSummary/medical-examination-record-discharge-summary-admin-crud.module').then(m => m.AdminMedicalExaminationRecordDischargeSummaryCrudModule),
			},
			{
				path: 'entities/medical-fee',
				loadChildren: () => import('./tiles/crud/medicalFee/medical-fee-admin-crud.module').then(m => m.AdminMedicalFeeCrudModule),
			},
			{
				path: 'entities/medical-fee-item-component',
				loadChildren: () => import('./tiles/crud/medicalFeeItemComponent/medical-fee-item-component-admin-crud.module').then(m => m.AdminMedicalFeeItemComponentCrudModule),
			},
			{
				path: 'entities/medical-record-initial-checklist',
				loadChildren: () => import('./tiles/crud/medicalRecordInitialChecklist/medical-record-initial-checklist-admin-crud.module').then(m => m.AdminMedicalRecordInitialChecklistCrudModule),
			},
			{
				path: 'entities/medical-record-next-verification-checklist',
				loadChildren: () => import('./tiles/crud/medicalRecordNextVerificationChecklist/medical-record-next-verification-checklist-admin-crud.module').then(m => m.AdminMedicalRecordNextVerificationChecklistCrudModule),
			},
			{
				path: 'users/medical-record-user',
				loadChildren: () => import('./tiles/crud/medicalRecordUser/medical-record-user-admin-crud.module').then(m => m.AdminMedicalRecordUserCrudModule),
			},
			{
				path: 'users/medical-transcriber-user',
				loadChildren: () => import('./tiles/crud/medicalTranscriberUser/medical-transcriber-user-admin-crud.module').then(m => m.AdminMedicalTranscriberUserCrudModule),
			},
			{
				path: 'entities/medication-administered-history',
				loadChildren: () => import('./tiles/crud/medicationAdministeredHistory/medication-administered-history-admin-crud.module').then(m => m.AdminMedicationAdministeredHistoryCrudModule),
			},
			{
				path: 'entities/medication-compound',
				loadChildren: () => import('./tiles/crud/medicationCompound/medication-compound-admin-crud.module').then(m => m.AdminMedicationCompoundCrudModule),
			},
			{
				path: 'entities/medication-header',
				loadChildren: () => import('./tiles/crud/medicationHeader/medication-header-admin-crud.module').then(m => m.AdminMedicationHeaderCrudModule),
			},
			{
				path: 'entities/medication-item',
				loadChildren: () => import('./tiles/crud/medicationItem/medication-item-admin-crud.module').then(m => m.AdminMedicationItemCrudModule),
			},
			{
				path: 'entities/merchant',
				loadChildren: () => import('./tiles/crud/merchant/merchant-admin-crud.module').then(m => m.AdminMerchantCrudModule),
			},
			{
				path: 'entities/merchant-surcharge-and-fee',
				loadChildren: () => import('./tiles/crud/merchantSurchargeAndFee/merchant-surcharge-and-fee-admin-crud.module').then(m => m.AdminMerchantSurchargeAndFeeCrudModule),
			},
			{
				path: 'entities/nhis-claim',
				loadChildren: () => import('./tiles/crud/nhisClaim/nhis-claim-admin-crud.module').then(m => m.AdminNhisClaimCrudModule),
			},
			{
				path: 'entities/nhis-claim-gdrg-detail',
				loadChildren: () => import('./tiles/crud/nhisClaimGDRGDetail/nhis-claim-gdrg-detail-admin-crud.module').then(m => m.AdminNhisClaimGDRGDetailCrudModule),
			},
			{
				path: 'entities/nhis-claim-investigation-detail',
				loadChildren: () => import('./tiles/crud/nhisClaimInvestigationDetail/nhis-claim-investigation-detail-admin-crud.module').then(m => m.AdminNhisClaimInvestigationDetailCrudModule),
			},
			{
				path: 'entities/nhis-gdrg',
				loadChildren: () => import('./tiles/crud/nhisGDRG/nhis-gdrg-admin-crud.module').then(m => m.AdminNhisGDRGCrudModule),
			},
			{
				path: 'entities/nhis-investigation',
				loadChildren: () => import('./tiles/crud/nhisInvestigation/nhis-investigation-admin-crud.module').then(m => m.AdminNhisInvestigationCrudModule),
			},
			{
				path: 'entities/nhis-medicine',
				loadChildren: () => import('./tiles/crud/nhisMedicine/nhis-medicine-admin-crud.module').then(m => m.AdminNhisMedicineCrudModule),
			},
			{
				path: 'entities/nhis-service-outcome',
				loadChildren: () => import('./tiles/crud/nhisServiceOutcome/nhis-service-outcome-admin-crud.module').then(m => m.AdminNhisServiceOutcomeCrudModule),
			},
			{
				path: 'entities/nhis-specialty-attended',
				loadChildren: () => import('./tiles/crud/nhisSpecialtyAttended/nhis-specialty-attended-admin-crud.module').then(m => m.AdminNhisSpecialtyAttendedCrudModule),
			},
			{
				path: 'entities/nhis-type-of-service',
				loadChildren: () => import('./tiles/crud/nhisTypeOfService/nhis-type-of-service-admin-crud.module').then(m => m.AdminNhisTypeOfServiceCrudModule),
			},
			{
				path: 'entities/newborn-detail',
				loadChildren: () => import('./tiles/crud/newbornDetail/newborn-detail-admin-crud.module').then(m => m.AdminNewbornDetailCrudModule),
			},
			{
				path: 'entities/numbering-setup',
				loadChildren: () => import('./tiles/crud/numberingSetup/numbering-setup-admin-crud.module').then(m => m.AdminNumberingSetupCrudModule),
			},
			{
				path: 'users/nurse-user',
				loadChildren: () => import('./tiles/crud/nurseUser/nurse-user-admin-crud.module').then(m => m.AdminNurseUserCrudModule),
			},
			{
				path: 'entities/nurse-vital-sign-measurement',
				loadChildren: () => import('./tiles/crud/nurseVitalSignMeasurement/nurse-vital-sign-measurement-admin-crud.module').then(m => m.AdminNurseVitalSignMeasurementCrudModule),
			},
			{
				path: 'entities/obstetric-and-gynecology-history',
				loadChildren: () => import('./tiles/crud/obstetricAndGynecologyHistory/obstetric-and-gynecology-history-admin-crud.module').then(m => m.AdminObstetricAndGynecologyHistoryCrudModule),
			},
			{
				path: 'entities/odontogram-examination',
				loadChildren: () => import('./tiles/crud/odontogramExamination/odontogram-examination-admin-crud.module').then(m => m.AdminOdontogramExaminationCrudModule),
			},
			{
				path: 'entities/operating-theater-medical-examination-record',
				loadChildren: () => import('./tiles/crud/operatingTheaterMedicalExaminationRecord/operating-theater-medical-examination-record-admin-crud.module').then(m => m.AdminOperatingTheaterMedicalExaminationRecordCrudModule),
			},
			{
				path: 'entities/ophthalmology-examination',
				loadChildren: () => import('./tiles/crud/ophthalmologyExamination/ophthalmology-examination-admin-crud.module').then(m => m.AdminOphthalmologyExaminationCrudModule),
			},
			{
				path: 'entities/pcare-action-examination',
				loadChildren: () => import('./tiles/crud/pcareActionExamination/pcare-action-examination-admin-crud.module').then(m => m.AdminPcareActionExaminationCrudModule),
			},
			{
				path: 'entities/pcare-club-prolanis',
				loadChildren: () => import('./tiles/crud/pcareClubProlanis/pcare-club-prolanis-admin-crud.module').then(m => m.AdminPcareClubProlanisCrudModule),
			},
			{
				path: 'entities/pcare-compound-drug',
				loadChildren: () => import('./tiles/crud/pcareCompoundDrug/pcare-compound-drug-admin-crud.module').then(m => m.AdminPcareCompoundDrugCrudModule),
			},
			{
				path: 'entities/pcare-compound-drug-item',
				loadChildren: () => import('./tiles/crud/pcareCompoundDrugItem/pcare-compound-drug-item-admin-crud.module').then(m => m.AdminPcareCompoundDrugItemCrudModule),
			},
			{
				path: 'entities/pcare-diagnosa',
				loadChildren: () => import('./tiles/crud/pcareDiagnosa/pcare-diagnosa-admin-crud.module').then(m => m.AdminPcareDiagnosaCrudModule),
			},
			{
				path: 'entities/pcare-dokter',
				loadChildren: () => import('./tiles/crud/pcareDokter/pcare-dokter-admin-crud.module').then(m => m.AdminPcareDokterCrudModule),
			},
			{
				path: 'entities/pcare-examination',
				loadChildren: () => import('./tiles/crud/pcareExamination/pcare-examination-admin-crud.module').then(m => m.AdminPcareExaminationCrudModule),
			},
			{
				path: 'entities/pcare-mcu',
				loadChildren: () => import('./tiles/crud/pcareMCU/pcare-mcu-admin-crud.module').then(m => m.AdminPcareMCUCrudModule),
			},
			{
				path: 'entities/pcare-noncompound-drug',
				loadChildren: () => import('./tiles/crud/pcareNonCompoundDrug/pcare-noncompound-drug-admin-crud.module').then(m => m.AdminPcareNonCompoundDrugCrudModule),
			},
			{
				path: 'entities/pcare-referensi-sarana',
				loadChildren: () => import('./tiles/crud/pcareReferensiSarana/pcare-referensi-sarana-admin-crud.module').then(m => m.AdminPcareReferensiSaranaCrudModule),
			},
			{
				path: 'entities/pcare-status-pulang',
				loadChildren: () => import('./tiles/crud/pcareStatusPulang/pcare-status-pulang-admin-crud.module').then(m => m.AdminPcareStatusPulangCrudModule),
			},
			{
				path: 'entities/pcare-tindakan',
				loadChildren: () => import('./tiles/crud/pcareTindakan/pcare-tindakan-admin-crud.module').then(m => m.AdminPcareTindakanCrudModule),
			},
			{
				path: 'entities/pcare-umum',
				loadChildren: () => import('./tiles/crud/pcareUmum/pcare-umum-admin-crud.module').then(m => m.AdminPcareUmumCrudModule),
			},
			{
				path: 'entities/patient-case-history',
				loadChildren: () => import('./tiles/crud/patientCaseHistory/patient-case-history-admin-crud.module').then(m => m.AdminPatientCaseHistoryCrudModule),
			},
			{
				path: 'entities/patient-consent',
				loadChildren: () => import('./tiles/crud/patientConsent/patient-consent-admin-crud.module').then(m => m.AdminPatientConsentCrudModule),
			},
			{
				path: 'entities/patient-contact-info',
				loadChildren: () => import('./tiles/crud/patientContactInfo/patient-contact-info-admin-crud.module').then(m => m.AdminPatientContactInfoCrudModule),
			},
			{
				path: 'entities/patient-detail',
				loadChildren: () => import('./tiles/crud/patientDetail/patient-detail-admin-crud.module').then(m => m.AdminPatientDetailCrudModule),
			},
			{
				path: 'entities/patient-detail-address',
				loadChildren: () => import('./tiles/crud/patientDetailAddress/patient-detail-address-admin-crud.module').then(m => m.AdminPatientDetailAddressCrudModule),
			},
			{
				path: 'entities/patient-emergency-contact-detail',
				loadChildren: () => import('./tiles/crud/patientEmergencyContactDetail/patient-emergency-contact-detail-admin-crud.module').then(m => m.AdminPatientEmergencyContactDetailCrudModule),
			},
			{
				path: 'entities/patient-employment-detail',
				loadChildren: () => import('./tiles/crud/patientEmploymentDetail/patient-employment-detail-admin-crud.module').then(m => m.AdminPatientEmploymentDetailCrudModule),
			},
			{
				path: 'entities/patient-general-info',
				loadChildren: () => import('./tiles/crud/patientGeneralInfo/patient-general-info-admin-crud.module').then(m => m.AdminPatientGeneralInfoCrudModule),
			},
			{
				path: 'entities/patient-payment-self-paying',
				loadChildren: () => import('./tiles/crud/patientPaymentSelfPaying/patient-payment-self-paying-admin-crud.module').then(m => m.AdminPatientPaymentSelfPayingCrudModule),
			},
			{
				path: 'entities/patient-payment-bpjs',
				loadChildren: () => import('./tiles/crud/patientPaymentBPJS/patient-payment-bpjs-admin-crud.module').then(m => m.AdminPatientPaymentBPJSCrudModule),
			},
			{
				path: 'entities/patient-payment-insurance',
				loadChildren: () => import('./tiles/crud/patientPaymentInsurance/patient-payment-insurance-admin-crud.module').then(m => m.AdminPatientPaymentInsuranceCrudModule),
			},
			{
				path: 'entities/patient-payment-others',
				loadChildren: () => import('./tiles/crud/patientPaymentOthers/patient-payment-others-admin-crud.module').then(m => m.AdminPatientPaymentOthersCrudModule),
			},
			{
				path: 'entities/patient-personal-info',
				loadChildren: () => import('./tiles/crud/patientPersonalInfo/patient-personal-info-admin-crud.module').then(m => m.AdminPatientPersonalInfoCrudModule),
			},
			{
				path: 'entities/patient-supporting-document',
				loadChildren: () => import('./tiles/crud/patientSupportingDocument/patient-supporting-document-admin-crud.module').then(m => m.AdminPatientSupportingDocumentCrudModule),
			},
			{
				path: 'entities/patient-visit',
				loadChildren: () => import('./tiles/crud/patientVisit/patient-visit-admin-crud.module').then(m => m.AdminPatientVisitCrudModule),
			},
			{
				path: 'entities/patient-visit-patient-payment-insurance',
				loadChildren: () => import('./tiles/crud/patientVisitPatientPaymentInsurance/patient-visit-patient-payment-insurance-admin-crud.module').then(m => m.AdminPatientVisitPatientPaymentInsuranceCrudModule),
			},
			{
				path: 'entities/patient-visit-patient-payment-others',
				loadChildren: () => import('./tiles/crud/patientVisitPatientPaymentOthers/patient-visit-patient-payment-others-admin-crud.module').then(m => m.AdminPatientVisitPatientPaymentOthersCrudModule),
			},
			{
				path: 'entities/patient-visit-payment-self-paying',
				loadChildren: () => import('./tiles/crud/patientVisitPaymentSelfPaying/patient-visit-payment-self-paying-admin-crud.module').then(m => m.AdminPatientVisitPaymentSelfPayingCrudModule),
			},
			{
				path: 'entities/patient-vital-information',
				loadChildren: () => import('./tiles/crud/patientVitalInformation/patient-vital-information-admin-crud.module').then(m => m.AdminPatientVitalInformationCrudModule),
			},
			{
				path: 'entities/pharmacy-setup',
				loadChildren: () => import('./tiles/crud/pharmacySetup/pharmacy-setup-admin-crud.module').then(m => m.AdminPharmacySetupCrudModule),
			},
			{
				path: 'users/pharmacy-user',
				loadChildren: () => import('./tiles/crud/pharmacyUser/pharmacy-user-admin-crud.module').then(m => m.AdminPharmacyUserCrudModule),
			},
			{
				path: 'entities/post-operative-details',
				loadChildren: () => import('./tiles/crud/postOperativeDetails/post-operative-details-admin-crud.module').then(m => m.AdminPostOperativeDetailsCrudModule),
			},
			{
				path: 'entities/preoperative-records',
				loadChildren: () => import('./tiles/crud/preoperativeRecords/preoperative-records-admin-crud.module').then(m => m.AdminPreoperativeRecordsCrudModule),
			},
			{
				path: 'entities/prescription-compound',
				loadChildren: () => import('./tiles/crud/prescriptionCompound/prescription-compound-admin-crud.module').then(m => m.AdminPrescriptionCompoundCrudModule),
			},
			{
				path: 'entities/prescription-header',
				loadChildren: () => import('./tiles/crud/prescriptionHeader/prescription-header-admin-crud.module').then(m => m.AdminPrescriptionHeaderCrudModule),
			},
			{
				path: 'entities/prescription-item',
				loadChildren: () => import('./tiles/crud/prescriptionItem/prescription-item-admin-crud.module').then(m => m.AdminPrescriptionItemCrudModule),
			},
			{
				path: 'entities/price-component',
				loadChildren: () => import('./tiles/crud/priceComponent/price-component-admin-crud.module').then(m => m.AdminPriceComponentCrudModule),
			},
			{
				path: 'entities/process-workflow',
				loadChildren: () => import('./tiles/crud/processWorkflow/process-workflow-admin-crud.module').then(m => m.AdminProcessWorkflowCrudModule),
			},
			{
				path: 'entities/purchase-order',
				loadChildren: () => import('./tiles/crud/purchaseOrder/purchase-order-admin-crud.module').then(m => m.AdminPurchaseOrderCrudModule),
			},
			{
				path: 'entities/purchase-order-stock-detail',
				loadChildren: () => import('./tiles/crud/purchaseOrderStockDetail/purchase-order-stock-detail-admin-crud.module').then(m => m.AdminPurchaseOrderStockDetailCrudModule),
			},
			{
				path: 'entities/purchase-requisition',
				loadChildren: () => import('./tiles/crud/purchaseRequisition/purchase-requisition-admin-crud.module').then(m => m.AdminPurchaseRequisitionCrudModule),
			},
			{
				path: 'entities/purchase-requisition-stock-detail',
				loadChildren: () => import('./tiles/crud/purchaseRequisitionStockDetail/purchase-requisition-stock-detail-admin-crud.module').then(m => m.AdminPurchaseRequisitionStockDetailCrudModule),
			},
			{
				path: 'users/purchasing-user',
				loadChildren: () => import('./tiles/crud/purchasingUser/purchasing-user-admin-crud.module').then(m => m.AdminPurchasingUserCrudModule),
			},
			{
				path: 'entities/reference-data',
				loadChildren: () => import('./tiles/crud/referenceData/reference-data-admin-crud.module').then(m => m.AdminReferenceDataCrudModule),
			},
			{
				path: 'entities/reference-header',
				loadChildren: () => import('./tiles/crud/referenceHeader/reference-header-admin-crud.module').then(m => m.AdminReferenceHeaderCrudModule),
			},
			{
				path: 'entities/registration',
				loadChildren: () => import('./tiles/crud/registration/registration-admin-crud.module').then(m => m.AdminRegistrationCrudModule),
			},
			{
				path: 'users/registration-user',
				loadChildren: () => import('./tiles/crud/registrationUser/registration-user-admin-crud.module').then(m => m.AdminRegistrationUserCrudModule),
			},
			{
				path: 'entities/retail-pharmacy',
				loadChildren: () => import('./tiles/crud/retailPharmacy/retail-pharmacy-admin-crud.module').then(m => m.AdminRetailPharmacyCrudModule),
			},
			{
				path: 'entities/retail-pharmacy-invoice',
				loadChildren: () => import('./tiles/crud/retailPharmacyInvoice/retail-pharmacy-invoice-admin-crud.module').then(m => m.AdminRetailPharmacyInvoiceCrudModule),
			},
			{
				path: 'entities/retail-pharmacy-stock-detail',
				loadChildren: () => import('./tiles/crud/retailPharmacyStockDetail/retail-pharmacy-stock-detail-admin-crud.module').then(m => m.AdminRetailPharmacyStockDetailCrudModule),
			},
			{
				path: 'entities/return-supplier',
				loadChildren: () => import('./tiles/crud/returnSupplier/return-supplier-admin-crud.module').then(m => m.AdminReturnSupplierCrudModule),
			},
			{
				path: 'entities/return-supplier-stock-detail',
				loadChildren: () => import('./tiles/crud/returnSupplierStockDetail/return-supplier-stock-detail-admin-crud.module').then(m => m.AdminReturnSupplierStockDetailCrudModule),
			},
			{
				path: 'entities/room-facility',
				loadChildren: () => import('./tiles/crud/roomFacility/room-facility-admin-crud.module').then(m => m.AdminRoomFacilityCrudModule),
			},
			{
				path: 'entities/room-transfer',
				loadChildren: () => import('./tiles/crud/roomTransfer/room-transfer-admin-crud.module').then(m => m.AdminRoomTransferCrudModule),
			},
			{
				path: 'entities/sep',
				loadChildren: () => import('./tiles/crud/sep/sep-admin-crud.module').then(m => m.AdminSepCrudModule),
			},
			{
				path: 'entities/sample-collection-information',
				loadChildren: () => import('./tiles/crud/sampleCollectionInformation/sample-collection-information-admin-crud.module').then(m => m.AdminSampleCollectionInformationCrudModule),
			},
			{
				path: 'entities/sample-collection-items',
				loadChildren: () => import('./tiles/crud/sampleCollectionItems/sample-collection-items-admin-crud.module').then(m => m.AdminSampleCollectionItemsCrudModule),
			},
			{
				path: 'entities/satu-sehat-configuration',
				loadChildren: () => import('./tiles/crud/satuSehatConfiguration/satu-sehat-configuration-admin-crud.module').then(m => m.AdminSatuSehatConfigurationCrudModule),
			},
			{
				path: 'entities/service',
				loadChildren: () => import('./tiles/crud/service/service-admin-crud.module').then(m => m.AdminServiceCrudModule),
			},
			{
				path: 'entities/service-facility-category',
				loadChildren: () => import('./tiles/crud/serviceFacilityCategory/service-facility-category-admin-crud.module').then(m => m.AdminServiceFacilityCategoryCrudModule),
			},
			{
				path: 'entities/service-item',
				loadChildren: () => import('./tiles/crud/serviceItem/service-item-admin-crud.module').then(m => m.AdminServiceItemCrudModule),
			},
			{
				path: 'entities/service-item-assignment',
				loadChildren: () => import('./tiles/crud/serviceItemAssignment/service-item-assignment-admin-crud.module').then(m => m.AdminServiceItemAssignmentCrudModule),
			},
			{
				path: 'entities/staff',
				loadChildren: () => import('./tiles/crud/staff/staff-admin-crud.module').then(m => m.AdminStaffCrudModule),
			},
			{
				path: 'entities/stock-catalogue',
				loadChildren: () => import('./tiles/crud/stockCatalogue/stock-catalogue-admin-crud.module').then(m => m.AdminStockCatalogueCrudModule),
			},
			{
				path: 'entities/stock-control',
				loadChildren: () => import('./tiles/crud/stockControl/stock-control-admin-crud.module').then(m => m.AdminStockControlCrudModule),
			},
			{
				path: 'entities/stock-transaction-detail',
				loadChildren: () => import('./tiles/crud/stockTransactionDetail/stock-transaction-detail-admin-crud.module').then(m => m.AdminStockTransactionDetailCrudModule),
			},
			{
				path: 'entities/stock-transaction-per-date',
				loadChildren: () => import('./tiles/crud/stockTransactionPerDate/stock-transaction-per-date-admin-crud.module').then(m => m.AdminStockTransactionPerDateCrudModule),
			},
			{
				path: 'entities/stock-transaction-per-date-type',
				loadChildren: () => import('./tiles/crud/stockTransactionPerDateType/stock-transaction-per-date-type-admin-crud.module').then(m => m.AdminStockTransactionPerDateTypeCrudModule),
			},
			{
				path: 'entities/supplier',
				loadChildren: () => import('./tiles/crud/supplier/supplier-admin-crud.module').then(m => m.AdminSupplierCrudModule),
			},
			{
				path: 'entities/supplier-bank-account',
				loadChildren: () => import('./tiles/crud/supplierBankAccount/supplier-bank-account-admin-crud.module').then(m => m.AdminSupplierBankAccountCrudModule),
			},
			{
				path: 'entities/supplier-contact-detail',
				loadChildren: () => import('./tiles/crud/supplierContactDetail/supplier-contact-detail-admin-crud.module').then(m => m.AdminSupplierContactDetailCrudModule),
			},
			{
				path: 'entities/supplier-product-detail',
				loadChildren: () => import('./tiles/crud/supplierProductDetail/supplier-product-detail-admin-crud.module').then(m => m.AdminSupplierProductDetailCrudModule),
			},
			{
				path: 'users/system-admin-user',
				loadChildren: () => import('./tiles/crud/systemAdminUser/system-admin-user-admin-crud.module').then(m => m.AdminSystemAdminUserCrudModule),
			},
			{
				path: 'entities/tariff-definition',
				loadChildren: () => import('./tiles/crud/tariffDefinition/tariff-definition-admin-crud.module').then(m => m.AdminTariffDefinitionCrudModule),
			},
			{
				path: 'entities/tariff-definition-other-component',
				loadChildren: () => import('./tiles/crud/tariffDefinitionOtherComponent/tariff-definition-other-component-admin-crud.module').then(m => m.AdminTariffDefinitionOtherComponentCrudModule),
			},
			{
				path: 'entities/tariff-formula',
				loadChildren: () => import('./tiles/crud/tariffFormula/tariff-formula-admin-crud.module').then(m => m.AdminTariffFormulaCrudModule),
			},
			{
				path: 'entities/tariff-package',
				loadChildren: () => import('./tiles/crud/tariffPackage/tariff-package-admin-crud.module').then(m => m.AdminTariffPackageCrudModule),
			},
			{
				path: 'entities/tariff-package-item',
				loadChildren: () => import('./tiles/crud/tariffPackageItem/tariff-package-item-admin-crud.module').then(m => m.AdminTariffPackageItemCrudModule),
			},
			{
				path: 'entities/tariff-package-service-assignment',
				loadChildren: () => import('./tiles/crud/tariffPackageServiceAssignment/tariff-package-service-assignment-admin-crud.module').then(m => m.AdminTariffPackageServiceAssignmentCrudModule),
			},
			{
				path: 'entities/tariff-schema',
				loadChildren: () => import('./tiles/crud/tariffSchema/tariff-schema-admin-crud.module').then(m => m.AdminTariffSchemaCrudModule),
			},
			{
				path: 'entities/task-dashboard',
				loadChildren: () => import('./tiles/crud/taskDashboard/task-dashboard-admin-crud.module').then(m => m.AdminTaskDashboardCrudModule),
			},
			{
				path: 'entities/transaction-detail-type',
				loadChildren: () => import('./tiles/crud/transactionDetailType/transaction-detail-type-admin-crud.module').then(m => m.AdminTransactionDetailTypeCrudModule),
			},
			{
				path: 'entities/transaction-detail-type-mapping',
				loadChildren: () => import('./tiles/crud/transactionDetailTypeMapping/transaction-detail-type-mapping-admin-crud.module').then(m => m.AdminTransactionDetailTypeMappingCrudModule),
			},
			{
				path: 'entities/transfer-order',
				loadChildren: () => import('./tiles/crud/transferOrder/transfer-order-admin-crud.module').then(m => m.AdminTransferOrderCrudModule),
			},
			{
				path: 'entities/transfer-order-stock-detail',
				loadChildren: () => import('./tiles/crud/transferOrderStockDetail/transfer-order-stock-detail-admin-crud.module').then(m => m.AdminTransferOrderStockDetailCrudModule),
			},
			{
				path: 'entities/unit-of-measurement',
				loadChildren: () => import('./tiles/crud/unitOfMeasurement/unit-of-measurement-admin-crud.module').then(m => m.AdminUnitOfMeasurementCrudModule),
			},
			{
				path: 'users/user',
				loadChildren: () => import('./tiles/crud/user/user-admin-crud.module').then(m => m.AdminUserCrudModule),
			},
			{
				path: 'entities/vaccination-order',
				loadChildren: () => import('./tiles/crud/vaccinationOrder/vaccination-order-admin-crud.module').then(m => m.AdminVaccinationOrderCrudModule),
			},
			{
				path: 'entities/vaccination-order-detail',
				loadChildren: () => import('./tiles/crud/vaccinationOrderDetail/vaccination-order-detail-admin-crud.module').then(m => m.AdminVaccinationOrderDetailCrudModule),
			},
			{
				path: 'entities/vital-signs',
				loadChildren: () => import('./tiles/crud/vitalSigns/vital-signs-admin-crud.module').then(m => m.AdminVitalSignsCrudModule),
			},
			{
				path: 'entities/warehouse',
				loadChildren: () => import('./tiles/crud/warehouse/warehouse-admin-crud.module').then(m => m.AdminWarehouseCrudModule),
			},
			{
				path: 'entities/warehouse-initial-stock',
				loadChildren: () => import('./tiles/crud/warehouseInitialStock/warehouse-initial-stock-admin-crud.module').then(m => m.AdminWarehouseInitialStockCrudModule),
			},
			{
				path: 'entities/warehouse-inventory',
				loadChildren: () => import('./tiles/crud/warehouseInventory/warehouse-inventory-admin-crud.module').then(m => m.AdminWarehouseInventoryCrudModule),
			},
			{
				path: 'users/warehouse-user',
				loadChildren: () => import('./tiles/crud/warehouseUser/warehouse-user-admin-crud.module').then(m => m.AdminWarehouseUserCrudModule),
			},

			// behviours
		]
	}
];

@NgModule({
	declarations: [
		// % protected region % [Add any additional declarations here] off begin
		// % protected region % [Add any additional declarations here] end
	],
	imports: [
		RouterModule.forChild(appRoutes),
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
export class AdminRoutingModule { }
