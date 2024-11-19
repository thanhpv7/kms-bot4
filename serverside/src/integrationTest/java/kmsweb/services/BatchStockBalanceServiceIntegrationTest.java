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
import kmsweb.entities.BatchStockBalanceEntity;
import kmsweb.repositories.BatchStockBalanceRepository;
import kmsweb.utils.BatchStockBalanceFactory;
import kmsweb.utils.DatabasePopulators.BatchStockBalanceDatabasePopulator;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.utils.StockCatalogueFactory;
import kmsweb.utils.DatabasePopulators.StockCatalogueDatabasePopulator;
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
public class BatchStockBalanceServiceIntegrationTest {

	@Autowired
	private BatchStockBalanceRepository batchStockBalanceRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BatchStockBalanceService batchStockBalanceService;

	private final BatchStockBalanceFactory batchStockBalanceFactory = new BatchStockBalanceFactory();

	@Autowired
	private BatchStockBalanceDatabasePopulator batchStockBalanceDatabasePopulator;

	@Autowired
	private StockCatalogueRepository stockCatalogueRepository;

	@Autowired
	private StockCatalogueDatabasePopulator stockCatalogueDatabasePopulator;

	private final StockCatalogueFactory stockCatalogueFactory = new StockCatalogueFactory();

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
		batchStockBalanceService = new BatchStockBalanceService(
			stockCatalogueRepository,
			warehouseRepository,
			validator,
			auditRepository,
			batchStockBalanceRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBatchStockBalanceEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BatchStockBalanceEntity batchStockBalanceEntity = batchStockBalanceFactory.getObject(false, false);

		BatchStockBalanceEntity updatedEntity = batchStockBalanceService.updateOldData(batchStockBalanceEntity);
		Assertions.assertEquals(batchStockBalanceEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBatchStockBalanceEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BatchStockBalanceEntity batchStockBalanceEntity;
			BatchStockBalanceEntity entityWithUpdatedValues;

			try {
				batchStockBalanceEntity = batchStockBalanceFactory.getObject(false, false);
				batchStockBalanceDatabasePopulator.populateRelatedEntitiesInDatabase(batchStockBalanceEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = batchStockBalanceFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			batchStockBalanceEntity = batchStockBalanceService.create(batchStockBalanceEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(batchStockBalanceEntity.getId());

			BatchStockBalanceEntity updatedEntity = batchStockBalanceService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBatchStockBalanceEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BatchStockBalanceEntity batchStockBalanceEntity = batchStockBalanceFactory.getObject(false, false);
		batchStockBalanceEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			batchStockBalanceService.updateOldData(batchStockBalanceEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBatchStockBalanceEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BatchStockBalanceEntity batchStockBalanceEntity;
			BatchStockBalanceEntity updatedBatchStockBalanceEntity;

			StockCatalogueEntity stockCatalogueEntity;

			WarehouseEntity warehouseEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				batchStockBalanceEntity = batchStockBalanceFactory.getObject(true, false);
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
			stockCatalogueEntity = batchStockBalanceEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			batchStockBalanceEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			warehouseEntity = batchStockBalanceEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			batchStockBalanceEntity.setWarehouseId(warehouseEntity.getId());


			batchStockBalanceEntity = batchStockBalanceService.create(batchStockBalanceEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(batchStockBalanceEntity.getStockCatalogue());
			batchStockBalanceEntity.setStockCatalogueId(null);
			batchStockBalanceEntity.unsetStockCatalogue();

			Assertions.assertNotNull(batchStockBalanceEntity.getWarehouse());
			batchStockBalanceEntity.setWarehouseId(null);
			batchStockBalanceEntity.unsetWarehouse();


			updatedBatchStockBalanceEntity = batchStockBalanceService.updateOldData(batchStockBalanceEntity);

			Assertions.assertNull(updatedBatchStockBalanceEntity.getStockCatalogue());

			Assertions.assertNull(updatedBatchStockBalanceEntity.getWarehouse());

		});
	}

	@Test
	public void updateOldDataWithBatchStockBalanceEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BatchStockBalanceEntity batchStockBalanceEntity;
			BatchStockBalanceEntity updatedBatchStockBalanceEntity;

			StockCatalogueEntity stockCatalogueEntity;

			WarehouseEntity warehouseEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				batchStockBalanceEntity = batchStockBalanceFactory.getObject(true, false);
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
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(batchStockBalanceEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(batchStockBalanceEntity.getStockCatalogue()).getId()).get();
			batchStockBalanceEntity.unsetStockCatalogue();
			batchStockBalanceEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(batchStockBalanceEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(batchStockBalanceEntity.getWarehouse()).getId()).get();
			batchStockBalanceEntity.unsetWarehouse();
			batchStockBalanceEntity.setWarehouseId(warehouseEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBatchStockBalanceEntity = batchStockBalanceService.updateOldData(batchStockBalanceEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			stockCatalogueEntity.unsetBatchStockBalancesCatalogue(false);
			updatedBatchStockBalanceEntity.getStockCatalogue().unsetBatchStockBalancesCatalogue(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedBatchStockBalanceEntity.getStockCatalogue());

			warehouseEntity.unsetBatchStockBalancesWarehouse(false);
			updatedBatchStockBalanceEntity.getWarehouse().unsetBatchStockBalancesWarehouse(false);
			Assertions.assertEquals(warehouseEntity, updatedBatchStockBalanceEntity.getWarehouse());

		});
	}

	@Test
	public void whenCreateBatchStockBalanceEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BatchStockBalanceEntity batchStockBalanceEntity;
			Optional<BatchStockBalanceEntity> fetchedBatchStockBalanceEntity;

			try {
				batchStockBalanceEntity = batchStockBalanceFactory.getObject(false, false);
				batchStockBalanceDatabasePopulator.populateRelatedEntitiesInDatabase(batchStockBalanceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			batchStockBalanceEntity = batchStockBalanceService.create(batchStockBalanceEntity);

			fetchedBatchStockBalanceEntity = batchStockBalanceService.findById(batchStockBalanceEntity.getId());

			Assertions.assertTrue(fetchedBatchStockBalanceEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBatchStockBalanceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(batchStockBalanceEntity, fetchedBatchStockBalanceEntity.get());
		});
	}

	@Test
	public void whenUpdateBatchStockBalanceEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BatchStockBalanceEntity batchStockBalanceEntity;
			BatchStockBalanceEntity updatedBatchStockBalanceEntity;
			Optional<BatchStockBalanceEntity> fetchedBatchStockBalanceEntity;

			try {
				batchStockBalanceEntity = batchStockBalanceFactory.getObject(false, false);
				batchStockBalanceDatabasePopulator.populateRelatedEntitiesInDatabase(batchStockBalanceEntity, true, true, false);
				updatedBatchStockBalanceEntity = batchStockBalanceFactory.getObject(false, false);
				batchStockBalanceDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBatchStockBalanceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			batchStockBalanceEntity = batchStockBalanceService.create(batchStockBalanceEntity);

			updatedBatchStockBalanceEntity.setId(batchStockBalanceEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBatchStockBalanceEntity.setCreated(batchStockBalanceEntity.getCreated());

			updatedBatchStockBalanceEntity = batchStockBalanceService.update(updatedBatchStockBalanceEntity);

			fetchedBatchStockBalanceEntity = batchStockBalanceService.findById(batchStockBalanceEntity.getId());

			Assertions.assertTrue(fetchedBatchStockBalanceEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBatchStockBalanceEntity_ThenEntityIsCreated
			fetchedBatchStockBalanceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBatchStockBalanceEntity, fetchedBatchStockBalanceEntity.get());
		});
	}

	@Test
	public void whenDeleteBatchStockBalanceEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BatchStockBalanceEntity batchStockBalanceEntity;
			Optional<BatchStockBalanceEntity> fetchedBatchStockBalanceEntity;

			try {
				batchStockBalanceEntity = batchStockBalanceFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				batchStockBalanceDatabasePopulator.populateRelatedEntitiesInDatabase(batchStockBalanceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			batchStockBalanceEntity = batchStockBalanceService.create(batchStockBalanceEntity);

			batchStockBalanceService.deleteById(batchStockBalanceEntity.getId());
			fetchedBatchStockBalanceEntity = batchStockBalanceService.findById(batchStockBalanceEntity.getId());

			Assertions.assertTrue(fetchedBatchStockBalanceEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
