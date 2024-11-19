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
import kmsweb.entities.TransactionDetailTypeEntity;
import kmsweb.repositories.TransactionDetailTypeRepository;
import kmsweb.utils.TransactionDetailTypeFactory;
import kmsweb.utils.DatabasePopulators.TransactionDetailTypeDatabasePopulator;
import kmsweb.entities.InventoryAdjustmentEntity;
import kmsweb.repositories.InventoryAdjustmentRepository;
import kmsweb.utils.InventoryAdjustmentFactory;
import kmsweb.utils.DatabasePopulators.InventoryAdjustmentDatabasePopulator;
import kmsweb.entities.StockTransactionDetailEntity;
import kmsweb.repositories.StockTransactionDetailRepository;
import kmsweb.utils.StockTransactionDetailFactory;
import kmsweb.utils.DatabasePopulators.StockTransactionDetailDatabasePopulator;
import kmsweb.entities.StockTransactionPerDateTypeEntity;
import kmsweb.repositories.StockTransactionPerDateTypeRepository;
import kmsweb.utils.StockTransactionPerDateTypeFactory;
import kmsweb.utils.DatabasePopulators.StockTransactionPerDateTypeDatabasePopulator;
import kmsweb.entities.TransactionDetailTypeMappingEntity;
import kmsweb.repositories.TransactionDetailTypeMappingRepository;
import kmsweb.utils.TransactionDetailTypeMappingFactory;
import kmsweb.utils.DatabasePopulators.TransactionDetailTypeMappingDatabasePopulator;
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
public class TransactionDetailTypeServiceIntegrationTest {

	@Autowired
	private TransactionDetailTypeRepository transactionDetailTypeRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private TransactionDetailTypeService transactionDetailTypeService;

	private final TransactionDetailTypeFactory transactionDetailTypeFactory = new TransactionDetailTypeFactory();

	@Autowired
	private TransactionDetailTypeDatabasePopulator transactionDetailTypeDatabasePopulator;

	@Autowired
	private InventoryAdjustmentRepository inventoryAdjustmentRepository;

	@Autowired
	private InventoryAdjustmentDatabasePopulator inventoryAdjustmentDatabasePopulator;

	private final InventoryAdjustmentFactory inventoryAdjustmentFactory = new InventoryAdjustmentFactory();

	@Autowired
	private StockTransactionDetailRepository stockTransactionDetailRepository;

	@Autowired
	private StockTransactionDetailDatabasePopulator stockTransactionDetailDatabasePopulator;

	private final StockTransactionDetailFactory stockTransactionDetailFactory = new StockTransactionDetailFactory();

	@Autowired
	private StockTransactionPerDateTypeRepository stockTransactionPerDateTypeRepository;

	@Autowired
	private StockTransactionPerDateTypeDatabasePopulator stockTransactionPerDateTypeDatabasePopulator;

	private final StockTransactionPerDateTypeFactory stockTransactionPerDateTypeFactory = new StockTransactionPerDateTypeFactory();

	@Autowired
	private TransactionDetailTypeMappingRepository transactionDetailTypeMappingRepository;

	@Autowired
	private TransactionDetailTypeMappingDatabasePopulator transactionDetailTypeMappingDatabasePopulator;

	private final TransactionDetailTypeMappingFactory transactionDetailTypeMappingFactory = new TransactionDetailTypeMappingFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		transactionDetailTypeService = new TransactionDetailTypeService(
			inventoryAdjustmentRepository,
			stockTransactionDetailRepository,
			stockTransactionPerDateTypeRepository,
			transactionDetailTypeMappingRepository,
			validator,
			auditRepository,
			transactionDetailTypeRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewTransactionDetailTypeEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		TransactionDetailTypeEntity transactionDetailTypeEntity = transactionDetailTypeFactory.getObject(false, false);

		TransactionDetailTypeEntity updatedEntity = transactionDetailTypeService.updateOldData(transactionDetailTypeEntity);
		Assertions.assertEquals(transactionDetailTypeEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingTransactionDetailTypeEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			TransactionDetailTypeEntity transactionDetailTypeEntity;
			TransactionDetailTypeEntity entityWithUpdatedValues;

			try {
				transactionDetailTypeEntity = transactionDetailTypeFactory.getObject(false, false);
				transactionDetailTypeDatabasePopulator.populateRelatedEntitiesInDatabase(transactionDetailTypeEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = transactionDetailTypeFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transactionDetailTypeEntity = transactionDetailTypeService.create(transactionDetailTypeEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(transactionDetailTypeEntity.getId());

			TransactionDetailTypeEntity updatedEntity = transactionDetailTypeService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithTransactionDetailTypeEntityWithNonExistentId_ShouldThrowException() throws Exception {
		TransactionDetailTypeEntity transactionDetailTypeEntity = transactionDetailTypeFactory.getObject(false, false);
		transactionDetailTypeEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			transactionDetailTypeService.updateOldData(transactionDetailTypeEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingTransactionDetailTypeEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TransactionDetailTypeEntity transactionDetailTypeEntity;
			TransactionDetailTypeEntity updatedTransactionDetailTypeEntity;

			Set<InventoryAdjustmentEntity> inventoryAdjustmentsEntities;

			Set<StockTransactionDetailEntity> stockTransactionDetailsEntities;

			Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypesEntities;

			Set<TransactionDetailTypeMappingEntity> transactionDetailTypeMappingsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				transactionDetailTypeEntity = transactionDetailTypeFactory.getObject(true, false);
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
			inventoryAdjustmentsEntities = transactionDetailTypeEntity.getInventoryAdjustments();
			Set<UUID> inventoryAdjustmentsEntityIds = new HashSet<>();
			for (InventoryAdjustmentEntity entity : inventoryAdjustmentsEntities) {
				try {
					inventoryAdjustmentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				inventoryAdjustmentsEntityIds.add(inventoryAdjustmentRepository.save(entity).getId());
			}
			transactionDetailTypeEntity.setInventoryAdjustmentsIds(inventoryAdjustmentsEntityIds);

			stockTransactionDetailsEntities = transactionDetailTypeEntity.getStockTransactionDetails();
			Set<UUID> stockTransactionDetailsEntityIds = new HashSet<>();
			for (StockTransactionDetailEntity entity : stockTransactionDetailsEntities) {
				try {
					stockTransactionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				stockTransactionDetailsEntityIds.add(stockTransactionDetailRepository.save(entity).getId());
			}
			transactionDetailTypeEntity.setStockTransactionDetailsIds(stockTransactionDetailsEntityIds);

			stockTransactionPerDateTypesEntities = transactionDetailTypeEntity.getStockTransactionPerDateTypes();
			Set<UUID> stockTransactionPerDateTypesEntityIds = new HashSet<>();
			for (StockTransactionPerDateTypeEntity entity : stockTransactionPerDateTypesEntities) {
				try {
					stockTransactionPerDateTypeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				stockTransactionPerDateTypesEntityIds.add(stockTransactionPerDateTypeRepository.save(entity).getId());
			}
			transactionDetailTypeEntity.setStockTransactionPerDateTypesIds(stockTransactionPerDateTypesEntityIds);

			transactionDetailTypeMappingsEntities = transactionDetailTypeEntity.getTransactionDetailTypeMappings();
			Set<UUID> transactionDetailTypeMappingsEntityIds = new HashSet<>();
			for (TransactionDetailTypeMappingEntity entity : transactionDetailTypeMappingsEntities) {
				try {
					transactionDetailTypeMappingDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				transactionDetailTypeMappingsEntityIds.add(transactionDetailTypeMappingRepository.save(entity).getId());
			}
			transactionDetailTypeEntity.setTransactionDetailTypeMappingsIds(transactionDetailTypeMappingsEntityIds);


			transactionDetailTypeEntity = transactionDetailTypeService.create(transactionDetailTypeEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(transactionDetailTypeEntity.getInventoryAdjustments().size() > 0);
			transactionDetailTypeEntity.setInventoryAdjustmentsIds(new HashSet<UUID>());
			transactionDetailTypeEntity.unsetInventoryAdjustments();

			Assertions.assertTrue(transactionDetailTypeEntity.getStockTransactionDetails().size() > 0);
			transactionDetailTypeEntity.setStockTransactionDetailsIds(new HashSet<UUID>());
			transactionDetailTypeEntity.unsetStockTransactionDetails();

			Assertions.assertTrue(transactionDetailTypeEntity.getStockTransactionPerDateTypes().size() > 0);
			transactionDetailTypeEntity.setStockTransactionPerDateTypesIds(new HashSet<UUID>());
			transactionDetailTypeEntity.unsetStockTransactionPerDateTypes();

			Assertions.assertTrue(transactionDetailTypeEntity.getTransactionDetailTypeMappings().size() > 0);
			transactionDetailTypeEntity.setTransactionDetailTypeMappingsIds(new HashSet<UUID>());
			transactionDetailTypeEntity.unsetTransactionDetailTypeMappings();


			updatedTransactionDetailTypeEntity = transactionDetailTypeService.updateOldData(transactionDetailTypeEntity);

			Assertions.assertEquals(0, updatedTransactionDetailTypeEntity.getInventoryAdjustments().size());

			Assertions.assertEquals(0, updatedTransactionDetailTypeEntity.getStockTransactionDetails().size());

			Assertions.assertEquals(0, updatedTransactionDetailTypeEntity.getStockTransactionPerDateTypes().size());

			Assertions.assertEquals(0, updatedTransactionDetailTypeEntity.getTransactionDetailTypeMappings().size());

		});
	}

	@Test
	public void updateOldDataWithTransactionDetailTypeEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TransactionDetailTypeEntity transactionDetailTypeEntity;
			TransactionDetailTypeEntity updatedTransactionDetailTypeEntity;

			Set<InventoryAdjustmentEntity> inventoryAdjustmentsEntities;
			Set<UUID> inventoryAdjustmentsEntityIds;

			Set<StockTransactionDetailEntity> stockTransactionDetailsEntities;
			Set<UUID> stockTransactionDetailsEntityIds;

			Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypesEntities;
			Set<UUID> stockTransactionPerDateTypesEntityIds;

			Set<TransactionDetailTypeMappingEntity> transactionDetailTypeMappingsEntities;
			Set<UUID> transactionDetailTypeMappingsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				transactionDetailTypeEntity = transactionDetailTypeFactory.getObject(true, false);
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
			inventoryAdjustmentsEntities = new HashSet<>();
			inventoryAdjustmentsEntityIds = new HashSet<>();
			for (InventoryAdjustmentEntity entity : transactionDetailTypeEntity.getInventoryAdjustments()) {
				try {
					inventoryAdjustmentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Inventory Adjustments relation for this test: " + e.getCause());
					return;
				}
				UUID id = inventoryAdjustmentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				inventoryAdjustmentsEntities.add(inventoryAdjustmentRepository.findById(id).get());
				inventoryAdjustmentsEntityIds.add(id);
			}
			transactionDetailTypeEntity.unsetInventoryAdjustments();
			transactionDetailTypeEntity.setInventoryAdjustmentsIds(inventoryAdjustmentsEntityIds);

			stockTransactionDetailsEntities = new HashSet<>();
			stockTransactionDetailsEntityIds = new HashSet<>();
			for (StockTransactionDetailEntity entity : transactionDetailTypeEntity.getStockTransactionDetails()) {
				try {
					stockTransactionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Stock Transaction Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = stockTransactionDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				stockTransactionDetailsEntities.add(stockTransactionDetailRepository.findById(id).get());
				stockTransactionDetailsEntityIds.add(id);
			}
			transactionDetailTypeEntity.unsetStockTransactionDetails();
			transactionDetailTypeEntity.setStockTransactionDetailsIds(stockTransactionDetailsEntityIds);

			stockTransactionPerDateTypesEntities = new HashSet<>();
			stockTransactionPerDateTypesEntityIds = new HashSet<>();
			for (StockTransactionPerDateTypeEntity entity : transactionDetailTypeEntity.getStockTransactionPerDateTypes()) {
				try {
					stockTransactionPerDateTypeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Stock Transaction Per Date Types relation for this test: " + e.getCause());
					return;
				}
				UUID id = stockTransactionPerDateTypeRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				stockTransactionPerDateTypesEntities.add(stockTransactionPerDateTypeRepository.findById(id).get());
				stockTransactionPerDateTypesEntityIds.add(id);
			}
			transactionDetailTypeEntity.unsetStockTransactionPerDateTypes();
			transactionDetailTypeEntity.setStockTransactionPerDateTypesIds(stockTransactionPerDateTypesEntityIds);

			transactionDetailTypeMappingsEntities = new HashSet<>();
			transactionDetailTypeMappingsEntityIds = new HashSet<>();
			for (TransactionDetailTypeMappingEntity entity : transactionDetailTypeEntity.getTransactionDetailTypeMappings()) {
				try {
					transactionDetailTypeMappingDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Transaction Detail Type Mappings relation for this test: " + e.getCause());
					return;
				}
				UUID id = transactionDetailTypeMappingRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				transactionDetailTypeMappingsEntities.add(transactionDetailTypeMappingRepository.findById(id).get());
				transactionDetailTypeMappingsEntityIds.add(id);
			}
			transactionDetailTypeEntity.unsetTransactionDetailTypeMappings();
			transactionDetailTypeEntity.setTransactionDetailTypeMappingsIds(transactionDetailTypeMappingsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedTransactionDetailTypeEntity = transactionDetailTypeService.updateOldData(transactionDetailTypeEntity);

			Assertions.assertEquals(inventoryAdjustmentsEntities.size(), updatedTransactionDetailTypeEntity.getInventoryAdjustments().size());

			Assertions.assertEquals(stockTransactionDetailsEntities.size(), updatedTransactionDetailTypeEntity.getStockTransactionDetails().size());

			Assertions.assertEquals(stockTransactionPerDateTypesEntities.size(), updatedTransactionDetailTypeEntity.getStockTransactionPerDateTypes().size());

			Assertions.assertEquals(transactionDetailTypeMappingsEntities.size(), updatedTransactionDetailTypeEntity.getTransactionDetailTypeMappings().size());

		});
	}

	@Test
	public void whenCreateTransactionDetailTypeEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			TransactionDetailTypeEntity transactionDetailTypeEntity;
			Optional<TransactionDetailTypeEntity> fetchedTransactionDetailTypeEntity;

			try {
				transactionDetailTypeEntity = transactionDetailTypeFactory.getObject(false, false);
				transactionDetailTypeDatabasePopulator.populateRelatedEntitiesInDatabase(transactionDetailTypeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transactionDetailTypeEntity = transactionDetailTypeService.create(transactionDetailTypeEntity);

			fetchedTransactionDetailTypeEntity = transactionDetailTypeService.findById(transactionDetailTypeEntity.getId());

			Assertions.assertTrue(fetchedTransactionDetailTypeEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedTransactionDetailTypeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(transactionDetailTypeEntity, fetchedTransactionDetailTypeEntity.get());
		});
	}

	@Test
	public void whenUpdateTransactionDetailTypeEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			TransactionDetailTypeEntity transactionDetailTypeEntity;
			TransactionDetailTypeEntity updatedTransactionDetailTypeEntity;
			Optional<TransactionDetailTypeEntity> fetchedTransactionDetailTypeEntity;

			try {
				transactionDetailTypeEntity = transactionDetailTypeFactory.getObject(false, false);
				transactionDetailTypeDatabasePopulator.populateRelatedEntitiesInDatabase(transactionDetailTypeEntity, true, true, false);
				updatedTransactionDetailTypeEntity = transactionDetailTypeFactory.getObject(false, false);
				transactionDetailTypeDatabasePopulator.populateRelatedEntitiesInDatabase(updatedTransactionDetailTypeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transactionDetailTypeEntity = transactionDetailTypeService.create(transactionDetailTypeEntity);

			updatedTransactionDetailTypeEntity.setId(transactionDetailTypeEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedTransactionDetailTypeEntity.setCreated(transactionDetailTypeEntity.getCreated());

			updatedTransactionDetailTypeEntity = transactionDetailTypeService.update(updatedTransactionDetailTypeEntity);

			fetchedTransactionDetailTypeEntity = transactionDetailTypeService.findById(transactionDetailTypeEntity.getId());

			Assertions.assertTrue(fetchedTransactionDetailTypeEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateTransactionDetailTypeEntity_ThenEntityIsCreated
			fetchedTransactionDetailTypeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedTransactionDetailTypeEntity, fetchedTransactionDetailTypeEntity.get());
		});
	}

	@Test
	public void whenDeleteTransactionDetailTypeEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			TransactionDetailTypeEntity transactionDetailTypeEntity;
			Optional<TransactionDetailTypeEntity> fetchedTransactionDetailTypeEntity;

			try {
				transactionDetailTypeEntity = transactionDetailTypeFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				transactionDetailTypeDatabasePopulator.populateRelatedEntitiesInDatabase(transactionDetailTypeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transactionDetailTypeEntity = transactionDetailTypeService.create(transactionDetailTypeEntity);

			transactionDetailTypeService.deleteById(transactionDetailTypeEntity.getId());
			fetchedTransactionDetailTypeEntity = transactionDetailTypeService.findById(transactionDetailTypeEntity.getId());

			Assertions.assertTrue(fetchedTransactionDetailTypeEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
