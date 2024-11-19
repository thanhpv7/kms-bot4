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
import kmsweb.entities.InventoryBatchCorrectionEntity;
import kmsweb.repositories.InventoryBatchCorrectionRepository;
import kmsweb.utils.InventoryBatchCorrectionFactory;
import kmsweb.utils.DatabasePopulators.InventoryBatchCorrectionDatabasePopulator;
import kmsweb.entities.InventoryBatchCorrectionItemEntity;
import kmsweb.repositories.InventoryBatchCorrectionItemRepository;
import kmsweb.utils.InventoryBatchCorrectionItemFactory;
import kmsweb.utils.DatabasePopulators.InventoryBatchCorrectionItemDatabasePopulator;
import kmsweb.entities.WarehouseEntity;
import kmsweb.repositories.WarehouseRepository;
import kmsweb.utils.WarehouseFactory;
import kmsweb.utils.DatabasePopulators.WarehouseDatabasePopulator;
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
public class InventoryBatchCorrectionServiceIntegrationTest {

	@Autowired
	private InventoryBatchCorrectionRepository inventoryBatchCorrectionRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InventoryBatchCorrectionService inventoryBatchCorrectionService;

	private final InventoryBatchCorrectionFactory inventoryBatchCorrectionFactory = new InventoryBatchCorrectionFactory();

	@Autowired
	private InventoryBatchCorrectionDatabasePopulator inventoryBatchCorrectionDatabasePopulator;

	@Autowired
	private InventoryBatchCorrectionItemRepository inventoryBatchCorrectionItemRepository;

	@Autowired
	private InventoryBatchCorrectionItemDatabasePopulator inventoryBatchCorrectionItemDatabasePopulator;

	private final InventoryBatchCorrectionItemFactory inventoryBatchCorrectionItemFactory = new InventoryBatchCorrectionItemFactory();

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private WarehouseDatabasePopulator warehouseDatabasePopulator;

	private final WarehouseFactory warehouseFactory = new WarehouseFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		inventoryBatchCorrectionService = new InventoryBatchCorrectionService(
			inventoryBatchCorrectionItemRepository,
			warehouseRepository,
			validator,
			auditRepository,
			inventoryBatchCorrectionRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInventoryBatchCorrectionEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InventoryBatchCorrectionEntity inventoryBatchCorrectionEntity = inventoryBatchCorrectionFactory.getObject(false, false);

		InventoryBatchCorrectionEntity updatedEntity = inventoryBatchCorrectionService.updateOldData(inventoryBatchCorrectionEntity);
		Assertions.assertEquals(inventoryBatchCorrectionEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingInventoryBatchCorrectionEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionEntity inventoryBatchCorrectionEntity;
			InventoryBatchCorrectionEntity entityWithUpdatedValues;

			try {
				inventoryBatchCorrectionEntity = inventoryBatchCorrectionFactory.getObject(false, false);
				inventoryBatchCorrectionDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = inventoryBatchCorrectionFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryBatchCorrectionEntity = inventoryBatchCorrectionService.create(inventoryBatchCorrectionEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(inventoryBatchCorrectionEntity.getId());

			InventoryBatchCorrectionEntity updatedEntity = inventoryBatchCorrectionService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInventoryBatchCorrectionEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InventoryBatchCorrectionEntity inventoryBatchCorrectionEntity = inventoryBatchCorrectionFactory.getObject(false, false);
		inventoryBatchCorrectionEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			inventoryBatchCorrectionService.updateOldData(inventoryBatchCorrectionEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInventoryBatchCorrectionEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionEntity inventoryBatchCorrectionEntity;
			InventoryBatchCorrectionEntity updatedInventoryBatchCorrectionEntity;

			WarehouseEntity warehouseEntity;

			Set<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				inventoryBatchCorrectionEntity = inventoryBatchCorrectionFactory.getObject(true, false);
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
			warehouseEntity = inventoryBatchCorrectionEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			inventoryBatchCorrectionEntity.setWarehouseId(warehouseEntity.getId());

			inventoryBatchCorrectionItemsEntities = inventoryBatchCorrectionEntity.getInventoryBatchCorrectionItems();
			Set<UUID> inventoryBatchCorrectionItemsEntityIds = new HashSet<>();
			for (InventoryBatchCorrectionItemEntity entity : inventoryBatchCorrectionItemsEntities) {
				try {
					inventoryBatchCorrectionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				inventoryBatchCorrectionItemsEntityIds.add(inventoryBatchCorrectionItemRepository.save(entity).getId());
			}
			inventoryBatchCorrectionEntity.setInventoryBatchCorrectionItemsIds(inventoryBatchCorrectionItemsEntityIds);


			inventoryBatchCorrectionEntity = inventoryBatchCorrectionService.create(inventoryBatchCorrectionEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(inventoryBatchCorrectionEntity.getWarehouse());
			inventoryBatchCorrectionEntity.setWarehouseId(null);
			inventoryBatchCorrectionEntity.unsetWarehouse();

			Assertions.assertTrue(inventoryBatchCorrectionEntity.getInventoryBatchCorrectionItems().size() > 0);
			inventoryBatchCorrectionEntity.setInventoryBatchCorrectionItemsIds(new HashSet<UUID>());
			inventoryBatchCorrectionEntity.unsetInventoryBatchCorrectionItems();


			updatedInventoryBatchCorrectionEntity = inventoryBatchCorrectionService.updateOldData(inventoryBatchCorrectionEntity);

			Assertions.assertNull(updatedInventoryBatchCorrectionEntity.getWarehouse());

			Assertions.assertEquals(0, updatedInventoryBatchCorrectionEntity.getInventoryBatchCorrectionItems().size());

		});
	}

	@Test
	public void updateOldDataWithInventoryBatchCorrectionEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionEntity inventoryBatchCorrectionEntity;
			InventoryBatchCorrectionEntity updatedInventoryBatchCorrectionEntity;

			WarehouseEntity warehouseEntity;

			Set<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItemsEntities;
			Set<UUID> inventoryBatchCorrectionItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				inventoryBatchCorrectionEntity = inventoryBatchCorrectionFactory.getObject(true, false);
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
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(inventoryBatchCorrectionEntity.getWarehouse()).getId()).get();
			inventoryBatchCorrectionEntity.unsetWarehouse();
			inventoryBatchCorrectionEntity.setWarehouseId(warehouseEntity.getId());

			inventoryBatchCorrectionItemsEntities = new HashSet<>();
			inventoryBatchCorrectionItemsEntityIds = new HashSet<>();
			for (InventoryBatchCorrectionItemEntity entity : inventoryBatchCorrectionEntity.getInventoryBatchCorrectionItems()) {
				try {
					inventoryBatchCorrectionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Inventory Batch Correction Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = inventoryBatchCorrectionItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				inventoryBatchCorrectionItemsEntities.add(inventoryBatchCorrectionItemRepository.findById(id).get());
				inventoryBatchCorrectionItemsEntityIds.add(id);
			}
			inventoryBatchCorrectionEntity.unsetInventoryBatchCorrectionItems();
			inventoryBatchCorrectionEntity.setInventoryBatchCorrectionItemsIds(inventoryBatchCorrectionItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInventoryBatchCorrectionEntity = inventoryBatchCorrectionService.updateOldData(inventoryBatchCorrectionEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			warehouseEntity.unsetInventoryBatchCorrections(false);
			updatedInventoryBatchCorrectionEntity.getWarehouse().unsetInventoryBatchCorrections(false);
			Assertions.assertEquals(warehouseEntity, updatedInventoryBatchCorrectionEntity.getWarehouse());

			Assertions.assertEquals(inventoryBatchCorrectionItemsEntities.size(), updatedInventoryBatchCorrectionEntity.getInventoryBatchCorrectionItems().size());

		});
	}

	@Test
	public void whenCreateInventoryBatchCorrectionEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionEntity inventoryBatchCorrectionEntity;
			Optional<InventoryBatchCorrectionEntity> fetchedInventoryBatchCorrectionEntity;

			try {
				inventoryBatchCorrectionEntity = inventoryBatchCorrectionFactory.getObject(false, false);
				inventoryBatchCorrectionDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryBatchCorrectionEntity = inventoryBatchCorrectionService.create(inventoryBatchCorrectionEntity);

			Optional<WarehouseEntity> relatedWarehouseOptional = warehouseRepository.findById(inventoryBatchCorrectionEntity.getWarehouseId());
			assert relatedWarehouseOptional.isPresent();
			WarehouseEntity relatedWarehouse = relatedWarehouseOptional.get();
			// Required related entity has to be created without a reference to this parent entity as it doesn't exist yet.
			// Therefore we need to update the related entity to reference our parent entity for the later checks
			relatedWarehouse.setInventoryBatchCorrections(Collections.singletonList(inventoryBatchCorrectionEntity));
			warehouseRepository.save(relatedWarehouse);

			fetchedInventoryBatchCorrectionEntity = inventoryBatchCorrectionService.findById(inventoryBatchCorrectionEntity.getId());

			Assertions.assertTrue(fetchedInventoryBatchCorrectionEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInventoryBatchCorrectionEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(inventoryBatchCorrectionEntity, fetchedInventoryBatchCorrectionEntity.get());
		});
	}

	@Test
	public void whenUpdateInventoryBatchCorrectionEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionEntity inventoryBatchCorrectionEntity;
			InventoryBatchCorrectionEntity updatedInventoryBatchCorrectionEntity;
			Optional<InventoryBatchCorrectionEntity> fetchedInventoryBatchCorrectionEntity;

			try {
				inventoryBatchCorrectionEntity = inventoryBatchCorrectionFactory.getObject(false, false);
				inventoryBatchCorrectionDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionEntity, true, true, false);
				updatedInventoryBatchCorrectionEntity = inventoryBatchCorrectionFactory.getObject(false, false);
				inventoryBatchCorrectionDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInventoryBatchCorrectionEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryBatchCorrectionEntity = inventoryBatchCorrectionService.create(inventoryBatchCorrectionEntity);

			updatedInventoryBatchCorrectionEntity.setId(inventoryBatchCorrectionEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInventoryBatchCorrectionEntity.setCreated(inventoryBatchCorrectionEntity.getCreated());

			updatedInventoryBatchCorrectionEntity = inventoryBatchCorrectionService.update(updatedInventoryBatchCorrectionEntity);

			fetchedInventoryBatchCorrectionEntity = inventoryBatchCorrectionService.findById(inventoryBatchCorrectionEntity.getId());

			Assertions.assertTrue(fetchedInventoryBatchCorrectionEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInventoryBatchCorrectionEntity_ThenEntityIsCreated
			fetchedInventoryBatchCorrectionEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInventoryBatchCorrectionEntity, fetchedInventoryBatchCorrectionEntity.get());
		});
	}

	@Test
	public void whenDeleteInventoryBatchCorrectionEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionEntity inventoryBatchCorrectionEntity;
			Optional<InventoryBatchCorrectionEntity> fetchedInventoryBatchCorrectionEntity;

			try {
				inventoryBatchCorrectionEntity = inventoryBatchCorrectionFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				inventoryBatchCorrectionDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryBatchCorrectionEntity = inventoryBatchCorrectionService.create(inventoryBatchCorrectionEntity);

			inventoryBatchCorrectionService.deleteById(inventoryBatchCorrectionEntity.getId());
			fetchedInventoryBatchCorrectionEntity = inventoryBatchCorrectionService.findById(inventoryBatchCorrectionEntity.getId());

			Assertions.assertTrue(fetchedInventoryBatchCorrectionEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
