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
import kmsweb.entities.SystemAdminUserEntity;
import kmsweb.repositories.SystemAdminUserRepository;
import kmsweb.utils.SystemAdminUserFactory;
import kmsweb.utils.DatabasePopulators.SystemAdminUserDatabasePopulator;
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
public class SystemAdminUserServiceIntegrationTest {

	@Autowired
	private SystemAdminUserRepository systemAdminUserRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	@Autowired
	private RoleService roleService;

	@Autowired
	PasswordEncoder passwordEncoder;

	// Not autowired as we instantiate this in beforeEach
	private SystemAdminUserService systemAdminUserService;

	private final SystemAdminUserFactory systemAdminUserFactory = new SystemAdminUserFactory();

	@Autowired
	private SystemAdminUserDatabasePopulator systemAdminUserDatabasePopulator;

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
		systemAdminUserService = new SystemAdminUserService(
			roleService,
			passwordEncoder,
			staffRepository,
			validator,
			auditRepository,
			systemAdminUserRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewSystemAdminUserEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		SystemAdminUserEntity systemAdminUserEntity = systemAdminUserFactory.getObject(false, false);

		SystemAdminUserEntity updatedEntity = systemAdminUserService.updateOldData(systemAdminUserEntity);
		Assertions.assertEquals(systemAdminUserEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingSystemAdminUserEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			SystemAdminUserEntity systemAdminUserEntity;
			SystemAdminUserEntity entityWithUpdatedValues;

			try {
				systemAdminUserEntity = systemAdminUserFactory.getObject(false, false);
				systemAdminUserDatabasePopulator.populateRelatedEntitiesInDatabase(systemAdminUserEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = systemAdminUserFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			systemAdminUserEntity = systemAdminUserService.create(systemAdminUserEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(systemAdminUserEntity.getId());

			SystemAdminUserEntity updatedEntity = systemAdminUserService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithSystemAdminUserEntityWithNonExistentId_ShouldThrowException() throws Exception {
		SystemAdminUserEntity systemAdminUserEntity = systemAdminUserFactory.getObject(false, false);
		systemAdminUserEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			systemAdminUserService.updateOldData(systemAdminUserEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingSystemAdminUserEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			SystemAdminUserEntity systemAdminUserEntity;
			SystemAdminUserEntity updatedSystemAdminUserEntity;

			StaffEntity staffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				systemAdminUserEntity = systemAdminUserFactory.getObject(true, false);
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
			staffEntity = systemAdminUserEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			systemAdminUserEntity.setStaffId(staffEntity.getId());


			systemAdminUserEntity = systemAdminUserService.create(systemAdminUserEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(systemAdminUserEntity.getStaff());
			systemAdminUserEntity.setStaffId(null);
			systemAdminUserEntity.unsetStaff();


			updatedSystemAdminUserEntity = systemAdminUserService.updateOldData(systemAdminUserEntity);

			Assertions.assertNull(updatedSystemAdminUserEntity.getStaff());

		});
	}

	@Test
	public void updateOldDataWithSystemAdminUserEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			SystemAdminUserEntity systemAdminUserEntity;
			SystemAdminUserEntity updatedSystemAdminUserEntity;

			StaffEntity staffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				systemAdminUserEntity = systemAdminUserFactory.getObject(true, false);
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
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(systemAdminUserEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(systemAdminUserEntity.getStaff()).getId()).get();
			systemAdminUserEntity.unsetStaff();
			systemAdminUserEntity.setStaffId(staffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedSystemAdminUserEntity = systemAdminUserService.updateOldData(systemAdminUserEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			staffEntity.unsetSystemAdminUser(false);
			updatedSystemAdminUserEntity.getStaff().unsetSystemAdminUser(false);
			Assertions.assertEquals(staffEntity, updatedSystemAdminUserEntity.getStaff());

		});
	}

	@Test
	public void whenCreateSystemAdminUserEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			SystemAdminUserEntity systemAdminUserEntity;
			Optional<SystemAdminUserEntity> fetchedSystemAdminUserEntity;

			try {
				systemAdminUserEntity = systemAdminUserFactory.getObject(false, false);
				systemAdminUserDatabasePopulator.populateRelatedEntitiesInDatabase(systemAdminUserEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			systemAdminUserEntity = systemAdminUserService.create(systemAdminUserEntity);

			fetchedSystemAdminUserEntity = systemAdminUserService.findById(systemAdminUserEntity.getId());

			Assertions.assertTrue(fetchedSystemAdminUserEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedSystemAdminUserEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(systemAdminUserEntity, fetchedSystemAdminUserEntity.get());
		});
	}

	@Test
	public void whenUpdateSystemAdminUserEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			SystemAdminUserEntity systemAdminUserEntity;
			SystemAdminUserEntity updatedSystemAdminUserEntity;
			Optional<SystemAdminUserEntity> fetchedSystemAdminUserEntity;

			try {
				systemAdminUserEntity = systemAdminUserFactory.getObject(false, false);
				systemAdminUserDatabasePopulator.populateRelatedEntitiesInDatabase(systemAdminUserEntity, true, true, false);
				updatedSystemAdminUserEntity = systemAdminUserFactory.getObject(false, false);
				systemAdminUserDatabasePopulator.populateRelatedEntitiesInDatabase(updatedSystemAdminUserEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			systemAdminUserEntity = systemAdminUserService.create(systemAdminUserEntity);

			updatedSystemAdminUserEntity.setId(systemAdminUserEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedSystemAdminUserEntity.setCreated(systemAdminUserEntity.getCreated());

			updatedSystemAdminUserEntity = systemAdminUserService.update(updatedSystemAdminUserEntity);

			fetchedSystemAdminUserEntity = systemAdminUserService.findById(systemAdminUserEntity.getId());

			Assertions.assertTrue(fetchedSystemAdminUserEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateSystemAdminUserEntity_ThenEntityIsCreated
			fetchedSystemAdminUserEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedSystemAdminUserEntity, fetchedSystemAdminUserEntity.get());
		});
	}

	@Test
	public void whenDeleteSystemAdminUserEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			SystemAdminUserEntity systemAdminUserEntity;
			Optional<SystemAdminUserEntity> fetchedSystemAdminUserEntity;

			try {
				systemAdminUserEntity = systemAdminUserFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				systemAdminUserDatabasePopulator.populateRelatedEntitiesInDatabase(systemAdminUserEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			systemAdminUserEntity = systemAdminUserService.create(systemAdminUserEntity);

			systemAdminUserService.deleteById(systemAdminUserEntity.getId());
			fetchedSystemAdminUserEntity = systemAdminUserService.findById(systemAdminUserEntity.getId());

			Assertions.assertTrue(fetchedSystemAdminUserEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}