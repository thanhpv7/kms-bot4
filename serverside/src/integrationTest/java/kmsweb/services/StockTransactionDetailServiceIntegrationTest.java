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
import kmsweb.entities.StockTransactionDetailEntity;
import kmsweb.repositories.StockTransactionDetailRepository;
import kmsweb.utils.StockTransactionDetailFactory;
import kmsweb.utils.DatabasePopulators.StockTransactionDetailDatabasePopulator;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.utils.StockCatalogueFactory;
import kmsweb.utils.DatabasePopulators.StockCatalogueDatabasePopulator;
import kmsweb.entities.TransactionDetailTypeEntity;
import kmsweb.repositories.TransactionDetailTypeRepository;
import kmsweb.utils.TransactionDetailTypeFactory;
import kmsweb.utils.DatabasePopulators.TransactionDetailTypeDatabasePopulator;
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
public class StockTransactionDetailServiceIntegrationTest {

	@Autowired
	private StockTransactionDetailRepository stockTransactionDetailRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private StockTransactionDetailService stockTransactionDetailService;

	private final StockTransactionDetailFactory stockTransactionDetailFactory = new StockTransactionDetailFactory();

	@Autowired
	private StockTransactionDetailDatabasePopulator stockTransactionDetailDatabasePopulator;

	@Autowired
	private StockCatalogueRepository stockCatalogueRepository;

	@Autowired
	private StockCatalogueDatabasePopulator stockCatalogueDatabasePopulator;

	private final StockCatalogueFactory stockCatalogueFactory = new StockCatalogueFactory();

	@Autowired
	private TransactionDetailTypeRepository transactionDetailTypeRepository;

	@Autowired
	private TransactionDetailTypeDatabasePopulator transactionDetailTypeDatabasePopulator;

	private final TransactionDetailTypeFactory transactionDetailTypeFactory = new TransactionDetailTypeFactory();

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
		stockTransactionDetailService = new StockTransactionDetailService(
			stockCatalogueRepository,
			transactionDetailTypeRepository,
			warehouseRepository,
			validator,
			auditRepository,
			stockTransactionDetailRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewStockTransactionDetailEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		StockTransactionDetailEntity stockTransactionDetailEntity = stockTransactionDetailFactory.getObject(false, false);

		StockTransactionDetailEntity updatedEntity = stockTransactionDetailService.updateOldData(stockTransactionDetailEntity);
		Assertions.assertEquals(stockTransactionDetailEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingStockTransactionDetailEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionDetailEntity stockTransactionDetailEntity;
			StockTransactionDetailEntity entityWithUpdatedValues;

			try {
				stockTransactionDetailEntity = stockTransactionDetailFactory.getObject(false, false);
				stockTransactionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionDetailEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = stockTransactionDetailFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockTransactionDetailEntity = stockTransactionDetailService.create(stockTransactionDetailEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(stockTransactionDetailEntity.getId());

			StockTransactionDetailEntity updatedEntity = stockTransactionDetailService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithStockTransactionDetailEntityWithNonExistentId_ShouldThrowException() throws Exception {
		StockTransactionDetailEntity stockTransactionDetailEntity = stockTransactionDetailFactory.getObject(false, false);
		stockTransactionDetailEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			stockTransactionDetailService.updateOldData(stockTransactionDetailEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingStockTransactionDetailEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionDetailEntity stockTransactionDetailEntity;
			StockTransactionDetailEntity updatedStockTransactionDetailEntity;

			StockCatalogueEntity stockCatalogueEntity;

			TransactionDetailTypeEntity transactionDetailTypeEntity;

			WarehouseEntity warehouseEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				stockTransactionDetailEntity = stockTransactionDetailFactory.getObject(true, false);
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
			stockCatalogueEntity = stockTransactionDetailEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			stockTransactionDetailEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			transactionDetailTypeEntity = stockTransactionDetailEntity.getTransactionDetailType();
			try {
				transactionDetailTypeDatabasePopulator.populateRelatedEntitiesInDatabase(transactionDetailTypeEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			transactionDetailTypeEntity = transactionDetailTypeRepository.save(transactionDetailTypeEntity);
			stockTransactionDetailEntity.setTransactionDetailTypeId(transactionDetailTypeEntity.getId());

			warehouseEntity = stockTransactionDetailEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			stockTransactionDetailEntity.setWarehouseId(warehouseEntity.getId());


			stockTransactionDetailEntity = stockTransactionDetailService.create(stockTransactionDetailEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(stockTransactionDetailEntity.getStockCatalogue());
			stockTransactionDetailEntity.setStockCatalogueId(null);
			stockTransactionDetailEntity.unsetStockCatalogue();

			Assertions.assertNotNull(stockTransactionDetailEntity.getTransactionDetailType());
			stockTransactionDetailEntity.setTransactionDetailTypeId(null);
			stockTransactionDetailEntity.unsetTransactionDetailType();

			Assertions.assertNotNull(stockTransactionDetailEntity.getWarehouse());
			stockTransactionDetailEntity.setWarehouseId(null);
			stockTransactionDetailEntity.unsetWarehouse();


			updatedStockTransactionDetailEntity = stockTransactionDetailService.updateOldData(stockTransactionDetailEntity);

			Assertions.assertNull(updatedStockTransactionDetailEntity.getStockCatalogue());

			Assertions.assertNull(updatedStockTransactionDetailEntity.getTransactionDetailType());

			Assertions.assertNull(updatedStockTransactionDetailEntity.getWarehouse());

		});
	}

	@Test
	public void updateOldDataWithStockTransactionDetailEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionDetailEntity stockTransactionDetailEntity;
			StockTransactionDetailEntity updatedStockTransactionDetailEntity;

			StockCatalogueEntity stockCatalogueEntity;

			TransactionDetailTypeEntity transactionDetailTypeEntity;

			WarehouseEntity warehouseEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				stockTransactionDetailEntity = stockTransactionDetailFactory.getObject(true, false);
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
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionDetailEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(stockTransactionDetailEntity.getStockCatalogue()).getId()).get();
			stockTransactionDetailEntity.unsetStockCatalogue();
			stockTransactionDetailEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			try {
				transactionDetailTypeDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionDetailEntity.getTransactionDetailType(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Transaction Detail Type relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			transactionDetailTypeEntity = transactionDetailTypeRepository.findById(transactionDetailTypeRepository.save(stockTransactionDetailEntity.getTransactionDetailType()).getId()).get();
			stockTransactionDetailEntity.unsetTransactionDetailType();
			stockTransactionDetailEntity.setTransactionDetailTypeId(transactionDetailTypeEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionDetailEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(stockTransactionDetailEntity.getWarehouse()).getId()).get();
			stockTransactionDetailEntity.unsetWarehouse();
			stockTransactionDetailEntity.setWarehouseId(warehouseEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedStockTransactionDetailEntity = stockTransactionDetailService.updateOldData(stockTransactionDetailEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			stockCatalogueEntity.unsetStockTransactionDetails(false);
			updatedStockTransactionDetailEntity.getStockCatalogue().unsetStockTransactionDetails(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedStockTransactionDetailEntity.getStockCatalogue());

			transactionDetailTypeEntity.unsetStockTransactionDetails(false);
			updatedStockTransactionDetailEntity.getTransactionDetailType().unsetStockTransactionDetails(false);
			Assertions.assertEquals(transactionDetailTypeEntity, updatedStockTransactionDetailEntity.getTransactionDetailType());

			warehouseEntity.unsetStockTransactionDetails(false);
			updatedStockTransactionDetailEntity.getWarehouse().unsetStockTransactionDetails(false);
			Assertions.assertEquals(warehouseEntity, updatedStockTransactionDetailEntity.getWarehouse());

		});
	}

	@Test
	public void whenCreateStockTransactionDetailEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionDetailEntity stockTransactionDetailEntity;
			Optional<StockTransactionDetailEntity> fetchedStockTransactionDetailEntity;

			try {
				stockTransactionDetailEntity = stockTransactionDetailFactory.getObject(false, false);
				stockTransactionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockTransactionDetailEntity = stockTransactionDetailService.create(stockTransactionDetailEntity);

			fetchedStockTransactionDetailEntity = stockTransactionDetailService.findById(stockTransactionDetailEntity.getId());

			Assertions.assertTrue(fetchedStockTransactionDetailEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedStockTransactionDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(stockTransactionDetailEntity, fetchedStockTransactionDetailEntity.get());
		});
	}

	@Test
	public void whenUpdateStockTransactionDetailEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionDetailEntity stockTransactionDetailEntity;
			StockTransactionDetailEntity updatedStockTransactionDetailEntity;
			Optional<StockTransactionDetailEntity> fetchedStockTransactionDetailEntity;

			try {
				stockTransactionDetailEntity = stockTransactionDetailFactory.getObject(false, false);
				stockTransactionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionDetailEntity, true, true, false);
				updatedStockTransactionDetailEntity = stockTransactionDetailFactory.getObject(false, false);
				stockTransactionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(updatedStockTransactionDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockTransactionDetailEntity = stockTransactionDetailService.create(stockTransactionDetailEntity);

			updatedStockTransactionDetailEntity.setId(stockTransactionDetailEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedStockTransactionDetailEntity.setCreated(stockTransactionDetailEntity.getCreated());

			updatedStockTransactionDetailEntity = stockTransactionDetailService.update(updatedStockTransactionDetailEntity);

			fetchedStockTransactionDetailEntity = stockTransactionDetailService.findById(stockTransactionDetailEntity.getId());

			Assertions.assertTrue(fetchedStockTransactionDetailEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateStockTransactionDetailEntity_ThenEntityIsCreated
			fetchedStockTransactionDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedStockTransactionDetailEntity, fetchedStockTransactionDetailEntity.get());
		});
	}

	@Test
	public void whenDeleteStockTransactionDetailEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionDetailEntity stockTransactionDetailEntity;
			Optional<StockTransactionDetailEntity> fetchedStockTransactionDetailEntity;

			try {
				stockTransactionDetailEntity = stockTransactionDetailFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				stockTransactionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockTransactionDetailEntity = stockTransactionDetailService.create(stockTransactionDetailEntity);

			stockTransactionDetailService.deleteById(stockTransactionDetailEntity.getId());
			fetchedStockTransactionDetailEntity = stockTransactionDetailService.findById(stockTransactionDetailEntity.getId());

			Assertions.assertTrue(fetchedStockTransactionDetailEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
