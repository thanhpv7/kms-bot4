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
package kmsweb.configs.security.filters;

import org.springframework.security.web.csrf.DefaultCsrfToken;
import kmsweb.configs.security.SecurityConfig;
import kmsweb.configs.security.authorities.CustomGrantedAuthority;
import kmsweb.configs.security.services.AuthenticationService;
import kmsweb.configs.security.repositories.XsrfTokenRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import io.jsonwebtoken.ExpiredJwtException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.FilterChain;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Tag("authentication")
@Tag("filter")
@Tag("security")
// % protected region % [Add any additional test tags or configuration here] off begin
// % protected region % [Add any additional test tags or configuration here] end
public class JwtAuthenticationFilterTest {
	private final String USER_USERNAME = "test@example.com";
	private final String USER_PASSWORD = "password";

	// Filter under test
	private JwtAuthenticationFilter authFilter;

	@Mock
	private XsrfTokenRepository xsrfTokenRepository;

	@Mock
	private AuthenticationService authService;

	@Mock
	private Authentication authentication;

	@Mock
	private UserDetails userDetails;

	@Mock
	private SecurityContext securityContext;

	// Mock request and response to be used for the tests.
	private MockHttpServletResponse response;
	private MockHttpServletRequest request;

	private List<GrantedAuthority> anonymousRoles;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@BeforeEach
	void setup() {
		// % protected region % [Add any additional logic for setup before the main body here] off begin
		// % protected region % [Add any additional logic for setup before the main body here] end

		MockitoAnnotations.initMocks(this);

		when(userDetails.getUsername()).thenReturn(USER_USERNAME);
		when(userDetails.getPassword()).thenReturn(USER_PASSWORD);
		when(authentication.getPrincipal()).thenReturn(userDetails);

		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();

		SecurityContextHolder.setContext(securityContext);

		authFilter = new JwtAuthenticationFilter("", authService);

		anonymousRoles = ImmutableList.of(
			// % protected region % [Add any additional anonymous roles here] off begin
			// % protected region % [Add any additional anonymous roles here] end
			new CustomGrantedAuthority("ROLE_VISITORS_REFERENCE_DATA_ENTITY_REFERENCE_DATA", "ReferenceDataEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", "ReferenceHeaderEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", "PatientGeneralInfoEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_REGISTRATION_ENTITY_REGISTRATION", "RegistrationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_FEE_ENTITY_MEDICAL_FEE", "MedicalFeeEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", "MedicalExaminationRecordEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", "PrescriptionHeaderEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SERVICE_ENTITY_SERVICE", "ServiceEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", "WarehouseInventoryEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", "TariffDefinitionEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_WAREHOUSE_ENTITY_WAREHOUSE", "WarehouseEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_LOCATION_ENTITY_LOCATION", "LocationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SERVICE_ITEM_ENTITY_SERVICE_ITEM", "ServiceItemEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", "TariffSchemaEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", "ServiceItemAssignmentEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_STAFF_ENTITY_STAFF", "StaffEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_ADMINISTRATOR_ENTITY_ADMINISTRATOR", "AdministratorEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_VISIT_ENTITY_PATIENT_VISIT", "PatientVisitEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", "PatientDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", "PatientPersonalInfoEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", "PatientDetailAddressEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", "PatientContactInfoEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", "PatientEmergencyContactDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", "PatientPaymentSelfPayingEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", "PatientPaymentInsuranceEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", "InsuranceProviderEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", "InsuranceBenefitPlanEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", "PatientPaymentOthersEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", "PatientCaseHistoryEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", "PatientSupportingDocumentEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", "PatientPaymentBPJSEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_ICD_10_ENTITY_ICD_10", "Icd10Entity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_ICD_9_CM_ENTITY_ICD_9_CM", "Icd9CMEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", "DoctorScheduleEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", "PatientEmploymentDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", "ExaminationGroupEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", "ExaminationItemEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", "CatalogueMedicalEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", "UnitOfMeasurementEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", "CatalogueNonMedicalEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", "PatientVisitPaymentSelfPayingEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", "PatientVisitPatientPaymentInsuranceEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", "PatientVisitPatientPaymentOthersEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", "StockCatalogueEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_ROOM_FACILITY_ENTITY_ROOM_FACILITY", "RoomFacilityEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BED_FACILITY_ENTITY_BED_FACILITY", "BedFacilityEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", "DiagnosesAndProceduresEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MCU_PACKAGE_ENTITY_MCU_PACKAGE", "McuPackageEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", "McuPackageItemEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", "HealthFacilityEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", "DiagnosisExaminationRecordEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", "DiagnosisNandaEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", "HospitalGroupInformationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", "HospitalBranchInformationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", "PrescriptionItemEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", "PrescriptionCompoundEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", "MedicalCertificateSickLeaveEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", "MedicalCertificateRestrictedWorkEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", "MedicalCertificateMedicalAttendanceEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", "MedicalRecordInitialChecklistEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", "MedicalRecordNextVerificationChecklistEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", "PriceComponentEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", "TariffDefinitionOtherComponentEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", "TariffFormulaEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_ENTITY_INVOICE", "InvoiceEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", "InvoicePaymentSelfPayingEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", "InvoicePaymentOtherEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", "PharmacySetupEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", "NumberingSetupEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", "AdministrationUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DOCTOR_USER_ENTITY_DOCTOR_USER", "DoctorUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_NURSE_USER_ENTITY_NURSE_USER", "NurseUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PHARMACY_USER_ENTITY_PHARMACY_USER", "PharmacyUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", "CompoundPrescriptionDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", "CompoundPrescriptionItemEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", "MedicalRecordUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", "ManagementUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_FACILITY_USER_ENTITY_FACILITY_USER", "FacilityUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_CLAIM_USER_ENTITY_CLAIM_USER", "ClaimUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_ITEM_ENTITY_INVOICE_ITEM", "InvoiceItemEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", "InvoiceSummaryEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", "InvoiceItemComponentEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MERCHANT_ENTITY_MERCHANT", "MerchantEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", "MerchantSurchargeAndFeeEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_CASH_RECEIPT_ENTITY_CASH_RECEIPT", "CashReceiptEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", "MedicalFeeItemComponentEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", "CashAllocationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_CASH_REFUND_ENTITY_CASH_REFUND", "CashRefundEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_CASHIER_USER_ENTITY_CASHIER_USER", "CashierUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", "InvoicePaymentInsuranceEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_GENERAL_ENTITY_BPJS_GENERAL", "BpjsGeneralEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", "BpjsDoctorMappingEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", "BpjsServiceMappingEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", "BpjsDismissalMappingEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", "BpjsTreatmentClassMappingEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_INACBG_ENTITY_BPJS_INACBG", "BpjsINACBGEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", "BpjsINACBGVariableEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SEP_ENTITY_SEP", "SepEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SUPPLIER_ENTITY_SUPPLIER", "SupplierEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", "SupplierContactDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", "SupplierBankAccountEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", "InpatientMedicalExaminationRecordEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", "RoomTransferEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", "CoTreatingDoctorEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", "WarehouseInitialStockEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", "CatalogueUOMEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", "GoodsReceiveNoteEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", "GoodsReceiveNoteItemEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", "GoodsReceiveNoteBatchEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", "StockTransactionDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", "TransactionDetailTypeEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", "TransactionDetailTypeMappingEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", "StockTransactionPerDateTypeEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_STOCK_CONTROL_ENTITY_STOCK_CONTROL", "StockControlEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", "BatchStockTransactionDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", "BatchStockBalanceEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", "BatchStockBalancePerDateEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", "StockTransactionPerDateEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", "MedicalCertificateHospitalizationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", "MedicalCertificateDischargeResumeEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", "InventoryBatchCorrectionEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", "InventoryBatchCorrectionItemEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", "InventoryAdjustmentEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", "InventoryAdjustmentItemEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", "InventoryAdjusmentBatchEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", "BpjsDoctorScheduleEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", "MedicalExaminationRecordDischargeSummaryEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", "TaskDashboardEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", "BpjsBedAvailabilityEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", "BpjsListTaskEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", "AmendmentDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", "BpjsDiagnoseEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", "BpjsDiagnosePRBEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", "BpjsDrugGenericPRBEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", "BpjsProcedureEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", "BpjsDismissalConditionEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", "BpjsJasaRaharjaEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", "BpjsPatientReferralEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEP_ENTITY_BPJS_SEP", "BpjsSEPEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_REGISTRATION_USER_ENTITY_REGISTRATION_USER", "RegistrationUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", "BpjsHealthFacilityEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", "BpjsAccidentMasterEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", "MedicationHeaderEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", "MedicationItemEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", "MedicationCompoundEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", "DiagnosticExaminationResultsEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", "DiagnosticStaffExaminationSummaryEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", "BpjsReferralSpecialistEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", "BpjsFacilityListEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", "BpjsFingerPrintEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", "BpjsListFingerPrintEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", "BpjsClaimDataEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", "BpjsTreatmentHistoryEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", "BpjsSEPINACBGIntegrationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", "BpjsSEPInternalDataEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", "BpjsJasaRaharjaClaimEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", "BpjsControlPlanEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", "BpjsControlSpecialistEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", "BpjsHospitalizationPlanEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", "BpjsOutsideFacilityReferralEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", "BpjsTotalReferralSEPEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", "BpjsSpecialReferralEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BED_RESERVE_ENTITY_BED_RESERVE", "BedReserveEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", "BpjsSearchSEPEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", "BpjsSEPSubmissionEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", "BpjsClaimSubmissionEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", "BpjsVisitDataEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", "BpjsSearchControlLetterEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", "WarehouseUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", "DiagnosticSupportUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", "VaccinationOrderEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", "VaccinationOrderDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_JOURNAL_ENTITY_JOURNAL", "JournalEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", "ChartOfAccountEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", "ExaminationItemDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PRB_ENTITY_BPJS_PRB", "BpjsPRBEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", "BpjsPRBDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", "BpjsTreatmentRoomEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", "BpjsINACBGClaimEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_UMUM_ENTITY_PCARE_UMUM", "PcareUmumEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", "PcareDiagnosaEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_DOKTER_ENTITY_PCARE_DOKTER", "PcareDokterEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", "PcareStatusPulangEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", "BpjsPcareKesadaranEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", "BpjsPcareProviderRayonisasiEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", "PcareTindakanEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", "PcareClubProlanisEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", "BpjsPcarePoliEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", "BpjsPcareDPHOEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", "BpjsPcareKegiatanKelompokEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_MCU_ENTITY_PCARE_MCU", "PcareMCUEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", "BpjsPcarePesertaKegiatanKelompokEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", "BpjsPcareKunjunganRujukanEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", "BpjsPcarePendaftaranEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", "BpjsPcareRegistrationsEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", "MedicationAdministeredHistoryEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", "ChartOfAccountMappingEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", "EmergencyMedicalExaminationRecordEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", "FacilityHistoryEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", "DeliveryMedicalExaminationRecordEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", "NewbornDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_VITAL_SIGNS_ENTITY_VITAL_SIGNS", "VitalSignsEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", "DailyCareCPPTEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", "PostOperativeDetailsEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", "PreoperativeRecordsEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", "IntraoperativeRecordsEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", "OperatingTheaterMedicalExaminationRecordEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", "SystemAdminUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", "PatientVitalInformationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", "FluidBalanceDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", "BpjsUpdateDismissalDateEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", "SupplierProductDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", "TransferOrderEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", "InternalOrderEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", "InternalOrderStockDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", "TransferOrderStockDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", "PcareExaminationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", "PcareActionExaminationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", "PcareNonCompoundDrugEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", "PcareCompoundDrugEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", "PcareCompoundDrugItemEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", "PurchaseRequisitionEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", "PurchaseRequisitionStockDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", "PurchaseOrderEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", "PurchaseOrderStockDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", "ReturnSupplierEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", "ReturnSupplierStockDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", "SatuSehatConfigurationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", "PcareReferensiSaranaEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", "BpjsPcareRiwayatKunjunganEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PURCHASING_USER_ENTITY_PURCHASING_USER", "PurchasingUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", "RetailPharmacyEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", "RetailPharmacyStockDetailEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", "DiagnosticSupportGeneralConfigurationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", "ObstetricAndGynecologyHistoryEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", "BodyChartExaminationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", "BirthHistoryEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", "PatientConsentEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", "RetailPharmacyInvoiceEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", "InformedConsentEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", "MedicalCertificatePhysicalHealthEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", "MedicalCertificateMentalHealthEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", "DeliveryProgressEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", "ProcessWorkflowEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", "SampleCollectionInformationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", "SampleCollectionItemsEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", "EntExaminationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", "MedicalTranscriberUserEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", "OphthalmologyExaminationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", "MedicalCertificateBirthEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", "HemodialysisExaminationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", "HemodialysisMonitoringEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", "OdontogramExaminationEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", "FormulirKonselingTesHivEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", "NurseVitalSignMeasurementEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_VISITORS_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", "ServiceFacilityCategoryEntity", false, false, false, false),
			new CustomGrantedAuthority("ROLE_ANONYMOUS", "", false, false, false, false)
		);

		// % protected region % [Add any additional logic for setup after the main body here] off begin
		// % protected region % [Add any additional logic for setup after the main body here] end
	}

	@AfterEach
	void tearDown() {
		// % protected region % [Add any additional logic for tearDown before the main body here] off begin
		// % protected region % [Add any additional logic for tearDown before the main body here] end

		SecurityContextHolder.clearContext();

		// % protected region % [Add any additional logic for tearDown after the main body here] off begin
		// % protected region % [Add any additional logic for tearDown after the main body here] end
	}

	@Test
	void normalAttemptAuthentication() {
		// % protected region % [Add any additional logic for normalAttemptAuthentication before the main body here] off begin
		// % protected region % [Add any additional logic for normalAttemptAuthentication before the main body here] end

		when(authService.getAuthentication(request)).thenReturn(authentication);
		FilterChain chain = mock(FilterChain.class);

		// % protected region % [Add any additional logic for normalAttemptAuthentication before assertions here] off begin
		// % protected region % [Add any additional logic for normalAttemptAuthentication before assertions here] end

		Authentication auth = authFilter.attemptAuthentication(request, response);

		assertNotNull(auth);
		assertEquals(authentication, auth);

		try {
			authFilter.successfulAuthentication(request, response, chain, auth);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unexpected exception found");
		}

		verify(securityContext, atLeast(1)).setAuthentication(auth);

		// % protected region % [Add any additional logic for normalAttemptAuthentication after the main body here] off begin
		// % protected region % [Add any additional logic for normalAttemptAuthentication after the main body here] end
	}

	@Test
	void missingAuthentication() {
		// % protected region % [Add any additional logic for missingAuthentication before the main body here] off begin
		// % protected region % [Add any additional logic for missingAuthentication before the main body here] end

		when(authService.getAuthentication(request)).thenReturn(null);

		// % protected region % [Add any additional logic for missingAuthentication before the assertions here] off begin
		// % protected region % [Add any additional logic for missingAuthentication before the assertions here] end

		Authentication anonymousUser = authFilter.attemptAuthentication(request, response);

		assertTrue(anonymousUser instanceof AnonymousAuthenticationToken);
		assertEquals(SecurityConfig.ANONYMOUS_USERNAME, anonymousUser.getPrincipal());
		assertEquals(SecurityConfig.ANONYMOUS_KEY.hashCode(), ((AnonymousAuthenticationToken) anonymousUser).getKeyHash());
		assertThat(anonymousUser.getAuthorities(), is(anonymousRoles));

		// % protected region % [Add any additional logic for missingAuthentication after the main body here] off begin
		// % protected region % [Add any additional logic for missingAuthentication after the main body here] end
	}

	@Test
	void expiredTokenAuthentication() {

		when(authService.getAuthentication(request)).thenThrow(ExpiredJwtException.class);
		FilterChain chain = mock(FilterChain.class);

		// % protected region % [Add any additional logic for expiredTokenAuthentication before assertions here] off begin
		// % protected region % [Add any additional logic for expiredTokenAuthentication before assertions here] end

		var exception = assertThrows(InsufficientAuthenticationException.class, () -> {
			Authentication auth = authFilter.attemptAuthentication(request, response);
		});

		assertTrue(exception.getCause() instanceof ExpiredJwtException);
		assertEquals("Token Expired", exception.getMessage());

		// % protected region % [Add any additional logic for expiredTokenAuthentication after the main body here] off begin
		// % protected region % [Add any additional logic for expiredTokenAuthentication after the main body here] end
	}

	@Test
	void unsuccessfulAuthentication() {
		// % protected region % [Add any additional logic for unsuccessfulAuthentication before the main body here] off begin
		// % protected region % [Add any additional logic for unsuccessfulAuthentication before the main body here] end

		ObjectMapper mapper = new ObjectMapper();

		try {
			authFilter.unsuccessfulAuthentication(request, response, new AuthenticationCredentialsNotFoundException(null));
			Map<String, String> json = mapper.readValue(response.getContentAsString(), new TypeReference<Map<String, String>>(){});

			// % protected region % [Add any additional logic for unsuccessfulAuthentication before the main assertions here] off begin
			// % protected region % [Add any additional logic for unsuccessfulAuthentication before the main assertions here] end

			// Check that exception handling is correct.
			assertEquals(401, response.getStatus());
			assertEquals("application/json", response.getContentType());
			assertEquals("invalid_grant", json.get("error"));
			assertEquals("The username/password combination is invalid.", json.get("error_description"));

			// % protected region % [Add any additional logic for unsuccessfulAuthentication after the main body here] off begin
			// % protected region % [Add any additional logic for unsuccessfulAuthentication after the main body here] end

		} catch (Exception e) {
			e.printStackTrace();
			fail("Unexpected exception found");
		}
	}
}