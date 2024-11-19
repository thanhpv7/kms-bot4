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
import kmsweb.entities.GoodsReceiveNoteItemEntity;
import kmsweb.repositories.GoodsReceiveNoteItemRepository;
import kmsweb.utils.GoodsReceiveNoteItemFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteItemDatabasePopulator;
import kmsweb.entities.GoodsReceiveNoteEntity;
import kmsweb.repositories.GoodsReceiveNoteRepository;
import kmsweb.utils.GoodsReceiveNoteFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteDatabasePopulator;
import kmsweb.entities.GoodsReceiveNoteBatchEntity;
import kmsweb.repositories.GoodsReceiveNoteBatchRepository;
import kmsweb.utils.GoodsReceiveNoteBatchFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteBatchDatabasePopulator;
import kmsweb.entities.PurchaseOrderStockDetailEntity;
import kmsweb.repositories.PurchaseOrderStockDetailRepository;
import kmsweb.utils.PurchaseOrderStockDetailFactory;
import kmsweb.utils.DatabasePopulators.PurchaseOrderStockDetailDatabasePopulator;
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
public class GoodsReceiveNoteItemServiceIntegrationTest {

	@Autowired
	private GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private GoodsReceiveNoteItemService goodsReceiveNoteItemService;

	private final GoodsReceiveNoteItemFactory goodsReceiveNoteItemFactory = new GoodsReceiveNoteItemFactory();

	@Autowired
	private GoodsReceiveNoteItemDatabasePopulator goodsReceiveNoteItemDatabasePopulator;

	@Autowired
	private GoodsReceiveNoteRepository goodsReceiveNoteRepository;

	@Autowired
	private GoodsReceiveNoteDatabasePopulator goodsReceiveNoteDatabasePopulator;

	private final GoodsReceiveNoteFactory goodsReceiveNoteFactory = new GoodsReceiveNoteFactory();

	@Autowired
	private GoodsReceiveNoteBatchRepository goodsReceiveNoteBatchRepository;

	@Autowired
	private GoodsReceiveNoteBatchDatabasePopulator goodsReceiveNoteBatchDatabasePopulator;

	private final GoodsReceiveNoteBatchFactory goodsReceiveNoteBatchFactory = new GoodsReceiveNoteBatchFactory();

	@Autowired
	private PurchaseOrderStockDetailRepository purchaseOrderStockDetailRepository;

	@Autowired
	private PurchaseOrderStockDetailDatabasePopulator purchaseOrderStockDetailDatabasePopulator;

	private final PurchaseOrderStockDetailFactory purchaseOrderStockDetailFactory = new PurchaseOrderStockDetailFactory();

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
		goodsReceiveNoteItemService = new GoodsReceiveNoteItemService(
			goodsReceiveNoteRepository,
			goodsReceiveNoteBatchRepository,
			purchaseOrderStockDetailRepository,
			stockCatalogueRepository,
			validator,
			auditRepository,
			goodsReceiveNoteItemRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewGoodsReceiveNoteItemEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity = goodsReceiveNoteItemFactory.getObject(false, false);

		GoodsReceiveNoteItemEntity updatedEntity = goodsReceiveNoteItemService.updateOldData(goodsReceiveNoteItemEntity);
		Assertions.assertEquals(goodsReceiveNoteItemEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewGoodsReceiveNoteItemEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity = goodsReceiveNoteItemFactory.getObject(false, false);

		goodsReceiveNoteItemEntity.setDiscountInPercent(null);
		Assertions.assertNull(goodsReceiveNoteItemEntity.getDiscountInPercent());

		goodsReceiveNoteItemEntity.setTaxInPercent(null);
		Assertions.assertNull(goodsReceiveNoteItemEntity.getTaxInPercent());


		GoodsReceiveNoteItemEntity updatedEntity = goodsReceiveNoteItemService.updateOldData(goodsReceiveNoteItemEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getDiscountInPercent());
		Assertions.assertFalse(updatedEntity.getDiscountInPercent());

		Assertions.assertNotNull(updatedEntity.getTaxInPercent());
		Assertions.assertFalse(updatedEntity.getTaxInPercent());

	}

	@Test
	public void updateOldDataWithExistingGoodsReceiveNoteItemEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity;
			GoodsReceiveNoteItemEntity entityWithUpdatedValues;

			try {
				goodsReceiveNoteItemEntity = goodsReceiveNoteItemFactory.getObject(false, false);
				goodsReceiveNoteItemDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteItemEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = goodsReceiveNoteItemFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteItemEntity = goodsReceiveNoteItemService.create(goodsReceiveNoteItemEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(goodsReceiveNoteItemEntity.getId());

			GoodsReceiveNoteItemEntity updatedEntity = goodsReceiveNoteItemService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithGoodsReceiveNoteItemEntityWithNonExistentId_ShouldThrowException() throws Exception {
		GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity = goodsReceiveNoteItemFactory.getObject(false, false);
		goodsReceiveNoteItemEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			goodsReceiveNoteItemService.updateOldData(goodsReceiveNoteItemEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingGoodsReceiveNoteItemEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity;
			GoodsReceiveNoteItemEntity updatedGoodsReceiveNoteItemEntity;

			GoodsReceiveNoteEntity goodsReceiveNoteEntity;

			PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity;

			StockCatalogueEntity stockCatalogueEntity;

			Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				goodsReceiveNoteItemEntity = goodsReceiveNoteItemFactory.getObject(true, false);
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
			goodsReceiveNoteEntity = goodsReceiveNoteItemEntity.getGoodsReceiveNote();
			try {
				goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			goodsReceiveNoteEntity = goodsReceiveNoteRepository.save(goodsReceiveNoteEntity);
			goodsReceiveNoteItemEntity.setGoodsReceiveNoteId(goodsReceiveNoteEntity.getId());

			purchaseOrderStockDetailEntity = goodsReceiveNoteItemEntity.getPurchaseOrderStockDetail();
			try {
				purchaseOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderStockDetailEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			purchaseOrderStockDetailEntity = purchaseOrderStockDetailRepository.save(purchaseOrderStockDetailEntity);
			goodsReceiveNoteItemEntity.setPurchaseOrderStockDetailId(purchaseOrderStockDetailEntity.getId());

			stockCatalogueEntity = goodsReceiveNoteItemEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			goodsReceiveNoteItemEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			goodsReceiveNoteBatchsEntities = goodsReceiveNoteItemEntity.getGoodsReceiveNoteBatchs();
			Set<UUID> goodsReceiveNoteBatchsEntityIds = new HashSet<>();
			for (GoodsReceiveNoteBatchEntity entity : goodsReceiveNoteBatchsEntities) {
				try {
					goodsReceiveNoteBatchDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				goodsReceiveNoteBatchsEntityIds.add(goodsReceiveNoteBatchRepository.save(entity).getId());
			}
			goodsReceiveNoteItemEntity.setGoodsReceiveNoteBatchsIds(goodsReceiveNoteBatchsEntityIds);


			goodsReceiveNoteItemEntity = goodsReceiveNoteItemService.create(goodsReceiveNoteItemEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(goodsReceiveNoteItemEntity.getGoodsReceiveNote());
			goodsReceiveNoteItemEntity.setGoodsReceiveNoteId(null);
			goodsReceiveNoteItemEntity.unsetGoodsReceiveNote();

			Assertions.assertNotNull(goodsReceiveNoteItemEntity.getPurchaseOrderStockDetail());
			goodsReceiveNoteItemEntity.setPurchaseOrderStockDetailId(null);
			goodsReceiveNoteItemEntity.unsetPurchaseOrderStockDetail();

			Assertions.assertNotNull(goodsReceiveNoteItemEntity.getStockCatalogue());
			goodsReceiveNoteItemEntity.setStockCatalogueId(null);
			goodsReceiveNoteItemEntity.unsetStockCatalogue();

			Assertions.assertTrue(goodsReceiveNoteItemEntity.getGoodsReceiveNoteBatchs().size() > 0);
			goodsReceiveNoteItemEntity.setGoodsReceiveNoteBatchsIds(new HashSet<UUID>());
			goodsReceiveNoteItemEntity.unsetGoodsReceiveNoteBatchs();


			updatedGoodsReceiveNoteItemEntity = goodsReceiveNoteItemService.updateOldData(goodsReceiveNoteItemEntity);

			Assertions.assertNull(updatedGoodsReceiveNoteItemEntity.getGoodsReceiveNote());

			Assertions.assertNull(updatedGoodsReceiveNoteItemEntity.getPurchaseOrderStockDetail());

			Assertions.assertNull(updatedGoodsReceiveNoteItemEntity.getStockCatalogue());

			Assertions.assertEquals(0, updatedGoodsReceiveNoteItemEntity.getGoodsReceiveNoteBatchs().size());

		});
	}

	@Test
	public void updateOldDataWithGoodsReceiveNoteItemEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity;
			GoodsReceiveNoteItemEntity updatedGoodsReceiveNoteItemEntity;

			GoodsReceiveNoteEntity goodsReceiveNoteEntity;

			PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity;

			StockCatalogueEntity stockCatalogueEntity;

			Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchsEntities;
			Set<UUID> goodsReceiveNoteBatchsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				goodsReceiveNoteItemEntity = goodsReceiveNoteItemFactory.getObject(true, false);
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
				goodsReceiveNoteDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteItemEntity.getGoodsReceiveNote(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Goods Receive Note relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			goodsReceiveNoteEntity = goodsReceiveNoteRepository.findById(goodsReceiveNoteRepository.save(goodsReceiveNoteItemEntity.getGoodsReceiveNote()).getId()).get();
			goodsReceiveNoteItemEntity.unsetGoodsReceiveNote();
			goodsReceiveNoteItemEntity.setGoodsReceiveNoteId(goodsReceiveNoteEntity.getId());

			try {
				purchaseOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteItemEntity.getPurchaseOrderStockDetail(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Purchase Order Stock Detail relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			purchaseOrderStockDetailEntity = purchaseOrderStockDetailRepository.findById(purchaseOrderStockDetailRepository.save(goodsReceiveNoteItemEntity.getPurchaseOrderStockDetail()).getId()).get();
			goodsReceiveNoteItemEntity.unsetPurchaseOrderStockDetail();
			goodsReceiveNoteItemEntity.setPurchaseOrderStockDetailId(purchaseOrderStockDetailEntity.getId());

			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteItemEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(goodsReceiveNoteItemEntity.getStockCatalogue()).getId()).get();
			goodsReceiveNoteItemEntity.unsetStockCatalogue();
			goodsReceiveNoteItemEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			goodsReceiveNoteBatchsEntities = new HashSet<>();
			goodsReceiveNoteBatchsEntityIds = new HashSet<>();
			for (GoodsReceiveNoteBatchEntity entity : goodsReceiveNoteItemEntity.getGoodsReceiveNoteBatchs()) {
				try {
					goodsReceiveNoteBatchDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Goods Receive Note Batchs relation for this test: " + e.getCause());
					return;
				}
				UUID id = goodsReceiveNoteBatchRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				goodsReceiveNoteBatchsEntities.add(goodsReceiveNoteBatchRepository.findById(id).get());
				goodsReceiveNoteBatchsEntityIds.add(id);
			}
			goodsReceiveNoteItemEntity.unsetGoodsReceiveNoteBatchs();
			goodsReceiveNoteItemEntity.setGoodsReceiveNoteBatchsIds(goodsReceiveNoteBatchsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedGoodsReceiveNoteItemEntity = goodsReceiveNoteItemService.updateOldData(goodsReceiveNoteItemEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			goodsReceiveNoteEntity.unsetGoodsReceiveNoteItems(false);
			updatedGoodsReceiveNoteItemEntity.getGoodsReceiveNote().unsetGoodsReceiveNoteItems(false);
			Assertions.assertEquals(goodsReceiveNoteEntity, updatedGoodsReceiveNoteItemEntity.getGoodsReceiveNote());

			purchaseOrderStockDetailEntity.unsetGoodsReceiveNoteItems(false);
			updatedGoodsReceiveNoteItemEntity.getPurchaseOrderStockDetail().unsetGoodsReceiveNoteItems(false);
			Assertions.assertEquals(purchaseOrderStockDetailEntity, updatedGoodsReceiveNoteItemEntity.getPurchaseOrderStockDetail());

			stockCatalogueEntity.unsetGoodsReceiveNoteItems(false);
			updatedGoodsReceiveNoteItemEntity.getStockCatalogue().unsetGoodsReceiveNoteItems(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedGoodsReceiveNoteItemEntity.getStockCatalogue());

			Assertions.assertEquals(goodsReceiveNoteBatchsEntities.size(), updatedGoodsReceiveNoteItemEntity.getGoodsReceiveNoteBatchs().size());

		});
	}

	@Test
	public void whenCreateGoodsReceiveNoteItemEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity;
			Optional<GoodsReceiveNoteItemEntity> fetchedGoodsReceiveNoteItemEntity;

			try {
				goodsReceiveNoteItemEntity = goodsReceiveNoteItemFactory.getObject(false, false);
				goodsReceiveNoteItemDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteItemEntity = goodsReceiveNoteItemService.create(goodsReceiveNoteItemEntity);

			fetchedGoodsReceiveNoteItemEntity = goodsReceiveNoteItemService.findById(goodsReceiveNoteItemEntity.getId());

			Assertions.assertTrue(fetchedGoodsReceiveNoteItemEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedGoodsReceiveNoteItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(goodsReceiveNoteItemEntity, fetchedGoodsReceiveNoteItemEntity.get());
		});
	}

	@Test
	public void whenUpdateGoodsReceiveNoteItemEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity;
			GoodsReceiveNoteItemEntity updatedGoodsReceiveNoteItemEntity;
			Optional<GoodsReceiveNoteItemEntity> fetchedGoodsReceiveNoteItemEntity;

			try {
				goodsReceiveNoteItemEntity = goodsReceiveNoteItemFactory.getObject(false, false);
				goodsReceiveNoteItemDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteItemEntity, true, true, false);
				updatedGoodsReceiveNoteItemEntity = goodsReceiveNoteItemFactory.getObject(false, false);
				goodsReceiveNoteItemDatabasePopulator.populateRelatedEntitiesInDatabase(updatedGoodsReceiveNoteItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteItemEntity = goodsReceiveNoteItemService.create(goodsReceiveNoteItemEntity);

			updatedGoodsReceiveNoteItemEntity.setId(goodsReceiveNoteItemEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedGoodsReceiveNoteItemEntity.setCreated(goodsReceiveNoteItemEntity.getCreated());

			updatedGoodsReceiveNoteItemEntity = goodsReceiveNoteItemService.update(updatedGoodsReceiveNoteItemEntity);

			fetchedGoodsReceiveNoteItemEntity = goodsReceiveNoteItemService.findById(goodsReceiveNoteItemEntity.getId());

			Assertions.assertTrue(fetchedGoodsReceiveNoteItemEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateGoodsReceiveNoteItemEntity_ThenEntityIsCreated
			fetchedGoodsReceiveNoteItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedGoodsReceiveNoteItemEntity, fetchedGoodsReceiveNoteItemEntity.get());
		});
	}

	@Test
	public void whenDeleteGoodsReceiveNoteItemEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			GoodsReceiveNoteItemEntity goodsReceiveNoteItemEntity;
			Optional<GoodsReceiveNoteItemEntity> fetchedGoodsReceiveNoteItemEntity;

			try {
				goodsReceiveNoteItemEntity = goodsReceiveNoteItemFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				goodsReceiveNoteItemDatabasePopulator.populateRelatedEntitiesInDatabase(goodsReceiveNoteItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			goodsReceiveNoteItemEntity = goodsReceiveNoteItemService.create(goodsReceiveNoteItemEntity);

			goodsReceiveNoteItemService.deleteById(goodsReceiveNoteItemEntity.getId());
			fetchedGoodsReceiveNoteItemEntity = goodsReceiveNoteItemService.findById(goodsReceiveNoteItemEntity.getId());

			Assertions.assertTrue(fetchedGoodsReceiveNoteItemEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
