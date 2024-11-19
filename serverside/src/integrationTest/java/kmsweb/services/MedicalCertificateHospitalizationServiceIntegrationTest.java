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
import kmsweb.entities.MedicalCertificateHospitalizationEntity;
import kmsweb.repositories.MedicalCertificateHospitalizationRepository;
import kmsweb.utils.MedicalCertificateHospitalizationFactory;
import kmsweb.utils.DatabasePopulators.MedicalCertificateHospitalizationDatabasePopulator;
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
public class MedicalCertificateHospitalizationServiceIntegrationTest {

	@Autowired
	private MedicalCertificateHospitalizationRepository medicalCertificateHospitalizationRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MedicalCertificateHospitalizationService medicalCertificateHospitalizationService;

	private final MedicalCertificateHospitalizationFactory medicalCertificateHospitalizationFactory = new MedicalCertificateHospitalizationFactory();

	@Autowired
	private MedicalCertificateHospitalizationDatabasePopulator medicalCertificateHospitalizationDatabasePopulator;

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
		medicalCertificateHospitalizationService = new MedicalCertificateHospitalizationService(
			registrationRepository,
			staffRepository,
			validator,
			auditRepository,
			medicalCertificateHospitalizationRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMedicalCertificateHospitalizationEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationFactory.getObject(false, false);

		MedicalCertificateHospitalizationEntity updatedEntity = medicalCertificateHospitalizationService.updateOldData(medicalCertificateHospitalizationEntity);
		Assertions.assertEquals(medicalCertificateHospitalizationEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingMedicalCertificateHospitalizationEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntity;
			MedicalCertificateHospitalizationEntity entityWithUpdatedValues;

			try {
				medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationFactory.getObject(false, false);
				medicalCertificateHospitalizationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateHospitalizationEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = medicalCertificateHospitalizationFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationService.create(medicalCertificateHospitalizationEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(medicalCertificateHospitalizationEntity.getId());

			MedicalCertificateHospitalizationEntity updatedEntity = medicalCertificateHospitalizationService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMedicalCertificateHospitalizationEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationFactory.getObject(false, false);
		medicalCertificateHospitalizationEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			medicalCertificateHospitalizationService.updateOldData(medicalCertificateHospitalizationEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMedicalCertificateHospitalizationEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntity;
			MedicalCertificateHospitalizationEntity updatedMedicalCertificateHospitalizationEntity;

			RegistrationEntity registrationEntity;

			StaffEntity medicalStaffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationFactory.getObject(true, false);
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
			registrationEntity = medicalCertificateHospitalizationEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			medicalCertificateHospitalizationEntity.setRegistrationId(registrationEntity.getId());

			medicalStaffEntity = medicalCertificateHospitalizationEntity.getMedicalStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalStaffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalStaffEntity = staffRepository.save(medicalStaffEntity);
			medicalCertificateHospitalizationEntity.setMedicalStaffId(medicalStaffEntity.getId());


			medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationService.create(medicalCertificateHospitalizationEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(medicalCertificateHospitalizationEntity.getRegistration());
			medicalCertificateHospitalizationEntity.setRegistrationId(null);
			medicalCertificateHospitalizationEntity.unsetRegistration();

			Assertions.assertNotNull(medicalCertificateHospitalizationEntity.getMedicalStaff());
			medicalCertificateHospitalizationEntity.setMedicalStaffId(null);
			medicalCertificateHospitalizationEntity.unsetMedicalStaff();


			updatedMedicalCertificateHospitalizationEntity = medicalCertificateHospitalizationService.updateOldData(medicalCertificateHospitalizationEntity);

			Assertions.assertNull(updatedMedicalCertificateHospitalizationEntity.getRegistration());

			Assertions.assertNull(updatedMedicalCertificateHospitalizationEntity.getMedicalStaff());

		});
	}

	@Test
	public void updateOldDataWithMedicalCertificateHospitalizationEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntity;
			MedicalCertificateHospitalizationEntity updatedMedicalCertificateHospitalizationEntity;

			RegistrationEntity registrationEntity;

			StaffEntity medicalStaffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationFactory.getObject(true, false);
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
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateHospitalizationEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(medicalCertificateHospitalizationEntity.getRegistration()).getId()).get();
			medicalCertificateHospitalizationEntity.unsetRegistration();
			medicalCertificateHospitalizationEntity.setRegistrationId(registrationEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateHospitalizationEntity.getMedicalStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalStaffEntity = staffRepository.findById(staffRepository.save(medicalCertificateHospitalizationEntity.getMedicalStaff()).getId()).get();
			medicalCertificateHospitalizationEntity.unsetMedicalStaff();
			medicalCertificateHospitalizationEntity.setMedicalStaffId(medicalStaffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMedicalCertificateHospitalizationEntity = medicalCertificateHospitalizationService.updateOldData(medicalCertificateHospitalizationEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			registrationEntity.unsetMedicalCertificateHospitalization(false);
			updatedMedicalCertificateHospitalizationEntity.getRegistration().unsetMedicalCertificateHospitalization(false);
			Assertions.assertEquals(registrationEntity, updatedMedicalCertificateHospitalizationEntity.getRegistration());

			medicalStaffEntity.unsetMedicalCertificateHospitalizations(false);
			updatedMedicalCertificateHospitalizationEntity.getMedicalStaff().unsetMedicalCertificateHospitalizations(false);
			Assertions.assertEquals(medicalStaffEntity, updatedMedicalCertificateHospitalizationEntity.getMedicalStaff());

		});
	}

	@Test
	public void whenCreateMedicalCertificateHospitalizationEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntity;
			Optional<MedicalCertificateHospitalizationEntity> fetchedMedicalCertificateHospitalizationEntity;

			try {
				medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationFactory.getObject(false, false);
				medicalCertificateHospitalizationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateHospitalizationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationService.create(medicalCertificateHospitalizationEntity);

			fetchedMedicalCertificateHospitalizationEntity = medicalCertificateHospitalizationService.findById(medicalCertificateHospitalizationEntity.getId());

			Assertions.assertTrue(fetchedMedicalCertificateHospitalizationEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMedicalCertificateHospitalizationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(medicalCertificateHospitalizationEntity, fetchedMedicalCertificateHospitalizationEntity.get());
		});
	}

	@Test
	public void whenUpdateMedicalCertificateHospitalizationEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntity;
			MedicalCertificateHospitalizationEntity updatedMedicalCertificateHospitalizationEntity;
			Optional<MedicalCertificateHospitalizationEntity> fetchedMedicalCertificateHospitalizationEntity;

			try {
				medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationFactory.getObject(false, false);
				medicalCertificateHospitalizationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateHospitalizationEntity, true, true, false);
				updatedMedicalCertificateHospitalizationEntity = medicalCertificateHospitalizationFactory.getObject(false, false);
				medicalCertificateHospitalizationDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMedicalCertificateHospitalizationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationService.create(medicalCertificateHospitalizationEntity);

			updatedMedicalCertificateHospitalizationEntity.setId(medicalCertificateHospitalizationEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMedicalCertificateHospitalizationEntity.setCreated(medicalCertificateHospitalizationEntity.getCreated());

			updatedMedicalCertificateHospitalizationEntity = medicalCertificateHospitalizationService.update(updatedMedicalCertificateHospitalizationEntity);

			fetchedMedicalCertificateHospitalizationEntity = medicalCertificateHospitalizationService.findById(medicalCertificateHospitalizationEntity.getId());

			Assertions.assertTrue(fetchedMedicalCertificateHospitalizationEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMedicalCertificateHospitalizationEntity_ThenEntityIsCreated
			fetchedMedicalCertificateHospitalizationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMedicalCertificateHospitalizationEntity, fetchedMedicalCertificateHospitalizationEntity.get());
		});
	}

	@Test
	public void whenDeleteMedicalCertificateHospitalizationEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalCertificateHospitalizationEntity medicalCertificateHospitalizationEntity;
			Optional<MedicalCertificateHospitalizationEntity> fetchedMedicalCertificateHospitalizationEntity;

			try {
				medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				medicalCertificateHospitalizationDatabasePopulator.populateRelatedEntitiesInDatabase(medicalCertificateHospitalizationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalCertificateHospitalizationEntity = medicalCertificateHospitalizationService.create(medicalCertificateHospitalizationEntity);

			medicalCertificateHospitalizationService.deleteById(medicalCertificateHospitalizationEntity.getId());
			fetchedMedicalCertificateHospitalizationEntity = medicalCertificateHospitalizationService.findById(medicalCertificateHospitalizationEntity.getId());

			Assertions.assertTrue(fetchedMedicalCertificateHospitalizationEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
