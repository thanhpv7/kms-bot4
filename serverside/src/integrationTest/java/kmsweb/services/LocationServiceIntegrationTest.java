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
import kmsweb.entities.LocationEntity;
import kmsweb.repositories.LocationRepository;
import kmsweb.utils.LocationFactory;
import kmsweb.utils.DatabasePopulators.LocationDatabasePopulator;
import kmsweb.entities.StockControlEntity;
import kmsweb.repositories.StockControlRepository;
import kmsweb.utils.StockControlFactory;
import kmsweb.utils.DatabasePopulators.StockControlDatabasePopulator;
import kmsweb.entities.WarehouseEntity;
import kmsweb.repositories.WarehouseRepository;
import kmsweb.utils.WarehouseFactory;
import kmsweb.utils.DatabasePopulators.WarehouseDatabasePopulator;
import kmsweb.entities.WarehouseInitialStockEntity;
import kmsweb.repositories.WarehouseInitialStockRepository;
import kmsweb.utils.WarehouseInitialStockFactory;
import kmsweb.utils.DatabasePopulators.WarehouseInitialStockDatabasePopulator;
import kmsweb.entities.WarehouseInventoryEntity;
import kmsweb.repositories.WarehouseInventoryRepository;
import kmsweb.utils.WarehouseInventoryFactory;
import kmsweb.utils.DatabasePopulators.WarehouseInventoryDatabasePopulator;
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
public class LocationServiceIntegrationTest {

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private LocationService locationService;

	private final LocationFactory locationFactory = new LocationFactory();

	@Autowired
	private LocationDatabasePopulator locationDatabasePopulator;

	@Autowired
	private StockControlRepository stockControlRepository;

	@Autowired
	private StockControlDatabasePopulator stockControlDatabasePopulator;

	private final StockControlFactory stockControlFactory = new StockControlFactory();

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private WarehouseDatabasePopulator warehouseDatabasePopulator;

	private final WarehouseFactory warehouseFactory = new WarehouseFactory();

	@Autowired
	private WarehouseInitialStockRepository warehouseInitialStockRepository;

	@Autowired
	private WarehouseInitialStockDatabasePopulator warehouseInitialStockDatabasePopulator;

	private final WarehouseInitialStockFactory warehouseInitialStockFactory = new WarehouseInitialStockFactory();

	@Autowired
	private WarehouseInventoryRepository warehouseInventoryRepository;

	@Autowired
	private WarehouseInventoryDatabasePopulator warehouseInventoryDatabasePopulator;

	private final WarehouseInventoryFactory warehouseInventoryFactory = new WarehouseInventoryFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		locationService = new LocationService(
			stockControlRepository,
			warehouseRepository,
			warehouseInitialStockRepository,
			warehouseInventoryRepository,
			validator,
			auditRepository,
			locationRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewLocationEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		LocationEntity locationEntity = locationFactory.getObject(false, false);

		LocationEntity updatedEntity = locationService.updateOldData(locationEntity);
		Assertions.assertEquals(locationEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingLocationEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			LocationEntity locationEntity;
			LocationEntity entityWithUpdatedValues;

			try {
				locationEntity = locationFactory.getObject(false, false);
				locationDatabasePopulator.populateRelatedEntitiesInDatabase(locationEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = locationFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			locationEntity = locationService.create(locationEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(locationEntity.getId());

			LocationEntity updatedEntity = locationService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithLocationEntityWithNonExistentId_ShouldThrowException() throws Exception {
		LocationEntity locationEntity = locationFactory.getObject(false, false);
		locationEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			locationService.updateOldData(locationEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingLocationEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			LocationEntity locationEntity;
			LocationEntity updatedLocationEntity;

			WarehouseEntity warehouseEntity;

			Set<StockControlEntity> stockControlsEntities;

			Set<WarehouseInitialStockEntity> warehouseInitialStockSEntities;

			Set<WarehouseInventoryEntity> warehouseInventoriesEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				locationEntity = locationFactory.getObject(true, false);
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
			warehouseEntity = locationEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			locationEntity.setWarehouseId(warehouseEntity.getId());

			stockControlsEntities = locationEntity.getStockControls();
			Set<UUID> stockControlsEntityIds = new HashSet<>();
			for (StockControlEntity entity : stockControlsEntities) {
				try {
					stockControlDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				stockControlsEntityIds.add(stockControlRepository.save(entity).getId());
			}
			locationEntity.setStockControlsIds(stockControlsEntityIds);

			warehouseInitialStockSEntities = locationEntity.getWarehouseInitialStockS();
			Set<UUID> warehouseInitialStockSEntityIds = new HashSet<>();
			for (WarehouseInitialStockEntity entity : warehouseInitialStockSEntities) {
				try {
					warehouseInitialStockDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				warehouseInitialStockSEntityIds.add(warehouseInitialStockRepository.save(entity).getId());
			}
			locationEntity.setWarehouseInitialStockSIds(warehouseInitialStockSEntityIds);

			warehouseInventoriesEntities = locationEntity.getWarehouseInventories();
			Set<UUID> warehouseInventoriesEntityIds = new HashSet<>();
			for (WarehouseInventoryEntity entity : warehouseInventoriesEntities) {
				try {
					warehouseInventoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				warehouseInventoriesEntityIds.add(warehouseInventoryRepository.save(entity).getId());
			}
			locationEntity.setWarehouseInventoriesIds(warehouseInventoriesEntityIds);


			locationEntity = locationService.create(locationEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(locationEntity.getWarehouse());
			locationEntity.setWarehouseId(null);
			locationEntity.unsetWarehouse();

			Assertions.assertTrue(locationEntity.getStockControls().size() > 0);
			locationEntity.setStockControlsIds(new HashSet<UUID>());
			locationEntity.unsetStockControls();

			Assertions.assertTrue(locationEntity.getWarehouseInitialStockS().size() > 0);
			locationEntity.setWarehouseInitialStockSIds(new HashSet<UUID>());
			locationEntity.unsetWarehouseInitialStockS();

			Assertions.assertTrue(locationEntity.getWarehouseInventories().size() > 0);
			locationEntity.setWarehouseInventoriesIds(new HashSet<UUID>());
			locationEntity.unsetWarehouseInventories();


			updatedLocationEntity = locationService.updateOldData(locationEntity);

			Assertions.assertNull(updatedLocationEntity.getWarehouse());

			Assertions.assertEquals(0, updatedLocationEntity.getStockControls().size());

			Assertions.assertEquals(0, updatedLocationEntity.getWarehouseInitialStockS().size());

			Assertions.assertEquals(0, updatedLocationEntity.getWarehouseInventories().size());

		});
	}

	@Test
	public void updateOldDataWithLocationEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			LocationEntity locationEntity;
			LocationEntity updatedLocationEntity;

			WarehouseEntity warehouseEntity;

			Set<StockControlEntity> stockControlsEntities;
			Set<UUID> stockControlsEntityIds;

			Set<WarehouseInitialStockEntity> warehouseInitialStockSEntities;
			Set<UUID> warehouseInitialStockSEntityIds;

			Set<WarehouseInventoryEntity> warehouseInventoriesEntities;
			Set<UUID> warehouseInventoriesEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				locationEntity = locationFactory.getObject(true, false);
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
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(locationEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(locationEntity.getWarehouse()).getId()).get();
			locationEntity.unsetWarehouse();
			locationEntity.setWarehouseId(warehouseEntity.getId());

			stockControlsEntities = new HashSet<>();
			stockControlsEntityIds = new HashSet<>();
			for (StockControlEntity entity : locationEntity.getStockControls()) {
				try {
					stockControlDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Stock Controls relation for this test: " + e.getCause());
					return;
				}
				UUID id = stockControlRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				stockControlsEntities.add(stockControlRepository.findById(id).get());
				stockControlsEntityIds.add(id);
			}
			locationEntity.unsetStockControls();
			locationEntity.setStockControlsIds(stockControlsEntityIds);

			warehouseInitialStockSEntities = new HashSet<>();
			warehouseInitialStockSEntityIds = new HashSet<>();
			for (WarehouseInitialStockEntity entity : locationEntity.getWarehouseInitialStockS()) {
				try {
					warehouseInitialStockDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Warehouse Initial Stock s relation for this test: " + e.getCause());
					return;
				}
				UUID id = warehouseInitialStockRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				warehouseInitialStockSEntities.add(warehouseInitialStockRepository.findById(id).get());
				warehouseInitialStockSEntityIds.add(id);
			}
			locationEntity.unsetWarehouseInitialStockS();
			locationEntity.setWarehouseInitialStockSIds(warehouseInitialStockSEntityIds);

			warehouseInventoriesEntities = new HashSet<>();
			warehouseInventoriesEntityIds = new HashSet<>();
			for (WarehouseInventoryEntity entity : locationEntity.getWarehouseInventories()) {
				try {
					warehouseInventoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Warehouse Inventories relation for this test: " + e.getCause());
					return;
				}
				UUID id = warehouseInventoryRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				warehouseInventoriesEntities.add(warehouseInventoryRepository.findById(id).get());
				warehouseInventoriesEntityIds.add(id);
			}
			locationEntity.unsetWarehouseInventories();
			locationEntity.setWarehouseInventoriesIds(warehouseInventoriesEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedLocationEntity = locationService.updateOldData(locationEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			warehouseEntity.unsetLocations(false);
			updatedLocationEntity.getWarehouse().unsetLocations(false);
			Assertions.assertEquals(warehouseEntity, updatedLocationEntity.getWarehouse());

			Assertions.assertEquals(stockControlsEntities.size(), updatedLocationEntity.getStockControls().size());

			Assertions.assertEquals(warehouseInitialStockSEntities.size(), updatedLocationEntity.getWarehouseInitialStockS().size());

			Assertions.assertEquals(warehouseInventoriesEntities.size(), updatedLocationEntity.getWarehouseInventories().size());

		});
	}

	@Test
	public void whenCreateLocationEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			LocationEntity locationEntity;
			Optional<LocationEntity> fetchedLocationEntity;

			try {
				locationEntity = locationFactory.getObject(false, false);
				locationDatabasePopulator.populateRelatedEntitiesInDatabase(locationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			locationEntity = locationService.create(locationEntity);

			fetchedLocationEntity = locationService.findById(locationEntity.getId());

			Assertions.assertTrue(fetchedLocationEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedLocationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(locationEntity, fetchedLocationEntity.get());
		});
	}

	@Test
	public void whenUpdateLocationEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			LocationEntity locationEntity;
			LocationEntity updatedLocationEntity;
			Optional<LocationEntity> fetchedLocationEntity;

			try {
				locationEntity = locationFactory.getObject(false, false);
				locationDatabasePopulator.populateRelatedEntitiesInDatabase(locationEntity, true, true, false);
				updatedLocationEntity = locationFactory.getObject(false, false);
				locationDatabasePopulator.populateRelatedEntitiesInDatabase(updatedLocationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			locationEntity = locationService.create(locationEntity);

			updatedLocationEntity.setId(locationEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedLocationEntity.setCreated(locationEntity.getCreated());

			updatedLocationEntity = locationService.update(updatedLocationEntity);

			fetchedLocationEntity = locationService.findById(locationEntity.getId());

			Assertions.assertTrue(fetchedLocationEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateLocationEntity_ThenEntityIsCreated
			fetchedLocationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedLocationEntity, fetchedLocationEntity.get());
		});
	}

	@Test
	public void whenDeleteLocationEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			LocationEntity locationEntity;
			Optional<LocationEntity> fetchedLocationEntity;

			try {
				locationEntity = locationFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				locationDatabasePopulator.populateRelatedEntitiesInDatabase(locationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			locationEntity = locationService.create(locationEntity);

			locationService.deleteById(locationEntity.getId());
			fetchedLocationEntity = locationService.findById(locationEntity.getId());

			Assertions.assertTrue(fetchedLocationEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
