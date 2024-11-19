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
import kmsweb.entities.InternalOrderEntity;
import kmsweb.repositories.InternalOrderRepository;
import kmsweb.utils.InternalOrderFactory;
import kmsweb.utils.DatabasePopulators.InternalOrderDatabasePopulator;
import kmsweb.entities.InternalOrderStockDetailEntity;
import kmsweb.repositories.InternalOrderStockDetailRepository;
import kmsweb.utils.InternalOrderStockDetailFactory;
import kmsweb.utils.DatabasePopulators.InternalOrderStockDetailDatabasePopulator;
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
public class InternalOrderServiceIntegrationTest {

	@Autowired
	private InternalOrderRepository internalOrderRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InternalOrderService internalOrderService;

	private final InternalOrderFactory internalOrderFactory = new InternalOrderFactory();

	@Autowired
	private InternalOrderDatabasePopulator internalOrderDatabasePopulator;

	@Autowired
	private InternalOrderStockDetailRepository internalOrderStockDetailRepository;

	@Autowired
	private InternalOrderStockDetailDatabasePopulator internalOrderStockDetailDatabasePopulator;

	private final InternalOrderStockDetailFactory internalOrderStockDetailFactory = new InternalOrderStockDetailFactory();

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
		internalOrderService = new InternalOrderService(
			internalOrderStockDetailRepository,
			warehouseRepository,
			validator,
			auditRepository,
			internalOrderRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInternalOrderEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InternalOrderEntity internalOrderEntity = internalOrderFactory.getObject(false, false);

		InternalOrderEntity updatedEntity = internalOrderService.updateOldData(internalOrderEntity);
		Assertions.assertEquals(internalOrderEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingInternalOrderEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InternalOrderEntity internalOrderEntity;
			InternalOrderEntity entityWithUpdatedValues;

			try {
				internalOrderEntity = internalOrderFactory.getObject(false, false);
				internalOrderDatabasePopulator.populateRelatedEntitiesInDatabase(internalOrderEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = internalOrderFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			internalOrderEntity = internalOrderService.create(internalOrderEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(internalOrderEntity.getId());

			InternalOrderEntity updatedEntity = internalOrderService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInternalOrderEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InternalOrderEntity internalOrderEntity = internalOrderFactory.getObject(false, false);
		internalOrderEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			internalOrderService.updateOldData(internalOrderEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInternalOrderEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InternalOrderEntity internalOrderEntity;
			InternalOrderEntity updatedInternalOrderEntity;

			WarehouseEntity warehouseEntity;

			Set<InternalOrderStockDetailEntity> internalOrderStockDetailsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				internalOrderEntity = internalOrderFactory.getObject(true, false);
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
			warehouseEntity = internalOrderEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			internalOrderEntity.setWarehouseId(warehouseEntity.getId());

			internalOrderStockDetailsEntities = internalOrderEntity.getInternalOrderStockDetails();
			Set<UUID> internalOrderStockDetailsEntityIds = new HashSet<>();
			for (InternalOrderStockDetailEntity entity : internalOrderStockDetailsEntities) {
				try {
					internalOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				internalOrderStockDetailsEntityIds.add(internalOrderStockDetailRepository.save(entity).getId());
			}
			internalOrderEntity.setInternalOrderStockDetailsIds(internalOrderStockDetailsEntityIds);


			internalOrderEntity = internalOrderService.create(internalOrderEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(internalOrderEntity.getWarehouse());
			internalOrderEntity.setWarehouseId(null);
			internalOrderEntity.unsetWarehouse();

			Assertions.assertTrue(internalOrderEntity.getInternalOrderStockDetails().size() > 0);
			internalOrderEntity.setInternalOrderStockDetailsIds(new HashSet<UUID>());
			internalOrderEntity.unsetInternalOrderStockDetails();


			updatedInternalOrderEntity = internalOrderService.updateOldData(internalOrderEntity);

			Assertions.assertNull(updatedInternalOrderEntity.getWarehouse());

			Assertions.assertEquals(0, updatedInternalOrderEntity.getInternalOrderStockDetails().size());

		});
	}

	@Test
	public void updateOldDataWithInternalOrderEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InternalOrderEntity internalOrderEntity;
			InternalOrderEntity updatedInternalOrderEntity;

			WarehouseEntity warehouseEntity;

			Set<InternalOrderStockDetailEntity> internalOrderStockDetailsEntities;
			Set<UUID> internalOrderStockDetailsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				internalOrderEntity = internalOrderFactory.getObject(true, false);
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
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(internalOrderEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(internalOrderEntity.getWarehouse()).getId()).get();
			internalOrderEntity.unsetWarehouse();
			internalOrderEntity.setWarehouseId(warehouseEntity.getId());

			internalOrderStockDetailsEntities = new HashSet<>();
			internalOrderStockDetailsEntityIds = new HashSet<>();
			for (InternalOrderStockDetailEntity entity : internalOrderEntity.getInternalOrderStockDetails()) {
				try {
					internalOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Internal Order Stock Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = internalOrderStockDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				internalOrderStockDetailsEntities.add(internalOrderStockDetailRepository.findById(id).get());
				internalOrderStockDetailsEntityIds.add(id);
			}
			internalOrderEntity.unsetInternalOrderStockDetails();
			internalOrderEntity.setInternalOrderStockDetailsIds(internalOrderStockDetailsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInternalOrderEntity = internalOrderService.updateOldData(internalOrderEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			warehouseEntity.unsetInternalOrders(false);
			updatedInternalOrderEntity.getWarehouse().unsetInternalOrders(false);
			Assertions.assertEquals(warehouseEntity, updatedInternalOrderEntity.getWarehouse());

			Assertions.assertEquals(internalOrderStockDetailsEntities.size(), updatedInternalOrderEntity.getInternalOrderStockDetails().size());

		});
	}

	@Test
	public void whenCreateInternalOrderEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InternalOrderEntity internalOrderEntity;
			Optional<InternalOrderEntity> fetchedInternalOrderEntity;

			try {
				internalOrderEntity = internalOrderFactory.getObject(false, false);
				internalOrderDatabasePopulator.populateRelatedEntitiesInDatabase(internalOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			internalOrderEntity = internalOrderService.create(internalOrderEntity);

			fetchedInternalOrderEntity = internalOrderService.findById(internalOrderEntity.getId());

			Assertions.assertTrue(fetchedInternalOrderEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInternalOrderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(internalOrderEntity, fetchedInternalOrderEntity.get());
		});
	}

	@Test
	public void whenUpdateInternalOrderEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InternalOrderEntity internalOrderEntity;
			InternalOrderEntity updatedInternalOrderEntity;
			Optional<InternalOrderEntity> fetchedInternalOrderEntity;

			try {
				internalOrderEntity = internalOrderFactory.getObject(false, false);
				internalOrderDatabasePopulator.populateRelatedEntitiesInDatabase(internalOrderEntity, true, true, false);
				updatedInternalOrderEntity = internalOrderFactory.getObject(false, false);
				internalOrderDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInternalOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			internalOrderEntity = internalOrderService.create(internalOrderEntity);

			updatedInternalOrderEntity.setId(internalOrderEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInternalOrderEntity.setCreated(internalOrderEntity.getCreated());

			updatedInternalOrderEntity = internalOrderService.update(updatedInternalOrderEntity);

			fetchedInternalOrderEntity = internalOrderService.findById(internalOrderEntity.getId());

			Assertions.assertTrue(fetchedInternalOrderEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInternalOrderEntity_ThenEntityIsCreated
			fetchedInternalOrderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInternalOrderEntity, fetchedInternalOrderEntity.get());
		});
	}

	@Test
	public void whenDeleteInternalOrderEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InternalOrderEntity internalOrderEntity;
			Optional<InternalOrderEntity> fetchedInternalOrderEntity;

			try {
				internalOrderEntity = internalOrderFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				internalOrderDatabasePopulator.populateRelatedEntitiesInDatabase(internalOrderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			internalOrderEntity = internalOrderService.create(internalOrderEntity);

			internalOrderService.deleteById(internalOrderEntity.getId());
			fetchedInternalOrderEntity = internalOrderService.findById(internalOrderEntity.getId());

			Assertions.assertTrue(fetchedInternalOrderEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
