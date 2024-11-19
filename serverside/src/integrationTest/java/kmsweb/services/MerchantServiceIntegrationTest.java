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
import kmsweb.entities.MerchantEntity;
import kmsweb.repositories.MerchantRepository;
import kmsweb.utils.MerchantFactory;
import kmsweb.utils.DatabasePopulators.MerchantDatabasePopulator;
import kmsweb.entities.CashReceiptEntity;
import kmsweb.repositories.CashReceiptRepository;
import kmsweb.utils.CashReceiptFactory;
import kmsweb.utils.DatabasePopulators.CashReceiptDatabasePopulator;
import kmsweb.entities.MerchantSurchargeAndFeeEntity;
import kmsweb.repositories.MerchantSurchargeAndFeeRepository;
import kmsweb.utils.MerchantSurchargeAndFeeFactory;
import kmsweb.utils.DatabasePopulators.MerchantSurchargeAndFeeDatabasePopulator;
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
public class MerchantServiceIntegrationTest {

	@Autowired
	private MerchantRepository merchantRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MerchantService merchantService;

	private final MerchantFactory merchantFactory = new MerchantFactory();

	@Autowired
	private MerchantDatabasePopulator merchantDatabasePopulator;

	@Autowired
	private CashReceiptRepository cashReceiptRepository;

	@Autowired
	private CashReceiptDatabasePopulator cashReceiptDatabasePopulator;

	private final CashReceiptFactory cashReceiptFactory = new CashReceiptFactory();

	@Autowired
	private MerchantSurchargeAndFeeRepository merchantSurchargeAndFeeRepository;

	@Autowired
	private MerchantSurchargeAndFeeDatabasePopulator merchantSurchargeAndFeeDatabasePopulator;

	private final MerchantSurchargeAndFeeFactory merchantSurchargeAndFeeFactory = new MerchantSurchargeAndFeeFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		merchantService = new MerchantService(
			cashReceiptRepository,
			merchantSurchargeAndFeeRepository,
			validator,
			auditRepository,
			merchantRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMerchantEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MerchantEntity merchantEntity = merchantFactory.getObject(false, false);

		MerchantEntity updatedEntity = merchantService.updateOldData(merchantEntity);
		Assertions.assertEquals(merchantEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingMerchantEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantEntity merchantEntity;
			MerchantEntity entityWithUpdatedValues;

			try {
				merchantEntity = merchantFactory.getObject(false, false);
				merchantDatabasePopulator.populateRelatedEntitiesInDatabase(merchantEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = merchantFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			merchantEntity = merchantService.create(merchantEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(merchantEntity.getId());

			MerchantEntity updatedEntity = merchantService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMerchantEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MerchantEntity merchantEntity = merchantFactory.getObject(false, false);
		merchantEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			merchantService.updateOldData(merchantEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMerchantEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantEntity merchantEntity;
			MerchantEntity updatedMerchantEntity;

			Set<CashReceiptEntity> cashReceiptsEntities;

			Set<MerchantSurchargeAndFeeEntity> merchantSurchargeAndFeesEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				merchantEntity = merchantFactory.getObject(true, false);
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
			cashReceiptsEntities = merchantEntity.getCashReceipts();
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
			merchantEntity.setCashReceiptsIds(cashReceiptsEntityIds);

			merchantSurchargeAndFeesEntities = merchantEntity.getMerchantSurchargeAndFees();
			Set<UUID> merchantSurchargeAndFeesEntityIds = new HashSet<>();
			for (MerchantSurchargeAndFeeEntity entity : merchantSurchargeAndFeesEntities) {
				try {
					merchantSurchargeAndFeeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				merchantSurchargeAndFeesEntityIds.add(merchantSurchargeAndFeeRepository.save(entity).getId());
			}
			merchantEntity.setMerchantSurchargeAndFeesIds(merchantSurchargeAndFeesEntityIds);


			merchantEntity = merchantService.create(merchantEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(merchantEntity.getCashReceipts().size() > 0);
			merchantEntity.setCashReceiptsIds(new HashSet<UUID>());
			merchantEntity.unsetCashReceipts();

			Assertions.assertTrue(merchantEntity.getMerchantSurchargeAndFees().size() > 0);
			merchantEntity.setMerchantSurchargeAndFeesIds(new HashSet<UUID>());
			merchantEntity.unsetMerchantSurchargeAndFees();


			updatedMerchantEntity = merchantService.updateOldData(merchantEntity);

			Assertions.assertEquals(0, updatedMerchantEntity.getCashReceipts().size());

			Assertions.assertEquals(0, updatedMerchantEntity.getMerchantSurchargeAndFees().size());

		});
	}

	@Test
	public void updateOldDataWithMerchantEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantEntity merchantEntity;
			MerchantEntity updatedMerchantEntity;

			Set<CashReceiptEntity> cashReceiptsEntities;
			Set<UUID> cashReceiptsEntityIds;

			Set<MerchantSurchargeAndFeeEntity> merchantSurchargeAndFeesEntities;
			Set<UUID> merchantSurchargeAndFeesEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				merchantEntity = merchantFactory.getObject(true, false);
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
			cashReceiptsEntities = new HashSet<>();
			cashReceiptsEntityIds = new HashSet<>();
			for (CashReceiptEntity entity : merchantEntity.getCashReceipts()) {
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
			merchantEntity.unsetCashReceipts();
			merchantEntity.setCashReceiptsIds(cashReceiptsEntityIds);

			merchantSurchargeAndFeesEntities = new HashSet<>();
			merchantSurchargeAndFeesEntityIds = new HashSet<>();
			for (MerchantSurchargeAndFeeEntity entity : merchantEntity.getMerchantSurchargeAndFees()) {
				try {
					merchantSurchargeAndFeeDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Merchant Surcharge and Fees relation for this test: " + e.getCause());
					return;
				}
				UUID id = merchantSurchargeAndFeeRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				merchantSurchargeAndFeesEntities.add(merchantSurchargeAndFeeRepository.findById(id).get());
				merchantSurchargeAndFeesEntityIds.add(id);
			}
			merchantEntity.unsetMerchantSurchargeAndFees();
			merchantEntity.setMerchantSurchargeAndFeesIds(merchantSurchargeAndFeesEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMerchantEntity = merchantService.updateOldData(merchantEntity);

			Assertions.assertEquals(cashReceiptsEntities.size(), updatedMerchantEntity.getCashReceipts().size());

			Assertions.assertEquals(merchantSurchargeAndFeesEntities.size(), updatedMerchantEntity.getMerchantSurchargeAndFees().size());

		});
	}

	@Test
	public void whenCreateMerchantEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantEntity merchantEntity;
			Optional<MerchantEntity> fetchedMerchantEntity;

			try {
				merchantEntity = merchantFactory.getObject(false, false);
				merchantDatabasePopulator.populateRelatedEntitiesInDatabase(merchantEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			merchantEntity = merchantService.create(merchantEntity);

			fetchedMerchantEntity = merchantService.findById(merchantEntity.getId());

			Assertions.assertTrue(fetchedMerchantEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMerchantEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(merchantEntity, fetchedMerchantEntity.get());
		});
	}

	@Test
	public void whenUpdateMerchantEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantEntity merchantEntity;
			MerchantEntity updatedMerchantEntity;
			Optional<MerchantEntity> fetchedMerchantEntity;

			try {
				merchantEntity = merchantFactory.getObject(false, false);
				merchantDatabasePopulator.populateRelatedEntitiesInDatabase(merchantEntity, true, true, false);
				updatedMerchantEntity = merchantFactory.getObject(false, false);
				merchantDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMerchantEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			merchantEntity = merchantService.create(merchantEntity);

			updatedMerchantEntity.setId(merchantEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMerchantEntity.setCreated(merchantEntity.getCreated());

			updatedMerchantEntity = merchantService.update(updatedMerchantEntity);

			fetchedMerchantEntity = merchantService.findById(merchantEntity.getId());

			Assertions.assertTrue(fetchedMerchantEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMerchantEntity_ThenEntityIsCreated
			fetchedMerchantEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMerchantEntity, fetchedMerchantEntity.get());
		});
	}

	@Test
	public void whenDeleteMerchantEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MerchantEntity merchantEntity;
			Optional<MerchantEntity> fetchedMerchantEntity;

			try {
				merchantEntity = merchantFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				merchantDatabasePopulator.populateRelatedEntitiesInDatabase(merchantEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			merchantEntity = merchantService.create(merchantEntity);

			merchantService.deleteById(merchantEntity.getId());
			fetchedMerchantEntity = merchantService.findById(merchantEntity.getId());

			Assertions.assertTrue(fetchedMerchantEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
