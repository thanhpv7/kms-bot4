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
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.repositories.PrescriptionHeaderRepository;
import kmsweb.utils.PrescriptionHeaderFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionHeaderDatabasePopulator;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.utils.InvoiceFactory;
import kmsweb.utils.DatabasePopulators.InvoiceDatabasePopulator;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.utils.InvoiceItemFactory;
import kmsweb.utils.DatabasePopulators.InvoiceItemDatabasePopulator;
import kmsweb.entities.PrescriptionCompoundEntity;
import kmsweb.repositories.PrescriptionCompoundRepository;
import kmsweb.utils.PrescriptionCompoundFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionCompoundDatabasePopulator;
import kmsweb.entities.PrescriptionItemEntity;
import kmsweb.repositories.PrescriptionItemRepository;
import kmsweb.utils.PrescriptionItemFactory;
import kmsweb.utils.DatabasePopulators.PrescriptionItemDatabasePopulator;
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
public class PrescriptionHeaderServiceIntegrationTest {

	@Autowired
	private PrescriptionHeaderRepository prescriptionHeaderRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PrescriptionHeaderService prescriptionHeaderService;

	private final PrescriptionHeaderFactory prescriptionHeaderFactory = new PrescriptionHeaderFactory();

	@Autowired
	private PrescriptionHeaderDatabasePopulator prescriptionHeaderDatabasePopulator;

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
	private PrescriptionCompoundRepository prescriptionCompoundRepository;

	@Autowired
	private PrescriptionCompoundDatabasePopulator prescriptionCompoundDatabasePopulator;

	private final PrescriptionCompoundFactory prescriptionCompoundFactory = new PrescriptionCompoundFactory();

	@Autowired
	private PrescriptionItemRepository prescriptionItemRepository;

	@Autowired
	private PrescriptionItemDatabasePopulator prescriptionItemDatabasePopulator;

	private final PrescriptionItemFactory prescriptionItemFactory = new PrescriptionItemFactory();

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
		prescriptionHeaderService = new PrescriptionHeaderService(
			invoiceRepository,
			invoiceItemRepository,
			prescriptionCompoundRepository,
			prescriptionItemRepository,
			registrationRepository,
			staffRepository,
			warehouseRepository,
			validator,
			auditRepository,
			prescriptionHeaderRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPrescriptionHeaderEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PrescriptionHeaderEntity prescriptionHeaderEntity = prescriptionHeaderFactory.getObject(false, false);

		PrescriptionHeaderEntity updatedEntity = prescriptionHeaderService.updateOldData(prescriptionHeaderEntity);
		Assertions.assertEquals(prescriptionHeaderEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewPrescriptionHeaderEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		PrescriptionHeaderEntity prescriptionHeaderEntity = prescriptionHeaderFactory.getObject(false, false);

		prescriptionHeaderEntity.setIsCompound(null);
		Assertions.assertNull(prescriptionHeaderEntity.getIsCompound());

		prescriptionHeaderEntity.setIsIteration(null);
		Assertions.assertNull(prescriptionHeaderEntity.getIsIteration());

		prescriptionHeaderEntity.setIsUrgent(null);
		Assertions.assertNull(prescriptionHeaderEntity.getIsUrgent());

		prescriptionHeaderEntity.setRestricted(null);
		Assertions.assertNull(prescriptionHeaderEntity.getRestricted());

		prescriptionHeaderEntity.setIsInvoiced(null);
		Assertions.assertNull(prescriptionHeaderEntity.getIsInvoiced());

		prescriptionHeaderEntity.setExternalWarehouse(null);
		Assertions.assertNull(prescriptionHeaderEntity.getExternalWarehouse());


		PrescriptionHeaderEntity updatedEntity = prescriptionHeaderService.updateOldData(prescriptionHeaderEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getIsCompound());
		Assertions.assertFalse(updatedEntity.getIsCompound());

		Assertions.assertNotNull(updatedEntity.getIsIteration());
		Assertions.assertFalse(updatedEntity.getIsIteration());

		Assertions.assertNotNull(updatedEntity.getIsUrgent());
		Assertions.assertFalse(updatedEntity.getIsUrgent());

		Assertions.assertNotNull(updatedEntity.getRestricted());
		Assertions.assertFalse(updatedEntity.getRestricted());

		Assertions.assertNotNull(updatedEntity.getIsInvoiced());
		Assertions.assertFalse(updatedEntity.getIsInvoiced());

		Assertions.assertNotNull(updatedEntity.getExternalWarehouse());
		Assertions.assertFalse(updatedEntity.getExternalWarehouse());

	}

	@Test
	public void updateOldDataWithExistingPrescriptionHeaderEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionHeaderEntity prescriptionHeaderEntity;
			PrescriptionHeaderEntity entityWithUpdatedValues;

			try {
				prescriptionHeaderEntity = prescriptionHeaderFactory.getObject(false, false);
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionHeaderEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = prescriptionHeaderFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionHeaderEntity = prescriptionHeaderService.create(prescriptionHeaderEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(prescriptionHeaderEntity.getId());

			PrescriptionHeaderEntity updatedEntity = prescriptionHeaderService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPrescriptionHeaderEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PrescriptionHeaderEntity prescriptionHeaderEntity = prescriptionHeaderFactory.getObject(false, false);
		prescriptionHeaderEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			prescriptionHeaderService.updateOldData(prescriptionHeaderEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPrescriptionHeaderEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionHeaderEntity prescriptionHeaderEntity;
			PrescriptionHeaderEntity updatedPrescriptionHeaderEntity;

			InvoiceEntity invoiceEntity;

			RegistrationEntity registrationEntity;

			StaffEntity requestedByEntity;

			WarehouseEntity warehouseEntity;

			Set<InvoiceItemEntity> invoiceItemsEntities;

			Set<PrescriptionCompoundEntity> prescriptionCompoundsEntities;

			Set<PrescriptionItemEntity> prescriptionItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				prescriptionHeaderEntity = prescriptionHeaderFactory.getObject(true, false);
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
			invoiceEntity = prescriptionHeaderEntity.getInvoice();
			try {
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			invoiceEntity = invoiceRepository.save(invoiceEntity);
			prescriptionHeaderEntity.setInvoiceId(invoiceEntity.getId());

			registrationEntity = prescriptionHeaderEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			prescriptionHeaderEntity.setRegistrationId(registrationEntity.getId());

			requestedByEntity = prescriptionHeaderEntity.getRequestedBy();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(requestedByEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			requestedByEntity = staffRepository.save(requestedByEntity);
			prescriptionHeaderEntity.setRequestedById(requestedByEntity.getId());

			warehouseEntity = prescriptionHeaderEntity.getWarehouse();
			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(warehouseEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			warehouseEntity = warehouseRepository.save(warehouseEntity);
			prescriptionHeaderEntity.setWarehouseId(warehouseEntity.getId());

			invoiceItemsEntities = prescriptionHeaderEntity.getInvoiceItems();
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
			prescriptionHeaderEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			prescriptionCompoundsEntities = prescriptionHeaderEntity.getPrescriptionCompounds();
			Set<UUID> prescriptionCompoundsEntityIds = new HashSet<>();
			for (PrescriptionCompoundEntity entity : prescriptionCompoundsEntities) {
				try {
					prescriptionCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				prescriptionCompoundsEntityIds.add(prescriptionCompoundRepository.save(entity).getId());
			}
			prescriptionHeaderEntity.setPrescriptionCompoundsIds(prescriptionCompoundsEntityIds);

			prescriptionItemsEntities = prescriptionHeaderEntity.getPrescriptionItems();
			Set<UUID> prescriptionItemsEntityIds = new HashSet<>();
			for (PrescriptionItemEntity entity : prescriptionItemsEntities) {
				try {
					prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				prescriptionItemsEntityIds.add(prescriptionItemRepository.save(entity).getId());
			}
			prescriptionHeaderEntity.setPrescriptionItemsIds(prescriptionItemsEntityIds);


			prescriptionHeaderEntity = prescriptionHeaderService.create(prescriptionHeaderEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(prescriptionHeaderEntity.getInvoice());
			prescriptionHeaderEntity.setInvoiceId(null);
			prescriptionHeaderEntity.unsetInvoice();

			Assertions.assertNotNull(prescriptionHeaderEntity.getRegistration());
			prescriptionHeaderEntity.setRegistrationId(null);
			prescriptionHeaderEntity.unsetRegistration();

			Assertions.assertNotNull(prescriptionHeaderEntity.getRequestedBy());
			prescriptionHeaderEntity.setRequestedById(null);
			prescriptionHeaderEntity.unsetRequestedBy();

			Assertions.assertNotNull(prescriptionHeaderEntity.getWarehouse());
			prescriptionHeaderEntity.setWarehouseId(null);
			prescriptionHeaderEntity.unsetWarehouse();

			Assertions.assertTrue(prescriptionHeaderEntity.getInvoiceItems().size() > 0);
			prescriptionHeaderEntity.setInvoiceItemsIds(new HashSet<UUID>());
			prescriptionHeaderEntity.unsetInvoiceItems();

			Assertions.assertTrue(prescriptionHeaderEntity.getPrescriptionCompounds().size() > 0);
			prescriptionHeaderEntity.setPrescriptionCompoundsIds(new HashSet<UUID>());
			prescriptionHeaderEntity.unsetPrescriptionCompounds();

			Assertions.assertTrue(prescriptionHeaderEntity.getPrescriptionItems().size() > 0);
			prescriptionHeaderEntity.setPrescriptionItemsIds(new HashSet<UUID>());
			prescriptionHeaderEntity.unsetPrescriptionItems();


			updatedPrescriptionHeaderEntity = prescriptionHeaderService.updateOldData(prescriptionHeaderEntity);

			Assertions.assertNull(updatedPrescriptionHeaderEntity.getInvoice());

			Assertions.assertNull(updatedPrescriptionHeaderEntity.getRegistration());

			Assertions.assertNull(updatedPrescriptionHeaderEntity.getRequestedBy());

			Assertions.assertNull(updatedPrescriptionHeaderEntity.getWarehouse());

			Assertions.assertEquals(0, updatedPrescriptionHeaderEntity.getInvoiceItems().size());

			Assertions.assertEquals(0, updatedPrescriptionHeaderEntity.getPrescriptionCompounds().size());

			Assertions.assertEquals(0, updatedPrescriptionHeaderEntity.getPrescriptionItems().size());

		});
	}

	@Test
	public void updateOldDataWithPrescriptionHeaderEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionHeaderEntity prescriptionHeaderEntity;
			PrescriptionHeaderEntity updatedPrescriptionHeaderEntity;

			InvoiceEntity invoiceEntity;

			RegistrationEntity registrationEntity;

			StaffEntity requestedByEntity;

			WarehouseEntity warehouseEntity;

			Set<InvoiceItemEntity> invoiceItemsEntities;
			Set<UUID> invoiceItemsEntityIds;

			Set<PrescriptionCompoundEntity> prescriptionCompoundsEntities;
			Set<UUID> prescriptionCompoundsEntityIds;

			Set<PrescriptionItemEntity> prescriptionItemsEntities;
			Set<UUID> prescriptionItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				prescriptionHeaderEntity = prescriptionHeaderFactory.getObject(true, false);
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
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionHeaderEntity.getInvoice(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Invoice relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			invoiceEntity = invoiceRepository.findById(invoiceRepository.save(prescriptionHeaderEntity.getInvoice()).getId()).get();
			prescriptionHeaderEntity.unsetInvoice();
			prescriptionHeaderEntity.setInvoiceId(invoiceEntity.getId());

			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionHeaderEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(prescriptionHeaderEntity.getRegistration()).getId()).get();
			prescriptionHeaderEntity.unsetRegistration();
			prescriptionHeaderEntity.setRegistrationId(registrationEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionHeaderEntity.getRequestedBy(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Requested By relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			requestedByEntity = staffRepository.findById(staffRepository.save(prescriptionHeaderEntity.getRequestedBy()).getId()).get();
			prescriptionHeaderEntity.unsetRequestedBy();
			prescriptionHeaderEntity.setRequestedById(requestedByEntity.getId());

			try {
				warehouseDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionHeaderEntity.getWarehouse(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Warehouse relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			warehouseEntity = warehouseRepository.findById(warehouseRepository.save(prescriptionHeaderEntity.getWarehouse()).getId()).get();
			prescriptionHeaderEntity.unsetWarehouse();
			prescriptionHeaderEntity.setWarehouseId(warehouseEntity.getId());

			invoiceItemsEntities = new HashSet<>();
			invoiceItemsEntityIds = new HashSet<>();
			for (InvoiceItemEntity entity : prescriptionHeaderEntity.getInvoiceItems()) {
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
			prescriptionHeaderEntity.unsetInvoiceItems();
			prescriptionHeaderEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			prescriptionCompoundsEntities = new HashSet<>();
			prescriptionCompoundsEntityIds = new HashSet<>();
			for (PrescriptionCompoundEntity entity : prescriptionHeaderEntity.getPrescriptionCompounds()) {
				try {
					prescriptionCompoundDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Prescription Compounds relation for this test: " + e.getCause());
					return;
				}
				UUID id = prescriptionCompoundRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				prescriptionCompoundsEntities.add(prescriptionCompoundRepository.findById(id).get());
				prescriptionCompoundsEntityIds.add(id);
			}
			prescriptionHeaderEntity.unsetPrescriptionCompounds();
			prescriptionHeaderEntity.setPrescriptionCompoundsIds(prescriptionCompoundsEntityIds);

			prescriptionItemsEntities = new HashSet<>();
			prescriptionItemsEntityIds = new HashSet<>();
			for (PrescriptionItemEntity entity : prescriptionHeaderEntity.getPrescriptionItems()) {
				try {
					prescriptionItemDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Prescription Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = prescriptionItemRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				prescriptionItemsEntities.add(prescriptionItemRepository.findById(id).get());
				prescriptionItemsEntityIds.add(id);
			}
			prescriptionHeaderEntity.unsetPrescriptionItems();
			prescriptionHeaderEntity.setPrescriptionItemsIds(prescriptionItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPrescriptionHeaderEntity = prescriptionHeaderService.updateOldData(prescriptionHeaderEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			invoiceEntity.unsetPrescriptionHeader(false);
			updatedPrescriptionHeaderEntity.getInvoice().unsetPrescriptionHeader(false);
			Assertions.assertEquals(invoiceEntity, updatedPrescriptionHeaderEntity.getInvoice());

			registrationEntity.unsetPrescriptionHeaders(false);
			updatedPrescriptionHeaderEntity.getRegistration().unsetPrescriptionHeaders(false);
			Assertions.assertEquals(registrationEntity, updatedPrescriptionHeaderEntity.getRegistration());

			requestedByEntity.unsetPrescriptionHeaders(false);
			updatedPrescriptionHeaderEntity.getRequestedBy().unsetPrescriptionHeaders(false);
			Assertions.assertEquals(requestedByEntity, updatedPrescriptionHeaderEntity.getRequestedBy());

			warehouseEntity.unsetPrescriptionHeaders(false);
			updatedPrescriptionHeaderEntity.getWarehouse().unsetPrescriptionHeaders(false);
			Assertions.assertEquals(warehouseEntity, updatedPrescriptionHeaderEntity.getWarehouse());

			Assertions.assertEquals(invoiceItemsEntities.size(), updatedPrescriptionHeaderEntity.getInvoiceItems().size());

			Assertions.assertEquals(prescriptionCompoundsEntities.size(), updatedPrescriptionHeaderEntity.getPrescriptionCompounds().size());

			Assertions.assertEquals(prescriptionItemsEntities.size(), updatedPrescriptionHeaderEntity.getPrescriptionItems().size());

		});
	}

	@Test
	public void whenCreatePrescriptionHeaderEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionHeaderEntity prescriptionHeaderEntity;
			Optional<PrescriptionHeaderEntity> fetchedPrescriptionHeaderEntity;

			try {
				prescriptionHeaderEntity = prescriptionHeaderFactory.getObject(false, false);
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionHeaderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionHeaderEntity = prescriptionHeaderService.create(prescriptionHeaderEntity);

			fetchedPrescriptionHeaderEntity = prescriptionHeaderService.findById(prescriptionHeaderEntity.getId());

			Assertions.assertTrue(fetchedPrescriptionHeaderEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPrescriptionHeaderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(prescriptionHeaderEntity, fetchedPrescriptionHeaderEntity.get());
		});
	}

	@Test
	public void whenUpdatePrescriptionHeaderEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionHeaderEntity prescriptionHeaderEntity;
			PrescriptionHeaderEntity updatedPrescriptionHeaderEntity;
			Optional<PrescriptionHeaderEntity> fetchedPrescriptionHeaderEntity;

			try {
				prescriptionHeaderEntity = prescriptionHeaderFactory.getObject(false, false);
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionHeaderEntity, true, true, false);
				updatedPrescriptionHeaderEntity = prescriptionHeaderFactory.getObject(false, false);
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPrescriptionHeaderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionHeaderEntity = prescriptionHeaderService.create(prescriptionHeaderEntity);

			updatedPrescriptionHeaderEntity.setId(prescriptionHeaderEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPrescriptionHeaderEntity.setCreated(prescriptionHeaderEntity.getCreated());

			updatedPrescriptionHeaderEntity = prescriptionHeaderService.update(updatedPrescriptionHeaderEntity);

			fetchedPrescriptionHeaderEntity = prescriptionHeaderService.findById(prescriptionHeaderEntity.getId());

			Assertions.assertTrue(fetchedPrescriptionHeaderEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePrescriptionHeaderEntity_ThenEntityIsCreated
			fetchedPrescriptionHeaderEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPrescriptionHeaderEntity, fetchedPrescriptionHeaderEntity.get());
		});
	}

	@Test
	public void whenDeletePrescriptionHeaderEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PrescriptionHeaderEntity prescriptionHeaderEntity;
			Optional<PrescriptionHeaderEntity> fetchedPrescriptionHeaderEntity;

			try {
				prescriptionHeaderEntity = prescriptionHeaderFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				prescriptionHeaderDatabasePopulator.populateRelatedEntitiesInDatabase(prescriptionHeaderEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			prescriptionHeaderEntity = prescriptionHeaderService.create(prescriptionHeaderEntity);

			prescriptionHeaderService.deleteById(prescriptionHeaderEntity.getId());
			fetchedPrescriptionHeaderEntity = prescriptionHeaderService.findById(prescriptionHeaderEntity.getId());

			Assertions.assertTrue(fetchedPrescriptionHeaderEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
