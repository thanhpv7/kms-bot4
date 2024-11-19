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
import kmsweb.entities.IntraoperativeRecordsEntity;
import kmsweb.repositories.IntraoperativeRecordsRepository;
import kmsweb.utils.IntraoperativeRecordsFactory;
import kmsweb.utils.DatabasePopulators.IntraoperativeRecordsDatabasePopulator;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.repositories.BedFacilityRepository;
import kmsweb.utils.BedFacilityFactory;
import kmsweb.utils.DatabasePopulators.BedFacilityDatabasePopulator;
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
public class IntraoperativeRecordsServiceIntegrationTest {

	@Autowired
	private IntraoperativeRecordsRepository intraoperativeRecordsRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private IntraoperativeRecordsService intraoperativeRecordsService;

	private final IntraoperativeRecordsFactory intraoperativeRecordsFactory = new IntraoperativeRecordsFactory();

	@Autowired
	private IntraoperativeRecordsDatabasePopulator intraoperativeRecordsDatabasePopulator;

	@Autowired
	private BedFacilityRepository bedFacilityRepository;

	@Autowired
	private BedFacilityDatabasePopulator bedFacilityDatabasePopulator;

	private final BedFacilityFactory bedFacilityFactory = new BedFacilityFactory();

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
		intraoperativeRecordsService = new IntraoperativeRecordsService(
			bedFacilityRepository,
			operatingTheaterMedicalExaminationRecordRepository,
			roomFacilityRepository,
			validator,
			auditRepository,
			intraoperativeRecordsRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewIntraoperativeRecordsEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		IntraoperativeRecordsEntity intraoperativeRecordsEntity = intraoperativeRecordsFactory.getObject(false, false);

		IntraoperativeRecordsEntity updatedEntity = intraoperativeRecordsService.updateOldData(intraoperativeRecordsEntity);
		Assertions.assertEquals(intraoperativeRecordsEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingIntraoperativeRecordsEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			IntraoperativeRecordsEntity intraoperativeRecordsEntity;
			IntraoperativeRecordsEntity entityWithUpdatedValues;

			try {
				intraoperativeRecordsEntity = intraoperativeRecordsFactory.getObject(false, false);
				intraoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(intraoperativeRecordsEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = intraoperativeRecordsFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			intraoperativeRecordsEntity = intraoperativeRecordsService.create(intraoperativeRecordsEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(intraoperativeRecordsEntity.getId());

			IntraoperativeRecordsEntity updatedEntity = intraoperativeRecordsService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithIntraoperativeRecordsEntityWithNonExistentId_ShouldThrowException() throws Exception {
		IntraoperativeRecordsEntity intraoperativeRecordsEntity = intraoperativeRecordsFactory.getObject(false, false);
		intraoperativeRecordsEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			intraoperativeRecordsService.updateOldData(intraoperativeRecordsEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingIntraoperativeRecordsEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			IntraoperativeRecordsEntity intraoperativeRecordsEntity;
			IntraoperativeRecordsEntity updatedIntraoperativeRecordsEntity;

			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;

			RoomFacilityEntity operatingRoomEntity;

			Set<BedFacilityEntity> bedFacilitiesEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				intraoperativeRecordsEntity = intraoperativeRecordsFactory.getObject(true, false);
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
			operatingTheaterMedicalExaminationRecordEntity = intraoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord();
			try {
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(operatingTheaterMedicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordRepository.save(operatingTheaterMedicalExaminationRecordEntity);
			intraoperativeRecordsEntity.setOperatingTheaterMedicalExaminationRecordId(operatingTheaterMedicalExaminationRecordEntity.getId());

			operatingRoomEntity = intraoperativeRecordsEntity.getOperatingRoom();
			try {
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(operatingRoomEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			operatingRoomEntity = roomFacilityRepository.save(operatingRoomEntity);
			intraoperativeRecordsEntity.setOperatingRoomId(operatingRoomEntity.getId());

			bedFacilitiesEntities = intraoperativeRecordsEntity.getBedFacilities();
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
			intraoperativeRecordsEntity.setBedFacilitiesIds(bedFacilitiesEntityIds);


			intraoperativeRecordsEntity = intraoperativeRecordsService.create(intraoperativeRecordsEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(intraoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord());
			intraoperativeRecordsEntity.setOperatingTheaterMedicalExaminationRecordId(null);
			intraoperativeRecordsEntity.unsetOperatingTheaterMedicalExaminationRecord();

			Assertions.assertNotNull(intraoperativeRecordsEntity.getOperatingRoom());
			intraoperativeRecordsEntity.setOperatingRoomId(null);
			intraoperativeRecordsEntity.unsetOperatingRoom();

			Assertions.assertTrue(intraoperativeRecordsEntity.getBedFacilities().size() > 0);
			intraoperativeRecordsEntity.setBedFacilitiesIds(new HashSet<UUID>());
			intraoperativeRecordsEntity.unsetBedFacilities();


			updatedIntraoperativeRecordsEntity = intraoperativeRecordsService.updateOldData(intraoperativeRecordsEntity);

			Assertions.assertNull(updatedIntraoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord());

			Assertions.assertNull(updatedIntraoperativeRecordsEntity.getOperatingRoom());

			Assertions.assertEquals(0, updatedIntraoperativeRecordsEntity.getBedFacilities().size());

		});
	}

	@Test
	public void updateOldDataWithIntraoperativeRecordsEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			IntraoperativeRecordsEntity intraoperativeRecordsEntity;
			IntraoperativeRecordsEntity updatedIntraoperativeRecordsEntity;

			OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecordEntity;

			RoomFacilityEntity operatingRoomEntity;

			Set<BedFacilityEntity> bedFacilitiesEntities;
			Set<UUID> bedFacilitiesEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				intraoperativeRecordsEntity = intraoperativeRecordsFactory.getObject(true, false);
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
				operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(intraoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Operating Theater Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			operatingTheaterMedicalExaminationRecordEntity = operatingTheaterMedicalExaminationRecordRepository.findById(operatingTheaterMedicalExaminationRecordRepository.save(intraoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord()).getId()).get();
			intraoperativeRecordsEntity.unsetOperatingTheaterMedicalExaminationRecord();
			intraoperativeRecordsEntity.setOperatingTheaterMedicalExaminationRecordId(operatingTheaterMedicalExaminationRecordEntity.getId());

			try {
				roomFacilityDatabasePopulator.populateRelatedEntitiesInDatabase(intraoperativeRecordsEntity.getOperatingRoom(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Operating Room relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			operatingRoomEntity = roomFacilityRepository.findById(roomFacilityRepository.save(intraoperativeRecordsEntity.getOperatingRoom()).getId()).get();
			intraoperativeRecordsEntity.unsetOperatingRoom();
			intraoperativeRecordsEntity.setOperatingRoomId(operatingRoomEntity.getId());

			bedFacilitiesEntities = new HashSet<>();
			bedFacilitiesEntityIds = new HashSet<>();
			for (BedFacilityEntity entity : intraoperativeRecordsEntity.getBedFacilities()) {
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
			intraoperativeRecordsEntity.unsetBedFacilities();
			intraoperativeRecordsEntity.setBedFacilitiesIds(bedFacilitiesEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedIntraoperativeRecordsEntity = intraoperativeRecordsService.updateOldData(intraoperativeRecordsEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			operatingTheaterMedicalExaminationRecordEntity.unsetIntraoperativeRecords(false);
			updatedIntraoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord().unsetIntraoperativeRecords(false);
			Assertions.assertEquals(operatingTheaterMedicalExaminationRecordEntity, updatedIntraoperativeRecordsEntity.getOperatingTheaterMedicalExaminationRecord());

			operatingRoomEntity.unsetOperatingRoom(false);
			updatedIntraoperativeRecordsEntity.getOperatingRoom().unsetOperatingRoom(false);
			Assertions.assertEquals(operatingRoomEntity, updatedIntraoperativeRecordsEntity.getOperatingRoom());

			Assertions.assertEquals(bedFacilitiesEntities.size(), updatedIntraoperativeRecordsEntity.getBedFacilities().size());

		});
	}

	@Test
	public void whenCreateIntraoperativeRecordsEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			IntraoperativeRecordsEntity intraoperativeRecordsEntity;
			Optional<IntraoperativeRecordsEntity> fetchedIntraoperativeRecordsEntity;

			try {
				intraoperativeRecordsEntity = intraoperativeRecordsFactory.getObject(false, false);
				intraoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(intraoperativeRecordsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			intraoperativeRecordsEntity = intraoperativeRecordsService.create(intraoperativeRecordsEntity);

			fetchedIntraoperativeRecordsEntity = intraoperativeRecordsService.findById(intraoperativeRecordsEntity.getId());

			Assertions.assertTrue(fetchedIntraoperativeRecordsEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedIntraoperativeRecordsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(intraoperativeRecordsEntity, fetchedIntraoperativeRecordsEntity.get());
		});
	}

	@Test
	public void whenUpdateIntraoperativeRecordsEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			IntraoperativeRecordsEntity intraoperativeRecordsEntity;
			IntraoperativeRecordsEntity updatedIntraoperativeRecordsEntity;
			Optional<IntraoperativeRecordsEntity> fetchedIntraoperativeRecordsEntity;

			try {
				intraoperativeRecordsEntity = intraoperativeRecordsFactory.getObject(false, false);
				intraoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(intraoperativeRecordsEntity, true, true, false);
				updatedIntraoperativeRecordsEntity = intraoperativeRecordsFactory.getObject(false, false);
				intraoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(updatedIntraoperativeRecordsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			intraoperativeRecordsEntity = intraoperativeRecordsService.create(intraoperativeRecordsEntity);

			updatedIntraoperativeRecordsEntity.setId(intraoperativeRecordsEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedIntraoperativeRecordsEntity.setCreated(intraoperativeRecordsEntity.getCreated());

			updatedIntraoperativeRecordsEntity = intraoperativeRecordsService.update(updatedIntraoperativeRecordsEntity);

			fetchedIntraoperativeRecordsEntity = intraoperativeRecordsService.findById(intraoperativeRecordsEntity.getId());

			Assertions.assertTrue(fetchedIntraoperativeRecordsEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateIntraoperativeRecordsEntity_ThenEntityIsCreated
			fetchedIntraoperativeRecordsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedIntraoperativeRecordsEntity, fetchedIntraoperativeRecordsEntity.get());
		});
	}

	@Test
	public void whenDeleteIntraoperativeRecordsEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			IntraoperativeRecordsEntity intraoperativeRecordsEntity;
			Optional<IntraoperativeRecordsEntity> fetchedIntraoperativeRecordsEntity;

			try {
				intraoperativeRecordsEntity = intraoperativeRecordsFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				intraoperativeRecordsDatabasePopulator.populateRelatedEntitiesInDatabase(intraoperativeRecordsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			intraoperativeRecordsEntity = intraoperativeRecordsService.create(intraoperativeRecordsEntity);

			intraoperativeRecordsService.deleteById(intraoperativeRecordsEntity.getId());
			fetchedIntraoperativeRecordsEntity = intraoperativeRecordsService.findById(intraoperativeRecordsEntity.getId());

			Assertions.assertTrue(fetchedIntraoperativeRecordsEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
