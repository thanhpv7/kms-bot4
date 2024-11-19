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
package kmsweb.configs.security;

import org.springframework.http.HttpHeaders;
import kmsweb.configs.security.authorities.CustomGrantedAuthority;
import kmsweb.configs.security.filters.*;
import kmsweb.configs.security.repositories.XsrfTokenRepository;
import kmsweb.configs.security.services.*;
import kmsweb.repositories.*;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.*;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * Whitelist URLs which will not require authentication when accessed. However, Spring by default will still require
	 * an {@link org.springframework.security.core.Authentication} object if no logged in is detected.
	 */
	public static final String[] AUTH_WHITELIST = {
			// % protected region % [Add any additional whitelist URL here] off begin
			// % protected region % [Add any additional whitelist URL here] end
	};

	/**
	 * Similar to {@link #AUTH_WHITELIST} but for the specific purpose of allowing access during development only.
	 */
	public static final String[] DEV_AUTH_WHITELIST = {
			// % protected region % [Add any additional development whitelisted URL here] off begin
			// % protected region % [Add any additional development whitelisted URL here] end

			"/h2/**",
			"/actuator",
			"/actuator/**",
			"/voyager",
			"/altair",
			"/graphiql",
			"/swagger-ui.html",
	};

	/**
	 * Allow anonymous access for requests using the HTTP GET verb for these endpoints.
	 */
	public static final String[] ANONYMOUS_GET_AUTH_WHITELIST = {

			/* Static files */
			"/webjars/**",
			"/assets/**",
			"/static/",
			"/",
			"/logout",
			"/index.html",
			"/vendor/graphiql/**.js",

			/* Documentation */
			"/v3/api-docs/**",
			"/api-docs/**",
			"/swagger-ui/**",

			"/{x:(?!api|graphql|voyager|altair|graphiql|swagger-ui.html).*}",
			// % protected region % [Add any custom HTTP GET whitelist routes here] off begin
			// % protected region % [Add any custom HTTP GET whitelist routes here] end
	};

	/**
	 * Allow anonymous access for requests using the HTTP POST verb for these endpoints.
	 */
	public static final String[] ANONYMOUS_POST_AUTH_WHITELIST = {
			"/api/authorization/request-reset-password",
			"/graphql",
			// % protected region % [Add any custom HTTP POST whitelist routes here] off begin
			// % protected region % [Add any custom HTTP POST whitelist routes here] end
	};

	/**
	 * Allow anonymous access for requests using the HTTP PUT verb for these endpoints.
	 */
	public static final String[] ANONYMOUS_PUT_AUTH_WHITELIST = {
			// % protected region % [Add any custom HTTP PUT whitelist routes here] off begin
			// % protected region % [Add any custom HTTP PUT whitelist routes here] end
	};

	/**
	 * Key used for anonymous user if not authenticated. Note that this key is not configurable.
	 */
	public static final String ANONYMOUS_KEY = "anonymous";

	/**
	 * Username used for anonymous user if not authenticated. Note that this username is not configurable.
	 */
	public static final UserDetails ANONYMOUS_USERNAME = new User("anonymous@example.com", "anonymous", List.of());

	/**
	 * List of all roles that are applied to anonymous user. By default anonymous user is no different than normal a
	 * unauthenticated user.
	 */
	public static final List<GrantedAuthority> ANONYMOUS_ROLES = ImmutableList.of(
		// % protected region % [Add any additional public roles here] off begin
		// % protected region % [Add any additional public roles here] end
		new CustomGrantedAuthority("ROLE_VISITORS_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", "DoctorScheduleEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", "DiagnosticExaminationResultsEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", "MedicationCompoundEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_INACBG_ENTITY_BPJS_INACBG", "BpjsINACBGEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", "PatientPaymentSelfPayingEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", "CatalogueMedicalEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", "TariffDefinitionOtherComponentEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", "BpjsOutsideFacilityReferralEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", "DiagnosticSupportUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", "PatientSupportingDocumentEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", "BpjsPcareKegiatanKelompokEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", "InventoryAdjustmentEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", "ExaminationGroupEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", "ObstetricAndGynecologyHistoryEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", "RoomTransferEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", "PcareDiagnosaEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", "TransactionDetailTypeEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", "PatientGeneralInfoEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", "RetailPharmacyStockDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", "InventoryAdjustmentItemEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", "InventoryBatchCorrectionEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", "InvoicePaymentSelfPayingEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_REGISTRATION_ENTITY_REGISTRATION", "RegistrationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", "TransferOrderStockDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", "PatientCaseHistoryEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", "BpjsPatientReferralEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", "EntExaminationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", "PrescriptionItemEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", "BpjsPcareDPHOEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", "StockTransactionPerDateEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", "PurchaseRequisitionEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", "SampleCollectionInformationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", "ServiceItemAssignmentEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", "GoodsReceiveNoteItemEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", "InvoicePaymentInsuranceEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_REFERENCE_DATA_ENTITY_REFERENCE_DATA", "ReferenceDataEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", "InpatientMedicalExaminationRecordEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", "PharmacySetupEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", "UnitOfMeasurementEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", "BpjsDiagnoseEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", "BatchStockBalancePerDateEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", "MerchantSurchargeAndFeeEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PRB_ENTITY_BPJS_PRB", "BpjsPRBEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", "MedicalRecordUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", "InvoiceItemComponentEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", "CatalogueNonMedicalEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", "ExaminationItemEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", "McuPackageItemEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", "WarehouseInventoryEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_CASHIER_USER_ENTITY_CASHIER_USER", "CashierUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", "DailyCareCPPTEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", "PatientVisitPatientPaymentOthersEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BED_RESERVE_ENTITY_BED_RESERVE", "BedReserveEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_FACILITY_USER_ENTITY_FACILITY_USER", "FacilityUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", "BpjsDismissalConditionEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", "BatchStockTransactionDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_VITAL_SIGNS_ENTITY_VITAL_SIGNS", "VitalSignsEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", "BatchStockBalanceEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", "OphthalmologyExaminationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", "DiagnosticSupportGeneralConfigurationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", "PcareCompoundDrugItemEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", "MedicalCertificateHospitalizationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", "PurchaseRequisitionStockDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_ENTITY_INVOICE", "InvoiceEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", "BpjsJasaRaharjaEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", "ProcessWorkflowEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", "MedicalCertificateSickLeaveEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", "MedicalCertificateDischargeResumeEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_STAFF_ENTITY_STAFF", "StaffEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", "BpjsControlSpecialistEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", "ManagementUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", "BpjsDismissalMappingEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", "BpjsHealthFacilityEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", "PatientVisitPaymentSelfPayingEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", "BpjsSearchSEPEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", "PcareActionExaminationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", "PcareExaminationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", "StockTransactionDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_DOCTOR_USER_ENTITY_DOCTOR_USER", "DoctorUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", "MedicationItemEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", "BpjsDrugGenericPRBEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", "BpjsTreatmentRoomEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_FEE_ENTITY_MEDICAL_FEE", "MedicalFeeEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_STOCK_CONTROL_ENTITY_STOCK_CONTROL", "StockControlEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", "NumberingSetupEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", "MedicalCertificatePhysicalHealthEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", "HospitalBranchInformationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_ADMINISTRATOR_ENTITY_ADMINISTRATOR", "AdministratorEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_ICD_10_ENTITY_ICD_10", "Icd10Entity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_NURSE_USER_ENTITY_NURSE_USER", "NurseUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_UMUM_ENTITY_PCARE_UMUM", "PcareUmumEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_CASH_RECEIPT_ENTITY_CASH_RECEIPT", "CashReceiptEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", "BpjsPcareProviderRayonisasiEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", "MedicationHeaderEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_MCU_ENTITY_PCARE_MCU", "PcareMCUEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", "MedicalExaminationRecordEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PHARMACY_USER_ENTITY_PHARMACY_USER", "PharmacyUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", "ChartOfAccountEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", "BpjsSpecialReferralEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", "SampleCollectionItemsEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", "BpjsFacilityListEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_LOCATION_ENTITY_LOCATION", "LocationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", "InternalOrderEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", "MedicalCertificateRestrictedWorkEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", "DiagnosisExaminationRecordEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", "BpjsSEPINACBGIntegrationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", "BpjsPcareKunjunganRujukanEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", "BpjsAccidentMasterEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", "MedicalRecordInitialChecklistEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", "SupplierContactDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MERCHANT_ENTITY_MERCHANT", "MerchantEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", "PatientPaymentBPJSEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_CLAIM_USER_ENTITY_CLAIM_USER", "ClaimUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", "PcareTindakanEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", "PatientEmploymentDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", "AmendmentDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", "PostOperativeDetailsEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_CASH_REFUND_ENTITY_CASH_REFUND", "CashRefundEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", "StockTransactionPerDateTypeEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", "PatientVitalInformationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", "VaccinationOrderDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MCU_PACKAGE_ENTITY_MCU_PACKAGE", "McuPackageEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", "HemodialysisExaminationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", "CompoundPrescriptionItemEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_REGISTRATION_USER_ENTITY_REGISTRATION_USER", "RegistrationUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SERVICE_ENTITY_SERVICE", "ServiceEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", "FormulirKonselingTesHivEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", "BpjsBedAvailabilityEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PURCHASING_USER_ENTITY_PURCHASING_USER", "PurchasingUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", "BpjsDoctorScheduleEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", "BpjsClaimDataEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", "NewbornDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", "PatientPaymentInsuranceEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", "MedicalCertificateBirthEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", "CoTreatingDoctorEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", "IntraoperativeRecordsEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", "BpjsServiceMappingEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEP_ENTITY_BPJS_SEP", "BpjsSEPEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", "PrescriptionCompoundEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", "VaccinationOrderEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", "PreoperativeRecordsEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", "BpjsUpdateDismissalDateEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", "FacilityHistoryEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", "SystemAdminUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", "MedicalExaminationRecordDischargeSummaryEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SEP_ENTITY_SEP", "SepEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", "MedicalCertificateMentalHealthEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_ROOM_FACILITY_ENTITY_ROOM_FACILITY", "RoomFacilityEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", "PcareStatusPulangEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", "BpjsPcareRegistrationsEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", "BpjsPRBDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", "PatientConsentEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", "BpjsPcareRiwayatKunjunganEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", "WarehouseInitialStockEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", "ExaminationItemDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", "PatientContactInfoEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", "PcareClubProlanisEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", "PatientEmergencyContactDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", "BpjsTreatmentClassMappingEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", "InsuranceBenefitPlanEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", "BpjsINACBGClaimEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", "TransactionDetailTypeMappingEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", "HemodialysisMonitoringEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", "FluidBalanceDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", "InventoryBatchCorrectionItemEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", "PatientVisitPatientPaymentInsuranceEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", "OdontogramExaminationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", "BpjsSEPInternalDataEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", "BpjsListTaskEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", "MedicalCertificateMedicalAttendanceEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", "CompoundPrescriptionDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", "DiagnosisNandaEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", "BpjsJasaRaharjaClaimEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", "AdministrationUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", "ChartOfAccountMappingEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", "EmergencyMedicalExaminationRecordEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", "BpjsSEPSubmissionEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SUPPLIER_ENTITY_SUPPLIER", "SupplierEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", "InsuranceProviderEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", "MedicalTranscriberUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", "BpjsProcedureEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", "BpjsFingerPrintEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SERVICE_ITEM_ENTITY_SERVICE_ITEM", "ServiceItemEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", "TariffDefinitionEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", "PurchaseOrderStockDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", "TransferOrderEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", "BpjsSearchControlLetterEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", "BpjsVisitDataEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", "PatientDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", "ServiceFacilityCategoryEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", "BpjsTotalReferralSEPEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", "RetailPharmacyInvoiceEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", "PatientDetailAddressEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", "MedicalRecordNextVerificationChecklistEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_DOKTER_ENTITY_PCARE_DOKTER", "PcareDokterEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_ICD_9_CM_ENTITY_ICD_9_CM", "Icd9CMEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", "ReferenceHeaderEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", "InvoiceSummaryEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", "PatientPaymentOthersEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", "InvoicePaymentOtherEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", "BirthHistoryEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_ITEM_ENTITY_INVOICE_ITEM", "InvoiceItemEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", "SupplierProductDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", "BpjsDiagnosePRBEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_GENERAL_ENTITY_BPJS_GENERAL", "BpjsGeneralEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", "BpjsPcarePoliEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", "StockCatalogueEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", "HealthFacilityEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", "PatientPersonalInfoEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", "RetailPharmacyEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", "BpjsPcarePesertaKegiatanKelompokEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", "CashAllocationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", "PurchaseOrderEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", "CatalogueUOMEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BED_FACILITY_ENTITY_BED_FACILITY", "BedFacilityEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", "BodyChartExaminationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", "BpjsHospitalizationPlanEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", "ReturnSupplierStockDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", "BpjsPcareKesadaranEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", "HospitalGroupInformationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", "InventoryAdjusmentBatchEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", "BpjsClaimSubmissionEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_JOURNAL_ENTITY_JOURNAL", "JournalEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", "DiagnosticStaffExaminationSummaryEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", "PcareCompoundDrugEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", "BpjsINACBGVariableEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", "BpjsPcarePendaftaranEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", "PriceComponentEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", "BpjsDoctorMappingEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", "SatuSehatConfigurationEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", "DiagnosesAndProceduresEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", "TariffSchemaEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", "BpjsControlPlanEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", "TaskDashboardEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", "NurseVitalSignMeasurementEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", "BpjsListFingerPrintEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", "MedicalFeeItemComponentEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", "GoodsReceiveNoteEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", "OperatingTheaterMedicalExaminationRecordEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", "DeliveryProgressEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_VISIT_ENTITY_PATIENT_VISIT", "PatientVisitEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", "InternalOrderStockDetailEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", "ReturnSupplierEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", "MedicationAdministeredHistoryEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", "WarehouseUserEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_WAREHOUSE_ENTITY_WAREHOUSE", "WarehouseEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", "BpjsReferralSpecialistEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", "TariffFormulaEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", "BpjsTreatmentHistoryEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", "SupplierBankAccountEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", "InformedConsentEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", "DeliveryMedicalExaminationRecordEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", "PcareReferensiSaranaEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", "PrescriptionHeaderEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", "GoodsReceiveNoteBatchEntity", false, false, false, false),
		new CustomGrantedAuthority("ROLE_VISITORS_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", "PcareNonCompoundDrugEntity", false, false, false, false),
		// Stub authority to satisfy Spring security. This authority does not do anything and is not meant to be used
		// in any meaningful way.
		new CustomGrantedAuthority("ROLE_ANONYMOUS", "", false, false, false, false)
	);

	/**
	 * The anonymous user which will be set by default if there is no logged in user.
	 */
	public static final Authentication ANONYMOUS_USER = new AnonymousAuthenticationToken(
		ANONYMOUS_KEY,
		ANONYMOUS_USERNAME,
		ANONYMOUS_ROLES
	);

	/*
	 * Environment info.
	 */
	private boolean isDevEnvironment;
	private boolean isTestEnvironment;

	/*
	 * Authentication and security info.
	 */
	private final AuthenticationService authService;
	private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	/*
	 * User management services.
	 */
	private final UserService userService;

	/*
	 * Base user repository
	 */
	private final UserRepository userRepository;
	private final AdministrationUserRepository administrationUserRepository;
	private final AdministratorRepository administratorRepository;
	private final CashierUserRepository cashierUserRepository;
	private final ClaimUserRepository claimUserRepository;
	private final DiagnosticSupportUserRepository diagnosticSupportUserRepository;
	private final DoctorUserRepository doctorUserRepository;
	private final FacilityUserRepository facilityUserRepository;
	private final ManagementUserRepository managementUserRepository;
	private final MedicalRecordUserRepository medicalRecordUserRepository;
	private final MedicalTranscriberUserRepository medicalTranscriberUserRepository;
	private final NurseUserRepository nurseUserRepository;
	private final PharmacyUserRepository pharmacyUserRepository;
	private final PurchasingUserRepository purchasingUserRepository;
	private final RegistrationUserRepository registrationUserRepository;
	private final SystemAdminUserRepository systemAdminUserRepository;
	private final WarehouseUserRepository warehouseUserRepository;
	private final RoleRepository roleRepository;

	/*
	 * Login and logout handlers.
	 */
	private final AuthenticationSuccessHandler authSuccessHandler;
	private final AuthenticationFailureHandler authFailureHandler;
	private final LogoutSuccessHandler logoutHandler;

	private final XsrfTokenRepository xsrfTokenRepository;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public SecurityConfig(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			Environment env,
			AuthenticationService authService,
			RestAuthenticationEntryPoint restAuthenticationEntryPoint,
			UserService userService,
			UserRepository userRepository,
			RoleRepository roleRepository,
			AdministrationUserRepository administrationUserRepository,
			AdministratorRepository administratorRepository,
			CashierUserRepository cashierUserRepository,
			ClaimUserRepository claimUserRepository,
			DiagnosticSupportUserRepository diagnosticSupportUserRepository,
			DoctorUserRepository doctorUserRepository,
			FacilityUserRepository facilityUserRepository,
			ManagementUserRepository managementUserRepository,
			MedicalRecordUserRepository medicalRecordUserRepository,
			MedicalTranscriberUserRepository medicalTranscriberUserRepository,
			NurseUserRepository nurseUserRepository,
			PharmacyUserRepository pharmacyUserRepository,
			PurchasingUserRepository purchasingUserRepository,
			RegistrationUserRepository registrationUserRepository,
			SystemAdminUserRepository systemAdminUserRepository,
			WarehouseUserRepository warehouseUserRepository,
			AuthenticationSuccessHandler authSuccessHandler,
			AuthenticationFailureHandler authFailureHandler,
			LogoutSuccessHandler logoutHandler,
			XsrfTokenRepository xsrfTokenRepository
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		for (int i = 0; i < env.getActiveProfiles().length; ++i) {
			if (env.getActiveProfiles()[i].equals("dev")) {
				isDevEnvironment = true;
			} else if (env.getActiveProfiles()[i].equals("test")) {
				isTestEnvironment = true;
			}
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		this.authService = authService;
		this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
		this.userService = userService;
		this.administrationUserRepository = administrationUserRepository;
		this.administratorRepository = administratorRepository;
		this.cashierUserRepository = cashierUserRepository;
		this.claimUserRepository = claimUserRepository;
		this.diagnosticSupportUserRepository = diagnosticSupportUserRepository;
		this.doctorUserRepository = doctorUserRepository;
		this.facilityUserRepository = facilityUserRepository;
		this.managementUserRepository = managementUserRepository;
		this.medicalRecordUserRepository = medicalRecordUserRepository;
		this.medicalTranscriberUserRepository = medicalTranscriberUserRepository;
		this.nurseUserRepository = nurseUserRepository;
		this.pharmacyUserRepository = pharmacyUserRepository;
		this.purchasingUserRepository = purchasingUserRepository;
		this.registrationUserRepository = registrationUserRepository;
		this.systemAdminUserRepository = systemAdminUserRepository;
		this.warehouseUserRepository = warehouseUserRepository;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.authSuccessHandler = authSuccessHandler;
		this.authFailureHandler = authFailureHandler;
		this.logoutHandler = logoutHandler;
		this.xsrfTokenRepository = xsrfTokenRepository;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// % protected region % [Add any additional security configuration before the main body here] off begin
		// % protected region % [Add any additional security configuration before the main body here] end

		if (isDevEnvironment || isTestEnvironment) {
			// % protected region % [Add any additional security configuration for dev and test environments before the main body here] off begin
			// % protected region % [Add any additional security configuration for dev and test environments before the main body here] end

			// % protected region % [Override the CORS configuration here for test and development] off begin
			var corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
			corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:8000"));
			corsConfiguration.addAllowedMethod(HttpMethod.OPTIONS);
			corsConfiguration.setAllowCredentials(true);
			// % protected region % [Override the CORS configuration here for test and development] end

			http
				.csrf()
				.ignoringAntMatchers(new String[] {
					"/graphql",
					"/api/**"
				})
				.and()
				.cors().configurationSource(request -> corsConfiguration)
				.and()
				.authorizeRequests()
				.antMatchers(DEV_AUTH_WHITELIST).permitAll()
				.and()
				// Allow browsers to load the h2 console
				.headers().frameOptions().sameOrigin();

			// % protected region % [Add any additional security configuration for dev and test environments after the main body here] off begin
			// % protected region % [Add any additional security configuration for dev and test environments after the main body here] end
	} else {
			// % protected region % [Add any additional security configuration for other environments before the main body here] off begin
			// % protected region % [Add any additional security configuration for other environments before the main body here] end

			// % protected region % [Override strict HTTPS mode here] off begin
			http
					.requiresChannel()
					.antMatchers("/**").requiresSecure();
			// % protected region % [Override strict HTTPS mode here] end

			// % protected region % [Add any additional security configuration for other environments after the main body here] off begin
			// % protected region % [Add any additional security configuration for other environments after the main body here] end
		}

		// % protected region % [Add any additional security configuration here] off begin
		// % protected region % [Add any additional security configuration here] end

		http
				.csrf().csrfTokenRepository(xsrfTokenRepository)
				.ignoringAntMatchers(new String[] {
					"/auth/login",
					"/api/authorization/reset-password",
					"/api/authorization/request-reset-password",
					"/auth/account/register/administration-user",
					"/auth/account/register/administrator",
					"/auth/account/register/cashier-user",
					"/auth/account/register/claim-user",
					"/auth/account/register/diagnostic-support-user",
					"/auth/account/register/doctor-user",
					"/auth/account/register/facility-user",
					"/auth/account/register/management-user",
					"/auth/account/register/medical-record-user",
					"/auth/account/register/medical-transcriber-user",
					"/auth/account/register/nurse-user",
					"/auth/account/register/pharmacy-user",
					"/auth/account/register/purchasing-user",
					"/auth/account/register/registration-user",
					"/auth/account/register/system-admin-user",
					"/auth/account/register/warehouse-user",
				})
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers(AUTH_WHITELIST).permitAll()
				.antMatchers(HttpMethod.GET, ANONYMOUS_GET_AUTH_WHITELIST).permitAll()
				.antMatchers(HttpMethod.POST, ANONYMOUS_POST_AUTH_WHITELIST).permitAll()
				.antMatchers(HttpMethod.PUT, ANONYMOUS_PUT_AUTH_WHITELIST).permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/auth/login")
					.successHandler(authSuccessHandler)
					.failureHandler(authFailureHandler)
				.and()
				.logout()
					.logoutUrl("/auth/logout")
					.logoutSuccessHandler(logoutHandler)
					.deleteCookies(AuthenticationService.AUTH_TOKEN_COOKIE_NAME)
					.deleteCookies(XsrfTokenRepository.XSRF_TOKEN_COOKIE_NAME)
				.and()
				// % protected region % [Add any additional filters before the main ones here] off begin
				// % protected region % [Add any additional filters before the main ones here] end
				.addFilterBefore(
						new ResetPasswordFilter(
								"/api/authorization/reset-password",
								userService,
								authSuccessHandler,
								passwordEncoder(),
								authenticationManager()
						),
						UsernamePasswordAuthenticationFilter.class
				)
				.addFilterBefore(
						new AdministrationUserRegistrationFilter(
								"/auth/account/register/administration-user",
								authService,
								administrationUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new AdministratorRegistrationFilter(
								"/auth/account/register/administrator",
								authService,
								administratorRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new CashierUserRegistrationFilter(
								"/auth/account/register/cashier-user",
								authService,
								cashierUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new ClaimUserRegistrationFilter(
								"/auth/account/register/claim-user",
								authService,
								claimUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new DiagnosticSupportUserRegistrationFilter(
								"/auth/account/register/diagnostic-support-user",
								authService,
								diagnosticSupportUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new DoctorUserRegistrationFilter(
								"/auth/account/register/doctor-user",
								authService,
								doctorUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new FacilityUserRegistrationFilter(
								"/auth/account/register/facility-user",
								authService,
								facilityUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new ManagementUserRegistrationFilter(
								"/auth/account/register/management-user",
								authService,
								managementUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new MedicalRecordUserRegistrationFilter(
								"/auth/account/register/medical-record-user",
								authService,
								medicalRecordUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new MedicalTranscriberUserRegistrationFilter(
								"/auth/account/register/medical-transcriber-user",
								authService,
								medicalTranscriberUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new NurseUserRegistrationFilter(
								"/auth/account/register/nurse-user",
								authService,
								nurseUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new PharmacyUserRegistrationFilter(
								"/auth/account/register/pharmacy-user",
								authService,
								pharmacyUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new PurchasingUserRegistrationFilter(
								"/auth/account/register/purchasing-user",
								authService,
								purchasingUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new RegistrationUserRegistrationFilter(
								"/auth/account/register/registration-user",
								authService,
								registrationUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new SystemAdminUserRegistrationFilter(
								"/auth/account/register/system-admin-user",
								authService,
								systemAdminUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new WarehouseUserRegistrationFilter(
								"/auth/account/register/warehouse-user",
								authService,
								warehouseUserRepository,
								roleRepository,
								passwordEncoder()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new JwtAuthenticationFilter("/graphql", authService),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new JwtAuthenticationFilter("/api/(?!api-docs).*", authService),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(
						new JwtAuthenticationFilter("/actuator/info", authService),
						UsernamePasswordAuthenticationFilter.class)
				// % protected region % [Add any additional filters after the main ones here] off begin
				// % protected region % [Add any additional filters after the main ones here] end
				.exceptionHandling()
				.authenticationEntryPoint(restAuthenticationEntryPoint);

		// % protected region % [Add any additional security configuration after the main body here] off begin
		// % protected region % [Add any additional security configuration after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// % protected region % [Add any additional logic for configure before the main body here] off begin
		// % protected region % [Add any additional logic for configure before the main body here] end

		auth
				// % protected region % [Add any additional configurations for the authentication manager here] off begin
				// % protected region % [Add any additional configurations for the authentication manager here] end
				.authenticationProvider(authenticationProvider())
				.jdbcAuthentication();

		// % protected region % [Add any additional logic for configure after the main body here] off begin
		// % protected region % [Add any additional logic for configure after the main body here] end
	}

	/**
	 * Authentication provider to be used in the authentication process. This differs from the default provider due to
	 * the custom {@link UserService} that handles authenticating users.
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		// % protected region % [Add any additional logic for authenticationProvider before the main body here] off begin
		// % protected region % [Add any additional logic for authenticationProvider before the main body here] end

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(passwordEncoder());

		// % protected region % [Add any additional logic for authenticationProvider after the main body here] off begin
		// % protected region % [Add any additional logic for authenticationProvider after the main body here] end

		return authProvider;
	}

	/**
	 * Password encoder used to encode user password during registration process.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		// % protected region % [Update password encoder configuration here] off begin
		return new BCryptPasswordEncoder(11);
		// % protected region % [Update password encoder configuration here] end
	}

	// % protected region % [Update request logging configuration here] off begin
	/**
	 * Filter used to log request info for every request that reaches the server side.
	 */
	@Bean
	public RequestLoggingFilter logFilter() {
		return new RequestLoggingFilter();
	}
	// % protected region % [Update request logging configuration here] end


	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
