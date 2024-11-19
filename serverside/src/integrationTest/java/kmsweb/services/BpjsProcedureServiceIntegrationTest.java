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
import kmsweb.entities.BpjsProcedureEntity;
import kmsweb.repositories.BpjsProcedureRepository;
import kmsweb.utils.BpjsProcedureFactory;
import kmsweb.utils.DatabasePopulators.BpjsProcedureDatabasePopulator;
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.repositories.BpjsClaimSubmissionRepository;
import kmsweb.utils.BpjsClaimSubmissionFactory;
import kmsweb.utils.DatabasePopulators.BpjsClaimSubmissionDatabasePopulator;
import kmsweb.entities.BpjsSpecialReferralEntity;
import kmsweb.repositories.BpjsSpecialReferralRepository;
import kmsweb.utils.BpjsSpecialReferralFactory;
import kmsweb.utils.DatabasePopulators.BpjsSpecialReferralDatabasePopulator;
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
public class BpjsProcedureServiceIntegrationTest {

	@Autowired
	private BpjsProcedureRepository bpjsProcedureRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsProcedureService bpjsProcedureService;

	private final BpjsProcedureFactory bpjsProcedureFactory = new BpjsProcedureFactory();

	@Autowired
	private BpjsProcedureDatabasePopulator bpjsProcedureDatabasePopulator;

	@Autowired
	private BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository;

	@Autowired
	private BpjsClaimSubmissionDatabasePopulator bpjsClaimSubmissionDatabasePopulator;

	private final BpjsClaimSubmissionFactory bpjsClaimSubmissionFactory = new BpjsClaimSubmissionFactory();

	@Autowired
	private BpjsSpecialReferralRepository bpjsSpecialReferralRepository;

	@Autowired
	private BpjsSpecialReferralDatabasePopulator bpjsSpecialReferralDatabasePopulator;

	private final BpjsSpecialReferralFactory bpjsSpecialReferralFactory = new BpjsSpecialReferralFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsProcedureService = new BpjsProcedureService(
			bpjsClaimSubmissionRepository,
			bpjsSpecialReferralRepository,
			validator,
			auditRepository,
			bpjsProcedureRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsProcedureEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsProcedureEntity bpjsProcedureEntity = bpjsProcedureFactory.getObject(false, false);

		BpjsProcedureEntity updatedEntity = bpjsProcedureService.updateOldData(bpjsProcedureEntity);
		Assertions.assertEquals(bpjsProcedureEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsProcedureEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsProcedureEntity bpjsProcedureEntity;
			BpjsProcedureEntity entityWithUpdatedValues;

			try {
				bpjsProcedureEntity = bpjsProcedureFactory.getObject(false, false);
				bpjsProcedureDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsProcedureEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsProcedureFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsProcedureEntity = bpjsProcedureService.create(bpjsProcedureEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsProcedureEntity.getId());

			BpjsProcedureEntity updatedEntity = bpjsProcedureService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsProcedureEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsProcedureEntity bpjsProcedureEntity = bpjsProcedureFactory.getObject(false, false);
		bpjsProcedureEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsProcedureService.updateOldData(bpjsProcedureEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsProcedureEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsProcedureEntity bpjsProcedureEntity;
			BpjsProcedureEntity updatedBpjsProcedureEntity;

			Set<BpjsSpecialReferralEntity> additionalProcedureEntities;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;

			Set<BpjsSpecialReferralEntity> primaryProcedureEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsProcedureEntity = bpjsProcedureFactory.getObject(true, false);
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
			additionalProcedureEntities = bpjsProcedureEntity.getAdditionalProcedure();
			Set<UUID> additionalProcedureEntityIds = new HashSet<>();
			for (BpjsSpecialReferralEntity entity : additionalProcedureEntities) {
				try {
					bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				additionalProcedureEntityIds.add(bpjsSpecialReferralRepository.save(entity).getId());
			}
			bpjsProcedureEntity.setAdditionalProcedureIds(additionalProcedureEntityIds);

			bpjsClaimSubmissionsEntities = bpjsProcedureEntity.getBpjsClaimSubmissions();
			Set<UUID> bpjsClaimSubmissionsEntityIds = new HashSet<>();
			for (BpjsClaimSubmissionEntity entity : bpjsClaimSubmissionsEntities) {
				try {
					bpjsClaimSubmissionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsClaimSubmissionsEntityIds.add(bpjsClaimSubmissionRepository.save(entity).getId());
			}
			bpjsProcedureEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			primaryProcedureEntities = bpjsProcedureEntity.getPrimaryProcedure();
			Set<UUID> primaryProcedureEntityIds = new HashSet<>();
			for (BpjsSpecialReferralEntity entity : primaryProcedureEntities) {
				try {
					bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				primaryProcedureEntityIds.add(bpjsSpecialReferralRepository.save(entity).getId());
			}
			bpjsProcedureEntity.setPrimaryProcedureIds(primaryProcedureEntityIds);


			bpjsProcedureEntity = bpjsProcedureService.create(bpjsProcedureEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(bpjsProcedureEntity.getAdditionalProcedure().size() > 0);
			bpjsProcedureEntity.setAdditionalProcedureIds(new HashSet<UUID>());
			bpjsProcedureEntity.unsetAdditionalProcedure();

			Assertions.assertTrue(bpjsProcedureEntity.getBpjsClaimSubmissions().size() > 0);
			bpjsProcedureEntity.setBpjsClaimSubmissionsIds(new HashSet<UUID>());
			bpjsProcedureEntity.unsetBpjsClaimSubmissions();

			Assertions.assertTrue(bpjsProcedureEntity.getPrimaryProcedure().size() > 0);
			bpjsProcedureEntity.setPrimaryProcedureIds(new HashSet<UUID>());
			bpjsProcedureEntity.unsetPrimaryProcedure();


			updatedBpjsProcedureEntity = bpjsProcedureService.updateOldData(bpjsProcedureEntity);

			Assertions.assertEquals(0, updatedBpjsProcedureEntity.getAdditionalProcedure().size());

			Assertions.assertEquals(0, updatedBpjsProcedureEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(0, updatedBpjsProcedureEntity.getPrimaryProcedure().size());

		});
	}

	@Test
	public void updateOldDataWithBpjsProcedureEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsProcedureEntity bpjsProcedureEntity;
			BpjsProcedureEntity updatedBpjsProcedureEntity;

			Set<BpjsSpecialReferralEntity> additionalProcedureEntities;
			Set<UUID> additionalProcedureEntityIds;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;
			Set<UUID> bpjsClaimSubmissionsEntityIds;

			Set<BpjsSpecialReferralEntity> primaryProcedureEntities;
			Set<UUID> primaryProcedureEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsProcedureEntity = bpjsProcedureFactory.getObject(true, false);
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
			additionalProcedureEntities = new HashSet<>();
			additionalProcedureEntityIds = new HashSet<>();
			for (BpjsSpecialReferralEntity entity : bpjsProcedureEntity.getAdditionalProcedure()) {
				try {
					bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Additional Procedure relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsSpecialReferralRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				additionalProcedureEntities.add(bpjsSpecialReferralRepository.findById(id).get());
				additionalProcedureEntityIds.add(id);
			}
			bpjsProcedureEntity.unsetAdditionalProcedure();
			bpjsProcedureEntity.setAdditionalProcedureIds(additionalProcedureEntityIds);

			bpjsClaimSubmissionsEntities = new HashSet<>();
			bpjsClaimSubmissionsEntityIds = new HashSet<>();
			for (BpjsClaimSubmissionEntity entity : bpjsProcedureEntity.getBpjsClaimSubmissions()) {
				try {
					bpjsClaimSubmissionDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Claim Submissions relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsClaimSubmissionRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsClaimSubmissionsEntities.add(bpjsClaimSubmissionRepository.findById(id).get());
				bpjsClaimSubmissionsEntityIds.add(id);
			}
			bpjsProcedureEntity.unsetBpjsClaimSubmissions();
			bpjsProcedureEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			primaryProcedureEntities = new HashSet<>();
			primaryProcedureEntityIds = new HashSet<>();
			for (BpjsSpecialReferralEntity entity : bpjsProcedureEntity.getPrimaryProcedure()) {
				try {
					bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Primary Procedure relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsSpecialReferralRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				primaryProcedureEntities.add(bpjsSpecialReferralRepository.findById(id).get());
				primaryProcedureEntityIds.add(id);
			}
			bpjsProcedureEntity.unsetPrimaryProcedure();
			bpjsProcedureEntity.setPrimaryProcedureIds(primaryProcedureEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsProcedureEntity = bpjsProcedureService.updateOldData(bpjsProcedureEntity);

			Assertions.assertEquals(additionalProcedureEntities.size(), updatedBpjsProcedureEntity.getAdditionalProcedure().size());

			Assertions.assertEquals(bpjsClaimSubmissionsEntities.size(), updatedBpjsProcedureEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(primaryProcedureEntities.size(), updatedBpjsProcedureEntity.getPrimaryProcedure().size());

		});
	}

	@Test
	public void whenCreateBpjsProcedureEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsProcedureEntity bpjsProcedureEntity;
			Optional<BpjsProcedureEntity> fetchedBpjsProcedureEntity;

			try {
				bpjsProcedureEntity = bpjsProcedureFactory.getObject(false, false);
				bpjsProcedureDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsProcedureEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsProcedureEntity = bpjsProcedureService.create(bpjsProcedureEntity);

			fetchedBpjsProcedureEntity = bpjsProcedureService.findById(bpjsProcedureEntity.getId());

			Assertions.assertTrue(fetchedBpjsProcedureEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsProcedureEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsProcedureEntity, fetchedBpjsProcedureEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsProcedureEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsProcedureEntity bpjsProcedureEntity;
			BpjsProcedureEntity updatedBpjsProcedureEntity;
			Optional<BpjsProcedureEntity> fetchedBpjsProcedureEntity;

			try {
				bpjsProcedureEntity = bpjsProcedureFactory.getObject(false, false);
				bpjsProcedureDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsProcedureEntity, true, true, false);
				updatedBpjsProcedureEntity = bpjsProcedureFactory.getObject(false, false);
				bpjsProcedureDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsProcedureEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsProcedureEntity = bpjsProcedureService.create(bpjsProcedureEntity);

			updatedBpjsProcedureEntity.setId(bpjsProcedureEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsProcedureEntity.setCreated(bpjsProcedureEntity.getCreated());

			updatedBpjsProcedureEntity = bpjsProcedureService.update(updatedBpjsProcedureEntity);

			fetchedBpjsProcedureEntity = bpjsProcedureService.findById(bpjsProcedureEntity.getId());

			Assertions.assertTrue(fetchedBpjsProcedureEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsProcedureEntity_ThenEntityIsCreated
			fetchedBpjsProcedureEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsProcedureEntity, fetchedBpjsProcedureEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsProcedureEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsProcedureEntity bpjsProcedureEntity;
			Optional<BpjsProcedureEntity> fetchedBpjsProcedureEntity;

			try {
				bpjsProcedureEntity = bpjsProcedureFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsProcedureDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsProcedureEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsProcedureEntity = bpjsProcedureService.create(bpjsProcedureEntity);

			bpjsProcedureService.deleteById(bpjsProcedureEntity.getId());
			fetchedBpjsProcedureEntity = bpjsProcedureService.findById(bpjsProcedureEntity.getId());

			Assertions.assertTrue(fetchedBpjsProcedureEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
