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
import kmsweb.entities.NurseUserEntity;
import kmsweb.repositories.NurseUserRepository;
import kmsweb.utils.NurseUserFactory;
import kmsweb.utils.DatabasePopulators.NurseUserDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
import kmsweb.repositories.auditing.AuditingRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.Validator;

import java.util.*;
import java.util.stream.Collectors;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestConfiguration.class)
@ActiveProfiles("test")
// % protected region % [Add any additional class annotations here] off begin
// % protected region % [Add any additional class annotations here] end
public class NurseUserServiceIntegrationTest {

	@Autowired
	private NurseUserRepository nurseUserRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	@Autowired
	private RoleService roleService;

	@Autowired
	PasswordEncoder passwordEncoder;

	// Not autowired as we instantiate this in beforeEach
	private NurseUserService nurseUserService;

	private final NurseUserFactory nurseUserFactory = new NurseUserFactory();

	@Autowired
	private NurseUserDatabasePopulator nurseUserDatabasePopulator;

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
		nurseUserService = new NurseUserService(
			roleService,
			passwordEncoder,
			staffRepository,
			validator,
			auditRepository,
			nurseUserRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewNurseUserEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		NurseUserEntity nurseUserEntity = nurseUserFactory.getObject(false, false);

		NurseUserEntity updatedEntity = nurseUserService.updateOldData(nurseUserEntity);
		Assertions.assertEquals(nurseUserEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingNurseUserEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			NurseUserEntity nurseUserEntity;
			NurseUserEntity entityWithUpdatedValues;

			try {
				nurseUserEntity = nurseUserFactory.getObject(false, false);
				nurseUserDatabasePopulator.populateRelatedEntitiesInDatabase(nurseUserEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = nurseUserFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			nurseUserEntity = nurseUserService.create(nurseUserEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(nurseUserEntity.getId());

			NurseUserEntity updatedEntity = nurseUserService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithNurseUserEntityWithNonExistentId_ShouldThrowException() throws Exception {
		NurseUserEntity nurseUserEntity = nurseUserFactory.getObject(false, false);
		nurseUserEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			nurseUserService.updateOldData(nurseUserEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingNurseUserEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			NurseUserEntity nurseUserEntity;
			NurseUserEntity updatedNurseUserEntity;

			StaffEntity staffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				nurseUserEntity = nurseUserFactory.getObject(true, false);
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
			staffEntity = nurseUserEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			nurseUserEntity.setStaffId(staffEntity.getId());


			nurseUserEntity = nurseUserService.create(nurseUserEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(nurseUserEntity.getStaff());
			nurseUserEntity.setStaffId(null);
			nurseUserEntity.unsetStaff();


			updatedNurseUserEntity = nurseUserService.updateOldData(nurseUserEntity);

			Assertions.assertNull(updatedNurseUserEntity.getStaff());

		});
	}

	@Test
	public void updateOldDataWithNurseUserEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			NurseUserEntity nurseUserEntity;
			NurseUserEntity updatedNurseUserEntity;

			StaffEntity staffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				nurseUserEntity = nurseUserFactory.getObject(true, false);
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
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(nurseUserEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(nurseUserEntity.getStaff()).getId()).get();
			nurseUserEntity.unsetStaff();
			nurseUserEntity.setStaffId(staffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedNurseUserEntity = nurseUserService.updateOldData(nurseUserEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			staffEntity.unsetNurseUser(false);
			updatedNurseUserEntity.getStaff().unsetNurseUser(false);
			Assertions.assertEquals(staffEntity, updatedNurseUserEntity.getStaff());

		});
	}

	@Test
	public void whenCreateNurseUserEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			NurseUserEntity nurseUserEntity;
			Optional<NurseUserEntity> fetchedNurseUserEntity;

			try {
				nurseUserEntity = nurseUserFactory.getObject(false, false);
				nurseUserDatabasePopulator.populateRelatedEntitiesInDatabase(nurseUserEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			nurseUserEntity = nurseUserService.create(nurseUserEntity);

			fetchedNurseUserEntity = nurseUserService.findById(nurseUserEntity.getId());

			Assertions.assertTrue(fetchedNurseUserEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedNurseUserEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(nurseUserEntity, fetchedNurseUserEntity.get());
		});
	}

	@Test
	public void whenUpdateNurseUserEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			NurseUserEntity nurseUserEntity;
			NurseUserEntity updatedNurseUserEntity;
			Optional<NurseUserEntity> fetchedNurseUserEntity;

			try {
				nurseUserEntity = nurseUserFactory.getObject(false, false);
				nurseUserDatabasePopulator.populateRelatedEntitiesInDatabase(nurseUserEntity, true, true, false);
				updatedNurseUserEntity = nurseUserFactory.getObject(false, false);
				nurseUserDatabasePopulator.populateRelatedEntitiesInDatabase(updatedNurseUserEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			nurseUserEntity = nurseUserService.create(nurseUserEntity);

			updatedNurseUserEntity.setId(nurseUserEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedNurseUserEntity.setCreated(nurseUserEntity.getCreated());

			updatedNurseUserEntity = nurseUserService.update(updatedNurseUserEntity);

			fetchedNurseUserEntity = nurseUserService.findById(nurseUserEntity.getId());

			Assertions.assertTrue(fetchedNurseUserEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateNurseUserEntity_ThenEntityIsCreated
			fetchedNurseUserEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedNurseUserEntity, fetchedNurseUserEntity.get());
		});
	}

	@Test
	public void whenDeleteNurseUserEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			NurseUserEntity nurseUserEntity;
			Optional<NurseUserEntity> fetchedNurseUserEntity;

			try {
				nurseUserEntity = nurseUserFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				nurseUserDatabasePopulator.populateRelatedEntitiesInDatabase(nurseUserEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			nurseUserEntity = nurseUserService.create(nurseUserEntity);

			nurseUserService.deleteById(nurseUserEntity.getId());
			fetchedNurseUserEntity = nurseUserService.findById(nurseUserEntity.getId());

			Assertions.assertTrue(fetchedNurseUserEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
