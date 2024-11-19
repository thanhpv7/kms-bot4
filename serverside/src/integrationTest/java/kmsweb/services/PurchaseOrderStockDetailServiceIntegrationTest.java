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
import kmsweb.entities.PurchaseOrderStockDetailEntity;
import kmsweb.repositories.PurchaseOrderStockDetailRepository;
import kmsweb.utils.PurchaseOrderStockDetailFactory;
import kmsweb.utils.DatabasePopulators.PurchaseOrderStockDetailDatabasePopulator;
import kmsweb.entities.GoodsReceiveNoteItemEntity;
import kmsweb.repositories.GoodsReceiveNoteItemRepository;
import kmsweb.utils.GoodsReceiveNoteItemFactory;
import kmsweb.utils.DatabasePopulators.GoodsReceiveNoteItemDatabasePopulator;
import kmsweb.entities.PurchaseOrderEntity;
import kmsweb.repositories.PurchaseOrderRepository;
import kmsweb.utils.PurchaseOrderFactory;
import kmsweb.utils.DatabasePopulators.PurchaseOrderDatabasePopulator;
import kmsweb.entities.PurchaseRequisitionStockDetailEntity;
import kmsweb.repositories.PurchaseRequisitionStockDetailRepository;
import kmsweb.utils.PurchaseRequisitionStockDetailFactory;
import kmsweb.utils.DatabasePopulators.PurchaseRequisitionStockDetailDatabasePopulator;
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
public class PurchaseOrderStockDetailServiceIntegrationTest {

	@Autowired
	private PurchaseOrderStockDetailRepository purchaseOrderStockDetailRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PurchaseOrderStockDetailService purchaseOrderStockDetailService;

	private final PurchaseOrderStockDetailFactory purchaseOrderStockDetailFactory = new PurchaseOrderStockDetailFactory();

	@Autowired
	private PurchaseOrderStockDetailDatabasePopulator purchaseOrderStockDetailDatabasePopulator;

	@Autowired
	private GoodsReceiveNoteItemRepository goodsReceiveNoteItemRepository;

	@Autowired
	private GoodsReceiveNoteItemDatabasePopulator goodsReceiveNoteItemDatabasePopulator;

	private final GoodsReceiveNoteItemFactory goodsReceiveNoteItemFactory = new GoodsReceiveNoteItemFactory();

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private PurchaseOrderDatabasePopulator purchaseOrderDatabasePopulator;

	private final PurchaseOrderFactory purchaseOrderFactory = new PurchaseOrderFactory();

	@Autowired
	private PurchaseRequisitionStockDetailRepository purchaseRequisitionStockDetailRepository;

	@Autowired
	private PurchaseRequisitionStockDetailDatabasePopulator purchaseRequisitionStockDetailDatabasePopulator;

	private final PurchaseRequisitionStockDetailFactory purchaseRequisitionStockDetailFactory = new PurchaseRequisitionStockDetailFactory();

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
		purchaseOrderStockDetailService = new PurchaseOrderStockDetailService(
			goodsReceiveNoteItemRepository,
			purchaseOrderRepository,
			purchaseRequisitionStockDetailRepository,
			stockCatalogueRepository,
			validator,
			auditRepository,
			purchaseOrderStockDetailRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPurchaseOrderStockDetailEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity = purchaseOrderStockDetailFactory.getObject(false, false);

		PurchaseOrderStockDetailEntity updatedEntity = purchaseOrderStockDetailService.updateOldData(purchaseOrderStockDetailEntity);
		Assertions.assertEquals(purchaseOrderStockDetailEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewPurchaseOrderStockDetailEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity = purchaseOrderStockDetailFactory.getObject(false, false);

		purchaseOrderStockDetailEntity.setDiscountInPercent(null);
		Assertions.assertNull(purchaseOrderStockDetailEntity.getDiscountInPercent());

		purchaseOrderStockDetailEntity.setTaxable(null);
		Assertions.assertNull(purchaseOrderStockDetailEntity.getTaxable());


		PurchaseOrderStockDetailEntity updatedEntity = purchaseOrderStockDetailService.updateOldData(purchaseOrderStockDetailEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getDiscountInPercent());
		Assertions.assertFalse(updatedEntity.getDiscountInPercent());

		Assertions.assertNotNull(updatedEntity.getTaxable());
		Assertions.assertFalse(updatedEntity.getTaxable());

	}

	@Test
	public void updateOldDataWithExistingPurchaseOrderStockDetailEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity;
			PurchaseOrderStockDetailEntity entityWithUpdatedValues;

			try {
				purchaseOrderStockDetailEntity = purchaseOrderStockDetailFactory.getObject(false, false);
				purchaseOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderStockDetailEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = purchaseOrderStockDetailFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseOrderStockDetailEntity = purchaseOrderStockDetailService.create(purchaseOrderStockDetailEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(purchaseOrderStockDetailEntity.getId());

			PurchaseOrderStockDetailEntity updatedEntity = purchaseOrderStockDetailService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPurchaseOrderStockDetailEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity = purchaseOrderStockDetailFactory.getObject(false, false);
		purchaseOrderStockDetailEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			purchaseOrderStockDetailService.updateOldData(purchaseOrderStockDetailEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPurchaseOrderStockDetailEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity;
			PurchaseOrderStockDetailEntity updatedPurchaseOrderStockDetailEntity;

			PurchaseOrderEntity purchaseOrderEntity;

			PurchaseRequisitionStockDetailEntity purchaseRequisitionStockDetailEntity;

			StockCatalogueEntity stockCatalogueEntity;

			Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				purchaseOrderStockDetailEntity = purchaseOrderStockDetailFactory.getObject(true, false);
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
			purchaseOrderEntity = purchaseOrderStockDetailEntity.getPurchaseOrder();
			try {
				purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			purchaseOrderEntity = purchaseOrderRepository.save(purchaseOrderEntity);
			purchaseOrderStockDetailEntity.setPurchaseOrderId(purchaseOrderEntity.getId());

			purchaseRequisitionStockDetailEntity = purchaseOrderStockDetailEntity.getPurchaseRequisitionStockDetail();
			try {
				purchaseRequisitionStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseRequisitionStockDetailEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			purchaseRequisitionStockDetailEntity = purchaseRequisitionStockDetailRepository.save(purchaseRequisitionStockDetailEntity);
			purchaseOrderStockDetailEntity.setPurchaseRequisitionStockDetailId(purchaseRequisitionStockDetailEntity.getId());

			stockCatalogueEntity = purchaseOrderStockDetailEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			purchaseOrderStockDetailEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			goodsReceiveNoteItemsEntities = purchaseOrderStockDetailEntity.getGoodsReceiveNoteItems();
			Set<UUID> goodsReceiveNoteItemsEntityIds = new HashSet<>();
			for (GoodsReceiveNoteItemEntity entity : goodsReceiveNoteItemsEntities) {
				try {
					goodsReceiveNoteItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				goodsReceiveNoteItemsEntityIds.add(goodsReceiveNoteItemRepository.save(entity).getId());
			}
			purchaseOrderStockDetailEntity.setGoodsReceiveNoteItemsIds(goodsReceiveNoteItemsEntityIds);


			purchaseOrderStockDetailEntity = purchaseOrderStockDetailService.create(purchaseOrderStockDetailEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(purchaseOrderStockDetailEntity.getPurchaseOrder());
			purchaseOrderStockDetailEntity.setPurchaseOrderId(null);
			purchaseOrderStockDetailEntity.unsetPurchaseOrder();

			Assertions.assertNotNull(purchaseOrderStockDetailEntity.getPurchaseRequisitionStockDetail());
			purchaseOrderStockDetailEntity.setPurchaseRequisitionStockDetailId(null);
			purchaseOrderStockDetailEntity.unsetPurchaseRequisitionStockDetail();

			Assertions.assertNotNull(purchaseOrderStockDetailEntity.getStockCatalogue());
			purchaseOrderStockDetailEntity.setStockCatalogueId(null);
			purchaseOrderStockDetailEntity.unsetStockCatalogue();

			Assertions.assertTrue(purchaseOrderStockDetailEntity.getGoodsReceiveNoteItems().size() > 0);
			purchaseOrderStockDetailEntity.setGoodsReceiveNoteItemsIds(new HashSet<UUID>());
			purchaseOrderStockDetailEntity.unsetGoodsReceiveNoteItems();


			updatedPurchaseOrderStockDetailEntity = purchaseOrderStockDetailService.updateOldData(purchaseOrderStockDetailEntity);

			Assertions.assertNull(updatedPurchaseOrderStockDetailEntity.getPurchaseOrder());

			Assertions.assertNull(updatedPurchaseOrderStockDetailEntity.getPurchaseRequisitionStockDetail());

			Assertions.assertNull(updatedPurchaseOrderStockDetailEntity.getStockCatalogue());

			Assertions.assertEquals(0, updatedPurchaseOrderStockDetailEntity.getGoodsReceiveNoteItems().size());

		});
	}

	@Test
	public void updateOldDataWithPurchaseOrderStockDetailEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity;
			PurchaseOrderStockDetailEntity updatedPurchaseOrderStockDetailEntity;

			PurchaseOrderEntity purchaseOrderEntity;

			PurchaseRequisitionStockDetailEntity purchaseRequisitionStockDetailEntity;

			StockCatalogueEntity stockCatalogueEntity;

			Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemsEntities;
			Set<UUID> goodsReceiveNoteItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				purchaseOrderStockDetailEntity = purchaseOrderStockDetailFactory.getObject(true, false);
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
				purchaseOrderDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderStockDetailEntity.getPurchaseOrder(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Purchase Order relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			purchaseOrderEntity = purchaseOrderRepository.findById(purchaseOrderRepository.save(purchaseOrderStockDetailEntity.getPurchaseOrder()).getId()).get();
			purchaseOrderStockDetailEntity.unsetPurchaseOrder();
			purchaseOrderStockDetailEntity.setPurchaseOrderId(purchaseOrderEntity.getId());

			try {
				purchaseRequisitionStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderStockDetailEntity.getPurchaseRequisitionStockDetail(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Purchase Requisition Stock Detail relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			purchaseRequisitionStockDetailEntity = purchaseRequisitionStockDetailRepository.findById(purchaseRequisitionStockDetailRepository.save(purchaseOrderStockDetailEntity.getPurchaseRequisitionStockDetail()).getId()).get();
			purchaseOrderStockDetailEntity.unsetPurchaseRequisitionStockDetail();
			purchaseOrderStockDetailEntity.setPurchaseRequisitionStockDetailId(purchaseRequisitionStockDetailEntity.getId());

			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderStockDetailEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(purchaseOrderStockDetailEntity.getStockCatalogue()).getId()).get();
			purchaseOrderStockDetailEntity.unsetStockCatalogue();
			purchaseOrderStockDetailEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			goodsReceiveNoteItemsEntities = new HashSet<>();
			goodsReceiveNoteItemsEntityIds = new HashSet<>();
			for (GoodsReceiveNoteItemEntity entity : purchaseOrderStockDetailEntity.getGoodsReceiveNoteItems()) {
				try {
					goodsReceiveNoteItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Goods Receive Note Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = goodsReceiveNoteItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				goodsReceiveNoteItemsEntities.add(goodsReceiveNoteItemRepository.findById(id).get());
				goodsReceiveNoteItemsEntityIds.add(id);
			}
			purchaseOrderStockDetailEntity.unsetGoodsReceiveNoteItems();
			purchaseOrderStockDetailEntity.setGoodsReceiveNoteItemsIds(goodsReceiveNoteItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPurchaseOrderStockDetailEntity = purchaseOrderStockDetailService.updateOldData(purchaseOrderStockDetailEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			purchaseOrderEntity.unsetPurchaseOrderStockDetails(false);
			updatedPurchaseOrderStockDetailEntity.getPurchaseOrder().unsetPurchaseOrderStockDetails(false);
			Assertions.assertEquals(purchaseOrderEntity, updatedPurchaseOrderStockDetailEntity.getPurchaseOrder());

			purchaseRequisitionStockDetailEntity.unsetPurchaseOrderStockDetails(false);
			updatedPurchaseOrderStockDetailEntity.getPurchaseRequisitionStockDetail().unsetPurchaseOrderStockDetails(false);
			Assertions.assertEquals(purchaseRequisitionStockDetailEntity, updatedPurchaseOrderStockDetailEntity.getPurchaseRequisitionStockDetail());

			stockCatalogueEntity.unsetPurchaseOrderStockDetails(false);
			updatedPurchaseOrderStockDetailEntity.getStockCatalogue().unsetPurchaseOrderStockDetails(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedPurchaseOrderStockDetailEntity.getStockCatalogue());

			Assertions.assertEquals(goodsReceiveNoteItemsEntities.size(), updatedPurchaseOrderStockDetailEntity.getGoodsReceiveNoteItems().size());

		});
	}

	@Test
	public void whenCreatePurchaseOrderStockDetailEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity;
			Optional<PurchaseOrderStockDetailEntity> fetchedPurchaseOrderStockDetailEntity;

			try {
				purchaseOrderStockDetailEntity = purchaseOrderStockDetailFactory.getObject(false, false);
				purchaseOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderStockDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseOrderStockDetailEntity = purchaseOrderStockDetailService.create(purchaseOrderStockDetailEntity);

			fetchedPurchaseOrderStockDetailEntity = purchaseOrderStockDetailService.findById(purchaseOrderStockDetailEntity.getId());

			Assertions.assertTrue(fetchedPurchaseOrderStockDetailEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPurchaseOrderStockDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(purchaseOrderStockDetailEntity, fetchedPurchaseOrderStockDetailEntity.get());
		});
	}

	@Test
	public void whenUpdatePurchaseOrderStockDetailEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity;
			PurchaseOrderStockDetailEntity updatedPurchaseOrderStockDetailEntity;
			Optional<PurchaseOrderStockDetailEntity> fetchedPurchaseOrderStockDetailEntity;

			try {
				purchaseOrderStockDetailEntity = purchaseOrderStockDetailFactory.getObject(false, false);
				purchaseOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderStockDetailEntity, true, true, false);
				updatedPurchaseOrderStockDetailEntity = purchaseOrderStockDetailFactory.getObject(false, false);
				purchaseOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPurchaseOrderStockDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseOrderStockDetailEntity = purchaseOrderStockDetailService.create(purchaseOrderStockDetailEntity);

			updatedPurchaseOrderStockDetailEntity.setId(purchaseOrderStockDetailEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPurchaseOrderStockDetailEntity.setCreated(purchaseOrderStockDetailEntity.getCreated());

			updatedPurchaseOrderStockDetailEntity = purchaseOrderStockDetailService.update(updatedPurchaseOrderStockDetailEntity);

			fetchedPurchaseOrderStockDetailEntity = purchaseOrderStockDetailService.findById(purchaseOrderStockDetailEntity.getId());

			Assertions.assertTrue(fetchedPurchaseOrderStockDetailEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePurchaseOrderStockDetailEntity_ThenEntityIsCreated
			fetchedPurchaseOrderStockDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPurchaseOrderStockDetailEntity, fetchedPurchaseOrderStockDetailEntity.get());
		});
	}

	@Test
	public void whenDeletePurchaseOrderStockDetailEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PurchaseOrderStockDetailEntity purchaseOrderStockDetailEntity;
			Optional<PurchaseOrderStockDetailEntity> fetchedPurchaseOrderStockDetailEntity;

			try {
				purchaseOrderStockDetailEntity = purchaseOrderStockDetailFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				purchaseOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(purchaseOrderStockDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			purchaseOrderStockDetailEntity = purchaseOrderStockDetailService.create(purchaseOrderStockDetailEntity);

			purchaseOrderStockDetailService.deleteById(purchaseOrderStockDetailEntity.getId());
			fetchedPurchaseOrderStockDetailEntity = purchaseOrderStockDetailService.findById(purchaseOrderStockDetailEntity.getId());

			Assertions.assertTrue(fetchedPurchaseOrderStockDetailEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
