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
import kmsweb.entities.DailyCareCPPTEntity;
import kmsweb.repositories.DailyCareCPPTRepository;
import kmsweb.utils.DailyCareCPPTFactory;
import kmsweb.utils.DatabasePopulators.DailyCareCPPTDatabasePopulator;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.utils.MedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDatabasePopulator;
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
public class DailyCareCPPTServiceIntegrationTest {

	@Autowired
	private DailyCareCPPTRepository dailyCareCPPTRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private DailyCareCPPTService dailyCareCPPTService;

	private final DailyCareCPPTFactory dailyCareCPPTFactory = new DailyCareCPPTFactory();

	@Autowired
	private DailyCareCPPTDatabasePopulator dailyCareCPPTDatabasePopulator;

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();

	@Autowired
	private MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	@Autowired
	private MedicalExaminationRecordDatabasePopulator medicalExaminationRecordDatabasePopulator;

	private final MedicalExaminationRecordFactory medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();

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
		dailyCareCPPTService = new DailyCareCPPTService(
			diagnosesAndProceduresRepository,
			medicalExaminationRecordRepository,
			staffRepository,
			validator,
			auditRepository,
			dailyCareCPPTRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewDailyCareCPPTEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		DailyCareCPPTEntity dailyCareCPPTEntity = dailyCareCPPTFactory.getObject(false, false);

		DailyCareCPPTEntity updatedEntity = dailyCareCPPTService.updateOldData(dailyCareCPPTEntity);
		Assertions.assertEquals(dailyCareCPPTEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingDailyCareCPPTEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			DailyCareCPPTEntity dailyCareCPPTEntity;
			DailyCareCPPTEntity entityWithUpdatedValues;

			try {
				dailyCareCPPTEntity = dailyCareCPPTFactory.getObject(false, false);
				dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(dailyCareCPPTEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = dailyCareCPPTFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			dailyCareCPPTEntity = dailyCareCPPTService.create(dailyCareCPPTEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(dailyCareCPPTEntity.getId());

			DailyCareCPPTEntity updatedEntity = dailyCareCPPTService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithDailyCareCPPTEntityWithNonExistentId_ShouldThrowException() throws Exception {
		DailyCareCPPTEntity dailyCareCPPTEntity = dailyCareCPPTFactory.getObject(false, false);
		dailyCareCPPTEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			dailyCareCPPTService.updateOldData(dailyCareCPPTEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingDailyCareCPPTEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DailyCareCPPTEntity dailyCareCPPTEntity;
			DailyCareCPPTEntity updatedDailyCareCPPTEntity;

			DiagnosesAndProceduresEntity icd10Entity;

			DiagnosesAndProceduresEntity icd9CMEntity;

			StaffEntity createdByStaffEntity;

			StaffEntity doctorInChargeEntity;

			StaffEntity medicalTranscriberEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				dailyCareCPPTEntity = dailyCareCPPTFactory.getObject(true, false);
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
			icd10Entity = dailyCareCPPTEntity.getIcd10();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(icd10Entity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			icd10Entity = diagnosesAndProceduresRepository.save(icd10Entity);
			dailyCareCPPTEntity.setIcd10Id(icd10Entity.getId());

			icd9CMEntity = dailyCareCPPTEntity.getIcd9CM();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(icd9CMEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			icd9CMEntity = diagnosesAndProceduresRepository.save(icd9CMEntity);
			dailyCareCPPTEntity.setIcd9CMId(icd9CMEntity.getId());

			createdByStaffEntity = dailyCareCPPTEntity.getCreatedByStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(createdByStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			createdByStaffEntity = staffRepository.save(createdByStaffEntity);
			dailyCareCPPTEntity.setCreatedByStaffId(createdByStaffEntity.getId());

			doctorInChargeEntity = dailyCareCPPTEntity.getDoctorInCharge();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(doctorInChargeEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			doctorInChargeEntity = staffRepository.save(doctorInChargeEntity);
			dailyCareCPPTEntity.setDoctorInChargeId(doctorInChargeEntity.getId());

			medicalTranscriberEntity = dailyCareCPPTEntity.getMedicalTranscriber();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalTranscriberEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalTranscriberEntity = staffRepository.save(medicalTranscriberEntity);
			dailyCareCPPTEntity.setMedicalTranscriberId(medicalTranscriberEntity.getId());

			medicalExaminationRecordEntity = dailyCareCPPTEntity.getMedicalExaminationRecord();
			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.save(medicalExaminationRecordEntity);
			dailyCareCPPTEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());


			dailyCareCPPTEntity = dailyCareCPPTService.create(dailyCareCPPTEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(dailyCareCPPTEntity.getIcd10());
			dailyCareCPPTEntity.setIcd10Id(null);
			dailyCareCPPTEntity.unsetIcd10();

			Assertions.assertNotNull(dailyCareCPPTEntity.getIcd9CM());
			dailyCareCPPTEntity.setIcd9CMId(null);
			dailyCareCPPTEntity.unsetIcd9CM();

			Assertions.assertNotNull(dailyCareCPPTEntity.getCreatedByStaff());
			dailyCareCPPTEntity.setCreatedByStaffId(null);
			dailyCareCPPTEntity.unsetCreatedByStaff();

			Assertions.assertNotNull(dailyCareCPPTEntity.getDoctorInCharge());
			dailyCareCPPTEntity.setDoctorInChargeId(null);
			dailyCareCPPTEntity.unsetDoctorInCharge();

			Assertions.assertNotNull(dailyCareCPPTEntity.getMedicalTranscriber());
			dailyCareCPPTEntity.setMedicalTranscriberId(null);
			dailyCareCPPTEntity.unsetMedicalTranscriber();

			Assertions.assertNotNull(dailyCareCPPTEntity.getMedicalExaminationRecord());
			dailyCareCPPTEntity.setMedicalExaminationRecordId(null);
			dailyCareCPPTEntity.unsetMedicalExaminationRecord();


			updatedDailyCareCPPTEntity = dailyCareCPPTService.updateOldData(dailyCareCPPTEntity);

			Assertions.assertNull(updatedDailyCareCPPTEntity.getIcd10());

			Assertions.assertNull(updatedDailyCareCPPTEntity.getIcd9CM());

			Assertions.assertNull(updatedDailyCareCPPTEntity.getCreatedByStaff());

			Assertions.assertNull(updatedDailyCareCPPTEntity.getDoctorInCharge());

			Assertions.assertNull(updatedDailyCareCPPTEntity.getMedicalTranscriber());

			Assertions.assertNull(updatedDailyCareCPPTEntity.getMedicalExaminationRecord());

		});
	}

	@Test
	public void updateOldDataWithDailyCareCPPTEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DailyCareCPPTEntity dailyCareCPPTEntity;
			DailyCareCPPTEntity updatedDailyCareCPPTEntity;

			DiagnosesAndProceduresEntity icd10Entity;

			DiagnosesAndProceduresEntity icd9CMEntity;

			StaffEntity createdByStaffEntity;

			StaffEntity doctorInChargeEntity;

			StaffEntity medicalTranscriberEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				dailyCareCPPTEntity = dailyCareCPPTFactory.getObject(true, false);
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
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(dailyCareCPPTEntity.getIcd10(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the ICD 10 relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			icd10Entity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(dailyCareCPPTEntity.getIcd10()).getId()).get();
			dailyCareCPPTEntity.unsetIcd10();
			dailyCareCPPTEntity.setIcd10Id(icd10Entity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(dailyCareCPPTEntity.getIcd9CM(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the ICD 9 CM relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			icd9CMEntity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(dailyCareCPPTEntity.getIcd9CM()).getId()).get();
			dailyCareCPPTEntity.unsetIcd9CM();
			dailyCareCPPTEntity.setIcd9CMId(icd9CMEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(dailyCareCPPTEntity.getCreatedByStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Created By Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			createdByStaffEntity = staffRepository.findById(staffRepository.save(dailyCareCPPTEntity.getCreatedByStaff()).getId()).get();
			dailyCareCPPTEntity.unsetCreatedByStaff();
			dailyCareCPPTEntity.setCreatedByStaffId(createdByStaffEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(dailyCareCPPTEntity.getDoctorInCharge(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Doctor in Charge relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			doctorInChargeEntity = staffRepository.findById(staffRepository.save(dailyCareCPPTEntity.getDoctorInCharge()).getId()).get();
			dailyCareCPPTEntity.unsetDoctorInCharge();
			dailyCareCPPTEntity.setDoctorInChargeId(doctorInChargeEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(dailyCareCPPTEntity.getMedicalTranscriber(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Transcriber relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalTranscriberEntity = staffRepository.findById(staffRepository.save(dailyCareCPPTEntity.getMedicalTranscriber()).getId()).get();
			dailyCareCPPTEntity.unsetMedicalTranscriber();
			dailyCareCPPTEntity.setMedicalTranscriberId(medicalTranscriberEntity.getId());

			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(dailyCareCPPTEntity.getMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.findById(medicalExaminationRecordRepository.save(dailyCareCPPTEntity.getMedicalExaminationRecord()).getId()).get();
			dailyCareCPPTEntity.unsetMedicalExaminationRecord();
			dailyCareCPPTEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedDailyCareCPPTEntity = dailyCareCPPTService.updateOldData(dailyCareCPPTEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			icd10Entity.unsetCpptICD10(false);
			updatedDailyCareCPPTEntity.getIcd10().unsetCpptICD10(false);
			Assertions.assertEquals(icd10Entity, updatedDailyCareCPPTEntity.getIcd10());

			icd9CMEntity.unsetCpptICD9CM(false);
			updatedDailyCareCPPTEntity.getIcd9CM().unsetCpptICD9CM(false);
			Assertions.assertEquals(icd9CMEntity, updatedDailyCareCPPTEntity.getIcd9CM());

			createdByStaffEntity.unsetDailyCareCPPTsCreatedByStaff(false);
			updatedDailyCareCPPTEntity.getCreatedByStaff().unsetDailyCareCPPTsCreatedByStaff(false);
			Assertions.assertEquals(createdByStaffEntity, updatedDailyCareCPPTEntity.getCreatedByStaff());

			doctorInChargeEntity.unsetDailyCareCPPTsDoctorInCharge(false);
			updatedDailyCareCPPTEntity.getDoctorInCharge().unsetDailyCareCPPTsDoctorInCharge(false);
			Assertions.assertEquals(doctorInChargeEntity, updatedDailyCareCPPTEntity.getDoctorInCharge());

			medicalTranscriberEntity.unsetDailyCareCPPTsMedicalTranscriber(false);
			updatedDailyCareCPPTEntity.getMedicalTranscriber().unsetDailyCareCPPTsMedicalTranscriber(false);
			Assertions.assertEquals(medicalTranscriberEntity, updatedDailyCareCPPTEntity.getMedicalTranscriber());

			medicalExaminationRecordEntity.unsetDailyCareCPPTs(false);
			updatedDailyCareCPPTEntity.getMedicalExaminationRecord().unsetDailyCareCPPTs(false);
			Assertions.assertEquals(medicalExaminationRecordEntity, updatedDailyCareCPPTEntity.getMedicalExaminationRecord());

		});
	}

	@Test
	public void whenCreateDailyCareCPPTEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			DailyCareCPPTEntity dailyCareCPPTEntity;
			Optional<DailyCareCPPTEntity> fetchedDailyCareCPPTEntity;

			try {
				dailyCareCPPTEntity = dailyCareCPPTFactory.getObject(false, false);
				dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(dailyCareCPPTEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			dailyCareCPPTEntity = dailyCareCPPTService.create(dailyCareCPPTEntity);

			fetchedDailyCareCPPTEntity = dailyCareCPPTService.findById(dailyCareCPPTEntity.getId());

			Assertions.assertTrue(fetchedDailyCareCPPTEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedDailyCareCPPTEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(dailyCareCPPTEntity, fetchedDailyCareCPPTEntity.get());
		});
	}

	@Test
	public void whenUpdateDailyCareCPPTEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			DailyCareCPPTEntity dailyCareCPPTEntity;
			DailyCareCPPTEntity updatedDailyCareCPPTEntity;
			Optional<DailyCareCPPTEntity> fetchedDailyCareCPPTEntity;

			try {
				dailyCareCPPTEntity = dailyCareCPPTFactory.getObject(false, false);
				dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(dailyCareCPPTEntity, true, true, false);
				updatedDailyCareCPPTEntity = dailyCareCPPTFactory.getObject(false, false);
				dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(updatedDailyCareCPPTEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			dailyCareCPPTEntity = dailyCareCPPTService.create(dailyCareCPPTEntity);

			updatedDailyCareCPPTEntity.setId(dailyCareCPPTEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedDailyCareCPPTEntity.setCreated(dailyCareCPPTEntity.getCreated());

			updatedDailyCareCPPTEntity = dailyCareCPPTService.update(updatedDailyCareCPPTEntity);

			fetchedDailyCareCPPTEntity = dailyCareCPPTService.findById(dailyCareCPPTEntity.getId());

			Assertions.assertTrue(fetchedDailyCareCPPTEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateDailyCareCPPTEntity_ThenEntityIsCreated
			fetchedDailyCareCPPTEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedDailyCareCPPTEntity, fetchedDailyCareCPPTEntity.get());
		});
	}

	@Test
	public void whenDeleteDailyCareCPPTEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			DailyCareCPPTEntity dailyCareCPPTEntity;
			Optional<DailyCareCPPTEntity> fetchedDailyCareCPPTEntity;

			try {
				dailyCareCPPTEntity = dailyCareCPPTFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				dailyCareCPPTDatabasePopulator.populateRelatedEntitiesInDatabase(dailyCareCPPTEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			dailyCareCPPTEntity = dailyCareCPPTService.create(dailyCareCPPTEntity);

			dailyCareCPPTService.deleteById(dailyCareCPPTEntity.getId());
			fetchedDailyCareCPPTEntity = dailyCareCPPTService.findById(dailyCareCPPTEntity.getId());

			Assertions.assertTrue(fetchedDailyCareCPPTEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
