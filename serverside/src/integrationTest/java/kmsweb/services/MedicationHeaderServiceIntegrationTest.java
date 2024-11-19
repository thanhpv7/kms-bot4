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
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.repositories.MedicationHeaderRepository;
import kmsweb.utils.MedicationHeaderFactory;
import kmsweb.utils.DatabasePopulators.MedicationHeaderDatabasePopulator;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.utils.InvoiceFactory;
import kmsweb.utils.DatabasePopulators.InvoiceDatabasePopulator;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.utils.InvoiceItemFactory;
import kmsweb.utils.DatabasePopulators.InvoiceItemDatabasePopulator;
import kmsweb.entities.MedicationCompoundEntity;
import kmsweb.repositories.MedicationCompoundRepository;
import kmsweb.utils.MedicationCompoundFactory;
import kmsweb.utils.DatabasePopulators.MedicationCompoundDatabasePopulator;
import kmsweb.entities.MedicationItemEntity;
import kmsweb.repositories.MedicationItemRepository;
import kmsweb.utils.MedicationItemFactory;
import kmsweb.utils.DatabasePopulators.MedicationItemDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
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
public class MedicationHeaderServiceIntegrationTest {

	@Autowired
	private MedicationHeaderRepository medicationHeaderRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MedicationHeaderService medicationHeaderService;

	private final MedicationHeaderFactory medicationHeaderFactory = new MedicationHeaderFactory();

	@Autowired
	private MedicationHeaderDatabasePopulator medicationHeaderDatabasePopulator;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDatabasePopulator invoiceDatabasePopulator;

	private final InvoiceFactory invoiceFactory = new InvoiceFactory();

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Autowired
	private InvoiceItemDatabasePopulator invoiceItemDatabasePopulator;

	private final InvoiceItemFactory invoiceItemFactory = new InvoiceItemFactory();

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
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	private final StaffFactory staffFactory = new StaffFactory();

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
		medicationHeaderService = new MedicationHeaderService(
			invoiceRepository,
			invoiceItemRepository,
			medicationCompoundRepository,
			medicationItemRepository,
			registrationRepository,
			staffRepository,
			warehouseRepository,
			validator,
			auditRepository,
			medicationHeaderRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMedicationHeaderEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MedicationHeaderEntity medicationHeaderEntity = medicationHeaderFactory.getObject(false, false);

		MedicationHeaderEntity updatedEntity = medicationHeaderService.updateOldData(medicationHeaderEntity);
		Assertions.assertEquals(medicationHeaderEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewMedicationHeaderEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		MedicationHeaderEntity medicationHeaderEntity = medicationHeaderFactory.getObject(false, false);

		medicationHeaderEntity.setIsUrgent(null);
		Assertions.assertNull(medicationHeaderEntity.getIsUrgent());

		medicationHeaderEntity.setIsCompound(null);
		Assertions.assertNull(medicationHeaderEntity.getIsCompound());

		medicationHeaderEntity.setIsInvoiced(null);
		Assertions.assertNull(medicationHeaderEntity.getIsInvoiced());

		medicationHeaderEntity.setExternalWarehouse(null);
		Assertions.assertNull(medicationHeaderEntity.getExternalWarehouse());

		medicationHeaderEntity.setRestricted(null);
		Assertions.assertNull(medicationHeaderEntity.getRestricted());


		MedicationHeaderEntity updatedEntity = medicationHeaderService.updateOldData(medicationHeaderEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getIsUrgent());
		Assertions.assertFalse(updatedEntity.getIsUrgent());

		Assertions.assertNotNull(updatedEntity.getIsCompound());
		Assertions.assertFalse(updatedEntity.getIsCompound());

		Assertions.assertNotNull(updatedEntity.getIsInvoiced());
		Assertions.assertFalse(updatedEntity.getIsInvoiced());

		Assertions.assertNotNull(updatedEntity.getExternalWarehouse());
		Assertions.assertFalse(updatedEntity.getExternalWarehouse());

		Assertions.assertNotNull(updatedEntity.getRestricted());
		Assertions.assertFalse(updatedEntity.getRestricted());

	}

	@Test
	public void updateOldDataWithExistingMedicationHeaderEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationHeaderEntity medicationHeaderEntity;
			MedicationHeaderEntity entityWithUpdatedValues;

			try {
				medicationHeaderEntity = medicationHeaderFactory.getObject(false, false);
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = medicationHeaderFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationHeaderEntity = medicationHeaderService.create(medicationHeaderEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(medicationHeaderEntity.getId());

			MedicationHeaderEntity updatedEntity = medicationHeaderService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMedicationHeaderEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MedicationHeaderEntity medicationHeaderEntity = medicationHeaderFactory.getObject(false, false);
		medicationHeaderEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			medicationHeaderService.updateOldData(medicationHeaderEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMedicationHeaderEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationHeaderEntity medicationHeaderEntity;
			MedicationHeaderEntity updatedMedicationHeaderEntity;

			InvoiceEntity invoiceEntity;

			RegistrationEntity registrationEntity;

			StaffEntity requestedByEntity;

			WarehouseEntity warehouseEntity;

			Set<InvoiceItemEntity> invoiceItemsEntities;

			Set<MedicationCompoundEntity> medicationCompoundsEntities;

			Set<MedicationItemEntity> medicationItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicationHeaderEntity = medicationHeaderFactory.getObject(true, false);
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
			invoiceEntity = medicationHeaderEntity.getInvoice();
			try {
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			invoiceEntity = invoiceRepository.save(invoiceEntity);
			medicationHeaderEntity.setInvoiceId(invoiceEntity.getId());

			registrationEntity = medicationHeaderEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			medicationHeaderEntity.setRegistrationId(registrationEntity.getId());

			requestedByEntity = medicationHeaderEntity.getRequestedBy();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(requestedByEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			requestedByEntity = staffRepository.save(requestedByEntity);
			medicationHeaderEntity.setRequestedById(requestedByEntity.getId());

			warehouseEntity = medicationHeaderEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			medicationHeaderEntity.setWarehouseId(warehouseEntity.getId());

			invoiceItemsEntities = medicationHeaderEntity.getInvoiceItems();
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
			medicationHeaderEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			medicationCompoundsEntities = medicationHeaderEntity.getMedicationCompounds();
			Set<UUID> medicationCompoundsEntityIds = new HashSet<>();
			for (MedicationCompoundEntity entity : medicationCompoundsEntities) {
				try {
					medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				medicationCompoundsEntityIds.add(medicationCompoundRepository.save(entity).getId());
			}
			medicationHeaderEntity.setMedicationCompoundsIds(medicationCompoundsEntityIds);

			medicationItemsEntities = medicationHeaderEntity.getMedicationItems();
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
			medicationHeaderEntity.setMedicationItemsIds(medicationItemsEntityIds);


			medicationHeaderEntity = medicationHeaderService.create(medicationHeaderEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(medicationHeaderEntity.getInvoice());
			medicationHeaderEntity.setInvoiceId(null);
			medicationHeaderEntity.unsetInvoice();

			Assertions.assertNotNull(medicationHeaderEntity.getRegistration());
			medicationHeaderEntity.setRegistrationId(null);
			medicationHeaderEntity.unsetRegistration();

			Assertions.assertNotNull(medicationHeaderEntity.getRequestedBy());
			medicationHeaderEntity.setRequestedById(null);
			medicationHeaderEntity.unsetRequestedBy();

			Assertions.assertNotNull(medicationHeaderEntity.getWarehouse());
			medicationHeaderEntity.setWarehouseId(null);
			medicationHeaderEntity.unsetWarehouse();

			Assertions.assertTrue(medicationHeaderEntity.getInvoiceItems().size() > 0);
			medicationHeaderEntity.setInvoiceItemsIds(new HashSet<UUID>());
			medicationHeaderEntity.unsetInvoiceItems();

			Assertions.assertTrue(medicationHeaderEntity.getMedicationCompounds().size() > 0);
			medicationHeaderEntity.setMedicationCompoundsIds(new HashSet<UUID>());
			medicationHeaderEntity.unsetMedicationCompounds();

			Assertions.assertTrue(medicationHeaderEntity.getMedicationItems().size() > 0);
			medicationHeaderEntity.setMedicationItemsIds(new HashSet<UUID>());
			medicationHeaderEntity.unsetMedicationItems();


			updatedMedicationHeaderEntity = medicationHeaderService.updateOldData(medicationHeaderEntity);

			Assertions.assertNull(updatedMedicationHeaderEntity.getInvoice());

			Assertions.assertNull(updatedMedicationHeaderEntity.getRegistration());

			Assertions.assertNull(updatedMedicationHeaderEntity.getRequestedBy());

			Assertions.assertNull(updatedMedicationHeaderEntity.getWarehouse());

			Assertions.assertEquals(0, updatedMedicationHeaderEntity.getInvoiceItems().size());

			Assertions.assertEquals(0, updatedMedicationHeaderEntity.getMedicationCompounds().size());

			Assertions.assertEquals(0, updatedMedicationHeaderEntity.getMedicationItems().size());

		});
	}

	@Test
	public void updateOldDataWithMedicationHeaderEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationHeaderEntity medicationHeaderEntity;
			MedicationHeaderEntity updatedMedicationHeaderEntity;

			InvoiceEntity invoiceEntity;

			RegistrationEntity registrationEntity;

			StaffEntity requestedByEntity;

			WarehouseEntity warehouseEntity;

			Set<InvoiceItemEntity> invoiceItemsEntities;
			Set<UUID> invoiceItemsEntityIds;

			Set<MedicationCompoundEntity> medicationCompoundsEntities;
			Set<UUID> medicationCompoundsEntityIds;

			Set<MedicationItemEntity> medicationItemsEntities;
			Set<UUID> medicationItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicationHeaderEntity = medicationHeaderFactory.getObject(true, false);
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
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity.getInvoice(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Invoice relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			invoiceEntity = invoiceRepository.findById(invoiceRepository.save(medicationHeaderEntity.getInvoice()).getId()).get();
			medicationHeaderEntity.unsetInvoice();
			medicationHeaderEntity.setInvoiceId(invoiceEntity.getId());

			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(medicationHeaderEntity.getRegistration()).getId()).get();
			medicationHeaderEntity.unsetRegistration();
			medicationHeaderEntity.setRegistrationId(registrationEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity.getRequestedBy(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Requested By relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			requestedByEntity = staffRepository.findById(staffRepository.save(medicationHeaderEntity.getRequestedBy()).getId()).get();
			medicationHeaderEntity.unsetRequestedBy();
			medicationHeaderEntity.setRequestedById(requestedByEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(medicationHeaderEntity.getWarehouse()).getId()).get();
			medicationHeaderEntity.unsetWarehouse();
			medicationHeaderEntity.setWarehouseId(warehouseEntity.getId());

			invoiceItemsEntities = new HashSet<>();
			invoiceItemsEntityIds = new HashSet<>();
			for (InvoiceItemEntity entity : medicationHeaderEntity.getInvoiceItems()) {
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
			medicationHeaderEntity.unsetInvoiceItems();
			medicationHeaderEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			medicationCompoundsEntities = new HashSet<>();
			medicationCompoundsEntityIds = new HashSet<>();
			for (MedicationCompoundEntity entity : medicationHeaderEntity.getMedicationCompounds()) {
				try {
					medicationCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Medication Compounds relation for this test: " + e.getCause());
					return;
				}
				UUID id = medicationCompoundRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				medicationCompoundsEntities.add(medicationCompoundRepository.findById(id).get());
				medicationCompoundsEntityIds.add(id);
			}
			medicationHeaderEntity.unsetMedicationCompounds();
			medicationHeaderEntity.setMedicationCompoundsIds(medicationCompoundsEntityIds);

			medicationItemsEntities = new HashSet<>();
			medicationItemsEntityIds = new HashSet<>();
			for (MedicationItemEntity entity : medicationHeaderEntity.getMedicationItems()) {
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
			medicationHeaderEntity.unsetMedicationItems();
			medicationHeaderEntity.setMedicationItemsIds(medicationItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMedicationHeaderEntity = medicationHeaderService.updateOldData(medicationHeaderEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			invoiceEntity.unsetMedicationHeader(false);
			updatedMedicationHeaderEntity.getInvoice().unsetMedicationHeader(false);
			Assertions.assertEquals(invoiceEntity, updatedMedicationHeaderEntity.getInvoice());

			registrationEntity.unsetMedicationHeaders(false);
			updatedMedicationHeaderEntity.getRegistration().unsetMedicationHeaders(false);
			Assertions.assertEquals(registrationEntity, updatedMedicationHeaderEntity.getRegistration());

			requestedByEntity.unsetMedicationHeaders(false);
			updatedMedicationHeaderEntity.getRequestedBy().unsetMedicationHeaders(false);
			Assertions.assertEquals(requestedByEntity, updatedMedicationHeaderEntity.getRequestedBy());

			warehouseEntity.unsetMedicationHeaders(false);
			updatedMedicationHeaderEntity.getWarehouse().unsetMedicationHeaders(false);
			Assertions.assertEquals(warehouseEntity, updatedMedicationHeaderEntity.getWarehouse());

			Assertions.assertEquals(invoiceItemsEntities.size(), updatedMedicationHeaderEntity.getInvoiceItems().size());

			Assertions.assertEquals(medicationCompoundsEntities.size(), updatedMedicationHeaderEntity.getMedicationCompounds().size());

			Assertions.assertEquals(medicationItemsEntities.size(), updatedMedicationHeaderEntity.getMedicationItems().size());

		});
	}

	@Test
	public void whenCreateMedicationHeaderEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationHeaderEntity medicationHeaderEntity;
			Optional<MedicationHeaderEntity> fetchedMedicationHeaderEntity;

			try {
				medicationHeaderEntity = medicationHeaderFactory.getObject(false, false);
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationHeaderEntity = medicationHeaderService.create(medicationHeaderEntity);

			fetchedMedicationHeaderEntity = medicationHeaderService.findById(medicationHeaderEntity.getId());

			Assertions.assertTrue(fetchedMedicationHeaderEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMedicationHeaderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(medicationHeaderEntity, fetchedMedicationHeaderEntity.get());
		});
	}

	@Test
	public void whenUpdateMedicationHeaderEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationHeaderEntity medicationHeaderEntity;
			MedicationHeaderEntity updatedMedicationHeaderEntity;
			Optional<MedicationHeaderEntity> fetchedMedicationHeaderEntity;

			try {
				medicationHeaderEntity = medicationHeaderFactory.getObject(false, false);
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity, true, true, false);
				updatedMedicationHeaderEntity = medicationHeaderFactory.getObject(false, false);
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMedicationHeaderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationHeaderEntity = medicationHeaderService.create(medicationHeaderEntity);

			updatedMedicationHeaderEntity.setId(medicationHeaderEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMedicationHeaderEntity.setCreated(medicationHeaderEntity.getCreated());

			updatedMedicationHeaderEntity = medicationHeaderService.update(updatedMedicationHeaderEntity);

			fetchedMedicationHeaderEntity = medicationHeaderService.findById(medicationHeaderEntity.getId());

			Assertions.assertTrue(fetchedMedicationHeaderEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMedicationHeaderEntity_ThenEntityIsCreated
			fetchedMedicationHeaderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMedicationHeaderEntity, fetchedMedicationHeaderEntity.get());
		});
	}

	@Test
	public void whenDeleteMedicationHeaderEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MedicationHeaderEntity medicationHeaderEntity;
			Optional<MedicationHeaderEntity> fetchedMedicationHeaderEntity;

			try {
				medicationHeaderEntity = medicationHeaderFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				medicationHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(medicationHeaderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicationHeaderEntity = medicationHeaderService.create(medicationHeaderEntity);

			medicationHeaderService.deleteById(medicationHeaderEntity.getId());
			fetchedMedicationHeaderEntity = medicationHeaderService.findById(medicationHeaderEntity.getId());

			Assertions.assertTrue(fetchedMedicationHeaderEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
