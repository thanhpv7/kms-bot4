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
import kmsweb.entities.PatientConsentEntity;
import kmsweb.repositories.PatientConsentRepository;
import kmsweb.utils.PatientConsentFactory;
import kmsweb.utils.DatabasePopulators.PatientConsentDatabasePopulator;
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.repositories.PatientGeneralInfoRepository;
import kmsweb.utils.PatientGeneralInfoFactory;
import kmsweb.utils.DatabasePopulators.PatientGeneralInfoDatabasePopulator;
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
public class PatientConsentServiceIntegrationTest {

	@Autowired
	private PatientConsentRepository patientConsentRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PatientConsentService patientConsentService;

	private final PatientConsentFactory patientConsentFactory = new PatientConsentFactory();

	@Autowired
	private PatientConsentDatabasePopulator patientConsentDatabasePopulator;

	@Autowired
	private PatientGeneralInfoRepository patientGeneralInfoRepository;

	@Autowired
	private PatientGeneralInfoDatabasePopulator patientGeneralInfoDatabasePopulator;

	private final PatientGeneralInfoFactory patientGeneralInfoFactory = new PatientGeneralInfoFactory();

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
		patientConsentService = new PatientConsentService(
			patientGeneralInfoRepository,
			staffRepository,
			validator,
			auditRepository,
			patientConsentRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPatientConsentEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PatientConsentEntity patientConsentEntity = patientConsentFactory.getObject(false, false);

		PatientConsentEntity updatedEntity = patientConsentService.updateOldData(patientConsentEntity);
		Assertions.assertEquals(patientConsentEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewPatientConsentEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		PatientConsentEntity patientConsentEntity = patientConsentFactory.getObject(false, false);

		patientConsentEntity.setReadAndSignSatusehat(null);
		Assertions.assertNull(patientConsentEntity.getReadAndSignSatusehat());


		PatientConsentEntity updatedEntity = patientConsentService.updateOldData(patientConsentEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getReadAndSignSatusehat());
		Assertions.assertFalse(updatedEntity.getReadAndSignSatusehat());

	}

	@Test
	public void updateOldDataWithExistingPatientConsentEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PatientConsentEntity patientConsentEntity;
			PatientConsentEntity entityWithUpdatedValues;

			try {
				patientConsentEntity = patientConsentFactory.getObject(false, false);
				patientConsentDatabasePopulator.populateRelatedEntitiesInDatabase(patientConsentEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = patientConsentFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientConsentEntity = patientConsentService.create(patientConsentEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(patientConsentEntity.getId());

			PatientConsentEntity updatedEntity = patientConsentService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPatientConsentEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PatientConsentEntity patientConsentEntity = patientConsentFactory.getObject(false, false);
		patientConsentEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			patientConsentService.updateOldData(patientConsentEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPatientConsentEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientConsentEntity patientConsentEntity;
			PatientConsentEntity updatedPatientConsentEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;

			StaffEntity staffEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientConsentEntity = patientConsentFactory.getObject(true, false);
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
			patientGeneralInfoEntity = patientConsentEntity.getPatientGeneralInfo();
			try {
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientGeneralInfoEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientGeneralInfoEntity = patientGeneralInfoRepository.save(patientGeneralInfoEntity);
			patientConsentEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());

			staffEntity = patientConsentEntity.getStaff();
			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(staffEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			staffEntity = staffRepository.save(staffEntity);
			patientConsentEntity.setStaffId(staffEntity.getId());


			patientConsentEntity = patientConsentService.create(patientConsentEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(patientConsentEntity.getPatientGeneralInfo());
			patientConsentEntity.setPatientGeneralInfoId(null);
			patientConsentEntity.unsetPatientGeneralInfo();

			Assertions.assertNotNull(patientConsentEntity.getStaff());
			patientConsentEntity.setStaffId(null);
			patientConsentEntity.unsetStaff();


			updatedPatientConsentEntity = patientConsentService.updateOldData(patientConsentEntity);

			Assertions.assertNull(updatedPatientConsentEntity.getPatientGeneralInfo());

			Assertions.assertNull(updatedPatientConsentEntity.getStaff());

		});
	}

	@Test
	public void updateOldDataWithPatientConsentEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientConsentEntity patientConsentEntity;
			PatientConsentEntity updatedPatientConsentEntity;

			PatientGeneralInfoEntity patientGeneralInfoEntity;

			StaffEntity staffEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientConsentEntity = patientConsentFactory.getObject(true, false);
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
				patientGeneralInfoDatabasePopulator.populateRelatedEntitiesInDatabase(patientConsentEntity.getPatientGeneralInfo(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient General Info relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientGeneralInfoEntity = patientGeneralInfoRepository.findById(patientGeneralInfoRepository.save(patientConsentEntity.getPatientGeneralInfo()).getId()).get();
			patientConsentEntity.unsetPatientGeneralInfo();
			patientConsentEntity.setPatientGeneralInfoId(patientGeneralInfoEntity.getId());

			try {
				staffDatabasePopulator.populateRelatedEntitiesInDatabase(patientConsentEntity.getStaff(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Staff relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			staffEntity = staffRepository.findById(staffRepository.save(patientConsentEntity.getStaff()).getId()).get();
			patientConsentEntity.unsetStaff();
			patientConsentEntity.setStaffId(staffEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPatientConsentEntity = patientConsentService.updateOldData(patientConsentEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			patientGeneralInfoEntity.unsetPatientConsents(false);
			updatedPatientConsentEntity.getPatientGeneralInfo().unsetPatientConsents(false);
			Assertions.assertEquals(patientGeneralInfoEntity, updatedPatientConsentEntity.getPatientGeneralInfo());

			staffEntity.unsetPatientConsents(false);
			updatedPatientConsentEntity.getStaff().unsetPatientConsents(false);
			Assertions.assertEquals(staffEntity, updatedPatientConsentEntity.getStaff());

		});
	}

	@Test
	public void whenCreatePatientConsentEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientConsentEntity patientConsentEntity;
			Optional<PatientConsentEntity> fetchedPatientConsentEntity;

			try {
				patientConsentEntity = patientConsentFactory.getObject(false, false);
				patientConsentDatabasePopulator.populateRelatedEntitiesInDatabase(patientConsentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientConsentEntity = patientConsentService.create(patientConsentEntity);

			fetchedPatientConsentEntity = patientConsentService.findById(patientConsentEntity.getId());

			Assertions.assertTrue(fetchedPatientConsentEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPatientConsentEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(patientConsentEntity, fetchedPatientConsentEntity.get());
		});
	}

	@Test
	public void whenUpdatePatientConsentEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientConsentEntity patientConsentEntity;
			PatientConsentEntity updatedPatientConsentEntity;
			Optional<PatientConsentEntity> fetchedPatientConsentEntity;

			try {
				patientConsentEntity = patientConsentFactory.getObject(false, false);
				patientConsentDatabasePopulator.populateRelatedEntitiesInDatabase(patientConsentEntity, true, true, false);
				updatedPatientConsentEntity = patientConsentFactory.getObject(false, false);
				patientConsentDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPatientConsentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientConsentEntity = patientConsentService.create(patientConsentEntity);

			updatedPatientConsentEntity.setId(patientConsentEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPatientConsentEntity.setCreated(patientConsentEntity.getCreated());

			updatedPatientConsentEntity = patientConsentService.update(updatedPatientConsentEntity);

			fetchedPatientConsentEntity = patientConsentService.findById(patientConsentEntity.getId());

			Assertions.assertTrue(fetchedPatientConsentEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePatientConsentEntity_ThenEntityIsCreated
			fetchedPatientConsentEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPatientConsentEntity, fetchedPatientConsentEntity.get());
		});
	}

	@Test
	public void whenDeletePatientConsentEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PatientConsentEntity patientConsentEntity;
			Optional<PatientConsentEntity> fetchedPatientConsentEntity;

			try {
				patientConsentEntity = patientConsentFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				patientConsentDatabasePopulator.populateRelatedEntitiesInDatabase(patientConsentEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientConsentEntity = patientConsentService.create(patientConsentEntity);

			patientConsentService.deleteById(patientConsentEntity.getId());
			fetchedPatientConsentEntity = patientConsentService.findById(patientConsentEntity.getId());

			Assertions.assertTrue(fetchedPatientConsentEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
