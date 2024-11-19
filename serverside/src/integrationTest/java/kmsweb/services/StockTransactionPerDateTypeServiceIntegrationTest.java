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
import kmsweb.entities.StockTransactionPerDateTypeEntity;
import kmsweb.repositories.StockTransactionPerDateTypeRepository;
import kmsweb.utils.StockTransactionPerDateTypeFactory;
import kmsweb.utils.DatabasePopulators.StockTransactionPerDateTypeDatabasePopulator;
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
public class StockTransactionPerDateTypeServiceIntegrationTest {

	@Autowired
	private StockTransactionPerDateTypeRepository stockTransactionPerDateTypeRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private StockTransactionPerDateTypeService stockTransactionPerDateTypeService;

	private final StockTransactionPerDateTypeFactory stockTransactionPerDateTypeFactory = new StockTransactionPerDateTypeFactory();

	@Autowired
	private StockTransactionPerDateTypeDatabasePopulator stockTransactionPerDateTypeDatabasePopulator;

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
		stockTransactionPerDateTypeService = new StockTransactionPerDateTypeService(
			stockCatalogueRepository,
			transactionDetailTypeRepository,
			warehouseRepository,
			validator,
			auditRepository,
			stockTransactionPerDateTypeRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewStockTransactionPerDateTypeEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		StockTransactionPerDateTypeEntity stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeFactory.getObject(false, false);

		StockTransactionPerDateTypeEntity updatedEntity = stockTransactionPerDateTypeService.updateOldData(stockTransactionPerDateTypeEntity);
		Assertions.assertEquals(stockTransactionPerDateTypeEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingStockTransactionPerDateTypeEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionPerDateTypeEntity stockTransactionPerDateTypeEntity;
			StockTransactionPerDateTypeEntity entityWithUpdatedValues;

			try {
				stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeFactory.getObject(false, false);
				stockTransactionPerDateTypeDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionPerDateTypeEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = stockTransactionPerDateTypeFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeService.create(stockTransactionPerDateTypeEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(stockTransactionPerDateTypeEntity.getId());

			StockTransactionPerDateTypeEntity updatedEntity = stockTransactionPerDateTypeService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithStockTransactionPerDateTypeEntityWithNonExistentId_ShouldThrowException() throws Exception {
		StockTransactionPerDateTypeEntity stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeFactory.getObject(false, false);
		stockTransactionPerDateTypeEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			stockTransactionPerDateTypeService.updateOldData(stockTransactionPerDateTypeEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingStockTransactionPerDateTypeEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionPerDateTypeEntity stockTransactionPerDateTypeEntity;
			StockTransactionPerDateTypeEntity updatedStockTransactionPerDateTypeEntity;

			StockCatalogueEntity stockCatalogueEntity;

			TransactionDetailTypeEntity transactionDetailTypeEntity;

			WarehouseEntity warehouseEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeFactory.getObject(true, false);
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
			stockCatalogueEntity = stockTransactionPerDateTypeEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			stockTransactionPerDateTypeEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			transactionDetailTypeEntity = stockTransactionPerDateTypeEntity.getTransactionDetailType();
			try {
				transactionDetailTypeDatabasePopulator.populateRelatedEntitiesInDatabase(transactionDetailTypeEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			transactionDetailTypeEntity = transactionDetailTypeRepository.save(transactionDetailTypeEntity);
			stockTransactionPerDateTypeEntity.setTransactionDetailTypeId(transactionDetailTypeEntity.getId());

			warehouseEntity = stockTransactionPerDateTypeEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			stockTransactionPerDateTypeEntity.setWarehouseId(warehouseEntity.getId());


			stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeService.create(stockTransactionPerDateTypeEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(stockTransactionPerDateTypeEntity.getStockCatalogue());
			stockTransactionPerDateTypeEntity.setStockCatalogueId(null);
			stockTransactionPerDateTypeEntity.unsetStockCatalogue();

			Assertions.assertNotNull(stockTransactionPerDateTypeEntity.getTransactionDetailType());
			stockTransactionPerDateTypeEntity.setTransactionDetailTypeId(null);
			stockTransactionPerDateTypeEntity.unsetTransactionDetailType();

			Assertions.assertNotNull(stockTransactionPerDateTypeEntity.getWarehouse());
			stockTransactionPerDateTypeEntity.setWarehouseId(null);
			stockTransactionPerDateTypeEntity.unsetWarehouse();


			updatedStockTransactionPerDateTypeEntity = stockTransactionPerDateTypeService.updateOldData(stockTransactionPerDateTypeEntity);

			Assertions.assertNull(updatedStockTransactionPerDateTypeEntity.getStockCatalogue());

			Assertions.assertNull(updatedStockTransactionPerDateTypeEntity.getTransactionDetailType());

			Assertions.assertNull(updatedStockTransactionPerDateTypeEntity.getWarehouse());

		});
	}

	@Test
	public void updateOldDataWithStockTransactionPerDateTypeEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionPerDateTypeEntity stockTransactionPerDateTypeEntity;
			StockTransactionPerDateTypeEntity updatedStockTransactionPerDateTypeEntity;

			StockCatalogueEntity stockCatalogueEntity;

			TransactionDetailTypeEntity transactionDetailTypeEntity;

			WarehouseEntity warehouseEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeFactory.getObject(true, false);
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
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionPerDateTypeEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(stockTransactionPerDateTypeEntity.getStockCatalogue()).getId()).get();
			stockTransactionPerDateTypeEntity.unsetStockCatalogue();
			stockTransactionPerDateTypeEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			try {
				transactionDetailTypeDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionPerDateTypeEntity.getTransactionDetailType(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Transaction Detail Type relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			transactionDetailTypeEntity = transactionDetailTypeRepository.findById(transactionDetailTypeRepository.save(stockTransactionPerDateTypeEntity.getTransactionDetailType()).getId()).get();
			stockTransactionPerDateTypeEntity.unsetTransactionDetailType();
			stockTransactionPerDateTypeEntity.setTransactionDetailTypeId(transactionDetailTypeEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionPerDateTypeEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(stockTransactionPerDateTypeEntity.getWarehouse()).getId()).get();
			stockTransactionPerDateTypeEntity.unsetWarehouse();
			stockTransactionPerDateTypeEntity.setWarehouseId(warehouseEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedStockTransactionPerDateTypeEntity = stockTransactionPerDateTypeService.updateOldData(stockTransactionPerDateTypeEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			stockCatalogueEntity.unsetStockTransactionPerDateTypes(false);
			updatedStockTransactionPerDateTypeEntity.getStockCatalogue().unsetStockTransactionPerDateTypes(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedStockTransactionPerDateTypeEntity.getStockCatalogue());

			transactionDetailTypeEntity.unsetStockTransactionPerDateTypes(false);
			updatedStockTransactionPerDateTypeEntity.getTransactionDetailType().unsetStockTransactionPerDateTypes(false);
			Assertions.assertEquals(transactionDetailTypeEntity, updatedStockTransactionPerDateTypeEntity.getTransactionDetailType());

			warehouseEntity.unsetStockTransactionPerDateTypes(false);
			updatedStockTransactionPerDateTypeEntity.getWarehouse().unsetStockTransactionPerDateTypes(false);
			Assertions.assertEquals(warehouseEntity, updatedStockTransactionPerDateTypeEntity.getWarehouse());

		});
	}

	@Test
	public void whenCreateStockTransactionPerDateTypeEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionPerDateTypeEntity stockTransactionPerDateTypeEntity;
			Optional<StockTransactionPerDateTypeEntity> fetchedStockTransactionPerDateTypeEntity;

			try {
				stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeFactory.getObject(false, false);
				stockTransactionPerDateTypeDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionPerDateTypeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeService.create(stockTransactionPerDateTypeEntity);

			fetchedStockTransactionPerDateTypeEntity = stockTransactionPerDateTypeService.findById(stockTransactionPerDateTypeEntity.getId());

			Assertions.assertTrue(fetchedStockTransactionPerDateTypeEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedStockTransactionPerDateTypeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(stockTransactionPerDateTypeEntity, fetchedStockTransactionPerDateTypeEntity.get());
		});
	}

	@Test
	public void whenUpdateStockTransactionPerDateTypeEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionPerDateTypeEntity stockTransactionPerDateTypeEntity;
			StockTransactionPerDateTypeEntity updatedStockTransactionPerDateTypeEntity;
			Optional<StockTransactionPerDateTypeEntity> fetchedStockTransactionPerDateTypeEntity;

			try {
				stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeFactory.getObject(false, false);
				stockTransactionPerDateTypeDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionPerDateTypeEntity, true, true, false);
				updatedStockTransactionPerDateTypeEntity = stockTransactionPerDateTypeFactory.getObject(false, false);
				stockTransactionPerDateTypeDatabasePopulator.populateRelatedEntitiesInDatabase(updatedStockTransactionPerDateTypeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeService.create(stockTransactionPerDateTypeEntity);

			updatedStockTransactionPerDateTypeEntity.setId(stockTransactionPerDateTypeEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedStockTransactionPerDateTypeEntity.setCreated(stockTransactionPerDateTypeEntity.getCreated());

			updatedStockTransactionPerDateTypeEntity = stockTransactionPerDateTypeService.update(updatedStockTransactionPerDateTypeEntity);

			fetchedStockTransactionPerDateTypeEntity = stockTransactionPerDateTypeService.findById(stockTransactionPerDateTypeEntity.getId());

			Assertions.assertTrue(fetchedStockTransactionPerDateTypeEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateStockTransactionPerDateTypeEntity_ThenEntityIsCreated
			fetchedStockTransactionPerDateTypeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedStockTransactionPerDateTypeEntity, fetchedStockTransactionPerDateTypeEntity.get());
		});
	}

	@Test
	public void whenDeleteStockTransactionPerDateTypeEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			StockTransactionPerDateTypeEntity stockTransactionPerDateTypeEntity;
			Optional<StockTransactionPerDateTypeEntity> fetchedStockTransactionPerDateTypeEntity;

			try {
				stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				stockTransactionPerDateTypeDatabasePopulator.populateRelatedEntitiesInDatabase(stockTransactionPerDateTypeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockTransactionPerDateTypeEntity = stockTransactionPerDateTypeService.create(stockTransactionPerDateTypeEntity);

			stockTransactionPerDateTypeService.deleteById(stockTransactionPerDateTypeEntity.getId());
			fetchedStockTransactionPerDateTypeEntity = stockTransactionPerDateTypeService.findById(stockTransactionPerDateTypeEntity.getId());

			Assertions.assertTrue(fetchedStockTransactionPerDateTypeEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
