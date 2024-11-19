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
import kmsweb.entities.BpjsDiagnoseEntity;
import kmsweb.repositories.BpjsDiagnoseRepository;
import kmsweb.utils.BpjsDiagnoseFactory;
import kmsweb.utils.DatabasePopulators.BpjsDiagnoseDatabasePopulator;
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.repositories.BpjsClaimSubmissionRepository;
import kmsweb.utils.BpjsClaimSubmissionFactory;
import kmsweb.utils.DatabasePopulators.BpjsClaimSubmissionDatabasePopulator;
import kmsweb.entities.BpjsPatientReferralEntity;
import kmsweb.repositories.BpjsPatientReferralRepository;
import kmsweb.utils.BpjsPatientReferralFactory;
import kmsweb.utils.DatabasePopulators.BpjsPatientReferralDatabasePopulator;
import kmsweb.entities.BpjsSpecialReferralEntity;
import kmsweb.repositories.BpjsSpecialReferralRepository;
import kmsweb.utils.BpjsSpecialReferralFactory;
import kmsweb.utils.DatabasePopulators.BpjsSpecialReferralDatabasePopulator;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
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
public class BpjsDiagnoseServiceIntegrationTest {

	@Autowired
	private BpjsDiagnoseRepository bpjsDiagnoseRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsDiagnoseService bpjsDiagnoseService;

	private final BpjsDiagnoseFactory bpjsDiagnoseFactory = new BpjsDiagnoseFactory();

	@Autowired
	private BpjsDiagnoseDatabasePopulator bpjsDiagnoseDatabasePopulator;

	@Autowired
	private BpjsClaimSubmissionRepository bpjsClaimSubmissionRepository;

	@Autowired
	private BpjsClaimSubmissionDatabasePopulator bpjsClaimSubmissionDatabasePopulator;

	private final BpjsClaimSubmissionFactory bpjsClaimSubmissionFactory = new BpjsClaimSubmissionFactory();

	@Autowired
	private BpjsPatientReferralRepository bpjsPatientReferralRepository;

	@Autowired
	private BpjsPatientReferralDatabasePopulator bpjsPatientReferralDatabasePopulator;

	private final BpjsPatientReferralFactory bpjsPatientReferralFactory = new BpjsPatientReferralFactory();

	@Autowired
	private BpjsSpecialReferralRepository bpjsSpecialReferralRepository;

	@Autowired
	private BpjsSpecialReferralDatabasePopulator bpjsSpecialReferralDatabasePopulator;

	private final BpjsSpecialReferralFactory bpjsSpecialReferralFactory = new BpjsSpecialReferralFactory();

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsDiagnoseService = new BpjsDiagnoseService(
			bpjsClaimSubmissionRepository,
			bpjsPatientReferralRepository,
			bpjsSpecialReferralRepository,
			diagnosesAndProceduresRepository,
			validator,
			auditRepository,
			bpjsDiagnoseRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsDiagnoseEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsDiagnoseEntity bpjsDiagnoseEntity = bpjsDiagnoseFactory.getObject(false, false);

		BpjsDiagnoseEntity updatedEntity = bpjsDiagnoseService.updateOldData(bpjsDiagnoseEntity);
		Assertions.assertEquals(bpjsDiagnoseEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsDiagnoseEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnoseEntity bpjsDiagnoseEntity;
			BpjsDiagnoseEntity entityWithUpdatedValues;

			try {
				bpjsDiagnoseEntity = bpjsDiagnoseFactory.getObject(false, false);
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnoseEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsDiagnoseFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDiagnoseEntity = bpjsDiagnoseService.create(bpjsDiagnoseEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsDiagnoseEntity.getId());

			BpjsDiagnoseEntity updatedEntity = bpjsDiagnoseService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsDiagnoseEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsDiagnoseEntity bpjsDiagnoseEntity = bpjsDiagnoseFactory.getObject(false, false);
		bpjsDiagnoseEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsDiagnoseService.updateOldData(bpjsDiagnoseEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsDiagnoseEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnoseEntity bpjsDiagnoseEntity;
			BpjsDiagnoseEntity updatedBpjsDiagnoseEntity;

			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;

			Set<BpjsSpecialReferralEntity> additionalDiagnoseEntities;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;

			Set<BpjsPatientReferralEntity> bpjsPatientReferralsEntities;

			Set<BpjsSpecialReferralEntity> primaryDiagnoseEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsDiagnoseEntity = bpjsDiagnoseFactory.getObject(true, false);
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
			diagnosesAndProceduresEntity = bpjsDiagnoseEntity.getDiagnosesAndProcedures();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			diagnosesAndProceduresEntity = diagnosesAndProceduresRepository.save(diagnosesAndProceduresEntity);
			bpjsDiagnoseEntity.setDiagnosesAndProceduresId(diagnosesAndProceduresEntity.getId());

			additionalDiagnoseEntities = bpjsDiagnoseEntity.getAdditionalDiagnose();
			Set<UUID> additionalDiagnoseEntityIds = new HashSet<>();
			for (BpjsSpecialReferralEntity entity : additionalDiagnoseEntities) {
				try {
					bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				additionalDiagnoseEntityIds.add(bpjsSpecialReferralRepository.save(entity).getId());
			}
			bpjsDiagnoseEntity.setAdditionalDiagnoseIds(additionalDiagnoseEntityIds);

			bpjsClaimSubmissionsEntities = bpjsDiagnoseEntity.getBpjsClaimSubmissions();
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
			bpjsDiagnoseEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			bpjsPatientReferralsEntities = bpjsDiagnoseEntity.getBpjsPatientReferrals();
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
			bpjsDiagnoseEntity.setBpjsPatientReferralsIds(bpjsPatientReferralsEntityIds);

			primaryDiagnoseEntities = bpjsDiagnoseEntity.getPrimaryDiagnose();
			Set<UUID> primaryDiagnoseEntityIds = new HashSet<>();
			for (BpjsSpecialReferralEntity entity : primaryDiagnoseEntities) {
				try {
					bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				primaryDiagnoseEntityIds.add(bpjsSpecialReferralRepository.save(entity).getId());
			}
			bpjsDiagnoseEntity.setPrimaryDiagnoseIds(primaryDiagnoseEntityIds);


			bpjsDiagnoseEntity = bpjsDiagnoseService.create(bpjsDiagnoseEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsDiagnoseEntity.getDiagnosesAndProcedures());
			bpjsDiagnoseEntity.setDiagnosesAndProceduresId(null);
			bpjsDiagnoseEntity.unsetDiagnosesAndProcedures();

			Assertions.assertTrue(bpjsDiagnoseEntity.getAdditionalDiagnose().size() > 0);
			bpjsDiagnoseEntity.setAdditionalDiagnoseIds(new HashSet<UUID>());
			bpjsDiagnoseEntity.unsetAdditionalDiagnose();

			Assertions.assertTrue(bpjsDiagnoseEntity.getBpjsClaimSubmissions().size() > 0);
			bpjsDiagnoseEntity.setBpjsClaimSubmissionsIds(new HashSet<UUID>());
			bpjsDiagnoseEntity.unsetBpjsClaimSubmissions();

			Assertions.assertTrue(bpjsDiagnoseEntity.getBpjsPatientReferrals().size() > 0);
			bpjsDiagnoseEntity.setBpjsPatientReferralsIds(new HashSet<UUID>());
			bpjsDiagnoseEntity.unsetBpjsPatientReferrals();

			Assertions.assertTrue(bpjsDiagnoseEntity.getPrimaryDiagnose().size() > 0);
			bpjsDiagnoseEntity.setPrimaryDiagnoseIds(new HashSet<UUID>());
			bpjsDiagnoseEntity.unsetPrimaryDiagnose();


			updatedBpjsDiagnoseEntity = bpjsDiagnoseService.updateOldData(bpjsDiagnoseEntity);

			Assertions.assertNull(updatedBpjsDiagnoseEntity.getDiagnosesAndProcedures());

			Assertions.assertEquals(0, updatedBpjsDiagnoseEntity.getAdditionalDiagnose().size());

			Assertions.assertEquals(0, updatedBpjsDiagnoseEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(0, updatedBpjsDiagnoseEntity.getBpjsPatientReferrals().size());

			Assertions.assertEquals(0, updatedBpjsDiagnoseEntity.getPrimaryDiagnose().size());

		});
	}

	@Test
	public void updateOldDataWithBpjsDiagnoseEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnoseEntity bpjsDiagnoseEntity;
			BpjsDiagnoseEntity updatedBpjsDiagnoseEntity;

			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;

			Set<BpjsSpecialReferralEntity> additionalDiagnoseEntities;
			Set<UUID> additionalDiagnoseEntityIds;

			Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissionsEntities;
			Set<UUID> bpjsClaimSubmissionsEntityIds;

			Set<BpjsPatientReferralEntity> bpjsPatientReferralsEntities;
			Set<UUID> bpjsPatientReferralsEntityIds;

			Set<BpjsSpecialReferralEntity> primaryDiagnoseEntities;
			Set<UUID> primaryDiagnoseEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsDiagnoseEntity = bpjsDiagnoseFactory.getObject(true, false);
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
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnoseEntity.getDiagnosesAndProcedures(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Diagnoses and Procedures relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			diagnosesAndProceduresEntity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(bpjsDiagnoseEntity.getDiagnosesAndProcedures()).getId()).get();
			bpjsDiagnoseEntity.unsetDiagnosesAndProcedures();
			bpjsDiagnoseEntity.setDiagnosesAndProceduresId(diagnosesAndProceduresEntity.getId());

			additionalDiagnoseEntities = new HashSet<>();
			additionalDiagnoseEntityIds = new HashSet<>();
			for (BpjsSpecialReferralEntity entity : bpjsDiagnoseEntity.getAdditionalDiagnose()) {
				try {
					bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Additional Diagnose relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsSpecialReferralRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				additionalDiagnoseEntities.add(bpjsSpecialReferralRepository.findById(id).get());
				additionalDiagnoseEntityIds.add(id);
			}
			bpjsDiagnoseEntity.unsetAdditionalDiagnose();
			bpjsDiagnoseEntity.setAdditionalDiagnoseIds(additionalDiagnoseEntityIds);

			bpjsClaimSubmissionsEntities = new HashSet<>();
			bpjsClaimSubmissionsEntityIds = new HashSet<>();
			for (BpjsClaimSubmissionEntity entity : bpjsDiagnoseEntity.getBpjsClaimSubmissions()) {
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
			bpjsDiagnoseEntity.unsetBpjsClaimSubmissions();
			bpjsDiagnoseEntity.setBpjsClaimSubmissionsIds(bpjsClaimSubmissionsEntityIds);

			bpjsPatientReferralsEntities = new HashSet<>();
			bpjsPatientReferralsEntityIds = new HashSet<>();
			for (BpjsPatientReferralEntity entity : bpjsDiagnoseEntity.getBpjsPatientReferrals()) {
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
			bpjsDiagnoseEntity.unsetBpjsPatientReferrals();
			bpjsDiagnoseEntity.setBpjsPatientReferralsIds(bpjsPatientReferralsEntityIds);

			primaryDiagnoseEntities = new HashSet<>();
			primaryDiagnoseEntityIds = new HashSet<>();
			for (BpjsSpecialReferralEntity entity : bpjsDiagnoseEntity.getPrimaryDiagnose()) {
				try {
					bpjsSpecialReferralDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Primary Diagnose relation for this test: " + e.getCause());
					return;
				}
				UUID id = bpjsSpecialReferralRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				primaryDiagnoseEntities.add(bpjsSpecialReferralRepository.findById(id).get());
				primaryDiagnoseEntityIds.add(id);
			}
			bpjsDiagnoseEntity.unsetPrimaryDiagnose();
			bpjsDiagnoseEntity.setPrimaryDiagnoseIds(primaryDiagnoseEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsDiagnoseEntity = bpjsDiagnoseService.updateOldData(bpjsDiagnoseEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			diagnosesAndProceduresEntity.unsetBpjsDiagnose(false);
			updatedBpjsDiagnoseEntity.getDiagnosesAndProcedures().unsetBpjsDiagnose(false);
			Assertions.assertEquals(diagnosesAndProceduresEntity, updatedBpjsDiagnoseEntity.getDiagnosesAndProcedures());

			Assertions.assertEquals(additionalDiagnoseEntities.size(), updatedBpjsDiagnoseEntity.getAdditionalDiagnose().size());

			Assertions.assertEquals(bpjsClaimSubmissionsEntities.size(), updatedBpjsDiagnoseEntity.getBpjsClaimSubmissions().size());

			Assertions.assertEquals(bpjsPatientReferralsEntities.size(), updatedBpjsDiagnoseEntity.getBpjsPatientReferrals().size());

			Assertions.assertEquals(primaryDiagnoseEntities.size(), updatedBpjsDiagnoseEntity.getPrimaryDiagnose().size());

		});
	}

	@Test
	public void whenCreateBpjsDiagnoseEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnoseEntity bpjsDiagnoseEntity;
			Optional<BpjsDiagnoseEntity> fetchedBpjsDiagnoseEntity;

			try {
				bpjsDiagnoseEntity = bpjsDiagnoseFactory.getObject(false, false);
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnoseEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDiagnoseEntity = bpjsDiagnoseService.create(bpjsDiagnoseEntity);

			fetchedBpjsDiagnoseEntity = bpjsDiagnoseService.findById(bpjsDiagnoseEntity.getId());

			Assertions.assertTrue(fetchedBpjsDiagnoseEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsDiagnoseEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsDiagnoseEntity, fetchedBpjsDiagnoseEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsDiagnoseEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnoseEntity bpjsDiagnoseEntity;
			BpjsDiagnoseEntity updatedBpjsDiagnoseEntity;
			Optional<BpjsDiagnoseEntity> fetchedBpjsDiagnoseEntity;

			try {
				bpjsDiagnoseEntity = bpjsDiagnoseFactory.getObject(false, false);
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnoseEntity, true, true, false);
				updatedBpjsDiagnoseEntity = bpjsDiagnoseFactory.getObject(false, false);
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsDiagnoseEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDiagnoseEntity = bpjsDiagnoseService.create(bpjsDiagnoseEntity);

			updatedBpjsDiagnoseEntity.setId(bpjsDiagnoseEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsDiagnoseEntity.setCreated(bpjsDiagnoseEntity.getCreated());

			updatedBpjsDiagnoseEntity = bpjsDiagnoseService.update(updatedBpjsDiagnoseEntity);

			fetchedBpjsDiagnoseEntity = bpjsDiagnoseService.findById(bpjsDiagnoseEntity.getId());

			Assertions.assertTrue(fetchedBpjsDiagnoseEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsDiagnoseEntity_ThenEntityIsCreated
			fetchedBpjsDiagnoseEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsDiagnoseEntity, fetchedBpjsDiagnoseEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsDiagnoseEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsDiagnoseEntity bpjsDiagnoseEntity;
			Optional<BpjsDiagnoseEntity> fetchedBpjsDiagnoseEntity;

			try {
				bpjsDiagnoseEntity = bpjsDiagnoseFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsDiagnoseDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsDiagnoseEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsDiagnoseEntity = bpjsDiagnoseService.create(bpjsDiagnoseEntity);

			bpjsDiagnoseService.deleteById(bpjsDiagnoseEntity.getId());
			fetchedBpjsDiagnoseEntity = bpjsDiagnoseService.findById(bpjsDiagnoseEntity.getId());

			Assertions.assertTrue(fetchedBpjsDiagnoseEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
