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
package kmsweb.configs.security.data;

import kmsweb.configs.security.helpers.AnonymousHelper;
import kmsweb.entities.RoleEntity;
import kmsweb.repositories.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static kmsweb.configs.security.helpers.RoleAndPrivilegeHelper.createOrUpdatePrivilege;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Setup the Roles and Privileges for the application
 */
@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RolesAndPrivileges implements ApplicationRunner {

	private final RoleRepository roleRepository;

	@Autowired
	public RolesAndPrivileges(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			RoleRepository roleRepository
	) {
		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		this.roleRepository = roleRepository;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// % protected region % [Add any additional pre-setup logic here] off begin
		// % protected region % [Add any additional pre-setup logic here] end

		AnonymousHelper.runAnonymously(this::setup);

		// % protected region % [Add any additional post-setup logic here] off begin
		// % protected region % [Add any additional post-setup logic here] end
	}

	/**
	 * Create default roles and privileges to be associated with users. Note that this method does not take anonymous
	 * roles into account. Instead it is deferred to {@link kmsweb.configs.security.filters.AuthenticationFilter}.
	 */
	private void setup() {
		// % protected region % [Override the setup here] off begin
		final String administratorRoleName = "ADMINISTRATOR";
		Optional<RoleEntity> administratorRoleOpt = roleRepository.findByName(administratorRoleName);
		var administratorRoleEntity = administratorRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(administratorRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(administratorRoleEntity, "ReferenceDataEntity",
		"ROLE_ADMINISTRATOR_REFERENCE_DATA_ENTITY_REFERENCE_DATA", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ReferenceHeaderEntity",
		"ROLE_ADMINISTRATOR_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_ADMINISTRATOR_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "RegistrationEntity",
		"ROLE_ADMINISTRATOR_REGISTRATION_ENTITY_REGISTRATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalFeeEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_ADMINISTRATOR_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ServiceEntity",
		"ROLE_ADMINISTRATOR_SERVICE_ENTITY_SERVICE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "WarehouseInventoryEntity",
		"ROLE_ADMINISTRATOR_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "TariffDefinitionEntity",
		"ROLE_ADMINISTRATOR_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "WarehouseEntity",
		"ROLE_ADMINISTRATOR_WAREHOUSE_ENTITY_WAREHOUSE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "LocationEntity",
		"ROLE_ADMINISTRATOR_LOCATION_ENTITY_LOCATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ServiceItemEntity",
		"ROLE_ADMINISTRATOR_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "TariffSchemaEntity",
		"ROLE_ADMINISTRATOR_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_ADMINISTRATOR_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "StaffEntity",
		"ROLE_ADMINISTRATOR_STAFF_ENTITY_STAFF", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "AdministratorEntity",
		"ROLE_ADMINISTRATOR_ADMINISTRATOR_ENTITY_ADMINISTRATOR", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientVisitEntity",
		"ROLE_ADMINISTRATOR_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientDetailEntity",
		"ROLE_ADMINISTRATOR_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_ADMINISTRATOR_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientDetailAddressEntity",
		"ROLE_ADMINISTRATOR_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientContactInfoEntity",
		"ROLE_ADMINISTRATOR_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_ADMINISTRATOR_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_ADMINISTRATOR_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_ADMINISTRATOR_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InsuranceProviderEntity",
		"ROLE_ADMINISTRATOR_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_ADMINISTRATOR_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_ADMINISTRATOR_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_ADMINISTRATOR_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_ADMINISTRATOR_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_ADMINISTRATOR_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "Icd10Entity",
		"ROLE_ADMINISTRATOR_ICD_10_ENTITY_ICD_10", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "Icd9CMEntity",
		"ROLE_ADMINISTRATOR_ICD_9_CM_ENTITY_ICD_9_CM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DoctorScheduleEntity",
		"ROLE_ADMINISTRATOR_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_ADMINISTRATOR_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ExaminationGroupEntity",
		"ROLE_ADMINISTRATOR_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ExaminationItemEntity",
		"ROLE_ADMINISTRATOR_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "CatalogueMedicalEntity",
		"ROLE_ADMINISTRATOR_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_ADMINISTRATOR_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_ADMINISTRATOR_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_ADMINISTRATOR_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_ADMINISTRATOR_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_ADMINISTRATOR_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "StockCatalogueEntity",
		"ROLE_ADMINISTRATOR_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "RoomFacilityEntity",
		"ROLE_ADMINISTRATOR_ROOM_FACILITY_ENTITY_ROOM_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BedFacilityEntity",
		"ROLE_ADMINISTRATOR_BED_FACILITY_ENTITY_BED_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_ADMINISTRATOR_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "McuPackageEntity",
		"ROLE_ADMINISTRATOR_MCU_PACKAGE_ENTITY_MCU_PACKAGE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "McuPackageItemEntity",
		"ROLE_ADMINISTRATOR_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "HealthFacilityEntity",
		"ROLE_ADMINISTRATOR_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_ADMINISTRATOR_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DiagnosisNandaEntity",
		"ROLE_ADMINISTRATOR_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_ADMINISTRATOR_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_ADMINISTRATOR_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PrescriptionItemEntity",
		"ROLE_ADMINISTRATOR_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_ADMINISTRATOR_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PriceComponentEntity",
		"ROLE_ADMINISTRATOR_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_ADMINISTRATOR_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "TariffFormulaEntity",
		"ROLE_ADMINISTRATOR_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InvoiceEntity",
		"ROLE_ADMINISTRATOR_INVOICE_ENTITY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_ADMINISTRATOR_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_ADMINISTRATOR_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PharmacySetupEntity",
		"ROLE_ADMINISTRATOR_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "NumberingSetupEntity",
		"ROLE_ADMINISTRATOR_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "AdministrationUserEntity",
		"ROLE_ADMINISTRATOR_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DoctorUserEntity",
		"ROLE_ADMINISTRATOR_DOCTOR_USER_ENTITY_DOCTOR_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "NurseUserEntity",
		"ROLE_ADMINISTRATOR_NURSE_USER_ENTITY_NURSE_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PharmacyUserEntity",
		"ROLE_ADMINISTRATOR_PHARMACY_USER_ENTITY_PHARMACY_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_ADMINISTRATOR_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_ADMINISTRATOR_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalRecordUserEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ManagementUserEntity",
		"ROLE_ADMINISTRATOR_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "FacilityUserEntity",
		"ROLE_ADMINISTRATOR_FACILITY_USER_ENTITY_FACILITY_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ClaimUserEntity",
		"ROLE_ADMINISTRATOR_CLAIM_USER_ENTITY_CLAIM_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InvoiceItemEntity",
		"ROLE_ADMINISTRATOR_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InvoiceSummaryEntity",
		"ROLE_ADMINISTRATOR_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_ADMINISTRATOR_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MerchantEntity",
		"ROLE_ADMINISTRATOR_MERCHANT_ENTITY_MERCHANT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_ADMINISTRATOR_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "CashReceiptEntity",
		"ROLE_ADMINISTRATOR_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "CashAllocationEntity",
		"ROLE_ADMINISTRATOR_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "CashRefundEntity",
		"ROLE_ADMINISTRATOR_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "CashierUserEntity",
		"ROLE_ADMINISTRATOR_CASHIER_USER_ENTITY_CASHIER_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_ADMINISTRATOR_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsGeneralEntity",
		"ROLE_ADMINISTRATOR_BPJS_GENERAL_ENTITY_BPJS_GENERAL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_ADMINISTRATOR_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_ADMINISTRATOR_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_ADMINISTRATOR_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_ADMINISTRATOR_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsINACBGEntity",
		"ROLE_ADMINISTRATOR_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_ADMINISTRATOR_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "SepEntity",
		"ROLE_ADMINISTRATOR_SEP_ENTITY_SEP", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "SupplierEntity",
		"ROLE_ADMINISTRATOR_SUPPLIER_ENTITY_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "SupplierContactDetailEntity",
		"ROLE_ADMINISTRATOR_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "SupplierBankAccountEntity",
		"ROLE_ADMINISTRATOR_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_ADMINISTRATOR_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "RoomTransferEntity",
		"ROLE_ADMINISTRATOR_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_ADMINISTRATOR_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_ADMINISTRATOR_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "CatalogueUOMEntity",
		"ROLE_ADMINISTRATOR_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_ADMINISTRATOR_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_ADMINISTRATOR_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_ADMINISTRATOR_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "StockTransactionDetailEntity",
		"ROLE_ADMINISTRATOR_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_ADMINISTRATOR_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_ADMINISTRATOR_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_ADMINISTRATOR_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "StockControlEntity",
		"ROLE_ADMINISTRATOR_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_ADMINISTRATOR_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BatchStockBalanceEntity",
		"ROLE_ADMINISTRATOR_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_ADMINISTRATOR_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_ADMINISTRATOR_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_ADMINISTRATOR_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_ADMINISTRATOR_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_ADMINISTRATOR_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_ADMINISTRATOR_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_ADMINISTRATOR_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_ADMINISTRATOR_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "TaskDashboardEntity",
		"ROLE_ADMINISTRATOR_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_ADMINISTRATOR_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsListTaskEntity",
		"ROLE_ADMINISTRATOR_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "AmendmentDetailEntity",
		"ROLE_ADMINISTRATOR_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_ADMINISTRATOR_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_ADMINISTRATOR_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_ADMINISTRATOR_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsProcedureEntity",
		"ROLE_ADMINISTRATOR_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_ADMINISTRATOR_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_ADMINISTRATOR_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_ADMINISTRATOR_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsSEPEntity",
		"ROLE_ADMINISTRATOR_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "RegistrationUserEntity",
		"ROLE_ADMINISTRATOR_REGISTRATION_USER_ENTITY_REGISTRATION_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_ADMINISTRATOR_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_ADMINISTRATOR_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicationHeaderEntity",
		"ROLE_ADMINISTRATOR_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicationItemEntity",
		"ROLE_ADMINISTRATOR_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicationCompoundEntity",
		"ROLE_ADMINISTRATOR_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_ADMINISTRATOR_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_ADMINISTRATOR_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_ADMINISTRATOR_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsFacilityListEntity",
		"ROLE_ADMINISTRATOR_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_ADMINISTRATOR_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_ADMINISTRATOR_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsClaimDataEntity",
		"ROLE_ADMINISTRATOR_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_ADMINISTRATOR_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_ADMINISTRATOR_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_ADMINISTRATOR_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_ADMINISTRATOR_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsControlPlanEntity",
		"ROLE_ADMINISTRATOR_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_ADMINISTRATOR_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_ADMINISTRATOR_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_ADMINISTRATOR_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_ADMINISTRATOR_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_ADMINISTRATOR_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BedReserveEntity",
		"ROLE_ADMINISTRATOR_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_ADMINISTRATOR_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_ADMINISTRATOR_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_ADMINISTRATOR_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsVisitDataEntity",
		"ROLE_ADMINISTRATOR_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_ADMINISTRATOR_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "WarehouseUserEntity",
		"ROLE_ADMINISTRATOR_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_ADMINISTRATOR_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "VaccinationOrderEntity",
		"ROLE_ADMINISTRATOR_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_ADMINISTRATOR_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "JournalEntity",
		"ROLE_ADMINISTRATOR_JOURNAL_ENTITY_JOURNAL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ChartOfAccountEntity",
		"ROLE_ADMINISTRATOR_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_ADMINISTRATOR_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPRBEntity",
		"ROLE_ADMINISTRATOR_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_ADMINISTRATOR_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_ADMINISTRATOR_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_ADMINISTRATOR_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareUmumEntity",
		"ROLE_ADMINISTRATOR_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareDiagnosaEntity",
		"ROLE_ADMINISTRATOR_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareDokterEntity",
		"ROLE_ADMINISTRATOR_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareStatusPulangEntity",
		"ROLE_ADMINISTRATOR_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_ADMINISTRATOR_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_ADMINISTRATOR_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareTindakanEntity",
		"ROLE_ADMINISTRATOR_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareClubProlanisEntity",
		"ROLE_ADMINISTRATOR_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_ADMINISTRATOR_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_ADMINISTRATOR_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_ADMINISTRATOR_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareMCUEntity",
		"ROLE_ADMINISTRATOR_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_ADMINISTRATOR_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_ADMINISTRATOR_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_ADMINISTRATOR_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_ADMINISTRATOR_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_ADMINISTRATOR_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_ADMINISTRATOR_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_ADMINISTRATOR_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "FacilityHistoryEntity",
		"ROLE_ADMINISTRATOR_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_ADMINISTRATOR_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "NewbornDetailEntity",
		"ROLE_ADMINISTRATOR_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "VitalSignsEntity",
		"ROLE_ADMINISTRATOR_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DailyCareCPPTEntity",
		"ROLE_ADMINISTRATOR_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_ADMINISTRATOR_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_ADMINISTRATOR_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_ADMINISTRATOR_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_ADMINISTRATOR_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "SystemAdminUserEntity",
		"ROLE_ADMINISTRATOR_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientVitalInformationEntity",
		"ROLE_ADMINISTRATOR_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_ADMINISTRATOR_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_ADMINISTRATOR_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "SupplierProductDetailEntity",
		"ROLE_ADMINISTRATOR_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "TransferOrderEntity",
		"ROLE_ADMINISTRATOR_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InternalOrderEntity",
		"ROLE_ADMINISTRATOR_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_ADMINISTRATOR_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_ADMINISTRATOR_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareExaminationEntity",
		"ROLE_ADMINISTRATOR_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareActionExaminationEntity",
		"ROLE_ADMINISTRATOR_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_ADMINISTRATOR_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_ADMINISTRATOR_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_ADMINISTRATOR_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_ADMINISTRATOR_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_ADMINISTRATOR_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PurchaseOrderEntity",
		"ROLE_ADMINISTRATOR_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_ADMINISTRATOR_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ReturnSupplierEntity",
		"ROLE_ADMINISTRATOR_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_ADMINISTRATOR_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_ADMINISTRATOR_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_ADMINISTRATOR_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_ADMINISTRATOR_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PurchasingUserEntity",
		"ROLE_ADMINISTRATOR_PURCHASING_USER_ENTITY_PURCHASING_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "RetailPharmacyEntity",
		"ROLE_ADMINISTRATOR_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_ADMINISTRATOR_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_ADMINISTRATOR_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_ADMINISTRATOR_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BodyChartExaminationEntity",
		"ROLE_ADMINISTRATOR_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "BirthHistoryEntity",
		"ROLE_ADMINISTRATOR_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "PatientConsentEntity",
		"ROLE_ADMINISTRATOR_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_ADMINISTRATOR_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "InformedConsentEntity",
		"ROLE_ADMINISTRATOR_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "DeliveryProgressEntity",
		"ROLE_ADMINISTRATOR_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ProcessWorkflowEntity",
		"ROLE_ADMINISTRATOR_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_ADMINISTRATOR_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_ADMINISTRATOR_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "EntExaminationEntity",
		"ROLE_ADMINISTRATOR_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_ADMINISTRATOR_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_ADMINISTRATOR_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_ADMINISTRATOR_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_ADMINISTRATOR_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "OdontogramExaminationEntity",
		"ROLE_ADMINISTRATOR_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_ADMINISTRATOR_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_ADMINISTRATOR_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_ADMINISTRATOR_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		createOrUpdatePrivilege(administratorRoleEntity, "RoleEntity",
		"ROLE_ADMINISTRATOR_USER_BEHAVIOUR_ROLE", false, true, false, false);
		createOrUpdatePrivilege(administratorRoleEntity, "PrivilegeEntity",
		"ROLE_ADMINISTRATOR_USER_BEHAVIOUR_PRIVILEGE", false, true, false, false);
		roleRepository.save(administratorRoleEntity);

		final String administrationUserRoleName = "ADMINISTRATION_USER";
		Optional<RoleEntity> administrationUserRoleOpt = roleRepository.findByName(administrationUserRoleName);
		var administrationUserRoleEntity = administrationUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(administrationUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(administrationUserRoleEntity, "ReferenceDataEntity",
		"ROLE_ADMINISTRATION_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_ADMINISTRATION_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "RegistrationEntity",
		"ROLE_ADMINISTRATION_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalFeeEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_ADMINISTRATION_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ServiceEntity",
		"ROLE_ADMINISTRATION_USER_SERVICE_ENTITY_SERVICE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_ADMINISTRATION_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_ADMINISTRATION_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "WarehouseEntity",
		"ROLE_ADMINISTRATION_USER_WAREHOUSE_ENTITY_WAREHOUSE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "LocationEntity",
		"ROLE_ADMINISTRATION_USER_LOCATION_ENTITY_LOCATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ServiceItemEntity",
		"ROLE_ADMINISTRATION_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "TariffSchemaEntity",
		"ROLE_ADMINISTRATION_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_ADMINISTRATION_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "StaffEntity",
		"ROLE_ADMINISTRATION_USER_STAFF_ENTITY_STAFF", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "AdministratorEntity",
		"ROLE_ADMINISTRATION_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientVisitEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientDetailEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_ADMINISTRATION_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_ADMINISTRATION_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "Icd10Entity",
		"ROLE_ADMINISTRATION_USER_ICD_10_ENTITY_ICD_10", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "Icd9CMEntity",
		"ROLE_ADMINISTRATION_USER_ICD_9_CM_ENTITY_ICD_9_CM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_ADMINISTRATION_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_ADMINISTRATION_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ExaminationItemEntity",
		"ROLE_ADMINISTRATION_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_ADMINISTRATION_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_ADMINISTRATION_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_ADMINISTRATION_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "StockCatalogueEntity",
		"ROLE_ADMINISTRATION_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "RoomFacilityEntity",
		"ROLE_ADMINISTRATION_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BedFacilityEntity",
		"ROLE_ADMINISTRATION_USER_BED_FACILITY_ENTITY_BED_FACILITY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_ADMINISTRATION_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "McuPackageEntity",
		"ROLE_ADMINISTRATION_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "McuPackageItemEntity",
		"ROLE_ADMINISTRATION_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "HealthFacilityEntity",
		"ROLE_ADMINISTRATION_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_ADMINISTRATION_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_ADMINISTRATION_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_ADMINISTRATION_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_ADMINISTRATION_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_ADMINISTRATION_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_ADMINISTRATION_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PriceComponentEntity",
		"ROLE_ADMINISTRATION_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_ADMINISTRATION_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "TariffFormulaEntity",
		"ROLE_ADMINISTRATION_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InvoiceEntity",
		"ROLE_ADMINISTRATION_USER_INVOICE_ENTITY_INVOICE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_ADMINISTRATION_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_ADMINISTRATION_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PharmacySetupEntity",
		"ROLE_ADMINISTRATION_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "NumberingSetupEntity",
		"ROLE_ADMINISTRATION_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "AdministrationUserEntity",
		"ROLE_ADMINISTRATION_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DoctorUserEntity",
		"ROLE_ADMINISTRATION_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "NurseUserEntity",
		"ROLE_ADMINISTRATION_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PharmacyUserEntity",
		"ROLE_ADMINISTRATION_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_ADMINISTRATION_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_ADMINISTRATION_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ManagementUserEntity",
		"ROLE_ADMINISTRATION_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "FacilityUserEntity",
		"ROLE_ADMINISTRATION_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ClaimUserEntity",
		"ROLE_ADMINISTRATION_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InvoiceItemEntity",
		"ROLE_ADMINISTRATION_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_ADMINISTRATION_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_ADMINISTRATION_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MerchantEntity",
		"ROLE_ADMINISTRATION_USER_MERCHANT_ENTITY_MERCHANT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_ADMINISTRATION_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "CashReceiptEntity",
		"ROLE_ADMINISTRATION_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "CashAllocationEntity",
		"ROLE_ADMINISTRATION_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "CashRefundEntity",
		"ROLE_ADMINISTRATION_USER_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "CashierUserEntity",
		"ROLE_ADMINISTRATION_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_ADMINISTRATION_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "SepEntity",
		"ROLE_ADMINISTRATION_USER_SEP_ENTITY_SEP", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "SupplierEntity",
		"ROLE_ADMINISTRATION_USER_SUPPLIER_ENTITY_SUPPLIER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_ADMINISTRATION_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_ADMINISTRATION_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_ADMINISTRATION_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "RoomTransferEntity",
		"ROLE_ADMINISTRATION_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(administrationUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_ADMINISTRATION_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_ADMINISTRATION_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_ADMINISTRATION_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_ADMINISTRATION_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_ADMINISTRATION_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_ADMINISTRATION_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_ADMINISTRATION_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_ADMINISTRATION_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_ADMINISTRATION_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_ADMINISTRATION_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "StockControlEntity",
		"ROLE_ADMINISTRATION_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_ADMINISTRATION_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_ADMINISTRATION_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_ADMINISTRATION_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_ADMINISTRATION_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_ADMINISTRATION_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_ADMINISTRATION_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_ADMINISTRATION_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_ADMINISTRATION_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_ADMINISTRATION_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "TaskDashboardEntity",
		"ROLE_ADMINISTRATION_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_ADMINISTRATION_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsSEPEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "RegistrationUserEntity",
		"ROLE_ADMINISTRATION_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_ADMINISTRATION_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicationItemEntity",
		"ROLE_ADMINISTRATION_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_ADMINISTRATION_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_ADMINISTRATION_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_ADMINISTRATION_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BedReserveEntity",
		"ROLE_ADMINISTRATION_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "WarehouseUserEntity",
		"ROLE_ADMINISTRATION_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_ADMINISTRATION_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_ADMINISTRATION_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_ADMINISTRATION_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "JournalEntity",
		"ROLE_ADMINISTRATION_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_ADMINISTRATION_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_ADMINISTRATION_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPRBEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareUmumEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareDokterEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareTindakanEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareMCUEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_ADMINISTRATION_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_ADMINISTRATION_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_ADMINISTRATION_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_ADMINISTRATION_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_ADMINISTRATION_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "NewbornDetailEntity",
		"ROLE_ADMINISTRATION_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "VitalSignsEntity",
		"ROLE_ADMINISTRATION_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_ADMINISTRATION_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_ADMINISTRATION_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_ADMINISTRATION_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_ADMINISTRATION_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_ADMINISTRATION_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_ADMINISTRATION_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_ADMINISTRATION_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_ADMINISTRATION_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "TransferOrderEntity",
		"ROLE_ADMINISTRATION_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InternalOrderEntity",
		"ROLE_ADMINISTRATION_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_ADMINISTRATION_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_ADMINISTRATION_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareExaminationEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_ADMINISTRATION_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_ADMINISTRATION_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_ADMINISTRATION_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_ADMINISTRATION_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_ADMINISTRATION_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_ADMINISTRATION_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_ADMINISTRATION_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_ADMINISTRATION_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_ADMINISTRATION_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PurchasingUserEntity",
		"ROLE_ADMINISTRATION_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_ADMINISTRATION_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(administrationUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_ADMINISTRATION_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_ADMINISTRATION_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_ADMINISTRATION_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_ADMINISTRATION_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "BirthHistoryEntity",
		"ROLE_ADMINISTRATION_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(administrationUserRoleEntity, "PatientConsentEntity",
		"ROLE_ADMINISTRATION_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_ADMINISTRATION_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(administrationUserRoleEntity, "InformedConsentEntity",
		"ROLE_ADMINISTRATION_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_ADMINISTRATION_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_ADMINISTRATION_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(administrationUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_ADMINISTRATION_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(administrationUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_ADMINISTRATION_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(administrationUserRoleEntity, "EntExaminationEntity",
		"ROLE_ADMINISTRATION_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_ADMINISTRATION_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_ADMINISTRATION_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_ADMINISTRATION_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_ADMINISTRATION_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_ADMINISTRATION_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_ADMINISTRATION_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, false);
		createOrUpdatePrivilege(administrationUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_ADMINISTRATION_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(administrationUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_ADMINISTRATION_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(administrationUserRoleEntity);

		final String doctorUserRoleName = "DOCTOR_USER";
		Optional<RoleEntity> doctorUserRoleOpt = roleRepository.findByName(doctorUserRoleName);
		var doctorUserRoleEntity = doctorUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(doctorUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(doctorUserRoleEntity, "ReferenceDataEntity",
		"ROLE_DOCTOR_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_DOCTOR_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_DOCTOR_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "RegistrationEntity",
		"ROLE_DOCTOR_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalFeeEntity",
		"ROLE_DOCTOR_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_DOCTOR_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_DOCTOR_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ServiceEntity",
		"ROLE_DOCTOR_USER_SERVICE_ENTITY_SERVICE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_DOCTOR_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_DOCTOR_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "WarehouseEntity",
		"ROLE_DOCTOR_USER_WAREHOUSE_ENTITY_WAREHOUSE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "LocationEntity",
		"ROLE_DOCTOR_USER_LOCATION_ENTITY_LOCATION", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ServiceItemEntity",
		"ROLE_DOCTOR_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "TariffSchemaEntity",
		"ROLE_DOCTOR_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_DOCTOR_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "StaffEntity",
		"ROLE_DOCTOR_USER_STAFF_ENTITY_STAFF", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "AdministratorEntity",
		"ROLE_DOCTOR_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientVisitEntity",
		"ROLE_DOCTOR_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientDetailEntity",
		"ROLE_DOCTOR_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_DOCTOR_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_DOCTOR_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_DOCTOR_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_DOCTOR_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_DOCTOR_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_DOCTOR_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_DOCTOR_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_DOCTOR_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_DOCTOR_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_DOCTOR_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_DOCTOR_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_DOCTOR_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "Icd10Entity",
		"ROLE_DOCTOR_USER_ICD_10_ENTITY_ICD_10", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "Icd9CMEntity",
		"ROLE_DOCTOR_USER_ICD_9_CM_ENTITY_ICD_9_CM", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_DOCTOR_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_DOCTOR_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_DOCTOR_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ExaminationItemEntity",
		"ROLE_DOCTOR_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_DOCTOR_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_DOCTOR_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_DOCTOR_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_DOCTOR_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_DOCTOR_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_DOCTOR_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "StockCatalogueEntity",
		"ROLE_DOCTOR_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "RoomFacilityEntity",
		"ROLE_DOCTOR_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BedFacilityEntity",
		"ROLE_DOCTOR_USER_BED_FACILITY_ENTITY_BED_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_DOCTOR_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "McuPackageEntity",
		"ROLE_DOCTOR_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "McuPackageItemEntity",
		"ROLE_DOCTOR_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "HealthFacilityEntity",
		"ROLE_DOCTOR_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_DOCTOR_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_DOCTOR_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_DOCTOR_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_DOCTOR_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_DOCTOR_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_DOCTOR_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_DOCTOR_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_DOCTOR_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_DOCTOR_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_DOCTOR_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_DOCTOR_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PriceComponentEntity",
		"ROLE_DOCTOR_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_DOCTOR_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "TariffFormulaEntity",
		"ROLE_DOCTOR_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InvoiceEntity",
		"ROLE_DOCTOR_USER_INVOICE_ENTITY_INVOICE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_DOCTOR_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_DOCTOR_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PharmacySetupEntity",
		"ROLE_DOCTOR_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "NumberingSetupEntity",
		"ROLE_DOCTOR_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", false, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "AdministrationUserEntity",
		"ROLE_DOCTOR_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DoctorUserEntity",
		"ROLE_DOCTOR_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "NurseUserEntity",
		"ROLE_DOCTOR_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PharmacyUserEntity",
		"ROLE_DOCTOR_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_DOCTOR_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_DOCTOR_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_DOCTOR_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ManagementUserEntity",
		"ROLE_DOCTOR_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "FacilityUserEntity",
		"ROLE_DOCTOR_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ClaimUserEntity",
		"ROLE_DOCTOR_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InvoiceItemEntity",
		"ROLE_DOCTOR_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_DOCTOR_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_DOCTOR_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MerchantEntity",
		"ROLE_DOCTOR_USER_MERCHANT_ENTITY_MERCHANT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_DOCTOR_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "CashReceiptEntity",
		"ROLE_DOCTOR_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_DOCTOR_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "CashAllocationEntity",
		"ROLE_DOCTOR_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "CashRefundEntity",
		"ROLE_DOCTOR_USER_CASH_REFUND_ENTITY_CASH_REFUND", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "CashierUserEntity",
		"ROLE_DOCTOR_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_DOCTOR_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_DOCTOR_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_DOCTOR_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_DOCTOR_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_DOCTOR_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_DOCTOR_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_DOCTOR_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_DOCTOR_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "SepEntity",
		"ROLE_DOCTOR_USER_SEP_ENTITY_SEP", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "SupplierEntity",
		"ROLE_DOCTOR_USER_SUPPLIER_ENTITY_SUPPLIER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_DOCTOR_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_DOCTOR_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_DOCTOR_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "RoomTransferEntity",
		"ROLE_DOCTOR_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_DOCTOR_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_DOCTOR_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_DOCTOR_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_DOCTOR_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_DOCTOR_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_DOCTOR_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_DOCTOR_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_DOCTOR_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_DOCTOR_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_DOCTOR_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "StockControlEntity",
		"ROLE_DOCTOR_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_DOCTOR_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_DOCTOR_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_DOCTOR_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_DOCTOR_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_DOCTOR_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_DOCTOR_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_DOCTOR_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_DOCTOR_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_DOCTOR_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_DOCTOR_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_DOCTOR_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_DOCTOR_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_DOCTOR_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "TaskDashboardEntity",
		"ROLE_DOCTOR_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_DOCTOR_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_DOCTOR_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_DOCTOR_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_DOCTOR_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_DOCTOR_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_DOCTOR_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_DOCTOR_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_DOCTOR_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_DOCTOR_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_DOCTOR_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsSEPEntity",
		"ROLE_DOCTOR_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "RegistrationUserEntity",
		"ROLE_DOCTOR_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_DOCTOR_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_DOCTOR_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_DOCTOR_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicationItemEntity",
		"ROLE_DOCTOR_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_DOCTOR_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_DOCTOR_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_DOCTOR_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_DOCTOR_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_DOCTOR_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_DOCTOR_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_DOCTOR_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_DOCTOR_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_DOCTOR_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_DOCTOR_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_DOCTOR_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_DOCTOR_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_DOCTOR_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_DOCTOR_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_DOCTOR_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_DOCTOR_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_DOCTOR_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_DOCTOR_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BedReserveEntity",
		"ROLE_DOCTOR_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_DOCTOR_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_DOCTOR_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_DOCTOR_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_DOCTOR_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_DOCTOR_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "WarehouseUserEntity",
		"ROLE_DOCTOR_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_DOCTOR_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_DOCTOR_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_DOCTOR_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "JournalEntity",
		"ROLE_DOCTOR_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_DOCTOR_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_DOCTOR_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPRBEntity",
		"ROLE_DOCTOR_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_DOCTOR_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_DOCTOR_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_DOCTOR_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareUmumEntity",
		"ROLE_DOCTOR_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_DOCTOR_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareDokterEntity",
		"ROLE_DOCTOR_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_DOCTOR_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_DOCTOR_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_DOCTOR_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareTindakanEntity",
		"ROLE_DOCTOR_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_DOCTOR_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_DOCTOR_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_DOCTOR_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_DOCTOR_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareMCUEntity",
		"ROLE_DOCTOR_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_DOCTOR_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_DOCTOR_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_DOCTOR_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_DOCTOR_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_DOCTOR_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_DOCTOR_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_DOCTOR_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_DOCTOR_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_DOCTOR_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "NewbornDetailEntity",
		"ROLE_DOCTOR_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "VitalSignsEntity",
		"ROLE_DOCTOR_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_DOCTOR_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_DOCTOR_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_DOCTOR_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_DOCTOR_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_DOCTOR_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_DOCTOR_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_DOCTOR_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_DOCTOR_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_DOCTOR_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_DOCTOR_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "TransferOrderEntity",
		"ROLE_DOCTOR_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InternalOrderEntity",
		"ROLE_DOCTOR_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_DOCTOR_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_DOCTOR_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareExaminationEntity",
		"ROLE_DOCTOR_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_DOCTOR_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_DOCTOR_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_DOCTOR_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_DOCTOR_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_DOCTOR_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_DOCTOR_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_DOCTOR_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_DOCTOR_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_DOCTOR_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_DOCTOR_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_DOCTOR_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_DOCTOR_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_DOCTOR_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PurchasingUserEntity",
		"ROLE_DOCTOR_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_DOCTOR_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_DOCTOR_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_DOCTOR_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_DOCTOR_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_DOCTOR_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "BirthHistoryEntity",
		"ROLE_DOCTOR_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "PatientConsentEntity",
		"ROLE_DOCTOR_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_DOCTOR_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "InformedConsentEntity",
		"ROLE_DOCTOR_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_DOCTOR_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_DOCTOR_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_DOCTOR_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_DOCTOR_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_DOCTOR_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_DOCTOR_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "EntExaminationEntity",
		"ROLE_DOCTOR_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_DOCTOR_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_DOCTOR_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_DOCTOR_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_DOCTOR_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_DOCTOR_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_DOCTOR_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_DOCTOR_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, false);
		createOrUpdatePrivilege(doctorUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_DOCTOR_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(doctorUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_DOCTOR_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(doctorUserRoleEntity);

		final String nurseUserRoleName = "NURSE_USER";
		Optional<RoleEntity> nurseUserRoleOpt = roleRepository.findByName(nurseUserRoleName);
		var nurseUserRoleEntity = nurseUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(nurseUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(nurseUserRoleEntity, "ReferenceDataEntity",
		"ROLE_NURSE_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_NURSE_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_NURSE_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "RegistrationEntity",
		"ROLE_NURSE_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalFeeEntity",
		"ROLE_NURSE_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_NURSE_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_NURSE_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ServiceEntity",
		"ROLE_NURSE_USER_SERVICE_ENTITY_SERVICE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_NURSE_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_NURSE_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "WarehouseEntity",
		"ROLE_NURSE_USER_WAREHOUSE_ENTITY_WAREHOUSE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "LocationEntity",
		"ROLE_NURSE_USER_LOCATION_ENTITY_LOCATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ServiceItemEntity",
		"ROLE_NURSE_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "TariffSchemaEntity",
		"ROLE_NURSE_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_NURSE_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "StaffEntity",
		"ROLE_NURSE_USER_STAFF_ENTITY_STAFF", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "AdministratorEntity",
		"ROLE_NURSE_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientVisitEntity",
		"ROLE_NURSE_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientDetailEntity",
		"ROLE_NURSE_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_NURSE_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_NURSE_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_NURSE_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_NURSE_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_NURSE_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_NURSE_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_NURSE_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_NURSE_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_NURSE_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_NURSE_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_NURSE_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_NURSE_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "Icd10Entity",
		"ROLE_NURSE_USER_ICD_10_ENTITY_ICD_10", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "Icd9CMEntity",
		"ROLE_NURSE_USER_ICD_9_CM_ENTITY_ICD_9_CM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_NURSE_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_NURSE_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_NURSE_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ExaminationItemEntity",
		"ROLE_NURSE_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_NURSE_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_NURSE_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_NURSE_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_NURSE_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_NURSE_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_NURSE_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "StockCatalogueEntity",
		"ROLE_NURSE_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "RoomFacilityEntity",
		"ROLE_NURSE_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BedFacilityEntity",
		"ROLE_NURSE_USER_BED_FACILITY_ENTITY_BED_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_NURSE_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "McuPackageEntity",
		"ROLE_NURSE_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "McuPackageItemEntity",
		"ROLE_NURSE_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "HealthFacilityEntity",
		"ROLE_NURSE_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_NURSE_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_NURSE_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_NURSE_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_NURSE_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_NURSE_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_NURSE_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_NURSE_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_NURSE_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_NURSE_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_NURSE_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_NURSE_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PriceComponentEntity",
		"ROLE_NURSE_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_NURSE_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "TariffFormulaEntity",
		"ROLE_NURSE_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InvoiceEntity",
		"ROLE_NURSE_USER_INVOICE_ENTITY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_NURSE_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_NURSE_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PharmacySetupEntity",
		"ROLE_NURSE_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "NumberingSetupEntity",
		"ROLE_NURSE_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", false, true, true, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "AdministrationUserEntity",
		"ROLE_NURSE_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DoctorUserEntity",
		"ROLE_NURSE_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "NurseUserEntity",
		"ROLE_NURSE_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PharmacyUserEntity",
		"ROLE_NURSE_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_NURSE_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_NURSE_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_NURSE_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ManagementUserEntity",
		"ROLE_NURSE_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "FacilityUserEntity",
		"ROLE_NURSE_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ClaimUserEntity",
		"ROLE_NURSE_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InvoiceItemEntity",
		"ROLE_NURSE_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_NURSE_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_NURSE_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MerchantEntity",
		"ROLE_NURSE_USER_MERCHANT_ENTITY_MERCHANT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_NURSE_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "CashReceiptEntity",
		"ROLE_NURSE_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_NURSE_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "CashAllocationEntity",
		"ROLE_NURSE_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "CashRefundEntity",
		"ROLE_NURSE_USER_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "CashierUserEntity",
		"ROLE_NURSE_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_NURSE_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_NURSE_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_NURSE_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_NURSE_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_NURSE_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_NURSE_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_NURSE_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_NURSE_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "SepEntity",
		"ROLE_NURSE_USER_SEP_ENTITY_SEP", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "SupplierEntity",
		"ROLE_NURSE_USER_SUPPLIER_ENTITY_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_NURSE_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_NURSE_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_NURSE_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "RoomTransferEntity",
		"ROLE_NURSE_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_NURSE_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_NURSE_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_NURSE_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_NURSE_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_NURSE_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_NURSE_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_NURSE_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_NURSE_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_NURSE_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_NURSE_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "StockControlEntity",
		"ROLE_NURSE_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_NURSE_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_NURSE_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_NURSE_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_NURSE_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_NURSE_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_NURSE_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_NURSE_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_NURSE_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_NURSE_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_NURSE_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_NURSE_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_NURSE_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_NURSE_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "TaskDashboardEntity",
		"ROLE_NURSE_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_NURSE_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_NURSE_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_NURSE_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_NURSE_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_NURSE_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_NURSE_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_NURSE_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_NURSE_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_NURSE_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_NURSE_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsSEPEntity",
		"ROLE_NURSE_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "RegistrationUserEntity",
		"ROLE_NURSE_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_NURSE_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_NURSE_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_NURSE_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicationItemEntity",
		"ROLE_NURSE_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_NURSE_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_NURSE_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_NURSE_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_NURSE_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_NURSE_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_NURSE_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_NURSE_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_NURSE_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_NURSE_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_NURSE_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_NURSE_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_NURSE_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_NURSE_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_NURSE_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_NURSE_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_NURSE_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_NURSE_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_NURSE_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BedReserveEntity",
		"ROLE_NURSE_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_NURSE_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_NURSE_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_NURSE_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_NURSE_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_NURSE_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "WarehouseUserEntity",
		"ROLE_NURSE_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_NURSE_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_NURSE_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_NURSE_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "JournalEntity",
		"ROLE_NURSE_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_NURSE_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_NURSE_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPRBEntity",
		"ROLE_NURSE_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_NURSE_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_NURSE_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_NURSE_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareUmumEntity",
		"ROLE_NURSE_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_NURSE_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareDokterEntity",
		"ROLE_NURSE_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_NURSE_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_NURSE_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_NURSE_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareTindakanEntity",
		"ROLE_NURSE_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_NURSE_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_NURSE_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_NURSE_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_NURSE_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareMCUEntity",
		"ROLE_NURSE_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_NURSE_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_NURSE_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_NURSE_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_NURSE_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_NURSE_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_NURSE_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_NURSE_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_NURSE_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_NURSE_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "NewbornDetailEntity",
		"ROLE_NURSE_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "VitalSignsEntity",
		"ROLE_NURSE_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_NURSE_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_NURSE_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_NURSE_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_NURSE_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_NURSE_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_NURSE_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_NURSE_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_NURSE_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_NURSE_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_NURSE_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "TransferOrderEntity",
		"ROLE_NURSE_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InternalOrderEntity",
		"ROLE_NURSE_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_NURSE_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_NURSE_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareExaminationEntity",
		"ROLE_NURSE_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_NURSE_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_NURSE_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_NURSE_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_NURSE_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_NURSE_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_NURSE_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_NURSE_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_NURSE_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_NURSE_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_NURSE_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_NURSE_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_NURSE_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_NURSE_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PurchasingUserEntity",
		"ROLE_NURSE_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_NURSE_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_NURSE_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_NURSE_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_NURSE_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_NURSE_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "BirthHistoryEntity",
		"ROLE_NURSE_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "PatientConsentEntity",
		"ROLE_NURSE_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_NURSE_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "InformedConsentEntity",
		"ROLE_NURSE_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_NURSE_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_NURSE_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_NURSE_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_NURSE_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_NURSE_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_NURSE_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "EntExaminationEntity",
		"ROLE_NURSE_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_NURSE_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(nurseUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_NURSE_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_NURSE_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_NURSE_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_NURSE_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_NURSE_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_NURSE_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_NURSE_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(nurseUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_NURSE_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(nurseUserRoleEntity);

		final String pharmacyUserRoleName = "PHARMACY_USER";
		Optional<RoleEntity> pharmacyUserRoleOpt = roleRepository.findByName(pharmacyUserRoleName);
		var pharmacyUserRoleEntity = pharmacyUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(pharmacyUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ReferenceDataEntity",
		"ROLE_PHARMACY_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_PHARMACY_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_PHARMACY_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "RegistrationEntity",
		"ROLE_PHARMACY_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalFeeEntity",
		"ROLE_PHARMACY_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_PHARMACY_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_PHARMACY_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ServiceEntity",
		"ROLE_PHARMACY_USER_SERVICE_ENTITY_SERVICE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_PHARMACY_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_PHARMACY_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "WarehouseEntity",
		"ROLE_PHARMACY_USER_WAREHOUSE_ENTITY_WAREHOUSE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "LocationEntity",
		"ROLE_PHARMACY_USER_LOCATION_ENTITY_LOCATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ServiceItemEntity",
		"ROLE_PHARMACY_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "TariffSchemaEntity",
		"ROLE_PHARMACY_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_PHARMACY_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "StaffEntity",
		"ROLE_PHARMACY_USER_STAFF_ENTITY_STAFF", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "AdministratorEntity",
		"ROLE_PHARMACY_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientVisitEntity",
		"ROLE_PHARMACY_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientDetailEntity",
		"ROLE_PHARMACY_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_PHARMACY_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_PHARMACY_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_PHARMACY_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_PHARMACY_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_PHARMACY_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_PHARMACY_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_PHARMACY_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_PHARMACY_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_PHARMACY_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_PHARMACY_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_PHARMACY_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_PHARMACY_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "Icd10Entity",
		"ROLE_PHARMACY_USER_ICD_10_ENTITY_ICD_10", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "Icd9CMEntity",
		"ROLE_PHARMACY_USER_ICD_9_CM_ENTITY_ICD_9_CM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_PHARMACY_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_PHARMACY_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_PHARMACY_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ExaminationItemEntity",
		"ROLE_PHARMACY_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_PHARMACY_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_PHARMACY_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_PHARMACY_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_PHARMACY_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_PHARMACY_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_PHARMACY_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "StockCatalogueEntity",
		"ROLE_PHARMACY_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "RoomFacilityEntity",
		"ROLE_PHARMACY_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BedFacilityEntity",
		"ROLE_PHARMACY_USER_BED_FACILITY_ENTITY_BED_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_PHARMACY_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "McuPackageEntity",
		"ROLE_PHARMACY_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "McuPackageItemEntity",
		"ROLE_PHARMACY_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "HealthFacilityEntity",
		"ROLE_PHARMACY_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_PHARMACY_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_PHARMACY_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_PHARMACY_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_PHARMACY_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_PHARMACY_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_PHARMACY_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_PHARMACY_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_PHARMACY_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_PHARMACY_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_PHARMACY_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_PHARMACY_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PriceComponentEntity",
		"ROLE_PHARMACY_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_PHARMACY_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "TariffFormulaEntity",
		"ROLE_PHARMACY_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InvoiceEntity",
		"ROLE_PHARMACY_USER_INVOICE_ENTITY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_PHARMACY_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_PHARMACY_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PharmacySetupEntity",
		"ROLE_PHARMACY_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "NumberingSetupEntity",
		"ROLE_PHARMACY_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "AdministrationUserEntity",
		"ROLE_PHARMACY_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DoctorUserEntity",
		"ROLE_PHARMACY_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "NurseUserEntity",
		"ROLE_PHARMACY_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PharmacyUserEntity",
		"ROLE_PHARMACY_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_PHARMACY_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_PHARMACY_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_PHARMACY_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ManagementUserEntity",
		"ROLE_PHARMACY_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "FacilityUserEntity",
		"ROLE_PHARMACY_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ClaimUserEntity",
		"ROLE_PHARMACY_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InvoiceItemEntity",
		"ROLE_PHARMACY_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_PHARMACY_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_PHARMACY_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MerchantEntity",
		"ROLE_PHARMACY_USER_MERCHANT_ENTITY_MERCHANT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_PHARMACY_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "CashReceiptEntity",
		"ROLE_PHARMACY_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_PHARMACY_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "CashAllocationEntity",
		"ROLE_PHARMACY_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "CashRefundEntity",
		"ROLE_PHARMACY_USER_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "CashierUserEntity",
		"ROLE_PHARMACY_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_PHARMACY_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_PHARMACY_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_PHARMACY_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_PHARMACY_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_PHARMACY_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_PHARMACY_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_PHARMACY_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_PHARMACY_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "SepEntity",
		"ROLE_PHARMACY_USER_SEP_ENTITY_SEP", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "SupplierEntity",
		"ROLE_PHARMACY_USER_SUPPLIER_ENTITY_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_PHARMACY_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_PHARMACY_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_PHARMACY_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "RoomTransferEntity",
		"ROLE_PHARMACY_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_PHARMACY_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_PHARMACY_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_PHARMACY_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_PHARMACY_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_PHARMACY_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_PHARMACY_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_PHARMACY_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_PHARMACY_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_PHARMACY_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_PHARMACY_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "StockControlEntity",
		"ROLE_PHARMACY_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_PHARMACY_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_PHARMACY_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_PHARMACY_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_PHARMACY_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_PHARMACY_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_PHARMACY_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_PHARMACY_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_PHARMACY_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_PHARMACY_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_PHARMACY_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_PHARMACY_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_PHARMACY_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_PHARMACY_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "TaskDashboardEntity",
		"ROLE_PHARMACY_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_PHARMACY_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_PHARMACY_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_PHARMACY_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_PHARMACY_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_PHARMACY_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_PHARMACY_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_PHARMACY_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_PHARMACY_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_PHARMACY_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_PHARMACY_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsSEPEntity",
		"ROLE_PHARMACY_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "RegistrationUserEntity",
		"ROLE_PHARMACY_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_PHARMACY_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_PHARMACY_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_PHARMACY_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicationItemEntity",
		"ROLE_PHARMACY_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_PHARMACY_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_PHARMACY_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_PHARMACY_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_PHARMACY_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_PHARMACY_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_PHARMACY_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_PHARMACY_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_PHARMACY_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_PHARMACY_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_PHARMACY_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_PHARMACY_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_PHARMACY_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_PHARMACY_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_PHARMACY_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_PHARMACY_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_PHARMACY_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_PHARMACY_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_PHARMACY_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BedReserveEntity",
		"ROLE_PHARMACY_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_PHARMACY_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_PHARMACY_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_PHARMACY_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_PHARMACY_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_PHARMACY_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "WarehouseUserEntity",
		"ROLE_PHARMACY_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_PHARMACY_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_PHARMACY_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_PHARMACY_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "JournalEntity",
		"ROLE_PHARMACY_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_PHARMACY_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_PHARMACY_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPRBEntity",
		"ROLE_PHARMACY_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_PHARMACY_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_PHARMACY_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_PHARMACY_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareUmumEntity",
		"ROLE_PHARMACY_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_PHARMACY_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareDokterEntity",
		"ROLE_PHARMACY_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_PHARMACY_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_PHARMACY_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_PHARMACY_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareTindakanEntity",
		"ROLE_PHARMACY_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_PHARMACY_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_PHARMACY_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_PHARMACY_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_PHARMACY_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareMCUEntity",
		"ROLE_PHARMACY_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_PHARMACY_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_PHARMACY_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_PHARMACY_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_PHARMACY_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_PHARMACY_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_PHARMACY_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_PHARMACY_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_PHARMACY_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_PHARMACY_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "NewbornDetailEntity",
		"ROLE_PHARMACY_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "VitalSignsEntity",
		"ROLE_PHARMACY_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_PHARMACY_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_PHARMACY_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_PHARMACY_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_PHARMACY_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_PHARMACY_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_PHARMACY_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_PHARMACY_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_PHARMACY_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_PHARMACY_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_PHARMACY_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "TransferOrderEntity",
		"ROLE_PHARMACY_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InternalOrderEntity",
		"ROLE_PHARMACY_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_PHARMACY_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_PHARMACY_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareExaminationEntity",
		"ROLE_PHARMACY_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_PHARMACY_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_PHARMACY_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_PHARMACY_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_PHARMACY_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_PHARMACY_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_PHARMACY_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_PHARMACY_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_PHARMACY_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_PHARMACY_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_PHARMACY_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_PHARMACY_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_PHARMACY_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_PHARMACY_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PurchasingUserEntity",
		"ROLE_PHARMACY_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_PHARMACY_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_PHARMACY_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_PHARMACY_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_PHARMACY_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_PHARMACY_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "BirthHistoryEntity",
		"ROLE_PHARMACY_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "PatientConsentEntity",
		"ROLE_PHARMACY_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_PHARMACY_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "InformedConsentEntity",
		"ROLE_PHARMACY_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_PHARMACY_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_PHARMACY_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_PHARMACY_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_PHARMACY_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_PHARMACY_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_PHARMACY_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "EntExaminationEntity",
		"ROLE_PHARMACY_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_PHARMACY_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_PHARMACY_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_PHARMACY_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_PHARMACY_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_PHARMACY_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_PHARMACY_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_PHARMACY_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_PHARMACY_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(pharmacyUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_PHARMACY_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(pharmacyUserRoleEntity);

		final String medicalRecordUserRoleName = "MEDICAL_RECORD_USER";
		Optional<RoleEntity> medicalRecordUserRoleOpt = roleRepository.findByName(medicalRecordUserRoleName);
		var medicalRecordUserRoleEntity = medicalRecordUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(medicalRecordUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ReferenceDataEntity",
		"ROLE_MEDICAL_RECORD_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_MEDICAL_RECORD_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "RegistrationEntity",
		"ROLE_MEDICAL_RECORD_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalFeeEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_MEDICAL_RECORD_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ServiceEntity",
		"ROLE_MEDICAL_RECORD_USER_SERVICE_ENTITY_SERVICE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_MEDICAL_RECORD_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_MEDICAL_RECORD_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "WarehouseEntity",
		"ROLE_MEDICAL_RECORD_USER_WAREHOUSE_ENTITY_WAREHOUSE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "LocationEntity",
		"ROLE_MEDICAL_RECORD_USER_LOCATION_ENTITY_LOCATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ServiceItemEntity",
		"ROLE_MEDICAL_RECORD_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "TariffSchemaEntity",
		"ROLE_MEDICAL_RECORD_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_MEDICAL_RECORD_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "StaffEntity",
		"ROLE_MEDICAL_RECORD_USER_STAFF_ENTITY_STAFF", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "AdministratorEntity",
		"ROLE_MEDICAL_RECORD_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientVisitEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_MEDICAL_RECORD_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_MEDICAL_RECORD_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "Icd10Entity",
		"ROLE_MEDICAL_RECORD_USER_ICD_10_ENTITY_ICD_10", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "Icd9CMEntity",
		"ROLE_MEDICAL_RECORD_USER_ICD_9_CM_ENTITY_ICD_9_CM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_MEDICAL_RECORD_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_MEDICAL_RECORD_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ExaminationItemEntity",
		"ROLE_MEDICAL_RECORD_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_MEDICAL_RECORD_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_MEDICAL_RECORD_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_MEDICAL_RECORD_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "StockCatalogueEntity",
		"ROLE_MEDICAL_RECORD_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "RoomFacilityEntity",
		"ROLE_MEDICAL_RECORD_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BedFacilityEntity",
		"ROLE_MEDICAL_RECORD_USER_BED_FACILITY_ENTITY_BED_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_MEDICAL_RECORD_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "McuPackageEntity",
		"ROLE_MEDICAL_RECORD_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "McuPackageItemEntity",
		"ROLE_MEDICAL_RECORD_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "HealthFacilityEntity",
		"ROLE_MEDICAL_RECORD_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_MEDICAL_RECORD_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_MEDICAL_RECORD_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_MEDICAL_RECORD_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_MEDICAL_RECORD_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_MEDICAL_RECORD_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_MEDICAL_RECORD_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PriceComponentEntity",
		"ROLE_MEDICAL_RECORD_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_MEDICAL_RECORD_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "TariffFormulaEntity",
		"ROLE_MEDICAL_RECORD_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InvoiceEntity",
		"ROLE_MEDICAL_RECORD_USER_INVOICE_ENTITY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_MEDICAL_RECORD_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_MEDICAL_RECORD_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PharmacySetupEntity",
		"ROLE_MEDICAL_RECORD_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "NumberingSetupEntity",
		"ROLE_MEDICAL_RECORD_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", false, true, true, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "AdministrationUserEntity",
		"ROLE_MEDICAL_RECORD_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DoctorUserEntity",
		"ROLE_MEDICAL_RECORD_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "NurseUserEntity",
		"ROLE_MEDICAL_RECORD_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PharmacyUserEntity",
		"ROLE_MEDICAL_RECORD_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_MEDICAL_RECORD_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ManagementUserEntity",
		"ROLE_MEDICAL_RECORD_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "FacilityUserEntity",
		"ROLE_MEDICAL_RECORD_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ClaimUserEntity",
		"ROLE_MEDICAL_RECORD_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InvoiceItemEntity",
		"ROLE_MEDICAL_RECORD_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_MEDICAL_RECORD_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_MEDICAL_RECORD_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MerchantEntity",
		"ROLE_MEDICAL_RECORD_USER_MERCHANT_ENTITY_MERCHANT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_MEDICAL_RECORD_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "CashReceiptEntity",
		"ROLE_MEDICAL_RECORD_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "CashAllocationEntity",
		"ROLE_MEDICAL_RECORD_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "CashRefundEntity",
		"ROLE_MEDICAL_RECORD_USER_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "CashierUserEntity",
		"ROLE_MEDICAL_RECORD_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_MEDICAL_RECORD_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "SepEntity",
		"ROLE_MEDICAL_RECORD_USER_SEP_ENTITY_SEP", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "SupplierEntity",
		"ROLE_MEDICAL_RECORD_USER_SUPPLIER_ENTITY_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_MEDICAL_RECORD_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_MEDICAL_RECORD_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "RoomTransferEntity",
		"ROLE_MEDICAL_RECORD_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_MEDICAL_RECORD_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_MEDICAL_RECORD_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_MEDICAL_RECORD_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_MEDICAL_RECORD_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_MEDICAL_RECORD_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_MEDICAL_RECORD_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_MEDICAL_RECORD_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_MEDICAL_RECORD_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_MEDICAL_RECORD_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "StockControlEntity",
		"ROLE_MEDICAL_RECORD_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_MEDICAL_RECORD_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_MEDICAL_RECORD_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_MEDICAL_RECORD_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_MEDICAL_RECORD_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_MEDICAL_RECORD_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_MEDICAL_RECORD_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_MEDICAL_RECORD_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_MEDICAL_RECORD_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "TaskDashboardEntity",
		"ROLE_MEDICAL_RECORD_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsSEPEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "RegistrationUserEntity",
		"ROLE_MEDICAL_RECORD_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicationItemEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_MEDICAL_RECORD_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_MEDICAL_RECORD_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BedReserveEntity",
		"ROLE_MEDICAL_RECORD_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "WarehouseUserEntity",
		"ROLE_MEDICAL_RECORD_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_MEDICAL_RECORD_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_MEDICAL_RECORD_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "JournalEntity",
		"ROLE_MEDICAL_RECORD_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_MEDICAL_RECORD_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPRBEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareUmumEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareDokterEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareTindakanEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareMCUEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_MEDICAL_RECORD_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_MEDICAL_RECORD_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_MEDICAL_RECORD_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_MEDICAL_RECORD_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "NewbornDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "VitalSignsEntity",
		"ROLE_MEDICAL_RECORD_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_MEDICAL_RECORD_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_MEDICAL_RECORD_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_MEDICAL_RECORD_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_MEDICAL_RECORD_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_MEDICAL_RECORD_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_MEDICAL_RECORD_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "TransferOrderEntity",
		"ROLE_MEDICAL_RECORD_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InternalOrderEntity",
		"ROLE_MEDICAL_RECORD_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareExaminationEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_MEDICAL_RECORD_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_MEDICAL_RECORD_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_MEDICAL_RECORD_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_MEDICAL_RECORD_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_MEDICAL_RECORD_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_MEDICAL_RECORD_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PurchasingUserEntity",
		"ROLE_MEDICAL_RECORD_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_MEDICAL_RECORD_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_MEDICAL_RECORD_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_MEDICAL_RECORD_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_MEDICAL_RECORD_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_MEDICAL_RECORD_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "BirthHistoryEntity",
		"ROLE_MEDICAL_RECORD_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "PatientConsentEntity",
		"ROLE_MEDICAL_RECORD_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_MEDICAL_RECORD_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "InformedConsentEntity",
		"ROLE_MEDICAL_RECORD_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_MEDICAL_RECORD_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_MEDICAL_RECORD_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_MEDICAL_RECORD_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_MEDICAL_RECORD_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "EntExaminationEntity",
		"ROLE_MEDICAL_RECORD_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_MEDICAL_RECORD_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_MEDICAL_RECORD_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_MEDICAL_RECORD_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_MEDICAL_RECORD_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_MEDICAL_RECORD_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_MEDICAL_RECORD_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_MEDICAL_RECORD_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(medicalRecordUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_MEDICAL_RECORD_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(medicalRecordUserRoleEntity);

		final String managementUserRoleName = "MANAGEMENT_USER";
		Optional<RoleEntity> managementUserRoleOpt = roleRepository.findByName(managementUserRoleName);
		var managementUserRoleEntity = managementUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(managementUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(managementUserRoleEntity, "ReferenceDataEntity",
		"ROLE_MANAGEMENT_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_MANAGEMENT_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "RegistrationEntity",
		"ROLE_MANAGEMENT_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalFeeEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_MANAGEMENT_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ServiceEntity",
		"ROLE_MANAGEMENT_USER_SERVICE_ENTITY_SERVICE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_MANAGEMENT_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_MANAGEMENT_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "WarehouseEntity",
		"ROLE_MANAGEMENT_USER_WAREHOUSE_ENTITY_WAREHOUSE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "LocationEntity",
		"ROLE_MANAGEMENT_USER_LOCATION_ENTITY_LOCATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ServiceItemEntity",
		"ROLE_MANAGEMENT_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "TariffSchemaEntity",
		"ROLE_MANAGEMENT_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_MANAGEMENT_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "StaffEntity",
		"ROLE_MANAGEMENT_USER_STAFF_ENTITY_STAFF", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "AdministratorEntity",
		"ROLE_MANAGEMENT_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientVisitEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientDetailEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_MANAGEMENT_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_MANAGEMENT_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "Icd10Entity",
		"ROLE_MANAGEMENT_USER_ICD_10_ENTITY_ICD_10", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "Icd9CMEntity",
		"ROLE_MANAGEMENT_USER_ICD_9_CM_ENTITY_ICD_9_CM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_MANAGEMENT_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_MANAGEMENT_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ExaminationItemEntity",
		"ROLE_MANAGEMENT_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_MANAGEMENT_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_MANAGEMENT_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_MANAGEMENT_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "StockCatalogueEntity",
		"ROLE_MANAGEMENT_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "RoomFacilityEntity",
		"ROLE_MANAGEMENT_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BedFacilityEntity",
		"ROLE_MANAGEMENT_USER_BED_FACILITY_ENTITY_BED_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_MANAGEMENT_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "McuPackageEntity",
		"ROLE_MANAGEMENT_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "McuPackageItemEntity",
		"ROLE_MANAGEMENT_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "HealthFacilityEntity",
		"ROLE_MANAGEMENT_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_MANAGEMENT_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_MANAGEMENT_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_MANAGEMENT_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_MANAGEMENT_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_MANAGEMENT_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_MANAGEMENT_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PriceComponentEntity",
		"ROLE_MANAGEMENT_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_MANAGEMENT_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "TariffFormulaEntity",
		"ROLE_MANAGEMENT_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InvoiceEntity",
		"ROLE_MANAGEMENT_USER_INVOICE_ENTITY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_MANAGEMENT_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_MANAGEMENT_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PharmacySetupEntity",
		"ROLE_MANAGEMENT_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "NumberingSetupEntity",
		"ROLE_MANAGEMENT_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "AdministrationUserEntity",
		"ROLE_MANAGEMENT_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "DoctorUserEntity",
		"ROLE_MANAGEMENT_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "NurseUserEntity",
		"ROLE_MANAGEMENT_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "PharmacyUserEntity",
		"ROLE_MANAGEMENT_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_MANAGEMENT_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_MANAGEMENT_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "ManagementUserEntity",
		"ROLE_MANAGEMENT_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "FacilityUserEntity",
		"ROLE_MANAGEMENT_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "ClaimUserEntity",
		"ROLE_MANAGEMENT_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "InvoiceItemEntity",
		"ROLE_MANAGEMENT_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_MANAGEMENT_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_MANAGEMENT_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MerchantEntity",
		"ROLE_MANAGEMENT_USER_MERCHANT_ENTITY_MERCHANT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_MANAGEMENT_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "CashReceiptEntity",
		"ROLE_MANAGEMENT_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "CashAllocationEntity",
		"ROLE_MANAGEMENT_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "CashRefundEntity",
		"ROLE_MANAGEMENT_USER_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "CashierUserEntity",
		"ROLE_MANAGEMENT_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_MANAGEMENT_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_MANAGEMENT_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_MANAGEMENT_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_MANAGEMENT_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_MANAGEMENT_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_MANAGEMENT_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_MANAGEMENT_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_MANAGEMENT_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "SepEntity",
		"ROLE_MANAGEMENT_USER_SEP_ENTITY_SEP", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "SupplierEntity",
		"ROLE_MANAGEMENT_USER_SUPPLIER_ENTITY_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_MANAGEMENT_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_MANAGEMENT_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_MANAGEMENT_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "RoomTransferEntity",
		"ROLE_MANAGEMENT_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_MANAGEMENT_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_MANAGEMENT_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_MANAGEMENT_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_MANAGEMENT_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_MANAGEMENT_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_MANAGEMENT_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_MANAGEMENT_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_MANAGEMENT_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_MANAGEMENT_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_MANAGEMENT_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "StockControlEntity",
		"ROLE_MANAGEMENT_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_MANAGEMENT_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_MANAGEMENT_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_MANAGEMENT_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_MANAGEMENT_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_MANAGEMENT_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_MANAGEMENT_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_MANAGEMENT_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_MANAGEMENT_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_MANAGEMENT_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_MANAGEMENT_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "TaskDashboardEntity",
		"ROLE_MANAGEMENT_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_MANAGEMENT_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_MANAGEMENT_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_MANAGEMENT_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_MANAGEMENT_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_MANAGEMENT_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_MANAGEMENT_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_MANAGEMENT_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_MANAGEMENT_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsSEPEntity",
		"ROLE_MANAGEMENT_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "RegistrationUserEntity",
		"ROLE_MANAGEMENT_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_MANAGEMENT_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_MANAGEMENT_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_MANAGEMENT_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicationItemEntity",
		"ROLE_MANAGEMENT_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_MANAGEMENT_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_MANAGEMENT_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_MANAGEMENT_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_MANAGEMENT_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_MANAGEMENT_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_MANAGEMENT_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_MANAGEMENT_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_MANAGEMENT_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_MANAGEMENT_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_MANAGEMENT_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_MANAGEMENT_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_MANAGEMENT_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_MANAGEMENT_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_MANAGEMENT_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_MANAGEMENT_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_MANAGEMENT_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_MANAGEMENT_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_MANAGEMENT_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BedReserveEntity",
		"ROLE_MANAGEMENT_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_MANAGEMENT_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_MANAGEMENT_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_MANAGEMENT_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_MANAGEMENT_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_MANAGEMENT_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "WarehouseUserEntity",
		"ROLE_MANAGEMENT_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_MANAGEMENT_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_MANAGEMENT_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_MANAGEMENT_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "JournalEntity",
		"ROLE_MANAGEMENT_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_MANAGEMENT_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_MANAGEMENT_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPRBEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_MANAGEMENT_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_MANAGEMENT_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareUmumEntity",
		"ROLE_MANAGEMENT_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_MANAGEMENT_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareDokterEntity",
		"ROLE_MANAGEMENT_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_MANAGEMENT_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareTindakanEntity",
		"ROLE_MANAGEMENT_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_MANAGEMENT_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareMCUEntity",
		"ROLE_MANAGEMENT_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_MANAGEMENT_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_MANAGEMENT_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_MANAGEMENT_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_MANAGEMENT_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_MANAGEMENT_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "NewbornDetailEntity",
		"ROLE_MANAGEMENT_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "VitalSignsEntity",
		"ROLE_MANAGEMENT_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_MANAGEMENT_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_MANAGEMENT_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_MANAGEMENT_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_MANAGEMENT_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_MANAGEMENT_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_MANAGEMENT_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_MANAGEMENT_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_MANAGEMENT_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_MANAGEMENT_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "TransferOrderEntity",
		"ROLE_MANAGEMENT_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InternalOrderEntity",
		"ROLE_MANAGEMENT_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_MANAGEMENT_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_MANAGEMENT_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareExaminationEntity",
		"ROLE_MANAGEMENT_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_MANAGEMENT_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_MANAGEMENT_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_MANAGEMENT_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_MANAGEMENT_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_MANAGEMENT_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_MANAGEMENT_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_MANAGEMENT_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_MANAGEMENT_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_MANAGEMENT_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_MANAGEMENT_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_MANAGEMENT_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_MANAGEMENT_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_MANAGEMENT_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PurchasingUserEntity",
		"ROLE_MANAGEMENT_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_MANAGEMENT_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_MANAGEMENT_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_MANAGEMENT_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_MANAGEMENT_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_MANAGEMENT_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "BirthHistoryEntity",
		"ROLE_MANAGEMENT_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "PatientConsentEntity",
		"ROLE_MANAGEMENT_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_MANAGEMENT_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "InformedConsentEntity",
		"ROLE_MANAGEMENT_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_MANAGEMENT_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_MANAGEMENT_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_MANAGEMENT_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_MANAGEMENT_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "EntExaminationEntity",
		"ROLE_MANAGEMENT_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(managementUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_MANAGEMENT_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_MANAGEMENT_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_MANAGEMENT_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_MANAGEMENT_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_MANAGEMENT_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_MANAGEMENT_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_MANAGEMENT_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(managementUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_MANAGEMENT_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(managementUserRoleEntity);

		final String facilityUserRoleName = "FACILITY_USER";
		Optional<RoleEntity> facilityUserRoleOpt = roleRepository.findByName(facilityUserRoleName);
		var facilityUserRoleEntity = facilityUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(facilityUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(facilityUserRoleEntity, "ReferenceDataEntity",
		"ROLE_FACILITY_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_FACILITY_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_FACILITY_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "RegistrationEntity",
		"ROLE_FACILITY_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalFeeEntity",
		"ROLE_FACILITY_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_FACILITY_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_FACILITY_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ServiceEntity",
		"ROLE_FACILITY_USER_SERVICE_ENTITY_SERVICE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_FACILITY_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_FACILITY_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "WarehouseEntity",
		"ROLE_FACILITY_USER_WAREHOUSE_ENTITY_WAREHOUSE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "LocationEntity",
		"ROLE_FACILITY_USER_LOCATION_ENTITY_LOCATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ServiceItemEntity",
		"ROLE_FACILITY_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "TariffSchemaEntity",
		"ROLE_FACILITY_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_FACILITY_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "StaffEntity",
		"ROLE_FACILITY_USER_STAFF_ENTITY_STAFF", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "AdministratorEntity",
		"ROLE_FACILITY_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientVisitEntity",
		"ROLE_FACILITY_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientDetailEntity",
		"ROLE_FACILITY_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_FACILITY_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_FACILITY_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_FACILITY_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_FACILITY_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_FACILITY_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_FACILITY_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_FACILITY_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_FACILITY_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_FACILITY_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_FACILITY_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_FACILITY_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_FACILITY_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "Icd10Entity",
		"ROLE_FACILITY_USER_ICD_10_ENTITY_ICD_10", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "Icd9CMEntity",
		"ROLE_FACILITY_USER_ICD_9_CM_ENTITY_ICD_9_CM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_FACILITY_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_FACILITY_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_FACILITY_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ExaminationItemEntity",
		"ROLE_FACILITY_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_FACILITY_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_FACILITY_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_FACILITY_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_FACILITY_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_FACILITY_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_FACILITY_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "StockCatalogueEntity",
		"ROLE_FACILITY_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "RoomFacilityEntity",
		"ROLE_FACILITY_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BedFacilityEntity",
		"ROLE_FACILITY_USER_BED_FACILITY_ENTITY_BED_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_FACILITY_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "McuPackageEntity",
		"ROLE_FACILITY_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "McuPackageItemEntity",
		"ROLE_FACILITY_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "HealthFacilityEntity",
		"ROLE_FACILITY_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_FACILITY_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_FACILITY_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_FACILITY_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_FACILITY_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_FACILITY_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_FACILITY_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_FACILITY_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_FACILITY_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_FACILITY_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_FACILITY_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_FACILITY_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PriceComponentEntity",
		"ROLE_FACILITY_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_FACILITY_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "TariffFormulaEntity",
		"ROLE_FACILITY_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InvoiceEntity",
		"ROLE_FACILITY_USER_INVOICE_ENTITY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_FACILITY_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_FACILITY_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PharmacySetupEntity",
		"ROLE_FACILITY_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "NumberingSetupEntity",
		"ROLE_FACILITY_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", false, true, true, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "AdministrationUserEntity",
		"ROLE_FACILITY_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DoctorUserEntity",
		"ROLE_FACILITY_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "NurseUserEntity",
		"ROLE_FACILITY_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PharmacyUserEntity",
		"ROLE_FACILITY_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_FACILITY_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_FACILITY_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_FACILITY_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ManagementUserEntity",
		"ROLE_FACILITY_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "FacilityUserEntity",
		"ROLE_FACILITY_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ClaimUserEntity",
		"ROLE_FACILITY_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InvoiceItemEntity",
		"ROLE_FACILITY_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_FACILITY_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_FACILITY_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MerchantEntity",
		"ROLE_FACILITY_USER_MERCHANT_ENTITY_MERCHANT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_FACILITY_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "CashReceiptEntity",
		"ROLE_FACILITY_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_FACILITY_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "CashAllocationEntity",
		"ROLE_FACILITY_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "CashRefundEntity",
		"ROLE_FACILITY_USER_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "CashierUserEntity",
		"ROLE_FACILITY_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_FACILITY_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_FACILITY_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_FACILITY_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_FACILITY_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_FACILITY_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_FACILITY_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_FACILITY_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_FACILITY_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "SepEntity",
		"ROLE_FACILITY_USER_SEP_ENTITY_SEP", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "SupplierEntity",
		"ROLE_FACILITY_USER_SUPPLIER_ENTITY_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_FACILITY_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_FACILITY_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_FACILITY_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "RoomTransferEntity",
		"ROLE_FACILITY_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_FACILITY_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_FACILITY_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_FACILITY_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_FACILITY_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_FACILITY_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_FACILITY_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_FACILITY_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_FACILITY_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_FACILITY_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_FACILITY_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "StockControlEntity",
		"ROLE_FACILITY_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_FACILITY_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_FACILITY_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_FACILITY_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_FACILITY_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_FACILITY_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_FACILITY_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_FACILITY_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_FACILITY_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_FACILITY_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_FACILITY_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_FACILITY_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_FACILITY_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_FACILITY_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "TaskDashboardEntity",
		"ROLE_FACILITY_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_FACILITY_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_FACILITY_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_FACILITY_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_FACILITY_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_FACILITY_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_FACILITY_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_FACILITY_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_FACILITY_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_FACILITY_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_FACILITY_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsSEPEntity",
		"ROLE_FACILITY_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "RegistrationUserEntity",
		"ROLE_FACILITY_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_FACILITY_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_FACILITY_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_FACILITY_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicationItemEntity",
		"ROLE_FACILITY_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_FACILITY_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_FACILITY_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_FACILITY_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_FACILITY_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_FACILITY_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_FACILITY_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_FACILITY_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_FACILITY_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_FACILITY_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_FACILITY_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_FACILITY_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_FACILITY_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_FACILITY_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_FACILITY_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_FACILITY_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_FACILITY_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_FACILITY_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_FACILITY_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BedReserveEntity",
		"ROLE_FACILITY_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_FACILITY_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_FACILITY_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_FACILITY_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_FACILITY_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_FACILITY_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "WarehouseUserEntity",
		"ROLE_FACILITY_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_FACILITY_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_FACILITY_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_FACILITY_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "JournalEntity",
		"ROLE_FACILITY_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_FACILITY_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_FACILITY_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPRBEntity",
		"ROLE_FACILITY_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_FACILITY_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_FACILITY_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_FACILITY_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareUmumEntity",
		"ROLE_FACILITY_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_FACILITY_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareDokterEntity",
		"ROLE_FACILITY_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_FACILITY_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_FACILITY_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_FACILITY_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareTindakanEntity",
		"ROLE_FACILITY_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_FACILITY_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_FACILITY_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_FACILITY_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_FACILITY_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareMCUEntity",
		"ROLE_FACILITY_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_FACILITY_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_FACILITY_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_FACILITY_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_FACILITY_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_FACILITY_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_FACILITY_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_FACILITY_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_FACILITY_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_FACILITY_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "NewbornDetailEntity",
		"ROLE_FACILITY_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "VitalSignsEntity",
		"ROLE_FACILITY_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_FACILITY_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_FACILITY_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_FACILITY_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_FACILITY_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_FACILITY_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_FACILITY_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_FACILITY_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_FACILITY_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_FACILITY_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_FACILITY_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "TransferOrderEntity",
		"ROLE_FACILITY_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InternalOrderEntity",
		"ROLE_FACILITY_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_FACILITY_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_FACILITY_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareExaminationEntity",
		"ROLE_FACILITY_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_FACILITY_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_FACILITY_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_FACILITY_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_FACILITY_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_FACILITY_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_FACILITY_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_FACILITY_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_FACILITY_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_FACILITY_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_FACILITY_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_FACILITY_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_FACILITY_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_FACILITY_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PurchasingUserEntity",
		"ROLE_FACILITY_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_FACILITY_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_FACILITY_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_FACILITY_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_FACILITY_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_FACILITY_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "BirthHistoryEntity",
		"ROLE_FACILITY_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "PatientConsentEntity",
		"ROLE_FACILITY_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_FACILITY_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "InformedConsentEntity",
		"ROLE_FACILITY_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_FACILITY_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_FACILITY_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_FACILITY_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_FACILITY_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_FACILITY_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_FACILITY_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "EntExaminationEntity",
		"ROLE_FACILITY_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_FACILITY_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(facilityUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_FACILITY_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_FACILITY_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_FACILITY_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_FACILITY_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_FACILITY_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_FACILITY_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_FACILITY_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(facilityUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_FACILITY_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(facilityUserRoleEntity);

		final String claimUserRoleName = "CLAIM_USER";
		Optional<RoleEntity> claimUserRoleOpt = roleRepository.findByName(claimUserRoleName);
		var claimUserRoleEntity = claimUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(claimUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(claimUserRoleEntity, "ReferenceDataEntity",
		"ROLE_CLAIM_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_CLAIM_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_CLAIM_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "RegistrationEntity",
		"ROLE_CLAIM_USER_REGISTRATION_ENTITY_REGISTRATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalFeeEntity",
		"ROLE_CLAIM_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_CLAIM_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_CLAIM_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ServiceEntity",
		"ROLE_CLAIM_USER_SERVICE_ENTITY_SERVICE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_CLAIM_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_CLAIM_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "WarehouseEntity",
		"ROLE_CLAIM_USER_WAREHOUSE_ENTITY_WAREHOUSE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "LocationEntity",
		"ROLE_CLAIM_USER_LOCATION_ENTITY_LOCATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ServiceItemEntity",
		"ROLE_CLAIM_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "TariffSchemaEntity",
		"ROLE_CLAIM_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_CLAIM_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "StaffEntity",
		"ROLE_CLAIM_USER_STAFF_ENTITY_STAFF", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "AdministratorEntity",
		"ROLE_CLAIM_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientVisitEntity",
		"ROLE_CLAIM_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientDetailEntity",
		"ROLE_CLAIM_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_CLAIM_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_CLAIM_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_CLAIM_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_CLAIM_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_CLAIM_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_CLAIM_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_CLAIM_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_CLAIM_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_CLAIM_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_CLAIM_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_CLAIM_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_CLAIM_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "Icd10Entity",
		"ROLE_CLAIM_USER_ICD_10_ENTITY_ICD_10", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "Icd9CMEntity",
		"ROLE_CLAIM_USER_ICD_9_CM_ENTITY_ICD_9_CM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_CLAIM_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_CLAIM_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_CLAIM_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ExaminationItemEntity",
		"ROLE_CLAIM_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_CLAIM_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_CLAIM_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_CLAIM_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_CLAIM_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_CLAIM_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_CLAIM_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "StockCatalogueEntity",
		"ROLE_CLAIM_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "RoomFacilityEntity",
		"ROLE_CLAIM_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BedFacilityEntity",
		"ROLE_CLAIM_USER_BED_FACILITY_ENTITY_BED_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_CLAIM_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "McuPackageEntity",
		"ROLE_CLAIM_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "McuPackageItemEntity",
		"ROLE_CLAIM_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "HealthFacilityEntity",
		"ROLE_CLAIM_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_CLAIM_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_CLAIM_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_CLAIM_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_CLAIM_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_CLAIM_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_CLAIM_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_CLAIM_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_CLAIM_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_CLAIM_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_CLAIM_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_CLAIM_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "PriceComponentEntity",
		"ROLE_CLAIM_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_CLAIM_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "TariffFormulaEntity",
		"ROLE_CLAIM_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InvoiceEntity",
		"ROLE_CLAIM_USER_INVOICE_ENTITY_INVOICE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_CLAIM_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_CLAIM_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PharmacySetupEntity",
		"ROLE_CLAIM_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "NumberingSetupEntity",
		"ROLE_CLAIM_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", false, true, true, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "AdministrationUserEntity",
		"ROLE_CLAIM_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "DoctorUserEntity",
		"ROLE_CLAIM_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "NurseUserEntity",
		"ROLE_CLAIM_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PharmacyUserEntity",
		"ROLE_CLAIM_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_CLAIM_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_CLAIM_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_CLAIM_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ManagementUserEntity",
		"ROLE_CLAIM_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "FacilityUserEntity",
		"ROLE_CLAIM_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ClaimUserEntity",
		"ROLE_CLAIM_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InvoiceItemEntity",
		"ROLE_CLAIM_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_CLAIM_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_CLAIM_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MerchantEntity",
		"ROLE_CLAIM_USER_MERCHANT_ENTITY_MERCHANT", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_CLAIM_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "CashReceiptEntity",
		"ROLE_CLAIM_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_CLAIM_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "CashAllocationEntity",
		"ROLE_CLAIM_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "CashRefundEntity",
		"ROLE_CLAIM_USER_CASH_REFUND_ENTITY_CASH_REFUND", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "CashierUserEntity",
		"ROLE_CLAIM_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_CLAIM_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_CLAIM_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_CLAIM_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_CLAIM_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_CLAIM_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_CLAIM_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_CLAIM_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_CLAIM_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "SepEntity",
		"ROLE_CLAIM_USER_SEP_ENTITY_SEP", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "SupplierEntity",
		"ROLE_CLAIM_USER_SUPPLIER_ENTITY_SUPPLIER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_CLAIM_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_CLAIM_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_CLAIM_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "RoomTransferEntity",
		"ROLE_CLAIM_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_CLAIM_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_CLAIM_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_CLAIM_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_CLAIM_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_CLAIM_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_CLAIM_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_CLAIM_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_CLAIM_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_CLAIM_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_CLAIM_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "StockControlEntity",
		"ROLE_CLAIM_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_CLAIM_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_CLAIM_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_CLAIM_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_CLAIM_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_CLAIM_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_CLAIM_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_CLAIM_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_CLAIM_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_CLAIM_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_CLAIM_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_CLAIM_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_CLAIM_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_CLAIM_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "TaskDashboardEntity",
		"ROLE_CLAIM_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_CLAIM_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_CLAIM_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_CLAIM_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_CLAIM_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_CLAIM_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_CLAIM_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_CLAIM_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_CLAIM_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_CLAIM_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_CLAIM_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsSEPEntity",
		"ROLE_CLAIM_USER_BPJS_SEP_ENTITY_BPJS_SEP", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "RegistrationUserEntity",
		"ROLE_CLAIM_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_CLAIM_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_CLAIM_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_CLAIM_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicationItemEntity",
		"ROLE_CLAIM_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_CLAIM_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_CLAIM_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_CLAIM_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_CLAIM_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_CLAIM_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_CLAIM_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_CLAIM_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_CLAIM_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_CLAIM_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_CLAIM_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_CLAIM_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_CLAIM_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_CLAIM_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_CLAIM_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_CLAIM_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_CLAIM_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_CLAIM_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_CLAIM_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BedReserveEntity",
		"ROLE_CLAIM_USER_BED_RESERVE_ENTITY_BED_RESERVE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_CLAIM_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_CLAIM_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_CLAIM_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_CLAIM_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_CLAIM_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "WarehouseUserEntity",
		"ROLE_CLAIM_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_CLAIM_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_CLAIM_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_CLAIM_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "JournalEntity",
		"ROLE_CLAIM_USER_JOURNAL_ENTITY_JOURNAL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_CLAIM_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_CLAIM_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPRBEntity",
		"ROLE_CLAIM_USER_BPJS_PRB_ENTITY_BPJS_PRB", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_CLAIM_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_CLAIM_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_CLAIM_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareUmumEntity",
		"ROLE_CLAIM_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_CLAIM_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareDokterEntity",
		"ROLE_CLAIM_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_CLAIM_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_CLAIM_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_CLAIM_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareTindakanEntity",
		"ROLE_CLAIM_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_CLAIM_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_CLAIM_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_CLAIM_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_CLAIM_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareMCUEntity",
		"ROLE_CLAIM_USER_PCARE_MCU_ENTITY_PCARE_MCU", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_CLAIM_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_CLAIM_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_CLAIM_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_CLAIM_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_CLAIM_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_CLAIM_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_CLAIM_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_CLAIM_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_CLAIM_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "NewbornDetailEntity",
		"ROLE_CLAIM_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "VitalSignsEntity",
		"ROLE_CLAIM_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_CLAIM_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_CLAIM_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_CLAIM_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_CLAIM_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_CLAIM_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_CLAIM_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_CLAIM_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_CLAIM_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_CLAIM_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_CLAIM_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "TransferOrderEntity",
		"ROLE_CLAIM_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "InternalOrderEntity",
		"ROLE_CLAIM_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_CLAIM_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_CLAIM_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareExaminationEntity",
		"ROLE_CLAIM_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_CLAIM_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_CLAIM_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_CLAIM_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_CLAIM_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_CLAIM_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_CLAIM_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_CLAIM_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_CLAIM_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_CLAIM_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_CLAIM_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_CLAIM_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_CLAIM_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_CLAIM_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "PurchasingUserEntity",
		"ROLE_CLAIM_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_CLAIM_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_CLAIM_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_CLAIM_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_CLAIM_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_CLAIM_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "BirthHistoryEntity",
		"ROLE_CLAIM_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "PatientConsentEntity",
		"ROLE_CLAIM_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_CLAIM_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "InformedConsentEntity",
		"ROLE_CLAIM_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_CLAIM_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_CLAIM_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_CLAIM_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_CLAIM_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_CLAIM_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_CLAIM_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "EntExaminationEntity",
		"ROLE_CLAIM_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_CLAIM_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_CLAIM_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_CLAIM_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_CLAIM_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_CLAIM_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_CLAIM_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_CLAIM_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", false, true, false, false);
		createOrUpdatePrivilege(claimUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_CLAIM_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(claimUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_CLAIM_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(claimUserRoleEntity);

		final String cashierUserRoleName = "CASHIER_USER";
		Optional<RoleEntity> cashierUserRoleOpt = roleRepository.findByName(cashierUserRoleName);
		var cashierUserRoleEntity = cashierUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(cashierUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(cashierUserRoleEntity, "ReferenceDataEntity",
		"ROLE_CASHIER_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_CASHIER_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_CASHIER_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "RegistrationEntity",
		"ROLE_CASHIER_USER_REGISTRATION_ENTITY_REGISTRATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalFeeEntity",
		"ROLE_CASHIER_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", false, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_CASHIER_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_CASHIER_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ServiceEntity",
		"ROLE_CASHIER_USER_SERVICE_ENTITY_SERVICE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_CASHIER_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_CASHIER_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "WarehouseEntity",
		"ROLE_CASHIER_USER_WAREHOUSE_ENTITY_WAREHOUSE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "LocationEntity",
		"ROLE_CASHIER_USER_LOCATION_ENTITY_LOCATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ServiceItemEntity",
		"ROLE_CASHIER_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "TariffSchemaEntity",
		"ROLE_CASHIER_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_CASHIER_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "StaffEntity",
		"ROLE_CASHIER_USER_STAFF_ENTITY_STAFF", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "AdministratorEntity",
		"ROLE_CASHIER_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientVisitEntity",
		"ROLE_CASHIER_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientDetailEntity",
		"ROLE_CASHIER_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_CASHIER_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_CASHIER_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_CASHIER_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_CASHIER_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_CASHIER_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_CASHIER_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_CASHIER_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_CASHIER_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_CASHIER_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_CASHIER_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_CASHIER_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_CASHIER_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "Icd10Entity",
		"ROLE_CASHIER_USER_ICD_10_ENTITY_ICD_10", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "Icd9CMEntity",
		"ROLE_CASHIER_USER_ICD_9_CM_ENTITY_ICD_9_CM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_CASHIER_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_CASHIER_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_CASHIER_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ExaminationItemEntity",
		"ROLE_CASHIER_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_CASHIER_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_CASHIER_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_CASHIER_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_CASHIER_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_CASHIER_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_CASHIER_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "StockCatalogueEntity",
		"ROLE_CASHIER_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "RoomFacilityEntity",
		"ROLE_CASHIER_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BedFacilityEntity",
		"ROLE_CASHIER_USER_BED_FACILITY_ENTITY_BED_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_CASHIER_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "McuPackageEntity",
		"ROLE_CASHIER_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "McuPackageItemEntity",
		"ROLE_CASHIER_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "HealthFacilityEntity",
		"ROLE_CASHIER_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_CASHIER_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_CASHIER_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_CASHIER_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_CASHIER_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_CASHIER_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_CASHIER_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_CASHIER_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_CASHIER_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_CASHIER_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_CASHIER_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_CASHIER_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PriceComponentEntity",
		"ROLE_CASHIER_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_CASHIER_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "TariffFormulaEntity",
		"ROLE_CASHIER_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InvoiceEntity",
		"ROLE_CASHIER_USER_INVOICE_ENTITY_INVOICE", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_CASHIER_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_CASHIER_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PharmacySetupEntity",
		"ROLE_CASHIER_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "NumberingSetupEntity",
		"ROLE_CASHIER_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", false, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "AdministrationUserEntity",
		"ROLE_CASHIER_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DoctorUserEntity",
		"ROLE_CASHIER_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "NurseUserEntity",
		"ROLE_CASHIER_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PharmacyUserEntity",
		"ROLE_CASHIER_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_CASHIER_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_CASHIER_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_CASHIER_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ManagementUserEntity",
		"ROLE_CASHIER_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "FacilityUserEntity",
		"ROLE_CASHIER_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ClaimUserEntity",
		"ROLE_CASHIER_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InvoiceItemEntity",
		"ROLE_CASHIER_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_CASHIER_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_CASHIER_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MerchantEntity",
		"ROLE_CASHIER_USER_MERCHANT_ENTITY_MERCHANT", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_CASHIER_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "CashReceiptEntity",
		"ROLE_CASHIER_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_CASHIER_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", false, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "CashAllocationEntity",
		"ROLE_CASHIER_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "CashRefundEntity",
		"ROLE_CASHIER_USER_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "CashierUserEntity",
		"ROLE_CASHIER_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_CASHIER_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_CASHIER_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_CASHIER_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_CASHIER_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_CASHIER_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_CASHIER_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_CASHIER_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_CASHIER_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "SepEntity",
		"ROLE_CASHIER_USER_SEP_ENTITY_SEP", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "SupplierEntity",
		"ROLE_CASHIER_USER_SUPPLIER_ENTITY_SUPPLIER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_CASHIER_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_CASHIER_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_CASHIER_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "RoomTransferEntity",
		"ROLE_CASHIER_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_CASHIER_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_CASHIER_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_CASHIER_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_CASHIER_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_CASHIER_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_CASHIER_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_CASHIER_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_CASHIER_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_CASHIER_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_CASHIER_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "StockControlEntity",
		"ROLE_CASHIER_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_CASHIER_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_CASHIER_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_CASHIER_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_CASHIER_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_CASHIER_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_CASHIER_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_CASHIER_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_CASHIER_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_CASHIER_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_CASHIER_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_CASHIER_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_CASHIER_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_CASHIER_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "TaskDashboardEntity",
		"ROLE_CASHIER_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_CASHIER_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_CASHIER_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_CASHIER_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_CASHIER_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_CASHIER_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_CASHIER_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_CASHIER_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_CASHIER_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_CASHIER_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_CASHIER_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsSEPEntity",
		"ROLE_CASHIER_USER_BPJS_SEP_ENTITY_BPJS_SEP", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "RegistrationUserEntity",
		"ROLE_CASHIER_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_CASHIER_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_CASHIER_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_CASHIER_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicationItemEntity",
		"ROLE_CASHIER_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_CASHIER_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_CASHIER_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_CASHIER_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_CASHIER_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_CASHIER_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_CASHIER_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_CASHIER_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_CASHIER_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_CASHIER_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_CASHIER_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_CASHIER_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_CASHIER_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_CASHIER_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_CASHIER_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_CASHIER_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_CASHIER_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_CASHIER_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_CASHIER_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BedReserveEntity",
		"ROLE_CASHIER_USER_BED_RESERVE_ENTITY_BED_RESERVE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_CASHIER_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_CASHIER_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_CASHIER_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_CASHIER_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_CASHIER_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "WarehouseUserEntity",
		"ROLE_CASHIER_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_CASHIER_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_CASHIER_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_CASHIER_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "JournalEntity",
		"ROLE_CASHIER_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_CASHIER_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_CASHIER_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPRBEntity",
		"ROLE_CASHIER_USER_BPJS_PRB_ENTITY_BPJS_PRB", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_CASHIER_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_CASHIER_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_CASHIER_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareUmumEntity",
		"ROLE_CASHIER_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_CASHIER_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareDokterEntity",
		"ROLE_CASHIER_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_CASHIER_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_CASHIER_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_CASHIER_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareTindakanEntity",
		"ROLE_CASHIER_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_CASHIER_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_CASHIER_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_CASHIER_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_CASHIER_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareMCUEntity",
		"ROLE_CASHIER_USER_PCARE_MCU_ENTITY_PCARE_MCU", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_CASHIER_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_CASHIER_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_CASHIER_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_CASHIER_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_CASHIER_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_CASHIER_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_CASHIER_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_CASHIER_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_CASHIER_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "NewbornDetailEntity",
		"ROLE_CASHIER_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "VitalSignsEntity",
		"ROLE_CASHIER_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_CASHIER_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_CASHIER_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_CASHIER_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_CASHIER_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_CASHIER_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_CASHIER_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_CASHIER_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_CASHIER_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_CASHIER_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_CASHIER_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "TransferOrderEntity",
		"ROLE_CASHIER_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InternalOrderEntity",
		"ROLE_CASHIER_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_CASHIER_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_CASHIER_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareExaminationEntity",
		"ROLE_CASHIER_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_CASHIER_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_CASHIER_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_CASHIER_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_CASHIER_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_CASHIER_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_CASHIER_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_CASHIER_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_CASHIER_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_CASHIER_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_CASHIER_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_CASHIER_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_CASHIER_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_CASHIER_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PurchasingUserEntity",
		"ROLE_CASHIER_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_CASHIER_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_CASHIER_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_CASHIER_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_CASHIER_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_CASHIER_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "BirthHistoryEntity",
		"ROLE_CASHIER_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "PatientConsentEntity",
		"ROLE_CASHIER_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_CASHIER_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "InformedConsentEntity",
		"ROLE_CASHIER_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_CASHIER_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_CASHIER_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_CASHIER_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_CASHIER_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_CASHIER_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_CASHIER_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "EntExaminationEntity",
		"ROLE_CASHIER_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_CASHIER_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_CASHIER_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_CASHIER_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_CASHIER_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_CASHIER_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_CASHIER_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_CASHIER_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", false, true, false, false);
		createOrUpdatePrivilege(cashierUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_CASHIER_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(cashierUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_CASHIER_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(cashierUserRoleEntity);

		final String registrationUserRoleName = "REGISTRATION_USER";
		Optional<RoleEntity> registrationUserRoleOpt = roleRepository.findByName(registrationUserRoleName);
		var registrationUserRoleEntity = registrationUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(registrationUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(registrationUserRoleEntity, "ReferenceDataEntity",
		"ROLE_REGISTRATION_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_REGISTRATION_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_REGISTRATION_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "RegistrationEntity",
		"ROLE_REGISTRATION_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalFeeEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_REGISTRATION_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ServiceEntity",
		"ROLE_REGISTRATION_USER_SERVICE_ENTITY_SERVICE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_REGISTRATION_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_REGISTRATION_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "WarehouseEntity",
		"ROLE_REGISTRATION_USER_WAREHOUSE_ENTITY_WAREHOUSE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "LocationEntity",
		"ROLE_REGISTRATION_USER_LOCATION_ENTITY_LOCATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ServiceItemEntity",
		"ROLE_REGISTRATION_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "TariffSchemaEntity",
		"ROLE_REGISTRATION_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_REGISTRATION_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "StaffEntity",
		"ROLE_REGISTRATION_USER_STAFF_ENTITY_STAFF", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "AdministratorEntity",
		"ROLE_REGISTRATION_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientVisitEntity",
		"ROLE_REGISTRATION_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientDetailEntity",
		"ROLE_REGISTRATION_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_REGISTRATION_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_REGISTRATION_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_REGISTRATION_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_REGISTRATION_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_REGISTRATION_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_REGISTRATION_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_REGISTRATION_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_REGISTRATION_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_REGISTRATION_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_REGISTRATION_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_REGISTRATION_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_REGISTRATION_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "Icd10Entity",
		"ROLE_REGISTRATION_USER_ICD_10_ENTITY_ICD_10", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "Icd9CMEntity",
		"ROLE_REGISTRATION_USER_ICD_9_CM_ENTITY_ICD_9_CM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_REGISTRATION_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_REGISTRATION_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_REGISTRATION_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ExaminationItemEntity",
		"ROLE_REGISTRATION_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_REGISTRATION_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_REGISTRATION_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_REGISTRATION_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_REGISTRATION_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_REGISTRATION_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_REGISTRATION_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "StockCatalogueEntity",
		"ROLE_REGISTRATION_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "RoomFacilityEntity",
		"ROLE_REGISTRATION_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BedFacilityEntity",
		"ROLE_REGISTRATION_USER_BED_FACILITY_ENTITY_BED_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_REGISTRATION_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "McuPackageEntity",
		"ROLE_REGISTRATION_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "McuPackageItemEntity",
		"ROLE_REGISTRATION_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "HealthFacilityEntity",
		"ROLE_REGISTRATION_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_REGISTRATION_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_REGISTRATION_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_REGISTRATION_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_REGISTRATION_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_REGISTRATION_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_REGISTRATION_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PriceComponentEntity",
		"ROLE_REGISTRATION_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_REGISTRATION_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "TariffFormulaEntity",
		"ROLE_REGISTRATION_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InvoiceEntity",
		"ROLE_REGISTRATION_USER_INVOICE_ENTITY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_REGISTRATION_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_REGISTRATION_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PharmacySetupEntity",
		"ROLE_REGISTRATION_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "NumberingSetupEntity",
		"ROLE_REGISTRATION_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", false, true, true, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "AdministrationUserEntity",
		"ROLE_REGISTRATION_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DoctorUserEntity",
		"ROLE_REGISTRATION_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "NurseUserEntity",
		"ROLE_REGISTRATION_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PharmacyUserEntity",
		"ROLE_REGISTRATION_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_REGISTRATION_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_REGISTRATION_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ManagementUserEntity",
		"ROLE_REGISTRATION_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "FacilityUserEntity",
		"ROLE_REGISTRATION_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ClaimUserEntity",
		"ROLE_REGISTRATION_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InvoiceItemEntity",
		"ROLE_REGISTRATION_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_REGISTRATION_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_REGISTRATION_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MerchantEntity",
		"ROLE_REGISTRATION_USER_MERCHANT_ENTITY_MERCHANT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_REGISTRATION_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "CashReceiptEntity",
		"ROLE_REGISTRATION_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "CashAllocationEntity",
		"ROLE_REGISTRATION_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "CashRefundEntity",
		"ROLE_REGISTRATION_USER_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "CashierUserEntity",
		"ROLE_REGISTRATION_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_REGISTRATION_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_REGISTRATION_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_REGISTRATION_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_REGISTRATION_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_REGISTRATION_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_REGISTRATION_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_REGISTRATION_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_REGISTRATION_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "SepEntity",
		"ROLE_REGISTRATION_USER_SEP_ENTITY_SEP", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "SupplierEntity",
		"ROLE_REGISTRATION_USER_SUPPLIER_ENTITY_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_REGISTRATION_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_REGISTRATION_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_REGISTRATION_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "RoomTransferEntity",
		"ROLE_REGISTRATION_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_REGISTRATION_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_REGISTRATION_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_REGISTRATION_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_REGISTRATION_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_REGISTRATION_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_REGISTRATION_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_REGISTRATION_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_REGISTRATION_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_REGISTRATION_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_REGISTRATION_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "StockControlEntity",
		"ROLE_REGISTRATION_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_REGISTRATION_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_REGISTRATION_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_REGISTRATION_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_REGISTRATION_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_REGISTRATION_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_REGISTRATION_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_REGISTRATION_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_REGISTRATION_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_REGISTRATION_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_REGISTRATION_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "TaskDashboardEntity",
		"ROLE_REGISTRATION_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_REGISTRATION_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_REGISTRATION_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_REGISTRATION_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_REGISTRATION_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_REGISTRATION_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_REGISTRATION_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_REGISTRATION_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_REGISTRATION_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_REGISTRATION_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_REGISTRATION_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsSEPEntity",
		"ROLE_REGISTRATION_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "RegistrationUserEntity",
		"ROLE_REGISTRATION_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_REGISTRATION_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_REGISTRATION_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_REGISTRATION_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicationItemEntity",
		"ROLE_REGISTRATION_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_REGISTRATION_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_REGISTRATION_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_REGISTRATION_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_REGISTRATION_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_REGISTRATION_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_REGISTRATION_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_REGISTRATION_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_REGISTRATION_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_REGISTRATION_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_REGISTRATION_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_REGISTRATION_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_REGISTRATION_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_REGISTRATION_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_REGISTRATION_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_REGISTRATION_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_REGISTRATION_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_REGISTRATION_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_REGISTRATION_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BedReserveEntity",
		"ROLE_REGISTRATION_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_REGISTRATION_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_REGISTRATION_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_REGISTRATION_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_REGISTRATION_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_REGISTRATION_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "WarehouseUserEntity",
		"ROLE_REGISTRATION_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_REGISTRATION_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_REGISTRATION_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_REGISTRATION_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "JournalEntity",
		"ROLE_REGISTRATION_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_REGISTRATION_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_REGISTRATION_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPRBEntity",
		"ROLE_REGISTRATION_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_REGISTRATION_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_REGISTRATION_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_REGISTRATION_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareUmumEntity",
		"ROLE_REGISTRATION_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_REGISTRATION_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareDokterEntity",
		"ROLE_REGISTRATION_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_REGISTRATION_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_REGISTRATION_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_REGISTRATION_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareTindakanEntity",
		"ROLE_REGISTRATION_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_REGISTRATION_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_REGISTRATION_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_REGISTRATION_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_REGISTRATION_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareMCUEntity",
		"ROLE_REGISTRATION_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_REGISTRATION_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_REGISTRATION_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_REGISTRATION_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_REGISTRATION_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_REGISTRATION_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_REGISTRATION_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_REGISTRATION_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_REGISTRATION_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_REGISTRATION_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "NewbornDetailEntity",
		"ROLE_REGISTRATION_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "VitalSignsEntity",
		"ROLE_REGISTRATION_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_REGISTRATION_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_REGISTRATION_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_REGISTRATION_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_REGISTRATION_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_REGISTRATION_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_REGISTRATION_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_REGISTRATION_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_REGISTRATION_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_REGISTRATION_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_REGISTRATION_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "TransferOrderEntity",
		"ROLE_REGISTRATION_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InternalOrderEntity",
		"ROLE_REGISTRATION_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_REGISTRATION_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_REGISTRATION_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareExaminationEntity",
		"ROLE_REGISTRATION_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_REGISTRATION_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_REGISTRATION_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_REGISTRATION_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_REGISTRATION_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_REGISTRATION_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_REGISTRATION_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_REGISTRATION_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_REGISTRATION_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_REGISTRATION_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_REGISTRATION_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_REGISTRATION_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_REGISTRATION_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_REGISTRATION_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PurchasingUserEntity",
		"ROLE_REGISTRATION_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_REGISTRATION_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_REGISTRATION_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_REGISTRATION_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_REGISTRATION_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_REGISTRATION_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "BirthHistoryEntity",
		"ROLE_REGISTRATION_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "PatientConsentEntity",
		"ROLE_REGISTRATION_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_REGISTRATION_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "InformedConsentEntity",
		"ROLE_REGISTRATION_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_REGISTRATION_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_REGISTRATION_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_REGISTRATION_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_REGISTRATION_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "EntExaminationEntity",
		"ROLE_REGISTRATION_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(registrationUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_REGISTRATION_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_REGISTRATION_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_REGISTRATION_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_REGISTRATION_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_REGISTRATION_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_REGISTRATION_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_REGISTRATION_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(registrationUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_REGISTRATION_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(registrationUserRoleEntity);

		final String warehouseUserRoleName = "WAREHOUSE_USER";
		Optional<RoleEntity> warehouseUserRoleOpt = roleRepository.findByName(warehouseUserRoleName);
		var warehouseUserRoleEntity = warehouseUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(warehouseUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(warehouseUserRoleEntity, "ReferenceDataEntity",
		"ROLE_WAREHOUSE_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_WAREHOUSE_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "RegistrationEntity",
		"ROLE_WAREHOUSE_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalFeeEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_WAREHOUSE_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ServiceEntity",
		"ROLE_WAREHOUSE_USER_SERVICE_ENTITY_SERVICE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_WAREHOUSE_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_WAREHOUSE_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "WarehouseEntity",
		"ROLE_WAREHOUSE_USER_WAREHOUSE_ENTITY_WAREHOUSE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "LocationEntity",
		"ROLE_WAREHOUSE_USER_LOCATION_ENTITY_LOCATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ServiceItemEntity",
		"ROLE_WAREHOUSE_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "TariffSchemaEntity",
		"ROLE_WAREHOUSE_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_WAREHOUSE_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "StaffEntity",
		"ROLE_WAREHOUSE_USER_STAFF_ENTITY_STAFF", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "AdministratorEntity",
		"ROLE_WAREHOUSE_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientVisitEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientDetailEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_WAREHOUSE_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_WAREHOUSE_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "Icd10Entity",
		"ROLE_WAREHOUSE_USER_ICD_10_ENTITY_ICD_10", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "Icd9CMEntity",
		"ROLE_WAREHOUSE_USER_ICD_9_CM_ENTITY_ICD_9_CM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_WAREHOUSE_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_WAREHOUSE_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ExaminationItemEntity",
		"ROLE_WAREHOUSE_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_WAREHOUSE_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_WAREHOUSE_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_WAREHOUSE_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "StockCatalogueEntity",
		"ROLE_WAREHOUSE_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "RoomFacilityEntity",
		"ROLE_WAREHOUSE_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BedFacilityEntity",
		"ROLE_WAREHOUSE_USER_BED_FACILITY_ENTITY_BED_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_WAREHOUSE_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "McuPackageEntity",
		"ROLE_WAREHOUSE_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "McuPackageItemEntity",
		"ROLE_WAREHOUSE_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "HealthFacilityEntity",
		"ROLE_WAREHOUSE_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_WAREHOUSE_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_WAREHOUSE_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_WAREHOUSE_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_WAREHOUSE_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_WAREHOUSE_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_WAREHOUSE_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PriceComponentEntity",
		"ROLE_WAREHOUSE_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_WAREHOUSE_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "TariffFormulaEntity",
		"ROLE_WAREHOUSE_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InvoiceEntity",
		"ROLE_WAREHOUSE_USER_INVOICE_ENTITY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_WAREHOUSE_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_WAREHOUSE_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PharmacySetupEntity",
		"ROLE_WAREHOUSE_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "NumberingSetupEntity",
		"ROLE_WAREHOUSE_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", false, true, true, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "AdministrationUserEntity",
		"ROLE_WAREHOUSE_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DoctorUserEntity",
		"ROLE_WAREHOUSE_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "NurseUserEntity",
		"ROLE_WAREHOUSE_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PharmacyUserEntity",
		"ROLE_WAREHOUSE_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_WAREHOUSE_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_WAREHOUSE_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ManagementUserEntity",
		"ROLE_WAREHOUSE_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "FacilityUserEntity",
		"ROLE_WAREHOUSE_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ClaimUserEntity",
		"ROLE_WAREHOUSE_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InvoiceItemEntity",
		"ROLE_WAREHOUSE_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_WAREHOUSE_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_WAREHOUSE_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MerchantEntity",
		"ROLE_WAREHOUSE_USER_MERCHANT_ENTITY_MERCHANT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_WAREHOUSE_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "CashReceiptEntity",
		"ROLE_WAREHOUSE_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "CashAllocationEntity",
		"ROLE_WAREHOUSE_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "CashRefundEntity",
		"ROLE_WAREHOUSE_USER_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "CashierUserEntity",
		"ROLE_WAREHOUSE_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_WAREHOUSE_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_WAREHOUSE_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_WAREHOUSE_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_WAREHOUSE_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_WAREHOUSE_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_WAREHOUSE_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_WAREHOUSE_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_WAREHOUSE_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "SepEntity",
		"ROLE_WAREHOUSE_USER_SEP_ENTITY_SEP", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "SupplierEntity",
		"ROLE_WAREHOUSE_USER_SUPPLIER_ENTITY_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_WAREHOUSE_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_WAREHOUSE_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_WAREHOUSE_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "RoomTransferEntity",
		"ROLE_WAREHOUSE_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_WAREHOUSE_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_WAREHOUSE_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_WAREHOUSE_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_WAREHOUSE_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_WAREHOUSE_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_WAREHOUSE_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_WAREHOUSE_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_WAREHOUSE_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_WAREHOUSE_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_WAREHOUSE_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "StockControlEntity",
		"ROLE_WAREHOUSE_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_WAREHOUSE_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_WAREHOUSE_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_WAREHOUSE_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_WAREHOUSE_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_WAREHOUSE_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_WAREHOUSE_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_WAREHOUSE_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_WAREHOUSE_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_WAREHOUSE_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_WAREHOUSE_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "TaskDashboardEntity",
		"ROLE_WAREHOUSE_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_WAREHOUSE_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_WAREHOUSE_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_WAREHOUSE_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_WAREHOUSE_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_WAREHOUSE_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_WAREHOUSE_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_WAREHOUSE_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_WAREHOUSE_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsSEPEntity",
		"ROLE_WAREHOUSE_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "RegistrationUserEntity",
		"ROLE_WAREHOUSE_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_WAREHOUSE_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_WAREHOUSE_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_WAREHOUSE_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicationItemEntity",
		"ROLE_WAREHOUSE_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_WAREHOUSE_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_WAREHOUSE_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_WAREHOUSE_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_WAREHOUSE_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_WAREHOUSE_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_WAREHOUSE_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_WAREHOUSE_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_WAREHOUSE_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_WAREHOUSE_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_WAREHOUSE_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_WAREHOUSE_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_WAREHOUSE_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_WAREHOUSE_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_WAREHOUSE_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_WAREHOUSE_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_WAREHOUSE_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_WAREHOUSE_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_WAREHOUSE_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BedReserveEntity",
		"ROLE_WAREHOUSE_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_WAREHOUSE_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_WAREHOUSE_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_WAREHOUSE_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_WAREHOUSE_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_WAREHOUSE_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "WarehouseUserEntity",
		"ROLE_WAREHOUSE_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_WAREHOUSE_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_WAREHOUSE_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_WAREHOUSE_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "JournalEntity",
		"ROLE_WAREHOUSE_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_WAREHOUSE_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_WAREHOUSE_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPRBEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_WAREHOUSE_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_WAREHOUSE_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareUmumEntity",
		"ROLE_WAREHOUSE_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_WAREHOUSE_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareDokterEntity",
		"ROLE_WAREHOUSE_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_WAREHOUSE_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareTindakanEntity",
		"ROLE_WAREHOUSE_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_WAREHOUSE_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareMCUEntity",
		"ROLE_WAREHOUSE_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_WAREHOUSE_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_WAREHOUSE_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_WAREHOUSE_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_WAREHOUSE_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_WAREHOUSE_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "NewbornDetailEntity",
		"ROLE_WAREHOUSE_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "VitalSignsEntity",
		"ROLE_WAREHOUSE_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_WAREHOUSE_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_WAREHOUSE_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_WAREHOUSE_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_WAREHOUSE_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_WAREHOUSE_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_WAREHOUSE_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_WAREHOUSE_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_WAREHOUSE_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_WAREHOUSE_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "TransferOrderEntity",
		"ROLE_WAREHOUSE_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InternalOrderEntity",
		"ROLE_WAREHOUSE_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_WAREHOUSE_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_WAREHOUSE_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareExaminationEntity",
		"ROLE_WAREHOUSE_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_WAREHOUSE_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_WAREHOUSE_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_WAREHOUSE_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_WAREHOUSE_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_WAREHOUSE_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_WAREHOUSE_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_WAREHOUSE_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_WAREHOUSE_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_WAREHOUSE_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_WAREHOUSE_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_WAREHOUSE_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_WAREHOUSE_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_WAREHOUSE_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PurchasingUserEntity",
		"ROLE_WAREHOUSE_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_WAREHOUSE_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_WAREHOUSE_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_WAREHOUSE_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_WAREHOUSE_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_WAREHOUSE_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "BirthHistoryEntity",
		"ROLE_WAREHOUSE_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "PatientConsentEntity",
		"ROLE_WAREHOUSE_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_WAREHOUSE_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "InformedConsentEntity",
		"ROLE_WAREHOUSE_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_WAREHOUSE_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_WAREHOUSE_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_WAREHOUSE_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_WAREHOUSE_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "EntExaminationEntity",
		"ROLE_WAREHOUSE_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_WAREHOUSE_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_WAREHOUSE_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_WAREHOUSE_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_WAREHOUSE_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_WAREHOUSE_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_WAREHOUSE_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", false, false, false, false);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_WAREHOUSE_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(warehouseUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_WAREHOUSE_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(warehouseUserRoleEntity);

		final String diagnosticSupportUserRoleName = "DIAGNOSTIC_SUPPORT_USER";
		Optional<RoleEntity> diagnosticSupportUserRoleOpt = roleRepository.findByName(diagnosticSupportUserRoleName);
		var diagnosticSupportUserRoleEntity = diagnosticSupportUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(diagnosticSupportUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ReferenceDataEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "RegistrationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalFeeEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ServiceEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SERVICE_ENTITY_SERVICE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "WarehouseEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_WAREHOUSE_ENTITY_WAREHOUSE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "LocationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_LOCATION_ENTITY_LOCATION", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ServiceItemEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "TariffSchemaEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "StaffEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_STAFF_ENTITY_STAFF", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "AdministratorEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientVisitEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "Icd10Entity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_ICD_10_ENTITY_ICD_10", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "Icd9CMEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_ICD_9_CM_ENTITY_ICD_9_CM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ExaminationItemEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "StockCatalogueEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "RoomFacilityEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BedFacilityEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BED_FACILITY_ENTITY_BED_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "McuPackageEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "McuPackageItemEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "HealthFacilityEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PriceComponentEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "TariffFormulaEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InvoiceEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVOICE_ENTITY_INVOICE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PharmacySetupEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "NumberingSetupEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", false, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "AdministrationUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DoctorUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "NurseUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PharmacyUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ManagementUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "FacilityUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ClaimUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InvoiceItemEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MerchantEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MERCHANT_ENTITY_MERCHANT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "CashReceiptEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "CashAllocationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "CashRefundEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_CASH_REFUND_ENTITY_CASH_REFUND", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "CashierUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "SepEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SEP_ENTITY_SEP", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "SupplierEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SUPPLIER_ENTITY_SUPPLIER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "RoomTransferEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "StockControlEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "TaskDashboardEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsSEPEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "RegistrationUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicationItemEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BedReserveEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "WarehouseUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "JournalEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPRBEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareUmumEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareDokterEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareTindakanEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareMCUEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_MCU_ENTITY_PCARE_MCU", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", false, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "NewbornDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "VitalSignsEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "TransferOrderEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InternalOrderEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareExaminationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PurchasingUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "BirthHistoryEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "PatientConsentEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "InformedConsentEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "EntExaminationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", false, true, false, false);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(diagnosticSupportUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_DIAGNOSTIC_SUPPORT_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(diagnosticSupportUserRoleEntity);

		final String systemAdminUserRoleName = "SYSTEM_ADMIN_USER";
		Optional<RoleEntity> systemAdminUserRoleOpt = roleRepository.findByName(systemAdminUserRoleName);
		var systemAdminUserRoleEntity = systemAdminUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(systemAdminUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ReferenceDataEntity",
		"ROLE_SYSTEM_ADMIN_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_SYSTEM_ADMIN_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "RegistrationEntity",
		"ROLE_SYSTEM_ADMIN_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalFeeEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_SYSTEM_ADMIN_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ServiceEntity",
		"ROLE_SYSTEM_ADMIN_USER_SERVICE_ENTITY_SERVICE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_SYSTEM_ADMIN_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_SYSTEM_ADMIN_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "WarehouseEntity",
		"ROLE_SYSTEM_ADMIN_USER_WAREHOUSE_ENTITY_WAREHOUSE", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "LocationEntity",
		"ROLE_SYSTEM_ADMIN_USER_LOCATION_ENTITY_LOCATION", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ServiceItemEntity",
		"ROLE_SYSTEM_ADMIN_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "TariffSchemaEntity",
		"ROLE_SYSTEM_ADMIN_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_SYSTEM_ADMIN_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "StaffEntity",
		"ROLE_SYSTEM_ADMIN_USER_STAFF_ENTITY_STAFF", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "AdministratorEntity",
		"ROLE_SYSTEM_ADMIN_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientVisitEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_SYSTEM_ADMIN_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_SYSTEM_ADMIN_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "Icd10Entity",
		"ROLE_SYSTEM_ADMIN_USER_ICD_10_ENTITY_ICD_10", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "Icd9CMEntity",
		"ROLE_SYSTEM_ADMIN_USER_ICD_9_CM_ENTITY_ICD_9_CM", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_SYSTEM_ADMIN_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_SYSTEM_ADMIN_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ExaminationItemEntity",
		"ROLE_SYSTEM_ADMIN_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_SYSTEM_ADMIN_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_SYSTEM_ADMIN_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_SYSTEM_ADMIN_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "StockCatalogueEntity",
		"ROLE_SYSTEM_ADMIN_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "RoomFacilityEntity",
		"ROLE_SYSTEM_ADMIN_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BedFacilityEntity",
		"ROLE_SYSTEM_ADMIN_USER_BED_FACILITY_ENTITY_BED_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_SYSTEM_ADMIN_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "McuPackageEntity",
		"ROLE_SYSTEM_ADMIN_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "McuPackageItemEntity",
		"ROLE_SYSTEM_ADMIN_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "HealthFacilityEntity",
		"ROLE_SYSTEM_ADMIN_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_SYSTEM_ADMIN_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_SYSTEM_ADMIN_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_SYSTEM_ADMIN_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_SYSTEM_ADMIN_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_SYSTEM_ADMIN_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_SYSTEM_ADMIN_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PriceComponentEntity",
		"ROLE_SYSTEM_ADMIN_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_SYSTEM_ADMIN_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "TariffFormulaEntity",
		"ROLE_SYSTEM_ADMIN_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InvoiceEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVOICE_ENTITY_INVOICE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PharmacySetupEntity",
		"ROLE_SYSTEM_ADMIN_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "NumberingSetupEntity",
		"ROLE_SYSTEM_ADMIN_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "AdministrationUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DoctorUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "NurseUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_NURSE_USER_ENTITY_NURSE_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PharmacyUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_SYSTEM_ADMIN_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ManagementUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "FacilityUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_FACILITY_USER_ENTITY_FACILITY_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ClaimUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_CLAIM_USER_ENTITY_CLAIM_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InvoiceItemEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MerchantEntity",
		"ROLE_SYSTEM_ADMIN_USER_MERCHANT_ENTITY_MERCHANT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_SYSTEM_ADMIN_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "CashReceiptEntity",
		"ROLE_SYSTEM_ADMIN_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "CashAllocationEntity",
		"ROLE_SYSTEM_ADMIN_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "CashRefundEntity",
		"ROLE_SYSTEM_ADMIN_USER_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "CashierUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_CASHIER_USER_ENTITY_CASHIER_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "SepEntity",
		"ROLE_SYSTEM_ADMIN_USER_SEP_ENTITY_SEP", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "SupplierEntity",
		"ROLE_SYSTEM_ADMIN_USER_SUPPLIER_ENTITY_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_SYSTEM_ADMIN_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_SYSTEM_ADMIN_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "RoomTransferEntity",
		"ROLE_SYSTEM_ADMIN_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_SYSTEM_ADMIN_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_SYSTEM_ADMIN_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_SYSTEM_ADMIN_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_SYSTEM_ADMIN_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_SYSTEM_ADMIN_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_SYSTEM_ADMIN_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_SYSTEM_ADMIN_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_SYSTEM_ADMIN_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_SYSTEM_ADMIN_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "StockControlEntity",
		"ROLE_SYSTEM_ADMIN_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_SYSTEM_ADMIN_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_SYSTEM_ADMIN_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_SYSTEM_ADMIN_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_SYSTEM_ADMIN_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "TaskDashboardEntity",
		"ROLE_SYSTEM_ADMIN_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsSEPEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "RegistrationUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicationItemEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_SYSTEM_ADMIN_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_SYSTEM_ADMIN_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BedReserveEntity",
		"ROLE_SYSTEM_ADMIN_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "WarehouseUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_SYSTEM_ADMIN_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "JournalEntity",
		"ROLE_SYSTEM_ADMIN_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_SYSTEM_ADMIN_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPRBEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareUmumEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareDokterEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareTindakanEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareMCUEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_SYSTEM_ADMIN_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_SYSTEM_ADMIN_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_SYSTEM_ADMIN_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_SYSTEM_ADMIN_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "NewbornDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "VitalSignsEntity",
		"ROLE_SYSTEM_ADMIN_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_SYSTEM_ADMIN_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_SYSTEM_ADMIN_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_SYSTEM_ADMIN_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_SYSTEM_ADMIN_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_SYSTEM_ADMIN_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "TransferOrderEntity",
		"ROLE_SYSTEM_ADMIN_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InternalOrderEntity",
		"ROLE_SYSTEM_ADMIN_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareExaminationEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_SYSTEM_ADMIN_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_SYSTEM_ADMIN_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_SYSTEM_ADMIN_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_SYSTEM_ADMIN_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_SYSTEM_ADMIN_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_SYSTEM_ADMIN_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PurchasingUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_SYSTEM_ADMIN_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_SYSTEM_ADMIN_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_SYSTEM_ADMIN_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_SYSTEM_ADMIN_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_SYSTEM_ADMIN_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "BirthHistoryEntity",
		"ROLE_SYSTEM_ADMIN_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "PatientConsentEntity",
		"ROLE_SYSTEM_ADMIN_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_SYSTEM_ADMIN_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "InformedConsentEntity",
		"ROLE_SYSTEM_ADMIN_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_SYSTEM_ADMIN_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_SYSTEM_ADMIN_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_SYSTEM_ADMIN_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_SYSTEM_ADMIN_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "EntExaminationEntity",
		"ROLE_SYSTEM_ADMIN_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_SYSTEM_ADMIN_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_SYSTEM_ADMIN_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_SYSTEM_ADMIN_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_SYSTEM_ADMIN_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_SYSTEM_ADMIN_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_SYSTEM_ADMIN_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, false);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_SYSTEM_ADMIN_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(systemAdminUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_SYSTEM_ADMIN_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(systemAdminUserRoleEntity);

		final String purchasingUserRoleName = "PURCHASING_USER";
		Optional<RoleEntity> purchasingUserRoleOpt = roleRepository.findByName(purchasingUserRoleName);
		var purchasingUserRoleEntity = purchasingUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(purchasingUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(purchasingUserRoleEntity, "ReferenceDataEntity",
		"ROLE_PURCHASING_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_PURCHASING_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_PURCHASING_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "RegistrationEntity",
		"ROLE_PURCHASING_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalFeeEntity",
		"ROLE_PURCHASING_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_PURCHASING_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_PURCHASING_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ServiceEntity",
		"ROLE_PURCHASING_USER_SERVICE_ENTITY_SERVICE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_PURCHASING_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_PURCHASING_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "WarehouseEntity",
		"ROLE_PURCHASING_USER_WAREHOUSE_ENTITY_WAREHOUSE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "LocationEntity",
		"ROLE_PURCHASING_USER_LOCATION_ENTITY_LOCATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ServiceItemEntity",
		"ROLE_PURCHASING_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "TariffSchemaEntity",
		"ROLE_PURCHASING_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_PURCHASING_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "StaffEntity",
		"ROLE_PURCHASING_USER_STAFF_ENTITY_STAFF", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "AdministratorEntity",
		"ROLE_PURCHASING_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientVisitEntity",
		"ROLE_PURCHASING_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientDetailEntity",
		"ROLE_PURCHASING_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_PURCHASING_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_PURCHASING_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_PURCHASING_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_PURCHASING_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_PURCHASING_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_PURCHASING_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_PURCHASING_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_PURCHASING_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_PURCHASING_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_PURCHASING_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_PURCHASING_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_PURCHASING_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "Icd10Entity",
		"ROLE_PURCHASING_USER_ICD_10_ENTITY_ICD_10", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "Icd9CMEntity",
		"ROLE_PURCHASING_USER_ICD_9_CM_ENTITY_ICD_9_CM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_PURCHASING_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_PURCHASING_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_PURCHASING_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ExaminationItemEntity",
		"ROLE_PURCHASING_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_PURCHASING_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_PURCHASING_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_PURCHASING_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_PURCHASING_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_PURCHASING_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_PURCHASING_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "StockCatalogueEntity",
		"ROLE_PURCHASING_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "RoomFacilityEntity",
		"ROLE_PURCHASING_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BedFacilityEntity",
		"ROLE_PURCHASING_USER_BED_FACILITY_ENTITY_BED_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_PURCHASING_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "McuPackageEntity",
		"ROLE_PURCHASING_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "McuPackageItemEntity",
		"ROLE_PURCHASING_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "HealthFacilityEntity",
		"ROLE_PURCHASING_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_PURCHASING_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_PURCHASING_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_PURCHASING_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_PURCHASING_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_PURCHASING_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_PURCHASING_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_PURCHASING_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_PURCHASING_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_PURCHASING_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_PURCHASING_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_PURCHASING_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PriceComponentEntity",
		"ROLE_PURCHASING_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_PURCHASING_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "TariffFormulaEntity",
		"ROLE_PURCHASING_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InvoiceEntity",
		"ROLE_PURCHASING_USER_INVOICE_ENTITY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_PURCHASING_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_PURCHASING_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PharmacySetupEntity",
		"ROLE_PURCHASING_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "NumberingSetupEntity",
		"ROLE_PURCHASING_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "AdministrationUserEntity",
		"ROLE_PURCHASING_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DoctorUserEntity",
		"ROLE_PURCHASING_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "NurseUserEntity",
		"ROLE_PURCHASING_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PharmacyUserEntity",
		"ROLE_PURCHASING_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_PURCHASING_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_PURCHASING_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_PURCHASING_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ManagementUserEntity",
		"ROLE_PURCHASING_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "FacilityUserEntity",
		"ROLE_PURCHASING_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ClaimUserEntity",
		"ROLE_PURCHASING_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InvoiceItemEntity",
		"ROLE_PURCHASING_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_PURCHASING_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_PURCHASING_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MerchantEntity",
		"ROLE_PURCHASING_USER_MERCHANT_ENTITY_MERCHANT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_PURCHASING_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "CashReceiptEntity",
		"ROLE_PURCHASING_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_PURCHASING_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "CashAllocationEntity",
		"ROLE_PURCHASING_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "CashRefundEntity",
		"ROLE_PURCHASING_USER_CASH_REFUND_ENTITY_CASH_REFUND", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "CashierUserEntity",
		"ROLE_PURCHASING_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_PURCHASING_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_PURCHASING_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_PURCHASING_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_PURCHASING_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_PURCHASING_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_PURCHASING_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_PURCHASING_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_PURCHASING_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "SepEntity",
		"ROLE_PURCHASING_USER_SEP_ENTITY_SEP", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "SupplierEntity",
		"ROLE_PURCHASING_USER_SUPPLIER_ENTITY_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_PURCHASING_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_PURCHASING_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_PURCHASING_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "RoomTransferEntity",
		"ROLE_PURCHASING_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_PURCHASING_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_PURCHASING_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_PURCHASING_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_PURCHASING_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_PURCHASING_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_PURCHASING_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_PURCHASING_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_PURCHASING_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_PURCHASING_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_PURCHASING_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "StockControlEntity",
		"ROLE_PURCHASING_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_PURCHASING_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_PURCHASING_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_PURCHASING_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_PURCHASING_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_PURCHASING_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_PURCHASING_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_PURCHASING_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_PURCHASING_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_PURCHASING_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_PURCHASING_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_PURCHASING_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_PURCHASING_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_PURCHASING_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "TaskDashboardEntity",
		"ROLE_PURCHASING_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_PURCHASING_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_PURCHASING_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_PURCHASING_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_PURCHASING_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_PURCHASING_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_PURCHASING_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_PURCHASING_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_PURCHASING_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_PURCHASING_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_PURCHASING_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsSEPEntity",
		"ROLE_PURCHASING_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "RegistrationUserEntity",
		"ROLE_PURCHASING_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_PURCHASING_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_PURCHASING_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_PURCHASING_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicationItemEntity",
		"ROLE_PURCHASING_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_PURCHASING_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_PURCHASING_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_PURCHASING_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_PURCHASING_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_PURCHASING_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_PURCHASING_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_PURCHASING_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_PURCHASING_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_PURCHASING_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_PURCHASING_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_PURCHASING_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_PURCHASING_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_PURCHASING_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_PURCHASING_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_PURCHASING_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_PURCHASING_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_PURCHASING_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_PURCHASING_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BedReserveEntity",
		"ROLE_PURCHASING_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_PURCHASING_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_PURCHASING_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_PURCHASING_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_PURCHASING_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_PURCHASING_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "WarehouseUserEntity",
		"ROLE_PURCHASING_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_PURCHASING_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_PURCHASING_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_PURCHASING_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "JournalEntity",
		"ROLE_PURCHASING_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_PURCHASING_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_PURCHASING_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPRBEntity",
		"ROLE_PURCHASING_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_PURCHASING_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_PURCHASING_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_PURCHASING_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareUmumEntity",
		"ROLE_PURCHASING_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_PURCHASING_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareDokterEntity",
		"ROLE_PURCHASING_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_PURCHASING_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_PURCHASING_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_PURCHASING_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareTindakanEntity",
		"ROLE_PURCHASING_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_PURCHASING_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_PURCHASING_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_PURCHASING_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_PURCHASING_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareMCUEntity",
		"ROLE_PURCHASING_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_PURCHASING_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_PURCHASING_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_PURCHASING_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_PURCHASING_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_PURCHASING_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_PURCHASING_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_PURCHASING_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_PURCHASING_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_PURCHASING_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "NewbornDetailEntity",
		"ROLE_PURCHASING_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "VitalSignsEntity",
		"ROLE_PURCHASING_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_PURCHASING_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_PURCHASING_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_PURCHASING_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_PURCHASING_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_PURCHASING_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_PURCHASING_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_PURCHASING_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_PURCHASING_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_PURCHASING_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_PURCHASING_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "TransferOrderEntity",
		"ROLE_PURCHASING_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InternalOrderEntity",
		"ROLE_PURCHASING_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_PURCHASING_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_PURCHASING_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareExaminationEntity",
		"ROLE_PURCHASING_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_PURCHASING_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_PURCHASING_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_PURCHASING_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_PURCHASING_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_PURCHASING_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_PURCHASING_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_PURCHASING_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_PURCHASING_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_PURCHASING_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_PURCHASING_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_PURCHASING_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_PURCHASING_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_PURCHASING_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PurchasingUserEntity",
		"ROLE_PURCHASING_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_PURCHASING_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_PURCHASING_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_PURCHASING_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_PURCHASING_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_PURCHASING_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "BirthHistoryEntity",
		"ROLE_PURCHASING_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "PatientConsentEntity",
		"ROLE_PURCHASING_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_PURCHASING_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "InformedConsentEntity",
		"ROLE_PURCHASING_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_PURCHASING_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_PURCHASING_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_PURCHASING_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_PURCHASING_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_PURCHASING_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_PURCHASING_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "EntExaminationEntity",
		"ROLE_PURCHASING_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_PURCHASING_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_PURCHASING_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_PURCHASING_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_PURCHASING_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_PURCHASING_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_PURCHASING_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_PURCHASING_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_PURCHASING_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(purchasingUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_PURCHASING_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(purchasingUserRoleEntity);

		final String medicalTranscriberUserRoleName = "MEDICAL_TRANSCRIBER_USER";
		Optional<RoleEntity> medicalTranscriberUserRoleOpt = roleRepository.findByName(medicalTranscriberUserRoleName);
		var medicalTranscriberUserRoleEntity = medicalTranscriberUserRoleOpt.orElseGet(() -> {
			var role = new RoleEntity();
			role.setName(medicalTranscriberUserRoleName);
			return roleRepository.save(role);
		});

		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ReferenceDataEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_REFERENCE_DATA_ENTITY_REFERENCE_DATA", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ReferenceHeaderEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_REFERENCE_HEADER_ENTITY_REFERENCE_HEADER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientGeneralInfoEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_GENERAL_INFO_ENTITY_PATIENT_GENERAL_INFO", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "RegistrationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_REGISTRATION_ENTITY_REGISTRATION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalFeeEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_FEE_ENTITY_MEDICAL_FEE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalExaminationRecordEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_EXAMINATION_RECORD_ENTITY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PrescriptionHeaderEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PRESCRIPTION_HEADER_ENTITY_PRESCRIPTION_HEADER", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ServiceEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SERVICE_ENTITY_SERVICE", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "WarehouseInventoryEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_WAREHOUSE_INVENTORY_ENTITY_WAREHOUSE_INVENTORY", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "TariffDefinitionEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_TARIFF_DEFINITION_ENTITY_TARIFF_DEFINITION", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "WarehouseEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_WAREHOUSE_ENTITY_WAREHOUSE", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "LocationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_LOCATION_ENTITY_LOCATION", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ServiceItemEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SERVICE_ITEM_ENTITY_SERVICE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "TariffSchemaEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_TARIFF_SCHEMA_ENTITY_TARIFF_SCHEMA", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ServiceItemAssignmentEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SERVICE_ITEM_ASSIGNMENT_ENTITY_SERVICE_ITEM_ASSIGNMENT", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "StaffEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_STAFF_ENTITY_STAFF", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "AdministratorEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_ADMINISTRATOR_ENTITY_ADMINISTRATOR", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientVisitEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_VISIT_ENTITY_PATIENT_VISIT", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_DETAIL_ENTITY_PATIENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientPersonalInfoEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_PERSONAL_INFO_ENTITY_PATIENT_PERSONAL_INFO", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientDetailAddressEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_DETAIL_ADDRESS_ENTITY_PATIENT_DETAIL_ADDRESS", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientContactInfoEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_CONTACT_INFO_ENTITY_PATIENT_CONTACT_INFO", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientEmergencyContactDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_EMERGENCY_CONTACT_DETAIL_ENTITY_PATIENT_EMERGENCY_CONTACT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientPaymentSelfPayingEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_PAYMENT_SELF_PAYING", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientPaymentInsuranceEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_PAYMENT_INSURANCE", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InsuranceProviderEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INSURANCE_PROVIDER_ENTITY_INSURANCE_PROVIDER", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InsuranceBenefitPlanEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INSURANCE_BENEFIT_PLAN_ENTITY_INSURANCE_BENEFIT_PLAN", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientPaymentOthersEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_PAYMENT_OTHERS", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientCaseHistoryEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_CASE_HISTORY_ENTITY_PATIENT_CASE_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientSupportingDocumentEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_SUPPORTING_DOCUMENT_ENTITY_PATIENT_SUPPORTING_DOCUMENT", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientPaymentBPJSEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_PAYMENT_BPJS_ENTITY_PATIENT_PAYMENT_BPJS", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "Icd10Entity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_ICD_10_ENTITY_ICD_10", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "Icd9CMEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_ICD_9_CM_ENTITY_ICD_9_CM", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DoctorScheduleEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DOCTOR_SCHEDULE_ENTITY_DOCTOR_SCHEDULE", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientEmploymentDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_EMPLOYMENT_DETAIL_ENTITY_PATIENT_EMPLOYMENT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ExaminationGroupEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_EXAMINATION_GROUP_ENTITY_EXAMINATION_GROUP", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ExaminationItemEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_EXAMINATION_ITEM_ENTITY_EXAMINATION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "CatalogueMedicalEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_CATALOGUE_MEDICAL_ENTITY_CATALOGUE_MEDICAL", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "UnitOfMeasurementEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_UNIT_OF_MEASUREMENT_ENTITY_UNIT_OF_MEASUREMENT", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "CatalogueNonMedicalEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_CATALOGUE_NON_MEDICAL_ENTITY_CATALOGUE_NON_MEDICAL", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientVisitPaymentSelfPayingEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_VISIT_PAYMENT_SELF_PAYING_ENTITY_PATIENT_VISIT_PAYMENT_SELF_PAYING", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientVisitPatientPaymentInsuranceEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientVisitPatientPaymentOthersEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ENTITY_PATIENT_VISIT_PATIENT_PAYMENT_OTHERS", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "StockCatalogueEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_STOCK_CATALOGUE_ENTITY_STOCK_CATALOGUE", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "RoomFacilityEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_ROOM_FACILITY_ENTITY_ROOM_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BedFacilityEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BED_FACILITY_ENTITY_BED_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DiagnosesAndProceduresEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DIAGNOSES_AND_PROCEDURES_ENTITY_DIAGNOSES_AND_PROCEDURES", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "McuPackageEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MCU_PACKAGE_ENTITY_MCU_PACKAGE", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "McuPackageItemEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MCU_PACKAGE_ITEM_ENTITY_MCU_PACKAGE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "HealthFacilityEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_HEALTH_FACILITY_ENTITY_HEALTH_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DiagnosisExaminationRecordEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DIAGNOSIS_EXAMINATION_RECORD_ENTITY_DIAGNOSIS_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DiagnosisNandaEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DIAGNOSIS_NANDA_ENTITY_DIAGNOSIS_NANDA", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "HospitalGroupInformationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_HOSPITAL_GROUP_INFORMATION_ENTITY_HOSPITAL_GROUP_INFORMATION", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "HospitalBranchInformationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_HOSPITAL_BRANCH_INFORMATION_ENTITY_HOSPITAL_BRANCH_INFORMATION", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PrescriptionItemEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PRESCRIPTION_ITEM_ENTITY_PRESCRIPTION_ITEM", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PrescriptionCompoundEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PRESCRIPTION_COMPOUND_ENTITY_PRESCRIPTION_COMPOUND", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalCertificateSickLeaveEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_CERTIFICATE_SICK_LEAVE_ENTITY_MEDICAL_CERTIFICATE_SICK_LEAVE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalCertificateRestrictedWorkEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_CERTIFICATE_RESTRICTED_WORK_ENTITY_MEDICAL_CERTIFICATE_RESTRICTED_WORK", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalCertificateMedicalAttendanceEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE_ENTITY_MEDICAL_CERTIFICATE_MEDICAL_ATTENDANCE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalRecordInitialChecklistEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_RECORD_INITIAL_CHECKLIST_ENTITY_MEDICAL_RECORD_INITIAL_CHECKLIST", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalRecordNextVerificationChecklistEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST_ENTITY_MEDICAL_RECORD_NEXT_VERIFICATION_CHECKLIST", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PriceComponentEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PRICE_COMPONENT_ENTITY_PRICE_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "TariffDefinitionOtherComponentEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_TARIFF_DEFINITION_OTHER_COMPONENT_ENTITY_TARIFF_DEFINITION_OTHER_COMPONENT", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "TariffFormulaEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_TARIFF_FORMULA_ENTITY_TARIFF_FORMULA", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InvoiceEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVOICE_ENTITY_INVOICE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InvoicePaymentSelfPayingEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVOICE_PAYMENT_SELF_PAYING_ENTITY_INVOICE_PAYMENT_SELF_PAYING", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InvoicePaymentOtherEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVOICE_PAYMENT_OTHER_ENTITY_INVOICE_PAYMENT_OTHER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PharmacySetupEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PHARMACY_SETUP_ENTITY_PHARMACY_SETUP", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "NumberingSetupEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_NUMBERING_SETUP_ENTITY_NUMBERING_SETUP", false, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "AdministrationUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_ADMINISTRATION_USER_ENTITY_ADMINISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DoctorUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DOCTOR_USER_ENTITY_DOCTOR_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "NurseUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_NURSE_USER_ENTITY_NURSE_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PharmacyUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PHARMACY_USER_ENTITY_PHARMACY_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "CompoundPrescriptionDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_COMPOUND_PRESCRIPTION_DETAIL_ENTITY_COMPOUND_PRESCRIPTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "CompoundPrescriptionItemEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_COMPOUND_PRESCRIPTION_ITEM_ENTITY_COMPOUND_PRESCRIPTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalRecordUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_RECORD_USER_ENTITY_MEDICAL_RECORD_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ManagementUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MANAGEMENT_USER_ENTITY_MANAGEMENT_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "FacilityUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_FACILITY_USER_ENTITY_FACILITY_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ClaimUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_CLAIM_USER_ENTITY_CLAIM_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InvoiceItemEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVOICE_ITEM_ENTITY_INVOICE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InvoiceSummaryEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVOICE_SUMMARY_ENTITY_INVOICE_SUMMARY", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InvoiceItemComponentEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVOICE_ITEM_COMPONENT_ENTITY_INVOICE_ITEM_COMPONENT", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MerchantEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MERCHANT_ENTITY_MERCHANT", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MerchantSurchargeAndFeeEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MERCHANT_SURCHARGE_AND_FEE_ENTITY_MERCHANT_SURCHARGE_AND_FEE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "CashReceiptEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_CASH_RECEIPT_ENTITY_CASH_RECEIPT", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalFeeItemComponentEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_FEE_ITEM_COMPONENT_ENTITY_MEDICAL_FEE_ITEM_COMPONENT", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "CashAllocationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_CASH_ALLOCATION_ENTITY_CASH_ALLOCATION", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "CashRefundEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_CASH_REFUND_ENTITY_CASH_REFUND", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "CashierUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_CASHIER_USER_ENTITY_CASHIER_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InvoicePaymentInsuranceEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVOICE_PAYMENT_INSURANCE_ENTITY_INVOICE_PAYMENT_INSURANCE", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsGeneralEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_GENERAL_ENTITY_BPJS_GENERAL", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsDoctorMappingEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_DOCTOR_MAPPING_ENTITY_BPJS_DOCTOR_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsServiceMappingEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_SERVICE_MAPPING_ENTITY_BPJS_SERVICE_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsDismissalMappingEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_DISMISSAL_MAPPING_ENTITY_BPJS_DISMISSAL_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsTreatmentClassMappingEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_TREATMENT_CLASS_MAPPING_ENTITY_BPJS_TREATMENT_CLASS_MAPPING", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsINACBGEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_INACBG_ENTITY_BPJS_INACBG", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsINACBGVariableEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_INACBG_VARIABLE_ENTITY_BPJS_INACBG_VARIABLE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "SepEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SEP_ENTITY_SEP", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "SupplierEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SUPPLIER_ENTITY_SUPPLIER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "SupplierContactDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SUPPLIER_CONTACT_DETAIL_ENTITY_SUPPLIER_CONTACT_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "SupplierBankAccountEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SUPPLIER_BANK_ACCOUNT_ENTITY_SUPPLIER_BANK_ACCOUNT", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InpatientMedicalExaminationRecordEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INPATIENT_MEDICAL_EXAMINATION_RECORD_ENTITY_INPATIENT_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "RoomTransferEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_ROOM_TRANSFER_ENTITY_ROOM_TRANSFER", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "CoTreatingDoctorEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_CO_TREATING_DOCTOR_ENTITY_CO_TREATING_DOCTOR", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "WarehouseInitialStockEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_WAREHOUSE_INITIAL_STOCK_ENTITY_WAREHOUSE_INITIAL_STOCK", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "CatalogueUOMEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_CATALOGUE_UOM_ENTITY_CATALOGUE_UOM", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "GoodsReceiveNoteEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_GOODS_RECEIVE_NOTE_ENTITY_GOODS_RECEIVE_NOTE", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "GoodsReceiveNoteItemEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_GOODS_RECEIVE_NOTE_ITEM_ENTITY_GOODS_RECEIVE_NOTE_ITEM", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "GoodsReceiveNoteBatchEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_GOODS_RECEIVE_NOTE_BATCH_ENTITY_GOODS_RECEIVE_NOTE_BATCH", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "StockTransactionDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_STOCK_TRANSACTION_DETAIL_ENTITY_STOCK_TRANSACTION_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "TransactionDetailTypeEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_TRANSACTION_DETAIL_TYPE_ENTITY_TRANSACTION_DETAIL_TYPE", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "TransactionDetailTypeMappingEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_TRANSACTION_DETAIL_TYPE_MAPPING_ENTITY_TRANSACTION_DETAIL_TYPE_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "StockTransactionPerDateTypeEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_STOCK_TRANSACTION_PER_DATE_TYPE_ENTITY_STOCK_TRANSACTION_PER_DATE_TYPE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "StockControlEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_STOCK_CONTROL_ENTITY_STOCK_CONTROL", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BatchStockTransactionDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BATCH_STOCK_TRANSACTION_DETAIL_ENTITY_BATCH_STOCK_TRANSACTION_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BatchStockBalanceEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BATCH_STOCK_BALANCE_ENTITY_BATCH_STOCK_BALANCE", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BatchStockBalancePerDateEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BATCH_STOCK_BALANCE_PER_DATE_ENTITY_BATCH_STOCK_BALANCE_PER_DATE", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "StockTransactionPerDateEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_STOCK_TRANSACTION_PER_DATE_ENTITY_STOCK_TRANSACTION_PER_DATE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalCertificateHospitalizationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_CERTIFICATE_HOSPITALIZATION_ENTITY_MEDICAL_CERTIFICATE_HOSPITALIZATION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalCertificateDischargeResumeEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_ENTITY_MEDICAL_CERTIFICATE_DISCHARGE_RESUME", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InventoryBatchCorrectionEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVENTORY_BATCH_CORRECTION_ENTITY_INVENTORY_BATCH_CORRECTION", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InventoryBatchCorrectionItemEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVENTORY_BATCH_CORRECTION_ITEM_ENTITY_INVENTORY_BATCH_CORRECTION_ITEM", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InventoryAdjustmentEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVENTORY_ADJUSTMENT_ENTITY_INVENTORY_ADJUSTMENT", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InventoryAdjustmentItemEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVENTORY_ADJUSTMENT_ITEM_ENTITY_INVENTORY_ADJUSTMENT_ITEM", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InventoryAdjusmentBatchEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INVENTORY_ADJUSMENT_BATCH_ENTITY_INVENTORY_ADJUSMENT_BATCH", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsDoctorScheduleEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_DOCTOR_SCHEDULE_ENTITY_BPJS_DOCTOR_SCHEDULE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalExaminationRecordDischargeSummaryEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY_ENTITY_MEDICAL_EXAMINATION_RECORD_DISCHARGE_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "TaskDashboardEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_TASK_DASHBOARD_ENTITY_TASK_DASHBOARD", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsBedAvailabilityEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_BED_AVAILABILITY_ENTITY_BPJS_BED_AVAILABILITY", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsListTaskEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_LIST_TASK_ENTITY_BPJS_LIST_TASK", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "AmendmentDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_AMENDMENT_DETAIL_ENTITY_AMENDMENT_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsDiagnoseEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_DIAGNOSE_ENTITY_BPJS_DIAGNOSE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsDiagnosePRBEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_DIAGNOSE_PRB_ENTITY_BPJS_DIAGNOSE_PRB", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsDrugGenericPRBEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_DRUG_GENERIC_PRB_ENTITY_BPJS_DRUG_GENERIC_PRB", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsProcedureEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PROCEDURE_ENTITY_BPJS_PROCEDURE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsDismissalConditionEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_DISMISSAL_CONDITION_ENTITY_BPJS_DISMISSAL_CONDITION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsJasaRaharjaEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_JASA_RAHARJA_ENTITY_BPJS_JASA_RAHARJA", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPatientReferralEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PATIENT_REFERRAL_ENTITY_BPJS_PATIENT_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsSEPEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_SEP_ENTITY_BPJS_SEP", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "RegistrationUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_REGISTRATION_USER_ENTITY_REGISTRATION_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsHealthFacilityEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_HEALTH_FACILITY_ENTITY_BPJS_HEALTH_FACILITY", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsAccidentMasterEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_ACCIDENT_MASTER_ENTITY_BPJS_ACCIDENT_MASTER", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicationHeaderEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICATION_HEADER_ENTITY_MEDICATION_HEADER", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicationItemEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICATION_ITEM_ENTITY_MEDICATION_ITEM", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicationCompoundEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICATION_COMPOUND_ENTITY_MEDICATION_COMPOUND", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DiagnosticExaminationResultsEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DIAGNOSTIC_EXAMINATION_RESULTS_ENTITY_DIAGNOSTIC_EXAMINATION_RESULTS", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DiagnosticStaffExaminationSummaryEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY_ENTITY_DIAGNOSTIC_STAFF_EXAMINATION_SUMMARY", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsReferralSpecialistEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_REFERRAL_SPECIALIST_ENTITY_BPJS_REFERRAL_SPECIALIST", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsFacilityListEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_FACILITY_LIST_ENTITY_BPJS_FACILITY_LIST", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsFingerPrintEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_FINGER_PRINT_ENTITY_BPJS_FINGER_PRINT", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsListFingerPrintEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_LIST_FINGER_PRINT_ENTITY_BPJS_LIST_FINGER_PRINT", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsClaimDataEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_CLAIM_DATA_ENTITY_BPJS_CLAIM_DATA", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsTreatmentHistoryEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_TREATMENT_HISTORY_ENTITY_BPJS_TREATMENT_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsSEPINACBGIntegrationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_SEP_INACBG_INTEGRATION_ENTITY_BPJS_SEP_INACBG_INTEGRATION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsSEPInternalDataEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_SEP_INTERNAL_DATA_ENTITY_BPJS_SEP_INTERNAL_DATA", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsJasaRaharjaClaimEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_JASA_RAHARJA_CLAIM_ENTITY_BPJS_JASA_RAHARJA_CLAIM", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsControlPlanEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_CONTROL_PLAN_ENTITY_BPJS_CONTROL_PLAN", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsControlSpecialistEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_CONTROL_SPECIALIST_ENTITY_BPJS_CONTROL_SPECIALIST", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsHospitalizationPlanEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_HOSPITALIZATION_PLAN_ENTITY_BPJS_HOSPITALIZATION_PLAN", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsOutsideFacilityReferralEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_OUTSIDE_FACILITY_REFERRAL_ENTITY_BPJS_OUTSIDE_FACILITY_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsTotalReferralSEPEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_TOTAL_REFERRAL_SEP_ENTITY_BPJS_TOTAL_REFERRAL_SEP", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsSpecialReferralEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_SPECIAL_REFERRAL_ENTITY_BPJS_SPECIAL_REFERRAL", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BedReserveEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BED_RESERVE_ENTITY_BED_RESERVE", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsSearchSEPEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_SEARCH_SEP_ENTITY_BPJS_SEARCH_SEP", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsSEPSubmissionEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_SEP_SUBMISSION_ENTITY_BPJS_SEP_SUBMISSION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsClaimSubmissionEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_CLAIM_SUBMISSION_ENTITY_BPJS_CLAIM_SUBMISSION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsVisitDataEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_VISIT_DATA_ENTITY_BPJS_VISIT_DATA", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsSearchControlLetterEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_SEARCH_CONTROL_LETTER_ENTITY_BPJS_SEARCH_CONTROL_LETTER", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "WarehouseUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_WAREHOUSE_USER_ENTITY_WAREHOUSE_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DiagnosticSupportUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DIAGNOSTIC_SUPPORT_USER_ENTITY_DIAGNOSTIC_SUPPORT_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "VaccinationOrderEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_VACCINATION_ORDER_ENTITY_VACCINATION_ORDER", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "VaccinationOrderDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_VACCINATION_ORDER_DETAIL_ENTITY_VACCINATION_ORDER_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "JournalEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_JOURNAL_ENTITY_JOURNAL", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ChartOfAccountEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_CHART_OF_ACCOUNT_ENTITY_CHART_OF_ACCOUNT", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ExaminationItemDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_EXAMINATION_ITEM_DETAIL_ENTITY_EXAMINATION_ITEM_DETAIL", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPRBEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PRB_ENTITY_BPJS_PRB", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPRBDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PRB_DETAIL_ENTITY_BPJS_PRB_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsTreatmentRoomEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_TREATMENT_ROOM_ENTITY_BPJS_TREATMENT_ROOM", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsINACBGClaimEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_INACBG_CLAIM_ENTITY_BPJS_INACBG_CLAIM", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareUmumEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_UMUM_ENTITY_PCARE_UMUM", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareDiagnosaEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_DIAGNOSA_ENTITY_PCARE_DIAGNOSA", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareDokterEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_DOKTER_ENTITY_PCARE_DOKTER", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareStatusPulangEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_STATUS_PULANG_ENTITY_PCARE_STATUS_PULANG", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPcareKesadaranEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PCARE_KESADARAN_ENTITY_BPJS_PCARE_KESADARAN", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPcareProviderRayonisasiEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PCARE_PROVIDER_RAYONISASI_ENTITY_BPJS_PCARE_PROVIDER_RAYONISASI", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareTindakanEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_TINDAKAN_ENTITY_PCARE_TINDAKAN", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareClubProlanisEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_CLUB_PROLANIS_ENTITY_PCARE_CLUB_PROLANIS", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPcarePoliEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PCARE_POLI_ENTITY_BPJS_PCARE_POLI", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPcareDPHOEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PCARE_DPHO_ENTITY_BPJS_PCARE_DPHO", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPcareKegiatanKelompokEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PCARE_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_KEGIATAN_KELOMPOK", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareMCUEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_MCU_ENTITY_PCARE_MCU", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPcarePesertaKegiatanKelompokEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK_ENTITY_BPJS_PCARE_PESERTA_KEGIATAN_KELOMPOK", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPcareKunjunganRujukanEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PCARE_KUNJUNGAN_RUJUKAN_ENTITY_BPJS_PCARE_KUNJUNGAN_RUJUKAN", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPcarePendaftaranEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PCARE_PENDAFTARAN_ENTITY_BPJS_PCARE_PENDAFTARAN", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPcareRegistrationsEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PCARE_REGISTRATIONS_ENTITY_BPJS_PCARE_REGISTRATIONS", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicationAdministeredHistoryEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICATION_ADMINISTERED_HISTORY_ENTITY_MEDICATION_ADMINISTERED_HISTORY", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ChartOfAccountMappingEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_CHART_OF_ACCOUNT_MAPPING_ENTITY_CHART_OF_ACCOUNT_MAPPING", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "EmergencyMedicalExaminationRecordEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_EMERGENCY_MEDICAL_EXAMINATION_RECORD_ENTITY_EMERGENCY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "FacilityHistoryEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_FACILITY_HISTORY_ENTITY_FACILITY_HISTORY", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DeliveryMedicalExaminationRecordEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DELIVERY_MEDICAL_EXAMINATION_RECORD_ENTITY_DELIVERY_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "NewbornDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_NEWBORN_DETAIL_ENTITY_NEWBORN_DETAIL", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "VitalSignsEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_VITAL_SIGNS_ENTITY_VITAL_SIGNS", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DailyCareCPPTEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DAILY_CARE_CPPT_ENTITY_DAILY_CARE_CPPT", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PostOperativeDetailsEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_POST_OPERATIVE_DETAILS_ENTITY_POST_OPERATIVE_DETAILS", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PreoperativeRecordsEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PREOPERATIVE_RECORDS_ENTITY_PREOPERATIVE_RECORDS", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "IntraoperativeRecordsEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INTRAOPERATIVE_RECORDS_ENTITY_INTRAOPERATIVE_RECORDS", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "OperatingTheaterMedicalExaminationRecordEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD_ENTITY_OPERATING_THEATER_MEDICAL_EXAMINATION_RECORD", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "SystemAdminUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SYSTEM_ADMIN_USER_ENTITY_SYSTEM_ADMIN_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientVitalInformationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_VITAL_INFORMATION_ENTITY_PATIENT_VITAL_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "FluidBalanceDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_FLUID_BALANCE_DETAIL_ENTITY_FLUID_BALANCE_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsUpdateDismissalDateEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_UPDATE_DISMISSAL_DATE_ENTITY_BPJS_UPDATE_DISMISSAL_DATE", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "SupplierProductDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SUPPLIER_PRODUCT_DETAIL_ENTITY_SUPPLIER_PRODUCT_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "TransferOrderEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_TRANSFER_ORDER_ENTITY_TRANSFER_ORDER", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InternalOrderEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INTERNAL_ORDER_ENTITY_INTERNAL_ORDER", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InternalOrderStockDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INTERNAL_ORDER_STOCK_DETAIL_ENTITY_INTERNAL_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "TransferOrderStockDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_TRANSFER_ORDER_STOCK_DETAIL_ENTITY_TRANSFER_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareExaminationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_EXAMINATION_ENTITY_PCARE_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareActionExaminationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_ACTION_EXAMINATION_ENTITY_PCARE_ACTION_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareNonCompoundDrugEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_NONCOMPOUND_DRUG_ENTITY_PCARE_NONCOMPOUND_DRUG", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareCompoundDrugEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_COMPOUND_DRUG_ENTITY_PCARE_COMPOUND_DRUG", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareCompoundDrugItemEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_COMPOUND_DRUG_ITEM_ENTITY_PCARE_COMPOUND_DRUG_ITEM", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PurchaseRequisitionEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PURCHASE_REQUISITION_ENTITY_PURCHASE_REQUISITION", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PurchaseRequisitionStockDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PURCHASE_REQUISITION_STOCK_DETAIL_ENTITY_PURCHASE_REQUISITION_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PurchaseOrderEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PURCHASE_ORDER_ENTITY_PURCHASE_ORDER", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PurchaseOrderStockDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PURCHASE_ORDER_STOCK_DETAIL_ENTITY_PURCHASE_ORDER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ReturnSupplierEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_RETURN_SUPPLIER_ENTITY_RETURN_SUPPLIER", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ReturnSupplierStockDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_RETURN_SUPPLIER_STOCK_DETAIL_ENTITY_RETURN_SUPPLIER_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "SatuSehatConfigurationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SATU_SEHAT_CONFIGURATION_ENTITY_SATU_SEHAT_CONFIGURATION", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PcareReferensiSaranaEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PCARE_REFERENSI_SARANA_ENTITY_PCARE_REFERENSI_SARANA", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BpjsPcareRiwayatKunjunganEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BPJS_PCARE_RIWAYAT_KUNJUNGAN_ENTITY_BPJS_PCARE_RIWAYAT_KUNJUNGAN", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PurchasingUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PURCHASING_USER_ENTITY_PURCHASING_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "RetailPharmacyEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_RETAIL_PHARMACY_ENTITY_RETAIL_PHARMACY", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "RetailPharmacyStockDetailEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_RETAIL_PHARMACY_STOCK_DETAIL_ENTITY_RETAIL_PHARMACY_STOCK_DETAIL", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DiagnosticSupportGeneralConfigurationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION_ENTITY_DIAGNOSTIC_SUPPORT_GENERAL_CONFIGURATION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ObstetricAndGynecologyHistoryEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_OBSTETRIC_AND_GYNECOLOGY_HISTORY_ENTITY_OBSTETRIC_AND_GYNECOLOGY_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BodyChartExaminationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BODY_CHART_EXAMINATION_ENTITY_BODY_CHART_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "BirthHistoryEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_BIRTH_HISTORY_ENTITY_BIRTH_HISTORY", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "PatientConsentEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PATIENT_CONSENT_ENTITY_PATIENT_CONSENT", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "RetailPharmacyInvoiceEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_RETAIL_PHARMACY_INVOICE_ENTITY_RETAIL_PHARMACY_INVOICE", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "InformedConsentEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_INFORMED_CONSENT_ENTITY_INFORMED_CONSENT", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalCertificatePhysicalHealthEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_PHYSICAL_HEALTH", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalCertificateMentalHealthEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_CERTIFICATE_MENTAL_HEALTH_ENTITY_MEDICAL_CERTIFICATE_MENTAL_HEALTH", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "DeliveryProgressEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_DELIVERY_PROGRESS_ENTITY_DELIVERY_PROGRESS", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ProcessWorkflowEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_PROCESS_WORKFLOW_ENTITY_PROCESS_WORKFLOW", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "SampleCollectionInformationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SAMPLE_COLLECTION_INFORMATION_ENTITY_SAMPLE_COLLECTION_INFORMATION", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "SampleCollectionItemsEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SAMPLE_COLLECTION_ITEMS_ENTITY_SAMPLE_COLLECTION_ITEMS", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "EntExaminationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_ENT_EXAMINATION_ENTITY_ENT_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalTranscriberUserEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_TRANSCRIBER_USER_ENTITY_MEDICAL_TRANSCRIBER_USER", false, true, false, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "OphthalmologyExaminationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_OPHTHALMOLOGY_EXAMINATION_ENTITY_OPHTHALMOLOGY_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "MedicalCertificateBirthEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_MEDICAL_CERTIFICATE_BIRTH_ENTITY_MEDICAL_CERTIFICATE_BIRTH", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "HemodialysisExaminationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_HEMODIALYSIS_EXAMINATION_ENTITY_HEMODIALYSIS_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "HemodialysisMonitoringEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_HEMODIALYSIS_MONITORING_ENTITY_HEMODIALYSIS_MONITORING", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "OdontogramExaminationEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_ODONTOGRAM_EXAMINATION_ENTITY_ODONTOGRAM_EXAMINATION", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "FormulirKonselingTesHivEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_FORMULIR_KONSELING_TES_HIV_ENTITY_FORMULIR_KONSELING_TES_HIV", true, true, true, false);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "NurseVitalSignMeasurementEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_NURSE_VITAL_SIGN_MEASUREMENT_ENTITY_NURSE_VITAL_SIGN_MEASUREMENT", true, true, true, true);
		createOrUpdatePrivilege(medicalTranscriberUserRoleEntity, "ServiceFacilityCategoryEntity",
		"ROLE_MEDICAL_TRANSCRIBER_USER_SERVICE_FACILITY_CATEGORY_ENTITY_SERVICE_FACILITY_CATEGORY", true, true, true, true);
		roleRepository.save(medicalTranscriberUserRoleEntity);

		// % protected region % [Override the setup here] end
		// % protected region % [Add additional custom logic for the role setup] off begin
		// % protected region % [Add additional custom logic for the role setup] end
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
