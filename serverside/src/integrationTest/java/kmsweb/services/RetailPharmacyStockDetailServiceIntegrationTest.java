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
import kmsweb.entities.RetailPharmacyStockDetailEntity;
import kmsweb.repositories.RetailPharmacyStockDetailRepository;
import kmsweb.utils.RetailPharmacyStockDetailFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyStockDetailDatabasePopulator;
import kmsweb.entities.RetailPharmacyEntity;
import kmsweb.repositories.RetailPharmacyRepository;
import kmsweb.utils.RetailPharmacyFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyDatabasePopulator;
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
public class RetailPharmacyStockDetailServiceIntegrationTest {

	@Autowired
	private RetailPharmacyStockDetailRepository retailPharmacyStockDetailRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private RetailPharmacyStockDetailService retailPharmacyStockDetailService;

	private final RetailPharmacyStockDetailFactory retailPharmacyStockDetailFactory = new RetailPharmacyStockDetailFactory();

	@Autowired
	private RetailPharmacyStockDetailDatabasePopulator retailPharmacyStockDetailDatabasePopulator;

	@Autowired
	private RetailPharmacyRepository retailPharmacyRepository;

	@Autowired
	private RetailPharmacyDatabasePopulator retailPharmacyDatabasePopulator;

	private final RetailPharmacyFactory retailPharmacyFactory = new RetailPharmacyFactory();

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
		retailPharmacyStockDetailService = new RetailPharmacyStockDetailService(
			retailPharmacyRepository,
			stockCatalogueRepository,
			validator,
			auditRepository,
			retailPharmacyStockDetailRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewRetailPharmacyStockDetailEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntity = retailPharmacyStockDetailFactory.getObject(false, false);

		RetailPharmacyStockDetailEntity updatedEntity = retailPharmacyStockDetailService.updateOldData(retailPharmacyStockDetailEntity);
		Assertions.assertEquals(retailPharmacyStockDetailEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewRetailPharmacyStockDetailEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntity = retailPharmacyStockDetailFactory.getObject(false, false);

		retailPharmacyStockDetailEntity.setTaxIncluded(null);
		Assertions.assertNull(retailPharmacyStockDetailEntity.getTaxIncluded());


		RetailPharmacyStockDetailEntity updatedEntity = retailPharmacyStockDetailService.updateOldData(retailPharmacyStockDetailEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getTaxIncluded());
		Assertions.assertFalse(updatedEntity.getTaxIncluded());

	}

	@Test
	public void updateOldDataWithExistingRetailPharmacyStockDetailEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntity;
			RetailPharmacyStockDetailEntity entityWithUpdatedValues;

			try {
				retailPharmacyStockDetailEntity = retailPharmacyStockDetailFactory.getObject(false, false);
				retailPharmacyStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyStockDetailEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = retailPharmacyStockDetailFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyStockDetailEntity = retailPharmacyStockDetailService.create(retailPharmacyStockDetailEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(retailPharmacyStockDetailEntity.getId());

			RetailPharmacyStockDetailEntity updatedEntity = retailPharmacyStockDetailService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithRetailPharmacyStockDetailEntityWithNonExistentId_ShouldThrowException() throws Exception {
		RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntity = retailPharmacyStockDetailFactory.getObject(false, false);
		retailPharmacyStockDetailEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			retailPharmacyStockDetailService.updateOldData(retailPharmacyStockDetailEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingRetailPharmacyStockDetailEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntity;
			RetailPharmacyStockDetailEntity updatedRetailPharmacyStockDetailEntity;

			RetailPharmacyEntity retailPharmacyEntity;

			StockCatalogueEntity stockCatalogueEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				retailPharmacyStockDetailEntity = retailPharmacyStockDetailFactory.getObject(true, false);
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
			retailPharmacyEntity = retailPharmacyStockDetailEntity.getRetailPharmacy();
			try {
				retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			retailPharmacyEntity = retailPharmacyRepository.save(retailPharmacyEntity);
			retailPharmacyStockDetailEntity.setRetailPharmacyId(retailPharmacyEntity.getId());

			stockCatalogueEntity = retailPharmacyStockDetailEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			retailPharmacyStockDetailEntity.setStockCatalogueId(stockCatalogueEntity.getId());


			retailPharmacyStockDetailEntity = retailPharmacyStockDetailService.create(retailPharmacyStockDetailEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(retailPharmacyStockDetailEntity.getRetailPharmacy());
			retailPharmacyStockDetailEntity.setRetailPharmacyId(null);
			retailPharmacyStockDetailEntity.unsetRetailPharmacy();

			Assertions.assertNotNull(retailPharmacyStockDetailEntity.getStockCatalogue());
			retailPharmacyStockDetailEntity.setStockCatalogueId(null);
			retailPharmacyStockDetailEntity.unsetStockCatalogue();


			updatedRetailPharmacyStockDetailEntity = retailPharmacyStockDetailService.updateOldData(retailPharmacyStockDetailEntity);

			Assertions.assertNull(updatedRetailPharmacyStockDetailEntity.getRetailPharmacy());

			Assertions.assertNull(updatedRetailPharmacyStockDetailEntity.getStockCatalogue());

		});
	}

	@Test
	public void updateOldDataWithRetailPharmacyStockDetailEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntity;
			RetailPharmacyStockDetailEntity updatedRetailPharmacyStockDetailEntity;

			RetailPharmacyEntity retailPharmacyEntity;

			StockCatalogueEntity stockCatalogueEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				retailPharmacyStockDetailEntity = retailPharmacyStockDetailFactory.getObject(true, false);
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
				retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyStockDetailEntity.getRetailPharmacy(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Retail Pharmacy relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			retailPharmacyEntity = retailPharmacyRepository.findById(retailPharmacyRepository.save(retailPharmacyStockDetailEntity.getRetailPharmacy()).getId()).get();
			retailPharmacyStockDetailEntity.unsetRetailPharmacy();
			retailPharmacyStockDetailEntity.setRetailPharmacyId(retailPharmacyEntity.getId());

			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyStockDetailEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(retailPharmacyStockDetailEntity.getStockCatalogue()).getId()).get();
			retailPharmacyStockDetailEntity.unsetStockCatalogue();
			retailPharmacyStockDetailEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedRetailPharmacyStockDetailEntity = retailPharmacyStockDetailService.updateOldData(retailPharmacyStockDetailEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			retailPharmacyEntity.unsetRetailPharmacyStockDetails(false);
			updatedRetailPharmacyStockDetailEntity.getRetailPharmacy().unsetRetailPharmacyStockDetails(false);
			Assertions.assertEquals(retailPharmacyEntity, updatedRetailPharmacyStockDetailEntity.getRetailPharmacy());

			stockCatalogueEntity.unsetRetailPharmacyStockDetails(false);
			updatedRetailPharmacyStockDetailEntity.getStockCatalogue().unsetRetailPharmacyStockDetails(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedRetailPharmacyStockDetailEntity.getStockCatalogue());

		});
	}

	@Test
	public void whenCreateRetailPharmacyStockDetailEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntity;
			Optional<RetailPharmacyStockDetailEntity> fetchedRetailPharmacyStockDetailEntity;

			try {
				retailPharmacyStockDetailEntity = retailPharmacyStockDetailFactory.getObject(false, false);
				retailPharmacyStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyStockDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyStockDetailEntity = retailPharmacyStockDetailService.create(retailPharmacyStockDetailEntity);

			fetchedRetailPharmacyStockDetailEntity = retailPharmacyStockDetailService.findById(retailPharmacyStockDetailEntity.getId());

			Assertions.assertTrue(fetchedRetailPharmacyStockDetailEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedRetailPharmacyStockDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(retailPharmacyStockDetailEntity, fetchedRetailPharmacyStockDetailEntity.get());
		});
	}

	@Test
	public void whenUpdateRetailPharmacyStockDetailEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntity;
			RetailPharmacyStockDetailEntity updatedRetailPharmacyStockDetailEntity;
			Optional<RetailPharmacyStockDetailEntity> fetchedRetailPharmacyStockDetailEntity;

			try {
				retailPharmacyStockDetailEntity = retailPharmacyStockDetailFactory.getObject(false, false);
				retailPharmacyStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyStockDetailEntity, true, true, false);
				updatedRetailPharmacyStockDetailEntity = retailPharmacyStockDetailFactory.getObject(false, false);
				retailPharmacyStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(updatedRetailPharmacyStockDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyStockDetailEntity = retailPharmacyStockDetailService.create(retailPharmacyStockDetailEntity);

			updatedRetailPharmacyStockDetailEntity.setId(retailPharmacyStockDetailEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedRetailPharmacyStockDetailEntity.setCreated(retailPharmacyStockDetailEntity.getCreated());

			updatedRetailPharmacyStockDetailEntity = retailPharmacyStockDetailService.update(updatedRetailPharmacyStockDetailEntity);

			fetchedRetailPharmacyStockDetailEntity = retailPharmacyStockDetailService.findById(retailPharmacyStockDetailEntity.getId());

			Assertions.assertTrue(fetchedRetailPharmacyStockDetailEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateRetailPharmacyStockDetailEntity_ThenEntityIsCreated
			fetchedRetailPharmacyStockDetailEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedRetailPharmacyStockDetailEntity, fetchedRetailPharmacyStockDetailEntity.get());
		});
	}

	@Test
	public void whenDeleteRetailPharmacyStockDetailEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyStockDetailEntity retailPharmacyStockDetailEntity;
			Optional<RetailPharmacyStockDetailEntity> fetchedRetailPharmacyStockDetailEntity;

			try {
				retailPharmacyStockDetailEntity = retailPharmacyStockDetailFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				retailPharmacyStockDetailDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyStockDetailEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyStockDetailEntity = retailPharmacyStockDetailService.create(retailPharmacyStockDetailEntity);

			retailPharmacyStockDetailService.deleteById(retailPharmacyStockDetailEntity.getId());
			fetchedRetailPharmacyStockDetailEntity = retailPharmacyStockDetailService.findById(retailPharmacyStockDetailEntity.getId());

			Assertions.assertTrue(fetchedRetailPharmacyStockDetailEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
