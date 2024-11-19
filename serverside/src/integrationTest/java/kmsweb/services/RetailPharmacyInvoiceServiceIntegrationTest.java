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
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.repositories.RetailPharmacyInvoiceRepository;
import kmsweb.utils.RetailPharmacyInvoiceFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyInvoiceDatabasePopulator;
import kmsweb.entities.CashReceiptEntity;
import kmsweb.repositories.CashReceiptRepository;
import kmsweb.utils.CashReceiptFactory;
import kmsweb.utils.DatabasePopulators.CashReceiptDatabasePopulator;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.repositories.InvoiceItemRepository;
import kmsweb.utils.InvoiceItemFactory;
import kmsweb.utils.DatabasePopulators.InvoiceItemDatabasePopulator;
import kmsweb.entities.InvoiceSummaryEntity;
import kmsweb.repositories.InvoiceSummaryRepository;
import kmsweb.utils.InvoiceSummaryFactory;
import kmsweb.utils.DatabasePopulators.InvoiceSummaryDatabasePopulator;
import kmsweb.entities.RetailPharmacyEntity;
import kmsweb.repositories.RetailPharmacyRepository;
import kmsweb.utils.RetailPharmacyFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyDatabasePopulator;
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
public class RetailPharmacyInvoiceServiceIntegrationTest {

	@Autowired
	private RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private RetailPharmacyInvoiceService retailPharmacyInvoiceService;

	private final RetailPharmacyInvoiceFactory retailPharmacyInvoiceFactory = new RetailPharmacyInvoiceFactory();

	@Autowired
	private RetailPharmacyInvoiceDatabasePopulator retailPharmacyInvoiceDatabasePopulator;

	@Autowired
	private CashReceiptRepository cashReceiptRepository;

	@Autowired
	private CashReceiptDatabasePopulator cashReceiptDatabasePopulator;

	private final CashReceiptFactory cashReceiptFactory = new CashReceiptFactory();

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Autowired
	private InvoiceItemDatabasePopulator invoiceItemDatabasePopulator;

	private final InvoiceItemFactory invoiceItemFactory = new InvoiceItemFactory();

	@Autowired
	private InvoiceSummaryRepository invoiceSummaryRepository;

	@Autowired
	private InvoiceSummaryDatabasePopulator invoiceSummaryDatabasePopulator;

	private final InvoiceSummaryFactory invoiceSummaryFactory = new InvoiceSummaryFactory();

	@Autowired
	private RetailPharmacyRepository retailPharmacyRepository;

	@Autowired
	private RetailPharmacyDatabasePopulator retailPharmacyDatabasePopulator;

	private final RetailPharmacyFactory retailPharmacyFactory = new RetailPharmacyFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		retailPharmacyInvoiceService = new RetailPharmacyInvoiceService(
			cashReceiptRepository,
			invoiceItemRepository,
			invoiceSummaryRepository,
			retailPharmacyRepository,
			validator,
			auditRepository,
			retailPharmacyInvoiceRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewRetailPharmacyInvoiceEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity = retailPharmacyInvoiceFactory.getObject(false, false);

		RetailPharmacyInvoiceEntity updatedEntity = retailPharmacyInvoiceService.updateOldData(retailPharmacyInvoiceEntity);
		Assertions.assertEquals(retailPharmacyInvoiceEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewRetailPharmacyInvoiceEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity = retailPharmacyInvoiceFactory.getObject(false, false);

		retailPharmacyInvoiceEntity.setDisplayDoctorOnPrint(null);
		Assertions.assertNull(retailPharmacyInvoiceEntity.getDisplayDoctorOnPrint());


		RetailPharmacyInvoiceEntity updatedEntity = retailPharmacyInvoiceService.updateOldData(retailPharmacyInvoiceEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getDisplayDoctorOnPrint());
		Assertions.assertFalse(updatedEntity.getDisplayDoctorOnPrint());

	}

	@Test
	public void updateOldDataWithExistingRetailPharmacyInvoiceEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;
			RetailPharmacyInvoiceEntity entityWithUpdatedValues;

			try {
				retailPharmacyInvoiceEntity = retailPharmacyInvoiceFactory.getObject(false, false);
				retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyInvoiceEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = retailPharmacyInvoiceFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyInvoiceEntity = retailPharmacyInvoiceService.create(retailPharmacyInvoiceEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(retailPharmacyInvoiceEntity.getId());

			RetailPharmacyInvoiceEntity updatedEntity = retailPharmacyInvoiceService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithRetailPharmacyInvoiceEntityWithNonExistentId_ShouldThrowException() throws Exception {
		RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity = retailPharmacyInvoiceFactory.getObject(false, false);
		retailPharmacyInvoiceEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			retailPharmacyInvoiceService.updateOldData(retailPharmacyInvoiceEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingRetailPharmacyInvoiceEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;
			RetailPharmacyInvoiceEntity updatedRetailPharmacyInvoiceEntity;

			InvoiceSummaryEntity invoiceSummaryEntity;

			RetailPharmacyEntity retailPharmacyEntity;

			Set<CashReceiptEntity> cashReceiptsEntities;

			Set<InvoiceItemEntity> invoiceItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				retailPharmacyInvoiceEntity = retailPharmacyInvoiceFactory.getObject(true, false);
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
			invoiceSummaryEntity = retailPharmacyInvoiceEntity.getInvoiceSummary();
			try {
				invoiceSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceSummaryEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			invoiceSummaryEntity = invoiceSummaryRepository.save(invoiceSummaryEntity);
			retailPharmacyInvoiceEntity.setInvoiceSummaryId(invoiceSummaryEntity.getId());

			retailPharmacyEntity = retailPharmacyInvoiceEntity.getRetailPharmacy();
			try {
				retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			retailPharmacyEntity = retailPharmacyRepository.save(retailPharmacyEntity);
			retailPharmacyInvoiceEntity.setRetailPharmacyId(retailPharmacyEntity.getId());

			cashReceiptsEntities = retailPharmacyInvoiceEntity.getCashReceipts();
			Set<UUID> cashReceiptsEntityIds = new HashSet<>();
			for (CashReceiptEntity entity : cashReceiptsEntities) {
				try {
					cashReceiptDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				cashReceiptsEntityIds.add(cashReceiptRepository.save(entity).getId());
			}
			retailPharmacyInvoiceEntity.setCashReceiptsIds(cashReceiptsEntityIds);

			invoiceItemsEntities = retailPharmacyInvoiceEntity.getInvoiceItems();
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
			retailPharmacyInvoiceEntity.setInvoiceItemsIds(invoiceItemsEntityIds);


			retailPharmacyInvoiceEntity = retailPharmacyInvoiceService.create(retailPharmacyInvoiceEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(retailPharmacyInvoiceEntity.getInvoiceSummary());
			retailPharmacyInvoiceEntity.setInvoiceSummaryId(null);
			retailPharmacyInvoiceEntity.unsetInvoiceSummary();

			Assertions.assertNotNull(retailPharmacyInvoiceEntity.getRetailPharmacy());
			retailPharmacyInvoiceEntity.setRetailPharmacyId(null);
			retailPharmacyInvoiceEntity.unsetRetailPharmacy();

			Assertions.assertTrue(retailPharmacyInvoiceEntity.getCashReceipts().size() > 0);
			retailPharmacyInvoiceEntity.setCashReceiptsIds(new HashSet<UUID>());
			retailPharmacyInvoiceEntity.unsetCashReceipts();

			Assertions.assertTrue(retailPharmacyInvoiceEntity.getInvoiceItems().size() > 0);
			retailPharmacyInvoiceEntity.setInvoiceItemsIds(new HashSet<UUID>());
			retailPharmacyInvoiceEntity.unsetInvoiceItems();


			updatedRetailPharmacyInvoiceEntity = retailPharmacyInvoiceService.updateOldData(retailPharmacyInvoiceEntity);

			Assertions.assertNull(updatedRetailPharmacyInvoiceEntity.getInvoiceSummary());

			Assertions.assertNull(updatedRetailPharmacyInvoiceEntity.getRetailPharmacy());

			Assertions.assertEquals(0, updatedRetailPharmacyInvoiceEntity.getCashReceipts().size());

			Assertions.assertEquals(0, updatedRetailPharmacyInvoiceEntity.getInvoiceItems().size());

		});
	}

	@Test
	public void updateOldDataWithRetailPharmacyInvoiceEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;
			RetailPharmacyInvoiceEntity updatedRetailPharmacyInvoiceEntity;

			InvoiceSummaryEntity invoiceSummaryEntity;

			RetailPharmacyEntity retailPharmacyEntity;

			Set<CashReceiptEntity> cashReceiptsEntities;
			Set<UUID> cashReceiptsEntityIds;

			Set<InvoiceItemEntity> invoiceItemsEntities;
			Set<UUID> invoiceItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				retailPharmacyInvoiceEntity = retailPharmacyInvoiceFactory.getObject(true, false);
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
				invoiceSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyInvoiceEntity.getInvoiceSummary(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Invoice Summary relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			invoiceSummaryEntity = invoiceSummaryRepository.findById(invoiceSummaryRepository.save(retailPharmacyInvoiceEntity.getInvoiceSummary()).getId()).get();
			retailPharmacyInvoiceEntity.unsetInvoiceSummary();
			retailPharmacyInvoiceEntity.setInvoiceSummaryId(invoiceSummaryEntity.getId());

			try {
				retailPharmacyDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyInvoiceEntity.getRetailPharmacy(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Retail Pharmacy relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			retailPharmacyEntity = retailPharmacyRepository.findById(retailPharmacyRepository.save(retailPharmacyInvoiceEntity.getRetailPharmacy()).getId()).get();
			retailPharmacyInvoiceEntity.unsetRetailPharmacy();
			retailPharmacyInvoiceEntity.setRetailPharmacyId(retailPharmacyEntity.getId());

			cashReceiptsEntities = new HashSet<>();
			cashReceiptsEntityIds = new HashSet<>();
			for (CashReceiptEntity entity : retailPharmacyInvoiceEntity.getCashReceipts()) {
				try {
					cashReceiptDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Cash Receipts relation for this test: " + e.getCause());
					return;
				}
				UUID id = cashReceiptRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				cashReceiptsEntities.add(cashReceiptRepository.findById(id).get());
				cashReceiptsEntityIds.add(id);
			}
			retailPharmacyInvoiceEntity.unsetCashReceipts();
			retailPharmacyInvoiceEntity.setCashReceiptsIds(cashReceiptsEntityIds);

			invoiceItemsEntities = new HashSet<>();
			invoiceItemsEntityIds = new HashSet<>();
			for (InvoiceItemEntity entity : retailPharmacyInvoiceEntity.getInvoiceItems()) {
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
			retailPharmacyInvoiceEntity.unsetInvoiceItems();
			retailPharmacyInvoiceEntity.setInvoiceItemsIds(invoiceItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedRetailPharmacyInvoiceEntity = retailPharmacyInvoiceService.updateOldData(retailPharmacyInvoiceEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			invoiceSummaryEntity.unsetRetailPharmacyInvoice(false);
			updatedRetailPharmacyInvoiceEntity.getInvoiceSummary().unsetRetailPharmacyInvoice(false);
			Assertions.assertEquals(invoiceSummaryEntity, updatedRetailPharmacyInvoiceEntity.getInvoiceSummary());

			retailPharmacyEntity.unsetRetailPharmacyInvoices(false);
			updatedRetailPharmacyInvoiceEntity.getRetailPharmacy().unsetRetailPharmacyInvoices(false);
			Assertions.assertEquals(retailPharmacyEntity, updatedRetailPharmacyInvoiceEntity.getRetailPharmacy());

			Assertions.assertEquals(cashReceiptsEntities.size(), updatedRetailPharmacyInvoiceEntity.getCashReceipts().size());

			Assertions.assertEquals(invoiceItemsEntities.size(), updatedRetailPharmacyInvoiceEntity.getInvoiceItems().size());

		});
	}

	@Test
	public void whenCreateRetailPharmacyInvoiceEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;
			Optional<RetailPharmacyInvoiceEntity> fetchedRetailPharmacyInvoiceEntity;

			try {
				retailPharmacyInvoiceEntity = retailPharmacyInvoiceFactory.getObject(false, false);
				retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyInvoiceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyInvoiceEntity = retailPharmacyInvoiceService.create(retailPharmacyInvoiceEntity);

			fetchedRetailPharmacyInvoiceEntity = retailPharmacyInvoiceService.findById(retailPharmacyInvoiceEntity.getId());

			Assertions.assertTrue(fetchedRetailPharmacyInvoiceEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedRetailPharmacyInvoiceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(retailPharmacyInvoiceEntity, fetchedRetailPharmacyInvoiceEntity.get());
		});
	}

	@Test
	public void whenUpdateRetailPharmacyInvoiceEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;
			RetailPharmacyInvoiceEntity updatedRetailPharmacyInvoiceEntity;
			Optional<RetailPharmacyInvoiceEntity> fetchedRetailPharmacyInvoiceEntity;

			try {
				retailPharmacyInvoiceEntity = retailPharmacyInvoiceFactory.getObject(false, false);
				retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyInvoiceEntity, true, true, false);
				updatedRetailPharmacyInvoiceEntity = retailPharmacyInvoiceFactory.getObject(false, false);
				retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(updatedRetailPharmacyInvoiceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyInvoiceEntity = retailPharmacyInvoiceService.create(retailPharmacyInvoiceEntity);

			updatedRetailPharmacyInvoiceEntity.setId(retailPharmacyInvoiceEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedRetailPharmacyInvoiceEntity.setCreated(retailPharmacyInvoiceEntity.getCreated());

			updatedRetailPharmacyInvoiceEntity = retailPharmacyInvoiceService.update(updatedRetailPharmacyInvoiceEntity);

			fetchedRetailPharmacyInvoiceEntity = retailPharmacyInvoiceService.findById(retailPharmacyInvoiceEntity.getId());

			Assertions.assertTrue(fetchedRetailPharmacyInvoiceEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateRetailPharmacyInvoiceEntity_ThenEntityIsCreated
			fetchedRetailPharmacyInvoiceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedRetailPharmacyInvoiceEntity, fetchedRetailPharmacyInvoiceEntity.get());
		});
	}

	@Test
	public void whenDeleteRetailPharmacyInvoiceEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;
			Optional<RetailPharmacyInvoiceEntity> fetchedRetailPharmacyInvoiceEntity;

			try {
				retailPharmacyInvoiceEntity = retailPharmacyInvoiceFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyInvoiceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			retailPharmacyInvoiceEntity = retailPharmacyInvoiceService.create(retailPharmacyInvoiceEntity);

			retailPharmacyInvoiceService.deleteById(retailPharmacyInvoiceEntity.getId());
			fetchedRetailPharmacyInvoiceEntity = retailPharmacyInvoiceService.findById(retailPharmacyInvoiceEntity.getId());

			Assertions.assertTrue(fetchedRetailPharmacyInvoiceEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
