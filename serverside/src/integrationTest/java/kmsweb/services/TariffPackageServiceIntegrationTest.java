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
import kmsweb.entities.TariffPackageEntity;
import kmsweb.repositories.TariffPackageRepository;
import kmsweb.utils.TariffPackageFactory;
import kmsweb.utils.DatabasePopulators.TariffPackageDatabasePopulator;
import kmsweb.entities.ServiceItemAssignmentEntity;
import kmsweb.repositories.ServiceItemAssignmentRepository;
import kmsweb.utils.ServiceItemAssignmentFactory;
import kmsweb.utils.DatabasePopulators.ServiceItemAssignmentDatabasePopulator;
import kmsweb.entities.TariffPackageItemEntity;
import kmsweb.repositories.TariffPackageItemRepository;
import kmsweb.utils.TariffPackageItemFactory;
import kmsweb.utils.DatabasePopulators.TariffPackageItemDatabasePopulator;
import kmsweb.entities.TariffPackageServiceAssignmentEntity;
import kmsweb.repositories.TariffPackageServiceAssignmentRepository;
import kmsweb.utils.TariffPackageServiceAssignmentFactory;
import kmsweb.utils.DatabasePopulators.TariffPackageServiceAssignmentDatabasePopulator;
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
public class TariffPackageServiceIntegrationTest {

	@Autowired
	private TariffPackageRepository tariffPackageRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private TariffPackageService tariffPackageService;

	private final TariffPackageFactory tariffPackageFactory = new TariffPackageFactory();

	@Autowired
	private TariffPackageDatabasePopulator tariffPackageDatabasePopulator;

	@Autowired
	private ServiceItemAssignmentRepository serviceItemAssignmentRepository;

	@Autowired
	private ServiceItemAssignmentDatabasePopulator serviceItemAssignmentDatabasePopulator;

	private final ServiceItemAssignmentFactory serviceItemAssignmentFactory = new ServiceItemAssignmentFactory();

	@Autowired
	private TariffPackageItemRepository tariffPackageItemRepository;

	@Autowired
	private TariffPackageItemDatabasePopulator tariffPackageItemDatabasePopulator;

	private final TariffPackageItemFactory tariffPackageItemFactory = new TariffPackageItemFactory();

	@Autowired
	private TariffPackageServiceAssignmentRepository tariffPackageServiceAssignmentRepository;

	@Autowired
	private TariffPackageServiceAssignmentDatabasePopulator tariffPackageServiceAssignmentDatabasePopulator;

	private final TariffPackageServiceAssignmentFactory tariffPackageServiceAssignmentFactory = new TariffPackageServiceAssignmentFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		tariffPackageService = new TariffPackageService(
			serviceItemAssignmentRepository,
			tariffPackageItemRepository,
			tariffPackageServiceAssignmentRepository,
			validator,
			auditRepository,
			tariffPackageRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewTariffPackageEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		TariffPackageEntity tariffPackageEntity = tariffPackageFactory.getObject(false, false);

		TariffPackageEntity updatedEntity = tariffPackageService.updateOldData(tariffPackageEntity);
		Assertions.assertEquals(tariffPackageEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewTariffPackageEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		TariffPackageEntity tariffPackageEntity = tariffPackageFactory.getObject(false, false);

		tariffPackageEntity.setApplyToAllServices(null);
		Assertions.assertNull(tariffPackageEntity.getApplyToAllServices());


		TariffPackageEntity updatedEntity = tariffPackageService.updateOldData(tariffPackageEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getApplyToAllServices());
		Assertions.assertFalse(updatedEntity.getApplyToAllServices());

	}

	@Test
	public void updateOldDataWithExistingTariffPackageEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			TariffPackageEntity tariffPackageEntity;
			TariffPackageEntity entityWithUpdatedValues;

			try {
				tariffPackageEntity = tariffPackageFactory.getObject(false, false);
				tariffPackageDatabasePopulator.populateRelatedEntitiesInDatabase(tariffPackageEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = tariffPackageFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffPackageEntity = tariffPackageService.create(tariffPackageEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(tariffPackageEntity.getId());

			TariffPackageEntity updatedEntity = tariffPackageService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithTariffPackageEntityWithNonExistentId_ShouldThrowException() throws Exception {
		TariffPackageEntity tariffPackageEntity = tariffPackageFactory.getObject(false, false);
		tariffPackageEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			tariffPackageService.updateOldData(tariffPackageEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingTariffPackageEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TariffPackageEntity tariffPackageEntity;
			TariffPackageEntity updatedTariffPackageEntity;

			Set<ServiceItemAssignmentEntity> serviceItemAssignmentsEntities;

			Set<TariffPackageItemEntity> tariffPackageItemsEntities;

			Set<TariffPackageServiceAssignmentEntity> tariffPackageServiceAssignmentsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				tariffPackageEntity = tariffPackageFactory.getObject(true, false);
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
			serviceItemAssignmentsEntities = tariffPackageEntity.getServiceItemAssignments();
			Set<UUID> serviceItemAssignmentsEntityIds = new HashSet<>();
			for (ServiceItemAssignmentEntity entity : serviceItemAssignmentsEntities) {
				try {
					serviceItemAssignmentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				serviceItemAssignmentsEntityIds.add(serviceItemAssignmentRepository.save(entity).getId());
			}
			tariffPackageEntity.setServiceItemAssignmentsIds(serviceItemAssignmentsEntityIds);

			tariffPackageItemsEntities = tariffPackageEntity.getTariffPackageItems();
			Set<UUID> tariffPackageItemsEntityIds = new HashSet<>();
			for (TariffPackageItemEntity entity : tariffPackageItemsEntities) {
				try {
					tariffPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				tariffPackageItemsEntityIds.add(tariffPackageItemRepository.save(entity).getId());
			}
			tariffPackageEntity.setTariffPackageItemsIds(tariffPackageItemsEntityIds);

			tariffPackageServiceAssignmentsEntities = tariffPackageEntity.getTariffPackageServiceAssignments();
			Set<UUID> tariffPackageServiceAssignmentsEntityIds = new HashSet<>();
			for (TariffPackageServiceAssignmentEntity entity : tariffPackageServiceAssignmentsEntities) {
				try {
					tariffPackageServiceAssignmentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				tariffPackageServiceAssignmentsEntityIds.add(tariffPackageServiceAssignmentRepository.save(entity).getId());
			}
			tariffPackageEntity.setTariffPackageServiceAssignmentsIds(tariffPackageServiceAssignmentsEntityIds);


			tariffPackageEntity = tariffPackageService.create(tariffPackageEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(tariffPackageEntity.getServiceItemAssignments().size() > 0);
			tariffPackageEntity.setServiceItemAssignmentsIds(new HashSet<UUID>());
			tariffPackageEntity.unsetServiceItemAssignments();

			Assertions.assertTrue(tariffPackageEntity.getTariffPackageItems().size() > 0);
			tariffPackageEntity.setTariffPackageItemsIds(new HashSet<UUID>());
			tariffPackageEntity.unsetTariffPackageItems();

			Assertions.assertTrue(tariffPackageEntity.getTariffPackageServiceAssignments().size() > 0);
			tariffPackageEntity.setTariffPackageServiceAssignmentsIds(new HashSet<UUID>());
			tariffPackageEntity.unsetTariffPackageServiceAssignments();


			updatedTariffPackageEntity = tariffPackageService.updateOldData(tariffPackageEntity);

			Assertions.assertEquals(0, updatedTariffPackageEntity.getServiceItemAssignments().size());

			Assertions.assertEquals(0, updatedTariffPackageEntity.getTariffPackageItems().size());

			Assertions.assertEquals(0, updatedTariffPackageEntity.getTariffPackageServiceAssignments().size());

		});
	}

	@Test
	public void updateOldDataWithTariffPackageEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			TariffPackageEntity tariffPackageEntity;
			TariffPackageEntity updatedTariffPackageEntity;

			Set<ServiceItemAssignmentEntity> serviceItemAssignmentsEntities;
			Set<UUID> serviceItemAssignmentsEntityIds;

			Set<TariffPackageItemEntity> tariffPackageItemsEntities;
			Set<UUID> tariffPackageItemsEntityIds;

			Set<TariffPackageServiceAssignmentEntity> tariffPackageServiceAssignmentsEntities;
			Set<UUID> tariffPackageServiceAssignmentsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				tariffPackageEntity = tariffPackageFactory.getObject(true, false);
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
			serviceItemAssignmentsEntities = new HashSet<>();
			serviceItemAssignmentsEntityIds = new HashSet<>();
			for (ServiceItemAssignmentEntity entity : tariffPackageEntity.getServiceItemAssignments()) {
				try {
					serviceItemAssignmentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Service Item Assignments relation for this test: " + e.getCause());
					return;
				}
				UUID id = serviceItemAssignmentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				serviceItemAssignmentsEntities.add(serviceItemAssignmentRepository.findById(id).get());
				serviceItemAssignmentsEntityIds.add(id);
			}
			tariffPackageEntity.unsetServiceItemAssignments();
			tariffPackageEntity.setServiceItemAssignmentsIds(serviceItemAssignmentsEntityIds);

			tariffPackageItemsEntities = new HashSet<>();
			tariffPackageItemsEntityIds = new HashSet<>();
			for (TariffPackageItemEntity entity : tariffPackageEntity.getTariffPackageItems()) {
				try {
					tariffPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Tariff Package Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = tariffPackageItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				tariffPackageItemsEntities.add(tariffPackageItemRepository.findById(id).get());
				tariffPackageItemsEntityIds.add(id);
			}
			tariffPackageEntity.unsetTariffPackageItems();
			tariffPackageEntity.setTariffPackageItemsIds(tariffPackageItemsEntityIds);

			tariffPackageServiceAssignmentsEntities = new HashSet<>();
			tariffPackageServiceAssignmentsEntityIds = new HashSet<>();
			for (TariffPackageServiceAssignmentEntity entity : tariffPackageEntity.getTariffPackageServiceAssignments()) {
				try {
					tariffPackageServiceAssignmentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Tariff Package Service Assignments relation for this test: " + e.getCause());
					return;
				}
				UUID id = tariffPackageServiceAssignmentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				tariffPackageServiceAssignmentsEntities.add(tariffPackageServiceAssignmentRepository.findById(id).get());
				tariffPackageServiceAssignmentsEntityIds.add(id);
			}
			tariffPackageEntity.unsetTariffPackageServiceAssignments();
			tariffPackageEntity.setTariffPackageServiceAssignmentsIds(tariffPackageServiceAssignmentsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedTariffPackageEntity = tariffPackageService.updateOldData(tariffPackageEntity);

			Assertions.assertEquals(serviceItemAssignmentsEntities.size(), updatedTariffPackageEntity.getServiceItemAssignments().size());

			Assertions.assertEquals(tariffPackageItemsEntities.size(), updatedTariffPackageEntity.getTariffPackageItems().size());

			Assertions.assertEquals(tariffPackageServiceAssignmentsEntities.size(), updatedTariffPackageEntity.getTariffPackageServiceAssignments().size());

		});
	}

	@Test
	public void whenCreateTariffPackageEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			TariffPackageEntity tariffPackageEntity;
			Optional<TariffPackageEntity> fetchedTariffPackageEntity;

			try {
				tariffPackageEntity = tariffPackageFactory.getObject(false, false);
				tariffPackageDatabasePopulator.populateRelatedEntitiesInDatabase(tariffPackageEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffPackageEntity = tariffPackageService.create(tariffPackageEntity);

			fetchedTariffPackageEntity = tariffPackageService.findById(tariffPackageEntity.getId());

			Assertions.assertTrue(fetchedTariffPackageEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedTariffPackageEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(tariffPackageEntity, fetchedTariffPackageEntity.get());
		});
	}

	@Test
	public void whenUpdateTariffPackageEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			TariffPackageEntity tariffPackageEntity;
			TariffPackageEntity updatedTariffPackageEntity;
			Optional<TariffPackageEntity> fetchedTariffPackageEntity;

			try {
				tariffPackageEntity = tariffPackageFactory.getObject(false, false);
				tariffPackageDatabasePopulator.populateRelatedEntitiesInDatabase(tariffPackageEntity, true, true, false);
				updatedTariffPackageEntity = tariffPackageFactory.getObject(false, false);
				tariffPackageDatabasePopulator.populateRelatedEntitiesInDatabase(updatedTariffPackageEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffPackageEntity = tariffPackageService.create(tariffPackageEntity);

			updatedTariffPackageEntity.setId(tariffPackageEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedTariffPackageEntity.setCreated(tariffPackageEntity.getCreated());

			updatedTariffPackageEntity = tariffPackageService.update(updatedTariffPackageEntity);

			fetchedTariffPackageEntity = tariffPackageService.findById(tariffPackageEntity.getId());

			Assertions.assertTrue(fetchedTariffPackageEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateTariffPackageEntity_ThenEntityIsCreated
			fetchedTariffPackageEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedTariffPackageEntity, fetchedTariffPackageEntity.get());
		});
	}

	@Test
	public void whenDeleteTariffPackageEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			TariffPackageEntity tariffPackageEntity;
			Optional<TariffPackageEntity> fetchedTariffPackageEntity;

			try {
				tariffPackageEntity = tariffPackageFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				tariffPackageDatabasePopulator.populateRelatedEntitiesInDatabase(tariffPackageEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			tariffPackageEntity = tariffPackageService.create(tariffPackageEntity);

			tariffPackageService.deleteById(tariffPackageEntity.getId());
			fetchedTariffPackageEntity = tariffPackageService.findById(tariffPackageEntity.getId());

			Assertions.assertTrue(fetchedTariffPackageEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
