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
import kmsweb.entities.McuPackageEntity;
import kmsweb.repositories.McuPackageRepository;
import kmsweb.utils.McuPackageFactory;
import kmsweb.utils.DatabasePopulators.McuPackageDatabasePopulator;
import kmsweb.entities.McuPackageItemEntity;
import kmsweb.repositories.McuPackageItemRepository;
import kmsweb.utils.McuPackageItemFactory;
import kmsweb.utils.DatabasePopulators.McuPackageItemDatabasePopulator;
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
public class McuPackageServiceIntegrationTest {

	@Autowired
	private McuPackageRepository mcuPackageRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private McuPackageService mcuPackageService;

	private final McuPackageFactory mcuPackageFactory = new McuPackageFactory();

	@Autowired
	private McuPackageDatabasePopulator mcuPackageDatabasePopulator;

	@Autowired
	private McuPackageItemRepository mcuPackageItemRepository;

	@Autowired
	private McuPackageItemDatabasePopulator mcuPackageItemDatabasePopulator;

	private final McuPackageItemFactory mcuPackageItemFactory = new McuPackageItemFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		mcuPackageService = new McuPackageService(
			mcuPackageItemRepository,
			validator,
			auditRepository,
			mcuPackageRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMcuPackageEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		McuPackageEntity mcuPackageEntity = mcuPackageFactory.getObject(false, false);

		McuPackageEntity updatedEntity = mcuPackageService.updateOldData(mcuPackageEntity);
		Assertions.assertEquals(mcuPackageEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingMcuPackageEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageEntity mcuPackageEntity;
			McuPackageEntity entityWithUpdatedValues;

			try {
				mcuPackageEntity = mcuPackageFactory.getObject(false, false);
				mcuPackageDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = mcuPackageFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			mcuPackageEntity = mcuPackageService.create(mcuPackageEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(mcuPackageEntity.getId());

			McuPackageEntity updatedEntity = mcuPackageService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMcuPackageEntityWithNonExistentId_ShouldThrowException() throws Exception {
		McuPackageEntity mcuPackageEntity = mcuPackageFactory.getObject(false, false);
		mcuPackageEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			mcuPackageService.updateOldData(mcuPackageEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMcuPackageEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageEntity mcuPackageEntity;
			McuPackageEntity updatedMcuPackageEntity;

			Set<McuPackageItemEntity> mcuPackageItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				mcuPackageEntity = mcuPackageFactory.getObject(true, false);
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
			mcuPackageItemsEntities = mcuPackageEntity.getMcuPackageItems();
			Set<UUID> mcuPackageItemsEntityIds = new HashSet<>();
			for (McuPackageItemEntity entity : mcuPackageItemsEntities) {
				try {
					mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				mcuPackageItemsEntityIds.add(mcuPackageItemRepository.save(entity).getId());
			}
			mcuPackageEntity.setMcuPackageItemsIds(mcuPackageItemsEntityIds);


			mcuPackageEntity = mcuPackageService.create(mcuPackageEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(mcuPackageEntity.getMcuPackageItems().size() > 0);
			mcuPackageEntity.setMcuPackageItemsIds(new HashSet<UUID>());
			mcuPackageEntity.unsetMcuPackageItems();


			updatedMcuPackageEntity = mcuPackageService.updateOldData(mcuPackageEntity);

			Assertions.assertEquals(0, updatedMcuPackageEntity.getMcuPackageItems().size());

		});
	}

	@Test
	public void updateOldDataWithMcuPackageEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageEntity mcuPackageEntity;
			McuPackageEntity updatedMcuPackageEntity;

			Set<McuPackageItemEntity> mcuPackageItemsEntities;
			Set<UUID> mcuPackageItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				mcuPackageEntity = mcuPackageFactory.getObject(true, false);
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
			mcuPackageItemsEntities = new HashSet<>();
			mcuPackageItemsEntityIds = new HashSet<>();
			for (McuPackageItemEntity entity : mcuPackageEntity.getMcuPackageItems()) {
				try {
					mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the MCU Package Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = mcuPackageItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				mcuPackageItemsEntities.add(mcuPackageItemRepository.findById(id).get());
				mcuPackageItemsEntityIds.add(id);
			}
			mcuPackageEntity.unsetMcuPackageItems();
			mcuPackageEntity.setMcuPackageItemsIds(mcuPackageItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMcuPackageEntity = mcuPackageService.updateOldData(mcuPackageEntity);

			Assertions.assertEquals(mcuPackageItemsEntities.size(), updatedMcuPackageEntity.getMcuPackageItems().size());

		});
	}

	@Test
	public void whenCreateMcuPackageEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageEntity mcuPackageEntity;
			Optional<McuPackageEntity> fetchedMcuPackageEntity;

			try {
				mcuPackageEntity = mcuPackageFactory.getObject(false, false);
				mcuPackageDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			mcuPackageEntity = mcuPackageService.create(mcuPackageEntity);

			fetchedMcuPackageEntity = mcuPackageService.findById(mcuPackageEntity.getId());

			Assertions.assertTrue(fetchedMcuPackageEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMcuPackageEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(mcuPackageEntity, fetchedMcuPackageEntity.get());
		});
	}

	@Test
	public void whenUpdateMcuPackageEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageEntity mcuPackageEntity;
			McuPackageEntity updatedMcuPackageEntity;
			Optional<McuPackageEntity> fetchedMcuPackageEntity;

			try {
				mcuPackageEntity = mcuPackageFactory.getObject(false, false);
				mcuPackageDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageEntity, true, true, false);
				updatedMcuPackageEntity = mcuPackageFactory.getObject(false, false);
				mcuPackageDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMcuPackageEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			mcuPackageEntity = mcuPackageService.create(mcuPackageEntity);

			updatedMcuPackageEntity.setId(mcuPackageEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMcuPackageEntity.setCreated(mcuPackageEntity.getCreated());

			updatedMcuPackageEntity = mcuPackageService.update(updatedMcuPackageEntity);

			fetchedMcuPackageEntity = mcuPackageService.findById(mcuPackageEntity.getId());

			Assertions.assertTrue(fetchedMcuPackageEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMcuPackageEntity_ThenEntityIsCreated
			fetchedMcuPackageEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMcuPackageEntity, fetchedMcuPackageEntity.get());
		});
	}

	@Test
	public void whenDeleteMcuPackageEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageEntity mcuPackageEntity;
			Optional<McuPackageEntity> fetchedMcuPackageEntity;

			try {
				mcuPackageEntity = mcuPackageFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				mcuPackageDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			mcuPackageEntity = mcuPackageService.create(mcuPackageEntity);

			mcuPackageService.deleteById(mcuPackageEntity.getId());
			fetchedMcuPackageEntity = mcuPackageService.findById(mcuPackageEntity.getId());

			Assertions.assertTrue(fetchedMcuPackageEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}