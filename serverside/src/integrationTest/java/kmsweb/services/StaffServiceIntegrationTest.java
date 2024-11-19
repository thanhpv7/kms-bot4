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

package kmsweb.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;
import kmsweb.SpringTestConfiguration;
import kmsweb.configs.security.helpers.AnonymousHelper;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
import kmsweb.entities.AdministrationUserEntity;
import kmsweb.repositories.AdministrationUserRepository;
import kmsweb.utils.AdministrationUserFactory;
import kmsweb.utils.DatabasePopulators.AdministrationUserDatabasePopulator;
import kmsweb.entities.AdministratorEntity;
import kmsweb.repositories.AdministratorRepository;
import kmsweb.utils.AdministratorFactory;
import kmsweb.utils.DatabasePopulators.AdministratorDatabasePopulator;
import kmsweb.entities.AmendmentDetailEntity;
import kmsweb.repositories.AmendmentDetailRepository;
import kmsweb.utils.AmendmentDetailFactory;
import kmsweb.utils.DatabasePopulators.AmendmentDetailDatabasePopulator;
import kmsweb.entities.BpjsDoctorMappingEntity;
import kmsweb.repositories.BpjsDoctorMappingRepository;
import kmsweb.utils.BpjsDoctorMappingFactory;
import kmsweb.utils.DatabasePopulators.BpjsDoctorMappingDatabasePopulator;
import kmsweb.entities.CashReceiptEntity;
import kmsweb.repositories.CashReceiptRepository;
import kmsweb.utils.CashReceiptFactory;
import kmsweb.utils.DatabasePopulators.CashReceiptDatabasePopulator;
import kmsweb.entities.CashierUserEntity;
import kmsweb.repositories.CashierUserRepository;
import kmsweb.utils.CashierUserFactory;
import kmsweb.utils.DatabasePopulators.CashierUserDatabasePopulator;
import kmsweb.entities.ClaimUserEntity;
import kmsweb.repositories.ClaimUserRepository;
import kmsweb.utils.ClaimUserFactory;
import kmsweb.utils.DatabasePopulators.ClaimUserDatabasePopulator;
import kmsweb.entities.CoTreatingDoctorEntity;
import kmsweb.repositories.CoTreatingDoctorRepository;
import kmsweb.utils.CoTreatingDoctorFactory;
import kmsweb.utils.DatabasePopulators.CoTreatingDoctorDatabasePopulator;
import kmsweb.entities.DailyCareCPPTEntity;
import kmsweb.repositories.DailyCareCPPTRepository;
import kmsweb.utils.DailyCareCPPTFactory;
import kmsweb.utils.DatabasePopulators.DailyCareCPPTDatabasePopulator;
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import kmsweb.repositories.DeliveryMedicalExaminationRecordRepository;
import kmsweb.utils.DeliveryMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.DeliveryMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.DeliveryProgressEntity;
import kmsweb.repositories.DeliveryProgressRepository;
import kmsweb.utils.DeliveryProgressFactory;
import kmsweb.utils.DatabasePopulators.DeliveryProgressDatabasePopulator;
import kmsweb.entities.DiagnosticStaffExaminationSummaryEntity;
import kmsweb.repositories.DiagnosticStaffExaminationSummaryRepository;
import kmsweb.utils.DiagnosticStaffExaminationSummaryFactory;
import kmsweb.utils.DatabasePopulators.DiagnosticStaffExaminationSummaryDatabasePopulator;
import kmsweb.entities.DiagnosticSupportUserEntity;
import kmsweb.repositories.DiagnosticSupportUserRepository;
import kmsweb.utils.DiagnosticSupportUserFactory;
import kmsweb.utils.DatabasePopulators.DiagnosticSupportUserDatabasePopulator;
import kmsweb.entities.DoctorScheduleEntity;
import kmsweb.repositories.DoctorScheduleRepository;
import kmsweb.utils.DoctorScheduleFactory;
import kmsweb.utils.DatabasePopulators.DoctorScheduleDatabasePopulator;
import kmsweb.entities.DoctorUserEntity;
import kmsweb.repositories.DoctorUserRepository;
import kmsweb.utils.DoctorUserFactory;
import kmsweb.utils.DatabasePopulators.DoctorUserDatabasePopulator;
import kmsweb.entities.FacilityUserEntity;
import kmsweb.repositories.FacilityUserRepository;
import kmsweb.utils.FacilityUserFactory;
import kmsweb.utils.DatabasePopulators.FacilityUserDatabasePopulator;
import kmsweb.entities.FluidBalanceDetailEntity;
import kmsweb.repositories.FluidBalanceDetailRepository;
import kmsweb.utils.FluidBalanceDetailFactory;
import kmsweb.utils.DatabasePopulators.FluidBalanceDetailDatabasePopulator;
import kmsweb.entities.HemodialysisMonitoringEntity;
import kmsweb.repositories.HemodialysisMonitoringRepository;
import kmsweb.utils.HemodialysisMonitoringFactory;
import kmsweb.utils.DatabasePopulators.HemodialysisMonitoringDatabasePopulator;
import kmsweb.entities.HospitalBranchInformationEntity;
import kmsweb.repositories.HospitalBranchInformationRepository;
import kmsweb.utils.HospitalBranchInformationFactory;
import kmsweb.utils.DatabasePopulators.HospitalBranchInformationDatabasePopulator;
import kmsweb.entities.InformedConsentEntity;
import kmsweb.repositories.InformedConsentRepository;
import kmsweb.utils.InformedConsentFactory;
import kmsweb.utils.DatabasePopulators.InformedConsentDatabasePopulator;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.utils.InvoiceFactory;
import kmsweb.utils.DatabasePopulators.InvoiceDatabasePopulator;
import kmsweb.entities.McuPackageItemEntity;
import kmsweb.repositories.McuPackageItemRepository;
import kmsweb.utils.McuPackageItemFactory;
import kmsweb.utils.DatabasePopulators.McuPackageItemDatabasePopulator;
import kmsweb.entities.ManagementUserEntity;
import kmsweb.repositories.ManagementUserRepository;
import kmsweb.utils.ManagementUserFactory;
import kmsweb.utils.DatabasePopulators.ManagementUserDatabasePopulator;
import kmsweb.entities.MedicalCertificateDischargeResumeEntity;
import kmsweb.repositories.MedicalCertificateDischargeResumeRepository;
import kmsweb.utils.MedicalCertificateDischargeResumeFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificateDischargeResumeDatabasePopulator;
import kmsweb.entities.MedicalCertificateBirthEntity;
import kmsweb.repositories.MedicalCertificateBirthRepository;
import kmsweb.utils.MedicalCertificateBirthFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificateBirthDatabasePopulator;
import kmsweb.entities.MedicalCertificateHospitalizationEntity;
import kmsweb.repositories.MedicalCertificateHospitalizationRepository;
import kmsweb.utils.MedicalCertificateHospitalizationFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificateHospitalizationDatabasePopulator;
import kmsweb.entities.MedicalCertificateMedicalAttendanceEntity;
import kmsweb.repositories.MedicalCertificateMedicalAttendanceRepository;
import kmsweb.utils.MedicalCertificateMedicalAttendanceFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificateMedicalAttendanceDatabasePopulator;
import kmsweb.entities.MedicalCertificateMentalHealthEntity;
import kmsweb.repositories.MedicalCertificateMentalHealthRepository;
import kmsweb.utils.MedicalCertificateMentalHealthFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificateMentalHealthDatabasePopulator;
import kmsweb.entities.MedicalCertificatePhysicalHealthEntity;
import kmsweb.repositories.MedicalCertificatePhysicalHealthRepository;
import kmsweb.utils.MedicalCertificatePhysicalHealthFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificatePhysicalHealthDatabasePopulator;
import kmsweb.entities.MedicalCertificateRestrictedWorkEntity;
import kmsweb.repositories.MedicalCertificateRestrictedWorkRepository;
import kmsweb.utils.MedicalCertificateRestrictedWorkFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificateRestrictedWorkDatabasePopulator;
import kmsweb.entities.MedicalCertificateSickLeaveEntity;
import kmsweb.repositories.MedicalCertificateSickLeaveRepository;
import kmsweb.utils.MedicalCertificateSickLeaveFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificateSickLeaveDatabasePopulator;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.utils.MedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.MedicalExaminationRecordDischargeSummaryEntity;
import kmsweb.repositories.MedicalExaminationRecordDischargeSummaryRepository;
import kmsweb.utils.MedicalExaminationRecordDischargeSummaryFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDischargeSummaryDatabasePopulator;
import kmsweb.entities.MedicalRecordUserEntity;
import kmsweb.repositories.MedicalRecordUserRepository;
import kmsweb.utils.MedicalRecordUserFactory;
import kmsweb.utils.DatabasePopulators.MedicalRecordUserDatabasePopulator;
import kmsweb.entities.MedicalTranscriberUserEntity;
import kmsweb.repositories.MedicalTranscriberUserRepository;
import kmsweb.utils.MedicalTranscriberUserFactory;
import kmsweb.utils.DatabasePopulators.MedicalTranscriberUserDatabasePopulator;
import kmsweb.entities.MedicationAdministeredHistoryEntity;
import kmsweb.repositories.MedicationAdministeredHistoryRepository;
import kmsweb.utils.MedicationAdministeredHistoryFactory;
import kmsweb.utils.DatabasePopulators.MedicationAdministeredHistoryDatabasePopulator;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.utils.MedicationHeaderFactory;
import kmsweb.utils.DatabasePopulators.MedicationHeaderDatabasePopulator;
import kmsweb.entities.NewbornDetailEntity;
import kmsweb.repositories.NewbornDetailRepository;
import kmsweb.utils.NewbornDetailFactory;
import kmsweb.utils.DatabasePopulators.NewbornDetailDatabasePopulator;
import kmsweb.entities.NurseUserEntity;
import kmsweb.repositories.NurseUserRepository;
import kmsweb.utils.NurseUserFactory;
import kmsweb.utils.DatabasePopulators.NurseUserDatabasePopulator;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.utils.OperatingTheaterMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.OperatingTheaterMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.PcareDokterEntity;
import kmsweb.repositories.PcareDokterRepository;
import kmsweb.utils.PcareDokterFactory;
import kmsweb.utils.DatabasePopulators.PcareDokterDatabasePopulator;
import kmsweb.entities.PatientConsentEntity;
import kmsweb.repositories.PatientConsentRepository;
import kmsweb.utils.PatientConsentFactory;
import kmsweb.utils.DatabasePopulators.PatientConsentDatabasePopulator;
import kmsweb.entities.PatientVitalInformationEntity;
import kmsweb.repositories.PatientVitalInformationRepository;
import kmsweb.utils.PatientVitalInformationFactory;
import kmsweb.utils.DatabasePopulators.PatientVitalInformationDatabasePopulator;
import kmsweb.entities.PharmacyUserEntity;
import kmsweb.repositories.PharmacyUserRepository;
import kmsweb.utils.PharmacyUserFactory;
import kmsweb.utils.DatabasePopulators.PharmacyUserDatabasePopulator;
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.repositories.PreoperativeRecordsRepository;
import kmsweb.utils.PreoperativeRecordsFactory;
import kmsweb.utils.DatabasePopulators.PreoperativeRecordsDatabasePopulator;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.utils.PrescriptionHeaderFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionHeaderDatabasePopulator;
import kmsweb.entities.ProcessWorkflowEntity;
import kmsweb.repositories.ProcessWorkflowRepository;
import kmsweb.utils.ProcessWorkflowFactory;
import kmsweb.utils.DatabasePopulators.ProcessWorkflowDatabasePopulator;
import kmsweb.entities.PurchasingUserEntity;
import kmsweb.repositories.PurchasingUserRepository;
import kmsweb.utils.PurchasingUserFactory;
import kmsweb.utils.DatabasePopulators.PurchasingUserDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.RegistrationUserEntity;
import kmsweb.repositories.RegistrationUserRepository;
import kmsweb.utils.RegistrationUserFactory;
import kmsweb.utils.DatabasePopulators.RegistrationUserDatabasePopulator;
import kmsweb.entities.RoomTransferEntity;
import kmsweb.repositories.RoomTransferRepository;
import kmsweb.utils.RoomTransferFactory;
import kmsweb.utils.DatabasePopulators.RoomTransferDatabasePopulator;
import kmsweb.entities.SampleCollectionItemsEntity;
import kmsweb.repositories.SampleCollectionItemsRepository;
import kmsweb.utils.SampleCollectionItemsFactory;
import kmsweb.utils.DatabasePopulators.SampleCollectionItemsDatabasePopulator;
import kmsweb.entities.ServiceEntity;
import kmsweb.repositories.ServiceRepository;
import kmsweb.utils.ServiceFactory;
import kmsweb.utils.DatabasePopulators.ServiceDatabasePopulator;
import kmsweb.entities.SystemAdminUserEntity;
import kmsweb.repositories.SystemAdminUserRepository;
import kmsweb.utils.SystemAdminUserFactory;
import kmsweb.utils.DatabasePopulators.SystemAdminUserDatabasePopulator;
import kmsweb.entities.TransferOrderStockDetailEntity;
import kmsweb.repositories.TransferOrderStockDetailRepository;
import kmsweb.utils.TransferOrderStockDetailFactory;
import kmsweb.utils.DatabasePopulators.TransferOrderStockDetailDatabasePopulator;
import kmsweb.entities.VaccinationOrderEntity;
import kmsweb.repositories.VaccinationOrderRepository;
import kmsweb.utils.VaccinationOrderFactory;
import kmsweb.utils.DatabasePopulators.VaccinationOrderDatabasePopulator;
import kmsweb.entities.WarehouseUserEntity;
import kmsweb.repositories.WarehouseUserRepository;
import kmsweb.utils.WarehouseUserFactory;
import kmsweb.utils.DatabasePopulators.WarehouseUserDatabasePopulator;
import kmsweb.repositories.auditing.AuditingRepository;

import javax.validation.Validator;

import java.util.*;
import java.util.stream.Collectors;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestConfiguration.class)
@ActiveProfiles("test")
// % protected region % [Add any additional class annotations here] off begin
// % protected region % [Add any additional class annotations here] end
public class StaffServiceIntegrationTest {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private StaffService staffService;

	private final StaffFactory staffFactory = new StaffFactory();

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	@Autowired
	private AdministrationUserRepository administrationUserRepository;

	@Autowired
	private AdministrationUserDatabasePopulator administrationUserDatabasePopulator;

	private final AdministrationUserFactory administrationUserFactory = new AdministrationUserFactory();

	@Autowired
	private AdministratorRepository administratorRepository;

	@Autowired
	private AdministratorDatabasePopulator administratorDatabasePopulator;

	private final AdministratorFactory administratorFactory = new AdministratorFactory();

	@Autowired
	private AmendmentDetailRepository amendmentDetailRepository;

	@Autowired
	private AmendmentDetailDatabasePopulator amendmentDetailDatabasePopulator;

	private final AmendmentDetailFactory amendmentDetailFactory = new AmendmentDetailFactory();

	@Autowired
	private BpjsDoctorMappingRepository bpjsDoctorMappingRepository;

	@Autowired
	private BpjsDoctorMappingDatabasePopulator bpjsDoctorMappingDatabasePopulator;

	private final BpjsDoctorMappingFactory bpjsDoctorMappingFactory = new BpjsDoctorMappingFactory();

	@Autowired
	private CashReceiptRepository cashReceiptRepository;

	@Autowired
	private CashReceiptDatabasePopulator cashReceiptDatabasePopulator;

	private final CashReceiptFactory cashReceiptFactory = new CashReceiptFactory();

	@Autowired
	private CashierUserRepository cashierUserRepository;

	@Autowired
	private CashierUserDatabasePopulator cashierUserDatabasePopulator;

	private final CashierUserFactory cashierUserFactory = new CashierUserFactory();

	@Autowired
	private ClaimUserRepository claimUserRepository;

	@Autowired
	private ClaimUserDatabasePopulator claimUserDatabasePopulator;

	private final ClaimUserFactory claimUserFactory = new ClaimUserFactory();

	@Autowired
	private CoTreatingDoctorRepository coTreatingDoctorRepository;

	@Autowired
	private CoTreatingDoctorDatabasePopulator coTreatingDoctorDatabasePopulator;

	private final CoTreatingDoctorFactory coTreatingDoctorFactory = new CoTreatingDoctorFactory();

	@Autowired
	private DailyCareCPPTRepository dailyCareCPPTRepository;

	@Autowired
	private DailyCareCPPTDatabasePopulator dailyCareCPPTDatabasePopulator;

	private final DailyCareCPPTFactory dailyCareCPPTFactory = new DailyCareCPPTFactory();

	@Autowired
	private DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository;

	@Autowired
	private DeliveryMedicalExaminationRecordDatabasePopulator deliveryMedicalExaminationRecordDatabasePopulator;

	private final DeliveryMedicalExaminationRecordFactory deliveryMedicalExaminationRecordFactory = new DeliveryMedicalExaminationRecordFactory();

	@Autowired
	private DeliveryProgressRepository deliveryProgressRepository;

	@Autowired
	private DeliveryProgressDatabasePopulator deliveryProgressDatabasePopulator;

	private final DeliveryProgressFactory deliveryProgressFactory = new DeliveryProgressFactory();

	@Autowired
	private DiagnosticStaffExaminationSummaryRepository diagnosticStaffExaminationSummaryRepository;

	@Autowired
	private DiagnosticStaffExaminationSummaryDatabasePopulator diagnosticStaffExaminationSummaryDatabasePopulator;

	private final DiagnosticStaffExaminationSummaryFactory diagnosticStaffExaminationSummaryFactory = new DiagnosticStaffExaminationSummaryFactory();

	@Autowired
	private DiagnosticSupportUserRepository diagnosticSupportUserRepository;

	@Autowired
	private DiagnosticSupportUserDatabasePopulator diagnosticSupportUserDatabasePopulator;

	private final DiagnosticSupportUserFactory diagnosticSupportUserFactory = new DiagnosticSupportUserFactory();

	@Autowired
	private DoctorScheduleRepository doctorScheduleRepository;

	@Autowired
	private DoctorScheduleDatabasePopulator doctorScheduleDatabasePopulator;

	private final DoctorScheduleFactory doctorScheduleFactory = new DoctorScheduleFactory();

	@Autowired
	private DoctorUserRepository doctorUserRepository;

	@Autowired
	private DoctorUserDatabasePopulator doctorUserDatabasePopulator;

	private final DoctorUserFactory doctorUserFactory = new DoctorUserFactory();

	@Autowired
	private FacilityUserRepository facilityUserRepository;

	@Autowired
	private FacilityUserDatabasePopulator facilityUserDatabasePopulator;

	private final FacilityUserFactory facilityUserFactory = new FacilityUserFactory();

	@Autowired
	private FluidBalanceDetailRepository fluidBalanceDetailRepository;

	@Autowired
	private FluidBalanceDetailDatabasePopulator fluidBalanceDetailDatabasePopulator;

	private final FluidBalanceDetailFactory fluidBalanceDetailFactory = new FluidBalanceDetailFactory();

	@Autowired
	private HemodialysisMonitoringRepository hemodialysisMonitoringRepository;

	@Autowired
	private HemodialysisMonitoringDatabasePopulator hemodialysisMonitoringDatabasePopulator;

	private final HemodialysisMonitoringFactory hemodialysisMonitoringFactory = new HemodialysisMonitoringFactory();

	@Autowired
	private HospitalBranchInformationRepository hospitalBranchInformationRepository;

	@Autowired
	private HospitalBranchInformationDatabasePopulator hospitalBranchInformationDatabasePopulator;

	private final HospitalBranchInformationFactory hospitalBranchInformationFactory = new HospitalBranchInformationFactory();

	@Autowired
	private InformedConsentRepository informedConsentRepository;

	@Autowired
	private InformedConsentDatabasePopulator informedConsentDatabasePopulator;

	private final InformedConsentFactory informedConsentFactory = new InformedConsentFactory();

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDatabasePopulator invoiceDatabasePopulator;

	private final InvoiceFactory invoiceFactory = new InvoiceFactory();

	@Autowired
	private McuPackageItemRepository mcuPackageItemRepository;

	@Autowired
	private McuPackageItemDatabasePopulator mcuPackageItemDatabasePopulator;

	private final McuPackageItemFactory mcuPackageItemFactory = new McuPackageItemFactory();

	@Autowired
	private ManagementUserRepository managementUserRepository;

	@Autowired
	private ManagementUserDatabasePopulator managementUserDatabasePopulator;

	private final ManagementUserFactory managementUserFactory = new ManagementUserFactory();

	@Autowired
	private MedicalCertificateDischargeResumeRepository medicalCertificateDischargeResumeRepository;

	@Autowired
	private MedicalCertificateDischargeResumeDatabasePopulator medicalCertificateDischargeResumeDatabasePopulator;

	private final MedicalCertificateDischargeResumeFactory medicalCertificateDischargeResumeFactory = new MedicalCertificateDischargeResumeFactory();

	@Autowired
	private MedicalCertificateBirthRepository medicalCertificateBirthRepository;

	@Autowired
	private MedicalCertificateBirthDatabasePopulator medicalCertificateBirthDatabasePopulator;

	private final MedicalCertificateBirthFactory medicalCertificateBirthFactory = new MedicalCertificateBirthFactory();

	@Autowired
	private MedicalCertificateHospitalizationRepository medicalCertificateHospitalizationRepository;

	@Autowired
	private MedicalCertificateHospitalizationDatabasePopulator medicalCertificateHospitalizationDatabasePopulator;

	private final MedicalCertificateHospitalizationFactory medicalCertificateHospitalizationFactory = new MedicalCertificateHospitalizationFactory();

	@Autowired
	private MedicalCertificateMedicalAttendanceRepository medicalCertificateMedicalAttendanceRepository;

	@Autowired
	private MedicalCertificateMedicalAttendanceDatabasePopulator medicalCertificateMedicalAttendanceDatabasePopulator;

	private final MedicalCertificateMedicalAttendanceFactory medicalCertificateMedicalAttendanceFactory = new MedicalCertificateMedicalAttendanceFactory();

	@Autowired
	private MedicalCertificateMentalHealthRepository medicalCertificateMentalHealthRepository;

	@Autowired
	private MedicalCertificateMentalHealthDatabasePopulator medicalCertificateMentalHealthDatabasePopulator;

	private final MedicalCertificateMentalHealthFactory medicalCertificateMentalHealthFactory = new MedicalCertificateMentalHealthFactory();

	@Autowired
	private MedicalCertificatePhysicalHealthRepository medicalCertificatePhysicalHealthRepository;

	@Autowired
	private MedicalCertificatePhysicalHealthDatabasePopulator medicalCertificatePhysicalHealthDatabasePopulator;

	private final MedicalCertificatePhysicalHealthFactory medicalCertificatePhysicalHealthFactory = new MedicalCertificatePhysicalHealthFactory();

	@Autowired
	private MedicalCertificateRestrictedWorkRepository medicalCertificateRestrictedWorkRepository;

	@Autowired
	private MedicalCertificateRestrictedWorkDatabasePopulator medicalCertificateRestrictedWorkDatabasePopulator;

	private final MedicalCertificateRestrictedWorkFactory medicalCertificateRestrictedWorkFactory = new MedicalCertificateRestrictedWorkFactory();

	@Autowired
	private MedicalCertificateSickLeaveRepository medicalCertificateSickLeaveRepository;

	@Autowired
	private MedicalCertificateSickLeaveDatabasePopulator medicalCertificateSickLeaveDatabasePopulator;

	private final MedicalCertificateSickLeaveFactory medicalCertificateSickLeaveFactory = new MedicalCertificateSickLeaveFactory();

	@Autowired
	private MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	@Autowired
	private MedicalExaminationRecordDatabasePopulator medicalExaminationRecordDatabasePopulator;

	private final MedicalExaminationRecordFactory medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();

	@Autowired
	private MedicalExaminationRecordDischargeSummaryRepository medicalExaminationRecordDischargeSummaryRepository;

	@Autowired
	private MedicalExaminationRecordDischargeSummaryDatabasePopulator medicalExaminationRecordDischargeSummaryDatabasePopulator;

	private final MedicalExaminationRecordDischargeSummaryFactory medicalExaminationRecordDischargeSummaryFactory = new MedicalExaminationRecordDischargeSummaryFactory();

	@Autowired
	private MedicalRecordUserRepository medicalRecordUserRepository;

	@Autowired
	private MedicalRecordUserDatabasePopulator medicalRecordUserDatabasePopulator;

	private final MedicalRecordUserFactory medicalRecordUserFactory = new MedicalRecordUserFactory();

	@Autowired
	private MedicalTranscriberUserRepository medicalTranscriberUserRepository;

	@Autowired
	private MedicalTranscriberUserDatabasePopulator medicalTranscriberUserDatabasePopulator;

	private final MedicalTranscriberUserFactory medicalTranscriberUserFactory = new MedicalTranscriberUserFactory();

	@Autowired
	private MedicationAdministeredHistoryRepository medicationAdministeredHistoryRepository;

	@Autowired
	private MedicationAdministeredHistoryDatabasePopulator medicationAdministeredHistoryDatabasePopulator;

	private final MedicationAdministeredHistoryFactory medicationAdministeredHistoryFactory = new MedicationAdministeredHistoryFactory();

	@Autowired
	private MedicationHeaderRepository medicationHeaderRepository;

	@Autowired
	private MedicationHeaderDatabasePopulator medicationHeaderDatabasePopulator;

	private final MedicationHeaderFactory medicationHeaderFactory = new MedicationHeaderFactory();

	@Autowired
	private NewbornDetailRepository newbornDetailRepository;

	@Autowired
	private NewbornDetailDatabasePopulator newbornDetailDatabasePopulator;

	private final NewbornDetailFactory newbornDetailFactory = new NewbornDetailFactory();

	@Autowired
	private NurseUserRepository nurseUserRepository;

	@Autowired
	private NurseUserDatabasePopulator nurseUserDatabasePopulator;

	private final NurseUserFactory nurseUserFactory = new NurseUserFactory();

	@Autowired
	private OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;

	@Autowired
	private OperatingTheaterMedicalExaminationRecordDatabasePopulator operatingTheaterMedicalExaminationRecordDatabasePopulator;

	private final OperatingTheaterMedicalExaminationRecordFactory operatingTheaterMedicalExaminationRecordFactory = new OperatingTheaterMedicalExaminationRecordFactory();

	@Autowired
	private PcareDokterRepository pcareDokterRepository;

	@Autowired
	private PcareDokterDatabasePopulator pcareDokterDatabasePopulator;

	private final PcareDokterFactory pcareDokterFactory = new PcareDokterFactory();

	@Autowired
	private PatientConsentRepository patientConsentRepository;

	@Autowired
	private PatientConsentDatabasePopulator patientConsentDatabasePopulator;

	private final PatientConsentFactory patientConsentFactory = new PatientConsentFactory();

	@Autowired
	private PatientVitalInformationRepository patientVitalInformationRepository;

	@Autowired
	private PatientVitalInformationDatabasePopulator patientVitalInformationDatabasePopulator;

	private final PatientVitalInformationFactory patientVitalInformationFactory = new PatientVitalInformationFactory();

	@Autowired
	private PharmacyUserRepository pharmacyUserRepository;

	@Autowired
	private PharmacyUserDatabasePopulator pharmacyUserDatabasePopulator;

	private final PharmacyUserFactory pharmacyUserFactory = new PharmacyUserFactory();

	@Autowired
	private PreoperativeRecordsRepository preoperativeRecordsRepository;

	@Autowired
	private PreoperativeRecordsDatabasePopulator preoperativeRecordsDatabasePopulator;

	private final PreoperativeRecordsFactory preoperativeRecordsFactory = new PreoperativeRecordsFactory();

	@Autowired
	private PrescriptionHeaderRepository prescriptionHeaderRepository;

	@Autowired
	private PrescriptionHeaderDatabasePopulator prescriptionHeaderDatabasePopulator;

	private final PrescriptionHeaderFactory prescriptionHeaderFactory = new PrescriptionHeaderFactory();

	@Autowired
	private ProcessWorkflowRepository processWorkflowRepository;

	@Autowired
	private ProcessWorkflowDatabasePopulator processWorkflowDatabasePopulator;

	private final ProcessWorkflowFactory processWorkflowFactory = new ProcessWorkflowFactory();

	@Autowired
	private PurchasingUserRepository purchasingUserRepository;

	@Autowired
	private PurchasingUserDatabasePopulator purchasingUserDatabasePopulator;

	private final PurchasingUserFactory purchasingUserFactory = new PurchasingUserFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private RegistrationUserRepository registrationUserRepository;

	@Autowired
	private RegistrationUserDatabasePopulator registrationUserDatabasePopulator;

	private final RegistrationUserFactory registrationUserFactory = new RegistrationUserFactory();

	@Autowired
	private RoomTransferRepository roomTransferRepository;

	@Autowired
	private RoomTransferDatabasePopulator roomTransferDatabasePopulator;

	private final RoomTransferFactory roomTransferFactory = new RoomTransferFactory();

	@Autowired
	private SampleCollectionItemsRepository sampleCollectionItemsRepository;

	@Autowired
	private SampleCollectionItemsDatabasePopulator sampleCollectionItemsDatabasePopulator;

	private final SampleCollectionItemsFactory sampleCollectionItemsFactory = new SampleCollectionItemsFactory();

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ServiceDatabasePopulator serviceDatabasePopulator;

	private final ServiceFactory serviceFactory = new ServiceFactory();

	@Autowired
	private SystemAdminUserRepository systemAdminUserRepository;

	@Autowired
	private SystemAdminUserDatabasePopulator systemAdminUserDatabasePopulator;

	private final SystemAdminUserFactory systemAdminUserFactory = new SystemAdminUserFactory();

	@Autowired
	private TransferOrderStockDetailRepository transferOrderStockDetailRepository;

	@Autowired
	private TransferOrderStockDetailDatabasePopulator transferOrderStockDetailDatabasePopulator;

	private final TransferOrderStockDetailFactory transferOrderStockDetailFactory = new TransferOrderStockDetailFactory();

	@Autowired
	private VaccinationOrderRepository vaccinationOrderRepository;

	@Autowired
	private VaccinationOrderDatabasePopulator vaccinationOrderDatabasePopulator;

	private final VaccinationOrderFactory vaccinationOrderFactory = new VaccinationOrderFactory();

	@Autowired
	private WarehouseUserRepository warehouseUserRepository;

	@Autowired
	private WarehouseUserDatabasePopulator warehouseUserDatabasePopulator;

	private final WarehouseUserFactory warehouseUserFactory = new WarehouseUserFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		staffService = new StaffService(
			administrationUserRepository,
			administratorRepository,
			amendmentDetailRepository,
			bpjsDoctorMappingRepository,
			cashReceiptRepository,
			cashierUserRepository,
			claimUserRepository,
			coTreatingDoctorRepository,
			dailyCareCPPTRepository,
			deliveryMedicalExaminationRecordRepository,
			deliveryProgressRepository,
			diagnosticStaffExaminationSummaryRepository,
			diagnosticSupportUserRepository,
			doctorScheduleRepository,
			doctorUserRepository,
			facilityUserRepository,
			fluidBalanceDetailRepository,
			hemodialysisMonitoringRepository,
			hospitalBranchInformationRepository,
			informedConsentRepository,
			invoiceRepository,
			mcuPackageItemRepository,
			managementUserRepository,
			medicalCertificateDischargeResumeRepository,
			medicalCertificateBirthRepository,
			medicalCertificateHospitalizationRepository,
			medicalCertificateMedicalAttendanceRepository,
			medicalCertificateMentalHealthRepository,
			medicalCertificatePhysicalHealthRepository,
			medicalCertificateRestrictedWorkRepository,
			medicalCertificateSickLeaveRepository,
			medicalExaminationRecordRepository,
			medicalExaminationRecordDischargeSummaryRepository,
			medicalRecordUserRepository,
			medicalTranscriberUserRepository,
			medicationAdministeredHistoryRepository,
			medicationHeaderRepository,
			newbornDetailRepository,
			nurseUserRepository,
			operatingTheaterMedicalExaminationRecordRepository,
			pcareDokterRepository,
			patientConsentRepository,
			patientVitalInformationRepository,
			pharmacyUserRepository,
			preoperativeRecordsRepository,
			prescriptionHeaderRepository,
			processWorkflowRepository,
			purchasingUserRepository,
			registrationRepository,
			registrationUserRepository,
			roomTransferRepository,
			sampleCollectionItemsRepository,
			serviceRepository,
			systemAdminUserRepository,
			transferOrderStockDetailRepository,
			vaccinationOrderRepository,
			warehouseUserRepository,
			validator,
			auditRepository,
			staffRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewStaffEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		StaffEntity staffEntity = staffFactory.getObject(false, false);

		StaffEntity updatedEntity = staffService.updateOldData(staffEntity);
		Assertions.assertEquals(staffEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingStaffEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			StaffEntity staffEntity;
			StaffEntity entityWithUpdatedValues;

			try {
				staffEntity = staffFactory.getObject(false, false);
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = staffFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			staffEntity = staffService.create(staffEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(staffEntity.getId());

			StaffEntity updatedEntity = staffService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithStaffEntityWithNonExistentId_ShouldThrowException() throws Exception {
		StaffEntity staffEntity = staffFactory.getObject(false, false);
		staffEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			staffService.updateOldData(staffEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingStaffEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			StaffEntity staffEntity;
			StaffEntity updatedStaffEntity;

			AdministrationUserEntity administrationUserEntity;

			CashierUserEntity cashierUserEntity;

			ClaimUserEntity claimUserEntity;

			DiagnosticSupportUserEntity diagnosticSupportUserEntity;

			DoctorUserEntity doctorUserEntity;

			FacilityUserEntity facilityUserEntity;

			ManagementUserEntity managementUserEntity;

			MedicalRecordUserEntity medicalRecordUserEntity;

			MedicalTranscriberUserEntity medicalTranscriberUserEntity;

			NurseUserEntity nurseUserEntity;

			PharmacyUserEntity pharmacyUserEntity;

			PurchasingUserEntity purchasingUserEntity;

			RegistrationUserEntity registrationUserEntity;

			SystemAdminUserEntity systemAdminUserEntity;

			WarehouseUserEntity warehouseUserEntity;

			AdministratorEntity administratorEntity;

			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;

			PcareDokterEntity pcareDokterEntity;

			ServiceEntity serviceEntity;

			Set<InformedConsentEntity> accompanyingConsentsEntities;

			Set<AmendmentDetailEntity> amendmentDetailsEntities;

			Set<PreoperativeRecordsEntity> anesthesiaMedicalTranscriberEntities;

			Set<PreoperativeRecordsEntity> anesthesiologistEntities;

			Set<PreoperativeRecordsEntity> anesthesiologyNurseEntities;

			Set<CashReceiptEntity> cashierStaffEntities;

			Set<CoTreatingDoctorEntity> coTreatingDoctorsEntities;

			Set<DailyCareCPPTEntity> dailyCareCPPTsCreatedByStaffEntities;

			Set<DailyCareCPPTEntity> dailyCareCPPTsDoctorInChargeEntities;

			Set<DailyCareCPPTEntity> dailyCareCPPTsMedicalTranscriberEntities;

			Set<DeliveryProgressEntity> deliveryProgressesEntities;

			Set<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummariesEntities;

			Set<RegistrationEntity> dismissalReferringStaffEntities;

			Set<DoctorScheduleEntity> doctorSchedulesEntities;

			Set<MedicalExaminationRecordEntity> doctorOnExaminationEntities;

			Set<FluidBalanceDetailEntity> fluidBalanceDetailsEntities;

			Set<HemodialysisMonitoringEntity> hemodialysisMonitoringsEntities;

			Set<HospitalBranchInformationEntity> hospitalBranchInformationsEntities;

			Set<InformedConsentEntity> informingConsentsEntities;

			Set<InvoiceEntity> invoicesEntities;

			Set<McuPackageItemEntity> mcuPackageItemsEntities;

			Set<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumesEntities;

			Set<MedicalCertificateBirthEntity> medicalCertificateBirthsEntities;

			Set<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizationsEntities;

			Set<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummarysEntities;

			Set<MedicalExaminationRecordEntity> medicalRecordTranscriberEntities;

			Set<MedicalCertificateMedicalAttendanceEntity> medicalStaffOfMedicalAttendancesCertificateEntities;

			Set<MedicalCertificateMentalHealthEntity> medicalStaffOfMentalHealthsEntities;

			Set<MedicalCertificatePhysicalHealthEntity> medicalStaffOfPhysicalHealthsEntities;

			Set<MedicalCertificateRestrictedWorkEntity> medicalStaffOfRestrictedWorksCertificateEntities;

			Set<MedicalCertificateSickLeaveEntity> medicalStaffOfSickLeavesCertificateEntities;

			Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotriesEntities;

			Set<MedicationHeaderEntity> medicationHeadersEntities;

			Set<DeliveryMedicalExaminationRecordEntity> midwivesEntities;

			Set<MedicalExaminationRecordEntity> nurseEntities;

			Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailSurgicalNursingEntities;

			Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailsAnesthesiaNursingEntities;

			Set<PatientConsentEntity> patientConsentsEntities;

			Set<PatientVitalInformationEntity> patientVitalInformationsEntities;

			Set<NewbornDetailEntity> pediatricianInChargeEntities;

			Set<PrescriptionHeaderEntity> prescriptionHeadersEntities;

			Set<ProcessWorkflowEntity> processWorkflowLogsEntities;

			Set<RegistrationEntity> registrationsEntities;

			Set<RegistrationEntity> requestedByEntities;

			Set<RoomTransferEntity> roomTransfersEntities;

			Set<SampleCollectionItemsEntity> sampleCollectionStaffsEntities;

			Set<SampleCollectionItemsEntity> sampleDeliveryStaffsEntities;

			Set<SampleCollectionItemsEntity> sampleProcessingStaffsEntities;

			Set<PreoperativeRecordsEntity> surgeonEntities;

			Set<PreoperativeRecordsEntity> surgicalMedicalTranscriberEntities;

			Set<PreoperativeRecordsEntity> surgicalNurseEntities;

			Set<TransferOrderStockDetailEntity> transferOrderStockDetailsEntities;

			Set<VaccinationOrderEntity> vaccinationOrdersEntities;

			Set<ServiceEntity> servicesEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				staffEntity = staffFactory.getObject(true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			/*
				As this test is checking that removing a reference entity works, we need to add the
				reference entities to the database
			 */
			administrationUserEntity = staffEntity.getAdministrationUser();
			try {
				administrationUserDatabasePopulator.populateRelatedEntitiesInDatabase(administrationUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			administrationUserEntity = administrationUserRepository.save(administrationUserEntity);
			staffEntity.setAdministrationUserId(administrationUserEntity.getId());

			cashierUserEntity = staffEntity.getCashierUser();
			try {
				cashierUserDatabasePopulator.populateRelatedEntitiesInDatabase(cashierUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			cashierUserEntity = cashierUserRepository.save(cashierUserEntity);
			staffEntity.setCashierUserId(cashierUserEntity.getId());

			claimUserEntity = staffEntity.getClaimUser();
			try {
				claimUserDatabasePopulator.populateRelatedEntitiesInDatabase(claimUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			claimUserEntity = claimUserRepository.save(claimUserEntity);
			staffEntity.setClaimUserId(claimUserEntity.getId());

			diagnosticSupportUserEntity = staffEntity.getDiagnosticSupportUser();
			try {
				diagnosticSupportUserDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosticSupportUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			diagnosticSupportUserEntity = diagnosticSupportUserRepository.save(diagnosticSupportUserEntity);
			staffEntity.setDiagnosticSupportUserId(diagnosticSupportUserEntity.getId());

			doctorUserEntity = staffEntity.getDoctorUser();
			try {
				doctorUserDatabasePopulator.populateRelatedEntitiesInDatabase(doctorUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			doctorUserEntity = doctorUserRepository.save(doctorUserEntity);
			staffEntity.setDoctorUserId(doctorUserEntity.getId());

			facilityUserEntity = staffEntity.getFacilityUser();
			try {
				facilityUserDatabasePopulator.populateRelatedEntitiesInDatabase(facilityUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			facilityUserEntity = facilityUserRepository.save(facilityUserEntity);
			staffEntity.setFacilityUserId(facilityUserEntity.getId());

			managementUserEntity = staffEntity.getManagementUser();
			try {
				managementUserDatabasePopulator.populateRelatedEntitiesInDatabase(managementUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			managementUserEntity = managementUserRepository.save(managementUserEntity);
			staffEntity.setManagementUserId(managementUserEntity.getId());

			medicalRecordUserEntity = staffEntity.getMedicalRecordUser();
			try {
				medicalRecordUserDatabasePopulator.populateRelatedEntitiesInDatabase(medicalRecordUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalRecordUserEntity = medicalRecordUserRepository.save(medicalRecordUserEntity);
			staffEntity.setMedicalRecordUserId(medicalRecordUserEntity.getId());

			medicalTranscriberUserEntity = staffEntity.getMedicalTranscriberUser();
			try {
				medicalTranscriberUserDatabasePopulator.populateRelatedEntitiesInDatabase(medicalTranscriberUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalTranscriberUserEntity = medicalTranscriberUserRepository.save(medicalTranscriberUserEntity);
			staffEntity.setMedicalTranscriberUserId(medicalTranscriberUserEntity.getId());

			nurseUserEntity = staffEntity.getNurseUser();
			try {
				nurseUserDatabasePopulator.populateRelatedEntitiesInDatabase(nurseUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			nurseUserEntity = nurseUserRepository.save(nurseUserEntity);
			staffEntity.setNurseUserId(nurseUserEntity.getId());

			pharmacyUserEntity = staffEntity.getPharmacyUser();
			try {
				pharmacyUserDatabasePopulator.populateRelatedEntitiesInDatabase(pharmacyUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			pharmacyUserEntity = pharmacyUserRepository.save(pharmacyUserEntity);
			staffEntity.setPharmacyUserId(pharmacyUserEntity.getId());

			purchasingUserEntity = staffEntity.getPurchasingUser();
			try {
				purchasingUserDatabasePopulator.populateRelatedEntitiesInDatabase(purchasingUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			purchasingUserEntity = purchasingUserRepository.save(purchasingUserEntity);
			staffEntity.setPurchasingUserId(purchasingUserEntity.getId());

			registrationUserEntity = staffEntity.getRegistrationUser();
			try {
				registrationUserDatabasePopulator.populateRelatedEntitiesInDatabase(registrationUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationUserEntity = registrationUserRepository.save(registrationUserEntity);
			staffEntity.setRegistrationUserId(registrationUserEntity.getId());

			systemAdminUserEntity = staffEntity.getSystemAdminUser();
			try {
				systemAdminUserDatabasePopulator.populateRelatedEntitiesInDatabase(systemAdminUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			systemAdminUserEntity = systemAdminUserRepository.save(systemAdminUserEntity);
			staffEntity.setSystemAdminUserId(systemAdminUserEntity.getId());

			warehouseUserEntity = staffEntity.getWarehouseUser();
			try {
				warehouseUserDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseUserEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseUserEntity = warehouseUserRepository.save(warehouseUserEntity);
			staffEntity.setWarehouseUserId(warehouseUserEntity.getId());

			administratorEntity = staffEntity.getAdministrator();
			try {
				administratorDatabasePopulator.populateRelatedEntitiesInDatabase(administratorEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			administratorEntity = administratorRepository.save(administratorEntity);
			staffEntity.setAdministratorId(administratorEntity.getId());

			bpjsDoctorMappingEntity = staffEntity.getBpjsDoctorMapping();
			try {
				bpjsDoctorMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDoctorMappingEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsDoctorMappingEntity = bpjsDoctorMappingRepository.save(bpjsDoctorMappingEntity);
			staffEntity.setBpjsDoctorMappingId(bpjsDoctorMappingEntity.getId());

			pcareDokterEntity = staffEntity.getPcareDokter();
			try {
				pcareDokterDatabasePopulator.populateRelatedEntitiesInDatabase(pcareDokterEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			pcareDokterEntity = pcareDokterRepository.save(pcareDokterEntity);
			staffEntity.setPcareDokterId(pcareDokterEntity.getId());

			serviceEntity = staffEntity.getService();
			try {
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			serviceEntity = serviceRepository.save(serviceEntity);
			staffEntity.setServiceId(serviceEntity.getId());

			accompanyingConsentsEntities = staffEntity.getAccompanyingConsents();
			Set<UUID> accompanyingConsentsEntityIds = new HashSet<>();
			for (InformedConsentEntity entity : accompanyingConsentsEntities) {
				try {
					informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				accompanyingConsentsEntityIds.add(informedConsentRepository.save(entity).getId());
			}
			staffEntity.setAccompanyingConsentsIds(accompanyingConsentsEntityIds);

			amendmentDetailsEntities = staffEntity.getAmendmentDetails();
			Set<UUID> amendmentDetailsEntityIds = new HashSet<>();
			for (AmendmentDetailEntity entity : amendmentDetailsEntities) {
				try {
					amendmentDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				amendmentDetailsEntityIds.add(amendmentDetailRepository.save(entity).getId());
			}
			staffEntity.setAmendmentDetailsIds(amendmentDetailsEntityIds);

			anesthesiaMedicalTranscriberEntities = staffEntity.getAnesthesiaMedicalTranscriber();
			Set<UUID> anesthesiaMedicalTranscriberEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : anesthesiaMedicalTranscriberEntities) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				anesthesiaMedicalTranscriberEntityIds.add(preoperativeRecordsRepository.save(entity).getId());
			}
			staffEntity.setAnesthesiaMedicalTranscriberIds(anesthesiaMedicalTranscriberEntityIds);

			anesthesiologistEntities = staffEntity.getAnesthesiologist();
			Set<UUID> anesthesiologistEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : anesthesiologistEntities) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				anesthesiologistEntityIds.add(preoperativeRecordsRepository.save(entity).getId());
			}
			staffEntity.setAnesthesiologistIds(anesthesiologistEntityIds);

			anesthesiologyNurseEntities = staffEntity.getAnesthesiologyNurse();
			Set<UUID> anesthesiologyNurseEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : anesthesiologyNurseEntities) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				anesthesiologyNurseEntityIds.add(preoperativeRecordsRepository.save(entity).getId());
			}
			staffEntity.setAnesthesiologyNurseIds(anesthesiologyNurseEntityIds);

			cashierStaffEntities = staffEntity.getCashierStaff();
			Set<UUID> cashierStaffEntityIds = new HashSet<>();
			for (CashReceiptEntity entity : cashierStaffEntities) {
				try {
					cashReceiptDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				cashierStaffEntityIds.add(cashReceiptRepository.save(entity).getId());
			}
			staffEntity.setCashierStaffIds(cashierStaffEntityIds);

			coTreatingDoctorsEntities = staffEntity.getCoTreatingDoctors();
			Set<UUID> coTreatingDoctorsEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : coTreatingDoctorsEntities) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				coTreatingDoctorsEntityIds.add(coTreatingDoctorRepository.save(entity).getId());
			}
			staffEntity.setCoTreatingDoctorsIds(coTreatingDoctorsEntityIds);

			dailyCareCPPTsCreatedByStaffEntities = staffEntity.getDailyCareCPPTsCreatedByStaff();
			Set<UUID> dailyCareCPPTsCreatedByStaffEntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : dailyCareCPPTsCreatedByStaffEntities) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				dailyCareCPPTsCreatedByStaffEntityIds.add(dailyCareCPPTRepository.save(entity).getId());
			}
			staffEntity.setDailyCareCPPTsCreatedByStaffIds(dailyCareCPPTsCreatedByStaffEntityIds);

			dailyCareCPPTsDoctorInChargeEntities = staffEntity.getDailyCareCPPTsDoctorInCharge();
			Set<UUID> dailyCareCPPTsDoctorInChargeEntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : dailyCareCPPTsDoctorInChargeEntities) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				dailyCareCPPTsDoctorInChargeEntityIds.add(dailyCareCPPTRepository.save(entity).getId());
			}
			staffEntity.setDailyCareCPPTsDoctorInChargeIds(dailyCareCPPTsDoctorInChargeEntityIds);

			dailyCareCPPTsMedicalTranscriberEntities = staffEntity.getDailyCareCPPTsMedicalTranscriber();
			Set<UUID> dailyCareCPPTsMedicalTranscriberEntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : dailyCareCPPTsMedicalTranscriberEntities) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				dailyCareCPPTsMedicalTranscriberEntityIds.add(dailyCareCPPTRepository.save(entity).getId());
			}
			staffEntity.setDailyCareCPPTsMedicalTranscriberIds(dailyCareCPPTsMedicalTranscriberEntityIds);

			deliveryProgressesEntities = staffEntity.getDeliveryProgresses();
			Set<UUID> deliveryProgressesEntityIds = new HashSet<>();
			for (DeliveryProgressEntity entity : deliveryProgressesEntities) {
				try {
					deliveryProgressDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				deliveryProgressesEntityIds.add(deliveryProgressRepository.save(entity).getId());
			}
			staffEntity.setDeliveryProgressesIds(deliveryProgressesEntityIds);

			diagnosticStaffExaminationSummariesEntities = staffEntity.getDiagnosticStaffExaminationSummaries();
			Set<UUID> diagnosticStaffExaminationSummariesEntityIds = new HashSet<>();
			for (DiagnosticStaffExaminationSummaryEntity entity : diagnosticStaffExaminationSummariesEntities) {
				try {
					diagnosticStaffExaminationSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				diagnosticStaffExaminationSummariesEntityIds.add(diagnosticStaffExaminationSummaryRepository.save(entity).getId());
			}
			staffEntity.setDiagnosticStaffExaminationSummariesIds(diagnosticStaffExaminationSummariesEntityIds);

			dismissalReferringStaffEntities = staffEntity.getDismissalReferringStaff();
			Set<UUID> dismissalReferringStaffEntityIds = new HashSet<>();
			for (RegistrationEntity entity : dismissalReferringStaffEntities) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				dismissalReferringStaffEntityIds.add(registrationRepository.save(entity).getId());
			}
			staffEntity.setDismissalReferringStaffIds(dismissalReferringStaffEntityIds);

			doctorSchedulesEntities = staffEntity.getDoctorSchedules();
			Set<UUID> doctorSchedulesEntityIds = new HashSet<>();
			for (DoctorScheduleEntity entity : doctorSchedulesEntities) {
				try {
					doctorScheduleDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				doctorSchedulesEntityIds.add(doctorScheduleRepository.save(entity).getId());
			}
			staffEntity.setDoctorSchedulesIds(doctorSchedulesEntityIds);

			doctorOnExaminationEntities = staffEntity.getDoctorOnExamination();
			Set<UUID> doctorOnExaminationEntityIds = new HashSet<>();
			for (MedicalExaminationRecordEntity entity : doctorOnExaminationEntities) {
				try {
					medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				doctorOnExaminationEntityIds.add(medicalExaminationRecordRepository.save(entity).getId());
			}
			staffEntity.setDoctorOnExaminationIds(doctorOnExaminationEntityIds);

			fluidBalanceDetailsEntities = staffEntity.getFluidBalanceDetails();
			Set<UUID> fluidBalanceDetailsEntityIds = new HashSet<>();
			for (FluidBalanceDetailEntity entity : fluidBalanceDetailsEntities) {
				try {
					fluidBalanceDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				fluidBalanceDetailsEntityIds.add(fluidBalanceDetailRepository.save(entity).getId());
			}
			staffEntity.setFluidBalanceDetailsIds(fluidBalanceDetailsEntityIds);

			hemodialysisMonitoringsEntities = staffEntity.getHemodialysisMonitorings();
			Set<UUID> hemodialysisMonitoringsEntityIds = new HashSet<>();
			for (HemodialysisMonitoringEntity entity : hemodialysisMonitoringsEntities) {
				try {
					hemodialysisMonitoringDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				hemodialysisMonitoringsEntityIds.add(hemodialysisMonitoringRepository.save(entity).getId());
			}
			staffEntity.setHemodialysisMonitoringsIds(hemodialysisMonitoringsEntityIds);

			hospitalBranchInformationsEntities = staffEntity.getHospitalBranchInformations();
			Set<UUID> hospitalBranchInformationsEntityIds = new HashSet<>();
			for (HospitalBranchInformationEntity entity : hospitalBranchInformationsEntities) {
				try {
					hospitalBranchInformationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				hospitalBranchInformationsEntityIds.add(hospitalBranchInformationRepository.save(entity).getId());
			}
			staffEntity.setHospitalBranchInformationsIds(hospitalBranchInformationsEntityIds);

			informingConsentsEntities = staffEntity.getInformingConsents();
			Set<UUID> informingConsentsEntityIds = new HashSet<>();
			for (InformedConsentEntity entity : informingConsentsEntities) {
				try {
					informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				informingConsentsEntityIds.add(informedConsentRepository.save(entity).getId());
			}
			staffEntity.setInformingConsentsIds(informingConsentsEntityIds);

			invoicesEntities = staffEntity.getInvoices();
			Set<UUID> invoicesEntityIds = new HashSet<>();
			for (InvoiceEntity entity : invoicesEntities) {
				try {
					invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoicesEntityIds.add(invoiceRepository.save(entity).getId());
			}
			staffEntity.setInvoicesIds(invoicesEntityIds);

			mcuPackageItemsEntities = staffEntity.getMcuPackageItems();
			Set<UUID> mcuPackageItemsEntityIds = new HashSet<>();
			for (McuPackageItemEntity entity : mcuPackageItemsEntities) {
				try {
					mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				mcuPackageItemsEntityIds.add(mcuPackageItemRepository.save(entity).getId());
			}
			staffEntity.setMcuPackageItemsIds(mcuPackageItemsEntityIds);

			medicalCertificateDischargeResumesEntities = staffEntity.getMedicalCertificateDischargeResumes();
			Set<UUID> medicalCertificateDischargeResumesEntityIds = new HashSet<>();
			for (MedicalCertificateDischargeResumeEntity entity : medicalCertificateDischargeResumesEntities) {
				try {
					medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalCertificateDischargeResumesEntityIds.add(medicalCertificateDischargeResumeRepository.save(entity).getId());
			}
			staffEntity.setMedicalCertificateDischargeResumesIds(medicalCertificateDischargeResumesEntityIds);

			medicalCertificateBirthsEntities = staffEntity.getMedicalCertificateBirths();
			Set<UUID> medicalCertificateBirthsEntityIds = new HashSet<>();
			for (MedicalCertificateBirthEntity entity : medicalCertificateBirthsEntities) {
				try {
					medicalCertificateBirthDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalCertificateBirthsEntityIds.add(medicalCertificateBirthRepository.save(entity).getId());
			}
			staffEntity.setMedicalCertificateBirthsIds(medicalCertificateBirthsEntityIds);

			medicalCertificateHospitalizationsEntities = staffEntity.getMedicalCertificateHospitalizations();
			Set<UUID> medicalCertificateHospitalizationsEntityIds = new HashSet<>();
			for (MedicalCertificateHospitalizationEntity entity : medicalCertificateHospitalizationsEntities) {
				try {
					medicalCertificateHospitalizationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalCertificateHospitalizationsEntityIds.add(medicalCertificateHospitalizationRepository.save(entity).getId());
			}
			staffEntity.setMedicalCertificateHospitalizationsIds(medicalCertificateHospitalizationsEntityIds);

			medicalExaminationRecordDischargeSummarysEntities = staffEntity.getMedicalExaminationRecordDischargeSummarys();
			Set<UUID> medicalExaminationRecordDischargeSummarysEntityIds = new HashSet<>();
			for (MedicalExaminationRecordDischargeSummaryEntity entity : medicalExaminationRecordDischargeSummarysEntities) {
				try {
					medicalExaminationRecordDischargeSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalExaminationRecordDischargeSummarysEntityIds.add(medicalExaminationRecordDischargeSummaryRepository.save(entity).getId());
			}
			staffEntity.setMedicalExaminationRecordDischargeSummarysIds(medicalExaminationRecordDischargeSummarysEntityIds);

			medicalRecordTranscriberEntities = staffEntity.getMedicalRecordTranscriber();
			Set<UUID> medicalRecordTranscriberEntityIds = new HashSet<>();
			for (MedicalExaminationRecordEntity entity : medicalRecordTranscriberEntities) {
				try {
					medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalRecordTranscriberEntityIds.add(medicalExaminationRecordRepository.save(entity).getId());
			}
			staffEntity.setMedicalRecordTranscriberIds(medicalRecordTranscriberEntityIds);

			medicalStaffOfMedicalAttendancesCertificateEntities = staffEntity.getMedicalStaffOfMedicalAttendancesCertificate();
			Set<UUID> medicalStaffOfMedicalAttendancesCertificateEntityIds = new HashSet<>();
			for (MedicalCertificateMedicalAttendanceEntity entity : medicalStaffOfMedicalAttendancesCertificateEntities) {
				try {
					medicalCertificateMedicalAttendanceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalStaffOfMedicalAttendancesCertificateEntityIds.add(medicalCertificateMedicalAttendanceRepository.save(entity).getId());
			}
			staffEntity.setMedicalStaffOfMedicalAttendancesCertificateIds(medicalStaffOfMedicalAttendancesCertificateEntityIds);

			medicalStaffOfMentalHealthsEntities = staffEntity.getMedicalStaffOfMentalHealths();
			Set<UUID> medicalStaffOfMentalHealthsEntityIds = new HashSet<>();
			for (MedicalCertificateMentalHealthEntity entity : medicalStaffOfMentalHealthsEntities) {
				try {
					medicalCertificateMentalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalStaffOfMentalHealthsEntityIds.add(medicalCertificateMentalHealthRepository.save(entity).getId());
			}
			staffEntity.setMedicalStaffOfMentalHealthsIds(medicalStaffOfMentalHealthsEntityIds);

			medicalStaffOfPhysicalHealthsEntities = staffEntity.getMedicalStaffOfPhysicalHealths();
			Set<UUID> medicalStaffOfPhysicalHealthsEntityIds = new HashSet<>();
			for (MedicalCertificatePhysicalHealthEntity entity : medicalStaffOfPhysicalHealthsEntities) {
				try {
					medicalCertificatePhysicalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalStaffOfPhysicalHealthsEntityIds.add(medicalCertificatePhysicalHealthRepository.save(entity).getId());
			}
			staffEntity.setMedicalStaffOfPhysicalHealthsIds(medicalStaffOfPhysicalHealthsEntityIds);

			medicalStaffOfRestrictedWorksCertificateEntities = staffEntity.getMedicalStaffOfRestrictedWorksCertificate();
			Set<UUID> medicalStaffOfRestrictedWorksCertificateEntityIds = new HashSet<>();
			for (MedicalCertificateRestrictedWorkEntity entity : medicalStaffOfRestrictedWorksCertificateEntities) {
				try {
					medicalCertificateRestrictedWorkDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalStaffOfRestrictedWorksCertificateEntityIds.add(medicalCertificateRestrictedWorkRepository.save(entity).getId());
			}
			staffEntity.setMedicalStaffOfRestrictedWorksCertificateIds(medicalStaffOfRestrictedWorksCertificateEntityIds);

			medicalStaffOfSickLeavesCertificateEntities = staffEntity.getMedicalStaffOfSickLeavesCertificate();
			Set<UUID> medicalStaffOfSickLeavesCertificateEntityIds = new HashSet<>();
			for (MedicalCertificateSickLeaveEntity entity : medicalStaffOfSickLeavesCertificateEntities) {
				try {
					medicalCertificateSickLeaveDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalStaffOfSickLeavesCertificateEntityIds.add(medicalCertificateSickLeaveRepository.save(entity).getId());
			}
			staffEntity.setMedicalStaffOfSickLeavesCertificateIds(medicalStaffOfSickLeavesCertificateEntityIds);

			medicationAdministeredHisotriesEntities = staffEntity.getMedicationAdministeredHisotries();
			Set<UUID> medicationAdministeredHisotriesEntityIds = new HashSet<>();
			for (MedicationAdministeredHistoryEntity entity : medicationAdministeredHisotriesEntities) {
				try {
					medicationAdministeredHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicationAdministeredHisotriesEntityIds.add(medicationAdministeredHistoryRepository.save(entity).getId());
			}
			staffEntity.setMedicationAdministeredHisotriesIds(medicationAdministeredHisotriesEntityIds);

			medicationHeadersEntities = staffEntity.getMedicationHeaders();
			Set<UUID> medicationHeadersEntityIds = new HashSet<>();
			for (MedicationHeaderEntity entity : medicationHeadersEntities) {
				try {
					medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicationHeadersEntityIds.add(medicationHeaderRepository.save(entity).getId());
			}
			staffEntity.setMedicationHeadersIds(medicationHeadersEntityIds);

			midwivesEntities = staffEntity.getMidwives();
			Set<UUID> midwivesEntityIds = new HashSet<>();
			for (DeliveryMedicalExaminationRecordEntity entity : midwivesEntities) {
				try {
					deliveryMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				midwivesEntityIds.add(deliveryMedicalExaminationRecordRepository.save(entity).getId());
			}
			staffEntity.setMidwivesIds(midwivesEntityIds);

			nurseEntities = staffEntity.getNurse();
			Set<UUID> nurseEntityIds = new HashSet<>();
			for (MedicalExaminationRecordEntity entity : nurseEntities) {
				try {
					medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				nurseEntityIds.add(medicalExaminationRecordRepository.save(entity).getId());
			}
			staffEntity.setNurseIds(nurseEntityIds);

			nursingDetailSurgicalNursingEntities = staffEntity.getNursingDetailSurgicalNursing();
			Set<UUID> nursingDetailSurgicalNursingEntityIds = new HashSet<>();
			for (OperatingTheaterMedicalExaminationRecordEntity entity : nursingDetailSurgicalNursingEntities) {
				try {
					operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				nursingDetailSurgicalNursingEntityIds.add(operatingTheaterMedicalExaminationRecordRepository.save(entity).getId());
			}
			staffEntity.setNursingDetailSurgicalNursingIds(nursingDetailSurgicalNursingEntityIds);

			nursingDetailsAnesthesiaNursingEntities = staffEntity.getNursingDetailsAnesthesiaNursing();
			Set<UUID> nursingDetailsAnesthesiaNursingEntityIds = new HashSet<>();
			for (OperatingTheaterMedicalExaminationRecordEntity entity : nursingDetailsAnesthesiaNursingEntities) {
				try {
					operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				nursingDetailsAnesthesiaNursingEntityIds.add(operatingTheaterMedicalExaminationRecordRepository.save(entity).getId());
			}
			staffEntity.setNursingDetailsAnesthesiaNursingIds(nursingDetailsAnesthesiaNursingEntityIds);

			patientConsentsEntities = staffEntity.getPatientConsents();
			Set<UUID> patientConsentsEntityIds = new HashSet<>();
			for (PatientConsentEntity entity : patientConsentsEntities) {
				try {
					patientConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				patientConsentsEntityIds.add(patientConsentRepository.save(entity).getId());
			}
			staffEntity.setPatientConsentsIds(patientConsentsEntityIds);

			patientVitalInformationsEntities = staffEntity.getPatientVitalInformations();
			Set<UUID> patientVitalInformationsEntityIds = new HashSet<>();
			for (PatientVitalInformationEntity entity : patientVitalInformationsEntities) {
				try {
					patientVitalInformationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				patientVitalInformationsEntityIds.add(patientVitalInformationRepository.save(entity).getId());
			}
			staffEntity.setPatientVitalInformationsIds(patientVitalInformationsEntityIds);

			pediatricianInChargeEntities = staffEntity.getPediatricianInCharge();
			Set<UUID> pediatricianInChargeEntityIds = new HashSet<>();
			for (NewbornDetailEntity entity : pediatricianInChargeEntities) {
				try {
					newbornDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				pediatricianInChargeEntityIds.add(newbornDetailRepository.save(entity).getId());
			}
			staffEntity.setPediatricianInChargeIds(pediatricianInChargeEntityIds);

			prescriptionHeadersEntities = staffEntity.getPrescriptionHeaders();
			Set<UUID> prescriptionHeadersEntityIds = new HashSet<>();
			for (PrescriptionHeaderEntity entity : prescriptionHeadersEntities) {
				try {
					prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				prescriptionHeadersEntityIds.add(prescriptionHeaderRepository.save(entity).getId());
			}
			staffEntity.setPrescriptionHeadersIds(prescriptionHeadersEntityIds);

			processWorkflowLogsEntities = staffEntity.getProcessWorkflowLogs();
			Set<UUID> processWorkflowLogsEntityIds = new HashSet<>();
			for (ProcessWorkflowEntity entity : processWorkflowLogsEntities) {
				try {
					processWorkflowDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				processWorkflowLogsEntityIds.add(processWorkflowRepository.save(entity).getId());
			}
			staffEntity.setProcessWorkflowLogsIds(processWorkflowLogsEntityIds);

			registrationsEntities = staffEntity.getRegistrations();
			Set<UUID> registrationsEntityIds = new HashSet<>();
			for (RegistrationEntity entity : registrationsEntities) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				registrationsEntityIds.add(registrationRepository.save(entity).getId());
			}
			staffEntity.setRegistrationsIds(registrationsEntityIds);

			requestedByEntities = staffEntity.getRequestedBy();
			Set<UUID> requestedByEntityIds = new HashSet<>();
			for (RegistrationEntity entity : requestedByEntities) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				requestedByEntityIds.add(registrationRepository.save(entity).getId());
			}
			staffEntity.setRequestedByIds(requestedByEntityIds);

			roomTransfersEntities = staffEntity.getRoomTransfers();
			Set<UUID> roomTransfersEntityIds = new HashSet<>();
			for (RoomTransferEntity entity : roomTransfersEntities) {
				try {
					roomTransferDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				roomTransfersEntityIds.add(roomTransferRepository.save(entity).getId());
			}
			staffEntity.setRoomTransfersIds(roomTransfersEntityIds);

			sampleCollectionStaffsEntities = staffEntity.getSampleCollectionStaffs();
			Set<UUID> sampleCollectionStaffsEntityIds = new HashSet<>();
			for (SampleCollectionItemsEntity entity : sampleCollectionStaffsEntities) {
				try {
					sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				sampleCollectionStaffsEntityIds.add(sampleCollectionItemsRepository.save(entity).getId());
			}
			staffEntity.setSampleCollectionStaffsIds(sampleCollectionStaffsEntityIds);

			sampleDeliveryStaffsEntities = staffEntity.getSampleDeliveryStaffs();
			Set<UUID> sampleDeliveryStaffsEntityIds = new HashSet<>();
			for (SampleCollectionItemsEntity entity : sampleDeliveryStaffsEntities) {
				try {
					sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				sampleDeliveryStaffsEntityIds.add(sampleCollectionItemsRepository.save(entity).getId());
			}
			staffEntity.setSampleDeliveryStaffsIds(sampleDeliveryStaffsEntityIds);

			sampleProcessingStaffsEntities = staffEntity.getSampleProcessingStaffs();
			Set<UUID> sampleProcessingStaffsEntityIds = new HashSet<>();
			for (SampleCollectionItemsEntity entity : sampleProcessingStaffsEntities) {
				try {
					sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				sampleProcessingStaffsEntityIds.add(sampleCollectionItemsRepository.save(entity).getId());
			}
			staffEntity.setSampleProcessingStaffsIds(sampleProcessingStaffsEntityIds);

			surgeonEntities = staffEntity.getSurgeon();
			Set<UUID> surgeonEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : surgeonEntities) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				surgeonEntityIds.add(preoperativeRecordsRepository.save(entity).getId());
			}
			staffEntity.setSurgeonIds(surgeonEntityIds);

			surgicalMedicalTranscriberEntities = staffEntity.getSurgicalMedicalTranscriber();
			Set<UUID> surgicalMedicalTranscriberEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : surgicalMedicalTranscriberEntities) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				surgicalMedicalTranscriberEntityIds.add(preoperativeRecordsRepository.save(entity).getId());
			}
			staffEntity.setSurgicalMedicalTranscriberIds(surgicalMedicalTranscriberEntityIds);

			surgicalNurseEntities = staffEntity.getSurgicalNurse();
			Set<UUID> surgicalNurseEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : surgicalNurseEntities) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				surgicalNurseEntityIds.add(preoperativeRecordsRepository.save(entity).getId());
			}
			staffEntity.setSurgicalNurseIds(surgicalNurseEntityIds);

			transferOrderStockDetailsEntities = staffEntity.getTransferOrderStockDetails();
			Set<UUID> transferOrderStockDetailsEntityIds = new HashSet<>();
			for (TransferOrderStockDetailEntity entity : transferOrderStockDetailsEntities) {
				try {
					transferOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				transferOrderStockDetailsEntityIds.add(transferOrderStockDetailRepository.save(entity).getId());
			}
			staffEntity.setTransferOrderStockDetailsIds(transferOrderStockDetailsEntityIds);

			vaccinationOrdersEntities = staffEntity.getVaccinationOrders();
			Set<UUID> vaccinationOrdersEntityIds = new HashSet<>();
			for (VaccinationOrderEntity entity : vaccinationOrdersEntities) {
				try {
					vaccinationOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				vaccinationOrdersEntityIds.add(vaccinationOrderRepository.save(entity).getId());
			}
			staffEntity.setVaccinationOrdersIds(vaccinationOrdersEntityIds);

			servicesEntities = staffEntity.getServices();
			Set<UUID> servicesEntityIds = new HashSet<>();
			for (ServiceEntity entity : servicesEntities) {
				try {
					serviceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				servicesEntityIds.add(serviceRepository.save(entity).getId());
			}
			staffEntity.setServicesIds(servicesEntityIds);


			staffEntity = staffService.create(staffEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(staffEntity.getAdministrationUser());
			staffEntity.setAdministrationUserId(null);
			staffEntity.unsetAdministrationUser();

			Assertions.assertNotNull(staffEntity.getCashierUser());
			staffEntity.setCashierUserId(null);
			staffEntity.unsetCashierUser();

			Assertions.assertNotNull(staffEntity.getClaimUser());
			staffEntity.setClaimUserId(null);
			staffEntity.unsetClaimUser();

			Assertions.assertNotNull(staffEntity.getDiagnosticSupportUser());
			staffEntity.setDiagnosticSupportUserId(null);
			staffEntity.unsetDiagnosticSupportUser();

			Assertions.assertNotNull(staffEntity.getDoctorUser());
			staffEntity.setDoctorUserId(null);
			staffEntity.unsetDoctorUser();

			Assertions.assertNotNull(staffEntity.getFacilityUser());
			staffEntity.setFacilityUserId(null);
			staffEntity.unsetFacilityUser();

			Assertions.assertNotNull(staffEntity.getManagementUser());
			staffEntity.setManagementUserId(null);
			staffEntity.unsetManagementUser();

			Assertions.assertNotNull(staffEntity.getMedicalRecordUser());
			staffEntity.setMedicalRecordUserId(null);
			staffEntity.unsetMedicalRecordUser();

			Assertions.assertNotNull(staffEntity.getMedicalTranscriberUser());
			staffEntity.setMedicalTranscriberUserId(null);
			staffEntity.unsetMedicalTranscriberUser();

			Assertions.assertNotNull(staffEntity.getNurseUser());
			staffEntity.setNurseUserId(null);
			staffEntity.unsetNurseUser();

			Assertions.assertNotNull(staffEntity.getPharmacyUser());
			staffEntity.setPharmacyUserId(null);
			staffEntity.unsetPharmacyUser();

			Assertions.assertNotNull(staffEntity.getPurchasingUser());
			staffEntity.setPurchasingUserId(null);
			staffEntity.unsetPurchasingUser();

			Assertions.assertNotNull(staffEntity.getRegistrationUser());
			staffEntity.setRegistrationUserId(null);
			staffEntity.unsetRegistrationUser();

			Assertions.assertNotNull(staffEntity.getSystemAdminUser());
			staffEntity.setSystemAdminUserId(null);
			staffEntity.unsetSystemAdminUser();

			Assertions.assertNotNull(staffEntity.getWarehouseUser());
			staffEntity.setWarehouseUserId(null);
			staffEntity.unsetWarehouseUser();

			Assertions.assertNotNull(staffEntity.getAdministrator());
			staffEntity.setAdministratorId(null);
			staffEntity.unsetAdministrator();

			Assertions.assertNotNull(staffEntity.getBpjsDoctorMapping());
			staffEntity.setBpjsDoctorMappingId(null);
			staffEntity.unsetBpjsDoctorMapping();

			Assertions.assertNotNull(staffEntity.getPcareDokter());
			staffEntity.setPcareDokterId(null);
			staffEntity.unsetPcareDokter();

			Assertions.assertNotNull(staffEntity.getService());
			staffEntity.setServiceId(null);
			staffEntity.unsetService();

			Assertions.assertTrue(staffEntity.getAccompanyingConsents().size() > 0);
			staffEntity.setAccompanyingConsentsIds(new HashSet<UUID>());
			staffEntity.unsetAccompanyingConsents();

			Assertions.assertTrue(staffEntity.getAmendmentDetails().size() > 0);
			staffEntity.setAmendmentDetailsIds(new HashSet<UUID>());
			staffEntity.unsetAmendmentDetails();

			Assertions.assertTrue(staffEntity.getAnesthesiaMedicalTranscriber().size() > 0);
			staffEntity.setAnesthesiaMedicalTranscriberIds(new HashSet<UUID>());
			staffEntity.unsetAnesthesiaMedicalTranscriber();

			Assertions.assertTrue(staffEntity.getAnesthesiologist().size() > 0);
			staffEntity.setAnesthesiologistIds(new HashSet<UUID>());
			staffEntity.unsetAnesthesiologist();

			Assertions.assertTrue(staffEntity.getAnesthesiologyNurse().size() > 0);
			staffEntity.setAnesthesiologyNurseIds(new HashSet<UUID>());
			staffEntity.unsetAnesthesiologyNurse();

			Assertions.assertTrue(staffEntity.getCashierStaff().size() > 0);
			staffEntity.setCashierStaffIds(new HashSet<UUID>());
			staffEntity.unsetCashierStaff();

			Assertions.assertTrue(staffEntity.getCoTreatingDoctors().size() > 0);
			staffEntity.setCoTreatingDoctorsIds(new HashSet<UUID>());
			staffEntity.unsetCoTreatingDoctors();

			Assertions.assertTrue(staffEntity.getDailyCareCPPTsCreatedByStaff().size() > 0);
			staffEntity.setDailyCareCPPTsCreatedByStaffIds(new HashSet<UUID>());
			staffEntity.unsetDailyCareCPPTsCreatedByStaff();

			Assertions.assertTrue(staffEntity.getDailyCareCPPTsDoctorInCharge().size() > 0);
			staffEntity.setDailyCareCPPTsDoctorInChargeIds(new HashSet<UUID>());
			staffEntity.unsetDailyCareCPPTsDoctorInCharge();

			Assertions.assertTrue(staffEntity.getDailyCareCPPTsMedicalTranscriber().size() > 0);
			staffEntity.setDailyCareCPPTsMedicalTranscriberIds(new HashSet<UUID>());
			staffEntity.unsetDailyCareCPPTsMedicalTranscriber();

			Assertions.assertTrue(staffEntity.getDeliveryProgresses().size() > 0);
			staffEntity.setDeliveryProgressesIds(new HashSet<UUID>());
			staffEntity.unsetDeliveryProgresses();

			Assertions.assertTrue(staffEntity.getDiagnosticStaffExaminationSummaries().size() > 0);
			staffEntity.setDiagnosticStaffExaminationSummariesIds(new HashSet<UUID>());
			staffEntity.unsetDiagnosticStaffExaminationSummaries();

			Assertions.assertTrue(staffEntity.getDismissalReferringStaff().size() > 0);
			staffEntity.setDismissalReferringStaffIds(new HashSet<UUID>());
			staffEntity.unsetDismissalReferringStaff();

			Assertions.assertTrue(staffEntity.getDoctorSchedules().size() > 0);
			staffEntity.setDoctorSchedulesIds(new HashSet<UUID>());
			staffEntity.unsetDoctorSchedules();

			Assertions.assertTrue(staffEntity.getDoctorOnExamination().size() > 0);
			staffEntity.setDoctorOnExaminationIds(new HashSet<UUID>());
			staffEntity.unsetDoctorOnExamination();

			Assertions.assertTrue(staffEntity.getFluidBalanceDetails().size() > 0);
			staffEntity.setFluidBalanceDetailsIds(new HashSet<UUID>());
			staffEntity.unsetFluidBalanceDetails();

			Assertions.assertTrue(staffEntity.getHemodialysisMonitorings().size() > 0);
			staffEntity.setHemodialysisMonitoringsIds(new HashSet<UUID>());
			staffEntity.unsetHemodialysisMonitorings();

			Assertions.assertTrue(staffEntity.getHospitalBranchInformations().size() > 0);
			staffEntity.setHospitalBranchInformationsIds(new HashSet<UUID>());
			staffEntity.unsetHospitalBranchInformations();

			Assertions.assertTrue(staffEntity.getInformingConsents().size() > 0);
			staffEntity.setInformingConsentsIds(new HashSet<UUID>());
			staffEntity.unsetInformingConsents();

			Assertions.assertTrue(staffEntity.getInvoices().size() > 0);
			staffEntity.setInvoicesIds(new HashSet<UUID>());
			staffEntity.unsetInvoices();

			Assertions.assertTrue(staffEntity.getMcuPackageItems().size() > 0);
			staffEntity.setMcuPackageItemsIds(new HashSet<UUID>());
			staffEntity.unsetMcuPackageItems();

			Assertions.assertTrue(staffEntity.getMedicalCertificateDischargeResumes().size() > 0);
			staffEntity.setMedicalCertificateDischargeResumesIds(new HashSet<UUID>());
			staffEntity.unsetMedicalCertificateDischargeResumes();

			Assertions.assertTrue(staffEntity.getMedicalCertificateBirths().size() > 0);
			staffEntity.setMedicalCertificateBirthsIds(new HashSet<UUID>());
			staffEntity.unsetMedicalCertificateBirths();

			Assertions.assertTrue(staffEntity.getMedicalCertificateHospitalizations().size() > 0);
			staffEntity.setMedicalCertificateHospitalizationsIds(new HashSet<UUID>());
			staffEntity.unsetMedicalCertificateHospitalizations();

			Assertions.assertTrue(staffEntity.getMedicalExaminationRecordDischargeSummarys().size() > 0);
			staffEntity.setMedicalExaminationRecordDischargeSummarysIds(new HashSet<UUID>());
			staffEntity.unsetMedicalExaminationRecordDischargeSummarys();

			Assertions.assertTrue(staffEntity.getMedicalRecordTranscriber().size() > 0);
			staffEntity.setMedicalRecordTranscriberIds(new HashSet<UUID>());
			staffEntity.unsetMedicalRecordTranscriber();

			Assertions.assertTrue(staffEntity.getMedicalStaffOfMedicalAttendancesCertificate().size() > 0);
			staffEntity.setMedicalStaffOfMedicalAttendancesCertificateIds(new HashSet<UUID>());
			staffEntity.unsetMedicalStaffOfMedicalAttendancesCertificate();

			Assertions.assertTrue(staffEntity.getMedicalStaffOfMentalHealths().size() > 0);
			staffEntity.setMedicalStaffOfMentalHealthsIds(new HashSet<UUID>());
			staffEntity.unsetMedicalStaffOfMentalHealths();

			Assertions.assertTrue(staffEntity.getMedicalStaffOfPhysicalHealths().size() > 0);
			staffEntity.setMedicalStaffOfPhysicalHealthsIds(new HashSet<UUID>());
			staffEntity.unsetMedicalStaffOfPhysicalHealths();

			Assertions.assertTrue(staffEntity.getMedicalStaffOfRestrictedWorksCertificate().size() > 0);
			staffEntity.setMedicalStaffOfRestrictedWorksCertificateIds(new HashSet<UUID>());
			staffEntity.unsetMedicalStaffOfRestrictedWorksCertificate();

			Assertions.assertTrue(staffEntity.getMedicalStaffOfSickLeavesCertificate().size() > 0);
			staffEntity.setMedicalStaffOfSickLeavesCertificateIds(new HashSet<UUID>());
			staffEntity.unsetMedicalStaffOfSickLeavesCertificate();

			Assertions.assertTrue(staffEntity.getMedicationAdministeredHisotries().size() > 0);
			staffEntity.setMedicationAdministeredHisotriesIds(new HashSet<UUID>());
			staffEntity.unsetMedicationAdministeredHisotries();

			Assertions.assertTrue(staffEntity.getMedicationHeaders().size() > 0);
			staffEntity.setMedicationHeadersIds(new HashSet<UUID>());
			staffEntity.unsetMedicationHeaders();

			Assertions.assertTrue(staffEntity.getMidwives().size() > 0);
			staffEntity.setMidwivesIds(new HashSet<UUID>());
			staffEntity.unsetMidwives();

			Assertions.assertTrue(staffEntity.getNurse().size() > 0);
			staffEntity.setNurseIds(new HashSet<UUID>());
			staffEntity.unsetNurse();

			Assertions.assertTrue(staffEntity.getNursingDetailSurgicalNursing().size() > 0);
			staffEntity.setNursingDetailSurgicalNursingIds(new HashSet<UUID>());
			staffEntity.unsetNursingDetailSurgicalNursing();

			Assertions.assertTrue(staffEntity.getNursingDetailsAnesthesiaNursing().size() > 0);
			staffEntity.setNursingDetailsAnesthesiaNursingIds(new HashSet<UUID>());
			staffEntity.unsetNursingDetailsAnesthesiaNursing();

			Assertions.assertTrue(staffEntity.getPatientConsents().size() > 0);
			staffEntity.setPatientConsentsIds(new HashSet<UUID>());
			staffEntity.unsetPatientConsents();

			Assertions.assertTrue(staffEntity.getPatientVitalInformations().size() > 0);
			staffEntity.setPatientVitalInformationsIds(new HashSet<UUID>());
			staffEntity.unsetPatientVitalInformations();

			Assertions.assertTrue(staffEntity.getPediatricianInCharge().size() > 0);
			staffEntity.setPediatricianInChargeIds(new HashSet<UUID>());
			staffEntity.unsetPediatricianInCharge();

			Assertions.assertTrue(staffEntity.getPrescriptionHeaders().size() > 0);
			staffEntity.setPrescriptionHeadersIds(new HashSet<UUID>());
			staffEntity.unsetPrescriptionHeaders();

			Assertions.assertTrue(staffEntity.getProcessWorkflowLogs().size() > 0);
			staffEntity.setProcessWorkflowLogsIds(new HashSet<UUID>());
			staffEntity.unsetProcessWorkflowLogs();

			Assertions.assertTrue(staffEntity.getRegistrations().size() > 0);
			staffEntity.setRegistrationsIds(new HashSet<UUID>());
			staffEntity.unsetRegistrations();

			Assertions.assertTrue(staffEntity.getRequestedBy().size() > 0);
			staffEntity.setRequestedByIds(new HashSet<UUID>());
			staffEntity.unsetRequestedBy();

			Assertions.assertTrue(staffEntity.getRoomTransfers().size() > 0);
			staffEntity.setRoomTransfersIds(new HashSet<UUID>());
			staffEntity.unsetRoomTransfers();

			Assertions.assertTrue(staffEntity.getSampleCollectionStaffs().size() > 0);
			staffEntity.setSampleCollectionStaffsIds(new HashSet<UUID>());
			staffEntity.unsetSampleCollectionStaffs();

			Assertions.assertTrue(staffEntity.getSampleDeliveryStaffs().size() > 0);
			staffEntity.setSampleDeliveryStaffsIds(new HashSet<UUID>());
			staffEntity.unsetSampleDeliveryStaffs();

			Assertions.assertTrue(staffEntity.getSampleProcessingStaffs().size() > 0);
			staffEntity.setSampleProcessingStaffsIds(new HashSet<UUID>());
			staffEntity.unsetSampleProcessingStaffs();

			Assertions.assertTrue(staffEntity.getSurgeon().size() > 0);
			staffEntity.setSurgeonIds(new HashSet<UUID>());
			staffEntity.unsetSurgeon();

			Assertions.assertTrue(staffEntity.getSurgicalMedicalTranscriber().size() > 0);
			staffEntity.setSurgicalMedicalTranscriberIds(new HashSet<UUID>());
			staffEntity.unsetSurgicalMedicalTranscriber();

			Assertions.assertTrue(staffEntity.getSurgicalNurse().size() > 0);
			staffEntity.setSurgicalNurseIds(new HashSet<UUID>());
			staffEntity.unsetSurgicalNurse();

			Assertions.assertTrue(staffEntity.getTransferOrderStockDetails().size() > 0);
			staffEntity.setTransferOrderStockDetailsIds(new HashSet<UUID>());
			staffEntity.unsetTransferOrderStockDetails();

			Assertions.assertTrue(staffEntity.getVaccinationOrders().size() > 0);
			staffEntity.setVaccinationOrdersIds(new HashSet<UUID>());
			staffEntity.unsetVaccinationOrders();

			Assertions.assertTrue(staffEntity.getServices().size() > 0);
			staffEntity.setServicesIds(new HashSet<UUID>());
			staffEntity.unsetServices();


			updatedStaffEntity = staffService.updateOldData(staffEntity);

			Assertions.assertNull(updatedStaffEntity.getAdministrationUser());

			Assertions.assertNull(updatedStaffEntity.getCashierUser());

			Assertions.assertNull(updatedStaffEntity.getClaimUser());

			Assertions.assertNull(updatedStaffEntity.getDiagnosticSupportUser());

			Assertions.assertNull(updatedStaffEntity.getDoctorUser());

			Assertions.assertNull(updatedStaffEntity.getFacilityUser());

			Assertions.assertNull(updatedStaffEntity.getManagementUser());

			Assertions.assertNull(updatedStaffEntity.getMedicalRecordUser());

			Assertions.assertNull(updatedStaffEntity.getMedicalTranscriberUser());

			Assertions.assertNull(updatedStaffEntity.getNurseUser());

			Assertions.assertNull(updatedStaffEntity.getPharmacyUser());

			Assertions.assertNull(updatedStaffEntity.getPurchasingUser());

			Assertions.assertNull(updatedStaffEntity.getRegistrationUser());

			Assertions.assertNull(updatedStaffEntity.getSystemAdminUser());

			Assertions.assertNull(updatedStaffEntity.getWarehouseUser());

			Assertions.assertNull(updatedStaffEntity.getAdministrator());

			Assertions.assertNull(updatedStaffEntity.getBpjsDoctorMapping());

			Assertions.assertNull(updatedStaffEntity.getPcareDokter());

			Assertions.assertNull(updatedStaffEntity.getService());

			Assertions.assertEquals(0, updatedStaffEntity.getAccompanyingConsents().size());

			Assertions.assertEquals(0, updatedStaffEntity.getAmendmentDetails().size());

			Assertions.assertEquals(0, updatedStaffEntity.getAnesthesiaMedicalTranscriber().size());

			Assertions.assertEquals(0, updatedStaffEntity.getAnesthesiologist().size());

			Assertions.assertEquals(0, updatedStaffEntity.getAnesthesiologyNurse().size());

			Assertions.assertEquals(0, updatedStaffEntity.getCashierStaff().size());

			Assertions.assertEquals(0, updatedStaffEntity.getCoTreatingDoctors().size());

			Assertions.assertEquals(0, updatedStaffEntity.getDailyCareCPPTsCreatedByStaff().size());

			Assertions.assertEquals(0, updatedStaffEntity.getDailyCareCPPTsDoctorInCharge().size());

			Assertions.assertEquals(0, updatedStaffEntity.getDailyCareCPPTsMedicalTranscriber().size());

			Assertions.assertEquals(0, updatedStaffEntity.getDeliveryProgresses().size());

			Assertions.assertEquals(0, updatedStaffEntity.getDiagnosticStaffExaminationSummaries().size());

			Assertions.assertEquals(0, updatedStaffEntity.getDismissalReferringStaff().size());

			Assertions.assertEquals(0, updatedStaffEntity.getDoctorSchedules().size());

			Assertions.assertEquals(0, updatedStaffEntity.getDoctorOnExamination().size());

			Assertions.assertEquals(0, updatedStaffEntity.getFluidBalanceDetails().size());

			Assertions.assertEquals(0, updatedStaffEntity.getHemodialysisMonitorings().size());

			Assertions.assertEquals(0, updatedStaffEntity.getHospitalBranchInformations().size());

			Assertions.assertEquals(0, updatedStaffEntity.getInformingConsents().size());

			Assertions.assertEquals(0, updatedStaffEntity.getInvoices().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMcuPackageItems().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicalCertificateDischargeResumes().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicalCertificateBirths().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicalCertificateHospitalizations().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicalExaminationRecordDischargeSummarys().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicalRecordTranscriber().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicalStaffOfMedicalAttendancesCertificate().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicalStaffOfMentalHealths().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicalStaffOfPhysicalHealths().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicalStaffOfRestrictedWorksCertificate().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicalStaffOfSickLeavesCertificate().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicationAdministeredHisotries().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMedicationHeaders().size());

			Assertions.assertEquals(0, updatedStaffEntity.getMidwives().size());

			Assertions.assertEquals(0, updatedStaffEntity.getNurse().size());

			Assertions.assertEquals(0, updatedStaffEntity.getNursingDetailSurgicalNursing().size());

			Assertions.assertEquals(0, updatedStaffEntity.getNursingDetailsAnesthesiaNursing().size());

			Assertions.assertEquals(0, updatedStaffEntity.getPatientConsents().size());

			Assertions.assertEquals(0, updatedStaffEntity.getPatientVitalInformations().size());

			Assertions.assertEquals(0, updatedStaffEntity.getPediatricianInCharge().size());

			Assertions.assertEquals(0, updatedStaffEntity.getPrescriptionHeaders().size());

			Assertions.assertEquals(0, updatedStaffEntity.getProcessWorkflowLogs().size());

			Assertions.assertEquals(0, updatedStaffEntity.getRegistrations().size());

			Assertions.assertEquals(0, updatedStaffEntity.getRequestedBy().size());

			Assertions.assertEquals(0, updatedStaffEntity.getRoomTransfers().size());

			Assertions.assertEquals(0, updatedStaffEntity.getSampleCollectionStaffs().size());

			Assertions.assertEquals(0, updatedStaffEntity.getSampleDeliveryStaffs().size());

			Assertions.assertEquals(0, updatedStaffEntity.getSampleProcessingStaffs().size());

			Assertions.assertEquals(0, updatedStaffEntity.getSurgeon().size());

			Assertions.assertEquals(0, updatedStaffEntity.getSurgicalMedicalTranscriber().size());

			Assertions.assertEquals(0, updatedStaffEntity.getSurgicalNurse().size());

			Assertions.assertEquals(0, updatedStaffEntity.getTransferOrderStockDetails().size());

			Assertions.assertEquals(0, updatedStaffEntity.getVaccinationOrders().size());

			Assertions.assertEquals(0, updatedStaffEntity.getServices().size());

		});
	}

	@Test
	public void updateOldDataWithStaffEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			StaffEntity staffEntity;
			StaffEntity updatedStaffEntity;

			AdministrationUserEntity administrationUserEntity;

			CashierUserEntity cashierUserEntity;

			ClaimUserEntity claimUserEntity;

			DiagnosticSupportUserEntity diagnosticSupportUserEntity;

			DoctorUserEntity doctorUserEntity;

			FacilityUserEntity facilityUserEntity;

			ManagementUserEntity managementUserEntity;

			MedicalRecordUserEntity medicalRecordUserEntity;

			MedicalTranscriberUserEntity medicalTranscriberUserEntity;

			NurseUserEntity nurseUserEntity;

			PharmacyUserEntity pharmacyUserEntity;

			PurchasingUserEntity purchasingUserEntity;

			RegistrationUserEntity registrationUserEntity;

			SystemAdminUserEntity systemAdminUserEntity;

			WarehouseUserEntity warehouseUserEntity;

			AdministratorEntity administratorEntity;

			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;

			PcareDokterEntity pcareDokterEntity;

			ServiceEntity serviceEntity;

			Set<InformedConsentEntity> accompanyingConsentsEntities;
			Set<UUID> accompanyingConsentsEntityIds;

			Set<AmendmentDetailEntity> amendmentDetailsEntities;
			Set<UUID> amendmentDetailsEntityIds;

			Set<PreoperativeRecordsEntity> anesthesiaMedicalTranscriberEntities;
			Set<UUID> anesthesiaMedicalTranscriberEntityIds;

			Set<PreoperativeRecordsEntity> anesthesiologistEntities;
			Set<UUID> anesthesiologistEntityIds;

			Set<PreoperativeRecordsEntity> anesthesiologyNurseEntities;
			Set<UUID> anesthesiologyNurseEntityIds;

			Set<CashReceiptEntity> cashierStaffEntities;
			Set<UUID> cashierStaffEntityIds;

			Set<CoTreatingDoctorEntity> coTreatingDoctorsEntities;
			Set<UUID> coTreatingDoctorsEntityIds;

			Set<DailyCareCPPTEntity> dailyCareCPPTsCreatedByStaffEntities;
			Set<UUID> dailyCareCPPTsCreatedByStaffEntityIds;

			Set<DailyCareCPPTEntity> dailyCareCPPTsDoctorInChargeEntities;
			Set<UUID> dailyCareCPPTsDoctorInChargeEntityIds;

			Set<DailyCareCPPTEntity> dailyCareCPPTsMedicalTranscriberEntities;
			Set<UUID> dailyCareCPPTsMedicalTranscriberEntityIds;

			Set<DeliveryProgressEntity> deliveryProgressesEntities;
			Set<UUID> deliveryProgressesEntityIds;

			Set<DiagnosticStaffExaminationSummaryEntity> diagnosticStaffExaminationSummariesEntities;
			Set<UUID> diagnosticStaffExaminationSummariesEntityIds;

			Set<RegistrationEntity> dismissalReferringStaffEntities;
			Set<UUID> dismissalReferringStaffEntityIds;

			Set<DoctorScheduleEntity> doctorSchedulesEntities;
			Set<UUID> doctorSchedulesEntityIds;

			Set<MedicalExaminationRecordEntity> doctorOnExaminationEntities;
			Set<UUID> doctorOnExaminationEntityIds;

			Set<FluidBalanceDetailEntity> fluidBalanceDetailsEntities;
			Set<UUID> fluidBalanceDetailsEntityIds;

			Set<HemodialysisMonitoringEntity> hemodialysisMonitoringsEntities;
			Set<UUID> hemodialysisMonitoringsEntityIds;

			Set<HospitalBranchInformationEntity> hospitalBranchInformationsEntities;
			Set<UUID> hospitalBranchInformationsEntityIds;

			Set<InformedConsentEntity> informingConsentsEntities;
			Set<UUID> informingConsentsEntityIds;

			Set<InvoiceEntity> invoicesEntities;
			Set<UUID> invoicesEntityIds;

			Set<McuPackageItemEntity> mcuPackageItemsEntities;
			Set<UUID> mcuPackageItemsEntityIds;

			Set<MedicalCertificateDischargeResumeEntity> medicalCertificateDischargeResumesEntities;
			Set<UUID> medicalCertificateDischargeResumesEntityIds;

			Set<MedicalCertificateBirthEntity> medicalCertificateBirthsEntities;
			Set<UUID> medicalCertificateBirthsEntityIds;

			Set<MedicalCertificateHospitalizationEntity> medicalCertificateHospitalizationsEntities;
			Set<UUID> medicalCertificateHospitalizationsEntityIds;

			Set<MedicalExaminationRecordDischargeSummaryEntity> medicalExaminationRecordDischargeSummarysEntities;
			Set<UUID> medicalExaminationRecordDischargeSummarysEntityIds;

			Set<MedicalExaminationRecordEntity> medicalRecordTranscriberEntities;
			Set<UUID> medicalRecordTranscriberEntityIds;

			Set<MedicalCertificateMedicalAttendanceEntity> medicalStaffOfMedicalAttendancesCertificateEntities;
			Set<UUID> medicalStaffOfMedicalAttendancesCertificateEntityIds;

			Set<MedicalCertificateMentalHealthEntity> medicalStaffOfMentalHealthsEntities;
			Set<UUID> medicalStaffOfMentalHealthsEntityIds;

			Set<MedicalCertificatePhysicalHealthEntity> medicalStaffOfPhysicalHealthsEntities;
			Set<UUID> medicalStaffOfPhysicalHealthsEntityIds;

			Set<MedicalCertificateRestrictedWorkEntity> medicalStaffOfRestrictedWorksCertificateEntities;
			Set<UUID> medicalStaffOfRestrictedWorksCertificateEntityIds;

			Set<MedicalCertificateSickLeaveEntity> medicalStaffOfSickLeavesCertificateEntities;
			Set<UUID> medicalStaffOfSickLeavesCertificateEntityIds;

			Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotriesEntities;
			Set<UUID> medicationAdministeredHisotriesEntityIds;

			Set<MedicationHeaderEntity> medicationHeadersEntities;
			Set<UUID> medicationHeadersEntityIds;

			Set<DeliveryMedicalExaminationRecordEntity> midwivesEntities;
			Set<UUID> midwivesEntityIds;

			Set<MedicalExaminationRecordEntity> nurseEntities;
			Set<UUID> nurseEntityIds;

			Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailSurgicalNursingEntities;
			Set<UUID> nursingDetailSurgicalNursingEntityIds;

			Set<OperatingTheaterMedicalExaminationRecordEntity> nursingDetailsAnesthesiaNursingEntities;
			Set<UUID> nursingDetailsAnesthesiaNursingEntityIds;

			Set<PatientConsentEntity> patientConsentsEntities;
			Set<UUID> patientConsentsEntityIds;

			Set<PatientVitalInformationEntity> patientVitalInformationsEntities;
			Set<UUID> patientVitalInformationsEntityIds;

			Set<NewbornDetailEntity> pediatricianInChargeEntities;
			Set<UUID> pediatricianInChargeEntityIds;

			Set<PrescriptionHeaderEntity> prescriptionHeadersEntities;
			Set<UUID> prescriptionHeadersEntityIds;

			Set<ProcessWorkflowEntity> processWorkflowLogsEntities;
			Set<UUID> processWorkflowLogsEntityIds;

			Set<RegistrationEntity> registrationsEntities;
			Set<UUID> registrationsEntityIds;

			Set<RegistrationEntity> requestedByEntities;
			Set<UUID> requestedByEntityIds;

			Set<RoomTransferEntity> roomTransfersEntities;
			Set<UUID> roomTransfersEntityIds;

			Set<SampleCollectionItemsEntity> sampleCollectionStaffsEntities;
			Set<UUID> sampleCollectionStaffsEntityIds;

			Set<SampleCollectionItemsEntity> sampleDeliveryStaffsEntities;
			Set<UUID> sampleDeliveryStaffsEntityIds;

			Set<SampleCollectionItemsEntity> sampleProcessingStaffsEntities;
			Set<UUID> sampleProcessingStaffsEntityIds;

			Set<PreoperativeRecordsEntity> surgeonEntities;
			Set<UUID> surgeonEntityIds;

			Set<PreoperativeRecordsEntity> surgicalMedicalTranscriberEntities;
			Set<UUID> surgicalMedicalTranscriberEntityIds;

			Set<PreoperativeRecordsEntity> surgicalNurseEntities;
			Set<UUID> surgicalNurseEntityIds;

			Set<TransferOrderStockDetailEntity> transferOrderStockDetailsEntities;
			Set<UUID> transferOrderStockDetailsEntityIds;

			Set<VaccinationOrderEntity> vaccinationOrdersEntities;
			Set<UUID> vaccinationOrdersEntityIds;

			Set<ServiceEntity> servicesEntities;
			Set<UUID> servicesEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				staffEntity = staffFactory.getObject(true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			/*
				Expected state of the entity prior to updateOldData when trying to add a reference
				is that the reference id is set, but the reference entity is not set.  Therefore,
				we need to remove the reference entity and set the reference id, as this will set up
				the state we expect to see for this test.

				We also need to populate the required relations for all related entities, as creating any entities
				with required references will cause an error (and a subsequent test failure) if we do not
			 */
			try {
				administrationUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getAdministrationUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Administration User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			administrationUserEntity = administrationUserRepository.findById(administrationUserRepository.save(staffEntity.getAdministrationUser()).getId()).get();
			staffEntity.unsetAdministrationUser();
			staffEntity.setAdministrationUserId(administrationUserEntity.getId());

			try {
				cashierUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getCashierUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Cashier User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			cashierUserEntity = cashierUserRepository.findById(cashierUserRepository.save(staffEntity.getCashierUser()).getId()).get();
			staffEntity.unsetCashierUser();
			staffEntity.setCashierUserId(cashierUserEntity.getId());

			try {
				claimUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getClaimUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Claim User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			claimUserEntity = claimUserRepository.findById(claimUserRepository.save(staffEntity.getClaimUser()).getId()).get();
			staffEntity.unsetClaimUser();
			staffEntity.setClaimUserId(claimUserEntity.getId());

			try {
				diagnosticSupportUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getDiagnosticSupportUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Diagnostic Support User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			diagnosticSupportUserEntity = diagnosticSupportUserRepository.findById(diagnosticSupportUserRepository.save(staffEntity.getDiagnosticSupportUser()).getId()).get();
			staffEntity.unsetDiagnosticSupportUser();
			staffEntity.setDiagnosticSupportUserId(diagnosticSupportUserEntity.getId());

			try {
				doctorUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getDoctorUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Doctor User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			doctorUserEntity = doctorUserRepository.findById(doctorUserRepository.save(staffEntity.getDoctorUser()).getId()).get();
			staffEntity.unsetDoctorUser();
			staffEntity.setDoctorUserId(doctorUserEntity.getId());

			try {
				facilityUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getFacilityUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Facility User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			facilityUserEntity = facilityUserRepository.findById(facilityUserRepository.save(staffEntity.getFacilityUser()).getId()).get();
			staffEntity.unsetFacilityUser();
			staffEntity.setFacilityUserId(facilityUserEntity.getId());

			try {
				managementUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getManagementUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Management User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			managementUserEntity = managementUserRepository.findById(managementUserRepository.save(staffEntity.getManagementUser()).getId()).get();
			staffEntity.unsetManagementUser();
			staffEntity.setManagementUserId(managementUserEntity.getId());

			try {
				medicalRecordUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getMedicalRecordUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Record user relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalRecordUserEntity = medicalRecordUserRepository.findById(medicalRecordUserRepository.save(staffEntity.getMedicalRecordUser()).getId()).get();
			staffEntity.unsetMedicalRecordUser();
			staffEntity.setMedicalRecordUserId(medicalRecordUserEntity.getId());

			try {
				medicalTranscriberUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getMedicalTranscriberUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Transcriber User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalTranscriberUserEntity = medicalTranscriberUserRepository.findById(medicalTranscriberUserRepository.save(staffEntity.getMedicalTranscriberUser()).getId()).get();
			staffEntity.unsetMedicalTranscriberUser();
			staffEntity.setMedicalTranscriberUserId(medicalTranscriberUserEntity.getId());

			try {
				nurseUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getNurseUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Nurse User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			nurseUserEntity = nurseUserRepository.findById(nurseUserRepository.save(staffEntity.getNurseUser()).getId()).get();
			staffEntity.unsetNurseUser();
			staffEntity.setNurseUserId(nurseUserEntity.getId());

			try {
				pharmacyUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getPharmacyUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Pharmacy User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			pharmacyUserEntity = pharmacyUserRepository.findById(pharmacyUserRepository.save(staffEntity.getPharmacyUser()).getId()).get();
			staffEntity.unsetPharmacyUser();
			staffEntity.setPharmacyUserId(pharmacyUserEntity.getId());

			try {
				purchasingUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getPurchasingUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Purchasing User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			purchasingUserEntity = purchasingUserRepository.findById(purchasingUserRepository.save(staffEntity.getPurchasingUser()).getId()).get();
			staffEntity.unsetPurchasingUser();
			staffEntity.setPurchasingUserId(purchasingUserEntity.getId());

			try {
				registrationUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getRegistrationUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationUserEntity = registrationUserRepository.findById(registrationUserRepository.save(staffEntity.getRegistrationUser()).getId()).get();
			staffEntity.unsetRegistrationUser();
			staffEntity.setRegistrationUserId(registrationUserEntity.getId());

			try {
				systemAdminUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getSystemAdminUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the System Admin User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			systemAdminUserEntity = systemAdminUserRepository.findById(systemAdminUserRepository.save(staffEntity.getSystemAdminUser()).getId()).get();
			staffEntity.unsetSystemAdminUser();
			staffEntity.setSystemAdminUserId(systemAdminUserEntity.getId());

			try {
				warehouseUserDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getWarehouseUser(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse User relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseUserEntity = warehouseUserRepository.findById(warehouseUserRepository.save(staffEntity.getWarehouseUser()).getId()).get();
			staffEntity.unsetWarehouseUser();
			staffEntity.setWarehouseUserId(warehouseUserEntity.getId());

			try {
				administratorDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getAdministrator(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Administrator relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			administratorEntity = administratorRepository.findById(administratorRepository.save(staffEntity.getAdministrator()).getId()).get();
			staffEntity.unsetAdministrator();
			staffEntity.setAdministratorId(administratorEntity.getId());

			try {
				bpjsDoctorMappingDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getBpjsDoctorMapping(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Doctor Mapping relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsDoctorMappingEntity = bpjsDoctorMappingRepository.findById(bpjsDoctorMappingRepository.save(staffEntity.getBpjsDoctorMapping()).getId()).get();
			staffEntity.unsetBpjsDoctorMapping();
			staffEntity.setBpjsDoctorMappingId(bpjsDoctorMappingEntity.getId());

			try {
				pcareDokterDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getPcareDokter(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the PCare Dokter relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			pcareDokterEntity = pcareDokterRepository.findById(pcareDokterRepository.save(staffEntity.getPcareDokter()).getId()).get();
			staffEntity.unsetPcareDokter();
			staffEntity.setPcareDokterId(pcareDokterEntity.getId());

			try {
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity.getService(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Service relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			serviceEntity = serviceRepository.findById(serviceRepository.save(staffEntity.getService()).getId()).get();
			staffEntity.unsetService();
			staffEntity.setServiceId(serviceEntity.getId());

			accompanyingConsentsEntities = new HashSet<>();
			accompanyingConsentsEntityIds = new HashSet<>();
			for (InformedConsentEntity entity : staffEntity.getAccompanyingConsents()) {
				try {
					informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Accompanying Consents relation for this test: " + e.getCause());
					return;
				}
				UUID id = informedConsentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				accompanyingConsentsEntities.add(informedConsentRepository.findById(id).get());
				accompanyingConsentsEntityIds.add(id);
			}
			staffEntity.unsetAccompanyingConsents();
			staffEntity.setAccompanyingConsentsIds(accompanyingConsentsEntityIds);

			amendmentDetailsEntities = new HashSet<>();
			amendmentDetailsEntityIds = new HashSet<>();
			for (AmendmentDetailEntity entity : staffEntity.getAmendmentDetails()) {
				try {
					amendmentDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Amendment Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = amendmentDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				amendmentDetailsEntities.add(amendmentDetailRepository.findById(id).get());
				amendmentDetailsEntityIds.add(id);
			}
			staffEntity.unsetAmendmentDetails();
			staffEntity.setAmendmentDetailsIds(amendmentDetailsEntityIds);

			anesthesiaMedicalTranscriberEntities = new HashSet<>();
			anesthesiaMedicalTranscriberEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : staffEntity.getAnesthesiaMedicalTranscriber()) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Anesthesia Medical Transcriber relation for this test: " + e.getCause());
					return;
				}
				UUID id = preoperativeRecordsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				anesthesiaMedicalTranscriberEntities.add(preoperativeRecordsRepository.findById(id).get());
				anesthesiaMedicalTranscriberEntityIds.add(id);
			}
			staffEntity.unsetAnesthesiaMedicalTranscriber();
			staffEntity.setAnesthesiaMedicalTranscriberIds(anesthesiaMedicalTranscriberEntityIds);

			anesthesiologistEntities = new HashSet<>();
			anesthesiologistEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : staffEntity.getAnesthesiologist()) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Anesthesiologist relation for this test: " + e.getCause());
					return;
				}
				UUID id = preoperativeRecordsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				anesthesiologistEntities.add(preoperativeRecordsRepository.findById(id).get());
				anesthesiologistEntityIds.add(id);
			}
			staffEntity.unsetAnesthesiologist();
			staffEntity.setAnesthesiologistIds(anesthesiologistEntityIds);

			anesthesiologyNurseEntities = new HashSet<>();
			anesthesiologyNurseEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : staffEntity.getAnesthesiologyNurse()) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Anesthesiology Nurse relation for this test: " + e.getCause());
					return;
				}
				UUID id = preoperativeRecordsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				anesthesiologyNurseEntities.add(preoperativeRecordsRepository.findById(id).get());
				anesthesiologyNurseEntityIds.add(id);
			}
			staffEntity.unsetAnesthesiologyNurse();
			staffEntity.setAnesthesiologyNurseIds(anesthesiologyNurseEntityIds);

			cashierStaffEntities = new HashSet<>();
			cashierStaffEntityIds = new HashSet<>();
			for (CashReceiptEntity entity : staffEntity.getCashierStaff()) {
				try {
					cashReceiptDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Cashier Staff relation for this test: " + e.getCause());
					return;
				}
				UUID id = cashReceiptRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				cashierStaffEntities.add(cashReceiptRepository.findById(id).get());
				cashierStaffEntityIds.add(id);
			}
			staffEntity.unsetCashierStaff();
			staffEntity.setCashierStaffIds(cashierStaffEntityIds);

			coTreatingDoctorsEntities = new HashSet<>();
			coTreatingDoctorsEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : staffEntity.getCoTreatingDoctors()) {
				try {
					coTreatingDoctorDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Co Treating Doctors relation for this test: " + e.getCause());
					return;
				}
				UUID id = coTreatingDoctorRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				coTreatingDoctorsEntities.add(coTreatingDoctorRepository.findById(id).get());
				coTreatingDoctorsEntityIds.add(id);
			}
			staffEntity.unsetCoTreatingDoctors();
			staffEntity.setCoTreatingDoctorsIds(coTreatingDoctorsEntityIds);

			dailyCareCPPTsCreatedByStaffEntities = new HashSet<>();
			dailyCareCPPTsCreatedByStaffEntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : staffEntity.getDailyCareCPPTsCreatedByStaff()) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Daily Care CPPTs Created By Staff relation for this test: " + e.getCause());
					return;
				}
				UUID id = dailyCareCPPTRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				dailyCareCPPTsCreatedByStaffEntities.add(dailyCareCPPTRepository.findById(id).get());
				dailyCareCPPTsCreatedByStaffEntityIds.add(id);
			}
			staffEntity.unsetDailyCareCPPTsCreatedByStaff();
			staffEntity.setDailyCareCPPTsCreatedByStaffIds(dailyCareCPPTsCreatedByStaffEntityIds);

			dailyCareCPPTsDoctorInChargeEntities = new HashSet<>();
			dailyCareCPPTsDoctorInChargeEntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : staffEntity.getDailyCareCPPTsDoctorInCharge()) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Daily Care CPPTs Doctor in Charge relation for this test: " + e.getCause());
					return;
				}
				UUID id = dailyCareCPPTRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				dailyCareCPPTsDoctorInChargeEntities.add(dailyCareCPPTRepository.findById(id).get());
				dailyCareCPPTsDoctorInChargeEntityIds.add(id);
			}
			staffEntity.unsetDailyCareCPPTsDoctorInCharge();
			staffEntity.setDailyCareCPPTsDoctorInChargeIds(dailyCareCPPTsDoctorInChargeEntityIds);

			dailyCareCPPTsMedicalTranscriberEntities = new HashSet<>();
			dailyCareCPPTsMedicalTranscriberEntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : staffEntity.getDailyCareCPPTsMedicalTranscriber()) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Daily Care CPPTs Medical Transcriber relation for this test: " + e.getCause());
					return;
				}
				UUID id = dailyCareCPPTRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				dailyCareCPPTsMedicalTranscriberEntities.add(dailyCareCPPTRepository.findById(id).get());
				dailyCareCPPTsMedicalTranscriberEntityIds.add(id);
			}
			staffEntity.unsetDailyCareCPPTsMedicalTranscriber();
			staffEntity.setDailyCareCPPTsMedicalTranscriberIds(dailyCareCPPTsMedicalTranscriberEntityIds);

			deliveryProgressesEntities = new HashSet<>();
			deliveryProgressesEntityIds = new HashSet<>();
			for (DeliveryProgressEntity entity : staffEntity.getDeliveryProgresses()) {
				try {
					deliveryProgressDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Delivery Progresses relation for this test: " + e.getCause());
					return;
				}
				UUID id = deliveryProgressRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				deliveryProgressesEntities.add(deliveryProgressRepository.findById(id).get());
				deliveryProgressesEntityIds.add(id);
			}
			staffEntity.unsetDeliveryProgresses();
			staffEntity.setDeliveryProgressesIds(deliveryProgressesEntityIds);

			diagnosticStaffExaminationSummariesEntities = new HashSet<>();
			diagnosticStaffExaminationSummariesEntityIds = new HashSet<>();
			for (DiagnosticStaffExaminationSummaryEntity entity : staffEntity.getDiagnosticStaffExaminationSummaries()) {
				try {
					diagnosticStaffExaminationSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Diagnostic Staff Examination Summaries relation for this test: " + e.getCause());
					return;
				}
				UUID id = diagnosticStaffExaminationSummaryRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				diagnosticStaffExaminationSummariesEntities.add(diagnosticStaffExaminationSummaryRepository.findById(id).get());
				diagnosticStaffExaminationSummariesEntityIds.add(id);
			}
			staffEntity.unsetDiagnosticStaffExaminationSummaries();
			staffEntity.setDiagnosticStaffExaminationSummariesIds(diagnosticStaffExaminationSummariesEntityIds);

			dismissalReferringStaffEntities = new HashSet<>();
			dismissalReferringStaffEntityIds = new HashSet<>();
			for (RegistrationEntity entity : staffEntity.getDismissalReferringStaff()) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Dismissal Referring Staff relation for this test: " + e.getCause());
					return;
				}
				UUID id = registrationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				dismissalReferringStaffEntities.add(registrationRepository.findById(id).get());
				dismissalReferringStaffEntityIds.add(id);
			}
			staffEntity.unsetDismissalReferringStaff();
			staffEntity.setDismissalReferringStaffIds(dismissalReferringStaffEntityIds);

			doctorSchedulesEntities = new HashSet<>();
			doctorSchedulesEntityIds = new HashSet<>();
			for (DoctorScheduleEntity entity : staffEntity.getDoctorSchedules()) {
				try {
					doctorScheduleDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Doctor Schedules relation for this test: " + e.getCause());
					return;
				}
				UUID id = doctorScheduleRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				doctorSchedulesEntities.add(doctorScheduleRepository.findById(id).get());
				doctorSchedulesEntityIds.add(id);
			}
			staffEntity.unsetDoctorSchedules();
			staffEntity.setDoctorSchedulesIds(doctorSchedulesEntityIds);

			doctorOnExaminationEntities = new HashSet<>();
			doctorOnExaminationEntityIds = new HashSet<>();
			for (MedicalExaminationRecordEntity entity : staffEntity.getDoctorOnExamination()) {
				try {
					medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Doctor on examination relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				doctorOnExaminationEntities.add(medicalExaminationRecordRepository.findById(id).get());
				doctorOnExaminationEntityIds.add(id);
			}
			staffEntity.unsetDoctorOnExamination();
			staffEntity.setDoctorOnExaminationIds(doctorOnExaminationEntityIds);

			fluidBalanceDetailsEntities = new HashSet<>();
			fluidBalanceDetailsEntityIds = new HashSet<>();
			for (FluidBalanceDetailEntity entity : staffEntity.getFluidBalanceDetails()) {
				try {
					fluidBalanceDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Fluid Balance Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = fluidBalanceDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				fluidBalanceDetailsEntities.add(fluidBalanceDetailRepository.findById(id).get());
				fluidBalanceDetailsEntityIds.add(id);
			}
			staffEntity.unsetFluidBalanceDetails();
			staffEntity.setFluidBalanceDetailsIds(fluidBalanceDetailsEntityIds);

			hemodialysisMonitoringsEntities = new HashSet<>();
			hemodialysisMonitoringsEntityIds = new HashSet<>();
			for (HemodialysisMonitoringEntity entity : staffEntity.getHemodialysisMonitorings()) {
				try {
					hemodialysisMonitoringDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Hemodialysis Monitorings relation for this test: " + e.getCause());
					return;
				}
				UUID id = hemodialysisMonitoringRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				hemodialysisMonitoringsEntities.add(hemodialysisMonitoringRepository.findById(id).get());
				hemodialysisMonitoringsEntityIds.add(id);
			}
			staffEntity.unsetHemodialysisMonitorings();
			staffEntity.setHemodialysisMonitoringsIds(hemodialysisMonitoringsEntityIds);

			hospitalBranchInformationsEntities = new HashSet<>();
			hospitalBranchInformationsEntityIds = new HashSet<>();
			for (HospitalBranchInformationEntity entity : staffEntity.getHospitalBranchInformations()) {
				try {
					hospitalBranchInformationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Hospital Branch Informations relation for this test: " + e.getCause());
					return;
				}
				UUID id = hospitalBranchInformationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				hospitalBranchInformationsEntities.add(hospitalBranchInformationRepository.findById(id).get());
				hospitalBranchInformationsEntityIds.add(id);
			}
			staffEntity.unsetHospitalBranchInformations();
			staffEntity.setHospitalBranchInformationsIds(hospitalBranchInformationsEntityIds);

			informingConsentsEntities = new HashSet<>();
			informingConsentsEntityIds = new HashSet<>();
			for (InformedConsentEntity entity : staffEntity.getInformingConsents()) {
				try {
					informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Informing Consents relation for this test: " + e.getCause());
					return;
				}
				UUID id = informedConsentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				informingConsentsEntities.add(informedConsentRepository.findById(id).get());
				informingConsentsEntityIds.add(id);
			}
			staffEntity.unsetInformingConsents();
			staffEntity.setInformingConsentsIds(informingConsentsEntityIds);

			invoicesEntities = new HashSet<>();
			invoicesEntityIds = new HashSet<>();
			for (InvoiceEntity entity : staffEntity.getInvoices()) {
				try {
					invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoices relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoiceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoicesEntities.add(invoiceRepository.findById(id).get());
				invoicesEntityIds.add(id);
			}
			staffEntity.unsetInvoices();
			staffEntity.setInvoicesIds(invoicesEntityIds);

			mcuPackageItemsEntities = new HashSet<>();
			mcuPackageItemsEntityIds = new HashSet<>();
			for (McuPackageItemEntity entity : staffEntity.getMcuPackageItems()) {
				try {
					mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the MCU Package Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = mcuPackageItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				mcuPackageItemsEntities.add(mcuPackageItemRepository.findById(id).get());
				mcuPackageItemsEntityIds.add(id);
			}
			staffEntity.unsetMcuPackageItems();
			staffEntity.setMcuPackageItemsIds(mcuPackageItemsEntityIds);

			medicalCertificateDischargeResumesEntities = new HashSet<>();
			medicalCertificateDischargeResumesEntityIds = new HashSet<>();
			for (MedicalCertificateDischargeResumeEntity entity : staffEntity.getMedicalCertificateDischargeResumes()) {
				try {
					medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Certificate  Discharge Resumes relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalCertificateDischargeResumeRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalCertificateDischargeResumesEntities.add(medicalCertificateDischargeResumeRepository.findById(id).get());
				medicalCertificateDischargeResumesEntityIds.add(id);
			}
			staffEntity.unsetMedicalCertificateDischargeResumes();
			staffEntity.setMedicalCertificateDischargeResumesIds(medicalCertificateDischargeResumesEntityIds);

			medicalCertificateBirthsEntities = new HashSet<>();
			medicalCertificateBirthsEntityIds = new HashSet<>();
			for (MedicalCertificateBirthEntity entity : staffEntity.getMedicalCertificateBirths()) {
				try {
					medicalCertificateBirthDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Certificate Births relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalCertificateBirthRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalCertificateBirthsEntities.add(medicalCertificateBirthRepository.findById(id).get());
				medicalCertificateBirthsEntityIds.add(id);
			}
			staffEntity.unsetMedicalCertificateBirths();
			staffEntity.setMedicalCertificateBirthsIds(medicalCertificateBirthsEntityIds);

			medicalCertificateHospitalizationsEntities = new HashSet<>();
			medicalCertificateHospitalizationsEntityIds = new HashSet<>();
			for (MedicalCertificateHospitalizationEntity entity : staffEntity.getMedicalCertificateHospitalizations()) {
				try {
					medicalCertificateHospitalizationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Certificate Hospitalizations relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalCertificateHospitalizationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalCertificateHospitalizationsEntities.add(medicalCertificateHospitalizationRepository.findById(id).get());
				medicalCertificateHospitalizationsEntityIds.add(id);
			}
			staffEntity.unsetMedicalCertificateHospitalizations();
			staffEntity.setMedicalCertificateHospitalizationsIds(medicalCertificateHospitalizationsEntityIds);

			medicalExaminationRecordDischargeSummarysEntities = new HashSet<>();
			medicalExaminationRecordDischargeSummarysEntityIds = new HashSet<>();
			for (MedicalExaminationRecordDischargeSummaryEntity entity : staffEntity.getMedicalExaminationRecordDischargeSummarys()) {
				try {
					medicalExaminationRecordDischargeSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Examination Record Discharge Summarys relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalExaminationRecordDischargeSummaryRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalExaminationRecordDischargeSummarysEntities.add(medicalExaminationRecordDischargeSummaryRepository.findById(id).get());
				medicalExaminationRecordDischargeSummarysEntityIds.add(id);
			}
			staffEntity.unsetMedicalExaminationRecordDischargeSummarys();
			staffEntity.setMedicalExaminationRecordDischargeSummarysIds(medicalExaminationRecordDischargeSummarysEntityIds);

			medicalRecordTranscriberEntities = new HashSet<>();
			medicalRecordTranscriberEntityIds = new HashSet<>();
			for (MedicalExaminationRecordEntity entity : staffEntity.getMedicalRecordTranscriber()) {
				try {
					medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Record Transcriber relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalRecordTranscriberEntities.add(medicalExaminationRecordRepository.findById(id).get());
				medicalRecordTranscriberEntityIds.add(id);
			}
			staffEntity.unsetMedicalRecordTranscriber();
			staffEntity.setMedicalRecordTranscriberIds(medicalRecordTranscriberEntityIds);

			medicalStaffOfMedicalAttendancesCertificateEntities = new HashSet<>();
			medicalStaffOfMedicalAttendancesCertificateEntityIds = new HashSet<>();
			for (MedicalCertificateMedicalAttendanceEntity entity : staffEntity.getMedicalStaffOfMedicalAttendancesCertificate()) {
				try {
					medicalCertificateMedicalAttendanceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Staff of Medical Attendances certificate relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalCertificateMedicalAttendanceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalStaffOfMedicalAttendancesCertificateEntities.add(medicalCertificateMedicalAttendanceRepository.findById(id).get());
				medicalStaffOfMedicalAttendancesCertificateEntityIds.add(id);
			}
			staffEntity.unsetMedicalStaffOfMedicalAttendancesCertificate();
			staffEntity.setMedicalStaffOfMedicalAttendancesCertificateIds(medicalStaffOfMedicalAttendancesCertificateEntityIds);

			medicalStaffOfMentalHealthsEntities = new HashSet<>();
			medicalStaffOfMentalHealthsEntityIds = new HashSet<>();
			for (MedicalCertificateMentalHealthEntity entity : staffEntity.getMedicalStaffOfMentalHealths()) {
				try {
					medicalCertificateMentalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Staff of Mental Healths relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalCertificateMentalHealthRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalStaffOfMentalHealthsEntities.add(medicalCertificateMentalHealthRepository.findById(id).get());
				medicalStaffOfMentalHealthsEntityIds.add(id);
			}
			staffEntity.unsetMedicalStaffOfMentalHealths();
			staffEntity.setMedicalStaffOfMentalHealthsIds(medicalStaffOfMentalHealthsEntityIds);

			medicalStaffOfPhysicalHealthsEntities = new HashSet<>();
			medicalStaffOfPhysicalHealthsEntityIds = new HashSet<>();
			for (MedicalCertificatePhysicalHealthEntity entity : staffEntity.getMedicalStaffOfPhysicalHealths()) {
				try {
					medicalCertificatePhysicalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Staff of Physical Healths relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalCertificatePhysicalHealthRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalStaffOfPhysicalHealthsEntities.add(medicalCertificatePhysicalHealthRepository.findById(id).get());
				medicalStaffOfPhysicalHealthsEntityIds.add(id);
			}
			staffEntity.unsetMedicalStaffOfPhysicalHealths();
			staffEntity.setMedicalStaffOfPhysicalHealthsIds(medicalStaffOfPhysicalHealthsEntityIds);

			medicalStaffOfRestrictedWorksCertificateEntities = new HashSet<>();
			medicalStaffOfRestrictedWorksCertificateEntityIds = new HashSet<>();
			for (MedicalCertificateRestrictedWorkEntity entity : staffEntity.getMedicalStaffOfRestrictedWorksCertificate()) {
				try {
					medicalCertificateRestrictedWorkDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Staff of Restricted Works certificate relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalCertificateRestrictedWorkRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalStaffOfRestrictedWorksCertificateEntities.add(medicalCertificateRestrictedWorkRepository.findById(id).get());
				medicalStaffOfRestrictedWorksCertificateEntityIds.add(id);
			}
			staffEntity.unsetMedicalStaffOfRestrictedWorksCertificate();
			staffEntity.setMedicalStaffOfRestrictedWorksCertificateIds(medicalStaffOfRestrictedWorksCertificateEntityIds);

			medicalStaffOfSickLeavesCertificateEntities = new HashSet<>();
			medicalStaffOfSickLeavesCertificateEntityIds = new HashSet<>();
			for (MedicalCertificateSickLeaveEntity entity : staffEntity.getMedicalStaffOfSickLeavesCertificate()) {
				try {
					medicalCertificateSickLeaveDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Staff of Sick Leaves certificate relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalCertificateSickLeaveRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalStaffOfSickLeavesCertificateEntities.add(medicalCertificateSickLeaveRepository.findById(id).get());
				medicalStaffOfSickLeavesCertificateEntityIds.add(id);
			}
			staffEntity.unsetMedicalStaffOfSickLeavesCertificate();
			staffEntity.setMedicalStaffOfSickLeavesCertificateIds(medicalStaffOfSickLeavesCertificateEntityIds);

			medicationAdministeredHisotriesEntities = new HashSet<>();
			medicationAdministeredHisotriesEntityIds = new HashSet<>();
			for (MedicationAdministeredHistoryEntity entity : staffEntity.getMedicationAdministeredHisotries()) {
				try {
					medicationAdministeredHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medication Administered Hisotries relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicationAdministeredHistoryRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicationAdministeredHisotriesEntities.add(medicationAdministeredHistoryRepository.findById(id).get());
				medicationAdministeredHisotriesEntityIds.add(id);
			}
			staffEntity.unsetMedicationAdministeredHisotries();
			staffEntity.setMedicationAdministeredHisotriesIds(medicationAdministeredHisotriesEntityIds);

			medicationHeadersEntities = new HashSet<>();
			medicationHeadersEntityIds = new HashSet<>();
			for (MedicationHeaderEntity entity : staffEntity.getMedicationHeaders()) {
				try {
					medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medication Headers relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicationHeaderRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicationHeadersEntities.add(medicationHeaderRepository.findById(id).get());
				medicationHeadersEntityIds.add(id);
			}
			staffEntity.unsetMedicationHeaders();
			staffEntity.setMedicationHeadersIds(medicationHeadersEntityIds);

			midwivesEntities = new HashSet<>();
			midwivesEntityIds = new HashSet<>();
			for (DeliveryMedicalExaminationRecordEntity entity : staffEntity.getMidwives()) {
				try {
					deliveryMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Midwives relation for this test: " + e.getCause());
					return;
				}
				UUID id = deliveryMedicalExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				midwivesEntities.add(deliveryMedicalExaminationRecordRepository.findById(id).get());
				midwivesEntityIds.add(id);
			}
			staffEntity.unsetMidwives();
			staffEntity.setMidwivesIds(midwivesEntityIds);

			nurseEntities = new HashSet<>();
			nurseEntityIds = new HashSet<>();
			for (MedicalExaminationRecordEntity entity : staffEntity.getNurse()) {
				try {
					medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Nurse relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				nurseEntities.add(medicalExaminationRecordRepository.findById(id).get());
				nurseEntityIds.add(id);
			}
			staffEntity.unsetNurse();
			staffEntity.setNurseIds(nurseEntityIds);

			nursingDetailSurgicalNursingEntities = new HashSet<>();
			nursingDetailSurgicalNursingEntityIds = new HashSet<>();
			for (OperatingTheaterMedicalExaminationRecordEntity entity : staffEntity.getNursingDetailSurgicalNursing()) {
				try {
					operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Nursing Detail Surgical Nursing relation for this test: " + e.getCause());
					return;
				}
				UUID id = operatingTheaterMedicalExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				nursingDetailSurgicalNursingEntities.add(operatingTheaterMedicalExaminationRecordRepository.findById(id).get());
				nursingDetailSurgicalNursingEntityIds.add(id);
			}
			staffEntity.unsetNursingDetailSurgicalNursing();
			staffEntity.setNursingDetailSurgicalNursingIds(nursingDetailSurgicalNursingEntityIds);

			nursingDetailsAnesthesiaNursingEntities = new HashSet<>();
			nursingDetailsAnesthesiaNursingEntityIds = new HashSet<>();
			for (OperatingTheaterMedicalExaminationRecordEntity entity : staffEntity.getNursingDetailsAnesthesiaNursing()) {
				try {
					operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Nursing Details Anesthesia Nursing relation for this test: " + e.getCause());
					return;
				}
				UUID id = operatingTheaterMedicalExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				nursingDetailsAnesthesiaNursingEntities.add(operatingTheaterMedicalExaminationRecordRepository.findById(id).get());
				nursingDetailsAnesthesiaNursingEntityIds.add(id);
			}
			staffEntity.unsetNursingDetailsAnesthesiaNursing();
			staffEntity.setNursingDetailsAnesthesiaNursingIds(nursingDetailsAnesthesiaNursingEntityIds);

			patientConsentsEntities = new HashSet<>();
			patientConsentsEntityIds = new HashSet<>();
			for (PatientConsentEntity entity : staffEntity.getPatientConsents()) {
				try {
					patientConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Patient Consents relation for this test: " + e.getCause());
					return;
				}
				UUID id = patientConsentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				patientConsentsEntities.add(patientConsentRepository.findById(id).get());
				patientConsentsEntityIds.add(id);
			}
			staffEntity.unsetPatientConsents();
			staffEntity.setPatientConsentsIds(patientConsentsEntityIds);

			patientVitalInformationsEntities = new HashSet<>();
			patientVitalInformationsEntityIds = new HashSet<>();
			for (PatientVitalInformationEntity entity : staffEntity.getPatientVitalInformations()) {
				try {
					patientVitalInformationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Patient Vital Informations relation for this test: " + e.getCause());
					return;
				}
				UUID id = patientVitalInformationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				patientVitalInformationsEntities.add(patientVitalInformationRepository.findById(id).get());
				patientVitalInformationsEntityIds.add(id);
			}
			staffEntity.unsetPatientVitalInformations();
			staffEntity.setPatientVitalInformationsIds(patientVitalInformationsEntityIds);

			pediatricianInChargeEntities = new HashSet<>();
			pediatricianInChargeEntityIds = new HashSet<>();
			for (NewbornDetailEntity entity : staffEntity.getPediatricianInCharge()) {
				try {
					newbornDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Pediatrician In Charge relation for this test: " + e.getCause());
					return;
				}
				UUID id = newbornDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				pediatricianInChargeEntities.add(newbornDetailRepository.findById(id).get());
				pediatricianInChargeEntityIds.add(id);
			}
			staffEntity.unsetPediatricianInCharge();
			staffEntity.setPediatricianInChargeIds(pediatricianInChargeEntityIds);

			prescriptionHeadersEntities = new HashSet<>();
			prescriptionHeadersEntityIds = new HashSet<>();
			for (PrescriptionHeaderEntity entity : staffEntity.getPrescriptionHeaders()) {
				try {
					prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Prescription Headers relation for this test: " + e.getCause());
					return;
				}
				UUID id = prescriptionHeaderRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				prescriptionHeadersEntities.add(prescriptionHeaderRepository.findById(id).get());
				prescriptionHeadersEntityIds.add(id);
			}
			staffEntity.unsetPrescriptionHeaders();
			staffEntity.setPrescriptionHeadersIds(prescriptionHeadersEntityIds);

			processWorkflowLogsEntities = new HashSet<>();
			processWorkflowLogsEntityIds = new HashSet<>();
			for (ProcessWorkflowEntity entity : staffEntity.getProcessWorkflowLogs()) {
				try {
					processWorkflowDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Process Workflow Logs relation for this test: " + e.getCause());
					return;
				}
				UUID id = processWorkflowRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				processWorkflowLogsEntities.add(processWorkflowRepository.findById(id).get());
				processWorkflowLogsEntityIds.add(id);
			}
			staffEntity.unsetProcessWorkflowLogs();
			staffEntity.setProcessWorkflowLogsIds(processWorkflowLogsEntityIds);

			registrationsEntities = new HashSet<>();
			registrationsEntityIds = new HashSet<>();
			for (RegistrationEntity entity : staffEntity.getRegistrations()) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Registrations relation for this test: " + e.getCause());
					return;
				}
				UUID id = registrationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				registrationsEntities.add(registrationRepository.findById(id).get());
				registrationsEntityIds.add(id);
			}
			staffEntity.unsetRegistrations();
			staffEntity.setRegistrationsIds(registrationsEntityIds);

			requestedByEntities = new HashSet<>();
			requestedByEntityIds = new HashSet<>();
			for (RegistrationEntity entity : staffEntity.getRequestedBy()) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Requested By relation for this test: " + e.getCause());
					return;
				}
				UUID id = registrationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				requestedByEntities.add(registrationRepository.findById(id).get());
				requestedByEntityIds.add(id);
			}
			staffEntity.unsetRequestedBy();
			staffEntity.setRequestedByIds(requestedByEntityIds);

			roomTransfersEntities = new HashSet<>();
			roomTransfersEntityIds = new HashSet<>();
			for (RoomTransferEntity entity : staffEntity.getRoomTransfers()) {
				try {
					roomTransferDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Room Transfers relation for this test: " + e.getCause());
					return;
				}
				UUID id = roomTransferRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				roomTransfersEntities.add(roomTransferRepository.findById(id).get());
				roomTransfersEntityIds.add(id);
			}
			staffEntity.unsetRoomTransfers();
			staffEntity.setRoomTransfersIds(roomTransfersEntityIds);

			sampleCollectionStaffsEntities = new HashSet<>();
			sampleCollectionStaffsEntityIds = new HashSet<>();
			for (SampleCollectionItemsEntity entity : staffEntity.getSampleCollectionStaffs()) {
				try {
					sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Sample Collection Staffs relation for this test: " + e.getCause());
					return;
				}
				UUID id = sampleCollectionItemsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				sampleCollectionStaffsEntities.add(sampleCollectionItemsRepository.findById(id).get());
				sampleCollectionStaffsEntityIds.add(id);
			}
			staffEntity.unsetSampleCollectionStaffs();
			staffEntity.setSampleCollectionStaffsIds(sampleCollectionStaffsEntityIds);

			sampleDeliveryStaffsEntities = new HashSet<>();
			sampleDeliveryStaffsEntityIds = new HashSet<>();
			for (SampleCollectionItemsEntity entity : staffEntity.getSampleDeliveryStaffs()) {
				try {
					sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Sample Delivery Staffs relation for this test: " + e.getCause());
					return;
				}
				UUID id = sampleCollectionItemsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				sampleDeliveryStaffsEntities.add(sampleCollectionItemsRepository.findById(id).get());
				sampleDeliveryStaffsEntityIds.add(id);
			}
			staffEntity.unsetSampleDeliveryStaffs();
			staffEntity.setSampleDeliveryStaffsIds(sampleDeliveryStaffsEntityIds);

			sampleProcessingStaffsEntities = new HashSet<>();
			sampleProcessingStaffsEntityIds = new HashSet<>();
			for (SampleCollectionItemsEntity entity : staffEntity.getSampleProcessingStaffs()) {
				try {
					sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Sample Processing Staffs relation for this test: " + e.getCause());
					return;
				}
				UUID id = sampleCollectionItemsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				sampleProcessingStaffsEntities.add(sampleCollectionItemsRepository.findById(id).get());
				sampleProcessingStaffsEntityIds.add(id);
			}
			staffEntity.unsetSampleProcessingStaffs();
			staffEntity.setSampleProcessingStaffsIds(sampleProcessingStaffsEntityIds);

			surgeonEntities = new HashSet<>();
			surgeonEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : staffEntity.getSurgeon()) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Surgeon relation for this test: " + e.getCause());
					return;
				}
				UUID id = preoperativeRecordsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				surgeonEntities.add(preoperativeRecordsRepository.findById(id).get());
				surgeonEntityIds.add(id);
			}
			staffEntity.unsetSurgeon();
			staffEntity.setSurgeonIds(surgeonEntityIds);

			surgicalMedicalTranscriberEntities = new HashSet<>();
			surgicalMedicalTranscriberEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : staffEntity.getSurgicalMedicalTranscriber()) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Surgical Medical Transcriber relation for this test: " + e.getCause());
					return;
				}
				UUID id = preoperativeRecordsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				surgicalMedicalTranscriberEntities.add(preoperativeRecordsRepository.findById(id).get());
				surgicalMedicalTranscriberEntityIds.add(id);
			}
			staffEntity.unsetSurgicalMedicalTranscriber();
			staffEntity.setSurgicalMedicalTranscriberIds(surgicalMedicalTranscriberEntityIds);

			surgicalNurseEntities = new HashSet<>();
			surgicalNurseEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : staffEntity.getSurgicalNurse()) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Surgical Nurse relation for this test: " + e.getCause());
					return;
				}
				UUID id = preoperativeRecordsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				surgicalNurseEntities.add(preoperativeRecordsRepository.findById(id).get());
				surgicalNurseEntityIds.add(id);
			}
			staffEntity.unsetSurgicalNurse();
			staffEntity.setSurgicalNurseIds(surgicalNurseEntityIds);

			transferOrderStockDetailsEntities = new HashSet<>();
			transferOrderStockDetailsEntityIds = new HashSet<>();
			for (TransferOrderStockDetailEntity entity : staffEntity.getTransferOrderStockDetails()) {
				try {
					transferOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Transfer Order Stock Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = transferOrderStockDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				transferOrderStockDetailsEntities.add(transferOrderStockDetailRepository.findById(id).get());
				transferOrderStockDetailsEntityIds.add(id);
			}
			staffEntity.unsetTransferOrderStockDetails();
			staffEntity.setTransferOrderStockDetailsIds(transferOrderStockDetailsEntityIds);

			vaccinationOrdersEntities = new HashSet<>();
			vaccinationOrdersEntityIds = new HashSet<>();
			for (VaccinationOrderEntity entity : staffEntity.getVaccinationOrders()) {
				try {
					vaccinationOrderDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Vaccination Orders relation for this test: " + e.getCause());
					return;
				}
				UUID id = vaccinationOrderRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				vaccinationOrdersEntities.add(vaccinationOrderRepository.findById(id).get());
				vaccinationOrdersEntityIds.add(id);
			}
			staffEntity.unsetVaccinationOrders();
			staffEntity.setVaccinationOrdersIds(vaccinationOrdersEntityIds);

			servicesEntities = new HashSet<>();
			servicesEntityIds = new HashSet<>();
			for (ServiceEntity entity : staffEntity.getServices()) {
				try {
					serviceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Services relation for this test: " + e.getCause());
					return;
				}
				UUID id = serviceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				servicesEntities.add(serviceRepository.findById(id).get());
				servicesEntityIds.add(id);
			}
			staffEntity.unsetServices();
			staffEntity.setServicesIds(servicesEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedStaffEntity = staffService.updateOldData(staffEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			administrationUserEntity.unsetStaff(false);
			updatedStaffEntity.getAdministrationUser().unsetStaff(false);
			Assertions.assertEquals(administrationUserEntity, updatedStaffEntity.getAdministrationUser());

			cashierUserEntity.unsetStaff(false);
			updatedStaffEntity.getCashierUser().unsetStaff(false);
			Assertions.assertEquals(cashierUserEntity, updatedStaffEntity.getCashierUser());

			claimUserEntity.unsetStaff(false);
			updatedStaffEntity.getClaimUser().unsetStaff(false);
			Assertions.assertEquals(claimUserEntity, updatedStaffEntity.getClaimUser());

			diagnosticSupportUserEntity.unsetStaff(false);
			updatedStaffEntity.getDiagnosticSupportUser().unsetStaff(false);
			Assertions.assertEquals(diagnosticSupportUserEntity, updatedStaffEntity.getDiagnosticSupportUser());

			doctorUserEntity.unsetStaff(false);
			updatedStaffEntity.getDoctorUser().unsetStaff(false);
			Assertions.assertEquals(doctorUserEntity, updatedStaffEntity.getDoctorUser());

			facilityUserEntity.unsetStaff(false);
			updatedStaffEntity.getFacilityUser().unsetStaff(false);
			Assertions.assertEquals(facilityUserEntity, updatedStaffEntity.getFacilityUser());

			managementUserEntity.unsetStaff(false);
			updatedStaffEntity.getManagementUser().unsetStaff(false);
			Assertions.assertEquals(managementUserEntity, updatedStaffEntity.getManagementUser());

			medicalRecordUserEntity.unsetStaff(false);
			updatedStaffEntity.getMedicalRecordUser().unsetStaff(false);
			Assertions.assertEquals(medicalRecordUserEntity, updatedStaffEntity.getMedicalRecordUser());

			medicalTranscriberUserEntity.unsetStaff(false);
			updatedStaffEntity.getMedicalTranscriberUser().unsetStaff(false);
			Assertions.assertEquals(medicalTranscriberUserEntity, updatedStaffEntity.getMedicalTranscriberUser());

			nurseUserEntity.unsetStaff(false);
			updatedStaffEntity.getNurseUser().unsetStaff(false);
			Assertions.assertEquals(nurseUserEntity, updatedStaffEntity.getNurseUser());

			pharmacyUserEntity.unsetStaff(false);
			updatedStaffEntity.getPharmacyUser().unsetStaff(false);
			Assertions.assertEquals(pharmacyUserEntity, updatedStaffEntity.getPharmacyUser());

			purchasingUserEntity.unsetStaff(false);
			updatedStaffEntity.getPurchasingUser().unsetStaff(false);
			Assertions.assertEquals(purchasingUserEntity, updatedStaffEntity.getPurchasingUser());

			registrationUserEntity.unsetStaff(false);
			updatedStaffEntity.getRegistrationUser().unsetStaff(false);
			Assertions.assertEquals(registrationUserEntity, updatedStaffEntity.getRegistrationUser());

			systemAdminUserEntity.unsetStaff(false);
			updatedStaffEntity.getSystemAdminUser().unsetStaff(false);
			Assertions.assertEquals(systemAdminUserEntity, updatedStaffEntity.getSystemAdminUser());

			warehouseUserEntity.unsetStaff(false);
			updatedStaffEntity.getWarehouseUser().unsetStaff(false);
			Assertions.assertEquals(warehouseUserEntity, updatedStaffEntity.getWarehouseUser());

			administratorEntity.unsetStaff(false);
			updatedStaffEntity.getAdministrator().unsetStaff(false);
			Assertions.assertEquals(administratorEntity, updatedStaffEntity.getAdministrator());

			bpjsDoctorMappingEntity.unsetStaff(false);
			updatedStaffEntity.getBpjsDoctorMapping().unsetStaff(false);
			Assertions.assertEquals(bpjsDoctorMappingEntity, updatedStaffEntity.getBpjsDoctorMapping());

			pcareDokterEntity.unsetStaff(false);
			updatedStaffEntity.getPcareDokter().unsetStaff(false);
			Assertions.assertEquals(pcareDokterEntity, updatedStaffEntity.getPcareDokter());

			serviceEntity.unsetDefaultMedicalStaff(false);
			updatedStaffEntity.getService().unsetDefaultMedicalStaff(false);
			Assertions.assertEquals(serviceEntity, updatedStaffEntity.getService());

			Assertions.assertEquals(accompanyingConsentsEntities.size(), updatedStaffEntity.getAccompanyingConsents().size());

			Assertions.assertEquals(amendmentDetailsEntities.size(), updatedStaffEntity.getAmendmentDetails().size());

			Assertions.assertEquals(anesthesiaMedicalTranscriberEntities.size(), updatedStaffEntity.getAnesthesiaMedicalTranscriber().size());

			Assertions.assertEquals(anesthesiologistEntities.size(), updatedStaffEntity.getAnesthesiologist().size());

			Assertions.assertEquals(anesthesiologyNurseEntities.size(), updatedStaffEntity.getAnesthesiologyNurse().size());

			Assertions.assertEquals(cashierStaffEntities.size(), updatedStaffEntity.getCashierStaff().size());

			Assertions.assertEquals(coTreatingDoctorsEntities.size(), updatedStaffEntity.getCoTreatingDoctors().size());

			Assertions.assertEquals(dailyCareCPPTsCreatedByStaffEntities.size(), updatedStaffEntity.getDailyCareCPPTsCreatedByStaff().size());

			Assertions.assertEquals(dailyCareCPPTsDoctorInChargeEntities.size(), updatedStaffEntity.getDailyCareCPPTsDoctorInCharge().size());

			Assertions.assertEquals(dailyCareCPPTsMedicalTranscriberEntities.size(), updatedStaffEntity.getDailyCareCPPTsMedicalTranscriber().size());

			Assertions.assertEquals(deliveryProgressesEntities.size(), updatedStaffEntity.getDeliveryProgresses().size());

			Assertions.assertEquals(diagnosticStaffExaminationSummariesEntities.size(), updatedStaffEntity.getDiagnosticStaffExaminationSummaries().size());

			Assertions.assertEquals(dismissalReferringStaffEntities.size(), updatedStaffEntity.getDismissalReferringStaff().size());

			Assertions.assertEquals(doctorSchedulesEntities.size(), updatedStaffEntity.getDoctorSchedules().size());

			Assertions.assertEquals(doctorOnExaminationEntities.size(), updatedStaffEntity.getDoctorOnExamination().size());

			Assertions.assertEquals(fluidBalanceDetailsEntities.size(), updatedStaffEntity.getFluidBalanceDetails().size());

			Assertions.assertEquals(hemodialysisMonitoringsEntities.size(), updatedStaffEntity.getHemodialysisMonitorings().size());

			Assertions.assertEquals(hospitalBranchInformationsEntities.size(), updatedStaffEntity.getHospitalBranchInformations().size());

			Assertions.assertEquals(informingConsentsEntities.size(), updatedStaffEntity.getInformingConsents().size());

			Assertions.assertEquals(invoicesEntities.size(), updatedStaffEntity.getInvoices().size());

			Assertions.assertEquals(mcuPackageItemsEntities.size(), updatedStaffEntity.getMcuPackageItems().size());

			Assertions.assertEquals(medicalCertificateDischargeResumesEntities.size(), updatedStaffEntity.getMedicalCertificateDischargeResumes().size());

			Assertions.assertEquals(medicalCertificateBirthsEntities.size(), updatedStaffEntity.getMedicalCertificateBirths().size());

			Assertions.assertEquals(medicalCertificateHospitalizationsEntities.size(), updatedStaffEntity.getMedicalCertificateHospitalizations().size());

			Assertions.assertEquals(medicalExaminationRecordDischargeSummarysEntities.size(), updatedStaffEntity.getMedicalExaminationRecordDischargeSummarys().size());

			Assertions.assertEquals(medicalRecordTranscriberEntities.size(), updatedStaffEntity.getMedicalRecordTranscriber().size());

			Assertions.assertEquals(medicalStaffOfMedicalAttendancesCertificateEntities.size(), updatedStaffEntity.getMedicalStaffOfMedicalAttendancesCertificate().size());

			Assertions.assertEquals(medicalStaffOfMentalHealthsEntities.size(), updatedStaffEntity.getMedicalStaffOfMentalHealths().size());

			Assertions.assertEquals(medicalStaffOfPhysicalHealthsEntities.size(), updatedStaffEntity.getMedicalStaffOfPhysicalHealths().size());

			Assertions.assertEquals(medicalStaffOfRestrictedWorksCertificateEntities.size(), updatedStaffEntity.getMedicalStaffOfRestrictedWorksCertificate().size());

			Assertions.assertEquals(medicalStaffOfSickLeavesCertificateEntities.size(), updatedStaffEntity.getMedicalStaffOfSickLeavesCertificate().size());

			Assertions.assertEquals(medicationAdministeredHisotriesEntities.size(), updatedStaffEntity.getMedicationAdministeredHisotries().size());

			Assertions.assertEquals(medicationHeadersEntities.size(), updatedStaffEntity.getMedicationHeaders().size());

			Assertions.assertEquals(midwivesEntities.size(), updatedStaffEntity.getMidwives().size());

			Assertions.assertEquals(nurseEntities.size(), updatedStaffEntity.getNurse().size());

			Assertions.assertEquals(nursingDetailSurgicalNursingEntities.size(), updatedStaffEntity.getNursingDetailSurgicalNursing().size());

			Assertions.assertEquals(nursingDetailsAnesthesiaNursingEntities.size(), updatedStaffEntity.getNursingDetailsAnesthesiaNursing().size());

			Assertions.assertEquals(patientConsentsEntities.size(), updatedStaffEntity.getPatientConsents().size());

			Assertions.assertEquals(patientVitalInformationsEntities.size(), updatedStaffEntity.getPatientVitalInformations().size());

			Assertions.assertEquals(pediatricianInChargeEntities.size(), updatedStaffEntity.getPediatricianInCharge().size());

			Assertions.assertEquals(prescriptionHeadersEntities.size(), updatedStaffEntity.getPrescriptionHeaders().size());

			Assertions.assertEquals(processWorkflowLogsEntities.size(), updatedStaffEntity.getProcessWorkflowLogs().size());

			Assertions.assertEquals(registrationsEntities.size(), updatedStaffEntity.getRegistrations().size());

			Assertions.assertEquals(requestedByEntities.size(), updatedStaffEntity.getRequestedBy().size());

			Assertions.assertEquals(roomTransfersEntities.size(), updatedStaffEntity.getRoomTransfers().size());

			Assertions.assertEquals(sampleCollectionStaffsEntities.size(), updatedStaffEntity.getSampleCollectionStaffs().size());

			Assertions.assertEquals(sampleDeliveryStaffsEntities.size(), updatedStaffEntity.getSampleDeliveryStaffs().size());

			Assertions.assertEquals(sampleProcessingStaffsEntities.size(), updatedStaffEntity.getSampleProcessingStaffs().size());

			Assertions.assertEquals(surgeonEntities.size(), updatedStaffEntity.getSurgeon().size());

			Assertions.assertEquals(surgicalMedicalTranscriberEntities.size(), updatedStaffEntity.getSurgicalMedicalTranscriber().size());

			Assertions.assertEquals(surgicalNurseEntities.size(), updatedStaffEntity.getSurgicalNurse().size());

			Assertions.assertEquals(transferOrderStockDetailsEntities.size(), updatedStaffEntity.getTransferOrderStockDetails().size());

			Assertions.assertEquals(vaccinationOrdersEntities.size(), updatedStaffEntity.getVaccinationOrders().size());

			Assertions.assertEquals(servicesEntities.size(), updatedStaffEntity.getServices().size());

		});
	}

	@Test
	public void whenCreateStaffEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			StaffEntity staffEntity;
			Optional<StaffEntity> fetchedStaffEntity;

			try {
				staffEntity = staffFactory.getObject(false, false);
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			staffEntity = staffService.create(staffEntity);

			fetchedStaffEntity = staffService.findById(staffEntity.getId());

			Assertions.assertTrue(fetchedStaffEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedStaffEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(staffEntity, fetchedStaffEntity.get());
		});
	}

	@Test
	public void whenUpdateStaffEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			StaffEntity staffEntity;
			StaffEntity updatedStaffEntity;
			Optional<StaffEntity> fetchedStaffEntity;

			try {
				staffEntity = staffFactory.getObject(false, false);
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, false);
				updatedStaffEntity = staffFactory.getObject(false, false);
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(updatedStaffEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			staffEntity = staffService.create(staffEntity);

			updatedStaffEntity.setId(staffEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedStaffEntity.setCreated(staffEntity.getCreated());

			updatedStaffEntity = staffService.update(updatedStaffEntity);

			fetchedStaffEntity = staffService.findById(staffEntity.getId());

			Assertions.assertTrue(fetchedStaffEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateStaffEntity_ThenEntityIsCreated
			fetchedStaffEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedStaffEntity, fetchedStaffEntity.get());
		});
	}

	@Test
	public void whenDeleteStaffEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			StaffEntity staffEntity;
			Optional<StaffEntity> fetchedStaffEntity;

			try {
				staffEntity = staffFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			staffEntity = staffService.create(staffEntity);

			staffService.deleteById(staffEntity.getId());
			fetchedStaffEntity = staffService.findById(staffEntity.getId());

			Assertions.assertTrue(fetchedStaffEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
