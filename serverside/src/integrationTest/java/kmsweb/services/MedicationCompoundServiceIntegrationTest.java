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
import kmsweb.entities.MedicationCompoundEntity;
import kmsweb.repositories.MedicationCompoundRepository;
import kmsweb.utils.MedicationCompoundFactory;
import kmsweb.utils.DatabasePopulators.MedicationCompoundDatabasePopulator;
import kmsweb.entities.MedicationAdministeredHistoryEntity;
import kmsweb.repositories.MedicationAdministeredHistoryRepository;
import kmsweb.utils.MedicationAdministeredHistoryFactory;
import kmsweb.utils.DatabasePopulators.MedicationAdministeredHistoryDatabasePopulator;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.utils.MedicationHeaderFactory;
import kmsweb.utils.DatabasePopulators.MedicationHeaderDatabasePopulator;
import kmsweb.entities.MedicationItemEntity;
import kmsweb.repositories.MedicationItemRepository;
import kmsweb.utils.MedicationItemFactory;
import kmsweb.utils.DatabasePopulators.MedicationItemDatabasePopulator;
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
public class MedicationCompoundServiceIntegrationTest {

	@Autowired
	private MedicationCompoundRepository medicationCompoundRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MedicationCompoundService medicationCompoundService;

	private final MedicationCompoundFactory medicationCompoundFactory = new MedicationCompoundFactory();

	@Autowired
	private MedicationCompoundDatabasePopulator medicationCompoundDatabasePopulator;

	@Autowired
	private MedicationAdministeredHistoryRepository medicationAdministeredHistoryRepository;

	@Autowired
	private MedicationAdministeredHistoryDatabasePopulator medicationAdministeredHistoryDatabasePopulator;

	private final MedicationAdministeredHistoryFactory medicationAdministeredHistoryFactory = new MedicationAdministeredHistoryFactory();

	@Autowired
	private MedicationHeaderRepository medicationHeaderRepository;

	@Autowired
	private MedicationHeaderDatabasePopulator medicationHeaderDatabasePopulator;

	private final MedicationHeaderFactory medicationHeaderFactory = new MedicationHeaderFactory();

	@Autowired
	private MedicationItemRepository medicationItemRepository;

	@Autowired
	private MedicationItemDatabasePopulator medicationItemDatabasePopulator;

	private final MedicationItemFactory medicationItemFactory = new MedicationItemFactory();

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
		medicationCompoundService = new MedicationCompoundService(
			medicationAdministeredHistoryRepository,
			medicationHeaderRepository,
			medicationItemRepository,
			unitOfMeasurementRepository,
			validator,
			auditRepository,
			medicationCompoundRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMedicationCompoundEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MedicationCompoundEntity medicationCompoundEntity = medicationCompoundFactory.getObject(false, false);

		MedicationCompoundEntity updatedEntity = medicationCompoundService.updateOldData(medicationCompoundEntity);
		Assertions.assertEquals(medicationCompoundEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewMedicationCompoundEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		MedicationCompoundEntity medicationCompoundEntity = medicationCompoundFactory.getObject(false, false);

		medicationCompoundEntity.setIsDtd(null);
		Assertions.assertNull(medicationCompoundEntity.getIsDtd());


		MedicationCompoundEntity updatedEntity = medicationCompoundService.updateOldData(medicationCompoundEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getIsDtd());
		Assertions.assertFalse(updatedEntity.getIsDtd());

	}

	@Test
	public void updateOldDataWithExistingMedicationCompoundEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationCompoundEntity medicationCompoundEntity;
			MedicationCompoundEntity entityWithUpdatedValues;

			try {
				medicationCompoundEntity = medicationCompoundFactory.getObject(false, false);
				medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(medicationCompoundEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = medicationCompoundFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationCompoundEntity = medicationCompoundService.create(medicationCompoundEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(medicationCompoundEntity.getId());

			MedicationCompoundEntity updatedEntity = medicationCompoundService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMedicationCompoundEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MedicationCompoundEntity medicationCompoundEntity = medicationCompoundFactory.getObject(false, false);
		medicationCompoundEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			medicationCompoundService.updateOldData(medicationCompoundEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMedicationCompoundEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationCompoundEntity medicationCompoundEntity;
			MedicationCompoundEntity updatedMedicationCompoundEntity;

			MedicationHeaderEntity medicationHeaderEntity;

			UnitOfMeasurementEntity unitOfMeasurementEntity;

			Set<MedicationAdministeredHistoryEntity> medicationAdministeredHistoriesEntities;

			Set<MedicationItemEntity> medicationItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicationCompoundEntity = medicationCompoundFactory.getObject(true, false);
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
			medicationHeaderEntity = medicationCompoundEntity.getMedicationHeader();
			try {
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicationHeaderEntity = medicationHeaderRepository.save(medicationHeaderEntity);
			medicationCompoundEntity.setMedicationHeaderId(medicationHeaderEntity.getId());

			unitOfMeasurementEntity = medicationCompoundEntity.getUnitOfMeasurement();
			try {
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(unitOfMeasurementEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			unitOfMeasurementEntity = unitOfMeasurementRepository.save(unitOfMeasurementEntity);
			medicationCompoundEntity.setUnitOfMeasurementId(unitOfMeasurementEntity.getId());

			medicationAdministeredHistoriesEntities = medicationCompoundEntity.getMedicationAdministeredHistories();
			Set<UUID> medicationAdministeredHistoriesEntityIds = new HashSet<>();
			for (MedicationAdministeredHistoryEntity entity : medicationAdministeredHistoriesEntities) {
				try {
					medicationAdministeredHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicationAdministeredHistoriesEntityIds.add(medicationAdministeredHistoryRepository.save(entity).getId());
			}
			medicationCompoundEntity.setMedicationAdministeredHistoriesIds(medicationAdministeredHistoriesEntityIds);

			medicationItemsEntities = medicationCompoundEntity.getMedicationItems();
			Set<UUID> medicationItemsEntityIds = new HashSet<>();
			for (MedicationItemEntity entity : medicationItemsEntities) {
				try {
					medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicationItemsEntityIds.add(medicationItemRepository.save(entity).getId());
			}
			medicationCompoundEntity.setMedicationItemsIds(medicationItemsEntityIds);


			medicationCompoundEntity = medicationCompoundService.create(medicationCompoundEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(medicationCompoundEntity.getMedicationHeader());
			medicationCompoundEntity.setMedicationHeaderId(null);
			medicationCompoundEntity.unsetMedicationHeader();

			Assertions.assertNotNull(medicationCompoundEntity.getUnitOfMeasurement());
			medicationCompoundEntity.setUnitOfMeasurementId(null);
			medicationCompoundEntity.unsetUnitOfMeasurement();

			Assertions.assertTrue(medicationCompoundEntity.getMedicationAdministeredHistories().size() > 0);
			medicationCompoundEntity.setMedicationAdministeredHistoriesIds(new HashSet<UUID>());
			medicationCompoundEntity.unsetMedicationAdministeredHistories();

			Assertions.assertTrue(medicationCompoundEntity.getMedicationItems().size() > 0);
			medicationCompoundEntity.setMedicationItemsIds(new HashSet<UUID>());
			medicationCompoundEntity.unsetMedicationItems();


			updatedMedicationCompoundEntity = medicationCompoundService.updateOldData(medicationCompoundEntity);

			Assertions.assertNull(updatedMedicationCompoundEntity.getMedicationHeader());

			Assertions.assertNull(updatedMedicationCompoundEntity.getUnitOfMeasurement());

			Assertions.assertEquals(0, updatedMedicationCompoundEntity.getMedicationAdministeredHistories().size());

			Assertions.assertEquals(0, updatedMedicationCompoundEntity.getMedicationItems().size());

		});
	}

	@Test
	public void updateOldDataWithMedicationCompoundEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationCompoundEntity medicationCompoundEntity;
			MedicationCompoundEntity updatedMedicationCompoundEntity;

			MedicationHeaderEntity medicationHeaderEntity;

			UnitOfMeasurementEntity unitOfMeasurementEntity;

			Set<MedicationAdministeredHistoryEntity> medicationAdministeredHistoriesEntities;
			Set<UUID> medicationAdministeredHistoriesEntityIds;

			Set<MedicationItemEntity> medicationItemsEntities;
			Set<UUID> medicationItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicationCompoundEntity = medicationCompoundFactory.getObject(true, false);
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
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(medicationCompoundEntity.getMedicationHeader(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medication Header relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicationHeaderEntity = medicationHeaderRepository.findById(medicationHeaderRepository.save(medicationCompoundEntity.getMedicationHeader()).getId()).get();
			medicationCompoundEntity.unsetMedicationHeader();
			medicationCompoundEntity.setMedicationHeaderId(medicationHeaderEntity.getId());

			try {
				unitOfMeasurementDatabasePopulator.populateRelatedEntitiesInDatabase(medicationCompoundEntity.getUnitOfMeasurement(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Unit Of Measurement relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			unitOfMeasurementEntity = unitOfMeasurementRepository.findById(unitOfMeasurementRepository.save(medicationCompoundEntity.getUnitOfMeasurement()).getId()).get();
			medicationCompoundEntity.unsetUnitOfMeasurement();
			medicationCompoundEntity.setUnitOfMeasurementId(unitOfMeasurementEntity.getId());

			medicationAdministeredHistoriesEntities = new HashSet<>();
			medicationAdministeredHistoriesEntityIds = new HashSet<>();
			for (MedicationAdministeredHistoryEntity entity : medicationCompoundEntity.getMedicationAdministeredHistories()) {
				try {
					medicationAdministeredHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medication Administered Histories relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicationAdministeredHistoryRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicationAdministeredHistoriesEntities.add(medicationAdministeredHistoryRepository.findById(id).get());
				medicationAdministeredHistoriesEntityIds.add(id);
			}
			medicationCompoundEntity.unsetMedicationAdministeredHistories();
			medicationCompoundEntity.setMedicationAdministeredHistoriesIds(medicationAdministeredHistoriesEntityIds);

			medicationItemsEntities = new HashSet<>();
			medicationItemsEntityIds = new HashSet<>();
			for (MedicationItemEntity entity : medicationCompoundEntity.getMedicationItems()) {
				try {
					medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medication Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicationItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicationItemsEntities.add(medicationItemRepository.findById(id).get());
				medicationItemsEntityIds.add(id);
			}
			medicationCompoundEntity.unsetMedicationItems();
			medicationCompoundEntity.setMedicationItemsIds(medicationItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMedicationCompoundEntity = medicationCompoundService.updateOldData(medicationCompoundEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			medicationHeaderEntity.unsetMedicationCompounds(false);
			updatedMedicationCompoundEntity.getMedicationHeader().unsetMedicationCompounds(false);
			Assertions.assertEquals(medicationHeaderEntity, updatedMedicationCompoundEntity.getMedicationHeader());

			unitOfMeasurementEntity.unsetMedicationCompounds(false);
			updatedMedicationCompoundEntity.getUnitOfMeasurement().unsetMedicationCompounds(false);
			Assertions.assertEquals(unitOfMeasurementEntity, updatedMedicationCompoundEntity.getUnitOfMeasurement());

			Assertions.assertEquals(medicationAdministeredHistoriesEntities.size(), updatedMedicationCompoundEntity.getMedicationAdministeredHistories().size());

			Assertions.assertEquals(medicationItemsEntities.size(), updatedMedicationCompoundEntity.getMedicationItems().size());

		});
	}

	@Test
	public void whenCreateMedicationCompoundEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationCompoundEntity medicationCompoundEntity;
			Optional<MedicationCompoundEntity> fetchedMedicationCompoundEntity;

			try {
				medicationCompoundEntity = medicationCompoundFactory.getObject(false, false);
				medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(medicationCompoundEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationCompoundEntity = medicationCompoundService.create(medicationCompoundEntity);

			fetchedMedicationCompoundEntity = medicationCompoundService.findById(medicationCompoundEntity.getId());

			Assertions.assertTrue(fetchedMedicationCompoundEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMedicationCompoundEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(medicationCompoundEntity, fetchedMedicationCompoundEntity.get());
		});
	}

	@Test
	public void whenUpdateMedicationCompoundEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationCompoundEntity medicationCompoundEntity;
			MedicationCompoundEntity updatedMedicationCompoundEntity;
			Optional<MedicationCompoundEntity> fetchedMedicationCompoundEntity;

			try {
				medicationCompoundEntity = medicationCompoundFactory.getObject(false, false);
				medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(medicationCompoundEntity, true, true, false);
				updatedMedicationCompoundEntity = medicationCompoundFactory.getObject(false, false);
				medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMedicationCompoundEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationCompoundEntity = medicationCompoundService.create(medicationCompoundEntity);

			updatedMedicationCompoundEntity.setId(medicationCompoundEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMedicationCompoundEntity.setCreated(medicationCompoundEntity.getCreated());

			updatedMedicationCompoundEntity = medicationCompoundService.update(updatedMedicationCompoundEntity);

			fetchedMedicationCompoundEntity = medicationCompoundService.findById(medicationCompoundEntity.getId());

			Assertions.assertTrue(fetchedMedicationCompoundEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMedicationCompoundEntity_ThenEntityIsCreated
			fetchedMedicationCompoundEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMedicationCompoundEntity, fetchedMedicationCompoundEntity.get());
		});
	}

	@Test
	public void whenDeleteMedicationCompoundEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationCompoundEntity medicationCompoundEntity;
			Optional<MedicationCompoundEntity> fetchedMedicationCompoundEntity;

			try {
				medicationCompoundEntity = medicationCompoundFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(medicationCompoundEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationCompoundEntity = medicationCompoundService.create(medicationCompoundEntity);

			medicationCompoundService.deleteById(medicationCompoundEntity.getId());
			fetchedMedicationCompoundEntity = medicationCompoundService.findById(medicationCompoundEntity.getId());

			Assertions.assertTrue(fetchedMedicationCompoundEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
