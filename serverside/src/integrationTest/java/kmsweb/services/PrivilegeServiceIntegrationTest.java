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
import kmsweb.entities.PrivilegeEntity;
import kmsweb.repositories.PrivilegeRepository;
import kmsweb.utils.PrivilegeFactory;
import kmsweb.utils.DatabasePopulators.PrivilegeDatabasePopulator;
import kmsweb.entities.RoleEntity;
import kmsweb.repositories.RoleRepository;
import kmsweb.utils.RoleFactory;
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
public class PrivilegeServiceIntegrationTest {

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PrivilegeService privilegeService;

	private final PrivilegeFactory privilegeFactory = new PrivilegeFactory();

	@Autowired
	private PrivilegeDatabasePopulator privilegeDatabasePopulator;

	@Autowired
	private RoleRepository roleRepository;

	private final RoleFactory roleFactory = new RoleFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		privilegeService = new PrivilegeService(
			roleRepository,
			validator,
			auditRepository,
			privilegeRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPrivilegeEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PrivilegeEntity privilegeEntity = privilegeFactory.getObject(false, false);

		PrivilegeEntity updatedEntity = privilegeService.updateOldData(privilegeEntity);
		Assertions.assertEquals(privilegeEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewPrivilegeEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		PrivilegeEntity privilegeEntity = privilegeFactory.getObject(false, false);

		privilegeEntity.setAllowCreate(null);
		Assertions.assertNull(privilegeEntity.getAllowCreate());

		privilegeEntity.setAllowRead(null);
		Assertions.assertNull(privilegeEntity.getAllowRead());

		privilegeEntity.setAllowUpdate(null);
		Assertions.assertNull(privilegeEntity.getAllowUpdate());

		privilegeEntity.setAllowDelete(null);
		Assertions.assertNull(privilegeEntity.getAllowDelete());


		PrivilegeEntity updatedEntity = privilegeService.updateOldData(privilegeEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getAllowCreate());
		Assertions.assertFalse(updatedEntity.getAllowCreate());

		Assertions.assertNotNull(updatedEntity.getAllowRead());
		Assertions.assertFalse(updatedEntity.getAllowRead());

		Assertions.assertNotNull(updatedEntity.getAllowUpdate());
		Assertions.assertFalse(updatedEntity.getAllowUpdate());

		Assertions.assertNotNull(updatedEntity.getAllowDelete());
		Assertions.assertFalse(updatedEntity.getAllowDelete());

	}

	@Test
	public void updateOldDataWithExistingPrivilegeEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PrivilegeEntity privilegeEntity;
			PrivilegeEntity entityWithUpdatedValues;

			try {
				privilegeEntity = privilegeFactory.getObject(false, false);
				privilegeDatabasePopulator.populateRelatedEntitiesInDatabase(privilegeEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = privilegeFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			privilegeEntity = privilegeService.create(privilegeEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(privilegeEntity.getId());

			PrivilegeEntity updatedEntity = privilegeService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPrivilegeEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PrivilegeEntity privilegeEntity = privilegeFactory.getObject(false, false);
		privilegeEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			privilegeService.updateOldData(privilegeEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPrivilegeEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PrivilegeEntity privilegeEntity;
			PrivilegeEntity updatedPrivilegeEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				privilegeEntity = privilegeFactory.getObject(true, false);
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
			List<RoleEntity> rolesEntities = (List<RoleEntity>) roleRepository.saveAll(privilegeEntity.getRoles());
			privilegeEntity.setRolesIds(rolesEntities.stream().map(RoleEntity::getId).collect(Collectors.toSet()));

			privilegeEntity = privilegeService.create(privilegeEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(privilegeEntity.getRoles().size() > 0);
			privilegeEntity.setRolesIds(new HashSet<UUID>());
			privilegeEntity.unsetRoles();


			updatedPrivilegeEntity = privilegeService.updateOldData(privilegeEntity);

			Assertions.assertEquals(0, updatedPrivilegeEntity.getRoles().size());

		});
	}

	@Test
	public void updateOldDataWithPrivilegeEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PrivilegeEntity privilegeEntity;
			PrivilegeEntity updatedPrivilegeEntity;

			List<RoleEntity> rolesEntities;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				privilegeEntity = privilegeFactory.getObject(true, false);
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
			rolesEntities = (List<RoleEntity>) roleRepository.saveAll(privilegeEntity.getRoles());
			privilegeEntity.unsetRoles();
			privilegeEntity.setRolesIds(rolesEntities.stream().map(RoleEntity::getId).collect(Collectors.toSet()));

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPrivilegeEntity = privilegeService.updateOldData(privilegeEntity);

			Assertions.assertEquals(rolesEntities.size(), updatedPrivilegeEntity.getRoles().size());

		});
	}

	@Test
	public void whenCreatePrivilegeEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PrivilegeEntity privilegeEntity;
			Optional<PrivilegeEntity> fetchedPrivilegeEntity;

			try {
				privilegeEntity = privilegeFactory.getObject(false, false);
				privilegeDatabasePopulator.populateRelatedEntitiesInDatabase(privilegeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			privilegeEntity = privilegeService.create(privilegeEntity);

			fetchedPrivilegeEntity = privilegeService.findById(privilegeEntity.getId());

			Assertions.assertTrue(fetchedPrivilegeEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPrivilegeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(privilegeEntity, fetchedPrivilegeEntity.get());
		});
	}

	@Test
	public void whenUpdatePrivilegeEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PrivilegeEntity privilegeEntity;
			PrivilegeEntity updatedPrivilegeEntity;
			Optional<PrivilegeEntity> fetchedPrivilegeEntity;

			try {
				privilegeEntity = privilegeFactory.getObject(false, false);
				privilegeDatabasePopulator.populateRelatedEntitiesInDatabase(privilegeEntity, true, true, false);
				updatedPrivilegeEntity = privilegeFactory.getObject(false, false);
				privilegeDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPrivilegeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			privilegeEntity = privilegeService.create(privilegeEntity);

			updatedPrivilegeEntity.setId(privilegeEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPrivilegeEntity.setCreated(privilegeEntity.getCreated());

			updatedPrivilegeEntity = privilegeService.update(updatedPrivilegeEntity);

			fetchedPrivilegeEntity = privilegeService.findById(privilegeEntity.getId());

			Assertions.assertTrue(fetchedPrivilegeEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePrivilegeEntity_ThenEntityIsCreated
			fetchedPrivilegeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPrivilegeEntity, fetchedPrivilegeEntity.get());
		});
	}

	@Test
	public void whenDeletePrivilegeEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PrivilegeEntity privilegeEntity;
			Optional<PrivilegeEntity> fetchedPrivilegeEntity;

			try {
				privilegeEntity = privilegeFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				privilegeDatabasePopulator.populateRelatedEntitiesInDatabase(privilegeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			privilegeEntity = privilegeService.create(privilegeEntity);

			privilegeService.deleteById(privilegeEntity.getId());
			fetchedPrivilegeEntity = privilegeService.findById(privilegeEntity.getId());

			Assertions.assertTrue(fetchedPrivilegeEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
