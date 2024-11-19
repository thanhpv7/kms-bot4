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
import kmsweb.entities.ServiceItemEntity;
import kmsweb.repositories.ServiceItemRepository;
import kmsweb.utils.ServiceItemFactory;
import kmsweb.utils.DatabasePopulators.ServiceItemDatabasePopulator;
import kmsweb.entities.ExaminationItemEntity;
import kmsweb.repositories.ExaminationItemRepository;
import kmsweb.utils.ExaminationItemFactory;
import kmsweb.utils.DatabasePopulators.ExaminationItemDatabasePopulator;
import kmsweb.entities.ServiceEntity;
import kmsweb.repositories.ServiceRepository;
import kmsweb.utils.ServiceFactory;
import kmsweb.utils.DatabasePopulators.ServiceDatabasePopulator;
import kmsweb.entities.ServiceItemAssignmentEntity;
import kmsweb.repositories.ServiceItemAssignmentRepository;
import kmsweb.utils.ServiceItemAssignmentFactory;
import kmsweb.utils.DatabasePopulators.ServiceItemAssignmentDatabasePopulator;
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
public class ServiceItemServiceIntegrationTest {

	@Autowired
	private ServiceItemRepository serviceItemRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private ServiceItemService serviceItemService;

	private final ServiceItemFactory serviceItemFactory = new ServiceItemFactory();

	@Autowired
	private ServiceItemDatabasePopulator serviceItemDatabasePopulator;

	@Autowired
	private ExaminationItemRepository examinationItemRepository;

	@Autowired
	private ExaminationItemDatabasePopulator examinationItemDatabasePopulator;

	private final ExaminationItemFactory examinationItemFactory = new ExaminationItemFactory();

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ServiceDatabasePopulator serviceDatabasePopulator;

	private final ServiceFactory serviceFactory = new ServiceFactory();

	@Autowired
	private ServiceItemAssignmentRepository serviceItemAssignmentRepository;

	@Autowired
	private ServiceItemAssignmentDatabasePopulator serviceItemAssignmentDatabasePopulator;

	private final ServiceItemAssignmentFactory serviceItemAssignmentFactory = new ServiceItemAssignmentFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		serviceItemService = new ServiceItemService(
			examinationItemRepository,
			serviceRepository,
			serviceItemAssignmentRepository,
			validator,
			auditRepository,
			serviceItemRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewServiceItemEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		ServiceItemEntity serviceItemEntity = serviceItemFactory.getObject(false, false);

		ServiceItemEntity updatedEntity = serviceItemService.updateOldData(serviceItemEntity);
		Assertions.assertEquals(serviceItemEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewServiceItemEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		ServiceItemEntity serviceItemEntity = serviceItemFactory.getObject(false, false);

		serviceItemEntity.setApplyToAllService(null);
		Assertions.assertNull(serviceItemEntity.getApplyToAllService());


		ServiceItemEntity updatedEntity = serviceItemService.updateOldData(serviceItemEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getApplyToAllService());
		Assertions.assertFalse(updatedEntity.getApplyToAllService());

	}

	@Test
	public void updateOldDataWithExistingServiceItemEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceItemEntity serviceItemEntity;
			ServiceItemEntity entityWithUpdatedValues;

			try {
				serviceItemEntity = serviceItemFactory.getObject(false, false);
				serviceItemDatabasePopulator.populateRelatedEntitiesInDatabase(serviceItemEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = serviceItemFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			serviceItemEntity = serviceItemService.create(serviceItemEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(serviceItemEntity.getId());

			ServiceItemEntity updatedEntity = serviceItemService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithServiceItemEntityWithNonExistentId_ShouldThrowException() throws Exception {
		ServiceItemEntity serviceItemEntity = serviceItemFactory.getObject(false, false);
		serviceItemEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			serviceItemService.updateOldData(serviceItemEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingServiceItemEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceItemEntity serviceItemEntity;
			ServiceItemEntity updatedServiceItemEntity;

			Set<ExaminationItemEntity> examinationItemsEntities;

			Set<ServiceItemAssignmentEntity> serviceItemAssignmentsEntities;

			Set<ServiceEntity> servicesEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				serviceItemEntity = serviceItemFactory.getObject(true, false);
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
			examinationItemsEntities = serviceItemEntity.getExaminationItems();
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
			serviceItemEntity.setExaminationItemsIds(examinationItemsEntityIds);

			serviceItemAssignmentsEntities = serviceItemEntity.getServiceItemAssignments();
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
			serviceItemEntity.setServiceItemAssignmentsIds(serviceItemAssignmentsEntityIds);

			servicesEntities = serviceItemEntity.getServices();
			Set<UUID> servicesEntityIds = new HashSet<>();
			for (ServiceEntity entity : servicesEntities) {
				try {
					serviceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				servicesEntityIds.add(serviceRepository.save(entity).getId());
			}
			serviceItemEntity.setServicesIds(servicesEntityIds);

			serviceItemEntity = serviceItemService.create(serviceItemEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(serviceItemEntity.getExaminationItems().size() > 0);
			serviceItemEntity.setExaminationItemsIds(new HashSet<UUID>());
			serviceItemEntity.unsetExaminationItems();

			Assertions.assertTrue(serviceItemEntity.getServiceItemAssignments().size() > 0);
			serviceItemEntity.setServiceItemAssignmentsIds(new HashSet<UUID>());
			serviceItemEntity.unsetServiceItemAssignments();

			Assertions.assertTrue(serviceItemEntity.getServices().size() > 0);
			serviceItemEntity.setServicesIds(new HashSet<UUID>());
			serviceItemEntity.unsetServices();


			updatedServiceItemEntity = serviceItemService.updateOldData(serviceItemEntity);

			Assertions.assertEquals(0, updatedServiceItemEntity.getExaminationItems().size());

			Assertions.assertEquals(0, updatedServiceItemEntity.getServiceItemAssignments().size());

			Assertions.assertEquals(0, updatedServiceItemEntity.getServices().size());

		});
	}

	@Test
	public void updateOldDataWithServiceItemEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceItemEntity serviceItemEntity;
			ServiceItemEntity updatedServiceItemEntity;

			Set<ExaminationItemEntity> examinationItemsEntities;
			Set<UUID> examinationItemsEntityIds;

			Set<ServiceItemAssignmentEntity> serviceItemAssignmentsEntities;
			Set<UUID> serviceItemAssignmentsEntityIds;

			Set<ServiceEntity> servicesEntities;
			Set<UUID> servicesEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				serviceItemEntity = serviceItemFactory.getObject(true, false);
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
			examinationItemsEntities = new HashSet<>();
			examinationItemsEntityIds = new HashSet<>();
			for (ExaminationItemEntity entity : serviceItemEntity.getExaminationItems()) {
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
			serviceItemEntity.unsetExaminationItems();
			serviceItemEntity.setExaminationItemsIds(examinationItemsEntityIds);

			serviceItemAssignmentsEntities = new HashSet<>();
			serviceItemAssignmentsEntityIds = new HashSet<>();
			for (ServiceItemAssignmentEntity entity : serviceItemEntity.getServiceItemAssignments()) {
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
			serviceItemEntity.unsetServiceItemAssignments();
			serviceItemEntity.setServiceItemAssignmentsIds(serviceItemAssignmentsEntityIds);

			servicesEntities = new HashSet<>();
			servicesEntityIds = new HashSet<>();
			for (ServiceEntity entity : serviceItemEntity.getServices()) {
				try {
					serviceDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Services relation for this test: " + e.getCause());
					return;
				}
				UUID id = serviceRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				servicesEntities.add(serviceRepository.findById(id).get());
				servicesEntityIds.add(id);
			}
			serviceItemEntity.unsetServices();
			serviceItemEntity.setServicesIds(servicesEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedServiceItemEntity = serviceItemService.updateOldData(serviceItemEntity);

			Assertions.assertEquals(examinationItemsEntities.size(), updatedServiceItemEntity.getExaminationItems().size());

			Assertions.assertEquals(serviceItemAssignmentsEntities.size(), updatedServiceItemEntity.getServiceItemAssignments().size());

			Assertions.assertEquals(servicesEntities.size(), updatedServiceItemEntity.getServices().size());

		});
	}

	@Test
	public void whenCreateServiceItemEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceItemEntity serviceItemEntity;
			Optional<ServiceItemEntity> fetchedServiceItemEntity;

			try {
				serviceItemEntity = serviceItemFactory.getObject(false, false);
				serviceItemDatabasePopulator.populateRelatedEntitiesInDatabase(serviceItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			serviceItemEntity = serviceItemService.create(serviceItemEntity);

			fetchedServiceItemEntity = serviceItemService.findById(serviceItemEntity.getId());

			Assertions.assertTrue(fetchedServiceItemEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedServiceItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(serviceItemEntity, fetchedServiceItemEntity.get());
		});
	}

	@Test
	public void whenUpdateServiceItemEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceItemEntity serviceItemEntity;
			ServiceItemEntity updatedServiceItemEntity;
			Optional<ServiceItemEntity> fetchedServiceItemEntity;

			try {
				serviceItemEntity = serviceItemFactory.getObject(false, false);
				serviceItemDatabasePopulator.populateRelatedEntitiesInDatabase(serviceItemEntity, true, true, false);
				updatedServiceItemEntity = serviceItemFactory.getObject(false, false);
				serviceItemDatabasePopulator.populateRelatedEntitiesInDatabase(updatedServiceItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			serviceItemEntity = serviceItemService.create(serviceItemEntity);

			updatedServiceItemEntity.setId(serviceItemEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedServiceItemEntity.setCreated(serviceItemEntity.getCreated());

			updatedServiceItemEntity = serviceItemService.update(updatedServiceItemEntity);

			fetchedServiceItemEntity = serviceItemService.findById(serviceItemEntity.getId());

			Assertions.assertTrue(fetchedServiceItemEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateServiceItemEntity_ThenEntityIsCreated
			fetchedServiceItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedServiceItemEntity, fetchedServiceItemEntity.get());
		});
	}

	@Test
	public void whenDeleteServiceItemEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			ServiceItemEntity serviceItemEntity;
			Optional<ServiceItemEntity> fetchedServiceItemEntity;

			try {
				serviceItemEntity = serviceItemFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				serviceItemDatabasePopulator.populateRelatedEntitiesInDatabase(serviceItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			serviceItemEntity = serviceItemService.create(serviceItemEntity);

			serviceItemService.deleteById(serviceItemEntity.getId());
			fetchedServiceItemEntity = serviceItemService.findById(serviceItemEntity.getId());

			Assertions.assertTrue(fetchedServiceItemEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
