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
import kmsweb.entities.PrescriptionItemEntity;
import kmsweb.repositories.PrescriptionItemRepository;
import kmsweb.utils.PrescriptionItemFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionItemDatabasePopulator;
import kmsweb.entities.PrescriptionCompoundEntity;
import kmsweb.repositories.PrescriptionCompoundRepository;
import kmsweb.utils.PrescriptionCompoundFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionCompoundDatabasePopulator;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.utils.PrescriptionHeaderFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionHeaderDatabasePopulator;
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
public class PrescriptionItemServiceIntegrationTest {

	@Autowired
	private PrescriptionItemRepository prescriptionItemRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PrescriptionItemService prescriptionItemService;

	private final PrescriptionItemFactory prescriptionItemFactory = new PrescriptionItemFactory();

	@Autowired
	private PrescriptionItemDatabasePopulator prescriptionItemDatabasePopulator;

	@Autowired
	private PrescriptionCompoundRepository prescriptionCompoundRepository;

	@Autowired
	private PrescriptionCompoundDatabasePopulator prescriptionCompoundDatabasePopulator;

	private final PrescriptionCompoundFactory prescriptionCompoundFactory = new PrescriptionCompoundFactory();

	@Autowired
	private PrescriptionHeaderRepository prescriptionHeaderRepository;

	@Autowired
	private PrescriptionHeaderDatabasePopulator prescriptionHeaderDatabasePopulator;

	private final PrescriptionHeaderFactory prescriptionHeaderFactory = new PrescriptionHeaderFactory();

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
		prescriptionItemService = new PrescriptionItemService(
			prescriptionCompoundRepository,
			prescriptionHeaderRepository,
			stockCatalogueRepository,
			unitOfMeasurementRepository,
			validator,
			auditRepository,
			prescriptionItemRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPrescriptionItemEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PrescriptionItemEntity prescriptionItemEntity = prescriptionItemFactory.getObject(false, false);

		PrescriptionItemEntity updatedEntity = prescriptionItemService.updateOldData(prescriptionItemEntity);
		Assertions.assertEquals(prescriptionItemEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewPrescriptionItemEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		PrescriptionItemEntity prescriptionItemEntity = prescriptionItemFactory.getObject(false, false);

		prescriptionItemEntity.setIsDtd(null);
		Assertions.assertNull(prescriptionItemEntity.getIsDtd());


		PrescriptionItemEntity updatedEntity = prescriptionItemService.updateOldData(prescriptionItemEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getIsDtd());
		Assertions.assertFalse(updatedEntity.getIsDtd());

	}

	@Test
	public void updateOldDataWithExistingPrescriptionItemEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionItemEntity prescriptionItemEntity;
			PrescriptionItemEntity entityWithUpdatedValues;

			try {
				prescriptionItemEntity = prescriptionItemFactory.getObject(false, false);
				prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionItemEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = prescriptionItemFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionItemEntity = prescriptionItemService.create(prescriptionItemEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(prescriptionItemEntity.getId());

			PrescriptionItemEntity updatedEntity = prescriptionItemService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPrescriptionItemEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PrescriptionItemEntity prescriptionItemEntity = prescriptionItemFactory.getObject(false, false);
		prescriptionItemEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			prescriptionItemService.updateOldData(prescriptionItemEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPrescriptionItemEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionItemEntity prescriptionItemEntity;
			PrescriptionItemEntity updatedPrescriptionItemEntity;

			PrescriptionCompoundEntity compoundEntity;

			StockCatalogueEntity stockCatalogueIdEntity;

			PrescriptionHeaderEntity prescriptionEntity;

			UnitOfMeasurementEntity unitEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				prescriptionItemEntity = prescriptionItemFactory.getObject(true, false);
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
			compoundEntity = prescriptionItemEntity.getCompound();
			try {
				prescriptionCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(compoundEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			compoundEntity = prescriptionCompoundRepository.save(compoundEntity);
			prescriptionItemEntity.setCompoundId(compoundEntity.getId());

			stockCatalogueIdEntity = prescriptionItemEntity.getStockCatalogueId();
			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(stockCatalogueIdEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			stockCatalogueIdEntity = stockCatalogueRepository.save(stockCatalogueIdEntity);
			prescriptionItemEntity.setStockCatalogueIdId(stockCatalogueIdEntity.getId());

			prescriptionEntity = prescriptionItemEntity.getPrescription();
			try {
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			prescriptionEntity = prescriptionHeaderRepository.save(prescriptionEntity);
			prescriptionItemEntity.setPrescriptionId(prescriptionEntity.getId());

			unitEntity = prescriptionItemEntity.getUnit();
			try {
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(unitEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			unitEntity = unitOfMeasurementRepository.save(unitEntity);
			prescriptionItemEntity.setUnitId(unitEntity.getId());


			prescriptionItemEntity = prescriptionItemService.create(prescriptionItemEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(prescriptionItemEntity.getCompound());
			prescriptionItemEntity.setCompoundId(null);
			prescriptionItemEntity.unsetCompound();

			Assertions.assertNotNull(prescriptionItemEntity.getStockCatalogueId());
			prescriptionItemEntity.setStockCatalogueIdId(null);
			prescriptionItemEntity.unsetStockCatalogueId();

			Assertions.assertNotNull(prescriptionItemEntity.getPrescription());
			prescriptionItemEntity.setPrescriptionId(null);
			prescriptionItemEntity.unsetPrescription();

			Assertions.assertNotNull(prescriptionItemEntity.getUnit());
			prescriptionItemEntity.setUnitId(null);
			prescriptionItemEntity.unsetUnit();


			updatedPrescriptionItemEntity = prescriptionItemService.updateOldData(prescriptionItemEntity);

			Assertions.assertNull(updatedPrescriptionItemEntity.getCompound());

			Assertions.assertNull(updatedPrescriptionItemEntity.getStockCatalogueId());

			Assertions.assertNull(updatedPrescriptionItemEntity.getPrescription());

			Assertions.assertNull(updatedPrescriptionItemEntity.getUnit());

		});
	}

	@Test
	public void updateOldDataWithPrescriptionItemEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionItemEntity prescriptionItemEntity;
			PrescriptionItemEntity updatedPrescriptionItemEntity;

			PrescriptionCompoundEntity compoundEntity;

			StockCatalogueEntity stockCatalogueIdEntity;

			PrescriptionHeaderEntity prescriptionEntity;

			UnitOfMeasurementEntity unitEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				prescriptionItemEntity = prescriptionItemFactory.getObject(true, false);
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
				prescriptionCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionItemEntity.getCompound(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Compound relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			compoundEntity = prescriptionCompoundRepository.findById(prescriptionCompoundRepository.save(prescriptionItemEntity.getCompound()).getId()).get();
			prescriptionItemEntity.unsetCompound();
			prescriptionItemEntity.setCompoundId(compoundEntity.getId());

			try {
				stockCatalogueDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionItemEntity.getStockCatalogueId(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Stock Catalogue Id relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			stockCatalogueIdEntity = stockCatalogueRepository.findById(stockCatalogueRepository.save(prescriptionItemEntity.getStockCatalogueId()).getId()).get();
			prescriptionItemEntity.unsetStockCatalogueId();
			prescriptionItemEntity.setStockCatalogueIdId(stockCatalogueIdEntity.getId());

			try {
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionItemEntity.getPrescription(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Prescription relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			prescriptionEntity = prescriptionHeaderRepository.findById(prescriptionHeaderRepository.save(prescriptionItemEntity.getPrescription()).getId()).get();
			prescriptionItemEntity.unsetPrescription();
			prescriptionItemEntity.setPrescriptionId(prescriptionEntity.getId());

			try {
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionItemEntity.getUnit(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Unit relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			unitEntity = unitOfMeasurementRepository.findById(unitOfMeasurementRepository.save(prescriptionItemEntity.getUnit()).getId()).get();
			prescriptionItemEntity.unsetUnit();
			prescriptionItemEntity.setUnitId(unitEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPrescriptionItemEntity = prescriptionItemService.updateOldData(prescriptionItemEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			compoundEntity.unsetCompoundItems(false);
			updatedPrescriptionItemEntity.getCompound().unsetCompoundItems(false);
			Assertions.assertEquals(compoundEntity, updatedPrescriptionItemEntity.getCompound());

			stockCatalogueIdEntity.unsetPrescriptionItem(false);
			updatedPrescriptionItemEntity.getStockCatalogueId().unsetPrescriptionItem(false);
			Assertions.assertEquals(stockCatalogueIdEntity, updatedPrescriptionItemEntity.getStockCatalogueId());

			prescriptionEntity.unsetPrescriptionItems(false);
			updatedPrescriptionItemEntity.getPrescription().unsetPrescriptionItems(false);
			Assertions.assertEquals(prescriptionEntity, updatedPrescriptionItemEntity.getPrescription());

			unitEntity.unsetPrescriptionItems(false);
			updatedPrescriptionItemEntity.getUnit().unsetPrescriptionItems(false);
			Assertions.assertEquals(unitEntity, updatedPrescriptionItemEntity.getUnit());

		});
	}

	@Test
	public void whenCreatePrescriptionItemEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionItemEntity prescriptionItemEntity;
			Optional<PrescriptionItemEntity> fetchedPrescriptionItemEntity;

			try {
				prescriptionItemEntity = prescriptionItemFactory.getObject(false, false);
				prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionItemEntity = prescriptionItemService.create(prescriptionItemEntity);

			fetchedPrescriptionItemEntity = prescriptionItemService.findById(prescriptionItemEntity.getId());

			Assertions.assertTrue(fetchedPrescriptionItemEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPrescriptionItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(prescriptionItemEntity, fetchedPrescriptionItemEntity.get());
		});
	}

	@Test
	public void whenUpdatePrescriptionItemEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionItemEntity prescriptionItemEntity;
			PrescriptionItemEntity updatedPrescriptionItemEntity;
			Optional<PrescriptionItemEntity> fetchedPrescriptionItemEntity;

			try {
				prescriptionItemEntity = prescriptionItemFactory.getObject(false, false);
				prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionItemEntity, true, true, false);
				updatedPrescriptionItemEntity = prescriptionItemFactory.getObject(false, false);
				prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPrescriptionItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionItemEntity = prescriptionItemService.create(prescriptionItemEntity);

			updatedPrescriptionItemEntity.setId(prescriptionItemEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPrescriptionItemEntity.setCreated(prescriptionItemEntity.getCreated());

			updatedPrescriptionItemEntity = prescriptionItemService.update(updatedPrescriptionItemEntity);

			fetchedPrescriptionItemEntity = prescriptionItemService.findById(prescriptionItemEntity.getId());

			Assertions.assertTrue(fetchedPrescriptionItemEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePrescriptionItemEntity_ThenEntityIsCreated
			fetchedPrescriptionItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPrescriptionItemEntity, fetchedPrescriptionItemEntity.get());
		});
	}

	@Test
	public void whenDeletePrescriptionItemEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionItemEntity prescriptionItemEntity;
			Optional<PrescriptionItemEntity> fetchedPrescriptionItemEntity;

			try {
				prescriptionItemEntity = prescriptionItemFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionItemEntity = prescriptionItemService.create(prescriptionItemEntity);

			prescriptionItemService.deleteById(prescriptionItemEntity.getId());
			fetchedPrescriptionItemEntity = prescriptionItemService.findById(prescriptionItemEntity.getId());

			Assertions.assertTrue(fetchedPrescriptionItemEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
