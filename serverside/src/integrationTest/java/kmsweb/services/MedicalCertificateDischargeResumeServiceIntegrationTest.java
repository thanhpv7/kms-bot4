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
import kmsweb.entities.MedicalCertificateDischargeResumeEntity;
import kmsweb.repositories.MedicalCertificateDischargeResumeRepository;
import kmsweb.utils.MedicalCertificateDischargeResumeFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificateDischargeResumeDatabasePopulator;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
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
public class MedicalCertificateDischargeResumeServiceIntegrationTest {

	@Autowired
	private MedicalCertificateDischargeResumeRepository medicalCertificateDischargeResumeRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MedicalCertificateDischargeResumeService medicalCertificateDischargeResumeService;

	private final MedicalCertificateDischargeResumeFactory medicalCertificateDischargeResumeFactory = new MedicalCertificateDischargeResumeFactory();

	@Autowired
	private MedicalCertificateDischargeResumeDatabasePopulator medicalCertificateDischargeResumeDatabasePopulator;

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

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
		medicalCertificateDischargeResumeService = new MedicalCertificateDischargeResumeService(
			diagnosesAndProceduresRepository,
			registrationRepository,
			staffRepository,
			validator,
			auditRepository,
			medicalCertificateDischargeResumeRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMedicalCertificateDischargeResumeEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeFactory.getObject(false, false);

		MedicalCertificateDischargeResumeEntity updatedEntity = medicalCertificateDischargeResumeService.updateOldData(medicalCertificateDischargeResumeEntity);
		Assertions.assertEquals(medicalCertificateDischargeResumeEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingMedicalCertificateDischargeResumeEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntity;
			MedicalCertificateDischargeResumeEntity entityWithUpdatedValues;

			try {
				medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeFactory.getObject(false, false);
				medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateDischargeResumeEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = medicalCertificateDischargeResumeFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeService.create(medicalCertificateDischargeResumeEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(medicalCertificateDischargeResumeEntity.getId());

			MedicalCertificateDischargeResumeEntity updatedEntity = medicalCertificateDischargeResumeService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMedicalCertificateDischargeResumeEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeFactory.getObject(false, false);
		medicalCertificateDischargeResumeEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			medicalCertificateDischargeResumeService.updateOldData(medicalCertificateDischargeResumeEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMedicalCertificateDischargeResumeEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntity;
			MedicalCertificateDischargeResumeEntity updatedMedicalCertificateDischargeResumeEntity;

			RegistrationEntity registrationEntity;

			DiagnosesAndProceduresEntity dischargeICD10Entity;

			DiagnosesAndProceduresEntity dischargeICD9CMEntity;

			StaffEntity medicalStaffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeFactory.getObject(true, false);
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
			registrationEntity = medicalCertificateDischargeResumeEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			medicalCertificateDischargeResumeEntity.setRegistrationId(registrationEntity.getId());

			dischargeICD10Entity = medicalCertificateDischargeResumeEntity.getDischargeICD10();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(dischargeICD10Entity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			dischargeICD10Entity = diagnosesAndProceduresRepository.save(dischargeICD10Entity);
			medicalCertificateDischargeResumeEntity.setDischargeICD10Id(dischargeICD10Entity.getId());

			dischargeICD9CMEntity = medicalCertificateDischargeResumeEntity.getDischargeICD9CM();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(dischargeICD9CMEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			dischargeICD9CMEntity = diagnosesAndProceduresRepository.save(dischargeICD9CMEntity);
			medicalCertificateDischargeResumeEntity.setDischargeICD9CMId(dischargeICD9CMEntity.getId());

			medicalStaffEntity = medicalCertificateDischargeResumeEntity.getMedicalStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalStaffEntity = staffRepository.save(medicalStaffEntity);
			medicalCertificateDischargeResumeEntity.setMedicalStaffId(medicalStaffEntity.getId());


			medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeService.create(medicalCertificateDischargeResumeEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(medicalCertificateDischargeResumeEntity.getRegistration());
			medicalCertificateDischargeResumeEntity.setRegistrationId(null);
			medicalCertificateDischargeResumeEntity.unsetRegistration();

			Assertions.assertNotNull(medicalCertificateDischargeResumeEntity.getDischargeICD10());
			medicalCertificateDischargeResumeEntity.setDischargeICD10Id(null);
			medicalCertificateDischargeResumeEntity.unsetDischargeICD10();

			Assertions.assertNotNull(medicalCertificateDischargeResumeEntity.getDischargeICD9CM());
			medicalCertificateDischargeResumeEntity.setDischargeICD9CMId(null);
			medicalCertificateDischargeResumeEntity.unsetDischargeICD9CM();

			Assertions.assertNotNull(medicalCertificateDischargeResumeEntity.getMedicalStaff());
			medicalCertificateDischargeResumeEntity.setMedicalStaffId(null);
			medicalCertificateDischargeResumeEntity.unsetMedicalStaff();


			updatedMedicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeService.updateOldData(medicalCertificateDischargeResumeEntity);

			Assertions.assertNull(updatedMedicalCertificateDischargeResumeEntity.getRegistration());

			Assertions.assertNull(updatedMedicalCertificateDischargeResumeEntity.getDischargeICD10());

			Assertions.assertNull(updatedMedicalCertificateDischargeResumeEntity.getDischargeICD9CM());

			Assertions.assertNull(updatedMedicalCertificateDischargeResumeEntity.getMedicalStaff());

		});
	}

	@Test
	public void updateOldDataWithMedicalCertificateDischargeResumeEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntity;
			MedicalCertificateDischargeResumeEntity updatedMedicalCertificateDischargeResumeEntity;

			RegistrationEntity registrationEntity;

			DiagnosesAndProceduresEntity dischargeICD10Entity;

			DiagnosesAndProceduresEntity dischargeICD9CMEntity;

			StaffEntity medicalStaffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeFactory.getObject(true, false);
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
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateDischargeResumeEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(medicalCertificateDischargeResumeEntity.getRegistration()).getId()).get();
			medicalCertificateDischargeResumeEntity.unsetRegistration();
			medicalCertificateDischargeResumeEntity.setRegistrationId(registrationEntity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateDischargeResumeEntity.getDischargeICD10(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Discharge ICD 10 relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			dischargeICD10Entity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(medicalCertificateDischargeResumeEntity.getDischargeICD10()).getId()).get();
			medicalCertificateDischargeResumeEntity.unsetDischargeICD10();
			medicalCertificateDischargeResumeEntity.setDischargeICD10Id(dischargeICD10Entity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateDischargeResumeEntity.getDischargeICD9CM(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Discharge ICD 9 CM relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			dischargeICD9CMEntity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(medicalCertificateDischargeResumeEntity.getDischargeICD9CM()).getId()).get();
			medicalCertificateDischargeResumeEntity.unsetDischargeICD9CM();
			medicalCertificateDischargeResumeEntity.setDischargeICD9CMId(dischargeICD9CMEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateDischargeResumeEntity.getMedicalStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalStaffEntity = staffRepository.findById(staffRepository.save(medicalCertificateDischargeResumeEntity.getMedicalStaff()).getId()).get();
			medicalCertificateDischargeResumeEntity.unsetMedicalStaff();
			medicalCertificateDischargeResumeEntity.setMedicalStaffId(medicalStaffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMedicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeService.updateOldData(medicalCertificateDischargeResumeEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			registrationEntity.unsetMedicalCertificateDischargeResume(false);
			updatedMedicalCertificateDischargeResumeEntity.getRegistration().unsetMedicalCertificateDischargeResume(false);
			Assertions.assertEquals(registrationEntity, updatedMedicalCertificateDischargeResumeEntity.getRegistration());

			dischargeICD10Entity.unsetDischargeICD10(false);
			updatedMedicalCertificateDischargeResumeEntity.getDischargeICD10().unsetDischargeICD10(false);
			Assertions.assertEquals(dischargeICD10Entity, updatedMedicalCertificateDischargeResumeEntity.getDischargeICD10());

			dischargeICD9CMEntity.unsetDischargeICD9CM(false);
			updatedMedicalCertificateDischargeResumeEntity.getDischargeICD9CM().unsetDischargeICD9CM(false);
			Assertions.assertEquals(dischargeICD9CMEntity, updatedMedicalCertificateDischargeResumeEntity.getDischargeICD9CM());

			medicalStaffEntity.unsetMedicalCertificateDischargeResumes(false);
			updatedMedicalCertificateDischargeResumeEntity.getMedicalStaff().unsetMedicalCertificateDischargeResumes(false);
			Assertions.assertEquals(medicalStaffEntity, updatedMedicalCertificateDischargeResumeEntity.getMedicalStaff());

		});
	}

	@Test
	public void whenCreateMedicalCertificateDischargeResumeEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntity;
			Optional<MedicalCertificateDischargeResumeEntity> fetchedMedicalCertificateDischargeResumeEntity;

			try {
				medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeFactory.getObject(false, false);
				medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateDischargeResumeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeService.create(medicalCertificateDischargeResumeEntity);

			fetchedMedicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeService.findById(medicalCertificateDischargeResumeEntity.getId());

			Assertions.assertTrue(fetchedMedicalCertificateDischargeResumeEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMedicalCertificateDischargeResumeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(medicalCertificateDischargeResumeEntity, fetchedMedicalCertificateDischargeResumeEntity.get());
		});
	}

	@Test
	public void whenUpdateMedicalCertificateDischargeResumeEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntity;
			MedicalCertificateDischargeResumeEntity updatedMedicalCertificateDischargeResumeEntity;
			Optional<MedicalCertificateDischargeResumeEntity> fetchedMedicalCertificateDischargeResumeEntity;

			try {
				medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeFactory.getObject(false, false);
				medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateDischargeResumeEntity, true, true, false);
				updatedMedicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeFactory.getObject(false, false);
				medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMedicalCertificateDischargeResumeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeService.create(medicalCertificateDischargeResumeEntity);

			updatedMedicalCertificateDischargeResumeEntity.setId(medicalCertificateDischargeResumeEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMedicalCertificateDischargeResumeEntity.setCreated(medicalCertificateDischargeResumeEntity.getCreated());

			updatedMedicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeService.update(updatedMedicalCertificateDischargeResumeEntity);

			fetchedMedicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeService.findById(medicalCertificateDischargeResumeEntity.getId());

			Assertions.assertTrue(fetchedMedicalCertificateDischargeResumeEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMedicalCertificateDischargeResumeEntity_ThenEntityIsCreated
			fetchedMedicalCertificateDischargeResumeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMedicalCertificateDischargeResumeEntity, fetchedMedicalCertificateDischargeResumeEntity.get());
		});
	}

	@Test
	public void whenDeleteMedicalCertificateDischargeResumeEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResumeEntity;
			Optional<MedicalCertificateDischargeResumeEntity> fetchedMedicalCertificateDischargeResumeEntity;

			try {
				medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				medicalCertificateDischargeResumeDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateDischargeResumeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeService.create(medicalCertificateDischargeResumeEntity);

			medicalCertificateDischargeResumeService.deleteById(medicalCertificateDischargeResumeEntity.getId());
			fetchedMedicalCertificateDischargeResumeEntity = medicalCertificateDischargeResumeService.findById(medicalCertificateDischargeResumeEntity.getId());

			Assertions.assertTrue(fetchedMedicalCertificateDischargeResumeEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
