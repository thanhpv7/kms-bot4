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
import kmsweb.entities.McuPackageItemEntity;
import kmsweb.repositories.McuPackageItemRepository;
import kmsweb.utils.McuPackageItemFactory;
import kmsweb.utils.DatabasePopulators.McuPackageItemDatabasePopulator;
import kmsweb.entities.ExaminationItemEntity;
import kmsweb.repositories.ExaminationItemRepository;
import kmsweb.utils.ExaminationItemFactory;
import kmsweb.utils.DatabasePopulators.ExaminationItemDatabasePopulator;
import kmsweb.entities.McuPackageEntity;
import kmsweb.repositories.McuPackageRepository;
import kmsweb.utils.McuPackageFactory;
import kmsweb.utils.DatabasePopulators.McuPackageDatabasePopulator;
import kmsweb.entities.ServiceEntity;
import kmsweb.repositories.ServiceRepository;
import kmsweb.utils.ServiceFactory;
import kmsweb.utils.DatabasePopulators.ServiceDatabasePopulator;
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
public class McuPackageItemServiceIntegrationTest {

	@Autowired
	private McuPackageItemRepository mcuPackageItemRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private McuPackageItemService mcuPackageItemService;

	private final McuPackageItemFactory mcuPackageItemFactory = new McuPackageItemFactory();

	@Autowired
	private McuPackageItemDatabasePopulator mcuPackageItemDatabasePopulator;

	@Autowired
	private ExaminationItemRepository examinationItemRepository;

	@Autowired
	private ExaminationItemDatabasePopulator examinationItemDatabasePopulator;

	private final ExaminationItemFactory examinationItemFactory = new ExaminationItemFactory();

	@Autowired
	private McuPackageRepository mcuPackageRepository;

	@Autowired
	private McuPackageDatabasePopulator mcuPackageDatabasePopulator;

	private final McuPackageFactory mcuPackageFactory = new McuPackageFactory();

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ServiceDatabasePopulator serviceDatabasePopulator;

	private final ServiceFactory serviceFactory = new ServiceFactory();

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
		mcuPackageItemService = new McuPackageItemService(
			examinationItemRepository,
			mcuPackageRepository,
			serviceRepository,
			staffRepository,
			validator,
			auditRepository,
			mcuPackageItemRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMcuPackageItemEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		McuPackageItemEntity mcuPackageItemEntity = mcuPackageItemFactory.getObject(false, false);

		McuPackageItemEntity updatedEntity = mcuPackageItemService.updateOldData(mcuPackageItemEntity);
		Assertions.assertEquals(mcuPackageItemEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingMcuPackageItemEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageItemEntity mcuPackageItemEntity;
			McuPackageItemEntity entityWithUpdatedValues;

			try {
				mcuPackageItemEntity = mcuPackageItemFactory.getObject(false, false);
				mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageItemEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = mcuPackageItemFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			mcuPackageItemEntity = mcuPackageItemService.create(mcuPackageItemEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(mcuPackageItemEntity.getId());

			McuPackageItemEntity updatedEntity = mcuPackageItemService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMcuPackageItemEntityWithNonExistentId_ShouldThrowException() throws Exception {
		McuPackageItemEntity mcuPackageItemEntity = mcuPackageItemFactory.getObject(false, false);
		mcuPackageItemEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			mcuPackageItemService.updateOldData(mcuPackageItemEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMcuPackageItemEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageItemEntity mcuPackageItemEntity;
			McuPackageItemEntity updatedMcuPackageItemEntity;

			McuPackageEntity mcuPackageEntity;

			ServiceEntity serviceEntity;

			StaffEntity staffEntity;

			Set<ExaminationItemEntity> examinationItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				mcuPackageItemEntity = mcuPackageItemFactory.getObject(true, false);
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
			mcuPackageEntity = mcuPackageItemEntity.getMcuPackage();
			try {
				mcuPackageDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			mcuPackageEntity = mcuPackageRepository.save(mcuPackageEntity);
			mcuPackageItemEntity.setMcuPackageId(mcuPackageEntity.getId());

			serviceEntity = mcuPackageItemEntity.getService();
			try {
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			serviceEntity = serviceRepository.save(serviceEntity);
			mcuPackageItemEntity.setServiceId(serviceEntity.getId());

			staffEntity = mcuPackageItemEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			mcuPackageItemEntity.setStaffId(staffEntity.getId());

			examinationItemsEntities = mcuPackageItemEntity.getExaminationItems();
			Set<UUID> examinationItemsEntityIds = new HashSet<>();
			for (ExaminationItemEntity entity : examinationItemsEntities) {
				try {
					examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				examinationItemsEntityIds.add(examinationItemRepository.save(entity).getId());
			}
			mcuPackageItemEntity.setExaminationItemsIds(examinationItemsEntityIds);

			mcuPackageItemEntity = mcuPackageItemService.create(mcuPackageItemEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(mcuPackageItemEntity.getMcuPackage());
			mcuPackageItemEntity.setMcuPackageId(null);
			mcuPackageItemEntity.unsetMcuPackage();

			Assertions.assertNotNull(mcuPackageItemEntity.getService());
			mcuPackageItemEntity.setServiceId(null);
			mcuPackageItemEntity.unsetService();

			Assertions.assertNotNull(mcuPackageItemEntity.getStaff());
			mcuPackageItemEntity.setStaffId(null);
			mcuPackageItemEntity.unsetStaff();

			Assertions.assertTrue(mcuPackageItemEntity.getExaminationItems().size() > 0);
			mcuPackageItemEntity.setExaminationItemsIds(new HashSet<UUID>());
			mcuPackageItemEntity.unsetExaminationItems();


			updatedMcuPackageItemEntity = mcuPackageItemService.updateOldData(mcuPackageItemEntity);

			Assertions.assertNull(updatedMcuPackageItemEntity.getMcuPackage());

			Assertions.assertNull(updatedMcuPackageItemEntity.getService());

			Assertions.assertNull(updatedMcuPackageItemEntity.getStaff());

			Assertions.assertEquals(0, updatedMcuPackageItemEntity.getExaminationItems().size());

		});
	}

	@Test
	public void updateOldDataWithMcuPackageItemEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageItemEntity mcuPackageItemEntity;
			McuPackageItemEntity updatedMcuPackageItemEntity;

			McuPackageEntity mcuPackageEntity;

			ServiceEntity serviceEntity;

			StaffEntity staffEntity;

			Set<ExaminationItemEntity> examinationItemsEntities;
			Set<UUID> examinationItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				mcuPackageItemEntity = mcuPackageItemFactory.getObject(true, false);
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
				mcuPackageDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageItemEntity.getMcuPackage(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the MCU Package relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			mcuPackageEntity = mcuPackageRepository.findById(mcuPackageRepository.save(mcuPackageItemEntity.getMcuPackage()).getId()).get();
			mcuPackageItemEntity.unsetMcuPackage();
			mcuPackageItemEntity.setMcuPackageId(mcuPackageEntity.getId());

			try {
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageItemEntity.getService(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Service relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			serviceEntity = serviceRepository.findById(serviceRepository.save(mcuPackageItemEntity.getService()).getId()).get();
			mcuPackageItemEntity.unsetService();
			mcuPackageItemEntity.setServiceId(serviceEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageItemEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(mcuPackageItemEntity.getStaff()).getId()).get();
			mcuPackageItemEntity.unsetStaff();
			mcuPackageItemEntity.setStaffId(staffEntity.getId());

			examinationItemsEntities = new HashSet<>();
			examinationItemsEntityIds = new HashSet<>();
			for (ExaminationItemEntity entity : mcuPackageItemEntity.getExaminationItems()) {
				try {
					examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Examination Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = examinationItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				examinationItemsEntities.add(examinationItemRepository.findById(id).get());
				examinationItemsEntityIds.add(id);
			}
			mcuPackageItemEntity.unsetExaminationItems();
			mcuPackageItemEntity.setExaminationItemsIds(examinationItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMcuPackageItemEntity = mcuPackageItemService.updateOldData(mcuPackageItemEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			mcuPackageEntity.unsetMcuPackageItems(false);
			updatedMcuPackageItemEntity.getMcuPackage().unsetMcuPackageItems(false);
			Assertions.assertEquals(mcuPackageEntity, updatedMcuPackageItemEntity.getMcuPackage());

			serviceEntity.unsetMcuPackageItems(false);
			updatedMcuPackageItemEntity.getService().unsetMcuPackageItems(false);
			Assertions.assertEquals(serviceEntity, updatedMcuPackageItemEntity.getService());

			staffEntity.unsetMcuPackageItems(false);
			updatedMcuPackageItemEntity.getStaff().unsetMcuPackageItems(false);
			Assertions.assertEquals(staffEntity, updatedMcuPackageItemEntity.getStaff());

			Assertions.assertEquals(examinationItemsEntities.size(), updatedMcuPackageItemEntity.getExaminationItems().size());

		});
	}

	@Test
	public void whenCreateMcuPackageItemEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageItemEntity mcuPackageItemEntity;
			Optional<McuPackageItemEntity> fetchedMcuPackageItemEntity;

			try {
				mcuPackageItemEntity = mcuPackageItemFactory.getObject(false, false);
				mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			mcuPackageItemEntity = mcuPackageItemService.create(mcuPackageItemEntity);

			fetchedMcuPackageItemEntity = mcuPackageItemService.findById(mcuPackageItemEntity.getId());

			Assertions.assertTrue(fetchedMcuPackageItemEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMcuPackageItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(mcuPackageItemEntity, fetchedMcuPackageItemEntity.get());
		});
	}

	@Test
	public void whenUpdateMcuPackageItemEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageItemEntity mcuPackageItemEntity;
			McuPackageItemEntity updatedMcuPackageItemEntity;
			Optional<McuPackageItemEntity> fetchedMcuPackageItemEntity;

			try {
				mcuPackageItemEntity = mcuPackageItemFactory.getObject(false, false);
				mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageItemEntity, true, true, false);
				updatedMcuPackageItemEntity = mcuPackageItemFactory.getObject(false, false);
				mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMcuPackageItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			mcuPackageItemEntity = mcuPackageItemService.create(mcuPackageItemEntity);

			updatedMcuPackageItemEntity.setId(mcuPackageItemEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMcuPackageItemEntity.setCreated(mcuPackageItemEntity.getCreated());

			updatedMcuPackageItemEntity = mcuPackageItemService.update(updatedMcuPackageItemEntity);

			fetchedMcuPackageItemEntity = mcuPackageItemService.findById(mcuPackageItemEntity.getId());

			Assertions.assertTrue(fetchedMcuPackageItemEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMcuPackageItemEntity_ThenEntityIsCreated
			fetchedMcuPackageItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMcuPackageItemEntity, fetchedMcuPackageItemEntity.get());
		});
	}

	@Test
	public void whenDeleteMcuPackageItemEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			McuPackageItemEntity mcuPackageItemEntity;
			Optional<McuPackageItemEntity> fetchedMcuPackageItemEntity;

			try {
				mcuPackageItemEntity = mcuPackageItemFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(mcuPackageItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			mcuPackageItemEntity = mcuPackageItemService.create(mcuPackageItemEntity);

			mcuPackageItemService.deleteById(mcuPackageItemEntity.getId());
			fetchedMcuPackageItemEntity = mcuPackageItemService.findById(mcuPackageItemEntity.getId());

			Assertions.assertTrue(fetchedMcuPackageItemEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
