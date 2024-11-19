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
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.utils.OperatingTheaterMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.OperatingTheaterMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.DiagnosisNandaEntity;
import kmsweb.repositories.DiagnosisNandaRepository;
import kmsweb.utils.DiagnosisNandaFactory;
import kmsweb.utils.DatabasePopulators.DiagnosisNandaDatabasePopulator;
import kmsweb.entities.IntraoperativeRecordsEntity;
import kmsweb.repositories.IntraoperativeRecordsRepository;
import kmsweb.utils.IntraoperativeRecordsFactory;
import kmsweb.utils.DatabasePopulators.IntraoperativeRecordsDatabasePopulator;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.utils.MedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.PostOperativeDetailsEntity;
import kmsweb.repositories.PostOperativeDetailsRepository;
import kmsweb.utils.PostOperativeDetailsFactory;
import kmsweb.utils.DatabasePopulators.PostOperativeDetailsDatabasePopulator;
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.repositories.PreoperativeRecordsRepository;
import kmsweb.utils.PreoperativeRecordsFactory;
import kmsweb.utils.DatabasePopulators.PreoperativeRecordsDatabasePopulator;
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
public class OperatingTheaterMedicalExaminationRecordServiceIntegrationTest {

	@Autowired
	private OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private OperatingTheaterMedicalExaminationRecordService operatingTheaterMedicalExaminationRecordService;

	private final OperatingTheaterMedicalExaminationRecordFactory operatingTheaterMedicalExaminationRecordFactory = new OperatingTheaterMedicalExaminationRecordFactory();

	@Autowired
	private OperatingTheaterMedicalExaminationRecordDatabasePopulator operatingTheaterMedicalExaminationRecordDatabasePopulator;

	@Autowired
	private DiagnosisNandaRepository diagnosisNandaRepository;

	@Autowired
	private DiagnosisNandaDatabasePopulator diagnosisNandaDatabasePopulator;

	private final DiagnosisNandaFactory diagnosisNandaFactory = new DiagnosisNandaFactory();

	@Autowired
	private IntraoperativeRecordsRepository intraoperativeRecordsRepository;

	@Autowired
	private IntraoperativeRecordsDatabasePopulator intraoperativeRecordsDatabasePopulator;

	private final IntraoperativeRecordsFactory intraoperativeRecordsFactory = new IntraoperativeRecordsFactory();

	@Autowired
	private MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	@Autowired
	private MedicalExaminationRecordDatabasePopulator medicalExaminationRecordDatabasePopulator;

	private final MedicalExaminationRecordFactory medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();

	@Autowired
	private PostOperativeDetailsRepository postOperativeDetailsRepository;

	@Autowired
	private PostOperativeDetailsDatabasePopulator postOperativeDetailsDatabasePopulator;

	private final PostOperativeDetailsFactory postOperativeDetailsFactory = new PostOperativeDetailsFactory();

	@Autowired
	private PreoperativeRecordsRepository preoperativeRecordsRepository;

	@Autowired
	private PreoperativeRecordsDatabasePopulator preoperativeRecordsDatabasePopulator;

	private final PreoperativeRecordsFactory preoperativeRecordsFactory = new PreoperativeRecordsFactory();

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
		operatingTheaterMedicalExaminationRecordService = new OperatingTheaterMedicalExaminationRecordService(
			diagnosisNandaRepository,
			intraoperativeRecordsRepository,
			medicalExaminationRecordRepository,
			postOperativeDetailsRepository,
			preoperativeRecordsRepository,
			staffRepository,
			validator,
			auditRepository,
			operatingTheaterMedicalExaminationRecordRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewOperatingTheaterMedicalExaminationRecordEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordFactory.getObject(false, false);

		OperatingTheaterMedicalExaminationRecordEntity updatedEntity = operatingTheaterMedicalExaminationRecordService.updateOldData(operatingTheaterMedicalExaminationRecordEntity);
		Assertions.assertEquals(operatingTheaterMedicalExaminationRecordEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewOperatingTheaterMedicalExaminationRecordEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordFactory.getObject(false, false);

		operatingTheaterMedicalExaminationRecordEntity.setHasConfirmedIdentity(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getHasConfirmedIdentity());

		operatingTheaterMedicalExaminationRecordEntity.setAnesthesiaSafetyCheckCompleted(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getAnesthesiaSafetyCheckCompleted());

		operatingTheaterMedicalExaminationRecordEntity.setPulseOxymeterFunctioning(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getPulseOxymeterFunctioning());

		operatingTheaterMedicalExaminationRecordEntity.setTeamMemberIntroduced(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getTeamMemberIntroduced());

		operatingTheaterMedicalExaminationRecordEntity.setProfessionalConfirmedPatient(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getProfessionalConfirmedPatient());

		operatingTheaterMedicalExaminationRecordEntity.setWhareAreCriticalSteps(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getWhareAreCriticalSteps());

		operatingTheaterMedicalExaminationRecordEntity.setHowLongCaseTake(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getHowLongCaseTake());

		operatingTheaterMedicalExaminationRecordEntity.setWhatIsAnticipatedBloodLoss(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getWhatIsAnticipatedBloodLoss());

		operatingTheaterMedicalExaminationRecordEntity.setAnyPatientSpecificConcerns(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getAnyPatientSpecificConcerns());

		operatingTheaterMedicalExaminationRecordEntity.setSterlityBeenConfirmed(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getSterlityBeenConfirmed());

		operatingTheaterMedicalExaminationRecordEntity.setEquipmentIssuesAnyConcern(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getEquipmentIssuesAnyConcern());

		operatingTheaterMedicalExaminationRecordEntity.setNameOfProcedure(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getNameOfProcedure());

		operatingTheaterMedicalExaminationRecordEntity.setInstrumentsNeedCountCorrect(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getInstrumentsNeedCountCorrect());

		operatingTheaterMedicalExaminationRecordEntity.setSpecimenIsLabeled(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getSpecimenIsLabeled());

		operatingTheaterMedicalExaminationRecordEntity.setEquipmentProblemsAddressed(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getEquipmentProblemsAddressed());

		operatingTheaterMedicalExaminationRecordEntity.setKeyConcernsForRecovery(null);
		Assertions.assertNull(operatingTheaterMedicalExaminationRecordEntity.getKeyConcernsForRecovery());


		OperatingTheaterMedicalExaminationRecordEntity updatedEntity = operatingTheaterMedicalExaminationRecordService.updateOldData(operatingTheaterMedicalExaminationRecordEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getHasConfirmedIdentity());
		Assertions.assertFalse(updatedEntity.getHasConfirmedIdentity());

		Assertions.assertNotNull(updatedEntity.getAnesthesiaSafetyCheckCompleted());
		Assertions.assertFalse(updatedEntity.getAnesthesiaSafetyCheckCompleted());

		Assertions.assertNotNull(updatedEntity.getPulseOxymeterFunctioning());
		Assertions.assertFalse(updatedEntity.getPulseOxymeterFunctioning());

		Assertions.assertNotNull(updatedEntity.getTeamMemberIntroduced());
		Assertions.assertFalse(updatedEntity.getTeamMemberIntroduced());

		Assertions.assertNotNull(updatedEntity.getProfessionalConfirmedPatient());
		Assertions.assertFalse(updatedEntity.getProfessionalConfirmedPatient());

		Assertions.assertNotNull(updatedEntity.getWhareAreCriticalSteps());
		Assertions.assertFalse(updatedEntity.getWhareAreCriticalSteps());

		Assertions.assertNotNull(updatedEntity.getHowLongCaseTake());
		Assertions.assertFalse(updatedEntity.getHowLongCaseTake());

		Assertions.assertNotNull(updatedEntity.getWhatIsAnticipatedBloodLoss());
		Assertions.assertFalse(updatedEntity.getWhatIsAnticipatedBloodLoss());

		Assertions.assertNotNull(updatedEntity.getAnyPatientSpecificConcerns());
		Assertions.assertFalse(updatedEntity.getAnyPatientSpecificConcerns());

		Assertions.assertNotNull(updatedEntity.getSterlityBeenConfirmed());
		Assertions.assertFalse(updatedEntity.getSterlityBeenConfirmed());

		Assertions.assertNotNull(updatedEntity.getEquipmentIssuesAnyConcern());
		Assertions.assertFalse(updatedEntity.getEquipmentIssuesAnyConcern());

		Assertions.assertNotNull(updatedEntity.getNameOfProcedure());
		Assertions.assertFalse(updatedEntity.getNameOfProcedure());

		Assertions.assertNotNull(updatedEntity.getInstrumentsNeedCountCorrect());
		Assertions.assertFalse(updatedEntity.getInstrumentsNeedCountCorrect());

		Assertions.assertNotNull(updatedEntity.getSpecimenIsLabeled());
		Assertions.assertFalse(updatedEntity.getSpecimenIsLabeled());

		Assertions.assertNotNull(updatedEntity.getEquipmentProblemsAddressed());
		Assertions.assertFalse(updatedEntity.getEquipmentProblemsAddressed());

		Assertions.assertNotNull(updatedEntity.getKeyConcernsForRecovery());
		Assertions.assertFalse(updatedEntity.getKeyConcernsForRecovery());

	}

	@Test
	public void updateOldDataWithExistingOperatingTheaterMedicalExaminationRecordEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;
			OperatingTheaterMedicalExaminationRecordEntity entityWithUpdatedValues;

			try {
				operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordFactory.getObject(false, false);
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = operatingTheaterMedicalExaminationRecordFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordService.create(operatingTheaterMedicalExaminationRecordEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(operatingTheaterMedicalExaminationRecordEntity.getId());

			OperatingTheaterMedicalExaminationRecordEntity updatedEntity = operatingTheaterMedicalExaminationRecordService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithOperatingTheaterMedicalExaminationRecordEntityWithNonExistentId_ShouldThrowException() throws Exception {
		OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordFactory.getObject(false, false);
		operatingTheaterMedicalExaminationRecordEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			operatingTheaterMedicalExaminationRecordService.updateOldData(operatingTheaterMedicalExaminationRecordEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingOperatingTheaterMedicalExaminationRecordEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;
			OperatingTheaterMedicalExaminationRecordEntity updatedOperatingTheaterMedicalExaminationRecordEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			IntraoperativeRecordsEntity intraoperativeRecordsEntity;

			PostOperativeDetailsEntity postOperativeDetailsEntity;

			PreoperativeRecordsEntity preoperativeRecordsEntity;

			DiagnosisNandaEntity nursingAnesthesiaDetailEntity;

			StaffEntity nursingDetailSurgicalNursingsEntity;

			StaffEntity nursingDetailsAnesthesiaNursingsEntity;

			DiagnosisNandaEntity nursingSurgicalDetailEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordFactory.getObject(true, false);
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
			medicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordEntity.getMedicalExaminationRecord();
			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.save(medicalExaminationRecordEntity);
			operatingTheaterMedicalExaminationRecordEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			intraoperativeRecordsEntity = operatingTheaterMedicalExaminationRecordEntity.getIntraoperativeRecords();
			try {
				intraoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(intraoperativeRecordsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			intraoperativeRecordsEntity = intraoperativeRecordsRepository.save(intraoperativeRecordsEntity);
			operatingTheaterMedicalExaminationRecordEntity.setIntraoperativeRecordsId(intraoperativeRecordsEntity.getId());

			postOperativeDetailsEntity = operatingTheaterMedicalExaminationRecordEntity.getPostOperativeDetails();
			try {
				postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeDetailsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			postOperativeDetailsEntity = postOperativeDetailsRepository.save(postOperativeDetailsEntity);
			operatingTheaterMedicalExaminationRecordEntity.setPostOperativeDetailsId(postOperativeDetailsEntity.getId());

			preoperativeRecordsEntity = operatingTheaterMedicalExaminationRecordEntity.getPreoperativeRecords();
			try {
				preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(preoperativeRecordsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			preoperativeRecordsEntity = preoperativeRecordsRepository.save(preoperativeRecordsEntity);
			operatingTheaterMedicalExaminationRecordEntity.setPreoperativeRecordsId(preoperativeRecordsEntity.getId());

			nursingAnesthesiaDetailEntity = operatingTheaterMedicalExaminationRecordEntity.getNursingAnesthesiaDetail();
			try {
				diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(nursingAnesthesiaDetailEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			nursingAnesthesiaDetailEntity = diagnosisNandaRepository.save(nursingAnesthesiaDetailEntity);
			operatingTheaterMedicalExaminationRecordEntity.setNursingAnesthesiaDetailId(nursingAnesthesiaDetailEntity.getId());

			nursingDetailSurgicalNursingsEntity = operatingTheaterMedicalExaminationRecordEntity.getNursingDetailSurgicalNursings();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(nursingDetailSurgicalNursingsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			nursingDetailSurgicalNursingsEntity = staffRepository.save(nursingDetailSurgicalNursingsEntity);
			operatingTheaterMedicalExaminationRecordEntity.setNursingDetailSurgicalNursingsId(nursingDetailSurgicalNursingsEntity.getId());

			nursingDetailsAnesthesiaNursingsEntity = operatingTheaterMedicalExaminationRecordEntity.getNursingDetailsAnesthesiaNursings();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(nursingDetailsAnesthesiaNursingsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			nursingDetailsAnesthesiaNursingsEntity = staffRepository.save(nursingDetailsAnesthesiaNursingsEntity);
			operatingTheaterMedicalExaminationRecordEntity.setNursingDetailsAnesthesiaNursingsId(nursingDetailsAnesthesiaNursingsEntity.getId());

			nursingSurgicalDetailEntity = operatingTheaterMedicalExaminationRecordEntity.getNursingSurgicalDetail();
			try {
				diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(nursingSurgicalDetailEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			nursingSurgicalDetailEntity = diagnosisNandaRepository.save(nursingSurgicalDetailEntity);
			operatingTheaterMedicalExaminationRecordEntity.setNursingSurgicalDetailId(nursingSurgicalDetailEntity.getId());


			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordService.create(operatingTheaterMedicalExaminationRecordEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(operatingTheaterMedicalExaminationRecordEntity.getMedicalExaminationRecord());
			operatingTheaterMedicalExaminationRecordEntity.setMedicalExaminationRecordId(null);
			operatingTheaterMedicalExaminationRecordEntity.unsetMedicalExaminationRecord();

			Assertions.assertNotNull(operatingTheaterMedicalExaminationRecordEntity.getIntraoperativeRecords());
			operatingTheaterMedicalExaminationRecordEntity.setIntraoperativeRecordsId(null);
			operatingTheaterMedicalExaminationRecordEntity.unsetIntraoperativeRecords();

			Assertions.assertNotNull(operatingTheaterMedicalExaminationRecordEntity.getPostOperativeDetails());
			operatingTheaterMedicalExaminationRecordEntity.setPostOperativeDetailsId(null);
			operatingTheaterMedicalExaminationRecordEntity.unsetPostOperativeDetails();

			Assertions.assertNotNull(operatingTheaterMedicalExaminationRecordEntity.getPreoperativeRecords());
			operatingTheaterMedicalExaminationRecordEntity.setPreoperativeRecordsId(null);
			operatingTheaterMedicalExaminationRecordEntity.unsetPreoperativeRecords();

			Assertions.assertNotNull(operatingTheaterMedicalExaminationRecordEntity.getNursingAnesthesiaDetail());
			operatingTheaterMedicalExaminationRecordEntity.setNursingAnesthesiaDetailId(null);
			operatingTheaterMedicalExaminationRecordEntity.unsetNursingAnesthesiaDetail();

			Assertions.assertNotNull(operatingTheaterMedicalExaminationRecordEntity.getNursingDetailSurgicalNursings());
			operatingTheaterMedicalExaminationRecordEntity.setNursingDetailSurgicalNursingsId(null);
			operatingTheaterMedicalExaminationRecordEntity.unsetNursingDetailSurgicalNursings();

			Assertions.assertNotNull(operatingTheaterMedicalExaminationRecordEntity.getNursingDetailsAnesthesiaNursings());
			operatingTheaterMedicalExaminationRecordEntity.setNursingDetailsAnesthesiaNursingsId(null);
			operatingTheaterMedicalExaminationRecordEntity.unsetNursingDetailsAnesthesiaNursings();

			Assertions.assertNotNull(operatingTheaterMedicalExaminationRecordEntity.getNursingSurgicalDetail());
			operatingTheaterMedicalExaminationRecordEntity.setNursingSurgicalDetailId(null);
			operatingTheaterMedicalExaminationRecordEntity.unsetNursingSurgicalDetail();


			updatedOperatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordService.updateOldData(operatingTheaterMedicalExaminationRecordEntity);

			Assertions.assertNull(updatedOperatingTheaterMedicalExaminationRecordEntity.getMedicalExaminationRecord());

			Assertions.assertNull(updatedOperatingTheaterMedicalExaminationRecordEntity.getIntraoperativeRecords());

			Assertions.assertNull(updatedOperatingTheaterMedicalExaminationRecordEntity.getPostOperativeDetails());

			Assertions.assertNull(updatedOperatingTheaterMedicalExaminationRecordEntity.getPreoperativeRecords());

			Assertions.assertNull(updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingAnesthesiaDetail());

			Assertions.assertNull(updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingDetailSurgicalNursings());

			Assertions.assertNull(updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingDetailsAnesthesiaNursings());

			Assertions.assertNull(updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingSurgicalDetail());

		});
	}

	@Test
	public void updateOldDataWithOperatingTheaterMedicalExaminationRecordEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;
			OperatingTheaterMedicalExaminationRecordEntity updatedOperatingTheaterMedicalExaminationRecordEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			IntraoperativeRecordsEntity intraoperativeRecordsEntity;

			PostOperativeDetailsEntity postOperativeDetailsEntity;

			PreoperativeRecordsEntity preoperativeRecordsEntity;

			DiagnosisNandaEntity nursingAnesthesiaDetailEntity;

			StaffEntity nursingDetailSurgicalNursingsEntity;

			StaffEntity nursingDetailsAnesthesiaNursingsEntity;

			DiagnosisNandaEntity nursingSurgicalDetailEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordFactory.getObject(true, false);
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
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity.getMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.findById(medicalExaminationRecordRepository.save(operatingTheaterMedicalExaminationRecordEntity.getMedicalExaminationRecord()).getId()).get();
			operatingTheaterMedicalExaminationRecordEntity.unsetMedicalExaminationRecord();
			operatingTheaterMedicalExaminationRecordEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			try {
				intraoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity.getIntraoperativeRecords(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Intraoperative Records relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			intraoperativeRecordsEntity = intraoperativeRecordsRepository.findById(intraoperativeRecordsRepository.save(operatingTheaterMedicalExaminationRecordEntity.getIntraoperativeRecords()).getId()).get();
			operatingTheaterMedicalExaminationRecordEntity.unsetIntraoperativeRecords();
			operatingTheaterMedicalExaminationRecordEntity.setIntraoperativeRecordsId(intraoperativeRecordsEntity.getId());

			try {
				postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity.getPostOperativeDetails(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Post Operative Details relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			postOperativeDetailsEntity = postOperativeDetailsRepository.findById(postOperativeDetailsRepository.save(operatingTheaterMedicalExaminationRecordEntity.getPostOperativeDetails()).getId()).get();
			operatingTheaterMedicalExaminationRecordEntity.unsetPostOperativeDetails();
			operatingTheaterMedicalExaminationRecordEntity.setPostOperativeDetailsId(postOperativeDetailsEntity.getId());

			try {
				preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity.getPreoperativeRecords(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Preoperative Records relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			preoperativeRecordsEntity = preoperativeRecordsRepository.findById(preoperativeRecordsRepository.save(operatingTheaterMedicalExaminationRecordEntity.getPreoperativeRecords()).getId()).get();
			operatingTheaterMedicalExaminationRecordEntity.unsetPreoperativeRecords();
			operatingTheaterMedicalExaminationRecordEntity.setPreoperativeRecordsId(preoperativeRecordsEntity.getId());

			try {
				diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity.getNursingAnesthesiaDetail(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Nursing Anesthesia Detail relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			nursingAnesthesiaDetailEntity = diagnosisNandaRepository.findById(diagnosisNandaRepository.save(operatingTheaterMedicalExaminationRecordEntity.getNursingAnesthesiaDetail()).getId()).get();
			operatingTheaterMedicalExaminationRecordEntity.unsetNursingAnesthesiaDetail();
			operatingTheaterMedicalExaminationRecordEntity.setNursingAnesthesiaDetailId(nursingAnesthesiaDetailEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity.getNursingDetailSurgicalNursings(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Nursing Detail Surgical Nursings relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			nursingDetailSurgicalNursingsEntity = staffRepository.findById(staffRepository.save(operatingTheaterMedicalExaminationRecordEntity.getNursingDetailSurgicalNursings()).getId()).get();
			operatingTheaterMedicalExaminationRecordEntity.unsetNursingDetailSurgicalNursings();
			operatingTheaterMedicalExaminationRecordEntity.setNursingDetailSurgicalNursingsId(nursingDetailSurgicalNursingsEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity.getNursingDetailsAnesthesiaNursings(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Nursing Details Anesthesia Nursings relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			nursingDetailsAnesthesiaNursingsEntity = staffRepository.findById(staffRepository.save(operatingTheaterMedicalExaminationRecordEntity.getNursingDetailsAnesthesiaNursings()).getId()).get();
			operatingTheaterMedicalExaminationRecordEntity.unsetNursingDetailsAnesthesiaNursings();
			operatingTheaterMedicalExaminationRecordEntity.setNursingDetailsAnesthesiaNursingsId(nursingDetailsAnesthesiaNursingsEntity.getId());

			try {
				diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity.getNursingSurgicalDetail(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Nursing Surgical Detail relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			nursingSurgicalDetailEntity = diagnosisNandaRepository.findById(diagnosisNandaRepository.save(operatingTheaterMedicalExaminationRecordEntity.getNursingSurgicalDetail()).getId()).get();
			operatingTheaterMedicalExaminationRecordEntity.unsetNursingSurgicalDetail();
			operatingTheaterMedicalExaminationRecordEntity.setNursingSurgicalDetailId(nursingSurgicalDetailEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedOperatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordService.updateOldData(operatingTheaterMedicalExaminationRecordEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			medicalExaminationRecordEntity.unsetOperatingTheaterMedicalExaminationRecord(false);
			updatedOperatingTheaterMedicalExaminationRecordEntity.getMedicalExaminationRecord().unsetOperatingTheaterMedicalExaminationRecord(false);
			Assertions.assertEquals(medicalExaminationRecordEntity, updatedOperatingTheaterMedicalExaminationRecordEntity.getMedicalExaminationRecord());

			intraoperativeRecordsEntity.unsetOperatingTheaterMedicalExaminationRecord(false);
			updatedOperatingTheaterMedicalExaminationRecordEntity.getIntraoperativeRecords().unsetOperatingTheaterMedicalExaminationRecord(false);
			Assertions.assertEquals(intraoperativeRecordsEntity, updatedOperatingTheaterMedicalExaminationRecordEntity.getIntraoperativeRecords());

			postOperativeDetailsEntity.unsetOperatingTheaterMedicalExaminationRecord(false);
			updatedOperatingTheaterMedicalExaminationRecordEntity.getPostOperativeDetails().unsetOperatingTheaterMedicalExaminationRecord(false);
			Assertions.assertEquals(postOperativeDetailsEntity, updatedOperatingTheaterMedicalExaminationRecordEntity.getPostOperativeDetails());

			preoperativeRecordsEntity.unsetOperatingTheaterMedicalExaminationRecord(false);
			updatedOperatingTheaterMedicalExaminationRecordEntity.getPreoperativeRecords().unsetOperatingTheaterMedicalExaminationRecord(false);
			Assertions.assertEquals(preoperativeRecordsEntity, updatedOperatingTheaterMedicalExaminationRecordEntity.getPreoperativeRecords());

			nursingAnesthesiaDetailEntity.unsetNursingAnesthesiaDetail(false);
			updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingAnesthesiaDetail().unsetNursingAnesthesiaDetail(false);
			Assertions.assertEquals(nursingAnesthesiaDetailEntity, updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingAnesthesiaDetail());

			nursingDetailSurgicalNursingsEntity.unsetNursingDetailSurgicalNursing(false);
			updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingDetailSurgicalNursings().unsetNursingDetailSurgicalNursing(false);
			Assertions.assertEquals(nursingDetailSurgicalNursingsEntity, updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingDetailSurgicalNursings());

			nursingDetailsAnesthesiaNursingsEntity.unsetNursingDetailsAnesthesiaNursing(false);
			updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingDetailsAnesthesiaNursings().unsetNursingDetailsAnesthesiaNursing(false);
			Assertions.assertEquals(nursingDetailsAnesthesiaNursingsEntity, updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingDetailsAnesthesiaNursings());

			nursingSurgicalDetailEntity.unsetNursingSurgicalDetail(false);
			updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingSurgicalDetail().unsetNursingSurgicalDetail(false);
			Assertions.assertEquals(nursingSurgicalDetailEntity, updatedOperatingTheaterMedicalExaminationRecordEntity.getNursingSurgicalDetail());

		});
	}

	@Test
	public void whenCreateOperatingTheaterMedicalExaminationRecordEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;
			Optional<OperatingTheaterMedicalExaminationRecordEntity> fetchedOperatingTheaterMedicalExaminationRecordEntity;

			try {
				operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordFactory.getObject(false, false);
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordService.create(operatingTheaterMedicalExaminationRecordEntity);

			fetchedOperatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordService.findById(operatingTheaterMedicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedOperatingTheaterMedicalExaminationRecordEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedOperatingTheaterMedicalExaminationRecordEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(operatingTheaterMedicalExaminationRecordEntity, fetchedOperatingTheaterMedicalExaminationRecordEntity.get());
		});
	}

	@Test
	public void whenUpdateOperatingTheaterMedicalExaminationRecordEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;
			OperatingTheaterMedicalExaminationRecordEntity updatedOperatingTheaterMedicalExaminationRecordEntity;
			Optional<OperatingTheaterMedicalExaminationRecordEntity> fetchedOperatingTheaterMedicalExaminationRecordEntity;

			try {
				operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordFactory.getObject(false, false);
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity, true, true, false);
				updatedOperatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordFactory.getObject(false, false);
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(updatedOperatingTheaterMedicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordService.create(operatingTheaterMedicalExaminationRecordEntity);

			updatedOperatingTheaterMedicalExaminationRecordEntity.setId(operatingTheaterMedicalExaminationRecordEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedOperatingTheaterMedicalExaminationRecordEntity.setCreated(operatingTheaterMedicalExaminationRecordEntity.getCreated());

			updatedOperatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordService.update(updatedOperatingTheaterMedicalExaminationRecordEntity);

			fetchedOperatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordService.findById(operatingTheaterMedicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedOperatingTheaterMedicalExaminationRecordEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateOperatingTheaterMedicalExaminationRecordEntity_ThenEntityIsCreated
			fetchedOperatingTheaterMedicalExaminationRecordEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedOperatingTheaterMedicalExaminationRecordEntity, fetchedOperatingTheaterMedicalExaminationRecordEntity.get());
		});
	}

	@Test
	public void whenDeleteOperatingTheaterMedicalExaminationRecordEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;
			Optional<OperatingTheaterMedicalExaminationRecordEntity> fetchedOperatingTheaterMedicalExaminationRecordEntity;

			try {
				operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordService.create(operatingTheaterMedicalExaminationRecordEntity);

			operatingTheaterMedicalExaminationRecordService.deleteById(operatingTheaterMedicalExaminationRecordEntity.getId());
			fetchedOperatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordService.findById(operatingTheaterMedicalExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedOperatingTheaterMedicalExaminationRecordEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
