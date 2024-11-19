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
import kmsweb.entities.BpjsServiceMappingEntity;
import kmsweb.repositories.BpjsServiceMappingRepository;
import kmsweb.utils.BpjsServiceMappingFactory;
import kmsweb.utils.DatabasePopulators.BpjsServiceMappingDatabasePopulator;
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
import kmsweb.entities.BpjsPatientReferralEntity;
import kmsweb.repositories.BpjsPatientReferralRepository;
import kmsweb.utils.BpjsPatientReferralFactory;
import kmsweb.utils.DatabasePopulators.BpjsPatientReferralDatabasePopulator;
import kmsweb.entities.ServiceEntity;
import kmsweb.repositories.ServiceRepository;
import kmsweb.utils.ServiceFactory;
import kmsweb.utils.DatabasePopulators.ServiceDatabasePopulator;
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
public class BpjsServiceMappingServiceIntegrationTest {

	@Autowired
	private BpjsServiceMappingRepository bpjsServiceMappingRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsServiceMappingService bpjsServiceMappingService;

	private final BpjsServiceMappingFactory bpjsServiceMappingFactory = new BpjsServiceMappingFactory();

	@Autowired
	private BpjsServiceMappingDatabasePopulator bpjsServiceMappingDatabasePopulator;

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
	private BpjsPatientReferralRepository bpjsPatientReferralRepository;

	@Autowired
	private BpjsPatientReferralDatabasePopulator bpjsPatientReferralDatabasePopulator;

	private final BpjsPatientReferralFactory bpjsPatientReferralFactory = new BpjsPatientReferralFactory();

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ServiceDatabasePopulator serviceDatabasePopulator;

	private final ServiceFactory serviceFactory = new ServiceFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsServiceMappingService = new BpjsServiceMappingService(
			bpjsClaimSubmissionRepository,
			bpjsControlPlanRepository,
			bpjsHospitalizationPlanRepository,
			bpjsPatientReferralRepository,
			serviceRepository,
			validator,
			auditRepository,
			bpjsServiceMappingRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsServiceMappingEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsServiceMappingEntity bpjsServiceMappingEntity = bpjsServiceMappingFactory.getObject(false, false);

		BpjsServiceMappingEntity updatedEntity = bpjsServiceMappingService.updateOldData(bpjsServiceMappingEntity);
		Assertions.assertEquals(bpjsServiceMappingEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewBpjsServiceMappingEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		BpjsServiceMappingEntity bpjsServiceMappingEntity = bpjsServiceMappingFactory.getObject(false, false);

		bpjsServiceMappingEntity.setCategorizedAsSurgery(null);
		Assertions.assertNull(bpjsServiceMappingEntity.getCategorizedAsSurgery());


		BpjsServiceMappingEntity updatedEntity = bpjsServiceMappingService.updateOldData(bpjsServiceMappingEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getCategorizedAsSurgery());
		Assertions.assertFalse(updatedEntity.getCategorizedAsSurgery());

	}

	@Test
	public void updateOldDataWithExistingBpjsServiceMappingEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsServiceMappingEntity bpjsServiceMappingEntity;
			BpjsServiceMappingEntity entityWithUpdatedValues;

			try {
				bpjsServiceMappingEntity = bpjsServiceMappingFactory.getObject(false, false);
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsServiceMappingEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsServiceMappingFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsServiceMappingEntity = bpjsServiceMappingService.create(bpjsServiceMappingEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsServiceMappingEntity.getId());

			BpjsServiceMappingEntity updatedEntity = bpjsServiceMappingService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsServiceMappingEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsServiceMappingEntity bpjsServiceMappingEntity = bpjsServiceMappingFactory.getObject(false, false);
		bpjsServiceMappingEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsServiceMappingService.updateOldData(bpjsServiceMappingEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsServiceMappingEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsServiceMappingEntity bpjsServiceMappingEntity;
			BpjsServiceMappingEntity updatedBpjsServiceMappingEntity;

			ServiceEntity serviceEntity;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;

			Set<BpjsControlPlanEntity> bpjsControlPlansEntities;

			Set<BpjsPatientReferralEntity> bpjsPatientReferralsEntities;

			Set<BpjsHospitalizationPlanEntity> polikontrolEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsServiceMappingEntity = bpjsServiceMappingFactory.getObject(true, false);
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
			serviceEntity = bpjsServiceMappingEntity.getService();
			try {
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			serviceEntity = serviceRepository.save(serviceEntity);
			bpjsServiceMappingEntity.setServiceId(serviceEntity.getId());

			bpjsClaimSubmissionsEntities = bpjsServiceMappingEntity.getBpjsClaimSubmissions();
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
			bpjsServiceMappingEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			bpjsControlPlansEntities = bpjsServiceMappingEntity.getBpjsControlPlans();
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
			bpjsServiceMappingEntity.setBpjsControlPlansIds(bpjsControlPlansEntityIds);

			bpjsPatientReferralsEntities = bpjsServiceMappingEntity.getBpjsPatientReferrals();
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
			bpjsServiceMappingEntity.setBpjsPatientReferralsIds(bpjsPatientReferralsEntityIds);

			polikontrolEntities = bpjsServiceMappingEntity.getPolikontrol();
			Set<UUID> polikontrolEntityIds = new HashSet<>();
			for (BpjsHospitalizationPlanEntity entity : polikontrolEntities) {
				try {
					bpjsHospitalizationPlanDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				polikontrolEntityIds.add(bpjsHospitalizationPlanRepository.save(entity).getId());
			}
			bpjsServiceMappingEntity.setPolikontrolIds(polikontrolEntityIds);


			bpjsServiceMappingEntity = bpjsServiceMappingService.create(bpjsServiceMappingEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsServiceMappingEntity.getService());
			bpjsServiceMappingEntity.setServiceId(null);
			bpjsServiceMappingEntity.unsetService();

			Assertions.assertTrue(bpjsServiceMappingEntity.getBpjsClaimSubmissions().size() > 0);
			bpjsServiceMappingEntity.setBpjsClaimSubmissionsIds(new HashSet<UUID>());
			bpjsServiceMappingEntity.unsetBpjsClaimSubmissions();

			Assertions.assertTrue(bpjsServiceMappingEntity.getBpjsControlPlans().size() > 0);
			bpjsServiceMappingEntity.setBpjsControlPlansIds(new HashSet<UUID>());
			bpjsServiceMappingEntity.unsetBpjsControlPlans();

			Assertions.assertTrue(bpjsServiceMappingEntity.getBpjsPatientReferrals().size() > 0);
			bpjsServiceMappingEntity.setBpjsPatientReferralsIds(new HashSet<UUID>());
			bpjsServiceMappingEntity.unsetBpjsPatientReferrals();

			Assertions.assertTrue(bpjsServiceMappingEntity.getPolikontrol().size() > 0);
			bpjsServiceMappingEntity.setPolikontrolIds(new HashSet<UUID>());
			bpjsServiceMappingEntity.unsetPolikontrol();


			updatedBpjsServiceMappingEntity = bpjsServiceMappingService.updateOldData(bpjsServiceMappingEntity);

			Assertions.assertNull(updatedBpjsServiceMappingEntity.getService());

			Assertions.assertEquals(0, updatedBpjsServiceMappingEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(0, updatedBpjsServiceMappingEntity.getBpjsControlPlans().size());

			Assertions.assertEquals(0, updatedBpjsServiceMappingEntity.getBpjsPatientReferrals().size());

			Assertions.assertEquals(0, updatedBpjsServiceMappingEntity.getPolikontrol().size());

		});
	}

	@Test
	public void updateOldDataWithBpjsServiceMappingEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsServiceMappingEntity bpjsServiceMappingEntity;
			BpjsServiceMappingEntity updatedBpjsServiceMappingEntity;

			ServiceEntity serviceEntity;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;
			Set<UUID> bpjsClaimSubmissionsEntityIds;

			Set<BpjsControlPlanEntity> bpjsControlPlansEntities;
			Set<UUID> bpjsControlPlansEntityIds;

			Set<BpjsPatientReferralEntity> bpjsPatientReferralsEntities;
			Set<UUID> bpjsPatientReferralsEntityIds;

			Set<BpjsHospitalizationPlanEntity> polikontrolEntities;
			Set<UUID> polikontrolEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsServiceMappingEntity = bpjsServiceMappingFactory.getObject(true, false);
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
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsServiceMappingEntity.getService(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Service relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			serviceEntity = serviceRepository.findById(serviceRepository.save(bpjsServiceMappingEntity.getService()).getId()).get();
			bpjsServiceMappingEntity.unsetService();
			bpjsServiceMappingEntity.setServiceId(serviceEntity.getId());

			bpjsClaimSubmissionsEntities = new HashSet<>();
			bpjsClaimSubmissionsEntityIds = new HashSet<>();
			for (BpjsClaimSubmissionEntity entity : bpjsServiceMappingEntity.getBpjsClaimSubmissions()) {
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
			bpjsServiceMappingEntity.unsetBpjsClaimSubmissions();
			bpjsServiceMappingEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			bpjsControlPlansEntities = new HashSet<>();
			bpjsControlPlansEntityIds = new HashSet<>();
			for (BpjsControlPlanEntity entity : bpjsServiceMappingEntity.getBpjsControlPlans()) {
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
			bpjsServiceMappingEntity.unsetBpjsControlPlans();
			bpjsServiceMappingEntity.setBpjsControlPlansIds(bpjsControlPlansEntityIds);

			bpjsPatientReferralsEntities = new HashSet<>();
			bpjsPatientReferralsEntityIds = new HashSet<>();
			for (BpjsPatientReferralEntity entity : bpjsServiceMappingEntity.getBpjsPatientReferrals()) {
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
			bpjsServiceMappingEntity.unsetBpjsPatientReferrals();
			bpjsServiceMappingEntity.setBpjsPatientReferralsIds(bpjsPatientReferralsEntityIds);

			polikontrolEntities = new HashSet<>();
			polikontrolEntityIds = new HashSet<>();
			for (BpjsHospitalizationPlanEntity entity : bpjsServiceMappingEntity.getPolikontrol()) {
				try {
					bpjsHospitalizationPlanDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the poliKontrol relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsHospitalizationPlanRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				polikontrolEntities.add(bpjsHospitalizationPlanRepository.findById(id).get());
				polikontrolEntityIds.add(id);
			}
			bpjsServiceMappingEntity.unsetPolikontrol();
			bpjsServiceMappingEntity.setPolikontrolIds(polikontrolEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsServiceMappingEntity = bpjsServiceMappingService.updateOldData(bpjsServiceMappingEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			serviceEntity.unsetBpjsServiceMapping(false);
			updatedBpjsServiceMappingEntity.getService().unsetBpjsServiceMapping(false);
			Assertions.assertEquals(serviceEntity, updatedBpjsServiceMappingEntity.getService());

			Assertions.assertEquals(bpjsClaimSubmissionsEntities.size(), updatedBpjsServiceMappingEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(bpjsControlPlansEntities.size(), updatedBpjsServiceMappingEntity.getBpjsControlPlans().size());

			Assertions.assertEquals(bpjsPatientReferralsEntities.size(), updatedBpjsServiceMappingEntity.getBpjsPatientReferrals().size());

			Assertions.assertEquals(polikontrolEntities.size(), updatedBpjsServiceMappingEntity.getPolikontrol().size());

		});
	}

	@Test
	public void whenCreateBpjsServiceMappingEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsServiceMappingEntity bpjsServiceMappingEntity;
			Optional<BpjsServiceMappingEntity> fetchedBpjsServiceMappingEntity;

			try {
				bpjsServiceMappingEntity = bpjsServiceMappingFactory.getObject(false, false);
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsServiceMappingEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsServiceMappingEntity = bpjsServiceMappingService.create(bpjsServiceMappingEntity);

			fetchedBpjsServiceMappingEntity = bpjsServiceMappingService.findById(bpjsServiceMappingEntity.getId());

			Assertions.assertTrue(fetchedBpjsServiceMappingEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsServiceMappingEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsServiceMappingEntity, fetchedBpjsServiceMappingEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsServiceMappingEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsServiceMappingEntity bpjsServiceMappingEntity;
			BpjsServiceMappingEntity updatedBpjsServiceMappingEntity;
			Optional<BpjsServiceMappingEntity> fetchedBpjsServiceMappingEntity;

			try {
				bpjsServiceMappingEntity = bpjsServiceMappingFactory.getObject(false, false);
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsServiceMappingEntity, true, true, false);
				updatedBpjsServiceMappingEntity = bpjsServiceMappingFactory.getObject(false, false);
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsServiceMappingEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsServiceMappingEntity = bpjsServiceMappingService.create(bpjsServiceMappingEntity);

			updatedBpjsServiceMappingEntity.setId(bpjsServiceMappingEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsServiceMappingEntity.setCreated(bpjsServiceMappingEntity.getCreated());

			updatedBpjsServiceMappingEntity = bpjsServiceMappingService.update(updatedBpjsServiceMappingEntity);

			fetchedBpjsServiceMappingEntity = bpjsServiceMappingService.findById(bpjsServiceMappingEntity.getId());

			Assertions.assertTrue(fetchedBpjsServiceMappingEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsServiceMappingEntity_ThenEntityIsCreated
			fetchedBpjsServiceMappingEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsServiceMappingEntity, fetchedBpjsServiceMappingEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsServiceMappingEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsServiceMappingEntity bpjsServiceMappingEntity;
			Optional<BpjsServiceMappingEntity> fetchedBpjsServiceMappingEntity;

			try {
				bpjsServiceMappingEntity = bpjsServiceMappingFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsServiceMappingDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsServiceMappingEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsServiceMappingEntity = bpjsServiceMappingService.create(bpjsServiceMappingEntity);

			bpjsServiceMappingService.deleteById(bpjsServiceMappingEntity.getId());
			fetchedBpjsServiceMappingEntity = bpjsServiceMappingService.findById(bpjsServiceMappingEntity.getId());

			Assertions.assertTrue(fetchedBpjsServiceMappingEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
