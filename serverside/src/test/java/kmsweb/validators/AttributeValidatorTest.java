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

package kmsweb.validators;

import java.util.Set;
import java.util.stream.Stream;
import java.util.UUID;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kmsweb.entities.*;

import static org.junit.jupiter.api.Assertions.*;

@Tag("validation")
public class AttributeValidatorTest {

	private Validator validator;
	private MockNeat mockNeat;

	private Class getEntityClass(String entityName) throws Exception {
		switch (entityName) {
			case "AdministrationUser":
				return AdministrationUserEntity.class;
			case "Administrator":
				return AdministratorEntity.class;
			case "AmendmentDetail":
				return AmendmentDetailEntity.class;
			case "BpjsAccidentMaster":
				return BpjsAccidentMasterEntity.class;
			case "BpjsBedAvailability":
				return BpjsBedAvailabilityEntity.class;
			case "BpjsClaimData":
				return BpjsClaimDataEntity.class;
			case "BpjsClaimSubmission":
				return BpjsClaimSubmissionEntity.class;
			case "BpjsControlPlan":
				return BpjsControlPlanEntity.class;
			case "BpjsControlSpecialist":
				return BpjsControlSpecialistEntity.class;
			case "BpjsDiagnose":
				return BpjsDiagnoseEntity.class;
			case "BpjsDiagnosePRB":
				return BpjsDiagnosePRBEntity.class;
			case "BpjsDismissalCondition":
				return BpjsDismissalConditionEntity.class;
			case "BpjsDismissalMapping":
				return BpjsDismissalMappingEntity.class;
			case "BpjsDoctorMapping":
				return BpjsDoctorMappingEntity.class;
			case "BpjsDoctorSchedule":
				return BpjsDoctorScheduleEntity.class;
			case "BpjsDrugGenericPRB":
				return BpjsDrugGenericPRBEntity.class;
			case "BpjsFacilityList":
				return BpjsFacilityListEntity.class;
			case "BpjsFingerPrint":
				return BpjsFingerPrintEntity.class;
			case "BpjsGeneral":
				return BpjsGeneralEntity.class;
			case "BpjsHealthFacility":
				return BpjsHealthFacilityEntity.class;
			case "BpjsHospitalizationPlan":
				return BpjsHospitalizationPlanEntity.class;
			case "BpjsINACBG":
				return BpjsINACBGEntity.class;
			case "BpjsINACBGClaim":
				return BpjsINACBGClaimEntity.class;
			case "BpjsINACBGVariable":
				return BpjsINACBGVariableEntity.class;
			case "BpjsJasaRaharja":
				return BpjsJasaRaharjaEntity.class;
			case "BpjsJasaRaharjaClaim":
				return BpjsJasaRaharjaClaimEntity.class;
			case "BpjsListFingerPrint":
				return BpjsListFingerPrintEntity.class;
			case "BpjsListTask":
				return BpjsListTaskEntity.class;
			case "BpjsOutsideFacilityReferral":
				return BpjsOutsideFacilityReferralEntity.class;
			case "BpjsPRB":
				return BpjsPRBEntity.class;
			case "BpjsPRBDetail":
				return BpjsPRBDetailEntity.class;
			case "BpjsPatientReferral":
				return BpjsPatientReferralEntity.class;
			case "BpjsPcareDPHO":
				return BpjsPcareDPHOEntity.class;
			case "BpjsPcareKegiatanKelompok":
				return BpjsPcareKegiatanKelompokEntity.class;
			case "BpjsPcareKesadaran":
				return BpjsPcareKesadaranEntity.class;
			case "BpjsPcarePesertaKegiatanKelompok":
				return BpjsPcarePesertaKegiatanKelompokEntity.class;
			case "BpjsPcarePoli":
				return BpjsPcarePoliEntity.class;
			case "BpjsPcareProviderRayonisasi":
				return BpjsPcareProviderRayonisasiEntity.class;
			case "BpjsPcareRegistrations":
				return BpjsPcareRegistrationsEntity.class;
			case "BpjsProcedure":
				return BpjsProcedureEntity.class;
			case "BpjsReferralSpecialist":
				return BpjsReferralSpecialistEntity.class;
			case "BpjsSEP":
				return BpjsSEPEntity.class;
			case "BpjsSEPINACBGIntegration":
				return BpjsSEPINACBGIntegrationEntity.class;
			case "BpjsSEPInternalData":
				return BpjsSEPInternalDataEntity.class;
			case "BpjsSEPSubmission":
				return BpjsSEPSubmissionEntity.class;
			case "BpjsSearchControlLetter":
				return BpjsSearchControlLetterEntity.class;
			case "BpjsSearchSEP":
				return BpjsSearchSEPEntity.class;
			case "BpjsServiceMapping":
				return BpjsServiceMappingEntity.class;
			case "BpjsSpecialReferral":
				return BpjsSpecialReferralEntity.class;
			case "BpjsTotalReferralSEP":
				return BpjsTotalReferralSEPEntity.class;
			case "BpjsTreatmentClassMapping":
				return BpjsTreatmentClassMappingEntity.class;
			case "BpjsTreatmentHistory":
				return BpjsTreatmentHistoryEntity.class;
			case "BpjsTreatmentRoom":
				return BpjsTreatmentRoomEntity.class;
			case "BpjsUpdateDismissalDate":
				return BpjsUpdateDismissalDateEntity.class;
			case "BpjsVisitData":
				return BpjsVisitDataEntity.class;
			case "BatchStockBalance":
				return BatchStockBalanceEntity.class;
			case "BatchStockBalancePerDate":
				return BatchStockBalancePerDateEntity.class;
			case "BatchStockTransactionDetail":
				return BatchStockTransactionDetailEntity.class;
			case "BedFacility":
				return BedFacilityEntity.class;
			case "BedReserve":
				return BedReserveEntity.class;
			case "BirthHistory":
				return BirthHistoryEntity.class;
			case "BodyChartExamination":
				return BodyChartExaminationEntity.class;
			case "BpjsPcareKunjunganRujukan":
				return BpjsPcareKunjunganRujukanEntity.class;
			case "BpjsPcarePendaftaran":
				return BpjsPcarePendaftaranEntity.class;
			case "BpjsPcareRiwayatKunjungan":
				return BpjsPcareRiwayatKunjunganEntity.class;
			case "CashAllocation":
				return CashAllocationEntity.class;
			case "CashReceipt":
				return CashReceiptEntity.class;
			case "CashRefund":
				return CashRefundEntity.class;
			case "CashierUser":
				return CashierUserEntity.class;
			case "CatalogueMedical":
				return CatalogueMedicalEntity.class;
			case "CatalogueNonMedical":
				return CatalogueNonMedicalEntity.class;
			case "CatalogueUOM":
				return CatalogueUOMEntity.class;
			case "ChartOfAccount":
				return ChartOfAccountEntity.class;
			case "ChartOfAccountMapping":
				return ChartOfAccountMappingEntity.class;
			case "ClaimUser":
				return ClaimUserEntity.class;
			case "CoTreatingDoctor":
				return CoTreatingDoctorEntity.class;
			case "CompoundPrescriptionDetail":
				return CompoundPrescriptionDetailEntity.class;
			case "CompoundPrescriptionItem":
				return CompoundPrescriptionItemEntity.class;
			case "DailyCareCPPT":
				return DailyCareCPPTEntity.class;
			case "DeliveryMedicalExaminationRecord":
				return DeliveryMedicalExaminationRecordEntity.class;
			case "DeliveryProgress":
				return DeliveryProgressEntity.class;
			case "DiagnosesAndProcedures":
				return DiagnosesAndProceduresEntity.class;
			case "DiagnosisExaminationRecord":
				return DiagnosisExaminationRecordEntity.class;
			case "DiagnosisNanda":
				return DiagnosisNandaEntity.class;
			case "DiagnosticExaminationResults":
				return DiagnosticExaminationResultsEntity.class;
			case "DiagnosticStaffExaminationSummary":
				return DiagnosticStaffExaminationSummaryEntity.class;
			case "DiagnosticSupportGeneralConfiguration":
				return DiagnosticSupportGeneralConfigurationEntity.class;
			case "DiagnosticSupportUser":
				return DiagnosticSupportUserEntity.class;
			case "DoctorSchedule":
				return DoctorScheduleEntity.class;
			case "DoctorUser":
				return DoctorUserEntity.class;
			case "EntExamination":
				return EntExaminationEntity.class;
			case "EmergencyMedicalExaminationRecord":
				return EmergencyMedicalExaminationRecordEntity.class;
			case "ExaminationGroup":
				return ExaminationGroupEntity.class;
			case "ExaminationItem":
				return ExaminationItemEntity.class;
			case "ExaminationItemDetail":
				return ExaminationItemDetailEntity.class;
			case "FacilityHistory":
				return FacilityHistoryEntity.class;
			case "FacilityUser":
				return FacilityUserEntity.class;
			case "FluidBalanceDetail":
				return FluidBalanceDetailEntity.class;
			case "FormulirKonselingTesHiv":
				return FormulirKonselingTesHivEntity.class;
			case "GoodsReceiveNote":
				return GoodsReceiveNoteEntity.class;
			case "GoodsReceiveNoteBatch":
				return GoodsReceiveNoteBatchEntity.class;
			case "GoodsReceiveNoteItem":
				return GoodsReceiveNoteItemEntity.class;
			case "HealthFacility":
				return HealthFacilityEntity.class;
			case "HemodialysisExamination":
				return HemodialysisExaminationEntity.class;
			case "HemodialysisMonitoring":
				return HemodialysisMonitoringEntity.class;
			case "HospitalBranchInformation":
				return HospitalBranchInformationEntity.class;
			case "HospitalGroupInformation":
				return HospitalGroupInformationEntity.class;
			case "Icd10":
				return Icd10Entity.class;
			case "Icd9CM":
				return Icd9CMEntity.class;
			case "InformedConsent":
				return InformedConsentEntity.class;
			case "InpatientMedicalExaminationRecord":
				return InpatientMedicalExaminationRecordEntity.class;
			case "InsuranceBenefitPlan":
				return InsuranceBenefitPlanEntity.class;
			case "InsuranceProvider":
				return InsuranceProviderEntity.class;
			case "InternalOrder":
				return InternalOrderEntity.class;
			case "InternalOrderStockDetail":
				return InternalOrderStockDetailEntity.class;
			case "IntraoperativeRecords":
				return IntraoperativeRecordsEntity.class;
			case "InventoryAdjusmentBatch":
				return InventoryAdjusmentBatchEntity.class;
			case "InventoryAdjustment":
				return InventoryAdjustmentEntity.class;
			case "InventoryAdjustmentItem":
				return InventoryAdjustmentItemEntity.class;
			case "InventoryBatchCorrection":
				return InventoryBatchCorrectionEntity.class;
			case "InventoryBatchCorrectionItem":
				return InventoryBatchCorrectionItemEntity.class;
			case "Invoice":
				return InvoiceEntity.class;
			case "InvoiceItem":
				return InvoiceItemEntity.class;
			case "InvoiceItemComponent":
				return InvoiceItemComponentEntity.class;
			case "InvoicePaymentInsurance":
				return InvoicePaymentInsuranceEntity.class;
			case "InvoicePaymentOther":
				return InvoicePaymentOtherEntity.class;
			case "InvoicePaymentSelfPaying":
				return InvoicePaymentSelfPayingEntity.class;
			case "InvoiceSummary":
				return InvoiceSummaryEntity.class;
			case "Journal":
				return JournalEntity.class;
			case "Library":
				return LibraryEntity.class;
			case "Location":
				return LocationEntity.class;
			case "McuPackage":
				return McuPackageEntity.class;
			case "McuPackageItem":
				return McuPackageItemEntity.class;
			case "ManagementUser":
				return ManagementUserEntity.class;
			case "MedicalCertificateDischargeResume":
				return MedicalCertificateDischargeResumeEntity.class;
			case "MedicalCertificateBirth":
				return MedicalCertificateBirthEntity.class;
			case "MedicalCertificateHospitalization":
				return MedicalCertificateHospitalizationEntity.class;
			case "MedicalCertificateMedicalAttendance":
				return MedicalCertificateMedicalAttendanceEntity.class;
			case "MedicalCertificateMentalHealth":
				return MedicalCertificateMentalHealthEntity.class;
			case "MedicalCertificatePhysicalHealth":
				return MedicalCertificatePhysicalHealthEntity.class;
			case "MedicalCertificateRestrictedWork":
				return MedicalCertificateRestrictedWorkEntity.class;
			case "MedicalCertificateSickLeave":
				return MedicalCertificateSickLeaveEntity.class;
			case "MedicalExaminationRecord":
				return MedicalExaminationRecordEntity.class;
			case "MedicalExaminationRecordDischargeSummary":
				return MedicalExaminationRecordDischargeSummaryEntity.class;
			case "MedicalFee":
				return MedicalFeeEntity.class;
			case "MedicalFeeItemComponent":
				return MedicalFeeItemComponentEntity.class;
			case "MedicalRecordInitialChecklist":
				return MedicalRecordInitialChecklistEntity.class;
			case "MedicalRecordNextVerificationChecklist":
				return MedicalRecordNextVerificationChecklistEntity.class;
			case "MedicalRecordUser":
				return MedicalRecordUserEntity.class;
			case "MedicalTranscriberUser":
				return MedicalTranscriberUserEntity.class;
			case "MedicationAdministeredHistory":
				return MedicationAdministeredHistoryEntity.class;
			case "MedicationCompound":
				return MedicationCompoundEntity.class;
			case "MedicationHeader":
				return MedicationHeaderEntity.class;
			case "MedicationItem":
				return MedicationItemEntity.class;
			case "Merchant":
				return MerchantEntity.class;
			case "MerchantSurchargeAndFee":
				return MerchantSurchargeAndFeeEntity.class;
			case "NhisClaim":
				return NhisClaimEntity.class;
			case "NhisClaimGDRGDetail":
				return NhisClaimGDRGDetailEntity.class;
			case "NhisClaimInvestigationDetail":
				return NhisClaimInvestigationDetailEntity.class;
			case "NhisGDRG":
				return NhisGDRGEntity.class;
			case "NhisInvestigation":
				return NhisInvestigationEntity.class;
			case "NhisMedicine":
				return NhisMedicineEntity.class;
			case "NhisServiceOutcome":
				return NhisServiceOutcomeEntity.class;
			case "NhisSpecialtyAttended":
				return NhisSpecialtyAttendedEntity.class;
			case "NhisTypeOfService":
				return NhisTypeOfServiceEntity.class;
			case "NewbornDetail":
				return NewbornDetailEntity.class;
			case "NumberingSetup":
				return NumberingSetupEntity.class;
			case "NurseUser":
				return NurseUserEntity.class;
			case "NurseVitalSignMeasurement":
				return NurseVitalSignMeasurementEntity.class;
			case "ObstetricAndGynecologyHistory":
				return ObstetricAndGynecologyHistoryEntity.class;
			case "OdontogramExamination":
				return OdontogramExaminationEntity.class;
			case "OperatingTheaterMedicalExaminationRecord":
				return OperatingTheaterMedicalExaminationRecordEntity.class;
			case "OphthalmologyExamination":
				return OphthalmologyExaminationEntity.class;
			case "PcareActionExamination":
				return PcareActionExaminationEntity.class;
			case "PcareClubProlanis":
				return PcareClubProlanisEntity.class;
			case "PcareCompoundDrug":
				return PcareCompoundDrugEntity.class;
			case "PcareCompoundDrugItem":
				return PcareCompoundDrugItemEntity.class;
			case "PcareDiagnosa":
				return PcareDiagnosaEntity.class;
			case "PcareDokter":
				return PcareDokterEntity.class;
			case "PcareExamination":
				return PcareExaminationEntity.class;
			case "PcareMCU":
				return PcareMCUEntity.class;
			case "PcareNonCompoundDrug":
				return PcareNonCompoundDrugEntity.class;
			case "PcareReferensiSarana":
				return PcareReferensiSaranaEntity.class;
			case "PcareStatusPulang":
				return PcareStatusPulangEntity.class;
			case "PcareTindakan":
				return PcareTindakanEntity.class;
			case "PcareUmum":
				return PcareUmumEntity.class;
			case "PatientCaseHistory":
				return PatientCaseHistoryEntity.class;
			case "PatientConsent":
				return PatientConsentEntity.class;
			case "PatientContactInfo":
				return PatientContactInfoEntity.class;
			case "PatientDetail":
				return PatientDetailEntity.class;
			case "PatientDetailAddress":
				return PatientDetailAddressEntity.class;
			case "PatientEmergencyContactDetail":
				return PatientEmergencyContactDetailEntity.class;
			case "PatientEmploymentDetail":
				return PatientEmploymentDetailEntity.class;
			case "PatientGeneralInfo":
				return PatientGeneralInfoEntity.class;
			case "PatientPaymentSelfPaying":
				return PatientPaymentSelfPayingEntity.class;
			case "PatientPaymentBPJS":
				return PatientPaymentBPJSEntity.class;
			case "PatientPaymentInsurance":
				return PatientPaymentInsuranceEntity.class;
			case "PatientPaymentOthers":
				return PatientPaymentOthersEntity.class;
			case "PatientPersonalInfo":
				return PatientPersonalInfoEntity.class;
			case "PatientSupportingDocument":
				return PatientSupportingDocumentEntity.class;
			case "PatientVisit":
				return PatientVisitEntity.class;
			case "PatientVisitPatientPaymentInsurance":
				return PatientVisitPatientPaymentInsuranceEntity.class;
			case "PatientVisitPatientPaymentOthers":
				return PatientVisitPatientPaymentOthersEntity.class;
			case "PatientVisitPaymentSelfPaying":
				return PatientVisitPaymentSelfPayingEntity.class;
			case "PatientVitalInformation":
				return PatientVitalInformationEntity.class;
			case "PharmacySetup":
				return PharmacySetupEntity.class;
			case "PharmacyUser":
				return PharmacyUserEntity.class;
			case "PostOperativeDetails":
				return PostOperativeDetailsEntity.class;
			case "PreoperativeRecords":
				return PreoperativeRecordsEntity.class;
			case "PrescriptionCompound":
				return PrescriptionCompoundEntity.class;
			case "PrescriptionHeader":
				return PrescriptionHeaderEntity.class;
			case "PrescriptionItem":
				return PrescriptionItemEntity.class;
			case "PriceComponent":
				return PriceComponentEntity.class;
			case "Privilege":
				return PrivilegeEntity.class;
			case "ProcessWorkflow":
				return ProcessWorkflowEntity.class;
			case "PurchaseOrder":
				return PurchaseOrderEntity.class;
			case "PurchaseOrderStockDetail":
				return PurchaseOrderStockDetailEntity.class;
			case "PurchaseRequisition":
				return PurchaseRequisitionEntity.class;
			case "PurchaseRequisitionStockDetail":
				return PurchaseRequisitionStockDetailEntity.class;
			case "PurchasingUser":
				return PurchasingUserEntity.class;
			case "ReferenceData":
				return ReferenceDataEntity.class;
			case "ReferenceHeader":
				return ReferenceHeaderEntity.class;
			case "Registration":
				return RegistrationEntity.class;
			case "RegistrationUser":
				return RegistrationUserEntity.class;
			case "RetailPharmacy":
				return RetailPharmacyEntity.class;
			case "RetailPharmacyInvoice":
				return RetailPharmacyInvoiceEntity.class;
			case "RetailPharmacyStockDetail":
				return RetailPharmacyStockDetailEntity.class;
			case "ReturnSupplier":
				return ReturnSupplierEntity.class;
			case "ReturnSupplierStockDetail":
				return ReturnSupplierStockDetailEntity.class;
			case "Role":
				return RoleEntity.class;
			case "RoomFacility":
				return RoomFacilityEntity.class;
			case "RoomTransfer":
				return RoomTransferEntity.class;
			case "Sep":
				return SepEntity.class;
			case "SampleCollectionInformation":
				return SampleCollectionInformationEntity.class;
			case "SampleCollectionItems":
				return SampleCollectionItemsEntity.class;
			case "SatuSehatConfiguration":
				return SatuSehatConfigurationEntity.class;
			case "Service":
				return ServiceEntity.class;
			case "ServiceFacilityCategory":
				return ServiceFacilityCategoryEntity.class;
			case "ServiceItem":
				return ServiceItemEntity.class;
			case "ServiceItemAssignment":
				return ServiceItemAssignmentEntity.class;
			case "Staff":
				return StaffEntity.class;
			case "StockCatalogue":
				return StockCatalogueEntity.class;
			case "StockControl":
				return StockControlEntity.class;
			case "StockTransactionDetail":
				return StockTransactionDetailEntity.class;
			case "StockTransactionPerDate":
				return StockTransactionPerDateEntity.class;
			case "StockTransactionPerDateType":
				return StockTransactionPerDateTypeEntity.class;
			case "Supplier":
				return SupplierEntity.class;
			case "SupplierBankAccount":
				return SupplierBankAccountEntity.class;
			case "SupplierContactDetail":
				return SupplierContactDetailEntity.class;
			case "SupplierProductDetail":
				return SupplierProductDetailEntity.class;
			case "SystemAdminUser":
				return SystemAdminUserEntity.class;
			case "TariffDefinition":
				return TariffDefinitionEntity.class;
			case "TariffDefinitionOtherComponent":
				return TariffDefinitionOtherComponentEntity.class;
			case "TariffFormula":
				return TariffFormulaEntity.class;
			case "TariffPackage":
				return TariffPackageEntity.class;
			case "TariffPackageItem":
				return TariffPackageItemEntity.class;
			case "TariffPackageServiceAssignment":
				return TariffPackageServiceAssignmentEntity.class;
			case "TariffSchema":
				return TariffSchemaEntity.class;
			case "TaskDashboard":
				return TaskDashboardEntity.class;
			case "TransactionDetailType":
				return TransactionDetailTypeEntity.class;
			case "TransactionDetailTypeMapping":
				return TransactionDetailTypeMappingEntity.class;
			case "TransferOrder":
				return TransferOrderEntity.class;
			case "TransferOrderStockDetail":
				return TransferOrderStockDetailEntity.class;
			case "UnitOfMeasurement":
				return UnitOfMeasurementEntity.class;
			case "User":
				return UserEntity.class;
			case "VaccinationOrder":
				return VaccinationOrderEntity.class;
			case "VaccinationOrderDetail":
				return VaccinationOrderDetailEntity.class;
			case "VitalSigns":
				return VitalSignsEntity.class;
			case "Warehouse":
				return WarehouseEntity.class;
			case "WarehouseInitialStock":
				return WarehouseInitialStockEntity.class;
			case "WarehouseInventory":
				return WarehouseInventoryEntity.class;
			case "WarehouseUser":
				return WarehouseUserEntity.class;
			default:
				throw new Exception(entityName + "must be a valid entity");
		}
	}

	private String getAlphanumericString(int length) {
		return mockNeat.strings().size(length).type(StringType.valueOf("ALPHA_NUMERIC")).get();
	}

	@BeforeEach
	void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		//Multiple options are available for instantiating MockNeat.  MockNeat.threadLocal() is recommended in the docs
		mockNeat = MockNeat.threadLocal();
	}

	private static Stream<Arguments> requiredValidators() {
		return Stream.of(
				Arguments.of("AmendmentDetail", "reason"),
				Arguments.of("BpjsDismissalMapping", "refCode"),
				Arguments.of("BpjsDismissalMapping", "refName"),
				Arguments.of("BpjsDismissalMapping", "internalDismissal"),
				Arguments.of("BpjsDoctorMapping", "refCode"),
				Arguments.of("BpjsDoctorMapping", "bpjsMedicalStaff"),
				Arguments.of("BpjsGeneral", "consID"),
				Arguments.of("BpjsGeneral", "secretKey"),
				Arguments.of("BpjsGeneral", "bpjsWebServiceURL"),
				Arguments.of("BpjsGeneral", "aplicareWebServiceURL"),
				Arguments.of("BpjsGeneral", "healthFacilityCode"),
				Arguments.of("BpjsGeneral", "healthFacilityName"),
				Arguments.of("BpjsINACBG", "healthFacilityCode"),
				Arguments.of("BpjsINACBG", "healthFacilityName"),
				Arguments.of("BpjsINACBG", "address"),
				Arguments.of("BpjsINACBG", "stateProvince"),
				Arguments.of("BpjsINACBG", "cityRegency"),
				Arguments.of("BpjsINACBG", "regional"),
				Arguments.of("BpjsINACBG", "hospitalClass"),
				Arguments.of("BpjsINACBG", "inacbgTariff1"),
				Arguments.of("BpjsINACBG", "inacbgTariff2"),
				Arguments.of("BpjsINACBG", "additionalUpgradeVIP"),
				Arguments.of("BpjsINACBG", "payplanID"),
				Arguments.of("BpjsINACBG", "paymentPlanCode"),
				Arguments.of("BpjsINACBG", "tariffCode"),
				Arguments.of("BpjsINACBG", "url"),
				Arguments.of("BpjsINACBG", "username"),
				Arguments.of("BpjsINACBG", "password"),
				Arguments.of("BpjsINACBG", "secretKey"),
				Arguments.of("BpjsINACBG", "coderID"),
				Arguments.of("BpjsINACBGVariable", "variableCode"),
				Arguments.of("BpjsINACBGVariable", "english"),
				Arguments.of("BpjsINACBGVariable", "indonesian"),
				Arguments.of("BpjsINACBGVariable", "notes"),
				Arguments.of("BpjsTreatmentClassMapping", "refCode"),
				Arguments.of("BpjsTreatmentClassMapping", "refName"),
				Arguments.of("BpjsTreatmentClassMapping", "internalTreatmentClass"),
				Arguments.of("BedFacility", "bedNumber"),
				Arguments.of("BedFacility", "bedName"),
				Arguments.of("BedFacility", "treatmentClass"),
				Arguments.of("BedFacility", "availability"),
				Arguments.of("CashReceipt", "receiptType"),
				Arguments.of("CashReceipt", "paymentDate"),
				Arguments.of("CashReceipt", "cashierLocation"),
				Arguments.of("CashRefund", "refundDate"),
				Arguments.of("CashRefund", "cashierLocation"),
				Arguments.of("DailyCareCPPT", "subjective"),
				Arguments.of("DailyCareCPPT", "objective"),
				Arguments.of("DailyCareCPPT", "diagnose"),
				Arguments.of("DailyCareCPPT", "plan"),
				Arguments.of("DailyCareCPPT", "instruction"),
				Arguments.of("DiagnosesAndProcedures", "itemType"),
				Arguments.of("DiagnosesAndProcedures", "itemCode"),
				Arguments.of("DiagnosesAndProcedures", "description"),
				Arguments.of("DoctorSchedule", "startDateTime"),
				Arguments.of("DoctorSchedule", "endDateTime"),
				Arguments.of("DoctorSchedule", "schedulerType"),
				Arguments.of("ExaminationGroup", "diagnosticGroupCode"),
				Arguments.of("ExaminationGroup", "description"),
				Arguments.of("ExaminationItem", "itemCode"),
				Arguments.of("ExaminationItem", "description"),
				Arguments.of("ExaminationItemDetail", "ageMinimum"),
				Arguments.of("ExaminationItemDetail", "ageMaximum"),
				Arguments.of("ExaminationItemDetail", "gender"),
				Arguments.of("ExaminationItemDetail", "normalRangeLow"),
				Arguments.of("ExaminationItemDetail", "normalRangeHigh"),
				Arguments.of("ExaminationItemDetail", "unit"),
				Arguments.of("HealthFacility", "healthFacilityID"),
				Arguments.of("HealthFacility", "healthFacilityName"),
				Arguments.of("HealthFacility", "address"),
				Arguments.of("HospitalBranchInformation", "hospitalCode"),
				Arguments.of("HospitalBranchInformation", "hospitalName"),
				Arguments.of("HospitalBranchInformation", "hospitalType"),
				Arguments.of("HospitalBranchInformation", "hospitalClass"),
				Arguments.of("HospitalBranchInformation", "hospitalDirectorName"),
				Arguments.of("HospitalBranchInformation", "address"),
				Arguments.of("HospitalBranchInformation", "city"),
				Arguments.of("HospitalGroupInformation", "hospitalGroupCode"),
				Arguments.of("HospitalGroupInformation", "hospitalGroupName"),
				Arguments.of("HospitalGroupInformation", "hospitalGroupCorporationName"),
				Arguments.of("HospitalGroupInformation", "hospitalGroupDirector"),
				Arguments.of("HospitalGroupInformation", "address"),
				Arguments.of("InsuranceBenefitPlan", "benefitPlanNo"),
				Arguments.of("InsuranceProvider", "providerCode"),
				Arguments.of("InsuranceProvider", "providerName"),
				Arguments.of("InsuranceProvider", "providerType"),
				Arguments.of("InsuranceProvider", "benefitProvider"),
				Arguments.of("InsuranceProvider", "firstName"),
				Arguments.of("InsuranceProvider", "lastName"),
				Arguments.of("InventoryBatchCorrection", "transactionDate"),
				Arguments.of("InventoryBatchCorrection", "transactionType"),
				Arguments.of("Invoice", "invoiceType"),
				Arguments.of("Invoice", "invoiceDate"),
				Arguments.of("Invoice", "billingLocation"),
				Arguments.of("Invoice", "patientPaymentType"),
				Arguments.of("Location", "locationName"),
				Arguments.of("McuPackage", "mcuPackageCode"),
				Arguments.of("McuPackage", "description"),
				Arguments.of("McuPackage", "packageType"),
				Arguments.of("McuPackageItem", "itemCode"),
				Arguments.of("MedicationHeader", "medicationNumber"),
				Arguments.of("MedicationHeader", "dispensingType"),
				Arguments.of("Merchant", "merchantName"),
				Arguments.of("Merchant", "merchantNumber"),
				Arguments.of("Merchant", "bankAccount"),
				Arguments.of("MerchantSurchargeAndFee", "bankName"),
				Arguments.of("MerchantSurchargeAndFee", "cardType"),
				Arguments.of("MerchantSurchargeAndFee", "surcharge"),
				Arguments.of("MerchantSurchargeAndFee", "fee"),
				Arguments.of("PcareUmum", "consID"),
				Arguments.of("PcareUmum", "secretKey"),
				Arguments.of("PcareUmum", "webServiceURL"),
				Arguments.of("PcareUmum", "authUsername"),
				Arguments.of("PcareUmum", "authPassword"),
				Arguments.of("PcareUmum", "kodeAplikasi"),
				Arguments.of("PatientDetail", "activePatientID"),
				Arguments.of("PatientGeneralInfo", "patientID"),
				Arguments.of("PatientGeneralInfo", "givenName"),
				Arguments.of("PatientGeneralInfo", "lastName"),
				Arguments.of("PatientGeneralInfo", "placeOfBirth"),
				Arguments.of("PatientGeneralInfo", "dateOfBirth"),
				Arguments.of("PatientGeneralInfo", "address"),
				Arguments.of("PatientVisit", "visitNumber"),
				Arguments.of("PatientVisit", "visitDate"),
				Arguments.of("PatientVisit", "registrationLocation"),
				Arguments.of("PrescriptionHeader", "prescriptionNumber"),
				Arguments.of("PrescriptionHeader", "prescriptionType"),
				Arguments.of("PriceComponent", "componentCode"),
				Arguments.of("PriceComponent", "componentName"),
				Arguments.of("ReferenceData", "referenceType"),
				Arguments.of("ReferenceData", "code"),
				Arguments.of("ReferenceData", "description"),
				Arguments.of("ReferenceData", "sequence"),
				Arguments.of("ReferenceHeader", "referenceType"),
				Arguments.of("ReferenceHeader", "description"),
				Arguments.of("Registration", "registrationNumber"),
				Arguments.of("Registration", "scheduledDate"),
				Arguments.of("RoomFacility", "roomNumber"),
				Arguments.of("RoomFacility", "roomName"),
				Arguments.of("RoomFacility", "department"),
				Arguments.of("RoomFacility", "genderAllocation"),
				Arguments.of("RoomFacility", "location"),
				Arguments.of("RoomFacility", "treatmentClass"),
				Arguments.of("Service", "serviceName"),
				Arguments.of("ServiceItem", "serviceItemCode"),
				Arguments.of("ServiceItem", "serviceItemName"),
				Arguments.of("ServiceItem", "classification"),
				Arguments.of("Staff", "firstName"),
				Arguments.of("Staff", "lastName"),
				Arguments.of("Supplier", "supplierNumber"),
				Arguments.of("Supplier", "supplierName"),
				Arguments.of("Supplier", "supplyStockGroup"),
				Arguments.of("Supplier", "adress"),
				Arguments.of("Supplier", "phoneNumber"),
				Arguments.of("SupplierBankAccount", "bankName"),
				Arguments.of("SupplierBankAccount", "accountName"),
				Arguments.of("SupplierBankAccount", "accountNumber"),
				Arguments.of("TariffSchema", "schemaCode"),
				Arguments.of("TariffSchema", "schemeName"),
				Arguments.of("TariffSchema", "startDate"),
				Arguments.of("TransactionDetailType", "transactionDetail"),
				Arguments.of("UnitOfMeasurement", "unitName"),
				Arguments.of("User", "isArchived"),
				Arguments.of("VaccinationOrderDetail", "vaccinationDate"),
				Arguments.of("VaccinationOrderDetail", "vaccinationType"),
				Arguments.of("VaccinationOrderDetail", "vaccinationDetail"),
				Arguments.of("VaccinationOrderDetail", "quantity"),
				Arguments.of("Warehouse", "warehouseNumber"),
				Arguments.of("Warehouse", "warehouseName"),
				Arguments.of("Warehouse", "description"),
				Arguments.of("Warehouse", "address"),
				Arguments.of("Warehouse", "contactPerson"),
				Arguments.of("Warehouse", "phoneNumber")
		);
	}

	@ParameterizedTest(name = "Invalid Inputs to {1} attribute in {0} entity with required validator should trigger validation error")
	@MethodSource("requiredValidators")
	void testRequired(String entityName, String attributeName) throws Exception {
		assertFalse(validator.validateValue(this.getEntityClass(entityName), attributeName, null).isEmpty());
	}

	private static Stream<Arguments> lengthValidators() {
		return Stream.of(
				Arguments.of("BpjsDismissalMapping", "refCode", 25, true),
				Arguments.of("BpjsDismissalMapping", "refCode", 26, false),
				Arguments.of("BpjsDismissalMapping", "refName", 50, true),
				Arguments.of("BpjsDismissalMapping", "refName", 51, false),
				Arguments.of("BpjsDoctorMapping", "refCode", 25, true),
				Arguments.of("BpjsDoctorMapping", "refCode", 26, false),
				Arguments.of("BpjsDoctorMapping", "notes", 1000, true),
				Arguments.of("BpjsDoctorMapping", "notes", 1001, false),
				Arguments.of("BpjsGeneral", "consID", 4, true),
				Arguments.of("BpjsGeneral", "consID", 3, false),
				Arguments.of("BpjsGeneral", "consID", 15, true),
				Arguments.of("BpjsGeneral", "consID", 16, false),
				Arguments.of("BpjsGeneral", "secretKey", 25, true),
				Arguments.of("BpjsGeneral", "secretKey", 26, false),
				Arguments.of("BpjsGeneral", "healthFacilityCode", 25, true),
				Arguments.of("BpjsGeneral", "healthFacilityCode", 26, false),
				Arguments.of("BpjsGeneral", "healthFacilityName", 100, true),
				Arguments.of("BpjsGeneral", "healthFacilityName", 101, false),
				Arguments.of("BpjsINACBG", "healthFacilityCode", 25, true),
				Arguments.of("BpjsINACBG", "healthFacilityCode", 26, false),
				Arguments.of("BpjsINACBG", "healthFacilityName", 100, true),
				Arguments.of("BpjsINACBG", "healthFacilityName", 101, false),
				Arguments.of("BpjsINACBG", "stateProvince", 50, true),
				Arguments.of("BpjsINACBG", "stateProvince", 51, false),
				Arguments.of("BpjsINACBG", "cityRegency", 50, true),
				Arguments.of("BpjsINACBG", "cityRegency", 51, false),
				Arguments.of("BpjsINACBG", "regional", 50, true),
				Arguments.of("BpjsINACBG", "regional", 51, false),
				Arguments.of("BpjsINACBG", "hospitalClass", 25, true),
				Arguments.of("BpjsINACBG", "hospitalClass", 26, false),
				Arguments.of("BpjsINACBG", "inacbgTariff1", 100, true),
				Arguments.of("BpjsINACBG", "inacbgTariff1", 101, false),
				Arguments.of("BpjsINACBG", "inacbgTariff2", 100, true),
				Arguments.of("BpjsINACBG", "inacbgTariff2", 101, false),
				Arguments.of("BpjsINACBG", "additionalUpgradeVIP", 100, true),
				Arguments.of("BpjsINACBG", "additionalUpgradeVIP", 101, false),
				Arguments.of("BpjsINACBG", "payplanID", 100, true),
				Arguments.of("BpjsINACBG", "payplanID", 101, false),
				Arguments.of("BpjsINACBG", "paymentPlanCode", 100, true),
				Arguments.of("BpjsINACBG", "paymentPlanCode", 101, false),
				Arguments.of("BpjsINACBG", "tariffCode", 50, true),
				Arguments.of("BpjsINACBG", "tariffCode", 51, false),
				Arguments.of("BpjsINACBG", "username", 100, true),
				Arguments.of("BpjsINACBG", "username", 101, false),
				Arguments.of("BpjsINACBG", "password", 100, true),
				Arguments.of("BpjsINACBG", "password", 101, false),
				Arguments.of("BpjsINACBG", "secretKey", 225, true),
				Arguments.of("BpjsINACBG", "secretKey", 226, false),
				Arguments.of("BpjsINACBG", "coderID", 100, true),
				Arguments.of("BpjsINACBG", "coderID", 101, false),
				Arguments.of("BpjsServiceMapping", "refCode", 25, true),
				Arguments.of("BpjsServiceMapping", "refCode", 26, false),
				Arguments.of("BpjsServiceMapping", "refService", 200, true),
				Arguments.of("BpjsServiceMapping", "refService", 201, false),
				Arguments.of("BpjsTreatmentClassMapping", "refCode", 25, true),
				Arguments.of("BpjsTreatmentClassMapping", "refCode", 26, false),
				Arguments.of("BpjsTreatmentClassMapping", "refName", 50, true),
				Arguments.of("BpjsTreatmentClassMapping", "refName", 51, false),
				Arguments.of("BpjsVisitData", "jsonInsert", 5000, true),
				Arguments.of("BpjsVisitData", "jsonInsert", 5001, false),
				Arguments.of("BpjsVisitData", "jsonUpdate", 5000, true),
				Arguments.of("BpjsVisitData", "jsonUpdate", 5001, false),
				Arguments.of("CashReceipt", "description", 5000, true),
				Arguments.of("CashReceipt", "description", 5001, false),
				Arguments.of("CashRefund", "description", 5000, true),
				Arguments.of("CashRefund", "description", 5001, false),
				Arguments.of("DailyCareCPPT", "subjective", 5000, true),
				Arguments.of("DailyCareCPPT", "subjective", 5001, false),
				Arguments.of("DailyCareCPPT", "objective", 5000, true),
				Arguments.of("DailyCareCPPT", "objective", 5001, false),
				Arguments.of("DailyCareCPPT", "diagnose", 5000, true),
				Arguments.of("DailyCareCPPT", "diagnose", 5001, false),
				Arguments.of("DailyCareCPPT", "plan", 5000, true),
				Arguments.of("DailyCareCPPT", "plan", 5001, false),
				Arguments.of("DailyCareCPPT", "instruction", 5000, true),
				Arguments.of("DailyCareCPPT", "instruction", 5001, false),
				Arguments.of("DiagnosisExaminationRecord", "diagnosisNotes", 5000, true),
				Arguments.of("DiagnosisExaminationRecord", "diagnosisNotes", 5001, false),
				Arguments.of("DiagnosisExaminationRecord", "actionNotes", 5000, true),
				Arguments.of("DiagnosisExaminationRecord", "actionNotes", 5001, false),
				Arguments.of("DiagnosticExaminationResults", "result", 1000, true),
				Arguments.of("DiagnosticExaminationResults", "result", 1001, false),
				Arguments.of("HemodialysisExamination", "postHemodialysisEvaluation", 500, true),
				Arguments.of("HemodialysisExamination", "postHemodialysisEvaluation", 501, false),
				Arguments.of("Invoice", "billingLocation", 20, true),
				Arguments.of("Invoice", "billingLocation", 21, false),
				Arguments.of("Invoice", "notes", 500, true),
				Arguments.of("Invoice", "notes", 501, false),
				Arguments.of("InvoiceItem", "notes", 500, true),
				Arguments.of("InvoiceItem", "notes", 501, false),
				Arguments.of("MedicalExaminationRecord", "objective", 5000, true),
				Arguments.of("MedicalExaminationRecord", "objective", 5001, false),
				Arguments.of("MedicalExaminationRecord", "subjective", 5000, true),
				Arguments.of("MedicalExaminationRecord", "subjective", 5001, false),
				Arguments.of("MedicalExaminationRecord", "plan", 5000, true),
				Arguments.of("MedicalExaminationRecord", "plan", 5001, false),
				Arguments.of("MedicalExaminationRecord", "purpose", 5000, true),
				Arguments.of("MedicalExaminationRecord", "purpose", 5001, false),
				Arguments.of("MedicalExaminationRecord", "additionalNotes", 5000, true),
				Arguments.of("MedicalExaminationRecord", "additionalNotes", 5001, false),
				Arguments.of("MedicalExaminationRecordDischargeSummary", "objective", 5000, true),
				Arguments.of("MedicalExaminationRecordDischargeSummary", "objective", 5001, false),
				Arguments.of("MedicalExaminationRecordDischargeSummary", "subjective", 5000, true),
				Arguments.of("MedicalExaminationRecordDischargeSummary", "subjective", 5001, false),
				Arguments.of("MedicalExaminationRecordDischargeSummary", "plan", 5000, true),
				Arguments.of("MedicalExaminationRecordDischargeSummary", "plan", 5001, false),
				Arguments.of("MedicalExaminationRecordDischargeSummary", "purpose", 5000, true),
				Arguments.of("MedicalExaminationRecordDischargeSummary", "purpose", 5001, false),
				Arguments.of("MedicalExaminationRecordDischargeSummary", "additionalNotes", 5000, true),
				Arguments.of("MedicalExaminationRecordDischargeSummary", "additionalNotes", 5001, false),
				Arguments.of("PcareExamination", "catatan", 1000, true),
				Arguments.of("PcareExamination", "catatan", 1001, false),
				Arguments.of("PcareExamination", "jsoninsert", 5000, true),
				Arguments.of("PcareExamination", "jsoninsert", 5001, false),
				Arguments.of("PcareExamination", "jsonupdate", 5000, true),
				Arguments.of("PcareExamination", "jsonupdate", 5001, false),
				Arguments.of("PcareUmum", "consID", 4, true),
				Arguments.of("PcareUmum", "consID", 3, false),
				Arguments.of("PcareUmum", "consID", 15, true),
				Arguments.of("PcareUmum", "consID", 16, false),
				Arguments.of("PcareUmum", "secretKey", 25, true),
				Arguments.of("PcareUmum", "secretKey", 26, false),
				Arguments.of("SatuSehatConfiguration", "clientID", 1000, true),
				Arguments.of("SatuSehatConfiguration", "clientID", 1001, false),
				Arguments.of("SatuSehatConfiguration", "secretKey", 1000, true),
				Arguments.of("SatuSehatConfiguration", "secretKey", 1001, false),
				Arguments.of("SatuSehatConfiguration", "tokenRequest", 1000, true),
				Arguments.of("SatuSehatConfiguration", "tokenRequest", 1001, false),
				Arguments.of("User", "password", 10, true),
				Arguments.of("User", "password", 9, false),
				Arguments.of("User", "password", 255, true),
				Arguments.of("User", "password", 256, false),
				Arguments.of("Warehouse", "description", 2000, true),
				Arguments.of("Warehouse", "description", 2001, false)
		);
	}

	@ParameterizedTest(name = "Inputs to {1} attribute in {0} entity with Length validator should trigger validation error if invalid")
	@MethodSource("lengthValidators")
	void testLength(String entityName, String attributeName, int length, boolean valid) throws Exception {
		String input = mockNeat.strings().size(length).get();
		Set validationErrors = validator.validateValue(this.getEntityClass(entityName), attributeName, input);
		assertEquals(validationErrors.isEmpty(), valid);
	}

	private static Stream<Arguments> numericValidators() {
		return Stream.of(
				Arguments.of("CatalogueUOM", "conversion", null, true, true),
				Arguments.of("CatalogueUOM", "conversion", null, false, false),
				Arguments.of("Supplier", "phoneNumber", null, true, true),
				Arguments.of("Supplier", "phoneNumber", null, false, false),
				Arguments.of("Supplier", "otherPhoneNumber", null, true, true),
				Arguments.of("Supplier", "otherPhoneNumber", null, false, false),
				Arguments.of("Supplier", "fax", null, true, true),
				Arguments.of("Supplier", "fax", null, false, false),
				Arguments.of("SupplierBankAccount", "accountNumber", null, true, true),
				Arguments.of("SupplierBankAccount", "accountNumber", null, false, false),
				Arguments.of("SupplierContactDetail", "phoneNumber", null, true, true),
				Arguments.of("SupplierContactDetail", "phoneNumber", null, false, false),
				Arguments.of("SupplierContactDetail", "mobilePhoneNumber", null, true, true),
				Arguments.of("SupplierContactDetail", "mobilePhoneNumber", null, false, false),
				Arguments.of("SupplierContactDetail", "ext", null, true, true),
				Arguments.of("SupplierContactDetail", "ext", null, false, false),
				Arguments.of("Warehouse", "phoneNumber", null, true, true),
				Arguments.of("Warehouse", "phoneNumber", null, false, false),
				Arguments.of("Warehouse", "mobilePhoneNumber", null, true, true),
				Arguments.of("Warehouse", "mobilePhoneNumber", null, false, false)
		);
	}

	@ParameterizedTest(name = "Inputs to {1} attribute in {0} entity with Numeric validator should trigger validation error if invalid")
	@MethodSource("numericValidators")
	void testNumeric(String entityName, String attributeName, Integer length, boolean followNumeric, boolean valid) throws Exception {
		String input;
		if (length == null) {
			if (followNumeric) {
				input = mockNeat.strings().type(StringType.valueOf("NUMBERS")).get();
			} else {
				input = mockNeat.strings().type(StringType.valueOf("LETTERS")).get();
			}
		} else {
			if (followNumeric) {
				input = mockNeat.strings().size(length).type(StringType.valueOf("NUMBERS")).get();
			} else {
				input = mockNeat.strings().size(length).type(StringType.valueOf("LETTERS")).get();
			}
		}

		Set validationErrors = validator.validateValue(this.getEntityClass(entityName), attributeName, input);
		assertEquals(validationErrors.isEmpty(), valid);
	}

	private static Stream<Arguments> urlValidators() {
		return Stream.of(
				Arguments.of("DiagnosticSupportGeneralConfiguration", "lisWebServiceURL", true),
				Arguments.of("DiagnosticSupportGeneralConfiguration", "lisWebServiceURL", false)
		);
	}

	@ParameterizedTest(name = "Inputs to {1} attribute in {0} entity with Url validator should trigger validation error if invalid")
	@MethodSource("urlValidators")
	void testUrl(String entityName, String attributeName, boolean valid) throws Exception {
		String input;
		if (valid) {
			input = mockNeat.urls().scheme("http").get();
		} else {
			//Scheme is invalid, so string is an invalid url
			input = mockNeat.urls().scheme("hp").get();
		}
		Set validationErrors = validator.validateValue(this.getEntityClass(entityName), attributeName, input);
		assertEquals(validationErrors.isEmpty(), valid);
	}

	private static Stream<Arguments> emailValidators() {
		return Stream.of(
				Arguments.of("Supplier", "email", true),
				Arguments.of("Supplier", "email", false),
				Arguments.of("SupplierContactDetail", "email", true),
				Arguments.of("SupplierContactDetail", "email", false),
				Arguments.of("User", "username", true),
				Arguments.of("User", "username", false),
				Arguments.of("Warehouse", "email", true),
				Arguments.of("Warehouse", "email", false)
		);
	}

	@ParameterizedTest(name = "Inputs to {1} attribute in {0} entity with Email validator should trigger validation error if invalid")
	@MethodSource("emailValidators")
	void testEmail(String entityName, String attributeName, boolean valid) throws Exception {
		String input;
		if (valid) {
			input = mockNeat.emails().get();
		} else {
			input = mockNeat.strings().get();
		}
		Set validationErrors = validator.validateValue(this.getEntityClass(entityName), attributeName, input);
		assertEquals(validationErrors.isEmpty(), valid);
	}

}
