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
import kmsweb.entities.ExaminationGroupEntity;
import kmsweb.repositories.ExaminationGroupRepository;
import kmsweb.utils.ExaminationGroupFactory;
import kmsweb.utils.DatabasePopulators.ExaminationGroupDatabasePopulator;
import kmsweb.entities.ExaminationItemEntity;
import kmsweb.repositories.ExaminationItemRepository;
import kmsweb.utils.ExaminationItemFactory;
import kmsweb.utils.DatabasePopulators.ExaminationItemDatabasePopulator;
import kmsweb.entities.ServiceEntity;
import kmsweb.repositories.ServiceRepository;
import kmsweb.utils.ServiceFactory;
import kmsweb.utils.DatabasePopulators.ServiceDatabasePopulator;
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
public class ExaminationGroupServiceIntegrationTest {

	@Autowired
	private ExaminationGroupRepository examinationGroupRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private ExaminationGroupService examinationGroupService;

	private final ExaminationGroupFactory examinationGroupFactory = new ExaminationGroupFactory();

	@Autowired
	private ExaminationGroupDatabasePopulator examinationGroupDatabasePopulator;

	@Autowired
	private ExaminationItemRepository examinationItemRepository;

	@Autowired
	private ExaminationItemDatabasePopulator examinationItemDatabasePopulator;

	private final ExaminationItemFactory examinationItemFactory = new ExaminationItemFactory();

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ServiceDatabasePopulator serviceDatabasePopulator;

	private final ServiceFactory serviceFactory = new ServiceFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		examinationGroupService = new ExaminationGroupService(
			examinationItemRepository,
			serviceRepository,
			validator,
			auditRepository,
			examinationGroupRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewExaminationGroupEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		ExaminationGroupEntity examinationGroupEntity = examinationGroupFactory.getObject(false, false);

		ExaminationGroupEntity updatedEntity = examinationGroupService.updateOldData(examinationGroupEntity);
		Assertions.assertEquals(examinationGroupEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingExaminationGroupEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationGroupEntity examinationGroupEntity;
			ExaminationGroupEntity entityWithUpdatedValues;

			try {
				examinationGroupEntity = examinationGroupFactory.getObject(false, false);
				examinationGroupDatabasePopulator.populateRelatedEntitiesInDatabase(examinationGroupEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = examinationGroupFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationGroupEntity = examinationGroupService.create(examinationGroupEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(examinationGroupEntity.getId());

			ExaminationGroupEntity updatedEntity = examinationGroupService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithExaminationGroupEntityWithNonExistentId_ShouldThrowException() throws Exception {
		ExaminationGroupEntity examinationGroupEntity = examinationGroupFactory.getObject(false, false);
		examinationGroupEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			examinationGroupService.updateOldData(examinationGroupEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingExaminationGroupEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationGroupEntity examinationGroupEntity;
			ExaminationGroupEntity updatedExaminationGroupEntity;

			ServiceEntity serviceEntity;

			Set<ExaminationItemEntity> examinationItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				examinationGroupEntity = examinationGroupFactory.getObject(true, false);
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
			serviceEntity = examinationGroupEntity.getService();
			try {
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			serviceEntity = serviceRepository.save(serviceEntity);
			examinationGroupEntity.setServiceId(serviceEntity.getId());

			examinationItemsEntities = examinationGroupEntity.getExaminationItems();
			Set<UUID> examinationItemsEntityIds = new HashSet<>();
			for (ExaminationItemEntity entity : examinationItemsEntities) {
				try {
					examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				examinationItemsEntityIds.add(examinationItemRepository.save(entity).getId());
			}
			examinationGroupEntity.setExaminationItemsIds(examinationItemsEntityIds);


			examinationGroupEntity = examinationGroupService.create(examinationGroupEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(examinationGroupEntity.getService());
			examinationGroupEntity.setServiceId(null);
			examinationGroupEntity.unsetService();

			Assertions.assertTrue(examinationGroupEntity.getExaminationItems().size() > 0);
			examinationGroupEntity.setExaminationItemsIds(new HashSet<UUID>());
			examinationGroupEntity.unsetExaminationItems();


			updatedExaminationGroupEntity = examinationGroupService.updateOldData(examinationGroupEntity);

			Assertions.assertNull(updatedExaminationGroupEntity.getService());

			Assertions.assertEquals(0, updatedExaminationGroupEntity.getExaminationItems().size());

		});
	}

	@Test
	public void updateOldDataWithExaminationGroupEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationGroupEntity examinationGroupEntity;
			ExaminationGroupEntity updatedExaminationGroupEntity;

			ServiceEntity serviceEntity;

			Set<ExaminationItemEntity> examinationItemsEntities;
			Set<UUID> examinationItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				examinationGroupEntity = examinationGroupFactory.getObject(true, false);
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
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(examinationGroupEntity.getService(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Service relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			serviceEntity = serviceRepository.findById(serviceRepository.save(examinationGroupEntity.getService()).getId()).get();
			examinationGroupEntity.unsetService();
			examinationGroupEntity.setServiceId(serviceEntity.getId());

			examinationItemsEntities = new HashSet<>();
			examinationItemsEntityIds = new HashSet<>();
			for (ExaminationItemEntity entity : examinationGroupEntity.getExaminationItems()) {
				try {
					examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Examination Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = examinationItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				examinationItemsEntities.add(examinationItemRepository.findById(id).get());
				examinationItemsEntityIds.add(id);
			}
			examinationGroupEntity.unsetExaminationItems();
			examinationGroupEntity.setExaminationItemsIds(examinationItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedExaminationGroupEntity = examinationGroupService.updateOldData(examinationGroupEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			serviceEntity.unsetExaminationGroups(false);
			updatedExaminationGroupEntity.getService().unsetExaminationGroups(false);
			Assertions.assertEquals(serviceEntity, updatedExaminationGroupEntity.getService());

			Assertions.assertEquals(examinationItemsEntities.size(), updatedExaminationGroupEntity.getExaminationItems().size());

		});
	}

	@Test
	public void whenCreateExaminationGroupEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationGroupEntity examinationGroupEntity;
			Optional<ExaminationGroupEntity> fetchedExaminationGroupEntity;

			try {
				examinationGroupEntity = examinationGroupFactory.getObject(false, false);
				examinationGroupDatabasePopulator.populateRelatedEntitiesInDatabase(examinationGroupEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationGroupEntity = examinationGroupService.create(examinationGroupEntity);

			fetchedExaminationGroupEntity = examinationGroupService.findById(examinationGroupEntity.getId());

			Assertions.assertTrue(fetchedExaminationGroupEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedExaminationGroupEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(examinationGroupEntity, fetchedExaminationGroupEntity.get());
		});
	}

	@Test
	public void whenUpdateExaminationGroupEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationGroupEntity examinationGroupEntity;
			ExaminationGroupEntity updatedExaminationGroupEntity;
			Optional<ExaminationGroupEntity> fetchedExaminationGroupEntity;

			try {
				examinationGroupEntity = examinationGroupFactory.getObject(false, false);
				examinationGroupDatabasePopulator.populateRelatedEntitiesInDatabase(examinationGroupEntity, true, true, false);
				updatedExaminationGroupEntity = examinationGroupFactory.getObject(false, false);
				examinationGroupDatabasePopulator.populateRelatedEntitiesInDatabase(updatedExaminationGroupEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationGroupEntity = examinationGroupService.create(examinationGroupEntity);

			updatedExaminationGroupEntity.setId(examinationGroupEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedExaminationGroupEntity.setCreated(examinationGroupEntity.getCreated());

			updatedExaminationGroupEntity = examinationGroupService.update(updatedExaminationGroupEntity);

			fetchedExaminationGroupEntity = examinationGroupService.findById(examinationGroupEntity.getId());

			Assertions.assertTrue(fetchedExaminationGroupEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateExaminationGroupEntity_ThenEntityIsCreated
			fetchedExaminationGroupEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedExaminationGroupEntity, fetchedExaminationGroupEntity.get());
		});
	}

	@Test
	public void whenDeleteExaminationGroupEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationGroupEntity examinationGroupEntity;
			Optional<ExaminationGroupEntity> fetchedExaminationGroupEntity;

			try {
				examinationGroupEntity = examinationGroupFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				examinationGroupDatabasePopulator.populateRelatedEntitiesInDatabase(examinationGroupEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationGroupEntity = examinationGroupService.create(examinationGroupEntity);

			examinationGroupService.deleteById(examinationGroupEntity.getId());
			fetchedExaminationGroupEntity = examinationGroupService.findById(examinationGroupEntity.getId());

			Assertions.assertTrue(fetchedExaminationGroupEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
