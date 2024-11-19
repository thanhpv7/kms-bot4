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
import kmsweb.entities.TransferOrderEntity;
import kmsweb.repositories.TransferOrderRepository;
import kmsweb.utils.TransferOrderFactory;
import kmsweb.utils.DatabasePopulators.TransferOrderDatabasePopulator;
import kmsweb.entities.TransferOrderStockDetailEntity;
import kmsweb.repositories.TransferOrderStockDetailRepository;
import kmsweb.utils.TransferOrderStockDetailFactory;
import kmsweb.utils.DatabasePopulators.TransferOrderStockDetailDatabasePopulator;
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
public class TransferOrderServiceIntegrationTest {

	@Autowired
	private TransferOrderRepository transferOrderRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private TransferOrderService transferOrderService;

	private final TransferOrderFactory transferOrderFactory = new TransferOrderFactory();

	@Autowired
	private TransferOrderDatabasePopulator transferOrderDatabasePopulator;

	@Autowired
	private TransferOrderStockDetailRepository transferOrderStockDetailRepository;

	@Autowired
	private TransferOrderStockDetailDatabasePopulator transferOrderStockDetailDatabasePopulator;

	private final TransferOrderStockDetailFactory transferOrderStockDetailFactory = new TransferOrderStockDetailFactory();

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
		transferOrderService = new TransferOrderService(
			transferOrderStockDetailRepository,
			warehouseRepository,
			validator,
			auditRepository,
			transferOrderRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewTransferOrderEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		TransferOrderEntity transferOrderEntity = transferOrderFactory.getObject(false, false);

		TransferOrderEntity updatedEntity = transferOrderService.updateOldData(transferOrderEntity);
		Assertions.assertEquals(transferOrderEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingTransferOrderEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderEntity transferOrderEntity;
			TransferOrderEntity entityWithUpdatedValues;

			try {
				transferOrderEntity = transferOrderFactory.getObject(false, false);
				transferOrderDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = transferOrderFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transferOrderEntity = transferOrderService.create(transferOrderEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(transferOrderEntity.getId());

			TransferOrderEntity updatedEntity = transferOrderService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithTransferOrderEntityWithNonExistentId_ShouldThrowException() throws Exception {
		TransferOrderEntity transferOrderEntity = transferOrderFactory.getObject(false, false);
		transferOrderEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			transferOrderService.updateOldData(transferOrderEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingTransferOrderEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderEntity transferOrderEntity;
			TransferOrderEntity updatedTransferOrderEntity;

			WarehouseEntity destinationWarehouseEntity;

			WarehouseEntity sourceWarehouseEntity;

			Set<TransferOrderStockDetailEntity> transferOrderStockDetailsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				transferOrderEntity = transferOrderFactory.getObject(true, false);
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
			destinationWarehouseEntity = transferOrderEntity.getDestinationWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(destinationWarehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			destinationWarehouseEntity = warehouseRepository.save(destinationWarehouseEntity);
			transferOrderEntity.setDestinationWarehouseId(destinationWarehouseEntity.getId());

			sourceWarehouseEntity = transferOrderEntity.getSourceWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(sourceWarehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			sourceWarehouseEntity = warehouseRepository.save(sourceWarehouseEntity);
			transferOrderEntity.setSourceWarehouseId(sourceWarehouseEntity.getId());

			transferOrderStockDetailsEntities = transferOrderEntity.getTransferOrderStockDetails();
			Set<UUID> transferOrderStockDetailsEntityIds = new HashSet<>();
			for (TransferOrderStockDetailEntity entity : transferOrderStockDetailsEntities) {
				try {
					transferOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				transferOrderStockDetailsEntityIds.add(transferOrderStockDetailRepository.save(entity).getId());
			}
			transferOrderEntity.setTransferOrderStockDetailsIds(transferOrderStockDetailsEntityIds);


			transferOrderEntity = transferOrderService.create(transferOrderEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(transferOrderEntity.getDestinationWarehouse());
			transferOrderEntity.setDestinationWarehouseId(null);
			transferOrderEntity.unsetDestinationWarehouse();

			Assertions.assertNotNull(transferOrderEntity.getSourceWarehouse());
			transferOrderEntity.setSourceWarehouseId(null);
			transferOrderEntity.unsetSourceWarehouse();

			Assertions.assertTrue(transferOrderEntity.getTransferOrderStockDetails().size() > 0);
			transferOrderEntity.setTransferOrderStockDetailsIds(new HashSet<UUID>());
			transferOrderEntity.unsetTransferOrderStockDetails();


			updatedTransferOrderEntity = transferOrderService.updateOldData(transferOrderEntity);

			Assertions.assertNull(updatedTransferOrderEntity.getDestinationWarehouse());

			Assertions.assertNull(updatedTransferOrderEntity.getSourceWarehouse());

			Assertions.assertEquals(0, updatedTransferOrderEntity.getTransferOrderStockDetails().size());

		});
	}

	@Test
	public void updateOldDataWithTransferOrderEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderEntity transferOrderEntity;
			TransferOrderEntity updatedTransferOrderEntity;

			WarehouseEntity destinationWarehouseEntity;

			WarehouseEntity sourceWarehouseEntity;

			Set<TransferOrderStockDetailEntity> transferOrderStockDetailsEntities;
			Set<UUID> transferOrderStockDetailsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				transferOrderEntity = transferOrderFactory.getObject(true, false);
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
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderEntity.getDestinationWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Destination Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			destinationWarehouseEntity = warehouseRepository.findById(warehouseRepository.save(transferOrderEntity.getDestinationWarehouse()).getId()).get();
			transferOrderEntity.unsetDestinationWarehouse();
			transferOrderEntity.setDestinationWarehouseId(destinationWarehouseEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderEntity.getSourceWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Source Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			sourceWarehouseEntity = warehouseRepository.findById(warehouseRepository.save(transferOrderEntity.getSourceWarehouse()).getId()).get();
			transferOrderEntity.unsetSourceWarehouse();
			transferOrderEntity.setSourceWarehouseId(sourceWarehouseEntity.getId());

			transferOrderStockDetailsEntities = new HashSet<>();
			transferOrderStockDetailsEntityIds = new HashSet<>();
			for (TransferOrderStockDetailEntity entity : transferOrderEntity.getTransferOrderStockDetails()) {
				try {
					transferOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Transfer Order Stock Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = transferOrderStockDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				transferOrderStockDetailsEntities.add(transferOrderStockDetailRepository.findById(id).get());
				transferOrderStockDetailsEntityIds.add(id);
			}
			transferOrderEntity.unsetTransferOrderStockDetails();
			transferOrderEntity.setTransferOrderStockDetailsIds(transferOrderStockDetailsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedTransferOrderEntity = transferOrderService.updateOldData(transferOrderEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			destinationWarehouseEntity.unsetDestinationWarehouses(false);
			updatedTransferOrderEntity.getDestinationWarehouse().unsetDestinationWarehouses(false);
			Assertions.assertEquals(destinationWarehouseEntity, updatedTransferOrderEntity.getDestinationWarehouse());

			sourceWarehouseEntity.unsetSourceWarehouses(false);
			updatedTransferOrderEntity.getSourceWarehouse().unsetSourceWarehouses(false);
			Assertions.assertEquals(sourceWarehouseEntity, updatedTransferOrderEntity.getSourceWarehouse());

			Assertions.assertEquals(transferOrderStockDetailsEntities.size(), updatedTransferOrderEntity.getTransferOrderStockDetails().size());

		});
	}

	@Test
	public void whenCreateTransferOrderEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderEntity transferOrderEntity;
			Optional<TransferOrderEntity> fetchedTransferOrderEntity;

			try {
				transferOrderEntity = transferOrderFactory.getObject(false, false);
				transferOrderDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transferOrderEntity = transferOrderService.create(transferOrderEntity);

			fetchedTransferOrderEntity = transferOrderService.findById(transferOrderEntity.getId());

			Assertions.assertTrue(fetchedTransferOrderEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedTransferOrderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(transferOrderEntity, fetchedTransferOrderEntity.get());
		});
	}

	@Test
	public void whenUpdateTransferOrderEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderEntity transferOrderEntity;
			TransferOrderEntity updatedTransferOrderEntity;
			Optional<TransferOrderEntity> fetchedTransferOrderEntity;

			try {
				transferOrderEntity = transferOrderFactory.getObject(false, false);
				transferOrderDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderEntity, true, true, false);
				updatedTransferOrderEntity = transferOrderFactory.getObject(false, false);
				transferOrderDatabasePopulator.populateRelatedEntitiesInDatabase(updatedTransferOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transferOrderEntity = transferOrderService.create(transferOrderEntity);

			updatedTransferOrderEntity.setId(transferOrderEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedTransferOrderEntity.setCreated(transferOrderEntity.getCreated());

			updatedTransferOrderEntity = transferOrderService.update(updatedTransferOrderEntity);

			fetchedTransferOrderEntity = transferOrderService.findById(transferOrderEntity.getId());

			Assertions.assertTrue(fetchedTransferOrderEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateTransferOrderEntity_ThenEntityIsCreated
			fetchedTransferOrderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedTransferOrderEntity, fetchedTransferOrderEntity.get());
		});
	}

	@Test
	public void whenDeleteTransferOrderEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderEntity transferOrderEntity;
			Optional<TransferOrderEntity> fetchedTransferOrderEntity;

			try {
				transferOrderEntity = transferOrderFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				transferOrderDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transferOrderEntity = transferOrderService.create(transferOrderEntity);

			transferOrderService.deleteById(transferOrderEntity.getId());
			fetchedTransferOrderEntity = transferOrderService.findById(transferOrderEntity.getId());

			Assertions.assertTrue(fetchedTransferOrderEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
