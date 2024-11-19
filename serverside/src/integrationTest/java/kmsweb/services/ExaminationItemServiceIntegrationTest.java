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
import kmsweb.entities.ExaminationItemEntity;
import kmsweb.repositories.ExaminationItemRepository;
import kmsweb.utils.ExaminationItemFactory;
import kmsweb.utils.DatabasePopulators.ExaminationItemDatabasePopulator;
import kmsweb.entities.DiagnosticExaminationResultsEntity;
import kmsweb.repositories.DiagnosticExaminationResultsRepository;
import kmsweb.utils.DiagnosticExaminationResultsFactory;
import kmsweb.utils.DatabasePopulators.DiagnosticExaminationResultsDatabasePopulator;
import kmsweb.entities.ExaminationGroupEntity;
import kmsweb.repositories.ExaminationGroupRepository;
import kmsweb.utils.ExaminationGroupFactory;
import kmsweb.utils.DatabasePopulators.ExaminationGroupDatabasePopulator;
import kmsweb.entities.ExaminationItemDetailEntity;
import kmsweb.repositories.ExaminationItemDetailRepository;
import kmsweb.utils.ExaminationItemDetailFactory;
import kmsweb.utils.DatabasePopulators.ExaminationItemDetailDatabasePopulator;
import kmsweb.entities.McuPackageItemEntity;
import kmsweb.repositories.McuPackageItemRepository;
import kmsweb.utils.McuPackageItemFactory;
import kmsweb.utils.DatabasePopulators.McuPackageItemDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.ServiceItemEntity;
import kmsweb.repositories.ServiceItemRepository;
import kmsweb.utils.ServiceItemFactory;
import kmsweb.utils.DatabasePopulators.ServiceItemDatabasePopulator;
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
public class ExaminationItemServiceIntegrationTest {

	@Autowired
	private ExaminationItemRepository examinationItemRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private ExaminationItemService examinationItemService;

	private final ExaminationItemFactory examinationItemFactory = new ExaminationItemFactory();

	@Autowired
	private ExaminationItemDatabasePopulator examinationItemDatabasePopulator;

	@Autowired
	private DiagnosticExaminationResultsRepository diagnosticExaminationResultsRepository;

	@Autowired
	private DiagnosticExaminationResultsDatabasePopulator diagnosticExaminationResultsDatabasePopulator;

	private final DiagnosticExaminationResultsFactory diagnosticExaminationResultsFactory = new DiagnosticExaminationResultsFactory();

	@Autowired
	private ExaminationGroupRepository examinationGroupRepository;

	@Autowired
	private ExaminationGroupDatabasePopulator examinationGroupDatabasePopulator;

	private final ExaminationGroupFactory examinationGroupFactory = new ExaminationGroupFactory();

	@Autowired
	private ExaminationItemDetailRepository examinationItemDetailRepository;

	@Autowired
	private ExaminationItemDetailDatabasePopulator examinationItemDetailDatabasePopulator;

	private final ExaminationItemDetailFactory examinationItemDetailFactory = new ExaminationItemDetailFactory();

	@Autowired
	private McuPackageItemRepository mcuPackageItemRepository;

	@Autowired
	private McuPackageItemDatabasePopulator mcuPackageItemDatabasePopulator;

	private final McuPackageItemFactory mcuPackageItemFactory = new McuPackageItemFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private ServiceItemRepository serviceItemRepository;

	@Autowired
	private ServiceItemDatabasePopulator serviceItemDatabasePopulator;

	private final ServiceItemFactory serviceItemFactory = new ServiceItemFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		examinationItemService = new ExaminationItemService(
			diagnosticExaminationResultsRepository,
			examinationGroupRepository,
			examinationItemDetailRepository,
			mcuPackageItemRepository,
			registrationRepository,
			serviceItemRepository,
			validator,
			auditRepository,
			examinationItemRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewExaminationItemEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		ExaminationItemEntity examinationItemEntity = examinationItemFactory.getObject(false, false);

		ExaminationItemEntity updatedEntity = examinationItemService.updateOldData(examinationItemEntity);
		Assertions.assertEquals(examinationItemEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingExaminationItemEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemEntity examinationItemEntity;
			ExaminationItemEntity entityWithUpdatedValues;

			try {
				examinationItemEntity = examinationItemFactory.getObject(false, false);
				examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = examinationItemFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationItemEntity = examinationItemService.create(examinationItemEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(examinationItemEntity.getId());

			ExaminationItemEntity updatedEntity = examinationItemService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithExaminationItemEntityWithNonExistentId_ShouldThrowException() throws Exception {
		ExaminationItemEntity examinationItemEntity = examinationItemFactory.getObject(false, false);
		examinationItemEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			examinationItemService.updateOldData(examinationItemEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingExaminationItemEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemEntity examinationItemEntity;
			ExaminationItemEntity updatedExaminationItemEntity;

			ExaminationGroupEntity examinationGroupEntity;

			ServiceItemEntity serviceItemEntity;

			Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResultsEntities;

			Set<ExaminationItemDetailEntity> examinationItemDetailsEntities;

			Set<McuPackageItemEntity> examinationItemOfMCUItemEntities;

			Set<RegistrationEntity> registrationsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				examinationItemEntity = examinationItemFactory.getObject(true, false);
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
			examinationGroupEntity = examinationItemEntity.getExaminationGroup();
			try {
				examinationGroupDatabasePopulator.populateRelatedEntitiesInDatabase(examinationGroupEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			examinationGroupEntity = examinationGroupRepository.save(examinationGroupEntity);
			examinationItemEntity.setExaminationGroupId(examinationGroupEntity.getId());

			serviceItemEntity = examinationItemEntity.getServiceItem();
			try {
				serviceItemDatabasePopulator.populateRelatedEntitiesInDatabase(serviceItemEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			serviceItemEntity = serviceItemRepository.save(serviceItemEntity);
			examinationItemEntity.setServiceItemId(serviceItemEntity.getId());

			diagnosticExaminationResultsEntities = examinationItemEntity.getDiagnosticExaminationResults();
			Set<UUID> diagnosticExaminationResultsEntityIds = new HashSet<>();
			for (DiagnosticExaminationResultsEntity entity : diagnosticExaminationResultsEntities) {
				try {
					diagnosticExaminationResultsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				diagnosticExaminationResultsEntityIds.add(diagnosticExaminationResultsRepository.save(entity).getId());
			}
			examinationItemEntity.setDiagnosticExaminationResultsIds(diagnosticExaminationResultsEntityIds);

			examinationItemDetailsEntities = examinationItemEntity.getExaminationItemDetails();
			Set<UUID> examinationItemDetailsEntityIds = new HashSet<>();
			for (ExaminationItemDetailEntity entity : examinationItemDetailsEntities) {
				try {
					examinationItemDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				examinationItemDetailsEntityIds.add(examinationItemDetailRepository.save(entity).getId());
			}
			examinationItemEntity.setExaminationItemDetailsIds(examinationItemDetailsEntityIds);

			examinationItemOfMCUItemEntities = examinationItemEntity.getExaminationItemOfMCUItem();
			Set<UUID> examinationItemOfMCUItemEntityIds = new HashSet<>();
			for (McuPackageItemEntity entity : examinationItemOfMCUItemEntities) {
				try {
					mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				examinationItemOfMCUItemEntityIds.add(mcuPackageItemRepository.save(entity).getId());
			}
			examinationItemEntity.setExaminationItemOfMCUItemIds(examinationItemOfMCUItemEntityIds);

			registrationsEntities = examinationItemEntity.getRegistrations();
			Set<UUID> registrationsEntityIds = new HashSet<>();
			for (RegistrationEntity entity : registrationsEntities) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				registrationsEntityIds.add(registrationRepository.save(entity).getId());
			}
			examinationItemEntity.setRegistrationsIds(registrationsEntityIds);


			examinationItemEntity = examinationItemService.create(examinationItemEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(examinationItemEntity.getExaminationGroup());
			examinationItemEntity.setExaminationGroupId(null);
			examinationItemEntity.unsetExaminationGroup();

			Assertions.assertNotNull(examinationItemEntity.getServiceItem());
			examinationItemEntity.setServiceItemId(null);
			examinationItemEntity.unsetServiceItem();

			Assertions.assertTrue(examinationItemEntity.getDiagnosticExaminationResults().size() > 0);
			examinationItemEntity.setDiagnosticExaminationResultsIds(new HashSet<UUID>());
			examinationItemEntity.unsetDiagnosticExaminationResults();

			Assertions.assertTrue(examinationItemEntity.getExaminationItemDetails().size() > 0);
			examinationItemEntity.setExaminationItemDetailsIds(new HashSet<UUID>());
			examinationItemEntity.unsetExaminationItemDetails();

			Assertions.assertTrue(examinationItemEntity.getExaminationItemOfMCUItem().size() > 0);
			examinationItemEntity.setExaminationItemOfMCUItemIds(new HashSet<UUID>());
			examinationItemEntity.unsetExaminationItemOfMCUItem();

			Assertions.assertTrue(examinationItemEntity.getRegistrations().size() > 0);
			examinationItemEntity.setRegistrationsIds(new HashSet<UUID>());
			examinationItemEntity.unsetRegistrations();


			updatedExaminationItemEntity = examinationItemService.updateOldData(examinationItemEntity);

			Assertions.assertNull(updatedExaminationItemEntity.getExaminationGroup());

			Assertions.assertNull(updatedExaminationItemEntity.getServiceItem());

			Assertions.assertEquals(0, updatedExaminationItemEntity.getDiagnosticExaminationResults().size());

			Assertions.assertEquals(0, updatedExaminationItemEntity.getExaminationItemDetails().size());

			Assertions.assertEquals(0, updatedExaminationItemEntity.getExaminationItemOfMCUItem().size());

			Assertions.assertEquals(0, updatedExaminationItemEntity.getRegistrations().size());

		});
	}

	@Test
	public void updateOldDataWithExaminationItemEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemEntity examinationItemEntity;
			ExaminationItemEntity updatedExaminationItemEntity;

			ExaminationGroupEntity examinationGroupEntity;

			ServiceItemEntity serviceItemEntity;

			Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResultsEntities;
			Set<UUID> diagnosticExaminationResultsEntityIds;

			Set<ExaminationItemDetailEntity> examinationItemDetailsEntities;
			Set<UUID> examinationItemDetailsEntityIds;

			Set<McuPackageItemEntity> examinationItemOfMCUItemEntities;
			Set<UUID> examinationItemOfMCUItemEntityIds;

			Set<RegistrationEntity> registrationsEntities;
			Set<UUID> registrationsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				examinationItemEntity = examinationItemFactory.getObject(true, false);
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
				examinationGroupDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemEntity.getExaminationGroup(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Examination Group relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			examinationGroupEntity = examinationGroupRepository.findById(examinationGroupRepository.save(examinationItemEntity.getExaminationGroup()).getId()).get();
			examinationItemEntity.unsetExaminationGroup();
			examinationItemEntity.setExaminationGroupId(examinationGroupEntity.getId());

			try {
				serviceItemDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemEntity.getServiceItem(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Service Item relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			serviceItemEntity = serviceItemRepository.findById(serviceItemRepository.save(examinationItemEntity.getServiceItem()).getId()).get();
			examinationItemEntity.unsetServiceItem();
			examinationItemEntity.setServiceItemId(serviceItemEntity.getId());

			diagnosticExaminationResultsEntities = new HashSet<>();
			diagnosticExaminationResultsEntityIds = new HashSet<>();
			for (DiagnosticExaminationResultsEntity entity : examinationItemEntity.getDiagnosticExaminationResults()) {
				try {
					diagnosticExaminationResultsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Diagnostic Examination Results relation for this test: " + e.getCause());
					return;
				}
				UUID id = diagnosticExaminationResultsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				diagnosticExaminationResultsEntities.add(diagnosticExaminationResultsRepository.findById(id).get());
				diagnosticExaminationResultsEntityIds.add(id);
			}
			examinationItemEntity.unsetDiagnosticExaminationResults();
			examinationItemEntity.setDiagnosticExaminationResultsIds(diagnosticExaminationResultsEntityIds);

			examinationItemDetailsEntities = new HashSet<>();
			examinationItemDetailsEntityIds = new HashSet<>();
			for (ExaminationItemDetailEntity entity : examinationItemEntity.getExaminationItemDetails()) {
				try {
					examinationItemDetailDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Examination Item Details relation for this test: " + e.getCause());
					return;
				}
				UUID id = examinationItemDetailRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				examinationItemDetailsEntities.add(examinationItemDetailRepository.findById(id).get());
				examinationItemDetailsEntityIds.add(id);
			}
			examinationItemEntity.unsetExaminationItemDetails();
			examinationItemEntity.setExaminationItemDetailsIds(examinationItemDetailsEntityIds);

			examinationItemOfMCUItemEntities = new HashSet<>();
			examinationItemOfMCUItemEntityIds = new HashSet<>();
			for (McuPackageItemEntity entity : examinationItemEntity.getExaminationItemOfMCUItem()) {
				try {
					mcuPackageItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Examination Item of MCU Item relation for this test: " + e.getCause());
					return;
				}
				UUID id = mcuPackageItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				examinationItemOfMCUItemEntities.add(mcuPackageItemRepository.findById(id).get());
				examinationItemOfMCUItemEntityIds.add(id);
			}
			examinationItemEntity.unsetExaminationItemOfMCUItem();
			examinationItemEntity.setExaminationItemOfMCUItemIds(examinationItemOfMCUItemEntityIds);

			registrationsEntities = new HashSet<>();
			registrationsEntityIds = new HashSet<>();
			for (RegistrationEntity entity : examinationItemEntity.getRegistrations()) {
				try {
					registrationDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Registrations relation for this test: " + e.getCause());
					return;
				}
				UUID id = registrationRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				registrationsEntities.add(registrationRepository.findById(id).get());
				registrationsEntityIds.add(id);
			}
			examinationItemEntity.unsetRegistrations();
			examinationItemEntity.setRegistrationsIds(registrationsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedExaminationItemEntity = examinationItemService.updateOldData(examinationItemEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			examinationGroupEntity.unsetExaminationItems(false);
			updatedExaminationItemEntity.getExaminationGroup().unsetExaminationItems(false);
			Assertions.assertEquals(examinationGroupEntity, updatedExaminationItemEntity.getExaminationGroup());

			serviceItemEntity.unsetExaminationItems(false);
			updatedExaminationItemEntity.getServiceItem().unsetExaminationItems(false);
			Assertions.assertEquals(serviceItemEntity, updatedExaminationItemEntity.getServiceItem());

			Assertions.assertEquals(diagnosticExaminationResultsEntities.size(), updatedExaminationItemEntity.getDiagnosticExaminationResults().size());

			Assertions.assertEquals(examinationItemDetailsEntities.size(), updatedExaminationItemEntity.getExaminationItemDetails().size());

			Assertions.assertEquals(examinationItemOfMCUItemEntities.size(), updatedExaminationItemEntity.getExaminationItemOfMCUItem().size());

			Assertions.assertEquals(registrationsEntities.size(), updatedExaminationItemEntity.getRegistrations().size());

		});
	}

	@Test
	public void whenCreateExaminationItemEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemEntity examinationItemEntity;
			Optional<ExaminationItemEntity> fetchedExaminationItemEntity;

			try {
				examinationItemEntity = examinationItemFactory.getObject(false, false);
				examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationItemEntity = examinationItemService.create(examinationItemEntity);

			fetchedExaminationItemEntity = examinationItemService.findById(examinationItemEntity.getId());

			Assertions.assertTrue(fetchedExaminationItemEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedExaminationItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(examinationItemEntity, fetchedExaminationItemEntity.get());
		});
	}

	@Test
	public void whenUpdateExaminationItemEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemEntity examinationItemEntity;
			ExaminationItemEntity updatedExaminationItemEntity;
			Optional<ExaminationItemEntity> fetchedExaminationItemEntity;

			try {
				examinationItemEntity = examinationItemFactory.getObject(false, false);
				examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemEntity, true, true, false);
				updatedExaminationItemEntity = examinationItemFactory.getObject(false, false);
				examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(updatedExaminationItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationItemEntity = examinationItemService.create(examinationItemEntity);

			updatedExaminationItemEntity.setId(examinationItemEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedExaminationItemEntity.setCreated(examinationItemEntity.getCreated());

			updatedExaminationItemEntity = examinationItemService.update(updatedExaminationItemEntity);

			fetchedExaminationItemEntity = examinationItemService.findById(examinationItemEntity.getId());

			Assertions.assertTrue(fetchedExaminationItemEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateExaminationItemEntity_ThenEntityIsCreated
			fetchedExaminationItemEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedExaminationItemEntity, fetchedExaminationItemEntity.get());
		});
	}

	@Test
	public void whenDeleteExaminationItemEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			ExaminationItemEntity examinationItemEntity;
			Optional<ExaminationItemEntity> fetchedExaminationItemEntity;

			try {
				examinationItemEntity = examinationItemFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				examinationItemDatabasePopulator.populateRelatedEntitiesInDatabase(examinationItemEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			examinationItemEntity = examinationItemService.create(examinationItemEntity);

			examinationItemService.deleteById(examinationItemEntity.getId());
			fetchedExaminationItemEntity = examinationItemService.findById(examinationItemEntity.getId());

			Assertions.assertTrue(fetchedExaminationItemEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
