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
import kmsweb.entities.InvoicePaymentInsuranceEntity;
import kmsweb.repositories.InvoicePaymentInsuranceRepository;
import kmsweb.utils.InvoicePaymentInsuranceFactory;
import kmsweb.utils.DatabasePopulators.InvoicePaymentInsuranceDatabasePopulator;
import kmsweb.entities.InsuranceBenefitPlanEntity;
import kmsweb.repositories.InsuranceBenefitPlanRepository;
import kmsweb.utils.InsuranceBenefitPlanFactory;
import kmsweb.utils.DatabasePopulators.InsuranceBenefitPlanDatabasePopulator;
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
public class InvoicePaymentInsuranceServiceIntegrationTest {

	@Autowired
	private InvoicePaymentInsuranceRepository invoicePaymentInsuranceRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private InvoicePaymentInsuranceService invoicePaymentInsuranceService;

	private final InvoicePaymentInsuranceFactory invoicePaymentInsuranceFactory = new InvoicePaymentInsuranceFactory();

	@Autowired
	private InvoicePaymentInsuranceDatabasePopulator invoicePaymentInsuranceDatabasePopulator;

	@Autowired
	private InsuranceBenefitPlanRepository insuranceBenefitPlanRepository;

	@Autowired
	private InsuranceBenefitPlanDatabasePopulator insuranceBenefitPlanDatabasePopulator;

	private final InsuranceBenefitPlanFactory insuranceBenefitPlanFactory = new InsuranceBenefitPlanFactory();

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
		invoicePaymentInsuranceService = new InvoicePaymentInsuranceService(
			insuranceBenefitPlanRepository,
			invoiceRepository,
			validator,
			auditRepository,
			invoicePaymentInsuranceRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewInvoicePaymentInsuranceEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntity = invoicePaymentInsuranceFactory.getObject(false, false);

		InvoicePaymentInsuranceEntity updatedEntity = invoicePaymentInsuranceService.updateOldData(invoicePaymentInsuranceEntity);
		Assertions.assertEquals(invoicePaymentInsuranceEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewInvoicePaymentInsuranceEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntity = invoicePaymentInsuranceFactory.getObject(false, false);

		invoicePaymentInsuranceEntity.setMainInsurance(null);
		Assertions.assertNull(invoicePaymentInsuranceEntity.getMainInsurance());


		InvoicePaymentInsuranceEntity updatedEntity = invoicePaymentInsuranceService.updateOldData(invoicePaymentInsuranceEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getMainInsurance());
		Assertions.assertFalse(updatedEntity.getMainInsurance());

	}

	@Test
	public void updateOldDataWithExistingInvoicePaymentInsuranceEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntity;
			InvoicePaymentInsuranceEntity entityWithUpdatedValues;

			try {
				invoicePaymentInsuranceEntity = invoicePaymentInsuranceFactory.getObject(false, false);
				invoicePaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentInsuranceEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = invoicePaymentInsuranceFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoicePaymentInsuranceEntity = invoicePaymentInsuranceService.create(invoicePaymentInsuranceEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(invoicePaymentInsuranceEntity.getId());

			InvoicePaymentInsuranceEntity updatedEntity = invoicePaymentInsuranceService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithInvoicePaymentInsuranceEntityWithNonExistentId_ShouldThrowException() throws Exception {
		InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntity = invoicePaymentInsuranceFactory.getObject(false, false);
		invoicePaymentInsuranceEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			invoicePaymentInsuranceService.updateOldData(invoicePaymentInsuranceEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingInvoicePaymentInsuranceEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntity;
			InvoicePaymentInsuranceEntity updatedInvoicePaymentInsuranceEntity;

			InsuranceBenefitPlanEntity insuranceBenefitPlanEntity;

			InvoiceEntity invoiceEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				invoicePaymentInsuranceEntity = invoicePaymentInsuranceFactory.getObject(true, false);
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
			insuranceBenefitPlanEntity = invoicePaymentInsuranceEntity.getInsuranceBenefitPlan();
			try {
				insuranceBenefitPlanDatabasePopulator.populateRelatedEntitiesInDatabase(insuranceBenefitPlanEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			insuranceBenefitPlanEntity = insuranceBenefitPlanRepository.save(insuranceBenefitPlanEntity);
			invoicePaymentInsuranceEntity.setInsuranceBenefitPlanId(insuranceBenefitPlanEntity.getId());

			invoiceEntity = invoicePaymentInsuranceEntity.getInvoice();
			try {
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoiceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			invoiceEntity = invoiceRepository.save(invoiceEntity);
			invoicePaymentInsuranceEntity.setInvoiceId(invoiceEntity.getId());


			invoicePaymentInsuranceEntity = invoicePaymentInsuranceService.create(invoicePaymentInsuranceEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(invoicePaymentInsuranceEntity.getInsuranceBenefitPlan());
			invoicePaymentInsuranceEntity.setInsuranceBenefitPlanId(null);
			invoicePaymentInsuranceEntity.unsetInsuranceBenefitPlan();

			Assertions.assertNotNull(invoicePaymentInsuranceEntity.getInvoice());
			invoicePaymentInsuranceEntity.setInvoiceId(null);
			invoicePaymentInsuranceEntity.unsetInvoice();


			updatedInvoicePaymentInsuranceEntity = invoicePaymentInsuranceService.updateOldData(invoicePaymentInsuranceEntity);

			Assertions.assertNull(updatedInvoicePaymentInsuranceEntity.getInsuranceBenefitPlan());

			Assertions.assertNull(updatedInvoicePaymentInsuranceEntity.getInvoice());

		});
	}

	@Test
	public void updateOldDataWithInvoicePaymentInsuranceEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntity;
			InvoicePaymentInsuranceEntity updatedInvoicePaymentInsuranceEntity;

			InsuranceBenefitPlanEntity insuranceBenefitPlanEntity;

			InvoiceEntity invoiceEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				invoicePaymentInsuranceEntity = invoicePaymentInsuranceFactory.getObject(true, false);
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
				insuranceBenefitPlanDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentInsuranceEntity.getInsuranceBenefitPlan(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Insurance Benefit Plan relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			insuranceBenefitPlanEntity = insuranceBenefitPlanRepository.findById(insuranceBenefitPlanRepository.save(invoicePaymentInsuranceEntity.getInsuranceBenefitPlan()).getId()).get();
			invoicePaymentInsuranceEntity.unsetInsuranceBenefitPlan();
			invoicePaymentInsuranceEntity.setInsuranceBenefitPlanId(insuranceBenefitPlanEntity.getId());

			try {
				invoiceDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentInsuranceEntity.getInvoice(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Invoice relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			invoiceEntity = invoiceRepository.findById(invoiceRepository.save(invoicePaymentInsuranceEntity.getInvoice()).getId()).get();
			invoicePaymentInsuranceEntity.unsetInvoice();
			invoicePaymentInsuranceEntity.setInvoiceId(invoiceEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedInvoicePaymentInsuranceEntity = invoicePaymentInsuranceService.updateOldData(invoicePaymentInsuranceEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			insuranceBenefitPlanEntity.unsetInvoicePaymentInsurances(false);
			updatedInvoicePaymentInsuranceEntity.getInsuranceBenefitPlan().unsetInvoicePaymentInsurances(false);
			Assertions.assertEquals(insuranceBenefitPlanEntity, updatedInvoicePaymentInsuranceEntity.getInsuranceBenefitPlan());

			invoiceEntity.unsetInvoicePaymentInsurances(false);
			updatedInvoicePaymentInsuranceEntity.getInvoice().unsetInvoicePaymentInsurances(false);
			Assertions.assertEquals(invoiceEntity, updatedInvoicePaymentInsuranceEntity.getInvoice());

		});
	}

	@Test
	public void whenCreateInvoicePaymentInsuranceEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntity;
			Optional<InvoicePaymentInsuranceEntity> fetchedInvoicePaymentInsuranceEntity;

			try {
				invoicePaymentInsuranceEntity = invoicePaymentInsuranceFactory.getObject(false, false);
				invoicePaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentInsuranceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoicePaymentInsuranceEntity = invoicePaymentInsuranceService.create(invoicePaymentInsuranceEntity);

			fetchedInvoicePaymentInsuranceEntity = invoicePaymentInsuranceService.findById(invoicePaymentInsuranceEntity.getId());

			Assertions.assertTrue(fetchedInvoicePaymentInsuranceEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedInvoicePaymentInsuranceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(invoicePaymentInsuranceEntity, fetchedInvoicePaymentInsuranceEntity.get());
		});
	}

	@Test
	public void whenUpdateInvoicePaymentInsuranceEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntity;
			InvoicePaymentInsuranceEntity updatedInvoicePaymentInsuranceEntity;
			Optional<InvoicePaymentInsuranceEntity> fetchedInvoicePaymentInsuranceEntity;

			try {
				invoicePaymentInsuranceEntity = invoicePaymentInsuranceFactory.getObject(false, false);
				invoicePaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentInsuranceEntity, true, true, false);
				updatedInvoicePaymentInsuranceEntity = invoicePaymentInsuranceFactory.getObject(false, false);
				invoicePaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(updatedInvoicePaymentInsuranceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoicePaymentInsuranceEntity = invoicePaymentInsuranceService.create(invoicePaymentInsuranceEntity);

			updatedInvoicePaymentInsuranceEntity.setId(invoicePaymentInsuranceEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedInvoicePaymentInsuranceEntity.setCreated(invoicePaymentInsuranceEntity.getCreated());

			updatedInvoicePaymentInsuranceEntity = invoicePaymentInsuranceService.update(updatedInvoicePaymentInsuranceEntity);

			fetchedInvoicePaymentInsuranceEntity = invoicePaymentInsuranceService.findById(invoicePaymentInsuranceEntity.getId());

			Assertions.assertTrue(fetchedInvoicePaymentInsuranceEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateInvoicePaymentInsuranceEntity_ThenEntityIsCreated
			fetchedInvoicePaymentInsuranceEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedInvoicePaymentInsuranceEntity, fetchedInvoicePaymentInsuranceEntity.get());
		});
	}

	@Test
	public void whenDeleteInvoicePaymentInsuranceEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			InvoicePaymentInsuranceEntity invoicePaymentInsuranceEntity;
			Optional<InvoicePaymentInsuranceEntity> fetchedInvoicePaymentInsuranceEntity;

			try {
				invoicePaymentInsuranceEntity = invoicePaymentInsuranceFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				invoicePaymentInsuranceDatabasePopulator.populateRelatedEntitiesInDatabase(invoicePaymentInsuranceEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			invoicePaymentInsuranceEntity = invoicePaymentInsuranceService.create(invoicePaymentInsuranceEntity);

			invoicePaymentInsuranceService.deleteById(invoicePaymentInsuranceEntity.getId());
			fetchedInvoicePaymentInsuranceEntity = invoicePaymentInsuranceService.findById(invoicePaymentInsuranceEntity.getId());

			Assertions.assertTrue(fetchedInvoicePaymentInsuranceEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
