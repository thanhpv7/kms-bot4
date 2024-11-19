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
import kmsweb.entities.GoodsReceiveNoteBatchEntity;
import kmsweb.repositories.GoodsReceiveNoteBatchRepository;
import kmsweb.utils.GoodsReceiveNoteBatchFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteBatchDatabasePopulator;
import kmsweb.entities.GoodsReceiveNoteItemEntity;
import kmsweb.repositories.GoodsReceiveNoteItemRepository;
import kmsweb.utils.GoodsReceiveNoteItemFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteItemDatabasePopulator;
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
public class GoodsReceiveNoteBatchServiceIntegrationTest {

	@Autowired
	private GoodsReceiveNoteBatchRepository goodsReceiveNoteBatchRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private GoodsReceiveNoteBatchService goodsReceiveNoteBatchService;

	private final GoodsReceiveNoteBatchFactory goodsReceiveNoteBatchFactory = new GoodsReceiveNoteBatchFactory();

	@Autowired
	private GoodsReceiveNoteBatchDatabasePopulator goodsReceiveNoteBatchDatabasePopulator;

	@Autowired
	private GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository;

	@Autowired
	private GoodsReceiveNoteItemDatabasePopulator goodsReceiveNoteItemDatabasePopulator;

	private final GoodsReceiveNoteItemFactory goodsReceiveNoteItemFactory = new GoodsReceiveNoteItemFactory();

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
		goodsReceiveNoteBatchService = new GoodsReceiveNoteBatchService(
			goodsReceiveNoteItemRepository,
			stockCatalogueRepository,
			warehouseRepository,
			validator,
			auditRepository,
			goodsReceiveNoteBatchRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewGoodsReceiveNoteBatchEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchFactory.getObject(false, false);

		GoodsReceiveNoteBatchEntity updatedEntity = goodsReceiveNoteBatchService.updateOldData(goodsReceiveNoteBatchEntity);
		Assertions.assertEquals(goodsReceiveNoteBatchEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingGoodsReceiveNoteBatchEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchEntity;
			GoodsReceiveNoteBatchEntity entityWithUpdatedValues;

			try {
				goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchFactory.getObject(false, false);
				goodsReceiveNoteBatchDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteBatchEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = goodsReceiveNoteBatchFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchService.create(goodsReceiveNoteBatchEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(goodsReceiveNoteBatchEntity.getId());

			GoodsReceiveNoteBatchEntity updatedEntity = goodsReceiveNoteBatchService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithGoodsReceiveNoteBatchEntityWithNonExistentId_ShouldThrowException() throws Exception {
		GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchFactory.getObject(false, false);
		goodsReceiveNoteBatchEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			goodsReceiveNoteBatchService.updateOldData(goodsReceiveNoteBatchEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingGoodsReceiveNoteBatchEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchEntity;
			GoodsReceiveNoteBatchEntity updatedGoodsReceiveNoteBatchEntity;

			GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity;

			StockCatalogueEntity stockCatalogueEntity;

			WarehouseEntity warehouseEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchFactory.getObject(true, false);
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
			goodsReceiveNoteItemEntity = goodsReceiveNoteBatchEntity.getGoodsReceiveNoteItem();
			try {
				goodsReceiveNoteItemDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteItemEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			goodsReceiveNoteItemEntity = goodsReceiveNoteItemRepository.save(goodsReceiveNoteItemEntity);
			goodsReceiveNoteBatchEntity.setGoodsReceiveNoteItemId(goodsReceiveNoteItemEntity.getId());

			stockCatalogueEntity = goodsReceiveNoteBatchEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			goodsReceiveNoteBatchEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			warehouseEntity = goodsReceiveNoteBatchEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			goodsReceiveNoteBatchEntity.setWarehouseId(warehouseEntity.getId());


			goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchService.create(goodsReceiveNoteBatchEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(goodsReceiveNoteBatchEntity.getGoodsReceiveNoteItem());
			goodsReceiveNoteBatchEntity.setGoodsReceiveNoteItemId(null);
			goodsReceiveNoteBatchEntity.unsetGoodsReceiveNoteItem();

			Assertions.assertNotNull(goodsReceiveNoteBatchEntity.getStockCatalogue());
			goodsReceiveNoteBatchEntity.setStockCatalogueId(null);
			goodsReceiveNoteBatchEntity.unsetStockCatalogue();

			Assertions.assertNotNull(goodsReceiveNoteBatchEntity.getWarehouse());
			goodsReceiveNoteBatchEntity.setWarehouseId(null);
			goodsReceiveNoteBatchEntity.unsetWarehouse();


			updatedGoodsReceiveNoteBatchEntity = goodsReceiveNoteBatchService.updateOldData(goodsReceiveNoteBatchEntity);

			Assertions.assertNull(updatedGoodsReceiveNoteBatchEntity.getGoodsReceiveNoteItem());

			Assertions.assertNull(updatedGoodsReceiveNoteBatchEntity.getStockCatalogue());

			Assertions.assertNull(updatedGoodsReceiveNoteBatchEntity.getWarehouse());

		});
	}

	@Test
	public void updateOldDataWithGoodsReceiveNoteBatchEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchEntity;
			GoodsReceiveNoteBatchEntity updatedGoodsReceiveNoteBatchEntity;

			GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity;

			StockCatalogueEntity stockCatalogueEntity;

			WarehouseEntity warehouseEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchFactory.getObject(true, false);
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
				goodsReceiveNoteItemDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteBatchEntity.getGoodsReceiveNoteItem(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Goods Receive Note Item relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			goodsReceiveNoteItemEntity = goodsReceiveNoteItemRepository.findById(goodsReceiveNoteItemRepository.save(goodsReceiveNoteBatchEntity.getGoodsReceiveNoteItem()).getId()).get();
			goodsReceiveNoteBatchEntity.unsetGoodsReceiveNoteItem();
			goodsReceiveNoteBatchEntity.setGoodsReceiveNoteItemId(goodsReceiveNoteItemEntity.getId());

			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteBatchEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(goodsReceiveNoteBatchEntity.getStockCatalogue()).getId()).get();
			goodsReceiveNoteBatchEntity.unsetStockCatalogue();
			goodsReceiveNoteBatchEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteBatchEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(goodsReceiveNoteBatchEntity.getWarehouse()).getId()).get();
			goodsReceiveNoteBatchEntity.unsetWarehouse();
			goodsReceiveNoteBatchEntity.setWarehouseId(warehouseEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedGoodsReceiveNoteBatchEntity = goodsReceiveNoteBatchService.updateOldData(goodsReceiveNoteBatchEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			goodsReceiveNoteItemEntity.unsetGoodsReceiveNoteBatchs(false);
			updatedGoodsReceiveNoteBatchEntity.getGoodsReceiveNoteItem().unsetGoodsReceiveNoteBatchs(false);
			Assertions.assertEquals(goodsReceiveNoteItemEntity, updatedGoodsReceiveNoteBatchEntity.getGoodsReceiveNoteItem());

			stockCatalogueEntity.unsetGoodsReceiveNoteBatchs(false);
			updatedGoodsReceiveNoteBatchEntity.getStockCatalogue().unsetGoodsReceiveNoteBatchs(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedGoodsReceiveNoteBatchEntity.getStockCatalogue());

			warehouseEntity.unsetGoodsReceiveNoteBatchs(false);
			updatedGoodsReceiveNoteBatchEntity.getWarehouse().unsetGoodsReceiveNoteBatchs(false);
			Assertions.assertEquals(warehouseEntity, updatedGoodsReceiveNoteBatchEntity.getWarehouse());

		});
	}

	@Test
	public void whenCreateGoodsReceiveNoteBatchEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchEntity;
			Optional<GoodsReceiveNoteBatchEntity> fetchedGoodsReceiveNoteBatchEntity;

			try {
				goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchFactory.getObject(false, false);
				goodsReceiveNoteBatchDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteBatchEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchService.create(goodsReceiveNoteBatchEntity);

			fetchedGoodsReceiveNoteBatchEntity = goodsReceiveNoteBatchService.findById(goodsReceiveNoteBatchEntity.getId());

			Assertions.assertTrue(fetchedGoodsReceiveNoteBatchEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedGoodsReceiveNoteBatchEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(goodsReceiveNoteBatchEntity, fetchedGoodsReceiveNoteBatchEntity.get());
		});
	}

	@Test
	public void whenUpdateGoodsReceiveNoteBatchEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchEntity;
			GoodsReceiveNoteBatchEntity updatedGoodsReceiveNoteBatchEntity;
			Optional<GoodsReceiveNoteBatchEntity> fetchedGoodsReceiveNoteBatchEntity;

			try {
				goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchFactory.getObject(false, false);
				goodsReceiveNoteBatchDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteBatchEntity, true, true, false);
				updatedGoodsReceiveNoteBatchEntity = goodsReceiveNoteBatchFactory.getObject(false, false);
				goodsReceiveNoteBatchDatabasePopulator.populateRelatedEntitiesInDatabase(updatedGoodsReceiveNoteBatchEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchService.create(goodsReceiveNoteBatchEntity);

			updatedGoodsReceiveNoteBatchEntity.setId(goodsReceiveNoteBatchEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedGoodsReceiveNoteBatchEntity.setCreated(goodsReceiveNoteBatchEntity.getCreated());

			updatedGoodsReceiveNoteBatchEntity = goodsReceiveNoteBatchService.update(updatedGoodsReceiveNoteBatchEntity);

			fetchedGoodsReceiveNoteBatchEntity = goodsReceiveNoteBatchService.findById(goodsReceiveNoteBatchEntity.getId());

			Assertions.assertTrue(fetchedGoodsReceiveNoteBatchEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateGoodsReceiveNoteBatchEntity_ThenEntityIsCreated
			fetchedGoodsReceiveNoteBatchEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedGoodsReceiveNoteBatchEntity, fetchedGoodsReceiveNoteBatchEntity.get());
		});
	}

	@Test
	public void whenDeleteGoodsReceiveNoteBatchEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchEntity;
			Optional<GoodsReceiveNoteBatchEntity> fetchedGoodsReceiveNoteBatchEntity;

			try {
				goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				goodsReceiveNoteBatchDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteBatchEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteBatchEntity = goodsReceiveNoteBatchService.create(goodsReceiveNoteBatchEntity);

			goodsReceiveNoteBatchService.deleteById(goodsReceiveNoteBatchEntity.getId());
			fetchedGoodsReceiveNoteBatchEntity = goodsReceiveNoteBatchService.findById(goodsReceiveNoteBatchEntity.getId());

			Assertions.assertTrue(fetchedGoodsReceiveNoteBatchEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
