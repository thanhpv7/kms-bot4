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
import kmsweb.entities.HemodialysisMonitoringEntity;
import kmsweb.repositories.HemodialysisMonitoringRepository;
import kmsweb.utils.HemodialysisMonitoringFactory;
import kmsweb.utils.DatabasePopulators.HemodialysisMonitoringDatabasePopulator;
import kmsweb.entities.HemodialysisExaminationEntity;
import kmsweb.repositories.HemodialysisExaminationRepository;
import kmsweb.utils.HemodialysisExaminationFactory;
import kmsweb.utils.DatabasePopulators.HemodialysisExaminationDatabasePopulator;
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
public class HemodialysisMonitoringServiceIntegrationTest {

	@Autowired
	private HemodialysisMonitoringRepository hemodialysisMonitoringRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private HemodialysisMonitoringService hemodialysisMonitoringService;

	private final HemodialysisMonitoringFactory hemodialysisMonitoringFactory = new HemodialysisMonitoringFactory();

	@Autowired
	private HemodialysisMonitoringDatabasePopulator hemodialysisMonitoringDatabasePopulator;

	@Autowired
	private HemodialysisExaminationRepository hemodialysisExaminationRepository;

	@Autowired
	private HemodialysisExaminationDatabasePopulator hemodialysisExaminationDatabasePopulator;

	private final HemodialysisExaminationFactory hemodialysisExaminationFactory = new HemodialysisExaminationFactory();

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
		hemodialysisMonitoringService = new HemodialysisMonitoringService(
			hemodialysisExaminationRepository,
			staffRepository,
			validator,
			auditRepository,
			hemodialysisMonitoringRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewHemodialysisMonitoringEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		HemodialysisMonitoringEntity hemodialysisMonitoringEntity = hemodialysisMonitoringFactory.getObject(false, false);

		HemodialysisMonitoringEntity updatedEntity = hemodialysisMonitoringService.updateOldData(hemodialysisMonitoringEntity);
		Assertions.assertEquals(hemodialysisMonitoringEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingHemodialysisMonitoringEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisMonitoringEntity hemodialysisMonitoringEntity;
			HemodialysisMonitoringEntity entityWithUpdatedValues;

			try {
				hemodialysisMonitoringEntity = hemodialysisMonitoringFactory.getObject(false, false);
				hemodialysisMonitoringDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisMonitoringEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = hemodialysisMonitoringFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hemodialysisMonitoringEntity = hemodialysisMonitoringService.create(hemodialysisMonitoringEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(hemodialysisMonitoringEntity.getId());

			HemodialysisMonitoringEntity updatedEntity = hemodialysisMonitoringService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithHemodialysisMonitoringEntityWithNonExistentId_ShouldThrowException() throws Exception {
		HemodialysisMonitoringEntity hemodialysisMonitoringEntity = hemodialysisMonitoringFactory.getObject(false, false);
		hemodialysisMonitoringEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			hemodialysisMonitoringService.updateOldData(hemodialysisMonitoringEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingHemodialysisMonitoringEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisMonitoringEntity hemodialysisMonitoringEntity;
			HemodialysisMonitoringEntity updatedHemodialysisMonitoringEntity;

			HemodialysisExaminationEntity hemodialysisExaminationEntity;

			StaffEntity medicalStaffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				hemodialysisMonitoringEntity = hemodialysisMonitoringFactory.getObject(true, false);
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
			hemodialysisExaminationEntity = hemodialysisMonitoringEntity.getHemodialysisExamination();
			try {
				hemodialysisExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisExaminationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			hemodialysisExaminationEntity = hemodialysisExaminationRepository.save(hemodialysisExaminationEntity);
			hemodialysisMonitoringEntity.setHemodialysisExaminationId(hemodialysisExaminationEntity.getId());

			medicalStaffEntity = hemodialysisMonitoringEntity.getMedicalStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalStaffEntity = staffRepository.save(medicalStaffEntity);
			hemodialysisMonitoringEntity.setMedicalStaffId(medicalStaffEntity.getId());


			hemodialysisMonitoringEntity = hemodialysisMonitoringService.create(hemodialysisMonitoringEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(hemodialysisMonitoringEntity.getHemodialysisExamination());
			hemodialysisMonitoringEntity.setHemodialysisExaminationId(null);
			hemodialysisMonitoringEntity.unsetHemodialysisExamination();

			Assertions.assertNotNull(hemodialysisMonitoringEntity.getMedicalStaff());
			hemodialysisMonitoringEntity.setMedicalStaffId(null);
			hemodialysisMonitoringEntity.unsetMedicalStaff();


			updatedHemodialysisMonitoringEntity = hemodialysisMonitoringService.updateOldData(hemodialysisMonitoringEntity);

			Assertions.assertNull(updatedHemodialysisMonitoringEntity.getHemodialysisExamination());

			Assertions.assertNull(updatedHemodialysisMonitoringEntity.getMedicalStaff());

		});
	}

	@Test
	public void updateOldDataWithHemodialysisMonitoringEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisMonitoringEntity hemodialysisMonitoringEntity;
			HemodialysisMonitoringEntity updatedHemodialysisMonitoringEntity;

			HemodialysisExaminationEntity hemodialysisExaminationEntity;

			StaffEntity medicalStaffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				hemodialysisMonitoringEntity = hemodialysisMonitoringFactory.getObject(true, false);
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
				hemodialysisExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisMonitoringEntity.getHemodialysisExamination(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Hemodialysis Examination relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			hemodialysisExaminationEntity = hemodialysisExaminationRepository.findById(hemodialysisExaminationRepository.save(hemodialysisMonitoringEntity.getHemodialysisExamination()).getId()).get();
			hemodialysisMonitoringEntity.unsetHemodialysisExamination();
			hemodialysisMonitoringEntity.setHemodialysisExaminationId(hemodialysisExaminationEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisMonitoringEntity.getMedicalStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalStaffEntity = staffRepository.findById(staffRepository.save(hemodialysisMonitoringEntity.getMedicalStaff()).getId()).get();
			hemodialysisMonitoringEntity.unsetMedicalStaff();
			hemodialysisMonitoringEntity.setMedicalStaffId(medicalStaffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedHemodialysisMonitoringEntity = hemodialysisMonitoringService.updateOldData(hemodialysisMonitoringEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			hemodialysisExaminationEntity.unsetHemodialysisMonitorings(false);
			updatedHemodialysisMonitoringEntity.getHemodialysisExamination().unsetHemodialysisMonitorings(false);
			Assertions.assertEquals(hemodialysisExaminationEntity, updatedHemodialysisMonitoringEntity.getHemodialysisExamination());

			medicalStaffEntity.unsetHemodialysisMonitorings(false);
			updatedHemodialysisMonitoringEntity.getMedicalStaff().unsetHemodialysisMonitorings(false);
			Assertions.assertEquals(medicalStaffEntity, updatedHemodialysisMonitoringEntity.getMedicalStaff());

		});
	}

	@Test
	public void whenCreateHemodialysisMonitoringEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisMonitoringEntity hemodialysisMonitoringEntity;
			Optional<HemodialysisMonitoringEntity> fetchedHemodialysisMonitoringEntity;

			try {
				hemodialysisMonitoringEntity = hemodialysisMonitoringFactory.getObject(false, false);
				hemodialysisMonitoringDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisMonitoringEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hemodialysisMonitoringEntity = hemodialysisMonitoringService.create(hemodialysisMonitoringEntity);

			fetchedHemodialysisMonitoringEntity = hemodialysisMonitoringService.findById(hemodialysisMonitoringEntity.getId());

			Assertions.assertTrue(fetchedHemodialysisMonitoringEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedHemodialysisMonitoringEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(hemodialysisMonitoringEntity, fetchedHemodialysisMonitoringEntity.get());
		});
	}

	@Test
	public void whenUpdateHemodialysisMonitoringEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisMonitoringEntity hemodialysisMonitoringEntity;
			HemodialysisMonitoringEntity updatedHemodialysisMonitoringEntity;
			Optional<HemodialysisMonitoringEntity> fetchedHemodialysisMonitoringEntity;

			try {
				hemodialysisMonitoringEntity = hemodialysisMonitoringFactory.getObject(false, false);
				hemodialysisMonitoringDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisMonitoringEntity, true, true, false);
				updatedHemodialysisMonitoringEntity = hemodialysisMonitoringFactory.getObject(false, false);
				hemodialysisMonitoringDatabasePopulator.populateRelatedEntitiesInDatabase(updatedHemodialysisMonitoringEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hemodialysisMonitoringEntity = hemodialysisMonitoringService.create(hemodialysisMonitoringEntity);

			updatedHemodialysisMonitoringEntity.setId(hemodialysisMonitoringEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedHemodialysisMonitoringEntity.setCreated(hemodialysisMonitoringEntity.getCreated());

			updatedHemodialysisMonitoringEntity = hemodialysisMonitoringService.update(updatedHemodialysisMonitoringEntity);

			fetchedHemodialysisMonitoringEntity = hemodialysisMonitoringService.findById(hemodialysisMonitoringEntity.getId());

			Assertions.assertTrue(fetchedHemodialysisMonitoringEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateHemodialysisMonitoringEntity_ThenEntityIsCreated
			fetchedHemodialysisMonitoringEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedHemodialysisMonitoringEntity, fetchedHemodialysisMonitoringEntity.get());
		});
	}

	@Test
	public void whenDeleteHemodialysisMonitoringEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisMonitoringEntity hemodialysisMonitoringEntity;
			Optional<HemodialysisMonitoringEntity> fetchedHemodialysisMonitoringEntity;

			try {
				hemodialysisMonitoringEntity = hemodialysisMonitoringFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				hemodialysisMonitoringDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisMonitoringEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hemodialysisMonitoringEntity = hemodialysisMonitoringService.create(hemodialysisMonitoringEntity);

			hemodialysisMonitoringService.deleteById(hemodialysisMonitoringEntity.getId());
			fetchedHemodialysisMonitoringEntity = hemodialysisMonitoringService.findById(hemodialysisMonitoringEntity.getId());

			Assertions.assertTrue(fetchedHemodialysisMonitoringEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
