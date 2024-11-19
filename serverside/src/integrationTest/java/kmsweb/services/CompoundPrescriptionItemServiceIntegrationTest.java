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
import kmsweb.entities.CompoundPrescriptionItemEntity;
import kmsweb.repositories.CompoundPrescriptionItemRepository;
import kmsweb.utils.CompoundPrescriptionItemFactory;
import kmsweb.utils.DatabasePopulators.CompoundPrescriptionItemDatabasePopulator;
import kmsweb.entities.CompoundPrescriptionDetailEntity;
import kmsweb.repositories.CompoundPrescriptionDetailRepository;
import kmsweb.utils.CompoundPrescriptionDetailFactory;
import kmsweb.utils.DatabasePopulators.CompoundPrescriptionDetailDatabasePopulator;
import kmsweb.entities.StockCatalogueEntity;
import kmsweb.repositories.StockCatalogueRepository;
import kmsweb.utils.StockCatalogueFactory;
import kmsweb.utils.DatabasePopulators.StockCatalogueDatabasePopulator;
import kmsweb.entities.UnitOfMeasurementEntity;
import kmsweb.repositories.UnitOfMeasurementRepository;
import kmsweb.utils.UnitOfMeasurementFactory;
import kmsweb.utils.DatabasePopulators.UnitOfMeasurementDatabasePopulator;
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
public class CompoundPrescriptionItemServiceIntegrationTest {

	@Autowired
	private CompoundPrescriptionItemRepository compoundPrescriptionItemRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private CompoundPrescriptionItemService compoundPrescriptionItemService;

	private final CompoundPrescriptionItemFactory compoundPrescriptionItemFactory = new CompoundPrescriptionItemFactory();

	@Autowired
	private CompoundPrescriptionItemDatabasePopulator compoundPrescriptionItemDatabasePopulator;

	@Autowired
	private CompoundPrescriptionDetailRepository compoundPrescriptionDetailRepository;

	@Autowired
	private CompoundPrescriptionDetailDatabasePopulator compoundPrescriptionDetailDatabasePopulator;

	private final CompoundPrescriptionDetailFactory compoundPrescriptionDetailFactory = new CompoundPrescriptionDetailFactory();

	@Autowired
	private StockCatalogueRepository stockCatalogueRepository;

	@Autowired
	private StockCatalogueDatabasePopulator stockCatalogueDatabasePopulator;

	private final StockCatalogueFactory stockCatalogueFactory = new StockCatalogueFactory();

	@Autowired
	private UnitOfMeasurementRepository unitOfMeasurementRepository;

	@Autowired
	private UnitOfMeasurementDatabasePopulator unitOfMeasurementDatabasePopulator;

	private final UnitOfMeasurementFactory unitOfMeasurementFactory = new UnitOfMeasurementFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		compoundPrescriptionItemService = new CompoundPrescriptionItemService(
			compoundPrescriptionDetailRepository,
			stockCatalogueRepository,
			unitOfMeasurementRepository,
			validator,
			auditRepository,
			compoundPrescriptionItemRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewCompoundPrescriptionItemEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		CompoundPrescriptionItemEntity compoundPrescriptionItemEntity = compoundPrescriptionItemFactory.getObject(false, false);

		CompoundPrescriptionItemEntity updatedEntity = compoundPrescriptionItemService.updateOldData(compoundPrescriptionItemEntity);
		Assertions.assertEquals(compoundPrescriptionItemEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingCompoundPrescriptionItemEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionItemEntity compoundPrescriptionItemEntity;
			CompoundPrescriptionItemEntity entityWithUpdatedValues;

			try {
				compoundPrescriptionItemEntity = compoundPrescriptionItemFactory.getObject(false, false);
				compoundPrescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionItemEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = compoundPrescriptionItemFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			compoundPrescriptionItemEntity = compoundPrescriptionItemService.create(compoundPrescriptionItemEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(compoundPrescriptionItemEntity.getId());

			CompoundPrescriptionItemEntity updatedEntity = compoundPrescriptionItemService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithCompoundPrescriptionItemEntityWithNonExistentId_ShouldThrowException() throws Exception {
		CompoundPrescriptionItemEntity compoundPrescriptionItemEntity = compoundPrescriptionItemFactory.getObject(false, false);
		compoundPrescriptionItemEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			compoundPrescriptionItemService.updateOldData(compoundPrescriptionItemEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingCompoundPrescriptionItemEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionItemEntity compoundPrescriptionItemEntity;
			CompoundPrescriptionItemEntity updatedCompoundPrescriptionItemEntity;

			CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity;

			StockCatalogueEntity stockCatalogueEntity;

			UnitOfMeasurementEntity unitEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				compoundPrescriptionItemEntity = compoundPrescriptionItemFactory.getObject(true, false);
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
			compoundPrescriptionDetailEntity = compoundPrescriptionItemEntity.getCompoundPrescriptionDetail();
			try {
				compoundPrescriptionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionDetailEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			compoundPrescriptionDetailEntity = compoundPrescriptionDetailRepository.save(compoundPrescriptionDetailEntity);
			compoundPrescriptionItemEntity.setCompoundPrescriptionDetailId(compoundPrescriptionDetailEntity.getId());

			stockCatalogueEntity = compoundPrescriptionItemEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			compoundPrescriptionItemEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			unitEntity = compoundPrescriptionItemEntity.getUnit();
			try {
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(unitEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			unitEntity = unitOfMeasurementRepository.save(unitEntity);
			compoundPrescriptionItemEntity.setUnitId(unitEntity.getId());


			compoundPrescriptionItemEntity = compoundPrescriptionItemService.create(compoundPrescriptionItemEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(compoundPrescriptionItemEntity.getCompoundPrescriptionDetail());
			compoundPrescriptionItemEntity.setCompoundPrescriptionDetailId(null);
			compoundPrescriptionItemEntity.unsetCompoundPrescriptionDetail();

			Assertions.assertNotNull(compoundPrescriptionItemEntity.getStockCatalogue());
			compoundPrescriptionItemEntity.setStockCatalogueId(null);
			compoundPrescriptionItemEntity.unsetStockCatalogue();

			Assertions.assertNotNull(compoundPrescriptionItemEntity.getUnit());
			compoundPrescriptionItemEntity.setUnitId(null);
			compoundPrescriptionItemEntity.unsetUnit();


			updatedCompoundPrescriptionItemEntity = compoundPrescriptionItemService.updateOldData(compoundPrescriptionItemEntity);

			Assertions.assertNull(updatedCompoundPrescriptionItemEntity.getCompoundPrescriptionDetail());

			Assertions.assertNull(updatedCompoundPrescriptionItemEntity.getStockCatalogue());

			Assertions.assertNull(updatedCompoundPrescriptionItemEntity.getUnit());

		});
	}

	@Test
	public void updateOldDataWithCompoundPrescriptionItemEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionItemEntity compoundPrescriptionItemEntity;
			CompoundPrescriptionItemEntity updatedCompoundPrescriptionItemEntity;

			CompoundPrescriptionDetailEntity compoundPrescriptionDetailEntity;

			StockCatalogueEntity stockCatalogueEntity;

			UnitOfMeasurementEntity unitEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				compoundPrescriptionItemEntity = compoundPrescriptionItemFactory.getObject(true, false);
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
				compoundPrescriptionDetailDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionItemEntity.getCompoundPrescriptionDetail(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Compound Prescription Detail relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			compoundPrescriptionDetailEntity = compoundPrescriptionDetailRepository.findById(compoundPrescriptionDetailRepository.save(compoundPrescriptionItemEntity.getCompoundPrescriptionDetail()).getId()).get();
			compoundPrescriptionItemEntity.unsetCompoundPrescriptionDetail();
			compoundPrescriptionItemEntity.setCompoundPrescriptionDetailId(compoundPrescriptionDetailEntity.getId());

			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionItemEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(compoundPrescriptionItemEntity.getStockCatalogue()).getId()).get();
			compoundPrescriptionItemEntity.unsetStockCatalogue();
			compoundPrescriptionItemEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			try {
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionItemEntity.getUnit(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Unit relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			unitEntity = unitOfMeasurementRepository.findById(unitOfMeasurementRepository.save(compoundPrescriptionItemEntity.getUnit()).getId()).get();
			compoundPrescriptionItemEntity.unsetUnit();
			compoundPrescriptionItemEntity.setUnitId(unitEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedCompoundPrescriptionItemEntity = compoundPrescriptionItemService.updateOldData(compoundPrescriptionItemEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			compoundPrescriptionDetailEntity.unsetCompoundPrescriptionItems(false);
			updatedCompoundPrescriptionItemEntity.getCompoundPrescriptionDetail().unsetCompoundPrescriptionItems(false);
			Assertions.assertEquals(compoundPrescriptionDetailEntity, updatedCompoundPrescriptionItemEntity.getCompoundPrescriptionDetail());

			stockCatalogueEntity.unsetCompoundPrescriptionItems(false);
			updatedCompoundPrescriptionItemEntity.getStockCatalogue().unsetCompoundPrescriptionItems(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedCompoundPrescriptionItemEntity.getStockCatalogue());

			unitEntity.unsetCompoundPrescriptionItems(false);
			updatedCompoundPrescriptionItemEntity.getUnit().unsetCompoundPrescriptionItems(false);
			Assertions.assertEquals(unitEntity, updatedCompoundPrescriptionItemEntity.getUnit());

		});
	}

	@Test
	public void whenCreateCompoundPrescriptionItemEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionItemEntity compoundPrescriptionItemEntity;
			Optional<CompoundPrescriptionItemEntity> fetchedCompoundPrescriptionItemEntity;

			try {
				compoundPrescriptionItemEntity = compoundPrescriptionItemFactory.getObject(false, false);
				compoundPrescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			compoundPrescriptionItemEntity = compoundPrescriptionItemService.create(compoundPrescriptionItemEntity);

			fetchedCompoundPrescriptionItemEntity = compoundPrescriptionItemService.findById(compoundPrescriptionItemEntity.getId());

			Assertions.assertTrue(fetchedCompoundPrescriptionItemEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedCompoundPrescriptionItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(compoundPrescriptionItemEntity, fetchedCompoundPrescriptionItemEntity.get());
		});
	}

	@Test
	public void whenUpdateCompoundPrescriptionItemEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionItemEntity compoundPrescriptionItemEntity;
			CompoundPrescriptionItemEntity updatedCompoundPrescriptionItemEntity;
			Optional<CompoundPrescriptionItemEntity> fetchedCompoundPrescriptionItemEntity;

			try {
				compoundPrescriptionItemEntity = compoundPrescriptionItemFactory.getObject(false, false);
				compoundPrescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionItemEntity, true, true, false);
				updatedCompoundPrescriptionItemEntity = compoundPrescriptionItemFactory.getObject(false, false);
				compoundPrescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(updatedCompoundPrescriptionItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			compoundPrescriptionItemEntity = compoundPrescriptionItemService.create(compoundPrescriptionItemEntity);

			updatedCompoundPrescriptionItemEntity.setId(compoundPrescriptionItemEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedCompoundPrescriptionItemEntity.setCreated(compoundPrescriptionItemEntity.getCreated());

			updatedCompoundPrescriptionItemEntity = compoundPrescriptionItemService.update(updatedCompoundPrescriptionItemEntity);

			fetchedCompoundPrescriptionItemEntity = compoundPrescriptionItemService.findById(compoundPrescriptionItemEntity.getId());

			Assertions.assertTrue(fetchedCompoundPrescriptionItemEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateCompoundPrescriptionItemEntity_ThenEntityIsCreated
			fetchedCompoundPrescriptionItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedCompoundPrescriptionItemEntity, fetchedCompoundPrescriptionItemEntity.get());
		});
	}

	@Test
	public void whenDeleteCompoundPrescriptionItemEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			CompoundPrescriptionItemEntity compoundPrescriptionItemEntity;
			Optional<CompoundPrescriptionItemEntity> fetchedCompoundPrescriptionItemEntity;

			try {
				compoundPrescriptionItemEntity = compoundPrescriptionItemFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				compoundPrescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(compoundPrescriptionItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			compoundPrescriptionItemEntity = compoundPrescriptionItemService.create(compoundPrescriptionItemEntity);

			compoundPrescriptionItemService.deleteById(compoundPrescriptionItemEntity.getId());
			fetchedCompoundPrescriptionItemEntity = compoundPrescriptionItemService.findById(compoundPrescriptionItemEntity.getId());

			Assertions.assertTrue(fetchedCompoundPrescriptionItemEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
