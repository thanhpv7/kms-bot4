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
import kmsweb.entities.DoctorScheduleEntity;
import kmsweb.repositories.DoctorScheduleRepository;
import kmsweb.utils.DoctorScheduleFactory;
import kmsweb.utils.DatabasePopulators.DoctorScheduleDatabasePopulator;
import kmsweb.entities.ServiceEntity;
import kmsweb.repositories.ServiceRepository;
import kmsweb.utils.ServiceFactory;
import kmsweb.utils.DatabasePopulators.ServiceDatabasePopulator;
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
public class DoctorScheduleServiceIntegrationTest {

	@Autowired
	private DoctorScheduleRepository doctorScheduleRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private DoctorScheduleService doctorScheduleService;

	private final DoctorScheduleFactory doctorScheduleFactory = new DoctorScheduleFactory();

	@Autowired
	private DoctorScheduleDatabasePopulator doctorScheduleDatabasePopulator;

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ServiceDatabasePopulator serviceDatabasePopulator;

	private final ServiceFactory serviceFactory = new ServiceFactory();

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
		doctorScheduleService = new DoctorScheduleService(
			serviceRepository,
			staffRepository,
			validator,
			auditRepository,
			doctorScheduleRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewDoctorScheduleEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		DoctorScheduleEntity doctorScheduleEntity = doctorScheduleFactory.getObject(false, false);

		DoctorScheduleEntity updatedEntity = doctorScheduleService.updateOldData(doctorScheduleEntity);
		Assertions.assertEquals(doctorScheduleEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewDoctorScheduleEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		DoctorScheduleEntity doctorScheduleEntity = doctorScheduleFactory.getObject(false, false);

		doctorScheduleEntity.setMonday(null);
		Assertions.assertNull(doctorScheduleEntity.getMonday());

		doctorScheduleEntity.setTuesday(null);
		Assertions.assertNull(doctorScheduleEntity.getTuesday());

		doctorScheduleEntity.setWednesday(null);
		Assertions.assertNull(doctorScheduleEntity.getWednesday());

		doctorScheduleEntity.setThursday(null);
		Assertions.assertNull(doctorScheduleEntity.getThursday());

		doctorScheduleEntity.setFriday(null);
		Assertions.assertNull(doctorScheduleEntity.getFriday());

		doctorScheduleEntity.setSaturday(null);
		Assertions.assertNull(doctorScheduleEntity.getSaturday());

		doctorScheduleEntity.setSunday(null);
		Assertions.assertNull(doctorScheduleEntity.getSunday());

		doctorScheduleEntity.setRepetition(null);
		Assertions.assertNull(doctorScheduleEntity.getRepetition());


		DoctorScheduleEntity updatedEntity = doctorScheduleService.updateOldData(doctorScheduleEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getMonday());
		Assertions.assertFalse(updatedEntity.getMonday());

		Assertions.assertNotNull(updatedEntity.getTuesday());
		Assertions.assertFalse(updatedEntity.getTuesday());

		Assertions.assertNotNull(updatedEntity.getWednesday());
		Assertions.assertFalse(updatedEntity.getWednesday());

		Assertions.assertNotNull(updatedEntity.getThursday());
		Assertions.assertFalse(updatedEntity.getThursday());

		Assertions.assertNotNull(updatedEntity.getFriday());
		Assertions.assertFalse(updatedEntity.getFriday());

		Assertions.assertNotNull(updatedEntity.getSaturday());
		Assertions.assertFalse(updatedEntity.getSaturday());

		Assertions.assertNotNull(updatedEntity.getSunday());
		Assertions.assertFalse(updatedEntity.getSunday());

		Assertions.assertNotNull(updatedEntity.getRepetition());
		Assertions.assertFalse(updatedEntity.getRepetition());

	}

	@Test
	public void updateOldDataWithExistingDoctorScheduleEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			DoctorScheduleEntity doctorScheduleEntity;
			DoctorScheduleEntity entityWithUpdatedValues;

			try {
				doctorScheduleEntity = doctorScheduleFactory.getObject(false, false);
				doctorScheduleDatabasePopulator.populateRelatedEntitiesInDatabase(doctorScheduleEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = doctorScheduleFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			doctorScheduleEntity = doctorScheduleService.create(doctorScheduleEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(doctorScheduleEntity.getId());

			DoctorScheduleEntity updatedEntity = doctorScheduleService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithDoctorScheduleEntityWithNonExistentId_ShouldThrowException() throws Exception {
		DoctorScheduleEntity doctorScheduleEntity = doctorScheduleFactory.getObject(false, false);
		doctorScheduleEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			doctorScheduleService.updateOldData(doctorScheduleEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingDoctorScheduleEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DoctorScheduleEntity doctorScheduleEntity;
			DoctorScheduleEntity updatedDoctorScheduleEntity;

			ServiceEntity serviceEntity;

			StaffEntity staffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				doctorScheduleEntity = doctorScheduleFactory.getObject(true, false);
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
			serviceEntity = doctorScheduleEntity.getService();
			try {
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(serviceEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			serviceEntity = serviceRepository.save(serviceEntity);
			doctorScheduleEntity.setServiceId(serviceEntity.getId());

			staffEntity = doctorScheduleEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			doctorScheduleEntity.setStaffId(staffEntity.getId());


			doctorScheduleEntity = doctorScheduleService.create(doctorScheduleEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(doctorScheduleEntity.getService());
			doctorScheduleEntity.setServiceId(null);
			doctorScheduleEntity.unsetService();

			Assertions.assertNotNull(doctorScheduleEntity.getStaff());
			doctorScheduleEntity.setStaffId(null);
			doctorScheduleEntity.unsetStaff();


			updatedDoctorScheduleEntity = doctorScheduleService.updateOldData(doctorScheduleEntity);

			Assertions.assertNull(updatedDoctorScheduleEntity.getService());

			Assertions.assertNull(updatedDoctorScheduleEntity.getStaff());

		});
	}

	@Test
	public void updateOldDataWithDoctorScheduleEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DoctorScheduleEntity doctorScheduleEntity;
			DoctorScheduleEntity updatedDoctorScheduleEntity;

			ServiceEntity serviceEntity;

			StaffEntity staffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				doctorScheduleEntity = doctorScheduleFactory.getObject(true, false);
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
				serviceDatabasePopulator.populateRelatedEntitiesInDatabase(doctorScheduleEntity.getService(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Service relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			serviceEntity = serviceRepository.findById(serviceRepository.save(doctorScheduleEntity.getService()).getId()).get();
			doctorScheduleEntity.unsetService();
			doctorScheduleEntity.setServiceId(serviceEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(doctorScheduleEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(doctorScheduleEntity.getStaff()).getId()).get();
			doctorScheduleEntity.unsetStaff();
			doctorScheduleEntity.setStaffId(staffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedDoctorScheduleEntity = doctorScheduleService.updateOldData(doctorScheduleEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			serviceEntity.unsetDoctorSchedules(false);
			updatedDoctorScheduleEntity.getService().unsetDoctorSchedules(false);
			Assertions.assertEquals(serviceEntity, updatedDoctorScheduleEntity.getService());

			staffEntity.unsetDoctorSchedules(false);
			updatedDoctorScheduleEntity.getStaff().unsetDoctorSchedules(false);
			Assertions.assertEquals(staffEntity, updatedDoctorScheduleEntity.getStaff());

		});
	}

	@Test
	public void whenCreateDoctorScheduleEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			DoctorScheduleEntity doctorScheduleEntity;
			Optional<DoctorScheduleEntity> fetchedDoctorScheduleEntity;

			try {
				doctorScheduleEntity = doctorScheduleFactory.getObject(false, false);
				doctorScheduleDatabasePopulator.populateRelatedEntitiesInDatabase(doctorScheduleEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			doctorScheduleEntity = doctorScheduleService.create(doctorScheduleEntity);

			fetchedDoctorScheduleEntity = doctorScheduleService.findById(doctorScheduleEntity.getId());

			Assertions.assertTrue(fetchedDoctorScheduleEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedDoctorScheduleEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(doctorScheduleEntity, fetchedDoctorScheduleEntity.get());
		});
	}

	@Test
	public void whenUpdateDoctorScheduleEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			DoctorScheduleEntity doctorScheduleEntity;
			DoctorScheduleEntity updatedDoctorScheduleEntity;
			Optional<DoctorScheduleEntity> fetchedDoctorScheduleEntity;

			try {
				doctorScheduleEntity = doctorScheduleFactory.getObject(false, false);
				doctorScheduleDatabasePopulator.populateRelatedEntitiesInDatabase(doctorScheduleEntity, true, true, false);
				updatedDoctorScheduleEntity = doctorScheduleFactory.getObject(false, false);
				doctorScheduleDatabasePopulator.populateRelatedEntitiesInDatabase(updatedDoctorScheduleEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			doctorScheduleEntity = doctorScheduleService.create(doctorScheduleEntity);

			updatedDoctorScheduleEntity.setId(doctorScheduleEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedDoctorScheduleEntity.setCreated(doctorScheduleEntity.getCreated());

			updatedDoctorScheduleEntity = doctorScheduleService.update(updatedDoctorScheduleEntity);

			fetchedDoctorScheduleEntity = doctorScheduleService.findById(doctorScheduleEntity.getId());

			Assertions.assertTrue(fetchedDoctorScheduleEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateDoctorScheduleEntity_ThenEntityIsCreated
			fetchedDoctorScheduleEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedDoctorScheduleEntity, fetchedDoctorScheduleEntity.get());
		});
	}

	@Test
	public void whenDeleteDoctorScheduleEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			DoctorScheduleEntity doctorScheduleEntity;
			Optional<DoctorScheduleEntity> fetchedDoctorScheduleEntity;

			try {
				doctorScheduleEntity = doctorScheduleFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				doctorScheduleDatabasePopulator.populateRelatedEntitiesInDatabase(doctorScheduleEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			doctorScheduleEntity = doctorScheduleService.create(doctorScheduleEntity);

			doctorScheduleService.deleteById(doctorScheduleEntity.getId());
			fetchedDoctorScheduleEntity = doctorScheduleService.findById(doctorScheduleEntity.getId());

			Assertions.assertTrue(fetchedDoctorScheduleEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
