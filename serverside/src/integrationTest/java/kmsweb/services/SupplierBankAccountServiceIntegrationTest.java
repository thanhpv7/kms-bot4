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
import kmsweb.entities.SupplierBankAccountEntity;
import kmsweb.repositories.SupplierBankAccountRepository;
import kmsweb.utils.SupplierBankAccountFactory;
import kmsweb.utils.DatabasePopulators.SupplierBankAccountDatabasePopulator;
import kmsweb.entities.SupplierEntity;
import kmsweb.repositories.SupplierRepository;
import kmsweb.utils.SupplierFactory;
import kmsweb.utils.DatabasePopulators.SupplierDatabasePopulator;
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
public class SupplierBankAccountServiceIntegrationTest {

	@Autowired
	private SupplierBankAccountRepository supplierBankAccountRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private SupplierBankAccountService supplierBankAccountService;

	private final SupplierBankAccountFactory supplierBankAccountFactory = new SupplierBankAccountFactory();

	@Autowired
	private SupplierBankAccountDatabasePopulator supplierBankAccountDatabasePopulator;

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private SupplierDatabasePopulator supplierDatabasePopulator;

	private final SupplierFactory supplierFactory = new SupplierFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		supplierBankAccountService = new SupplierBankAccountService(
			supplierRepository,
			validator,
			auditRepository,
			supplierBankAccountRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewSupplierBankAccountEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		SupplierBankAccountEntity supplierBankAccountEntity = supplierBankAccountFactory.getObject(false, false);

		SupplierBankAccountEntity updatedEntity = supplierBankAccountService.updateOldData(supplierBankAccountEntity);
		Assertions.assertEquals(supplierBankAccountEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingSupplierBankAccountEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierBankAccountEntity supplierBankAccountEntity;
			SupplierBankAccountEntity entityWithUpdatedValues;

			try {
				supplierBankAccountEntity = supplierBankAccountFactory.getObject(false, false);
				supplierBankAccountDatabasePopulator.populateRelatedEntitiesInDatabase(supplierBankAccountEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = supplierBankAccountFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			supplierBankAccountEntity = supplierBankAccountService.create(supplierBankAccountEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(supplierBankAccountEntity.getId());

			SupplierBankAccountEntity updatedEntity = supplierBankAccountService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithSupplierBankAccountEntityWithNonExistentId_ShouldThrowException() throws Exception {
		SupplierBankAccountEntity supplierBankAccountEntity = supplierBankAccountFactory.getObject(false, false);
		supplierBankAccountEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			supplierBankAccountService.updateOldData(supplierBankAccountEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingSupplierBankAccountEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierBankAccountEntity supplierBankAccountEntity;
			SupplierBankAccountEntity updatedSupplierBankAccountEntity;

			SupplierEntity supplierEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				supplierBankAccountEntity = supplierBankAccountFactory.getObject(true, false);
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
			supplierEntity = supplierBankAccountEntity.getSupplier();
			try {
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(supplierEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			supplierEntity = supplierRepository.save(supplierEntity);
			supplierBankAccountEntity.setSupplierId(supplierEntity.getId());


			supplierBankAccountEntity = supplierBankAccountService.create(supplierBankAccountEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(supplierBankAccountEntity.getSupplier());
			supplierBankAccountEntity.setSupplierId(null);
			supplierBankAccountEntity.unsetSupplier();


			updatedSupplierBankAccountEntity = supplierBankAccountService.updateOldData(supplierBankAccountEntity);

			Assertions.assertNull(updatedSupplierBankAccountEntity.getSupplier());

		});
	}

	@Test
	public void updateOldDataWithSupplierBankAccountEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierBankAccountEntity supplierBankAccountEntity;
			SupplierBankAccountEntity updatedSupplierBankAccountEntity;

			SupplierEntity supplierEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				supplierBankAccountEntity = supplierBankAccountFactory.getObject(true, false);
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
				supplierDatabasePopulator.populateRelatedEntitiesInDatabase(supplierBankAccountEntity.getSupplier(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Supplier relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			supplierEntity = supplierRepository.findById(supplierRepository.save(supplierBankAccountEntity.getSupplier()).getId()).get();
			supplierBankAccountEntity.unsetSupplier();
			supplierBankAccountEntity.setSupplierId(supplierEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedSupplierBankAccountEntity = supplierBankAccountService.updateOldData(supplierBankAccountEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			supplierEntity.unsetSupplierBankAccounts(false);
			updatedSupplierBankAccountEntity.getSupplier().unsetSupplierBankAccounts(false);
			Assertions.assertEquals(supplierEntity, updatedSupplierBankAccountEntity.getSupplier());

		});
	}

	@Test
	public void whenCreateSupplierBankAccountEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierBankAccountEntity supplierBankAccountEntity;
			Optional<SupplierBankAccountEntity> fetchedSupplierBankAccountEntity;

			try {
				supplierBankAccountEntity = supplierBankAccountFactory.getObject(false, false);
				supplierBankAccountDatabasePopulator.populateRelatedEntitiesInDatabase(supplierBankAccountEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			supplierBankAccountEntity = supplierBankAccountService.create(supplierBankAccountEntity);

			fetchedSupplierBankAccountEntity = supplierBankAccountService.findById(supplierBankAccountEntity.getId());

			Assertions.assertTrue(fetchedSupplierBankAccountEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedSupplierBankAccountEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(supplierBankAccountEntity, fetchedSupplierBankAccountEntity.get());
		});
	}

	@Test
	public void whenUpdateSupplierBankAccountEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierBankAccountEntity supplierBankAccountEntity;
			SupplierBankAccountEntity updatedSupplierBankAccountEntity;
			Optional<SupplierBankAccountEntity> fetchedSupplierBankAccountEntity;

			try {
				supplierBankAccountEntity = supplierBankAccountFactory.getObject(false, false);
				supplierBankAccountDatabasePopulator.populateRelatedEntitiesInDatabase(supplierBankAccountEntity, true, true, false);
				updatedSupplierBankAccountEntity = supplierBankAccountFactory.getObject(false, false);
				supplierBankAccountDatabasePopulator.populateRelatedEntitiesInDatabase(updatedSupplierBankAccountEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			supplierBankAccountEntity = supplierBankAccountService.create(supplierBankAccountEntity);

			updatedSupplierBankAccountEntity.setId(supplierBankAccountEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedSupplierBankAccountEntity.setCreated(supplierBankAccountEntity.getCreated());

			updatedSupplierBankAccountEntity = supplierBankAccountService.update(updatedSupplierBankAccountEntity);

			fetchedSupplierBankAccountEntity = supplierBankAccountService.findById(supplierBankAccountEntity.getId());

			Assertions.assertTrue(fetchedSupplierBankAccountEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateSupplierBankAccountEntity_ThenEntityIsCreated
			fetchedSupplierBankAccountEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedSupplierBankAccountEntity, fetchedSupplierBankAccountEntity.get());
		});
	}

	@Test
	public void whenDeleteSupplierBankAccountEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			SupplierBankAccountEntity supplierBankAccountEntity;
			Optional<SupplierBankAccountEntity> fetchedSupplierBankAccountEntity;

			try {
				supplierBankAccountEntity = supplierBankAccountFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				supplierBankAccountDatabasePopulator.populateRelatedEntitiesInDatabase(supplierBankAccountEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			supplierBankAccountEntity = supplierBankAccountService.create(supplierBankAccountEntity);

			supplierBankAccountService.deleteById(supplierBankAccountEntity.getId());
			fetchedSupplierBankAccountEntity = supplierBankAccountService.findById(supplierBankAccountEntity.getId());

			Assertions.assertTrue(fetchedSupplierBankAccountEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
