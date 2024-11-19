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
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.utils.MedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.AmendmentDetailEntity;
import kmsweb.repositories.AmendmentDetailRepository;
import kmsweb.utils.AmendmentDetailFactory;
import kmsweb.utils.DatabasePopulators.AmendmentDetailDatabasePopulator;
import kmsweb.entities.BirthHistoryEntity;
import kmsweb.repositories.BirthHistoryRepository;
import kmsweb.utils.BirthHistoryFactory;
import kmsweb.utils.DatabasePopulators.BirthHistoryDatabasePopulator;
import kmsweb.entities.BodyChartExaminationEntity;
import kmsweb.repositories.BodyChartExaminationRepository;
import kmsweb.utils.BodyChartExaminationFactory;
import kmsweb.utils.DatabasePopulators.BodyChartExaminationDatabasePopulator;
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
import kmsweb.entities.DiagnosisExaminationRecordEntity;
import kmsweb.repositories.DiagnosisExaminationRecordRepository;
import kmsweb.utils.DiagnosisExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.DiagnosisExaminationRecordDatabasePopulator;
import kmsweb.entities.DiagnosisNandaEntity;
import kmsweb.repositories.DiagnosisNandaRepository;
import kmsweb.utils.DiagnosisNandaFactory;
import kmsweb.utils.DatabasePopulators.DiagnosisNandaDatabasePopulator;
import kmsweb.entities.EntExaminationEntity;
import kmsweb.repositories.EntExaminationRepository;
import kmsweb.utils.EntExaminationFactory;
import kmsweb.utils.DatabasePopulators.EntExaminationDatabasePopulator;
import kmsweb.entities.EmergencyMedicalExaminationRecordEntity;
import kmsweb.repositories.EmergencyMedicalExaminationRecordRepository;
import kmsweb.utils.EmergencyMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.EmergencyMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.FormulirKonselingTesHivEntity;
import kmsweb.repositories.FormulirKonselingTesHivRepository;
import kmsweb.utils.FormulirKonselingTesHivFactory;
import kmsweb.utils.DatabasePopulators.FormulirKonselingTesHivDatabasePopulator;
import kmsweb.entities.HemodialysisExaminationEntity;
import kmsweb.repositories.HemodialysisExaminationRepository;
import kmsweb.utils.HemodialysisExaminationFactory;
import kmsweb.utils.DatabasePopulators.HemodialysisExaminationDatabasePopulator;
import kmsweb.entities.InpatientMedicalExaminationRecordEntity;
import kmsweb.repositories.InpatientMedicalExaminationRecordRepository;
import kmsweb.utils.InpatientMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.InpatientMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.MedicalExaminationRecordDischargeSummaryEntity;
import kmsweb.repositories.MedicalExaminationRecordDischargeSummaryRepository;
import kmsweb.utils.MedicalExaminationRecordDischargeSummaryFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDischargeSummaryDatabasePopulator;
import kmsweb.entities.MedicalRecordInitialChecklistEntity;
import kmsweb.repositories.MedicalRecordInitialChecklistRepository;
import kmsweb.utils.MedicalRecordInitialChecklistFactory;
import kmsweb.utils.DatabasePopulators.MedicalRecordInitialChecklistDatabasePopulator;
import kmsweb.entities.MedicalRecordNextVerificationChecklistEntity;
import kmsweb.repositories.MedicalRecordNextVerificationChecklistRepository;
import kmsweb.utils.MedicalRecordNextVerificationChecklistFactory;
import kmsweb.utils.DatabasePopulators.MedicalRecordNextVerificationChecklistDatabasePopulator;
import kmsweb.entities.NurseVitalSignMeasurementEntity;
import kmsweb.repositories.NurseVitalSignMeasurementRepository;
import kmsweb.utils.NurseVitalSignMeasurementFactory;
import kmsweb.utils.DatabasePopulators.NurseVitalSignMeasurementDatabasePopulator;
import kmsweb.entities.ObstetricAndGynecologyHistoryEntity;
import kmsweb.repositories.ObstetricAndGynecologyHistoryRepository;
import kmsweb.utils.ObstetricAndGynecologyHistoryFactory;
import kmsweb.utils.DatabasePopulators.ObstetricAndGynecologyHistoryDatabasePopulator;
import kmsweb.entities.OdontogramExaminationEntity;
import kmsweb.repositories.OdontogramExaminationRepository;
import kmsweb.utils.OdontogramExaminationFactory;
import kmsweb.utils.DatabasePopulators.OdontogramExaminationDatabasePopulator;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.utils.OperatingTheaterMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.OperatingTheaterMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.OphthalmologyExaminationEntity;
import kmsweb.repositories.OphthalmologyExaminationRepository;
import kmsweb.utils.OphthalmologyExaminationFactory;
import kmsweb.utils.DatabasePopulators.OphthalmologyExaminationDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.RoomTransferEntity;
import kmsweb.repositories.RoomTransferRepository;
import kmsweb.utils.RoomTransferFactory;
import kmsweb.utils.DatabasePopulators.RoomTransferDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
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
public class MedicalExaminationRecordServiceIntegrationTest {

	@Autowired
	private MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MedicalExaminationRecordService medicalExaminationRecordService;

	private final MedicalExaminationRecordFactory medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();

	@Autowired
	private MedicalExaminationRecordDatabasePopulator medicalExaminationRecordDatabasePopulator;

	@Autowired
	private AmendmentDetailRepository amendmentDetailRepository;

	@Autowired
	private AmendmentDetailDatabasePopulator amendmentDetailDatabasePopulator;

	private final AmendmentDetailFactory amendmentDetailFactory = new AmendmentDetailFactory();

	@Autowired
	private BirthHistoryRepository birthHistoryRepository;

	@Autowired
	private BirthHistoryDatabasePopulator birthHistoryDatabasePopulator;

	private final BirthHistoryFactory birthHistoryFactory = new BirthHistoryFactory();

	@Autowired
	private BodyChartExaminationRepository bodyChartExaminationRepository;

	@Autowired
	private BodyChartExaminationDatabasePopulator bodyChartExaminationDatabasePopulator;

	private final BodyChartExaminationFactory bodyChartExaminationFactory = new BodyChartExaminationFactory();

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
	private DiagnosisExaminationRecordRepository diagnosisExaminationRecordRepository;

	@Autowired
	private DiagnosisExaminationRecordDatabasePopulator diagnosisExaminationRecordDatabasePopulator;

	private final DiagnosisExaminationRecordFactory diagnosisExaminationRecordFactory = new DiagnosisExaminationRecordFactory();

	@Autowired
	private DiagnosisNandaRepository diagnosisNandaRepository;

	@Autowired
	private DiagnosisNandaDatabasePopulator diagnosisNandaDatabasePopulator;

	private final DiagnosisNandaFactory diagnosisNandaFactory = new DiagnosisNandaFactory();

	@Autowired
	private EntExaminationRepository entExaminationRepository;

	@Autowired
	private EntExaminationDatabasePopulator entExaminationDatabasePopulator;

	private final EntExaminationFactory entExaminationFactory = new EntExaminationFactory();

	@Autowired
	private EmergencyMedicalExaminationRecordRepository emergencyMedicalExaminationRecordRepository;

	@Autowired
	private EmergencyMedicalExaminationRecordDatabasePopulator emergencyMedicalExaminationRecordDatabasePopulator;

	private final EmergencyMedicalExaminationRecordFactory emergencyMedicalExaminationRecordFactory = new EmergencyMedicalExaminationRecordFactory();

	@Autowired
	private FormulirKonselingTesHivRepository formulirKonselingTesHivRepository;

	@Autowired
	private FormulirKonselingTesHivDatabasePopulator formulirKonselingTesHivDatabasePopulator;

	private final FormulirKonselingTesHivFactory formulirKonselingTesHivFactory = new FormulirKonselingTesHivFactory();

	@Autowired
	private HemodialysisExaminationRepository hemodialysisExaminationRepository;

	@Autowired
	private HemodialysisExaminationDatabasePopulator hemodialysisExaminationDatabasePopulator;

	private final HemodialysisExaminationFactory hemodialysisExaminationFactory = new HemodialysisExaminationFactory();

	@Autowired
	private InpatientMedicalExaminationRecordRepository inpatientMedicalExaminationRecordRepository;

	@Autowired
	private InpatientMedicalExaminationRecordDatabasePopulator inpatientMedicalExaminationRecordDatabasePopulator;

	private final InpatientMedicalExaminationRecordFactory inpatientMedicalExaminationRecordFactory = new InpatientMedicalExaminationRecordFactory();

	@Autowired
	private MedicalExaminationRecordDischargeSummaryRepository medicalExaminationRecordDischargeSummaryRepository;

	@Autowired
	private MedicalExaminationRecordDischargeSummaryDatabasePopulator medicalExaminationRecordDischargeSummaryDatabasePopulator;

	private final MedicalExaminationRecordDischargeSummaryFactory medicalExaminationRecordDischargeSummaryFactory = new MedicalExaminationRecordDischargeSummaryFactory();

	@Autowired
	private MedicalRecordInitialChecklistRepository medicalRecordInitialChecklistRepository;

	@Autowired
	private MedicalRecordInitialChecklistDatabasePopulator medicalRecordInitialChecklistDatabasePopulator;

	private final MedicalRecordInitialChecklistFactory medicalRecordInitialChecklistFactory = new MedicalRecordInitialChecklistFactory();

	@Autowired
	private MedicalRecordNextVerificationChecklistRepository medicalRecordNextVerificationChecklistRepository;

	@Autowired
	private MedicalRecordNextVerificationChecklistDatabasePopulator medicalRecordNextVerificationChecklistDatabasePopulator;

	private final MedicalRecordNextVerificationChecklistFactory medicalRecordNextVerificationChecklistFactory = new MedicalRecordNextVerificationChecklistFactory();

	@Autowired
	private NurseVitalSignMeasurementRepository nurseVitalSignMeasurementRepository;

	@Autowired
	private NurseVitalSignMeasurementDatabasePopulator nurseVitalSignMeasurementDatabasePopulator;

	private final NurseVitalSignMeasurementFactory nurseVitalSignMeasurementFactory = new NurseVitalSignMeasurementFactory();

	@Autowired
	private ObstetricAndGynecologyHistoryRepository obstetricAndGynecologyHistoryRepository;

	@Autowired
	private ObstetricAndGynecologyHistoryDatabasePopulator obstetricAndGynecologyHistoryDatabasePopulator;

	private final ObstetricAndGynecologyHistoryFactory obstetricAndGynecologyHistoryFactory = new ObstetricAndGynecologyHistoryFactory();

	@Autowired
	private OdontogramExaminationRepository odontogramExaminationRepository;

	@Autowired
	private OdontogramExaminationDatabasePopulator odontogramExaminationDatabasePopulator;

	private final OdontogramExaminationFactory odontogramExaminationFactory = new OdontogramExaminationFactory();

	@Autowired
	private OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;

	@Autowired
	private OperatingTheaterMedicalExaminationRecordDatabasePopulator operatingTheaterMedicalExaminationRecordDatabasePopulator;

	private final OperatingTheaterMedicalExaminationRecordFactory operatingTheaterMedicalExaminationRecordFactory = new OperatingTheaterMedicalExaminationRecordFactory();

	@Autowired
	private OphthalmologyExaminationRepository ophthalmologyExaminationRepository;

	@Autowired
	private OphthalmologyExaminationDatabasePopulator ophthalmologyExaminationDatabasePopulator;

	private final OphthalmologyExaminationFactory ophthalmologyExaminationFactory = new OphthalmologyExaminationFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private RoomTransferRepository roomTransferRepository;

	@Autowired
	private RoomTransferDatabasePopulator roomTransferDatabasePopulator;

	private final RoomTransferFactory roomTransferFactory = new RoomTransferFactory();

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	private final StaffFactory staffFactory = new StaffFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		medicalExaminationRecordService = new MedicalExaminationRecordService(
			amendmentDetailRepository,
			birthHistoryRepository,
			bodyChartExaminationRepository,
			coTreatingDoctorRepository,
			dailyCareCPPTRepository,
			deliveryMedicalExaminationRecordRepository,
			diagnosisExaminationRecordRepository,
			diagnosisNandaRepository,
			entExaminationRepository,
			emergencyMedicalExaminationRecordRepository,
			formulirKonselingTesHivRepository,
			hemodialysisExaminationRepository,
			inpatientMedicalExaminationRecordRepository,
			medicalExaminationRecordDischargeSummaryRepository,
			medicalRecordInitialChecklistRepository,
			medicalRecordNextVerificationChecklistRepository,
			nurseVitalSignMeasurementRepository,
			obstetricAndGynecologyHistoryRepository,
			odontogramExaminationRepository,
			operatingTheaterMedicalExaminationRecordRepository,
			ophthalmologyExaminationRepository,
			registrationRepository,
			roomTransferRepository,
			staffRepository,
			validator,
			auditRepository,
			medicalExaminationRecordRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMedicalExaminationRecordEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MedicalExaminationRecordEntity medicalExaminationRecordEntity = medicalExaminationRecordFactory.getObject(false, false);

		MedicalExaminationRecordEntity updatedEntity = medicalExaminationRecordService.updateOldData(medicalExaminationRecordEntity);
		Assertions.assertEquals(medicalExaminationRecordEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewMedicalExaminationRecordEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		MedicalExaminationRecordEntity medicalExaminationRecordEntity = medicalExaminationRecordFactory.getObject(false, false);

		medicalExaminationRecordEntity.setFamilyPlanning(null);
		Assertions.assertNull(medicalExaminationRecordEntity.getFamilyPlanning());

		medicalExaminationRecordEntity.setDiastema(null);
		Assertions.assertNull(medicalExaminationRecordEntity.getDiastema());

		medicalExaminationRecordEntity.setToothAnomaly(null);
		Assertions.assertNull(medicalExaminationRecordEntity.getToothAnomaly());


		MedicalExaminationRecordEntity updatedEntity = medicalExaminationRecordService.updateOldData(medicalExaminationRecordEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getFamilyPlanning());
		Assertions.assertFalse(updatedEntity.getFamilyPlanning());

		Assertions.assertNotNull(updatedEntity.getDiastema());
		Assertions.assertFalse(updatedEntity.getDiastema());

		Assertions.assertNotNull(updatedEntity.getToothAnomaly());
		Assertions.assertFalse(updatedEntity.getToothAnomaly());

	}

	@Test
	public void updateOldDataWithExistingMedicalExaminationRecordEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordEntity medicalExaminationRecordEntity;
			MedicalExaminationRecordEntity entityWithUpdatedValues;

			try {
				medicalExaminationRecordEntity = medicalExaminationRecordFactory.getObject(false, false);
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = medicalExaminationRecordFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalExaminationRecordEntity = medicalExaminationRecordService.create(medicalExaminationRecordEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(medicalExaminationRecordEntity.getId());

			MedicalExaminationRecordEntity updatedEntity = medicalExaminationRecordService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMedicalExaminationRecordEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MedicalExaminationRecordEntity medicalExaminationRecordEntity = medicalExaminationRecordFactory.getObject(false, false);
		medicalExaminationRecordEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			medicalExaminationRecordService.updateOldData(medicalExaminationRecordEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMedicalExaminationRecordEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordEntity medicalExaminationRecordEntity;
			MedicalExaminationRecordEntity updatedMedicalExaminationRecordEntity;

			InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntity;

			RegistrationEntity registrationEntity;

			BirthHistoryEntity birthHistoryEntity;

			BodyChartExaminationEntity bodyChartExaminationEntity;

			DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity;

			EntExaminationEntity entExaminationEntity;

			EmergencyMedicalExaminationRecordEntity emergencyMedicationExaminationRecordEntity;

			FormulirKonselingTesHivEntity formulirKonselingTesHivEntity;

			HemodialysisExaminationEntity hemodialysisExaminationEntity;

			MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity;

			MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity;

			MedicalRecordNextVerificationChecklistEntity medicalRecordNextVerificationChecklistEntity;

			NurseVitalSignMeasurementEntity nurseVitalSignMeasurementEntity;

			ObstetricAndGynecologyHistoryEntity obstetricAndGynecologyHistoryEntity;

			OdontogramExaminationEntity odontogramExaminationEntity;

			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;

			OphthalmologyExaminationEntity ophthalmologyExaminationEntity;

			StaffEntity doctorEntity;

			StaffEntity medicalTranscriberEntity;

			StaffEntity nurseEntity;

			Set<AmendmentDetailEntity> amendmentDetailsEntities;

			Set<CoTreatingDoctorEntity> coTreatingDoctorsEntities;

			Set<DailyCareCPPTEntity> dailyCareCPPTsEntities;

			Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecordsEntities;

			Set<DiagnosisNandaEntity> diagnosisNandasEntities;

			Set<RoomTransferEntity> roomTransfersEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalExaminationRecordEntity = medicalExaminationRecordFactory.getObject(true, false);
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
			inpatientMedicalExaminationRecordEntity = medicalExaminationRecordEntity.getInpatientMedicalExaminationRecord();
			try {
				inpatientMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(inpatientMedicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordRepository.save(inpatientMedicalExaminationRecordEntity);
			medicalExaminationRecordEntity.setInpatientMedicalExaminationRecordId(inpatientMedicalExaminationRecordEntity.getId());

			registrationEntity = medicalExaminationRecordEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			medicalExaminationRecordEntity.setRegistrationId(registrationEntity.getId());

			birthHistoryEntity = medicalExaminationRecordEntity.getBirthHistory();
			try {
				birthHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(birthHistoryEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			birthHistoryEntity = birthHistoryRepository.save(birthHistoryEntity);
			medicalExaminationRecordEntity.setBirthHistoryId(birthHistoryEntity.getId());

			bodyChartExaminationEntity = medicalExaminationRecordEntity.getBodyChartExamination();
			try {
				bodyChartExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(bodyChartExaminationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			bodyChartExaminationEntity = bodyChartExaminationRepository.save(bodyChartExaminationEntity);
			medicalExaminationRecordEntity.setBodyChartExaminationId(bodyChartExaminationEntity.getId());

			deliveryMedicalExaminationRecordEntity = medicalExaminationRecordEntity.getDeliveryMedicalExaminationRecord();
			try {
				deliveryMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(deliveryMedicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordRepository.save(deliveryMedicalExaminationRecordEntity);
			medicalExaminationRecordEntity.setDeliveryMedicalExaminationRecordId(deliveryMedicalExaminationRecordEntity.getId());

			entExaminationEntity = medicalExaminationRecordEntity.getEntExamination();
			try {
				entExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(entExaminationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			entExaminationEntity = entExaminationRepository.save(entExaminationEntity);
			medicalExaminationRecordEntity.setEntExaminationId(entExaminationEntity.getId());

			emergencyMedicationExaminationRecordEntity = medicalExaminationRecordEntity.getEmergencyMedicationExaminationRecord();
			try {
				emergencyMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(emergencyMedicationExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			emergencyMedicationExaminationRecordEntity = emergencyMedicalExaminationRecordRepository.save(emergencyMedicationExaminationRecordEntity);
			medicalExaminationRecordEntity.setEmergencyMedicationExaminationRecordId(emergencyMedicationExaminationRecordEntity.getId());

			formulirKonselingTesHivEntity = medicalExaminationRecordEntity.getFormulirKonselingTesHiv();
			try {
				formulirKonselingTesHivDatabasePopulator.populateRelatedEntitiesInDatabase(formulirKonselingTesHivEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			formulirKonselingTesHivEntity = formulirKonselingTesHivRepository.save(formulirKonselingTesHivEntity);
			medicalExaminationRecordEntity.setFormulirKonselingTesHivId(formulirKonselingTesHivEntity.getId());

			hemodialysisExaminationEntity = medicalExaminationRecordEntity.getHemodialysisExamination();
			try {
				hemodialysisExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisExaminationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			hemodialysisExaminationEntity = hemodialysisExaminationRepository.save(hemodialysisExaminationEntity);
			medicalExaminationRecordEntity.setHemodialysisExaminationId(hemodialysisExaminationEntity.getId());

			medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary();
			try {
				medicalExaminationRecordDischargeSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordDischargeSummaryEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryRepository.save(medicalExaminationRecordDischargeSummaryEntity);
			medicalExaminationRecordEntity.setMedicalExaminationRecordDischargeSummaryId(medicalExaminationRecordDischargeSummaryEntity.getId());

			medicalRecordInitialChecklistEntity = medicalExaminationRecordEntity.getMedicalRecordInitialChecklist();
			try {
				medicalRecordInitialChecklistDatabasePopulator.populateRelatedEntitiesInDatabase(medicalRecordInitialChecklistEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistRepository.save(medicalRecordInitialChecklistEntity);
			medicalExaminationRecordEntity.setMedicalRecordInitialChecklistId(medicalRecordInitialChecklistEntity.getId());

			medicalRecordNextVerificationChecklistEntity = medicalExaminationRecordEntity.getMedicalRecordNextVerificationChecklist();
			try {
				medicalRecordNextVerificationChecklistDatabasePopulator.populateRelatedEntitiesInDatabase(medicalRecordNextVerificationChecklistEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalRecordNextVerificationChecklistEntity = medicalRecordNextVerificationChecklistRepository.save(medicalRecordNextVerificationChecklistEntity);
			medicalExaminationRecordEntity.setMedicalRecordNextVerificationChecklistId(medicalRecordNextVerificationChecklistEntity.getId());

			nurseVitalSignMeasurementEntity = medicalExaminationRecordEntity.getNurseVitalSignMeasurement();
			try {
				nurseVitalSignMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(nurseVitalSignMeasurementEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			nurseVitalSignMeasurementEntity = nurseVitalSignMeasurementRepository.save(nurseVitalSignMeasurementEntity);
			medicalExaminationRecordEntity.setNurseVitalSignMeasurementId(nurseVitalSignMeasurementEntity.getId());

			obstetricAndGynecologyHistoryEntity = medicalExaminationRecordEntity.getObstetricAndGynecologyHistory();
			try {
				obstetricAndGynecologyHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(obstetricAndGynecologyHistoryEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			obstetricAndGynecologyHistoryEntity = obstetricAndGynecologyHistoryRepository.save(obstetricAndGynecologyHistoryEntity);
			medicalExaminationRecordEntity.setObstetricAndGynecologyHistoryId(obstetricAndGynecologyHistoryEntity.getId());

			odontogramExaminationEntity = medicalExaminationRecordEntity.getOdontogramExamination();
			try {
				odontogramExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(odontogramExaminationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			odontogramExaminationEntity = odontogramExaminationRepository.save(odontogramExaminationEntity);
			medicalExaminationRecordEntity.setOdontogramExaminationId(odontogramExaminationEntity.getId());

			operatingTheaterMedicalExaminationRecordEntity = medicalExaminationRecordEntity.getOperatingTheaterMedicalExaminationRecord();
			try {
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordRepository.save(operatingTheaterMedicalExaminationRecordEntity);
			medicalExaminationRecordEntity.setOperatingTheaterMedicalExaminationRecordId(operatingTheaterMedicalExaminationRecordEntity.getId());

			ophthalmologyExaminationEntity = medicalExaminationRecordEntity.getOphthalmologyExamination();
			try {
				ophthalmologyExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(ophthalmologyExaminationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			ophthalmologyExaminationEntity = ophthalmologyExaminationRepository.save(ophthalmologyExaminationEntity);
			medicalExaminationRecordEntity.setOphthalmologyExaminationId(ophthalmologyExaminationEntity.getId());

			doctorEntity = medicalExaminationRecordEntity.getDoctor();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(doctorEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			doctorEntity = staffRepository.save(doctorEntity);
			medicalExaminationRecordEntity.setDoctorId(doctorEntity.getId());

			medicalTranscriberEntity = medicalExaminationRecordEntity.getMedicalTranscriber();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalTranscriberEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalTranscriberEntity = staffRepository.save(medicalTranscriberEntity);
			medicalExaminationRecordEntity.setMedicalTranscriberId(medicalTranscriberEntity.getId());

			nurseEntity = medicalExaminationRecordEntity.getNurse();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(nurseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			nurseEntity = staffRepository.save(nurseEntity);
			medicalExaminationRecordEntity.setNurseId(nurseEntity.getId());

			amendmentDetailsEntities = medicalExaminationRecordEntity.getAmendmentDetails();
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
			medicalExaminationRecordEntity.setAmendmentDetailsIds(amendmentDetailsEntityIds);

			coTreatingDoctorsEntities = medicalExaminationRecordEntity.getCoTreatingDoctors();
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
			medicalExaminationRecordEntity.setCoTreatingDoctorsIds(coTreatingDoctorsEntityIds);

			dailyCareCPPTsEntities = medicalExaminationRecordEntity.getDailyCareCPPTs();
			Set<UUID> dailyCareCPPTsEntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : dailyCareCPPTsEntities) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				dailyCareCPPTsEntityIds.add(dailyCareCPPTRepository.save(entity).getId());
			}
			medicalExaminationRecordEntity.setDailyCareCPPTsIds(dailyCareCPPTsEntityIds);

			diagnosisExaminationRecordsEntities = medicalExaminationRecordEntity.getDiagnosisExaminationRecords();
			Set<UUID> diagnosisExaminationRecordsEntityIds = new HashSet<>();
			for (DiagnosisExaminationRecordEntity entity : diagnosisExaminationRecordsEntities) {
				try {
					diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				diagnosisExaminationRecordsEntityIds.add(diagnosisExaminationRecordRepository.save(entity).getId());
			}
			medicalExaminationRecordEntity.setDiagnosisExaminationRecordsIds(diagnosisExaminationRecordsEntityIds);

			diagnosisNandasEntities = medicalExaminationRecordEntity.getDiagnosisNandas();
			Set<UUID> diagnosisNandasEntityIds = new HashSet<>();
			for (DiagnosisNandaEntity entity : diagnosisNandasEntities) {
				try {
					diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				diagnosisNandasEntityIds.add(diagnosisNandaRepository.save(entity).getId());
			}
			medicalExaminationRecordEntity.setDiagnosisNandasIds(diagnosisNandasEntityIds);

			roomTransfersEntities = medicalExaminationRecordEntity.getRoomTransfers();
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
			medicalExaminationRecordEntity.setRoomTransfersIds(roomTransfersEntityIds);


			medicalExaminationRecordEntity = medicalExaminationRecordService.create(medicalExaminationRecordEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(medicalExaminationRecordEntity.getInpatientMedicalExaminationRecord());
			medicalExaminationRecordEntity.setInpatientMedicalExaminationRecordId(null);
			medicalExaminationRecordEntity.unsetInpatientMedicalExaminationRecord();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getRegistration());
			medicalExaminationRecordEntity.setRegistrationId(null);
			medicalExaminationRecordEntity.unsetRegistration();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getBirthHistory());
			medicalExaminationRecordEntity.setBirthHistoryId(null);
			medicalExaminationRecordEntity.unsetBirthHistory();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getBodyChartExamination());
			medicalExaminationRecordEntity.setBodyChartExaminationId(null);
			medicalExaminationRecordEntity.unsetBodyChartExamination();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getDeliveryMedicalExaminationRecord());
			medicalExaminationRecordEntity.setDeliveryMedicalExaminationRecordId(null);
			medicalExaminationRecordEntity.unsetDeliveryMedicalExaminationRecord();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getEntExamination());
			medicalExaminationRecordEntity.setEntExaminationId(null);
			medicalExaminationRecordEntity.unsetEntExamination();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getEmergencyMedicationExaminationRecord());
			medicalExaminationRecordEntity.setEmergencyMedicationExaminationRecordId(null);
			medicalExaminationRecordEntity.unsetEmergencyMedicationExaminationRecord();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getFormulirKonselingTesHiv());
			medicalExaminationRecordEntity.setFormulirKonselingTesHivId(null);
			medicalExaminationRecordEntity.unsetFormulirKonselingTesHiv();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getHemodialysisExamination());
			medicalExaminationRecordEntity.setHemodialysisExaminationId(null);
			medicalExaminationRecordEntity.unsetHemodialysisExamination();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary());
			medicalExaminationRecordEntity.setMedicalExaminationRecordDischargeSummaryId(null);
			medicalExaminationRecordEntity.unsetMedicalExaminationRecordDischargeSummary();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getMedicalRecordInitialChecklist());
			medicalExaminationRecordEntity.setMedicalRecordInitialChecklistId(null);
			medicalExaminationRecordEntity.unsetMedicalRecordInitialChecklist();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getMedicalRecordNextVerificationChecklist());
			medicalExaminationRecordEntity.setMedicalRecordNextVerificationChecklistId(null);
			medicalExaminationRecordEntity.unsetMedicalRecordNextVerificationChecklist();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getNurseVitalSignMeasurement());
			medicalExaminationRecordEntity.setNurseVitalSignMeasurementId(null);
			medicalExaminationRecordEntity.unsetNurseVitalSignMeasurement();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getObstetricAndGynecologyHistory());
			medicalExaminationRecordEntity.setObstetricAndGynecologyHistoryId(null);
			medicalExaminationRecordEntity.unsetObstetricAndGynecologyHistory();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getOdontogramExamination());
			medicalExaminationRecordEntity.setOdontogramExaminationId(null);
			medicalExaminationRecordEntity.unsetOdontogramExamination();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getOperatingTheaterMedicalExaminationRecord());
			medicalExaminationRecordEntity.setOperatingTheaterMedicalExaminationRecordId(null);
			medicalExaminationRecordEntity.unsetOperatingTheaterMedicalExaminationRecord();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getOphthalmologyExamination());
			medicalExaminationRecordEntity.setOphthalmologyExaminationId(null);
			medicalExaminationRecordEntity.unsetOphthalmologyExamination();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getDoctor());
			medicalExaminationRecordEntity.setDoctorId(null);
			medicalExaminationRecordEntity.unsetDoctor();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getMedicalTranscriber());
			medicalExaminationRecordEntity.setMedicalTranscriberId(null);
			medicalExaminationRecordEntity.unsetMedicalTranscriber();

			Assertions.assertNotNull(medicalExaminationRecordEntity.getNurse());
			medicalExaminationRecordEntity.setNurseId(null);
			medicalExaminationRecordEntity.unsetNurse();

			Assertions.assertTrue(medicalExaminationRecordEntity.getAmendmentDetails().size() > 0);
			medicalExaminationRecordEntity.setAmendmentDetailsIds(new HashSet<UUID>());
			medicalExaminationRecordEntity.unsetAmendmentDetails();

			Assertions.assertTrue(medicalExaminationRecordEntity.getCoTreatingDoctors().size() > 0);
			medicalExaminationRecordEntity.setCoTreatingDoctorsIds(new HashSet<UUID>());
			medicalExaminationRecordEntity.unsetCoTreatingDoctors();

			Assertions.assertTrue(medicalExaminationRecordEntity.getDailyCareCPPTs().size() > 0);
			medicalExaminationRecordEntity.setDailyCareCPPTsIds(new HashSet<UUID>());
			medicalExaminationRecordEntity.unsetDailyCareCPPTs();

			Assertions.assertTrue(medicalExaminationRecordEntity.getDiagnosisExaminationRecords().size() > 0);
			medicalExaminationRecordEntity.setDiagnosisExaminationRecordsIds(new HashSet<UUID>());
			medicalExaminationRecordEntity.unsetDiagnosisExaminationRecords();

			Assertions.assertTrue(medicalExaminationRecordEntity.getDiagnosisNandas().size() > 0);
			medicalExaminationRecordEntity.setDiagnosisNandasIds(new HashSet<UUID>());
			medicalExaminationRecordEntity.unsetDiagnosisNandas();

			Assertions.assertTrue(medicalExaminationRecordEntity.getRoomTransfers().size() > 0);
			medicalExaminationRecordEntity.setRoomTransfersIds(new HashSet<UUID>());
			medicalExaminationRecordEntity.unsetRoomTransfers();


			updatedMedicalExaminationRecordEntity = medicalExaminationRecordService.updateOldData(medicalExaminationRecordEntity);

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getInpatientMedicalExaminationRecord());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getRegistration());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getBirthHistory());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getBodyChartExamination());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getDeliveryMedicalExaminationRecord());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getEntExamination());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getEmergencyMedicationExaminationRecord());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getFormulirKonselingTesHiv());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getHemodialysisExamination());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getMedicalRecordInitialChecklist());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getMedicalRecordNextVerificationChecklist());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getNurseVitalSignMeasurement());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getObstetricAndGynecologyHistory());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getOdontogramExamination());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getOperatingTheaterMedicalExaminationRecord());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getOphthalmologyExamination());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getDoctor());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getMedicalTranscriber());

			Assertions.assertNull(updatedMedicalExaminationRecordEntity.getNurse());

			Assertions.assertEquals(0, updatedMedicalExaminationRecordEntity.getAmendmentDetails().size());

			Assertions.assertEquals(0, updatedMedicalExaminationRecordEntity.getCoTreatingDoctors().size());

			Assertions.assertEquals(0, updatedMedicalExaminationRecordEntity.getDailyCareCPPTs().size());

			Assertions.assertEquals(0, updatedMedicalExaminationRecordEntity.getDiagnosisExaminationRecords().size());

			Assertions.assertEquals(0, updatedMedicalExaminationRecordEntity.getDiagnosisNandas().size());

			Assertions.assertEquals(0, updatedMedicalExaminationRecordEntity.getRoomTransfers().size());

		});
	}

	@Test
	public void updateOldDataWithMedicalExaminationRecordEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordEntity medicalExaminationRecordEntity;
			MedicalExaminationRecordEntity updatedMedicalExaminationRecordEntity;

			InpatientMedicalExaminationRecordEntity inpatientMedicalExaminationRecordEntity;

			RegistrationEntity registrationEntity;

			BirthHistoryEntity birthHistoryEntity;

			BodyChartExaminationEntity bodyChartExaminationEntity;

			DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecordEntity;

			EntExaminationEntity entExaminationEntity;

			EmergencyMedicalExaminationRecordEntity emergencyMedicationExaminationRecordEntity;

			FormulirKonselingTesHivEntity formulirKonselingTesHivEntity;

			HemodialysisExaminationEntity hemodialysisExaminationEntity;

			MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity;

			MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity;

			MedicalRecordNextVerificationChecklistEntity medicalRecordNextVerificationChecklistEntity;

			NurseVitalSignMeasurementEntity nurseVitalSignMeasurementEntity;

			ObstetricAndGynecologyHistoryEntity obstetricAndGynecologyHistoryEntity;

			OdontogramExaminationEntity odontogramExaminationEntity;

			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;

			OphthalmologyExaminationEntity ophthalmologyExaminationEntity;

			StaffEntity doctorEntity;

			StaffEntity medicalTranscriberEntity;

			StaffEntity nurseEntity;

			Set<AmendmentDetailEntity> amendmentDetailsEntities;
			Set<UUID> amendmentDetailsEntityIds;

			Set<CoTreatingDoctorEntity> coTreatingDoctorsEntities;
			Set<UUID> coTreatingDoctorsEntityIds;

			Set<DailyCareCPPTEntity> dailyCareCPPTsEntities;
			Set<UUID> dailyCareCPPTsEntityIds;

			Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecordsEntities;
			Set<UUID> diagnosisExaminationRecordsEntityIds;

			Set<DiagnosisNandaEntity> diagnosisNandasEntities;
			Set<UUID> diagnosisNandasEntityIds;

			Set<RoomTransferEntity> roomTransfersEntities;
			Set<UUID> roomTransfersEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalExaminationRecordEntity = medicalExaminationRecordFactory.getObject(true, false);
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
				inpatientMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getInpatientMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Inpatient Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			inpatientMedicalExaminationRecordEntity = inpatientMedicalExaminationRecordRepository.findById(inpatientMedicalExaminationRecordRepository.save(medicalExaminationRecordEntity.getInpatientMedicalExaminationRecord()).getId()).get();
			medicalExaminationRecordEntity.unsetInpatientMedicalExaminationRecord();
			medicalExaminationRecordEntity.setInpatientMedicalExaminationRecordId(inpatientMedicalExaminationRecordEntity.getId());

			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(medicalExaminationRecordEntity.getRegistration()).getId()).get();
			medicalExaminationRecordEntity.unsetRegistration();
			medicalExaminationRecordEntity.setRegistrationId(registrationEntity.getId());

			try {
				birthHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getBirthHistory(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Birth History relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			birthHistoryEntity = birthHistoryRepository.findById(birthHistoryRepository.save(medicalExaminationRecordEntity.getBirthHistory()).getId()).get();
			medicalExaminationRecordEntity.unsetBirthHistory();
			medicalExaminationRecordEntity.setBirthHistoryId(birthHistoryEntity.getId());

			try {
				bodyChartExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getBodyChartExamination(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Body Chart Examination relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			bodyChartExaminationEntity = bodyChartExaminationRepository.findById(bodyChartExaminationRepository.save(medicalExaminationRecordEntity.getBodyChartExamination()).getId()).get();
			medicalExaminationRecordEntity.unsetBodyChartExamination();
			medicalExaminationRecordEntity.setBodyChartExaminationId(bodyChartExaminationEntity.getId());

			try {
				deliveryMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getDeliveryMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Delivery Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			deliveryMedicalExaminationRecordEntity = deliveryMedicalExaminationRecordRepository.findById(deliveryMedicalExaminationRecordRepository.save(medicalExaminationRecordEntity.getDeliveryMedicalExaminationRecord()).getId()).get();
			medicalExaminationRecordEntity.unsetDeliveryMedicalExaminationRecord();
			medicalExaminationRecordEntity.setDeliveryMedicalExaminationRecordId(deliveryMedicalExaminationRecordEntity.getId());

			try {
				entExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getEntExamination(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the ENT Examination relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			entExaminationEntity = entExaminationRepository.findById(entExaminationRepository.save(medicalExaminationRecordEntity.getEntExamination()).getId()).get();
			medicalExaminationRecordEntity.unsetEntExamination();
			medicalExaminationRecordEntity.setEntExaminationId(entExaminationEntity.getId());

			try {
				emergencyMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getEmergencyMedicationExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Emergency Medication Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			emergencyMedicationExaminationRecordEntity = emergencyMedicalExaminationRecordRepository.findById(emergencyMedicalExaminationRecordRepository.save(medicalExaminationRecordEntity.getEmergencyMedicationExaminationRecord()).getId()).get();
			medicalExaminationRecordEntity.unsetEmergencyMedicationExaminationRecord();
			medicalExaminationRecordEntity.setEmergencyMedicationExaminationRecordId(emergencyMedicationExaminationRecordEntity.getId());

			try {
				formulirKonselingTesHivDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getFormulirKonselingTesHiv(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Formulir Konseling Tes Hiv relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			formulirKonselingTesHivEntity = formulirKonselingTesHivRepository.findById(formulirKonselingTesHivRepository.save(medicalExaminationRecordEntity.getFormulirKonselingTesHiv()).getId()).get();
			medicalExaminationRecordEntity.unsetFormulirKonselingTesHiv();
			medicalExaminationRecordEntity.setFormulirKonselingTesHivId(formulirKonselingTesHivEntity.getId());

			try {
				hemodialysisExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getHemodialysisExamination(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Hemodialysis Examination relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			hemodialysisExaminationEntity = hemodialysisExaminationRepository.findById(hemodialysisExaminationRepository.save(medicalExaminationRecordEntity.getHemodialysisExamination()).getId()).get();
			medicalExaminationRecordEntity.unsetHemodialysisExamination();
			medicalExaminationRecordEntity.setHemodialysisExaminationId(hemodialysisExaminationEntity.getId());

			try {
				medicalExaminationRecordDischargeSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record Discharge Summary relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryRepository.findById(medicalExaminationRecordDischargeSummaryRepository.save(medicalExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary()).getId()).get();
			medicalExaminationRecordEntity.unsetMedicalExaminationRecordDischargeSummary();
			medicalExaminationRecordEntity.setMedicalExaminationRecordDischargeSummaryId(medicalExaminationRecordDischargeSummaryEntity.getId());

			try {
				medicalRecordInitialChecklistDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getMedicalRecordInitialChecklist(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Record Initial Checklist relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistRepository.findById(medicalRecordInitialChecklistRepository.save(medicalExaminationRecordEntity.getMedicalRecordInitialChecklist()).getId()).get();
			medicalExaminationRecordEntity.unsetMedicalRecordInitialChecklist();
			medicalExaminationRecordEntity.setMedicalRecordInitialChecklistId(medicalRecordInitialChecklistEntity.getId());

			try {
				medicalRecordNextVerificationChecklistDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getMedicalRecordNextVerificationChecklist(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Record Next Verification Checklist relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalRecordNextVerificationChecklistEntity = medicalRecordNextVerificationChecklistRepository.findById(medicalRecordNextVerificationChecklistRepository.save(medicalExaminationRecordEntity.getMedicalRecordNextVerificationChecklist()).getId()).get();
			medicalExaminationRecordEntity.unsetMedicalRecordNextVerificationChecklist();
			medicalExaminationRecordEntity.setMedicalRecordNextVerificationChecklistId(medicalRecordNextVerificationChecklistEntity.getId());

			try {
				nurseVitalSignMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getNurseVitalSignMeasurement(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Nurse Vital Sign Measurement relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			nurseVitalSignMeasurementEntity = nurseVitalSignMeasurementRepository.findById(nurseVitalSignMeasurementRepository.save(medicalExaminationRecordEntity.getNurseVitalSignMeasurement()).getId()).get();
			medicalExaminationRecordEntity.unsetNurseVitalSignMeasurement();
			medicalExaminationRecordEntity.setNurseVitalSignMeasurementId(nurseVitalSignMeasurementEntity.getId());

			try {
				obstetricAndGynecologyHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getObstetricAndGynecologyHistory(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Obstetric And Gynecology History relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			obstetricAndGynecologyHistoryEntity = obstetricAndGynecologyHistoryRepository.findById(obstetricAndGynecologyHistoryRepository.save(medicalExaminationRecordEntity.getObstetricAndGynecologyHistory()).getId()).get();
			medicalExaminationRecordEntity.unsetObstetricAndGynecologyHistory();
			medicalExaminationRecordEntity.setObstetricAndGynecologyHistoryId(obstetricAndGynecologyHistoryEntity.getId());

			try {
				odontogramExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getOdontogramExamination(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Odontogram Examination relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			odontogramExaminationEntity = odontogramExaminationRepository.findById(odontogramExaminationRepository.save(medicalExaminationRecordEntity.getOdontogramExamination()).getId()).get();
			medicalExaminationRecordEntity.unsetOdontogramExamination();
			medicalExaminationRecordEntity.setOdontogramExaminationId(odontogramExaminationEntity.getId());

			try {
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getOperatingTheaterMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Operating Theater Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordRepository.findById(operatingTheaterMedicalExaminationRecordRepository.save(medicalExaminationRecordEntity.getOperatingTheaterMedicalExaminationRecord()).getId()).get();
			medicalExaminationRecordEntity.unsetOperatingTheaterMedicalExaminationRecord();
			medicalExaminationRecordEntity.setOperatingTheaterMedicalExaminationRecordId(operatingTheaterMedicalExaminationRecordEntity.getId());

			try {
				ophthalmologyExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getOphthalmologyExamination(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Ophthalmology Examination relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			ophthalmologyExaminationEntity = ophthalmologyExaminationRepository.findById(ophthalmologyExaminationRepository.save(medicalExaminationRecordEntity.getOphthalmologyExamination()).getId()).get();
			medicalExaminationRecordEntity.unsetOphthalmologyExamination();
			medicalExaminationRecordEntity.setOphthalmologyExaminationId(ophthalmologyExaminationEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getDoctor(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Doctor relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			doctorEntity = staffRepository.findById(staffRepository.save(medicalExaminationRecordEntity.getDoctor()).getId()).get();
			medicalExaminationRecordEntity.unsetDoctor();
			medicalExaminationRecordEntity.setDoctorId(doctorEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getMedicalTranscriber(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Transcriber relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalTranscriberEntity = staffRepository.findById(staffRepository.save(medicalExaminationRecordEntity.getMedicalTranscriber()).getId()).get();
			medicalExaminationRecordEntity.unsetMedicalTranscriber();
			medicalExaminationRecordEntity.setMedicalTranscriberId(medicalTranscriberEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity.getNurse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Nurse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			nurseEntity = staffRepository.findById(staffRepository.save(medicalExaminationRecordEntity.getNurse()).getId()).get();
			medicalExaminationRecordEntity.unsetNurse();
			medicalExaminationRecordEntity.setNurseId(nurseEntity.getId());

			amendmentDetailsEntities = new HashSet<>();
			amendmentDetailsEntityIds = new HashSet<>();
			for (AmendmentDetailEntity entity : medicalExaminationRecordEntity.getAmendmentDetails()) {
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
			medicalExaminationRecordEntity.unsetAmendmentDetails();
			medicalExaminationRecordEntity.setAmendmentDetailsIds(amendmentDetailsEntityIds);

			coTreatingDoctorsEntities = new HashSet<>();
			coTreatingDoctorsEntityIds = new HashSet<>();
			for (CoTreatingDoctorEntity entity : medicalExaminationRecordEntity.getCoTreatingDoctors()) {
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
			medicalExaminationRecordEntity.unsetCoTreatingDoctors();
			medicalExaminationRecordEntity.setCoTreatingDoctorsIds(coTreatingDoctorsEntityIds);

			dailyCareCPPTsEntities = new HashSet<>();
			dailyCareCPPTsEntityIds = new HashSet<>();
			for (DailyCareCPPTEntity entity : medicalExaminationRecordEntity.getDailyCareCPPTs()) {
				try {
					dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Daily Care CPPTs relation for this test: " + e.getCause());
					return;
				}
				UUID id = dailyCareCPPTRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				dailyCareCPPTsEntities.add(dailyCareCPPTRepository.findById(id).get());
				dailyCareCPPTsEntityIds.add(id);
			}
			medicalExaminationRecordEntity.unsetDailyCareCPPTs();
			medicalExaminationRecordEntity.setDailyCareCPPTsIds(dailyCareCPPTsEntityIds);

			diagnosisExaminationRecordsEntities = new HashSet<>();
			diagnosisExaminationRecordsEntityIds = new HashSet<>();
			for (DiagnosisExaminationRecordEntity entity : medicalExaminationRecordEntity.getDiagnosisExaminationRecords()) {
				try {
					diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Diagnosis Examination Records relation for this test: " + e.getCause());
					return;
				}
				UUID id = diagnosisExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				diagnosisExaminationRecordsEntities.add(diagnosisExaminationRecordRepository.findById(id).get());
				diagnosisExaminationRecordsEntityIds.add(id);
			}
			medicalExaminationRecordEntity.unsetDiagnosisExaminationRecords();
			medicalExaminationRecordEntity.setDiagnosisExaminationRecordsIds(diagnosisExaminationRecordsEntityIds);

			diagnosisNandasEntities = new HashSet<>();
			diagnosisNandasEntityIds = new HashSet<>();
			for (DiagnosisNandaEntity entity : medicalExaminationRecordEntity.getDiagnosisNandas()) {
				try {
					diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Diagnosis Nandas relation for this test: " + e.getCause());
					return;
				}
				UUID id = diagnosisNandaRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				diagnosisNandasEntities.add(diagnosisNandaRepository.findById(id).get());
				diagnosisNandasEntityIds.add(id);
			}
			medicalExaminationRecordEntity.unsetDiagnosisNandas();
			medicalExaminationRecordEntity.setDiagnosisNandasIds(diagnosisNandasEntityIds);

			roomTransfersEntities = new HashSet<>();
			roomTransfersEntityIds = new HashSet<>();
			for (RoomTransferEntity entity : medicalExaminationRecordEntity.getRoomTransfers()) {
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
			medicalExaminationRecordEntity.unsetRoomTransfers();
			medicalExaminationRecordEntity.setRoomTransfersIds(roomTransfersEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMedicalExaminationRecordEntity = medicalExaminationRecordService.updateOldData(medicalExaminationRecordEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			inpatientMedicalExaminationRecordEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getInpatientMedicalExaminationRecord().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(inpatientMedicalExaminationRecordEntity, updatedMedicalExaminationRecordEntity.getInpatientMedicalExaminationRecord());

			registrationEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getRegistration().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(registrationEntity, updatedMedicalExaminationRecordEntity.getRegistration());

			birthHistoryEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getBirthHistory().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(birthHistoryEntity, updatedMedicalExaminationRecordEntity.getBirthHistory());

			bodyChartExaminationEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getBodyChartExamination().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(bodyChartExaminationEntity, updatedMedicalExaminationRecordEntity.getBodyChartExamination());

			deliveryMedicalExaminationRecordEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getDeliveryMedicalExaminationRecord().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(deliveryMedicalExaminationRecordEntity, updatedMedicalExaminationRecordEntity.getDeliveryMedicalExaminationRecord());

			entExaminationEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getEntExamination().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(entExaminationEntity, updatedMedicalExaminationRecordEntity.getEntExamination());

			emergencyMedicationExaminationRecordEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getEmergencyMedicationExaminationRecord().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(emergencyMedicationExaminationRecordEntity, updatedMedicalExaminationRecordEntity.getEmergencyMedicationExaminationRecord());

			formulirKonselingTesHivEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getFormulirKonselingTesHiv().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(formulirKonselingTesHivEntity, updatedMedicalExaminationRecordEntity.getFormulirKonselingTesHiv());

			hemodialysisExaminationEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getHemodialysisExamination().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(hemodialysisExaminationEntity, updatedMedicalExaminationRecordEntity.getHemodialysisExamination());

			medicalExaminationRecordDischargeSummaryEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(medicalExaminationRecordDischargeSummaryEntity, updatedMedicalExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary());

			medicalRecordInitialChecklistEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getMedicalRecordInitialChecklist().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(medicalRecordInitialChecklistEntity, updatedMedicalExaminationRecordEntity.getMedicalRecordInitialChecklist());

			medicalRecordNextVerificationChecklistEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getMedicalRecordNextVerificationChecklist().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(medicalRecordNextVerificationChecklistEntity, updatedMedicalExaminationRecordEntity.getMedicalRecordNextVerificationChecklist());

			nurseVitalSignMeasurementEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getNurseVitalSignMeasurement().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(nurseVitalSignMeasurementEntity, updatedMedicalExaminationRecordEntity.getNurseVitalSignMeasurement());

			obstetricAndGynecologyHistoryEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getObstetricAndGynecologyHistory().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(obstetricAndGynecologyHistoryEntity, updatedMedicalExaminationRecordEntity.getObstetricAndGynecologyHistory());

			odontogramExaminationEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getOdontogramExamination().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(odontogramExaminationEntity, updatedMedicalExaminationRecordEntity.getOdontogramExamination());

			operatingTheaterMedicalExaminationRecordEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getOperatingTheaterMedicalExaminationRecord().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(operatingTheaterMedicalExaminationRecordEntity, updatedMedicalExaminationRecordEntity.getOperatingTheaterMedicalExaminationRecord());

			ophthalmologyExaminationEntity.unsetMedicalExaminationRecord(false);
			updatedMedicalExaminationRecordEntity.getOphthalmologyExamination().unsetMedicalExaminationRecord(false);
			Assertions.assertEquals(ophthalmologyExaminationEntity, updatedMedicalExaminationRecordEntity.getOphthalmologyExamination());

			doctorEntity.unsetDoctorOnExamination(false);
			updatedMedicalExaminationRecordEntity.getDoctor().unsetDoctorOnExamination(false);
			Assertions.assertEquals(doctorEntity, updatedMedicalExaminationRecordEntity.getDoctor());

			medicalTranscriberEntity.unsetMedicalRecordTranscriber(false);
			updatedMedicalExaminationRecordEntity.getMedicalTranscriber().unsetMedicalRecordTranscriber(false);
			Assertions.assertEquals(medicalTranscriberEntity, updatedMedicalExaminationRecordEntity.getMedicalTranscriber());

			nurseEntity.unsetNurse(false);
			updatedMedicalExaminationRecordEntity.getNurse().unsetNurse(false);
			Assertions.assertEquals(nurseEntity, updatedMedicalExaminationRecordEntity.getNurse());

			Assertions.assertEquals(amendmentDetailsEntities.size(), updatedMedicalExaminationRecordEntity.getAmendmentDetails().size());

			Assertions.assertEquals(coTreatingDoctorsEntities.size(), updatedMedicalExaminationRecordEntity.getCoTreatingDoctors().size());

			Assertions.assertEquals(dailyCareCPPTsEntities.size(), updatedMedicalExaminationRecordEntity.getDailyCareCPPTs().size());

			Assertions.assertEquals(diagnosisExaminationRecordsEntities.size(), updatedMedicalExaminationRecordEntity.getDiagnosisExaminationRecords().size());

			Assertions.assertEquals(diagnosisNandasEntities.size(), updatedMedicalExaminationRecordEntity.getDiagnosisNandas().size());

			Assertions.assertEquals(roomTransfersEntities.size(), updatedMedicalExaminationRecordEntity.getRoomTransfers().size());

		});
	}

	@Test
	public void whenCreateMedicalExaminationRecordEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordEntity medicalExaminationRecordEntity;
			Optional<MedicalExaminationRecordEntity> fetchedMedicalExaminationRecordEntity;

			try {
				medicalExaminationRecordEntity = medicalExaminationRecordFactory.getObject(false, false);
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalExaminationRecordEntity = medicalExaminationRecordService.create(medicalExaminationRecordEntity);

			fetchedMedicalExaminationRecordEntity = medicalExaminationRecordService.findById(medicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedMedicalExaminationRecordEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMedicalExaminationRecordEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(medicalExaminationRecordEntity, fetchedMedicalExaminationRecordEntity.get());
		});
	}

	@Test
	public void whenUpdateMedicalExaminationRecordEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordEntity medicalExaminationRecordEntity;
			MedicalExaminationRecordEntity updatedMedicalExaminationRecordEntity;
			Optional<MedicalExaminationRecordEntity> fetchedMedicalExaminationRecordEntity;

			try {
				medicalExaminationRecordEntity = medicalExaminationRecordFactory.getObject(false, false);
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, false);
				updatedMedicalExaminationRecordEntity = medicalExaminationRecordFactory.getObject(false, false);
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMedicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalExaminationRecordEntity = medicalExaminationRecordService.create(medicalExaminationRecordEntity);

			updatedMedicalExaminationRecordEntity.setId(medicalExaminationRecordEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMedicalExaminationRecordEntity.setCreated(medicalExaminationRecordEntity.getCreated());

			updatedMedicalExaminationRecordEntity = medicalExaminationRecordService.update(updatedMedicalExaminationRecordEntity);

			fetchedMedicalExaminationRecordEntity = medicalExaminationRecordService.findById(medicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedMedicalExaminationRecordEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMedicalExaminationRecordEntity_ThenEntityIsCreated
			fetchedMedicalExaminationRecordEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMedicalExaminationRecordEntity, fetchedMedicalExaminationRecordEntity.get());
		});
	}

	@Test
	public void whenDeleteMedicalExaminationRecordEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordEntity medicalExaminationRecordEntity;
			Optional<MedicalExaminationRecordEntity> fetchedMedicalExaminationRecordEntity;

			try {
				medicalExaminationRecordEntity = medicalExaminationRecordFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalExaminationRecordEntity = medicalExaminationRecordService.create(medicalExaminationRecordEntity);

			medicalExaminationRecordService.deleteById(medicalExaminationRecordEntity.getId());
			fetchedMedicalExaminationRecordEntity = medicalExaminationRecordService.findById(medicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedMedicalExaminationRecordEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
