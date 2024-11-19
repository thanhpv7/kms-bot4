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
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.BpjsPRBDetailEntity;
import kmsweb.repositories.BpjsPRBDetailRepository;
import kmsweb.utils.BpjsPRBDetailFactory;
import kmsweb.utils.DatabasePopulators.BpjsPRBDetailDatabasePopulator;
import kmsweb.entities.BpjsPcareRegistrationsEntity;
import kmsweb.repositories.BpjsPcareRegistrationsRepository;
import kmsweb.utils.BpjsPcareRegistrationsFactory;
import kmsweb.utils.DatabasePopulators.BpjsPcareRegistrationsDatabasePopulator;
import kmsweb.entities.BpjsSEPEntity;
import kmsweb.repositories.BpjsSEPRepository;
import kmsweb.utils.BpjsSEPFactory;
import kmsweb.utils.DatabasePopulators.BpjsSEPDatabasePopulator;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.utils.BedFacilityFactory;
import kmsweb.utils.DatabasePopulators.BedFacilityDatabasePopulator;
import kmsweb.entities.BedReserveEntity;
import kmsweb.repositories.BedReserveRepository;
import kmsweb.utils.BedReserveFactory;
import kmsweb.utils.DatabasePopulators.BedReserveDatabasePopulator;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
import kmsweb.entities.DiagnosticExaminationResultsEntity;
import kmsweb.repositories.DiagnosticExaminationResultsRepository;
import kmsweb.utils.DiagnosticExaminationResultsFactory;
import kmsweb.utils.DatabasePopulators.DiagnosticExaminationResultsDatabasePopulator;
import kmsweb.entities.DiagnosticStaffExaminationSummaryEntity;
import kmsweb.repositories.DiagnosticStaffExaminationSummaryRepository;
import kmsweb.utils.DiagnosticStaffExaminationSummaryFactory;
import kmsweb.utils.DatabasePopulators.DiagnosticStaffExaminationSummaryDatabasePopulator;
import kmsweb.entities.ExaminationItemEntity;
import kmsweb.repositories.ExaminationItemRepository;
import kmsweb.utils.ExaminationItemFactory;
import kmsweb.utils.DatabasePopulators.ExaminationItemDatabasePopulator;
import kmsweb.entities.FluidBalanceDetailEntity;
import kmsweb.repositories.FluidBalanceDetailRepository;
import kmsweb.utils.FluidBalanceDetailFactory;
import kmsweb.utils.DatabasePopulators.FluidBalanceDetailDatabasePopulator;
import kmsweb.entities.HealthFacilityEntity;
import kmsweb.repositories.HealthFacilityRepository;
import kmsweb.utils.HealthFacilityFactory;
import kmsweb.utils.DatabasePopulators.HealthFacilityDatabasePopulator;
import kmsweb.entities.InformedConsentEntity;
import kmsweb.repositories.InformedConsentRepository;
import kmsweb.utils.InformedConsentFactory;
import kmsweb.utils.DatabasePopulators.InformedConsentDatabasePopulator;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.utils.InvoiceItemFactory;
import kmsweb.utils.DatabasePopulators.InvoiceItemDatabasePopulator;
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
import kmsweb.entities.MedicalFeeEntity;
import kmsweb.repositories.MedicalFeeRepository;
import kmsweb.utils.MedicalFeeFactory;
import kmsweb.utils.DatabasePopulators.MedicalFeeDatabasePopulator;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.utils.MedicationHeaderFactory;
import kmsweb.utils.DatabasePopulators.MedicationHeaderDatabasePopulator;
import kmsweb.entities.PcareExaminationEntity;
import kmsweb.repositories.PcareExaminationRepository;
import kmsweb.utils.PcareExaminationFactory;
import kmsweb.utils.DatabasePopulators.PcareExaminationDatabasePopulator;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;
import kmsweb.utils.PatientVisitFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitDatabasePopulator;
import kmsweb.entities.PatientVitalInformationEntity;
import kmsweb.repositories.PatientVitalInformationRepository;
import kmsweb.utils.PatientVitalInformationFactory;
import kmsweb.utils.DatabasePopulators.PatientVitalInformationDatabasePopulator;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.utils.PrescriptionHeaderFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionHeaderDatabasePopulator;
import kmsweb.entities.SepEntity;
import kmsweb.repositories.SepRepository;
import kmsweb.utils.SepFactory;
import kmsweb.utils.DatabasePopulators.SepDatabasePopulator;
import kmsweb.entities.SampleCollectionInformationEntity;
import kmsweb.repositories.SampleCollectionInformationRepository;
import kmsweb.utils.SampleCollectionInformationFactory;
import kmsweb.utils.DatabasePopulators.SampleCollectionInformationDatabasePopulator;
import kmsweb.entities.ServiceEntity;
import kmsweb.repositories.ServiceRepository;
import kmsweb.utils.ServiceFactory;
import kmsweb.utils.DatabasePopulators.ServiceDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
import kmsweb.entities.VaccinationOrderEntity;
import kmsweb.repositories.VaccinationOrderRepository;
import kmsweb.utils.VaccinationOrderFactory;
import kmsweb.utils.DatabasePopulators.VaccinationOrderDatabasePopulator;
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
public class RegistrationServiceIntegrationTest {

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private RegistrationService registrationService;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	@Autowired
	private BpjsPRBDetailRepository bpjsPRBDetailRepository;

	@Autowired
	private BpjsPRBDetailDatabasePopulator bpjsPRBDetailDatabasePopulator;

	private final BpjsPRBDetailFactory bpjsPRBDetailFactory = new BpjsPRBDetailFactory();

	@Autowired
	private BpjsPcareRegistrationsRepository bpjsPcareRegistrationsRepository;

	@Autowired
	private BpjsPcareRegistrationsDatabasePopulator bpjsPcareRegistrationsDatabasePopulator;

	private final BpjsPcareRegistrationsFactory bpjsPcareRegistrationsFactory = new BpjsPcareRegistrationsFactory();

	@Autowired
	private BpjsSEPRepository bpjsSEPRepository;

	@Autowired
	private BpjsSEPDatabasePopulator bpjsSEPDatabasePopulator;

	private final BpjsSEPFactory bpjsSEPFactory = new BpjsSEPFactory();

	@Autowired
	private BedFacilityRepository bedFacilityRepository;

	@Autowired
	private BedFacilityDatabasePopulator bedFacilityDatabasePopulator;

	private final BedFacilityFactory bedFacilityFactory = new BedFacilityFactory();

	@Autowired
	private BedReserveRepository bedReserveRepository;

	@Autowired
	private BedReserveDatabasePopulator bedReserveDatabasePopulator;

	private final BedReserveFactory bedReserveFactory = new BedReserveFactory();

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();

	@Autowired
	private DiagnosticExaminationResultsRepository diagnosticExaminationResultsRepository;

	@Autowired
	private DiagnosticExaminationResultsDatabasePopulator diagnosticExaminationResultsDatabasePopulator;

	private final DiagnosticExaminationResultsFactory diagnosticExaminationResultsFactory = new DiagnosticExaminationResultsFactory();

	@Autowired
	private DiagnosticStaffExaminationSummaryRepository diagnosticStaffExaminationSummaryRepository;

	@Autowired
	private DiagnosticStaffExaminationSummaryDatabasePopulator diagnosticStaffExaminationSummaryDatabasePopulator;

	private final DiagnosticStaffExaminationSummaryFactory diagnosticStaffExaminationSummaryFactory = new DiagnosticStaffExaminationSummaryFactory();

	@Autowired
	private ExaminationItemRepository examinationItemRepository;

	@Autowired
	private ExaminationItemDatabasePopulator examinationItemDatabasePopulator;

	private final ExaminationItemFactory examinationItemFactory = new ExaminationItemFactory();

	@Autowired
	private FluidBalanceDetailRepository fluidBalanceDetailRepository;

	@Autowired
	private FluidBalanceDetailDatabasePopulator fluidBalanceDetailDatabasePopulator;

	private final FluidBalanceDetailFactory fluidBalanceDetailFactory = new FluidBalanceDetailFactory();

	@Autowired
	private HealthFacilityRepository healthFacilityRepository;

	@Autowired
	private HealthFacilityDatabasePopulator healthFacilityDatabasePopulator;

	private final HealthFacilityFactory healthFacilityFactory = new HealthFacilityFactory();

	@Autowired
	private InformedConsentRepository informedConsentRepository;

	@Autowired
	private InformedConsentDatabasePopulator informedConsentDatabasePopulator;

	private final InformedConsentFactory informedConsentFactory = new InformedConsentFactory();

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Autowired
	private InvoiceItemDatabasePopulator invoiceItemDatabasePopulator;

	private final InvoiceItemFactory invoiceItemFactory = new InvoiceItemFactory();

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
	private MedicalFeeRepository medicalFeeRepository;

	@Autowired
	private MedicalFeeDatabasePopulator medicalFeeDatabasePopulator;

	private final MedicalFeeFactory medicalFeeFactory = new MedicalFeeFactory();

	@Autowired
	private MedicationHeaderRepository medicationHeaderRepository;

	@Autowired
	private MedicationHeaderDatabasePopulator medicationHeaderDatabasePopulator;

	private final MedicationHeaderFactory medicationHeaderFactory = new MedicationHeaderFactory();

	@Autowired
	private PcareExaminationRepository pcareExaminationRepository;

	@Autowired
	private PcareExaminationDatabasePopulator pcareExaminationDatabasePopulator;

	private final PcareExaminationFactory pcareExaminationFactory = new PcareExaminationFactory();

	@Autowired
	private PatientVisitRepository patientVisitRepository;

	@Autowired
	private PatientVisitDatabasePopulator patientVisitDatabasePopulator;

	private final PatientVisitFactory patientVisitFactory = new PatientVisitFactory();

	@Autowired
	private PatientVitalInformationRepository patientVitalInformationRepository;

	@Autowired
	private PatientVitalInformationDatabasePopulator patientVitalInformationDatabasePopulator;

	private final PatientVitalInformationFactory patientVitalInformationFactory = new PatientVitalInformationFactory();

	@Autowired
	private PrescriptionHeaderRepository prescriptionHeaderRepository;

	@Autowired
	private PrescriptionHeaderDatabasePopulator prescriptionHeaderDatabasePopulator;

	private final PrescriptionHeaderFactory prescriptionHeaderFactory = new PrescriptionHeaderFactory();

	@Autowired
	private SepRepository sepRepository;

	@Autowired
	private SepDatabasePopulator sepDatabasePopulator;

	private final SepFactory sepFactory = new SepFactory();

	@Autowired
	private SampleCollectionInformationRepository sampleCollectionInformationRepository;

	@Autowired
	private SampleCollectionInformationDatabasePopulator sampleCollectionInformationDatabasePopulator;

	private final SampleCollectionInformationFactory sampleCollectionInformationFactory = new SampleCollectionInformationFactory();

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ServiceDatabasePopulator serviceDatabasePopulator;

	private final ServiceFactory serviceFactory = new ServiceFactory();

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	private final StaffFactory staffFactory = new StaffFactory();

	@Autowired
	private VaccinationOrderRepository vaccinationOrderRepository;

	@Autowired
	private VaccinationOrderDatabasePopulator vaccinationOrderDatabasePopulator;

	private final VaccinationOrderFactory vaccinationOrderFactory = new VaccinationOrderFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		registrationService = new RegistrationService(
			bpjsPRBDetailRepository,
			bpjsPcareRegistrationsRepository,
			bpjsSEPRepository,
			bedFacilityRepository,
			bedReserveRepository,
			diagnosesAndProceduresRepository,
			diagnosticExaminationResultsRepository,
			diagnosticStaffExaminationSummaryRepository,
			examinationItemRepository,
			fluidBalanceDetailRepository,
			healthFacilityRepository,
			informedConsentRepository,
			invoiceItemRepository,
			medicalCertificateDischargeResumeRepository,
			medicalCertificateBirthRepository,
			medicalCertificateHospitalizationRepository,
			medicalCertificateMedicalAttendanceRepository,
			medicalCertificateMentalHealthRepository,
			medicalCertificatePhysicalHealthRepository,
			medicalCertificateRestrictedWorkRepository,
			medicalCertificateSickLeaveRepository,
			medicalExaminationRecordRepository,
			medicalFeeRepository,
			medicationHeaderRepository,
			pcareExaminationRepository,
			patientVisitRepository,
			patientVitalInformationRepository,
			prescriptionHeaderRepository,
			sepRepository,
			sampleCollectionInformationRepository,
			serviceRepository,
			staffRepository,
			vaccinationOrderRepository,
			validator,
			auditRepository,
			registrationRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewRegistrationEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		RegistrationEntity registrationEntity = registrationFactory.getObject(false, false);

		RegistrationEntity updatedEntity = registrationService.updateOldData(registrationEntity);
		Assertions.assertEquals(registrationEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewRegistrationEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		RegistrationEntity registrationEntity = registrationFactory.getObject(false, false);

		registrationEntity.setCito(null);
		Assertions.assertNull(registrationEntity.getCito());

		registrationEntity.setOneDayCare(null);
		Assertions.assertNull(registrationEntity.getOneDayCare());

		registrationEntity.setReferral(null);
		Assertions.assertNull(registrationEntity.getReferral());

		registrationEntity.setIsAnAppointment(null);
		Assertions.assertNull(registrationEntity.getIsAnAppointment());

		registrationEntity.setDismissalReferral(null);
		Assertions.assertNull(registrationEntity.getDismissalReferral());

		registrationEntity.setPatientIsReferredBack(null);
		Assertions.assertNull(registrationEntity.getPatientIsReferredBack());

		registrationEntity.setIsUnknownPatient(null);
		Assertions.assertNull(registrationEntity.getIsUnknownPatient());


		RegistrationEntity updatedEntity = registrationService.updateOldData(registrationEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getCito());
		Assertions.assertFalse(updatedEntity.getCito());

		Assertions.assertNotNull(updatedEntity.getOneDayCare());
		Assertions.assertFalse(updatedEntity.getOneDayCare());

		Assertions.assertNotNull(updatedEntity.getReferral());
		Assertions.assertFalse(updatedEntity.getReferral());

		Assertions.assertNotNull(updatedEntity.getIsAnAppointment());
		Assertions.assertFalse(updatedEntity.getIsAnAppointment());

		Assertions.assertNotNull(updatedEntity.getDismissalReferral());
		Assertions.assertFalse(updatedEntity.getDismissalReferral());

		Assertions.assertNotNull(updatedEntity.getPatientIsReferredBack());
		Assertions.assertFalse(updatedEntity.getPatientIsReferredBack());

		Assertions.assertNotNull(updatedEntity.getIsUnknownPatient());
		Assertions.assertFalse(updatedEntity.getIsUnknownPatient());

	}

	@Test
	public void updateOldDataWithExistingRegistrationEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationEntity registrationEntity;
			RegistrationEntity entityWithUpdatedValues;

			try {
				registrationEntity = registrationFactory.getObject(false, false);
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = registrationFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			registrationEntity = registrationService.create(registrationEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(registrationEntity.getId());

			RegistrationEntity updatedEntity = registrationService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithRegistrationEntityWithNonExistentId_ShouldThrowException() throws Exception {
		RegistrationEntity registrationEntity = registrationFactory.getObject(false, false);
		registrationEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			registrationService.updateOldData(registrationEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingRegistrationEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationEntity registrationEntity;
			RegistrationEntity updatedRegistrationEntity;

			DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummaryEntity;

			BpjsPRBDetailEntity bpjsPRBDetailEntity;

			BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity;

			BpjsSEPEntity bpjsSEPEntity;

			MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntity;

			MedicalCertificateBirthEntity medicalCertificateBirthEntity;

			MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntity;

			MedicalCertificateMedicalAttendanceEntity medicalCertificateMedicalAttendanceEntity;

			MedicalCertificateMentalHealthEntity medicalCertificateMentalHealthEntity;

			MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity;

			MedicalCertificateRestrictedWorkEntity medicalCertificateRestrictedWorkEntity;

			MedicalCertificateSickLeaveEntity medicalCertificateSickLeaveEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			PcareExaminationEntity pcareExaminationEntity;

			SepEntity sepEntity;

			DiagnosesAndProceduresEntity admissionICD10Entity;

			DiagnosesAndProceduresEntity admissionICD9CMEntity;

			HealthFacilityEntity dismissalReferringFacilityEntity;

			StaffEntity dismissalReferringStaffEntity;

			ServiceEntity referringUnitEntity;

			HealthFacilityEntity referringFacilityEntity;

			BedFacilityEntity bedFacilityEntity;

			PatientVisitEntity patientVisitEntity;

			ServiceEntity serviceEntity;

			StaffEntity staffEntity;

			StaffEntity requestedByEntity;

			Set<BedReserveEntity> bedReservesEntities;

			Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResultsEntities;

			Set<FluidBalanceDetailEntity> fluidBalanceDetailsEntities;

			Set<InformedConsentEntity> informedConsentsEntities;

			Set<InvoiceItemEntity> invoiceItemsEntities;

			Set<MedicalFeeEntity> medicalFeesEntities;

			Set<MedicationHeaderEntity> medicationHeadersEntities;

			Set<PatientVitalInformationEntity> patientVitalInformationsEntities;

			Set<PrescriptionHeaderEntity> prescriptionHeadersEntities;

			Set<SampleCollectionInformationEntity> sampleCollectionInformationsEntities;

			Set<VaccinationOrderEntity> vaccinationOrdersEntities;

			Set<ExaminationItemEntity> examinationItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				registrationEntity = registrationFactory.getObject(true, false);
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
			diagnosticStaffExaminationSummaryEntity = registrationEntity.getDiagnosticStaffExaminationSummary();
			try {
				diagnosticStaffExaminationSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosticStaffExaminationSummaryEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			diagnosticStaffExaminationSummaryEntity = diagnosticStaffExaminationSummaryRepository.save(diagnosticStaffExaminationSummaryEntity);
			registrationEntity.setDiagnosticStaffExaminationSummaryId(diagnosticStaffExaminationSummaryEntity.getId());

			bpjsPRBDetailEntity = registrationEntity.getBpjsPRBDetail();
			try {
				bpjsPRBDetailDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPRBDetailEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsPRBDetailEntity = bpjsPRBDetailRepository.save(bpjsPRBDetailEntity);
			registrationEntity.setBpjsPRBDetailId(bpjsPRBDetailEntity.getId());

			bpjsPcareRegistrationsEntity = registrationEntity.getBpjsPcareRegistrations();
			try {
				bpjsPcareRegistrationsDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareRegistrationsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsRepository.save(bpjsPcareRegistrationsEntity);
			registrationEntity.setBpjsPcareRegistrationsId(bpjsPcareRegistrationsEntity.getId());

			bpjsSEPEntity = registrationEntity.getBpjsSEP();
			try {
				bpjsSEPDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsSEPEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bpjsSEPEntity = bpjsSEPRepository.save(bpjsSEPEntity);
			registrationEntity.setBpjsSEPId(bpjsSEPEntity.getId());

			medicalCertificateDischargeResumeEntity = registrationEntity.getMedicalCertificateDischargeResume();
			try {
				medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateDischargeResumeEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeRepository.save(medicalCertificateDischargeResumeEntity);
			registrationEntity.setMedicalCertificateDischargeResumeId(medicalCertificateDischargeResumeEntity.getId());

			medicalCertificateBirthEntity = registrationEntity.getMedicalCertificateBirth();
			try {
				medicalCertificateBirthDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateBirthEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalCertificateBirthEntity = medicalCertificateBirthRepository.save(medicalCertificateBirthEntity);
			registrationEntity.setMedicalCertificateBirthId(medicalCertificateBirthEntity.getId());

			medicalCertificateHospitalizationEntity = registrationEntity.getMedicalCertificateHospitalization();
			try {
				medicalCertificateHospitalizationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateHospitalizationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationRepository.save(medicalCertificateHospitalizationEntity);
			registrationEntity.setMedicalCertificateHospitalizationId(medicalCertificateHospitalizationEntity.getId());

			medicalCertificateMedicalAttendanceEntity = registrationEntity.getMedicalCertificateMedicalAttendance();
			try {
				medicalCertificateMedicalAttendanceDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateMedicalAttendanceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalCertificateMedicalAttendanceEntity = medicalCertificateMedicalAttendanceRepository.save(medicalCertificateMedicalAttendanceEntity);
			registrationEntity.setMedicalCertificateMedicalAttendanceId(medicalCertificateMedicalAttendanceEntity.getId());

			medicalCertificateMentalHealthEntity = registrationEntity.getMedicalCertificateMentalHealth();
			try {
				medicalCertificateMentalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateMentalHealthEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalCertificateMentalHealthEntity = medicalCertificateMentalHealthRepository.save(medicalCertificateMentalHealthEntity);
			registrationEntity.setMedicalCertificateMentalHealthId(medicalCertificateMentalHealthEntity.getId());

			medicalCertificatePhysicalHealthEntity = registrationEntity.getMedicalCertificatePhysicalHealth();
			try {
				medicalCertificatePhysicalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificatePhysicalHealthEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthRepository.save(medicalCertificatePhysicalHealthEntity);
			registrationEntity.setMedicalCertificatePhysicalHealthId(medicalCertificatePhysicalHealthEntity.getId());

			medicalCertificateRestrictedWorkEntity = registrationEntity.getMedicalCertificateRestrictedWork();
			try {
				medicalCertificateRestrictedWorkDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateRestrictedWorkEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalCertificateRestrictedWorkEntity = medicalCertificateRestrictedWorkRepository.save(medicalCertificateRestrictedWorkEntity);
			registrationEntity.setMedicalCertificateRestrictedWorkId(medicalCertificateRestrictedWorkEntity.getId());

			medicalCertificateSickLeaveEntity = registrationEntity.getMedicalCertificateSickLeave();
			try {
				medicalCertificateSickLeaveDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateSickLeaveEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalCertificateSickLeaveEntity = medicalCertificateSickLeaveRepository.save(medicalCertificateSickLeaveEntity);
			registrationEntity.setMedicalCertificateSickLeaveId(medicalCertificateSickLeaveEntity.getId());

			medicalExaminationRecordEntity = registrationEntity.getMedicalExaminationRecord();
			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.save(medicalExaminationRecordEntity);
			registrationEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			pcareExaminationEntity = registrationEntity.getPcareExamination();
			try {
				pcareExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(pcareExaminationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			pcareExaminationEntity = pcareExaminationRepository.save(pcareExaminationEntity);
			registrationEntity.setPcareExaminationId(pcareExaminationEntity.getId());

			sepEntity = registrationEntity.getSep();
			try {
				sepDatabasePopulator.populateRelatedEntitiesInDatabase(sepEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			sepEntity = sepRepository.save(sepEntity);
			registrationEntity.setSepId(sepEntity.getId());

			admissionICD10Entity = registrationEntity.getAdmissionICD10();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(admissionICD10Entity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			admissionICD10Entity = diagnosesAndProceduresRepository.save(admissionICD10Entity);
			registrationEntity.setAdmissionICD10Id(admissionICD10Entity.getId());

			admissionICD9CMEntity = registrationEntity.getAdmissionICD9CM();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(admissionICD9CMEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			admissionICD9CMEntity = diagnosesAndProceduresRepository.save(admissionICD9CMEntity);
			registrationEntity.setAdmissionICD9CMId(admissionICD9CMEntity.getId());

			dismissalReferringFacilityEntity = registrationEntity.getDismissalReferringFacility();
			try {
				healthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(dismissalReferringFacilityEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			dismissalReferringFacilityEntity = healthFacilityRepository.save(dismissalReferringFacilityEntity);
			registrationEntity.setDismissalReferringFacilityId(dismissalReferringFacilityEntity.getId());

			dismissalReferringStaffEntity = registrationEntity.getDismissalReferringStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(dismissalReferringStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			dismissalReferringStaffEntity = staffRepository.save(dismissalReferringStaffEntity);
			registrationEntity.setDismissalReferringStaffId(dismissalReferringStaffEntity.getId());

			referringUnitEntity = registrationEntity.getReferringUnit();
			try {
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(referringUnitEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			referringUnitEntity = serviceRepository.save(referringUnitEntity);
			registrationEntity.setReferringUnitId(referringUnitEntity.getId());

			referringFacilityEntity = registrationEntity.getReferringFacility();
			try {
				healthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(referringFacilityEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			referringFacilityEntity = healthFacilityRepository.save(referringFacilityEntity);
			registrationEntity.setReferringFacilityId(referringFacilityEntity.getId());

			bedFacilityEntity = registrationEntity.getBedFacility();
			try {
				bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bedFacilityEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bedFacilityEntity = bedFacilityRepository.save(bedFacilityEntity);
			registrationEntity.setBedFacilityId(bedFacilityEntity.getId());

			patientVisitEntity = registrationEntity.getPatientVisit();
			try {
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientVisitEntity = patientVisitRepository.save(patientVisitEntity);
			registrationEntity.setPatientVisitId(patientVisitEntity.getId());

			serviceEntity = registrationEntity.getService();
			try {
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			serviceEntity = serviceRepository.save(serviceEntity);
			registrationEntity.setServiceId(serviceEntity.getId());

			staffEntity = registrationEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			registrationEntity.setStaffId(staffEntity.getId());

			requestedByEntity = registrationEntity.getRequestedBy();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(requestedByEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			requestedByEntity = staffRepository.save(requestedByEntity);
			registrationEntity.setRequestedById(requestedByEntity.getId());

			bedReservesEntities = registrationEntity.getBedReserves();
			Set<UUID> bedReservesEntityIds = new HashSet<>();
			for (BedReserveEntity entity : bedReservesEntities) {
				try {
					bedReserveDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bedReservesEntityIds.add(bedReserveRepository.save(entity).getId());
			}
			registrationEntity.setBedReservesIds(bedReservesEntityIds);

			diagnosticExaminationResultsEntities = registrationEntity.getDiagnosticExaminationResults();
			Set<UUID> diagnosticExaminationResultsEntityIds = new HashSet<>();
			for (DiagnosticExaminationResultsEntity entity : diagnosticExaminationResultsEntities) {
				try {
					diagnosticExaminationResultsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				diagnosticExaminationResultsEntityIds.add(diagnosticExaminationResultsRepository.save(entity).getId());
			}
			registrationEntity.setDiagnosticExaminationResultsIds(diagnosticExaminationResultsEntityIds);

			fluidBalanceDetailsEntities = registrationEntity.getFluidBalanceDetails();
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
			registrationEntity.setFluidBalanceDetailsIds(fluidBalanceDetailsEntityIds);

			informedConsentsEntities = registrationEntity.getInformedConsents();
			Set<UUID> informedConsentsEntityIds = new HashSet<>();
			for (InformedConsentEntity entity : informedConsentsEntities) {
				try {
					informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				informedConsentsEntityIds.add(informedConsentRepository.save(entity).getId());
			}
			registrationEntity.setInformedConsentsIds(informedConsentsEntityIds);

			invoiceItemsEntities = registrationEntity.getInvoiceItems();
			Set<UUID> invoiceItemsEntityIds = new HashSet<>();
			for (InvoiceItemEntity entity : invoiceItemsEntities) {
				try {
					invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoiceItemsEntityIds.add(invoiceItemRepository.save(entity).getId());
			}
			registrationEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			medicalFeesEntities = registrationEntity.getMedicalFees();
			Set<UUID> medicalFeesEntityIds = new HashSet<>();
			for (MedicalFeeEntity entity : medicalFeesEntities) {
				try {
					medicalFeeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalFeesEntityIds.add(medicalFeeRepository.save(entity).getId());
			}
			registrationEntity.setMedicalFeesIds(medicalFeesEntityIds);

			medicationHeadersEntities = registrationEntity.getMedicationHeaders();
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
			registrationEntity.setMedicationHeadersIds(medicationHeadersEntityIds);

			patientVitalInformationsEntities = registrationEntity.getPatientVitalInformations();
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
			registrationEntity.setPatientVitalInformationsIds(patientVitalInformationsEntityIds);

			prescriptionHeadersEntities = registrationEntity.getPrescriptionHeaders();
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
			registrationEntity.setPrescriptionHeadersIds(prescriptionHeadersEntityIds);

			sampleCollectionInformationsEntities = registrationEntity.getSampleCollectionInformations();
			Set<UUID> sampleCollectionInformationsEntityIds = new HashSet<>();
			for (SampleCollectionInformationEntity entity : sampleCollectionInformationsEntities) {
				try {
					sampleCollectionInformationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				sampleCollectionInformationsEntityIds.add(sampleCollectionInformationRepository.save(entity).getId());
			}
			registrationEntity.setSampleCollectionInformationsIds(sampleCollectionInformationsEntityIds);

			vaccinationOrdersEntities = registrationEntity.getVaccinationOrders();
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
			registrationEntity.setVaccinationOrdersIds(vaccinationOrdersEntityIds);

			examinationItemsEntities = registrationEntity.getExaminationItems();
			Set<UUID> examinationItemsEntityIds = new HashSet<>();
			for (ExaminationItemEntity entity : examinationItemsEntities) {
				try {
					examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				examinationItemsEntityIds.add(examinationItemRepository.save(entity).getId());
			}
			registrationEntity.setExaminationItemsIds(examinationItemsEntityIds);

			registrationEntity = registrationService.create(registrationEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(registrationEntity.getDiagnosticStaffExaminationSummary());
			registrationEntity.setDiagnosticStaffExaminationSummaryId(null);
			registrationEntity.unsetDiagnosticStaffExaminationSummary();

			Assertions.assertNotNull(registrationEntity.getBpjsPRBDetail());
			registrationEntity.setBpjsPRBDetailId(null);
			registrationEntity.unsetBpjsPRBDetail();

			Assertions.assertNotNull(registrationEntity.getBpjsPcareRegistrations());
			registrationEntity.setBpjsPcareRegistrationsId(null);
			registrationEntity.unsetBpjsPcareRegistrations();

			Assertions.assertNotNull(registrationEntity.getBpjsSEP());
			registrationEntity.setBpjsSEPId(null);
			registrationEntity.unsetBpjsSEP();

			Assertions.assertNotNull(registrationEntity.getMedicalCertificateDischargeResume());
			registrationEntity.setMedicalCertificateDischargeResumeId(null);
			registrationEntity.unsetMedicalCertificateDischargeResume();

			Assertions.assertNotNull(registrationEntity.getMedicalCertificateBirth());
			registrationEntity.setMedicalCertificateBirthId(null);
			registrationEntity.unsetMedicalCertificateBirth();

			Assertions.assertNotNull(registrationEntity.getMedicalCertificateHospitalization());
			registrationEntity.setMedicalCertificateHospitalizationId(null);
			registrationEntity.unsetMedicalCertificateHospitalization();

			Assertions.assertNotNull(registrationEntity.getMedicalCertificateMedicalAttendance());
			registrationEntity.setMedicalCertificateMedicalAttendanceId(null);
			registrationEntity.unsetMedicalCertificateMedicalAttendance();

			Assertions.assertNotNull(registrationEntity.getMedicalCertificateMentalHealth());
			registrationEntity.setMedicalCertificateMentalHealthId(null);
			registrationEntity.unsetMedicalCertificateMentalHealth();

			Assertions.assertNotNull(registrationEntity.getMedicalCertificatePhysicalHealth());
			registrationEntity.setMedicalCertificatePhysicalHealthId(null);
			registrationEntity.unsetMedicalCertificatePhysicalHealth();

			Assertions.assertNotNull(registrationEntity.getMedicalCertificateRestrictedWork());
			registrationEntity.setMedicalCertificateRestrictedWorkId(null);
			registrationEntity.unsetMedicalCertificateRestrictedWork();

			Assertions.assertNotNull(registrationEntity.getMedicalCertificateSickLeave());
			registrationEntity.setMedicalCertificateSickLeaveId(null);
			registrationEntity.unsetMedicalCertificateSickLeave();

			Assertions.assertNotNull(registrationEntity.getMedicalExaminationRecord());
			registrationEntity.setMedicalExaminationRecordId(null);
			registrationEntity.unsetMedicalExaminationRecord();

			Assertions.assertNotNull(registrationEntity.getPcareExamination());
			registrationEntity.setPcareExaminationId(null);
			registrationEntity.unsetPcareExamination();

			Assertions.assertNotNull(registrationEntity.getSep());
			registrationEntity.setSepId(null);
			registrationEntity.unsetSep();

			Assertions.assertNotNull(registrationEntity.getAdmissionICD10());
			registrationEntity.setAdmissionICD10Id(null);
			registrationEntity.unsetAdmissionICD10();

			Assertions.assertNotNull(registrationEntity.getAdmissionICD9CM());
			registrationEntity.setAdmissionICD9CMId(null);
			registrationEntity.unsetAdmissionICD9CM();

			Assertions.assertNotNull(registrationEntity.getDismissalReferringFacility());
			registrationEntity.setDismissalReferringFacilityId(null);
			registrationEntity.unsetDismissalReferringFacility();

			Assertions.assertNotNull(registrationEntity.getDismissalReferringStaff());
			registrationEntity.setDismissalReferringStaffId(null);
			registrationEntity.unsetDismissalReferringStaff();

			Assertions.assertNotNull(registrationEntity.getReferringUnit());
			registrationEntity.setReferringUnitId(null);
			registrationEntity.unsetReferringUnit();

			Assertions.assertNotNull(registrationEntity.getReferringFacility());
			registrationEntity.setReferringFacilityId(null);
			registrationEntity.unsetReferringFacility();

			Assertions.assertNotNull(registrationEntity.getBedFacility());
			registrationEntity.setBedFacilityId(null);
			registrationEntity.unsetBedFacility();

			Assertions.assertNotNull(registrationEntity.getPatientVisit());
			registrationEntity.setPatientVisitId(null);
			registrationEntity.unsetPatientVisit();

			Assertions.assertNotNull(registrationEntity.getService());
			registrationEntity.setServiceId(null);
			registrationEntity.unsetService();

			Assertions.assertNotNull(registrationEntity.getStaff());
			registrationEntity.setStaffId(null);
			registrationEntity.unsetStaff();

			Assertions.assertNotNull(registrationEntity.getRequestedBy());
			registrationEntity.setRequestedById(null);
			registrationEntity.unsetRequestedBy();

			Assertions.assertTrue(registrationEntity.getBedReserves().size() > 0);
			registrationEntity.setBedReservesIds(new HashSet<UUID>());
			registrationEntity.unsetBedReserves();

			Assertions.assertTrue(registrationEntity.getDiagnosticExaminationResults().size() > 0);
			registrationEntity.setDiagnosticExaminationResultsIds(new HashSet<UUID>());
			registrationEntity.unsetDiagnosticExaminationResults();

			Assertions.assertTrue(registrationEntity.getFluidBalanceDetails().size() > 0);
			registrationEntity.setFluidBalanceDetailsIds(new HashSet<UUID>());
			registrationEntity.unsetFluidBalanceDetails();

			Assertions.assertTrue(registrationEntity.getInformedConsents().size() > 0);
			registrationEntity.setInformedConsentsIds(new HashSet<UUID>());
			registrationEntity.unsetInformedConsents();

			Assertions.assertTrue(registrationEntity.getInvoiceItems().size() > 0);
			registrationEntity.setInvoiceItemsIds(new HashSet<UUID>());
			registrationEntity.unsetInvoiceItems();

			Assertions.assertTrue(registrationEntity.getMedicalFees().size() > 0);
			registrationEntity.setMedicalFeesIds(new HashSet<UUID>());
			registrationEntity.unsetMedicalFees();

			Assertions.assertTrue(registrationEntity.getMedicationHeaders().size() > 0);
			registrationEntity.setMedicationHeadersIds(new HashSet<UUID>());
			registrationEntity.unsetMedicationHeaders();

			Assertions.assertTrue(registrationEntity.getPatientVitalInformations().size() > 0);
			registrationEntity.setPatientVitalInformationsIds(new HashSet<UUID>());
			registrationEntity.unsetPatientVitalInformations();

			Assertions.assertTrue(registrationEntity.getPrescriptionHeaders().size() > 0);
			registrationEntity.setPrescriptionHeadersIds(new HashSet<UUID>());
			registrationEntity.unsetPrescriptionHeaders();

			Assertions.assertTrue(registrationEntity.getSampleCollectionInformations().size() > 0);
			registrationEntity.setSampleCollectionInformationsIds(new HashSet<UUID>());
			registrationEntity.unsetSampleCollectionInformations();

			Assertions.assertTrue(registrationEntity.getVaccinationOrders().size() > 0);
			registrationEntity.setVaccinationOrdersIds(new HashSet<UUID>());
			registrationEntity.unsetVaccinationOrders();

			Assertions.assertTrue(registrationEntity.getExaminationItems().size() > 0);
			registrationEntity.setExaminationItemsIds(new HashSet<UUID>());
			registrationEntity.unsetExaminationItems();


			updatedRegistrationEntity = registrationService.updateOldData(registrationEntity);

			Assertions.assertNull(updatedRegistrationEntity.getDiagnosticStaffExaminationSummary());

			Assertions.assertNull(updatedRegistrationEntity.getBpjsPRBDetail());

			Assertions.assertNull(updatedRegistrationEntity.getBpjsPcareRegistrations());

			Assertions.assertNull(updatedRegistrationEntity.getBpjsSEP());

			Assertions.assertNull(updatedRegistrationEntity.getMedicalCertificateDischargeResume());

			Assertions.assertNull(updatedRegistrationEntity.getMedicalCertificateBirth());

			Assertions.assertNull(updatedRegistrationEntity.getMedicalCertificateHospitalization());

			Assertions.assertNull(updatedRegistrationEntity.getMedicalCertificateMedicalAttendance());

			Assertions.assertNull(updatedRegistrationEntity.getMedicalCertificateMentalHealth());

			Assertions.assertNull(updatedRegistrationEntity.getMedicalCertificatePhysicalHealth());

			Assertions.assertNull(updatedRegistrationEntity.getMedicalCertificateRestrictedWork());

			Assertions.assertNull(updatedRegistrationEntity.getMedicalCertificateSickLeave());

			Assertions.assertNull(updatedRegistrationEntity.getMedicalExaminationRecord());

			Assertions.assertNull(updatedRegistrationEntity.getPcareExamination());

			Assertions.assertNull(updatedRegistrationEntity.getSep());

			Assertions.assertNull(updatedRegistrationEntity.getAdmissionICD10());

			Assertions.assertNull(updatedRegistrationEntity.getAdmissionICD9CM());

			Assertions.assertNull(updatedRegistrationEntity.getDismissalReferringFacility());

			Assertions.assertNull(updatedRegistrationEntity.getDismissalReferringStaff());

			Assertions.assertNull(updatedRegistrationEntity.getReferringUnit());

			Assertions.assertNull(updatedRegistrationEntity.getReferringFacility());

			Assertions.assertNull(updatedRegistrationEntity.getBedFacility());

			Assertions.assertNull(updatedRegistrationEntity.getPatientVisit());

			Assertions.assertNull(updatedRegistrationEntity.getService());

			Assertions.assertNull(updatedRegistrationEntity.getStaff());

			Assertions.assertNull(updatedRegistrationEntity.getRequestedBy());

			Assertions.assertEquals(0, updatedRegistrationEntity.getBedReserves().size());

			Assertions.assertEquals(0, updatedRegistrationEntity.getDiagnosticExaminationResults().size());

			Assertions.assertEquals(0, updatedRegistrationEntity.getFluidBalanceDetails().size());

			Assertions.assertEquals(0, updatedRegistrationEntity.getInformedConsents().size());

			Assertions.assertEquals(0, updatedRegistrationEntity.getInvoiceItems().size());

			Assertions.assertEquals(0, updatedRegistrationEntity.getMedicalFees().size());

			Assertions.assertEquals(0, updatedRegistrationEntity.getMedicationHeaders().size());

			Assertions.assertEquals(0, updatedRegistrationEntity.getPatientVitalInformations().size());

			Assertions.assertEquals(0, updatedRegistrationEntity.getPrescriptionHeaders().size());

			Assertions.assertEquals(0, updatedRegistrationEntity.getSampleCollectionInformations().size());

			Assertions.assertEquals(0, updatedRegistrationEntity.getVaccinationOrders().size());

			Assertions.assertEquals(0, updatedRegistrationEntity.getExaminationItems().size());

		});
	}

	@Test
	public void updateOldDataWithRegistrationEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationEntity registrationEntity;
			RegistrationEntity updatedRegistrationEntity;

			DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummaryEntity;

			BpjsPRBDetailEntity bpjsPRBDetailEntity;

			BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity;

			BpjsSEPEntity bpjsSEPEntity;

			MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntity;

			MedicalCertificateBirthEntity medicalCertificateBirthEntity;

			MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntity;

			MedicalCertificateMedicalAttendanceEntity medicalCertificateMedicalAttendanceEntity;

			MedicalCertificateMentalHealthEntity medicalCertificateMentalHealthEntity;

			MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity;

			MedicalCertificateRestrictedWorkEntity medicalCertificateRestrictedWorkEntity;

			MedicalCertificateSickLeaveEntity medicalCertificateSickLeaveEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			PcareExaminationEntity pcareExaminationEntity;

			SepEntity sepEntity;

			DiagnosesAndProceduresEntity admissionICD10Entity;

			DiagnosesAndProceduresEntity admissionICD9CMEntity;

			HealthFacilityEntity dismissalReferringFacilityEntity;

			StaffEntity dismissalReferringStaffEntity;

			ServiceEntity referringUnitEntity;

			HealthFacilityEntity referringFacilityEntity;

			BedFacilityEntity bedFacilityEntity;

			PatientVisitEntity patientVisitEntity;

			ServiceEntity serviceEntity;

			StaffEntity staffEntity;

			StaffEntity requestedByEntity;

			Set<BedReserveEntity> bedReservesEntities;
			Set<UUID> bedReservesEntityIds;

			Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResultsEntities;
			Set<UUID> diagnosticExaminationResultsEntityIds;

			Set<FluidBalanceDetailEntity> fluidBalanceDetailsEntities;
			Set<UUID> fluidBalanceDetailsEntityIds;

			Set<InformedConsentEntity> informedConsentsEntities;
			Set<UUID> informedConsentsEntityIds;

			Set<InvoiceItemEntity> invoiceItemsEntities;
			Set<UUID> invoiceItemsEntityIds;

			Set<MedicalFeeEntity> medicalFeesEntities;
			Set<UUID> medicalFeesEntityIds;

			Set<MedicationHeaderEntity> medicationHeadersEntities;
			Set<UUID> medicationHeadersEntityIds;

			Set<PatientVitalInformationEntity> patientVitalInformationsEntities;
			Set<UUID> patientVitalInformationsEntityIds;

			Set<PrescriptionHeaderEntity> prescriptionHeadersEntities;
			Set<UUID> prescriptionHeadersEntityIds;

			Set<SampleCollectionInformationEntity> sampleCollectionInformationsEntities;
			Set<UUID> sampleCollectionInformationsEntityIds;

			Set<VaccinationOrderEntity> vaccinationOrdersEntities;
			Set<UUID> vaccinationOrdersEntityIds;

			Set<ExaminationItemEntity> examinationItemsEntities;
			Set<UUID> examinationItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				registrationEntity = registrationFactory.getObject(true, false);
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
				diagnosticStaffExaminationSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getDiagnosticStaffExaminationSummary(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Diagnostic Staff Examination Summary relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			diagnosticStaffExaminationSummaryEntity = diagnosticStaffExaminationSummaryRepository.findById(diagnosticStaffExaminationSummaryRepository.save(registrationEntity.getDiagnosticStaffExaminationSummary()).getId()).get();
			registrationEntity.unsetDiagnosticStaffExaminationSummary();
			registrationEntity.setDiagnosticStaffExaminationSummaryId(diagnosticStaffExaminationSummaryEntity.getId());

			try {
				bpjsPRBDetailDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getBpjsPRBDetail(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS PRB Detail relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsPRBDetailEntity = bpjsPRBDetailRepository.findById(bpjsPRBDetailRepository.save(registrationEntity.getBpjsPRBDetail()).getId()).get();
			registrationEntity.unsetBpjsPRBDetail();
			registrationEntity.setBpjsPRBDetailId(bpjsPRBDetailEntity.getId());

			try {
				bpjsPcareRegistrationsDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getBpjsPcareRegistrations(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS Pcare Registrations relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsRepository.findById(bpjsPcareRegistrationsRepository.save(registrationEntity.getBpjsPcareRegistrations()).getId()).get();
			registrationEntity.unsetBpjsPcareRegistrations();
			registrationEntity.setBpjsPcareRegistrationsId(bpjsPcareRegistrationsEntity.getId());

			try {
				bpjsSEPDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getBpjsSEP(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the BPJS SEP relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bpjsSEPEntity = bpjsSEPRepository.findById(bpjsSEPRepository.save(registrationEntity.getBpjsSEP()).getId()).get();
			registrationEntity.unsetBpjsSEP();
			registrationEntity.setBpjsSEPId(bpjsSEPEntity.getId());

			try {
				medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getMedicalCertificateDischargeResume(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Certificate  Discharge Resume relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeRepository.findById(medicalCertificateDischargeResumeRepository.save(registrationEntity.getMedicalCertificateDischargeResume()).getId()).get();
			registrationEntity.unsetMedicalCertificateDischargeResume();
			registrationEntity.setMedicalCertificateDischargeResumeId(medicalCertificateDischargeResumeEntity.getId());

			try {
				medicalCertificateBirthDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getMedicalCertificateBirth(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Certificate Birth relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalCertificateBirthEntity = medicalCertificateBirthRepository.findById(medicalCertificateBirthRepository.save(registrationEntity.getMedicalCertificateBirth()).getId()).get();
			registrationEntity.unsetMedicalCertificateBirth();
			registrationEntity.setMedicalCertificateBirthId(medicalCertificateBirthEntity.getId());

			try {
				medicalCertificateHospitalizationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getMedicalCertificateHospitalization(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Certificate Hospitalization relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationRepository.findById(medicalCertificateHospitalizationRepository.save(registrationEntity.getMedicalCertificateHospitalization()).getId()).get();
			registrationEntity.unsetMedicalCertificateHospitalization();
			registrationEntity.setMedicalCertificateHospitalizationId(medicalCertificateHospitalizationEntity.getId());

			try {
				medicalCertificateMedicalAttendanceDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getMedicalCertificateMedicalAttendance(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Certificate Medical Attendance relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalCertificateMedicalAttendanceEntity = medicalCertificateMedicalAttendanceRepository.findById(medicalCertificateMedicalAttendanceRepository.save(registrationEntity.getMedicalCertificateMedicalAttendance()).getId()).get();
			registrationEntity.unsetMedicalCertificateMedicalAttendance();
			registrationEntity.setMedicalCertificateMedicalAttendanceId(medicalCertificateMedicalAttendanceEntity.getId());

			try {
				medicalCertificateMentalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getMedicalCertificateMentalHealth(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Certificate Mental Health relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalCertificateMentalHealthEntity = medicalCertificateMentalHealthRepository.findById(medicalCertificateMentalHealthRepository.save(registrationEntity.getMedicalCertificateMentalHealth()).getId()).get();
			registrationEntity.unsetMedicalCertificateMentalHealth();
			registrationEntity.setMedicalCertificateMentalHealthId(medicalCertificateMentalHealthEntity.getId());

			try {
				medicalCertificatePhysicalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getMedicalCertificatePhysicalHealth(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Certificate Physical Health relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthRepository.findById(medicalCertificatePhysicalHealthRepository.save(registrationEntity.getMedicalCertificatePhysicalHealth()).getId()).get();
			registrationEntity.unsetMedicalCertificatePhysicalHealth();
			registrationEntity.setMedicalCertificatePhysicalHealthId(medicalCertificatePhysicalHealthEntity.getId());

			try {
				medicalCertificateRestrictedWorkDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getMedicalCertificateRestrictedWork(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Certificate Restricted Work relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalCertificateRestrictedWorkEntity = medicalCertificateRestrictedWorkRepository.findById(medicalCertificateRestrictedWorkRepository.save(registrationEntity.getMedicalCertificateRestrictedWork()).getId()).get();
			registrationEntity.unsetMedicalCertificateRestrictedWork();
			registrationEntity.setMedicalCertificateRestrictedWorkId(medicalCertificateRestrictedWorkEntity.getId());

			try {
				medicalCertificateSickLeaveDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getMedicalCertificateSickLeave(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Certificate Sick Leave relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalCertificateSickLeaveEntity = medicalCertificateSickLeaveRepository.findById(medicalCertificateSickLeaveRepository.save(registrationEntity.getMedicalCertificateSickLeave()).getId()).get();
			registrationEntity.unsetMedicalCertificateSickLeave();
			registrationEntity.setMedicalCertificateSickLeaveId(medicalCertificateSickLeaveEntity.getId());

			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.findById(medicalExaminationRecordRepository.save(registrationEntity.getMedicalExaminationRecord()).getId()).get();
			registrationEntity.unsetMedicalExaminationRecord();
			registrationEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			try {
				pcareExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getPcareExamination(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the PCare Examination relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			pcareExaminationEntity = pcareExaminationRepository.findById(pcareExaminationRepository.save(registrationEntity.getPcareExamination()).getId()).get();
			registrationEntity.unsetPcareExamination();
			registrationEntity.setPcareExaminationId(pcareExaminationEntity.getId());

			try {
				sepDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getSep(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the SEP relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			sepEntity = sepRepository.findById(sepRepository.save(registrationEntity.getSep()).getId()).get();
			registrationEntity.unsetSep();
			registrationEntity.setSepId(sepEntity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getAdmissionICD10(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Admission ICD 10 relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			admissionICD10Entity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(registrationEntity.getAdmissionICD10()).getId()).get();
			registrationEntity.unsetAdmissionICD10();
			registrationEntity.setAdmissionICD10Id(admissionICD10Entity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getAdmissionICD9CM(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Admission ICD 9 CM relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			admissionICD9CMEntity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(registrationEntity.getAdmissionICD9CM()).getId()).get();
			registrationEntity.unsetAdmissionICD9CM();
			registrationEntity.setAdmissionICD9CMId(admissionICD9CMEntity.getId());

			try {
				healthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getDismissalReferringFacility(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Dismissal Referring Facility relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			dismissalReferringFacilityEntity = healthFacilityRepository.findById(healthFacilityRepository.save(registrationEntity.getDismissalReferringFacility()).getId()).get();
			registrationEntity.unsetDismissalReferringFacility();
			registrationEntity.setDismissalReferringFacilityId(dismissalReferringFacilityEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getDismissalReferringStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Dismissal Referring Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			dismissalReferringStaffEntity = staffRepository.findById(staffRepository.save(registrationEntity.getDismissalReferringStaff()).getId()).get();
			registrationEntity.unsetDismissalReferringStaff();
			registrationEntity.setDismissalReferringStaffId(dismissalReferringStaffEntity.getId());

			try {
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getReferringUnit(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Referring Unit relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			referringUnitEntity = serviceRepository.findById(serviceRepository.save(registrationEntity.getReferringUnit()).getId()).get();
			registrationEntity.unsetReferringUnit();
			registrationEntity.setReferringUnitId(referringUnitEntity.getId());

			try {
				healthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getReferringFacility(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Referring facility relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			referringFacilityEntity = healthFacilityRepository.findById(healthFacilityRepository.save(registrationEntity.getReferringFacility()).getId()).get();
			registrationEntity.unsetReferringFacility();
			registrationEntity.setReferringFacilityId(referringFacilityEntity.getId());

			try {
				bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getBedFacility(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Bed Facility relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bedFacilityEntity = bedFacilityRepository.findById(bedFacilityRepository.save(registrationEntity.getBedFacility()).getId()).get();
			registrationEntity.unsetBedFacility();
			registrationEntity.setBedFacilityId(bedFacilityEntity.getId());

			try {
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getPatientVisit(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Visit relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientVisitEntity = patientVisitRepository.findById(patientVisitRepository.save(registrationEntity.getPatientVisit()).getId()).get();
			registrationEntity.unsetPatientVisit();
			registrationEntity.setPatientVisitId(patientVisitEntity.getId());

			try {
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getService(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Service relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			serviceEntity = serviceRepository.findById(serviceRepository.save(registrationEntity.getService()).getId()).get();
			registrationEntity.unsetService();
			registrationEntity.setServiceId(serviceEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(registrationEntity.getStaff()).getId()).get();
			registrationEntity.unsetStaff();
			registrationEntity.setStaffId(staffEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity.getRequestedBy(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Requested By relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			requestedByEntity = staffRepository.findById(staffRepository.save(registrationEntity.getRequestedBy()).getId()).get();
			registrationEntity.unsetRequestedBy();
			registrationEntity.setRequestedById(requestedByEntity.getId());

			bedReservesEntities = new HashSet<>();
			bedReservesEntityIds = new HashSet<>();
			for (BedReserveEntity entity : registrationEntity.getBedReserves()) {
				try {
					bedReserveDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Bed Reserves relation for this test: " + e.getCause());
					return;
				}
				UUID id = bedReserveRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bedReservesEntities.add(bedReserveRepository.findById(id).get());
				bedReservesEntityIds.add(id);
			}
			registrationEntity.unsetBedReserves();
			registrationEntity.setBedReservesIds(bedReservesEntityIds);

			diagnosticExaminationResultsEntities = new HashSet<>();
			diagnosticExaminationResultsEntityIds = new HashSet<>();
			for (DiagnosticExaminationResultsEntity entity : registrationEntity.getDiagnosticExaminationResults()) {
				try {
					diagnosticExaminationResultsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Diagnostic Examination Results relation for this test: " + e.getCause());
					return;
				}
				UUID id = diagnosticExaminationResultsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				diagnosticExaminationResultsEntities.add(diagnosticExaminationResultsRepository.findById(id).get());
				diagnosticExaminationResultsEntityIds.add(id);
			}
			registrationEntity.unsetDiagnosticExaminationResults();
			registrationEntity.setDiagnosticExaminationResultsIds(diagnosticExaminationResultsEntityIds);

			fluidBalanceDetailsEntities = new HashSet<>();
			fluidBalanceDetailsEntityIds = new HashSet<>();
			for (FluidBalanceDetailEntity entity : registrationEntity.getFluidBalanceDetails()) {
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
			registrationEntity.unsetFluidBalanceDetails();
			registrationEntity.setFluidBalanceDetailsIds(fluidBalanceDetailsEntityIds);

			informedConsentsEntities = new HashSet<>();
			informedConsentsEntityIds = new HashSet<>();
			for (InformedConsentEntity entity : registrationEntity.getInformedConsents()) {
				try {
					informedConsentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Informed Consents relation for this test: " + e.getCause());
					return;
				}
				UUID id = informedConsentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				informedConsentsEntities.add(informedConsentRepository.findById(id).get());
				informedConsentsEntityIds.add(id);
			}
			registrationEntity.unsetInformedConsents();
			registrationEntity.setInformedConsentsIds(informedConsentsEntityIds);

			invoiceItemsEntities = new HashSet<>();
			invoiceItemsEntityIds = new HashSet<>();
			for (InvoiceItemEntity entity : registrationEntity.getInvoiceItems()) {
				try {
					invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoice Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoiceItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoiceItemsEntities.add(invoiceItemRepository.findById(id).get());
				invoiceItemsEntityIds.add(id);
			}
			registrationEntity.unsetInvoiceItems();
			registrationEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			medicalFeesEntities = new HashSet<>();
			medicalFeesEntityIds = new HashSet<>();
			for (MedicalFeeEntity entity : registrationEntity.getMedicalFees()) {
				try {
					medicalFeeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Fees relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalFeeRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalFeesEntities.add(medicalFeeRepository.findById(id).get());
				medicalFeesEntityIds.add(id);
			}
			registrationEntity.unsetMedicalFees();
			registrationEntity.setMedicalFeesIds(medicalFeesEntityIds);

			medicationHeadersEntities = new HashSet<>();
			medicationHeadersEntityIds = new HashSet<>();
			for (MedicationHeaderEntity entity : registrationEntity.getMedicationHeaders()) {
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
			registrationEntity.unsetMedicationHeaders();
			registrationEntity.setMedicationHeadersIds(medicationHeadersEntityIds);

			patientVitalInformationsEntities = new HashSet<>();
			patientVitalInformationsEntityIds = new HashSet<>();
			for (PatientVitalInformationEntity entity : registrationEntity.getPatientVitalInformations()) {
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
			registrationEntity.unsetPatientVitalInformations();
			registrationEntity.setPatientVitalInformationsIds(patientVitalInformationsEntityIds);

			prescriptionHeadersEntities = new HashSet<>();
			prescriptionHeadersEntityIds = new HashSet<>();
			for (PrescriptionHeaderEntity entity : registrationEntity.getPrescriptionHeaders()) {
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
			registrationEntity.unsetPrescriptionHeaders();
			registrationEntity.setPrescriptionHeadersIds(prescriptionHeadersEntityIds);

			sampleCollectionInformationsEntities = new HashSet<>();
			sampleCollectionInformationsEntityIds = new HashSet<>();
			for (SampleCollectionInformationEntity entity : registrationEntity.getSampleCollectionInformations()) {
				try {
					sampleCollectionInformationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Sample Collection Informations relation for this test: " + e.getCause());
					return;
				}
				UUID id = sampleCollectionInformationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				sampleCollectionInformationsEntities.add(sampleCollectionInformationRepository.findById(id).get());
				sampleCollectionInformationsEntityIds.add(id);
			}
			registrationEntity.unsetSampleCollectionInformations();
			registrationEntity.setSampleCollectionInformationsIds(sampleCollectionInformationsEntityIds);

			vaccinationOrdersEntities = new HashSet<>();
			vaccinationOrdersEntityIds = new HashSet<>();
			for (VaccinationOrderEntity entity : registrationEntity.getVaccinationOrders()) {
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
			registrationEntity.unsetVaccinationOrders();
			registrationEntity.setVaccinationOrdersIds(vaccinationOrdersEntityIds);

			examinationItemsEntities = new HashSet<>();
			examinationItemsEntityIds = new HashSet<>();
			for (ExaminationItemEntity entity : registrationEntity.getExaminationItems()) {
				try {
					examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Examination Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = examinationItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				examinationItemsEntities.add(examinationItemRepository.findById(id).get());
				examinationItemsEntityIds.add(id);
			}
			registrationEntity.unsetExaminationItems();
			registrationEntity.setExaminationItemsIds(examinationItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedRegistrationEntity = registrationService.updateOldData(registrationEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			diagnosticStaffExaminationSummaryEntity.unsetRegistration(false);
			updatedRegistrationEntity.getDiagnosticStaffExaminationSummary().unsetRegistration(false);
			Assertions.assertEquals(diagnosticStaffExaminationSummaryEntity, updatedRegistrationEntity.getDiagnosticStaffExaminationSummary());

			bpjsPRBDetailEntity.unsetRegistration(false);
			updatedRegistrationEntity.getBpjsPRBDetail().unsetRegistration(false);
			Assertions.assertEquals(bpjsPRBDetailEntity, updatedRegistrationEntity.getBpjsPRBDetail());

			bpjsPcareRegistrationsEntity.unsetRegistration(false);
			updatedRegistrationEntity.getBpjsPcareRegistrations().unsetRegistration(false);
			Assertions.assertEquals(bpjsPcareRegistrationsEntity, updatedRegistrationEntity.getBpjsPcareRegistrations());

			bpjsSEPEntity.unsetRegistration(false);
			updatedRegistrationEntity.getBpjsSEP().unsetRegistration(false);
			Assertions.assertEquals(bpjsSEPEntity, updatedRegistrationEntity.getBpjsSEP());

			medicalCertificateDischargeResumeEntity.unsetRegistration(false);
			updatedRegistrationEntity.getMedicalCertificateDischargeResume().unsetRegistration(false);
			Assertions.assertEquals(medicalCertificateDischargeResumeEntity, updatedRegistrationEntity.getMedicalCertificateDischargeResume());

			medicalCertificateBirthEntity.unsetRegistration(false);
			updatedRegistrationEntity.getMedicalCertificateBirth().unsetRegistration(false);
			Assertions.assertEquals(medicalCertificateBirthEntity, updatedRegistrationEntity.getMedicalCertificateBirth());

			medicalCertificateHospitalizationEntity.unsetRegistration(false);
			updatedRegistrationEntity.getMedicalCertificateHospitalization().unsetRegistration(false);
			Assertions.assertEquals(medicalCertificateHospitalizationEntity, updatedRegistrationEntity.getMedicalCertificateHospitalization());

			medicalCertificateMedicalAttendanceEntity.unsetRegistration(false);
			updatedRegistrationEntity.getMedicalCertificateMedicalAttendance().unsetRegistration(false);
			Assertions.assertEquals(medicalCertificateMedicalAttendanceEntity, updatedRegistrationEntity.getMedicalCertificateMedicalAttendance());

			medicalCertificateMentalHealthEntity.unsetRegistration(false);
			updatedRegistrationEntity.getMedicalCertificateMentalHealth().unsetRegistration(false);
			Assertions.assertEquals(medicalCertificateMentalHealthEntity, updatedRegistrationEntity.getMedicalCertificateMentalHealth());

			medicalCertificatePhysicalHealthEntity.unsetRegistration(false);
			updatedRegistrationEntity.getMedicalCertificatePhysicalHealth().unsetRegistration(false);
			Assertions.assertEquals(medicalCertificatePhysicalHealthEntity, updatedRegistrationEntity.getMedicalCertificatePhysicalHealth());

			medicalCertificateRestrictedWorkEntity.unsetRegistration(false);
			updatedRegistrationEntity.getMedicalCertificateRestrictedWork().unsetRegistration(false);
			Assertions.assertEquals(medicalCertificateRestrictedWorkEntity, updatedRegistrationEntity.getMedicalCertificateRestrictedWork());

			medicalCertificateSickLeaveEntity.unsetRegistration(false);
			updatedRegistrationEntity.getMedicalCertificateSickLeave().unsetRegistration(false);
			Assertions.assertEquals(medicalCertificateSickLeaveEntity, updatedRegistrationEntity.getMedicalCertificateSickLeave());

			medicalExaminationRecordEntity.unsetRegistration(false);
			updatedRegistrationEntity.getMedicalExaminationRecord().unsetRegistration(false);
			Assertions.assertEquals(medicalExaminationRecordEntity, updatedRegistrationEntity.getMedicalExaminationRecord());

			pcareExaminationEntity.unsetRegistration(false);
			updatedRegistrationEntity.getPcareExamination().unsetRegistration(false);
			Assertions.assertEquals(pcareExaminationEntity, updatedRegistrationEntity.getPcareExamination());

			sepEntity.unsetRegistration(false);
			updatedRegistrationEntity.getSep().unsetRegistration(false);
			Assertions.assertEquals(sepEntity, updatedRegistrationEntity.getSep());

			admissionICD10Entity.unsetAdmissionICD10(false);
			updatedRegistrationEntity.getAdmissionICD10().unsetAdmissionICD10(false);
			Assertions.assertEquals(admissionICD10Entity, updatedRegistrationEntity.getAdmissionICD10());

			admissionICD9CMEntity.unsetAdmissionICD9CM(false);
			updatedRegistrationEntity.getAdmissionICD9CM().unsetAdmissionICD9CM(false);
			Assertions.assertEquals(admissionICD9CMEntity, updatedRegistrationEntity.getAdmissionICD9CM());

			dismissalReferringFacilityEntity.unsetDismissalReferringFacility(false);
			updatedRegistrationEntity.getDismissalReferringFacility().unsetDismissalReferringFacility(false);
			Assertions.assertEquals(dismissalReferringFacilityEntity, updatedRegistrationEntity.getDismissalReferringFacility());

			dismissalReferringStaffEntity.unsetDismissalReferringStaff(false);
			updatedRegistrationEntity.getDismissalReferringStaff().unsetDismissalReferringStaff(false);
			Assertions.assertEquals(dismissalReferringStaffEntity, updatedRegistrationEntity.getDismissalReferringStaff());

			referringUnitEntity.unsetReferringUnit(false);
			updatedRegistrationEntity.getReferringUnit().unsetReferringUnit(false);
			Assertions.assertEquals(referringUnitEntity, updatedRegistrationEntity.getReferringUnit());

			referringFacilityEntity.unsetReferringFacility(false);
			updatedRegistrationEntity.getReferringFacility().unsetReferringFacility(false);
			Assertions.assertEquals(referringFacilityEntity, updatedRegistrationEntity.getReferringFacility());

			bedFacilityEntity.unsetRegistrations(false);
			updatedRegistrationEntity.getBedFacility().unsetRegistrations(false);
			Assertions.assertEquals(bedFacilityEntity, updatedRegistrationEntity.getBedFacility());

			patientVisitEntity.unsetRegistrations(false);
			updatedRegistrationEntity.getPatientVisit().unsetRegistrations(false);
			Assertions.assertEquals(patientVisitEntity, updatedRegistrationEntity.getPatientVisit());

			serviceEntity.unsetRegistrations(false);
			updatedRegistrationEntity.getService().unsetRegistrations(false);
			Assertions.assertEquals(serviceEntity, updatedRegistrationEntity.getService());

			staffEntity.unsetRegistrations(false);
			updatedRegistrationEntity.getStaff().unsetRegistrations(false);
			Assertions.assertEquals(staffEntity, updatedRegistrationEntity.getStaff());

			requestedByEntity.unsetRequestedBy(false);
			updatedRegistrationEntity.getRequestedBy().unsetRequestedBy(false);
			Assertions.assertEquals(requestedByEntity, updatedRegistrationEntity.getRequestedBy());

			Assertions.assertEquals(bedReservesEntities.size(), updatedRegistrationEntity.getBedReserves().size());

			Assertions.assertEquals(diagnosticExaminationResultsEntities.size(), updatedRegistrationEntity.getDiagnosticExaminationResults().size());

			Assertions.assertEquals(fluidBalanceDetailsEntities.size(), updatedRegistrationEntity.getFluidBalanceDetails().size());

			Assertions.assertEquals(informedConsentsEntities.size(), updatedRegistrationEntity.getInformedConsents().size());

			Assertions.assertEquals(invoiceItemsEntities.size(), updatedRegistrationEntity.getInvoiceItems().size());

			Assertions.assertEquals(medicalFeesEntities.size(), updatedRegistrationEntity.getMedicalFees().size());

			Assertions.assertEquals(medicationHeadersEntities.size(), updatedRegistrationEntity.getMedicationHeaders().size());

			Assertions.assertEquals(patientVitalInformationsEntities.size(), updatedRegistrationEntity.getPatientVitalInformations().size());

			Assertions.assertEquals(prescriptionHeadersEntities.size(), updatedRegistrationEntity.getPrescriptionHeaders().size());

			Assertions.assertEquals(sampleCollectionInformationsEntities.size(), updatedRegistrationEntity.getSampleCollectionInformations().size());

			Assertions.assertEquals(vaccinationOrdersEntities.size(), updatedRegistrationEntity.getVaccinationOrders().size());

			Assertions.assertEquals(examinationItemsEntities.size(), updatedRegistrationEntity.getExaminationItems().size());

		});
	}

	@Test
	public void whenCreateRegistrationEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationEntity registrationEntity;
			Optional<RegistrationEntity> fetchedRegistrationEntity;

			try {
				registrationEntity = registrationFactory.getObject(false, false);
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			registrationEntity = registrationService.create(registrationEntity);

			fetchedRegistrationEntity = registrationService.findById(registrationEntity.getId());

			Assertions.assertTrue(fetchedRegistrationEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedRegistrationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(registrationEntity, fetchedRegistrationEntity.get());
		});
	}

	@Test
	public void whenUpdateRegistrationEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationEntity registrationEntity;
			RegistrationEntity updatedRegistrationEntity;
			Optional<RegistrationEntity> fetchedRegistrationEntity;

			try {
				registrationEntity = registrationFactory.getObject(false, false);
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, false);
				updatedRegistrationEntity = registrationFactory.getObject(false, false);
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(updatedRegistrationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			registrationEntity = registrationService.create(registrationEntity);

			updatedRegistrationEntity.setId(registrationEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedRegistrationEntity.setCreated(registrationEntity.getCreated());

			updatedRegistrationEntity = registrationService.update(updatedRegistrationEntity);

			fetchedRegistrationEntity = registrationService.findById(registrationEntity.getId());

			Assertions.assertTrue(fetchedRegistrationEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateRegistrationEntity_ThenEntityIsCreated
			fetchedRegistrationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedRegistrationEntity, fetchedRegistrationEntity.get());
		});
	}

	@Test
	public void whenDeleteRegistrationEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationEntity registrationEntity;
			Optional<RegistrationEntity> fetchedRegistrationEntity;

			try {
				registrationEntity = registrationFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			registrationEntity = registrationService.create(registrationEntity);

			registrationService.deleteById(registrationEntity.getId());
			fetchedRegistrationEntity = registrationService.findById(registrationEntity.getId());

			Assertions.assertTrue(fetchedRegistrationEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
