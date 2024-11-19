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
import kmsweb.entities.RegistrationUserEntity;
import kmsweb.repositories.RegistrationUserRepository;
import kmsweb.utils.RegistrationUserFactory;
import kmsweb.utils.DatabasePopulators.RegistrationUserDatabasePopulator;
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
public class RegistrationUserServiceIntegrationTest {

	@Autowired
	private RegistrationUserRepository registrationUserRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	@Autowired
	private RoleService roleService;

	@Autowired
	PasswordEncoder passwordEncoder;

	// Not autowired as we instantiate this in beforeEach
	private RegistrationUserService registrationUserService;

	private final RegistrationUserFactory registrationUserFactory = new RegistrationUserFactory();

	@Autowired
	private RegistrationUserDatabasePopulator registrationUserDatabasePopulator;

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
		registrationUserService = new RegistrationUserService(
			roleService,
			passwordEncoder,
			staffRepository,
			validator,
			auditRepository,
			registrationUserRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewRegistrationUserEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		RegistrationUserEntity registrationUserEntity = registrationUserFactory.getObject(false, false);

		RegistrationUserEntity updatedEntity = registrationUserService.updateOldData(registrationUserEntity);
		Assertions.assertEquals(registrationUserEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingRegistrationUserEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationUserEntity registrationUserEntity;
			RegistrationUserEntity entityWithUpdatedValues;

			try {
				registrationUserEntity = registrationUserFactory.getObject(false, false);
				registrationUserDatabasePopulator.populateRelatedEntitiesInDatabase(registrationUserEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = registrationUserFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			registrationUserEntity = registrationUserService.create(registrationUserEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(registrationUserEntity.getId());

			RegistrationUserEntity updatedEntity = registrationUserService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithRegistrationUserEntityWithNonExistentId_ShouldThrowException() throws Exception {
		RegistrationUserEntity registrationUserEntity = registrationUserFactory.getObject(false, false);
		registrationUserEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			registrationUserService.updateOldData(registrationUserEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingRegistrationUserEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationUserEntity registrationUserEntity;
			RegistrationUserEntity updatedRegistrationUserEntity;

			StaffEntity staffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				registrationUserEntity = registrationUserFactory.getObject(true, false);
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
			staffEntity = registrationUserEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			registrationUserEntity.setStaffId(staffEntity.getId());


			registrationUserEntity = registrationUserService.create(registrationUserEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(registrationUserEntity.getStaff());
			registrationUserEntity.setStaffId(null);
			registrationUserEntity.unsetStaff();


			updatedRegistrationUserEntity = registrationUserService.updateOldData(registrationUserEntity);

			Assertions.assertNull(updatedRegistrationUserEntity.getStaff());

		});
	}

	@Test
	public void updateOldDataWithRegistrationUserEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationUserEntity registrationUserEntity;
			RegistrationUserEntity updatedRegistrationUserEntity;

			StaffEntity staffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				registrationUserEntity = registrationUserFactory.getObject(true, false);
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
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(registrationUserEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(registrationUserEntity.getStaff()).getId()).get();
			registrationUserEntity.unsetStaff();
			registrationUserEntity.setStaffId(staffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedRegistrationUserEntity = registrationUserService.updateOldData(registrationUserEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			staffEntity.unsetRegistrationUser(false);
			updatedRegistrationUserEntity.getStaff().unsetRegistrationUser(false);
			Assertions.assertEquals(staffEntity, updatedRegistrationUserEntity.getStaff());

		});
	}

	@Test
	public void whenCreateRegistrationUserEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationUserEntity registrationUserEntity;
			Optional<RegistrationUserEntity> fetchedRegistrationUserEntity;

			try {
				registrationUserEntity = registrationUserFactory.getObject(false, false);
				registrationUserDatabasePopulator.populateRelatedEntitiesInDatabase(registrationUserEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			registrationUserEntity = registrationUserService.create(registrationUserEntity);

			fetchedRegistrationUserEntity = registrationUserService.findById(registrationUserEntity.getId());

			Assertions.assertTrue(fetchedRegistrationUserEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedRegistrationUserEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(registrationUserEntity, fetchedRegistrationUserEntity.get());
		});
	}

	@Test
	public void whenUpdateRegistrationUserEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationUserEntity registrationUserEntity;
			RegistrationUserEntity updatedRegistrationUserEntity;
			Optional<RegistrationUserEntity> fetchedRegistrationUserEntity;

			try {
				registrationUserEntity = registrationUserFactory.getObject(false, false);
				registrationUserDatabasePopulator.populateRelatedEntitiesInDatabase(registrationUserEntity, true, true, false);
				updatedRegistrationUserEntity = registrationUserFactory.getObject(false, false);
				registrationUserDatabasePopulator.populateRelatedEntitiesInDatabase(updatedRegistrationUserEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			registrationUserEntity = registrationUserService.create(registrationUserEntity);

			updatedRegistrationUserEntity.setId(registrationUserEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedRegistrationUserEntity.setCreated(registrationUserEntity.getCreated());

			updatedRegistrationUserEntity = registrationUserService.update(updatedRegistrationUserEntity);

			fetchedRegistrationUserEntity = registrationUserService.findById(registrationUserEntity.getId());

			Assertions.assertTrue(fetchedRegistrationUserEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateRegistrationUserEntity_ThenEntityIsCreated
			fetchedRegistrationUserEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedRegistrationUserEntity, fetchedRegistrationUserEntity.get());
		});
	}

	@Test
	public void whenDeleteRegistrationUserEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			RegistrationUserEntity registrationUserEntity;
			Optional<RegistrationUserEntity> fetchedRegistrationUserEntity;

			try {
				registrationUserEntity = registrationUserFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				registrationUserDatabasePopulator.populateRelatedEntitiesInDatabase(registrationUserEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			registrationUserEntity = registrationUserService.create(registrationUserEntity);

			registrationUserService.deleteById(registrationUserEntity.getId());
			fetchedRegistrationUserEntity = registrationUserService.findById(registrationUserEntity.getId());

			Assertions.assertTrue(fetchedRegistrationUserEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
