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

import kmsweb.entities.PrivilegeEntity;
import kmsweb.entities.RoleEntity;

import java.util.UUID;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Helper class for managing the roles and privileges that are restricted in {@link kmsweb.configs.security.SecurityConfig}
 */
public class RoleAndPrivilegeHelper {

	/**
	 * Create a privilege for the role
	 * If privilege is already exists, create a new one
	 *
	 * @param roleEntity    Related role entity
	 * @param entityName    Name of target entity
	 * @param privilegeName Name of the privilege entity
	 * @param allowCreate   whether allow to create
	 * @param allowRead     whether allow to read
	 * @param allowUpdate   whether allow to update
	 * @param allowDelete   whether allow to delete
	 */
	public static void createOrUpdatePrivilege(RoleEntity roleEntity, String entityName, String privilegeName,
											   Boolean allowCreate, Boolean allowRead, Boolean allowUpdate, Boolean allowDelete) {

		PrivilegeEntity privilegeEntity = roleEntity.getPrivileges().stream()
				.filter(privilege -> privilege.getName().equals(privilegeName))
				.findFirst().orElse(null);

		if (privilegeEntity == null) {
			privilegeEntity = new PrivilegeEntity();
			privilegeEntity.setId(UUID.randomUUID());
			privilegeEntity.setName(privilegeName);
			privilegeEntity.setTargetEntity(entityName);
			roleEntity.getPrivileges().add(privilegeEntity);
		}

		privilegeEntity.setAllowCreate(allowCreate);
		privilegeEntity.setAllowRead(allowRead);
		privilegeEntity.setAllowUpdate(allowUpdate);
		privilegeEntity.setAllowDelete(allowDelete);
	}

	public static final String[] APPLICATION_ENTITY_NAMES = {
			"AdministrationUserEntity",
			"AdministratorEntity",
			"AmendmentDetailEntity",
			"BpjsAccidentMasterEntity",
			"BpjsBedAvailabilityEntity",
			"BpjsClaimDataEntity",
			"BpjsClaimSubmissionEntity",
			"BpjsControlPlanEntity",
			"BpjsControlSpecialistEntity",
			"BpjsDiagnoseEntity",
			"BpjsDiagnosePRBEntity",
			"BpjsDismissalConditionEntity",
			"BpjsDismissalMappingEntity",
			"BpjsDoctorMappingEntity",
			"BpjsDoctorScheduleEntity",
			"BpjsDrugGenericPRBEntity",
			"BpjsFacilityListEntity",
			"BpjsFingerPrintEntity",
			"BpjsGeneralEntity",
			"BpjsHealthFacilityEntity",
			"BpjsHospitalizationPlanEntity",
			"BpjsINACBGEntity",
			"BpjsINACBGClaimEntity",
			"BpjsINACBGVariableEntity",
			"BpjsJasaRaharjaEntity",
			"BpjsJasaRaharjaClaimEntity",
			"BpjsListFingerPrintEntity",
			"BpjsListTaskEntity",
			"BpjsOutsideFacilityReferralEntity",
			"BpjsPRBEntity",
			"BpjsPRBDetailEntity",
			"BpjsPatientReferralEntity",
			"BpjsPcareDPHOEntity",
			"BpjsPcareKegiatanKelompokEntity",
			"BpjsPcareKesadaranEntity",
			"BpjsPcarePesertaKegiatanKelompokEntity",
			"BpjsPcarePoliEntity",
			"BpjsPcareProviderRayonisasiEntity",
			"BpjsPcareRegistrationsEntity",
			"BpjsProcedureEntity",
			"BpjsReferralSpecialistEntity",
			"BpjsSEPEntity",
			"BpjsSEPINACBGIntegrationEntity",
			"BpjsSEPInternalDataEntity",
			"BpjsSEPSubmissionEntity",
			"BpjsSearchControlLetterEntity",
			"BpjsSearchSEPEntity",
			"BpjsServiceMappingEntity",
			"BpjsSpecialReferralEntity",
			"BpjsTotalReferralSEPEntity",
			"BpjsTreatmentClassMappingEntity",
			"BpjsTreatmentHistoryEntity",
			"BpjsTreatmentRoomEntity",
			"BpjsUpdateDismissalDateEntity",
			"BpjsVisitDataEntity",
			"BatchStockBalanceEntity",
			"BatchStockBalancePerDateEntity",
			"BatchStockTransactionDetailEntity",
			"BedFacilityEntity",
			"BedReserveEntity",
			"BirthHistoryEntity",
			"BodyChartExaminationEntity",
			"BpjsPcareKunjunganRujukanEntity",
			"BpjsPcarePendaftaranEntity",
			"BpjsPcareRiwayatKunjunganEntity",
			"CashAllocationEntity",
			"CashReceiptEntity",
			"CashRefundEntity",
			"CashierUserEntity",
			"CatalogueMedicalEntity",
			"CatalogueNonMedicalEntity",
			"CatalogueUOMEntity",
			"ChartOfAccountEntity",
			"ChartOfAccountMappingEntity",
			"ClaimUserEntity",
			"CoTreatingDoctorEntity",
			"CompoundPrescriptionDetailEntity",
			"CompoundPrescriptionItemEntity",
			"DailyCareCPPTEntity",
			"DeliveryMedicalExaminationRecordEntity",
			"DeliveryProgressEntity",
			"DiagnosesAndProceduresEntity",
			"DiagnosisExaminationRecordEntity",
			"DiagnosisNandaEntity",
			"DiagnosticExaminationResultsEntity",
			"DiagnosticStaffExaminationSummaryEntity",
			"DiagnosticSupportGeneralConfigurationEntity",
			"DiagnosticSupportUserEntity",
			"DoctorScheduleEntity",
			"DoctorUserEntity",
			"EntExaminationEntity",
			"EmergencyMedicalExaminationRecordEntity",
			"ExaminationGroupEntity",
			"ExaminationItemEntity",
			"ExaminationItemDetailEntity",
			"FacilityHistoryEntity",
			"FacilityUserEntity",
			"FluidBalanceDetailEntity",
			"FormulirKonselingTesHivEntity",
			"GoodsReceiveNoteEntity",
			"GoodsReceiveNoteBatchEntity",
			"GoodsReceiveNoteItemEntity",
			"HealthFacilityEntity",
			"HemodialysisExaminationEntity",
			"HemodialysisMonitoringEntity",
			"HospitalBranchInformationEntity",
			"HospitalGroupInformationEntity",
			"Icd10Entity",
			"Icd9CMEntity",
			"InformedConsentEntity",
			"InpatientMedicalExaminationRecordEntity",
			"InsuranceBenefitPlanEntity",
			"InsuranceProviderEntity",
			"InternalOrderEntity",
			"InternalOrderStockDetailEntity",
			"IntraoperativeRecordsEntity",
			"InventoryAdjusmentBatchEntity",
			"InventoryAdjustmentEntity",
			"InventoryAdjustmentItemEntity",
			"InventoryBatchCorrectionEntity",
			"InventoryBatchCorrectionItemEntity",
			"InvoiceEntity",
			"InvoiceItemEntity",
			"InvoiceItemComponentEntity",
			"InvoicePaymentInsuranceEntity",
			"InvoicePaymentOtherEntity",
			"InvoicePaymentSelfPayingEntity",
			"InvoiceSummaryEntity",
			"JournalEntity",
			"LibraryEntity",
			"LocationEntity",
			"McuPackageEntity",
			"McuPackageItemEntity",
			"ManagementUserEntity",
			"MedicalCertificateDischargeResumeEntity",
			"MedicalCertificateBirthEntity",
			"MedicalCertificateHospitalizationEntity",
			"MedicalCertificateMedicalAttendanceEntity",
			"MedicalCertificateMentalHealthEntity",
			"MedicalCertificatePhysicalHealthEntity",
			"MedicalCertificateRestrictedWorkEntity",
			"MedicalCertificateSickLeaveEntity",
			"MedicalExaminationRecordEntity",
			"MedicalExaminationRecordDischargeSummaryEntity",
			"MedicalFeeEntity",
			"MedicalFeeItemComponentEntity",
			"MedicalRecordInitialChecklistEntity",
			"MedicalRecordNextVerificationChecklistEntity",
			"MedicalRecordUserEntity",
			"MedicalTranscriberUserEntity",
			"MedicationAdministeredHistoryEntity",
			"MedicationCompoundEntity",
			"MedicationHeaderEntity",
			"MedicationItemEntity",
			"MerchantEntity",
			"MerchantSurchargeAndFeeEntity",
			"NhisClaimEntity",
			"NhisClaimGDRGDetailEntity",
			"NhisClaimInvestigationDetailEntity",
			"NhisGDRGEntity",
			"NhisInvestigationEntity",
			"NhisMedicineEntity",
			"NhisServiceOutcomeEntity",
			"NhisSpecialtyAttendedEntity",
			"NhisTypeOfServiceEntity",
			"NewbornDetailEntity",
			"NumberingSetupEntity",
			"NurseUserEntity",
			"NurseVitalSignMeasurementEntity",
			"ObstetricAndGynecologyHistoryEntity",
			"OdontogramExaminationEntity",
			"OperatingTheaterMedicalExaminationRecordEntity",
			"OphthalmologyExaminationEntity",
			"PcareActionExaminationEntity",
			"PcareClubProlanisEntity",
			"PcareCompoundDrugEntity",
			"PcareCompoundDrugItemEntity",
			"PcareDiagnosaEntity",
			"PcareDokterEntity",
			"PcareExaminationEntity",
			"PcareMCUEntity",
			"PcareNonCompoundDrugEntity",
			"PcareReferensiSaranaEntity",
			"PcareStatusPulangEntity",
			"PcareTindakanEntity",
			"PcareUmumEntity",
			"PatientCaseHistoryEntity",
			"PatientConsentEntity",
			"PatientContactInfoEntity",
			"PatientDetailEntity",
			"PatientDetailAddressEntity",
			"PatientEmergencyContactDetailEntity",
			"PatientEmploymentDetailEntity",
			"PatientGeneralInfoEntity",
			"PatientPaymentSelfPayingEntity",
			"PatientPaymentBPJSEntity",
			"PatientPaymentInsuranceEntity",
			"PatientPaymentOthersEntity",
			"PatientPersonalInfoEntity",
			"PatientSupportingDocumentEntity",
			"PatientVisitEntity",
			"PatientVisitPatientPaymentInsuranceEntity",
			"PatientVisitPatientPaymentOthersEntity",
			"PatientVisitPaymentSelfPayingEntity",
			"PatientVitalInformationEntity",
			"PharmacySetupEntity",
			"PharmacyUserEntity",
			"PostOperativeDetailsEntity",
			"PreoperativeRecordsEntity",
			"PrescriptionCompoundEntity",
			"PrescriptionHeaderEntity",
			"PrescriptionItemEntity",
			"PriceComponentEntity",
			"PrivilegeEntity",
			"ProcessWorkflowEntity",
			"PurchaseOrderEntity",
			"PurchaseOrderStockDetailEntity",
			"PurchaseRequisitionEntity",
			"PurchaseRequisitionStockDetailEntity",
			"PurchasingUserEntity",
			"ReferenceDataEntity",
			"ReferenceHeaderEntity",
			"RegistrationEntity",
			"RegistrationUserEntity",
			"RetailPharmacyEntity",
			"RetailPharmacyInvoiceEntity",
			"RetailPharmacyStockDetailEntity",
			"ReturnSupplierEntity",
			"ReturnSupplierStockDetailEntity",
			"RoleEntity",
			"RoomFacilityEntity",
			"RoomTransferEntity",
			"SepEntity",
			"SampleCollectionInformationEntity",
			"SampleCollectionItemsEntity",
			"SatuSehatConfigurationEntity",
			"ServiceEntity",
			"ServiceFacilityCategoryEntity",
			"ServiceItemEntity",
			"ServiceItemAssignmentEntity",
			"StaffEntity",
			"StockCatalogueEntity",
			"StockControlEntity",
			"StockTransactionDetailEntity",
			"StockTransactionPerDateEntity",
			"StockTransactionPerDateTypeEntity",
			"SupplierEntity",
			"SupplierBankAccountEntity",
			"SupplierContactDetailEntity",
			"SupplierProductDetailEntity",
			"SystemAdminUserEntity",
			"TariffDefinitionEntity",
			"TariffDefinitionOtherComponentEntity",
			"TariffFormulaEntity",
			"TariffPackageEntity",
			"TariffPackageItemEntity",
			"TariffPackageServiceAssignmentEntity",
			"TariffSchemaEntity",
			"TaskDashboardEntity",
			"TransactionDetailTypeEntity",
			"TransactionDetailTypeMappingEntity",
			"TransferOrderEntity",
			"TransferOrderStockDetailEntity",
			"UnitOfMeasurementEntity",
			"UserEntity",
			"VaccinationOrderEntity",
			"VaccinationOrderDetailEntity",
			"VitalSignsEntity",
			"WarehouseEntity",
			"WarehouseInitialStockEntity",
			"WarehouseInventoryEntity",
			"WarehouseUserEntity",
	};

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}


