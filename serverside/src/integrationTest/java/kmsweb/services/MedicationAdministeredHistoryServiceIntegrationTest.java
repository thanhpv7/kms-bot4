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
import kmsweb.entities.MedicationAdministeredHistoryEntity;
import kmsweb.repositories.MedicationAdministeredHistoryRepository;
import kmsweb.utils.MedicationAdministeredHistoryFactory;
import kmsweb.utils.DatabasePopulators.MedicationAdministeredHistoryDatabasePopulator;
import kmsweb.entities.MedicationCompoundEntity;
import kmsweb.repositories.MedicationCompoundRepository;
import kmsweb.utils.MedicationCompoundFactory;
import kmsweb.utils.DatabasePopulators.MedicationCompoundDatabasePopulator;
import kmsweb.entities.MedicationItemEntity;
import kmsweb.repositories.MedicationItemRepository;
import kmsweb.utils.MedicationItemFactory;
import kmsweb.utils.DatabasePopulators.MedicationItemDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
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
public class MedicationAdministeredHistoryServiceIntegrationTest {

	@Autowired
	private MedicationAdministeredHistoryRepository medicationAdministeredHistoryRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MedicationAdministeredHistoryService medicationAdministeredHistoryService;

	private final MedicationAdministeredHistoryFactory medicationAdministeredHistoryFactory = new MedicationAdministeredHistoryFactory();

	@Autowired
	private MedicationAdministeredHistoryDatabasePopulator medicationAdministeredHistoryDatabasePopulator;

	@Autowired
	private MedicationCompoundRepository medicationCompoundRepository;

	@Autowired
	private MedicationCompoundDatabasePopulator medicationCompoundDatabasePopulator;

	private final MedicationCompoundFactory medicationCompoundFactory = new MedicationCompoundFactory();

	@Autowired
	private MedicationItemRepository medicationItemRepository;

	@Autowired
	private MedicationItemDatabasePopulator medicationItemDatabasePopulator;

	private final MedicationItemFactory medicationItemFactory = new MedicationItemFactory();

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	private final StaffFactory staffFactory = new StaffFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		medicationAdministeredHistoryService = new MedicationAdministeredHistoryService(
			medicationCompoundRepository,
			medicationItemRepository,
			staffRepository,
			validator,
			auditRepository,
			medicationAdministeredHistoryRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMedicationAdministeredHistoryEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MedicationAdministeredHistoryEntity medicationAdministeredHistoryEntity = medicationAdministeredHistoryFactory.getObject(false, false);

		MedicationAdministeredHistoryEntity updatedEntity = medicationAdministeredHistoryService.updateOldData(medicationAdministeredHistoryEntity);
		Assertions.assertEquals(medicationAdministeredHistoryEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingMedicationAdministeredHistoryEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationAdministeredHistoryEntity medicationAdministeredHistoryEntity;
			MedicationAdministeredHistoryEntity entityWithUpdatedValues;

			try {
				medicationAdministeredHistoryEntity = medicationAdministeredHistoryFactory.getObject(false, false);
				medicationAdministeredHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(medicationAdministeredHistoryEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = medicationAdministeredHistoryFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationAdministeredHistoryEntity = medicationAdministeredHistoryService.create(medicationAdministeredHistoryEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(medicationAdministeredHistoryEntity.getId());

			MedicationAdministeredHistoryEntity updatedEntity = medicationAdministeredHistoryService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMedicationAdministeredHistoryEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MedicationAdministeredHistoryEntity medicationAdministeredHistoryEntity = medicationAdministeredHistoryFactory.getObject(false, false);
		medicationAdministeredHistoryEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			medicationAdministeredHistoryService.updateOldData(medicationAdministeredHistoryEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMedicationAdministeredHistoryEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationAdministeredHistoryEntity medicationAdministeredHistoryEntity;
			MedicationAdministeredHistoryEntity updatedMedicationAdministeredHistoryEntity;

			MedicationItemEntity medicationItemEntity;

			StaffEntity staffEntity;

			MedicationCompoundEntity medicationCompoundEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicationAdministeredHistoryEntity = medicationAdministeredHistoryFactory.getObject(true, false);
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
			medicationItemEntity = medicationAdministeredHistoryEntity.getMedicationItem();
			try {
				medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(medicationItemEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicationItemEntity = medicationItemRepository.save(medicationItemEntity);
			medicationAdministeredHistoryEntity.setMedicationItemId(medicationItemEntity.getId());

			staffEntity = medicationAdministeredHistoryEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			medicationAdministeredHistoryEntity.setStaffId(staffEntity.getId());

			medicationCompoundEntity = medicationAdministeredHistoryEntity.getMedicationCompound();
			try {
				medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(medicationCompoundEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicationCompoundEntity = medicationCompoundRepository.save(medicationCompoundEntity);
			medicationAdministeredHistoryEntity.setMedicationCompoundId(medicationCompoundEntity.getId());


			medicationAdministeredHistoryEntity = medicationAdministeredHistoryService.create(medicationAdministeredHistoryEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(medicationAdministeredHistoryEntity.getMedicationItem());
			medicationAdministeredHistoryEntity.setMedicationItemId(null);
			medicationAdministeredHistoryEntity.unsetMedicationItem();

			Assertions.assertNotNull(medicationAdministeredHistoryEntity.getStaff());
			medicationAdministeredHistoryEntity.setStaffId(null);
			medicationAdministeredHistoryEntity.unsetStaff();

			Assertions.assertNotNull(medicationAdministeredHistoryEntity.getMedicationCompound());
			medicationAdministeredHistoryEntity.setMedicationCompoundId(null);
			medicationAdministeredHistoryEntity.unsetMedicationCompound();


			updatedMedicationAdministeredHistoryEntity = medicationAdministeredHistoryService.updateOldData(medicationAdministeredHistoryEntity);

			Assertions.assertNull(updatedMedicationAdministeredHistoryEntity.getMedicationItem());

			Assertions.assertNull(updatedMedicationAdministeredHistoryEntity.getStaff());

			Assertions.assertNull(updatedMedicationAdministeredHistoryEntity.getMedicationCompound());

		});
	}

	@Test
	public void updateOldDataWithMedicationAdministeredHistoryEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationAdministeredHistoryEntity medicationAdministeredHistoryEntity;
			MedicationAdministeredHistoryEntity updatedMedicationAdministeredHistoryEntity;

			MedicationItemEntity medicationItemEntity;

			StaffEntity staffEntity;

			MedicationCompoundEntity medicationCompoundEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicationAdministeredHistoryEntity = medicationAdministeredHistoryFactory.getObject(true, false);
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
				medicationItemDatabasePopulator.populateRelatedEntitiesInDatabase(medicationAdministeredHistoryEntity.getMedicationItem(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medication Item relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicationItemEntity = medicationItemRepository.findById(medicationItemRepository.save(medicationAdministeredHistoryEntity.getMedicationItem()).getId()).get();
			medicationAdministeredHistoryEntity.unsetMedicationItem();
			medicationAdministeredHistoryEntity.setMedicationItemId(medicationItemEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicationAdministeredHistoryEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(medicationAdministeredHistoryEntity.getStaff()).getId()).get();
			medicationAdministeredHistoryEntity.unsetStaff();
			medicationAdministeredHistoryEntity.setStaffId(staffEntity.getId());

			try {
				medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(medicationAdministeredHistoryEntity.getMedicationCompound(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medication Compound relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicationCompoundEntity = medicationCompoundRepository.findById(medicationCompoundRepository.save(medicationAdministeredHistoryEntity.getMedicationCompound()).getId()).get();
			medicationAdministeredHistoryEntity.unsetMedicationCompound();
			medicationAdministeredHistoryEntity.setMedicationCompoundId(medicationCompoundEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMedicationAdministeredHistoryEntity = medicationAdministeredHistoryService.updateOldData(medicationAdministeredHistoryEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			medicationItemEntity.unsetMedicationAdministeredHisotries(false);
			updatedMedicationAdministeredHistoryEntity.getMedicationItem().unsetMedicationAdministeredHisotries(false);
			Assertions.assertEquals(medicationItemEntity, updatedMedicationAdministeredHistoryEntity.getMedicationItem());

			staffEntity.unsetMedicationAdministeredHisotries(false);
			updatedMedicationAdministeredHistoryEntity.getStaff().unsetMedicationAdministeredHisotries(false);
			Assertions.assertEquals(staffEntity, updatedMedicationAdministeredHistoryEntity.getStaff());

			medicationCompoundEntity.unsetMedicationAdministeredHistories(false);
			updatedMedicationAdministeredHistoryEntity.getMedicationCompound().unsetMedicationAdministeredHistories(false);
			Assertions.assertEquals(medicationCompoundEntity, updatedMedicationAdministeredHistoryEntity.getMedicationCompound());

		});
	}

	@Test
	public void whenCreateMedicationAdministeredHistoryEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationAdministeredHistoryEntity medicationAdministeredHistoryEntity;
			Optional<MedicationAdministeredHistoryEntity> fetchedMedicationAdministeredHistoryEntity;

			try {
				medicationAdministeredHistoryEntity = medicationAdministeredHistoryFactory.getObject(false, false);
				medicationAdministeredHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(medicationAdministeredHistoryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationAdministeredHistoryEntity = medicationAdministeredHistoryService.create(medicationAdministeredHistoryEntity);

			fetchedMedicationAdministeredHistoryEntity = medicationAdministeredHistoryService.findById(medicationAdministeredHistoryEntity.getId());

			Assertions.assertTrue(fetchedMedicationAdministeredHistoryEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMedicationAdministeredHistoryEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(medicationAdministeredHistoryEntity, fetchedMedicationAdministeredHistoryEntity.get());
		});
	}

	@Test
	public void whenUpdateMedicationAdministeredHistoryEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationAdministeredHistoryEntity medicationAdministeredHistoryEntity;
			MedicationAdministeredHistoryEntity updatedMedicationAdministeredHistoryEntity;
			Optional<MedicationAdministeredHistoryEntity> fetchedMedicationAdministeredHistoryEntity;

			try {
				medicationAdministeredHistoryEntity = medicationAdministeredHistoryFactory.getObject(false, false);
				medicationAdministeredHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(medicationAdministeredHistoryEntity, true, true, false);
				updatedMedicationAdministeredHistoryEntity = medicationAdministeredHistoryFactory.getObject(false, false);
				medicationAdministeredHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMedicationAdministeredHistoryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationAdministeredHistoryEntity = medicationAdministeredHistoryService.create(medicationAdministeredHistoryEntity);

			updatedMedicationAdministeredHistoryEntity.setId(medicationAdministeredHistoryEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMedicationAdministeredHistoryEntity.setCreated(medicationAdministeredHistoryEntity.getCreated());

			updatedMedicationAdministeredHistoryEntity = medicationAdministeredHistoryService.update(updatedMedicationAdministeredHistoryEntity);

			fetchedMedicationAdministeredHistoryEntity = medicationAdministeredHistoryService.findById(medicationAdministeredHistoryEntity.getId());

			Assertions.assertTrue(fetchedMedicationAdministeredHistoryEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMedicationAdministeredHistoryEntity_ThenEntityIsCreated
			fetchedMedicationAdministeredHistoryEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMedicationAdministeredHistoryEntity, fetchedMedicationAdministeredHistoryEntity.get());
		});
	}

	@Test
	public void whenDeleteMedicationAdministeredHistoryEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationAdministeredHistoryEntity medicationAdministeredHistoryEntity;
			Optional<MedicationAdministeredHistoryEntity> fetchedMedicationAdministeredHistoryEntity;

			try {
				medicationAdministeredHistoryEntity = medicationAdministeredHistoryFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				medicationAdministeredHistoryDatabasePopulator.populateRelatedEntitiesInDatabase(medicationAdministeredHistoryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationAdministeredHistoryEntity = medicationAdministeredHistoryService.create(medicationAdministeredHistoryEntity);

			medicationAdministeredHistoryService.deleteById(medicationAdministeredHistoryEntity.getId());
			fetchedMedicationAdministeredHistoryEntity = medicationAdministeredHistoryService.findById(medicationAdministeredHistoryEntity.getId());

			Assertions.assertTrue(fetchedMedicationAdministeredHistoryEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
