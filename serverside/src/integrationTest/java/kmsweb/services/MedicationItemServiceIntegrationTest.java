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
import kmsweb.entities.MedicationItemEntity;
import kmsweb.repositories.MedicationItemRepository;
import kmsweb.utils.MedicationItemFactory;
import kmsweb.utils.DatabasePopulators.MedicationItemDatabasePopulator;
import kmsweb.entities.MedicationAdministeredHistoryEntity;
import kmsweb.repositories.MedicationAdministeredHistoryRepository;
import kmsweb.utils.MedicationAdministeredHistoryFactory;
import kmsweb.utils.DatabasePopulators.MedicationAdministeredHistoryDatabasePopulator;
import kmsweb.entities.MedicationCompoundEntity;
import kmsweb.repositories.MedicationCompoundRepository;
import kmsweb.utils.MedicationCompoundFactory;
import kmsweb.utils.DatabasePopulators.MedicationCompoundDatabasePopulator;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.utils.MedicationHeaderFactory;
import kmsweb.utils.DatabasePopulators.MedicationHeaderDatabasePopulator;
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
public class MedicationItemServiceIntegrationTest {

	@Autowired
	private MedicationItemRepository medicationItemRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MedicationItemService medicationItemService;

	private final MedicationItemFactory medicationItemFactory = new MedicationItemFactory();

	@Autowired
	private MedicationItemDatabasePopulator medicationItemDatabasePopulator;

	@Autowired
	private MedicationAdministeredHistoryRepository medicationAdministeredHistoryRepository;

	@Autowired
	private MedicationAdministeredHistoryDatabasePopulator medicationAdministeredHistoryDatabasePopulator;

	private final MedicationAdministeredHistoryFactory medicationAdministeredHistoryFactory = new MedicationAdministeredHistoryFactory();

	@Autowired
	private MedicationCompoundRepository medicationCompoundRepository;

	@Autowired
	private MedicationCompoundDatabasePopulator medicationCompoundDatabasePopulator;

	private final MedicationCompoundFactory medicationCompoundFactory = new MedicationCompoundFactory();

	@Autowired
	private MedicationHeaderRepository medicationHeaderRepository;

	@Autowired
	private MedicationHeaderDatabasePopulator medicationHeaderDatabasePopulator;

	private final MedicationHeaderFactory medicationHeaderFactory = new MedicationHeaderFactory();

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
		medicationItemService = new MedicationItemService(
			medicationAdministeredHistoryRepository,
			medicationCompoundRepository,
			medicationHeaderRepository,
			stockCatalogueRepository,
			unitOfMeasurementRepository,
			validator,
			auditRepository,
			medicationItemRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMedicationItemEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MedicationItemEntity medicationItemEntity = medicationItemFactory.getObject(false, false);

		MedicationItemEntity updatedEntity = medicationItemService.updateOldData(medicationItemEntity);
		Assertions.assertEquals(medicationItemEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewMedicationItemEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		MedicationItemEntity medicationItemEntity = medicationItemFactory.getObject(false, false);

		medicationItemEntity.setIsDtd(null);
		Assertions.assertNull(medicationItemEntity.getIsDtd());


		MedicationItemEntity updatedEntity = medicationItemService.updateOldData(medicationItemEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getIsDtd());
		Assertions.assertFalse(updatedEntity.getIsDtd());

	}

	@Test
	public void updateOldDataWithExistingMedicationItemEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationItemEntity medicationItemEntity;
			MedicationItemEntity entityWithUpdatedValues;

			try {
				medicationItemEntity = medicationItemFactory.getObject(false, false);
				medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(medicationItemEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = medicationItemFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationItemEntity = medicationItemService.create(medicationItemEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(medicationItemEntity.getId());

			MedicationItemEntity updatedEntity = medicationItemService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMedicationItemEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MedicationItemEntity medicationItemEntity = medicationItemFactory.getObject(false, false);
		medicationItemEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			medicationItemService.updateOldData(medicationItemEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMedicationItemEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationItemEntity medicationItemEntity;
			MedicationItemEntity updatedMedicationItemEntity;

			MedicationCompoundEntity medicationCompoundEntity;

			MedicationHeaderEntity medicationHeaderEntity;

			StockCatalogueEntity stockCatalogueEntity;

			UnitOfMeasurementEntity unitOfMeasurementEntity;

			Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotriesEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicationItemEntity = medicationItemFactory.getObject(true, false);
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
			medicationCompoundEntity = medicationItemEntity.getMedicationCompound();
			try {
				medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(medicationCompoundEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicationCompoundEntity = medicationCompoundRepository.save(medicationCompoundEntity);
			medicationItemEntity.setMedicationCompoundId(medicationCompoundEntity.getId());

			medicationHeaderEntity = medicationItemEntity.getMedicationHeader();
			try {
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicationHeaderEntity = medicationHeaderRepository.save(medicationHeaderEntity);
			medicationItemEntity.setMedicationHeaderId(medicationHeaderEntity.getId());

			stockCatalogueEntity = medicationItemEntity.getStockCatalogue();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueEntity = stockCatalogueRepository.save(stockCatalogueEntity);
			medicationItemEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			unitOfMeasurementEntity = medicationItemEntity.getUnitOfMeasurement();
			try {
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(unitOfMeasurementEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			unitOfMeasurementEntity = unitOfMeasurementRepository.save(unitOfMeasurementEntity);
			medicationItemEntity.setUnitOfMeasurementId(unitOfMeasurementEntity.getId());

			medicationAdministeredHisotriesEntities = medicationItemEntity.getMedicationAdministeredHisotries();
			Set<UUID> medicationAdministeredHisotriesEntityIds = new HashSet<>();
			for (MedicationAdministeredHistoryEntity entity : medicationAdministeredHisotriesEntities) {
				try {
					medicationAdministeredHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicationAdministeredHisotriesEntityIds.add(medicationAdministeredHistoryRepository.save(entity).getId());
			}
			medicationItemEntity.setMedicationAdministeredHisotriesIds(medicationAdministeredHisotriesEntityIds);


			medicationItemEntity = medicationItemService.create(medicationItemEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(medicationItemEntity.getMedicationCompound());
			medicationItemEntity.setMedicationCompoundId(null);
			medicationItemEntity.unsetMedicationCompound();

			Assertions.assertNotNull(medicationItemEntity.getMedicationHeader());
			medicationItemEntity.setMedicationHeaderId(null);
			medicationItemEntity.unsetMedicationHeader();

			Assertions.assertNotNull(medicationItemEntity.getStockCatalogue());
			medicationItemEntity.setStockCatalogueId(null);
			medicationItemEntity.unsetStockCatalogue();

			Assertions.assertNotNull(medicationItemEntity.getUnitOfMeasurement());
			medicationItemEntity.setUnitOfMeasurementId(null);
			medicationItemEntity.unsetUnitOfMeasurement();

			Assertions.assertTrue(medicationItemEntity.getMedicationAdministeredHisotries().size() > 0);
			medicationItemEntity.setMedicationAdministeredHisotriesIds(new HashSet<UUID>());
			medicationItemEntity.unsetMedicationAdministeredHisotries();


			updatedMedicationItemEntity = medicationItemService.updateOldData(medicationItemEntity);

			Assertions.assertNull(updatedMedicationItemEntity.getMedicationCompound());

			Assertions.assertNull(updatedMedicationItemEntity.getMedicationHeader());

			Assertions.assertNull(updatedMedicationItemEntity.getStockCatalogue());

			Assertions.assertNull(updatedMedicationItemEntity.getUnitOfMeasurement());

			Assertions.assertEquals(0, updatedMedicationItemEntity.getMedicationAdministeredHisotries().size());

		});
	}

	@Test
	public void updateOldDataWithMedicationItemEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationItemEntity medicationItemEntity;
			MedicationItemEntity updatedMedicationItemEntity;

			MedicationCompoundEntity medicationCompoundEntity;

			MedicationHeaderEntity medicationHeaderEntity;

			StockCatalogueEntity stockCatalogueEntity;

			UnitOfMeasurementEntity unitOfMeasurementEntity;

			Set<MedicationAdministeredHistoryEntity> medicationAdministeredHisotriesEntities;
			Set<UUID> medicationAdministeredHisotriesEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicationItemEntity = medicationItemFactory.getObject(true, false);
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
				medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(medicationItemEntity.getMedicationCompound(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medication Compound relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicationCompoundEntity = medicationCompoundRepository.findById(medicationCompoundRepository.save(medicationItemEntity.getMedicationCompound()).getId()).get();
			medicationItemEntity.unsetMedicationCompound();
			medicationItemEntity.setMedicationCompoundId(medicationCompoundEntity.getId());

			try {
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(medicationItemEntity.getMedicationHeader(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medication Header relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicationHeaderEntity = medicationHeaderRepository.findById(medicationHeaderRepository.save(medicationItemEntity.getMedicationHeader()).getId()).get();
			medicationItemEntity.unsetMedicationHeader();
			medicationItemEntity.setMedicationHeaderId(medicationHeaderEntity.getId());

			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(medicationItemEntity.getStockCatalogue(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(medicationItemEntity.getStockCatalogue()).getId()).get();
			medicationItemEntity.unsetStockCatalogue();
			medicationItemEntity.setStockCatalogueId(stockCatalogueEntity.getId());

			try {
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(medicationItemEntity.getUnitOfMeasurement(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Unit Of Measurement relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			unitOfMeasurementEntity = unitOfMeasurementRepository.findById(unitOfMeasurementRepository.save(medicationItemEntity.getUnitOfMeasurement()).getId()).get();
			medicationItemEntity.unsetUnitOfMeasurement();
			medicationItemEntity.setUnitOfMeasurementId(unitOfMeasurementEntity.getId());

			medicationAdministeredHisotriesEntities = new HashSet<>();
			medicationAdministeredHisotriesEntityIds = new HashSet<>();
			for (MedicationAdministeredHistoryEntity entity : medicationItemEntity.getMedicationAdministeredHisotries()) {
				try {
					medicationAdministeredHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medication Administered Hisotries relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicationAdministeredHistoryRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicationAdministeredHisotriesEntities.add(medicationAdministeredHistoryRepository.findById(id).get());
				medicationAdministeredHisotriesEntityIds.add(id);
			}
			medicationItemEntity.unsetMedicationAdministeredHisotries();
			medicationItemEntity.setMedicationAdministeredHisotriesIds(medicationAdministeredHisotriesEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMedicationItemEntity = medicationItemService.updateOldData(medicationItemEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			medicationCompoundEntity.unsetMedicationItems(false);
			updatedMedicationItemEntity.getMedicationCompound().unsetMedicationItems(false);
			Assertions.assertEquals(medicationCompoundEntity, updatedMedicationItemEntity.getMedicationCompound());

			medicationHeaderEntity.unsetMedicationItems(false);
			updatedMedicationItemEntity.getMedicationHeader().unsetMedicationItems(false);
			Assertions.assertEquals(medicationHeaderEntity, updatedMedicationItemEntity.getMedicationHeader());

			stockCatalogueEntity.unsetMedicationItems(false);
			updatedMedicationItemEntity.getStockCatalogue().unsetMedicationItems(false);
			Assertions.assertEquals(stockCatalogueEntity, updatedMedicationItemEntity.getStockCatalogue());

			unitOfMeasurementEntity.unsetMedicationItems(false);
			updatedMedicationItemEntity.getUnitOfMeasurement().unsetMedicationItems(false);
			Assertions.assertEquals(unitOfMeasurementEntity, updatedMedicationItemEntity.getUnitOfMeasurement());

			Assertions.assertEquals(medicationAdministeredHisotriesEntities.size(), updatedMedicationItemEntity.getMedicationAdministeredHisotries().size());

		});
	}

	@Test
	public void whenCreateMedicationItemEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationItemEntity medicationItemEntity;
			Optional<MedicationItemEntity> fetchedMedicationItemEntity;

			try {
				medicationItemEntity = medicationItemFactory.getObject(false, false);
				medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(medicationItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationItemEntity = medicationItemService.create(medicationItemEntity);

			fetchedMedicationItemEntity = medicationItemService.findById(medicationItemEntity.getId());

			Assertions.assertTrue(fetchedMedicationItemEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMedicationItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(medicationItemEntity, fetchedMedicationItemEntity.get());
		});
	}

	@Test
	public void whenUpdateMedicationItemEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationItemEntity medicationItemEntity;
			MedicationItemEntity updatedMedicationItemEntity;
			Optional<MedicationItemEntity> fetchedMedicationItemEntity;

			try {
				medicationItemEntity = medicationItemFactory.getObject(false, false);
				medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(medicationItemEntity, true, true, false);
				updatedMedicationItemEntity = medicationItemFactory.getObject(false, false);
				medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMedicationItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationItemEntity = medicationItemService.create(medicationItemEntity);

			updatedMedicationItemEntity.setId(medicationItemEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMedicationItemEntity.setCreated(medicationItemEntity.getCreated());

			updatedMedicationItemEntity = medicationItemService.update(updatedMedicationItemEntity);

			fetchedMedicationItemEntity = medicationItemService.findById(medicationItemEntity.getId());

			Assertions.assertTrue(fetchedMedicationItemEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMedicationItemEntity_ThenEntityIsCreated
			fetchedMedicationItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMedicationItemEntity, fetchedMedicationItemEntity.get());
		});
	}

	@Test
	public void whenDeleteMedicationItemEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationItemEntity medicationItemEntity;
			Optional<MedicationItemEntity> fetchedMedicationItemEntity;

			try {
				medicationItemEntity = medicationItemFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(medicationItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationItemEntity = medicationItemService.create(medicationItemEntity);

			medicationItemService.deleteById(medicationItemEntity.getId());
			fetchedMedicationItemEntity = medicationItemService.findById(medicationItemEntity.getId());

			Assertions.assertTrue(fetchedMedicationItemEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
