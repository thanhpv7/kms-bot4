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
import kmsweb.entities.TransferOrderStockDetailEntity;
import kmsweb.repositories.TransferOrderStockDetailRepository;
import kmsweb.utils.TransferOrderStockDetailFactory;
import kmsweb.utils.DatabasePopulators.TransferOrderStockDetailDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.utils.StockCatalogueFactory;
import kmsweb.utils.DatabasePopulators.StockCatalogueDatabasePopulator;
import kmsweb.entities.TransferOrderEntity;
import kmsweb.repositories.TransferOrderRepository;
import kmsweb.utils.TransferOrderFactory;
import kmsweb.utils.DatabasePopulators.TransferOrderDatabasePopulator;
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
public class TransferOrderStockDetailServiceIntegrationTest {

	@Autowired
	private TransferOrderStockDetailRepository transferOrderStockDetailRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private TransferOrderStockDetailService transferOrderStockDetailService;

	private final TransferOrderStockDetailFactory transferOrderStockDetailFactory = new TransferOrderStockDetailFactory();

	@Autowired
	private TransferOrderStockDetailDatabasePopulator transferOrderStockDetailDatabasePopulator;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	private final StaffFactory staffFactory = new StaffFactory();

	@Autowired
	private StockCatalogueRepository stockCatalogueRepository;

	@Autowired
	private StockCatalogueDatabasePopulator stockCatalogueDatabasePopulator;

	private final StockCatalogueFactory stockCatalogueFactory = new StockCatalogueFactory();

	@Autowired
	private TransferOrderRepository transferOrderRepository;

	@Autowired
	private TransferOrderDatabasePopulator transferOrderDatabasePopulator;

	private final TransferOrderFactory transferOrderFactory = new TransferOrderFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		transferOrderStockDetailService = new TransferOrderStockDetailService(
			staffRepository,
			stockCatalogueRepository,
			transferOrderRepository,
			validator,
			auditRepository,
			transferOrderStockDetailRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewTransferOrderStockDetailEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		TransferOrderStockDetailEntity transferOrderStockDetailEntity = transferOrderStockDetailFactory.getObject(false, false);

		TransferOrderStockDetailEntity updatedEntity = transferOrderStockDetailService.updateOldData(transferOrderStockDetailEntity);
		Assertions.assertEquals(transferOrderStockDetailEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingTransferOrderStockDetailEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderStockDetailEntity transferOrderStockDetailEntity;
			TransferOrderStockDetailEntity entityWithUpdatedValues;

			try {
				transferOrderStockDetailEntity = transferOrderStockDetailFactory.getObject(false, false);
				transferOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderStockDetailEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = transferOrderStockDetailFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transferOrderStockDetailEntity = transferOrderStockDetailService.create(transferOrderStockDetailEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(transferOrderStockDetailEntity.getId());

			TransferOrderStockDetailEntity updatedEntity = transferOrderStockDetailService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithTransferOrderStockDetailEntityWithNonExistentId_ShouldThrowException() throws Exception {
		TransferOrderStockDetailEntity transferOrderStockDetailEntity = transferOrderStockDetailFactory.getObject(false, false);
		transferOrderStockDetailEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			transferOrderStockDetailService.updateOldData(transferOrderStockDetailEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingTransferOrderStockDetailEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderStockDetailEntity transferOrderStockDetailEntity;
			TransferOrderStockDetailEntity updatedTransferOrderStockDetailEntity;

			StaffEntity staffEntity;

			StockCatalogueEntity stockCatalogueEntity;

			TransferOrderEntity transferOrderEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				transferOrderStockDetailEntity = transferOrderStockDetailFactory.getObject(true, false);
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
			staffEntity = transferOrderStockDetailEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			transferOrderStockDetailEntity.setStaffId(staffEntity.getId());

			stockCatalogueEntity = transferOrderStockDetailEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			transferOrderStockDetailEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			transferOrderEntity = transferOrderStockDetailEntity.getTransferOrder();
			try {
				transferOrderDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			transferOrderEntity = transferOrderRepository.save(transferOrderEntity);
			transferOrderStockDetailEntity.setTransferOrderId(transferOrderEntity.getId());


			transferOrderStockDetailEntity = transferOrderStockDetailService.create(transferOrderStockDetailEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(transferOrderStockDetailEntity.getStaff());
			transferOrderStockDetailEntity.setStaffId(null);
			transferOrderStockDetailEntity.unsetStaff();

			Assertions.assertNotNull(transferOrderStockDetailEntity.getStockCatalogue());
			transferOrderStockDetailEntity.setStockCatalogueId(null);
			transferOrderStockDetailEntity.unsetStockCatalogue();

			Assertions.assertNotNull(transferOrderStockDetailEntity.getTransferOrder());
			transferOrderStockDetailEntity.setTransferOrderId(null);
			transferOrderStockDetailEntity.unsetTransferOrder();


			updatedTransferOrderStockDetailEntity = transferOrderStockDetailService.updateOldData(transferOrderStockDetailEntity);

			Assertions.assertNull(updatedTransferOrderStockDetailEntity.getStaff());

			Assertions.assertNull(updatedTransferOrderStockDetailEntity.getStockCatalogue());

			Assertions.assertNull(updatedTransferOrderStockDetailEntity.getTransferOrder());

		});
	}

	@Test
	public void updateOldDataWithTransferOrderStockDetailEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderStockDetailEntity transferOrderStockDetailEntity;
			TransferOrderStockDetailEntity updatedTransferOrderStockDetailEntity;

			StaffEntity staffEntity;

			StockCatalogueEntity stockCatalogueEntity;

			TransferOrderEntity transferOrderEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				transferOrderStockDetailEntity = transferOrderStockDetailFactory.getObject(true, false);
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
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderStockDetailEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(transferOrderStockDetailEntity.getStaff()).getId()).get();
			transferOrderStockDetailEntity.unsetStaff();
			transferOrderStockDetailEntity.setStaffId(staffEntity.getId());

			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderStockDetailEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(transferOrderStockDetailEntity.getStockCatalogue()).getId()).get();
			transferOrderStockDetailEntity.unsetStockCatalogue();
			transferOrderStockDetailEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			try {
				transferOrderDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderStockDetailEntity.getTransferOrder(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Transfer Order relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			transferOrderEntity = transferOrderRepository.findById(transferOrderRepository.save(transferOrderStockDetailEntity.getTransferOrder()).getId()).get();
			transferOrderStockDetailEntity.unsetTransferOrder();
			transferOrderStockDetailEntity.setTransferOrderId(transferOrderEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedTransferOrderStockDetailEntity = transferOrderStockDetailService.updateOldData(transferOrderStockDetailEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			staffEntity.unsetTransferOrderStockDetails(false);
			updatedTransferOrderStockDetailEntity.getStaff().unsetTransferOrderStockDetails(false);
			Assertions.assertEquals(staffEntity, updatedTransferOrderStockDetailEntity.getStaff());

			stockCatalogueEntity.unsetTransferOrderStockDetails(false);
			updatedTransferOrderStockDetailEntity.getStockCatalogue().unsetTransferOrderStockDetails(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedTransferOrderStockDetailEntity.getStockCatalogue());

			transferOrderEntity.unsetTransferOrderStockDetails(false);
			updatedTransferOrderStockDetailEntity.getTransferOrder().unsetTransferOrderStockDetails(false);
			Assertions.assertEquals(transferOrderEntity, updatedTransferOrderStockDetailEntity.getTransferOrder());

		});
	}

	@Test
	public void whenCreateTransferOrderStockDetailEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderStockDetailEntity transferOrderStockDetailEntity;
			Optional<TransferOrderStockDetailEntity> fetchedTransferOrderStockDetailEntity;

			try {
				transferOrderStockDetailEntity = transferOrderStockDetailFactory.getObject(false, false);
				transferOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderStockDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transferOrderStockDetailEntity = transferOrderStockDetailService.create(transferOrderStockDetailEntity);

			fetchedTransferOrderStockDetailEntity = transferOrderStockDetailService.findById(transferOrderStockDetailEntity.getId());

			Assertions.assertTrue(fetchedTransferOrderStockDetailEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedTransferOrderStockDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(transferOrderStockDetailEntity, fetchedTransferOrderStockDetailEntity.get());
		});
	}

	@Test
	public void whenUpdateTransferOrderStockDetailEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderStockDetailEntity transferOrderStockDetailEntity;
			TransferOrderStockDetailEntity updatedTransferOrderStockDetailEntity;
			Optional<TransferOrderStockDetailEntity> fetchedTransferOrderStockDetailEntity;

			try {
				transferOrderStockDetailEntity = transferOrderStockDetailFactory.getObject(false, false);
				transferOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderStockDetailEntity, true, true, false);
				updatedTransferOrderStockDetailEntity = transferOrderStockDetailFactory.getObject(false, false);
				transferOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(updatedTransferOrderStockDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transferOrderStockDetailEntity = transferOrderStockDetailService.create(transferOrderStockDetailEntity);

			updatedTransferOrderStockDetailEntity.setId(transferOrderStockDetailEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedTransferOrderStockDetailEntity.setCreated(transferOrderStockDetailEntity.getCreated());

			updatedTransferOrderStockDetailEntity = transferOrderStockDetailService.update(updatedTransferOrderStockDetailEntity);

			fetchedTransferOrderStockDetailEntity = transferOrderStockDetailService.findById(transferOrderStockDetailEntity.getId());

			Assertions.assertTrue(fetchedTransferOrderStockDetailEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateTransferOrderStockDetailEntity_ThenEntityIsCreated
			fetchedTransferOrderStockDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedTransferOrderStockDetailEntity, fetchedTransferOrderStockDetailEntity.get());
		});
	}

	@Test
	public void whenDeleteTransferOrderStockDetailEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			TransferOrderStockDetailEntity transferOrderStockDetailEntity;
			Optional<TransferOrderStockDetailEntity> fetchedTransferOrderStockDetailEntity;

			try {
				transferOrderStockDetailEntity = transferOrderStockDetailFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				transferOrderStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(transferOrderStockDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			transferOrderStockDetailEntity = transferOrderStockDetailService.create(transferOrderStockDetailEntity);

			transferOrderStockDetailService.deleteById(transferOrderStockDetailEntity.getId());
			fetchedTransferOrderStockDetailEntity = transferOrderStockDetailService.findById(transferOrderStockDetailEntity.getId());

			Assertions.assertTrue(fetchedTransferOrderStockDetailEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
