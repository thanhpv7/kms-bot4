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
import kmsweb.entities.BpjsHealthFacilityEntity;
import kmsweb.repositories.BpjsHealthFacilityRepository;
import kmsweb.utils.BpjsHealthFacilityFactory;
import kmsweb.utils.DatabasePopulators.BpjsHealthFacilityDatabasePopulator;
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.repositories.BpjsClaimSubmissionRepository;
import kmsweb.utils.BpjsClaimSubmissionFactory;
import kmsweb.utils.DatabasePopulators.BpjsClaimSubmissionDatabasePopulator;
import kmsweb.entities.BpjsFacilityListEntity;
import kmsweb.repositories.BpjsFacilityListRepository;
import kmsweb.utils.BpjsFacilityListFactory;
import kmsweb.utils.DatabasePopulators.BpjsFacilityListDatabasePopulator;
import kmsweb.entities.BpjsPatientReferralEntity;
import kmsweb.repositories.BpjsPatientReferralRepository;
import kmsweb.utils.BpjsPatientReferralFactory;
import kmsweb.utils.DatabasePopulators.BpjsPatientReferralDatabasePopulator;
import kmsweb.entities.BpjsReferralSpecialistEntity;
import kmsweb.repositories.BpjsReferralSpecialistRepository;
import kmsweb.utils.BpjsReferralSpecialistFactory;
import kmsweb.utils.DatabasePopulators.BpjsReferralSpecialistDatabasePopulator;
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
public class BpjsHealthFacilityServiceIntegrationTest {

	@Autowired
	private BpjsHealthFacilityRepository bpjsHealthFacilityRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsHealthFacilityService bpjsHealthFacilityService;

	private final BpjsHealthFacilityFactory bpjsHealthFacilityFactory = new BpjsHealthFacilityFactory();

	@Autowired
	private BpjsHealthFacilityDatabasePopulator bpjsHealthFacilityDatabasePopulator;

	@Autowired
	private BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository;

	@Autowired
	private BpjsClaimSubmissionDatabasePopulator bpjsClaimSubmissionDatabasePopulator;

	private final BpjsClaimSubmissionFactory bpjsClaimSubmissionFactory = new BpjsClaimSubmissionFactory();

	@Autowired
	private BpjsFacilityListRepository bpjsFacilityListRepository;

	@Autowired
	private BpjsFacilityListDatabasePopulator bpjsFacilityListDatabasePopulator;

	private final BpjsFacilityListFactory bpjsFacilityListFactory = new BpjsFacilityListFactory();

	@Autowired
	private BpjsPatientReferralRepository bpjsPatientReferralRepository;

	@Autowired
	private BpjsPatientReferralDatabasePopulator bpjsPatientReferralDatabasePopulator;

	private final BpjsPatientReferralFactory bpjsPatientReferralFactory = new BpjsPatientReferralFactory();

	@Autowired
	private BpjsReferralSpecialistRepository bpjsReferralSpecialistRepository;

	@Autowired
	private BpjsReferralSpecialistDatabasePopulator bpjsReferralSpecialistDatabasePopulator;

	private final BpjsReferralSpecialistFactory bpjsReferralSpecialistFactory = new BpjsReferralSpecialistFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsHealthFacilityService = new BpjsHealthFacilityService(
			bpjsClaimSubmissionRepository,
			bpjsFacilityListRepository,
			bpjsPatientReferralRepository,
			bpjsReferralSpecialistRepository,
			validator,
			auditRepository,
			bpjsHealthFacilityRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsHealthFacilityEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsHealthFacilityEntity bpjsHealthFacilityEntity = bpjsHealthFacilityFactory.getObject(false, false);

		BpjsHealthFacilityEntity updatedEntity = bpjsHealthFacilityService.updateOldData(bpjsHealthFacilityEntity);
		Assertions.assertEquals(bpjsHealthFacilityEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsHealthFacilityEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHealthFacilityEntity bpjsHealthFacilityEntity;
			BpjsHealthFacilityEntity entityWithUpdatedValues;

			try {
				bpjsHealthFacilityEntity = bpjsHealthFacilityFactory.getObject(false, false);
				bpjsHealthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHealthFacilityEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsHealthFacilityFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsHealthFacilityEntity = bpjsHealthFacilityService.create(bpjsHealthFacilityEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsHealthFacilityEntity.getId());

			BpjsHealthFacilityEntity updatedEntity = bpjsHealthFacilityService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsHealthFacilityEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsHealthFacilityEntity bpjsHealthFacilityEntity = bpjsHealthFacilityFactory.getObject(false, false);
		bpjsHealthFacilityEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsHealthFacilityService.updateOldData(bpjsHealthFacilityEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsHealthFacilityEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHealthFacilityEntity bpjsHealthFacilityEntity;
			BpjsHealthFacilityEntity updatedBpjsHealthFacilityEntity;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;

			Set<BpjsFacilityListEntity> bpjsFacilityListsEntities;

			Set<BpjsPatientReferralEntity> bpjsPatientReferralsEntities;

			Set<BpjsReferralSpecialistEntity> bpjsReferralSpecialistsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsHealthFacilityEntity = bpjsHealthFacilityFactory.getObject(true, false);
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
			bpjsClaimSubmissionsEntities = bpjsHealthFacilityEntity.getBpjsClaimSubmissions();
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
			bpjsHealthFacilityEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			bpjsFacilityListsEntities = bpjsHealthFacilityEntity.getBpjsFacilityLists();
			Set<UUID> bpjsFacilityListsEntityIds = new HashSet<>();
			for (BpjsFacilityListEntity entity : bpjsFacilityListsEntities) {
				try {
					bpjsFacilityListDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsFacilityListsEntityIds.add(bpjsFacilityListRepository.save(entity).getId());
			}
			bpjsHealthFacilityEntity.setBpjsFacilityListsIds(bpjsFacilityListsEntityIds);

			bpjsPatientReferralsEntities = bpjsHealthFacilityEntity.getBpjsPatientReferrals();
			Set<UUID> bpjsPatientReferralsEntityIds = new HashSet<>();
			for (BpjsPatientReferralEntity entity : bpjsPatientReferralsEntities) {
				try {
					bpjsPatientReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsPatientReferralsEntityIds.add(bpjsPatientReferralRepository.save(entity).getId());
			}
			bpjsHealthFacilityEntity.setBpjsPatientReferralsIds(bpjsPatientReferralsEntityIds);

			bpjsReferralSpecialistsEntities = bpjsHealthFacilityEntity.getBpjsReferralSpecialists();
			Set<UUID> bpjsReferralSpecialistsEntityIds = new HashSet<>();
			for (BpjsReferralSpecialistEntity entity : bpjsReferralSpecialistsEntities) {
				try {
					bpjsReferralSpecialistDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsReferralSpecialistsEntityIds.add(bpjsReferralSpecialistRepository.save(entity).getId());
			}
			bpjsHealthFacilityEntity.setBpjsReferralSpecialistsIds(bpjsReferralSpecialistsEntityIds);


			bpjsHealthFacilityEntity = bpjsHealthFacilityService.create(bpjsHealthFacilityEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(bpjsHealthFacilityEntity.getBpjsClaimSubmissions().size() > 0);
			bpjsHealthFacilityEntity.setBpjsClaimSubmissionsIds(new HashSet<UUID>());
			bpjsHealthFacilityEntity.unsetBpjsClaimSubmissions();

			Assertions.assertTrue(bpjsHealthFacilityEntity.getBpjsFacilityLists().size() > 0);
			bpjsHealthFacilityEntity.setBpjsFacilityListsIds(new HashSet<UUID>());
			bpjsHealthFacilityEntity.unsetBpjsFacilityLists();

			Assertions.assertTrue(bpjsHealthFacilityEntity.getBpjsPatientReferrals().size() > 0);
			bpjsHealthFacilityEntity.setBpjsPatientReferralsIds(new HashSet<UUID>());
			bpjsHealthFacilityEntity.unsetBpjsPatientReferrals();

			Assertions.assertTrue(bpjsHealthFacilityEntity.getBpjsReferralSpecialists().size() > 0);
			bpjsHealthFacilityEntity.setBpjsReferralSpecialistsIds(new HashSet<UUID>());
			bpjsHealthFacilityEntity.unsetBpjsReferralSpecialists();


			updatedBpjsHealthFacilityEntity = bpjsHealthFacilityService.updateOldData(bpjsHealthFacilityEntity);

			Assertions.assertEquals(0, updatedBpjsHealthFacilityEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(0, updatedBpjsHealthFacilityEntity.getBpjsFacilityLists().size());

			Assertions.assertEquals(0, updatedBpjsHealthFacilityEntity.getBpjsPatientReferrals().size());

			Assertions.assertEquals(0, updatedBpjsHealthFacilityEntity.getBpjsReferralSpecialists().size());

		});
	}

	@Test
	public void updateOldDataWithBpjsHealthFacilityEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHealthFacilityEntity bpjsHealthFacilityEntity;
			BpjsHealthFacilityEntity updatedBpjsHealthFacilityEntity;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;
			Set<UUID> bpjsClaimSubmissionsEntityIds;

			Set<BpjsFacilityListEntity> bpjsFacilityListsEntities;
			Set<UUID> bpjsFacilityListsEntityIds;

			Set<BpjsPatientReferralEntity> bpjsPatientReferralsEntities;
			Set<UUID> bpjsPatientReferralsEntityIds;

			Set<BpjsReferralSpecialistEntity> bpjsReferralSpecialistsEntities;
			Set<UUID> bpjsReferralSpecialistsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsHealthFacilityEntity = bpjsHealthFacilityFactory.getObject(true, false);
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
			bpjsClaimSubmissionsEntities = new HashSet<>();
			bpjsClaimSubmissionsEntityIds = new HashSet<>();
			for (BpjsClaimSubmissionEntity entity : bpjsHealthFacilityEntity.getBpjsClaimSubmissions()) {
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
			bpjsHealthFacilityEntity.unsetBpjsClaimSubmissions();
			bpjsHealthFacilityEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			bpjsFacilityListsEntities = new HashSet<>();
			bpjsFacilityListsEntityIds = new HashSet<>();
			for (BpjsFacilityListEntity entity : bpjsHealthFacilityEntity.getBpjsFacilityLists()) {
				try {
					bpjsFacilityListDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Facility Lists relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsFacilityListRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsFacilityListsEntities.add(bpjsFacilityListRepository.findById(id).get());
				bpjsFacilityListsEntityIds.add(id);
			}
			bpjsHealthFacilityEntity.unsetBpjsFacilityLists();
			bpjsHealthFacilityEntity.setBpjsFacilityListsIds(bpjsFacilityListsEntityIds);

			bpjsPatientReferralsEntities = new HashSet<>();
			bpjsPatientReferralsEntityIds = new HashSet<>();
			for (BpjsPatientReferralEntity entity : bpjsHealthFacilityEntity.getBpjsPatientReferrals()) {
				try {
					bpjsPatientReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Patient Referrals relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsPatientReferralRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsPatientReferralsEntities.add(bpjsPatientReferralRepository.findById(id).get());
				bpjsPatientReferralsEntityIds.add(id);
			}
			bpjsHealthFacilityEntity.unsetBpjsPatientReferrals();
			bpjsHealthFacilityEntity.setBpjsPatientReferralsIds(bpjsPatientReferralsEntityIds);

			bpjsReferralSpecialistsEntities = new HashSet<>();
			bpjsReferralSpecialistsEntityIds = new HashSet<>();
			for (BpjsReferralSpecialistEntity entity : bpjsHealthFacilityEntity.getBpjsReferralSpecialists()) {
				try {
					bpjsReferralSpecialistDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Referral Specialists relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsReferralSpecialistRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsReferralSpecialistsEntities.add(bpjsReferralSpecialistRepository.findById(id).get());
				bpjsReferralSpecialistsEntityIds.add(id);
			}
			bpjsHealthFacilityEntity.unsetBpjsReferralSpecialists();
			bpjsHealthFacilityEntity.setBpjsReferralSpecialistsIds(bpjsReferralSpecialistsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsHealthFacilityEntity = bpjsHealthFacilityService.updateOldData(bpjsHealthFacilityEntity);

			Assertions.assertEquals(bpjsClaimSubmissionsEntities.size(), updatedBpjsHealthFacilityEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(bpjsFacilityListsEntities.size(), updatedBpjsHealthFacilityEntity.getBpjsFacilityLists().size());

			Assertions.assertEquals(bpjsPatientReferralsEntities.size(), updatedBpjsHealthFacilityEntity.getBpjsPatientReferrals().size());

			Assertions.assertEquals(bpjsReferralSpecialistsEntities.size(), updatedBpjsHealthFacilityEntity.getBpjsReferralSpecialists().size());

		});
	}

	@Test
	public void whenCreateBpjsHealthFacilityEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHealthFacilityEntity bpjsHealthFacilityEntity;
			Optional<BpjsHealthFacilityEntity> fetchedBpjsHealthFacilityEntity;

			try {
				bpjsHealthFacilityEntity = bpjsHealthFacilityFactory.getObject(false, false);
				bpjsHealthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHealthFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsHealthFacilityEntity = bpjsHealthFacilityService.create(bpjsHealthFacilityEntity);

			fetchedBpjsHealthFacilityEntity = bpjsHealthFacilityService.findById(bpjsHealthFacilityEntity.getId());

			Assertions.assertTrue(fetchedBpjsHealthFacilityEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsHealthFacilityEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsHealthFacilityEntity, fetchedBpjsHealthFacilityEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsHealthFacilityEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHealthFacilityEntity bpjsHealthFacilityEntity;
			BpjsHealthFacilityEntity updatedBpjsHealthFacilityEntity;
			Optional<BpjsHealthFacilityEntity> fetchedBpjsHealthFacilityEntity;

			try {
				bpjsHealthFacilityEntity = bpjsHealthFacilityFactory.getObject(false, false);
				bpjsHealthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHealthFacilityEntity, true, true, false);
				updatedBpjsHealthFacilityEntity = bpjsHealthFacilityFactory.getObject(false, false);
				bpjsHealthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsHealthFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsHealthFacilityEntity = bpjsHealthFacilityService.create(bpjsHealthFacilityEntity);

			updatedBpjsHealthFacilityEntity.setId(bpjsHealthFacilityEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsHealthFacilityEntity.setCreated(bpjsHealthFacilityEntity.getCreated());

			updatedBpjsHealthFacilityEntity = bpjsHealthFacilityService.update(updatedBpjsHealthFacilityEntity);

			fetchedBpjsHealthFacilityEntity = bpjsHealthFacilityService.findById(bpjsHealthFacilityEntity.getId());

			Assertions.assertTrue(fetchedBpjsHealthFacilityEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsHealthFacilityEntity_ThenEntityIsCreated
			fetchedBpjsHealthFacilityEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsHealthFacilityEntity, fetchedBpjsHealthFacilityEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsHealthFacilityEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsHealthFacilityEntity bpjsHealthFacilityEntity;
			Optional<BpjsHealthFacilityEntity> fetchedBpjsHealthFacilityEntity;

			try {
				bpjsHealthFacilityEntity = bpjsHealthFacilityFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsHealthFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsHealthFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsHealthFacilityEntity = bpjsHealthFacilityService.create(bpjsHealthFacilityEntity);

			bpjsHealthFacilityService.deleteById(bpjsHealthFacilityEntity.getId());
			fetchedBpjsHealthFacilityEntity = bpjsHealthFacilityService.findById(bpjsHealthFacilityEntity.getId());

			Assertions.assertTrue(fetchedBpjsHealthFacilityEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
