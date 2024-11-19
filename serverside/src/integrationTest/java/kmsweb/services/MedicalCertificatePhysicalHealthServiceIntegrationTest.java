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
import kmsweb.entities.MedicalCertificatePhysicalHealthEntity;
import kmsweb.repositories.MedicalCertificatePhysicalHealthRepository;
import kmsweb.utils.MedicalCertificatePhysicalHealthFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificatePhysicalHealthDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
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
public class MedicalCertificatePhysicalHealthServiceIntegrationTest {

	@Autowired
	private MedicalCertificatePhysicalHealthRepository medicalCertificatePhysicalHealthRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MedicalCertificatePhysicalHealthService medicalCertificatePhysicalHealthService;

	private final MedicalCertificatePhysicalHealthFactory medicalCertificatePhysicalHealthFactory = new MedicalCertificatePhysicalHealthFactory();

	@Autowired
	private MedicalCertificatePhysicalHealthDatabasePopulator medicalCertificatePhysicalHealthDatabasePopulator;

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

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
		medicalCertificatePhysicalHealthService = new MedicalCertificatePhysicalHealthService(
			registrationRepository,
			staffRepository,
			validator,
			auditRepository,
			medicalCertificatePhysicalHealthRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMedicalCertificatePhysicalHealthEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthFactory.getObject(false, false);

		MedicalCertificatePhysicalHealthEntity updatedEntity = medicalCertificatePhysicalHealthService.updateOldData(medicalCertificatePhysicalHealthEntity);
		Assertions.assertEquals(medicalCertificatePhysicalHealthEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewMedicalCertificatePhysicalHealthEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthFactory.getObject(false, false);

		medicalCertificatePhysicalHealthEntity.setExaminationResult(null);
		Assertions.assertNull(medicalCertificatePhysicalHealthEntity.getExaminationResult());


		MedicalCertificatePhysicalHealthEntity updatedEntity = medicalCertificatePhysicalHealthService.updateOldData(medicalCertificatePhysicalHealthEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getExaminationResult());
		Assertions.assertFalse(updatedEntity.getExaminationResult());

	}

	@Test
	public void updateOldDataWithExistingMedicalCertificatePhysicalHealthEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity;
			MedicalCertificatePhysicalHealthEntity entityWithUpdatedValues;

			try {
				medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthFactory.getObject(false, false);
				medicalCertificatePhysicalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificatePhysicalHealthEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = medicalCertificatePhysicalHealthFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthService.create(medicalCertificatePhysicalHealthEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(medicalCertificatePhysicalHealthEntity.getId());

			MedicalCertificatePhysicalHealthEntity updatedEntity = medicalCertificatePhysicalHealthService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMedicalCertificatePhysicalHealthEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthFactory.getObject(false, false);
		medicalCertificatePhysicalHealthEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			medicalCertificatePhysicalHealthService.updateOldData(medicalCertificatePhysicalHealthEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMedicalCertificatePhysicalHealthEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity;
			MedicalCertificatePhysicalHealthEntity updatedMedicalCertificatePhysicalHealthEntity;

			RegistrationEntity registrationEntity;

			StaffEntity medicalStaffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthFactory.getObject(true, false);
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
			registrationEntity = medicalCertificatePhysicalHealthEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			medicalCertificatePhysicalHealthEntity.setRegistrationId(registrationEntity.getId());

			medicalStaffEntity = medicalCertificatePhysicalHealthEntity.getMedicalStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalStaffEntity = staffRepository.save(medicalStaffEntity);
			medicalCertificatePhysicalHealthEntity.setMedicalStaffId(medicalStaffEntity.getId());


			medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthService.create(medicalCertificatePhysicalHealthEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(medicalCertificatePhysicalHealthEntity.getRegistration());
			medicalCertificatePhysicalHealthEntity.setRegistrationId(null);
			medicalCertificatePhysicalHealthEntity.unsetRegistration();

			Assertions.assertNotNull(medicalCertificatePhysicalHealthEntity.getMedicalStaff());
			medicalCertificatePhysicalHealthEntity.setMedicalStaffId(null);
			medicalCertificatePhysicalHealthEntity.unsetMedicalStaff();


			updatedMedicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthService.updateOldData(medicalCertificatePhysicalHealthEntity);

			Assertions.assertNull(updatedMedicalCertificatePhysicalHealthEntity.getRegistration());

			Assertions.assertNull(updatedMedicalCertificatePhysicalHealthEntity.getMedicalStaff());

		});
	}

	@Test
	public void updateOldDataWithMedicalCertificatePhysicalHealthEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity;
			MedicalCertificatePhysicalHealthEntity updatedMedicalCertificatePhysicalHealthEntity;

			RegistrationEntity registrationEntity;

			StaffEntity medicalStaffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthFactory.getObject(true, false);
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
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificatePhysicalHealthEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(medicalCertificatePhysicalHealthEntity.getRegistration()).getId()).get();
			medicalCertificatePhysicalHealthEntity.unsetRegistration();
			medicalCertificatePhysicalHealthEntity.setRegistrationId(registrationEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificatePhysicalHealthEntity.getMedicalStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalStaffEntity = staffRepository.findById(staffRepository.save(medicalCertificatePhysicalHealthEntity.getMedicalStaff()).getId()).get();
			medicalCertificatePhysicalHealthEntity.unsetMedicalStaff();
			medicalCertificatePhysicalHealthEntity.setMedicalStaffId(medicalStaffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMedicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthService.updateOldData(medicalCertificatePhysicalHealthEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			registrationEntity.unsetMedicalCertificatePhysicalHealth(false);
			updatedMedicalCertificatePhysicalHealthEntity.getRegistration().unsetMedicalCertificatePhysicalHealth(false);
			Assertions.assertEquals(registrationEntity, updatedMedicalCertificatePhysicalHealthEntity.getRegistration());

			medicalStaffEntity.unsetMedicalStaffOfPhysicalHealths(false);
			updatedMedicalCertificatePhysicalHealthEntity.getMedicalStaff().unsetMedicalStaffOfPhysicalHealths(false);
			Assertions.assertEquals(medicalStaffEntity, updatedMedicalCertificatePhysicalHealthEntity.getMedicalStaff());

		});
	}

	@Test
	public void whenCreateMedicalCertificatePhysicalHealthEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity;
			Optional<MedicalCertificatePhysicalHealthEntity> fetchedMedicalCertificatePhysicalHealthEntity;

			try {
				medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthFactory.getObject(false, false);
				medicalCertificatePhysicalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificatePhysicalHealthEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthService.create(medicalCertificatePhysicalHealthEntity);

			fetchedMedicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthService.findById(medicalCertificatePhysicalHealthEntity.getId());

			Assertions.assertTrue(fetchedMedicalCertificatePhysicalHealthEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMedicalCertificatePhysicalHealthEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(medicalCertificatePhysicalHealthEntity, fetchedMedicalCertificatePhysicalHealthEntity.get());
		});
	}

	@Test
	public void whenUpdateMedicalCertificatePhysicalHealthEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity;
			MedicalCertificatePhysicalHealthEntity updatedMedicalCertificatePhysicalHealthEntity;
			Optional<MedicalCertificatePhysicalHealthEntity> fetchedMedicalCertificatePhysicalHealthEntity;

			try {
				medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthFactory.getObject(false, false);
				medicalCertificatePhysicalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificatePhysicalHealthEntity, true, true, false);
				updatedMedicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthFactory.getObject(false, false);
				medicalCertificatePhysicalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMedicalCertificatePhysicalHealthEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthService.create(medicalCertificatePhysicalHealthEntity);

			updatedMedicalCertificatePhysicalHealthEntity.setId(medicalCertificatePhysicalHealthEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMedicalCertificatePhysicalHealthEntity.setCreated(medicalCertificatePhysicalHealthEntity.getCreated());

			updatedMedicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthService.update(updatedMedicalCertificatePhysicalHealthEntity);

			fetchedMedicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthService.findById(medicalCertificatePhysicalHealthEntity.getId());

			Assertions.assertTrue(fetchedMedicalCertificatePhysicalHealthEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMedicalCertificatePhysicalHealthEntity_ThenEntityIsCreated
			fetchedMedicalCertificatePhysicalHealthEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMedicalCertificatePhysicalHealthEntity, fetchedMedicalCertificatePhysicalHealthEntity.get());
		});
	}

	@Test
	public void whenDeleteMedicalCertificatePhysicalHealthEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealthEntity;
			Optional<MedicalCertificatePhysicalHealthEntity> fetchedMedicalCertificatePhysicalHealthEntity;

			try {
				medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				medicalCertificatePhysicalHealthDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificatePhysicalHealthEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthService.create(medicalCertificatePhysicalHealthEntity);

			medicalCertificatePhysicalHealthService.deleteById(medicalCertificatePhysicalHealthEntity.getId());
			fetchedMedicalCertificatePhysicalHealthEntity = medicalCertificatePhysicalHealthService.findById(medicalCertificatePhysicalHealthEntity.getId());

			Assertions.assertTrue(fetchedMedicalCertificatePhysicalHealthEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
