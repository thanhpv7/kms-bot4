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
import kmsweb.entities.StockControlEntity;
import kmsweb.repositories.StockControlRepository;
import kmsweb.utils.StockControlFactory;
import kmsweb.utils.DatabasePopulators.StockControlDatabasePopulator;
import kmsweb.entities.LocationEntity;
import kmsweb.repositories.LocationRepository;
import kmsweb.utils.LocationFactory;
import kmsweb.utils.DatabasePopulators.LocationDatabasePopulator;
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
public class StockControlServiceIntegrationTest {

	@Autowired
	private StockControlRepository stockControlRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private StockControlService stockControlService;

	private final StockControlFactory stockControlFactory = new StockControlFactory();

	@Autowired
	private StockControlDatabasePopulator stockControlDatabasePopulator;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private LocationDatabasePopulator locationDatabasePopulator;

	private final LocationFactory locationFactory = new LocationFactory();

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
		stockControlService = new StockControlService(
			locationRepository,
			stockCatalogueRepository,
			warehouseRepository,
			validator,
			auditRepository,
			stockControlRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewStockControlEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		StockControlEntity stockControlEntity = stockControlFactory.getObject(false, false);

		StockControlEntity updatedEntity = stockControlService.updateOldData(stockControlEntity);
		Assertions.assertEquals(stockControlEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingStockControlEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			StockControlEntity stockControlEntity;
			StockControlEntity entityWithUpdatedValues;

			try {
				stockControlEntity = stockControlFactory.getObject(false, false);
				stockControlDatabasePopulator.populateRelatedEntitiesInDatabase(stockControlEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = stockControlFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockControlEntity = stockControlService.create(stockControlEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(stockControlEntity.getId());

			StockControlEntity updatedEntity = stockControlService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithStockControlEntityWithNonExistentId_ShouldThrowException() throws Exception {
		StockControlEntity stockControlEntity = stockControlFactory.getObject(false, false);
		stockControlEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			stockControlService.updateOldData(stockControlEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingStockControlEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			StockControlEntity stockControlEntity;
			StockControlEntity updatedStockControlEntity;

			LocationEntity locationEntity;

			StockCatalogueEntity stockCatalogueEntity;

			WarehouseEntity warehouseEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				stockControlEntity = stockControlFactory.getObject(true, false);
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
			locationEntity = stockControlEntity.getLocation();
			try {
				locationDatabasePopulator.populateRelatedEntitiesInDatabase(locationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			locationEntity = locationRepository.save(locationEntity);
			stockControlEntity.setLocationId(locationEntity.getId());

			stockCatalogueEntity = stockControlEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			stockControlEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			warehouseEntity = stockControlEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			stockControlEntity.setWarehouseId(warehouseEntity.getId());


			stockControlEntity = stockControlService.create(stockControlEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(stockControlEntity.getLocation());
			stockControlEntity.setLocationId(null);
			stockControlEntity.unsetLocation();

			Assertions.assertNotNull(stockControlEntity.getStockCatalogue());
			stockControlEntity.setStockCatalogueId(null);
			stockControlEntity.unsetStockCatalogue();

			Assertions.assertNotNull(stockControlEntity.getWarehouse());
			stockControlEntity.setWarehouseId(null);
			stockControlEntity.unsetWarehouse();


			updatedStockControlEntity = stockControlService.updateOldData(stockControlEntity);

			Assertions.assertNull(updatedStockControlEntity.getLocation());

			Assertions.assertNull(updatedStockControlEntity.getStockCatalogue());

			Assertions.assertNull(updatedStockControlEntity.getWarehouse());

		});
	}

	@Test
	public void updateOldDataWithStockControlEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			StockControlEntity stockControlEntity;
			StockControlEntity updatedStockControlEntity;

			LocationEntity locationEntity;

			StockCatalogueEntity stockCatalogueEntity;

			WarehouseEntity warehouseEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				stockControlEntity = stockControlFactory.getObject(true, false);
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
				locationDatabasePopulator.populateRelatedEntitiesInDatabase(stockControlEntity.getLocation(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Location relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			locationEntity = locationRepository.findById(locationRepository.save(stockControlEntity.getLocation()).getId()).get();
			stockControlEntity.unsetLocation();
			stockControlEntity.setLocationId(locationEntity.getId());

			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockControlEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(stockControlEntity.getStockCatalogue()).getId()).get();
			stockControlEntity.unsetStockCatalogue();
			stockControlEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(stockControlEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(stockControlEntity.getWarehouse()).getId()).get();
			stockControlEntity.unsetWarehouse();
			stockControlEntity.setWarehouseId(warehouseEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedStockControlEntity = stockControlService.updateOldData(stockControlEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			locationEntity.unsetStockControls(false);
			updatedStockControlEntity.getLocation().unsetStockControls(false);
			Assertions.assertEquals(locationEntity, updatedStockControlEntity.getLocation());

			stockCatalogueEntity.unsetStockControls(false);
			updatedStockControlEntity.getStockCatalogue().unsetStockControls(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedStockControlEntity.getStockCatalogue());

			warehouseEntity.unsetStockControls(false);
			updatedStockControlEntity.getWarehouse().unsetStockControls(false);
			Assertions.assertEquals(warehouseEntity, updatedStockControlEntity.getWarehouse());

		});
	}

	@Test
	public void whenCreateStockControlEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			StockControlEntity stockControlEntity;
			Optional<StockControlEntity> fetchedStockControlEntity;

			try {
				stockControlEntity = stockControlFactory.getObject(false, false);
				stockControlDatabasePopulator.populateRelatedEntitiesInDatabase(stockControlEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockControlEntity = stockControlService.create(stockControlEntity);

			fetchedStockControlEntity = stockControlService.findById(stockControlEntity.getId());

			Assertions.assertTrue(fetchedStockControlEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedStockControlEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(stockControlEntity, fetchedStockControlEntity.get());
		});
	}

	@Test
	public void whenUpdateStockControlEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			StockControlEntity stockControlEntity;
			StockControlEntity updatedStockControlEntity;
			Optional<StockControlEntity> fetchedStockControlEntity;

			try {
				stockControlEntity = stockControlFactory.getObject(false, false);
				stockControlDatabasePopulator.populateRelatedEntitiesInDatabase(stockControlEntity, true, true, false);
				updatedStockControlEntity = stockControlFactory.getObject(false, false);
				stockControlDatabasePopulator.populateRelatedEntitiesInDatabase(updatedStockControlEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockControlEntity = stockControlService.create(stockControlEntity);

			updatedStockControlEntity.setId(stockControlEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedStockControlEntity.setCreated(stockControlEntity.getCreated());

			updatedStockControlEntity = stockControlService.update(updatedStockControlEntity);

			fetchedStockControlEntity = stockControlService.findById(stockControlEntity.getId());

			Assertions.assertTrue(fetchedStockControlEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateStockControlEntity_ThenEntityIsCreated
			fetchedStockControlEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedStockControlEntity, fetchedStockControlEntity.get());
		});
	}

	@Test
	public void whenDeleteStockControlEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			StockControlEntity stockControlEntity;
			Optional<StockControlEntity> fetchedStockControlEntity;

			try {
				stockControlEntity = stockControlFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				stockControlDatabasePopulator.populateRelatedEntitiesInDatabase(stockControlEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			stockControlEntity = stockControlService.create(stockControlEntity);

			stockControlService.deleteById(stockControlEntity.getId());
			fetchedStockControlEntity = stockControlService.findById(stockControlEntity.getId());

			Assertions.assertTrue(fetchedStockControlEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
