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
import kmsweb.entities.BpjsDoctorMappingEntity;
import kmsweb.repositories.BpjsDoctorMappingRepository;
import kmsweb.utils.BpjsDoctorMappingFactory;
import kmsweb.utils.DatabasePopulators.BpjsDoctorMappingDatabasePopulator;
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.repositories.BpjsClaimSubmissionRepository;
import kmsweb.utils.BpjsClaimSubmissionFactory;
import kmsweb.utils.DatabasePopulators.BpjsClaimSubmissionDatabasePopulator;
import kmsweb.entities.BpjsControlPlanEntity;
import kmsweb.repositories.BpjsControlPlanRepository;
import kmsweb.utils.BpjsControlPlanFactory;
import kmsweb.utils.DatabasePopulators.BpjsControlPlanDatabasePopulator;
import kmsweb.entities.BpjsHospitalizationPlanEntity;
import kmsweb.repositories.BpjsHospitalizationPlanRepository;
import kmsweb.utils.BpjsHospitalizationPlanFactory;
import kmsweb.utils.DatabasePopulators.BpjsHospitalizationPlanDatabasePopulator;
import kmsweb.entities.BpjsPRBEntity;
import kmsweb.repositories.BpjsPRBRepository;
import kmsweb.utils.BpjsPRBFactory;
import kmsweb.utils.DatabasePopulators.BpjsPRBDatabasePopulator;
import kmsweb.entities.StaffEntity;
import kmsweb.repositories.StaffRepository;
import kmsweb.utils.StaffFactory;
import kmsweb.utils.DatabasePopulators.StaffDatabasePopulator;
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
public class BpjsDoctorMappingServiceIntegrationTest {

	@Autowired
	private BpjsDoctorMappingRepository bpjsDoctorMappingRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsDoctorMappingService bpjsDoctorMappingService;

	private final BpjsDoctorMappingFactory bpjsDoctorMappingFactory = new BpjsDoctorMappingFactory();

	@Autowired
	private BpjsDoctorMappingDatabasePopulator bpjsDoctorMappingDatabasePopulator;

	@Autowired
	private BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository;

	@Autowired
	private BpjsClaimSubmissionDatabasePopulator bpjsClaimSubmissionDatabasePopulator;

	private final BpjsClaimSubmissionFactory bpjsClaimSubmissionFactory = new BpjsClaimSubmissionFactory();

	@Autowired
	private BpjsControlPlanRepository bpjsControlPlanRepository;

	@Autowired
	private BpjsControlPlanDatabasePopulator bpjsControlPlanDatabasePopulator;

	private final BpjsControlPlanFactory bpjsControlPlanFactory = new BpjsControlPlanFactory();

	@Autowired
	private BpjsHospitalizationPlanRepository bpjsHospitalizationPlanRepository;

	@Autowired
	private BpjsHospitalizationPlanDatabasePopulator bpjsHospitalizationPlanDatabasePopulator;

	private final BpjsHospitalizationPlanFactory bpjsHospitalizationPlanFactory = new BpjsHospitalizationPlanFactory();

	@Autowired
	private BpjsPRBRepository bpjsPRBRepository;

	@Autowired
	private BpjsPRBDatabasePopulator bpjsPRBDatabasePopulator;

	private final BpjsPRBFactory bpjsPRBFactory = new BpjsPRBFactory();

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StaffDatabasePopulator staffDatabasePopulator;

	private final StaffFactory staffFactory = new StaffFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsDoctorMappingService = new BpjsDoctorMappingService(
			bpjsClaimSubmissionRepository,
			bpjsControlPlanRepository,
			bpjsHospitalizationPlanRepository,
			bpjsPRBRepository,
			staffRepository,
			validator,
			auditRepository,
			bpjsDoctorMappingRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsDoctorMappingEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsDoctorMappingEntity bpjsDoctorMappingEntity = bpjsDoctorMappingFactory.getObject(false, false);

		BpjsDoctorMappingEntity updatedEntity = bpjsDoctorMappingService.updateOldData(bpjsDoctorMappingEntity);
		Assertions.assertEquals(bpjsDoctorMappingEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsDoctorMappingEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;
			BpjsDoctorMappingEntity entityWithUpdatedValues;

			try {
				bpjsDoctorMappingEntity = bpjsDoctorMappingFactory.getObject(false, false);
				bpjsDoctorMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDoctorMappingEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsDoctorMappingFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDoctorMappingEntity = bpjsDoctorMappingService.create(bpjsDoctorMappingEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsDoctorMappingEntity.getId());

			BpjsDoctorMappingEntity updatedEntity = bpjsDoctorMappingService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsDoctorMappingEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsDoctorMappingEntity bpjsDoctorMappingEntity = bpjsDoctorMappingFactory.getObject(false, false);
		bpjsDoctorMappingEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsDoctorMappingService.updateOldData(bpjsDoctorMappingEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsDoctorMappingEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;
			BpjsDoctorMappingEntity updatedBpjsDoctorMappingEntity;

			StaffEntity staffEntity;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;

			Set<BpjsControlPlanEntity> bpjsControlPlansEntities;

			Set<BpjsPRBEntity> bpjsPRBsEntities;

			Set<BpjsHospitalizationPlanEntity> kodedokterEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsDoctorMappingEntity = bpjsDoctorMappingFactory.getObject(true, false);
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
			staffEntity = bpjsDoctorMappingEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			bpjsDoctorMappingEntity.setStaffId(staffEntity.getId());

			bpjsClaimSubmissionsEntities = bpjsDoctorMappingEntity.getBpjsClaimSubmissions();
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
			bpjsDoctorMappingEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			bpjsControlPlansEntities = bpjsDoctorMappingEntity.getBpjsControlPlans();
			Set<UUID> bpjsControlPlansEntityIds = new HashSet<>();
			for (BpjsControlPlanEntity entity : bpjsControlPlansEntities) {
				try {
					bpjsControlPlanDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsControlPlansEntityIds.add(bpjsControlPlanRepository.save(entity).getId());
			}
			bpjsDoctorMappingEntity.setBpjsControlPlansIds(bpjsControlPlansEntityIds);

			bpjsPRBsEntities = bpjsDoctorMappingEntity.getBpjsPRBs();
			Set<UUID> bpjsPRBsEntityIds = new HashSet<>();
			for (BpjsPRBEntity entity : bpjsPRBsEntities) {
				try {
					bpjsPRBDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bpjsPRBsEntityIds.add(bpjsPRBRepository.save(entity).getId());
			}
			bpjsDoctorMappingEntity.setBpjsPRBsIds(bpjsPRBsEntityIds);

			kodedokterEntities = bpjsDoctorMappingEntity.getKodedokter();
			Set<UUID> kodedokterEntityIds = new HashSet<>();
			for (BpjsHospitalizationPlanEntity entity : kodedokterEntities) {
				try {
					bpjsHospitalizationPlanDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				kodedokterEntityIds.add(bpjsHospitalizationPlanRepository.save(entity).getId());
			}
			bpjsDoctorMappingEntity.setKodedokterIds(kodedokterEntityIds);


			bpjsDoctorMappingEntity = bpjsDoctorMappingService.create(bpjsDoctorMappingEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsDoctorMappingEntity.getStaff());
			bpjsDoctorMappingEntity.setStaffId(null);
			bpjsDoctorMappingEntity.unsetStaff();

			Assertions.assertTrue(bpjsDoctorMappingEntity.getBpjsClaimSubmissions().size() > 0);
			bpjsDoctorMappingEntity.setBpjsClaimSubmissionsIds(new HashSet<UUID>());
			bpjsDoctorMappingEntity.unsetBpjsClaimSubmissions();

			Assertions.assertTrue(bpjsDoctorMappingEntity.getBpjsControlPlans().size() > 0);
			bpjsDoctorMappingEntity.setBpjsControlPlansIds(new HashSet<UUID>());
			bpjsDoctorMappingEntity.unsetBpjsControlPlans();

			Assertions.assertTrue(bpjsDoctorMappingEntity.getBpjsPRBs().size() > 0);
			bpjsDoctorMappingEntity.setBpjsPRBsIds(new HashSet<UUID>());
			bpjsDoctorMappingEntity.unsetBpjsPRBs();

			Assertions.assertTrue(bpjsDoctorMappingEntity.getKodedokter().size() > 0);
			bpjsDoctorMappingEntity.setKodedokterIds(new HashSet<UUID>());
			bpjsDoctorMappingEntity.unsetKodedokter();


			updatedBpjsDoctorMappingEntity = bpjsDoctorMappingService.updateOldData(bpjsDoctorMappingEntity);

			Assertions.assertNull(updatedBpjsDoctorMappingEntity.getStaff());

			Assertions.assertEquals(0, updatedBpjsDoctorMappingEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(0, updatedBpjsDoctorMappingEntity.getBpjsControlPlans().size());

			Assertions.assertEquals(0, updatedBpjsDoctorMappingEntity.getBpjsPRBs().size());

			Assertions.assertEquals(0, updatedBpjsDoctorMappingEntity.getKodedokter().size());

		});
	}

	@Test
	public void updateOldDataWithBpjsDoctorMappingEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;
			BpjsDoctorMappingEntity updatedBpjsDoctorMappingEntity;

			StaffEntity staffEntity;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;
			Set<UUID> bpjsClaimSubmissionsEntityIds;

			Set<BpjsControlPlanEntity> bpjsControlPlansEntities;
			Set<UUID> bpjsControlPlansEntityIds;

			Set<BpjsPRBEntity> bpjsPRBsEntities;
			Set<UUID> bpjsPRBsEntityIds;

			Set<BpjsHospitalizationPlanEntity> kodedokterEntities;
			Set<UUID> kodedokterEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsDoctorMappingEntity = bpjsDoctorMappingFactory.getObject(true, false);
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
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDoctorMappingEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(bpjsDoctorMappingEntity.getStaff()).getId()).get();
			bpjsDoctorMappingEntity.unsetStaff();
			bpjsDoctorMappingEntity.setStaffId(staffEntity.getId());

			bpjsClaimSubmissionsEntities = new HashSet<>();
			bpjsClaimSubmissionsEntityIds = new HashSet<>();
			for (BpjsClaimSubmissionEntity entity : bpjsDoctorMappingEntity.getBpjsClaimSubmissions()) {
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
			bpjsDoctorMappingEntity.unsetBpjsClaimSubmissions();
			bpjsDoctorMappingEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			bpjsControlPlansEntities = new HashSet<>();
			bpjsControlPlansEntityIds = new HashSet<>();
			for (BpjsControlPlanEntity entity : bpjsDoctorMappingEntity.getBpjsControlPlans()) {
				try {
					bpjsControlPlanDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS Control Plans relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsControlPlanRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsControlPlansEntities.add(bpjsControlPlanRepository.findById(id).get());
				bpjsControlPlansEntityIds.add(id);
			}
			bpjsDoctorMappingEntity.unsetBpjsControlPlans();
			bpjsDoctorMappingEntity.setBpjsControlPlansIds(bpjsControlPlansEntityIds);

			bpjsPRBsEntities = new HashSet<>();
			bpjsPRBsEntityIds = new HashSet<>();
			for (BpjsPRBEntity entity : bpjsDoctorMappingEntity.getBpjsPRBs()) {
				try {
					bpjsPRBDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the BPJS PRBs relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsPRBRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bpjsPRBsEntities.add(bpjsPRBRepository.findById(id).get());
				bpjsPRBsEntityIds.add(id);
			}
			bpjsDoctorMappingEntity.unsetBpjsPRBs();
			bpjsDoctorMappingEntity.setBpjsPRBsIds(bpjsPRBsEntityIds);

			kodedokterEntities = new HashSet<>();
			kodedokterEntityIds = new HashSet<>();
			for (BpjsHospitalizationPlanEntity entity : bpjsDoctorMappingEntity.getKodedokter()) {
				try {
					bpjsHospitalizationPlanDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the kodeDokter relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsHospitalizationPlanRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				kodedokterEntities.add(bpjsHospitalizationPlanRepository.findById(id).get());
				kodedokterEntityIds.add(id);
			}
			bpjsDoctorMappingEntity.unsetKodedokter();
			bpjsDoctorMappingEntity.setKodedokterIds(kodedokterEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsDoctorMappingEntity = bpjsDoctorMappingService.updateOldData(bpjsDoctorMappingEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			staffEntity.unsetBpjsDoctorMapping(false);
			updatedBpjsDoctorMappingEntity.getStaff().unsetBpjsDoctorMapping(false);
			Assertions.assertEquals(staffEntity, updatedBpjsDoctorMappingEntity.getStaff());

			Assertions.assertEquals(bpjsClaimSubmissionsEntities.size(), updatedBpjsDoctorMappingEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(bpjsControlPlansEntities.size(), updatedBpjsDoctorMappingEntity.getBpjsControlPlans().size());

			Assertions.assertEquals(bpjsPRBsEntities.size(), updatedBpjsDoctorMappingEntity.getBpjsPRBs().size());

			Assertions.assertEquals(kodedokterEntities.size(), updatedBpjsDoctorMappingEntity.getKodedokter().size());

		});
	}

	@Test
	public void whenCreateBpjsDoctorMappingEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;
			Optional<BpjsDoctorMappingEntity> fetchedBpjsDoctorMappingEntity;

			try {
				bpjsDoctorMappingEntity = bpjsDoctorMappingFactory.getObject(false, false);
				bpjsDoctorMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDoctorMappingEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDoctorMappingEntity = bpjsDoctorMappingService.create(bpjsDoctorMappingEntity);

			fetchedBpjsDoctorMappingEntity = bpjsDoctorMappingService.findById(bpjsDoctorMappingEntity.getId());

			Assertions.assertTrue(fetchedBpjsDoctorMappingEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsDoctorMappingEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsDoctorMappingEntity, fetchedBpjsDoctorMappingEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsDoctorMappingEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;
			BpjsDoctorMappingEntity updatedBpjsDoctorMappingEntity;
			Optional<BpjsDoctorMappingEntity> fetchedBpjsDoctorMappingEntity;

			try {
				bpjsDoctorMappingEntity = bpjsDoctorMappingFactory.getObject(false, false);
				bpjsDoctorMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDoctorMappingEntity, true, true, false);
				updatedBpjsDoctorMappingEntity = bpjsDoctorMappingFactory.getObject(false, false);
				bpjsDoctorMappingDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsDoctorMappingEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDoctorMappingEntity = bpjsDoctorMappingService.create(bpjsDoctorMappingEntity);

			updatedBpjsDoctorMappingEntity.setId(bpjsDoctorMappingEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsDoctorMappingEntity.setCreated(bpjsDoctorMappingEntity.getCreated());

			updatedBpjsDoctorMappingEntity = bpjsDoctorMappingService.update(updatedBpjsDoctorMappingEntity);

			fetchedBpjsDoctorMappingEntity = bpjsDoctorMappingService.findById(bpjsDoctorMappingEntity.getId());

			Assertions.assertTrue(fetchedBpjsDoctorMappingEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsDoctorMappingEntity_ThenEntityIsCreated
			fetchedBpjsDoctorMappingEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsDoctorMappingEntity, fetchedBpjsDoctorMappingEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsDoctorMappingEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDoctorMappingEntity bpjsDoctorMappingEntity;
			Optional<BpjsDoctorMappingEntity> fetchedBpjsDoctorMappingEntity;

			try {
				bpjsDoctorMappingEntity = bpjsDoctorMappingFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsDoctorMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDoctorMappingEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDoctorMappingEntity = bpjsDoctorMappingService.create(bpjsDoctorMappingEntity);

			bpjsDoctorMappingService.deleteById(bpjsDoctorMappingEntity.getId());
			fetchedBpjsDoctorMappingEntity = bpjsDoctorMappingService.findById(bpjsDoctorMappingEntity.getId());

			Assertions.assertTrue(fetchedBpjsDoctorMappingEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
