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
import kmsweb.entities.InventoryBatchCorrectionItemEntity;
import kmsweb.repositories.InventoryBatchCorrectionItemRepository;
import kmsweb.utils.InventoryBatchCorrectionItemFactory;
import kmsweb.utils.DatabasePopulators.InventoryBatchCorrectionItemDatabasePopulator;
import kmsweb.entities.InventoryBatchCorrectionEntity;
import kmsweb.repositories.InventoryBatchCorrectionRepository;
import kmsweb.utils.InventoryBatchCorrectionFactory;
import kmsweb.utils.DatabasePopulators.InventoryBatchCorrectionDatabasePopulator;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.utils.StockCatalogueFactory;
import kmsweb.utils.DatabasePopulators.StockCatalogueDatabasePopulator;
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
public class InventoryBatchCorrectionItemServiceIntegrationTest {

	@Autowired
	private InventoryBatchCorrectionItemRepository inventoryBatchCorrectionItemRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InventoryBatchCorrectionItemService inventoryBatchCorrectionItemService;

	private final InventoryBatchCorrectionItemFactory inventoryBatchCorrectionItemFactory = new InventoryBatchCorrectionItemFactory();

	@Autowired
	private InventoryBatchCorrectionItemDatabasePopulator inventoryBatchCorrectionItemDatabasePopulator;

	@Autowired
	private InventoryBatchCorrectionRepository inventoryBatchCorrectionRepository;

	@Autowired
	private InventoryBatchCorrectionDatabasePopulator inventoryBatchCorrectionDatabasePopulator;

	private final InventoryBatchCorrectionFactory inventoryBatchCorrectionFactory = new InventoryBatchCorrectionFactory();

	@Autowired
	private StockCatalogueRepository stockCatalogueRepository;

	@Autowired
	private StockCatalogueDatabasePopulator stockCatalogueDatabasePopulator;

	private final StockCatalogueFactory stockCatalogueFactory = new StockCatalogueFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		inventoryBatchCorrectionItemService = new InventoryBatchCorrectionItemService(
			inventoryBatchCorrectionRepository,
			stockCatalogueRepository,
			validator,
			auditRepository,
			inventoryBatchCorrectionItemRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInventoryBatchCorrectionItemEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemFactory.getObject(false, false);

		InventoryBatchCorrectionItemEntity updatedEntity = inventoryBatchCorrectionItemService.updateOldData(inventoryBatchCorrectionItemEntity);
		Assertions.assertEquals(inventoryBatchCorrectionItemEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingInventoryBatchCorrectionItemEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItemEntity;
			InventoryBatchCorrectionItemEntity entityWithUpdatedValues;

			try {
				inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemFactory.getObject(false, false);
				inventoryBatchCorrectionItemDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionItemEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = inventoryBatchCorrectionItemFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemService.create(inventoryBatchCorrectionItemEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(inventoryBatchCorrectionItemEntity.getId());

			InventoryBatchCorrectionItemEntity updatedEntity = inventoryBatchCorrectionItemService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInventoryBatchCorrectionItemEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemFactory.getObject(false, false);
		inventoryBatchCorrectionItemEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			inventoryBatchCorrectionItemService.updateOldData(inventoryBatchCorrectionItemEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInventoryBatchCorrectionItemEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItemEntity;
			InventoryBatchCorrectionItemEntity updatedInventoryBatchCorrectionItemEntity;

			InventoryBatchCorrectionEntity inventoryBatchCorrectionEntity;

			StockCatalogueEntity stockCatalogueEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemFactory.getObject(true, false);
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
			inventoryBatchCorrectionEntity = inventoryBatchCorrectionItemEntity.getInventoryBatchCorrection();
			try {
				inventoryBatchCorrectionDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			inventoryBatchCorrectionEntity = inventoryBatchCorrectionRepository.save(inventoryBatchCorrectionEntity);
			inventoryBatchCorrectionItemEntity.setInventoryBatchCorrectionId(inventoryBatchCorrectionEntity.getId());

			stockCatalogueEntity = inventoryBatchCorrectionItemEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			inventoryBatchCorrectionItemEntity.setStockCatalogueId(stockCatalogueEntity.getId());


			inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemService.create(inventoryBatchCorrectionItemEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(inventoryBatchCorrectionItemEntity.getInventoryBatchCorrection());
			inventoryBatchCorrectionItemEntity.setInventoryBatchCorrectionId(null);
			inventoryBatchCorrectionItemEntity.unsetInventoryBatchCorrection();

			Assertions.assertNotNull(inventoryBatchCorrectionItemEntity.getStockCatalogue());
			inventoryBatchCorrectionItemEntity.setStockCatalogueId(null);
			inventoryBatchCorrectionItemEntity.unsetStockCatalogue();


			updatedInventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemService.updateOldData(inventoryBatchCorrectionItemEntity);

			Assertions.assertNull(updatedInventoryBatchCorrectionItemEntity.getInventoryBatchCorrection());

			Assertions.assertNull(updatedInventoryBatchCorrectionItemEntity.getStockCatalogue());

		});
	}

	@Test
	public void updateOldDataWithInventoryBatchCorrectionItemEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItemEntity;
			InventoryBatchCorrectionItemEntity updatedInventoryBatchCorrectionItemEntity;

			InventoryBatchCorrectionEntity inventoryBatchCorrectionEntity;

			StockCatalogueEntity stockCatalogueEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemFactory.getObject(true, false);
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
				inventoryBatchCorrectionDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionItemEntity.getInventoryBatchCorrection(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Inventory Batch Correction relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			inventoryBatchCorrectionEntity = inventoryBatchCorrectionRepository.findById(inventoryBatchCorrectionRepository.save(inventoryBatchCorrectionItemEntity.getInventoryBatchCorrection()).getId()).get();
			inventoryBatchCorrectionItemEntity.unsetInventoryBatchCorrection();
			inventoryBatchCorrectionItemEntity.setInventoryBatchCorrectionId(inventoryBatchCorrectionEntity.getId());

			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionItemEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(inventoryBatchCorrectionItemEntity.getStockCatalogue()).getId()).get();
			inventoryBatchCorrectionItemEntity.unsetStockCatalogue();
			inventoryBatchCorrectionItemEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemService.updateOldData(inventoryBatchCorrectionItemEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			inventoryBatchCorrectionEntity.unsetInventoryBatchCorrectionItems(false);
			updatedInventoryBatchCorrectionItemEntity.getInventoryBatchCorrection().unsetInventoryBatchCorrectionItems(false);
			Assertions.assertEquals(inventoryBatchCorrectionEntity, updatedInventoryBatchCorrectionItemEntity.getInventoryBatchCorrection());

			stockCatalogueEntity.unsetInventoryBatchCorrectionItems(false);
			updatedInventoryBatchCorrectionItemEntity.getStockCatalogue().unsetInventoryBatchCorrectionItems(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedInventoryBatchCorrectionItemEntity.getStockCatalogue());

		});
	}

	@Test
	public void whenCreateInventoryBatchCorrectionItemEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItemEntity;
			Optional<InventoryBatchCorrectionItemEntity> fetchedInventoryBatchCorrectionItemEntity;

			try {
				inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemFactory.getObject(false, false);
				inventoryBatchCorrectionItemDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemService.create(inventoryBatchCorrectionItemEntity);

			fetchedInventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemService.findById(inventoryBatchCorrectionItemEntity.getId());

			Assertions.assertTrue(fetchedInventoryBatchCorrectionItemEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInventoryBatchCorrectionItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(inventoryBatchCorrectionItemEntity, fetchedInventoryBatchCorrectionItemEntity.get());
		});
	}

	@Test
	public void whenUpdateInventoryBatchCorrectionItemEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItemEntity;
			InventoryBatchCorrectionItemEntity updatedInventoryBatchCorrectionItemEntity;
			Optional<InventoryBatchCorrectionItemEntity> fetchedInventoryBatchCorrectionItemEntity;

			try {
				inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemFactory.getObject(false, false);
				inventoryBatchCorrectionItemDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionItemEntity, true, true, false);
				updatedInventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemFactory.getObject(false, false);
				inventoryBatchCorrectionItemDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInventoryBatchCorrectionItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemService.create(inventoryBatchCorrectionItemEntity);

			updatedInventoryBatchCorrectionItemEntity.setId(inventoryBatchCorrectionItemEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInventoryBatchCorrectionItemEntity.setCreated(inventoryBatchCorrectionItemEntity.getCreated());

			updatedInventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemService.update(updatedInventoryBatchCorrectionItemEntity);

			fetchedInventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemService.findById(inventoryBatchCorrectionItemEntity.getId());

			Assertions.assertTrue(fetchedInventoryBatchCorrectionItemEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInventoryBatchCorrectionItemEntity_ThenEntityIsCreated
			fetchedInventoryBatchCorrectionItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInventoryBatchCorrectionItemEntity, fetchedInventoryBatchCorrectionItemEntity.get());
		});
	}

	@Test
	public void whenDeleteInventoryBatchCorrectionItemEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItemEntity;
			Optional<InventoryBatchCorrectionItemEntity> fetchedInventoryBatchCorrectionItemEntity;

			try {
				inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				inventoryBatchCorrectionItemDatabasePopulator.populateRelatedEntitiesInDatabase(inventoryBatchCorrectionItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			inventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemService.create(inventoryBatchCorrectionItemEntity);

			inventoryBatchCorrectionItemService.deleteById(inventoryBatchCorrectionItemEntity.getId());
			fetchedInventoryBatchCorrectionItemEntity = inventoryBatchCorrectionItemService.findById(inventoryBatchCorrectionItemEntity.getId());

			Assertions.assertTrue(fetchedInventoryBatchCorrectionItemEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
