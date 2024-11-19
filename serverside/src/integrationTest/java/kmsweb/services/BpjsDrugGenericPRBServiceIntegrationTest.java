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
import kmsweb.entities.BpjsDrugGenericPRBEntity;
import kmsweb.repositories.BpjsDrugGenericPRBRepository;
import kmsweb.utils.BpjsDrugGenericPRBFactory;
import kmsweb.utils.DatabasePopulators.BpjsDrugGenericPRBDatabasePopulator;
import kmsweb.entities.BpjsPRBDetailEntity;
import kmsweb.repositories.BpjsPRBDetailRepository;
import kmsweb.utils.BpjsPRBDetailFactory;
import kmsweb.utils.DatabasePopulators.BpjsPRBDetailDatabasePopulator;
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
public class BpjsDrugGenericPRBServiceIntegrationTest {

	@Autowired
	private BpjsDrugGenericPRBRepository bpjsDrugGenericPRBRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsDrugGenericPRBService bpjsDrugGenericPRBService;

	private final BpjsDrugGenericPRBFactory bpjsDrugGenericPRBFactory = new BpjsDrugGenericPRBFactory();

	@Autowired
	private BpjsDrugGenericPRBDatabasePopulator bpjsDrugGenericPRBDatabasePopulator;

	@Autowired
	private BpjsPRBDetailRepository bpjsPRBDetailRepository;

	@Autowired
	private BpjsPRBDetailDatabasePopulator bpjsPRBDetailDatabasePopulator;

	private final BpjsPRBDetailFactory bpjsPRBDetailFactory = new BpjsPRBDetailFactory();

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
		bpjsDrugGenericPRBService = new BpjsDrugGenericPRBService(
			bpjsPRBDetailRepository,
			stockCatalogueRepository,
			validator,
			auditRepository,
			bpjsDrugGenericPRBRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsDrugGenericPRBEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBFactory.getObject(false, false);

		BpjsDrugGenericPRBEntity updatedEntity = bpjsDrugGenericPRBService.updateOldData(bpjsDrugGenericPRBEntity);
		Assertions.assertEquals(bpjsDrugGenericPRBEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsDrugGenericPRBEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntity;
			BpjsDrugGenericPRBEntity entityWithUpdatedValues;

			try {
				bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBFactory.getObject(false, false);
				bpjsDrugGenericPRBDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDrugGenericPRBEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsDrugGenericPRBFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBService.create(bpjsDrugGenericPRBEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsDrugGenericPRBEntity.getId());

			BpjsDrugGenericPRBEntity updatedEntity = bpjsDrugGenericPRBService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsDrugGenericPRBEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBFactory.getObject(false, false);
		bpjsDrugGenericPRBEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsDrugGenericPRBService.updateOldData(bpjsDrugGenericPRBEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsDrugGenericPRBEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntity;
			BpjsDrugGenericPRBEntity updatedBpjsDrugGenericPRBEntity;

			StockCatalogueEntity stockCatalogueEntity;

			Set<BpjsPRBDetailEntity> bpjsPRBDetailsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBFactory.getObject(true, false);
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
			stockCatalogueEntity = bpjsDrugGenericPRBEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			bpjsDrugGenericPRBEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			bpjsPRBDetailsEntities = bpjsDrugGenericPRBEntity.getBpjsPRBDetails();
			Set<UUID> bpjsPRBDetailsEntityIds = new HashSet<>();
			for (BpjsPRBDetailEntity entity : bpjsPRBDetailsEntities) {
				try {
					bpjsPRBDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsPRBDetailsEntityIds.add(bpjsPRBDetailRepository.save(entity).getId());
			}
			bpjsDrugGenericPRBEntity.setBpjsPRBDetailsIds(bpjsPRBDetailsEntityIds);


			bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBService.create(bpjsDrugGenericPRBEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsDrugGenericPRBEntity.getStockCatalogue());
			bpjsDrugGenericPRBEntity.setStockCatalogueId(null);
			bpjsDrugGenericPRBEntity.unsetStockCatalogue();

			Assertions.assertTrue(bpjsDrugGenericPRBEntity.getBpjsPRBDetails().size() > 0);
			bpjsDrugGenericPRBEntity.setBpjsPRBDetailsIds(new HashSet<UUID>());
			bpjsDrugGenericPRBEntity.unsetBpjsPRBDetails();


			updatedBpjsDrugGenericPRBEntity = bpjsDrugGenericPRBService.updateOldData(bpjsDrugGenericPRBEntity);

			Assertions.assertNull(updatedBpjsDrugGenericPRBEntity.getStockCatalogue());

			Assertions.assertEquals(0, updatedBpjsDrugGenericPRBEntity.getBpjsPRBDetails().size());

		});
	}

	@Test
	public void updateOldDataWithBpjsDrugGenericPRBEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntity;
			BpjsDrugGenericPRBEntity updatedBpjsDrugGenericPRBEntity;

			StockCatalogueEntity stockCatalogueEntity;

			Set<BpjsPRBDetailEntity> bpjsPRBDetailsEntities;
			Set<UUID> bpjsPRBDetailsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBFactory.getObject(true, false);
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
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDrugGenericPRBEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(bpjsDrugGenericPRBEntity.getStockCatalogue()).getId()).get();
			bpjsDrugGenericPRBEntity.unsetStockCatalogue();
			bpjsDrugGenericPRBEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			bpjsPRBDetailsEntities = new HashSet<>();
			bpjsPRBDetailsEntityIds = new HashSet<>();
			for (BpjsPRBDetailEntity entity : bpjsDrugGenericPRBEntity.getBpjsPRBDetails()) {
				try {
					bpjsPRBDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS PRB Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsPRBDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsPRBDetailsEntities.add(bpjsPRBDetailRepository.findById(id).get());
				bpjsPRBDetailsEntityIds.add(id);
			}
			bpjsDrugGenericPRBEntity.unsetBpjsPRBDetails();
			bpjsDrugGenericPRBEntity.setBpjsPRBDetailsIds(bpjsPRBDetailsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsDrugGenericPRBEntity = bpjsDrugGenericPRBService.updateOldData(bpjsDrugGenericPRBEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			stockCatalogueEntity.unsetBpjsDrugGenericPRB(false);
			updatedBpjsDrugGenericPRBEntity.getStockCatalogue().unsetBpjsDrugGenericPRB(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedBpjsDrugGenericPRBEntity.getStockCatalogue());

			Assertions.assertEquals(bpjsPRBDetailsEntities.size(), updatedBpjsDrugGenericPRBEntity.getBpjsPRBDetails().size());

		});
	}

	@Test
	public void whenCreateBpjsDrugGenericPRBEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntity;
			Optional<BpjsDrugGenericPRBEntity> fetchedBpjsDrugGenericPRBEntity;

			try {
				bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBFactory.getObject(false, false);
				bpjsDrugGenericPRBDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDrugGenericPRBEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBService.create(bpjsDrugGenericPRBEntity);

			fetchedBpjsDrugGenericPRBEntity = bpjsDrugGenericPRBService.findById(bpjsDrugGenericPRBEntity.getId());

			Assertions.assertTrue(fetchedBpjsDrugGenericPRBEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsDrugGenericPRBEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsDrugGenericPRBEntity, fetchedBpjsDrugGenericPRBEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsDrugGenericPRBEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntity;
			BpjsDrugGenericPRBEntity updatedBpjsDrugGenericPRBEntity;
			Optional<BpjsDrugGenericPRBEntity> fetchedBpjsDrugGenericPRBEntity;

			try {
				bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBFactory.getObject(false, false);
				bpjsDrugGenericPRBDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDrugGenericPRBEntity, true, true, false);
				updatedBpjsDrugGenericPRBEntity = bpjsDrugGenericPRBFactory.getObject(false, false);
				bpjsDrugGenericPRBDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsDrugGenericPRBEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBService.create(bpjsDrugGenericPRBEntity);

			updatedBpjsDrugGenericPRBEntity.setId(bpjsDrugGenericPRBEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsDrugGenericPRBEntity.setCreated(bpjsDrugGenericPRBEntity.getCreated());

			updatedBpjsDrugGenericPRBEntity = bpjsDrugGenericPRBService.update(updatedBpjsDrugGenericPRBEntity);

			fetchedBpjsDrugGenericPRBEntity = bpjsDrugGenericPRBService.findById(bpjsDrugGenericPRBEntity.getId());

			Assertions.assertTrue(fetchedBpjsDrugGenericPRBEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsDrugGenericPRBEntity_ThenEntityIsCreated
			fetchedBpjsDrugGenericPRBEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsDrugGenericPRBEntity, fetchedBpjsDrugGenericPRBEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsDrugGenericPRBEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDrugGenericPRBEntity bpjsDrugGenericPRBEntity;
			Optional<BpjsDrugGenericPRBEntity> fetchedBpjsDrugGenericPRBEntity;

			try {
				bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsDrugGenericPRBDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDrugGenericPRBEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDrugGenericPRBEntity = bpjsDrugGenericPRBService.create(bpjsDrugGenericPRBEntity);

			bpjsDrugGenericPRBService.deleteById(bpjsDrugGenericPRBEntity.getId());
			fetchedBpjsDrugGenericPRBEntity = bpjsDrugGenericPRBService.findById(bpjsDrugGenericPRBEntity.getId());

			Assertions.assertTrue(fetchedBpjsDrugGenericPRBEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
