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
import kmsweb.entities.MerchantSurchargeAndFeeEntity;
import kmsweb.repositories.MerchantSurchargeAndFeeRepository;
import kmsweb.utils.MerchantSurchargeAndFeeFactory;
import kmsweb.utils.DatabasePopulators.MerchantSurchargeAndFeeDatabasePopulator;
import kmsweb.entities.MerchantEntity;
import kmsweb.repositories.MerchantRepository;
import kmsweb.utils.MerchantFactory;
import kmsweb.utils.DatabasePopulators.MerchantDatabasePopulator;
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
public class MerchantSurchargeAndFeeServiceIntegrationTest {

	@Autowired
	private MerchantSurchargeAndFeeRepository merchantSurchargeAndFeeRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MerchantSurchargeAndFeeService merchantSurchargeAndFeeService;

	private final MerchantSurchargeAndFeeFactory merchantSurchargeAndFeeFactory = new MerchantSurchargeAndFeeFactory();

	@Autowired
	private MerchantSurchargeAndFeeDatabasePopulator merchantSurchargeAndFeeDatabasePopulator;

	@Autowired
	private MerchantRepository merchantRepository;

	@Autowired
	private MerchantDatabasePopulator merchantDatabasePopulator;

	private final MerchantFactory merchantFactory = new MerchantFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		merchantSurchargeAndFeeService = new MerchantSurchargeAndFeeService(
			merchantRepository,
			validator,
			auditRepository,
			merchantSurchargeAndFeeRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMerchantSurchargeAndFeeEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MerchantSurchargeAndFeeEntity merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeFactory.getObject(false, false);

		MerchantSurchargeAndFeeEntity updatedEntity = merchantSurchargeAndFeeService.updateOldData(merchantSurchargeAndFeeEntity);
		Assertions.assertEquals(merchantSurchargeAndFeeEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingMerchantSurchargeAndFeeEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantSurchargeAndFeeEntity merchantSurchargeAndFeeEntity;
			MerchantSurchargeAndFeeEntity entityWithUpdatedValues;

			try {
				merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeFactory.getObject(false, false);
				merchantSurchargeAndFeeDatabasePopulator.populateRelatedEntitiesInDatabase(merchantSurchargeAndFeeEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = merchantSurchargeAndFeeFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeService.create(merchantSurchargeAndFeeEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(merchantSurchargeAndFeeEntity.getId());

			MerchantSurchargeAndFeeEntity updatedEntity = merchantSurchargeAndFeeService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMerchantSurchargeAndFeeEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MerchantSurchargeAndFeeEntity merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeFactory.getObject(false, false);
		merchantSurchargeAndFeeEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			merchantSurchargeAndFeeService.updateOldData(merchantSurchargeAndFeeEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMerchantSurchargeAndFeeEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantSurchargeAndFeeEntity merchantSurchargeAndFeeEntity;
			MerchantSurchargeAndFeeEntity updatedMerchantSurchargeAndFeeEntity;

			MerchantEntity merchantEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeFactory.getObject(true, false);
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
			merchantEntity = merchantSurchargeAndFeeEntity.getMerchant();
			try {
				merchantDatabasePopulator.populateRelatedEntitiesInDatabase(merchantEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			merchantEntity = merchantRepository.save(merchantEntity);
			merchantSurchargeAndFeeEntity.setMerchantId(merchantEntity.getId());


			merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeService.create(merchantSurchargeAndFeeEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(merchantSurchargeAndFeeEntity.getMerchant());
			merchantSurchargeAndFeeEntity.setMerchantId(null);
			merchantSurchargeAndFeeEntity.unsetMerchant();


			updatedMerchantSurchargeAndFeeEntity = merchantSurchargeAndFeeService.updateOldData(merchantSurchargeAndFeeEntity);

			Assertions.assertNull(updatedMerchantSurchargeAndFeeEntity.getMerchant());

		});
	}

	@Test
	public void updateOldDataWithMerchantSurchargeAndFeeEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantSurchargeAndFeeEntity merchantSurchargeAndFeeEntity;
			MerchantSurchargeAndFeeEntity updatedMerchantSurchargeAndFeeEntity;

			MerchantEntity merchantEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeFactory.getObject(true, false);
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
				merchantDatabasePopulator.populateRelatedEntitiesInDatabase(merchantSurchargeAndFeeEntity.getMerchant(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Merchant relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			merchantEntity = merchantRepository.findById(merchantRepository.save(merchantSurchargeAndFeeEntity.getMerchant()).getId()).get();
			merchantSurchargeAndFeeEntity.unsetMerchant();
			merchantSurchargeAndFeeEntity.setMerchantId(merchantEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMerchantSurchargeAndFeeEntity = merchantSurchargeAndFeeService.updateOldData(merchantSurchargeAndFeeEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			merchantEntity.unsetMerchantSurchargeAndFees(false);
			updatedMerchantSurchargeAndFeeEntity.getMerchant().unsetMerchantSurchargeAndFees(false);
			Assertions.assertEquals(merchantEntity, updatedMerchantSurchargeAndFeeEntity.getMerchant());

		});
	}

	@Test
	public void whenCreateMerchantSurchargeAndFeeEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantSurchargeAndFeeEntity merchantSurchargeAndFeeEntity;
			Optional<MerchantSurchargeAndFeeEntity> fetchedMerchantSurchargeAndFeeEntity;

			try {
				merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeFactory.getObject(false, false);
				merchantSurchargeAndFeeDatabasePopulator.populateRelatedEntitiesInDatabase(merchantSurchargeAndFeeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeService.create(merchantSurchargeAndFeeEntity);

			fetchedMerchantSurchargeAndFeeEntity = merchantSurchargeAndFeeService.findById(merchantSurchargeAndFeeEntity.getId());

			Assertions.assertTrue(fetchedMerchantSurchargeAndFeeEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMerchantSurchargeAndFeeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(merchantSurchargeAndFeeEntity, fetchedMerchantSurchargeAndFeeEntity.get());
		});
	}

	@Test
	public void whenUpdateMerchantSurchargeAndFeeEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantSurchargeAndFeeEntity merchantSurchargeAndFeeEntity;
			MerchantSurchargeAndFeeEntity updatedMerchantSurchargeAndFeeEntity;
			Optional<MerchantSurchargeAndFeeEntity> fetchedMerchantSurchargeAndFeeEntity;

			try {
				merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeFactory.getObject(false, false);
				merchantSurchargeAndFeeDatabasePopulator.populateRelatedEntitiesInDatabase(merchantSurchargeAndFeeEntity, true, true, false);
				updatedMerchantSurchargeAndFeeEntity = merchantSurchargeAndFeeFactory.getObject(false, false);
				merchantSurchargeAndFeeDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMerchantSurchargeAndFeeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeService.create(merchantSurchargeAndFeeEntity);

			updatedMerchantSurchargeAndFeeEntity.setId(merchantSurchargeAndFeeEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMerchantSurchargeAndFeeEntity.setCreated(merchantSurchargeAndFeeEntity.getCreated());

			updatedMerchantSurchargeAndFeeEntity = merchantSurchargeAndFeeService.update(updatedMerchantSurchargeAndFeeEntity);

			fetchedMerchantSurchargeAndFeeEntity = merchantSurchargeAndFeeService.findById(merchantSurchargeAndFeeEntity.getId());

			Assertions.assertTrue(fetchedMerchantSurchargeAndFeeEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMerchantSurchargeAndFeeEntity_ThenEntityIsCreated
			fetchedMerchantSurchargeAndFeeEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMerchantSurchargeAndFeeEntity, fetchedMerchantSurchargeAndFeeEntity.get());
		});
	}

	@Test
	public void whenDeleteMerchantSurchargeAndFeeEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantSurchargeAndFeeEntity merchantSurchargeAndFeeEntity;
			Optional<MerchantSurchargeAndFeeEntity> fetchedMerchantSurchargeAndFeeEntity;

			try {
				merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				merchantSurchargeAndFeeDatabasePopulator.populateRelatedEntitiesInDatabase(merchantSurchargeAndFeeEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			merchantSurchargeAndFeeEntity = merchantSurchargeAndFeeService.create(merchantSurchargeAndFeeEntity);

			merchantSurchargeAndFeeService.deleteById(merchantSurchargeAndFeeEntity.getId());
			fetchedMerchantSurchargeAndFeeEntity = merchantSurchargeAndFeeService.findById(merchantSurchargeAndFeeEntity.getId());

			Assertions.assertTrue(fetchedMerchantSurchargeAndFeeEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
