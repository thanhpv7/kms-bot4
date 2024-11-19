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
import kmsweb.entities.InvoiceSummaryEntity;
import kmsweb.repositories.InvoiceSummaryRepository;
import kmsweb.utils.InvoiceSummaryFactory;
import kmsweb.utils.DatabasePopulators.InvoiceSummaryDatabasePopulator;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.utils.InvoiceFactory;
import kmsweb.utils.DatabasePopulators.InvoiceDatabasePopulator;
import kmsweb.entities.RetailPharmacyInvoiceEntity;
import kmsweb.repositories.RetailPharmacyInvoiceRepository;
import kmsweb.utils.RetailPharmacyInvoiceFactory;
import kmsweb.utils.DatabasePopulators.RetailPharmacyInvoiceDatabasePopulator;
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
public class InvoiceSummaryServiceIntegrationTest {

	@Autowired
	private InvoiceSummaryRepository invoiceSummaryRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InvoiceSummaryService invoiceSummaryService;

	private final InvoiceSummaryFactory invoiceSummaryFactory = new InvoiceSummaryFactory();

	@Autowired
	private InvoiceSummaryDatabasePopulator invoiceSummaryDatabasePopulator;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDatabasePopulator invoiceDatabasePopulator;

	private final InvoiceFactory invoiceFactory = new InvoiceFactory();

	@Autowired
	private RetailPharmacyInvoiceRepository retailPharmacyInvoiceRepository;

	@Autowired
	private RetailPharmacyInvoiceDatabasePopulator retailPharmacyInvoiceDatabasePopulator;

	private final RetailPharmacyInvoiceFactory retailPharmacyInvoiceFactory = new RetailPharmacyInvoiceFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		invoiceSummaryService = new InvoiceSummaryService(
			invoiceRepository,
			retailPharmacyInvoiceRepository,
			validator,
			auditRepository,
			invoiceSummaryRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInvoiceSummaryEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InvoiceSummaryEntity invoiceSummaryEntity = invoiceSummaryFactory.getObject(false, false);

		InvoiceSummaryEntity updatedEntity = invoiceSummaryService.updateOldData(invoiceSummaryEntity);
		Assertions.assertEquals(invoiceSummaryEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewInvoiceSummaryEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		InvoiceSummaryEntity invoiceSummaryEntity = invoiceSummaryFactory.getObject(false, false);

		invoiceSummaryEntity.setTaxOnOtherDiscount(null);
		Assertions.assertNull(invoiceSummaryEntity.getTaxOnOtherDiscount());

		invoiceSummaryEntity.setTaxOnOtherFee(null);
		Assertions.assertNull(invoiceSummaryEntity.getTaxOnOtherFee());


		InvoiceSummaryEntity updatedEntity = invoiceSummaryService.updateOldData(invoiceSummaryEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getTaxOnOtherDiscount());
		Assertions.assertFalse(updatedEntity.getTaxOnOtherDiscount());

		Assertions.assertNotNull(updatedEntity.getTaxOnOtherFee());
		Assertions.assertFalse(updatedEntity.getTaxOnOtherFee());

	}

	@Test
	public void updateOldDataWithExistingInvoiceSummaryEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceSummaryEntity invoiceSummaryEntity;
			InvoiceSummaryEntity entityWithUpdatedValues;

			try {
				invoiceSummaryEntity = invoiceSummaryFactory.getObject(false, false);
				invoiceSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceSummaryEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = invoiceSummaryFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceSummaryEntity = invoiceSummaryService.create(invoiceSummaryEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(invoiceSummaryEntity.getId());

			InvoiceSummaryEntity updatedEntity = invoiceSummaryService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInvoiceSummaryEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InvoiceSummaryEntity invoiceSummaryEntity = invoiceSummaryFactory.getObject(false, false);
		invoiceSummaryEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			invoiceSummaryService.updateOldData(invoiceSummaryEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInvoiceSummaryEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceSummaryEntity invoiceSummaryEntity;
			InvoiceSummaryEntity updatedInvoiceSummaryEntity;

			InvoiceEntity invoiceEntity;

			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				invoiceSummaryEntity = invoiceSummaryFactory.getObject(true, false);
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
			invoiceEntity = invoiceSummaryEntity.getInvoice();
			try {
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			invoiceEntity = invoiceRepository.save(invoiceEntity);
			invoiceSummaryEntity.setInvoiceId(invoiceEntity.getId());

			retailPharmacyInvoiceEntity = invoiceSummaryEntity.getRetailPharmacyInvoice();
			try {
				retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(retailPharmacyInvoiceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			retailPharmacyInvoiceEntity = retailPharmacyInvoiceRepository.save(retailPharmacyInvoiceEntity);
			invoiceSummaryEntity.setRetailPharmacyInvoiceId(retailPharmacyInvoiceEntity.getId());


			invoiceSummaryEntity = invoiceSummaryService.create(invoiceSummaryEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(invoiceSummaryEntity.getInvoice());
			invoiceSummaryEntity.setInvoiceId(null);
			invoiceSummaryEntity.unsetInvoice();

			Assertions.assertNotNull(invoiceSummaryEntity.getRetailPharmacyInvoice());
			invoiceSummaryEntity.setRetailPharmacyInvoiceId(null);
			invoiceSummaryEntity.unsetRetailPharmacyInvoice();


			updatedInvoiceSummaryEntity = invoiceSummaryService.updateOldData(invoiceSummaryEntity);

			Assertions.assertNull(updatedInvoiceSummaryEntity.getInvoice());

			Assertions.assertNull(updatedInvoiceSummaryEntity.getRetailPharmacyInvoice());

		});
	}

	@Test
	public void updateOldDataWithInvoiceSummaryEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceSummaryEntity invoiceSummaryEntity;
			InvoiceSummaryEntity updatedInvoiceSummaryEntity;

			InvoiceEntity invoiceEntity;

			RetailPharmacyInvoiceEntity retailPharmacyInvoiceEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				invoiceSummaryEntity = invoiceSummaryFactory.getObject(true, false);
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
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceSummaryEntity.getInvoice(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Invoice relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			invoiceEntity = invoiceRepository.findById(invoiceRepository.save(invoiceSummaryEntity.getInvoice()).getId()).get();
			invoiceSummaryEntity.unsetInvoice();
			invoiceSummaryEntity.setInvoiceId(invoiceEntity.getId());

			try {
				retailPharmacyInvoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceSummaryEntity.getRetailPharmacyInvoice(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Retail Pharmacy Invoice relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			retailPharmacyInvoiceEntity = retailPharmacyInvoiceRepository.findById(retailPharmacyInvoiceRepository.save(invoiceSummaryEntity.getRetailPharmacyInvoice()).getId()).get();
			invoiceSummaryEntity.unsetRetailPharmacyInvoice();
			invoiceSummaryEntity.setRetailPharmacyInvoiceId(retailPharmacyInvoiceEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInvoiceSummaryEntity = invoiceSummaryService.updateOldData(invoiceSummaryEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			invoiceEntity.unsetInvoiceSummary(false);
			updatedInvoiceSummaryEntity.getInvoice().unsetInvoiceSummary(false);
			Assertions.assertEquals(invoiceEntity, updatedInvoiceSummaryEntity.getInvoice());

			retailPharmacyInvoiceEntity.unsetInvoiceSummary(false);
			updatedInvoiceSummaryEntity.getRetailPharmacyInvoice().unsetInvoiceSummary(false);
			Assertions.assertEquals(retailPharmacyInvoiceEntity, updatedInvoiceSummaryEntity.getRetailPharmacyInvoice());

		});
	}

	@Test
	public void whenCreateInvoiceSummaryEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceSummaryEntity invoiceSummaryEntity;
			Optional<InvoiceSummaryEntity> fetchedInvoiceSummaryEntity;

			try {
				invoiceSummaryEntity = invoiceSummaryFactory.getObject(false, false);
				invoiceSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceSummaryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceSummaryEntity = invoiceSummaryService.create(invoiceSummaryEntity);

			fetchedInvoiceSummaryEntity = invoiceSummaryService.findById(invoiceSummaryEntity.getId());

			Assertions.assertTrue(fetchedInvoiceSummaryEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInvoiceSummaryEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(invoiceSummaryEntity, fetchedInvoiceSummaryEntity.get());
		});
	}

	@Test
	public void whenUpdateInvoiceSummaryEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceSummaryEntity invoiceSummaryEntity;
			InvoiceSummaryEntity updatedInvoiceSummaryEntity;
			Optional<InvoiceSummaryEntity> fetchedInvoiceSummaryEntity;

			try {
				invoiceSummaryEntity = invoiceSummaryFactory.getObject(false, false);
				invoiceSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceSummaryEntity, true, true, false);
				updatedInvoiceSummaryEntity = invoiceSummaryFactory.getObject(false, false);
				invoiceSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInvoiceSummaryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceSummaryEntity = invoiceSummaryService.create(invoiceSummaryEntity);

			updatedInvoiceSummaryEntity.setId(invoiceSummaryEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInvoiceSummaryEntity.setCreated(invoiceSummaryEntity.getCreated());

			updatedInvoiceSummaryEntity = invoiceSummaryService.update(updatedInvoiceSummaryEntity);

			fetchedInvoiceSummaryEntity = invoiceSummaryService.findById(invoiceSummaryEntity.getId());

			Assertions.assertTrue(fetchedInvoiceSummaryEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInvoiceSummaryEntity_ThenEntityIsCreated
			fetchedInvoiceSummaryEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInvoiceSummaryEntity, fetchedInvoiceSummaryEntity.get());
		});
	}

	@Test
	public void whenDeleteInvoiceSummaryEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InvoiceSummaryEntity invoiceSummaryEntity;
			Optional<InvoiceSummaryEntity> fetchedInvoiceSummaryEntity;

			try {
				invoiceSummaryEntity = invoiceSummaryFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				invoiceSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceSummaryEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoiceSummaryEntity = invoiceSummaryService.create(invoiceSummaryEntity);

			invoiceSummaryService.deleteById(invoiceSummaryEntity.getId());
			fetchedInvoiceSummaryEntity = invoiceSummaryService.findById(invoiceSummaryEntity.getId());

			Assertions.assertTrue(fetchedInvoiceSummaryEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
