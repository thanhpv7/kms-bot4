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
package kmsweb.inject.injector;

import kmsweb.inject.modules.*;
import kmsweb.inject.modules.entities.*;
import com.google.inject.Injector;
import com.netflix.governator.guice.LifecycleInjector;
import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;
import lombok.extern.slf4j.Slf4j;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Custom injector source with all related modules.
 *
 * @see <a href="https://stackoverflow.com/questions/12404434/configuring-cucumber-guice">Cucumber Guice</a>
 */
@Slf4j
public class CustomInjectorSource implements InjectorSource {
	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Override
	public Injector getInjector() {
		log.trace("Creating new injector source");

		// % protected region % [Add any additional logic for getInjector before the main body here] off begin
		// % protected region % [Add any additional logic for getInjector before the main body here] end

		Injector injector = LifecycleInjector.builder()
				.withBootstrapModule(new CustomBootstrapModule())
				.withModules(
						new BaseModule(),
						new AdministrationUserModule(),
						new AdministratorModule(),
						new AmendmentDetailModule(),
						new BpjsAccidentMasterModule(),
						new BpjsBedAvailabilityModule(),
						new BpjsClaimDataModule(),
						new BpjsClaimSubmissionModule(),
						new BpjsControlPlanModule(),
						new BpjsControlSpecialistModule(),
						new BpjsDiagnoseModule(),
						new BpjsDiagnosePRBModule(),
						new BpjsDismissalConditionModule(),
						new BpjsDismissalMappingModule(),
						new BpjsDoctorMappingModule(),
						new BpjsDoctorScheduleModule(),
						new BpjsDrugGenericPRBModule(),
						new BpjsFacilityListModule(),
						new BpjsFingerPrintModule(),
						new BpjsGeneralModule(),
						new BpjsHealthFacilityModule(),
						new BpjsHospitalizationPlanModule(),
						new BpjsINACBGModule(),
						new BpjsINACBGClaimModule(),
						new BpjsINACBGVariableModule(),
						new BpjsJasaRaharjaModule(),
						new BpjsJasaRaharjaClaimModule(),
						new BpjsListFingerPrintModule(),
						new BpjsListTaskModule(),
						new BpjsOutsideFacilityReferralModule(),
						new BpjsPRBModule(),
						new BpjsPRBDetailModule(),
						new BpjsPatientReferralModule(),
						new BpjsPcareDPHOModule(),
						new BpjsPcareKegiatanKelompokModule(),
						new BpjsPcareKesadaranModule(),
						new BpjsPcarePesertaKegiatanKelompokModule(),
						new BpjsPcarePoliModule(),
						new BpjsPcareProviderRayonisasiModule(),
						new BpjsPcareRegistrationsModule(),
						new BpjsProcedureModule(),
						new BpjsReferralSpecialistModule(),
						new BpjsSEPModule(),
						new BpjsSEPINACBGIntegrationModule(),
						new BpjsSEPInternalDataModule(),
						new BpjsSEPSubmissionModule(),
						new BpjsSearchControlLetterModule(),
						new BpjsSearchSEPModule(),
						new BpjsServiceMappingModule(),
						new BpjsSpecialReferralModule(),
						new BpjsTotalReferralSEPModule(),
						new BpjsTreatmentClassMappingModule(),
						new BpjsTreatmentHistoryModule(),
						new BpjsTreatmentRoomModule(),
						new BpjsUpdateDismissalDateModule(),
						new BpjsVisitDataModule(),
						new BatchStockBalanceModule(),
						new BatchStockBalancePerDateModule(),
						new BatchStockTransactionDetailModule(),
						new BedFacilityModule(),
						new BedReserveModule(),
						new BirthHistoryModule(),
						new BodyChartExaminationModule(),
						new BpjsPcareKunjunganRujukanModule(),
						new BpjsPcarePendaftaranModule(),
						new BpjsPcareRiwayatKunjunganModule(),
						new CashAllocationModule(),
						new CashReceiptModule(),
						new CashRefundModule(),
						new CashierUserModule(),
						new CatalogueMedicalModule(),
						new CatalogueNonMedicalModule(),
						new CatalogueUOMModule(),
						new ChartOfAccountModule(),
						new ChartOfAccountMappingModule(),
						new ClaimUserModule(),
						new CoTreatingDoctorModule(),
						new CompoundPrescriptionDetailModule(),
						new CompoundPrescriptionItemModule(),
						new DailyCareCPPTModule(),
						new DeliveryMedicalExaminationRecordModule(),
						new DeliveryProgressModule(),
						new DiagnosesAndProceduresModule(),
						new DiagnosisExaminationRecordModule(),
						new DiagnosisNandaModule(),
						new DiagnosticExaminationResultsModule(),
						new DiagnosticStaffExaminationSummaryModule(),
						new DiagnosticSupportGeneralConfigurationModule(),
						new DiagnosticSupportUserModule(),
						new DoctorScheduleModule(),
						new DoctorUserModule(),
						new EntExaminationModule(),
						new EmergencyMedicalExaminationRecordModule(),
						new ExaminationGroupModule(),
						new ExaminationItemModule(),
						new ExaminationItemDetailModule(),
						new FacilityHistoryModule(),
						new FacilityUserModule(),
						new FluidBalanceDetailModule(),
						new FormulirKonselingTesHivModule(),
						new GoodsReceiveNoteModule(),
						new GoodsReceiveNoteBatchModule(),
						new GoodsReceiveNoteItemModule(),
						new HealthFacilityModule(),
						new HemodialysisExaminationModule(),
						new HemodialysisMonitoringModule(),
						new HospitalBranchInformationModule(),
						new HospitalGroupInformationModule(),
						new Icd10Module(),
						new Icd9CMModule(),
						new InformedConsentModule(),
						new InpatientMedicalExaminationRecordModule(),
						new InsuranceBenefitPlanModule(),
						new InsuranceProviderModule(),
						new InternalOrderModule(),
						new InternalOrderStockDetailModule(),
						new IntraoperativeRecordsModule(),
						new InventoryAdjusmentBatchModule(),
						new InventoryAdjustmentModule(),
						new InventoryAdjustmentItemModule(),
						new InventoryBatchCorrectionModule(),
						new InventoryBatchCorrectionItemModule(),
						new InvoiceModule(),
						new InvoiceItemModule(),
						new InvoiceItemComponentModule(),
						new InvoicePaymentInsuranceModule(),
						new InvoicePaymentOtherModule(),
						new InvoicePaymentSelfPayingModule(),
						new InvoiceSummaryModule(),
						new JournalModule(),
						new LibraryModule(),
						new LocationModule(),
						new McuPackageModule(),
						new McuPackageItemModule(),
						new ManagementUserModule(),
						new MedicalCertificateDischargeResumeModule(),
						new MedicalCertificateBirthModule(),
						new MedicalCertificateHospitalizationModule(),
						new MedicalCertificateMedicalAttendanceModule(),
						new MedicalCertificateMentalHealthModule(),
						new MedicalCertificatePhysicalHealthModule(),
						new MedicalCertificateRestrictedWorkModule(),
						new MedicalCertificateSickLeaveModule(),
						new MedicalExaminationRecordModule(),
						new MedicalExaminationRecordDischargeSummaryModule(),
						new MedicalFeeModule(),
						new MedicalFeeItemComponentModule(),
						new MedicalRecordInitialChecklistModule(),
						new MedicalRecordNextVerificationChecklistModule(),
						new MedicalRecordUserModule(),
						new MedicalTranscriberUserModule(),
						new MedicationAdministeredHistoryModule(),
						new MedicationCompoundModule(),
						new MedicationHeaderModule(),
						new MedicationItemModule(),
						new MerchantModule(),
						new MerchantSurchargeAndFeeModule(),
						new NhisClaimModule(),
						new NhisClaimGDRGDetailModule(),
						new NhisClaimInvestigationDetailModule(),
						new NhisGDRGModule(),
						new NhisInvestigationModule(),
						new NhisMedicineModule(),
						new NhisServiceOutcomeModule(),
						new NhisSpecialtyAttendedModule(),
						new NhisTypeOfServiceModule(),
						new NewbornDetailModule(),
						new NumberingSetupModule(),
						new NurseUserModule(),
						new NurseVitalSignMeasurementModule(),
						new ObstetricAndGynecologyHistoryModule(),
						new OdontogramExaminationModule(),
						new OperatingTheaterMedicalExaminationRecordModule(),
						new OphthalmologyExaminationModule(),
						new PcareActionExaminationModule(),
						new PcareClubProlanisModule(),
						new PcareCompoundDrugModule(),
						new PcareCompoundDrugItemModule(),
						new PcareDiagnosaModule(),
						new PcareDokterModule(),
						new PcareExaminationModule(),
						new PcareMCUModule(),
						new PcareNonCompoundDrugModule(),
						new PcareReferensiSaranaModule(),
						new PcareStatusPulangModule(),
						new PcareTindakanModule(),
						new PcareUmumModule(),
						new PatientCaseHistoryModule(),
						new PatientConsentModule(),
						new PatientContactInfoModule(),
						new PatientDetailModule(),
						new PatientDetailAddressModule(),
						new PatientEmergencyContactDetailModule(),
						new PatientEmploymentDetailModule(),
						new PatientGeneralInfoModule(),
						new PatientPaymentSelfPayingModule(),
						new PatientPaymentBPJSModule(),
						new PatientPaymentInsuranceModule(),
						new PatientPaymentOthersModule(),
						new PatientPersonalInfoModule(),
						new PatientSupportingDocumentModule(),
						new PatientVisitModule(),
						new PatientVisitPatientPaymentInsuranceModule(),
						new PatientVisitPatientPaymentOthersModule(),
						new PatientVisitPaymentSelfPayingModule(),
						new PatientVitalInformationModule(),
						new PharmacySetupModule(),
						new PharmacyUserModule(),
						new PostOperativeDetailsModule(),
						new PreoperativeRecordsModule(),
						new PrescriptionCompoundModule(),
						new PrescriptionHeaderModule(),
						new PrescriptionItemModule(),
						new PriceComponentModule(),
						new PrivilegeModule(),
						new ProcessWorkflowModule(),
						new PurchaseOrderModule(),
						new PurchaseOrderStockDetailModule(),
						new PurchaseRequisitionModule(),
						new PurchaseRequisitionStockDetailModule(),
						new PurchasingUserModule(),
						new ReferenceDataModule(),
						new ReferenceHeaderModule(),
						new RegistrationModule(),
						new RegistrationUserModule(),
						new RetailPharmacyModule(),
						new RetailPharmacyInvoiceModule(),
						new RetailPharmacyStockDetailModule(),
						new ReturnSupplierModule(),
						new ReturnSupplierStockDetailModule(),
						new RoleModule(),
						new RoomFacilityModule(),
						new RoomTransferModule(),
						new SepModule(),
						new SampleCollectionInformationModule(),
						new SampleCollectionItemsModule(),
						new SatuSehatConfigurationModule(),
						new ServiceModule(),
						new ServiceFacilityCategoryModule(),
						new ServiceItemModule(),
						new ServiceItemAssignmentModule(),
						new StaffModule(),
						new StockCatalogueModule(),
						new StockControlModule(),
						new StockTransactionDetailModule(),
						new StockTransactionPerDateModule(),
						new StockTransactionPerDateTypeModule(),
						new SupplierModule(),
						new SupplierBankAccountModule(),
						new SupplierContactDetailModule(),
						new SupplierProductDetailModule(),
						new SystemAdminUserModule(),
						new TariffDefinitionModule(),
						new TariffDefinitionOtherComponentModule(),
						new TariffFormulaModule(),
						new TariffPackageModule(),
						new TariffPackageItemModule(),
						new TariffPackageServiceAssignmentModule(),
						new TariffSchemaModule(),
						new TaskDashboardModule(),
						new TransactionDetailTypeModule(),
						new TransactionDetailTypeMappingModule(),
						new TransferOrderModule(),
						new TransferOrderStockDetailModule(),
						new UnitOfMeasurementModule(),
						new UserModule(),
						new VaccinationOrderModule(),
						new VaccinationOrderDetailModule(),
						new VitalSignsModule(),
						new WarehouseModule(),
						new WarehouseInitialStockModule(),
						new WarehouseInventoryModule(),
						new WarehouseUserModule(),
						CucumberModules.createScenarioModule()
				)
				.build()
				.createInjector();

		// % protected region % [Add any additional logic for getInjector after the main body here] off begin
		// % protected region % [Add any additional logic for getInjector after the main body here] end

		log.trace("Created new injector source");

		return injector;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}