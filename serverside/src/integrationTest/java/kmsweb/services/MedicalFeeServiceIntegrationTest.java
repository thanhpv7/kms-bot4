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
import kmsweb.entities.MedicalFeeEntity;
import kmsweb.repositories.MedicalFeeRepository;
import kmsweb.utils.MedicalFeeFactory;
import kmsweb.utils.DatabasePopulators.MedicalFeeDatabasePopulator;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.utils.InvoiceItemFactory;
import kmsweb.utils.DatabasePopulators.InvoiceItemDatabasePopulator;
import kmsweb.entities.MedicalFeeItemComponentEntity;
import kmsweb.repositories.MedicalFeeItemComponentRepository;
import kmsweb.utils.MedicalFeeItemComponentFactory;
import kmsweb.utils.DatabasePopulators.MedicalFeeItemComponentDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.WarehouseEntity;
import kmsweb.repositories.WarehouseRepository;
import kmsweb.utils.WarehouseFactory;
import kmsweb.utils.DatabasePopulators.WarehouseDatabasePopulator;
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
public class MedicalFeeServiceIntegrationTest {

	@Autowired
	private MedicalFeeRepository medicalFeeRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MedicalFeeService medicalFeeService;

	private final MedicalFeeFactory medicalFeeFactory = new MedicalFeeFactory();

	@Autowired
	private MedicalFeeDatabasePopulator medicalFeeDatabasePopulator;

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Autowired
	private InvoiceItemDatabasePopulator invoiceItemDatabasePopulator;

	private final InvoiceItemFactory invoiceItemFactory = new InvoiceItemFactory();

	@Autowired
	private MedicalFeeItemComponentRepository medicalFeeItemComponentRepository;

	@Autowired
	private MedicalFeeItemComponentDatabasePopulator medicalFeeItemComponentDatabasePopulator;

	private final MedicalFeeItemComponentFactory medicalFeeItemComponentFactory = new MedicalFeeItemComponentFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private WarehouseDatabasePopulator warehouseDatabasePopulator;

	private final WarehouseFactory warehouseFactory = new WarehouseFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		medicalFeeService = new MedicalFeeService(
			invoiceItemRepository,
			medicalFeeItemComponentRepository,
			registrationRepository,
			warehouseRepository,
			validator,
			auditRepository,
			medicalFeeRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMedicalFeeEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MedicalFeeEntity medicalFeeEntity = medicalFeeFactory.getObject(false, false);

		MedicalFeeEntity updatedEntity = medicalFeeService.updateOldData(medicalFeeEntity);
		Assertions.assertEquals(medicalFeeEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingMedicalFeeEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalFeeEntity medicalFeeEntity;
			MedicalFeeEntity entityWithUpdatedValues;

			try {
				medicalFeeEntity = medicalFeeFactory.getObject(false, false);
				medicalFeeDatabasePopulator.populateRelatedEntitiesInDatabase(medicalFeeEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = medicalFeeFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalFeeEntity = medicalFeeService.create(medicalFeeEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(medicalFeeEntity.getId());

			MedicalFeeEntity updatedEntity = medicalFeeService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMedicalFeeEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MedicalFeeEntity medicalFeeEntity = medicalFeeFactory.getObject(false, false);
		medicalFeeEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			medicalFeeService.updateOldData(medicalFeeEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMedicalFeeEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalFeeEntity medicalFeeEntity;
			MedicalFeeEntity updatedMedicalFeeEntity;

			RegistrationEntity registrationEntity;

			WarehouseEntity warehouseEntity;

			Set<InvoiceItemEntity> invoiceItemsEntities;

			Set<MedicalFeeItemComponentEntity> medicalFeeItemComponentsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalFeeEntity = medicalFeeFactory.getObject(true, false);
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
			registrationEntity = medicalFeeEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			medicalFeeEntity.setRegistrationId(registrationEntity.getId());

			warehouseEntity = medicalFeeEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			medicalFeeEntity.setWarehouseId(warehouseEntity.getId());

			invoiceItemsEntities = medicalFeeEntity.getInvoiceItems();
			Set<UUID> invoiceItemsEntityIds = new HashSet<>();
			for (InvoiceItemEntity entity : invoiceItemsEntities) {
				try {
					invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				invoiceItemsEntityIds.add(invoiceItemRepository.save(entity).getId());
			}
			medicalFeeEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			medicalFeeItemComponentsEntities = medicalFeeEntity.getMedicalFeeItemComponents();
			Set<UUID> medicalFeeItemComponentsEntityIds = new HashSet<>();
			for (MedicalFeeItemComponentEntity entity : medicalFeeItemComponentsEntities) {
				try {
					medicalFeeItemComponentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicalFeeItemComponentsEntityIds.add(medicalFeeItemComponentRepository.save(entity).getId());
			}
			medicalFeeEntity.setMedicalFeeItemComponentsIds(medicalFeeItemComponentsEntityIds);


			medicalFeeEntity = medicalFeeService.create(medicalFeeEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(medicalFeeEntity.getRegistration());
			medicalFeeEntity.setRegistrationId(null);
			medicalFeeEntity.unsetRegistration();

			Assertions.assertNotNull(medicalFeeEntity.getWarehouse());
			medicalFeeEntity.setWarehouseId(null);
			medicalFeeEntity.unsetWarehouse();

			Assertions.assertTrue(medicalFeeEntity.getInvoiceItems().size() > 0);
			medicalFeeEntity.setInvoiceItemsIds(new HashSet<UUID>());
			medicalFeeEntity.unsetInvoiceItems();

			Assertions.assertTrue(medicalFeeEntity.getMedicalFeeItemComponents().size() > 0);
			medicalFeeEntity.setMedicalFeeItemComponentsIds(new HashSet<UUID>());
			medicalFeeEntity.unsetMedicalFeeItemComponents();


			updatedMedicalFeeEntity = medicalFeeService.updateOldData(medicalFeeEntity);

			Assertions.assertNull(updatedMedicalFeeEntity.getRegistration());

			Assertions.assertNull(updatedMedicalFeeEntity.getWarehouse());

			Assertions.assertEquals(0, updatedMedicalFeeEntity.getInvoiceItems().size());

			Assertions.assertEquals(0, updatedMedicalFeeEntity.getMedicalFeeItemComponents().size());

		});
	}

	@Test
	public void updateOldDataWithMedicalFeeEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalFeeEntity medicalFeeEntity;
			MedicalFeeEntity updatedMedicalFeeEntity;

			RegistrationEntity registrationEntity;

			WarehouseEntity warehouseEntity;

			Set<InvoiceItemEntity> invoiceItemsEntities;
			Set<UUID> invoiceItemsEntityIds;

			Set<MedicalFeeItemComponentEntity> medicalFeeItemComponentsEntities;
			Set<UUID> medicalFeeItemComponentsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalFeeEntity = medicalFeeFactory.getObject(true, false);
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
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalFeeEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(medicalFeeEntity.getRegistration()).getId()).get();
			medicalFeeEntity.unsetRegistration();
			medicalFeeEntity.setRegistrationId(registrationEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(medicalFeeEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(medicalFeeEntity.getWarehouse()).getId()).get();
			medicalFeeEntity.unsetWarehouse();
			medicalFeeEntity.setWarehouseId(warehouseEntity.getId());

			invoiceItemsEntities = new HashSet<>();
			invoiceItemsEntityIds = new HashSet<>();
			for (InvoiceItemEntity entity : medicalFeeEntity.getInvoiceItems()) {
				try {
					invoiceItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Invoice Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = invoiceItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				invoiceItemsEntities.add(invoiceItemRepository.findById(id).get());
				invoiceItemsEntityIds.add(id);
			}
			medicalFeeEntity.unsetInvoiceItems();
			medicalFeeEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			medicalFeeItemComponentsEntities = new HashSet<>();
			medicalFeeItemComponentsEntityIds = new HashSet<>();
			for (MedicalFeeItemComponentEntity entity : medicalFeeEntity.getMedicalFeeItemComponents()) {
				try {
					medicalFeeItemComponentDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medical Fee Item Components relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicalFeeItemComponentRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicalFeeItemComponentsEntities.add(medicalFeeItemComponentRepository.findById(id).get());
				medicalFeeItemComponentsEntityIds.add(id);
			}
			medicalFeeEntity.unsetMedicalFeeItemComponents();
			medicalFeeEntity.setMedicalFeeItemComponentsIds(medicalFeeItemComponentsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMedicalFeeEntity = medicalFeeService.updateOldData(medicalFeeEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			registrationEntity.unsetMedicalFees(false);
			updatedMedicalFeeEntity.getRegistration().unsetMedicalFees(false);
			Assertions.assertEquals(registrationEntity, updatedMedicalFeeEntity.getRegistration());

			warehouseEntity.unsetMedicalFees(false);
			updatedMedicalFeeEntity.getWarehouse().unsetMedicalFees(false);
			Assertions.assertEquals(warehouseEntity, updatedMedicalFeeEntity.getWarehouse());

			Assertions.assertEquals(invoiceItemsEntities.size(), updatedMedicalFeeEntity.getInvoiceItems().size());

			Assertions.assertEquals(medicalFeeItemComponentsEntities.size(), updatedMedicalFeeEntity.getMedicalFeeItemComponents().size());

		});
	}

	@Test
	public void whenCreateMedicalFeeEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalFeeEntity medicalFeeEntity;
			Optional<MedicalFeeEntity> fetchedMedicalFeeEntity;

			try {
				medicalFeeEntity = medicalFeeFactory.getObject(false, false);
				medicalFeeDatabasePopulator.populateRelatedEntitiesInDatabase(medicalFeeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalFeeEntity = medicalFeeService.create(medicalFeeEntity);

			fetchedMedicalFeeEntity = medicalFeeService.findById(medicalFeeEntity.getId());

			Assertions.assertTrue(fetchedMedicalFeeEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMedicalFeeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(medicalFeeEntity, fetchedMedicalFeeEntity.get());
		});
	}

	@Test
	public void whenUpdateMedicalFeeEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalFeeEntity medicalFeeEntity;
			MedicalFeeEntity updatedMedicalFeeEntity;
			Optional<MedicalFeeEntity> fetchedMedicalFeeEntity;

			try {
				medicalFeeEntity = medicalFeeFactory.getObject(false, false);
				medicalFeeDatabasePopulator.populateRelatedEntitiesInDatabase(medicalFeeEntity, true, true, false);
				updatedMedicalFeeEntity = medicalFeeFactory.getObject(false, false);
				medicalFeeDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMedicalFeeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalFeeEntity = medicalFeeService.create(medicalFeeEntity);

			updatedMedicalFeeEntity.setId(medicalFeeEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMedicalFeeEntity.setCreated(medicalFeeEntity.getCreated());

			updatedMedicalFeeEntity = medicalFeeService.update(updatedMedicalFeeEntity);

			fetchedMedicalFeeEntity = medicalFeeService.findById(medicalFeeEntity.getId());

			Assertions.assertTrue(fetchedMedicalFeeEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMedicalFeeEntity_ThenEntityIsCreated
			fetchedMedicalFeeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMedicalFeeEntity, fetchedMedicalFeeEntity.get());
		});
	}

	@Test
	public void whenDeleteMedicalFeeEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalFeeEntity medicalFeeEntity;
			Optional<MedicalFeeEntity> fetchedMedicalFeeEntity;

			try {
				medicalFeeEntity = medicalFeeFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				medicalFeeDatabasePopulator.populateRelatedEntitiesInDatabase(medicalFeeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalFeeEntity = medicalFeeService.create(medicalFeeEntity);

			medicalFeeService.deleteById(medicalFeeEntity.getId());
			fetchedMedicalFeeEntity = medicalFeeService.findById(medicalFeeEntity.getId());

			Assertions.assertTrue(fetchedMedicalFeeEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
