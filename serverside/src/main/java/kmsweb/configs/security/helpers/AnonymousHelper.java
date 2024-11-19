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
package kmsweb.configs.security.helpers;

import kmsweb.configs.security.authorities.CustomGrantedAuthority;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Helper class exists to run piece of code with elevated permission. This class is required for some of the
 * functionality in the application, such as login or insert test data. Otherwise the application will reject any
 * attempts to interact with the database since authentication is needed (and thus the "you can't login because you're
 * not logged in" problem).
 * <p>
 * <strong>Important note</strong>: This class is not meant to be used unless absolutely necessary. Developers should
 * adopt best security practices instead of using this as a work around security.
 */
public final class AnonymousHelper {
	/**
	 * Anonymous user with elevated permissions in order to satisfy the security checking.
	 */
	private static final Authentication anonymousUser = setupAnonymousUser();

	/**
	 * Create and return an anonymous user with elevated permissions. Note that this will only get runs once.
	 *
	 * @return an anonymous user with elevated permissions.
	 */
	private static Authentication setupAnonymousUser() {
		List<CustomGrantedAuthority> authorities = new ArrayList<>();

		CustomGrantedAuthority administrationUserAuthority = new CustomGrantedAuthority(
				"ROLE_ADMINISTRATION_USER",
				"AdministrationUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(administrationUserAuthority);

		CustomGrantedAuthority administratorAuthority = new CustomGrantedAuthority(
				"ROLE_ADMINISTRATOR",
				"AdministratorEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(administratorAuthority);

		CustomGrantedAuthority amendmentDetailAuthority = new CustomGrantedAuthority(
				"ROLE_AMENDMENT_DETAIL",
				"AmendmentDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(amendmentDetailAuthority);

		CustomGrantedAuthority bpjsAccidentMasterAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_ACCIDENT_MASTER",
				"BpjsAccidentMasterEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsAccidentMasterAuthority);

		CustomGrantedAuthority bpjsBedAvailabilityAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_BED_AVAILABILITY",
				"BpjsBedAvailabilityEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsBedAvailabilityAuthority);

		CustomGrantedAuthority bpjsClaimDataAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_CLAIM_DATA",
				"BpjsClaimDataEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsClaimDataAuthority);

		CustomGrantedAuthority bpjsClaimSubmissionAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_CLAIM_SUBMISSION",
				"BpjsClaimSubmissionEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsClaimSubmissionAuthority);

		CustomGrantedAuthority bpjsControlPlanAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_CONTROL_PLAN",
				"BpjsControlPlanEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsControlPlanAuthority);

		CustomGrantedAuthority bpjsControlSpecialistAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_CONTROL_SPECIALIST",
				"BpjsControlSpecialistEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsControlSpecialistAuthority);

		CustomGrantedAuthority bpjsDiagnoseAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_DIAGNOSE",
				"BpjsDiagnoseEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsDiagnoseAuthority);

		CustomGrantedAuthority bpjsDiagnosePRBAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_DIAGNOSE_PRB",
				"BpjsDiagnosePRBEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsDiagnosePRBAuthority);

		CustomGrantedAuthority bpjsDismissalConditionAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_DISMISSAL_CONDITION",
				"BpjsDismissalConditionEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsDismissalConditionAuthority);

		CustomGrantedAuthority bpjsDismissalMappingAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_DISMISSAL_MAPPING",
				"BpjsDismissalMappingEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsDismissalMappingAuthority);

		CustomGrantedAuthority bpjsDoctorMappingAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_DOCTOR_MAPPING",
				"BpjsDoctorMappingEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsDoctorMappingAuthority);

		CustomGrantedAuthority bpjsDoctorScheduleAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_DOCTOR_SCHEDULE",
				"BpjsDoctorScheduleEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsDoctorScheduleAuthority);

		CustomGrantedAuthority bpjsDrugGenericPRBAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_DRUG_GENERIC_PRB",
				"BpjsDrugGenericPRBEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsDrugGenericPRBAuthority);

		CustomGrantedAuthority bpjsFacilityListAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_FACILITY_LIST",
				"BpjsFacilityListEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsFacilityListAuthority);

		CustomGrantedAuthority bpjsFingerPrintAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_FINGER_PRINT",
				"BpjsFingerPrintEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsFingerPrintAuthority);

		CustomGrantedAuthority bpjsGeneralAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_GENERAL",
				"BpjsGeneralEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsGeneralAuthority);

		CustomGrantedAuthority bpjsHealthFacilityAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_HEALTH_FACILITY",
				"BpjsHealthFacilityEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsHealthFacilityAuthority);

		CustomGrantedAuthority bpjsHospitalizationPlanAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_HOSPITALIZATION_PLAN",
				"BpjsHospitalizationPlanEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsHospitalizationPlanAuthority);

		CustomGrantedAuthority bpjsINACBGAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_INACBG",
				"BpjsINACBGEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsINACBGAuthority);

		CustomGrantedAuthority bpjsINACBGClaimAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_INACBG_CLAIM",
				"BpjsINACBGClaimEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsINACBGClaimAuthority);

		CustomGrantedAuthority bpjsINACBGVariableAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_INACBG_VARIABLE",
				"BpjsINACBGVariableEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsINACBGVariableAuthority);

		CustomGrantedAuthority bpjsJasaRaharjaAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_JASA_RAHARJA",
				"BpjsJasaRaharjaEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsJasaRaharjaAuthority);

		CustomGrantedAuthority bpjsJasaRaharjaClaimAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_JASA_RAHARJA_CLAIM",
				"BpjsJasaRaharjaClaimEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsJasaRaharjaClaimAuthority);

		CustomGrantedAuthority bpjsListFingerPrintAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_LIST_FINGER_PRINT",
				"BpjsListFingerPrintEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsListFingerPrintAuthority);

		CustomGrantedAuthority bpjsListTaskAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_LIST_TASK",
				"BpjsListTaskEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsListTaskAuthority);

		CustomGrantedAuthority bpjsOutsideFacilityReferralAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_OUTSIDE_FACILITY_REFERRAL",
				"BpjsOutsideFacilityReferralEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsOutsideFacilityReferralAuthority);

		CustomGrantedAuthority bpjsPRBAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PRB",
				"BpjsPRBEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPRBAuthority);

		CustomGrantedAuthority bpjsPRBDetailAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PRB_DETAIL",
				"BpjsPRBDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPRBDetailAuthority);

		CustomGrantedAuthority bpjsPatientReferralAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PATIENT_REFERRAL",
				"BpjsPatientReferralEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPatientReferralAuthority);

		CustomGrantedAuthority bpjsPcareDPHOAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PCARE_DPHO",
				"BpjsPcareDPHOEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPcareDPHOAuthority);

		CustomGrantedAuthority bpjsPcareKegiatanKelompokAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PCARE_KEGIATAN_KELOMPOK",
				"BpjsPcareKegiatanKelompokEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPcareKegiatanKelompokAuthority);

		CustomGrantedAuthority bpjsPcareKesadaranAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PCARE_KESADARAN",
				"BpjsPcareKesadaranEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPcareKesadaranAuthority);

		CustomGrantedAuthority bpjsPcarePesertaKegiatanKelompokAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK",
				"BpjsPcarePesertaKegiatanKelompokEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPcarePesertaKegiatanKelompokAuthority);

		CustomGrantedAuthority bpjsPcarePoliAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PCARE_POLI",
				"BpjsPcarePoliEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPcarePoliAuthority);

		CustomGrantedAuthority bpjsPcareProviderRayonisasiAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PCARE_PROVIDER_RAYONISASI",
				"BpjsPcareProviderRayonisasiEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPcareProviderRayonisasiAuthority);

		CustomGrantedAuthority bpjsPcareRegistrationsAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PCARE_REGISTRATIONS",
				"BpjsPcareRegistrationsEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPcareRegistrationsAuthority);

		CustomGrantedAuthority bpjsProcedureAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PROCEDURE",
				"BpjsProcedureEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsProcedureAuthority);

		CustomGrantedAuthority bpjsReferralSpecialistAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_REFERRAL_SPECIALIST",
				"BpjsReferralSpecialistEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsReferralSpecialistAuthority);

		CustomGrantedAuthority bpjsSEPAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_SEP",
				"BpjsSEPEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsSEPAuthority);

		CustomGrantedAuthority bpjsSEPINACBGIntegrationAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_SEP_INACBG_INTEGRATION",
				"BpjsSEPINACBGIntegrationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsSEPINACBGIntegrationAuthority);

		CustomGrantedAuthority bpjsSEPInternalDataAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_SEP_INTERNAL_DATA",
				"BpjsSEPInternalDataEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsSEPInternalDataAuthority);

		CustomGrantedAuthority bpjsSEPSubmissionAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_SEP_SUBMISSION",
				"BpjsSEPSubmissionEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsSEPSubmissionAuthority);

		CustomGrantedAuthority bpjsSearchControlLetterAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_SEARCH_CONTROL_LETTER",
				"BpjsSearchControlLetterEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsSearchControlLetterAuthority);

		CustomGrantedAuthority bpjsSearchSEPAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_SEARCH_SEP",
				"BpjsSearchSEPEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsSearchSEPAuthority);

		CustomGrantedAuthority bpjsServiceMappingAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_SERVICE_MAPPING",
				"BpjsServiceMappingEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsServiceMappingAuthority);

		CustomGrantedAuthority bpjsSpecialReferralAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_SPECIAL_REFERRAL",
				"BpjsSpecialReferralEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsSpecialReferralAuthority);

		CustomGrantedAuthority bpjsTotalReferralSEPAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_TOTAL_REFERRAL_SEP",
				"BpjsTotalReferralSEPEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsTotalReferralSEPAuthority);

		CustomGrantedAuthority bpjsTreatmentClassMappingAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_TREATMENT_CLASS_MAPPING",
				"BpjsTreatmentClassMappingEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsTreatmentClassMappingAuthority);

		CustomGrantedAuthority bpjsTreatmentHistoryAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_TREATMENT_HISTORY",
				"BpjsTreatmentHistoryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsTreatmentHistoryAuthority);

		CustomGrantedAuthority bpjsTreatmentRoomAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_TREATMENT_ROOM",
				"BpjsTreatmentRoomEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsTreatmentRoomAuthority);

		CustomGrantedAuthority bpjsUpdateDismissalDateAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_UPDATE_DISMISSAL_DATE",
				"BpjsUpdateDismissalDateEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsUpdateDismissalDateAuthority);

		CustomGrantedAuthority bpjsVisitDataAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_VISIT_DATA",
				"BpjsVisitDataEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsVisitDataAuthority);

		CustomGrantedAuthority batchStockBalanceAuthority = new CustomGrantedAuthority(
				"ROLE_BATCH_STOCK_BALANCE",
				"BatchStockBalanceEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(batchStockBalanceAuthority);

		CustomGrantedAuthority batchStockBalancePerDateAuthority = new CustomGrantedAuthority(
				"ROLE_BATCH_STOCK_BALANCE_PER_DATE",
				"BatchStockBalancePerDateEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(batchStockBalancePerDateAuthority);

		CustomGrantedAuthority batchStockTransactionDetailAuthority = new CustomGrantedAuthority(
				"ROLE_BATCH_STOCK_TRANSACTION_DETAIL",
				"BatchStockTransactionDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(batchStockTransactionDetailAuthority);

		CustomGrantedAuthority bedFacilityAuthority = new CustomGrantedAuthority(
				"ROLE_BED_FACILITY",
				"BedFacilityEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bedFacilityAuthority);

		CustomGrantedAuthority bedReserveAuthority = new CustomGrantedAuthority(
				"ROLE_BED_RESERVE",
				"BedReserveEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bedReserveAuthority);

		CustomGrantedAuthority birthHistoryAuthority = new CustomGrantedAuthority(
				"ROLE_BIRTH_HISTORY",
				"BirthHistoryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(birthHistoryAuthority);

		CustomGrantedAuthority bodyChartExaminationAuthority = new CustomGrantedAuthority(
				"ROLE_BODY_CHART_EXAMINATION",
				"BodyChartExaminationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bodyChartExaminationAuthority);

		CustomGrantedAuthority bpjsPcareKunjunganRujukanAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PCARE_KUNJUNGAN_RUJUKAN",
				"BpjsPcareKunjunganRujukanEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPcareKunjunganRujukanAuthority);

		CustomGrantedAuthority bpjsPcarePendaftaranAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PCARE_PENDAFTARAN",
				"BpjsPcarePendaftaranEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPcarePendaftaranAuthority);

		CustomGrantedAuthority bpjsPcareRiwayatKunjunganAuthority = new CustomGrantedAuthority(
				"ROLE_BPJS_PCARE_RIWAYAT_KUNJUNGAN",
				"BpjsPcareRiwayatKunjunganEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(bpjsPcareRiwayatKunjunganAuthority);

		CustomGrantedAuthority cashAllocationAuthority = new CustomGrantedAuthority(
				"ROLE_CASH_ALLOCATION",
				"CashAllocationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(cashAllocationAuthority);

		CustomGrantedAuthority cashReceiptAuthority = new CustomGrantedAuthority(
				"ROLE_CASH_RECEIPT",
				"CashReceiptEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(cashReceiptAuthority);

		CustomGrantedAuthority cashRefundAuthority = new CustomGrantedAuthority(
				"ROLE_CASH_REFUND",
				"CashRefundEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(cashRefundAuthority);

		CustomGrantedAuthority cashierUserAuthority = new CustomGrantedAuthority(
				"ROLE_CASHIER_USER",
				"CashierUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(cashierUserAuthority);

		CustomGrantedAuthority catalogueMedicalAuthority = new CustomGrantedAuthority(
				"ROLE_CATALOGUE_MEDICAL",
				"CatalogueMedicalEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(catalogueMedicalAuthority);

		CustomGrantedAuthority catalogueNonMedicalAuthority = new CustomGrantedAuthority(
				"ROLE_CATALOGUE_NON_MEDICAL",
				"CatalogueNonMedicalEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(catalogueNonMedicalAuthority);

		CustomGrantedAuthority catalogueUOMAuthority = new CustomGrantedAuthority(
				"ROLE_CATALOGUE_UOM",
				"CatalogueUOMEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(catalogueUOMAuthority);

		CustomGrantedAuthority chartOfAccountAuthority = new CustomGrantedAuthority(
				"ROLE_CHART_OF_ACCOUNT",
				"ChartOfAccountEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(chartOfAccountAuthority);

		CustomGrantedAuthority chartOfAccountMappingAuthority = new CustomGrantedAuthority(
				"ROLE_CHART_OF_ACCOUNT_MAPPING",
				"ChartOfAccountMappingEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(chartOfAccountMappingAuthority);

		CustomGrantedAuthority claimUserAuthority = new CustomGrantedAuthority(
				"ROLE_CLAIM_USER",
				"ClaimUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(claimUserAuthority);

		CustomGrantedAuthority coTreatingDoctorAuthority = new CustomGrantedAuthority(
				"ROLE_CO_TREATING_DOCTOR",
				"CoTreatingDoctorEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(coTreatingDoctorAuthority);

		CustomGrantedAuthority compoundPrescriptionDetailAuthority = new CustomGrantedAuthority(
				"ROLE_COMPOUND_PRESCRIPTION_DETAIL",
				"CompoundPrescriptionDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(compoundPrescriptionDetailAuthority);

		CustomGrantedAuthority compoundPrescriptionItemAuthority = new CustomGrantedAuthority(
				"ROLE_COMPOUND_PRESCRIPTION_ITEM",
				"CompoundPrescriptionItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(compoundPrescriptionItemAuthority);

		CustomGrantedAuthority dailyCareCPPTAuthority = new CustomGrantedAuthority(
				"ROLE_DAILY_CARE_CPPT",
				"DailyCareCPPTEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(dailyCareCPPTAuthority);

		CustomGrantedAuthority deliveryMedicalExaminationRecordAuthority = new CustomGrantedAuthority(
				"ROLE_DELIVERY_MEDICAL_EXAMINATION_RECORD",
				"DeliveryMedicalExaminationRecordEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(deliveryMedicalExaminationRecordAuthority);

		CustomGrantedAuthority deliveryProgressAuthority = new CustomGrantedAuthority(
				"ROLE_DELIVERY_PROGRESS",
				"DeliveryProgressEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(deliveryProgressAuthority);

		CustomGrantedAuthority diagnosesAndProceduresAuthority = new CustomGrantedAuthority(
				"ROLE_DIAGNOSES_AND_PROCEDURES",
				"DiagnosesAndProceduresEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(diagnosesAndProceduresAuthority);

		CustomGrantedAuthority diagnosisExaminationRecordAuthority = new CustomGrantedAuthority(
				"ROLE_DIAGNOSIS_EXAMINATION_RECORD",
				"DiagnosisExaminationRecordEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(diagnosisExaminationRecordAuthority);

		CustomGrantedAuthority diagnosisNandaAuthority = new CustomGrantedAuthority(
				"ROLE_DIAGNOSIS_NANDA",
				"DiagnosisNandaEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(diagnosisNandaAuthority);

		CustomGrantedAuthority diagnosticExaminationResultsAuthority = new CustomGrantedAuthority(
				"ROLE_DIAGNOSTIC_EXAMINATION_RESULTS",
				"DiagnosticExaminationResultsEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(diagnosticExaminationResultsAuthority);

		CustomGrantedAuthority diagnosticStaffExaminationSummaryAuthority = new CustomGrantedAuthority(
				"ROLE_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY",
				"DiagnosticStaffExaminationSummaryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(diagnosticStaffExaminationSummaryAuthority);

		CustomGrantedAuthority diagnosticSupportGeneralConfigurationAuthority = new CustomGrantedAuthority(
				"ROLE_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION",
				"DiagnosticSupportGeneralConfigurationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(diagnosticSupportGeneralConfigurationAuthority);

		CustomGrantedAuthority diagnosticSupportUserAuthority = new CustomGrantedAuthority(
				"ROLE_DIAGNOSTIC_SUPPORT_USER",
				"DiagnosticSupportUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(diagnosticSupportUserAuthority);

		CustomGrantedAuthority doctorScheduleAuthority = new CustomGrantedAuthority(
				"ROLE_DOCTOR_SCHEDULE",
				"DoctorScheduleEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(doctorScheduleAuthority);

		CustomGrantedAuthority doctorUserAuthority = new CustomGrantedAuthority(
				"ROLE_DOCTOR_USER",
				"DoctorUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(doctorUserAuthority);

		CustomGrantedAuthority entExaminationAuthority = new CustomGrantedAuthority(
				"ROLE_ENT_EXAMINATION",
				"EntExaminationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(entExaminationAuthority);

		CustomGrantedAuthority emergencyMedicalExaminationRecordAuthority = new CustomGrantedAuthority(
				"ROLE_EMERGENCY_MEDICAL_EXAMINATION_RECORD",
				"EmergencyMedicalExaminationRecordEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(emergencyMedicalExaminationRecordAuthority);

		CustomGrantedAuthority examinationGroupAuthority = new CustomGrantedAuthority(
				"ROLE_EXAMINATION_GROUP",
				"ExaminationGroupEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(examinationGroupAuthority);

		CustomGrantedAuthority examinationItemAuthority = new CustomGrantedAuthority(
				"ROLE_EXAMINATION_ITEM",
				"ExaminationItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(examinationItemAuthority);

		CustomGrantedAuthority examinationItemDetailAuthority = new CustomGrantedAuthority(
				"ROLE_EXAMINATION_ITEM_DETAIL",
				"ExaminationItemDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(examinationItemDetailAuthority);

		CustomGrantedAuthority facilityHistoryAuthority = new CustomGrantedAuthority(
				"ROLE_FACILITY_HISTORY",
				"FacilityHistoryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(facilityHistoryAuthority);

		CustomGrantedAuthority facilityUserAuthority = new CustomGrantedAuthority(
				"ROLE_FACILITY_USER",
				"FacilityUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(facilityUserAuthority);

		CustomGrantedAuthority fluidBalanceDetailAuthority = new CustomGrantedAuthority(
				"ROLE_FLUID_BALANCE_DETAIL",
				"FluidBalanceDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(fluidBalanceDetailAuthority);

		CustomGrantedAuthority formulirKonselingTesHivAuthority = new CustomGrantedAuthority(
				"ROLE_FORMULIR_KONSELING_TES_HIV",
				"FormulirKonselingTesHivEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(formulirKonselingTesHivAuthority);

		CustomGrantedAuthority goodsReceiveNoteAuthority = new CustomGrantedAuthority(
				"ROLE_GOODS_RECEIVE_NOTE",
				"GoodsReceiveNoteEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(goodsReceiveNoteAuthority);

		CustomGrantedAuthority goodsReceiveNoteBatchAuthority = new CustomGrantedAuthority(
				"ROLE_GOODS_RECEIVE_NOTE_BATCH",
				"GoodsReceiveNoteBatchEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(goodsReceiveNoteBatchAuthority);

		CustomGrantedAuthority goodsReceiveNoteItemAuthority = new CustomGrantedAuthority(
				"ROLE_GOODS_RECEIVE_NOTE_ITEM",
				"GoodsReceiveNoteItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(goodsReceiveNoteItemAuthority);

		CustomGrantedAuthority healthFacilityAuthority = new CustomGrantedAuthority(
				"ROLE_HEALTH_FACILITY",
				"HealthFacilityEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(healthFacilityAuthority);

		CustomGrantedAuthority hemodialysisExaminationAuthority = new CustomGrantedAuthority(
				"ROLE_HEMODIALYSIS_EXAMINATION",
				"HemodialysisExaminationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(hemodialysisExaminationAuthority);

		CustomGrantedAuthority hemodialysisMonitoringAuthority = new CustomGrantedAuthority(
				"ROLE_HEMODIALYSIS_MONITORING",
				"HemodialysisMonitoringEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(hemodialysisMonitoringAuthority);

		CustomGrantedAuthority hospitalBranchInformationAuthority = new CustomGrantedAuthority(
				"ROLE_HOSPITAL_BRANCH_INFORMATION",
				"HospitalBranchInformationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(hospitalBranchInformationAuthority);

		CustomGrantedAuthority hospitalGroupInformationAuthority = new CustomGrantedAuthority(
				"ROLE_HOSPITAL_GROUP_INFORMATION",
				"HospitalGroupInformationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(hospitalGroupInformationAuthority);

		CustomGrantedAuthority icd10Authority = new CustomGrantedAuthority(
				"ROLE_ICD_10",
				"Icd10Entity",
				true,
				true,
				true,
				true
		);
		authorities.add(icd10Authority);

		CustomGrantedAuthority icd9CMAuthority = new CustomGrantedAuthority(
				"ROLE_ICD_9_CM",
				"Icd9CMEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(icd9CMAuthority);

		CustomGrantedAuthority informedConsentAuthority = new CustomGrantedAuthority(
				"ROLE_INFORMED_CONSENT",
				"InformedConsentEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(informedConsentAuthority);

		CustomGrantedAuthority inpatientMedicalExaminationRecordAuthority = new CustomGrantedAuthority(
				"ROLE_INPATIENT_MEDICAL_EXAMINATION_RECORD",
				"InpatientMedicalExaminationRecordEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(inpatientMedicalExaminationRecordAuthority);

		CustomGrantedAuthority insuranceBenefitPlanAuthority = new CustomGrantedAuthority(
				"ROLE_INSURANCE_BENEFIT_PLAN",
				"InsuranceBenefitPlanEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(insuranceBenefitPlanAuthority);

		CustomGrantedAuthority insuranceProviderAuthority = new CustomGrantedAuthority(
				"ROLE_INSURANCE_PROVIDER",
				"InsuranceProviderEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(insuranceProviderAuthority);

		CustomGrantedAuthority internalOrderAuthority = new CustomGrantedAuthority(
				"ROLE_INTERNAL_ORDER",
				"InternalOrderEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(internalOrderAuthority);

		CustomGrantedAuthority internalOrderStockDetailAuthority = new CustomGrantedAuthority(
				"ROLE_INTERNAL_ORDER_STOCK_DETAIL",
				"InternalOrderStockDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(internalOrderStockDetailAuthority);

		CustomGrantedAuthority intraoperativeRecordsAuthority = new CustomGrantedAuthority(
				"ROLE_INTRAOPERATIVE_RECORDS",
				"IntraoperativeRecordsEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(intraoperativeRecordsAuthority);

		CustomGrantedAuthority inventoryAdjusmentBatchAuthority = new CustomGrantedAuthority(
				"ROLE_INVENTORY_ADJUSMENT_BATCH",
				"InventoryAdjusmentBatchEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(inventoryAdjusmentBatchAuthority);

		CustomGrantedAuthority inventoryAdjustmentAuthority = new CustomGrantedAuthority(
				"ROLE_INVENTORY_ADJUSTMENT",
				"InventoryAdjustmentEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(inventoryAdjustmentAuthority);

		CustomGrantedAuthority inventoryAdjustmentItemAuthority = new CustomGrantedAuthority(
				"ROLE_INVENTORY_ADJUSTMENT_ITEM",
				"InventoryAdjustmentItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(inventoryAdjustmentItemAuthority);

		CustomGrantedAuthority inventoryBatchCorrectionAuthority = new CustomGrantedAuthority(
				"ROLE_INVENTORY_BATCH_CORRECTION",
				"InventoryBatchCorrectionEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(inventoryBatchCorrectionAuthority);

		CustomGrantedAuthority inventoryBatchCorrectionItemAuthority = new CustomGrantedAuthority(
				"ROLE_INVENTORY_BATCH_CORRECTION_ITEM",
				"InventoryBatchCorrectionItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(inventoryBatchCorrectionItemAuthority);

		CustomGrantedAuthority invoiceAuthority = new CustomGrantedAuthority(
				"ROLE_INVOICE",
				"InvoiceEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(invoiceAuthority);

		CustomGrantedAuthority invoiceItemAuthority = new CustomGrantedAuthority(
				"ROLE_INVOICE_ITEM",
				"InvoiceItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(invoiceItemAuthority);

		CustomGrantedAuthority invoiceItemComponentAuthority = new CustomGrantedAuthority(
				"ROLE_INVOICE_ITEM_COMPONENT",
				"InvoiceItemComponentEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(invoiceItemComponentAuthority);

		CustomGrantedAuthority invoicePaymentInsuranceAuthority = new CustomGrantedAuthority(
				"ROLE_INVOICE_PAYMENT_INSURANCE",
				"InvoicePaymentInsuranceEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(invoicePaymentInsuranceAuthority);

		CustomGrantedAuthority invoicePaymentOtherAuthority = new CustomGrantedAuthority(
				"ROLE_INVOICE_PAYMENT_OTHER",
				"InvoicePaymentOtherEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(invoicePaymentOtherAuthority);

		CustomGrantedAuthority invoicePaymentSelfPayingAuthority = new CustomGrantedAuthority(
				"ROLE_INVOICE_PAYMENT_SELF_PAYING",
				"InvoicePaymentSelfPayingEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(invoicePaymentSelfPayingAuthority);

		CustomGrantedAuthority invoiceSummaryAuthority = new CustomGrantedAuthority(
				"ROLE_INVOICE_SUMMARY",
				"InvoiceSummaryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(invoiceSummaryAuthority);

		CustomGrantedAuthority journalAuthority = new CustomGrantedAuthority(
				"ROLE_JOURNAL",
				"JournalEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(journalAuthority);

		CustomGrantedAuthority libraryAuthority = new CustomGrantedAuthority(
				"ROLE_LIBRARY",
				"LibraryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(libraryAuthority);

		CustomGrantedAuthority locationAuthority = new CustomGrantedAuthority(
				"ROLE_LOCATION",
				"LocationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(locationAuthority);

		CustomGrantedAuthority mcuPackageAuthority = new CustomGrantedAuthority(
				"ROLE_MCU_PACKAGE",
				"McuPackageEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(mcuPackageAuthority);

		CustomGrantedAuthority mcuPackageItemAuthority = new CustomGrantedAuthority(
				"ROLE_MCU_PACKAGE_ITEM",
				"McuPackageItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(mcuPackageItemAuthority);

		CustomGrantedAuthority managementUserAuthority = new CustomGrantedAuthority(
				"ROLE_MANAGEMENT_USER",
				"ManagementUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(managementUserAuthority);

		CustomGrantedAuthority medicalCertificateDischargeResumeAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME",
				"MedicalCertificateDischargeResumeEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalCertificateDischargeResumeAuthority);

		CustomGrantedAuthority medicalCertificateBirthAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_CERTIFICATE_BIRTH",
				"MedicalCertificateBirthEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalCertificateBirthAuthority);

		CustomGrantedAuthority medicalCertificateHospitalizationAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_CERTIFICATE_HOSPITALIZATION",
				"MedicalCertificateHospitalizationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalCertificateHospitalizationAuthority);

		CustomGrantedAuthority medicalCertificateMedicalAttendanceAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE",
				"MedicalCertificateMedicalAttendanceEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalCertificateMedicalAttendanceAuthority);

		CustomGrantedAuthority medicalCertificateMentalHealthAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_CERTIFICATE_MENTAL_HEALTH",
				"MedicalCertificateMentalHealthEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalCertificateMentalHealthAuthority);

		CustomGrantedAuthority medicalCertificatePhysicalHealthAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH",
				"MedicalCertificatePhysicalHealthEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalCertificatePhysicalHealthAuthority);

		CustomGrantedAuthority medicalCertificateRestrictedWorkAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_CERTIFICATE_RESTRICTED_WORK",
				"MedicalCertificateRestrictedWorkEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalCertificateRestrictedWorkAuthority);

		CustomGrantedAuthority medicalCertificateSickLeaveAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_CERTIFICATE_SICK_LEAVE",
				"MedicalCertificateSickLeaveEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalCertificateSickLeaveAuthority);

		CustomGrantedAuthority medicalExaminationRecordAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_EXAMINATION_RECORD",
				"MedicalExaminationRecordEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalExaminationRecordAuthority);

		CustomGrantedAuthority medicalExaminationRecordDischargeSummaryAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY",
				"MedicalExaminationRecordDischargeSummaryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalExaminationRecordDischargeSummaryAuthority);

		CustomGrantedAuthority medicalFeeAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_FEE",
				"MedicalFeeEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalFeeAuthority);

		CustomGrantedAuthority medicalFeeItemComponentAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_FEE_ITEM_COMPONENT",
				"MedicalFeeItemComponentEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalFeeItemComponentAuthority);

		CustomGrantedAuthority medicalRecordInitialChecklistAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_RECORD_INITIAL_CHECKLIST",
				"MedicalRecordInitialChecklistEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalRecordInitialChecklistAuthority);

		CustomGrantedAuthority medicalRecordNextVerificationChecklistAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST",
				"MedicalRecordNextVerificationChecklistEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalRecordNextVerificationChecklistAuthority);

		CustomGrantedAuthority medicalRecordUserAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_RECORD_USER",
				"MedicalRecordUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalRecordUserAuthority);

		CustomGrantedAuthority medicalTranscriberUserAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICAL_TRANSCRIBER_USER",
				"MedicalTranscriberUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicalTranscriberUserAuthority);

		CustomGrantedAuthority medicationAdministeredHistoryAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICATION_ADMINISTERED_HISTORY",
				"MedicationAdministeredHistoryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicationAdministeredHistoryAuthority);

		CustomGrantedAuthority medicationCompoundAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICATION_COMPOUND",
				"MedicationCompoundEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicationCompoundAuthority);

		CustomGrantedAuthority medicationHeaderAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICATION_HEADER",
				"MedicationHeaderEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicationHeaderAuthority);

		CustomGrantedAuthority medicationItemAuthority = new CustomGrantedAuthority(
				"ROLE_MEDICATION_ITEM",
				"MedicationItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(medicationItemAuthority);

		CustomGrantedAuthority merchantAuthority = new CustomGrantedAuthority(
				"ROLE_MERCHANT",
				"MerchantEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(merchantAuthority);

		CustomGrantedAuthority merchantSurchargeAndFeeAuthority = new CustomGrantedAuthority(
				"ROLE_MERCHANT_SURCHARGE_AND_FEE",
				"MerchantSurchargeAndFeeEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(merchantSurchargeAndFeeAuthority);

		CustomGrantedAuthority nhisClaimAuthority = new CustomGrantedAuthority(
				"ROLE_NHIS_CLAIM",
				"NhisClaimEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(nhisClaimAuthority);

		CustomGrantedAuthority nhisClaimGDRGDetailAuthority = new CustomGrantedAuthority(
				"ROLE_NHIS_CLAIM_GDRG_DETAIL",
				"NhisClaimGDRGDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(nhisClaimGDRGDetailAuthority);

		CustomGrantedAuthority nhisClaimInvestigationDetailAuthority = new CustomGrantedAuthority(
				"ROLE_NHIS_CLAIM_INVESTIGATION_DETAIL",
				"NhisClaimInvestigationDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(nhisClaimInvestigationDetailAuthority);

		CustomGrantedAuthority nhisGDRGAuthority = new CustomGrantedAuthority(
				"ROLE_NHIS_GDRG",
				"NhisGDRGEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(nhisGDRGAuthority);

		CustomGrantedAuthority nhisInvestigationAuthority = new CustomGrantedAuthority(
				"ROLE_NHIS_INVESTIGATION",
				"NhisInvestigationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(nhisInvestigationAuthority);

		CustomGrantedAuthority nhisMedicineAuthority = new CustomGrantedAuthority(
				"ROLE_NHIS_MEDICINE",
				"NhisMedicineEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(nhisMedicineAuthority);

		CustomGrantedAuthority nhisServiceOutcomeAuthority = new CustomGrantedAuthority(
				"ROLE_NHIS_SERVICE_OUTCOME",
				"NhisServiceOutcomeEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(nhisServiceOutcomeAuthority);

		CustomGrantedAuthority nhisSpecialtyAttendedAuthority = new CustomGrantedAuthority(
				"ROLE_NHIS_SPECIALTY_ATTENDED",
				"NhisSpecialtyAttendedEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(nhisSpecialtyAttendedAuthority);

		CustomGrantedAuthority nhisTypeOfServiceAuthority = new CustomGrantedAuthority(
				"ROLE_NHIS_TYPE_OF_SERVICE",
				"NhisTypeOfServiceEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(nhisTypeOfServiceAuthority);

		CustomGrantedAuthority newbornDetailAuthority = new CustomGrantedAuthority(
				"ROLE_NEWBORN_DETAIL",
				"NewbornDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(newbornDetailAuthority);

		CustomGrantedAuthority numberingSetupAuthority = new CustomGrantedAuthority(
				"ROLE_NUMBERING_SETUP",
				"NumberingSetupEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(numberingSetupAuthority);

		CustomGrantedAuthority nurseUserAuthority = new CustomGrantedAuthority(
				"ROLE_NURSE_USER",
				"NurseUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(nurseUserAuthority);

		CustomGrantedAuthority nurseVitalSignMeasurementAuthority = new CustomGrantedAuthority(
				"ROLE_NURSE_VITAL_SIGN_MEASUREMENT",
				"NurseVitalSignMeasurementEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(nurseVitalSignMeasurementAuthority);

		CustomGrantedAuthority obstetricAndGynecologyHistoryAuthority = new CustomGrantedAuthority(
				"ROLE_OBSTETRIC_AND_GYNECOLOGY_HISTORY",
				"ObstetricAndGynecologyHistoryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(obstetricAndGynecologyHistoryAuthority);

		CustomGrantedAuthority odontogramExaminationAuthority = new CustomGrantedAuthority(
				"ROLE_ODONTOGRAM_EXAMINATION",
				"OdontogramExaminationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(odontogramExaminationAuthority);

		CustomGrantedAuthority operatingTheaterMedicalExaminationRecordAuthority = new CustomGrantedAuthority(
				"ROLE_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD",
				"OperatingTheaterMedicalExaminationRecordEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(operatingTheaterMedicalExaminationRecordAuthority);

		CustomGrantedAuthority ophthalmologyExaminationAuthority = new CustomGrantedAuthority(
				"ROLE_OPHTHALMOLOGY_EXAMINATION",
				"OphthalmologyExaminationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(ophthalmologyExaminationAuthority);

		CustomGrantedAuthority pcareActionExaminationAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_ACTION_EXAMINATION",
				"PcareActionExaminationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareActionExaminationAuthority);

		CustomGrantedAuthority pcareClubProlanisAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_CLUB_PROLANIS",
				"PcareClubProlanisEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareClubProlanisAuthority);

		CustomGrantedAuthority pcareCompoundDrugAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_COMPOUND_DRUG",
				"PcareCompoundDrugEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareCompoundDrugAuthority);

		CustomGrantedAuthority pcareCompoundDrugItemAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_COMPOUND_DRUG_ITEM",
				"PcareCompoundDrugItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareCompoundDrugItemAuthority);

		CustomGrantedAuthority pcareDiagnosaAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_DIAGNOSA",
				"PcareDiagnosaEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareDiagnosaAuthority);

		CustomGrantedAuthority pcareDokterAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_DOKTER",
				"PcareDokterEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareDokterAuthority);

		CustomGrantedAuthority pcareExaminationAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_EXAMINATION",
				"PcareExaminationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareExaminationAuthority);

		CustomGrantedAuthority pcareMCUAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_MCU",
				"PcareMCUEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareMCUAuthority);

		CustomGrantedAuthority pcareNonCompoundDrugAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_NONCOMPOUND_DRUG",
				"PcareNonCompoundDrugEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareNonCompoundDrugAuthority);

		CustomGrantedAuthority pcareReferensiSaranaAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_REFERENSI_SARANA",
				"PcareReferensiSaranaEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareReferensiSaranaAuthority);

		CustomGrantedAuthority pcareStatusPulangAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_STATUS_PULANG",
				"PcareStatusPulangEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareStatusPulangAuthority);

		CustomGrantedAuthority pcareTindakanAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_TINDAKAN",
				"PcareTindakanEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareTindakanAuthority);

		CustomGrantedAuthority pcareUmumAuthority = new CustomGrantedAuthority(
				"ROLE_PCARE_UMUM",
				"PcareUmumEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pcareUmumAuthority);

		CustomGrantedAuthority patientCaseHistoryAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_CASE_HISTORY",
				"PatientCaseHistoryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientCaseHistoryAuthority);

		CustomGrantedAuthority patientConsentAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_CONSENT",
				"PatientConsentEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientConsentAuthority);

		CustomGrantedAuthority patientContactInfoAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_CONTACT_INFO",
				"PatientContactInfoEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientContactInfoAuthority);

		CustomGrantedAuthority patientDetailAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_DETAIL",
				"PatientDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientDetailAuthority);

		CustomGrantedAuthority patientDetailAddressAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_DETAIL_ADDRESS",
				"PatientDetailAddressEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientDetailAddressAuthority);

		CustomGrantedAuthority patientEmergencyContactDetailAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_EMERGENCY_CONTACT_DETAIL",
				"PatientEmergencyContactDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientEmergencyContactDetailAuthority);

		CustomGrantedAuthority patientEmploymentDetailAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_EMPLOYMENT_DETAIL",
				"PatientEmploymentDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientEmploymentDetailAuthority);

		CustomGrantedAuthority patientGeneralInfoAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_GENERAL_INFO",
				"PatientGeneralInfoEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientGeneralInfoAuthority);

		CustomGrantedAuthority patientPaymentSelfPayingAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_PAYMENT_SELF_PAYING",
				"PatientPaymentSelfPayingEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientPaymentSelfPayingAuthority);

		CustomGrantedAuthority patientPaymentBPJSAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_PAYMENT_BPJS",
				"PatientPaymentBPJSEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientPaymentBPJSAuthority);

		CustomGrantedAuthority patientPaymentInsuranceAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_PAYMENT_INSURANCE",
				"PatientPaymentInsuranceEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientPaymentInsuranceAuthority);

		CustomGrantedAuthority patientPaymentOthersAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_PAYMENT_OTHERS",
				"PatientPaymentOthersEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientPaymentOthersAuthority);

		CustomGrantedAuthority patientPersonalInfoAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_PERSONAL_INFO",
				"PatientPersonalInfoEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientPersonalInfoAuthority);

		CustomGrantedAuthority patientSupportingDocumentAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_SUPPORTING_DOCUMENT",
				"PatientSupportingDocumentEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientSupportingDocumentAuthority);

		CustomGrantedAuthority patientVisitAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_VISIT",
				"PatientVisitEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientVisitAuthority);

		CustomGrantedAuthority patientVisitPatientPaymentInsuranceAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE",
				"PatientVisitPatientPaymentInsuranceEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientVisitPatientPaymentInsuranceAuthority);

		CustomGrantedAuthority patientVisitPatientPaymentOthersAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS",
				"PatientVisitPatientPaymentOthersEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientVisitPatientPaymentOthersAuthority);

		CustomGrantedAuthority patientVisitPaymentSelfPayingAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_VISIT_PAYMENT_SELF_PAYING",
				"PatientVisitPaymentSelfPayingEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientVisitPaymentSelfPayingAuthority);

		CustomGrantedAuthority patientVitalInformationAuthority = new CustomGrantedAuthority(
				"ROLE_PATIENT_VITAL_INFORMATION",
				"PatientVitalInformationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(patientVitalInformationAuthority);

		CustomGrantedAuthority pharmacySetupAuthority = new CustomGrantedAuthority(
				"ROLE_PHARMACY_SETUP",
				"PharmacySetupEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pharmacySetupAuthority);

		CustomGrantedAuthority pharmacyUserAuthority = new CustomGrantedAuthority(
				"ROLE_PHARMACY_USER",
				"PharmacyUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(pharmacyUserAuthority);

		CustomGrantedAuthority postOperativeDetailsAuthority = new CustomGrantedAuthority(
				"ROLE_POST_OPERATIVE_DETAILS",
				"PostOperativeDetailsEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(postOperativeDetailsAuthority);

		CustomGrantedAuthority preoperativeRecordsAuthority = new CustomGrantedAuthority(
				"ROLE_PREOPERATIVE_RECORDS",
				"PreoperativeRecordsEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(preoperativeRecordsAuthority);

		CustomGrantedAuthority prescriptionCompoundAuthority = new CustomGrantedAuthority(
				"ROLE_PRESCRIPTION_COMPOUND",
				"PrescriptionCompoundEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(prescriptionCompoundAuthority);

		CustomGrantedAuthority prescriptionHeaderAuthority = new CustomGrantedAuthority(
				"ROLE_PRESCRIPTION_HEADER",
				"PrescriptionHeaderEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(prescriptionHeaderAuthority);

		CustomGrantedAuthority prescriptionItemAuthority = new CustomGrantedAuthority(
				"ROLE_PRESCRIPTION_ITEM",
				"PrescriptionItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(prescriptionItemAuthority);

		CustomGrantedAuthority priceComponentAuthority = new CustomGrantedAuthority(
				"ROLE_PRICE_COMPONENT",
				"PriceComponentEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(priceComponentAuthority);

		CustomGrantedAuthority privilegeAuthority = new CustomGrantedAuthority(
				"ROLE_PRIVILEGE",
				"PrivilegeEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(privilegeAuthority);

		CustomGrantedAuthority processWorkflowAuthority = new CustomGrantedAuthority(
				"ROLE_PROCESS_WORKFLOW",
				"ProcessWorkflowEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(processWorkflowAuthority);

		CustomGrantedAuthority purchaseOrderAuthority = new CustomGrantedAuthority(
				"ROLE_PURCHASE_ORDER",
				"PurchaseOrderEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(purchaseOrderAuthority);

		CustomGrantedAuthority purchaseOrderStockDetailAuthority = new CustomGrantedAuthority(
				"ROLE_PURCHASE_ORDER_STOCK_DETAIL",
				"PurchaseOrderStockDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(purchaseOrderStockDetailAuthority);

		CustomGrantedAuthority purchaseRequisitionAuthority = new CustomGrantedAuthority(
				"ROLE_PURCHASE_REQUISITION",
				"PurchaseRequisitionEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(purchaseRequisitionAuthority);

		CustomGrantedAuthority purchaseRequisitionStockDetailAuthority = new CustomGrantedAuthority(
				"ROLE_PURCHASE_REQUISITION_STOCK_DETAIL",
				"PurchaseRequisitionStockDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(purchaseRequisitionStockDetailAuthority);

		CustomGrantedAuthority purchasingUserAuthority = new CustomGrantedAuthority(
				"ROLE_PURCHASING_USER",
				"PurchasingUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(purchasingUserAuthority);

		CustomGrantedAuthority referenceDataAuthority = new CustomGrantedAuthority(
				"ROLE_REFERENCE_DATA",
				"ReferenceDataEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(referenceDataAuthority);

		CustomGrantedAuthority referenceHeaderAuthority = new CustomGrantedAuthority(
				"ROLE_REFERENCE_HEADER",
				"ReferenceHeaderEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(referenceHeaderAuthority);

		CustomGrantedAuthority registrationAuthority = new CustomGrantedAuthority(
				"ROLE_REGISTRATION",
				"RegistrationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(registrationAuthority);

		CustomGrantedAuthority registrationUserAuthority = new CustomGrantedAuthority(
				"ROLE_REGISTRATION_USER",
				"RegistrationUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(registrationUserAuthority);

		CustomGrantedAuthority retailPharmacyAuthority = new CustomGrantedAuthority(
				"ROLE_RETAIL_PHARMACY",
				"RetailPharmacyEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(retailPharmacyAuthority);

		CustomGrantedAuthority retailPharmacyInvoiceAuthority = new CustomGrantedAuthority(
				"ROLE_RETAIL_PHARMACY_INVOICE",
				"RetailPharmacyInvoiceEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(retailPharmacyInvoiceAuthority);

		CustomGrantedAuthority retailPharmacyStockDetailAuthority = new CustomGrantedAuthority(
				"ROLE_RETAIL_PHARMACY_STOCK_DETAIL",
				"RetailPharmacyStockDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(retailPharmacyStockDetailAuthority);

		CustomGrantedAuthority returnSupplierAuthority = new CustomGrantedAuthority(
				"ROLE_RETURN_SUPPLIER",
				"ReturnSupplierEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(returnSupplierAuthority);

		CustomGrantedAuthority returnSupplierStockDetailAuthority = new CustomGrantedAuthority(
				"ROLE_RETURN_SUPPLIER_STOCK_DETAIL",
				"ReturnSupplierStockDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(returnSupplierStockDetailAuthority);

		CustomGrantedAuthority roleAuthority = new CustomGrantedAuthority(
				"ROLE_ROLE",
				"RoleEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(roleAuthority);

		CustomGrantedAuthority roomFacilityAuthority = new CustomGrantedAuthority(
				"ROLE_ROOM_FACILITY",
				"RoomFacilityEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(roomFacilityAuthority);

		CustomGrantedAuthority roomTransferAuthority = new CustomGrantedAuthority(
				"ROLE_ROOM_TRANSFER",
				"RoomTransferEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(roomTransferAuthority);

		CustomGrantedAuthority sepAuthority = new CustomGrantedAuthority(
				"ROLE_SEP",
				"SepEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(sepAuthority);

		CustomGrantedAuthority sampleCollectionInformationAuthority = new CustomGrantedAuthority(
				"ROLE_SAMPLE_COLLECTION_INFORMATION",
				"SampleCollectionInformationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(sampleCollectionInformationAuthority);

		CustomGrantedAuthority sampleCollectionItemsAuthority = new CustomGrantedAuthority(
				"ROLE_SAMPLE_COLLECTION_ITEMS",
				"SampleCollectionItemsEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(sampleCollectionItemsAuthority);

		CustomGrantedAuthority satuSehatConfigurationAuthority = new CustomGrantedAuthority(
				"ROLE_SATU_SEHAT_CONFIGURATION",
				"SatuSehatConfigurationEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(satuSehatConfigurationAuthority);

		CustomGrantedAuthority serviceAuthority = new CustomGrantedAuthority(
				"ROLE_SERVICE",
				"ServiceEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(serviceAuthority);

		CustomGrantedAuthority serviceFacilityCategoryAuthority = new CustomGrantedAuthority(
				"ROLE_SERVICE_FACILITY_CATEGORY",
				"ServiceFacilityCategoryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(serviceFacilityCategoryAuthority);

		CustomGrantedAuthority serviceItemAuthority = new CustomGrantedAuthority(
				"ROLE_SERVICE_ITEM",
				"ServiceItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(serviceItemAuthority);

		CustomGrantedAuthority serviceItemAssignmentAuthority = new CustomGrantedAuthority(
				"ROLE_SERVICE_ITEM_ASSIGNMENT",
				"ServiceItemAssignmentEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(serviceItemAssignmentAuthority);

		CustomGrantedAuthority staffAuthority = new CustomGrantedAuthority(
				"ROLE_STAFF",
				"StaffEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(staffAuthority);

		CustomGrantedAuthority stockCatalogueAuthority = new CustomGrantedAuthority(
				"ROLE_STOCK_CATALOGUE",
				"StockCatalogueEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(stockCatalogueAuthority);

		CustomGrantedAuthority stockControlAuthority = new CustomGrantedAuthority(
				"ROLE_STOCK_CONTROL",
				"StockControlEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(stockControlAuthority);

		CustomGrantedAuthority stockTransactionDetailAuthority = new CustomGrantedAuthority(
				"ROLE_STOCK_TRANSACTION_DETAIL",
				"StockTransactionDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(stockTransactionDetailAuthority);

		CustomGrantedAuthority stockTransactionPerDateAuthority = new CustomGrantedAuthority(
				"ROLE_STOCK_TRANSACTION_PER_DATE",
				"StockTransactionPerDateEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(stockTransactionPerDateAuthority);

		CustomGrantedAuthority stockTransactionPerDateTypeAuthority = new CustomGrantedAuthority(
				"ROLE_STOCK_TRANSACTION_PER_DATE_TYPE",
				"StockTransactionPerDateTypeEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(stockTransactionPerDateTypeAuthority);

		CustomGrantedAuthority supplierAuthority = new CustomGrantedAuthority(
				"ROLE_SUPPLIER",
				"SupplierEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(supplierAuthority);

		CustomGrantedAuthority supplierBankAccountAuthority = new CustomGrantedAuthority(
				"ROLE_SUPPLIER_BANK_ACCOUNT",
				"SupplierBankAccountEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(supplierBankAccountAuthority);

		CustomGrantedAuthority supplierContactDetailAuthority = new CustomGrantedAuthority(
				"ROLE_SUPPLIER_CONTACT_DETAIL",
				"SupplierContactDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(supplierContactDetailAuthority);

		CustomGrantedAuthority supplierProductDetailAuthority = new CustomGrantedAuthority(
				"ROLE_SUPPLIER_PRODUCT_DETAIL",
				"SupplierProductDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(supplierProductDetailAuthority);

		CustomGrantedAuthority systemAdminUserAuthority = new CustomGrantedAuthority(
				"ROLE_SYSTEM_ADMIN_USER",
				"SystemAdminUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(systemAdminUserAuthority);

		CustomGrantedAuthority tariffDefinitionAuthority = new CustomGrantedAuthority(
				"ROLE_TARIFF_DEFINITION",
				"TariffDefinitionEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(tariffDefinitionAuthority);

		CustomGrantedAuthority tariffDefinitionOtherComponentAuthority = new CustomGrantedAuthority(
				"ROLE_TARIFF_DEFINITION_OTHER_COMPONENT",
				"TariffDefinitionOtherComponentEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(tariffDefinitionOtherComponentAuthority);

		CustomGrantedAuthority tariffFormulaAuthority = new CustomGrantedAuthority(
				"ROLE_TARIFF_FORMULA",
				"TariffFormulaEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(tariffFormulaAuthority);

		CustomGrantedAuthority tariffPackageAuthority = new CustomGrantedAuthority(
				"ROLE_TARIFF_PACKAGE",
				"TariffPackageEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(tariffPackageAuthority);

		CustomGrantedAuthority tariffPackageItemAuthority = new CustomGrantedAuthority(
				"ROLE_TARIFF_PACKAGE_ITEM",
				"TariffPackageItemEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(tariffPackageItemAuthority);

		CustomGrantedAuthority tariffPackageServiceAssignmentAuthority = new CustomGrantedAuthority(
				"ROLE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT",
				"TariffPackageServiceAssignmentEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(tariffPackageServiceAssignmentAuthority);

		CustomGrantedAuthority tariffSchemaAuthority = new CustomGrantedAuthority(
				"ROLE_TARIFF_SCHEMA",
				"TariffSchemaEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(tariffSchemaAuthority);

		CustomGrantedAuthority taskDashboardAuthority = new CustomGrantedAuthority(
				"ROLE_TASK_DASHBOARD",
				"TaskDashboardEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(taskDashboardAuthority);

		CustomGrantedAuthority transactionDetailTypeAuthority = new CustomGrantedAuthority(
				"ROLE_TRANSACTION_DETAIL_TYPE",
				"TransactionDetailTypeEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(transactionDetailTypeAuthority);

		CustomGrantedAuthority transactionDetailTypeMappingAuthority = new CustomGrantedAuthority(
				"ROLE_TRANSACTION_DETAIL_TYPE_MAPPING",
				"TransactionDetailTypeMappingEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(transactionDetailTypeMappingAuthority);

		CustomGrantedAuthority transferOrderAuthority = new CustomGrantedAuthority(
				"ROLE_TRANSFER_ORDER",
				"TransferOrderEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(transferOrderAuthority);

		CustomGrantedAuthority transferOrderStockDetailAuthority = new CustomGrantedAuthority(
				"ROLE_TRANSFER_ORDER_STOCK_DETAIL",
				"TransferOrderStockDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(transferOrderStockDetailAuthority);

		CustomGrantedAuthority unitOfMeasurementAuthority = new CustomGrantedAuthority(
				"ROLE_UNIT_OF_MEASUREMENT",
				"UnitOfMeasurementEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(unitOfMeasurementAuthority);

		CustomGrantedAuthority userAuthority = new CustomGrantedAuthority(
				"ROLE_USER",
				"UserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(userAuthority);

		CustomGrantedAuthority vaccinationOrderAuthority = new CustomGrantedAuthority(
				"ROLE_VACCINATION_ORDER",
				"VaccinationOrderEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(vaccinationOrderAuthority);

		CustomGrantedAuthority vaccinationOrderDetailAuthority = new CustomGrantedAuthority(
				"ROLE_VACCINATION_ORDER_DETAIL",
				"VaccinationOrderDetailEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(vaccinationOrderDetailAuthority);

		CustomGrantedAuthority vitalSignsAuthority = new CustomGrantedAuthority(
				"ROLE_VITAL_SIGNS",
				"VitalSignsEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(vitalSignsAuthority);

		CustomGrantedAuthority warehouseAuthority = new CustomGrantedAuthority(
				"ROLE_WAREHOUSE",
				"WarehouseEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(warehouseAuthority);

		CustomGrantedAuthority warehouseInitialStockAuthority = new CustomGrantedAuthority(
				"ROLE_WAREHOUSE_INITIAL_STOCK",
				"WarehouseInitialStockEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(warehouseInitialStockAuthority);

		CustomGrantedAuthority warehouseInventoryAuthority = new CustomGrantedAuthority(
				"ROLE_WAREHOUSE_INVENTORY",
				"WarehouseInventoryEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(warehouseInventoryAuthority);

		CustomGrantedAuthority warehouseUserAuthority = new CustomGrantedAuthority(
				"ROLE_WAREHOUSE_USER",
				"WarehouseUserEntity",
				true,
				true,
				true,
				true
		);
		authorities.add(warehouseUserAuthority);

		// % protected region % [Add any additional authorities here] off begin
		// % protected region % [Add any additional authorities here] end

		return new UsernamePasswordAuthenticationToken(null, null, authorities);
	}

	/**
	 * Given a runnable, run it with an anonymous user with elevated permissions. It is guaranteed that once the task
	 * is done or failed, the permissions will be cleared. If this method is called when there's already a user logged
	 * in, then their permissions will be restored when the method finishes.
	 *
	 * @param taskToPerform a task to be run with elevated permissions
	 */
	public static void runAnonymously(@NonNull Runnable taskToPerform) {
		Authentication oldAuthentication = SecurityContextHolder.getContext().getAuthentication();
		try {
			SecurityContextHolder.getContext().setAuthentication(anonymousUser);
			taskToPerform.run();
		} finally {
			SecurityContextHolder.clearContext();
			SecurityContextHolder.getContext().setAuthentication(oldAuthentication);
		}
	}

	/**
	 * Given a supplier, run it with an anonymous user with elevated permissions and then return the value. It is
	 * guaranteed that once the task is done or failed, the permissions will be cleared. If this method is called when
	 * there's already a user logged in, then their permissions will be restored when the method finishes.
	 *
	 * @param taskToPerform a task to be run with elevated permissions
	 * @return the result supplied by the given task
	 */
	public static <T> T runAnonymouslyAndReturnValue(@NonNull Supplier<T> taskToPerform) {
		Authentication oldAuthentication = SecurityContextHolder.getContext().getAuthentication();
		try {
			SecurityContextHolder.getContext().setAuthentication(anonymousUser);
			return taskToPerform.get();
		} finally {
			SecurityContextHolder.clearContext();
			SecurityContextHolder.getContext().setAuthentication(oldAuthentication);
		}
	}
}