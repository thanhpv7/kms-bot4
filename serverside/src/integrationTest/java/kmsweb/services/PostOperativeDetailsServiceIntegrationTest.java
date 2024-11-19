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
import kmsweb.entities.PostOperativeDetailsEntity;
import kmsweb.repositories.PostOperativeDetailsRepository;
import kmsweb.utils.PostOperativeDetailsFactory;
import kmsweb.utils.DatabasePopulators.PostOperativeDetailsDatabasePopulator;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.utils.BedFacilityFactory;
import kmsweb.utils.DatabasePopulators.BedFacilityDatabasePopulator;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.utils.OperatingTheaterMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.OperatingTheaterMedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.RoomFacilityEntity;
import kmsweb.repositories.RoomFacilityRepository;
import kmsweb.utils.RoomFacilityFactory;
import kmsweb.utils.DatabasePopulators.RoomFacilityDatabasePopulator;
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
public class PostOperativeDetailsServiceIntegrationTest {

	@Autowired
	private PostOperativeDetailsRepository postOperativeDetailsRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PostOperativeDetailsService postOperativeDetailsService;

	private final PostOperativeDetailsFactory postOperativeDetailsFactory = new PostOperativeDetailsFactory();

	@Autowired
	private PostOperativeDetailsDatabasePopulator postOperativeDetailsDatabasePopulator;

	@Autowired
	private BedFacilityRepository bedFacilityRepository;

	@Autowired
	private BedFacilityDatabasePopulator bedFacilityDatabasePopulator;

	private final BedFacilityFactory bedFacilityFactory = new BedFacilityFactory();

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();

	@Autowired
	private OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;

	@Autowired
	private OperatingTheaterMedicalExaminationRecordDatabasePopulator operatingTheaterMedicalExaminationRecordDatabasePopulator;

	private final OperatingTheaterMedicalExaminationRecordFactory operatingTheaterMedicalExaminationRecordFactory = new OperatingTheaterMedicalExaminationRecordFactory();

	@Autowired
	private RoomFacilityRepository roomFacilityRepository;

	@Autowired
	private RoomFacilityDatabasePopulator roomFacilityDatabasePopulator;

	private final RoomFacilityFactory roomFacilityFactory = new RoomFacilityFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		postOperativeDetailsService = new PostOperativeDetailsService(
			bedFacilityRepository,
			diagnosesAndProceduresRepository,
			operatingTheaterMedicalExaminationRecordRepository,
			roomFacilityRepository,
			validator,
			auditRepository,
			postOperativeDetailsRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPostOperativeDetailsEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PostOperativeDetailsEntity postOperativeDetailsEntity = postOperativeDetailsFactory.getObject(false, false);

		PostOperativeDetailsEntity updatedEntity = postOperativeDetailsService.updateOldData(postOperativeDetailsEntity);
		Assertions.assertEquals(postOperativeDetailsEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewPostOperativeDetailsEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		PostOperativeDetailsEntity postOperativeDetailsEntity = postOperativeDetailsFactory.getObject(false, false);

		postOperativeDetailsEntity.setNewCase(null);
		Assertions.assertNull(postOperativeDetailsEntity.getNewCase());


		PostOperativeDetailsEntity updatedEntity = postOperativeDetailsService.updateOldData(postOperativeDetailsEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getNewCase());
		Assertions.assertFalse(updatedEntity.getNewCase());

	}

	@Test
	public void updateOldDataWithExistingPostOperativeDetailsEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PostOperativeDetailsEntity postOperativeDetailsEntity;
			PostOperativeDetailsEntity entityWithUpdatedValues;

			try {
				postOperativeDetailsEntity = postOperativeDetailsFactory.getObject(false, false);
				postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeDetailsEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = postOperativeDetailsFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			postOperativeDetailsEntity = postOperativeDetailsService.create(postOperativeDetailsEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(postOperativeDetailsEntity.getId());

			PostOperativeDetailsEntity updatedEntity = postOperativeDetailsService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPostOperativeDetailsEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PostOperativeDetailsEntity postOperativeDetailsEntity = postOperativeDetailsFactory.getObject(false, false);
		postOperativeDetailsEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			postOperativeDetailsService.updateOldData(postOperativeDetailsEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPostOperativeDetailsEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PostOperativeDetailsEntity postOperativeDetailsEntity;
			PostOperativeDetailsEntity updatedPostOperativeDetailsEntity;

			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;

			DiagnosesAndProceduresEntity postOperativeICD10Entity;

			DiagnosesAndProceduresEntity postOperativeICD9CMEntity;

			RoomFacilityEntity recoveryRoomsEntity;

			Set<BedFacilityEntity> bedFacilitiesEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				postOperativeDetailsEntity = postOperativeDetailsFactory.getObject(true, false);
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
			operatingTheaterMedicalExaminationRecordEntity = postOperativeDetailsEntity.getOperatingTheaterMedicalExaminationRecord();
			try {
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordRepository.save(operatingTheaterMedicalExaminationRecordEntity);
			postOperativeDetailsEntity.setOperatingTheaterMedicalExaminationRecordId(operatingTheaterMedicalExaminationRecordEntity.getId());

			postOperativeICD10Entity = postOperativeDetailsEntity.getPostOperativeICD10();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeICD10Entity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			postOperativeICD10Entity = diagnosesAndProceduresRepository.save(postOperativeICD10Entity);
			postOperativeDetailsEntity.setPostOperativeICD10Id(postOperativeICD10Entity.getId());

			postOperativeICD9CMEntity = postOperativeDetailsEntity.getPostOperativeICD9CM();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeICD9CMEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			postOperativeICD9CMEntity = diagnosesAndProceduresRepository.save(postOperativeICD9CMEntity);
			postOperativeDetailsEntity.setPostOperativeICD9CMId(postOperativeICD9CMEntity.getId());

			recoveryRoomsEntity = postOperativeDetailsEntity.getRecoveryRooms();
			try {
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(recoveryRoomsEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			recoveryRoomsEntity = roomFacilityRepository.save(recoveryRoomsEntity);
			postOperativeDetailsEntity.setRecoveryRoomsId(recoveryRoomsEntity.getId());

			bedFacilitiesEntities = postOperativeDetailsEntity.getBedFacilities();
			Set<UUID> bedFacilitiesEntityIds = new HashSet<>();
			for (BedFacilityEntity entity : bedFacilitiesEntities) {
				try {
					bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				bedFacilitiesEntityIds.add(bedFacilityRepository.save(entity).getId());
			}
			postOperativeDetailsEntity.setBedFacilitiesIds(bedFacilitiesEntityIds);


			postOperativeDetailsEntity = postOperativeDetailsService.create(postOperativeDetailsEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(postOperativeDetailsEntity.getOperatingTheaterMedicalExaminationRecord());
			postOperativeDetailsEntity.setOperatingTheaterMedicalExaminationRecordId(null);
			postOperativeDetailsEntity.unsetOperatingTheaterMedicalExaminationRecord();

			Assertions.assertNotNull(postOperativeDetailsEntity.getPostOperativeICD10());
			postOperativeDetailsEntity.setPostOperativeICD10Id(null);
			postOperativeDetailsEntity.unsetPostOperativeICD10();

			Assertions.assertNotNull(postOperativeDetailsEntity.getPostOperativeICD9CM());
			postOperativeDetailsEntity.setPostOperativeICD9CMId(null);
			postOperativeDetailsEntity.unsetPostOperativeICD9CM();

			Assertions.assertNotNull(postOperativeDetailsEntity.getRecoveryRooms());
			postOperativeDetailsEntity.setRecoveryRoomsId(null);
			postOperativeDetailsEntity.unsetRecoveryRooms();

			Assertions.assertTrue(postOperativeDetailsEntity.getBedFacilities().size() > 0);
			postOperativeDetailsEntity.setBedFacilitiesIds(new HashSet<UUID>());
			postOperativeDetailsEntity.unsetBedFacilities();


			updatedPostOperativeDetailsEntity = postOperativeDetailsService.updateOldData(postOperativeDetailsEntity);

			Assertions.assertNull(updatedPostOperativeDetailsEntity.getOperatingTheaterMedicalExaminationRecord());

			Assertions.assertNull(updatedPostOperativeDetailsEntity.getPostOperativeICD10());

			Assertions.assertNull(updatedPostOperativeDetailsEntity.getPostOperativeICD9CM());

			Assertions.assertNull(updatedPostOperativeDetailsEntity.getRecoveryRooms());

			Assertions.assertEquals(0, updatedPostOperativeDetailsEntity.getBedFacilities().size());

		});
	}

	@Test
	public void updateOldDataWithPostOperativeDetailsEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PostOperativeDetailsEntity postOperativeDetailsEntity;
			PostOperativeDetailsEntity updatedPostOperativeDetailsEntity;

			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;

			DiagnosesAndProceduresEntity postOperativeICD10Entity;

			DiagnosesAndProceduresEntity postOperativeICD9CMEntity;

			RoomFacilityEntity recoveryRoomsEntity;

			Set<BedFacilityEntity> bedFacilitiesEntities;
			Set<UUID> bedFacilitiesEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				postOperativeDetailsEntity = postOperativeDetailsFactory.getObject(true, false);
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
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeDetailsEntity.getOperatingTheaterMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Operating Theater Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordRepository.findById(operatingTheaterMedicalExaminationRecordRepository.save(postOperativeDetailsEntity.getOperatingTheaterMedicalExaminationRecord()).getId()).get();
			postOperativeDetailsEntity.unsetOperatingTheaterMedicalExaminationRecord();
			postOperativeDetailsEntity.setOperatingTheaterMedicalExaminationRecordId(operatingTheaterMedicalExaminationRecordEntity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeDetailsEntity.getPostOperativeICD10(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Post Operative ICD 10 relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			postOperativeICD10Entity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(postOperativeDetailsEntity.getPostOperativeICD10()).getId()).get();
			postOperativeDetailsEntity.unsetPostOperativeICD10();
			postOperativeDetailsEntity.setPostOperativeICD10Id(postOperativeICD10Entity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeDetailsEntity.getPostOperativeICD9CM(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Post Operative ICD 9 CM relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			postOperativeICD9CMEntity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(postOperativeDetailsEntity.getPostOperativeICD9CM()).getId()).get();
			postOperativeDetailsEntity.unsetPostOperativeICD9CM();
			postOperativeDetailsEntity.setPostOperativeICD9CMId(postOperativeICD9CMEntity.getId());

			try {
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeDetailsEntity.getRecoveryRooms(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Recovery Rooms relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			recoveryRoomsEntity = roomFacilityRepository.findById(roomFacilityRepository.save(postOperativeDetailsEntity.getRecoveryRooms()).getId()).get();
			postOperativeDetailsEntity.unsetRecoveryRooms();
			postOperativeDetailsEntity.setRecoveryRoomsId(recoveryRoomsEntity.getId());

			bedFacilitiesEntities = new HashSet<>();
			bedFacilitiesEntityIds = new HashSet<>();
			for (BedFacilityEntity entity : postOperativeDetailsEntity.getBedFacilities()) {
				try {
					bedFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Bed Facilities relation for this test: " + e.getCause());
					return;
				}
				UUID id = bedFacilityRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				bedFacilitiesEntities.add(bedFacilityRepository.findById(id).get());
				bedFacilitiesEntityIds.add(id);
			}
			postOperativeDetailsEntity.unsetBedFacilities();
			postOperativeDetailsEntity.setBedFacilitiesIds(bedFacilitiesEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPostOperativeDetailsEntity = postOperativeDetailsService.updateOldData(postOperativeDetailsEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			operatingTheaterMedicalExaminationRecordEntity.unsetPostOperativeDetails(false);
			updatedPostOperativeDetailsEntity.getOperatingTheaterMedicalExaminationRecord().unsetPostOperativeDetails(false);
			Assertions.assertEquals(operatingTheaterMedicalExaminationRecordEntity, updatedPostOperativeDetailsEntity.getOperatingTheaterMedicalExaminationRecord());

			postOperativeICD10Entity.unsetPostOperativeICD10(false);
			updatedPostOperativeDetailsEntity.getPostOperativeICD10().unsetPostOperativeICD10(false);
			Assertions.assertEquals(postOperativeICD10Entity, updatedPostOperativeDetailsEntity.getPostOperativeICD10());

			postOperativeICD9CMEntity.unsetPostOperativeICD9CM(false);
			updatedPostOperativeDetailsEntity.getPostOperativeICD9CM().unsetPostOperativeICD9CM(false);
			Assertions.assertEquals(postOperativeICD9CMEntity, updatedPostOperativeDetailsEntity.getPostOperativeICD9CM());

			recoveryRoomsEntity.unsetRecoveryRooms(false);
			updatedPostOperativeDetailsEntity.getRecoveryRooms().unsetRecoveryRooms(false);
			Assertions.assertEquals(recoveryRoomsEntity, updatedPostOperativeDetailsEntity.getRecoveryRooms());

			Assertions.assertEquals(bedFacilitiesEntities.size(), updatedPostOperativeDetailsEntity.getBedFacilities().size());

		});
	}

	@Test
	public void whenCreatePostOperativeDetailsEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PostOperativeDetailsEntity postOperativeDetailsEntity;
			Optional<PostOperativeDetailsEntity> fetchedPostOperativeDetailsEntity;

			try {
				postOperativeDetailsEntity = postOperativeDetailsFactory.getObject(false, false);
				postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeDetailsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			postOperativeDetailsEntity = postOperativeDetailsService.create(postOperativeDetailsEntity);

			fetchedPostOperativeDetailsEntity = postOperativeDetailsService.findById(postOperativeDetailsEntity.getId());

			Assertions.assertTrue(fetchedPostOperativeDetailsEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPostOperativeDetailsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(postOperativeDetailsEntity, fetchedPostOperativeDetailsEntity.get());
		});
	}

	@Test
	public void whenUpdatePostOperativeDetailsEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PostOperativeDetailsEntity postOperativeDetailsEntity;
			PostOperativeDetailsEntity updatedPostOperativeDetailsEntity;
			Optional<PostOperativeDetailsEntity> fetchedPostOperativeDetailsEntity;

			try {
				postOperativeDetailsEntity = postOperativeDetailsFactory.getObject(false, false);
				postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeDetailsEntity, true, true, false);
				updatedPostOperativeDetailsEntity = postOperativeDetailsFactory.getObject(false, false);
				postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPostOperativeDetailsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			postOperativeDetailsEntity = postOperativeDetailsService.create(postOperativeDetailsEntity);

			updatedPostOperativeDetailsEntity.setId(postOperativeDetailsEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPostOperativeDetailsEntity.setCreated(postOperativeDetailsEntity.getCreated());

			updatedPostOperativeDetailsEntity = postOperativeDetailsService.update(updatedPostOperativeDetailsEntity);

			fetchedPostOperativeDetailsEntity = postOperativeDetailsService.findById(postOperativeDetailsEntity.getId());

			Assertions.assertTrue(fetchedPostOperativeDetailsEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePostOperativeDetailsEntity_ThenEntityIsCreated
			fetchedPostOperativeDetailsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPostOperativeDetailsEntity, fetchedPostOperativeDetailsEntity.get());
		});
	}

	@Test
	public void whenDeletePostOperativeDetailsEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PostOperativeDetailsEntity postOperativeDetailsEntity;
			Optional<PostOperativeDetailsEntity> fetchedPostOperativeDetailsEntity;

			try {
				postOperativeDetailsEntity = postOperativeDetailsFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(postOperativeDetailsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			postOperativeDetailsEntity = postOperativeDetailsService.create(postOperativeDetailsEntity);

			postOperativeDetailsService.deleteById(postOperativeDetailsEntity.getId());
			fetchedPostOperativeDetailsEntity = postOperativeDetailsService.findById(postOperativeDetailsEntity.getId());

			Assertions.assertTrue(fetchedPostOperativeDetailsEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
