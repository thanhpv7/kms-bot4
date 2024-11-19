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
import kmsweb.entities.MedicalExaminationRecordDischargeSummaryEntity;
import kmsweb.repositories.MedicalExaminationRecordDischargeSummaryRepository;
import kmsweb.utils.MedicalExaminationRecordDischargeSummaryFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDischargeSummaryDatabasePopulator;
import kmsweb.entities.DiagnosisExaminationRecordEntity;
import kmsweb.repositories.DiagnosisExaminationRecordRepository;
import kmsweb.utils.DiagnosisExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.DiagnosisExaminationRecordDatabasePopulator;
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
public class MedicalExaminationRecordDischargeSummaryServiceIntegrationTest {

	@Autowired
	private MedicalExaminationRecordDischargeSummaryRepository medicalExaminationRecordDischargeSummaryRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MedicalExaminationRecordDischargeSummaryService medicalExaminationRecordDischargeSummaryService;

	private final MedicalExaminationRecordDischargeSummaryFactory medicalExaminationRecordDischargeSummaryFactory = new MedicalExaminationRecordDischargeSummaryFactory();

	@Autowired
	private MedicalExaminationRecordDischargeSummaryDatabasePopulator medicalExaminationRecordDischargeSummaryDatabasePopulator;

	@Autowired
	private DiagnosisExaminationRecordRepository diagnosisExaminationRecordRepository;

	@Autowired
	private DiagnosisExaminationRecordDatabasePopulator diagnosisExaminationRecordDatabasePopulator;

	private final DiagnosisExaminationRecordFactory diagnosisExaminationRecordFactory = new DiagnosisExaminationRecordFactory();

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
		medicalExaminationRecordDischargeSummaryService = new MedicalExaminationRecordDischargeSummaryService(
			diagnosisExaminationRecordRepository,
			medicalExaminationRecordRepository,
			staffRepository,
			validator,
			auditRepository,
			medicalExaminationRecordDischargeSummaryRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMedicalExaminationRecordDischargeSummaryEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryFactory.getObject(false, false);

		MedicalExaminationRecordDischargeSummaryEntity updatedEntity = medicalExaminationRecordDischargeSummaryService.updateOldData(medicalExaminationRecordDischargeSummaryEntity);
		Assertions.assertEquals(medicalExaminationRecordDischargeSummaryEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingMedicalExaminationRecordDischargeSummaryEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity;
			MedicalExaminationRecordDischargeSummaryEntity entityWithUpdatedValues;

			try {
				medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryFactory.getObject(false, false);
				medicalExaminationRecordDischargeSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordDischargeSummaryEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = medicalExaminationRecordDischargeSummaryFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryService.create(medicalExaminationRecordDischargeSummaryEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(medicalExaminationRecordDischargeSummaryEntity.getId());

			MedicalExaminationRecordDischargeSummaryEntity updatedEntity = medicalExaminationRecordDischargeSummaryService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMedicalExaminationRecordDischargeSummaryEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryFactory.getObject(false, false);
		medicalExaminationRecordDischargeSummaryEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			medicalExaminationRecordDischargeSummaryService.updateOldData(medicalExaminationRecordDischargeSummaryEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMedicalExaminationRecordDischargeSummaryEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity;
			MedicalExaminationRecordDischargeSummaryEntity updatedMedicalExaminationRecordDischargeSummaryEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			StaffEntity dischargingDoctorEntity;

			Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecordsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryFactory.getObject(true, false);
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
			medicalExaminationRecordEntity = medicalExaminationRecordDischargeSummaryEntity.getMedicalExaminationRecord();
			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.save(medicalExaminationRecordEntity);
			medicalExaminationRecordDischargeSummaryEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			dischargingDoctorEntity = medicalExaminationRecordDischargeSummaryEntity.getDischargingDoctor();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(dischargingDoctorEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			dischargingDoctorEntity = staffRepository.save(dischargingDoctorEntity);
			medicalExaminationRecordDischargeSummaryEntity.setDischargingDoctorId(dischargingDoctorEntity.getId());

			diagnosisExaminationRecordsEntities = medicalExaminationRecordDischargeSummaryEntity.getDiagnosisExaminationRecords();
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
			medicalExaminationRecordDischargeSummaryEntity.setDiagnosisExaminationRecordsIds(diagnosisExaminationRecordsEntityIds);


			medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryService.create(medicalExaminationRecordDischargeSummaryEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(medicalExaminationRecordDischargeSummaryEntity.getMedicalExaminationRecord());
			medicalExaminationRecordDischargeSummaryEntity.setMedicalExaminationRecordId(null);
			medicalExaminationRecordDischargeSummaryEntity.unsetMedicalExaminationRecord();

			Assertions.assertNotNull(medicalExaminationRecordDischargeSummaryEntity.getDischargingDoctor());
			medicalExaminationRecordDischargeSummaryEntity.setDischargingDoctorId(null);
			medicalExaminationRecordDischargeSummaryEntity.unsetDischargingDoctor();

			Assertions.assertTrue(medicalExaminationRecordDischargeSummaryEntity.getDiagnosisExaminationRecords().size() > 0);
			medicalExaminationRecordDischargeSummaryEntity.setDiagnosisExaminationRecordsIds(new HashSet<UUID>());
			medicalExaminationRecordDischargeSummaryEntity.unsetDiagnosisExaminationRecords();


			updatedMedicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryService.updateOldData(medicalExaminationRecordDischargeSummaryEntity);

			Assertions.assertNull(updatedMedicalExaminationRecordDischargeSummaryEntity.getMedicalExaminationRecord());

			Assertions.assertNull(updatedMedicalExaminationRecordDischargeSummaryEntity.getDischargingDoctor());

			Assertions.assertEquals(0, updatedMedicalExaminationRecordDischargeSummaryEntity.getDiagnosisExaminationRecords().size());

		});
	}

	@Test
	public void updateOldDataWithMedicalExaminationRecordDischargeSummaryEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity;
			MedicalExaminationRecordDischargeSummaryEntity updatedMedicalExaminationRecordDischargeSummaryEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			StaffEntity dischargingDoctorEntity;

			Set<DiagnosisExaminationRecordEntity> diagnosisExaminationRecordsEntities;
			Set<UUID> diagnosisExaminationRecordsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryFactory.getObject(true, false);
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
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordDischargeSummaryEntity.getMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.findById(medicalExaminationRecordRepository.save(medicalExaminationRecordDischargeSummaryEntity.getMedicalExaminationRecord()).getId()).get();
			medicalExaminationRecordDischargeSummaryEntity.unsetMedicalExaminationRecord();
			medicalExaminationRecordDischargeSummaryEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordDischargeSummaryEntity.getDischargingDoctor(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Discharging Doctor relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			dischargingDoctorEntity = staffRepository.findById(staffRepository.save(medicalExaminationRecordDischargeSummaryEntity.getDischargingDoctor()).getId()).get();
			medicalExaminationRecordDischargeSummaryEntity.unsetDischargingDoctor();
			medicalExaminationRecordDischargeSummaryEntity.setDischargingDoctorId(dischargingDoctorEntity.getId());

			diagnosisExaminationRecordsEntities = new HashSet<>();
			diagnosisExaminationRecordsEntityIds = new HashSet<>();
			for (DiagnosisExaminationRecordEntity entity : medicalExaminationRecordDischargeSummaryEntity.getDiagnosisExaminationRecords()) {
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
			medicalExaminationRecordDischargeSummaryEntity.unsetDiagnosisExaminationRecords();
			medicalExaminationRecordDischargeSummaryEntity.setDiagnosisExaminationRecordsIds(diagnosisExaminationRecordsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMedicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryService.updateOldData(medicalExaminationRecordDischargeSummaryEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			medicalExaminationRecordEntity.unsetMedicalExaminationRecordDischargeSummary(false);
			updatedMedicalExaminationRecordDischargeSummaryEntity.getMedicalExaminationRecord().unsetMedicalExaminationRecordDischargeSummary(false);
			Assertions.assertEquals(medicalExaminationRecordEntity, updatedMedicalExaminationRecordDischargeSummaryEntity.getMedicalExaminationRecord());

			dischargingDoctorEntity.unsetMedicalExaminationRecordDischargeSummarys(false);
			updatedMedicalExaminationRecordDischargeSummaryEntity.getDischargingDoctor().unsetMedicalExaminationRecordDischargeSummarys(false);
			Assertions.assertEquals(dischargingDoctorEntity, updatedMedicalExaminationRecordDischargeSummaryEntity.getDischargingDoctor());

			Assertions.assertEquals(diagnosisExaminationRecordsEntities.size(), updatedMedicalExaminationRecordDischargeSummaryEntity.getDiagnosisExaminationRecords().size());

		});
	}

	@Test
	public void whenCreateMedicalExaminationRecordDischargeSummaryEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity;
			Optional<MedicalExaminationRecordDischargeSummaryEntity> fetchedMedicalExaminationRecordDischargeSummaryEntity;

			try {
				medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryFactory.getObject(false, false);
				medicalExaminationRecordDischargeSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordDischargeSummaryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryService.create(medicalExaminationRecordDischargeSummaryEntity);

			fetchedMedicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryService.findById(medicalExaminationRecordDischargeSummaryEntity.getId());

			Assertions.assertTrue(fetchedMedicalExaminationRecordDischargeSummaryEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMedicalExaminationRecordDischargeSummaryEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(medicalExaminationRecordDischargeSummaryEntity, fetchedMedicalExaminationRecordDischargeSummaryEntity.get());
		});
	}

	@Test
	public void whenUpdateMedicalExaminationRecordDischargeSummaryEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity;
			MedicalExaminationRecordDischargeSummaryEntity updatedMedicalExaminationRecordDischargeSummaryEntity;
			Optional<MedicalExaminationRecordDischargeSummaryEntity> fetchedMedicalExaminationRecordDischargeSummaryEntity;

			try {
				medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryFactory.getObject(false, false);
				medicalExaminationRecordDischargeSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordDischargeSummaryEntity, true, true, false);
				updatedMedicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryFactory.getObject(false, false);
				medicalExaminationRecordDischargeSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMedicalExaminationRecordDischargeSummaryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryService.create(medicalExaminationRecordDischargeSummaryEntity);

			updatedMedicalExaminationRecordDischargeSummaryEntity.setId(medicalExaminationRecordDischargeSummaryEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMedicalExaminationRecordDischargeSummaryEntity.setCreated(medicalExaminationRecordDischargeSummaryEntity.getCreated());

			updatedMedicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryService.update(updatedMedicalExaminationRecordDischargeSummaryEntity);

			fetchedMedicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryService.findById(medicalExaminationRecordDischargeSummaryEntity.getId());

			Assertions.assertTrue(fetchedMedicalExaminationRecordDischargeSummaryEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMedicalExaminationRecordDischargeSummaryEntity_ThenEntityIsCreated
			fetchedMedicalExaminationRecordDischargeSummaryEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMedicalExaminationRecordDischargeSummaryEntity, fetchedMedicalExaminationRecordDischargeSummaryEntity.get());
		});
	}

	@Test
	public void whenDeleteMedicalExaminationRecordDischargeSummaryEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity;
			Optional<MedicalExaminationRecordDischargeSummaryEntity> fetchedMedicalExaminationRecordDischargeSummaryEntity;

			try {
				medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				medicalExaminationRecordDischargeSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordDischargeSummaryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryService.create(medicalExaminationRecordDischargeSummaryEntity);

			medicalExaminationRecordDischargeSummaryService.deleteById(medicalExaminationRecordDischargeSummaryEntity.getId());
			fetchedMedicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryService.findById(medicalExaminationRecordDischargeSummaryEntity.getId());

			Assertions.assertTrue(fetchedMedicalExaminationRecordDischargeSummaryEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
