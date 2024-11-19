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
import kmsweb.entities.BpjsPcareRegistrationsEntity;
import kmsweb.repositories.BpjsPcareRegistrationsRepository;
import kmsweb.utils.BpjsPcareRegistrationsFactory;
import kmsweb.utils.DatabasePopulators.BpjsPcareRegistrationsDatabasePopulator;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;
import kmsweb.utils.PatientVisitFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
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
public class BpjsPcareRegistrationsServiceIntegrationTest {

	@Autowired
	private BpjsPcareRegistrationsRepository bpjsPcareRegistrationsRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsPcareRegistrationsService bpjsPcareRegistrationsService;

	private final BpjsPcareRegistrationsFactory bpjsPcareRegistrationsFactory = new BpjsPcareRegistrationsFactory();

	@Autowired
	private BpjsPcareRegistrationsDatabasePopulator bpjsPcareRegistrationsDatabasePopulator;

	@Autowired
	private PatientVisitRepository patientVisitRepository;

	@Autowired
	private PatientVisitDatabasePopulator patientVisitDatabasePopulator;

	private final PatientVisitFactory patientVisitFactory = new PatientVisitFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		bpjsPcareRegistrationsService = new BpjsPcareRegistrationsService(
			patientVisitRepository,
			registrationRepository,
			validator,
			auditRepository,
			bpjsPcareRegistrationsRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsPcareRegistrationsEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsFactory.getObject(false, false);

		BpjsPcareRegistrationsEntity updatedEntity = bpjsPcareRegistrationsService.updateOldData(bpjsPcareRegistrationsEntity);
		Assertions.assertEquals(bpjsPcareRegistrationsEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsPcareRegistrationsEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity;
			BpjsPcareRegistrationsEntity entityWithUpdatedValues;

			try {
				bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsFactory.getObject(false, false);
				bpjsPcareRegistrationsDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareRegistrationsEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsPcareRegistrationsFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsService.create(bpjsPcareRegistrationsEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsPcareRegistrationsEntity.getId());

			BpjsPcareRegistrationsEntity updatedEntity = bpjsPcareRegistrationsService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsPcareRegistrationsEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsFactory.getObject(false, false);
		bpjsPcareRegistrationsEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsPcareRegistrationsService.updateOldData(bpjsPcareRegistrationsEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsPcareRegistrationsEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity;
			BpjsPcareRegistrationsEntity updatedBpjsPcareRegistrationsEntity;

			PatientVisitEntity patientVisitEntity;

			RegistrationEntity registrationEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsFactory.getObject(true, false);
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
			patientVisitEntity = bpjsPcareRegistrationsEntity.getPatientVisit();
			try {
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientVisitEntity = patientVisitRepository.save(patientVisitEntity);
			bpjsPcareRegistrationsEntity.setPatientVisitId(patientVisitEntity.getId());

			registrationEntity = bpjsPcareRegistrationsEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			bpjsPcareRegistrationsEntity.setRegistrationId(registrationEntity.getId());


			bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsService.create(bpjsPcareRegistrationsEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsPcareRegistrationsEntity.getPatientVisit());
			bpjsPcareRegistrationsEntity.setPatientVisitId(null);
			bpjsPcareRegistrationsEntity.unsetPatientVisit();

			Assertions.assertNotNull(bpjsPcareRegistrationsEntity.getRegistration());
			bpjsPcareRegistrationsEntity.setRegistrationId(null);
			bpjsPcareRegistrationsEntity.unsetRegistration();


			updatedBpjsPcareRegistrationsEntity = bpjsPcareRegistrationsService.updateOldData(bpjsPcareRegistrationsEntity);

			Assertions.assertNull(updatedBpjsPcareRegistrationsEntity.getPatientVisit());

			Assertions.assertNull(updatedBpjsPcareRegistrationsEntity.getRegistration());

		});
	}

	@Test
	public void updateOldDataWithBpjsPcareRegistrationsEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity;
			BpjsPcareRegistrationsEntity updatedBpjsPcareRegistrationsEntity;

			PatientVisitEntity patientVisitEntity;

			RegistrationEntity registrationEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsFactory.getObject(true, false);
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
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareRegistrationsEntity.getPatientVisit(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Visit relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientVisitEntity = patientVisitRepository.findById(patientVisitRepository.save(bpjsPcareRegistrationsEntity.getPatientVisit()).getId()).get();
			bpjsPcareRegistrationsEntity.unsetPatientVisit();
			bpjsPcareRegistrationsEntity.setPatientVisitId(patientVisitEntity.getId());

			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareRegistrationsEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(bpjsPcareRegistrationsEntity.getRegistration()).getId()).get();
			bpjsPcareRegistrationsEntity.unsetRegistration();
			bpjsPcareRegistrationsEntity.setRegistrationId(registrationEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsPcareRegistrationsEntity = bpjsPcareRegistrationsService.updateOldData(bpjsPcareRegistrationsEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			patientVisitEntity.unsetBpjsPcareRegistrations(false);
			updatedBpjsPcareRegistrationsEntity.getPatientVisit().unsetBpjsPcareRegistrations(false);
			Assertions.assertEquals(patientVisitEntity, updatedBpjsPcareRegistrationsEntity.getPatientVisit());

			registrationEntity.unsetBpjsPcareRegistrations(false);
			updatedBpjsPcareRegistrationsEntity.getRegistration().unsetBpjsPcareRegistrations(false);
			Assertions.assertEquals(registrationEntity, updatedBpjsPcareRegistrationsEntity.getRegistration());

		});
	}

	@Test
	public void whenCreateBpjsPcareRegistrationsEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity;
			Optional<BpjsPcareRegistrationsEntity> fetchedBpjsPcareRegistrationsEntity;

			try {
				bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsFactory.getObject(false, false);
				bpjsPcareRegistrationsDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareRegistrationsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsService.create(bpjsPcareRegistrationsEntity);

			fetchedBpjsPcareRegistrationsEntity = bpjsPcareRegistrationsService.findById(bpjsPcareRegistrationsEntity.getId());

			Assertions.assertTrue(fetchedBpjsPcareRegistrationsEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsPcareRegistrationsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsPcareRegistrationsEntity, fetchedBpjsPcareRegistrationsEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsPcareRegistrationsEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity;
			BpjsPcareRegistrationsEntity updatedBpjsPcareRegistrationsEntity;
			Optional<BpjsPcareRegistrationsEntity> fetchedBpjsPcareRegistrationsEntity;

			try {
				bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsFactory.getObject(false, false);
				bpjsPcareRegistrationsDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareRegistrationsEntity, true, true, false);
				updatedBpjsPcareRegistrationsEntity = bpjsPcareRegistrationsFactory.getObject(false, false);
				bpjsPcareRegistrationsDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsPcareRegistrationsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsService.create(bpjsPcareRegistrationsEntity);

			updatedBpjsPcareRegistrationsEntity.setId(bpjsPcareRegistrationsEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsPcareRegistrationsEntity.setCreated(bpjsPcareRegistrationsEntity.getCreated());

			updatedBpjsPcareRegistrationsEntity = bpjsPcareRegistrationsService.update(updatedBpjsPcareRegistrationsEntity);

			fetchedBpjsPcareRegistrationsEntity = bpjsPcareRegistrationsService.findById(bpjsPcareRegistrationsEntity.getId());

			Assertions.assertTrue(fetchedBpjsPcareRegistrationsEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsPcareRegistrationsEntity_ThenEntityIsCreated
			fetchedBpjsPcareRegistrationsEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsPcareRegistrationsEntity, fetchedBpjsPcareRegistrationsEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsPcareRegistrationsEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcareRegistrationsEntity bpjsPcareRegistrationsEntity;
			Optional<BpjsPcareRegistrationsEntity> fetchedBpjsPcareRegistrationsEntity;

			try {
				bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsPcareRegistrationsDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcareRegistrationsEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcareRegistrationsEntity = bpjsPcareRegistrationsService.create(bpjsPcareRegistrationsEntity);

			bpjsPcareRegistrationsService.deleteById(bpjsPcareRegistrationsEntity.getId());
			fetchedBpjsPcareRegistrationsEntity = bpjsPcareRegistrationsService.findById(bpjsPcareRegistrationsEntity.getId());

			Assertions.assertTrue(fetchedBpjsPcareRegistrationsEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
