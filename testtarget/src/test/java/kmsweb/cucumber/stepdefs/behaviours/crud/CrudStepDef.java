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
package kmsweb.cucumber.stepdefs.behaviours.crud;

import kmsweb.cucumber.pom.enums.VisibilityEnum;
import kmsweb.cucumber.pom.pages.admin.crud.list.CrudList;
import kmsweb.entities.AbstractEntity;
import kmsweb.cucumber.utils.WaitUtils;
import kmsweb.cucumber.utils.WebElementUtils;
import kmsweb.entities.EntityReference;
import kmsweb.cucumber.stepdefs.AbstractStepDef;
import kmsweb.inject.factories.*;
import org.testng.Assert;
import com.google.inject.Inject;
import kmsweb.cucumber.pom.factories.AdminPageFactory;
import cucumber.runtime.java.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.TimeoutException;
import lombok.extern.slf4j.Slf4j;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Slf4j
@ScenarioScoped
public class CrudStepDef extends AbstractStepDef {

	@Inject
	private AdministrationUserEntityFactory administrationUserEntityFactory;
	@Inject
	private AdministratorEntityFactory administratorEntityFactory;
	@Inject
	private AmendmentDetailEntityFactory amendmentDetailEntityFactory;
	@Inject
	private BpjsAccidentMasterEntityFactory bpjsAccidentMasterEntityFactory;
	@Inject
	private BpjsBedAvailabilityEntityFactory bpjsBedAvailabilityEntityFactory;
	@Inject
	private BpjsClaimDataEntityFactory bpjsClaimDataEntityFactory;
	@Inject
	private BpjsClaimSubmissionEntityFactory bpjsClaimSubmissionEntityFactory;
	@Inject
	private BpjsControlPlanEntityFactory bpjsControlPlanEntityFactory;
	@Inject
	private BpjsControlSpecialistEntityFactory bpjsControlSpecialistEntityFactory;
	@Inject
	private BpjsDiagnoseEntityFactory bpjsDiagnoseEntityFactory;
	@Inject
	private BpjsDiagnosePRBEntityFactory bpjsDiagnosePRBEntityFactory;
	@Inject
	private BpjsDismissalConditionEntityFactory bpjsDismissalConditionEntityFactory;
	@Inject
	private BpjsDismissalMappingEntityFactory bpjsDismissalMappingEntityFactory;
	@Inject
	private BpjsDoctorMappingEntityFactory bpjsDoctorMappingEntityFactory;
	@Inject
	private BpjsDoctorScheduleEntityFactory bpjsDoctorScheduleEntityFactory;
	@Inject
	private BpjsDrugGenericPRBEntityFactory bpjsDrugGenericPRBEntityFactory;
	@Inject
	private BpjsFacilityListEntityFactory bpjsFacilityListEntityFactory;
	@Inject
	private BpjsFingerPrintEntityFactory bpjsFingerPrintEntityFactory;
	@Inject
	private BpjsGeneralEntityFactory bpjsGeneralEntityFactory;
	@Inject
	private BpjsHealthFacilityEntityFactory bpjsHealthFacilityEntityFactory;
	@Inject
	private BpjsHospitalizationPlanEntityFactory bpjsHospitalizationPlanEntityFactory;
	@Inject
	private BpjsINACBGEntityFactory bpjsINACBGEntityFactory;
	@Inject
	private BpjsINACBGClaimEntityFactory bpjsINACBGClaimEntityFactory;
	@Inject
	private BpjsINACBGVariableEntityFactory bpjsINACBGVariableEntityFactory;
	@Inject
	private BpjsJasaRaharjaEntityFactory bpjsJasaRaharjaEntityFactory;
	@Inject
	private BpjsJasaRaharjaClaimEntityFactory bpjsJasaRaharjaClaimEntityFactory;
	@Inject
	private BpjsListFingerPrintEntityFactory bpjsListFingerPrintEntityFactory;
	@Inject
	private BpjsListTaskEntityFactory bpjsListTaskEntityFactory;
	@Inject
	private BpjsOutsideFacilityReferralEntityFactory bpjsOutsideFacilityReferralEntityFactory;
	@Inject
	private BpjsPRBEntityFactory bpjsPRBEntityFactory;
	@Inject
	private BpjsPRBDetailEntityFactory bpjsPRBDetailEntityFactory;
	@Inject
	private BpjsPatientReferralEntityFactory bpjsPatientReferralEntityFactory;
	@Inject
	private BpjsPcareDPHOEntityFactory bpjsPcareDPHOEntityFactory;
	@Inject
	private BpjsPcareKegiatanKelompokEntityFactory bpjsPcareKegiatanKelompokEntityFactory;
	@Inject
	private BpjsPcareKesadaranEntityFactory bpjsPcareKesadaranEntityFactory;
	@Inject
	private BpjsPcarePesertaKegiatanKelompokEntityFactory bpjsPcarePesertaKegiatanKelompokEntityFactory;
	@Inject
	private BpjsPcarePoliEntityFactory bpjsPcarePoliEntityFactory;
	@Inject
	private BpjsPcareProviderRayonisasiEntityFactory bpjsPcareProviderRayonisasiEntityFactory;
	@Inject
	private BpjsPcareRegistrationsEntityFactory bpjsPcareRegistrationsEntityFactory;
	@Inject
	private BpjsProcedureEntityFactory bpjsProcedureEntityFactory;
	@Inject
	private BpjsReferralSpecialistEntityFactory bpjsReferralSpecialistEntityFactory;
	@Inject
	private BpjsSEPEntityFactory bpjsSEPEntityFactory;
	@Inject
	private BpjsSEPINACBGIntegrationEntityFactory bpjsSEPINACBGIntegrationEntityFactory;
	@Inject
	private BpjsSEPInternalDataEntityFactory bpjsSEPInternalDataEntityFactory;
	@Inject
	private BpjsSEPSubmissionEntityFactory bpjsSEPSubmissionEntityFactory;
	@Inject
	private BpjsSearchControlLetterEntityFactory bpjsSearchControlLetterEntityFactory;
	@Inject
	private BpjsSearchSEPEntityFactory bpjsSearchSEPEntityFactory;
	@Inject
	private BpjsServiceMappingEntityFactory bpjsServiceMappingEntityFactory;
	@Inject
	private BpjsSpecialReferralEntityFactory bpjsSpecialReferralEntityFactory;
	@Inject
	private BpjsTotalReferralSEPEntityFactory bpjsTotalReferralSEPEntityFactory;
	@Inject
	private BpjsTreatmentClassMappingEntityFactory bpjsTreatmentClassMappingEntityFactory;
	@Inject
	private BpjsTreatmentHistoryEntityFactory bpjsTreatmentHistoryEntityFactory;
	@Inject
	private BpjsTreatmentRoomEntityFactory bpjsTreatmentRoomEntityFactory;
	@Inject
	private BpjsUpdateDismissalDateEntityFactory bpjsUpdateDismissalDateEntityFactory;
	@Inject
	private BpjsVisitDataEntityFactory bpjsVisitDataEntityFactory;
	@Inject
	private BatchStockBalanceEntityFactory batchStockBalanceEntityFactory;
	@Inject
	private BatchStockBalancePerDateEntityFactory batchStockBalancePerDateEntityFactory;
	@Inject
	private BatchStockTransactionDetailEntityFactory batchStockTransactionDetailEntityFactory;
	@Inject
	private BedFacilityEntityFactory bedFacilityEntityFactory;
	@Inject
	private BedReserveEntityFactory bedReserveEntityFactory;
	@Inject
	private BirthHistoryEntityFactory birthHistoryEntityFactory;
	@Inject
	private BodyChartExaminationEntityFactory bodyChartExaminationEntityFactory;
	@Inject
	private BpjsPcareKunjunganRujukanEntityFactory bpjsPcareKunjunganRujukanEntityFactory;
	@Inject
	private BpjsPcarePendaftaranEntityFactory bpjsPcarePendaftaranEntityFactory;
	@Inject
	private BpjsPcareRiwayatKunjunganEntityFactory bpjsPcareRiwayatKunjunganEntityFactory;
	@Inject
	private CashAllocationEntityFactory cashAllocationEntityFactory;
	@Inject
	private CashReceiptEntityFactory cashReceiptEntityFactory;
	@Inject
	private CashRefundEntityFactory cashRefundEntityFactory;
	@Inject
	private CashierUserEntityFactory cashierUserEntityFactory;
	@Inject
	private CatalogueMedicalEntityFactory catalogueMedicalEntityFactory;
	@Inject
	private CatalogueNonMedicalEntityFactory catalogueNonMedicalEntityFactory;
	@Inject
	private CatalogueUOMEntityFactory catalogueUOMEntityFactory;
	@Inject
	private ChartOfAccountEntityFactory chartOfAccountEntityFactory;
	@Inject
	private ChartOfAccountMappingEntityFactory chartOfAccountMappingEntityFactory;
	@Inject
	private ClaimUserEntityFactory claimUserEntityFactory;
	@Inject
	private CoTreatingDoctorEntityFactory coTreatingDoctorEntityFactory;
	@Inject
	private CompoundPrescriptionDetailEntityFactory compoundPrescriptionDetailEntityFactory;
	@Inject
	private CompoundPrescriptionItemEntityFactory compoundPrescriptionItemEntityFactory;
	@Inject
	private DailyCareCPPTEntityFactory dailyCareCPPTEntityFactory;
	@Inject
	private DeliveryMedicalExaminationRecordEntityFactory deliveryMedicalExaminationRecordEntityFactory;
	@Inject
	private DeliveryProgressEntityFactory deliveryProgressEntityFactory;
	@Inject
	private DiagnosesAndProceduresEntityFactory diagnosesAndProceduresEntityFactory;
	@Inject
	private DiagnosisExaminationRecordEntityFactory diagnosisExaminationRecordEntityFactory;
	@Inject
	private DiagnosisNandaEntityFactory diagnosisNandaEntityFactory;
	@Inject
	private DiagnosticExaminationResultsEntityFactory diagnosticExaminationResultsEntityFactory;
	@Inject
	private DiagnosticStaffExaminationSummaryEntityFactory diagnosticStaffExaminationSummaryEntityFactory;
	@Inject
	private DiagnosticSupportGeneralConfigurationEntityFactory diagnosticSupportGeneralConfigurationEntityFactory;
	@Inject
	private DiagnosticSupportUserEntityFactory diagnosticSupportUserEntityFactory;
	@Inject
	private DoctorScheduleEntityFactory doctorScheduleEntityFactory;
	@Inject
	private DoctorUserEntityFactory doctorUserEntityFactory;
	@Inject
	private EntExaminationEntityFactory entExaminationEntityFactory;
	@Inject
	private EmergencyMedicalExaminationRecordEntityFactory emergencyMedicalExaminationRecordEntityFactory;
	@Inject
	private ExaminationGroupEntityFactory examinationGroupEntityFactory;
	@Inject
	private ExaminationItemEntityFactory examinationItemEntityFactory;
	@Inject
	private ExaminationItemDetailEntityFactory examinationItemDetailEntityFactory;
	@Inject
	private FacilityHistoryEntityFactory facilityHistoryEntityFactory;
	@Inject
	private FacilityUserEntityFactory facilityUserEntityFactory;
	@Inject
	private FluidBalanceDetailEntityFactory fluidBalanceDetailEntityFactory;
	@Inject
	private FormulirKonselingTesHivEntityFactory formulirKonselingTesHivEntityFactory;
	@Inject
	private GoodsReceiveNoteEntityFactory goodsReceiveNoteEntityFactory;
	@Inject
	private GoodsReceiveNoteBatchEntityFactory goodsReceiveNoteBatchEntityFactory;
	@Inject
	private GoodsReceiveNoteItemEntityFactory goodsReceiveNoteItemEntityFactory;
	@Inject
	private HealthFacilityEntityFactory healthFacilityEntityFactory;
	@Inject
	private HemodialysisExaminationEntityFactory hemodialysisExaminationEntityFactory;
	@Inject
	private HemodialysisMonitoringEntityFactory hemodialysisMonitoringEntityFactory;
	@Inject
	private HospitalBranchInformationEntityFactory hospitalBranchInformationEntityFactory;
	@Inject
	private HospitalGroupInformationEntityFactory hospitalGroupInformationEntityFactory;
	@Inject
	private Icd10EntityFactory icd10EntityFactory;
	@Inject
	private Icd9CMEntityFactory icd9CMEntityFactory;
	@Inject
	private InformedConsentEntityFactory informedConsentEntityFactory;
	@Inject
	private InpatientMedicalExaminationRecordEntityFactory inpatientMedicalExaminationRecordEntityFactory;
	@Inject
	private InsuranceBenefitPlanEntityFactory insuranceBenefitPlanEntityFactory;
	@Inject
	private InsuranceProviderEntityFactory insuranceProviderEntityFactory;
	@Inject
	private InternalOrderEntityFactory internalOrderEntityFactory;
	@Inject
	private InternalOrderStockDetailEntityFactory internalOrderStockDetailEntityFactory;
	@Inject
	private IntraoperativeRecordsEntityFactory intraoperativeRecordsEntityFactory;
	@Inject
	private InventoryAdjusmentBatchEntityFactory inventoryAdjusmentBatchEntityFactory;
	@Inject
	private InventoryAdjustmentEntityFactory inventoryAdjustmentEntityFactory;
	@Inject
	private InventoryAdjustmentItemEntityFactory inventoryAdjustmentItemEntityFactory;
	@Inject
	private InventoryBatchCorrectionEntityFactory inventoryBatchCorrectionEntityFactory;
	@Inject
	private InventoryBatchCorrectionItemEntityFactory inventoryBatchCorrectionItemEntityFactory;
	@Inject
	private InvoiceEntityFactory invoiceEntityFactory;
	@Inject
	private InvoiceItemEntityFactory invoiceItemEntityFactory;
	@Inject
	private InvoiceItemComponentEntityFactory invoiceItemComponentEntityFactory;
	@Inject
	private InvoicePaymentInsuranceEntityFactory invoicePaymentInsuranceEntityFactory;
	@Inject
	private InvoicePaymentOtherEntityFactory invoicePaymentOtherEntityFactory;
	@Inject
	private InvoicePaymentSelfPayingEntityFactory invoicePaymentSelfPayingEntityFactory;
	@Inject
	private InvoiceSummaryEntityFactory invoiceSummaryEntityFactory;
	@Inject
	private JournalEntityFactory journalEntityFactory;
	@Inject
	private LibraryEntityFactory libraryEntityFactory;
	@Inject
	private LocationEntityFactory locationEntityFactory;
	@Inject
	private McuPackageEntityFactory mcuPackageEntityFactory;
	@Inject
	private McuPackageItemEntityFactory mcuPackageItemEntityFactory;
	@Inject
	private ManagementUserEntityFactory managementUserEntityFactory;
	@Inject
	private MedicalCertificateDischargeResumeEntityFactory medicalCertificateDischargeResumeEntityFactory;
	@Inject
	private MedicalCertificateBirthEntityFactory medicalCertificateBirthEntityFactory;
	@Inject
	private MedicalCertificateHospitalizationEntityFactory medicalCertificateHospitalizationEntityFactory;
	@Inject
	private MedicalCertificateMedicalAttendanceEntityFactory medicalCertificateMedicalAttendanceEntityFactory;
	@Inject
	private MedicalCertificateMentalHealthEntityFactory medicalCertificateMentalHealthEntityFactory;
	@Inject
	private MedicalCertificatePhysicalHealthEntityFactory medicalCertificatePhysicalHealthEntityFactory;
	@Inject
	private MedicalCertificateRestrictedWorkEntityFactory medicalCertificateRestrictedWorkEntityFactory;
	@Inject
	private MedicalCertificateSickLeaveEntityFactory medicalCertificateSickLeaveEntityFactory;
	@Inject
	private MedicalExaminationRecordEntityFactory medicalExaminationRecordEntityFactory;
	@Inject
	private MedicalExaminationRecordDischargeSummaryEntityFactory medicalExaminationRecordDischargeSummaryEntityFactory;
	@Inject
	private MedicalFeeEntityFactory medicalFeeEntityFactory;
	@Inject
	private MedicalFeeItemComponentEntityFactory medicalFeeItemComponentEntityFactory;
	@Inject
	private MedicalRecordInitialChecklistEntityFactory medicalRecordInitialChecklistEntityFactory;
	@Inject
	private MedicalRecordNextVerificationChecklistEntityFactory medicalRecordNextVerificationChecklistEntityFactory;
	@Inject
	private MedicalRecordUserEntityFactory medicalRecordUserEntityFactory;
	@Inject
	private MedicalTranscriberUserEntityFactory medicalTranscriberUserEntityFactory;
	@Inject
	private MedicationAdministeredHistoryEntityFactory medicationAdministeredHistoryEntityFactory;
	@Inject
	private MedicationCompoundEntityFactory medicationCompoundEntityFactory;
	@Inject
	private MedicationHeaderEntityFactory medicationHeaderEntityFactory;
	@Inject
	private MedicationItemEntityFactory medicationItemEntityFactory;
	@Inject
	private MerchantEntityFactory merchantEntityFactory;
	@Inject
	private MerchantSurchargeAndFeeEntityFactory merchantSurchargeAndFeeEntityFactory;
	@Inject
	private NhisClaimEntityFactory nhisClaimEntityFactory;
	@Inject
	private NhisClaimGDRGDetailEntityFactory nhisClaimGDRGDetailEntityFactory;
	@Inject
	private NhisClaimInvestigationDetailEntityFactory nhisClaimInvestigationDetailEntityFactory;
	@Inject
	private NhisGDRGEntityFactory nhisGDRGEntityFactory;
	@Inject
	private NhisInvestigationEntityFactory nhisInvestigationEntityFactory;
	@Inject
	private NhisMedicineEntityFactory nhisMedicineEntityFactory;
	@Inject
	private NhisServiceOutcomeEntityFactory nhisServiceOutcomeEntityFactory;
	@Inject
	private NhisSpecialtyAttendedEntityFactory nhisSpecialtyAttendedEntityFactory;
	@Inject
	private NhisTypeOfServiceEntityFactory nhisTypeOfServiceEntityFactory;
	@Inject
	private NewbornDetailEntityFactory newbornDetailEntityFactory;
	@Inject
	private NumberingSetupEntityFactory numberingSetupEntityFactory;
	@Inject
	private NurseUserEntityFactory nurseUserEntityFactory;
	@Inject
	private NurseVitalSignMeasurementEntityFactory nurseVitalSignMeasurementEntityFactory;
	@Inject
	private ObstetricAndGynecologyHistoryEntityFactory obstetricAndGynecologyHistoryEntityFactory;
	@Inject
	private OdontogramExaminationEntityFactory odontogramExaminationEntityFactory;
	@Inject
	private OperatingTheaterMedicalExaminationRecordEntityFactory operatingTheaterMedicalExaminationRecordEntityFactory;
	@Inject
	private OphthalmologyExaminationEntityFactory ophthalmologyExaminationEntityFactory;
	@Inject
	private PcareActionExaminationEntityFactory pcareActionExaminationEntityFactory;
	@Inject
	private PcareClubProlanisEntityFactory pcareClubProlanisEntityFactory;
	@Inject
	private PcareCompoundDrugEntityFactory pcareCompoundDrugEntityFactory;
	@Inject
	private PcareCompoundDrugItemEntityFactory pcareCompoundDrugItemEntityFactory;
	@Inject
	private PcareDiagnosaEntityFactory pcareDiagnosaEntityFactory;
	@Inject
	private PcareDokterEntityFactory pcareDokterEntityFactory;
	@Inject
	private PcareExaminationEntityFactory pcareExaminationEntityFactory;
	@Inject
	private PcareMCUEntityFactory pcareMCUEntityFactory;
	@Inject
	private PcareNonCompoundDrugEntityFactory pcareNonCompoundDrugEntityFactory;
	@Inject
	private PcareReferensiSaranaEntityFactory pcareReferensiSaranaEntityFactory;
	@Inject
	private PcareStatusPulangEntityFactory pcareStatusPulangEntityFactory;
	@Inject
	private PcareTindakanEntityFactory pcareTindakanEntityFactory;
	@Inject
	private PcareUmumEntityFactory pcareUmumEntityFactory;
	@Inject
	private PatientCaseHistoryEntityFactory patientCaseHistoryEntityFactory;
	@Inject
	private PatientConsentEntityFactory patientConsentEntityFactory;
	@Inject
	private PatientContactInfoEntityFactory patientContactInfoEntityFactory;
	@Inject
	private PatientDetailEntityFactory patientDetailEntityFactory;
	@Inject
	private PatientDetailAddressEntityFactory patientDetailAddressEntityFactory;
	@Inject
	private PatientEmergencyContactDetailEntityFactory patientEmergencyContactDetailEntityFactory;
	@Inject
	private PatientEmploymentDetailEntityFactory patientEmploymentDetailEntityFactory;
	@Inject
	private PatientGeneralInfoEntityFactory patientGeneralInfoEntityFactory;
	@Inject
	private PatientPaymentSelfPayingEntityFactory patientPaymentSelfPayingEntityFactory;
	@Inject
	private PatientPaymentBPJSEntityFactory patientPaymentBPJSEntityFactory;
	@Inject
	private PatientPaymentInsuranceEntityFactory patientPaymentInsuranceEntityFactory;
	@Inject
	private PatientPaymentOthersEntityFactory patientPaymentOthersEntityFactory;
	@Inject
	private PatientPersonalInfoEntityFactory patientPersonalInfoEntityFactory;
	@Inject
	private PatientSupportingDocumentEntityFactory patientSupportingDocumentEntityFactory;
	@Inject
	private PatientVisitEntityFactory patientVisitEntityFactory;
	@Inject
	private PatientVisitPatientPaymentInsuranceEntityFactory patientVisitPatientPaymentInsuranceEntityFactory;
	@Inject
	private PatientVisitPatientPaymentOthersEntityFactory patientVisitPatientPaymentOthersEntityFactory;
	@Inject
	private PatientVisitPaymentSelfPayingEntityFactory patientVisitPaymentSelfPayingEntityFactory;
	@Inject
	private PatientVitalInformationEntityFactory patientVitalInformationEntityFactory;
	@Inject
	private PharmacySetupEntityFactory pharmacySetupEntityFactory;
	@Inject
	private PharmacyUserEntityFactory pharmacyUserEntityFactory;
	@Inject
	private PostOperativeDetailsEntityFactory postOperativeDetailsEntityFactory;
	@Inject
	private PreoperativeRecordsEntityFactory preoperativeRecordsEntityFactory;
	@Inject
	private PrescriptionCompoundEntityFactory prescriptionCompoundEntityFactory;
	@Inject
	private PrescriptionHeaderEntityFactory prescriptionHeaderEntityFactory;
	@Inject
	private PrescriptionItemEntityFactory prescriptionItemEntityFactory;
	@Inject
	private PriceComponentEntityFactory priceComponentEntityFactory;
	@Inject
	private ProcessWorkflowEntityFactory processWorkflowEntityFactory;
	@Inject
	private PurchaseOrderEntityFactory purchaseOrderEntityFactory;
	@Inject
	private PurchaseOrderStockDetailEntityFactory purchaseOrderStockDetailEntityFactory;
	@Inject
	private PurchaseRequisitionEntityFactory purchaseRequisitionEntityFactory;
	@Inject
	private PurchaseRequisitionStockDetailEntityFactory purchaseRequisitionStockDetailEntityFactory;
	@Inject
	private PurchasingUserEntityFactory purchasingUserEntityFactory;
	@Inject
	private ReferenceDataEntityFactory referenceDataEntityFactory;
	@Inject
	private ReferenceHeaderEntityFactory referenceHeaderEntityFactory;
	@Inject
	private RegistrationEntityFactory registrationEntityFactory;
	@Inject
	private RegistrationUserEntityFactory registrationUserEntityFactory;
	@Inject
	private RetailPharmacyEntityFactory retailPharmacyEntityFactory;
	@Inject
	private RetailPharmacyInvoiceEntityFactory retailPharmacyInvoiceEntityFactory;
	@Inject
	private RetailPharmacyStockDetailEntityFactory retailPharmacyStockDetailEntityFactory;
	@Inject
	private ReturnSupplierEntityFactory returnSupplierEntityFactory;
	@Inject
	private ReturnSupplierStockDetailEntityFactory returnSupplierStockDetailEntityFactory;
	@Inject
	private RoomFacilityEntityFactory roomFacilityEntityFactory;
	@Inject
	private RoomTransferEntityFactory roomTransferEntityFactory;
	@Inject
	private SepEntityFactory sepEntityFactory;
	@Inject
	private SampleCollectionInformationEntityFactory sampleCollectionInformationEntityFactory;
	@Inject
	private SampleCollectionItemsEntityFactory sampleCollectionItemsEntityFactory;
	@Inject
	private SatuSehatConfigurationEntityFactory satuSehatConfigurationEntityFactory;
	@Inject
	private ServiceEntityFactory serviceEntityFactory;
	@Inject
	private ServiceFacilityCategoryEntityFactory serviceFacilityCategoryEntityFactory;
	@Inject
	private ServiceItemEntityFactory serviceItemEntityFactory;
	@Inject
	private ServiceItemAssignmentEntityFactory serviceItemAssignmentEntityFactory;
	@Inject
	private StaffEntityFactory staffEntityFactory;
	@Inject
	private StockCatalogueEntityFactory stockCatalogueEntityFactory;
	@Inject
	private StockControlEntityFactory stockControlEntityFactory;
	@Inject
	private StockTransactionDetailEntityFactory stockTransactionDetailEntityFactory;
	@Inject
	private StockTransactionPerDateEntityFactory stockTransactionPerDateEntityFactory;
	@Inject
	private StockTransactionPerDateTypeEntityFactory stockTransactionPerDateTypeEntityFactory;
	@Inject
	private SupplierEntityFactory supplierEntityFactory;
	@Inject
	private SupplierBankAccountEntityFactory supplierBankAccountEntityFactory;
	@Inject
	private SupplierContactDetailEntityFactory supplierContactDetailEntityFactory;
	@Inject
	private SupplierProductDetailEntityFactory supplierProductDetailEntityFactory;
	@Inject
	private SystemAdminUserEntityFactory systemAdminUserEntityFactory;
	@Inject
	private TariffDefinitionEntityFactory tariffDefinitionEntityFactory;
	@Inject
	private TariffDefinitionOtherComponentEntityFactory tariffDefinitionOtherComponentEntityFactory;
	@Inject
	private TariffFormulaEntityFactory tariffFormulaEntityFactory;
	@Inject
	private TariffPackageEntityFactory tariffPackageEntityFactory;
	@Inject
	private TariffPackageItemEntityFactory tariffPackageItemEntityFactory;
	@Inject
	private TariffPackageServiceAssignmentEntityFactory tariffPackageServiceAssignmentEntityFactory;
	@Inject
	private TariffSchemaEntityFactory tariffSchemaEntityFactory;
	@Inject
	private TaskDashboardEntityFactory taskDashboardEntityFactory;
	@Inject
	private TransactionDetailTypeEntityFactory transactionDetailTypeEntityFactory;
	@Inject
	private TransactionDetailTypeMappingEntityFactory transactionDetailTypeMappingEntityFactory;
	@Inject
	private TransferOrderEntityFactory transferOrderEntityFactory;
	@Inject
	private TransferOrderStockDetailEntityFactory transferOrderStockDetailEntityFactory;
	@Inject
	private UnitOfMeasurementEntityFactory unitOfMeasurementEntityFactory;
	@Inject
	private UserEntityFactory userEntityFactory;
	@Inject
	private VaccinationOrderEntityFactory vaccinationOrderEntityFactory;
	@Inject
	private VaccinationOrderDetailEntityFactory vaccinationOrderDetailEntityFactory;
	@Inject
	private VitalSignsEntityFactory vitalSignsEntityFactory;
	@Inject
	private WarehouseEntityFactory warehouseEntityFactory;
	@Inject
	private WarehouseInitialStockEntityFactory warehouseInitialStockEntityFactory;
	@Inject
	private WarehouseInventoryEntityFactory warehouseInventoryEntityFactory;
	@Inject
	private WarehouseUserEntityFactory warehouseUserEntityFactory;
	@Inject
	private AdminPageFactory adminPageFactory;

	@Given("I navigate to the {string} backend page")
	public void crud_backend_navigate(String entityName) throws Exception {
		adminPageFactory.createCrudListPage(entityName).navigate();
	}

	@Given("I click to create a {string}")
	public void crud_backend_click_create(String entityName) throws Exception {
		adminPageFactory.createCrudEditPage(entityName).createButton.click();
	}

	@Given("I {string} an existing {string}")
	public void iInteractWithAnExistingEntity(String crudAction, String entityName) throws Exception {
		var page = adminPageFactory.createCrudListPage(entityName);

		// wait for the list to be populated with values
		webDriverWait.until(x -> page.CrudListItems.size() > 0);
		// perform an action on the first entity in the list
		switch (crudAction.toLowerCase()) {
			case "update":
				page.EditButtons.get(0).click();
				var createPage = adminPageFactory.createCrudEditPage(entityName);
				var entity = getEntityFactory(entityName).createWithNoRef();
				createPage.applyEntity(entity);
				break;
			case "view":
				page.ViewButtons.get(0).click();
				break;
			case "delete":
				page.DeleteButtons.get(0).click();
				page.confirmDelete.click();
				break;
			case "select":
				page.selectionCheckboxes.get(1).click();
				break;
			default:
				throw new Exception(String.format("Unexpected crud action: %s", crudAction));
		}
	}

	@Given("I create an {string} if not exists")
	public void create_entity_if_not_exist(String entityName) throws Exception {
		var page = adminPageFactory.createCrudListPage(entityName);

		try {
			// wait for the list to be populated with values
			webDriverWait.until(x -> page.CrudListItems.size() > 0);
		} catch (TimeoutException e) {
			// Create a new entity if no one exists
			page.createButton.click();
			createValidEntity(entityName);
		}
	}

	@Given("I create a valid {string}")
	public void crud_backend_fill_in_and_save(String entityName) throws Exception {
		createValidEntity(entityName);
	}

	@Given("I create a valid {string} with id {string}")
	public void create_valid_entity_with_id_and_save(String entityName, String entityId) throws Exception {
		this.testContext.put(entityId, createValidEntity(entityName));
	}

	@Given("I delete all existing {string} entities")
	public void iDeleteAllExistingEntityNameFormTileEntities(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		if (page.DeleteButtons.size() > 0) {
			iIndividuallySelectAllEntitiesOnThePage(entityName);
			while (page.paginationButtons.size() > 0) {
				page.nextPage.click();
				iIndividuallySelectAllEntitiesOnThePage(entityName);
			}
			iClickTheDeleteAllButtonOnThePageAndConfirm(entityName);
		}
	}

	@Given("I create {int} {string} entities")
	public void iCreateEntities(int entityCount, String entityName) throws Exception {
		var pageUrl = adminPageFactory.createCrudListPage(entityName).getPageUrl();
		for (int i = 0; i < entityCount; i++) {
			this.createValidEntity(entityName);
			webDriverWait.until(webDriver -> webDriver.getCurrentUrl().matches(pageUrl));
		}
	}

	@When("I click the next page button on the {string} page")
	public void iClickTheNextPageButtonOnThePage(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		WaitUtils.waitForElement(webDriver, page.nextPage, VisibilityEnum.CLICKABLE);
		page.nextPage.click();
	}

	@When("I click the previous page button on the {string} page")
	public void iClickThePreviousPageButtonOnThePage(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		page.previousPage.click();
	}

	@When("I individually select all {string} entities on the page")
	public void iIndividuallySelectAllEntitiesOnThePage(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);

		//Don't click the select all checkbox, which is at index 0
		for (int i = 1; i < page.selectionCheckboxes.size(); i++) {
			if (!page.isCheckboxActive(i)) {
				page.selectionCheckboxes.get(i).click();
			}
		}
	}

	@When("I select all {string} entities")
	public void iSelectAllEntities(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		webDriverWait.until(x -> page.selectAllButton.size() > 0);
		page.selectAllButton.get(0).click();
	}

	@When("I click the cancel button on the {string} page")
	public void iClickTheCancelButtonOnThePage(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		webDriverWait.until(x -> page.collectionOptions.size() > 0);
		page.cancelButton.click();
	}

	@When("I click the delete all button on the {string} page and confirm")
	public void iClickTheDeleteAllButtonOnThePageAndConfirm(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		page.deleteAllButton.click();
		WaitUtils.waitForElement(webDriver, page.confirmDelete, VisibilityEnum.CLICKABLE);
		page.confirmDelete.click();
	}

	@When("I click the cancel button on the {string} edit page")
	public void iClickTheCancelButtonOnTheEditPage(String entityName) throws Exception{
		var page = this.adminPageFactory.createCrudEditPage(entityName);
		page.cancelButton.click();
	}

	@Then("I am on the {string} backend page")
	public void crud_assert_on_backend_page(String entityName) throws Exception {
		var pageUrl = adminPageFactory.createCrudListPage(entityName).getPageUrl();
		webDriverWait.until(webDriver -> webDriver.getCurrentUrl().contains(pageUrl));
	}

	@Then("I expect that the current page number on the {string} list page is {int}")
	public void iExpectThatTheCurrentPageNumberOnTheListPageIs(String entityName, int expectedPage) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		WaitUtils.waitForElement(webDriver, page.pageNumber, VisibilityEnum.VISIBLE);

		Assert.assertEquals(Integer.parseInt(page.pageNumber.getText()), expectedPage);
	}

	@Then("I {string} {string} a {string} entity")
	public void iInteractWithAnEntity(String hasAccess, String permissionType, String entityName) throws Exception {
		CrudList crudList = this.adminPageFactory.createCrudListPage(entityName);
		boolean canPerformAction = hasAccess.matches("can");
		boolean isDisabled;

		switch (permissionType) {
			case "create":
				webDriverWait.until(x -> crudList.EditButtons.size() > 0);
				isDisabled = WebElementUtils.elementHasAttribute(crudList.createButton, "disabled", "true");
				Assert.assertTrue(isDisabled != canPerformAction);
				break;
			case "read":
				isDisabled = webDriver.getCurrentUrl().endsWith("/403");
				Assert.assertTrue(isDisabled != canPerformAction);
				break;
			case "update":
				webDriverWait.until(x -> crudList.EditButtons.size() > 0);
				isDisabled = WebElementUtils.elementHasAttribute(crudList.EditButtons.get(0), "disabled", "true");
				Assert.assertTrue(isDisabled != canPerformAction);
				break;
			case "delete":
				webDriverWait.until(x -> crudList.DeleteButtons.size() > 0);
				isDisabled = WebElementUtils.elementHasAttribute(crudList.DeleteButtons.get(0), "disabled", "true");
				Assert.assertTrue(isDisabled != canPerformAction);
				break;
			default:
				throw new RuntimeException(permissionType + "is not a valid CRUD operation");
		}
	}

	@Then("I expect that the Select All Checkbox on the {string} page is active")
	public void iExpectThatTheSelectAllCheckboxOnThePageIsActive(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		Assert.assertTrue(page.isCheckboxActive(0));
	}

	@Then("I expect the {string} entity is selected")
	public void iExpectTheEntityIsSelected(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		webDriverWait.until(x -> this.checkboxActive(page, 1));
		Assert.assertTrue(this.checkboxActive(page, 1));
	}

	@Then("The {string} collection options bar is present")
	public void theCollectionOptionsBarIsPresent(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		webDriverWait.until(x -> page.collectionOptions.size() > 0);
		Assert.assertEquals(page.collectionOptions.size(), 1);
	}

	@Then("The Select All Items button is present in the {string} collection options bar")
	public void theSelectAllItemsButtonIsPresentInTheCollectionOptionsBar(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		webDriverWait.until(x -> page.selectAllButton.size() > 0);
		Assert.assertEquals(page.selectAllButton.size(), 1);
	}

	@Then("I expect that every {string} entity is selected")
	public void iExpectThatEveryEntityIsSelected(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		Assert.assertTrue(this.checkboxActive(page, 0));

		//While not on the last page
		while (!(page.nextPage.getAttribute("disabled") == null)) {
			page.nextPage.click();
			Assert.assertTrue(this.checkboxActive(page, 0));
		}
	}

	@Then("I expect that every {string} entity is deselected")
	public void iExpectThatEveryEntityIsDeselected(String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		Assert.assertFalse(this.checkboxActive(page, 0));

		//While not on the last page
		while (!(page.nextPage.getAttribute("disabled") == null)) {
			page.nextPage.click();
			Assert.assertFalse(this.checkboxActive(page, 0));
		}
	}

	@Then("I expect that every {string} entity except {int} is deleted")
	public void iExpectThatEveryEntityIsDeleted(String entityName, int expectedRemainingEntities) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		webDriverWait.until(x -> page.CrudListItems.size() == expectedRemainingEntities);
		Assert.assertEquals(page.CrudListItems.size(), expectedRemainingEntities);
	}

	@Then("I expect that {int} {string} entity is selected in the collection options bar")
	public void iExpectThatEntityIsSelectedInTheCollectionOptionsBar(int expectedSelected, String entityName) throws Exception {
		var page = this.adminPageFactory.createCrudListPage(entityName);
		WaitUtils.waitForElement(webDriver, page.selectedCount, VisibilityEnum.VISIBLE);
		int selectedCount = Integer.parseInt(page.selectedCount.getText());
		Assert.assertEquals(selectedCount, expectedSelected);
	}

	/**
	 * Performs a check to see whether the specified checkbox on the crud list page is active
	 *
	 * @param index The index of the checkbox to examine
	 * @return true if the checkbox is active, false otherwise
	 */
	private boolean checkboxActive(CrudList page, int index) {
		webDriverWait.until(webDriver -> webDriver.getCurrentUrl().matches(page.getPageUrl()));
		page.waitForListElementsLoaded();
		webDriverWait.until(x -> page.CrudListItems.size() > 0);
		return page.isCheckboxActive(index);
	}

	/**
	 * Given the name of entity, recursively create entities in backend
	 * @param entityName Name of the type of entity
	 * @return Created entity
	 * @throws Exception
	 */
	private AbstractEntity createValidEntity(String entityName) throws Exception{
		AbstractEntity entity = getEntityFactory(entityName).createWithNoRef();

		var createPage = adminPageFactory.createCrudEditPage(entityName);
		// for each of the required references we will create it
		for (EntityReference reference : entity.References) {
			if (!reference.optional) {
				crud_backend_fill_in_and_save(reference.entityName);
			}
		}
		createPage.navigate();

		webDriverWait.until(webDriver -> webDriver.getCurrentUrl().matches(createPage.getPageUrl()));
		createPage.applyEntity(entity);
		return entity;
	}

	private BaseFactory getEntityFactory(String entityName) throws Exception {
		BaseFactory baseFactory;
		switch (entityName)
		{
			case "AdministrationUser":
				baseFactory = administrationUserEntityFactory;
				break;
			case "Administrator":
				baseFactory = administratorEntityFactory;
				break;
			case "AmendmentDetail":
				baseFactory = amendmentDetailEntityFactory;
				break;
			case "BpjsAccidentMaster":
				baseFactory = bpjsAccidentMasterEntityFactory;
				break;
			case "BpjsBedAvailability":
				baseFactory = bpjsBedAvailabilityEntityFactory;
				break;
			case "BpjsClaimData":
				baseFactory = bpjsClaimDataEntityFactory;
				break;
			case "BpjsClaimSubmission":
				baseFactory = bpjsClaimSubmissionEntityFactory;
				break;
			case "BpjsControlPlan":
				baseFactory = bpjsControlPlanEntityFactory;
				break;
			case "BpjsControlSpecialist":
				baseFactory = bpjsControlSpecialistEntityFactory;
				break;
			case "BpjsDiagnose":
				baseFactory = bpjsDiagnoseEntityFactory;
				break;
			case "BpjsDiagnosePRB":
				baseFactory = bpjsDiagnosePRBEntityFactory;
				break;
			case "BpjsDismissalCondition":
				baseFactory = bpjsDismissalConditionEntityFactory;
				break;
			case "BpjsDismissalMapping":
				baseFactory = bpjsDismissalMappingEntityFactory;
				break;
			case "BpjsDoctorMapping":
				baseFactory = bpjsDoctorMappingEntityFactory;
				break;
			case "BpjsDoctorSchedule":
				baseFactory = bpjsDoctorScheduleEntityFactory;
				break;
			case "BpjsDrugGenericPRB":
				baseFactory = bpjsDrugGenericPRBEntityFactory;
				break;
			case "BpjsFacilityList":
				baseFactory = bpjsFacilityListEntityFactory;
				break;
			case "BpjsFingerPrint":
				baseFactory = bpjsFingerPrintEntityFactory;
				break;
			case "BpjsGeneral":
				baseFactory = bpjsGeneralEntityFactory;
				break;
			case "BpjsHealthFacility":
				baseFactory = bpjsHealthFacilityEntityFactory;
				break;
			case "BpjsHospitalizationPlan":
				baseFactory = bpjsHospitalizationPlanEntityFactory;
				break;
			case "BpjsINACBG":
				baseFactory = bpjsINACBGEntityFactory;
				break;
			case "BpjsINACBGClaim":
				baseFactory = bpjsINACBGClaimEntityFactory;
				break;
			case "BpjsINACBGVariable":
				baseFactory = bpjsINACBGVariableEntityFactory;
				break;
			case "BpjsJasaRaharja":
				baseFactory = bpjsJasaRaharjaEntityFactory;
				break;
			case "BpjsJasaRaharjaClaim":
				baseFactory = bpjsJasaRaharjaClaimEntityFactory;
				break;
			case "BpjsListFingerPrint":
				baseFactory = bpjsListFingerPrintEntityFactory;
				break;
			case "BpjsListTask":
				baseFactory = bpjsListTaskEntityFactory;
				break;
			case "BpjsOutsideFacilityReferral":
				baseFactory = bpjsOutsideFacilityReferralEntityFactory;
				break;
			case "BpjsPRB":
				baseFactory = bpjsPRBEntityFactory;
				break;
			case "BpjsPRBDetail":
				baseFactory = bpjsPRBDetailEntityFactory;
				break;
			case "BpjsPatientReferral":
				baseFactory = bpjsPatientReferralEntityFactory;
				break;
			case "BpjsPcareDPHO":
				baseFactory = bpjsPcareDPHOEntityFactory;
				break;
			case "BpjsPcareKegiatanKelompok":
				baseFactory = bpjsPcareKegiatanKelompokEntityFactory;
				break;
			case "BpjsPcareKesadaran":
				baseFactory = bpjsPcareKesadaranEntityFactory;
				break;
			case "BpjsPcarePesertaKegiatanKelompok":
				baseFactory = bpjsPcarePesertaKegiatanKelompokEntityFactory;
				break;
			case "BpjsPcarePoli":
				baseFactory = bpjsPcarePoliEntityFactory;
				break;
			case "BpjsPcareProviderRayonisasi":
				baseFactory = bpjsPcareProviderRayonisasiEntityFactory;
				break;
			case "BpjsPcareRegistrations":
				baseFactory = bpjsPcareRegistrationsEntityFactory;
				break;
			case "BpjsProcedure":
				baseFactory = bpjsProcedureEntityFactory;
				break;
			case "BpjsReferralSpecialist":
				baseFactory = bpjsReferralSpecialistEntityFactory;
				break;
			case "BpjsSEP":
				baseFactory = bpjsSEPEntityFactory;
				break;
			case "BpjsSEPINACBGIntegration":
				baseFactory = bpjsSEPINACBGIntegrationEntityFactory;
				break;
			case "BpjsSEPInternalData":
				baseFactory = bpjsSEPInternalDataEntityFactory;
				break;
			case "BpjsSEPSubmission":
				baseFactory = bpjsSEPSubmissionEntityFactory;
				break;
			case "BpjsSearchControlLetter":
				baseFactory = bpjsSearchControlLetterEntityFactory;
				break;
			case "BpjsSearchSEP":
				baseFactory = bpjsSearchSEPEntityFactory;
				break;
			case "BpjsServiceMapping":
				baseFactory = bpjsServiceMappingEntityFactory;
				break;
			case "BpjsSpecialReferral":
				baseFactory = bpjsSpecialReferralEntityFactory;
				break;
			case "BpjsTotalReferralSEP":
				baseFactory = bpjsTotalReferralSEPEntityFactory;
				break;
			case "BpjsTreatmentClassMapping":
				baseFactory = bpjsTreatmentClassMappingEntityFactory;
				break;
			case "BpjsTreatmentHistory":
				baseFactory = bpjsTreatmentHistoryEntityFactory;
				break;
			case "BpjsTreatmentRoom":
				baseFactory = bpjsTreatmentRoomEntityFactory;
				break;
			case "BpjsUpdateDismissalDate":
				baseFactory = bpjsUpdateDismissalDateEntityFactory;
				break;
			case "BpjsVisitData":
				baseFactory = bpjsVisitDataEntityFactory;
				break;
			case "BatchStockBalance":
				baseFactory = batchStockBalanceEntityFactory;
				break;
			case "BatchStockBalancePerDate":
				baseFactory = batchStockBalancePerDateEntityFactory;
				break;
			case "BatchStockTransactionDetail":
				baseFactory = batchStockTransactionDetailEntityFactory;
				break;
			case "BedFacility":
				baseFactory = bedFacilityEntityFactory;
				break;
			case "BedReserve":
				baseFactory = bedReserveEntityFactory;
				break;
			case "BirthHistory":
				baseFactory = birthHistoryEntityFactory;
				break;
			case "BodyChartExamination":
				baseFactory = bodyChartExaminationEntityFactory;
				break;
			case "BpjsPcareKunjunganRujukan":
				baseFactory = bpjsPcareKunjunganRujukanEntityFactory;
				break;
			case "BpjsPcarePendaftaran":
				baseFactory = bpjsPcarePendaftaranEntityFactory;
				break;
			case "BpjsPcareRiwayatKunjungan":
				baseFactory = bpjsPcareRiwayatKunjunganEntityFactory;
				break;
			case "CashAllocation":
				baseFactory = cashAllocationEntityFactory;
				break;
			case "CashReceipt":
				baseFactory = cashReceiptEntityFactory;
				break;
			case "CashRefund":
				baseFactory = cashRefundEntityFactory;
				break;
			case "CashierUser":
				baseFactory = cashierUserEntityFactory;
				break;
			case "CatalogueMedical":
				baseFactory = catalogueMedicalEntityFactory;
				break;
			case "CatalogueNonMedical":
				baseFactory = catalogueNonMedicalEntityFactory;
				break;
			case "CatalogueUOM":
				baseFactory = catalogueUOMEntityFactory;
				break;
			case "ChartOfAccount":
				baseFactory = chartOfAccountEntityFactory;
				break;
			case "ChartOfAccountMapping":
				baseFactory = chartOfAccountMappingEntityFactory;
				break;
			case "ClaimUser":
				baseFactory = claimUserEntityFactory;
				break;
			case "CoTreatingDoctor":
				baseFactory = coTreatingDoctorEntityFactory;
				break;
			case "CompoundPrescriptionDetail":
				baseFactory = compoundPrescriptionDetailEntityFactory;
				break;
			case "CompoundPrescriptionItem":
				baseFactory = compoundPrescriptionItemEntityFactory;
				break;
			case "DailyCareCPPT":
				baseFactory = dailyCareCPPTEntityFactory;
				break;
			case "DeliveryMedicalExaminationRecord":
				baseFactory = deliveryMedicalExaminationRecordEntityFactory;
				break;
			case "DeliveryProgress":
				baseFactory = deliveryProgressEntityFactory;
				break;
			case "DiagnosesAndProcedures":
				baseFactory = diagnosesAndProceduresEntityFactory;
				break;
			case "DiagnosisExaminationRecord":
				baseFactory = diagnosisExaminationRecordEntityFactory;
				break;
			case "DiagnosisNanda":
				baseFactory = diagnosisNandaEntityFactory;
				break;
			case "DiagnosticExaminationResults":
				baseFactory = diagnosticExaminationResultsEntityFactory;
				break;
			case "DiagnosticStaffExaminationSummary":
				baseFactory = diagnosticStaffExaminationSummaryEntityFactory;
				break;
			case "DiagnosticSupportGeneralConfiguration":
				baseFactory = diagnosticSupportGeneralConfigurationEntityFactory;
				break;
			case "DiagnosticSupportUser":
				baseFactory = diagnosticSupportUserEntityFactory;
				break;
			case "DoctorSchedule":
				baseFactory = doctorScheduleEntityFactory;
				break;
			case "DoctorUser":
				baseFactory = doctorUserEntityFactory;
				break;
			case "EntExamination":
				baseFactory = entExaminationEntityFactory;
				break;
			case "EmergencyMedicalExaminationRecord":
				baseFactory = emergencyMedicalExaminationRecordEntityFactory;
				break;
			case "ExaminationGroup":
				baseFactory = examinationGroupEntityFactory;
				break;
			case "ExaminationItem":
				baseFactory = examinationItemEntityFactory;
				break;
			case "ExaminationItemDetail":
				baseFactory = examinationItemDetailEntityFactory;
				break;
			case "FacilityHistory":
				baseFactory = facilityHistoryEntityFactory;
				break;
			case "FacilityUser":
				baseFactory = facilityUserEntityFactory;
				break;
			case "FluidBalanceDetail":
				baseFactory = fluidBalanceDetailEntityFactory;
				break;
			case "FormulirKonselingTesHiv":
				baseFactory = formulirKonselingTesHivEntityFactory;
				break;
			case "GoodsReceiveNote":
				baseFactory = goodsReceiveNoteEntityFactory;
				break;
			case "GoodsReceiveNoteBatch":
				baseFactory = goodsReceiveNoteBatchEntityFactory;
				break;
			case "GoodsReceiveNoteItem":
				baseFactory = goodsReceiveNoteItemEntityFactory;
				break;
			case "HealthFacility":
				baseFactory = healthFacilityEntityFactory;
				break;
			case "HemodialysisExamination":
				baseFactory = hemodialysisExaminationEntityFactory;
				break;
			case "HemodialysisMonitoring":
				baseFactory = hemodialysisMonitoringEntityFactory;
				break;
			case "HospitalBranchInformation":
				baseFactory = hospitalBranchInformationEntityFactory;
				break;
			case "HospitalGroupInformation":
				baseFactory = hospitalGroupInformationEntityFactory;
				break;
			case "Icd10":
				baseFactory = icd10EntityFactory;
				break;
			case "Icd9CM":
				baseFactory = icd9CMEntityFactory;
				break;
			case "InformedConsent":
				baseFactory = informedConsentEntityFactory;
				break;
			case "InpatientMedicalExaminationRecord":
				baseFactory = inpatientMedicalExaminationRecordEntityFactory;
				break;
			case "InsuranceBenefitPlan":
				baseFactory = insuranceBenefitPlanEntityFactory;
				break;
			case "InsuranceProvider":
				baseFactory = insuranceProviderEntityFactory;
				break;
			case "InternalOrder":
				baseFactory = internalOrderEntityFactory;
				break;
			case "InternalOrderStockDetail":
				baseFactory = internalOrderStockDetailEntityFactory;
				break;
			case "IntraoperativeRecords":
				baseFactory = intraoperativeRecordsEntityFactory;
				break;
			case "InventoryAdjusmentBatch":
				baseFactory = inventoryAdjusmentBatchEntityFactory;
				break;
			case "InventoryAdjustment":
				baseFactory = inventoryAdjustmentEntityFactory;
				break;
			case "InventoryAdjustmentItem":
				baseFactory = inventoryAdjustmentItemEntityFactory;
				break;
			case "InventoryBatchCorrection":
				baseFactory = inventoryBatchCorrectionEntityFactory;
				break;
			case "InventoryBatchCorrectionItem":
				baseFactory = inventoryBatchCorrectionItemEntityFactory;
				break;
			case "Invoice":
				baseFactory = invoiceEntityFactory;
				break;
			case "InvoiceItem":
				baseFactory = invoiceItemEntityFactory;
				break;
			case "InvoiceItemComponent":
				baseFactory = invoiceItemComponentEntityFactory;
				break;
			case "InvoicePaymentInsurance":
				baseFactory = invoicePaymentInsuranceEntityFactory;
				break;
			case "InvoicePaymentOther":
				baseFactory = invoicePaymentOtherEntityFactory;
				break;
			case "InvoicePaymentSelfPaying":
				baseFactory = invoicePaymentSelfPayingEntityFactory;
				break;
			case "InvoiceSummary":
				baseFactory = invoiceSummaryEntityFactory;
				break;
			case "Journal":
				baseFactory = journalEntityFactory;
				break;
			case "Library":
				baseFactory = libraryEntityFactory;
				break;
			case "Location":
				baseFactory = locationEntityFactory;
				break;
			case "McuPackage":
				baseFactory = mcuPackageEntityFactory;
				break;
			case "McuPackageItem":
				baseFactory = mcuPackageItemEntityFactory;
				break;
			case "ManagementUser":
				baseFactory = managementUserEntityFactory;
				break;
			case "MedicalCertificateDischargeResume":
				baseFactory = medicalCertificateDischargeResumeEntityFactory;
				break;
			case "MedicalCertificateBirth":
				baseFactory = medicalCertificateBirthEntityFactory;
				break;
			case "MedicalCertificateHospitalization":
				baseFactory = medicalCertificateHospitalizationEntityFactory;
				break;
			case "MedicalCertificateMedicalAttendance":
				baseFactory = medicalCertificateMedicalAttendanceEntityFactory;
				break;
			case "MedicalCertificateMentalHealth":
				baseFactory = medicalCertificateMentalHealthEntityFactory;
				break;
			case "MedicalCertificatePhysicalHealth":
				baseFactory = medicalCertificatePhysicalHealthEntityFactory;
				break;
			case "MedicalCertificateRestrictedWork":
				baseFactory = medicalCertificateRestrictedWorkEntityFactory;
				break;
			case "MedicalCertificateSickLeave":
				baseFactory = medicalCertificateSickLeaveEntityFactory;
				break;
			case "MedicalExaminationRecord":
				baseFactory = medicalExaminationRecordEntityFactory;
				break;
			case "MedicalExaminationRecordDischargeSummary":
				baseFactory = medicalExaminationRecordDischargeSummaryEntityFactory;
				break;
			case "MedicalFee":
				baseFactory = medicalFeeEntityFactory;
				break;
			case "MedicalFeeItemComponent":
				baseFactory = medicalFeeItemComponentEntityFactory;
				break;
			case "MedicalRecordInitialChecklist":
				baseFactory = medicalRecordInitialChecklistEntityFactory;
				break;
			case "MedicalRecordNextVerificationChecklist":
				baseFactory = medicalRecordNextVerificationChecklistEntityFactory;
				break;
			case "MedicalRecordUser":
				baseFactory = medicalRecordUserEntityFactory;
				break;
			case "MedicalTranscriberUser":
				baseFactory = medicalTranscriberUserEntityFactory;
				break;
			case "MedicationAdministeredHistory":
				baseFactory = medicationAdministeredHistoryEntityFactory;
				break;
			case "MedicationCompound":
				baseFactory = medicationCompoundEntityFactory;
				break;
			case "MedicationHeader":
				baseFactory = medicationHeaderEntityFactory;
				break;
			case "MedicationItem":
				baseFactory = medicationItemEntityFactory;
				break;
			case "Merchant":
				baseFactory = merchantEntityFactory;
				break;
			case "MerchantSurchargeAndFee":
				baseFactory = merchantSurchargeAndFeeEntityFactory;
				break;
			case "NhisClaim":
				baseFactory = nhisClaimEntityFactory;
				break;
			case "NhisClaimGDRGDetail":
				baseFactory = nhisClaimGDRGDetailEntityFactory;
				break;
			case "NhisClaimInvestigationDetail":
				baseFactory = nhisClaimInvestigationDetailEntityFactory;
				break;
			case "NhisGDRG":
				baseFactory = nhisGDRGEntityFactory;
				break;
			case "NhisInvestigation":
				baseFactory = nhisInvestigationEntityFactory;
				break;
			case "NhisMedicine":
				baseFactory = nhisMedicineEntityFactory;
				break;
			case "NhisServiceOutcome":
				baseFactory = nhisServiceOutcomeEntityFactory;
				break;
			case "NhisSpecialtyAttended":
				baseFactory = nhisSpecialtyAttendedEntityFactory;
				break;
			case "NhisTypeOfService":
				baseFactory = nhisTypeOfServiceEntityFactory;
				break;
			case "NewbornDetail":
				baseFactory = newbornDetailEntityFactory;
				break;
			case "NumberingSetup":
				baseFactory = numberingSetupEntityFactory;
				break;
			case "NurseUser":
				baseFactory = nurseUserEntityFactory;
				break;
			case "NurseVitalSignMeasurement":
				baseFactory = nurseVitalSignMeasurementEntityFactory;
				break;
			case "ObstetricAndGynecologyHistory":
				baseFactory = obstetricAndGynecologyHistoryEntityFactory;
				break;
			case "OdontogramExamination":
				baseFactory = odontogramExaminationEntityFactory;
				break;
			case "OperatingTheaterMedicalExaminationRecord":
				baseFactory = operatingTheaterMedicalExaminationRecordEntityFactory;
				break;
			case "OphthalmologyExamination":
				baseFactory = ophthalmologyExaminationEntityFactory;
				break;
			case "PcareActionExamination":
				baseFactory = pcareActionExaminationEntityFactory;
				break;
			case "PcareClubProlanis":
				baseFactory = pcareClubProlanisEntityFactory;
				break;
			case "PcareCompoundDrug":
				baseFactory = pcareCompoundDrugEntityFactory;
				break;
			case "PcareCompoundDrugItem":
				baseFactory = pcareCompoundDrugItemEntityFactory;
				break;
			case "PcareDiagnosa":
				baseFactory = pcareDiagnosaEntityFactory;
				break;
			case "PcareDokter":
				baseFactory = pcareDokterEntityFactory;
				break;
			case "PcareExamination":
				baseFactory = pcareExaminationEntityFactory;
				break;
			case "PcareMCU":
				baseFactory = pcareMCUEntityFactory;
				break;
			case "PcareNonCompoundDrug":
				baseFactory = pcareNonCompoundDrugEntityFactory;
				break;
			case "PcareReferensiSarana":
				baseFactory = pcareReferensiSaranaEntityFactory;
				break;
			case "PcareStatusPulang":
				baseFactory = pcareStatusPulangEntityFactory;
				break;
			case "PcareTindakan":
				baseFactory = pcareTindakanEntityFactory;
				break;
			case "PcareUmum":
				baseFactory = pcareUmumEntityFactory;
				break;
			case "PatientCaseHistory":
				baseFactory = patientCaseHistoryEntityFactory;
				break;
			case "PatientConsent":
				baseFactory = patientConsentEntityFactory;
				break;
			case "PatientContactInfo":
				baseFactory = patientContactInfoEntityFactory;
				break;
			case "PatientDetail":
				baseFactory = patientDetailEntityFactory;
				break;
			case "PatientDetailAddress":
				baseFactory = patientDetailAddressEntityFactory;
				break;
			case "PatientEmergencyContactDetail":
				baseFactory = patientEmergencyContactDetailEntityFactory;
				break;
			case "PatientEmploymentDetail":
				baseFactory = patientEmploymentDetailEntityFactory;
				break;
			case "PatientGeneralInfo":
				baseFactory = patientGeneralInfoEntityFactory;
				break;
			case "PatientPaymentSelfPaying":
				baseFactory = patientPaymentSelfPayingEntityFactory;
				break;
			case "PatientPaymentBPJS":
				baseFactory = patientPaymentBPJSEntityFactory;
				break;
			case "PatientPaymentInsurance":
				baseFactory = patientPaymentInsuranceEntityFactory;
				break;
			case "PatientPaymentOthers":
				baseFactory = patientPaymentOthersEntityFactory;
				break;
			case "PatientPersonalInfo":
				baseFactory = patientPersonalInfoEntityFactory;
				break;
			case "PatientSupportingDocument":
				baseFactory = patientSupportingDocumentEntityFactory;
				break;
			case "PatientVisit":
				baseFactory = patientVisitEntityFactory;
				break;
			case "PatientVisitPatientPaymentInsurance":
				baseFactory = patientVisitPatientPaymentInsuranceEntityFactory;
				break;
			case "PatientVisitPatientPaymentOthers":
				baseFactory = patientVisitPatientPaymentOthersEntityFactory;
				break;
			case "PatientVisitPaymentSelfPaying":
				baseFactory = patientVisitPaymentSelfPayingEntityFactory;
				break;
			case "PatientVitalInformation":
				baseFactory = patientVitalInformationEntityFactory;
				break;
			case "PharmacySetup":
				baseFactory = pharmacySetupEntityFactory;
				break;
			case "PharmacyUser":
				baseFactory = pharmacyUserEntityFactory;
				break;
			case "PostOperativeDetails":
				baseFactory = postOperativeDetailsEntityFactory;
				break;
			case "PreoperativeRecords":
				baseFactory = preoperativeRecordsEntityFactory;
				break;
			case "PrescriptionCompound":
				baseFactory = prescriptionCompoundEntityFactory;
				break;
			case "PrescriptionHeader":
				baseFactory = prescriptionHeaderEntityFactory;
				break;
			case "PrescriptionItem":
				baseFactory = prescriptionItemEntityFactory;
				break;
			case "PriceComponent":
				baseFactory = priceComponentEntityFactory;
				break;
			case "ProcessWorkflow":
				baseFactory = processWorkflowEntityFactory;
				break;
			case "PurchaseOrder":
				baseFactory = purchaseOrderEntityFactory;
				break;
			case "PurchaseOrderStockDetail":
				baseFactory = purchaseOrderStockDetailEntityFactory;
				break;
			case "PurchaseRequisition":
				baseFactory = purchaseRequisitionEntityFactory;
				break;
			case "PurchaseRequisitionStockDetail":
				baseFactory = purchaseRequisitionStockDetailEntityFactory;
				break;
			case "PurchasingUser":
				baseFactory = purchasingUserEntityFactory;
				break;
			case "ReferenceData":
				baseFactory = referenceDataEntityFactory;
				break;
			case "ReferenceHeader":
				baseFactory = referenceHeaderEntityFactory;
				break;
			case "Registration":
				baseFactory = registrationEntityFactory;
				break;
			case "RegistrationUser":
				baseFactory = registrationUserEntityFactory;
				break;
			case "RetailPharmacy":
				baseFactory = retailPharmacyEntityFactory;
				break;
			case "RetailPharmacyInvoice":
				baseFactory = retailPharmacyInvoiceEntityFactory;
				break;
			case "RetailPharmacyStockDetail":
				baseFactory = retailPharmacyStockDetailEntityFactory;
				break;
			case "ReturnSupplier":
				baseFactory = returnSupplierEntityFactory;
				break;
			case "ReturnSupplierStockDetail":
				baseFactory = returnSupplierStockDetailEntityFactory;
				break;
			case "RoomFacility":
				baseFactory = roomFacilityEntityFactory;
				break;
			case "RoomTransfer":
				baseFactory = roomTransferEntityFactory;
				break;
			case "Sep":
				baseFactory = sepEntityFactory;
				break;
			case "SampleCollectionInformation":
				baseFactory = sampleCollectionInformationEntityFactory;
				break;
			case "SampleCollectionItems":
				baseFactory = sampleCollectionItemsEntityFactory;
				break;
			case "SatuSehatConfiguration":
				baseFactory = satuSehatConfigurationEntityFactory;
				break;
			case "Service":
				baseFactory = serviceEntityFactory;
				break;
			case "ServiceFacilityCategory":
				baseFactory = serviceFacilityCategoryEntityFactory;
				break;
			case "ServiceItem":
				baseFactory = serviceItemEntityFactory;
				break;
			case "ServiceItemAssignment":
				baseFactory = serviceItemAssignmentEntityFactory;
				break;
			case "Staff":
				baseFactory = staffEntityFactory;
				break;
			case "StockCatalogue":
				baseFactory = stockCatalogueEntityFactory;
				break;
			case "StockControl":
				baseFactory = stockControlEntityFactory;
				break;
			case "StockTransactionDetail":
				baseFactory = stockTransactionDetailEntityFactory;
				break;
			case "StockTransactionPerDate":
				baseFactory = stockTransactionPerDateEntityFactory;
				break;
			case "StockTransactionPerDateType":
				baseFactory = stockTransactionPerDateTypeEntityFactory;
				break;
			case "Supplier":
				baseFactory = supplierEntityFactory;
				break;
			case "SupplierBankAccount":
				baseFactory = supplierBankAccountEntityFactory;
				break;
			case "SupplierContactDetail":
				baseFactory = supplierContactDetailEntityFactory;
				break;
			case "SupplierProductDetail":
				baseFactory = supplierProductDetailEntityFactory;
				break;
			case "SystemAdminUser":
				baseFactory = systemAdminUserEntityFactory;
				break;
			case "TariffDefinition":
				baseFactory = tariffDefinitionEntityFactory;
				break;
			case "TariffDefinitionOtherComponent":
				baseFactory = tariffDefinitionOtherComponentEntityFactory;
				break;
			case "TariffFormula":
				baseFactory = tariffFormulaEntityFactory;
				break;
			case "TariffPackage":
				baseFactory = tariffPackageEntityFactory;
				break;
			case "TariffPackageItem":
				baseFactory = tariffPackageItemEntityFactory;
				break;
			case "TariffPackageServiceAssignment":
				baseFactory = tariffPackageServiceAssignmentEntityFactory;
				break;
			case "TariffSchema":
				baseFactory = tariffSchemaEntityFactory;
				break;
			case "TaskDashboard":
				baseFactory = taskDashboardEntityFactory;
				break;
			case "TransactionDetailType":
				baseFactory = transactionDetailTypeEntityFactory;
				break;
			case "TransactionDetailTypeMapping":
				baseFactory = transactionDetailTypeMappingEntityFactory;
				break;
			case "TransferOrder":
				baseFactory = transferOrderEntityFactory;
				break;
			case "TransferOrderStockDetail":
				baseFactory = transferOrderStockDetailEntityFactory;
				break;
			case "UnitOfMeasurement":
				baseFactory = unitOfMeasurementEntityFactory;
				break;
			case "User":
				baseFactory = userEntityFactory;
				break;
			case "VaccinationOrder":
				baseFactory = vaccinationOrderEntityFactory;
				break;
			case "VaccinationOrderDetail":
				baseFactory = vaccinationOrderDetailEntityFactory;
				break;
			case "VitalSigns":
				baseFactory = vitalSignsEntityFactory;
				break;
			case "Warehouse":
				baseFactory = warehouseEntityFactory;
				break;
			case "WarehouseInitialStock":
				baseFactory = warehouseInitialStockEntityFactory;
				break;
			case "WarehouseInventory":
				baseFactory = warehouseInventoryEntityFactory;
				break;
			case "WarehouseUser":
				baseFactory = warehouseUserEntityFactory;
				break;
			default:
				throw new Exception(String.format("Unexpected entityName %s", entityName));
		}
		return baseFactory;
	}
}