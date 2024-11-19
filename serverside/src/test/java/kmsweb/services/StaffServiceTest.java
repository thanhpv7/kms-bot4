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

import net.andreinc.mockneat.MockNeat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import kmsweb.entities.StaffEntity;
import kmsweb.lib.validators.SimpleConstraintViolationImpl;
import kmsweb.repositories.StaffRepository;
import kmsweb.repositories.auditing.AuditingRepository;
import kmsweb.repositories.StaffRepository;
import kmsweb.services.StaffService;
import kmsweb.repositories.AdministrationUserRepository;
import kmsweb.repositories.AdministratorRepository;
import kmsweb.repositories.AmendmentDetailRepository;
import kmsweb.repositories.BpjsDoctorMappingRepository;
import kmsweb.repositories.CashReceiptRepository;
import kmsweb.repositories.CashierUserRepository;
import kmsweb.repositories.ClaimUserRepository;
import kmsweb.repositories.CoTreatingDoctorRepository;
import kmsweb.repositories.DailyCareCPPTRepository;
import kmsweb.repositories.DeliveryMedicalExaminationRecordRepository;
import kmsweb.repositories.DeliveryProgressRepository;
import kmsweb.repositories.DiagnosticStaffExaminationSummaryRepository;
import kmsweb.repositories.DiagnosticSupportUserRepository;
import kmsweb.repositories.DoctorScheduleRepository;
import kmsweb.repositories.DoctorUserRepository;
import kmsweb.repositories.FacilityUserRepository;
import kmsweb.repositories.FluidBalanceDetailRepository;
import kmsweb.repositories.HemodialysisMonitoringRepository;
import kmsweb.repositories.HospitalBranchInformationRepository;
import kmsweb.repositories.InformedConsentRepository;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.repositories.McuPackageItemRepository;
import kmsweb.repositories.ManagementUserRepository;
import kmsweb.repositories.MedicalCertificateDischargeResumeRepository;
import kmsweb.repositories.MedicalCertificateBirthRepository;
import kmsweb.repositories.MedicalCertificateHospitalizationRepository;
import kmsweb.repositories.MedicalCertificateMedicalAttendanceRepository;
import kmsweb.repositories.MedicalCertificateMentalHealthRepository;
import kmsweb.repositories.MedicalCertificatePhysicalHealthRepository;
import kmsweb.repositories.MedicalCertificateRestrictedWorkRepository;
import kmsweb.repositories.MedicalCertificateSickLeaveRepository;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.repositories.MedicalExaminationRecordDischargeSummaryRepository;
import kmsweb.repositories.MedicalRecordUserRepository;
import kmsweb.repositories.MedicalTranscriberUserRepository;
import kmsweb.repositories.MedicationAdministeredHistoryRepository;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.repositories.NewbornDetailRepository;
import kmsweb.repositories.NurseUserRepository;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.repositories.PcareDokterRepository;
import kmsweb.repositories.PatientConsentRepository;
import kmsweb.repositories.PatientVitalInformationRepository;
import kmsweb.repositories.PharmacyUserRepository;
import kmsweb.repositories.PreoperativeRecordsRepository;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.repositories.ProcessWorkflowRepository;
import kmsweb.repositories.PurchasingUserRepository;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.repositories.RegistrationUserRepository;
import kmsweb.repositories.RoomTransferRepository;
import kmsweb.repositories.SampleCollectionItemsRepository;
import kmsweb.repositories.ServiceRepository;
import kmsweb.repositories.SystemAdminUserRepository;
import kmsweb.repositories.TransferOrderStockDetailRepository;
import kmsweb.repositories.VaccinationOrderRepository;
import kmsweb.repositories.WarehouseUserRepository;
import kmsweb.lib.file.models.FileEntity;
import kmsweb.lib.file.services.AbstractFileService;
// % protected region % [Override your file service import here] off begin
import kmsweb.lib.file.services.S3FileService;
// % protected region % [Override your file service import here] end
import kmsweb.entities.enums.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Override the default annotations here] off begin
@Tag("validation")
// % protected region % [Override the default annotations here] end
public class StaffServiceTest {
	// % protected region % [Override the file service mock here] off begin
	@Mock
	private S3FileService s3FileService;
	// % protected region % [Override the file service mock here] end


	@Mock
	private AdministrationUserRepository administrationUserRepository;


	@Mock
	private AdministratorRepository administratorRepository;


	@Mock
	private AmendmentDetailRepository amendmentDetailRepository;


	@Mock
	private BpjsDoctorMappingRepository bpjsDoctorMappingRepository;


	@Mock
	private CashReceiptRepository cashReceiptRepository;


	@Mock
	private CashierUserRepository cashierUserRepository;


	@Mock
	private ClaimUserRepository claimUserRepository;


	@Mock
	private CoTreatingDoctorRepository coTreatingDoctorRepository;


	@Mock
	private DailyCareCPPTRepository dailyCareCPPTRepository;


	@Mock
	private DeliveryMedicalExaminationRecordRepository deliveryMedicalExaminationRecordRepository;


	@Mock
	private DeliveryProgressRepository deliveryProgressRepository;


	@Mock
	private DiagnosticStaffExaminationSummaryRepository diagnosticStaffExaminationSummaryRepository;


	@Mock
	private DiagnosticSupportUserRepository diagnosticSupportUserRepository;


	@Mock
	private DoctorScheduleRepository doctorScheduleRepository;


	@Mock
	private DoctorUserRepository doctorUserRepository;


	@Mock
	private FacilityUserRepository facilityUserRepository;


	@Mock
	private FluidBalanceDetailRepository fluidBalanceDetailRepository;


	@Mock
	private HemodialysisMonitoringRepository hemodialysisMonitoringRepository;


	@Mock
	private HospitalBranchInformationRepository hospitalBranchInformationRepository;


	@Mock
	private InformedConsentRepository informedConsentRepository;


	@Mock
	private InvoiceRepository invoiceRepository;


	@Mock
	private McuPackageItemRepository mcuPackageItemRepository;


	@Mock
	private ManagementUserRepository managementUserRepository;


	@Mock
	private MedicalCertificateDischargeResumeRepository medicalCertificateDischargeResumeRepository;


	@Mock
	private MedicalCertificateBirthRepository medicalCertificateBirthRepository;


	@Mock
	private MedicalCertificateHospitalizationRepository medicalCertificateHospitalizationRepository;


	@Mock
	private MedicalCertificateMedicalAttendanceRepository medicalCertificateMedicalAttendanceRepository;


	@Mock
	private MedicalCertificateMentalHealthRepository medicalCertificateMentalHealthRepository;


	@Mock
	private MedicalCertificatePhysicalHealthRepository medicalCertificatePhysicalHealthRepository;


	@Mock
	private MedicalCertificateRestrictedWorkRepository medicalCertificateRestrictedWorkRepository;


	@Mock
	private MedicalCertificateSickLeaveRepository medicalCertificateSickLeaveRepository;


	@Mock
	private MedicalExaminationRecordRepository medicalExaminationRecordRepository;


	@Mock
	private MedicalExaminationRecordDischargeSummaryRepository medicalExaminationRecordDischargeSummaryRepository;


	@Mock
	private MedicalRecordUserRepository medicalRecordUserRepository;


	@Mock
	private MedicalTranscriberUserRepository medicalTranscriberUserRepository;


	@Mock
	private MedicationAdministeredHistoryRepository medicationAdministeredHistoryRepository;


	@Mock
	private MedicationHeaderRepository medicationHeaderRepository;


	@Mock
	private NewbornDetailRepository newbornDetailRepository;


	@Mock
	private NurseUserRepository nurseUserRepository;


	@Mock
	private OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;


	@Mock
	private PcareDokterRepository pcareDokterRepository;


	@Mock
	private PatientConsentRepository patientConsentRepository;


	@Mock
	private PatientVitalInformationRepository patientVitalInformationRepository;


	@Mock
	private PharmacyUserRepository pharmacyUserRepository;


	@Mock
	private PreoperativeRecordsRepository preoperativeRecordsRepository;


	@Mock
	private PrescriptionHeaderRepository prescriptionHeaderRepository;


	@Mock
	private ProcessWorkflowRepository processWorkflowRepository;


	@Mock
	private PurchasingUserRepository purchasingUserRepository;


	@Mock
	private RegistrationRepository registrationRepository;


	@Mock
	private RegistrationUserRepository registrationUserRepository;


	@Mock
	private RoomTransferRepository roomTransferRepository;


	@Mock
	private SampleCollectionItemsRepository sampleCollectionItemsRepository;


	@Mock
	private ServiceRepository serviceRepository;


	@Mock
	private SystemAdminUserRepository systemAdminUserRepository;


	@Mock
	private TransferOrderStockDetailRepository transferOrderStockDetailRepository;


	@Mock
	private VaccinationOrderRepository vaccinationOrderRepository;


	@Mock
	private WarehouseUserRepository warehouseUserRepository;

	@Mock
	private InformedConsentService informedConsentService;

	@Mock
	private AdministratorService administratorService;

	@Mock
	private AmendmentDetailService amendmentDetailService;

	@Mock
	private PreoperativeRecordsService preoperativeRecordsService;

	@Mock
	private PreoperativeRecordsService preoperativeRecordsService;

	@Mock
	private PreoperativeRecordsService preoperativeRecordsService;

	@Mock
	private BpjsDoctorMappingService bpjsDoctorMappingService;

	@Mock
	private CashReceiptService cashReceiptService;

	@Mock
	private CoTreatingDoctorService coTreatingDoctorService;

	@Mock
	private DailyCareCPPTService dailyCareCPPTService;

	@Mock
	private DailyCareCPPTService dailyCareCPPTService;

	@Mock
	private DailyCareCPPTService dailyCareCPPTService;

	@Mock
	private DeliveryProgressService deliveryProgressService;

	@Mock
	private DiagnosticStaffExaminationSummaryService diagnosticStaffExaminationSummaryService;

	@Mock
	private RegistrationService registrationService;

	@Mock
	private DoctorScheduleService doctorScheduleService;

	@Mock
	private MedicalExaminationRecordService medicalExaminationRecordService;

	@Mock
	private FluidBalanceDetailService fluidBalanceDetailService;

	@Mock
	private HemodialysisMonitoringService hemodialysisMonitoringService;

	@Mock
	private HospitalBranchInformationService hospitalBranchInformationService;

	@Mock
	private InformedConsentService informedConsentService;

	@Mock
	private InvoiceService invoiceService;

	@Mock
	private McuPackageItemService mcuPackageItemService;

	@Mock
	private MedicalCertificateDischargeResumeService medicalCertificateDischargeResumeService;

	@Mock
	private MedicalCertificateBirthService medicalCertificateBirthService;

	@Mock
	private MedicalCertificateHospitalizationService medicalCertificateHospitalizationService;

	@Mock
	private MedicalExaminationRecordDischargeSummaryService medicalExaminationRecordDischargeSummaryService;

	@Mock
	private MedicalExaminationRecordService medicalExaminationRecordService;

	@Mock
	private MedicalCertificateMedicalAttendanceService medicalCertificateMedicalAttendanceService;

	@Mock
	private MedicalCertificateMentalHealthService medicalCertificateMentalHealthService;

	@Mock
	private MedicalCertificatePhysicalHealthService medicalCertificatePhysicalHealthService;

	@Mock
	private MedicalCertificateRestrictedWorkService medicalCertificateRestrictedWorkService;

	@Mock
	private MedicalCertificateSickLeaveService medicalCertificateSickLeaveService;

	@Mock
	private MedicationAdministeredHistoryService medicationAdministeredHistoryService;

	@Mock
	private MedicationHeaderService medicationHeaderService;

	@Mock
	private DeliveryMedicalExaminationRecordService deliveryMedicalExaminationRecordService;

	@Mock
	private MedicalExaminationRecordService medicalExaminationRecordService;

	@Mock
	private OperatingTheaterMedicalExaminationRecordService operatingTheaterMedicalExaminationRecordService;

	@Mock
	private OperatingTheaterMedicalExaminationRecordService operatingTheaterMedicalExaminationRecordService;

	@Mock
	private PcareDokterService pcareDokterService;

	@Mock
	private PatientConsentService patientConsentService;

	@Mock
	private PatientVitalInformationService patientVitalInformationService;

	@Mock
	private NewbornDetailService newbornDetailService;

	@Mock
	private PrescriptionHeaderService prescriptionHeaderService;

	@Mock
	private ProcessWorkflowService processWorkflowService;

	@Mock
	private RegistrationService registrationService;

	@Mock
	private RegistrationService registrationService;

	@Mock
	private RoomTransferService roomTransferService;

	@Mock
	private SampleCollectionItemsService sampleCollectionItemsService;

	@Mock
	private SampleCollectionItemsService sampleCollectionItemsService;

	@Mock
	private SampleCollectionItemsService sampleCollectionItemsService;

	@Mock
	private ServiceService serviceService;

	@Mock
	private ServiceService serviceService;

	@Mock
	private PreoperativeRecordsService preoperativeRecordsService;

	@Mock
	private PreoperativeRecordsService preoperativeRecordsService;

	@Mock
	private PreoperativeRecordsService preoperativeRecordsService;

	@Mock
	private TransferOrderStockDetailService transferOrderStockDetailService;

	@Mock
	private VaccinationOrderService vaccinationOrderService;

	@Mock
	private Validator validator;

	@Mock
	private AuditingRepository auditingRepository;

	@Mock
	private StaffRepository staffRepository;

	private StaffService staffService;

	private static MockNeat mockNeat;

	// % protected region % [Add additional method fields here] off begin
	// % protected region % [Add additional method fields here] end

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockNeat = MockNeat.threadLocal();

		staffService = new StaffService(
			// % protected region % [Add any additional constructor parameters here] off begin
			s3FileService,
			// % protected region % [Add any additional constructor parameters here] end
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
			auditingRepository,
			staffRepository
		);

		// % protected region % [Add additional setup logic here] off begin
		// % protected region % [Add additional setup logic here] end
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private StaffEntity setupConstrainViolationMock() {
		// % protected region % [Customise entity mock setup here] off begin
		var entity = new StaffEntity();

		entity.setStaffNumber(mockNeat.strings().get());
		when(staffRepository.findByStaffNumber(entity.getStaffNumber()))
			.thenReturn(Optional.of(entity));

		// % protected region % [Customise entity mock setup here] end

		return entity;
	}

	/**
	 * Setup the entity and the appropriate mocks for the constrain violation tests
	 * @return populated entity
	 */
	private StaffEntity setupConstrainHonouredMock() {
		// % protected region % [Customise valid entity mock setup here] off begin
		var entity = new StaffEntity();

		entity.setStaffNumber(mockNeat.strings().get());
		when(staffRepository.findByStaffNumber(entity.getStaffNumber()))
			.thenReturn(Optional.empty());

		// % protected region % [Customise valid entity mock setup here] end

		return entity;
	}


	// % protected region % [Override test method here testUniquenessConstraintViolatedOnStaffNumberAttribute] off begin
	@Test
	public void testUniquenessConstraintViolatedOnStaffNumberAttribute() {
		var entity = setupConstrainViolationMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<StaffEntity>(
				"Staff Number",
				entity.getStaffNumber(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"StaffNumber"
		);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
			staffService.validateEntity(entity);
		});

		// We only care about the constraint violation we are looking for here
		assertTrue(exception.getConstraintViolations().contains(nameConstraintViolation));
	}
	// % protected region % [Override test method here testUniquenessConstraintViolatedOnStaffNumberAttribute] end

	// % protected region % [Override test method here testUniquenessConstraintHonouredOnStaffNumberAttribute] off begin
	@Test
	public void testUniquenessConstraintHonouredOnStaffNumberAttribute() {
		var entity = setupConstrainHonouredMock();
		String UNIQUENESS_VIOLATION_MESSAGE = "must be unique";
		var nameConstraintViolation = new SimpleConstraintViolationImpl<StaffEntity>(
				"Staff Number",
				entity.getStaffNumber(),
				UNIQUENESS_VIOLATION_MESSAGE,
				"StaffNumber"
		);

		// In the case of a failure an exception will be thrown here of type ConstraintViolationException
		staffService.validateEntity(entity);
	}
	// % protected region % [Override test method here testUniquenessConstraintHonouredOnStaffNumberAttribute] end

	// % protected region % [Add additional test methods here] off begin
	// % protected region % [Add additional test methods here] end
}