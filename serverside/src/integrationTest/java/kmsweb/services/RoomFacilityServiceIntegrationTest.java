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
import kmsweb.entities.RoomFacilityEntity;
import kmsweb.repositories.RoomFacilityRepository;
import kmsweb.utils.RoomFacilityFactory;
import kmsweb.utils.DatabasePopulators.RoomFacilityDatabasePopulator;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.utils.BedFacilityFactory;
import kmsweb.utils.DatabasePopulators.BedFacilityDatabasePopulator;
import kmsweb.entities.IntraoperativeRecordsEntity;
import kmsweb.repositories.IntraoperativeRecordsRepository;
import kmsweb.utils.IntraoperativeRecordsFactory;
import kmsweb.utils.DatabasePopulators.IntraoperativeRecordsDatabasePopulator;
import kmsweb.entities.PostOperativeDetailsEntity;
import kmsweb.repositories.PostOperativeDetailsRepository;
import kmsweb.utils.PostOperativeDetailsFactory;
import kmsweb.utils.DatabasePopulators.PostOperativeDetailsDatabasePopulator;
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.repositories.PreoperativeRecordsRepository;
import kmsweb.utils.PreoperativeRecordsFactory;
import kmsweb.utils.DatabasePopulators.PreoperativeRecordsDatabasePopulator;
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
public class RoomFacilityServiceIntegrationTest {

	@Autowired
	private RoomFacilityRepository roomFacilityRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private RoomFacilityService roomFacilityService;

	private final RoomFacilityFactory roomFacilityFactory = new RoomFacilityFactory();

	@Autowired
	private RoomFacilityDatabasePopulator roomFacilityDatabasePopulator;

	@Autowired
	private BedFacilityRepository bedFacilityRepository;

	@Autowired
	private BedFacilityDatabasePopulator bedFacilityDatabasePopulator;

	private final BedFacilityFactory bedFacilityFactory = new BedFacilityFactory();

	@Autowired
	private IntraoperativeRecordsRepository intraoperativeRecordsRepository;

	@Autowired
	private IntraoperativeRecordsDatabasePopulator intraoperativeRecordsDatabasePopulator;

	private final IntraoperativeRecordsFactory intraoperativeRecordsFactory = new IntraoperativeRecordsFactory();

	@Autowired
	private PostOperativeDetailsRepository postOperativeDetailsRepository;

	@Autowired
	private PostOperativeDetailsDatabasePopulator postOperativeDetailsDatabasePopulator;

	private final PostOperativeDetailsFactory postOperativeDetailsFactory = new PostOperativeDetailsFactory();

	@Autowired
	private PreoperativeRecordsRepository preoperativeRecordsRepository;

	@Autowired
	private PreoperativeRecordsDatabasePopulator preoperativeRecordsDatabasePopulator;

	private final PreoperativeRecordsFactory preoperativeRecordsFactory = new PreoperativeRecordsFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		roomFacilityService = new RoomFacilityService(
			bedFacilityRepository,
			intraoperativeRecordsRepository,
			postOperativeDetailsRepository,
			preoperativeRecordsRepository,
			validator,
			auditRepository,
			roomFacilityRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewRoomFacilityEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		RoomFacilityEntity roomFacilityEntity = roomFacilityFactory.getObject(false, false);

		RoomFacilityEntity updatedEntity = roomFacilityService.updateOldData(roomFacilityEntity);
		Assertions.assertEquals(roomFacilityEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingRoomFacilityEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			RoomFacilityEntity roomFacilityEntity;
			RoomFacilityEntity entityWithUpdatedValues;

			try {
				roomFacilityEntity = roomFacilityFactory.getObject(false, false);
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(roomFacilityEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = roomFacilityFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			roomFacilityEntity = roomFacilityService.create(roomFacilityEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(roomFacilityEntity.getId());

			RoomFacilityEntity updatedEntity = roomFacilityService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithRoomFacilityEntityWithNonExistentId_ShouldThrowException() throws Exception {
		RoomFacilityEntity roomFacilityEntity = roomFacilityFactory.getObject(false, false);
		roomFacilityEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			roomFacilityService.updateOldData(roomFacilityEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingRoomFacilityEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RoomFacilityEntity roomFacilityEntity;
			RoomFacilityEntity updatedRoomFacilityEntity;

			Set<BedFacilityEntity> bedFacilitiesEntities;

			Set<IntraoperativeRecordsEntity> operatingRoomEntities;

			Set<PreoperativeRecordsEntity> preoperativeRoomsEntities;

			Set<PostOperativeDetailsEntity> recoveryRoomsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				roomFacilityEntity = roomFacilityFactory.getObject(true, false);
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
			bedFacilitiesEntities = roomFacilityEntity.getBedFacilities();
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
			roomFacilityEntity.setBedFacilitiesIds(bedFacilitiesEntityIds);

			operatingRoomEntities = roomFacilityEntity.getOperatingRoom();
			Set<UUID> operatingRoomEntityIds = new HashSet<>();
			for (IntraoperativeRecordsEntity entity : operatingRoomEntities) {
				try {
					intraoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				operatingRoomEntityIds.add(intraoperativeRecordsRepository.save(entity).getId());
			}
			roomFacilityEntity.setOperatingRoomIds(operatingRoomEntityIds);

			preoperativeRoomsEntities = roomFacilityEntity.getPreoperativeRooms();
			Set<UUID> preoperativeRoomsEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : preoperativeRoomsEntities) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				preoperativeRoomsEntityIds.add(preoperativeRecordsRepository.save(entity).getId());
			}
			roomFacilityEntity.setPreoperativeRoomsIds(preoperativeRoomsEntityIds);

			recoveryRoomsEntities = roomFacilityEntity.getRecoveryRooms();
			Set<UUID> recoveryRoomsEntityIds = new HashSet<>();
			for (PostOperativeDetailsEntity entity : recoveryRoomsEntities) {
				try {
					postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				recoveryRoomsEntityIds.add(postOperativeDetailsRepository.save(entity).getId());
			}
			roomFacilityEntity.setRecoveryRoomsIds(recoveryRoomsEntityIds);


			roomFacilityEntity = roomFacilityService.create(roomFacilityEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertTrue(roomFacilityEntity.getBedFacilities().size() > 0);
			roomFacilityEntity.setBedFacilitiesIds(new HashSet<UUID>());
			roomFacilityEntity.unsetBedFacilities();

			Assertions.assertTrue(roomFacilityEntity.getOperatingRoom().size() > 0);
			roomFacilityEntity.setOperatingRoomIds(new HashSet<UUID>());
			roomFacilityEntity.unsetOperatingRoom();

			Assertions.assertTrue(roomFacilityEntity.getPreoperativeRooms().size() > 0);
			roomFacilityEntity.setPreoperativeRoomsIds(new HashSet<UUID>());
			roomFacilityEntity.unsetPreoperativeRooms();

			Assertions.assertTrue(roomFacilityEntity.getRecoveryRooms().size() > 0);
			roomFacilityEntity.setRecoveryRoomsIds(new HashSet<UUID>());
			roomFacilityEntity.unsetRecoveryRooms();


			updatedRoomFacilityEntity = roomFacilityService.updateOldData(roomFacilityEntity);

			Assertions.assertEquals(0, updatedRoomFacilityEntity.getBedFacilities().size());

			Assertions.assertEquals(0, updatedRoomFacilityEntity.getOperatingRoom().size());

			Assertions.assertEquals(0, updatedRoomFacilityEntity.getPreoperativeRooms().size());

			Assertions.assertEquals(0, updatedRoomFacilityEntity.getRecoveryRooms().size());

		});
	}

	@Test
	public void updateOldDataWithRoomFacilityEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			RoomFacilityEntity roomFacilityEntity;
			RoomFacilityEntity updatedRoomFacilityEntity;

			Set<BedFacilityEntity> bedFacilitiesEntities;
			Set<UUID> bedFacilitiesEntityIds;

			Set<IntraoperativeRecordsEntity> operatingRoomEntities;
			Set<UUID> operatingRoomEntityIds;

			Set<PreoperativeRecordsEntity> preoperativeRoomsEntities;
			Set<UUID> preoperativeRoomsEntityIds;

			Set<PostOperativeDetailsEntity> recoveryRoomsEntities;
			Set<UUID> recoveryRoomsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				roomFacilityEntity = roomFacilityFactory.getObject(true, false);
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
			bedFacilitiesEntities = new HashSet<>();
			bedFacilitiesEntityIds = new HashSet<>();
			for (BedFacilityEntity entity : roomFacilityEntity.getBedFacilities()) {
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
			roomFacilityEntity.unsetBedFacilities();
			roomFacilityEntity.setBedFacilitiesIds(bedFacilitiesEntityIds);

			operatingRoomEntities = new HashSet<>();
			operatingRoomEntityIds = new HashSet<>();
			for (IntraoperativeRecordsEntity entity : roomFacilityEntity.getOperatingRoom()) {
				try {
					intraoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Operating Room relation for this test: " + e.getCause());
					return;
				}
				UUID id = intraoperativeRecordsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				operatingRoomEntities.add(intraoperativeRecordsRepository.findById(id).get());
				operatingRoomEntityIds.add(id);
			}
			roomFacilityEntity.unsetOperatingRoom();
			roomFacilityEntity.setOperatingRoomIds(operatingRoomEntityIds);

			preoperativeRoomsEntities = new HashSet<>();
			preoperativeRoomsEntityIds = new HashSet<>();
			for (PreoperativeRecordsEntity entity : roomFacilityEntity.getPreoperativeRooms()) {
				try {
					preoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Preoperative Rooms relation for this test: " + e.getCause());
					return;
				}
				UUID id = preoperativeRecordsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				preoperativeRoomsEntities.add(preoperativeRecordsRepository.findById(id).get());
				preoperativeRoomsEntityIds.add(id);
			}
			roomFacilityEntity.unsetPreoperativeRooms();
			roomFacilityEntity.setPreoperativeRoomsIds(preoperativeRoomsEntityIds);

			recoveryRoomsEntities = new HashSet<>();
			recoveryRoomsEntityIds = new HashSet<>();
			for (PostOperativeDetailsEntity entity : roomFacilityEntity.getRecoveryRooms()) {
				try {
					postOperativeDetailsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Recovery Rooms relation for this test: " + e.getCause());
					return;
				}
				UUID id = postOperativeDetailsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				recoveryRoomsEntities.add(postOperativeDetailsRepository.findById(id).get());
				recoveryRoomsEntityIds.add(id);
			}
			roomFacilityEntity.unsetRecoveryRooms();
			roomFacilityEntity.setRecoveryRoomsIds(recoveryRoomsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedRoomFacilityEntity = roomFacilityService.updateOldData(roomFacilityEntity);

			Assertions.assertEquals(bedFacilitiesEntities.size(), updatedRoomFacilityEntity.getBedFacilities().size());

			Assertions.assertEquals(operatingRoomEntities.size(), updatedRoomFacilityEntity.getOperatingRoom().size());

			Assertions.assertEquals(preoperativeRoomsEntities.size(), updatedRoomFacilityEntity.getPreoperativeRooms().size());

			Assertions.assertEquals(recoveryRoomsEntities.size(), updatedRoomFacilityEntity.getRecoveryRooms().size());

		});
	}

	@Test
	public void whenCreateRoomFacilityEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			RoomFacilityEntity roomFacilityEntity;
			Optional<RoomFacilityEntity> fetchedRoomFacilityEntity;

			try {
				roomFacilityEntity = roomFacilityFactory.getObject(false, false);
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(roomFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			roomFacilityEntity = roomFacilityService.create(roomFacilityEntity);

			fetchedRoomFacilityEntity = roomFacilityService.findById(roomFacilityEntity.getId());

			Assertions.assertTrue(fetchedRoomFacilityEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedRoomFacilityEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(roomFacilityEntity, fetchedRoomFacilityEntity.get());
		});
	}

	@Test
	public void whenUpdateRoomFacilityEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			RoomFacilityEntity roomFacilityEntity;
			RoomFacilityEntity updatedRoomFacilityEntity;
			Optional<RoomFacilityEntity> fetchedRoomFacilityEntity;

			try {
				roomFacilityEntity = roomFacilityFactory.getObject(false, false);
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(roomFacilityEntity, true, true, false);
				updatedRoomFacilityEntity = roomFacilityFactory.getObject(false, false);
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(updatedRoomFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			roomFacilityEntity = roomFacilityService.create(roomFacilityEntity);

			updatedRoomFacilityEntity.setId(roomFacilityEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedRoomFacilityEntity.setCreated(roomFacilityEntity.getCreated());

			updatedRoomFacilityEntity = roomFacilityService.update(updatedRoomFacilityEntity);

			fetchedRoomFacilityEntity = roomFacilityService.findById(roomFacilityEntity.getId());

			Assertions.assertTrue(fetchedRoomFacilityEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateRoomFacilityEntity_ThenEntityIsCreated
			fetchedRoomFacilityEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedRoomFacilityEntity, fetchedRoomFacilityEntity.get());
		});
	}

	@Test
	public void whenDeleteRoomFacilityEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			RoomFacilityEntity roomFacilityEntity;
			Optional<RoomFacilityEntity> fetchedRoomFacilityEntity;

			try {
				roomFacilityEntity = roomFacilityFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(roomFacilityEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			roomFacilityEntity = roomFacilityService.create(roomFacilityEntity);

			roomFacilityService.deleteById(roomFacilityEntity.getId());
			fetchedRoomFacilityEntity = roomFacilityService.findById(roomFacilityEntity.getId());

			Assertions.assertTrue(fetchedRoomFacilityEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
