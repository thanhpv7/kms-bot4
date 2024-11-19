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
import kmsweb.entities.InvoicePaymentOtherEntity;
import kmsweb.repositories.InvoicePaymentOtherRepository;
import kmsweb.utils.InvoicePaymentOtherFactory;
import kmsweb.utils.DatabasePopulators.InvoicePaymentOtherDatabasePopulator;
import kmsweb.entities.InvoiceEntity;
import kmsweb.repositories.InvoiceRepository;
import kmsweb.utils.InvoiceFactory;
import kmsweb.utils.DatabasePopulators.InvoiceDatabasePopulator;
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
public class InvoicePaymentOtherServiceIntegrationTest {

	@Autowired
	private InvoicePaymentOtherRepository invoicePaymentOtherRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InvoicePaymentOtherService invoicePaymentOtherService;

	private final InvoicePaymentOtherFactory invoicePaymentOtherFactory = new InvoicePaymentOtherFactory();

	@Autowired
	private InvoicePaymentOtherDatabasePopulator invoicePaymentOtherDatabasePopulator;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private InvoiceDatabasePopulator invoiceDatabasePopulator;

	private final InvoiceFactory invoiceFactory = new InvoiceFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		invoicePaymentOtherService = new InvoicePaymentOtherService(
			invoiceRepository,
			validator,
			auditRepository,
			invoicePaymentOtherRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInvoicePaymentOtherEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InvoicePaymentOtherEntity invoicePaymentOtherEntity = invoicePaymentOtherFactory.getObject(false, false);

		InvoicePaymentOtherEntity updatedEntity = invoicePaymentOtherService.updateOldData(invoicePaymentOtherEntity);
		Assertions.assertEquals(invoicePaymentOtherEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingInvoicePaymentOtherEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentOtherEntity invoicePaymentOtherEntity;
			InvoicePaymentOtherEntity entityWithUpdatedValues;

			try {
				invoicePaymentOtherEntity = invoicePaymentOtherFactory.getObject(false, false);
				invoicePaymentOtherDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentOtherEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = invoicePaymentOtherFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoicePaymentOtherEntity = invoicePaymentOtherService.create(invoicePaymentOtherEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(invoicePaymentOtherEntity.getId());

			InvoicePaymentOtherEntity updatedEntity = invoicePaymentOtherService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInvoicePaymentOtherEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InvoicePaymentOtherEntity invoicePaymentOtherEntity = invoicePaymentOtherFactory.getObject(false, false);
		invoicePaymentOtherEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			invoicePaymentOtherService.updateOldData(invoicePaymentOtherEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInvoicePaymentOtherEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentOtherEntity invoicePaymentOtherEntity;
			InvoicePaymentOtherEntity updatedInvoicePaymentOtherEntity;

			InvoiceEntity invoiceEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				invoicePaymentOtherEntity = invoicePaymentOtherFactory.getObject(true, false);
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
			invoiceEntity = invoicePaymentOtherEntity.getInvoice();
			try {
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			invoiceEntity = invoiceRepository.save(invoiceEntity);
			invoicePaymentOtherEntity.setInvoiceId(invoiceEntity.getId());


			invoicePaymentOtherEntity = invoicePaymentOtherService.create(invoicePaymentOtherEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(invoicePaymentOtherEntity.getInvoice());
			invoicePaymentOtherEntity.setInvoiceId(null);
			invoicePaymentOtherEntity.unsetInvoice();


			updatedInvoicePaymentOtherEntity = invoicePaymentOtherService.updateOldData(invoicePaymentOtherEntity);

			Assertions.assertNull(updatedInvoicePaymentOtherEntity.getInvoice());

		});
	}

	@Test
	public void updateOldDataWithInvoicePaymentOtherEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentOtherEntity invoicePaymentOtherEntity;
			InvoicePaymentOtherEntity updatedInvoicePaymentOtherEntity;

			InvoiceEntity invoiceEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				invoicePaymentOtherEntity = invoicePaymentOtherFactory.getObject(true, false);
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
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentOtherEntity.getInvoice(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Invoice relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			invoiceEntity = invoiceRepository.findById(invoiceRepository.save(invoicePaymentOtherEntity.getInvoice()).getId()).get();
			invoicePaymentOtherEntity.unsetInvoice();
			invoicePaymentOtherEntity.setInvoiceId(invoiceEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInvoicePaymentOtherEntity = invoicePaymentOtherService.updateOldData(invoicePaymentOtherEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			invoiceEntity.unsetInvoicePaymentOther(false);
			updatedInvoicePaymentOtherEntity.getInvoice().unsetInvoicePaymentOther(false);
			Assertions.assertEquals(invoiceEntity, updatedInvoicePaymentOtherEntity.getInvoice());

		});
	}

	@Test
	public void whenCreateInvoicePaymentOtherEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentOtherEntity invoicePaymentOtherEntity;
			Optional<InvoicePaymentOtherEntity> fetchedInvoicePaymentOtherEntity;

			try {
				invoicePaymentOtherEntity = invoicePaymentOtherFactory.getObject(false, false);
				invoicePaymentOtherDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentOtherEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoicePaymentOtherEntity = invoicePaymentOtherService.create(invoicePaymentOtherEntity);

			fetchedInvoicePaymentOtherEntity = invoicePaymentOtherService.findById(invoicePaymentOtherEntity.getId());

			Assertions.assertTrue(fetchedInvoicePaymentOtherEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInvoicePaymentOtherEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(invoicePaymentOtherEntity, fetchedInvoicePaymentOtherEntity.get());
		});
	}

	@Test
	public void whenUpdateInvoicePaymentOtherEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentOtherEntity invoicePaymentOtherEntity;
			InvoicePaymentOtherEntity updatedInvoicePaymentOtherEntity;
			Optional<InvoicePaymentOtherEntity> fetchedInvoicePaymentOtherEntity;

			try {
				invoicePaymentOtherEntity = invoicePaymentOtherFactory.getObject(false, false);
				invoicePaymentOtherDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentOtherEntity, true, true, false);
				updatedInvoicePaymentOtherEntity = invoicePaymentOtherFactory.getObject(false, false);
				invoicePaymentOtherDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInvoicePaymentOtherEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoicePaymentOtherEntity = invoicePaymentOtherService.create(invoicePaymentOtherEntity);

			updatedInvoicePaymentOtherEntity.setId(invoicePaymentOtherEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInvoicePaymentOtherEntity.setCreated(invoicePaymentOtherEntity.getCreated());

			updatedInvoicePaymentOtherEntity = invoicePaymentOtherService.update(updatedInvoicePaymentOtherEntity);

			fetchedInvoicePaymentOtherEntity = invoicePaymentOtherService.findById(invoicePaymentOtherEntity.getId());

			Assertions.assertTrue(fetchedInvoicePaymentOtherEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInvoicePaymentOtherEntity_ThenEntityIsCreated
			fetchedInvoicePaymentOtherEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInvoicePaymentOtherEntity, fetchedInvoicePaymentOtherEntity.get());
		});
	}

	@Test
	public void whenDeleteInvoicePaymentOtherEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentOtherEntity invoicePaymentOtherEntity;
			Optional<InvoicePaymentOtherEntity> fetchedInvoicePaymentOtherEntity;

			try {
				invoicePaymentOtherEntity = invoicePaymentOtherFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				invoicePaymentOtherDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentOtherEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoicePaymentOtherEntity = invoicePaymentOtherService.create(invoicePaymentOtherEntity);

			invoicePaymentOtherService.deleteById(invoicePaymentOtherEntity.getId());
			fetchedInvoicePaymentOtherEntity = invoicePaymentOtherService.findById(invoicePaymentOtherEntity.getId());

			Assertions.assertTrue(fetchedInvoicePaymentOtherEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
